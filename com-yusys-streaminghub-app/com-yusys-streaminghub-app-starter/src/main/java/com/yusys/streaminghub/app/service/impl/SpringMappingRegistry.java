package com.yusys.streaminghub.app.service.impl;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusys.streaminghub.app.info.RequestInfo;
import com.yusys.streaminghub.app.result.BizException;
import com.yusys.streaminghub.app.service.ISpringMappingRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.AbstractHandlerMethodMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SpringMappingRegistry implements ISpringMappingRegistry {
    @Autowired
    ApplicationContext applicationContext;

    @Override
    public List<HandlerMethod> searchMethodHandler(String url, RequestMappingHandlerMapping mapping) throws NoSuchFieldException, IllegalAccessException {
        List<HandlerMethod> handlerMethods = new ArrayList<>();

        Class<?> abstractHandlerMethodMappingClazz = AbstractHandlerMethodMapping.class;
        Field mappingRegistryField = abstractHandlerMethodMappingClazz.getDeclaredField("mappingRegistry");
        mappingRegistryField.setAccessible(true);
        Object mappingRegistry = mappingRegistryField.get(mapping);
        if (mappingRegistry == null) {
            return handlerMethods;
        }
        Class<?> internelClazz = mappingRegistry.getClass();

        Field registryField = internelClazz.getDeclaredField("registry");
        registryField.setAccessible(true);
        Map<RequestMappingInfo, Object> registry = (Map<RequestMappingInfo, Object>) registryField.get(mappingRegistry);

        if (registry == null) {
            return handlerMethods;
        }
//不同spring版本此处不同:pathLookup(高版本）
        Field pathLookup = internelClazz.getDeclaredField("urlLookup");
        pathLookup.setAccessible(true);
        Map<String, List<RequestMappingInfo>> infoMap = (Map<String, List<RequestMappingInfo>>) pathLookup.get(mappingRegistry);
        if (infoMap == null) {
            return handlerMethods;
        }

        List<RequestMappingInfo> requestMappingInfos = infoMap.get(url);
        if (requestMappingInfos == null) {
            return handlerMethods;
        }

        for (RequestMappingInfo info : requestMappingInfos) {
            Object o = registry.get(info);
            Class<?> mapRegistryClazz = o.getClass();
            Field handlerMethodField = mapRegistryClazz.getDeclaredField("handlerMethod");
            handlerMethodField.setAccessible(true);
            HandlerMethod handlerMethod = (HandlerMethod) handlerMethodField.get(o);
            if (handlerMethod == null) {
                continue;
            }

            handlerMethods.add(handlerMethod);
        }
        return handlerMethods;
    }

    @Override
    public Object invoke(List<HandlerMethod> handlerMethodList, RequestInfo requestInfo) throws InvocationTargetException, IllegalAccessException {
        Object[] args = requestInfo.getArgValues();
        String parameterNames[] = requestInfo.getArgNames();
        for (HandlerMethod handlerMethod : handlerMethodList) {
            if (!matchMethod(handlerMethod.getMethodParameters(), parameterNames)) {
                continue;
            }
            String bean = (String) handlerMethod.getBean();
            Object o = applicationContext.getBean(bean);
            Method method = handlerMethod.getMethod();
            try {
                checkAndConvertArgs(method, args);
            } catch (IOException e) {
                throw new BizException("20010", e.getMessage());
            }
            return method.invoke(o, args);
        }
        throw new InvocationTargetException(new NoSuchMethodException(String.format("指定的请求地址中没有声明方法！%s", requestInfo)));
    }

    private void checkAndConvertArgs(Method method, Object[] args) throws IOException {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Class<?> clazz = parameter.getType();
            Object argV = args[i];
            if (argV == null) {
                continue;
            }
            if (clazz.equals(argV.getClass())) {
                continue;
            }
            //为了兼容queryModel这个不规范的玩意
            if (clazz.equals(QueryModel.class) && argV != null) {
                if (argV instanceof Map) {
                    Map<String, Object> map = (Map<String, Object>) argV;
                    Map<String, Object> condition = (Map<String, Object>) map.get("condition");
                    map.put("condition", new ObjectMapper().writeValueAsString(condition));
                }
            }
            String json = new ObjectMapper().writeValueAsString(argV);
            args[i] = new ObjectMapper().readValue(json, clazz);
        }
    }

    private boolean matchMethod(MethodParameter[] methodParameters, String[] parameterNames) {
        //以地址来匹配method，spring如果有相同地址会报错，因此一个地址有且仅有一个method，而一个method可以映射多个地址
        //因此，通过地址获取的method虽然是列表，但实际上只能有一个method
        //如果非得匹配到method才安心的话，是非常困难的，原因如下：
        //1、如果以注解参数声明来匹配，目标方法的参数注解如未指定name而只能取实参名，由于java运行时实参实均已虚化，故得不到声名参数，如欲得到则需要aspect在编译期记录参数名。
        //2、如果以参数类型表匹配，前置的类型路径名可能与目标应用的参数类型不同，因此也难以匹配所有情况
        if (methodParameters.length != parameterNames.length) {
            return false;
        }

        return true;
    }
/*
    private String getDeclaredName(MethodParameter methodParameter) {
        String name=methodParameter.getParameterName();
        PathVariable pathVariable= methodParameter.getParameterAnnotation(PathVariable.class);
        if (pathVariable != null) {
            if (!StringUtils.isEmpty(pathVariable.name())) {
                name=pathVariable.name();
            }
        }
        RequestParam requestParam= methodParameter.getParameterAnnotation(RequestParam.class);
        if (requestParam != null) {
            if (!StringUtils.isEmpty(requestParam.name())) {
                name=requestParam.name();
            }
        }
        RequestHeader requestHeader= methodParameter.getParameterAnnotation(RequestHeader.class);
        if (requestHeader != null) {
            if (!StringUtils.isEmpty(requestHeader.name())) {
                name=requestHeader.name();
            }
        }
        return name;
    }

 */
}
