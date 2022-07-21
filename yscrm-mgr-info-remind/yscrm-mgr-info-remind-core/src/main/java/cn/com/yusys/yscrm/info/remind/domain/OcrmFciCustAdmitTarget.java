/*
 * 代码生成器自动生成的
 * Since 2008 - 2019
 *
 */
package cn.com.yusys.yscrm.info.remind.domain;

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
 * @项目名称: demo模块
 * @类名称: OcrmFciCustAdmitTarget
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: ns
 * @创建时间: 2019-03-28 13:59:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_CUST_ADMIT_TARGET")
public class OcrmFciCustAdmitTarget extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
	/**客户类型**/
    @Id
    @Column(name = "CUST_TYPE")
    private String custType;
    /**准入指标ID**/ 
    @Id
    @Column(name = "TARGET_ID")
    private String targetId;
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE")
	private String corpOrgCode;
	
	/** 准入指标名称 **/
	@Column(name = "TARGET_NAME")
	private String targetName;
	
	/** 准入指标运算符 **/
	@Column(name = "TARGET_OPERATOR")
	private String targetOperator;
	
	/** 准入指标状态 1-有效 0-无效 **/
	@Column(name = "TARGET_VALUE")
	private java.math.BigDecimal targetValue;
	
	/** TARGET_STATUS **/
	@Column(name = "TARGET_STATUS")
	private String targetStatus;
	
	/** 创建日期 **/
	@Transient
	@Column(name = "CRAT_DT")
	private Date cratDt;
	
	/** 创建人ID **/
	@Column(name = "CRAT_USR")
	private String cratUsr;
	
	/** 创建人名称 **/
	@Column(name = "CRAT_USER_NAME")
	private String cratUserName;
	
	/** 创建人所在机构ID **/
	@Column(name = "CRAT_ORG_ID")
	private String cratOrgId;
	
	/** 创建人所在机构名称 **/
	@Column(name = "CRAT_ORG_NAME")
	private String cratOrgName;
	
	/** 最近更新日期 **/
	@Transient
	@Column(name = "LAST_CHG_DATE")
	private Date lastChgDate;
	
	/** 最近更新人ID **/
	@Column(name = "LAST_CHG_USER_ID")
	private String lastChgUserId;
	
	/** 最近更新人名称 **/
	@Column(name = "LAST_CHG_USER_NAME")
	private String lastChgUserName;
	
	/** 最近更新人所在机构ID **/
	@Column(name = "LAST_CHG_ORG_ID")
	private String lastChgOrgId;
	
	/** 最近更新人所在机构名称 **/
	@Column(name = "LAST_CHG_ORG_NAME")
	private String lastChgOrgName;
	
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode;
	}
	
    /**
     * @return corpOrgCode
     */
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}
	
	/**
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType;
	}
	
    /**
     * @return custType
     */
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * @param targetId
	 */
	public void setTargetId(String targetId) {
		this.targetId = targetId;
	}
	
    /**
     * @return targetId
     */
	public String getTargetId() {
		return this.targetId;
	}
	
	/**
	 * @param targetName
	 */
	public void setTargetName(String targetName) {
		this.targetName = targetName;
	}
	
    /**
     * @return targetName
     */
	public String getTargetName() {
		return this.targetName;
	}
	
	/**
	 * @param targetOperator
	 */
	public void setTargetOperator(String targetOperator) {
		this.targetOperator = targetOperator;
	}
	
    /**
     * @return targetOperator
     */
	public String getTargetOperator() {
		return this.targetOperator;
	}
	
	/**
	 * @param targetValue
	 */
	public void setTargetValue(java.math.BigDecimal targetValue) {
		this.targetValue = targetValue;
	}
	
    /**
     * @return targetValue
     */
	public java.math.BigDecimal getTargetValue() {
		return this.targetValue;
	}
	
	/**
	 * @param targetStatus
	 */
	public void setTargetStatus(String targetStatus) {
		this.targetStatus = targetStatus;
	}
	
    /**
     * @return targetStatus
     */
	public String getTargetStatus() {
		return this.targetStatus;
	}
	
	/**
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return cratDt
     */
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr;
	}
	
    /**
     * @return cratUsr
     */
	public String getCratUsr() {
		return this.cratUsr;
	}
	
	/**
	 * @param cratUserName
	 */
	public void setCratUserName(String cratUserName) {
		this.cratUserName = cratUserName;
	}
	
    /**
     * @return cratUserName
     */
	public String getCratUserName() {
		return this.cratUserName;
	}
	
	/**
	 * @param cratOrgId
	 */
	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId;
	}
	
    /**
     * @return cratOrgId
     */
	public String getCratOrgId() {
		return this.cratOrgId;
	}
	
	/**
	 * @param cratOrgName
	 */
	public void setCratOrgName(String cratOrgName) {
		this.cratOrgName = cratOrgName;
	}
	
    /**
     * @return cratOrgName
     */
	public String getCratOrgName() {
		return this.cratOrgName;
	}
	
	/**
	 * @param lastChgDate
	 */
	public void setLastChgDate(Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}
	
    /**
     * @return lastChgDate
     */
	public Date getLastChgDate() {
		return this.lastChgDate;
	}
	
	/**
	 * @param lastChgUserId
	 */
	public void setLastChgUserId(String lastChgUserId) {
		this.lastChgUserId = lastChgUserId;
	}
	
    /**
     * @return lastChgUserId
     */
	public String getLastChgUserId() {
		return this.lastChgUserId;
	}
	
	/**
	 * @param lastChgUserName
	 */
	public void setLastChgUserName(String lastChgUserName) {
		this.lastChgUserName = lastChgUserName;
	}
	
    /**
     * @return lastChgUserName
     */
	public String getLastChgUserName() {
		return this.lastChgUserName;
	}
	
	/**
	 * @param lastChgOrgId
	 */
	public void setLastChgOrgId(String lastChgOrgId) {
		this.lastChgOrgId = lastChgOrgId;
	}
	
    /**
     * @return lastChgOrgId
     */
	public String getLastChgOrgId() {
		return this.lastChgOrgId;
	}
	
	/**
	 * @param lastChgOrgName
	 */
	public void setLastChgOrgName(String lastChgOrgName) {
		this.lastChgOrgName = lastChgOrgName;
	}
	
    /**
     * @return lastChgOrgName
     */
	public String getLastChgOrgName() {
		return this.lastChgOrgName;
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
	    OcrmFciCustAdmitTarget other = (OcrmFciCustAdmitTarget) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
	    	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
	    	&& (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
	    	&& (this.getTargetName() == null ? other.getTargetName() == null : this.getTargetName().equals(other.getTargetName()))
	    	&& (this.getTargetOperator() == null ? other.getTargetOperator() == null : this.getTargetOperator().equals(other.getTargetOperator()))
	    	    	&& (this.getTargetStatus() == null ? other.getTargetStatus() == null : this.getTargetStatus().equals(other.getTargetStatus()))
	    	    	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
	    	&& (this.getCratUserName() == null ? other.getCratUserName() == null : this.getCratUserName().equals(other.getCratUserName()))
	    	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
	    	&& (this.getCratOrgName() == null ? other.getCratOrgName() == null : this.getCratOrgName().equals(other.getCratOrgName()))
	    	    	&& (this.getLastChgUserId() == null ? other.getLastChgUserId() == null : this.getLastChgUserId().equals(other.getLastChgUserId()))
	    	&& (this.getLastChgUserName() == null ? other.getLastChgUserName() == null : this.getLastChgUserName().equals(other.getLastChgUserName()))
	    	&& (this.getLastChgOrgId() == null ? other.getLastChgOrgId() == null : this.getLastChgOrgId().equals(other.getLastChgOrgId()))
	    	&& (this.getLastChgOrgName() == null ? other.getLastChgOrgName() == null : this.getLastChgOrgName().equals(other.getLastChgOrgName()))
	    ;
	}
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getTargetName() == null) ? 0 : getTargetName().hashCode());
        result = prime * result + ((getTargetOperator() == null) ? 0 : getTargetOperator().hashCode());
        result = prime * result + ((getTargetStatus() == null) ? 0 : getTargetStatus().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getCratUserName() == null) ? 0 : getCratUserName().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratOrgName() == null) ? 0 : getCratOrgName().hashCode());
        result = prime * result + ((getLastChgUserId() == null) ? 0 : getLastChgUserId().hashCode());
        result = prime * result + ((getLastChgUserName() == null) ? 0 : getLastChgUserName().hashCode());
        result = prime * result + ((getLastChgOrgId() == null) ? 0 : getLastChgOrgId().hashCode());
        result = prime * result + ((getLastChgOrgName() == null) ? 0 : getLastChgOrgName().hashCode());
        return result;
    }
	
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append("]");
        return sb.toString();
    }
}