package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagGkSave
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-01-28 12:27:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_GK_SAVE")
public class AcrmFagGkSave extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期
 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 客户编号
 **/
	@Column(name = "CUST_ID", unique = false, nullable = false, length = 40)
	private String custId;
	
	/** 存款业务分类
 **/
	@Column(name = "DEPOSIT_TYPE", unique = false, nullable = true, length = 40)
	private String depositType;
	
	/** 币种代码
 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 日余额
 **/
	@Column(name = "DAY_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dayBal;
	
	/** 月日均余额
 **/
	@Column(name = "MONTH_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal monthAvgBal;
	
	/** 季日均余额
 **/
	@Column(name = "QUARTER_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal quarterAvgBal;
	
	/** 半年日均余额
 **/
	@Column(name = "HALF_YEAR_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal halfYearAvgBal;
	
	/** 年日均余额
 **/
	@Column(name = "YEAR_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal yearAvgBal;
	
	/** 上年同期月末日余额
 **/
	@Column(name = "LY_DAY_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyDayBal;
	
	/** 上年同期月日均余额
 **/
	@Column(name = "LY_MONTH_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyMonthAvgBal;
	
	/** 上年同期季日均余额
 **/
	@Column(name = "LY_QUARTER_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyQuarterAvgBal;
	
	/** 上年同期半年日均余额
 **/
	@Column(name = "LY_HALF_YEAR_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyHalfYearAvgBal;
	
	/** 上年同期年日均余额
 **/
	@Column(name = "LY_YEAR_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyYearAvgBal;
	
	
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
     * @return dataDate
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
     * @return custId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param depositType
	 */
	public void setDepositType(String depositType) {
		this.depositType = depositType == null ? null : depositType.trim();
	}
	
    /**
     * @return DepositType
     */	
	public String getDepositType() {
		return this.depositType;
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
	 * @param dayBal
	 */
	public void setDayBal(java.math.BigDecimal dayBal) {
		this.dayBal = dayBal;
	}
	
    /**
     * @return DayBal
     */	
	public java.math.BigDecimal getDayBal() {
		return this.dayBal;
	}
	
	/**
	 * @param monthAvgBal
	 */
	public void setMonthAvgBal(java.math.BigDecimal monthAvgBal) {
		this.monthAvgBal = monthAvgBal;
	}
	
    /**
     * @return MonthAvgBal
     */	
	public java.math.BigDecimal getMonthAvgBal() {
		return this.monthAvgBal;
	}
	
	/**
	 * @param quarterAvgBal
	 */
	public void setQuarterAvgBal(java.math.BigDecimal quarterAvgBal) {
		this.quarterAvgBal = quarterAvgBal;
	}
	
    /**
     * @return QuarterAvgBal
     */	
	public java.math.BigDecimal getQuarterAvgBal() {
		return this.quarterAvgBal;
	}
	
	/**
	 * @param halfYearAvgBal
	 */
	public void setHalfYearAvgBal(java.math.BigDecimal halfYearAvgBal) {
		this.halfYearAvgBal = halfYearAvgBal;
	}
	
    /**
     * @return HalfYearAvgBal
     */	
	public java.math.BigDecimal getHalfYearAvgBal() {
		return this.halfYearAvgBal;
	}
	
	/**
	 * @param yearAvgBal
	 */
	public void setYearAvgBal(java.math.BigDecimal yearAvgBal) {
		this.yearAvgBal = yearAvgBal;
	}
	
    /**
     * @return YearAvgBal
     */	
	public java.math.BigDecimal getYearAvgBal() {
		return this.yearAvgBal;
	}
	
	/**
	 * @param lyDayBal
	 */
	public void setLyDayBal(java.math.BigDecimal lyDayBal) {
		this.lyDayBal = lyDayBal;
	}
	
    /**
     * @return LyDayBal
     */	
	public java.math.BigDecimal getLyDayBal() {
		return this.lyDayBal;
	}
	
	/**
	 * @param lyMonthAvgBal
	 */
	public void setLyMonthAvgBal(java.math.BigDecimal lyMonthAvgBal) {
		this.lyMonthAvgBal = lyMonthAvgBal;
	}
	
    /**
     * @return LyMonthAvgBal
     */	
	public java.math.BigDecimal getLyMonthAvgBal() {
		return this.lyMonthAvgBal;
	}
	
	/**
	 * @param lyQuarterAvgBal
	 */
	public void setLyQuarterAvgBal(java.math.BigDecimal lyQuarterAvgBal) {
		this.lyQuarterAvgBal = lyQuarterAvgBal;
	}
	
    /**
     * @return LyQuarterAvgBal
     */	
	public java.math.BigDecimal getLyQuarterAvgBal() {
		return this.lyQuarterAvgBal;
	}
	
	/**
	 * @param lyHalfYearAvgBal
	 */
	public void setLyHalfYearAvgBal(java.math.BigDecimal lyHalfYearAvgBal) {
		this.lyHalfYearAvgBal = lyHalfYearAvgBal;
	}
	
    /**
     * @return LyHalfYearAvgBal
     */	
	public java.math.BigDecimal getLyHalfYearAvgBal() {
		return this.lyHalfYearAvgBal;
	}
	
	/**
	 * @param lyYearAvgBal
	 */
	public void setLyYearAvgBal(java.math.BigDecimal lyYearAvgBal) {
		this.lyYearAvgBal = lyYearAvgBal;
	}
	
    /**
     * @return LyYearAvgBal
     */	
	public java.math.BigDecimal getLyYearAvgBal() {
		return this.lyYearAvgBal;
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
        AcrmFagGkSave other = (AcrmFagGkSave) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getDepositType() == null ? other.getDepositType() == null : this.getDepositType().equals(other.getDepositType()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))                                     
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getDepositType() == null) ? 0 : getDepositType().hashCode());
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
		sb.append(", depositType=").append(depositType);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", dayBal=").append(dayBal);
		sb.append(", monthAvgBal=").append(monthAvgBal);
		sb.append(", quarterAvgBal=").append(quarterAvgBal);
		sb.append(", halfYearAvgBal=").append(halfYearAvgBal);
		sb.append(", yearAvgBal=").append(yearAvgBal);
		sb.append(", lyDayBal=").append(lyDayBal);
		sb.append(", lyMonthAvgBal=").append(lyMonthAvgBal);
		sb.append(", lyQuarterAvgBal=").append(lyQuarterAvgBal);
		sb.append(", lyHalfYearAvgBal=").append(lyHalfYearAvgBal);
		sb.append(", lyYearAvgBal=").append(lyYearAvgBal);
        sb.append("]");
        return sb.toString();
    }
}