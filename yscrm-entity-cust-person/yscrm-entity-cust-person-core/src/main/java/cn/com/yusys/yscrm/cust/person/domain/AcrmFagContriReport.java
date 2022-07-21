package cn.com.yusys.yscrm.cust.person.domain;



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
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFagContriReport
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-15 18:28:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_CONTRI_REPORT")
public class AcrmFagContriReport extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/**   法人   **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/**   数据日期   **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	
	/**   客户标识   **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 	本月存款贡献度	 **/
	@Column(name = "M_DEP_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mdepContribu;
	
	/** 	本月贷款贡献度	 **/
	@Column(name = "M_LOAN_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mloanContribu;
	
	/** 	本月中间业务贡献度	 **/
	@Column(name = "M_MID_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mmidContribu;
	
	/** 	本月综合贡献度	 **/
	@Column(name = "M_SUM_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal msumContribu;
	
	/** 	累计12个月存款贡献度	 **/
	@Column(name = "DEP_12M_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dep12mContribu;
	
	/** 	累计12个月贷款贡献度	 **/
	@Column(name = "LOAN_12M_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loan12mContribu;
	
	/** 	累计12个月中间业务贡献度	 **/
	@Column(name = "MID_12M_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mid12mContribu;
	
	/** 	累计12个月综合贡献度	 **/
	@Column(name = "SUM_12M_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal sum12mContribu;
	
	
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
	
	
	
	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
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
	 * @param mdepContribu
	 */
	public void setMdepContribu(java.math.BigDecimal mdepContribu) {
		this.mdepContribu = mdepContribu;
	}
	
    /**
     * @return MdepContribu
     */	
	public java.math.BigDecimal getMdepContribu() {
		return this.mdepContribu;
	}
	
	/**
	 * @param mloanContribu
	 */
	public void setMloanContribu(java.math.BigDecimal mloanContribu) {
		this.mloanContribu = mloanContribu;
	}
	
    /**
     * @return MloanContribu
     */	
	public java.math.BigDecimal getMloanContribu() {
		return this.mloanContribu;
	}
	
	/**
	 * @param mmidContribu
	 */
	public void setMmidContribu(java.math.BigDecimal mmidContribu) {
		this.mmidContribu = mmidContribu;
	}
	
    /**
     * @return MmidContribu
     */	
	public java.math.BigDecimal getMmidContribu() {
		return this.mmidContribu;
	}
	
	/**
	 * @param msumContribu
	 */
	public void setMsumContribu(java.math.BigDecimal msumContribu) {
		this.msumContribu = msumContribu;
	}
	
    /**
     * @return MsumContribu
     */	
	public java.math.BigDecimal getMsumContribu() {
		return this.msumContribu;
	}
	
	/**
	 * @param dep12mContribu
	 */
	public void setDep12mContribu(java.math.BigDecimal dep12mContribu) {
		this.dep12mContribu = dep12mContribu;
	}
	
    /**
     * @return Dep12mContribu
     */	
	public java.math.BigDecimal getDep12mContribu() {
		return this.dep12mContribu;
	}
	
	/**
	 * @param loan12mContribu
	 */
	public void setLoan12mContribu(java.math.BigDecimal loan12mContribu) {
		this.loan12mContribu = loan12mContribu;
	}
	
    /**
     * @return Loan12mContribu
     */	
	public java.math.BigDecimal getLoan12mContribu() {
		return this.loan12mContribu;
	}
	
	/**
	 * @param mid12mContribu
	 */
	public void setMid12mContribu(java.math.BigDecimal mid12mContribu) {
		this.mid12mContribu = mid12mContribu;
	}
	
    /**
     * @return Mid12mContribu
     */	
	public java.math.BigDecimal getMid12mContribu() {
		return this.mid12mContribu;
	}
	
	/**
	 * @param sum12mContribu
	 */
	public void setSum12mContribu(java.math.BigDecimal sum12mContribu) {
		this.sum12mContribu = sum12mContribu;
	}
	
    /**
     * @return Sum12mContribu
     */	
	public java.math.BigDecimal getSum12mContribu() {
		return this.sum12mContribu;
	}


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcrmFagContriReport other = (AcrmFagContriReport) obj;
		if (corpOrgCode == null) {
			if (other.corpOrgCode != null)
				return false;
		} else if (!corpOrgCode.equals(other.corpOrgCode))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (dataDate == null) {
			if (other.dataDate != null)
				return false;
		} else if (!dataDate.equals(other.dataDate))
			return false;
		if (dep12mContribu == null) {
			if (other.dep12mContribu != null)
				return false;
		} else if (!dep12mContribu.equals(other.dep12mContribu))
			return false;
		if (loan12mContribu == null) {
			if (other.loan12mContribu != null)
				return false;
		} else if (!loan12mContribu.equals(other.loan12mContribu))
			return false;
		if (mdepContribu == null) {
			if (other.mdepContribu != null)
				return false;
		} else if (!mdepContribu.equals(other.mdepContribu))
			return false;
		if (mid12mContribu == null) {
			if (other.mid12mContribu != null)
				return false;
		} else if (!mid12mContribu.equals(other.mid12mContribu))
			return false;
		if (mloanContribu == null) {
			if (other.mloanContribu != null)
				return false;
		} else if (!mloanContribu.equals(other.mloanContribu))
			return false;
		if (mmidContribu == null) {
			if (other.mmidContribu != null)
				return false;
		} else if (!mmidContribu.equals(other.mmidContribu))
			return false;
		if (msumContribu == null) {
			if (other.msumContribu != null)
				return false;
		} else if (!msumContribu.equals(other.msumContribu))
			return false;
		if (sum12mContribu == null) {
			if (other.sum12mContribu != null)
				return false;
		} else if (!sum12mContribu.equals(other.sum12mContribu))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((corpOrgCode == null) ? 0 : corpOrgCode.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((dataDate == null) ? 0 : dataDate.hashCode());
		result = prime * result + ((dep12mContribu == null) ? 0 : dep12mContribu.hashCode());
		result = prime * result + ((loan12mContribu == null) ? 0 : loan12mContribu.hashCode());
		result = prime * result + ((mdepContribu == null) ? 0 : mdepContribu.hashCode());
		result = prime * result + ((mid12mContribu == null) ? 0 : mid12mContribu.hashCode());
		result = prime * result + ((mloanContribu == null) ? 0 : mloanContribu.hashCode());
		result = prime * result + ((mmidContribu == null) ? 0 : mmidContribu.hashCode());
		result = prime * result + ((msumContribu == null) ? 0 : msumContribu.hashCode());
		result = prime * result + ((sum12mContribu == null) ? 0 : sum12mContribu.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "AcrmFagContriReport [corpOrgCode=" + corpOrgCode + ", dataDate=" + dataDate + ", custId=" + custId
				+ ", mdepContribu=" + mdepContribu + ", mloanContribu=" + mloanContribu + ", mmidContribu="
				+ mmidContribu + ", msumContribu=" + msumContribu + ", dep12mContribu=" + dep12mContribu
				+ ", loan12mContribu=" + loan12mContribu + ", mid12mContribu=" + mid12mContribu + ", sum12mContribu="
				+ sum12mContribu + "]";
	}
}