package cn.com.yusys.yusp.uaa.security.extra;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import cn.com.yusys.yusp.dycrm.userAcct.service.UserAccountInfoService;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.util.BCRSAUtil;
import cn.com.yusys.yusp.uaa.domain.AuthUser;
import cn.com.yusys.yusp.uaa.security.auth.AbstractUaaWebAuthVerify;
import cn.com.yusys.yusp.uaa.security.credentialstrategy.CredentialStrategy;
import cn.com.yusys.yusp.uaa.security.credentialstrategy.PswWrongStrategy;
import cn.com.yusys.yusp.uaa.service.CredentialStrategyService;
import cn.com.yusys.yusp.uaa.service.PasswordValidService;

/**
 * 本地UAA认证
 *
 * @author Hanlw
 * @since  1.0.0
 * 
 * 此类生效对应数据表：admin_sm_auth_info.bean_name
 */
@Service("ermWebLocationAuthVerify")
public class ErmWebLocationAuthVerify extends AbstractUaaWebAuthVerify {
	private final Logger logger = LoggerFactory.getLogger(ErmWebLocationAuthVerify.class);
	
    @Autowired
	private CredentialStrategyService credentialStrategyService;
    
    @Autowired
    private PasswordValidService passwordValidService;

    @Autowired
    private PasswordEncoder passwordEncoder;

	@Autowired
	private UserAccountInfoService userAccountInfoService;
	@Override
	public Boolean logoutAuthVerify(String username) {
		return true;
	}

	@Override
	public Boolean loginAuthVerify(UserDetails userDetails, String loginPassword, Object salt) {
		boolean isValid = false;
		if (passwordValidService == null) {
			isValid = passwordEncoder.matches(loginPassword, userDetails.getPassword());
		} else {
			isValid = passwordValidService.isPasswordValid(userDetails, loginPassword, passwordEncoder);
		}
		return isValid;
   }
	
	 public Boolean loginAuthVerify(AuthUser authUser, UserDetails userDetails, UsernamePasswordAuthenticationToken authentication, Object salt) {
		 Map<String,Object> map=new HashMap<>();
		 map=userAccountInfoService.selectOrg(authUser.getLoginCode());
		if(map==null){
			throw new BadCredentialsException(this.messages.getMessage("150000", "登录用户机构或角色为空,请联系管理员！"));
		}else if((String)map.get("orgid")==null){
			throw new BadCredentialsException(this.messages.getMessage("150000", "登录用户机构为空,请联系管理员！"));
		}else if((String)map.get("roleid")==null){
			throw new BadCredentialsException(this.messages.getMessage("150000", "登录用户角色为空,请联系管理员！"));
		}
		String username = authentication.getPrincipal().toString();
	        Map<String, String> parameters = (Map)authentication.getDetails();
	        String sysId = (String)parameters.get("sysId");
	        String Ifsso = parameters.get("crm_sso");
	        
	        if (sysId == null) {
	            sysId = "";
	            this.logger.info("登录用户[{}]所选逻辑系统id为null,请求参数：{}", username, parameters);
	        }

	        List<CredentialStrategy> credentialStrategy = this.credentialStrategyService.initCreStrategy(sysId);
	        PswWrongStrategy pswWrongStrategy = (PswWrongStrategy)this.credentialStrategyService.getPswWrongStrategy(sysId);
	        if (authentication.getCredentials() == null) {
	            this.logger.info("认证失败: 用户[{}]没有提供密码", username);
	            if (pswWrongStrategy != null && pswWrongStrategy.isEnable()) {
	                pswWrongStrategy.doCredentialStrategy(authUser, false);
	            }

	            throw new BadCredentialsException(this.messages.getMessage("150000", "密码错误"));
	        } else {
	            String password = authentication.getCredentials().toString();
	            String presentedPassword = password;
	            if ("2".equals(parameters.get("passwordType"))) {
	                try {
	                    password = password.replace(" ", "+");
	                    presentedPassword = BCRSAUtil.decrypt(password);
	                } catch (Exception var13) {
	                    this.logger.error("BC解密失败", var13);
	                    throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "密码错误"));
	                }
	            }
	            
	            boolean isValid = false;
	            
	            //SSO登录请求
	            if(Ifsso!=null) {
	            	isValid = true;
	            }else {
	            	isValid = this.loginAuthVerify(userDetails, presentedPassword, salt);
	            }
	            
	            if (!isValid) {
	                this.logger.info("认证失败: 用户[{}]密码错误", username);
	                if (pswWrongStrategy != null && pswWrongStrategy.isEnable()) {
	                    pswWrongStrategy.doCredentialStrategy(authUser, false);
	                }

	                throw new BadCredentialsException(this.messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials", "密码错误"));
	            } else {
	                this.doCredentialStrategy(authUser, credentialStrategy);
	                this.beforeChecks(authUser, authentication);
	                return true;
	            }
	        }
	    }

}
