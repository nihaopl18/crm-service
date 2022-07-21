package cn.com.yusys.yscrm.cust.org.domain;

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
 * @类名称: OcrmFciOrgOthbankInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-27 11:07:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_ORG_OTHBANK_INFO")
public class OcrmFciOrgOthbankInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID", unique = false, nullable = false, length = 32)
	private String id;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建机构编号 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建日期 **/
	@Transient
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建人 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最近更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户标识 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 开户机构名称 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 200)
	private String orgId;
	
	/** 是否基本开户行 **/
	@Column(name = "BASE_BANK_FLG", unique = false, nullable = true, length = 10)
	private String baseBankFlg;
	
	/** 合作年限 **/
	@Column(name = "CORP_YEAR", unique = false, nullable = true, length = 10)
	private String corpYear;
	
	/** 产品使用情况 **/
	@Column(name = "PROD_USAGE", unique = false, nullable = true, length = 200)
	private String prodUsage;
	
	/** 活期时点 **/
	@Column(name = "CDEP_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal cdepBal;
	
	/** 定期时点 **/
	@Column(name = "TDEP_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal tdepBal;
	
	/** 贷款余额时点 **/
	@Column(name = "LOAN_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal loanBal;
	
	/** 贷款利率 **/
	@Column(name = "LOAN_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanRate;
	
	/** 抵押物 **/
	@Column(name = "MORTGAGEE_NO", unique = false, nullable = true, length = 30)
	private String mortgageeNo;
	
	/** 质押物 **/
	@Column(name = "PLEDGE_NO", unique = false, nullable = true, length = 30)
	private String pledgeNo;
	
	/** 还款方式 **/
	@Column(name = "REPAY_WAY", unique = false, nullable = true, length = 10)
	private String repayWay;
	
	/** 授信总额 **/
	@Column(name = "CREDIT_LIMIT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal creditLimit;
	
	/** 授信期限 **/
	@Column(name = "CREDIT_TERM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal creditTerm;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	
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
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate == null ? null : dataDate.trim();
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param cratOrgId
	 */
	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId == null ? null : cratOrgId.trim();
	}
	
    /**
     * @return CratOrgId
     */	
	public String getCratOrgId() {
		return this.cratOrgId;
	}
	
	/**
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr == null ? null : cratUsr.trim();
	}
	
    /**
     * @return CratUsr
     */	
	public String getCratUsr() {
		return this.cratUsr;
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
	 * @param baseBankFlg
	 */
	public void setBaseBankFlg(String baseBankFlg) {
		this.baseBankFlg = baseBankFlg == null ? null : baseBankFlg.trim();
	}
	
    /**
     * @return BaseBankFlg
     */	
	public String getBaseBankFlg() {
		return this.baseBankFlg;
	}
	
	/**
	 * @param corpYear
	 */
	public void setCorpYear(String corpYear) {
		this.corpYear = corpYear == null ? null : corpYear.trim();
	}
	
    /**
     * @return CorpYear
     */	
	public String getCorpYear() {
		return this.corpYear;
	}
	
	/**
	 * @param prodUsage
	 */
	public void setProdUsage(String prodUsage) {
		this.prodUsage = prodUsage == null ? null : prodUsage.trim();
	}
	
    /**
     * @return ProdUsage
     */	
	public String getProdUsage() {
		return this.prodUsage;
	}
	
	/**
	 * @param cdepBal
	 */
	public void setCdepBal(java.math.BigDecimal cdepBal) {
		this.cdepBal = cdepBal;
	}
	
    /**
     * @return CdepBal
     */	
	public java.math.BigDecimal getCdepBal() {
		return this.cdepBal;
	}
	
	/**
	 * @param tdepBal
	 */
	public void setTdepBal(java.math.BigDecimal tdepBal) {
		this.tdepBal = tdepBal;
	}
	
    /**
     * @return TdepBal
     */	
	public java.math.BigDecimal getTdepBal() {
		return this.tdepBal;
	}
	
	/**
	 * @param loanBal
	 */
	public void setLoanBal(java.math.BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	
    /**
     * @return LoanBal
     */	
	public java.math.BigDecimal getLoanBal() {
		return this.loanBal;
	}
	
	/**
	 * @param loanRate
	 */
	public void setLoanRate(java.math.BigDecimal loanRate) {
		this.loanRate = loanRate;
	}
	
    /**
     * @return LoanRate
     */	
	public java.math.BigDecimal getLoanRate() {
		return this.loanRate;
	}
	
	/**
	 * @param mortgageeNo
	 */
	public void setMortgageeNo(String mortgageeNo) {
		this.mortgageeNo = mortgageeNo == null ? null : mortgageeNo.trim();
	}
	
    /**
     * @return MortgageeNo
     */	
	public String getMortgageeNo() {
		return this.mortgageeNo;
	}
	
	/**
	 * @param pledgeNo
	 */
	public void setPledgeNo(String pledgeNo) {
		this.pledgeNo = pledgeNo == null ? null : pledgeNo.trim();
	}
	
    /**
     * @return PledgeNo
     */	
	public String getPledgeNo() {
		return this.pledgeNo;
	}
	
	/**
	 * @param repayWay
	 */
	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay == null ? null : repayWay.trim();
	}
	
    /**
     * @return RepayWay
     */	
	public String getRepayWay() {
		return this.repayWay;
	}
	
	/**
	 * @param creditLimit
	 */
	public void setCreditLimit(java.math.BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}
	
    /**
     * @return CreditLimit
     */	
	public java.math.BigDecimal getCreditLimit() {
		return this.creditLimit;
	}
	
	/**
	 * @param creditTerm
	 */
	public void setCreditTerm(java.math.BigDecimal creditTerm) {
		this.creditTerm = creditTerm;
	}
	
    /**
     * @return CreditTerm
     */	
	public java.math.BigDecimal getCreditTerm() {
		return this.creditTerm;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
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
        OcrmFciOrgOthbankInfo other = (OcrmFciOrgOthbankInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
                	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
        	&& (this.getBaseBankFlg() == null ? other.getBaseBankFlg() == null : this.getBaseBankFlg().equals(other.getBaseBankFlg()))
        	&& (this.getCorpYear() == null ? other.getCorpYear() == null : this.getCorpYear().equals(other.getCorpYear()))
        	&& (this.getProdUsage() == null ? other.getProdUsage() == null : this.getProdUsage().equals(other.getProdUsage()))
                                        	&& (this.getMortgageeNo() == null ? other.getMortgageeNo() == null : this.getMortgageeNo().equals(other.getMortgageeNo()))
        	&& (this.getPledgeNo() == null ? other.getPledgeNo() == null : this.getPledgeNo().equals(other.getPledgeNo()))
        	&& (this.getRepayWay() == null ? other.getRepayWay() == null : this.getRepayWay().equals(other.getRepayWay()))
                        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getBaseBankFlg() == null) ? 0 : getBaseBankFlg().hashCode());
        result = prime * result + ((getCorpYear() == null) ? 0 : getCorpYear().hashCode());
        result = prime * result + ((getProdUsage() == null) ? 0 : getProdUsage().hashCode());
        result = prime * result + ((getMortgageeNo() == null) ? 0 : getMortgageeNo().hashCode());
        result = prime * result + ((getPledgeNo() == null) ? 0 : getPledgeNo().hashCode());
        result = prime * result + ((getRepayWay() == null) ? 0 : getRepayWay().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", orgId=").append(orgId);
		sb.append(", baseBankFlg=").append(baseBankFlg);
		sb.append(", corpYear=").append(corpYear);
		sb.append(", prodUsage=").append(prodUsage);
		sb.append(", cdepBal=").append(cdepBal);
		sb.append(", tdepBal=").append(tdepBal);
		sb.append(", loanBal=").append(loanBal);
		sb.append(", loanRate=").append(loanRate);
		sb.append(", mortgageeNo=").append(mortgageeNo);
		sb.append(", pledgeNo=").append(pledgeNo);
		sb.append(", repayWay=").append(repayWay);
		sb.append(", creditLimit=").append(creditLimit);
		sb.append(", creditTerm=").append(creditTerm);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}