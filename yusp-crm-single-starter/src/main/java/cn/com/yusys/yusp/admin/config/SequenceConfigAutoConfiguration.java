package cn.com.yusys.yusp.admin.config;

import java.util.List;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.com.yusys.yusp.sequence.cache.CacheTemplate;
import cn.com.yusys.yusp.sequence.exception.SequenceConfigException;
import cn.com.yusys.yusp.sequence.handler.DB2SequenceHandler;
import cn.com.yusys.yusp.sequence.handler.MySQLSequenceHandler;
import cn.com.yusys.yusp.sequence.handler.OracleSequenceHandler;
import cn.com.yusys.yusp.sequence.handler.RedisSequenceHandler;
import cn.com.yusys.yusp.sequence.handler.SequenceHandler;
import cn.com.yusys.yusp.sequence.handler.SequenceHandlerFactory;
import cn.com.yusys.yusp.sequence.handler.SqlServerSequenceHandler;

/**
 * 
 * @项目名称:yusp-sequence
 * @类名称:SequenceConfigAutoConfiguration
 * @类描述: 序列模版配置自动配置
 * @功能描述:
 * @创建人:wangyang13@yusys.com.cn
 * @创建时间:2018-01-12
 * @修改备注:
 * @修改日期        修改人员        修改原因
 * --------    --------     ----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Configuration
@ConditionalOnProperty(name = "emp.seqconfig.enabled", matchIfMissing = true)
@EnableConfigurationProperties(SequenceConfigProperties.class) 
public class SequenceConfigAutoConfiguration {

	public SequenceConfigAutoConfiguration() {
		//this.properties = properties;
	}

	/**
	 * 
	 * <p>
	 * <h2>简述</h2>
	 * 		<ol>数据库类型序列配置</ol>
	 * <h2>功能描述</h2>
	 * 		<ol>无</ol>
	 * <h2>修改历史</h2>
	 *    <ol>无</ol>
	 * </p>
	 * @author WangYang
	 * @2017年12月12日
	 * @version 1.0
	 */
	@Configuration
	public class SeqConfigDBHandlerConfiguration {
		@Bean
		public SequenceHandler db2SequenceHandler(JdbcTemplate jdbcTemplate) {
			return new DB2SequenceHandler(jdbcTemplate);
		}

		@Bean
		public SequenceHandler mySQLSequenceHandler(JdbcTemplate jdbcTemplate) {
			return new MySQLSequenceHandler(jdbcTemplate);
		}

		@Bean
		public SequenceHandler oracleSequenceHandler(JdbcTemplate jdbcTemplate) {
			return new OracleSequenceHandler(jdbcTemplate);
		}

		@Bean
		public SequenceHandler sqlServerSequenceHandler(JdbcTemplate jdbcTemplate) {
			return new SqlServerSequenceHandler(jdbcTemplate);
		}
	}

	/**
	 * 
	 * <p>
	 * <h2>简述</h2>
	 * 		<ol>Redis序列配置</ol>
	 * <h2>功能描述</h2>
	 * 		<ol>无</ol>
	 * <h2>修改历史</h2>
	 *    <ol>无</ol>
	 * </p>
	 * @author WangYang
	 * @2017年12月12日
	 * @version 1.0
	 */
	@Configuration
	public class SeqConfigRedisHandlerConfiguration {
		@Bean
		public SequenceHandler redisSequenceHandler(StringRedisTemplate stringRedisTemplate) {
			return new RedisSequenceHandler(stringRedisTemplate);
		}
	}

	@Configuration
	public class SequenceHandlerFactoryonfiguration {
		@Bean
		@ConditionalOnMissingBean
		public SequenceHandlerFactory sequenceHandlerFactory(SequenceConfigProperties properties,List<SequenceHandler> sequenceHandlers) throws SequenceConfigException {
			return new SequenceHandlerFactory(properties.getDefaultSeqType(), sequenceHandlers);
		}

	}
	
	@Bean
	public CacheTemplate cacheTemplate(StringRedisTemplate stringRedisTemplate) {
		return new CacheTemplate(stringRedisTemplate);
	}
}
