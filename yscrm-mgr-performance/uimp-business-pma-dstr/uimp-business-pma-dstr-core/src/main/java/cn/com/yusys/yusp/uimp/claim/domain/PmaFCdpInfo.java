package cn.com.yusys.yusp.uimp.claim.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFCdpInfo
 * @类描述: PMA_F_CDP_INFO数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-06-30 16:02:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_CDP_INFO")
public class PmaFCdpInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	

	/** 对公存款主键 **/
	@Column(name = "CDP_ID", unique = false, nullable = true, length = 100)
	private String cdpId;
	
	/** 数据日期 **/
	@Column(name = "ETL_DATE", unique = false, nullable = true, length = 8)
	private String etlDate;
	
	/** 主账号 **/
	@Column(name = "ACCT_NO", unique = false, nullable = true, length = 50)
	private String acctNo;
	
	/** 展示账号 **/
	@Column(name = "DIP_ACCT_NO", unique = false, nullable = true, length = 50)
	private String dipAcctNo;
	
	/** 卡号 **/
	@Column(name = "CARD_NO", unique = false, nullable = true, length = 50)
	private String cardNo;
	
	/** 子账号 **/
	@Column(name = "SUB_ACCT_NO", unique = false, nullable = true, length = 50)
	private String subAcctNo;
	
	/** 内部账号 **/
	@Column(name = "INACCT_NO", unique = false, nullable = true, length = 50)
	private String inacctNo;
	
	/** 客户号 **/
	@Column(name = "CUST_NO", unique = false, nullable = true, length = 50)
	private String custNo;
	
	/** 客户名 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 100)
	private String custName;
	
	/** 开户机构号 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 50)
	private String orgId;
	
	/** 开户机构名称 **/
	@Column(name = "ORG_NAME", unique = false, nullable = true, length = 100)
	private String orgName;
	
	/** 贷款标志 **/
	@Column(name = "LN_FLAG", unique = false, nullable = true, length = 2)
	private String lnFlag;
	
	/** 业务标识 **/
	@Column(name = "BUSS_NO", unique = false, nullable = true, length = 50)
	private String bussNo;
	
	/** 产品号 **/
	@Column(name = "PROD_NO", unique = false, nullable = true, length = 50)
	private String prodNo;
	
	/** 产品名 **/
	@Column(name = "PROD_NAME", unique = false, nullable = true, length = 100)
	private String prodName;
	
	/** 科目号 **/
	@Column(name = "SUB_NO", unique = false, nullable = true, length = 50)
	private String subNo;
	
	/** 科目名 **/
	@Column(name = "SUB_NAME", unique = false, nullable = true, length = 100)
	private String subName;
	
	/** 存期类型            **/
	@Column(name = "D_PERIOD", unique = false, nullable = true, length = 2)
	private String dPeriod;
	
	/** 存款类型 **/
	@Column(name = "D_TYPE", unique = false, nullable = true, length = 2)
	private String dType;
	
	/** 币种编码 **/
	@Column(name = "CU_NO", unique = false, nullable = true, length = 2)
	private String cuNo;
	
	/** 基准利率 **/
	@Column(name = "BASE_RATE", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal baseRate;
	
	/** 执行利率 **/
	@Column(name = "STR_RATE", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal strRate;
	
	/** 账户性质 **/
	@Column(name = "ACCT_ATTR", unique = false, nullable = true, length = 2)
	private String acctAttr;
	
	/** 账号状态 **/
	@Column(name = "ACCT_STATE", unique = false, nullable = true, length = 2)
	private String acctState;
	
	/** 存期 **/
	@Column(name = "PERIOD", unique = false, nullable = true, length = 8)
	private String period;
	
	/** 开户日期 **/
	@Column(name = "OPEN_DATE", unique = false, nullable = true, length = 8)
	private String openDate;
	
	/** 起息日期 **/
	@Column(name = "VALUE_DATE", unique = false, nullable = true, length = 8)
	private String valueDate;
	
	/** 到期日期 **/
	@Column(name = "DUE_DATE", unique = false, nullable = true, length = 8)
	private String dueDate;
	
	/** 销户日期 **/
	@Column(name = "CLOS_DATE", unique = false, nullable = true, length = 8)
	private String closDate;
	
	/** 客户经理A **/
	@Column(name = "MAN_A", unique = false, nullable = true, length = 50)
	private String manA;
	
	/** 客户经理B **/
	@Column(name = "MAN_B", unique = false, nullable = true, length = 50)
	private String manB;
	
	/** 客户经理C **/
	@Column(name = "MAN_C", unique = false, nullable = true, length = 50)
	private String manC;
	
	/** 客户经理D **/
	@Column(name = "MAN_D", unique = false, nullable = true, length = 50)
	private String manD;
	
	/** 客户经理E **/
	@Column(name = "MAN_E", unique = false, nullable = true, length = 50)
	private String manE;
	
	/** 余额 **/
	@Column(name = "BAL", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal bal;
	
	/** 月日均余额 **/
	@Column(name = "M_AVG", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal mAvg;
	
	/** 季日均余额 **/
	@Column(name = "Q_AVG", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal qAvg;
	
	/** 年日均余额 **/
	@Column(name = "Y_AVG", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal yAvg;
	
	/** 日利息支出 **/
	@Column(name = "D_EXP", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal dExp;
	
	/** 日FTP收入 **/
	@Column(name = "D_INT", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal dInt;
	
	/** 日FTP利润 **/
	@Column(name = "D_FTP", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal dFtp;
	
	/** 月利息支出 **/
	@Column(name = "M_EXP", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal mExp;
	
	/** 月FTP收入 **/
	@Column(name = "M_INT", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal mInt;
	
	/** 月FTP利润 **/
	@Column(name = "M_FTP", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal mFtp;
	
	/** 季利息支出 **/
	@Column(name = "Q_EXP", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal qExp;
	
	/** 季FTP收入 **/
	@Column(name = "Q_INT", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal qInt;
	
	/** 季FTP利润 **/
	@Column(name = "Q_FTP", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal qFtp;
	
	/** 年利息支出 **/
	@Column(name = "Y_EXP", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal yExp;
	
	/** 年FTP收入 **/
	@Column(name = "Y_INT", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal yInt;
	
	/** 年FTP利润 **/
	@Column(name = "Y_FTP", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal yFtp;
	
	/** 阈值判定金额 **/
	@Column(name = "THRESHOLD", unique = false, nullable = true, length = 24)
	private java.math.BigDecimal threshold;
	
	/** 年FTP利润 **/

	private String effectDate;
	
	private String distrRate;
	public String getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}

	public String getDistrRate() {
		return distrRate;
	}

	public void setDistrRate(String distrRate) {
		this.distrRate = distrRate;
	}

	/**
	 * @param cdpId
	 */
	public void setCdpId(String cdpId) {
		this.cdpId = cdpId == null ? null : cdpId.trim();
	}
	
    /**
     * @return CdpId
     */	
	public String getCdpId() {
		return this.cdpId;
	}
	
	/**
	 * @param etlDate
	 */
	public void setEtlDate(String etlDate) {
		this.etlDate = etlDate == null ? null : etlDate.trim();
	}
	
    /**
     * @return EtlDate
     */	
	public String getEtlDate() {
		return this.etlDate;
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
	 * @param dipAcctNo
	 */
	public void setDipAcctNo(String dipAcctNo) {
		this.dipAcctNo = dipAcctNo == null ? null : dipAcctNo.trim();
	}
	
    /**
     * @return DipAcctNo
     */	
	public String getDipAcctNo() {
		return this.dipAcctNo;
	}
	
	/**
	 * @param cardNo
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo == null ? null : cardNo.trim();
	}
	
    /**
     * @return CardNo
     */	
	public String getCardNo() {
		return this.cardNo;
	}
	
	/**
	 * @param subAcctNo
	 */
	public void setSubAcctNo(String subAcctNo) {
		this.subAcctNo = subAcctNo == null ? null : subAcctNo.trim();
	}
	
    /**
     * @return SubAcctNo
     */	
	public String getSubAcctNo() {
		return this.subAcctNo;
	}
	
	/**
	 * @param inacctNo
	 */
	public void setInacctNo(String inacctNo) {
		this.inacctNo = inacctNo == null ? null : inacctNo.trim();
	}
	
    /**
     * @return InacctNo
     */	
	public String getInacctNo() {
		return this.inacctNo;
	}
	
	/**
	 * @param custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo == null ? null : custNo.trim();
	}
	
    /**
     * @return CustNo
     */	
	public String getCustNo() {
		return this.custNo;
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
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}
	
    /**
     * @return OrgName
     */	
	public String getOrgName() {
		return this.orgName;
	}
	
	/**
	 * @param lnFlag
	 */
	public void setLnFlag(String lnFlag) {
		this.lnFlag = lnFlag == null ? null : lnFlag.trim();
	}
	
    /**
     * @return LnFlag
     */	
	public String getLnFlag() {
		return this.lnFlag;
	}
	
	/**
	 * @param bussNo
	 */
	public void setBussNo(String bussNo) {
		this.bussNo = bussNo == null ? null : bussNo.trim();
	}
	
    /**
     * @return BussNo
     */	
	public String getBussNo() {
		return this.bussNo;
	}
	
	/**
	 * @param prodNo
	 */
	public void setProdNo(String prodNo) {
		this.prodNo = prodNo == null ? null : prodNo.trim();
	}
	
    /**
     * @return ProdNo
     */	
	public String getProdNo() {
		return this.prodNo;
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
	 * @param subNo
	 */
	public void setSubNo(String subNo) {
		this.subNo = subNo == null ? null : subNo.trim();
	}
	
    /**
     * @return SubNo
     */	
	public String getSubNo() {
		return this.subNo;
	}
	
	/**
	 * @param subName
	 */
	public void setSubName(String subName) {
		this.subName = subName == null ? null : subName.trim();
	}
	
    /**
     * @return SubName
     */	
	public String getSubName() {
		return this.subName;
	}
	
	/**
	 * @param dPeriod
	 */
	public void setDPeriod(String dPeriod) {
		this.dPeriod = dPeriod == null ? null : dPeriod.trim();
	}
	
    /**
     * @return DPeriod
     */	
	public String getDPeriod() {
		return this.dPeriod;
	}
	
	/**
	 * @param dType
	 */
	public void setDType(String dType) {
		this.dType = dType == null ? null : dType.trim();
	}
	
    /**
     * @return DType
     */	
	public String getDType() {
		return this.dType;
	}
	
	/**
	 * @param cuNo
	 */
	public void setCuNo(String cuNo) {
		this.cuNo = cuNo == null ? null : cuNo.trim();
	}
	
    /**
     * @return CuNo
     */	
	public String getCuNo() {
		return this.cuNo;
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
	 * @param strRate
	 */
	public void setStrRate(java.math.BigDecimal strRate) {
		this.strRate = strRate;
	}
	
    /**
     * @return StrRate
     */	
	public java.math.BigDecimal getStrRate() {
		return this.strRate;
	}
	
	/**
	 * @param acctAttr
	 */
	public void setAcctAttr(String acctAttr) {
		this.acctAttr = acctAttr == null ? null : acctAttr.trim();
	}
	
    /**
     * @return AcctAttr
     */	
	public String getAcctAttr() {
		return this.acctAttr;
	}
	
	/**
	 * @param acctState
	 */
	public void setAcctState(String acctState) {
		this.acctState = acctState == null ? null : acctState.trim();
	}
	
    /**
     * @return AcctState
     */	
	public String getAcctState() {
		return this.acctState;
	}
	
	/**
	 * @param period
	 */
	public void setPeriod(String period) {
		this.period = period == null ? null : period.trim();
	}
	
    /**
     * @return Period
     */	
	public String getPeriod() {
		return this.period;
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
	 * @param valueDate
	 */
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate == null ? null : valueDate.trim();
	}
	
    /**
     * @return ValueDate
     */	
	public String getValueDate() {
		return this.valueDate;
	}
	
	/**
	 * @param dueDate
	 */
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate == null ? null : dueDate.trim();
	}
	
    /**
     * @return DueDate
     */	
	public String getDueDate() {
		return this.dueDate;
	}
	
	/**
	 * @param closDate
	 */
	public void setClosDate(String closDate) {
		this.closDate = closDate == null ? null : closDate.trim();
	}
	
    /**
     * @return ClosDate
     */	
	public String getClosDate() {
		return this.closDate;
	}
	
	/**
	 * @param manA
	 */
	public void setManA(String manA) {
		this.manA = manA == null ? null : manA.trim();
	}
	
    /**
     * @return ManA
     */	
	public String getManA() {
		return this.manA;
	}
	
	/**
	 * @param manB
	 */
	public void setManB(String manB) {
		this.manB = manB == null ? null : manB.trim();
	}
	
    /**
     * @return ManB
     */	
	public String getManB() {
		return this.manB;
	}
	
	/**
	 * @param manC
	 */
	public void setManC(String manC) {
		this.manC = manC == null ? null : manC.trim();
	}
	
    /**
     * @return ManC
     */	
	public String getManC() {
		return this.manC;
	}
	
	/**
	 * @param manD
	 */
	public void setManD(String manD) {
		this.manD = manD == null ? null : manD.trim();
	}
	
    /**
     * @return ManD
     */	
	public String getManD() {
		return this.manD;
	}
	
	/**
	 * @param manE
	 */
	public void setManE(String manE) {
		this.manE = manE == null ? null : manE.trim();
	}
	
    /**
     * @return ManE
     */	
	public String getManE() {
		return this.manE;
	}
	
	/**
	 * @param bal
	 */
	public void setBal(java.math.BigDecimal bal) {
		this.bal = bal;
	}
	
    /**
     * @return Bal
     */	
	public java.math.BigDecimal getBal() {
		return this.bal;
	}
	
	/**
	 * @param mAvg
	 */
	public void setMAvg(java.math.BigDecimal mAvg) {
		this.mAvg = mAvg;
	}
	
    /**
     * @return MAvg
     */	
	public java.math.BigDecimal getMAvg() {
		return this.mAvg;
	}
	
	/**
	 * @param qAvg
	 */
	public void setQAvg(java.math.BigDecimal qAvg) {
		this.qAvg = qAvg;
	}
	
    /**
     * @return QAvg
     */	
	public java.math.BigDecimal getQAvg() {
		return this.qAvg;
	}
	
	/**
	 * @param yAvg
	 */
	public void setYAvg(java.math.BigDecimal yAvg) {
		this.yAvg = yAvg;
	}
	
    /**
     * @return YAvg
     */	
	public java.math.BigDecimal getYAvg() {
		return this.yAvg;
	}
	
	/**
	 * @param dExp
	 */
	public void setDExp(java.math.BigDecimal dExp) {
		this.dExp = dExp;
	}
	
    /**
     * @return DExp
     */	
	public java.math.BigDecimal getDExp() {
		return this.dExp;
	}
	
	/**
	 * @param dInt
	 */
	public void setDInt(java.math.BigDecimal dInt) {
		this.dInt = dInt;
	}
	
    /**
     * @return DInt
     */	
	public java.math.BigDecimal getDInt() {
		return this.dInt;
	}
	
	/**
	 * @param dFtp
	 */
	public void setDFtp(java.math.BigDecimal dFtp) {
		this.dFtp = dFtp;
	}
	
    /**
     * @return DFtp
     */	
	public java.math.BigDecimal getDFtp() {
		return this.dFtp;
	}
	
	/**
	 * @param mExp
	 */
	public void setMExp(java.math.BigDecimal mExp) {
		this.mExp = mExp;
	}
	
    /**
     * @return MExp
     */	
	public java.math.BigDecimal getMExp() {
		return this.mExp;
	}
	
	/**
	 * @param mInt
	 */
	public void setMInt(java.math.BigDecimal mInt) {
		this.mInt = mInt;
	}
	
    /**
     * @return MInt
     */	
	public java.math.BigDecimal getMInt() {
		return this.mInt;
	}
	
	/**
	 * @param mFtp
	 */
	public void setMFtp(java.math.BigDecimal mFtp) {
		this.mFtp = mFtp;
	}
	
    /**
     * @return MFtp
     */	
	public java.math.BigDecimal getMFtp() {
		return this.mFtp;
	}
	
	/**
	 * @param qExp
	 */
	public void setQExp(java.math.BigDecimal qExp) {
		this.qExp = qExp;
	}
	
    /**
     * @return QExp
     */	
	public java.math.BigDecimal getQExp() {
		return this.qExp;
	}
	
	/**
	 * @param qInt
	 */
	public void setQInt(java.math.BigDecimal qInt) {
		this.qInt = qInt;
	}
	
    /**
     * @return QInt
     */	
	public java.math.BigDecimal getQInt() {
		return this.qInt;
	}
	
	/**
	 * @param qFtp
	 */
	public void setQFtp(java.math.BigDecimal qFtp) {
		this.qFtp = qFtp;
	}
	
    /**
     * @return QFtp
     */	
	public java.math.BigDecimal getQFtp() {
		return this.qFtp;
	}
	
	/**
	 * @param yExp
	 */
	public void setYExp(java.math.BigDecimal yExp) {
		this.yExp = yExp;
	}
	
    /**
     * @return YExp
     */	
	public java.math.BigDecimal getYExp() {
		return this.yExp;
	}
	
	/**
	 * @param yInt
	 */
	public void setYInt(java.math.BigDecimal yInt) {
		this.yInt = yInt;
	}
	
    /**
     * @return YInt
     */	
	public java.math.BigDecimal getYInt() {
		return this.yInt;
	}
	
	/**
	 * @param yFtp
	 */
	public void setYFtp(java.math.BigDecimal yFtp) {
		this.yFtp = yFtp;
	}
	
    /**
     * @return YFtp
     */	
	public java.math.BigDecimal getYFtp() {
		return this.yFtp;
	}
	
	/**
	 * @param threshold
	 */
	public void setThreshold(java.math.BigDecimal threshold) {
		this.threshold = threshold;
	}
	
    /**
     * @return Threshold
     */	
	public java.math.BigDecimal getThreshold() {
		return this.threshold;
	}



}