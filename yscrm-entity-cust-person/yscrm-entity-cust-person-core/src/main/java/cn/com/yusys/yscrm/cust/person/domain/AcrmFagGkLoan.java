package cn.com.yusys.yscrm.cust.person.domain;

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
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagGkLoan
 * @类描述: #数据实体类
 * @功能描述: 概览-贷款业务概览
 * @创建人: 15104
 * @创建时间: 2019-01-26 23:54:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_GK_LOAN")
public class AcrmFagGkLoan extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户编号
 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 贷款类型
 **/
	@Column(name = "LOAN_TYPE", unique = false, nullable = true, length = 40)
	private String loanType;
	
	/** 币种代码
 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 贷款余额
 **/
	@Column(name = "LOAN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanBal;
	
	/** 正常余额
 **/
	@Column(name = "REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal regularBal;
	
	/** 月日均正常余额
 **/
	@Column(name = "MONTH_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal monthAvgRegularBal;
	
	/** 季日均正常余额
 **/
	@Column(name = "QUAR_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal quarAvgRegularBal;
	
	/** 半年日均正常余额
 **/
	@Column(name = "HALF_YEAR_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal halfYearAvgRegularBal;
	
	/** 年日均正常余额
 **/
	@Column(name = "YEAR_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal yearAvgRegularBal;
	
	/** 上年同期贷款余额
 **/
	@Column(name = "LY_LOAN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyLoanBal;
	
	/** 上年同期正常余额
 **/
	@Column(name = "LY_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyRegularBal;
	
	/** 上年同期月日均正常余额
 **/
	@Column(name = "LY_MONTH_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyMonthAvgRegularBal;
	
	/** 上年同期季日均正常余额
 **/
	@Column(name = "LY_QUAR_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyQuarAvgRegularBal;
	
	/** 上年同期半年日均正常余额
 **/
	@Column(name = "LY_HALF_YEAR_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyHalfYearAvgRegularBal;
	
	/** 上年同期年日均正常余额
 **/
	@Column(name = "LY_YEAR_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyYearAvgRegularBal;
	
	
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
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
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
	 * @param loanType
	 */
	public void setLoanType(String loanType) {
		this.loanType = loanType == null ? null : loanType.trim();
	}
	
    /**
     * @return LoanType
     */	
	public String getLoanType() {
		return this.loanType;
	}
	
	/**
	 * @param ccyCd
	 */
	public void setCcyCd(String ccyCd) {
		this.ccyCd = ccyCd == null ? null : ccyCd.trim();
	}
	
    /**
     * @return CcyCd
     */	
	public String getCcyCd() {
		return this.ccyCd;
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
	 * @param regularBal
	 */
	public void setRegularBal(java.math.BigDecimal regularBal) {
		this.regularBal = regularBal;
	}
	
    /**
     * @return RegularBal
     */	
	public java.math.BigDecimal getRegularBal() {
		return this.regularBal;
	}
	
	/**
	 * @param monthAvgRegularBal
	 */
	public void setMonthAvgRegularBal(java.math.BigDecimal monthAvgRegularBal) {
		this.monthAvgRegularBal = monthAvgRegularBal;
	}
	
    /**
     * @return MonthAvgRegularBal
     */	
	public java.math.BigDecimal getMonthAvgRegularBal() {
		return this.monthAvgRegularBal;
	}
	
	/**
	 * @param quarAvgRegularBal
	 */
	public void setQuarAvgRegularBal(java.math.BigDecimal quarAvgRegularBal) {
		this.quarAvgRegularBal = quarAvgRegularBal;
	}
	
    /**
     * @return QuarAvgRegularBal
     */	
	public java.math.BigDecimal getQuarAvgRegularBal() {
		return this.quarAvgRegularBal;
	}
	
	/**
	 * @param halfYearAvgRegularBal
	 */
	public void setHalfYearAvgRegularBal(java.math.BigDecimal halfYearAvgRegularBal) {
		this.halfYearAvgRegularBal = halfYearAvgRegularBal;
	}
	
    /**
     * @return HalfYearAvgRegularBal
     */	
	public java.math.BigDecimal getHalfYearAvgRegularBal() {
		return this.halfYearAvgRegularBal;
	}
	
	/**
	 * @param yearAvgRegularBal
	 */
	public void setYearAvgRegularBal(java.math.BigDecimal yearAvgRegularBal) {
		this.yearAvgRegularBal = yearAvgRegularBal;
	}
	
    /**
     * @return YearAvgRegularBal
     */	
	public java.math.BigDecimal getYearAvgRegularBal() {
		return this.yearAvgRegularBal;
	}
	
	/**
	 * @param lyLoanBal
	 */
	public void setLyLoanBal(java.math.BigDecimal lyLoanBal) {
		this.lyLoanBal = lyLoanBal;
	}
	
    /**
     * @return LyLoanBal
     */	
	public java.math.BigDecimal getLyLoanBal() {
		return this.lyLoanBal;
	}
	
	/**
	 * @param lyRegularBal
	 */
	public void setLyRegularBal(java.math.BigDecimal lyRegularBal) {
		this.lyRegularBal = lyRegularBal;
	}
	
    /**
     * @return LyRegularBal
     */	
	public java.math.BigDecimal getLyRegularBal() {
		return this.lyRegularBal;
	}
	
	/**
	 * @param lyMonthAvgRegularBal
	 */
	public void setLyMonthAvgRegularBal(java.math.BigDecimal lyMonthAvgRegularBal) {
		this.lyMonthAvgRegularBal = lyMonthAvgRegularBal;
	}
	
    /**
     * @return LyMonthAvgRegularBal
     */	
	public java.math.BigDecimal getLyMonthAvgRegularBal() {
		return this.lyMonthAvgRegularBal;
	}
	
	/**
	 * @param lyQuarAvgRegularBal
	 */
	public void setLyQuarAvgRegularBal(java.math.BigDecimal lyQuarAvgRegularBal) {
		this.lyQuarAvgRegularBal = lyQuarAvgRegularBal;
	}
	
    /**
     * @return LyQuarAvgRegularBal
     */	
	public java.math.BigDecimal getLyQuarAvgRegularBal() {
		return this.lyQuarAvgRegularBal;
	}
	
	/**
	 * @param lyHalfYearAvgRegularBal
	 */
	public void setLyHalfYearAvgRegularBal(java.math.BigDecimal lyHalfYearAvgRegularBal) {
		this.lyHalfYearAvgRegularBal = lyHalfYearAvgRegularBal;
	}
	
    /**
     * @return LyHalfYearAvgRegularBal
     */	
	public java.math.BigDecimal getLyHalfYearAvgRegularBal() {
		return this.lyHalfYearAvgRegularBal;
	}
	
	/**
	 * @param lyYearAvgRegularBal
	 */
	public void setLyYearAvgRegularBal(java.math.BigDecimal lyYearAvgRegularBal) {
		this.lyYearAvgRegularBal = lyYearAvgRegularBal;
	}
	
    /**
     * @return LyYearAvgRegularBal
     */	
	public java.math.BigDecimal getLyYearAvgRegularBal() {
		return this.lyYearAvgRegularBal;
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
        AcrmFagGkLoan other = (AcrmFagGkLoan) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getLoanType() == null ? other.getLoanType() == null : this.getLoanType().equals(other.getLoanType()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
                                                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getLoanType() == null) ? 0 : getLoanType().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", custId=").append(custId);
		sb.append(", loanType=").append(loanType);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", loanBal=").append(loanBal);
		sb.append(", regularBal=").append(regularBal);
		sb.append(", monthAvgRegularBal=").append(monthAvgRegularBal);
		sb.append(", quarAvgRegularBal=").append(quarAvgRegularBal);
		sb.append(", halfYearAvgRegularBal=").append(halfYearAvgRegularBal);
		sb.append(", yearAvgRegularBal=").append(yearAvgRegularBal);
		sb.append(", lyLoanBal=").append(lyLoanBal);
		sb.append(", lyRegularBal=").append(lyRegularBal);
		sb.append(", lyMonthAvgRegularBal=").append(lyMonthAvgRegularBal);
		sb.append(", lyQuarAvgRegularBal=").append(lyQuarAvgRegularBal);
		sb.append(", lyHalfYearAvgRegularBal=").append(lyHalfYearAvgRegularBal);
		sb.append(", lyYearAvgRegularBal=").append(lyYearAvgRegularBal);
        sb.append("]");
        return sb.toString();
    }
}