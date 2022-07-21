package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexCondition
 * @类描述: PMA_F_BASE_INDEX_CONDITION数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-07 11:29:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFBaseIndexCondition", description = "基础指标条件")
@Entity
@Table(name = "PMA_F_BASE_INDEX_CONDITION")
public class PmaFBaseIndexCondition extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 逻辑主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "主键", name = "id", required = false)
	private String id;

	/** 指标号 **/
	@ApiModelProperty(value = "指标号", name = "indexId", required = false)
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 20)
	private String indexId;
	
	/** 条件类型1码值，2值域，3自定义 **/
	@ApiModelProperty(value = "条件类型", name = "conditionType", required = false)
	@Column(name = "CONDITION_TYPE", unique = false, nullable = true, length = 2)
	private String conditionType;
	
	/** 条件字段  **/
	@ApiModelProperty(value = "条件字段", name = "conditionColumn", required = false)
	@Column(name = "CONDITION_COLUMN", unique = false, nullable = true, length = 200)
	private String conditionColumn;
	
	/** 条件值 **/
	@ApiModelProperty(value = "条件值", name = "conditionValue", required = false)
	@Column(name = "CONDITION_VALUE", unique = false, nullable = true, length = 200)
	private String conditionValue;
	
	/** 条件值(码值反显) **/
	@ApiModelProperty(value = "条件值", name = "conditionRawValue", required = false)
	@Column(name = "CONDITION_RAW_VALUE", unique = false, nullable = true, length = 200)
	private String conditionRawValue;
	
	
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
	 * @param indexId
	 */
	public void setIndexId(String indexId) {
		this.indexId = indexId == null ? null : indexId.trim();
	}
	
    /**
     * @return IndexId
     */	
	public String getIndexId() {
		return this.indexId;
	}
	
	/**
	 * @param conditionType
	 */
	public void setConditionType(String conditionType) {
		this.conditionType = conditionType == null ? null : conditionType.trim();
	}
	
    /**
     * @return ConditionType
     */	
	public String getConditionType() {
		return this.conditionType;
	}
	
	/**
	 * @param conditionColumn
	 */
	public void setConditionColumn(String conditionColumn) {
		this.conditionColumn = conditionColumn == null ? null : conditionColumn.trim();
	}
	
    /**
     * @return ConditionColumn
     */	
	public String getConditionColumn() {
		return this.conditionColumn;
	}
	
	/**
	 * @param conditionValue
	 */
	public void setConditionValue(String conditionValue) {
		this.conditionValue = conditionValue == null ? null : conditionValue.trim();
	}
	
    /**
     * @return ConditionValue
     */	
	public String getConditionValue() {
		return this.conditionValue;
	}
	
	/**
	 * @param conditionRawValue
	 */
	public void setConditionRawValue(String conditionRawValue) {
		this.conditionRawValue = conditionRawValue == null ? null : conditionRawValue.trim();
	}
	
    /**
     * @return ConditionRawValue
     */	
	public String getConditionRawValue() {
		return this.conditionRawValue;
	}


}