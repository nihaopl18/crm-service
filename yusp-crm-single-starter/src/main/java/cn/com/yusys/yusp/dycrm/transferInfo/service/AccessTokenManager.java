package cn.com.yusys.yusp.dycrm.transferInfo.service;

import com.alibaba.fastjson.JSONObject;
import com.yusys.streaminghub.app.info.RequestInfo;
import com.yusys.streaminghub.app.service.IAccessTokenManager;
import com.yusys.streaminghub.app.service.ISSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenManager implements IAccessTokenManager {
    ThreadLocal<UserEntity> userEntities;
    @Autowired
    ISSOService issoService;

    public AccessTokenManager() {
        userEntities = new ThreadLocal<>();
    }

    @Override
    public void initAccessToken(RequestInfo request) {
        UserEntity current = userEntities.get();
        if (current != null && request.getUser().equals(current.user)) {
            return;
        }
        String access_token = issoService.getAccessToken(request.getUser(), request.getPassword());
        current = new UserEntity();
        current.user = request.getUser();
        current.accessToken = access_token;
        userEntities.set(current);
//        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
//        if (attributes != null) {
//            HttpServletRequest httpServletRequest = ((ServletRequestAttributes) attributes).getRequest();
//            if (httpServletRequest instanceof MultiReadeHttpServletRequest) {
//                MultiReadeHttpServletRequest multiReadeHttpServletRequest = (MultiReadeHttpServletRequest) httpServletRequest;
//                multiReadeHttpServletRequest.setAccessToken(current.accessToken);
//            }
//        }
    }

    @Override
    public String getAccessToken() {
        UserEntity current = userEntities.get();
        if (current == null) {
            return null;
        }
        return current.accessToken;
    }

    class UserEntity {
        String user;
        String accessToken;
    }
}
