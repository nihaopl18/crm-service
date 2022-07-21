/*
 * 代码生成器自动生成的
 * Since 2008 - 2020
 *
 */
package cn.com.yusys.yscrm.custflexEs.domain;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustGroupRelInfo
 * @类描述: CRM_CUST_GROUP_REL_INFO客户群成员信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-08 15:12:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Table(name = "CRM_CUST_GROUP_REL_INFO")
public class CrmCustGroupRelInfo extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
	
	/** 客户群编号 **/
	@Column(name = "GROUP_ID", unique = false, nullable = true, length = 32)
	private String groupId;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;
	
	/** 加入时间 **/
	@Column(name = "JOIN_DATE", unique = false, nullable = true, length = 7)
	private Date joinDate;
	
	
	/**
	 * @param groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	
    /**
     * @return groupId
     */
	public String getGroupId() {
		return this.groupId;
	}
	
	/**
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
    /**
     * @return custId
     */
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param joinDate
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
    /**
     * @return joinDate
     */
	public Date getJoinDate() {
		return this.joinDate;
	}


}