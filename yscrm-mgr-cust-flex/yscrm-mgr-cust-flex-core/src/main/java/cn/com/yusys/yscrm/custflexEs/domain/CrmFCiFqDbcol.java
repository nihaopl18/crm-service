package cn.com.yusys.yscrm.custflexEs.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmFCiFqDbcol
 * @类描述: CRM_F_CI_FQ_DBCOL数据集-属性表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-29 11:27:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "CRM_F_CI_FQ_DBCOL")
public class CrmFCiFqDbcol extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private java.math.BigDecimal id;

	/** 英文名称 **/
	@Column(name = "COL_NAME_E", unique = false, nullable = true, length = 250)
	private String colNameE;
	
	/** 中文名称 **/
	@Column(name = "COL_NAME_C", unique = false, nullable = true, length = 250)
	private String colNameC;
	
	/** 字段长度 **/
	@Column(name = "COL_SIZE", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal colSize;
	
	/** 字段类型 **/
	@Column(name = "COL_TYPE", unique = false, nullable = true, length = 30)
	private String colType;
	
	/** 默认值 **/
	@Column(name = "DEFAULT_VALUE", unique = false, nullable = true, length = 20)
	private String defaultValue;
	
	/** 是否为空 **/
	@Column(name = "IS_NULL", unique = false, nullable = true, length = 30)
	private String isNull;
	
	/** 是否主键 **/
	@Column(name = "PRIMARY_KEY_FLAG", unique = false, nullable = true, length = 30)
	private String primaryKeyFlag;
	
	/** 关联表id **/
	@Column(name = "DBTABLE_ID", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal dbtableId;
	
	/** 数据字典KEY **/
	@Column(name = "NOTES", unique = false, nullable = true, length = 250)
	private String notes;
	
	/** 是否用参数 **/
	@Column(name = "IS_ENABLE", unique = false, nullable = true, length = 30)
	private String isEnable;
	
	/** 排序字段列 **/
	@Column(name = "COL_SORT", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal colSort;
	
	/** 来源表 **/
	@Column(name = "DBTABLE_NAME", unique = false, nullable = true, length = 4000)
	private String dbtableName;
	
	/** 分组ID **/
	@Column(name = "GROUP_ID", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal groupId;
	
	/** 字段类型[文本框、下拉框等 ，数据字典定义] **/
	@Column(name = "FIELD_TYPE", unique = false, nullable = true, length = 4000)
	private String fieldType;
	
	/** 下拉框选项[如果字段是下拉框类型，其下拉选项引用数据字典(名称)] **/
	@Column(name = "F_NAME", unique = false, nullable = true, length = 4000)
	private String fName;
	
	/** 对象id用户对象初始化字段 **/
	@Column(name = "OBJ_ID", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal objId;
	
	/** 字段别名 **/
	@Column(name = "ALIAS", unique = false, nullable = true, length = 250)
	private String alias;
	
	/** NO_SENSI **/
	@Column(name = "NO_SENSI", unique = false, nullable = true, length = 2)
	private String noSensi;
	
	
	/**
	 * @param id
	 */
	public void setId(java.math.BigDecimal id) {
		this.id = id;
	}
	
    /**
     * @return Id
     */	
	public java.math.BigDecimal getId() {
		return this.id;
	}
	
	/**
	 * @param colNameE
	 */
	public void setColNameE(String colNameE) {
		this.colNameE = colNameE == null ? null : colNameE.trim();
	}
	
    /**
     * @return ColNameE
     */	
	public String getColNameE() {
		return this.colNameE;
	}
	
	/**
	 * @param colNameC
	 */
	public void setColNameC(String colNameC) {
		this.colNameC = colNameC == null ? null : colNameC.trim();
	}
	
    /**
     * @return ColNameC
     */	
	public String getColNameC() {
		return this.colNameC;
	}
	
	/**
	 * @param colSize
	 */
	public void setColSize(java.math.BigDecimal colSize) {
		this.colSize = colSize;
	}
	
    /**
     * @return ColSize
     */	
	public java.math.BigDecimal getColSize() {
		return this.colSize;
	}
	
	/**
	 * @param colType
	 */
	public void setColType(String colType) {
		this.colType = colType == null ? null : colType.trim();
	}
	
    /**
     * @return ColType
     */	
	public String getColType() {
		return this.colType;
	}
	
	/**
	 * @param defaultValue
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue == null ? null : defaultValue.trim();
	}
	
    /**
     * @return DefaultValue
     */	
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	/**
	 * @param isNull
	 */
	public void setIsNull(String isNull) {
		this.isNull = isNull == null ? null : isNull.trim();
	}
	
    /**
     * @return IsNull
     */	
	public String getIsNull() {
		return this.isNull;
	}
	
	/**
	 * @param primaryKeyFlag
	 */
	public void setPrimaryKeyFlag(String primaryKeyFlag) {
		this.primaryKeyFlag = primaryKeyFlag == null ? null : primaryKeyFlag.trim();
	}
	
    /**
     * @return PrimaryKeyFlag
     */	
	public String getPrimaryKeyFlag() {
		return this.primaryKeyFlag;
	}
	
	/**
	 * @param dbtableId
	 */
	public void setDbtableId(java.math.BigDecimal dbtableId) {
		this.dbtableId = dbtableId;
	}
	
    /**
     * @return DbtableId
     */	
	public java.math.BigDecimal getDbtableId() {
		return this.dbtableId;
	}
	
	/**
	 * @param notes
	 */
	public void setNotes(String notes) {
		this.notes = notes == null ? null : notes.trim();
	}
	
    /**
     * @return Notes
     */	
	public String getNotes() {
		return this.notes;
	}
	
	/**
	 * @param isEnable
	 */
	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable == null ? null : isEnable.trim();
	}
	
    /**
     * @return IsEnable
     */	
	public String getIsEnable() {
		return this.isEnable;
	}
	
	/**
	 * @param colSort
	 */
	public void setColSort(java.math.BigDecimal colSort) {
		this.colSort = colSort;
	}
	
    /**
     * @return ColSort
     */	
	public java.math.BigDecimal getColSort() {
		return this.colSort;
	}
	
	/**
	 * @param dbtableName
	 */
	public void setDbtableName(String dbtableName) {
		this.dbtableName = dbtableName == null ? null : dbtableName.trim();
	}
	
    /**
     * @return DbtableName
     */	
	public String getDbtableName() {
		return this.dbtableName;
	}
	
	/**
	 * @param groupId
	 */
	public void setGroupId(java.math.BigDecimal groupId) {
		this.groupId = groupId;
	}
	
    /**
     * @return GroupId
     */	
	public java.math.BigDecimal getGroupId() {
		return this.groupId;
	}
	
	/**
	 * @param fieldType
	 */
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType == null ? null : fieldType.trim();
	}
	
    /**
     * @return FieldType
     */	
	public String getFieldType() {
		return this.fieldType;
	}
	
	/**
	 * @param fName
	 */
	public void setFName(String fName) {
		this.fName = fName == null ? null : fName.trim();
	}
	
    /**
     * @return FName
     */	
	public String getFName() {
		return this.fName;
	}
	
	/**
	 * @param objId
	 */
	public void setObjId(java.math.BigDecimal objId) {
		this.objId = objId;
	}
	
    /**
     * @return ObjId
     */	
	public java.math.BigDecimal getObjId() {
		return this.objId;
	}
	
	/**
	 * @param alias
	 */
	public void setAlias(String alias) {
		this.alias = alias == null ? null : alias.trim();
	}
	
    /**
     * @return Alias
     */	
	public String getAlias() {
		return this.alias;
	}
	
	/**
	 * @param noSensi
	 */
	public void setNoSensi(String noSensi) {
		this.noSensi = noSensi == null ? null : noSensi.trim();
	}
	
    /**
     * @return NoSensi
     */	
	public String getNoSensi() {
		return this.noSensi;
	}


}