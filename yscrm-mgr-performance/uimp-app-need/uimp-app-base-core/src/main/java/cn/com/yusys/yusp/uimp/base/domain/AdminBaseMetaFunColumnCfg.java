package cn.com.yusys.yusp.uimp.base.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunColumnCfg
 * @类描述: ADMIN_BASE_META_FUN_COLUMN_CFG数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-31 15:14:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_BASE_META_FUN_COLUMN_CFG")
public class AdminBaseMetaFunColumnCfg extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 字段编码 **/
	@Column(name = "CONFIG_NAME", unique = false, nullable = true, length = 255)
	private String configName;
	
	/** 配置项名称 **/
	@Column(name = "CONFIG_VALUE", unique = false, nullable = true, length = 255)
	private String configValue;
	
	/** 配置项值 **/
	@Column(name = "COLUMN_CODE", unique = false, nullable = true, length = 255)
	private String columnCode;
	
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}
	
	/**
	 * @param configName
	 */
	public void setConfigName(String configName) {
		this.configName = configName == null ? null : configName.trim();
	}
	
    /**
     * @return ConfigName
     */	
	public String getConfigName() {
		return this.configName;
	}
	
	/**
	 * @param configValue
	 */
	public void setConfigValue(String configValue) {
		this.configValue = configValue == null ? null : configValue.trim();
	}
	
    /**
     * @return ConfigValue
     */	
	public String getConfigValue() {
		return this.configValue;
	}
	
	/**
	 * @param columnCode
	 */
	public void setColumnCode(String columnCode) {
		this.columnCode = columnCode == null ? null : columnCode.trim();
	}
	
    /**
     * @return ColumnCode
     */	
	public String getColumnCode() {
		return this.columnCode;
	}


}