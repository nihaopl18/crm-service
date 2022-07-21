package com.yusys.streaminghub.app.service.impl;

import com.yusys.streaminghub.app.service.ITestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestService implements ITestService {
    @Value("${test.p1}")
    String testP1;
    @Override
    public String test(int v) {
        return "xxx-" + testP1 + "-" + v;
    }
}
