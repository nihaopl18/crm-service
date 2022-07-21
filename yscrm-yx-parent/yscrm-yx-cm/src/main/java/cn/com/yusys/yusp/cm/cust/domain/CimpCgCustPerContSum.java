package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name = "CIMP_CG_CUST_PER_CONT_SUM")
public class CimpCgCustPerContSum extends BaseDomain implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="CUST_ID")
	private String custId;
	
	@Column(name="CORP_ORG_CODE")
	private String corpOrgCode;

	@Column(name="M_DEP_CONTRIBU")
	private BigDecimal mDepContribu;

	@Column(name="M_LOAN_CONTRIBU")
	private BigDecimal mLoanContribu;

	@Column(name="M_MID_CONTRIBU")
	private BigDecimal mMidContribu;

	@Column(name="M_SUM_CONTRIBU")
	private BigDecimal mSumContribu;

	@Column(name="Y_DEP_CONTRIBU")
	private BigDecimal yDepContribu;

	@Column(name="Y_LOAN_CONTRIBU")
	private BigDecimal yLoanContribu;

	@Column(name="Y_MID_CONTRIBU")
	private BigDecimal yMidContribu;

	@Column(name="Y_SUM_CONTRIBU")
	private BigDecimal ySumContribu;

	@Column(name="DEP_3M_CONTRIBU")
	private BigDecimal Dep3mContribu;

	@Column(name="LOAN_3M_CONTRIBU")
	private BigDecimal Loan3mContribu;

	@Column(name="MID_3M_CONTRIBU")
	private BigDecimal Mid3mContribu;

	@Column(name="SUM_3M_CONTRIBU")
	private BigDecimal Sum3mContribu;
	
	@Column(name="DEP_12M_CONTRIBU")
	private BigDecimal Dep12mContribu;

	@Column(name="LOAN_12M_CONTRIBU")
	private BigDecimal Loan12mContribu;

	@Column(name="MID_12M_CONTRIBU")
	private BigDecimal Mid12mContribu;

	@Column(name="SUM_12M_CONTRIBU")
	private BigDecimal Sum12mContribu;

	@Column(name="LAST_UPDATE_SYS")
	private String lastUpdateSys;

	@Column(name="LAST_UPDATE_USER")
	private String lastUpdateUser;

	@Column(name="LAST_UPDATE_TM")
	private Date lastUpdateTm;

	@Column(name="DATA_DATE")
	private Date dataDate;

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCorpOrgCode() {
		return corpOrgCode;
	}

	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode;
	}

	public BigDecimal getmDepContribu() {
		return mDepContribu;
	}

	public void setmDepContribu(BigDecimal mDepContribu) {
		this.mDepContribu = mDepContribu;
	}

	public BigDecimal getmLoanContribu() {
		return mLoanContribu;
	}

	public void setmLoanContribu(BigDecimal mLoanContribu) {
		this.mLoanContribu = mLoanContribu;
	}

	public BigDecimal getmMidContribu() {
		return mMidContribu;
	}

	public void setmMidContribu(BigDecimal mMidContribu) {
		this.mMidContribu = mMidContribu;
	}

	public BigDecimal getmSumContribu() {
		return mSumContribu;
	}

	public void setmSumContribu(BigDecimal mSumContribu) {
		this.mSumContribu = mSumContribu;
	}

	public BigDecimal getyDepContribu() {
		return yDepContribu;
	}

	public void setyDepContribu(BigDecimal yDepContribu) {
		this.yDepContribu = yDepContribu;
	}

	public BigDecimal getyLoanContribu() {
		return yLoanContribu;
	}

	public void setyLoanContribu(BigDecimal yLoanContribu) {
		this.yLoanContribu = yLoanContribu;
	}

	public BigDecimal getyMidContribu() {
		return yMidContribu;
	}

	public void setyMidContribu(BigDecimal yMidContribu) {
		this.yMidContribu = yMidContribu;
	}

	public BigDecimal getySumContribu() {
		return ySumContribu;
	}

	public void setySumContribu(BigDecimal ySumContribu) {
		this.ySumContribu = ySumContribu;
	}

	public BigDecimal getDep3mContribu() {
		return Dep3mContribu;
	}

	public void setDep3mContribu(BigDecimal dep3mContribu) {
		Dep3mContribu = dep3mContribu;
	}

	public BigDecimal getLoan3mContribu() {
		return Loan3mContribu;
	}

	public void setLoan3mContribu(BigDecimal loan3mContribu) {
		Loan3mContribu = loan3mContribu;
	}

	public BigDecimal getMid3mContribu() {
		return Mid3mContribu;
	}

	public void setMid3mContribu(BigDecimal mid3mContribu) {
		Mid3mContribu = mid3mContribu;
	}

	public BigDecimal getSum3mContribu() {
		return Sum3mContribu;
	}

	public void setSum3mContribu(BigDecimal sum3mContribu) {
		Sum3mContribu = sum3mContribu;
	}

	public BigDecimal getDep12mContribu() {
		return Dep12mContribu;
	}

	public void setDep12mContribu(BigDecimal dep12mContribu) {
		Dep12mContribu = dep12mContribu;
	}

	public BigDecimal getLoan12mContribu() {
		return Loan12mContribu;
	}

	public void setLoan12mContribu(BigDecimal loan12mContribu) {
		Loan12mContribu = loan12mContribu;
	}

	public BigDecimal getMid12mContribu() {
		return Mid12mContribu;
	}

	public void setMid12mContribu(BigDecimal mid12mContribu) {
		Mid12mContribu = mid12mContribu;
	}

	public BigDecimal getSum12mContribu() {
		return Sum12mContribu;
	}

	public void setSum12mContribu(BigDecimal sum12mContribu) {
		Sum12mContribu = sum12mContribu;
	}

	public String getLastUpdateSys() {
		return lastUpdateSys;
	}

	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public Date getLastUpdateTm() {
		return lastUpdateTm;
	}

	public void setLastUpdateTm(Date lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}

	public Date getDataDate() {
		return dataDate;
	}

	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}

	
}
