package cn.com.yusys.yusp.admin.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.quartz.Scheduler;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import cn.com.yusys.yusp.admin.job.core.schedule.XxlJobDynamicScheduler;

/**
 * @项目名称: yusp-adminO
 * @类名称: QuartzConfiguration
 * @类描述: 定时器Quartz配置
 * @功能描述: 
 * @创建人: dusong@yusys.com.cn
 * @创建时间: 2018-01-15 13:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
//@Configuration
public class QuartzConfiguration {
    
    private DataSource dataSource;
    
    public QuartzConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    /**
    * @方法名称: schedulerFactoryBean
    * @方法描述: 调度器初始化
    * @参数与返回说明: 
    * @算法描述: 
    */
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setQuartzProperties(quartzProperties());
        factory.setDataSource(this.dataSource);//
        factory.setStartupDelay(20);  //延时启动，应用启动成功后在启动
        factory.setOverwriteExistingJobs(true); //覆盖DB中JOB：true、以数据库中已经存在的为准：false
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        return factory;
    }

    /**
    * @方法名称: quartzProperties
    * @方法描述: 配置文件初始化
    * @参数与返回说明: 
    * @算法描述: 
    */
    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    /**
    * @方法名称:scheduler
    * @方法描述:获取Scheduler的实例
    * @参数与返回说明:
    * @算法描述:
    */
    @Bean
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean().getScheduler();
    }
    
    /**
    * @throws IOException 
    * @方法名称: xxlJobDynamicScheduler
    * @方法描述: 初始化XXL调度器
    * @参数与返回说明: 
    * @算法描述: 
    */
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public XxlJobDynamicScheduler xxlJobDynamicScheduler() throws IOException {
        XxlJobDynamicScheduler xxlJobDynamicScheduler = new XxlJobDynamicScheduler();
        xxlJobDynamicScheduler.setScheduler(scheduler());
        xxlJobDynamicScheduler.setAccessToken("");
        
        return xxlJobDynamicScheduler;
    }
}
