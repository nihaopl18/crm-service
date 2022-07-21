package cn.com.yusys.yusp.dycrm.transferInfo.service;

import com.alibaba.fastjson.JSONObject;
import com.yusys.streaminghub.app.filter.MultiReadeHttpServletRequest;
import com.yusys.streaminghub.app.result.BizException;
import com.yusys.streaminghub.app.result.ResultCode;
import com.yusys.streaminghub.app.service.ISSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Service
public class SSOServiceStreamingHub implements ISSOService {
    @Autowired
    SSOService ssoService;
    @Value("${shub.auth.publickKey}")
    String publicKey;
    @Value("localhost:${server.port}${server.servlet.context-path}/oauth/token")
    String cntPath;
    @Value("${shub.http.protocol}")
    String protocol;
    @Override
    public String getAccessToken(String username, String password) {
        String pt=StringUtils.isEmpty(protocol)?"http":protocol;
        String url = String.format("%s://%s", pt.toLowerCase(), cntPath);
        String old=password;
        try {
            password = encryptPWD(password);
        } catch (Exception e) {
            throw new BizException(ResultCode.USER_LOGIN_ERROR);
        }
        return ssoService.getAccessToken(url, username, password,old);
    }

    @Override
    public void initAccessToken(String username, String password) {
        MultiReadeHttpServletRequest request = (MultiReadeHttpServletRequest) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String exists = request.getParameter("access_token");
        if (!StringUtils.isEmpty(exists)) {
            return;
        }
        String accessToken = getAccessToken(username, password);
        request.setAccessToken(accessToken);
    }

    private String encryptPWD(String password) throws Exception {
        byte[] decode = Base64.getDecoder().decode(publicKey);
        RSAPublicKey rsaPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decode));
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, rsaPublicKey);
        byte[] crypt = cipher.doFinal(password.getBytes("UTF-8"));
        String basicCrypt = Base64.getEncoder().encodeToString(crypt);
        return basicCrypt;
    }
}
