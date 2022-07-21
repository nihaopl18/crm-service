package com.yusys.streaminghub.app.service;

public interface ISSOService {
    //默认认证服务器:http://xxxx:port/oauth/token
    String getAccessToken(String username, String password);

    void initAccessToken(String username, String password);

}
