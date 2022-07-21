package cn.com.yusys.climp.utils;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("UserInfoService")
public class UserInfoService {
    private static final Logger logger = LoggerFactory.getLogger(UserInfoService.class);
    //    @Autowired
//    private UserService userService;
//
//    /**
//     *
//     * @return 登录用户信息
//     */
//    public User getUserInfo(){
//        Map parsedTokenMap = AuthUtils.getParsedAccessTokenMap();
//        String accessToken = AuthUtils.getCurrentUserToken(parsedTokenMap);
//        String sysId = AuthUtils.getCurrentUserLoginSYS(parsedTokenMap);
//        if (StringUtils.isEmpty(accessToken)) {
//            logger.warn("用户授权信息获取失败{}", accessToken);
//            return null;
//        }else {
//            String loginCode = userService.getUserCode(accessToken);
//            logger.info("userCode: {}", loginCode);
//            return userService.getUserInfo(loginCode, sysId, accessToken);
//        }
//    }
//
//    /**
//     *
//     * @return 登录用户orgCode
//     */
//    public String getLoginCode() {
//        String loginCode = getUserInfo().getLoginCode();
//        return loginCode;
//    }
//
//    /**
//     *
//     * @return 登录用户orgCode
//     */
//    public String getOrgCode(){
//        return getUserInfo().getOrg().getCode();
//    }
    @Autowired
    private UaaClient uaaClient;

    /**
     * @return 登录用户信息
     */
    public UserInfoDTO getUserInfo() {
        String accessToken = HeaderUtil.getAccessToken();
        if (StringUtils.isEmpty(accessToken)) {
            logger.warn("用户授权信息获取失败{}", accessToken);
            return null;
        }
        ResponseEntity<UserInfoDTO> userSessionInfo = uaaClient.getUserSessionInfo(accessToken);
        UserInfoDTO body = userSessionInfo.getBody();
        return body;
    }

    /**
     * @return 登录用户orgCode
     */
    public String getLoginCode() {
        String loginCode = getUserInfo().getLoginCode();
        return loginCode;
    }

    /**
     * @return 登录用户orgCode
     */
    public String getOrgCode() {
        return getUserInfo().getOrg().getCode();
    }
}
