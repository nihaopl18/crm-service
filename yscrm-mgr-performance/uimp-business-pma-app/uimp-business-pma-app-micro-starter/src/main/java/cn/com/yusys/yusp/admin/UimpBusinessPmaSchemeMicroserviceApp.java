package cn.com.yusys.yusp.admin;

import cn.com.yusys.yusp.commons.config.ApplicationProperties;
import cn.com.yusys.yusp.commons.util.AppStartMessageUtil;
import com.ulisesbocchio.jasyptspringboot.JasyptSpringBootAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 2.1.x版本精简启动类代码<br/>
 * 该项目如需要使用属性加解密功能，请将该类的SpringBootApplication注解中exclude属性中的{@link JasyptSpringBootAutoConfiguration}删除即可
 *
 * @author tangxb
 * @version 2.1.1
 */
@EnableConfigurationProperties({ ApplicationProperties.class })
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "cn.com.yusys.yusp", exclude = { JmxAutoConfiguration.class,
        ThymeleafAutoConfiguration.class, SecurityAutoConfiguration.class, JasyptSpringBootAutoConfiguration.class })
@MapperScan({ "cn.com.yusys.yusp.**.repository.mapper" })
@EnableFeignClients("cn.com.yusys.yusp")
@EnableTransactionManagement
public class UimpBusinessPmaSchemeMicroserviceApp {
    private static final Logger logger = LoggerFactory.getLogger(UimpBusinessPmaSchemeMicroserviceApp.class);

    public static void main(String[] args) {
        Environment env = SpringApplication.run(UimpBusinessPmaSchemeMicroserviceApp.class, args).getEnvironment();
        logger.info(AppStartMessageUtil.updServiceStartMessage(env));
    }
}
