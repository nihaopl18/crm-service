package cn.com.yusys.yscimc.operation.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface Keyword {

    String alias();
}
