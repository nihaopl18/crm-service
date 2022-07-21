package com.yusys.streaminghub.app.service;

import com.yusys.streaminghub.app.result.SignException;

public interface ISignCheckerService {
    void check(String appId,String nonce,String sign)throws SignException;
}
