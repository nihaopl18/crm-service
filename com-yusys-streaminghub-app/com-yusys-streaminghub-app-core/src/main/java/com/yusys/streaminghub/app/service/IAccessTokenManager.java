package com.yusys.streaminghub.app.service;

import com.yusys.streaminghub.app.info.ReceiptsInfo;
import com.yusys.streaminghub.app.info.RequestInfo;

public interface IAccessTokenManager {
    void initAccessToken(RequestInfo info) ;
    String getAccessToken();
}
