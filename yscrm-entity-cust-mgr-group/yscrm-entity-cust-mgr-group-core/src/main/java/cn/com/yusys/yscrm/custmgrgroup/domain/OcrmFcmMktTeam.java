package cn.com.yusys.yscrm.custmgrgroup.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-mgr-group-core模块
 * @类名称: OcrmFcmMktTeam
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-13 15:18:47
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CM_MKT_TEAM")
public class OcrmFcmMktTeam extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户经理团队编号 **/
	@Id
	@Column(name = "MKT_TEAM_ID")
	@Generated(GenerationType.UUID)
	private String mktTeamId;
	
	/** 客户经理团队名称 **/
	@Column(name = "MKT_TEAM_NAME", unique = false, nullable = true, length = 200)
	private String mktTeamName;
	
	/** 团队类型 **/
	@Column(name = "TEAM_TYPE", unique = false, nullable = true, length = 13)
	private String teamType;
	
	/** 团队负责人ID **/
	@Column(name = "TEAM_LEADER_ID", unique = false, nullable = true, length = 32)
	private String teamLeaderId;
	
	/** 团队负责人 **/
	@Column(name = "TEAM_LEADER", unique = false, nullable = true, length = 50)
	private String teamLeader;
	
	/** 团队所属机构 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 30)
	private String orgId;
	
	/** 团队所属机构名称 **/
	@Column(name = "ORG_NAME", unique = false, nullable = true, length = 200)
	private String orgName;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建人ID **/
	@Column(name = "CREATE_USER_ID", unique = false, nullable = true, length = 30)
	private String createUserId;
	
	/** 创建人名称 **/
	@Column(name = "CREATE_USER_NAME", unique = false, nullable = true, length = 50)
	private String createUserName;
	
	/** 创建人机构 **/
	@Column(name = "CREATE_USER_ORG_ID", unique = false, nullable = true, length = 30)
	private String createUserOrgId;
	
	/** 最近维护人ID **/
	@Column(name = "UPDATE_USER_ID", unique = false, nullable = true, length = 30)
	private String updateUserId;
	
	/** 最近维护人名称 **/
	@Column(name = "UPDATE_USER_NAME", unique = false, nullable = true, length = 50)
	private String updateUserName;
	
	/** 最近维护日期 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
	/**
	 * @param mktTeamId
	 */
	public void setMktTeamId(String mktTeamId) {
		this.mktTeamId = mktTeamId == null ? null : mktTeamId.trim();
	}
	
    /**
     * @return MktTeamId
     */	
	public String getMktTeamId() {
		return this.mktTeamId;
	}
	
	/**
	 * @param mktTeamName
	 */
	public void setMktTeamName(String mktTeamName) {
		this.mktTeamName = mktTeamName == null ? null : mktTeamName.trim();
	}
	
    /**
     * @return MktTeamName
     */	
	public String getMktTeamName() {
		return this.mktTeamName;
	}
	
	/**
	 * @param teamType
	 */
	public void setTeamType(String teamType) {
		this.teamType = teamType == null ? null : teamType.trim();
	}
	
    /**
     * @return TeamType
     */	
	public String getTeamType() {
		return this.teamType;
	}
	
	/**
	 * @param teamLeaderId
	 */
	public void setTeamLeaderId(String teamLeaderId) {
		this.teamLeaderId = teamLeaderId == null ? null : teamLeaderId.trim();
	}
	
    /**
     * @return TeamLeaderId
     */	
	public String getTeamLeaderId() {
		return this.teamLeaderId;
	}
	
	/**
	 * @param teamLeader
	 */
	public void setTeamLeader(String teamLeader) {
		this.teamLeader = teamLeader == null ? null : teamLeader.trim();
	}
	
    /**
     * @return TeamLeader
     */	
	public String getTeamLeader() {
		return this.teamLeader;
	}
	
	/**
	 * @param orgId
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}
	
    /**
     * @return OrgId
     */	
	public String getOrgId() {
		return this.orgId;
	}
	
	/**
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}
	
    /**
     * @return OrgName
     */	
	public String getOrgName() {
		return this.orgName;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
    /**
     * @return CreateDate
     */	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param createUserId
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId == null ? null : createUserId.trim();
	}
	
    /**
     * @return CreateUserId
     */	
	public String getCreateUserId() {
		return this.createUserId;
	}
	
	/**
	 * @param createUserName
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}
	
    /**
     * @return CreateUserName
     */	
	public String getCreateUserName() {
		return this.createUserName;
	}
	
	/**
	 * @param createUserOrgId
	 */
	public void setCreateUserOrgId(String createUserOrgId) {
		this.createUserOrgId = createUserOrgId == null ? null : createUserOrgId.trim();
	}
	
    /**
     * @return CreateUserOrgId
     */	
	public String getCreateUserOrgId() {
		return this.createUserOrgId;
	}
	
	/**
	 * @param updateUserId
	 */
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId == null ? null : updateUserId.trim();
	}
	
    /**
     * @return UpdateUserId
     */	
	public String getUpdateUserId() {
		return this.updateUserId;
	}
	
	/**
	 * @param updateUserName
	 */
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName == null ? null : updateUserName.trim();
	}
	
    /**
     * @return UpdateUserName
     */	
	public String getUpdateUserName() {
		return this.updateUserName;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}


}