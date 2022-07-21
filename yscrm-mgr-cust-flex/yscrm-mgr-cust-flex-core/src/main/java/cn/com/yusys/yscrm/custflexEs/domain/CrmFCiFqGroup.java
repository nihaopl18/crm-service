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
 * @类名称: CrmFCiFqGroup
 * @类描述: CRM_F_CI_FQ_GROUP数据集—分组 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-29 11:26:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "CRM_F_CI_FQ_GROUP")
public class CrmFCiFqGroup extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private java.math.BigDecimal id;

	/** 对象主键 **/
	@Column(name = "OBJ_ID", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal objId;
	
	/** 分组名 **/
	@Column(name = "GROUP_NAME", unique = false, nullable = true, length = 30)
	private String groupName;
	
	/** 父节点 **/
	@Column(name = "PARENT_ID", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal parentId;
	
	/** 序号 **/
	@Column(name = "SORT", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal sort;
	
	
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
	 * @param groupName
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName == null ? null : groupName.trim();
	}
	
    /**
     * @return GroupName
     */	
	public String getGroupName() {
		return this.groupName;
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
	 * @param sort
	 */
	public void setSort(java.math.BigDecimal sort) {
		this.sort = sort;
	}
	
    /**
     * @return Sort
     */	
	public java.math.BigDecimal getSort() {
		return this.sort;
	}


}