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
 * @类名称: OcrmFcgCpnGrade
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 11:10:51
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CG_CPN_GRADE")
public class OcrmFcgCpnGrade extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/**   最新更新系统    **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/**   最新更新人    **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/**   最新更新时间    **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/**   法人    **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 100)
	private String corpOrgCode;
	
	/**   客户标识    **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/**   价值等级    **/
	@Column(name = "GRADE_LEVEL", unique = false, nullable = true, length = 20)
	private String gradeLevel;
	
	/**   下调前价值等级    **/
	@Column(name = "PRE_MINUS_LEVEL", unique = false, nullable = true, length = 20)
	private String preMinusLevel;
	
	/**   风险影响因子内容    **/
	@Column(name = "GRADE_MINUS_CONTENT", unique = false, nullable = true, length = 1000)
	private String gradeMinusContent;
	
	/** 	服务等级	  **/
	@Column(name = "SERVICE_LEVEL", unique = false, nullable = true, length = 20)
	private String serviceLevel;
	
	/** 	服务等级评级方式	  **/
	@Column(name = "EVALUATE_TYPE", unique = false, nullable = true, length = 20)
	private String evaluateType;
	
	/** 	系统服务等级	  **/
	@Column(name = "SYS_SERVICE_LEVEL", unique = false, nullable = true, length = 20)
	private String sysServiceLevel;
	
	/** 	手工服务等级	  **/
	@Column(name = "HAND_SERVICE_LEVEL", unique = false, nullable = true, length = 20)
	private String handServiceLevel;
	
	/** 	系统评级日期	  **/
	@Transient
	@Column(name = "EVALUATE_DATE", unique = false, nullable = true, length = 7)
	private Date evaluateDate;
	
	/** 	手工评级日期	  **/
	@Transient
	@Column(name = "HAND_EVALUATE_DATE", unique = false, nullable = true, length = 7)
	private Date handEvaluateDate;
	
	/** 	手工等级生效日期	  **/
	@Transient
	@Column(name = "HAND_EFFECTIVE_DATE", unique = false, nullable = true, length = 7)
	private Date handEffectiveDate;
	
	/** 	手工等级失效日期	  **/
	@Transient
	@Column(name = "HAND_EXPIRED_DATE", unique = false, nullable = true, length = 7)
	private Date handExpiredDate;
	
	
	/**
	 * @param lastChgSys
	 */
	public void setLastChgSys(String lastChgSys) {
		this.lastChgSys = lastChgSys == null ? null : lastChgSys.trim();
	}
	
    /**
     * @return LastChgSys
     */	
	public String getLastChgSys() {
		return this.lastChgSys;
	}
	
	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}
	
    /**
     * @return LastChgUsr
     */	
	public String getLastChgUsr() {
		return this.lastChgUsr;
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
	
	/**
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}
	
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param gradeLevel
	 */
	public void setGradeLevel(String gradeLevel) {
		this.gradeLevel = gradeLevel == null ? null : gradeLevel.trim();
	}
	
    /**
     * @return GradeLevel
     */	
	public String getGradeLevel() {
		return this.gradeLevel;
	}
	
	/**
	 * @param preMinusLevel
	 */
	public void setPreMinusLevel(String preMinusLevel) {
		this.preMinusLevel = preMinusLevel == null ? null : preMinusLevel.trim();
	}
	
    /**
     * @return PreMinusLevel
     */	
	public String getPreMinusLevel() {
		return this.preMinusLevel;
	}
	
	/**
	 * @param gradeMinusContent
	 */
	public void setGradeMinusContent(String gradeMinusContent) {
		this.gradeMinusContent = gradeMinusContent == null ? null : gradeMinusContent.trim();
	}
	
    /**
     * @return GradeMinusContent
     */	
	public String getGradeMinusContent() {
		return this.gradeMinusContent;
	}
	
	/**
	 * @param serviceLevel
	 */
	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel == null ? null : serviceLevel.trim();
	}
	
    /**
     * @return ServiceLevel
     */	
	public String getServiceLevel() {
		return this.serviceLevel;
	}
	
	/**
	 * @param evaluateType
	 */
	public void setEvaluateType(String evaluateType) {
		this.evaluateType = evaluateType == null ? null : evaluateType.trim();
	}
	
    /**
     * @return EvaluateType
     */	
	public String getEvaluateType() {
		return this.evaluateType;
	}
	
	/**
	 * @param sysServiceLevel
	 */
	public void setSysServiceLevel(String sysServiceLevel) {
		this.sysServiceLevel = sysServiceLevel == null ? null : sysServiceLevel.trim();
	}
	
    /**
     * @return SysServiceLevel
     */	
	public String getSysServiceLevel() {
		return this.sysServiceLevel;
	}
	
	/**
	 * @param handServiceLevel
	 */
	public void setHandServiceLevel(String handServiceLevel) {
		this.handServiceLevel = handServiceLevel == null ? null : handServiceLevel.trim();
	}
	
    /**
     * @return HandServiceLevel
     */	
	public String getHandServiceLevel() {
		return this.handServiceLevel;
	}
	
	/**
	 * @param evaluateDate
	 */
	public void setEvaluateDate(Date evaluateDate) {
		this.evaluateDate = evaluateDate;
	}
	
    /**
     * @return EvaluateDate
     */	
	public Date getEvaluateDate() {
		return this.evaluateDate;
	}
	
	/**
	 * @param handEvaluateDate
	 */
	public void setHandEvaluateDate(Date handEvaluateDate) {
		this.handEvaluateDate = handEvaluateDate;
	}
	
    /**
     * @return HandEvaluateDate
     */	
	public Date getHandEvaluateDate() {
		return this.handEvaluateDate;
	}
	
	/**
	 * @param handEffectiveDate
	 */
	public void setHandEffectiveDate(Date handEffectiveDate) {
		this.handEffectiveDate = handEffectiveDate;
	}
	
    /**
     * @return HandEffectiveDate
     */	
	public Date getHandEffectiveDate() {
		return this.handEffectiveDate;
	}
	
	/**
	 * @param handExpiredDate
	 */
	public void setHandExpiredDate(Date handExpiredDate) {
		this.handExpiredDate = handExpiredDate;
	}
	
    /**
     * @return HandExpiredDate
     */	
	public Date getHandExpiredDate() {
		return this.handExpiredDate;
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
        OcrmFcgCpnGrade other = (OcrmFcgCpnGrade) that;
		return (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getGradeLevel() == null ? other.getGradeLevel() == null : this.getGradeLevel().equals(other.getGradeLevel()))
        	&& (this.getPreMinusLevel() == null ? other.getPreMinusLevel() == null : this.getPreMinusLevel().equals(other.getPreMinusLevel()))
        	&& (this.getGradeMinusContent() == null ? other.getGradeMinusContent() == null : this.getGradeMinusContent().equals(other.getGradeMinusContent()))
        	&& (this.getServiceLevel() == null ? other.getServiceLevel() == null : this.getServiceLevel().equals(other.getServiceLevel()))
        	&& (this.getEvaluateType() == null ? other.getEvaluateType() == null : this.getEvaluateType().equals(other.getEvaluateType()))
        	&& (this.getSysServiceLevel() == null ? other.getSysServiceLevel() == null : this.getSysServiceLevel().equals(other.getSysServiceLevel()))
        	&& (this.getHandServiceLevel() == null ? other.getHandServiceLevel() == null : this.getHandServiceLevel().equals(other.getHandServiceLevel()))
                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getGradeLevel() == null) ? 0 : getGradeLevel().hashCode());
        result = prime * result + ((getPreMinusLevel() == null) ? 0 : getPreMinusLevel().hashCode());
        result = prime * result + ((getGradeMinusContent() == null) ? 0 : getGradeMinusContent().hashCode());
        result = prime * result + ((getServiceLevel() == null) ? 0 : getServiceLevel().hashCode());
        result = prime * result + ((getEvaluateType() == null) ? 0 : getEvaluateType().hashCode());
        result = prime * result + ((getSysServiceLevel() == null) ? 0 : getSysServiceLevel().hashCode());
        result = prime * result + ((getHandServiceLevel() == null) ? 0 : getHandServiceLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", gradeLevel=").append(gradeLevel);
		sb.append(", preMinusLevel=").append(preMinusLevel);
		sb.append(", gradeMinusContent=").append(gradeMinusContent);
		sb.append(", serviceLevel=").append(serviceLevel);
		sb.append(", evaluateType=").append(evaluateType);
		sb.append(", sysServiceLevel=").append(sysServiceLevel);
		sb.append(", handServiceLevel=").append(handServiceLevel);
		sb.append(", evaluateDate=").append(evaluateDate);
		sb.append(", handEvaluateDate=").append(handEvaluateDate);
		sb.append(", handEffectiveDate=").append(handEffectiveDate);
		sb.append(", handExpiredDate=").append(handExpiredDate);
        sb.append("]");
        return sb.toString();
    }
}