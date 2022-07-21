package cn.com.yusys.yscrm.cust.org.domain;

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
	@Column(name = "ACCT_ID", unique = false, nullable = true, length = 32)
	private String acctId;
	@Column(name = "ACCT_PROP_CD", unique = false, nullable = true, length = 2)
	private String acctPropCd;
	/** 主账号
 **/
	@Column(name = "ACCT_NO", unique = false, nullable = true, length = 32)
	private String acctNo;
	public String getAcctPropCd() {
		return acctPropCd;
	}

	public void setAcctPropCd(String acctPropCd) {
		this.acctPropCd = acctPropCd;
	}

	@Column(name = "STR_DT", unique = false, nullable = true, length = 10)
	private Date strDt;
	@Column(name = "DUE_DT", unique = false, nullable = true, length = 10)
	private Date dueDt;
	
	/** 卡号
 **/
	@Column(name = "CARD_ID", unique = false, nullable = true, length = 20)
	private String cardId;
	
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
     * @return dataDate
     */	
	public String getDataDate() {
		return this.dataDate;
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
        AcrmFagSaveInfo other = (AcrmFagSaveInfo) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getAcctId() == null ? other.getAcctId() == null : this.getAcctId().equals(other.getAcctId()))
        	&& (this.getAcctNo() == null ? other.getAcctNo() == null : this.getAcctNo().equals(other.getAcctNo()))
        	&& (this.getCardId() == null ? other.getCardId() == null : this.getCardId().equals(other.getCardId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getAcctType() == null ? other.getAcctType() == null : this.getAcctType().equals(other.getAcctType()))
        	&& (this.getCurrCd() == null ? other.getCurrCd() == null : this.getCurrCd().equals(other.getCurrCd()))
        	&& (this.getOpenDate() == null ? other.getOpenDate() == null : this.getOpenDate().equals(other.getOpenDate()))
        	&& (this.getCloseDate() == null ? other.getCloseDate() == null : this.getCloseDate().equals(other.getCloseDate()))
        	&& (this.getOpenBrchNo() == null ? other.getOpenBrchNo() == null : this.getOpenBrchNo().equals(other.getOpenBrchNo()))
        	&& (this.getTerm() == null ? other.getTerm() == null : this.getTerm().equals(other.getTerm()))
                                                	&& (this.getAcctStat() == null ? other.getAcctStat() == null : this.getAcctStat().equals(other.getAcctStat()))
                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getAcctId() == null) ? 0 : getAcctId().hashCode());
        result = prime * result + ((getAcctNo() == null) ? 0 : getAcctNo().hashCode());
        result = prime * result + ((getCardId() == null) ? 0 : getCardId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getAcctType() == null) ? 0 : getAcctType().hashCode());
        result = prime * result + ((getCurrCd() == null) ? 0 : getCurrCd().hashCode());
        result = prime * result + ((getOpenDate() == null) ? 0 : getOpenDate().hashCode());
        result = prime * result + ((getCloseDate() == null) ? 0 : getCloseDate().hashCode());
        result = prime * result + ((getOpenBrchNo() == null) ? 0 : getOpenBrchNo().hashCode());
        result = prime * result + ((getTerm() == null) ? 0 : getTerm().hashCode());
        result = prime * result + ((getAcctStat() == null) ? 0 : getAcctStat().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", acctId=").append(acctId);
		sb.append(", acctNo=").append(acctNo);
		sb.append(", cardId=").append(cardId);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", acctType=").append(acctType);
		sb.append(", currCd=").append(currCd);
		sb.append(", openDate=").append(openDate);
		sb.append(", closeDate=").append(closeDate);
		sb.append(", openBrchNo=").append(openBrchNo);
		sb.append(", term=").append(term);
		sb.append(", openAmt=").append(openAmt);
		sb.append(", acctBal=").append(acctBal);
		sb.append(", fctdepNum=").append(fctdepNum);
		sb.append(", drwBefAmt=").append(drwBefAmt);
		sb.append(", baseRate=").append(baseRate);
		sb.append(", acctStat=").append(acctStat);
		sb.append(", acctAvgBal3=").append(acctAvgBal3);
		sb.append(", acctAvgBal6=").append(acctAvgBal6);
		sb.append(", yearAvgBal=").append(yearAvgBal);
		sb.append(", lyYearAvgBal=").append(lyYearAvgBal);
		sb.append(", contriDeposit=").append(contriDeposit);
		sb.append(", lyContriDeposit=").append(lyContriDeposit);
		sb.append(", profitDeposit=").append(profitDeposit);
		sb.append(", dataDate=").append(dataDate);
        sb.append("]");
        return sb.toString();
    }
}