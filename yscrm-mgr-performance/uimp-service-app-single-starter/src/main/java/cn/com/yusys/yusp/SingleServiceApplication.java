//package cn.com.yusys.yusp;
//
//import cn.com.yusys.yusp.commons.config.ApplicationProperties;
//import com.ctrip.framework.apollo.spring.boot.ApolloAutoConfiguration;
//import com.ulisesbocchio.jasyptspringboot.JasyptSpringBootAutoConfiguration;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
//import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.core.env.Environment;
//import tk.mybatis.spring.annotation.MapperScan;
//
//import java.net.InetAddress;
//
///**
// * 2.1.x版本精简启动类代码<br/>
// * 该项目如需要使用属性加解密功能，请将该类的SpringBootApplication注解中exclude属性中的{@link JasyptSpringBootAutoConfiguration}删除即可
// *
// * @since 2019年1月28日 下午3:05:58
// * @version 1.0
// */
//@EnableConfigurationProperties({ApplicationProperties.class})
//@SpringBootApplication(scanBasePackages = { "cn.com.yusys.yusp"},
//		exclude = {JmxAutoConfiguration.class, SecurityAutoConfiguration.class,
//        ApolloAutoConfiguration.class})
//@MapperScan(basePackages = { "cn.com.yusys.yusp.**.repository.mapper"})
//public class SingleServiceApplication {
//
//    private static final Logger log = LoggerFactory.getLogger(SingleServiceApplication.class);
//
//    public static void main(String[] args) throws Exception {
//        ConfigurableApplicationContext application = SpringApplication.run(SingleServiceApplication.class, args);
//        Environment env = application.getEnvironment();
//        String ip = InetAddress.getLocalHost().getHostAddress();
//        String port = env.getProperty("server.port");
//        String path = env.getProperty("server.servlet.context-path");
//        log.info("\n----------------------------------------------------------\n\t" +
//                "Application UIMP-Service is running! Access URLs:\n\t" +
//                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
//                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
//                "swagger-doc: \thttp://" + ip + ":" + port + path + "/doc.html\n" +
//                "----------------------------------------------------------");
//    }
//}
