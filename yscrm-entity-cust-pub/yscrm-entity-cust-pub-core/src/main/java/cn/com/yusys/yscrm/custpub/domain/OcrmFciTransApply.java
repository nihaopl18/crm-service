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
 * @类名称: OcrmFciTransApply
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-15 17:36:15
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_TRANS_APPLY")
public class OcrmFciTransApply extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 申请编号 **/
	@Id
	@Column(name = "APPLY_NO")
	@Generated(GenerationType.UUID)
	private String applyNo;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 申请人id **/
	@Column(name = "USER_ID", unique = false, nullable = true, length = 20)
	private String userId;
	
	/** 申请人姓名 **/
	@Column(name = "USER_NAME", unique = false, nullable = true, length = 200)
	private String userName;
	
	/** 申请日期 **/
	@Column(name = "APPLY_DATE", unique = false, nullable = true, length = 11)
	private Date applyDate;
	
	/** 接收客户经理id **/
	@Column(name = "T_MGR_ID", unique = false, nullable = true, length = 20)
	private String tmgrId;
	
	/** 接收客户经理 **/
	@Column(name = "T_MGR_NAME", unique = false, nullable = true, length = 200)
	private String tmgrName;
	
	/** 接收机构id **/
	@Column(name = "T_ORG_ID", unique = false, nullable = true, length = 20)
	private String torgId;
	
	/** 接收机构 **/
	@Column(name = "T_ORG_NAME", unique = false, nullable = true, length = 200)
	private String torgName;
	
	/** 移交理由 **/
	@Column(name = "HAND_OVER_REASON", unique = false, nullable = true, length = 800)
	private String handOverReason;
	
	/** 工作交接日期 **/
	@Transient
	@Column(name = "WORK_INTERFIX_DT", unique = false, nullable = true, length = 11)
	private Date workInterfixDt;
	
	/** 审批状态 **/
	@Column(name = "APPROVE_STAT", unique = false, nullable = true, length = 30)
	private String approveStat;
	
	/** 移交类别 **/
	@Column(name = "APPLY_TYPE", unique = false, nullable = true, length = 30)
	private String applyType;
	
	
	/**
	 * @param applyNo
	 */
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo == null ? null : applyNo.trim();
	}
	
    /**
     * @return ApplyNo
     */	
	public String getApplyNo() {
		return this.applyNo;
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
	
    /**
     * @return UserId
     */	
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}
	
    /**
     * @return UserName
     */	
	public String getUserName() {
		return this.userName;
	}
	
	/**
	 * @param applyDate
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	
    /**
     * @return ApplyDate
     */	
	public Date getApplyDate() {
		return this.applyDate;
	}
	
	/**
	 * @param tmgrId
	 */
	public void setTmgrId(String tmgrId) {
		this.tmgrId = tmgrId == null ? null : tmgrId.trim();
	}
	
    /**
     * @return TmgrId
     */	
	public String getTmgrId() {
		return this.tmgrId;
	}
	
	/**
	 * @param tmgrName
	 */
	public void setTmgrName(String tmgrName) {
		this.tmgrName = tmgrName == null ? null : tmgrName.trim();
	}
	
    /**
     * @return TmgrName
     */	
	public String getTmgrName() {
		return this.tmgrName;
	}
	
	/**
	 * @param torgId
	 */
	public void setTorgId(String torgId) {
		this.torgId = torgId == null ? null : torgId.trim();
	}
	
    /**
     * @return TorgId
     */	
	public String getTorgId() {
		return this.torgId;
	}
	
	/**
	 * @param torgName
	 */
	public void setTorgName(String torgName) {
		this.torgName = torgName == null ? null : torgName.trim();
	}
	
    /**
     * @return TorgName
     */	
	public String getTorgName() {
		return this.torgName;
	}
	
	/**
	 * @param handOverReason
	 */
	public void setHandOverReason(String handOverReason) {
		this.handOverReason = handOverReason == null ? null : handOverReason.trim();
	}
	
    /**
     * @return HandOverReason
     */	
	public String getHandOverReason() {
		return this.handOverReason;
	}
	
	/**
	 * @param workInterfixDt
	 */
	public void setWorkInterfixDt(Date workInterfixDt) {
		this.workInterfixDt = workInterfixDt;
	}
	
    /**
     * @return WorkInterfixDt
     */	
	public Date getWorkInterfixDt() {
		return this.workInterfixDt;
	}
	
	/**
	 * @param approveStat
	 */
	public void setApproveStat(String approveStat) {
		this.approveStat = approveStat == null ? null : approveStat.trim();
	}
	
    /**
     * @return ApproveStat
     */	
	public String getApproveStat() {
		return this.approveStat;
	}
	
	/**
	 * @param applyType
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType == null ? null : applyType.trim();
	}
	
    /**
     * @return ApplyType
     */	
	public String getApplyType() {
		return this.applyType;
	}


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OcrmFciTransApply other = (OcrmFciTransApply) that;
		return (this.getApplyNo() == null ? other.getApplyNo() == null : this.getApplyNo().equals(other.getApplyNo()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        	&& (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
                	&& (this.getTmgrId() == null ? other.getTmgrId() == null : this.getTmgrId().equals(other.getTmgrId()))
        	&& (this.getTmgrName() == null ? other.getTmgrName() == null : this.getTmgrName().equals(other.getTmgrName()))
        	&& (this.getTorgId() == null ? other.getTorgId() == null : this.getTorgId().equals(other.getTorgId()))
        	&& (this.getTorgName() == null ? other.getTorgName() == null : this.getTorgName().equals(other.getTorgName()))
        	&& (this.getHandOverReason() == null ? other.getHandOverReason() == null : this.getHandOverReason().equals(other.getHandOverReason()))
                	&& (this.getApproveStat() == null ? other.getApproveStat() == null : this.getApproveStat().equals(other.getApproveStat()))
        	&& (this.getApplyType() == null ? other.getApplyType() == null : this.getApplyType().equals(other.getApplyType()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getApplyNo() == null) ? 0 : getApplyNo().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getTmgrId() == null) ? 0 : getTmgrId().hashCode());
        result = prime * result + ((getTmgrName() == null) ? 0 : getTmgrName().hashCode());
        result = prime * result + ((getTorgId() == null) ? 0 : getTorgId().hashCode());
        result = prime * result + ((getTorgName() == null) ? 0 : getTorgName().hashCode());
        result = prime * result + ((getHandOverReason() == null) ? 0 : getHandOverReason().hashCode());
        result = prime * result + ((getApproveStat() == null) ? 0 : getApproveStat().hashCode());
        result = prime * result + ((getApplyType() == null) ? 0 : getApplyType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", applyNo=").append(applyNo);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", userId=").append(userId);
		sb.append(", userName=").append(userName);
		sb.append(", applyDate=").append(applyDate);
		sb.append(", tmgrId=").append(tmgrId);
		sb.append(", tmgrName=").append(tmgrName);
		sb.append(", torgId=").append(torgId);
		sb.append(", torgName=").append(torgName);
		sb.append(", handOverReason=").append(handOverReason);
		sb.append(", workInterfixDt=").append(workInterfixDt);
		sb.append(", approveStat=").append(approveStat);
		sb.append(", applyType=").append(applyType);
        sb.append("]");
        return sb.toString();
    }
}