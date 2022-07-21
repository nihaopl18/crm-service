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
 * @类名称: AcrmFagLoanDebentInfo
 * @类描述: #数据实体类
 * @功能描述: 账户信息-个人贷款账户信息
 * @创建人: 15104
 * @创建时间: 2019-01-28 00:32:25
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_LOAN_DEBENT_INFO")
public class AcrmFagLoanDebentInfo extends BaseDomain implements Serializable{
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
	
	/** 借据编号
 **/
	@Column(name = "DEBENTURE_NO", unique = false, nullable = true, length = 50)
	private String debentureNo;
	
	/** 借据编号
 **/
	@Column(name = "DEBENTURE_MDFR", unique = false, nullable = true, length = 50)
	private String debentureMdfr;
	
	/** 合同编号
 **/
	@Column(name = "CONTR_NO", unique = false, nullable = true, length = 50)
	private String contrNo;
	
	/** 合同修饰符
 **/
	@Column(name = "CONTR_MDFR", unique = false, nullable = true, length = 50)
	private String contrMdfr;
	
	/** 币种代码
 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 客户名称
 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 放款日期
 **/
	@Transient
	@Column(name = "DRAW_DT", unique = false, nullable = true, length = 7)
	private Date drawDt;
	
	/** 到期日期
 **/
	@Transient
	@Column(name = "MATURE_DT", unique = false, nullable = true, length = 7)
	private Date matureDt;
	
	/** 贷款账号
 **/
	@Column(name = "LOAN_ACCT_ID", unique = false, nullable = true, length = 40)
	private String loanAcctId;
	
	/** 账号类型
 **/
	@Column(name = "ACCT_TYPE", unique = false, nullable = true, length = 1)
	private String acctType;
	
	/** 机构代码
 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 20)
	private String orgId;
	
	/** 开户网点名
 **/
	@Column(name = "OPEN_ORG_NAME", unique = false, nullable = true, length = 100)
	private String openOrgName;
	
	/** 产品类型
 **/
	@Column(name = "PROD_TYPE_CD", unique = false, nullable = true, length = 30)
	private String prodTypeCd;
	
	/** 公私标志
 **/
	@Column(name = "ORG_OR_PER_FLAG", unique = false, nullable = true, length = 2)
	private String orgOrPerFlag;
	
	/** 产品代码
 **/
	@Column(name = "PROD_CD", unique = false, nullable = true, length = 30)
	private String prodCd;
	
	/** 产品名称
 **/
	@Column(name = "PROD_NAME", unique = false, nullable = true, length = 200)
	private String prodName;
	
	/** 渠道代码
 **/
	@Column(name = "COMES_FROM", unique = false, nullable = true, length = 30)
	private String comesFrom;
	
