package cn.com.yusys.yscrm.custflexEs.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmFCiFqObj
 * @类描述: CRM_F_CI_FQ_OBJ数据集—对象 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-29 11:24:16
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "CRM_F_CI_FQ_OBJ")
public class CrmFCiFqObj extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private java.math.BigDecimal id;

	/** 表名 **/
	@Column(name = "OBJ_NAME", unique = false, nullable = true, length = 30)
	private String objName;
	
	/** 父节点 **/
	@Column(name = "TABLE_NAME", unique = false, nullable = true, length = 100)
	private String tableName;
	
	/** 对象名称 **/
	@Column(name = "PARENT_ID", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal parentId;
	
	/** 表别名 **/
	@Column(name = "ALIAS", unique = false, nullable = true, length = 50)
	private String alias;
	
	/** 1零售,2对公 **/
	@Column(name = "TYPE", unique = false, nullable = true, length = 1)
	private String type;
	
	
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
	 * @param objName
	 */
	public void setObjName(String objName) {
		this.objName = objName == null ? null : objName.trim();
	}
	
    /**
     * @return ObjName
     */	
	public String getObjName() {
		return this.objName;
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
	 * @param parentId
	 */
	public void setParentId(java.math.BigDecimal parentId) {
		this.parentId = parentId;
	}
	
    /**
     * @return ParentId
     */	
	public java.math.BigDecimal getParentId() {
		return this.parentId;
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
	 * @param type
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}
	
    /**
     * @return Type
     */	
	public String getType() {
		return this.type;
	}


}