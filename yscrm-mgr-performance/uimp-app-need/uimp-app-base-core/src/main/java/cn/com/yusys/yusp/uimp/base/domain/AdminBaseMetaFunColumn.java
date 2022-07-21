package cn.com.yusys.yusp.uimp.base.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunColumn
 * @类描述: ADMIN_BASE_META_FUN_COLUMN数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-27 15:10:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_BASE_META_FUN_COLUMN")
public class AdminBaseMetaFunColumn extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 业务模型编码 **/
	@Column(name = "TABLE_CODE", unique = false, nullable = false, length = 255)
	private String tableCode;
	
	/** 字段含义 **/
	@Column(name = "COLUMN_CN_NAME", unique = false, nullable = false, length = 255)
	private String columnCnName;
	
	/** 字段名 **/
	@Column(name = "COLUMN_NAME", unique = false, nullable = false, length = 255)
	private String columnName;
	
	/** 字段类型 **/
	@Column(name = "COLUMN_TYPE", unique = false, nullable = false, length = 255)
	private String columnType;
	
	/** 字段长度 **/
	@Column(name = "COLUMN_LENGTH", unique = false, nullable = false, length = 0)
	private Integer columnLength;
	
	/** 字段编码 **/
	@Column(name = "COLUMN_CODE", unique = false, nullable = false, length = 255)
	private String columnCode;
	
	/** 字段排序 **/
	@Column(name = "SORT", unique = false, nullable = true, length = 0)
	private Integer sort;
	
	@Transient
	private String isPk;
	
	@Transient
	private String isOrg;
	
	@Transient
	private String isAmt;
	
	public AdminBaseMetaFunColumn() {
		
	}
	
	/**
	 * @param columnCnName 字段含义
	 * @param columnName 字段名称
	 * @param columnType 字段类型
	 * @param columnLength 字段长度
	 * @param tableCode 模型编码
	 * @param columnCode 字段编码
	 * @param sort 字段排序
	 */
	public AdminBaseMetaFunColumn(String columnCnName, String columnName,
			String columnType, Integer columnLength, String tableCode,
			String columnCode,Integer sort) {
		this.columnCnName = columnCnName;
		this.columnName = columnName;
		this.columnType = columnType;
		this.columnLength = columnLength;
		this.tableCode = tableCode;
		this.columnCode = columnCode;
		this.sort = sort;
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
	
	/**
	 * @param tableCode
	 */
	public void setTableCode(String tableCode) {
		this.tableCode = tableCode == null ? null : tableCode.trim();
	}
	
    /**
     * @return TableCode
     */	
	public String getTableCode() {
		return this.tableCode;
	}
	
	/**
	 * @param columnCnName
	 */
	public void setColumnCnName(String columnCnName) {
		this.columnCnName = columnCnName == null ? null : columnCnName.trim();
	}
	
    /**
     * @return ColumnCnName
     */	
	public String getColumnCnName() {
		return this.columnCnName;
	}
	
	/**
	 * @param columnName
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName == null ? null : columnName.trim();
	}
	
    /**
     * @return ColumnName
     */	
	public String getColumnName() {
		return this.columnName;
	}
	
	/**
	 * @param columnType
	 */
	public void setColumnType(String columnType) {
		this.columnType = columnType == null ? null : columnType.trim();
	}
	
    /**
     * @return ColumnType
     */	
	public String getColumnType() {
		return this.columnType;
	}
	
	/**
	 * @param columnLength
	 */
	public void setColumnLength(Integer columnLength) {
		this.columnLength = columnLength;
	}
	
    /**
     * @return ColumnLength
     */	
	public Integer getColumnLength() {
		return this.columnLength;
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
	
	/**
	 * @param sort
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
    /**
     * @return Sort
     */	
	public Integer getSort() {
		return this.sort;
	}


	public String getIsPk() {
		return isPk;
	}


	public void setIsPk(String isPk) {
		this.isPk = isPk;
	}


	public String getIsOrg() {
		return isOrg;
	}


	public void setIsOrg(String isOrg) {
		this.isOrg = isOrg;
	}


	public String getIsAmt() {
		return isAmt;
	}


	public void setIsAmt(String isAmt) {
		this.isAmt = isAmt;
	}


}