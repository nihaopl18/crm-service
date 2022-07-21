package com.yusys.streaminghub.app.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ArgIndex {
    /**
     * 对应的在流应用方法参数中的位置。从零开始
     */
    int argIndex();
}
