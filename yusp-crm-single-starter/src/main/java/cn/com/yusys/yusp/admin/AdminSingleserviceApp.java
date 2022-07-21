package cn.com.yusys.yusp.admin;

import cn.com.yusys.yusp.admin.web.config.WebProperties;
import cn.com.yusys.yusp.commons.config.ApplicationProperties;
import cn.com.yusys.yusp.commons.config.DefaultProfileUtil;
import io.github.jhipster.config.JHipsterConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

@ComponentScan(
        basePackages = {"cn.com.yusys.yusp.admin", "cn.com.yusys.yusp.uaa", "cn.com.yusys.yusp.message",
                "cn.com.yusys.yusp.dataauth", "cn.com.yusys.yusp.commons.aop.dataauth",
                "cn.com.yusys.yusp.sequence", "cn.com.yusys.yscrm.mktactivity", "cn.com.yusys.yusp.commons.web.rest", "cn.com.yusys.yusp.echain.server",
                "cn.com.yusys.yscrm.custflexEs", "cn.com.yusys.yscrm.salesoppor", "cn.com.yusys.yscrm.custpub", "cn.com.yusys.yscrm.homepage",
                "cn.com.yusys.yscrm.sysview", "cn.com.yusys.yscrm.mgr.sys.pdplan", "cn.com.yusys.yscrm.custmgr",
                "cn.com.yusys.yscrm.product", "cn.com.yusys.yscrm.custmgrgroup",
                "cn.com.yusys.yscrm.custgrade", "cn.com.yusys.yscrm.infocalculator","cn.com.yusys.yscrm.fiexdstatement",
                "cn.com.yusys.yscrm.info.custlosswarn", "cn.com.yusys.yscrm.info.workreport", "cn.com.yusys.yscrm.knowledge","cn.com.yusys.yscrm.notice",
                "cn.com.yusys.yscrm.user.schedule", "cn.com.yusys.yscrm.info.remind", "cn.com.yusys.yscrm.exchange",
                "cn.com.yusys.yscrm.cust.person", "cn.com.yusys.yscrm.cust.org", "cn.com.yusys.yscrm.cust.group",
                "cn.com.yusys.yscrm.custservice", "cn.com.yusys.yscrm.entity.cust.org.group", "cn.com.yusys.yusp..*.web.rest..*",
                "cn.com.yusys.yusp.dycrm","cn.com.yusys.yscrm.pcrm.common",
                "cn.com.yusys.yusp.cim.model",
                "cn.com.yusys.climp",
                "cn.com.yusys.yscimc",
                "cn.com.yusys.yusp.cm",
                "cn.com.yusys.yusp.eng",
                "cn.com.yusys.yscimc.cust.group",
                "cn.com.yusys.yscimc.operation",
				"com.yusys.streaminghub.app",
				"com.yusys.streaminghub.rpc",
                "cn.com.yusys.yscimc.operation",
                "cn.com.yusys.yusp.uimp",
                "cn.com.yusys.yusp.kit",
                "cn.com.yusys.yusp.flow"
        }
)
//@EnableAutoConfiguration(exclude = {MetricFilterAutoConfiguration.class, MetricRepositoryAutoConfiguration.class})
@EnableConfigurationProperties({LiquibaseProperties.class, ApplicationProperties.class, WebProperties.class})
@MapperScan({"cn.com.yusys.**.repository.mapper","com.yusys.streaminghub.**.repository.mapper"})
@SpringBootApplication(scanBasePackages = { "cn.com.yusys.yusp"},exclude = {QuartzAutoConfiguration.class, JmxAutoConfiguration.class, SecurityAutoConfiguration.class})
public class AdminSingleserviceApp {

    private static final Logger log = LoggerFactory.getLogger(AdminSingleserviceApp.class);

    private final Environment env;

    public AdminSingleserviceApp(Environment env) {
        this.env = env;
    }

    /**
     * Initializes yuspAdmin.
     * <p>
     * Spring profiles can be configured with a program arguments --spring.profiles.active=your-active-profile
     * <p>
     * You can find more information on how profiles work with JHipster on <a href="http://jhipster.github.io/profiles/">http://jhipster.github.io/profiles/</a>.
     */
    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
        if (activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_PRODUCTION)) {
            log.error("You have misconfigured your application! It should not run " +
                    "with both the 'dev' and 'prod' profiles at the same time.");
        }
        if (activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT) && activeProfiles.contains(JHipsterConstants.SPRING_PROFILE_CLOUD)) {
            log.error("You have misconfigured your application! It should not" +
                    "run with both the 'dev' and 'cloud' profiles at the same time.");
        }
    }

    /**
     * Main method, used to run the application.
     *
     * @param args the command line arguments
     * @throws UnknownHostException if the local host name could not be resolved into an address
     */
    public static void main(String[] args) throws UnknownHostException {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication app = new SpringApplication(AdminSingleserviceApp.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        log.info("\n----------------------------------------------------------\n\t" +
                        "Application '{}' is running! Access URLs:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "External: \t{}://{}:{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getActiveProfiles());

        String configServerStatus = env.getProperty("configserver.status");
        log.info("\n----------------------------------------------------------\n\t" +
                        "Config Server: \t{}\n----------------------------------------------------------",
                configServerStatus == null ? "Not found or not setup for this application" : configServerStatus);

    }
}
