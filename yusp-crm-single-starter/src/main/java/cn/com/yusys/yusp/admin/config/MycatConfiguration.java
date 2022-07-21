package cn.com.yusys.yusp.admin.config;

import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * @项目名称: yusp-admin
 * @类名称: MycatConfiguration
 * @类描述: mycat增强器
 * @功能描述: mycat使用的mysql协议，但是底层数据库如果接入oracle，则心跳检查语句需要调整
 * @创建人: dusong@yusys.com.cn
 * @创建时间: 2018-01-22 14:52
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
//@Configuration
public class MycatConfiguration {
    
    private final Logger logger = LoggerFactory.getLogger(MycatConfiguration.class);
    
    private DataSource dataSource;
    private Environment env;
    
    public MycatConfiguration(DataSource dataSource,Environment env) {
        this.dataSource = dataSource;
        this.env = env;
        setValidationQuery();
    }
    
    public void setValidationQuery() {
        String validationQuery = this.env.getProperty("spring.datasource.validation-query");
        if (validationQuery == null) {
            logger.error("properties-config:[spring.datasource.validation-query] invalid");
            return;
        }
        
        if (this.dataSource instanceof HikariDataSource) {
            HikariDataSource dataSource = (HikariDataSource)this.dataSource;
            dataSource.setConnectionTestQuery(validationQuery);
        }
    }
    
}
