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
 * @类名称: AdminBaseMetaFunTable
 * @类描述: ADMIN_BASE_META_FUN_TABLE数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-25 10:54:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_BASE_META_FUN_TABLE")
public class AdminBaseMetaFunTable extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 业务标识码 **/
	@Column(name = "FUN_CODE", unique = false, nullable = false, length = 255)
	private String funCode;
	
	/** 物理表名 **/
	@Column(name = "TABLE_NAME", unique = false, nullable = false, length = 255)
	private String tableName;
	
	/** 业务模型名称 **/
	@Column(name = "TABLE_CN_NAME", unique = false, nullable = false, length = 255)
	private String tableCnName;
	
	/** 业务模型编码 **/
	@Column(name = "TABLE_CODE", unique = false, nullable = false, length = 255)
	private String tableCode;
	
	/** 业务子类型 **/
	@Column(name = "FUN_SUB_TYPE", unique = false, nullable = false, length = 255)
	private String funSubType;
	
	
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
	 * @param tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName == null ? null : tableName.trim();
	}
	
    /**
     * @return TableName
     */	
	public String getTableName() {
		return this.tableName;
	}
	
	/**
	 * @param tableCnName
	 */
	public void setTableCnName(String tableCnName) {
		this.tableCnName = tableCnName == null ? null : tableCnName.trim();
	}
	
    /**
     * @return TableCnName
     */	
	public String getTableCnName() {
		return this.tableCnName;
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
	 * @param funSubType
	 */
	public void setFunSubType(String funSubType) {
		this.funSubType = funSubType == null ? null : funSubType.trim();
	}
	
    /**
     * @return FunSubType
     */	
	public String getFunSubType() {
		return this.funSubType;
	}


}