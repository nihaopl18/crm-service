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
 * @类名称: AcrmFagSaveInfo
 * @类描述: #数据实体类
 * @功能描述: 账户信息-存款账户实时余额
 * @创建人: 15104
 * @创建时间: 2019-01-28 00:15:51
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_SAVE_INFO")
public class AcrmFagSaveInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户号
 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 帐户标识
 **/
	@Column(name = "ACCT_PROP_CD", unique = false, nullable = true, length = 2)
	private String acctPropCd;
	public String getAcctPropCd() {
		return acctPropCd;
	}

	public void setAcctPropCd(String acctPropCd) {
		this.acctPropCd = acctPropCd;
	}

	@Column(name = "ACCT_ID", unique = false, nullable = true, length = 32)
	private String acctId;
	@Column(name = "STR_DT", unique = false, nullable = true, length = 10)
	private Date strDt;
	@Column(name = "DUE_DT", unique = false, nullable = true, length = 10)
	private Date dueDt;
	
	public Date getStrDt() {
		return strDt;
	}

	public void setStrDt(Date strDt) {
		this.strDt = strDt;
	}

	public Date getDueDt() {
		return dueDt;
	}

	public void setDueDt(Date dueDt) {
		this.dueDt = dueDt;
	}

	/** 主账号
 **/
	@Column(name = "ACCT_NO", unique = false, nullable = true, length = 32)
	private String acctNo;
	
	/** 卡号
 **/
	@Column(name = "CARD_ID", unique = false, nullable = true, length = 20)
	private String cardId;
	
	/** 客户名称
 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 账户类型
 **/
	@Column(name = "ACCT_TYPE", unique = false, nullable = true, length = 30)
	private String acctType;
	
	/** 币种
 **/
	@Column(name = "CURR_CD", unique = false, nullable = true, length = 30)
	private String currCd;
	
	/** 开户日期
 **/
	@Column(name = "OPEN_DATE", unique = false, nullable = true, length = 8)
	private String openDate;
	
	/** 销户日期
 **/
	@Column(name = "CLOSE_DATE", unique = false, nullable = true, length = 8)
	private String closeDate;
	
	/** 开户机构
 **/
	@Column(name = "OPEN_BRCH_NO", unique = false, nullable = true, length = 30)
	private String openBrchNo;
	
	/** 存期(定期)
 **/
	@Column(name = "TERM", unique = false, nullable = true, length = 10)
	private String term;
	
	/** 定期本金(定期)
 **/
	@Column(name = "OPEN_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal openAmt;
	
	/** 帐户余额
 **/
	@Column(name = "ACCT_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal acctBal;
	
	/** 已转存次数
 **/
	@Column(name = "FCTDEP_NUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal fctdepNum;
	
	/** 部提金额(定期)
 **/
	@Column(name = "DRW_BEF_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal drwBefAmt;
	
	/** 利率
 **/
	@Column(name = "BASE_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal baseRate;
	
	@Column(name = "USED_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal usedRate;
	public java.math.BigDecimal getUsedRate() {
		return usedRate;
	}

	public void setUsedRate(java.math.BigDecimal usedRate) {
		this.usedRate = usedRate;
	}

	/** 帐户状态
 **/
	@Column(name = "ACCT_STAT", unique = false, nullable = true, length = 10)
	private String acctStat;
	
	/** 近三个月日均余额
 **/
	@Column(name = "ACCT_AVG_BAL_3", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal acctAvgBal3;
	
	/** 近六个月日均余额
 **/
	@Column(name = "ACCT_AVG_BAL_6", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal acctAvgBal6;
	
	/** 本年日均余额
 **/
	@Column(name = "YEAR_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal yearAvgBal;
	
	/** 上年日均余额
 **/
	@Column(name = "LY_YEAR_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyYearAvgBal;
	
	/** 上期贡献度
 **/
	@Column(name = "CONTRI_DEPOSIT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal contriDeposit;
	
	/** 上年贡献度
 **/
	@Column(name = "LY_CONTRI_DEPOSIT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lyContriDeposit;
	
	/** 存款创利
 **/
	@Column(name = "PROFIT_DEPOSIT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal profitDeposit;
	
	/** 数据日期
 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	
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
	 * @param acctId
	 */
	public void setAcctId(String acctId) {
		this.acctId = acctId == null ? null : acctId.trim();
	}
	
    /**
     * @return AcctId
     */	
	public String getAcctId() {
		return this.acctId;
	}
	
	/**
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo == null ? null : acctNo.trim();
	}
	
    /**
     * @return AcctNo
     */	
	public String getAcctNo() {
		return this.acctNo;
	}
	
	/**
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId == null ? null : cardId.trim();
	}
	
    /**
     * @return CardId
     */	
	public String getCardId() {
		return this.cardId;
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
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}
	
    /**
     * @return CustName
     */	
	public String getCustName() {
		return this.custName;
	}
	
	/**
	 * @param acctType
	 */
	public void setAcctType(String acctType) {
		this.acctType = acctType == null ? null : acctType.trim();
	}
	
    /**
     * @return AcctType
     */	
	public String getAcctType() {
		return this.acctType;
	}
	
	/**
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd == null ? null : currCd.trim();
	}
	
    /**
     * @return CurrCd
     */	
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * @param openDate
	 */
	public void setOpenDate(String openDate) {
		this.openDate = openDate == null ? null : openDate.trim();
	}
	
    /**
     * @return OpenDate
     */	
	public String getOpenDate() {
		return this.openDate;
	}
	
	/**
	 * @param closeDate
	 */
	public void setCloseDate(String closeDate) {
		this.closeDate = closeDate == null ? null : closeDate.trim();
	}
	
    /**
     * @return CloseDate
     */	
	public String getCloseDate() {
		return this.closeDate;
	}
	
	/**
	 * @param openBrchNo
	 */
	public void setOpenBrchNo(String openBrchNo) {
		this.openBrchNo = openBrchNo == null ? null : openBrchNo.trim();
	}
	
    /**
     * @return OpenBrchNo
     */	
	public String getOpenBrchNo() {
		return this.openBrchNo;
	}
	
	/**
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term == null ? null : term.trim();
	}
	
    /**
     * @return Term
     */	
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * @param openAmt
	 */
	public void setOpenAmt(java.math.BigDecimal openAmt) {
		this.openAmt = openAmt;
	}
	
    /**
     * @return OpenAmt
     */	
	public java.math.BigDecimal getOpenAmt() {
		return this.openAmt;
	}
	
	/**
	 * @param acctBal
	 */
	public void setAcctBal(java.math.BigDecimal acctBal) {
		this.acctBal = acctBal;
	}
	
    /**
     * @return AcctBal
     */	
	public java.math.BigDecimal getAcctBal() {
		return this.acctBal;
	}
	
	/**
	 * @param fctdepNum
	 */
	public void setFctdepNum(java.math.BigDecimal fctdepNum) {
		this.fctdepNum = fctdepNum;
	}
	
    /**
     * @return FctdepNum
     */	
	public java.math.BigDecimal getFctdepNum() {
		return this.fctdepNum;
	}
	
	/**
	 * @param drwBefAmt
	 */
	public void setDrwBefAmt(java.math.BigDecimal drwBefAmt) {
		this.drwBefAmt = drwBefAmt;
	}
	
    /**
     * @return DrwBefAmt
     */	
	public java.math.BigDecimal getDrwBefAmt() {
		return this.drwBefAmt;
	}
	
	/**
	 * @param baseRate
	 */
	public void setBaseRate(java.math.BigDecimal baseRate) {
		this.baseRate = baseRate;
	}
	
    /**
     * @return BaseRate
     */	
	public java.math.BigDecimal getBaseRate() {
		return this.baseRate;
	}
	
	/**
	 * @param acctStat
	 */
	public void setAcctStat(String acctStat) {
		this.acctStat = acctStat == null ? null : acctStat.trim();
	}
	
    /**
     * @return AcctStat
     */	
	public String getAcctStat() {
		return this.acctStat;
	}
	
	/**
	 * @param acctAvgBal3
	 */
	public void setAcctAvgBal3(java.math.BigDecimal acctAvgBal3) {
		this.acctAvgBal3 = acctAvgBal3;
	}
	
    /**
     * @return AcctAvgBal3
     */	
	public java.math.BigDecimal getAcctAvgBal3() {
		return this.acctAvgBal3;
	}
	
	/**
	 * @param acctAvgBal6
	 */
	public void setAcctAvgBal6(java.math.BigDecimal acctAvgBal6) {
		this.acctAvgBal6 = acctAvgBal6;
	}
	
    /**
     * @return AcctAvgBal6
     */	
	public java.math.BigDecimal getAcctAvgBal6() {
		return this.acctAvgBal6;
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
	
	/**
	 * @param contriDeposit
	 */
	public void setContriDeposit(java.math.BigDecimal contriDeposit) {
		this.contriDeposit = contriDeposit;
	}
	
    /**
     * @return ContriDeposit
     */	
	public java.math.BigDecimal getContriDeposit() {
		return this.contriDeposit;
	}
	
	/**
	 * @param lyContriDeposit
	 */
	public void setLyContriDeposit(java.math.BigDecimal lyContriDeposit) {
		this.lyContriDeposit = lyContriDeposit;
	}
	
    /**
     * @return LyContriDeposit
     */	
	public java.math.BigDecimal getLyContriDeposit() {
		return this.lyContriDeposit;
	}
	
	/**
	 * @param profitDeposit
	 */
	public void setProfitDeposit(java.math.BigDecimal profitDeposit) {
		this.profitDeposit = profitDeposit;
	}
	
    /**
     * @return ProfitDeposit
     */	
	public java.math.BigDecimal getProfitDeposit() {
		return this.profitDeposit;
	}
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return EtlDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcrmFagSaveInfo other = (AcrmFagSaveInfo) obj;
		if (acctAvgBal3 == null) {
			if (other.acctAvgBal3 != null)
				return false;
		} else if (!acctAvgBal3.equals(other.acctAvgBal3))
			return false;
		if (acctAvgBal6 == null) {
			if (other.acctAvgBal6 != null)
				return false;
		} else if (!acctAvgBal6.equals(other.acctAvgBal6))
			return false;
		if (acctBal == null) {
			if (other.acctBal != null)
				return false;
		} else if (!acctBal.equals(other.acctBal))
			return false;
		if (acctId == null) {
			if (other.acctId != null)
				return false;
		} else if (!acctId.equals(other.acctId))
			return false;
		if (acctNo == null) {
			if (other.acctNo != null)
				return false;
		} else if (!acctNo.equals(other.acctNo))
			return false;
		if (acctStat == null) {
			if (other.acctStat != null)
				return false;
		} else if (!acctStat.equals(other.acctStat))
			return false;
		if (acctType == null) {
			if (other.acctType != null)
				return false;
		} else if (!acctType.equals(other.acctType))
			return false;
		if (baseRate == null) {
			if (other.baseRate != null)
				return false;
		} else if (!baseRate.equals(other.baseRate))
			return false;
		if (cardId == null) {
			if (other.cardId != null)
				return false;
		} else if (!cardId.equals(other.cardId))
			return false;
		if (closeDate == null) {
			if (other.closeDate != null)
				return false;
		} else if (!closeDate.equals(other.closeDate))
			return false;
		if (contriDeposit == null) {
			if (other.contriDeposit != null)
				return false;
		} else if (!contriDeposit.equals(other.contriDeposit))
			return false;
		if (corpOrgCode == null) {
			if (other.corpOrgCode != null)
				return false;
		} else if (!corpOrgCode.equals(other.corpOrgCode))
			return false;
		if (currCd == null) {
			if (other.currCd != null)
				return false;
		} else if (!currCd.equals(other.currCd))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (dataDate == null) {
			if (other.dataDate != null)
				return false;
		} else if (!dataDate.equals(other.dataDate))
			return false;
		if (drwBefAmt == null) {
			if (other.drwBefAmt != null)
				return false;
		} else if (!drwBefAmt.equals(other.drwBefAmt))
			return false;
		if (dueDt == null) {
			if (other.dueDt != null)
				return false;
		} else if (!dueDt.equals(other.dueDt))
			return false;
		if (fctdepNum == null) {
			if (other.fctdepNum != null)
				return false;
		} else if (!fctdepNum.equals(other.fctdepNum))
			return false;
		if (lyContriDeposit == null) {
			if (other.lyContriDeposit != null)
				return false;
		} else if (!lyContriDeposit.equals(other.lyContriDeposit))
			return false;
		if (lyYearAvgBal == null) {
			if (other.lyYearAvgBal != null)
				return false;
		} else if (!lyYearAvgBal.equals(other.lyYearAvgBal))
			return false;
		if (openAmt == null) {
			if (other.openAmt != null)
				return false;
		} else if (!openAmt.equals(other.openAmt))
			return false;
		if (openBrchNo == null) {
			if (other.openBrchNo != null)
				return false;
		} else if (!openBrchNo.equals(other.openBrchNo))
			return false;
		if (openDate == null) {
			if (other.openDate != null)
				return false;
		} else if (!openDate.equals(other.openDate))
			return false;
		if (profitDeposit == null) {
			if (other.profitDeposit != null)
				return false;
		} else if (!profitDeposit.equals(other.profitDeposit))
			return false;
		if (strDt == null) {
			if (other.strDt != null)
				return false;
		} else if (!strDt.equals(other.strDt))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		if (usedRate == null) {
			if (other.usedRate != null)
				return false;
		} else if (!usedRate.equals(other.usedRate))
			return false;
		if (yearAvgBal == null) {
			if (other.yearAvgBal != null)
				return false;
		} else if (!yearAvgBal.equals(other.yearAvgBal))
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctAvgBal3 == null) ? 0 : acctAvgBal3.hashCode());
		result = prime * result + ((acctAvgBal6 == null) ? 0 : acctAvgBal6.hashCode());
		result = prime * result + ((acctBal == null) ? 0 : acctBal.hashCode());
		result = prime * result + ((acctId == null) ? 0 : acctId.hashCode());
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((acctStat == null) ? 0 : acctStat.hashCode());
		result = prime * result + ((acctType == null) ? 0 : acctType.hashCode());
		result = prime * result + ((baseRate == null) ? 0 : baseRate.hashCode());
		result = prime * result + ((cardId == null) ? 0 : cardId.hashCode());
		result = prime * result + ((closeDate == null) ? 0 : closeDate.hashCode());
		result = prime * result + ((contriDeposit == null) ? 0 : contriDeposit.hashCode());
		result = prime * result + ((corpOrgCode == null) ? 0 : corpOrgCode.hashCode());
		result = prime * result + ((currCd == null) ? 0 : currCd.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((dataDate == null) ? 0 : dataDate.hashCode());
		result = prime * result + ((drwBefAmt == null) ? 0 : drwBefAmt.hashCode());
		result = prime * result + ((dueDt == null) ? 0 : dueDt.hashCode());
		result = prime * result + ((fctdepNum == null) ? 0 : fctdepNum.hashCode());
		result = prime * result + ((lyContriDeposit == null) ? 0 : lyContriDeposit.hashCode());
		result = prime * result + ((lyYearAvgBal == null) ? 0 : lyYearAvgBal.hashCode());
		result = prime * result + ((openAmt == null) ? 0 : openAmt.hashCode());
		result = prime * result + ((openBrchNo == null) ? 0 : openBrchNo.hashCode());
		result = prime * result + ((openDate == null) ? 0 : openDate.hashCode());
		result = prime * result + ((profitDeposit == null) ? 0 : profitDeposit.hashCode());
		result = prime * result + ((strDt == null) ? 0 : strDt.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
		result = prime * result + ((usedRate == null) ? 0 : usedRate.hashCode());
		result = prime * result + ((yearAvgBal == null) ? 0 : yearAvgBal.hashCode());
		return result;
	}

    @Override
	public String toString() {
		return "AcrmFagSaveInfo [custId=" + custId + ", corpOrgCode=" + corpOrgCode + ", acctId=" + acctId + ", strDt="
				+ strDt + ", dueDt=" + dueDt + ", acctNo=" + acctNo + ", cardId=" + cardId + ", custName=" + custName
				+ ", acctType=" + acctType + ", currCd=" + currCd + ", openDate=" + openDate + ", closeDate="
				+ closeDate + ", openBrchNo=" + openBrchNo + ", term=" + term + ", openAmt=" + openAmt + ", acctBal="
				+ acctBal + ", fctdepNum=" + fctdepNum + ", drwBefAmt=" + drwBefAmt + ", baseRate=" + baseRate
				+ ", usedRate=" + usedRate + ", acctStat=" + acctStat + ", acctAvgBal3=" + acctAvgBal3
				+ ", acctAvgBal6=" + acctAvgBal6 + ", yearAvgBal=" + yearAvgBal + ", lyYearAvgBal=" + lyYearAvgBal
				+ ", contriDeposit=" + contriDeposit + ", lyContriDeposit=" + lyContriDeposit + ", profitDeposit="
				+ profitDeposit + ", dataDate=" + dataDate + "]";
	}
}