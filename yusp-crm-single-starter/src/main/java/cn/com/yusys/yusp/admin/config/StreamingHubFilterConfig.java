package cn.com.yusys.yusp.admin.config;

import cn.com.yusys.yusp.admin.web.filter.StreamingHubFilter;
import com.yusys.streaminghub.app.service.ISSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;

@Configuration
public class StreamingHubFilterConfig {
    @Value(value = "${api.openapi.path}")
    String openapiPath;
    @Autowired
    ISSOService ssoServiceStreamingHub;
    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new StreamingHubFilter(ssoServiceStreamingHub));
        String[] paths = openapiPath.split(",");
        for (String path : paths) {
            if (StringUtils.isEmpty(path)) {
                continue;
            }
            String patt=String.format("%s/*",path);
            registration.addUrlPatterns(patt);
            /*
            /yusp-crm-single/external/api/ocrmfcicgbase/customerList
             */
        }
//        registration.addUrlPatterns("/external/*");
        registration.setName("StreamingHubFilter");
        registration.setOrder(1);
        return registration;
    }
}
