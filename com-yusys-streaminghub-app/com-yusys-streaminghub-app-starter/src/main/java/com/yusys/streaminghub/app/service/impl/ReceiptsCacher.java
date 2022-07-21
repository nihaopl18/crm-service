package com.yusys.streaminghub.app.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusys.streaminghub.app.info.ReceiptsInfo;
import com.yusys.streaminghub.app.info.RequestInfo;
import com.yusys.streaminghub.app.service.IReceiptsCacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@Slf4j
public class ReceiptsCacher implements IReceiptsCacher {
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Override
    public String getData(RequestInfo requestInfo) throws JsonProcessingException {
        String argJson = new ObjectMapper().writeValueAsString(requestInfo.getArgValues());
        String paramsMD5 = DigestUtils.md5DigestAsHex(String.format("%s%s%s", requestInfo.getAppId(), requestInfo.getModule(), argJson).getBytes());
        String data= (String) redisTemplate.opsForHash().get("streaminghub:receipts.data",paramsMD5);
        return data;
    }
    @Override
    public boolean hasData(RequestInfo requestInfo) throws JsonProcessingException {
        String argJson = new ObjectMapper().writeValueAsString(requestInfo.getArgValues());
        String paramsMD5 = DigestUtils.md5DigestAsHex(String.format("%s%s%s", requestInfo.getAppId(), requestInfo.getModule(), argJson).getBytes());
        return redisTemplate.opsForHash().hasKey("streaminghub:receipts.data",paramsMD5);
    }
}
