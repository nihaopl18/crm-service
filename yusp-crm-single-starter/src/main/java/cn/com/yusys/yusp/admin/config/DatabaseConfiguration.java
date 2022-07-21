package cn.com.yusys.yusp.admin.config;


import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@MapperScan(basePackages= {"cn.com.yusys.yusp.admin.repository.mapper","cn.com.yusys.yusp.admin.job.dao",
		"cn.com.yusys.yusp.uaa.repository.mapper","cn.com.yusys.yusp.message.repository.mapper", "cn.com.yusys.yusp.dataauth.repository.mapper",
		"cn.com.yusys.yusp.sequence.repository.mapper","cn.com.yusys.yscrm.salesoppor.repository.mapper","cn.com.yusys.yusp.echain.server.repository.mapper",
		"cn.com.yusys.yscrm.custflex.repository.mapper","cn.com.yusys.yscrm.custpub.repository.mapper","cn.com.yusys.yscrm.homepage.repository.mapper",
		"cn.com.yusys.yscrm.mktactivity.repository.mapper","cn.com.yusys.yscrm.sysview.repository.mapper","cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper","cn.com.yusys.yscrm.custmgr.repository.mapper",
		"cn.com.yusys.yscrm.custgrade.repository.mapper","cn.com.yusys.yscrm.infocalculator.repository.mapper",
		"cn.com.yusys.yscrm.product.repository.mapper","cn.com.yusys.yscrm.custmgrgroup.repository.mapper",
		"cn.com.yusys.yscrm.info.custlosswarn.repository.mapper","cn.com.yusys.yscrm.info.workreport.repository.mapper",
		"cn.com.yusys.yscrm.knowledge.repository.mapper","cn.com.yusys.yscrm.user.schedule.repository.mapper",
		"cn.com.yusys.yscrm.info.remind.repository.mapper","cn.com.yusys.yscrm.exchange.repository.mapper","cn.com.yusys.yscrm.pcrm.common.remindInfo.repository.mapper",
		"cn.com.yusys.yscrm.cust.org.repository.mapper","cn.com.yusys.yscrm.cust.person.repository.mapper","cn.com.yusys.yscrm.cust.group.repository.mapper",
		"cn.com.yusys.yscrm.custservice.repository.mapper","cn.com.yusys.yscrm.entity.cust.org.group.repository.mapper","cn.com.yusys.yusp.dycrm.todowork.repository.mapper","cn.com.yusys.yusp.dycrm.transferInfo.repository.mapper","cn.com.yusys.yusp.dycrm.userAcct.repository.mapper",
		"cn.com.yusys.yusp.uimp.**.repository.mapper","cn.com.yusys.yusp.flow.repository.mapper"})
	public class DatabaseConfiguration {

	    private final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);

	    private final Environment env;

	    public DatabaseConfiguration(Environment env) {
	        this.env = env;
	    }

	    @Bean
	    public DatabaseIdProvider getDatabaseIdProvider(){
	        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
	        Properties properties = new Properties();
	        properties.setProperty("Oracle","oracle");
	        properties.setProperty("MySQL","mysql");
			properties.setProperty("DB2","DB2");
	        databaseIdProvider.setProperties(properties);
	        log.debug("数据源配置完成...");
	        return databaseIdProvider;
	    }
	}

