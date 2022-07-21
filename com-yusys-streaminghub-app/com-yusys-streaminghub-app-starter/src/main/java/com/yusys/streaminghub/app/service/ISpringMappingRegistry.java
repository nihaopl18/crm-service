package com.yusys.streaminghub.app.service;

import com.yusys.streaminghub.app.info.RequestInfo;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface ISpringMappingRegistry {
    List<HandlerMethod> searchMethodHandler(String url, RequestMappingHandlerMapping mapping) throws NoSuchFieldException, IllegalAccessException;

    Object invoke(List<HandlerMethod> handlerMethodList, RequestInfo requestInfo) throws InvocationTargetException, IllegalAccessException;

}
