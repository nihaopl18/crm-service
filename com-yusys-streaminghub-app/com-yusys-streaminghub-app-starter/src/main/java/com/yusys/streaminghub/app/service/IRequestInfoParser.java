package com.yusys.streaminghub.app.service;

import com.yusys.streaminghub.app.info.RequestInfo;
import org.aspectj.lang.reflect.MethodSignature;

public interface IRequestInfoParser {
    RequestInfo parse(MethodSignature signature, Object[] args);

}
