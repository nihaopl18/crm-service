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
 * @类名称: AcrmFciOrgCust
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-21 14:51:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_ORG_CUST")
public class AcrmFciOrgCust extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 最新更新系统 **/
	@Column(name = "LAST_UPDATE_SYS", unique = false, nullable = true, length = 20)
	private String lastUpdateSys;
	
	/** 最新更新人 **/
	@Column(name = "LAST_UPDATE_USER", unique = false, nullable = true, length = 20)
	private String lastUpdateUser;
	
	/** 最新更新时间 **/
	@Transient
	@Column(name = "LAST_UPDATE_TM", unique = false, nullable = true, length = 7)
	private Date lastUpdateTm;
	
	/** 最新更新机构 **/
	@Column(name = "LAST_UPDATE_ORG", unique = false, nullable = true, length = 20)
	private String lastUpdateOrg;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** ECIF客户标识 **/
	@Column(name = "ECIF_CUST_ID", unique = false, nullable = true, length = 32)
	private String ecifCustId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 证件类型 **/
	@Column(name = "CERT_TYPE", unique = false, nullable = true, length = 20)
	private String certType;
	
	/** 证件号码 **/
	@Column(name = "CERT_NO", unique = false, nullable = true, length = 50)
	private String certNo;
	
	/** 注册资本币别 **/
	@Column(name = "REG_CURR_CD", unique = false, nullable = true, length = 30)
	private String regCurrCd;
	
	/** 注册资本(万元) **/
	@Column(name = "REG_CAPITAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal regCapital;
	
	/** 企业规模 **/
	@Column(name = "COM_SCALE", unique = false, nullable = true, length = 30)
	private String comScale;
	
	/** 资产规模 **/
	@Column(name = "TOTAL_ASSETS", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal totalAssets;
	
	/** 信贷客户类型 **/
	@Column(name = "LOAN_CUST_TYPE", unique = false, nullable = true, length = 30)
	private String loanCustType;
	
	/** 投资主体 **/
	@Column(name = "INV_TYPE", unique = false, nullable = true, length = 30)
	private String invType;
	
	/** 销售总额(万元) **/
	@Column(name = "TOTAL_SALES", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal totalSales;
	
	/** 行业类型 **/
	@Column(name = "INDUS_CD", unique = false, nullable = true, length = 30)
	private String indusCd;
	
	/** 主营范围 **/
	@Column(name = "COM_MAIN_OPT_SCP", unique = false, nullable = true, length = 360)
	private String comMainOptScp;
	
	/** 兼营范围 **/
	@Column(name = "COM_PART_OPT_SCP", unique = false, nullable = true, length = 300)
	private String comPartOptScp;
	
	/** 客户与我行关系 **/
	@Column(name = "CUST_BANK_REL", unique = false, nullable = true, length = 30)
	private String custBankRel;
	
	/** 拥有我行股份金额 **/
	@Column(name = "HOLD_STOCK_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal holdStockAmt;
	
	/** 与我行合作关系 **/
	@Column(name = "COM_REL_DGR", unique = false, nullable = true, length = 30)
	private String comRelDgr;
	
	/** 成为我行客户时间 **/
	@Column(name = "BE_CUST_DATE", unique = false, nullable = true, length = 8)
	private String beCustDate;
	
	/** 建立信贷关系时间 **/
	@Column(name = "COM_INIT_LOAN_DATE", unique = false, nullable = true, length = 8)
	private String comInitLoanDate;
	
	/** 社员(股东)标志 **/
	@Column(name = "STOCK_FLG", unique = false, nullable = true, length = 30)
	private String stockFlg;
	
	/** 实际控制人 **/
	@Column(name = "REAL_CNTR", unique = false, nullable = true, length = 80)
	private String realCntr;
	
	/** 成立日期 **/
	@Column(name = "COM_ESTAB_DATE", unique = false, nullable = true, length = 8)
	private String comEstabDate;
	
	/** 员工规模 **/
	@Column(name = "EMP_NUM", unique = false, nullable = true, length = 30)
	private String empNum;
	
	/** 组织机构登记日期 **/
	@Column(name = "COM_INS_REG_DATE", unique = false, nullable = true, length = 8)
	private String comInsRegDate;
	
	/** 组织机构有效日期 **/
	@Column(name = "COM_INS_EXP_DATE", unique = false, nullable = true, length = 8)
	private String comInsExpDate;
	
	/** 登记注册号 **/
	@Column(name = "REG_CODE", unique = false, nullable = true, length = 30)
	private String regCode;
	
	/** 注册登记类型 **/
	@Column(name = "REG_TYPE", unique = false, nullable = true, length = 30)
	private String regType;
	
	/** 行政区划名称 **/
	@Column(name = "REG_AREA_NAME", unique = false, nullable = true, length = 100)
	private String regAreaName;
	
	/** 注册登记地址 **/
	@Column(name = "REG_ADDR", unique = false, nullable = true, length = 100)
	private String regAddr;
	
	/** 国税税务登记代码 **/
	@Column(name = "NAT_TAX_REG_CODE", unique = false, nullable = true, length = 30)
	private String natTaxRegCode;
	
	/** 地税税务登记代码 **/
	@Column(name = "LOC_TAX_REG_CODE", unique = false, nullable = true, length = 30)
	private String locTaxRegCode;
	
	/** 基本户是否在本行 **/
	@Column(name = "IS_BASE_BANK", unique = false, nullable = true, length = 30)
	private String isBaseBank;
	
	/** 本币基本帐户开户行 **/
	@Column(name = "CUR_BANK", unique = false, nullable = true, length = 80)
	private String curBank;
	
	/** 外币基本帐户开户行 **/
	@Column(name = "FOR_BANK", unique = false, nullable = true, length = 80)
	private String forBank;
	
	/** 本币基本帐户帐号 **/
	@Column(name = "CUR_ACCT_NO", unique = false, nullable = true, length = 32)
	private String curAcctNo;
	
	/** 外币基本帐户帐号 **/
	@Column(name = "FOR_ACCT_NO", unique = false, nullable = true, length = 32)
	private String forAcctNo;
	
	/** 基本存款账户开户日期 **/
	@Column(name = "BASE_ACCT_DATE", unique = false, nullable = true, length = 8)
	private String baseAcctDate;
	
	/** 企业类型 **/
	@Column(name = "CORP_TYPE", unique = false, nullable = true, length = 30)
	private String corpType;
	
	/** 经济性质 **/
	@Column(name = "ECON_PROPER", unique = false, nullable = true, length = 30)
	private String econProper;
	
	/** 组织机构信用代码 **/
	@Column(name = "INS_CRED_COD", unique = false, nullable = true, length = 30)
	private String insCredCod;
	
	/** 法定代表人客户标识 **/
	@Column(name = "LEGAL_CUST_ID", unique = false, nullable = true, length = 32)
	private String legalCustId;
	
	/** 法定代表人/负责人姓名 **/
	@Column(name = "LEGAL_NAME", unique = false, nullable = true, length = 60)
	private String legalName;
	
	/** 第一联系人 **/
	@Column(name = "CONT_MAN", unique = false, nullable = true, length = 60)
	private String contMan;
	
	/** 联系人电话 **/
	@Column(name = "CONT_TEL_NO", unique = false, nullable = true, length = 60)
	private String contTelNo;
	
	/** 是否有效户 **/
	@Column(name = "EFFECT_FLG", unique = false, nullable = true, length = 10)
	private String effectFlg;
	
	/** 七级风险分类 **/
	@Column(name = "LOAN_SEVEN_LEV", unique = false, nullable = true, length = 10)
	private String loanSevenLev;
	
	/** 信用等级 **/
	@Column(name = "CREDIT_LEV", unique = false, nullable = true, length = 10)
	private String creditLev;
	
	/** 客户服务等级 **/
	@Column(name = "SERV_LEV", unique = false, nullable = true, length = 20)
	private String servLev;
	
	/** 客户价值等级 **/
	@Column(name = "VALUE_LEV", unique = false, nullable = true, length = 20)
	private String valueLev;
	
	/** 主办客户经理编号 **/
	@Column(name = "BELONG_MGR", unique = false, nullable = true, length = 30)
	private String belongMgr;
	
	/** 主办客户机构编号 **/
	@Column(name = "BELONG_BRCH", unique = false, nullable = true, length = 30)
	private String belongBrch;
	
	/** 客户分配状态 **/
	@Column(name = "CUST_ASSIGN_STAT", unique = false, nullable = true, length = 20)
	private String custAssignStat;
	
	/** 客户状态 **/
	@Column(name = "CUST_STATUS", unique = false, nullable = true, length = 20)
	private String custStatus;
	
	/** 原系统客户状态 **/
	@Column(name = "SRC_CUST_STATUS", unique = false, nullable = true, length = 30)
	private String srcCustStatus;
	
	/** 是否贷款户 **/
	@Column(name = "IS_LOAN_CUST", unique = false, nullable = true, length = 20)
	private String isLoanCust;
	
	/** 是否股金户 **/
	@Column(name = "IS_STOCK_CUST", unique = false, nullable = true, length = 20)
	private String isStockCust;
	
	/** 是否VIP卡客户 **/
	@Column(name = "IS_CARD_VIP", unique = false, nullable = true, length = 20)
	private String isCardVip;
	
	/** 是否准入 **/
	@Column(name = "IS_ADMIT_ENTER", unique = false, nullable = true, length = 20)
	private String isAdmitEnter;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 300)
	private String remark;
	
	/** 联系人证件类型 **/
	@Column(name = "CONT_CERT_TYPE", unique = false, nullable = true, length = 2)
	private String contCertType;
	
	/** 联系人证件号码 **/
	@Column(name = "CONT_CERT_NO", unique = false, nullable = true, length = 100)
	private String contCertNo;
	
	/** 固定电话 **/
	@Column(name = "TEL_PHONE_NO", unique = false, nullable = true, length = 50)
	private String telPhoneNo;
	
	/** 来源渠道 **/
	@Column(name = "SOURCE_CHANNEL", unique = false, nullable = true, length = 50)
	private String sourceChannel;
	
	/** ID主键 **/
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	private String id;
	
	
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
	 * @param lastUpdateSys
	 */
	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys == null ? null : lastUpdateSys.trim();
	}
	
    /**
     * @return LastUpdateSys
     */	
	public String getLastUpdateSys() {
		return this.lastUpdateSys;
	}
	
	/**
	 * @param lastUpdateUser
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
	}
	
    /**
     * @return LastUpdateUser
     */	
	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}
	
	/**
	 * @param lastUpdateTm
	 */
	public void setLastUpdateTm(Date lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}
	
    /**
     * @return LastUpdateTm
     */	
	public Date getLastUpdateTm() {
		return this.lastUpdateTm;
	}
	
	/**
	 * @param lastUpdateOrg
	 */
	public void setLastUpdateOrg(String lastUpdateOrg) {
		this.lastUpdateOrg = lastUpdateOrg == null ? null : lastUpdateOrg.trim();
	}
	
    /**
     * @return LastUpdateOrg
     */	
	public String getLastUpdateOrg() {
		return this.lastUpdateOrg;
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
	 * @param ecifCustId
	 */
	public void setEcifCustId(String ecifCustId) {
		this.ecifCustId = ecifCustId == null ? null : ecifCustId.trim();
	}
	
    /**
     * @return EcifCustId
     */	
	public String getEcifCustId() {
		return this.ecifCustId;
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
	 * @param certType
	 */
	public void setCertType(String certType) {
		this.certType = certType == null ? null : certType.trim();
	}
	
    /**
     * @return CertType
     */	
	public String getCertType() {
		return this.certType;
	}
	
	/**
	 * @param certNo
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo == null ? null : certNo.trim();
	}
	
    /**
     * @return CertNo
     */	
	public String getCertNo() {
		return this.certNo;
	}
	
	/**
	 * @param regCurrCd
	 */
	public void setRegCurrCd(String regCurrCd) {
		this.regCurrCd = regCurrCd == null ? null : regCurrCd.trim();
	}
	
    /**
     * @return RegCurrCd
     */	
	public String getRegCurrCd() {
		return this.regCurrCd;
	}
	
	/**
	 * @param regCapital
	 */
	public void setRegCapital(java.math.BigDecimal regCapital) {
		this.regCapital = regCapital;
	}
	
    /**
     * @return RegCapital
     */	
	public java.math.BigDecimal getRegCapital() {
		return this.regCapital;
	}
	
	/**
	 * @param comScale
	 */
	public void setComScale(String comScale) {
		this.comScale = comScale == null ? null : comScale.trim();
	}
	
    /**
     * @return ComScale
     */	
	public String getComScale() {
		return this.comScale;
	}
	
	/**
	 * @param totalAssets
	 */
	public void setTotalAssets(java.math.BigDecimal totalAssets) {
		this.totalAssets = totalAssets;
	}
	
    /**
     * @return TotalAssets
     */	
	public java.math.BigDecimal getTotalAssets() {
		return this.totalAssets;
	}
	
	/**
	 * @param loanCustType
	 */
	public void setLoanCustType(String loanCustType) {
		this.loanCustType = loanCustType == null ? null : loanCustType.trim();
	}
	
    /**
     * @return LoanCustType
     */	
	public String getLoanCustType() {
		return this.loanCustType;
	}
	
	/**
	 * @param invType
	 */
	public void setInvType(String invType) {
		this.invType = invType == null ? null : invType.trim();
	}
	
    /**
     * @return InvType
     */	
	public String getInvType() {
		return this.invType;
	}
	
	/**
	 * @param totalSales
	 */
	public void setTotalSales(java.math.BigDecimal totalSales) {
		this.totalSales = totalSales;
	}
	
    /**
     * @return TotalSales
     */	
	public java.math.BigDecimal getTotalSales() {
		return this.totalSales;
	}
	
	/**
	 * @param indusCd
	 */
	public void setIndusCd(String indusCd) {
		this.indusCd = indusCd == null ? null : indusCd.trim();
	}
	
    /**
     * @return IndusCd
     */	
	public String getIndusCd() {
		return this.indusCd;
	}
	
	/**
	 * @param comMainOptScp
	 */
	public void setComMainOptScp(String comMainOptScp) {
		this.comMainOptScp = comMainOptScp == null ? null : comMainOptScp.trim();
	}
	
    /**
     * @return ComMainOptScp
     */	
	public String getComMainOptScp() {
		return this.comMainOptScp;
	}
	
	/**
	 * @param comPartOptScp
	 */
	public void setComPartOptScp(String comPartOptScp) {
		this.comPartOptScp = comPartOptScp == null ? null : comPartOptScp.trim();
	}
	
    /**
     * @return ComPartOptScp
     */	
	public String getComPartOptScp() {
		return this.comPartOptScp;
	}
	
	/**
	 * @param custBankRel
	 */
	public void setCustBankRel(String custBankRel) {
		this.custBankRel = custBankRel == null ? null : custBankRel.trim();
	}
	
    /**
     * @return CustBankRel
     */	
	public String getCustBankRel() {
		return this.custBankRel;
	}
	
	/**
	 * @param holdStockAmt
	 */
	public void setHoldStockAmt(java.math.BigDecimal holdStockAmt) {
		this.holdStockAmt = holdStockAmt;
	}
	
    /**
     * @return HoldStockAmt
     */	
	public java.math.BigDecimal getHoldStockAmt() {
		return this.holdStockAmt;
	}
	
	/**
	 * @param comRelDgr
	 */
	public void setComRelDgr(String comRelDgr) {
		this.comRelDgr = comRelDgr == null ? null : comRelDgr.trim();
	}
	
    /**
     * @return ComRelDgr
     */	
	public String getComRelDgr() {
		return this.comRelDgr;
	}
	
	/**
	 * @param beCustDate
	 */
	public void setBeCustDate(String beCustDate) {
		this.beCustDate = beCustDate == null ? null : beCustDate.trim();
	}
	
    /**
     * @return BeCustDate
     */	
	public String getBeCustDate() {
		return this.beCustDate;
	}
	
	/**
	 * @param comInitLoanDate
	 */
	public void setComInitLoanDate(String comInitLoanDate) {
		this.comInitLoanDate = comInitLoanDate == null ? null : comInitLoanDate.trim();
	}
	
    /**
     * @return ComInitLoanDate
     */	
	public String getComInitLoanDate() {
		return this.comInitLoanDate;
	}
	
	/**
	 * @param stockFlg
	 */
	public void setStockFlg(String stockFlg) {
		this.stockFlg = stockFlg == null ? null : stockFlg.trim();
	}
	
    /**
     * @return StockFlg
     */	
	public String getStockFlg() {
		return this.stockFlg;
	}
	
	/**
	 * @param realCntr
	 */
	public void setRealCntr(String realCntr) {
		this.realCntr = realCntr == null ? null : realCntr.trim();
	}
	
    /**
     * @return RealCntr
     */	
	public String getRealCntr() {
		return this.realCntr;
	}
	
	/**
	 * @param comEstabDate
	 */
	public void setComEstabDate(String comEstabDate) {
		this.comEstabDate = comEstabDate == null ? null : comEstabDate.trim();
	}
	
    /**
     * @return ComEstabDate
     */	
	public String getComEstabDate() {
		return this.comEstabDate;
	}
	
	/**
	 * @param empNum
	 */
	public void setEmpNum(String empNum) {
		this.empNum = empNum == null ? null : empNum.trim();
	}
	
    /**
     * @return EmpNum
     */	
	public String getEmpNum() {
		return this.empNum;
	}
	
	/**
	 * @param comInsRegDate
	 */
	public void setComInsRegDate(String comInsRegDate) {
		this.comInsRegDate = comInsRegDate == null ? null : comInsRegDate.trim();
	}
	
    /**
     * @return ComInsRegDate
     */	
	public String getComInsRegDate() {
		return this.comInsRegDate;
	}
	
	/**
	 * @param comInsExpDate
	 */
	public void setComInsExpDate(String comInsExpDate) {
		this.comInsExpDate = comInsExpDate == null ? null : comInsExpDate.trim();
	}
	
    /**
     * @return ComInsExpDate
     */	
	public String getComInsExpDate() {
		return this.comInsExpDate;
	}
	
	/**
	 * @param regCode
	 */
	public void setRegCode(String regCode) {
		this.regCode = regCode == null ? null : regCode.trim();
	}
	
    /**
     * @return RegCode
     */	
	public String getRegCode() {
		return this.regCode;
	}
	
	/**
	 * @param regType
	 */
	public void setRegType(String regType) {
		this.regType = regType == null ? null : regType.trim();
	}
	
    /**
     * @return RegType
     */	
	public String getRegType() {
		return this.regType;
	}
	
	/**
	 * @param regAreaName
	 */
	public void setRegAreaName(String regAreaName) {
		this.regAreaName = regAreaName == null ? null : regAreaName.trim();
	}
	
    /**
     * @return RegAreaName
     */	
	public String getRegAreaName() {
		return this.regAreaName;
	}
	
	/**
	 * @param regAddr
	 */
	public void setRegAddr(String regAddr) {
		this.regAddr = regAddr == null ? null : regAddr.trim();
	}
	
    /**
     * @return RegAddr
     */	
	public String getRegAddr() {
		return this.regAddr;
	}
	
	/**
	 * @param natTaxRegCode
	 */
	public void setNatTaxRegCode(String natTaxRegCode) {
		this.natTaxRegCode = natTaxRegCode == null ? null : natTaxRegCode.trim();
	}
	
    /**
     * @return NatTaxRegCode
     */	
	public String getNatTaxRegCode() {
		return this.natTaxRegCode;
	}
	
	/**
	 * @param locTaxRegCode
	 */
	public void setLocTaxRegCode(String locTaxRegCode) {
		this.locTaxRegCode = locTaxRegCode == null ? null : locTaxRegCode.trim();
	}
	
    /**
     * @return LocTaxRegCode
     */	
	public String getLocTaxRegCode() {
		return this.locTaxRegCode;
	}
	
	/**
	 * @param isBaseBank
	 */
	public void setIsBaseBank(String isBaseBank) {
		this.isBaseBank = isBaseBank == null ? null : isBaseBank.trim();
	}
	
    /**
     * @return IsBaseBank
     */	
	public String getIsBaseBank() {
		return this.isBaseBank;
	}
	
	/**
	 * @param curBank
	 */
	public void setCurBank(String curBank) {
		this.curBank = curBank == null ? null : curBank.trim();
	}
	
    /**
     * @return CurBank
     */	
	public String getCurBank() {
		return this.curBank;
	}
	
	/**
	 * @param forBank
	 */
	public void setForBank(String forBank) {
		this.forBank = forBank == null ? null : forBank.trim();
	}
	
    /**
     * @return ForBank
     */	
	public String getForBank() {
		return this.forBank;
	}
	
	/**
	 * @param curAcctNo
	 */
	public void setCurAcctNo(String curAcctNo) {
		this.curAcctNo = curAcctNo == null ? null : curAcctNo.trim();
	}
	
    /**
     * @return CurAcctNo
     */	
	public String getCurAcctNo() {
		return this.curAcctNo;
	}
	
	/**
	 * @param forAcctNo
	 */
	public void setForAcctNo(String forAcctNo) {
		this.forAcctNo = forAcctNo == null ? null : forAcctNo.trim();
	}
	
    /**
     * @return ForAcctNo
     */	
	public String getForAcctNo() {
		return this.forAcctNo;
	}
	
	/**
	 * @param baseAcctDate
	 */
	public void setBaseAcctDate(String baseAcctDate) {
		this.baseAcctDate = baseAcctDate == null ? null : baseAcctDate.trim();
	}
	
    /**
     * @return BaseAcctDate
     */	
	public String getBaseAcctDate() {
		return this.baseAcctDate;
	}
	
	/**
	 * @param corpType
	 */
	public void setCorpType(String corpType) {
		this.corpType = corpType == null ? null : corpType.trim();
	}
	
    /**
     * @return CorpType
     */	
	public String getCorpType() {
		return this.corpType;
	}
	
	/**
	 * @param econProper
	 */
	public void setEconProper(String econProper) {
		this.econProper = econProper == null ? null : econProper.trim();
	}
	
    /**
     * @return EconProper
     */	
	public String getEconProper() {
		return this.econProper;
	}
	
	/**
	 * @param insCredCod
	 */
	public void setInsCredCod(String insCredCod) {
		this.insCredCod = insCredCod == null ? null : insCredCod.trim();
	}
	
    /**
     * @return InsCredCod
     */	
	public String getInsCredCod() {
		return this.insCredCod;
	}
	
	/**
	 * @param legalCustId
	 */
	public void setLegalCustId(String legalCustId) {
		this.legalCustId = legalCustId == null ? null : legalCustId.trim();
	}
	
    /**
     * @return LegalCustId
     */	
	public String getLegalCustId() {
		return this.legalCustId;
	}
	
	/**
	 * @param legalName
	 */
	public void setLegalName(String legalName) {
		this.legalName = legalName == null ? null : legalName.trim();
	}
	
    /**
     * @return LegalName
     */	
	public String getLegalName() {
		return this.legalName;
	}
	
	/**
	 * @param contMan
	 */
	public void setContMan(String contMan) {
		this.contMan = contMan == null ? null : contMan.trim();
	}
	
    /**
     * @return ContMan
     */	
	public String getContMan() {
		return this.contMan;
	}
	
	/**
	 * @param contTelNo
	 */
	public void setContTelNo(String contTelNo) {
		this.contTelNo = contTelNo == null ? null : contTelNo.trim();
	}
	
    /**
     * @return ContTelNo
     */	
	public String getContTelNo() {
		return this.contTelNo;
	}
	
	/**
	 * @param effectFlg
	 */
	public void setEffectFlg(String effectFlg) {
		this.effectFlg = effectFlg == null ? null : effectFlg.trim();
	}
	
    /**
     * @return EffectFlg
     */	
	public String getEffectFlg() {
		return this.effectFlg;
	}
	
	/**
	 * @param loanSevenLev
	 */
	public void setLoanSevenLev(String loanSevenLev) {
		this.loanSevenLev = loanSevenLev == null ? null : loanSevenLev.trim();
	}
	
    /**
     * @return LoanSevenLev
     */	
	public String getLoanSevenLev() {
		return this.loanSevenLev;
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
	 * @param servLev
	 */
	public void setServLev(String servLev) {
		this.servLev = servLev == null ? null : servLev.trim();
	}
	
    /**
     * @return ServLev
     */	
	public String getServLev() {
		return this.servLev;
	}
	
	/**
	 * @param valueLev
	 */
	public void setValueLev(String valueLev) {
		this.valueLev = valueLev == null ? null : valueLev.trim();
	}
	
    /**
     * @return ValueLev
     */	
	public String getValueLev() {
		return this.valueLev;
	}
	
	/**
	 * @param belongMgr
	 */
	public void setBelongMgr(String belongMgr) {
		this.belongMgr = belongMgr == null ? null : belongMgr.trim();
	}
	
    /**
     * @return BelongMgr
     */	
	public String getBelongMgr() {
		return this.belongMgr;
	}
	
	/**
	 * @param belongBrch
	 */
	public void setBelongBrch(String belongBrch) {
		this.belongBrch = belongBrch == null ? null : belongBrch.trim();
	}
	
    /**
     * @return BelongBrch
     */	
	public String getBelongBrch() {
		return this.belongBrch;
	}
	
	/**
	 * @param custAssignStat
	 */
	public void setCustAssignStat(String custAssignStat) {
		this.custAssignStat = custAssignStat == null ? null : custAssignStat.trim();
	}
	
    /**
     * @return CustAssignStat
     */	
	public String getCustAssignStat() {
		return this.custAssignStat;
	}
	
	/**
	 * @param custStatus
	 */
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus == null ? null : custStatus.trim();
	}
	
    /**
     * @return CustStatus
     */	
	public String getCustStatus() {
		return this.custStatus;
	}
	
	/**
	 * @param srcCustStatus
	 */
	public void setSrcCustStatus(String srcCustStatus) {
		this.srcCustStatus = srcCustStatus == null ? null : srcCustStatus.trim();
	}
	
    /**
     * @return SrcCustStatus
     */	
	public String getSrcCustStatus() {
		return this.srcCustStatus;
	}
	
	/**
	 * @param isLoanCust
	 */
	public void setIsLoanCust(String isLoanCust) {
		this.isLoanCust = isLoanCust == null ? null : isLoanCust.trim();
	}
	
    /**
     * @return IsLoanCust
     */	
	public String getIsLoanCust() {
		return this.isLoanCust;
	}
	
	/**
	 * @param isStockCust
	 */
	public void setIsStockCust(String isStockCust) {
		this.isStockCust = isStockCust == null ? null : isStockCust.trim();
	}
	
    /**
     * @return IsStockCust
     */	
	public String getIsStockCust() {
		return this.isStockCust;
	}
	
	/**
	 * @param isCardVip
	 */
	public void setIsCardVip(String isCardVip) {
		this.isCardVip = isCardVip == null ? null : isCardVip.trim();
	}
	
    /**
     * @return IsCardVip
     */	
	public String getIsCardVip() {
		return this.isCardVip;
	}
	
	/**
	 * @param isAdmitEnter
	 */
	public void setIsAdmitEnter(String isAdmitEnter) {
		this.isAdmitEnter = isAdmitEnter == null ? null : isAdmitEnter.trim();
	}
	
    /**
     * @return IsAdmitEnter
     */	
	public String getIsAdmitEnter() {
		return this.isAdmitEnter;
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
	
	/**
	 * @param contCertType
	 */
	public void setContCertType(String contCertType) {
		this.contCertType = contCertType == null ? null : contCertType.trim();
	}
	
    /**
     * @return ContCertType
     */	
	public String getContCertType() {
		return this.contCertType;
	}
	
	/**
	 * @param contCertNo
	 */
	public void setContCertNo(String contCertNo) {
		this.contCertNo = contCertNo == null ? null : contCertNo.trim();
	}
	
    /**
     * @return ContCertNo
     */	
	public String getContCertNo() {
		return this.contCertNo;
	}
	
	/**
	 * @param telPhoneNo
	 */
	public void setTelPhoneNo(String telPhoneNo) {
		this.telPhoneNo = telPhoneNo == null ? null : telPhoneNo.trim();
	}
	
    /**
     * @return TelPhoneNo
     */	
	public String getTelPhoneNo() {
		return this.telPhoneNo;
	}
	
	/**
	 * @param sourceChannel
	 */
	public void setSourceChannel(String sourceChannel) {
		this.sourceChannel = sourceChannel == null ? null : sourceChannel.trim();
	}
	
    /**
     * @return SourceChannel
     */	
	public String getSourceChannel() {
		return this.sourceChannel;
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
        AcrmFciOrgCust other = (AcrmFciOrgCust) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastUpdateSys() == null ? other.getLastUpdateSys() == null : this.getLastUpdateSys().equals(other.getLastUpdateSys()))
        	&& (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
                	&& (this.getLastUpdateOrg() == null ? other.getLastUpdateOrg() == null : this.getLastUpdateOrg().equals(other.getLastUpdateOrg()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getEcifCustId() == null ? other.getEcifCustId() == null : this.getEcifCustId().equals(other.getEcifCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
        	&& (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
        	&& (this.getRegCurrCd() == null ? other.getRegCurrCd() == null : this.getRegCurrCd().equals(other.getRegCurrCd()))
                	&& (this.getComScale() == null ? other.getComScale() == null : this.getComScale().equals(other.getComScale()))
                	&& (this.getLoanCustType() == null ? other.getLoanCustType() == null : this.getLoanCustType().equals(other.getLoanCustType()))
        	&& (this.getInvType() == null ? other.getInvType() == null : this.getInvType().equals(other.getInvType()))
                	&& (this.getIndusCd() == null ? other.getIndusCd() == null : this.getIndusCd().equals(other.getIndusCd()))
        	&& (this.getComMainOptScp() == null ? other.getComMainOptScp() == null : this.getComMainOptScp().equals(other.getComMainOptScp()))
        	&& (this.getComPartOptScp() == null ? other.getComPartOptScp() == null : this.getComPartOptScp().equals(other.getComPartOptScp()))
        	&& (this.getCustBankRel() == null ? other.getCustBankRel() == null : this.getCustBankRel().equals(other.getCustBankRel()))
                	&& (this.getComRelDgr() == null ? other.getComRelDgr() == null : this.getComRelDgr().equals(other.getComRelDgr()))
        	&& (this.getBeCustDate() == null ? other.getBeCustDate() == null : this.getBeCustDate().equals(other.getBeCustDate()))
        	&& (this.getComInitLoanDate() == null ? other.getComInitLoanDate() == null : this.getComInitLoanDate().equals(other.getComInitLoanDate()))
        	&& (this.getStockFlg() == null ? other.getStockFlg() == null : this.getStockFlg().equals(other.getStockFlg()))
        	&& (this.getRealCntr() == null ? other.getRealCntr() == null : this.getRealCntr().equals(other.getRealCntr()))
        	&& (this.getComEstabDate() == null ? other.getComEstabDate() == null : this.getComEstabDate().equals(other.getComEstabDate()))
        	&& (this.getEmpNum() == null ? other.getEmpNum() == null : this.getEmpNum().equals(other.getEmpNum()))
        	&& (this.getComInsRegDate() == null ? other.getComInsRegDate() == null : this.getComInsRegDate().equals(other.getComInsRegDate()))
        	&& (this.getComInsExpDate() == null ? other.getComInsExpDate() == null : this.getComInsExpDate().equals(other.getComInsExpDate()))
        	&& (this.getRegCode() == null ? other.getRegCode() == null : this.getRegCode().equals(other.getRegCode()))
        	&& (this.getRegType() == null ? other.getRegType() == null : this.getRegType().equals(other.getRegType()))
        	&& (this.getRegAreaName() == null ? other.getRegAreaName() == null : this.getRegAreaName().equals(other.getRegAreaName()))
        	&& (this.getRegAddr() == null ? other.getRegAddr() == null : this.getRegAddr().equals(other.getRegAddr()))
        	&& (this.getNatTaxRegCode() == null ? other.getNatTaxRegCode() == null : this.getNatTaxRegCode().equals(other.getNatTaxRegCode()))
        	&& (this.getLocTaxRegCode() == null ? other.getLocTaxRegCode() == null : this.getLocTaxRegCode().equals(other.getLocTaxRegCode()))
        	&& (this.getIsBaseBank() == null ? other.getIsBaseBank() == null : this.getIsBaseBank().equals(other.getIsBaseBank()))
        	&& (this.getCurBank() == null ? other.getCurBank() == null : this.getCurBank().equals(other.getCurBank()))
        	&& (this.getForBank() == null ? other.getForBank() == null : this.getForBank().equals(other.getForBank()))
        	&& (this.getCurAcctNo() == null ? other.getCurAcctNo() == null : this.getCurAcctNo().equals(other.getCurAcctNo()))
        	&& (this.getForAcctNo() == null ? other.getForAcctNo() == null : this.getForAcctNo().equals(other.getForAcctNo()))
        	&& (this.getBaseAcctDate() == null ? other.getBaseAcctDate() == null : this.getBaseAcctDate().equals(other.getBaseAcctDate()))
        	&& (this.getCorpType() == null ? other.getCorpType() == null : this.getCorpType().equals(other.getCorpType()))
        	&& (this.getEconProper() == null ? other.getEconProper() == null : this.getEconProper().equals(other.getEconProper()))
        	&& (this.getInsCredCod() == null ? other.getInsCredCod() == null : this.getInsCredCod().equals(other.getInsCredCod()))
        	&& (this.getLegalCustId() == null ? other.getLegalCustId() == null : this.getLegalCustId().equals(other.getLegalCustId()))
        	&& (this.getLegalName() == null ? other.getLegalName() == null : this.getLegalName().equals(other.getLegalName()))
        	&& (this.getContMan() == null ? other.getContMan() == null : this.getContMan().equals(other.getContMan()))
        	&& (this.getContTelNo() == null ? other.getContTelNo() == null : this.getContTelNo().equals(other.getContTelNo()))
        	&& (this.getEffectFlg() == null ? other.getEffectFlg() == null : this.getEffectFlg().equals(other.getEffectFlg()))
        	&& (this.getLoanSevenLev() == null ? other.getLoanSevenLev() == null : this.getLoanSevenLev().equals(other.getLoanSevenLev()))
        	&& (this.getCreditLev() == null ? other.getCreditLev() == null : this.getCreditLev().equals(other.getCreditLev()))
        	&& (this.getServLev() == null ? other.getServLev() == null : this.getServLev().equals(other.getServLev()))
        	&& (this.getValueLev() == null ? other.getValueLev() == null : this.getValueLev().equals(other.getValueLev()))
        	&& (this.getBelongMgr() == null ? other.getBelongMgr() == null : this.getBelongMgr().equals(other.getBelongMgr()))
        	&& (this.getBelongBrch() == null ? other.getBelongBrch() == null : this.getBelongBrch().equals(other.getBelongBrch()))
        	&& (this.getCustAssignStat() == null ? other.getCustAssignStat() == null : this.getCustAssignStat().equals(other.getCustAssignStat()))
        	&& (this.getCustStatus() == null ? other.getCustStatus() == null : this.getCustStatus().equals(other.getCustStatus()))
        	&& (this.getSrcCustStatus() == null ? other.getSrcCustStatus() == null : this.getSrcCustStatus().equals(other.getSrcCustStatus()))
        	&& (this.getIsLoanCust() == null ? other.getIsLoanCust() == null : this.getIsLoanCust().equals(other.getIsLoanCust()))
        	&& (this.getIsStockCust() == null ? other.getIsStockCust() == null : this.getIsStockCust().equals(other.getIsStockCust()))
        	&& (this.getIsCardVip() == null ? other.getIsCardVip() == null : this.getIsCardVip().equals(other.getIsCardVip()))
        	&& (this.getIsAdmitEnter() == null ? other.getIsAdmitEnter() == null : this.getIsAdmitEnter().equals(other.getIsAdmitEnter()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getContCertType() == null ? other.getContCertType() == null : this.getContCertType().equals(other.getContCertType()))
        	&& (this.getContCertNo() == null ? other.getContCertNo() == null : this.getContCertNo().equals(other.getContCertNo()))
        	&& (this.getTelPhoneNo() == null ? other.getTelPhoneNo() == null : this.getTelPhoneNo().equals(other.getTelPhoneNo()))
        	&& (this.getSourceChannel() == null ? other.getSourceChannel() == null : this.getSourceChannel().equals(other.getSourceChannel()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getLastUpdateSys() == null) ? 0 : getLastUpdateSys().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getLastUpdateOrg() == null) ? 0 : getLastUpdateOrg().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getEcifCustId() == null) ? 0 : getEcifCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getRegCurrCd() == null) ? 0 : getRegCurrCd().hashCode());
        result = prime * result + ((getComScale() == null) ? 0 : getComScale().hashCode());
        result = prime * result + ((getLoanCustType() == null) ? 0 : getLoanCustType().hashCode());
        result = prime * result + ((getInvType() == null) ? 0 : getInvType().hashCode());
        result = prime * result + ((getIndusCd() == null) ? 0 : getIndusCd().hashCode());
        result = prime * result + ((getComMainOptScp() == null) ? 0 : getComMainOptScp().hashCode());
        result = prime * result + ((getComPartOptScp() == null) ? 0 : getComPartOptScp().hashCode());
        result = prime * result + ((getCustBankRel() == null) ? 0 : getCustBankRel().hashCode());
        result = prime * result + ((getComRelDgr() == null) ? 0 : getComRelDgr().hashCode());
        result = prime * result + ((getBeCustDate() == null) ? 0 : getBeCustDate().hashCode());
        result = prime * result + ((getComInitLoanDate() == null) ? 0 : getComInitLoanDate().hashCode());
        result = prime * result + ((getStockFlg() == null) ? 0 : getStockFlg().hashCode());
        result = prime * result + ((getRealCntr() == null) ? 0 : getRealCntr().hashCode());
        result = prime * result + ((getComEstabDate() == null) ? 0 : getComEstabDate().hashCode());
        result = prime * result + ((getEmpNum() == null) ? 0 : getEmpNum().hashCode());
        result = prime * result + ((getComInsRegDate() == null) ? 0 : getComInsRegDate().hashCode());
        result = prime * result + ((getComInsExpDate() == null) ? 0 : getComInsExpDate().hashCode());
        result = prime * result + ((getRegCode() == null) ? 0 : getRegCode().hashCode());
        result = prime * result + ((getRegType() == null) ? 0 : getRegType().hashCode());
        result = prime * result + ((getRegAreaName() == null) ? 0 : getRegAreaName().hashCode());
        result = prime * result + ((getRegAddr() == null) ? 0 : getRegAddr().hashCode());
        result = prime * result + ((getNatTaxRegCode() == null) ? 0 : getNatTaxRegCode().hashCode());
        result = prime * result + ((getLocTaxRegCode() == null) ? 0 : getLocTaxRegCode().hashCode());
        result = prime * result + ((getIsBaseBank() == null) ? 0 : getIsBaseBank().hashCode());
        result = prime * result + ((getCurBank() == null) ? 0 : getCurBank().hashCode());
        result = prime * result + ((getForBank() == null) ? 0 : getForBank().hashCode());
        result = prime * result + ((getCurAcctNo() == null) ? 0 : getCurAcctNo().hashCode());
        result = prime * result + ((getForAcctNo() == null) ? 0 : getForAcctNo().hashCode());
        result = prime * result + ((getBaseAcctDate() == null) ? 0 : getBaseAcctDate().hashCode());
        result = prime * result + ((getCorpType() == null) ? 0 : getCorpType().hashCode());
        result = prime * result + ((getEconProper() == null) ? 0 : getEconProper().hashCode());
        result = prime * result + ((getInsCredCod() == null) ? 0 : getInsCredCod().hashCode());
        result = prime * result + ((getLegalCustId() == null) ? 0 : getLegalCustId().hashCode());
        result = prime * result + ((getLegalName() == null) ? 0 : getLegalName().hashCode());
        result = prime * result + ((getContMan() == null) ? 0 : getContMan().hashCode());
        result = prime * result + ((getContTelNo() == null) ? 0 : getContTelNo().hashCode());
        result = prime * result + ((getEffectFlg() == null) ? 0 : getEffectFlg().hashCode());
        result = prime * result + ((getLoanSevenLev() == null) ? 0 : getLoanSevenLev().hashCode());
        result = prime * result + ((getCreditLev() == null) ? 0 : getCreditLev().hashCode());
        result = prime * result + ((getServLev() == null) ? 0 : getServLev().hashCode());
        result = prime * result + ((getValueLev() == null) ? 0 : getValueLev().hashCode());
        result = prime * result + ((getBelongMgr() == null) ? 0 : getBelongMgr().hashCode());
        result = prime * result + ((getBelongBrch() == null) ? 0 : getBelongBrch().hashCode());
        result = prime * result + ((getCustAssignStat() == null) ? 0 : getCustAssignStat().hashCode());
        result = prime * result + ((getCustStatus() == null) ? 0 : getCustStatus().hashCode());
        result = prime * result + ((getSrcCustStatus() == null) ? 0 : getSrcCustStatus().hashCode());
        result = prime * result + ((getIsLoanCust() == null) ? 0 : getIsLoanCust().hashCode());
        result = prime * result + ((getIsStockCust() == null) ? 0 : getIsStockCust().hashCode());
        result = prime * result + ((getIsCardVip() == null) ? 0 : getIsCardVip().hashCode());
        result = prime * result + ((getIsAdmitEnter() == null) ? 0 : getIsAdmitEnter().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getContCertType() == null) ? 0 : getContCertType().hashCode());
        result = prime * result + ((getContCertNo() == null) ? 0 : getContCertNo().hashCode());
        result = prime * result + ((getTelPhoneNo() == null) ? 0 : getTelPhoneNo().hashCode());
        result = prime * result + ((getSourceChannel() == null) ? 0 : getSourceChannel().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", lastUpdateSys=").append(lastUpdateSys);
		sb.append(", lastUpdateUser=").append(lastUpdateUser);
		sb.append(", lastUpdateTm=").append(lastUpdateTm);
		sb.append(", lastUpdateOrg=").append(lastUpdateOrg);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", ecifCustId=").append(ecifCustId);
		sb.append(", custName=").append(custName);
		sb.append(", certType=").append(certType);
		sb.append(", certNo=").append(certNo);
		sb.append(", regCurrCd=").append(regCurrCd);
		sb.append(", regCapital=").append(regCapital);
		sb.append(", comScale=").append(comScale);
		sb.append(", totalAssets=").append(totalAssets);
		sb.append(", loanCustType=").append(loanCustType);
		sb.append(", invType=").append(invType);
		sb.append(", totalSales=").append(totalSales);
		sb.append(", indusCd=").append(indusCd);
		sb.append(", comMainOptScp=").append(comMainOptScp);
		sb.append(", comPartOptScp=").append(comPartOptScp);
		sb.append(", custBankRel=").append(custBankRel);
		sb.append(", holdStockAmt=").append(holdStockAmt);
		sb.append(", comRelDgr=").append(comRelDgr);
		sb.append(", beCustDate=").append(beCustDate);
		sb.append(", comInitLoanDate=").append(comInitLoanDate);
		sb.append(", stockFlg=").append(stockFlg);
		sb.append(", realCntr=").append(realCntr);
		sb.append(", comEstabDate=").append(comEstabDate);
		sb.append(", empNum=").append(empNum);
		sb.append(", comInsRegDate=").append(comInsRegDate);
		sb.append(", comInsExpDate=").append(comInsExpDate);
		sb.append(", regCode=").append(regCode);
		sb.append(", regType=").append(regType);
		sb.append(", regAreaName=").append(regAreaName);
		sb.append(", regAddr=").append(regAddr);
		sb.append(", natTaxRegCode=").append(natTaxRegCode);
		sb.append(", locTaxRegCode=").append(locTaxRegCode);
		sb.append(", isBaseBank=").append(isBaseBank);
		sb.append(", curBank=").append(curBank);
		sb.append(", forBank=").append(forBank);
		sb.append(", curAcctNo=").append(curAcctNo);
		sb.append(", forAcctNo=").append(forAcctNo);
		sb.append(", baseAcctDate=").append(baseAcctDate);
		sb.append(", corpType=").append(corpType);
		sb.append(", econProper=").append(econProper);
		sb.append(", insCredCod=").append(insCredCod);
		sb.append(", legalCustId=").append(legalCustId);
		sb.append(", legalName=").append(legalName);
		sb.append(", contMan=").append(contMan);
		sb.append(", contTelNo=").append(contTelNo);
		sb.append(", effectFlg=").append(effectFlg);
		sb.append(", loanSevenLev=").append(loanSevenLev);
		sb.append(", creditLev=").append(creditLev);
		sb.append(", servLev=").append(servLev);
		sb.append(", valueLev=").append(valueLev);
		sb.append(", belongMgr=").append(belongMgr);
		sb.append(", belongBrch=").append(belongBrch);
		sb.append(", custAssignStat=").append(custAssignStat);
		sb.append(", custStatus=").append(custStatus);
		sb.append(", srcCustStatus=").append(srcCustStatus);
		sb.append(", isLoanCust=").append(isLoanCust);
		sb.append(", isStockCust=").append(isStockCust);
		sb.append(", isCardVip=").append(isCardVip);
		sb.append(", isAdmitEnter=").append(isAdmitEnter);
		sb.append(", remark=").append(remark);
		sb.append(", contCertType=").append(contCertType);
		sb.append(", contCertNo=").append(contCertNo);
		sb.append(", telPhoneNo=").append(telPhoneNo);
		sb.append(", sourceChannel=").append(sourceChannel);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}