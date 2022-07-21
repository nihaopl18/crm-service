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
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciTrusteeshipApply
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-15 11:56:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_TRUSTEESHIP_APPLY")
public class OcrmFciTrusteeshipApply extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "APPLY_ID")
	@Generated(GenerationType.UUID)
	private java.math.BigDecimal applyId;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 托管有效期 **/
	@Column(name = "DEAD_LINE", unique = false, nullable = true, length = 10)
	private Date deadLine;
	
	/** 客户经理编号 **/
	@Column(name = "MGR_ID", unique = false, nullable = true, length = 20)
	private String mgrId;
	
	/** 客户经理姓名 **/
	@Column(name = "MGR_NAME", unique = false, nullable = true, length = 200)
	private String mgrName;
	
	/** 托管客户经理编号 **/
	@Column(name = "TRUST_MGR_ID", unique = false, nullable = true, length = 20)
	private String trustMgrId;
	
	/** 托管客户经理姓名 **/
	@Column(name = "TRUST_MGR_NAME", unique = false, nullable = true, length = 200)
	private String trustMgrName;
	
	/** 设置人ID **/
	@Column(name = "SET_USER_ID", unique = false, nullable = true, length = 30)
	private String setUserId;
	
	/** 设置人 **/
	@Column(name = "SET_USER_NAME", unique = false, nullable = true, length = 200)
	private String setUserName;
	
	/** 托管时间 **/
	@Column(name = "SET_DATE", unique = false, nullable = true, length = 10)
	private Date setDate;
	
	/** 托管原因 **/
	@Column(name = "TRUST_REASON", unique = false, nullable = true, length = 800)
	private String trustReason;
	
	/** 托管状态 **/
	@Column(name = "TRUST_STAT", unique = false, nullable = true, length = 30)
	private String trustStat;
	
	/** 托管客户数 **/
	@Transient
	private int custNum;
	
	/** 托管客户编号 **/
	@Transient
	private String[] custId;
	
	@Transient
	/** 托管客户名称 **/
	private String[] custName;
	/**
	 * 流程id
	 */
	private String instanceId;

	/**
	 * @param applyId
	 */
	public void setApplyId(java.math.BigDecimal applyId) {
		this.applyId = applyId;
	}
	
    /**
     * @return ApplyId
     */	
	public java.math.BigDecimal getApplyId() {
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
	 * @param deadLine
	 */
	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}
	
    /**
     * @return DeadLine
     */	
	public Date getDeadLine() {
		return this.deadLine;
	}
	
	/**
	 * @param mgrId
	 */
	public void setMgrId(String mgrId) {
		this.mgrId = mgrId == null ? null : mgrId.trim();
	}
	
    /**
     * @return MgrId
     */	
	public String getMgrId() {
		return this.mgrId;
	}
	
	/**
	 * @param mgrName
	 */
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName == null ? null : mgrName.trim();
	}
	
    /**
     * @return MgrName
     */	
	public String getMgrName() {
		return this.mgrName;
	}
	
	/**
	 * @param trustMgrId
	 */
	public void setTrustMgrId(String trustMgrId) {
		this.trustMgrId = trustMgrId == null ? null : trustMgrId.trim();
	}
	
    /**
     * @return TrustMgrId
     */	
	public String getTrustMgrId() {
		return this.trustMgrId;
	}
	
	/**
	 * @param trustMgrName
	 */
	public void setTrustMgrName(String trustMgrName) {
		this.trustMgrName = trustMgrName == null ? null : trustMgrName.trim();
	}
	
    /**
     * @return TrustMgrName
     */	
	public String getTrustMgrName() {
		return this.trustMgrName;
	}
	
	/**
	 * @param setUserId
	 */
	public void setSetUserId(String setUserId) {
		this.setUserId = setUserId == null ? null : setUserId.trim();
	}
	
    /**
     * @return SetUserId
     */	
	public String getSetUserId() {
		return this.setUserId;
	}
	
	/**
	 * @param setUserName
	 */
	public void setSetUserName(String setUserName) {
		this.setUserName = setUserName == null ? null : setUserName.trim();
	}
	
    /**
     * @return SetUserName
     */	
	public String getSetUserName() {
		return this.setUserName;
	}
	
	/**
	 * @param setDate
	 */
	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
	
    /**
     * @return SetDate
     */	
	public Date getSetDate() {
		return this.setDate;
	}
	
	/**
	 * @param trustReason
	 */
	public void setTrustReason(String trustReason) {
		this.trustReason = trustReason == null ? null : trustReason.trim();
	}
	
    /**
     * @return TrustReason
     */	
	public String getTrustReason() {
		return this.trustReason;
	}
	
	/**
	 * @param trustStat
	 */
	public void setTrustStat(String trustStat) {
		this.trustStat = trustStat == null ? null : trustStat.trim();
	}
	
    /**
     * @return TrustStat
     */	
	public String getTrustStat() {
		return this.trustStat;
	}
	
	/**
	 * @param custNum
	 */
	public void setCustNum(int custNum) {
		this.custNum = custNum;
	}
	
    /**
     * @return custNum
     */	
	public int getCustNum() {
		return this.custNum;
	}
	
	/**
	 * @param custId
	 */
	public void setCustId(String[] custId) {
		this.custId = custId;
	}
	
    /**
     * @return custId
     */	
	public String[] getCustId() {
		return this.custId;
	}
	
	/**
	 * @param custName
	 */
	public void setCustName(String[] custName) {
		this.custName = custName;
	}
	
    /**
     * @return custName
     */	
	public String[] getCustName() {
		return this.custName;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
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
        OcrmFciTrusteeshipApply other = (OcrmFciTrusteeshipApply) that;
        		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        	&& (this.getTrustMgrId() == null ? other.getTrustMgrId() == null : this.getTrustMgrId().equals(other.getTrustMgrId()))
        	&& (this.getTrustMgrName() == null ? other.getTrustMgrName() == null : this.getTrustMgrName().equals(other.getTrustMgrName()))
        	&& (this.getSetUserId() == null ? other.getSetUserId() == null : this.getSetUserId().equals(other.getSetUserId()))
        	&& (this.getSetUserName() == null ? other.getSetUserName() == null : this.getSetUserName().equals(other.getSetUserName()))
                	&& (this.getTrustReason() == null ? other.getTrustReason() == null : this.getTrustReason().equals(other.getTrustReason()))
        	&& (this.getTrustStat() == null ? other.getTrustStat() == null : this.getTrustStat().equals(other.getTrustStat()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getTrustMgrId() == null) ? 0 : getTrustMgrId().hashCode());
        result = prime * result + ((getTrustMgrName() == null) ? 0 : getTrustMgrName().hashCode());
        result = prime * result + ((getSetUserId() == null) ? 0 : getSetUserId().hashCode());
        result = prime * result + ((getSetUserName() == null) ? 0 : getSetUserName().hashCode());
        result = prime * result + ((getTrustReason() == null) ? 0 : getTrustReason().hashCode());
        result = prime * result + ((getTrustStat() == null) ? 0 : getTrustStat().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", applyId=").append(applyId);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", deadLine=").append(deadLine);
		sb.append(", mgrId=").append(mgrId);
		sb.append(", mgrName=").append(mgrName);
		sb.append(", trustMgrId=").append(trustMgrId);
		sb.append(", trustMgrName=").append(trustMgrName);
		sb.append(", setUserId=").append(setUserId);
		sb.append(", setUserName=").append(setUserName);
		sb.append(", setDate=").append(setDate);
		sb.append(", trustReason=").append(trustReason);
		sb.append(", trustStat=").append(trustStat);
        sb.append("]");
        return sb.toString();
    }
}