package cn.com.yusys.yusp.uimp.base.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunPageCfg
 * @类描述: ADMIN_BASE_META_FUN_PAGE_CFG数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-23 15:43:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@ApiModel(value = "AdminBaseMetaFunPageCfg", description = "业务功能配置信息")
@Table(name = "ADMIN_BASE_META_FUN_PAGE_CFG")
public class AdminBaseMetaFunPageCfg extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "主键", name = "id", required = false)
	private String id;

	/** 业务标识码 **/
	@Column(name = "FUN_CODE", unique = false, nullable = false, length = 255)
	@ApiModelProperty(value = "业务标识码", name = "funCode", required = true)
	private String funCode;
	
	/** 配置项名称 **/
	@Column(name = "CONFIG_NAME", unique = false, nullable = false, length = 255)
	@ApiModelProperty(value = "配置项名称", name = "configName", required = true)
	private String configName;
	
	/** 配置项值 **/
	@Column(name = "CONFIG_VALUE", unique = false, nullable = false, length = 255)
	@ApiModelProperty(value = "配置项值", name = "configValue", required = true)
	private String configValue;
	
	
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
	 * @param funCode
	 */
	public void setFunCode(String funCode) {
		this.funCode = funCode == null ? null : funCode.trim();
	}
	
    /**
     * @return FunCode
     */	
	public String getFunCode() {
		return this.funCode;
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


}