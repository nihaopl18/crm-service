package com.yusys.streaminghub.app.response;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.commons.web.rest.errors.ErrorVM;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusys.streaminghub.app.annotation.ResponseResult;
import com.yusys.streaminghub.app.result.ResultCode;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 使用 @ControllerAdvice & ResponseBodyAdvice 
 * 拦截Controller方法默认返回参数，统一处理返回值/响应体
 */
@ControllerAdvice
public class ResponseResultHandler implements ResponseBodyAdvice<Object> {

  // 标记名称
  public static final String RESPONSE_RESULT_ANN = "RESPONSE-RESULT-ANN";


  // 判断是否要执行 beforeBodyWrite 方法，true为执行，false不执行，有注解标记的时候处理返回值
  @Override
  public boolean supports(MethodParameter arg0, Class<? extends HttpMessageConverter<?>> arg1) {
    ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    HttpServletRequest request = sra.getRequest();
    // 判断请求是否有包装标记
    ResponseResult responseResultAnn = (ResponseResult) request.getAttribute(RESPONSE_RESULT_ANN);
    return responseResultAnn == null ? false : true;
  }


  // 对返回值做包装处理，如果属于异常结果，则需要再包装
  @Override
  public Object beforeBodyWrite(Object body, MethodParameter arg1, MediaType arg2,
                                Class<? extends HttpMessageConverter<?>> arg3, ServerHttpRequest arg4, ServerHttpResponse arg5) {
    if (body instanceof ErrorResult) {
      ErrorResult error = (ErrorResult) body;
      return R.fail(error.getCode(), error.getMessage());
    } else if (body instanceof R) {
      return (R) body;
    }else if (body instanceof ErrorVM){
      ErrorVM error = (ErrorVM) body;
      return R.fail(ResultCode.SYSTEM_CRM_ERROR.code(), String.format("%s. 原因：%s",ResultCode.SYSTEM_CRM_ERROR.message(),error.getMessage()));
    }else if (body instanceof ResultDto){
      ResultDto resultDto = (ResultDto) body;
      return R.successCRM(resultDto);
    } else {
      Class<?> clazz=arg1.getMethod().getReturnType();
      if(clazz.equals(String.class)){
       HttpHeaders httpHeaders= arg5.getHeaders();
        httpHeaders.set("Access-Control-Allow-Origin", "*");
        httpHeaders.set("Content-Type", "application/json;charset=UTF-8");
        try {
          return new ObjectMapper().writeValueAsString(R.success(body));
        } catch (JsonProcessingException e) {
        }
      }
    }
    return R.success(body);
  }
}
