package cn.com.yusys.yusp.uimp.distribution.factory;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author:Mr.raop
 * @create:2022-05-20
 */

@Component
public class SpringJobBeanFactory implements ApplicationContextAware {

    private static ApplicationContext bean;
    @Override
    public void setApplicationContext(ApplicationContext bean) throws BeansException {
        SpringJobBeanFactory.bean = bean;
    }

    public static ApplicationContext getApplicationContext() {
        return bean;
    }


    public static <T>T getBean(String name ,Class<T> clazz){
        if(bean==null){
            return null;
        }
        return getApplicationContext().getBean(name,clazz);
    }
}
