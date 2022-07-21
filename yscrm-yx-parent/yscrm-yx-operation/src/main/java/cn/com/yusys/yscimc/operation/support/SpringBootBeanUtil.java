package cn.com.yusys.yscimc.operation.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * SpringBoot 普通类获取Spring容器中的bean工具类
 * @author hujun3@yusys.com.cn
 * @Copyright (c) 2019宇信科技-版权所有
 * @date 2021-01-05
 */
@Component
public class SpringBootBeanUtil implements ApplicationContextAware {

        private static ApplicationContext applicationContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            if (SpringBootBeanUtil.applicationContext == null) {
                SpringBootBeanUtil.applicationContext = applicationContext;
            }
            System.out.println("========ApplicationContext配置成功========");
            System.out.println("========在普通类可以通过调用SpringBootBeanUtil.getApplicationContext()获取applicationContext对象========");
            System.out.println("========applicationContext="+ SpringBootBeanUtil.applicationContext +"========");
        }

        /**
         * 获取applicationContext
         * @return
         */
        public static ApplicationContext getApplicationContext() {
            return applicationContext;
        }

        /**
         * 通过name获取 Bean.
         * @param name
         * @return
         */
        public static Object getBean(String name) {
            return getApplicationContext().getBean(name);
        }

        /**
         * 通过class获取Bean.
         * @param clazz
         * @return
         */
        public static <T> T getBean(Class<T> clazz) {
            return getApplicationContext().getBean(clazz);
        }

        /**
         * 通过name,以及Clazz返回指定的Bean
         * @param name
         * @param clazz
         * @return
         */
        public static <T> T getBean(String name, Class<T> clazz) {
            return getApplicationContext().getBean(name, clazz);
        }
    /**
     * 获取目标方法
     * @param proxyObject
     * @param methodStr
     * @return
     */
    public static Method getMethod(Class proxyObject, String methodStr) {
        Method[] methods = proxyObject.getMethods();

        for(Method method : methods) {
            if(method.getName().equalsIgnoreCase(methodStr)) {
                return method;
            }
        }

        return null;
    }
}

