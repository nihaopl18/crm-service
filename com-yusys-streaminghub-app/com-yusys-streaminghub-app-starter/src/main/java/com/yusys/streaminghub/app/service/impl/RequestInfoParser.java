package com.yusys.streaminghub.app.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.yusys.streaminghub.app.annotation.ArgIndex;
import com.yusys.streaminghub.app.annotation.ArgTable;
import com.yusys.streaminghub.app.filter.MultiReadeHttpServletRequest;
import com.yusys.streaminghub.app.info.RequestInfo;
import com.yusys.streaminghub.app.service.IAccessTokenManager;
import com.yusys.streaminghub.app.service.IRequestInfoParser;
import com.yusys.streaminghub.app.service.ISSOService;
import com.yusys.streaminghub.app.util.ReqiredBasicParametersConstants;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
@Slf4j
public class RequestInfoParser implements IRequestInfoParser, ReqiredBasicParametersConstants {
    String[] openapi;
    @Autowired
    ApplicationContext applicationContext;

    public RequestInfoParser(@Value("${api.openapi.path}") String openapi) {
        this.openapi = StringUtils.isEmpty(openapi) ? new String[0] : openapi.split(",");
    }

    @Override
    public RequestInfo parse(MethodSignature signature, Object[] args) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        RequestInfo info = new RequestInfo();
        parseRequest(request, signature, args, info);
        return info;
    }

    private void parseRequest(HttpServletRequest httpServletRequest, MethodSignature signature, Object[] args, RequestInfo info) {
        String methodAction = httpServletRequest.getMethod();
//        System.out.println(String.format("%s %s", methodAction, httpServletRequest.getRequestURI()));
        info.setMethod(methodAction);
        String url = httpServletRequest.getRequestURI();
        String cntPath = httpServletRequest.getContextPath();
        for (String path : openapi) {
            String fullPath = String.format("%s%s", cntPath, path);
            if (url.startsWith(fullPath)) {
                url = url.substring(fullPath.length());
                break;
            }
        }
        info.setUrl(url);
        Map<String, String> parametersMap = new HashMap<>();
        Map<String, String> headersMap = new HashMap<>();
        Map<String, String> bodysMap = new HashMap<>();

        Method method = signature.getMethod();
        String parameterNames[] = signature.getParameterNames();//这是方法参数定义名，但不是注解中的声明
        Parameter[] parameters = method.getParameters();
        Class<?> argClazz = null;
        Object argValues = null;
        for (int i = 0; i < parameters.length; i++) {
            Parameter p = parameters[i];
            RequestParam param = p.getAnnotation(RequestParam.class);
            if (param != null) {
//                System.out.println("\tparameter:");
                String key = StringUtils.hasLength(param.name()) ? param.name() : parameterNames[i];//取的是实际方法名，不是参数注解声明的参数名
                String v = httpServletRequest.getParameter(key);
//                System.out.println(String.format("\t\t%s=%s", key, v));
                parametersMap.put(key, v);
            }
            PathVariable pathParam = p.getAnnotation(PathVariable.class);
            if (pathParam != null) {
//                System.out.println("\tparameter:");
                String key = StringUtils.hasLength(pathParam.name()) ? pathParam.name() : parameterNames[i];//取的是实际方法名，不是参数注解声明的参数名
                String v = httpServletRequest.getParameter(key);
//                System.out.println(String.format("\t\t%s=%s", key, v));
                parametersMap.put(key, v);
            }
            RequestHeader header = p.getAnnotation(RequestHeader.class);
            if (header != null) {
//                System.out.println("\theader:");
                String key = StringUtils.hasLength(header.name()) ? header.name() : parameterNames[i];
                String v = httpServletRequest.getHeader(key);
//                System.out.println(String.format("\t\t%s=%s", key, v));
                headersMap.put(key, v);
            }
            if ("POST".equalsIgnoreCase(methodAction)) {
                RequestBody body = p.getAnnotation(RequestBody.class);
                if (body != null) {
                    ArgTable argTable = p.getAnnotation(ArgTable.class);
                    if (argTable == null) {
                        //                    System.out.println("\tbody:");
                        String key = parameterNames[i];
                        MultiReadeHttpServletRequest multiReadeHttpServletRequest = (MultiReadeHttpServletRequest) httpServletRequest;
                        String v = multiReadeHttpServletRequest.getBody();
//                    System.out.println(String.format("\t\t%s=%s", key, v));
                        bodysMap.put(key, v);
//                System.out.println(String.format("body-----%s=%s", key, v));
                    } else {
                        //实参类型
                        argClazz = p.getType();
                        argValues = args[i];
                    }

                }
            }
        }
        String appId = parametersMap.get("appId");
        if (StringUtils.isEmpty(appId)) {
            appId = headersMap.get("appId");
        }
        if (StringUtils.isEmpty(appId)) {
            throw new RuntimeException(String.format("缺少appId基本参数! %s %s", info.getUrl(), info.getMethod()));
        }
        String nonce = parametersMap.get("nonce");
        if (StringUtils.isEmpty(nonce)) {
            nonce = headersMap.get("nonce");
        }
        if (StringUtils.isEmpty(nonce)) {
            throw new RuntimeException(String.format("缺少nonce基本参数! %s %s", info.getUrl(), info.getMethod()));
        }
        String sign = parametersMap.get("sign");
        if (StringUtils.isEmpty(sign)) {
            sign = headersMap.get("sign");
        }
        if (StringUtils.isEmpty(sign)) {
            throw new RuntimeException(String.format("缺少sign基本参数! %s %s", info.getUrl(), info.getMethod()));
        }
        String module = parametersMap.get("module");
        if (StringUtils.isEmpty(module)) {
            module = headersMap.get("module");
        }
        if (StringUtils.isEmpty(module)) {
            throw new RuntimeException(String.format("缺少module基本参数! %s %s", info.getUrl(), info.getMethod()));
        }
        String user = parametersMap.get("user");
        if (StringUtils.isEmpty(user)) {
            user = headersMap.get("user");
        }
        if (StringUtils.isEmpty(user)) {
            throw new RuntimeException(String.format("缺少user基本参数! %s %s", info.getUrl(), info.getMethod()));
        }
        String password = parametersMap.get("password");
        if (StringUtils.isEmpty(password)) {
            password = headersMap.get("password");
        }
        if (StringUtils.isEmpty(password)) {
            throw new RuntimeException(String.format("缺少password基本参数! %s %s", info.getUrl(), info.getMethod()));
        }
        if (argClazz == null) {
            throw new RuntimeException(String.format("缺少流应用对应方法参数表，即使用@argTable和@RequestBody声明的参数! %s %s", info.getUrl(), info.getMethod()));
        }
        String cached = parametersMap.get("cached");
        if (StringUtils.isEmpty(cached)) {
            cached = headersMap.get("cached");
        }

        ISSOService issoService = (ISSOService) httpServletRequest.getAttribute("ssoServiceStreamingHub");
        issoService.initAccessToken(user, password);

        info.setAppId(appId);
        info.setNonce(nonce);
        info.setSign(sign);
        info.setModule(module);
        info.setUser(user);
        info.setPassword(password);
        info.setExtra(bodysMap);
        info.setCached(StringUtils.isEmpty(cached) ? true : Boolean.valueOf(cached));


//        IAccessTokenManager issoService = (IAccessTokenManager) applicationContext.getBean("accessTokenManager");
//        issoService.initAccessToken(info);
        try {
            parseArgTable(argClazz, argValues, info);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    private void parseArgTable(Class<?> argClazz, Object argValuesOnObj, RequestInfo info) throws IllegalAccessException {
        Field[] fields = argClazz.getDeclaredFields();
        Map<Integer, Object> argNames = new TreeMap<>();
        Map<Integer, Object> argTypes = new TreeMap<>();
        Map<Integer, Object> argValues = new TreeMap<>();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            ArgIndex argIndex = field.getAnnotation(ArgIndex.class);
            if (argIndex == null) {
                continue;
            }
            int index = argIndex.argIndex();
            String argName = null;
            ApiModelProperty modelProperty = field.getAnnotation(ApiModelProperty.class);
            if (modelProperty != null) {
                argName = modelProperty.name();
            }
            if (StringUtils.isEmpty(argName)) {
                argName = field.getName();
            }
            String type = field.getType().getName();
            field.setAccessible(true);
            Object value = field.get(argValuesOnObj);

            argNames.put(index, argName);
            argTypes.put(index, type);
            argValues.put(index, value);
        }
        if (argNames.size() != argTypes.size() || argTypes.size() != argValues.size()) {
            throw new RuntimeException(String.format("流应用方法参数配置不正确！%s %s", info.getUrl(), info.getMethod()));
        }
        info.setArgNames(argNames.values().toArray(new String[0]));
        info.setArgTypes(argTypes.values().toArray(new String[0]));
        info.setArgValues(argValues.values().toArray(new Object[0]));
        log.info("流应用方法参数表。{}", info);
    }
}
