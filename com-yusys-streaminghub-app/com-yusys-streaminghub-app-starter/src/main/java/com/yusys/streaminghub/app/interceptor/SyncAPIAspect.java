package com.yusys.streaminghub.app.interceptor;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusys.streaminghub.app.info.ReceiptsInfo;
import com.yusys.streaminghub.app.info.RequestInfo;
import com.yusys.streaminghub.app.service.IReceiptsCacher;
import com.yusys.streaminghub.app.service.IRequestInfoParser;
import com.yusys.streaminghub.app.service.ISignCheckerService;
import com.yusys.streaminghub.app.service.ISpringMappingRegistry;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

@Aspect
@Component
@Slf4j
public class SyncAPIAspect {
    @Autowired
    IRequestInfoParser requestInfoParser;
    @Autowired
    ISignCheckerService signCheckerService;
    @Autowired
    WebApplicationContext applicationContext;
    @Autowired
    ISpringMappingRegistry springMappingRegistry;
    @Autowired
    IReceiptsCacher receiptsCacher;

    @Pointcut("@annotation(com.yusys.streaminghub.app.annotation.SyncMethod)")
    public void annotationPoinCut() {
    }


    @Around("annotationPoinCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        RequestInfo requestInfo = null;
        try {
            requestInfo = requestInfoParser.parse(signature, joinPoint.getArgs());
            signCheckerService.check(requestInfo.getAppId(), requestInfo.getNonce(), requestInfo.getSign());

            Object ret = joinPoint.proceed(joinPoint.getArgs());
            if (ret != null) {
                throw new Exception(String.format("方法%s.%s必须返回null", signature.getMethod().getDeclaringClass(), signature.getName()));
            }
            //TODO: 如果判断查询的参数值与缓冲结果的参数值相同，则直接返回缓冲结果。此处未来实现
            //TODO: 检查参数值和缓冲结果，如果匹配则直接返回结果，则跳过作业查询
            //TODO: 算法：参数先排序，然后MD5，以此为串去查结果是否缓冲存在
            //执行作业进行一次新查询
            //其下执行内部api方法
            boolean cached = requestInfo.isCached();
            if (cached && receiptsCacher.hasData(requestInfo)) {
                String data = receiptsCacher.getData(requestInfo);
                Class<?>clazz=signature.getReturnType();
                if (clazz.equals(ResultDto.class)) {//为了兼容ResultDto返回类型
                    StringBuffer sb = new StringBuffer();
                    sb.append("{");
                    sb.append(String.format("\"code\":200,"));
                    sb.append(String.format("\"total\":0,"));
                    sb.append(String.format("\"message\":\"OK\","));
                    sb.append(String.format("\"data\":%s",data));
                    sb.append("}");
                    data=sb.toString();
                }
                return new ObjectMapper().readValue(data, signature.getReturnType());
            }
            return execMethod(requestInfo);
        } catch (Exception e) {
            throw e;
        }
    }

    private Object execMethod(RequestInfo info) throws Throwable {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //        mapping.match()
        List<HandlerMethod> handlerMethodList = springMappingRegistry.searchMethodHandler(info.getUrl(), mapping);
        Object obj = springMappingRegistry.invoke(handlerMethodList, info);
        return obj;
    }

}
