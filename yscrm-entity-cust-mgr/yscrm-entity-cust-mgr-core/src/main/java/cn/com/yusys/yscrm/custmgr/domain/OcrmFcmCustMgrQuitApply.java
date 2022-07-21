package cn.com.yusys.yscrm.custmgr.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFcmCustMgrQuitApply
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-28 14:26:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CM_CUST_MGR_QUIT_APPLY")
public class OcrmFcmCustMgrQuitApply extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 用户ID **/
	@Column(name = "USER_ID", unique = false, nullable = true, length = 32)
	private String userId;
	
	/** 客户经理名称 **/
	@Column(name = "CUST_MANAGER_NAME", unique = false, nullable = true, length = 100)
	private String custManagerName;
	
	/** 客户经理员工号 **/
	@Column(name = "CUST_MANAGER_ID", unique = false, nullable = true, length = 32)
	private String custManagerId;
	
	/** 学历 **/
	@Column(name = "EDUCATION", unique = false, nullable = true, length = 13)
	private String education;
	
	/** 入行日期 **/
	@Column(name = "ENTRANTS_DATE", unique = false, nullable = true, length = 7)
	private Date entrantsDate;
	
	/** 金融从业时间(月) **/
	@Column(name = "FINANCIAL_JOB_TIME", unique = false, nullable = true, length = 20)
	private String financialJobTime;
	
	/** 所获奖励 **/
	@Column(name = "AWARD", unique = false, nullable = true, length = 100)
	private String award;
	
	/** 资格证书 **/
	@Column(name = "CERTIFICATE", unique = false, nullable = true, length = 20)
	private String certificate;
	
	/** 职称 **/
	@Column(name = "DUTY", unique = false, nullable = true, length = 13)
	private String duty;
	
	/** 出生日期 **/
	@Column(name = "BIRTHDAY", unique = false, nullable = true, length = 7)
	private Date birthday;
	
	/** 任职日期 **/
	@Column(name = "POSITION_TIME", unique = false, nullable = true, length = 7)
	private Date positionTime;
	
	/** 客户经理等级 **/
	@Column(name = "CUST_MANAGER_LEVEL", unique = false, nullable = true, length = 13)
	private String custManagerLevel;
	
	/** 申请状态 **/
	@Column(name = "STATE", unique = false, nullable = true, length = 13)
	private String state;
	
	/** 退出理由 **/
	@Column(name = "QUIT_REASON", unique = false, nullable = true, length = 800)
	private String quitReason;
	
	/** 退出日期 **/
	@Column(name = "QUIT_DATE", unique = false, nullable = true, length = 7)
	private Date quitDate;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
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
	 * @param custManagerName
	 */
	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName == null ? null : custManagerName.trim();
	}
	
    /**
     * @return CustManagerName
     */	
	public String getCustManagerName() {
		return this.custManagerName;
	}
	
	/**
	 * @param custManagerId
	 */
	public void setCustManagerId(String custManagerId) {
		this.custManagerId = custManagerId == null ? null : custManagerId.trim();
	}
	
    /**
     * @return CustManagerId
     */	
	public String getCustManagerId() {
		return this.custManagerId;
	}
	
	/**
	 * @param education
	 */
	public void setEducation(String education) {
		this.education = education == null ? null : education.trim();
	}
	
    /**
     * @return Education
     */	
	public String getEducation() {
		return this.education;
	}
	
	/**
	 * @param entrantsDate
	 */
	public void setEntrantsDate(Date entrantsDate) {
		this.entrantsDate = entrantsDate;
	}
	
    /**
     * @return EntrantsDate
     */	
	public Date getEntrantsDate() {
		return this.entrantsDate;
	}
	
	/**
	 * @param financialJobTime
	 */
	public void setFinancialJobTime(String financialJobTime) {
		this.financialJobTime = financialJobTime == null ? null : financialJobTime.trim();
	}
	
    /**
     * @return FinancialJobTime
     */	
	public String getFinancialJobTime() {
		return this.financialJobTime;
	}
	
	/**
	 * @param award
	 */
	public void setAward(String award) {
		this.award = award == null ? null : award.trim();
	}
	
    /**
     * @return Award
     */	
	public String getAward() {
		return this.award;
	}
	
	/**
	 * @param certificate
	 */
	public void setCertificate(String certificate) {
		this.certificate = certificate == null ? null : certificate.trim();
	}
	
    /**
     * @return Certificate
     */	
	public String getCertificate() {
		return this.certificate;
	}
	
	/**
	 * @param duty
	 */
	public void setDuty(String duty) {
		this.duty = duty == null ? null : duty.trim();
	}
	
    /**
     * @return Duty
     */	
	public String getDuty() {
		return this.duty;
	}
	
	/**
	 * @param birthday
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
    /**
     * @return Birthday
     */	
	public Date getBirthday() {
		return this.birthday;
	}
	
	/**
	 * @param positionTime
	 */
	public void setPositionTime(Date positionTime) {
		this.positionTime = positionTime;
	}
	
    /**
     * @return PositionTime
     */	
	public Date getPositionTime() {
		return this.positionTime;
	}
	
	/**
	 * @param custManagerLevel
	 */
	public void setCustManagerLevel(String custManagerLevel) {
		this.custManagerLevel = custManagerLevel == null ? null : custManagerLevel.trim();
	}
	
    /**
     * @return CustManagerLevel
     */	
	public String getCustManagerLevel() {
		return this.custManagerLevel;
	}
	
	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
	
    /**
     * @return State
     */	
	public String getState() {
		return this.state;
	}
	
	/**
	 * @param quitReason
	 */
	public void setQuitReason(String quitReason) {
		this.quitReason = quitReason == null ? null : quitReason.trim();
	}
	
    /**
     * @return QuitReason
     */	
	public String getQuitReason() {
		return this.quitReason;
	}
	
	/**
	 * @param quitDate
	 */
	public void setQuitDate(Date quitDate) {
		this.quitDate = quitDate;
	}
	
    /**
     * @return QuitDate
     */	
	public Date getQuitDate() {
		return this.quitDate;
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
        OcrmFcmCustMgrQuitApply other = (OcrmFcmCustMgrQuitApply) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        	&& (this.getCustManagerName() == null ? other.getCustManagerName() == null : this.getCustManagerName().equals(other.getCustManagerName()))
        	&& (this.getCustManagerId() == null ? other.getCustManagerId() == null : this.getCustManagerId().equals(other.getCustManagerId()))
        	&& (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
                	&& (this.getFinancialJobTime() == null ? other.getFinancialJobTime() == null : this.getFinancialJobTime().equals(other.getFinancialJobTime()))
        	&& (this.getAward() == null ? other.getAward() == null : this.getAward().equals(other.getAward()))
        	&& (this.getCertificate() == null ? other.getCertificate() == null : this.getCertificate().equals(other.getCertificate()))
        	&& (this.getDuty() == null ? other.getDuty() == null : this.getDuty().equals(other.getDuty()))
                        	&& (this.getCustManagerLevel() == null ? other.getCustManagerLevel() == null : this.getCustManagerLevel().equals(other.getCustManagerLevel()))
        	&& (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
        	&& (this.getQuitReason() == null ? other.getQuitReason() == null : this.getQuitReason().equals(other.getQuitReason()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCustManagerName() == null) ? 0 : getCustManagerName().hashCode());
        result = prime * result + ((getCustManagerId() == null) ? 0 : getCustManagerId().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getFinancialJobTime() == null) ? 0 : getFinancialJobTime().hashCode());
        result = prime * result + ((getAward() == null) ? 0 : getAward().hashCode());
        result = prime * result + ((getCertificate() == null) ? 0 : getCertificate().hashCode());
        result = prime * result + ((getDuty() == null) ? 0 : getDuty().hashCode());
        result = prime * result + ((getCustManagerLevel() == null) ? 0 : getCustManagerLevel().hashCode());
        result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
        result = prime * result + ((getQuitReason() == null) ? 0 : getQuitReason().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userId=").append(userId);
		sb.append(", custManagerName=").append(custManagerName);
		sb.append(", custManagerId=").append(custManagerId);
		sb.append(", education=").append(education);
		sb.append(", entrantsDate=").append(entrantsDate);
		sb.append(", financialJobTime=").append(financialJobTime);
		sb.append(", award=").append(award);
		sb.append(", certificate=").append(certificate);
		sb.append(", duty=").append(duty);
		sb.append(", birthday=").append(birthday);
		sb.append(", positionTime=").append(positionTime);
		sb.append(", custManagerLevel=").append(custManagerLevel);
		sb.append(", state=").append(state);
		sb.append(", quitReason=").append(quitReason);
		sb.append(", quitDate=").append(quitDate);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}