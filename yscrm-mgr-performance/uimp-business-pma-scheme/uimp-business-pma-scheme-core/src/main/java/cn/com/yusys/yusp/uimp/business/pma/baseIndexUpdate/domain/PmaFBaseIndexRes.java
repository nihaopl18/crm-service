package cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexRes
 * @类描述: PMA_F_BASE_INDEX_RES数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-06 10:46:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFBaseIndexRes", description = "基础指标调整")
@Entity
@Table(name = "PMA_F_BASE_INDEX_RES")
public class PmaFBaseIndexRes extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@ApiModelProperty(value = "主键", name = "id", required = false)
	@Column(name = "ID")
	private String id;

	/** 指标编号 **/
	@Column(name = "INDEX_ID", unique = false, nullable = false, length = 20)
	@ApiModelProperty(value = "指标编号", name = "indexId", required = false)
	private String indexId;
	
	/** 考核对象ID **/
	@Column(name = "EVL_OBJ_ID", unique = false, nullable = false, length = 50)
	@ApiModelProperty(value = "考核对象ID", name = "evlObjId", required = false)
	private String evlObjId;
	
	/** 余额类型 **/
	@Column(name = "BAL_TYPE", unique = false, nullable = false, length = 4)
	@ApiModelProperty(value = "余额类型", name = "balType", required = false)
	private String balType;
	
	/** 数据日期 **/
	@Column(name = "ETL_DATE", unique = false, nullable = false, length = 8)
	@ApiModelProperty(value = "数据日期", name = "etlDate", required = false)
	private String etlDate;
	
	/** 指标值 **/
	@Column(name = "INDEX_VALUE", unique = false, nullable = true, length = 0)
	@ApiModelProperty(value = "指标值", name = "indexValue", required = false)
	private java.math.BigDecimal indexValue;
	
	/** 原始指标值 **/
	@Column(name = "OLD_INDEX_VALUE", unique = false, nullable = true, length = 0)
	@ApiModelProperty(value = "原始指标值 ", name = "oldIndexValue", required = false)
	private java.math.BigDecimal oldIndexValue;
	
	/** 考核对象类型 **/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = false, length = 4)
	@ApiModelProperty(value = "考核对象类型", name = "evlObjType", required = false)
	private String evlObjType;
	
	/** 应用类型 **/
	@Column(name = "APPLY_TYPE", unique = false, nullable = false, length = 4)
	@ApiModelProperty(value = "应用类型", name = "applyType", required = false)
	private String applyType;
	
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
	 * @param evlObjId
	 */
	public void setEvlObjId(String evlObjId) {
		this.evlObjId = evlObjId == null ? null : evlObjId.trim();
	}
	
    /**
     * @return EvlObjId
     */	
	public String getEvlObjId() {
		return this.evlObjId;
	}
	
	/**
	 * @param balTypeId
	 */
	public void setBalType(String balType) {
		this.balType = balType == null ? null : balType.trim();
	}
	
    /**
     * @return BalTypeId
     */	
	public String getBalType() {
		return this.balType;
	}
	
	/**
	 * @param statDate
	 */
	public void setEtlDate(String etlDate) {
		this.etlDate = etlDate == null ? null : etlDate.trim();
	}
	
    /**
     * @return StatDate
     */	
	public String getEtlDate() {
		return this.etlDate;
	}
	
	/**
	 * @param indexValue
	 */
	public void setIndexValue(java.math.BigDecimal indexValue) {
		this.indexValue = indexValue;
	}
	
    /**
     * @return IndexValue
     */	
	public java.math.BigDecimal getIndexValue() {
		return this.indexValue;
	}
	
	/**
	 * @param indexValueF
	 */
	public void setOldIndexValue(java.math.BigDecimal oldIndexValue) {
		this.oldIndexValue = oldIndexValue;
	}
	
    /**
     * @return IndexValueF
     */	
	public java.math.BigDecimal getOldIndexValue() {
		return this.oldIndexValue;
	}
	
	/**
	 * @param evlObjType
	 */
	public void setEvlObjType(String evlObjType) {
		this.evlObjType = evlObjType == null ? null : evlObjType.trim();
	}
	
    /**
     * @return EvlObjType
     */	
	public String getEvlObjType() {
		return this.evlObjType;
	}
	
	/**
	 * @param applyTypeId
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType == null ? null : applyType.trim();
	}
	
    /**
     * @return ApplyTypeId
     */	
	public String getApplyType() {
		return this.applyType;
	}
	
	
	
	
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


}