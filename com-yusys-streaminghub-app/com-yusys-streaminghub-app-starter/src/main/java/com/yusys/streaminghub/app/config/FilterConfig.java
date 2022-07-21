package com.yusys.streaminghub.app.config;

import com.yusys.streaminghub.app.filter.MultiReadHttpServletRequestFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    String[] openapi;
    public FilterConfig(@Value("${api.openapi.path}") String openapi) {
        this.openapi = openapi.split(",");
    }

    @Bean
    public FilterRegistrationBean registFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MultiReadHttpServletRequestFilter());
        for (String path : openapi) {
            registration.addUrlPatterns(String.format("%s/*",path));
        }
        registration.setName("MultiReadHttpServletRequestFilter");
        registration.setOrder(1);
        return registration;
    }
}
