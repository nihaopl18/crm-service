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
 * @类名称: AcrmFciCreditInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 12:11:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_CREDIT_INFO")
public class AcrmFciCreditInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 数据日期 **/
	@Column(name = "DATA_DT", unique = false, nullable = true, length = 8)
	private Date dataDt;
	
	/** 最近更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最近更新时间 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 11)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户标识 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 信贷信用等级 **/
	@Column(name = "CREDIT_LEV", unique = false, nullable = true, length = 20)
	private String creditLev;
	
	/** 信贷信用等级评定日期 **/
	@Column(name = "CREDIT_EVAL_DATE", unique = false, nullable = true, length = 8)
	private String creditEvalDate;
	
	/** 信贷信用评定到期日期 **/
	@Column(name = "CREDIT_DUE_DATE", unique = false, nullable = true, length = 8)
	private String creditDueDate;
	
	/** 手工调整信贷信用等级 **/
	@Column(name = "MANU_ADJ_LEV", unique = false, nullable = true, length = 20)
	private String manuAdjLev;
	
	/** 手工调整生效日期 **/
	@Column(name = "ADJ_EFFECT_DATE", unique = false, nullable = true, length = 8)
	private String adjEffectDate;
	
	/** 手工调整发起机构 **/
	@Column(name = "ADJ_BRCH_NO", unique = false, nullable = true, length = 20)
	private String adjBrchNo;
	
	/** ID主键 **/
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	private String id;
	
	

	
	

	public Date getDataDt() {
		return dataDt;
	}

	public void setDataDt(Date dataDt) {
		this.dataDt = dataDt;
	}

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
	 * @param creditLev
	 */
	public void setCreditLev(String creditLev) {
		this.creditLev = creditLev == null ? null : creditLev.trim();
	}
	
    /**
     * @return CreditLev
     */	
	public String getCreditLev() {
		return this.creditLev;
	}
	
	/**
	 * @param creditEvalDate
	 */
	public void setCreditEvalDate(String creditEvalDate) {
		this.creditEvalDate = creditEvalDate == null ? null : creditEvalDate.trim();
	}
	
    /**
     * @return CreditEvalDate
     */	
	public String getCreditEvalDate() {
		return this.creditEvalDate;
	}
	
	/**
	 * @param creditDueDate
	 */
	public void setCreditDueDate(String creditDueDate) {
		this.creditDueDate = creditDueDate == null ? null : creditDueDate.trim();
	}
	
    /**
     * @return CreditDueDate
     */	
	public String getCreditDueDate() {
		return this.creditDueDate;
	}
	
	/**
	 * @param manuAdjLev
	 */
	public void setManuAdjLev(String manuAdjLev) {
		this.manuAdjLev = manuAdjLev == null ? null : manuAdjLev.trim();
	}
	
    /**
     * @return ManuAdjLev
     */	
	public String getManuAdjLev() {
		return this.manuAdjLev;
	}
	
	/**
	 * @param adjEffectDate
	 */
	public void setAdjEffectDate(String adjEffectDate) {
		this.adjEffectDate = adjEffectDate == null ? null : adjEffectDate.trim();
	}
	
    /**
     * @return AdjEffectDate
     */	
	public String getAdjEffectDate() {
		return this.adjEffectDate;
	}
	
	/**
	 * @param adjBrchNo
	 */
	public void setAdjBrchNo(String adjBrchNo) {
		this.adjBrchNo = adjBrchNo == null ? null : adjBrchNo.trim();
	}
	
    /**
     * @return AdjBrchNo
     */	
	public String getAdjBrchNo() {
		return this.adjBrchNo;
	}
	
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
        AcrmFciCreditInfo other = (AcrmFciCreditInfo) that;
		return (this.getDataDt() == null ? other.getDataDt() == null : this.getDataDt().equals(other.getDataDt()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCreditLev() == null ? other.getCreditLev() == null : this.getCreditLev().equals(other.getCreditLev()))
        	&& (this.getCreditEvalDate() == null ? other.getCreditEvalDate() == null : this.getCreditEvalDate().equals(other.getCreditEvalDate()))
        	&& (this.getCreditDueDate() == null ? other.getCreditDueDate() == null : this.getCreditDueDate().equals(other.getCreditDueDate()))
        	&& (this.getManuAdjLev() == null ? other.getManuAdjLev() == null : this.getManuAdjLev().equals(other.getManuAdjLev()))
        	&& (this.getAdjEffectDate() == null ? other.getAdjEffectDate() == null : this.getAdjEffectDate().equals(other.getAdjEffectDate()))
        	&& (this.getAdjBrchNo() == null ? other.getAdjBrchNo() == null : this.getAdjBrchNo().equals(other.getAdjBrchNo()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDt() == null) ? 0 : getDataDt().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCreditLev() == null) ? 0 : getCreditLev().hashCode());
        result = prime * result + ((getCreditEvalDate() == null) ? 0 : getCreditEvalDate().hashCode());
        result = prime * result + ((getCreditDueDate() == null) ? 0 : getCreditDueDate().hashCode());
        result = prime * result + ((getManuAdjLev() == null) ? 0 : getManuAdjLev().hashCode());
        result = prime * result + ((getAdjEffectDate() == null) ? 0 : getAdjEffectDate().hashCode());
        result = prime * result + ((getAdjBrchNo() == null) ? 0 : getAdjBrchNo().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDt=").append(dataDt);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", creditLev=").append(creditLev);
		sb.append(", creditEvalDate=").append(creditEvalDate);
		sb.append(", creditDueDate=").append(creditDueDate);
		sb.append(", manuAdjLev=").append(manuAdjLev);
		sb.append(", adjEffectDate=").append(adjEffectDate);
		sb.append(", adjBrchNo=").append(adjBrchNo);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}