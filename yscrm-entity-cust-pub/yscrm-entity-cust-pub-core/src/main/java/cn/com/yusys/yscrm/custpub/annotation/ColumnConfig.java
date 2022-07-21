package cn.com.yusys.yscrm.custpub.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ColumnConfig {

	/**
	 * 字段的中文名
	 * @return
	 */
	String description() default "";

	/**
	 * 码值
	 * @return
	 */
	String lookup() default "";
	
	/**
	 * 是否为关键字段
	 * @return
	 */
	boolean key() default false;
}
