package cn.com.yusys.yscrm.custflexEs.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmCustGroupInfo
 * @类描述: CRM_CUST_GROUP_INFO客户群信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-08 11:13:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "CRM_CUST_GROUP_INFO")
public class CrmCustGroupInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户群编号 **/
	@Id
//	@Generated(GenerationType.UUID)
	@Column(name = "GROUP_ID")
	private String groupId;

	/** 客户群名称 **/
	@Column(name = "GROUP_NAME", unique = false, nullable = true, length = 60)
	private String groupName;
	
	/** 客户群分类 **/
	@Column(name = "GROUP_CLASS", unique = false, nullable = true, length = 10)
	private String groupClass;
	
	/** 共享类型 **/
	@Column(name = "GROUP_SHARE_TYPE", unique = false, nullable = true, length = 10)
	private String groupShareType;
	
	/** 是否进群审批 **/
	@Column(name = "IF_APPRROVE", unique = false, nullable = true, length = 10)
	private String ifApprrove;
	
	/** 群备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 1000)
	private String remark;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DT", unique = false, nullable = true, length = 7)
	private Date createDt;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 32)
	private String createUser;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 32)
	private String createOrg;
	
	/** 活动引入终止日期 **/
	@Column(name = "ACTIVITY_EXPIRY_DATE", unique = false, nullable = true, length = 7)
	private Date activityExpiryDate;
	
	/** SQL **/
	@Column(name = "SQL", unique = false, nullable = true, length = 2000)
	private String sql;
	
	/** 方案ID **/
	@Column(name = "SSID", unique = false, nullable = true, length = 32)
	private String ssid;
	
	
	/**
	 * @param groupId
	 */
	public void setGroupId(String groupId) {
		this.groupId = groupId == null ? null : groupId.trim();
	}
	
    /**
     * @return GroupId
     */	
	public String getGroupId() {
		return this.groupId;
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
	 * @param groupClass
	 */
	public void setGroupClass(String groupClass) {
		this.groupClass = groupClass == null ? null : groupClass.trim();
	}
	
    /**
     * @return GroupClass
     */	
	public String getGroupClass() {
		return this.groupClass;
	}
	
	/**
	 * @param groupShareType
	 */
	public void setGroupShareType(String groupShareType) {
		this.groupShareType = groupShareType == null ? null : groupShareType.trim();
	}
	
    /**
     * @return GroupShareType
     */	
	public String getGroupShareType() {
		return this.groupShareType;
	}
	
	/**
	 * @param ifApprrove
	 */
	public void setIfApprrove(String ifApprrove) {
		this.ifApprrove = ifApprrove == null ? null : ifApprrove.trim();
	}
	
    /**
     * @return IfApprrove
     */	
	public String getIfApprrove() {
		return this.ifApprrove;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * @param createDt
	 */
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
    /**
     * @return CreateDt
     */	
	public Date getCreateDt() {
		return this.createDt;
	}
	
	/**
	 * @param createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}
	
    /**
     * @return CreateUser
     */	
	public String getCreateUser() {
		return this.createUser;
	}
	
	/**
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
	}
	
	/**
	 * @param activityExpiryDate
	 */
	public void setActivityExpiryDate(Date activityExpiryDate) {
		this.activityExpiryDate = activityExpiryDate;
	}
	
    /**
     * @return ActivityExpiryDate
     */	
	public Date getActivityExpiryDate() {
		return this.activityExpiryDate;
	}
	
	/**
	 * @param sql
	 */
	public void setSql(String sql) {
		this.sql = sql == null ? null : sql.trim();
	}
	
    /**
     * @return Sql
     */	
	public String getSql() {
		return this.sql;
	}
	
	/**
	 * @param ssid
	 */
	public void setSsid(String ssid) {
		this.ssid = ssid == null ? null : ssid.trim();
	}
	
    /**
     * @return Ssid
     */	
	public String getSsid() {
		return this.ssid;
	}


}