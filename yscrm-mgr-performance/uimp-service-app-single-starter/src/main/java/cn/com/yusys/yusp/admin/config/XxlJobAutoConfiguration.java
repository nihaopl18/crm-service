//package cn.com.yusys.yusp.admin.config;
//
//import java.io.IOException;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//
//import cn.com.yusys.yusp.commons.job.core.executor.XxlJobExecutor;
//
///**
// * xxl-job config
// *
// */
////@Configuration
//@ConditionalOnProperty(name = "application.xxl.job.enabled", havingValue = "true", matchIfMissing = false)
//public class XxlJobAutoConfiguration {
//    private Logger logger = LoggerFactory.getLogger(XxlJobAutoConfiguration.class);
//
//
//    @Value("${application.xxl.job.admin.addresses}")
//    private String adminAddresses;
//
//    @Value("${application.xxl.job.executor.appname}")
//    private String appName;
//
//    @Value("${application.xxl.job.executor.ip}")
//    private String ip;
//
//    @Value("${application.xxl.job.executor.port}")
//    private int port;
//
//    @Value("${application.xxl.job.executor.logpath}")
//    private String logPath;
//
//    @Value("${application.xxl.job.executor.logretentiondays}")
//    private int logRetentionDays;
//
//    public XxlJobAutoConfiguration() {
//    }
//
//
//    @Bean(initMethod = "start", destroyMethod = "destroy")
//    public XxlJobExecutor xxlJobExecutor() throws IOException {
//        logger.info(">>>>>>>>>>> xxl-job config init.");
//        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
//        xxlJobExecutor.setAdminAddresses(adminAddresses);
//        xxlJobExecutor.setAppName(appName);
//        xxlJobExecutor.setIp(ip);
//        xxlJobExecutor.setPort(port);
//        //xxlJobExecutor.setAccessToken(getOAuth2RequestInterceptor().getToken().getValue());
//        xxlJobExecutor.setLogPath(logPath);
//        xxlJobExecutor.setLogRetentionDays(logRetentionDays);
//
//        return xxlJobExecutor;
//    }
//
//}