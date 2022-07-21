package cn.com.yusys.yusp.admin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 
 * @项目名称:yusp-sequence
 * @类名称:SequenceConfigProperties
 * @类描述: 序列号模版配置的自定义配置
 * @功能描述:
 * @创建人:wangyang13@yusys.com.cn
 * @创建时间:2018-01-12
 * @修改备注:
 * @修改日期        修改人员        修改原因
 * --------    --------     ----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@ConfigurationProperties(prefix = "emp.seqconfig")
public class SequenceConfigProperties {
	/**
	 * 是否启用
	 */
	private boolean enabled;

	/**
	 * 默认序列模版类型 mysql db2 oracle sqlserver redis
	 */
	private String defaultSeqType;

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getDefaultSeqType() {
		return defaultSeqType;
	}

	public void setDefaultSeqType(String defaultSeqType) {
		this.defaultSeqType = defaultSeqType;
	}

}
