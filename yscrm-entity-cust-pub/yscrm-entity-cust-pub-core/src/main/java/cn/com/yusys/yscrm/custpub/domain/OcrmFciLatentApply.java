package cn.com.yusys.yscrm.custpub.domain;

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
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciLatentApply
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-14 19:50:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_LATENT_APPLY")
public class OcrmFciLatentApply extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "APPLY_ID")
	@Generated(GenerationType.UUID)
	private String applyId;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 申请人id **/
	@Column(name = "APPLY_USER", unique = false, nullable = true, length = 30)
	private String applyUser;
	
	/** 申请人姓名 **/
	@Column(name = "APPLY_USERNAME", unique = false, nullable = true, length = 200)
	private String applyUsername;
	
	/** 申请人机构 **/
	@Column(name = "APPLY_INIT", unique = false, nullable = true, length = 20)
	private String applyInit;
	
	/** 申请人机构 **/
	@Column(name = "APPLY_INITNAME", unique = false, nullable = true, length = 50)
	private String applyInitname;
	
	/** 申请日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 19)
	private Date createDate;
	
	/** 申请理由 **/
	@Column(name = "APPLY_REASON", unique = false, nullable = true, length = 800)
	private String applyReason;
	
	/** 审批状态 **/
	@Column(name = "APPROVEL_STATUS", unique = false, nullable = true, length = 30)
	private String approvelStatus;
	
	/** 认领期限 **/
	@Column(name = "DEAD_LINE", unique = false, nullable = true, length = 30)
	private String deadLine;
	
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	private String id;
	
	/**
	 * @param applyId
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId == null ? null : applyId.trim();
	}
	
    /**
     * @return ApplyId
     */	
	public String getApplyId() {
		return this.applyId;
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
	
	/**
	 * @param applyUser
	 */
	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser == null ? null : applyUser.trim();
	}
	
    /**
     * @return ApplyUser
     */	
	public String getApplyUser() {
		return this.applyUser;
	}
	
	/**
	 * @param applyUsername
	 */
	public void setApplyUsername(String applyUsername) {
		this.applyUsername = applyUsername == null ? null : applyUsername.trim();
	}
	
    /**
     * @return ApplyUsername
     */	
	public String getApplyUsername() {
		return this.applyUsername;
	}
	
	/**
	 * @param applyInit
	 */
	public void setApplyInit(String applyInit) {
		this.applyInit = applyInit == null ? null : applyInit.trim();
	}
	
    /**
     * @return ApplyInit
     */	
	public String getApplyInit() {
		return this.applyInit;
	}
	
	/**
	 * @param applyInitname
	 */
	public void setApplyInitname(String applyInitname) {
		this.applyInitname = applyInitname == null ? null : applyInitname.trim();
	}
	
    /**
     * @return ApplyInitname
     */	
	public String getApplyInitname() {
		return this.applyInitname;
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
	 * @param applyReason
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason == null ? null : applyReason.trim();
	}
	
    /**
     * @return ApplyReason
     */	
	public String getApplyReason() {
		return this.applyReason;
	}
	
	/**
	 * @param approvelStatus
	 */
	public void setApprovelStatus(String approvelStatus) {
		this.approvelStatus = approvelStatus == null ? null : approvelStatus.trim();
	}
	
    /**
     * @return ApprovelStatus
     */	
	public String getApprovelStatus() {
		return this.approvelStatus;
	}
	
	/**
	 * @param deadLine
	 */
	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine == null ? null : deadLine.trim();
	}
	
    /**
     * @return DeadLine
     */	
	public String getDeadLine() {
		return this.deadLine;
	}


    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OcrmFciLatentApply other = (OcrmFciLatentApply) obj;
		if (applyId == null) {
			if (other.applyId != null)
				return false;
		} else if (!applyId.equals(other.applyId))
			return false;
		if (applyInit == null) {
			if (other.applyInit != null)
				return false;
		} else if (!applyInit.equals(other.applyInit))
			return false;
		if (applyInitname == null) {
			if (other.applyInitname != null)
				return false;
		} else if (!applyInitname.equals(other.applyInitname))
			return false;
		if (applyReason == null) {
			if (other.applyReason != null)
				return false;
		} else if (!applyReason.equals(other.applyReason))
			return false;
		if (applyUser == null) {
			if (other.applyUser != null)
				return false;
		} else if (!applyUser.equals(other.applyUser))
			return false;
		if (applyUsername == null) {
			if (other.applyUsername != null)
				return false;
		} else if (!applyUsername.equals(other.applyUsername))
			return false;
		if (approvelStatus == null) {
			if (other.approvelStatus != null)
				return false;
		} else if (!approvelStatus.equals(other.approvelStatus))
			return false;
		if (corpOrgCode == null) {
			if (other.corpOrgCode != null)
				return false;
		} else if (!corpOrgCode.equals(other.corpOrgCode))
			return false;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (deadLine == null) {
			if (other.deadLine != null)
				return false;
		} else if (!deadLine.equals(other.deadLine))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyId == null) ? 0 : applyId.hashCode());
		result = prime * result + ((applyInit == null) ? 0 : applyInit.hashCode());
		result = prime * result + ((applyInitname == null) ? 0 : applyInitname.hashCode());
		result = prime * result + ((applyReason == null) ? 0 : applyReason.hashCode());
		result = prime * result + ((applyUser == null) ? 0 : applyUser.hashCode());
		result = prime * result + ((applyUsername == null) ? 0 : applyUsername.hashCode());
		result = prime * result + ((approvelStatus == null) ? 0 : approvelStatus.hashCode());
		result = prime * result + ((corpOrgCode == null) ? 0 : corpOrgCode.hashCode());
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((deadLine == null) ? 0 : deadLine.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "OcrmFciLatentApply [applyId=" + applyId + ", corpOrgCode=" + corpOrgCode + ", applyUser=" + applyUser
				+ ", applyUsername=" + applyUsername + ", applyInit=" + applyInit + ", applyInitname=" + applyInitname
				+ ", createDate=" + createDate + ", applyReason=" + applyReason + ", approvelStatus=" + approvelStatus
				+ ", deadLine=" + deadLine + ", id=" + id + "]";
	}
}