package cn.com.yusys.yscrm.custmgr.domain;

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
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmBusiSumM
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 14:11:40
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_A_CM_BUSI_SUM_M")
public class AcrmAcmBusiSumM extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 法人 **/
	@Id
	@Column(name = "CORP_ORG_CODE")
	@Generated(GenerationType.UUID)
	private String corpOrgCode;
	/** 数据日期 **/
	@Id
	@Column(name = "DATA_DT")
	@Generated(GenerationType.UUID)
	private Date dataDt;
	/** 统计对象编号 **/
	@Id
	@Column(name = "TARGET_ID")
	@Generated(GenerationType.UUID)
	private String targetId;
	/** 汇总维度 **/
	@Id
	@Column(name = "TARGET_TYPE")
	@Generated(GenerationType.UUID)
	private String targetType;
	
	/** 归属条线 **/
	@Column(name = "BEL_TYPE", unique = false, nullable = true, length = 30)
	private String belType;
	
	/** 管理客户AUM月日均余额 **/
	@Column(name = "AUM_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal aumMavgBal;
	
	/** 管理客户贷款月日均余额 **/
	@Column(name = "LOAN_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanMavgBal;
	
	/** 管理零售客户AUM时点余额 **/
	@Column(name = "PER_AUM_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal perAumBal;
	
	/** 管理零售客户AUM月日均余额 **/
	@Column(name = "PER_AUM_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal perAumMavgBal;
	
	/** 管理零售客户AUM年日均余额 **/
	@Column(name = "PER_AUM_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal perAumYavgBal;
	
	/** 管理对公客户AUM时点余额 **/
	@Column(name = "ORG_AUM_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal orgAumBal;
	
	/** 管理对公客户AUM月日均余额 **/
	@Column(name = "ORG_AUM_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal orgAumMavgBal;
	
	/** 管理对公客户AUM年日均余额 **/
	@Column(name = "ORG_AUM_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal orgAumYavgBal;
	
	/** 管理零售客户AUM时点余额 **/
	@Column(name = "PER_LOAN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal perLoanBal;
	
	/** 管理零售客户AUM月日均余额 **/
	@Column(name = "PER_LOAN_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal perLoanMavgBal;
	
	/** 管理零售客户AUM年日均余额 **/
	@Column(name = "PER_LOAN_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal perLoanYavgBal;
	
	/** 管理对公客户AUM时点余额 **/
	@Column(name = "ORG_LOAN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal orgLoanBal;
	
	/** 管理对公客户AUM月日均余额 **/
	@Column(name = "ORG_LOAN_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal orgLoanMavgBal;
	
	/** 管理对公客户AUM年日均余额 **/
	@Column(name = "ORG_LOAN_Y_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal orgLoanYavgBal;
	
	
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
	 * @param dataDt
	 */
	public void setDataDt(Date dataDt) {
		this.dataDt = dataDt;
	}
	
    /**
     * @return DataDt
     */	
	public Date getDataDt() {
		return this.dataDt;
	}
	
	/**
	 * @param targetId
	 */
	public void setTargetId(String targetId) {
		this.targetId = targetId == null ? null : targetId.trim();
	}
	
    /**
     * @return TargetId
     */	
	public String getTargetId() {
		return this.targetId;
	}
	
	/**
	 * @param targetType
	 */
	public void setTargetType(String targetType) {
		this.targetType = targetType == null ? null : targetType.trim();
	}
	
    /**
     * @return TargetType
     */	
	public String getTargetType() {
		return this.targetType;
	}
	
	/**
	 * @param belType
	 */
	public void setBelType(String belType) {
		this.belType = belType == null ? null : belType.trim();
	}
	
    /**
     * @return BelType
     */	
	public String getBelType() {
		return this.belType;
	}
	
	/**
	 * @param aumMavgBal
	 */
	public void setAumMavgBal(java.math.BigDecimal aumMavgBal) {
		this.aumMavgBal = aumMavgBal;
	}
	
    /**
     * @return AumMavgBal
     */	
	public java.math.BigDecimal getAumMavgBal() {
		return this.aumMavgBal;
	}
	
	/**
	 * @param loanMavgBal
	 */
	public void setLoanMavgBal(java.math.BigDecimal loanMavgBal) {
		this.loanMavgBal = loanMavgBal;
	}
	
    /**
     * @return LoanMavgBal
     */	
	public java.math.BigDecimal getLoanMavgBal() {
		return this.loanMavgBal;
	}
	
	/**
	 * @param perAumBal
	 */
	public void setPerAumBal(java.math.BigDecimal perAumBal) {
		this.perAumBal = perAumBal;
	}
	
    /**
     * @return PerAumBal
     */	
	public java.math.BigDecimal getPerAumBal() {
		return this.perAumBal;
	}
	
	/**
	 * @param perAumMavgBal
	 */
	public void setPerAumMavgBal(java.math.BigDecimal perAumMavgBal) {
		this.perAumMavgBal = perAumMavgBal;
	}
	
    /**
     * @return PerAumMavgBal
     */	
	public java.math.BigDecimal getPerAumMavgBal() {
		return this.perAumMavgBal;
	}
	
	/**
	 * @param perAumYavgBal
	 */
	public void setPerAumYavgBal(java.math.BigDecimal perAumYavgBal) {
		this.perAumYavgBal = perAumYavgBal;
	}
	
    /**
     * @return PerAumYavgBal
     */	
	public java.math.BigDecimal getPerAumYavgBal() {
		return this.perAumYavgBal;
	}
	
	/**
	 * @param orgAumBal
	 */
	public void setOrgAumBal(java.math.BigDecimal orgAumBal) {
		this.orgAumBal = orgAumBal;
	}
	
    /**
     * @return OrgAumBal
     */	
	public java.math.BigDecimal getOrgAumBal() {
		return this.orgAumBal;
	}
	
	/**
	 * @param orgAumMavgBal
	 */
	public void setOrgAumMavgBal(java.math.BigDecimal orgAumMavgBal) {
		this.orgAumMavgBal = orgAumMavgBal;
	}
	
    /**
     * @return OrgAumMavgBal
     */	
	public java.math.BigDecimal getOrgAumMavgBal() {
		return this.orgAumMavgBal;
	}
	
	/**
	 * @param orgAumYavgBal
	 */
	public void setOrgAumYavgBal(java.math.BigDecimal orgAumYavgBal) {
		this.orgAumYavgBal = orgAumYavgBal;
	}
	
    /**
     * @return OrgAumYavgBal
     */	
	public java.math.BigDecimal getOrgAumYavgBal() {
		return this.orgAumYavgBal;
	}
	
	/**
	 * @param perLoanBal
	 */
	public void setPerLoanBal(java.math.BigDecimal perLoanBal) {
		this.perLoanBal = perLoanBal;
	}
	
    /**
     * @return PerLoanBal
     */	
	public java.math.BigDecimal getPerLoanBal() {
		return this.perLoanBal;
	}
	
	/**
	 * @param perLoanMavgBal
	 */
	public void setPerLoanMavgBal(java.math.BigDecimal perLoanMavgBal) {
		this.perLoanMavgBal = perLoanMavgBal;
	}
	
    /**
     * @return PerLoanMavgBal
     */	
	public java.math.BigDecimal getPerLoanMavgBal() {
		return this.perLoanMavgBal;
	}
	
	/**
	 * @param perLoanYavgBal
	 */
	public void setPerLoanYavgBal(java.math.BigDecimal perLoanYavgBal) {
		this.perLoanYavgBal = perLoanYavgBal;
	}
	
    /**
     * @return PerLoanYavgBal
     */	
	public java.math.BigDecimal getPerLoanYavgBal() {
		return this.perLoanYavgBal;
	}
	
	/**
	 * @param orgLoanBal
	 */
	public void setOrgLoanBal(java.math.BigDecimal orgLoanBal) {
		this.orgLoanBal = orgLoanBal;
	}
	
    /**
     * @return OrgLoanBal
     */	
	public java.math.BigDecimal getOrgLoanBal() {
		return this.orgLoanBal;
	}
	
	/**
	 * @param orgLoanMavgBal
	 */
	public void setOrgLoanMavgBal(java.math.BigDecimal orgLoanMavgBal) {
		this.orgLoanMavgBal = orgLoanMavgBal;
	}
	
    /**
     * @return OrgLoanMavgBal
     */	
	public java.math.BigDecimal getOrgLoanMavgBal() {
		return this.orgLoanMavgBal;
	}
	
	/**
	 * @param orgLoanYavgBal
	 */
	public void setOrgLoanYavgBal(java.math.BigDecimal orgLoanYavgBal) {
		this.orgLoanYavgBal = orgLoanYavgBal;
	}
	
    /**
     * @return OrgLoanYavgBal
     */	
	public java.math.BigDecimal getOrgLoanYavgBal() {
		return this.orgLoanYavgBal;
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
        AcrmAcmBusiSumM other = (AcrmAcmBusiSumM) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
        	&& (this.getTargetType() == null ? other.getTargetType() == null : this.getTargetType().equals(other.getTargetType()))
        	&& (this.getBelType() == null ? other.getBelType() == null : this.getBelType().equals(other.getBelType()))
                                                                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getTargetType() == null) ? 0 : getTargetType().hashCode());
        result = prime * result + ((getBelType() == null) ? 0 : getBelType().hashCode());
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