	/** 当前本金金额
 **/
	@Column(name = "PRIN_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal prinAmt;
	
	/** 欠息金额
 **/
	@Column(name = "DEB_INTR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal debIntrBal;
	
	/** 保证金
 **/
	@Column(name = "MARGIN_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal marginAmt;
	
	/** 合同起始日
 **/
	@Transient
	@Column(name = "CONTR_START_DT", unique = false, nullable = true, length = 7)
	private Date contrStartDt;
	
	/** 合同到期日
 **/
	@Transient
	@Column(name = "CONTR_END_DT", unique = false, nullable = true, length = 7)
	private Date contrEndDt;
	
	/** 还款账号/卡号
 **/
	@Column(name = "REPAY_ACCT_ID", unique = false, nullable = true, length = 40)
	private String repayAcctId;
	
	/** 担保方式
 **/
	@Column(name = "MAIN_SURETY_MODE_CD", unique = false, nullable = true, length = 20)
	private String mainSuretyModeCd;
	
	/** 押品名称
 **/
	@Column(name = "COLLATERAL_TYPE_C", unique = false, nullable = true, length = 40)
	private String collateralTypeC;
	
	/** 还款方式
 **/
	@Column(name = "REPAY_METH_CD", unique = false, nullable = true, length = 20)
	private String repayMethCd;
	
	/** 业务状态
 **/
	@Column(name = "BIZ_STAT_CD", unique = false, nullable = true, length = 20)
	private String bizStatCd;
	
	/** 记录状态
 **/
	@Column(name = "RECD_STAT_CD", unique = false, nullable = true, length = 20)
	private String recdStatCd;
	
	/** 贷款创利
 **/
	@Column(name = "PROFIT_LOAN", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal profitLoan;
	
	/** 五级分类
 **/
	@Column(name = "RISK_CATEG_CD", unique = false, nullable = true, length = 10)
	private String riskCategCd;
	
	/** 基准利率
 **/
	@Column(name = "BASE_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal baseRate;
	
	/** 执行利率
 **/
	@Column(name = "FIXED_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal fixedRate;
	
	/** 合同金额
 **/
	@Column(name = "CONTR_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal contrAmt;
	
	/** 合同金额（折人民币）
 **/
	@Column(name = "CONTR_AMT_RMB", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal contrAmtRmb;
	
	/** 发放金额
 **/
	@Column(name = "DRAW_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal drawAmt;
	
	/** 发放金额（折人民币）
 **/
	@Column(name = "DRAW_AMT_RMB", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal drawAmtRmb;
	
	/** 贷款余额
 **/
	@Column(name = "LOAN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanBal;
	
	/** 贷款余额（折人民币）
 **/
	@Column(name = "LOAN_BAL_RMB", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanBalRmb;
	
	/** 月日均
 **/
	@Column(name = "MONTH_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal monthAvgRegularBal;
	
	/** 季日均
 **/
	@Column(name = "QUARTER_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal quarterAvgRegularBal;
	
	/** 年日均
 **/
	@Column(name = "YEAR_AVG_REGULAR_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal yearAvgRegularBal;
	
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
	 * @param debentureNo
	 */
	public void setDebentureNo(String debentureNo) {
		this.debentureNo = debentureNo == null ? null : debentureNo.trim();
	}
	
    /**
     * @return DebentureNo
     */	
	public String getDebentureNo() {
		return this.debentureNo;
	}
	
	/**
	 * @param debentureMdfr
	 */
	public void setDebentureMdfr(String debentureMdfr) {
		this.debentureMdfr = debentureMdfr == null ? null : debentureMdfr.trim();
	}
	
    /**
     * @return DebentureMdfr
     */	
	public String getDebentureMdfr() {
		return this.debentureMdfr;
	}
	
	/**
	 * @param contrNo
	 */
	public void setContrNo(String contrNo) {
		this.contrNo = contrNo == null ? null : contrNo.trim();
	}
	
    /**
     * @return ContrNo
     */	
	public String getContrNo() {
		return this.contrNo;
	}
	
	/**
	 * @param contrMdfr
	 */
	public void setContrMdfr(String contrMdfr) {
		this.contrMdfr = contrMdfr == null ? null : contrMdfr.trim();
	}
	
    /**
     * @return ContrMdfr
     */	
	public String getContrMdfr() {
		return this.contrMdfr;
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
	 * @param drawDt
	 */
	public void setDrawDt(Date drawDt) {
		this.drawDt = drawDt;
	}
	
    /**
     * @return DrawDt
     */	
	public Date getDrawDt() {
		return this.drawDt;
	}
	
	/**
	 * @param matureDt
	 */
	public void setMatureDt(Date matureDt) {
		this.matureDt = matureDt;
	}
	
    /**
     * @return MatureDt
     */	
	public Date getMatureDt() {
		return this.matureDt;
	}
	
	/**
	 * @param loanAcctId
	 */
	public void setLoanAcctId(String loanAcctId) {
		this.loanAcctId = loanAcctId == null ? null : loanAcctId.trim();
	}
	
    /**
     * @return LoanAcctId
     */	
	public String getLoanAcctId() {
		return this.loanAcctId;
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
	 * @param openOrgName
	 */
	public void setOpenOrgName(String openOrgName) {
		this.openOrgName = openOrgName == null ? null : openOrgName.trim();
	}
	
    /**
     * @return OpenOrgName
     */	
	public String getOpenOrgName() {
		return this.openOrgName;
	}
	
	/**
	 * @param prodTypeCd
	 */
	public void setProdTypeCd(String prodTypeCd) {
		this.prodTypeCd = prodTypeCd == null ? null : prodTypeCd.trim();
	}
	
    /**
     * @return ProdTypeCd
     */	
	public String getProdTypeCd() {
		return this.prodTypeCd;
	}
	
	/**
	 * @param orgOrPerFlag
	 */
	public void setOrgOrPerFlag(String orgOrPerFlag) {
		this.orgOrPerFlag = orgOrPerFlag == null ? null : orgOrPerFlag.trim();
	}
	
    /**
     * @return OrgOrPerFlag
     */	
	public String getOrgOrPerFlag() {
		return this.orgOrPerFlag;
	}
	
	/**
	 * @param prodCd
	 */
	public void setProdCd(String prodCd) {
		this.prodCd = prodCd == null ? null : prodCd.trim();
	}
	
    /**
     * @return ProdCd
     */	
	public String getProdCd() {
		return this.prodCd;
	}
	
	/**
	 * @param prodName
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName == null ? null : prodName.trim();
	}
	
    /**
     * @return ProdName
     */	
	public String getProdName() {
		return this.prodName;
	}
	
	/**
	 * @param comesFrom
	 */
	public void setComesFrom(String comesFrom) {
		this.comesFrom = comesFrom == null ? null : comesFrom.trim();
	}
	
    /**
     * @return ComesFrom
     */	
	public String getComesFrom() {
		return this.comesFrom;
	}
	
	/**
	 * @param prinAmt
	 */
	public void setPrinAmt(java.math.BigDecimal prinAmt) {
		this.prinAmt = prinAmt;
	}
	
    /**
     * @return PrinAmt
     */	
	public java.math.BigDecimal getPrinAmt() {
		return this.prinAmt;
	}
	
	/**
	 * @param debIntrBal
	 */
	public void setDebIntrBal(java.math.BigDecimal debIntrBal) {
		this.debIntrBal = debIntrBal;
	}
	
    /**
     * @return DebIntrBal
     */	
	public java.math.BigDecimal getDebIntrBal() {
		return this.debIntrBal;
	}
	
	/**
	 * @param marginAmt
	 */
	public void setMarginAmt(java.math.BigDecimal marginAmt) {
		this.marginAmt = marginAmt;
	}
	
    /**
     * @return MarginAmt
     */	
	public java.math.BigDecimal getMarginAmt() {
		return this.marginAmt;
	}
	
	/**
	 * @param contrStartDt
	 */
	public void setContrStartDt(Date contrStartDt) {
		this.contrStartDt = contrStartDt;
	}
	
    /**
     * @return ContrStartDt
     */	
	public Date getContrStartDt() {
		return this.contrStartDt;
	}
	
	/**
	 * @param contrEndDt
	 */
	public void setContrEndDt(Date contrEndDt) {
		this.contrEndDt = contrEndDt;
	}
	
    /**
     * @return ContrEndDt
     */	
	public Date getContrEndDt() {
		return this.contrEndDt;
	}
	
	/**
	 * @param repayAcctId
	 */
	public void setRepayAcctId(String repayAcctId) {
		this.repayAcctId = repayAcctId == null ? null : repayAcctId.trim();
	}
	
    /**
     * @return RepayAcctId
     */	
	public String getRepayAcctId() {
		return this.repayAcctId;
	}
	
	/**
	 * @param mainSuretyModeCd
	 */
	public void setMainSuretyModeCd(String mainSuretyModeCd) {
		this.mainSuretyModeCd = mainSuretyModeCd == null ? null : mainSuretyModeCd.trim();
	}
	
    /**
     * @return MainSuretyModeCd
     */	
	public String getMainSuretyModeCd() {
		return this.mainSuretyModeCd;
	}
	
	/**
	 * @param collateralTypeC
	 */
	public void setCollateralTypeC(String collateralTypeC) {
		this.collateralTypeC = collateralTypeC == null ? null : collateralTypeC.trim();
	}
	
    /**
     * @return CollateralTypeC
     */	
	public String getCollateralTypeC() {
		return this.collateralTypeC;
	}
	
	/**
	 * @param repayMethCd
	 */
	public void setRepayMethCd(String repayMethCd) {
		this.repayMethCd = repayMethCd == null ? null : repayMethCd.trim();
	}
	
    /**
     * @return RepayMethCd
     */	
	public String getRepayMethCd() {
		return this.repayMethCd;
	}
	
	/**
	 * @param bizStatCd
	 */
	public void setBizStatCd(String bizStatCd) {
		this.bizStatCd = bizStatCd == null ? null : bizStatCd.trim();
	}
	
    /**
     * @return BizStatCd
     */	
	public String getBizStatCd() {
		return this.bizStatCd;
	}
	
	/**
	 * @param recdStatCd
	 */
	public void setRecdStatCd(String recdStatCd) {
		this.recdStatCd = recdStatCd == null ? null : recdStatCd.trim();
	}
	
    /**
     * @return RecdStatCd
     */	
	public String getRecdStatCd() {
		return this.recdStatCd;
	}
	
	/**
	 * @param profitLoan
	 */
	public void setProfitLoan(java.math.BigDecimal profitLoan) {
		this.profitLoan = profitLoan;
	}
	
    /**
     * @return ProfitLoan
     */	
	public java.math.BigDecimal getProfitLoan() {
		return this.profitLoan;
	}
	
	/**
	 * @param riskCategCd
	 */
	public void setRiskCategCd(String riskCategCd) {
		this.riskCategCd = riskCategCd == null ? null : riskCategCd.trim();
	}
	
    /**
     * @return RiskCategCd
     */	
	public String getRiskCategCd() {
		return this.riskCategCd;
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
	 * @param fixedRate
	 */
	public void setFixedRate(java.math.BigDecimal fixedRate) {
		this.fixedRate = fixedRate;
	}
	
    /**
     * @return FixedRate
     */	
	public java.math.BigDecimal getFixedRate() {
		return this.fixedRate;
	}
	
	/**
	 * @param contrAmt
	 */
	public void setContrAmt(java.math.BigDecimal contrAmt) {
		this.contrAmt = contrAmt;
	}
	
    /**
     * @return ContrAmt
     */	
	public java.math.BigDecimal getContrAmt() {
		return this.contrAmt;
	}
	
	/**
	 * @param contrAmtRmb
	 */
	public void setContrAmtRmb(java.math.BigDecimal contrAmtRmb) {
		this.contrAmtRmb = contrAmtRmb;
	}
	
    /**
     * @return ContrAmtRmb
     */	
	public java.math.BigDecimal getContrAmtRmb() {
		return this.contrAmtRmb;
	}
	
	/**
	 * @param drawAmt
	 */
	public void setDrawAmt(java.math.BigDecimal drawAmt) {
		this.drawAmt = drawAmt;
	}
	
    /**
     * @return DrawAmt
     */	
	public java.math.BigDecimal getDrawAmt() {
		return this.drawAmt;
	}
	
	/**
	 * @param drawAmtRmb
	 */
	public void setDrawAmtRmb(java.math.BigDecimal drawAmtRmb) {
		this.drawAmtRmb = drawAmtRmb;
	}
	
    /**
     * @return DrawAmtRmb
     */	
	public java.math.BigDecimal getDrawAmtRmb() {
		return this.drawAmtRmb;
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
	 * @param loanBalRmb
	 */
	public void setLoanBalRmb(java.math.BigDecimal loanBalRmb) {
		this.loanBalRmb = loanBalRmb;
	}
	
    /**
     * @return LoanBalRmb
     */	
	public java.math.BigDecimal getLoanBalRmb() {
		return this.loanBalRmb;
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
	 * @param quarterAvgRegularBal
	 */
	public void setQuarterAvgRegularBal(java.math.BigDecimal quarterAvgRegularBal) {
		this.quarterAvgRegularBal = quarterAvgRegularBal;
	}
	
    /**
     * @return QuarterAvgRegularBal
     */	
	public java.math.BigDecimal getQuarterAvgRegularBal() {
		return this.quarterAvgRegularBal;
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
        AcrmFagLoanDebentInfo other = (AcrmFagLoanDebentInfo) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getDebentureNo() == null ? other.getDebentureNo() == null : this.getDebentureNo().equals(other.getDebentureNo()))
        	&& (this.getDebentureMdfr() == null ? other.getDebentureMdfr() == null : this.getDebentureMdfr().equals(other.getDebentureMdfr()))
        	&& (this.getContrNo() == null ? other.getContrNo() == null : this.getContrNo().equals(other.getContrNo()))
        	&& (this.getContrMdfr() == null ? other.getContrMdfr() == null : this.getContrMdfr().equals(other.getContrMdfr()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
                        	&& (this.getLoanAcctId() == null ? other.getLoanAcctId() == null : this.getLoanAcctId().equals(other.getLoanAcctId()))
        	&& (this.getAcctType() == null ? other.getAcctType() == null : this.getAcctType().equals(other.getAcctType()))
        	&& (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
        	&& (this.getOpenOrgName() == null ? other.getOpenOrgName() == null : this.getOpenOrgName().equals(other.getOpenOrgName()))
        	&& (this.getProdTypeCd() == null ? other.getProdTypeCd() == null : this.getProdTypeCd().equals(other.getProdTypeCd()))
        	&& (this.getOrgOrPerFlag() == null ? other.getOrgOrPerFlag() == null : this.getOrgOrPerFlag().equals(other.getOrgOrPerFlag()))
        	&& (this.getProdCd() == null ? other.getProdCd() == null : this.getProdCd().equals(other.getProdCd()))
        	&& (this.getProdName() == null ? other.getProdName() == null : this.getProdName().equals(other.getProdName()))
        	&& (this.getComesFrom() == null ? other.getComesFrom() == null : this.getComesFrom().equals(other.getComesFrom()))
                                                	&& (this.getRepayAcctId() == null ? other.getRepayAcctId() == null : this.getRepayAcctId().equals(other.getRepayAcctId()))
        	&& (this.getMainSuretyModeCd() == null ? other.getMainSuretyModeCd() == null : this.getMainSuretyModeCd().equals(other.getMainSuretyModeCd()))
        	&& (this.getCollateralTypeC() == null ? other.getCollateralTypeC() == null : this.getCollateralTypeC().equals(other.getCollateralTypeC()))
        	&& (this.getRepayMethCd() == null ? other.getRepayMethCd() == null : this.getRepayMethCd().equals(other.getRepayMethCd()))
        	&& (this.getBizStatCd() == null ? other.getBizStatCd() == null : this.getBizStatCd().equals(other.getBizStatCd()))
        	&& (this.getRecdStatCd() == null ? other.getRecdStatCd() == null : this.getRecdStatCd().equals(other.getRecdStatCd()))
                	&& (this.getRiskCategCd() == null ? other.getRiskCategCd() == null : this.getRiskCategCd().equals(other.getRiskCategCd()))
                                                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getDebentureNo() == null) ? 0 : getDebentureNo().hashCode());
        result = prime * result + ((getDebentureMdfr() == null) ? 0 : getDebentureMdfr().hashCode());
        result = prime * result + ((getContrNo() == null) ? 0 : getContrNo().hashCode());
        result = prime * result + ((getContrMdfr() == null) ? 0 : getContrMdfr().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getLoanAcctId() == null) ? 0 : getLoanAcctId().hashCode());
        result = prime * result + ((getAcctType() == null) ? 0 : getAcctType().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOpenOrgName() == null) ? 0 : getOpenOrgName().hashCode());
        result = prime * result + ((getProdTypeCd() == null) ? 0 : getProdTypeCd().hashCode());
        result = prime * result + ((getOrgOrPerFlag() == null) ? 0 : getOrgOrPerFlag().hashCode());
        result = prime * result + ((getProdCd() == null) ? 0 : getProdCd().hashCode());
        result = prime * result + ((getProdName() == null) ? 0 : getProdName().hashCode());
        result = prime * result + ((getComesFrom() == null) ? 0 : getComesFrom().hashCode());
        result = prime * result + ((getRepayAcctId() == null) ? 0 : getRepayAcctId().hashCode());
        result = prime * result + ((getMainSuretyModeCd() == null) ? 0 : getMainSuretyModeCd().hashCode());
        result = prime * result + ((getCollateralTypeC() == null) ? 0 : getCollateralTypeC().hashCode());
        result = prime * result + ((getRepayMethCd() == null) ? 0 : getRepayMethCd().hashCode());
        result = prime * result + ((getBizStatCd() == null) ? 0 : getBizStatCd().hashCode());
        result = prime * result + ((getRecdStatCd() == null) ? 0 : getRecdStatCd().hashCode());
        result = prime * result + ((getRiskCategCd() == null) ? 0 : getRiskCategCd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", debentureNo=").append(debentureNo);
		sb.append(", debentureMdfr=").append(debentureMdfr);
		sb.append(", contrNo=").append(contrNo);
		sb.append(", contrMdfr=").append(contrMdfr);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", drawDt=").append(drawDt);
		sb.append(", matureDt=").append(matureDt);
		sb.append(", loanAcctId=").append(loanAcctId);
		sb.append(", acctType=").append(acctType);
		sb.append(", orgId=").append(orgId);
		sb.append(", openOrgName=").append(openOrgName);
		sb.append(", prodTypeCd=").append(prodTypeCd);
		sb.append(", orgOrPerFlag=").append(orgOrPerFlag);
		sb.append(", prodCd=").append(prodCd);
		sb.append(", prodName=").append(prodName);
		sb.append(", comesFrom=").append(comesFrom);
		sb.append(", prinAmt=").append(prinAmt);
		sb.append(", debIntrBal=").append(debIntrBal);
		sb.append(", marginAmt=").append(marginAmt);
		sb.append(", contrStartDt=").append(contrStartDt);
		sb.append(", contrEndDt=").append(contrEndDt);
		sb.append(", repayAcctId=").append(repayAcctId);
		sb.append(", mainSuretyModeCd=").append(mainSuretyModeCd);
		sb.append(", collateralTypeC=").append(collateralTypeC);
		sb.append(", repayMethCd=").append(repayMethCd);
		sb.append(", bizStatCd=").append(bizStatCd);
		sb.append(", recdStatCd=").append(recdStatCd);
		sb.append(", profitLoan=").append(profitLoan);
		sb.append(", riskCategCd=").append(riskCategCd);
		sb.append(", baseRate=").append(baseRate);
		sb.append(", fixedRate=").append(fixedRate);
		sb.append(", contrAmt=").append(contrAmt);
		sb.append(", contrAmtRmb=").append(contrAmtRmb);
		sb.append(", drawAmt=").append(drawAmt);
		sb.append(", drawAmtRmb=").append(drawAmtRmb);
		sb.append(", loanBal=").append(loanBal);
		sb.append(", loanBalRmb=").append(loanBalRmb);
		sb.append(", monthAvgRegularBal=").append(monthAvgRegularBal);
		sb.append(", quarterAvgRegularBal=").append(quarterAvgRegularBal);
		sb.append(", yearAvgRegularBal=").append(yearAvgRegularBal);
		sb.append(", dataDate=").append(dataDate);
        sb.append("]");
        return sb.toString();
    }
}