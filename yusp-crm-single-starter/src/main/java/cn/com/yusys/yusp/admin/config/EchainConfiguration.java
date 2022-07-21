package cn.com.yusys.yusp.admin.config;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cn.com.yusys.yusp.echain.server.echain.EchainInitializer;
import cn.com.yusys.yusp.echain.server.echain.aop.EchainCoreServiceAspect;
import cn.com.yusys.yusp.echain.server.echain.servlet.DefinitionServlet;

/**
 * @author Cytus_
 * @version 1.0
 * @since 2018/8/2 16:58
 */
@Configuration
public class EchainConfiguration {

    @Bean
    public EchainInitializer yuspEchainBean(DataSource dataSource) {
        return new EchainInitializer(dataSource);
    }

    @Configuration
    public class EchainInit {
        private EchainInitializer yuspEchainBean;

        public EchainInit(EchainInitializer yuspEchainBean) {
            this.yuspEchainBean = yuspEchainBean;
        }

        @PostConstruct
        public void initEchain() {
            yuspEchainBean.init();
        }

        @Bean
        public ServletRegistrationBean indexServletRegistration() {
            ServletRegistrationBean registration = new ServletRegistrationBean(new DefinitionServlet());
            registration.addUrlMappings("/definitionservlet");
            return registration;
        }

        @Bean
        public EchainCoreServiceAspect loggingAspect() {
            return new EchainCoreServiceAspect();
        }
    }

}
