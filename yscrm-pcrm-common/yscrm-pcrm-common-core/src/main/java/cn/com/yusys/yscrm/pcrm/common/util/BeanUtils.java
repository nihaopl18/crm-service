package cn.com.yusys.yscrm.pcrm.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        if (applicationContext == null){
            applicationContext = arg0;
        }
    }
    public static Object getBean(String name){ return applicationContext.getBean(name); }
    public static <T> T getBean(Class<T> tClass){ return applicationContext.getBean(tClass); }
}
