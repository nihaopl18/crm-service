package com.yusys.streaminghub.app.service.impl;

import com.yusys.streaminghub.app.domain.ShubApp;
import com.yusys.streaminghub.app.repository.mapper.ShubAppMapper;
import com.yusys.streaminghub.app.result.SignException;
import com.yusys.streaminghub.app.service.ISignCheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

@Service
public class SignCheckerService implements ISignCheckerService {
    @Autowired
    ShubAppMapper shubAppMapper;

    /**
     * MD5(appid+appsecrect+nonce)
     * @param appId
     * @param nonce
     * @param sign
     * @throws SignException
     */
    @Override
    public void check(String appId, String nonce, String sign) throws SignException {
        if (StringUtils.isEmpty(appId)) {
            throw new SignException("缺少参数appId");
        }
        if (StringUtils.isEmpty(nonce)) {
            throw new SignException("缺少参数nonce");
        }
        if (StringUtils.isEmpty(sign)) {
            throw new SignException("缺少参数sign");
        }
        ShubApp app = shubAppMapper.selectByPrimaryKey(appId);
        if (app == null) {
            throw new SignException(String.format("appId=%s",appId));
        }
        String destSign=DigestUtils.md5DigestAsHex(String.format("%s%s%s",appId,app.getAppSecret(),nonce).getBytes());
        if (!destSign.equals(sign)) {
            throw new SignException(String.format("appId=%s",appId));
        }
    }

    public static void main(String[] args) {
        String destSign=DigestUtils.md5DigestAsHex(
                String.format("%s%s%s","243b2335a62d8c796a5fa2863e49e8cb","c2e79b919f821c916716ab97264c6c0a","929328392").getBytes());
        System.out.println(destSign);//69ece89d49147c45143964a533d3cc50
    }
}
