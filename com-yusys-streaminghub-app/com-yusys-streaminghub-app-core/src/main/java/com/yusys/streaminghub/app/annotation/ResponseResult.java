package com.yusys.streaminghub.app.annotation;

import java.lang.annotation.*;

/**
 * 此注解包裹了返回值
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD})
@Documented
public @interface ResponseResult {

}
