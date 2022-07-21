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
 * @类名称: AcrmFagCcdAcct
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-01-29 10:16:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_CCD_ACCT")
public class AcrmFagCcdAcct extends BaseDomain implements Serializable{
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
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 账户编号
 **/
	@Column(name = "ACCT_NO", unique = false, nullable = true, length = 20)
	private String acctNo;
	
	/** 产品代码
 **/
	@Column(name = "PROD_CD", unique = false, nullable = true, length = 10)
	private String prodCd;
	
	/** 币种
 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 信用额度
 **/
	@Column(name = "CREDIT_LMT", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal creditLmt;
	
	/** 临时额度
 **/
	@Column(name = "TEMP_LMT", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal tempLmt;
	
	/** 临时额度开始日期
 **/
	@Transient
	@Column(name = "TEMP_LMT_S_DATE", unique = false, nullable = true, length = 7)
	private Date tempLmtSdate;
	
	/** 临时额度结束日期
 **/
	@Transient
	@Column(name = "TEMP_LMT_E_DATE", unique = false, nullable = true, length = 7)
	private Date tempLmtEdate;
	
	/** 取现额度比例
 **/
	@Column(name = "WITHDRAW_CASH_LMT", unique = false, nullable = true, length = 5)
	private java.math.BigDecimal withdrawCashLmt;
	
	/** 授权超限比例
 **/
	@Column(name = "AUTH_UP_PERCENT", unique = false, nullable = true, length = 5)
	private java.math.BigDecimal authUpPercent;
	
	/** 额度内分期额度比例
 **/
	@Column(name = "LMT_INSTAL_PERCENT", unique = false, nullable = true, length = 5)
	private java.math.BigDecimal lmtInstalPercent;
	
	/** 当前余额
 **/
	@Column(name = "BAL", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal bal;
	
	/** 取现余额
 **/
	@Column(name = "WITHDRAW_CASH_BAL", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal withdrawCashBal;
	
	/** 本金余额
 **/
	@Column(name = "PRIN_BAL", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal prinBal;
	
	/** 额度内分期余额
 **/
	@Column(name = "LMT_INSTAL_BAL", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal lmtInstalBal;
	
	/** 全部应还款额
 **/
	@Column(name = "ALL_AP_LMT", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal allApLmt;
	
	/** 积分余额
 **/
	@Column(name = "POINTS_BAL", unique = false, nullable = true, length = 16)
	private long pointsBal;
	
	/** 创建日期
 **/
	@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 账单周期
  **/
	@Column(name = "BILL_PERIOD", unique = false, nullable = true, length = 10)
	private String billPeriod;
	
	/** 寄送账单标志
 **/
	@Column(name = "POST_BILL_IND", unique = false, nullable = true, length = 10)
	private String postBillInd;
	
	/** 账单寄送地址标志
 **/
	@Column(name = "POST_BILL_ADDR", unique = false, nullable = true, length = 10)
	private String postBillAddr;
	
	/** 账单介质类型
 **/
	@Column(name = "BILL_MEDIUM_TYEP", unique = false, nullable = true, length = 1)
	private String billMediumTyep;
	
	/** 锁定码
 **/
	@Column(name = "LOCK_CD", unique = false, nullable = true, length = 30)
	private String lockCd;
	
	/** 账龄
 **/
	@Column(name = "BILL_AGE", unique = false, nullable = true, length = 10)
	private String billAge;
	
	/** 约定还款类型
 **/
	@Column(name = "STPLT_REPAY_TYPE", unique = false, nullable = true, length = 10)
	private String stpltRepayType;
	
	/** 约定还款银行名称
 **/
	@Column(name = "STPLT_REPAY_BANK_NM", unique = false, nullable = true, length = 80)
	private String stpltRepayBankNm;
	
	/** 约定还款开户行号
 **/
	@Column(name = "STPLT_REPAY_OPENBANK_NO", unique = false, nullable = true, length = 20)
	private String stpltRepayOpenbankNo;
	
	/** 约定还款扣款账号
 **/
	@Column(name = "STPLT_REPAY_ACCT_NO", unique = false, nullable = true, length = 40)
	private String stpltRepayAcctNo;
	
	/** 约定还款扣款账户姓名
 **/
	@Column(name = "STPLT_REPAY_ACCT_NM", unique = false, nullable = true, length = 80)
	private String stpltRepayAcctNm;
	
	/** 最终销户日期
 **/
	@Transient
	@Column(name = "LAST_END_DATE", unique = false, nullable = true, length = 7)
	private Date lastEndDate;
	
	/** 预销户日期
 **/
	@Transient
	@Column(name = "PLAN_END_DATE", unique = false, nullable = true, length = 7)
	private Date planEndDate;
	
	/** 最小还款额
 **/
	@Column(name = "MIN_REPAY_LMT", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal minRepayLmt;
	
	/** 还款历史信息
 **/
	@Column(name = "REPAY_HIS_INFO", unique = false, nullable = true, length = 40)
	private String repayHisInfo;
	
	/** 上期还款金额
 **/
	@Column(name = "LAST_REPAY_AMT", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal lastRepayAmt;
	
	/** 客户最后交易日期
 **/
	@Transient
	@Column(name = "CUST_LAST_TRANS_DATE", unique = false, nullable = true, length = 7)
	private Date custLastTransDate;
	
	/** 本月实际还款金额
 **/
	@Column(name = "ACTUAL_REPAY_AMT", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal actualRepayAmt;
	
	/** 核销金额
 **/
	@Column(name = "CANCEL_AMT", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal cancelAmt;
	
	/** 核销日期
 **/
	@Transient
	@Column(name = "CANCEL_DATE", unique = false, nullable = true, length = 7)
	private Date cancelDate;
	
	/** 未出账单余额
 **/
	@Column(name = "UNBILL_BAL", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal unbillBal;
	
	/** 备注
 **/
	@Column(name = "RMK", unique = false, nullable = true, length = 300)
	private String rmk;
	
	/** 当年消费金额
 **/
	@Column(name = "CONSUME_TOYEAR", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal consumeToyear;
	
	/** 入催次数
 **/
	@Column(name = "URGE_NUM", unique = false, nullable = true, length = 2)
	private byte urgeNum;
	
	/** 入催原因
 **/
	@Column(name = "URGE_RSN", unique = false, nullable = true, length = 6)
	private String urgeRsn;
	
	
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
	 * @param creditLmt
	 */
	public void setCreditLmt(java.math.BigDecimal creditLmt) {
		this.creditLmt = creditLmt;
	}
	
    /**
     * @return CreditLmt
     */	
	public java.math.BigDecimal getCreditLmt() {
		return this.creditLmt;
	}
	
	/**
	 * @param tempLmt
	 */
	public void setTempLmt(java.math.BigDecimal tempLmt) {
		this.tempLmt = tempLmt;
	}
	
    /**
     * @return TempLmt
     */	
	public java.math.BigDecimal getTempLmt() {
		return this.tempLmt;
	}
	
	/**
	 * @param tempLmtSdate
	 */
	public void setTempLmtSdate(Date tempLmtSdate) {
		this.tempLmtSdate = tempLmtSdate;
	}
	
    /**
     * @return TempLmtSdate
     */	
	public Date getTempLmtSdate() {
		return this.tempLmtSdate;
	}
	
	/**
	 * @param tempLmtEdate
	 */
	public void setTempLmtEdate(Date tempLmtEdate) {
		this.tempLmtEdate = tempLmtEdate;
	}
	
    /**
     * @return TempLmtEdate
     */	
	public Date getTempLmtEdate() {
		return this.tempLmtEdate;
	}
	
	/**
	 * @param withdrawCashLmt
	 */
	public void setWithdrawCashLmt(java.math.BigDecimal withdrawCashLmt) {
		this.withdrawCashLmt = withdrawCashLmt;
	}
	
    /**
     * @return WithdrawCashLmt
     */	
	public java.math.BigDecimal getWithdrawCashLmt() {
		return this.withdrawCashLmt;
	}
	
	/**
	 * @param authUpPercent
	 */
	public void setAuthUpPercent(java.math.BigDecimal authUpPercent) {
		this.authUpPercent = authUpPercent;
	}
	
    /**
     * @return AuthUpPercent
     */	
	public java.math.BigDecimal getAuthUpPercent() {
		return this.authUpPercent;
	}
	
	/**
	 * @param lmtInstalPercent
	 */
	public void setLmtInstalPercent(java.math.BigDecimal lmtInstalPercent) {
		this.lmtInstalPercent = lmtInstalPercent;
	}
	
    /**
     * @return LmtInstalPercent
     */	
	public java.math.BigDecimal getLmtInstalPercent() {
		return this.lmtInstalPercent;
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
	 * @param withdrawCashBal
	 */
	public void setWithdrawCashBal(java.math.BigDecimal withdrawCashBal) {
		this.withdrawCashBal = withdrawCashBal;
	}
	
    /**
     * @return WithdrawCashBal
     */	
	public java.math.BigDecimal getWithdrawCashBal() {
		return this.withdrawCashBal;
	}
	
	/**
	 * @param prinBal
	 */
	public void setPrinBal(java.math.BigDecimal prinBal) {
		this.prinBal = prinBal;
	}
	
    /**
     * @return PrinBal
     */	
	public java.math.BigDecimal getPrinBal() {
		return this.prinBal;
	}
	
	/**
	 * @param lmtInstalBal
	 */
	public void setLmtInstalBal(java.math.BigDecimal lmtInstalBal) {
		this.lmtInstalBal = lmtInstalBal;
	}
	
    /**
     * @return LmtInstalBal
     */	
	public java.math.BigDecimal getLmtInstalBal() {
		return this.lmtInstalBal;
	}
	
	/**
	 * @param allApLmt
	 */
	public void setAllApLmt(java.math.BigDecimal allApLmt) {
		this.allApLmt = allApLmt;
	}
	
    /**
     * @return AllApLmt
     */	
	public java.math.BigDecimal getAllApLmt() {
		return this.allApLmt;
	}
	
	/**
	 * @param pointsBal
	 */
	public void setPointsBal(long pointsBal) {
		this.pointsBal = pointsBal;
	}
	
    /**
     * @return PointsBal
     */	
	public long getPointsBal() {
		return this.pointsBal;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
    /**
     * @return CreateDate
     */	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param billPeriod
	 */
	public void setBillPeriod(String billPeriod) {
		this.billPeriod = billPeriod == null ? null : billPeriod.trim();
	}
	
    /**
     * @return BillPeriod
     */	
	public String getBillPeriod() {
		return this.billPeriod;
	}
	
	/**
	 * @param postBillInd
	 */
	public void setPostBillInd(String postBillInd) {
		this.postBillInd = postBillInd == null ? null : postBillInd.trim();
	}
	
    /**
     * @return PostBillInd
     */	
	public String getPostBillInd() {
		return this.postBillInd;
	}
	
	/**
	 * @param postBillAddr
	 */
	public void setPostBillAddr(String postBillAddr) {
		this.postBillAddr = postBillAddr == null ? null : postBillAddr.trim();
	}
	
    /**
     * @return PostBillAddr
     */	
	public String getPostBillAddr() {
		return this.postBillAddr;
	}
	
	/**
	 * @param billMediumTyep
	 */
	public void setBillMediumTyep(String billMediumTyep) {
		this.billMediumTyep = billMediumTyep == null ? null : billMediumTyep.trim();
	}
	
    /**
     * @return BillMediumTyep
     */	
	public String getBillMediumTyep() {
		return this.billMediumTyep;
	}
	
	/**
	 * @param lockCd
	 */
	public void setLockCd(String lockCd) {
		this.lockCd = lockCd == null ? null : lockCd.trim();
	}
	
    /**
     * @return LockCd
     */	
	public String getLockCd() {
		return this.lockCd;
	}
	
	/**
	 * @param billAge
	 */
	public void setBillAge(String billAge) {
		this.billAge = billAge == null ? null : billAge.trim();
	}
	
    /**
     * @return BillAge
     */	
	public String getBillAge() {
		return this.billAge;
	}
	
	/**
	 * @param stpltRepayType
	 */
	public void setStpltRepayType(String stpltRepayType) {
		this.stpltRepayType = stpltRepayType == null ? null : stpltRepayType.trim();
	}
	
    /**
     * @return StpltRepayType
     */	
	public String getStpltRepayType() {
		return this.stpltRepayType;
	}
	
	/**
	 * @param stpltRepayBankNm
	 */
	public void setStpltRepayBankNm(String stpltRepayBankNm) {
		this.stpltRepayBankNm = stpltRepayBankNm == null ? null : stpltRepayBankNm.trim();
	}
	
    /**
     * @return StpltRepayBankNm
     */	
	public String getStpltRepayBankNm() {
		return this.stpltRepayBankNm;
	}
	
	/**
	 * @param stpltRepayOpenbankNo
	 */
	public void setStpltRepayOpenbankNo(String stpltRepayOpenbankNo) {
		this.stpltRepayOpenbankNo = stpltRepayOpenbankNo == null ? null : stpltRepayOpenbankNo.trim();
	}
	
    /**
     * @return StpltRepayOpenbankNo
     */	
	public String getStpltRepayOpenbankNo() {
		return this.stpltRepayOpenbankNo;
	}
	
	/**
	 * @param stpltRepayAcctNo
	 */
	public void setStpltRepayAcctNo(String stpltRepayAcctNo) {
		this.stpltRepayAcctNo = stpltRepayAcctNo == null ? null : stpltRepayAcctNo.trim();
	}
	
    /**
     * @return StpltRepayAcctNo
     */	
	public String getStpltRepayAcctNo() {
		return this.stpltRepayAcctNo;
	}
	
	/**
	 * @param stpltRepayAcctNm
	 */
	public void setStpltRepayAcctNm(String stpltRepayAcctNm) {
		this.stpltRepayAcctNm = stpltRepayAcctNm == null ? null : stpltRepayAcctNm.trim();
	}
	
    /**
     * @return StpltRepayAcctNm
     */	
	public String getStpltRepayAcctNm() {
		return this.stpltRepayAcctNm;
	}
	
	/**
	 * @param lastEndDate
	 */
	public void setLastEndDate(Date lastEndDate) {
		this.lastEndDate = lastEndDate;
	}
	
    /**
     * @return LastEndDate
     */	
	public Date getLastEndDate() {
		return this.lastEndDate;
	}
	
	/**
	 * @param planEndDate
	 */
	public void setPlanEndDate(Date planEndDate) {
		this.planEndDate = planEndDate;
	}
	
    /**
     * @return PlanEndDate
     */	
	public Date getPlanEndDate() {
		return this.planEndDate;
	}
	
	/**
	 * @param minRepayLmt
	 */
	public void setMinRepayLmt(java.math.BigDecimal minRepayLmt) {
		this.minRepayLmt = minRepayLmt;
	}
	
    /**
     * @return MinRepayLmt
     */	
	public java.math.BigDecimal getMinRepayLmt() {
		return this.minRepayLmt;
	}
	
	/**
	 * @param repayHisInfo
	 */
	public void setRepayHisInfo(String repayHisInfo) {
		this.repayHisInfo = repayHisInfo == null ? null : repayHisInfo.trim();
	}
	
    /**
     * @return RepayHisInfo
     */	
	public String getRepayHisInfo() {
		return this.repayHisInfo;
	}
	
	/**
	 * @param lastRepayAmt
	 */
	public void setLastRepayAmt(java.math.BigDecimal lastRepayAmt) {
		this.lastRepayAmt = lastRepayAmt;
	}
	
    /**
     * @return LastRepayAmt
     */	
	public java.math.BigDecimal getLastRepayAmt() {
		return this.lastRepayAmt;
	}
	
	/**
	 * @param custLastTransDate
	 */
	public void setCustLastTransDate(Date custLastTransDate) {
		this.custLastTransDate = custLastTransDate;
	}
	
    /**
     * @return CustLastTransDate
     */	
	public Date getCustLastTransDate() {
		return this.custLastTransDate;
	}
	
	/**
	 * @param actualRepayAmt
	 */
	public void setActualRepayAmt(java.math.BigDecimal actualRepayAmt) {
		this.actualRepayAmt = actualRepayAmt;
	}
	
    /**
     * @return ActualRepayAmt
     */	
	public java.math.BigDecimal getActualRepayAmt() {
		return this.actualRepayAmt;
	}
	
	/**
	 * @param cancelAmt
	 */
	public void setCancelAmt(java.math.BigDecimal cancelAmt) {
		this.cancelAmt = cancelAmt;
	}
	
    /**
     * @return CancelAmt
     */	
	public java.math.BigDecimal getCancelAmt() {
		return this.cancelAmt;
	}
	
	/**
	 * @param cancelDate
	 */
	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}
	
    /**
     * @return CancelDate
     */	
	public Date getCancelDate() {
		return this.cancelDate;
	}
	
	/**
	 * @param unbillBal
	 */
	public void setUnbillBal(java.math.BigDecimal unbillBal) {
		this.unbillBal = unbillBal;
	}
	
    /**
     * @return UnbillBal
     */	
	public java.math.BigDecimal getUnbillBal() {
		return this.unbillBal;
	}
	
	/**
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk == null ? null : rmk.trim();
	}
	
    /**
     * @return Rmk
     */	
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * @param consumeToyear
	 */
	public void setConsumeToyear(java.math.BigDecimal consumeToyear) {
		this.consumeToyear = consumeToyear;
	}
	
    /**
     * @return ConsumeToyear
     */	
	public java.math.BigDecimal getConsumeToyear() {
		return this.consumeToyear;
	}
	
	/**
	 * @param urgeNum
	 */
	public void setUrgeNum(byte urgeNum) {
		this.urgeNum = urgeNum;
	}
	
    /**
     * @return UrgeNum
     */	
	public byte getUrgeNum() {
		return this.urgeNum;
	}
	
	/**
	 * @param urgeRsn
	 */
	public void setUrgeRsn(String urgeRsn) {
		this.urgeRsn = urgeRsn == null ? null : urgeRsn.trim();
	}
	
    /**
     * @return UrgeRsn
     */	
	public String getUrgeRsn() {
		return this.urgeRsn;
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
        AcrmFagCcdAcct other = (AcrmFagCcdAcct) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getAcctNo() == null ? other.getAcctNo() == null : this.getAcctNo().equals(other.getAcctNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getProdCd() == null ? other.getProdCd() == null : this.getProdCd().equals(other.getProdCd()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
                                                                                                                        	&& (this.getBillPeriod() == null ? other.getBillPeriod() == null : this.getBillPeriod().equals(other.getBillPeriod()))
        	&& (this.getPostBillInd() == null ? other.getPostBillInd() == null : this.getPostBillInd().equals(other.getPostBillInd()))
        	&& (this.getPostBillAddr() == null ? other.getPostBillAddr() == null : this.getPostBillAddr().equals(other.getPostBillAddr()))
        	&& (this.getBillMediumTyep() == null ? other.getBillMediumTyep() == null : this.getBillMediumTyep().equals(other.getBillMediumTyep()))
        	&& (this.getLockCd() == null ? other.getLockCd() == null : this.getLockCd().equals(other.getLockCd()))
        	&& (this.getBillAge() == null ? other.getBillAge() == null : this.getBillAge().equals(other.getBillAge()))
        	&& (this.getStpltRepayType() == null ? other.getStpltRepayType() == null : this.getStpltRepayType().equals(other.getStpltRepayType()))
        	&& (this.getStpltRepayBankNm() == null ? other.getStpltRepayBankNm() == null : this.getStpltRepayBankNm().equals(other.getStpltRepayBankNm()))
        	&& (this.getStpltRepayOpenbankNo() == null ? other.getStpltRepayOpenbankNo() == null : this.getStpltRepayOpenbankNo().equals(other.getStpltRepayOpenbankNo()))
        	&& (this.getStpltRepayAcctNo() == null ? other.getStpltRepayAcctNo() == null : this.getStpltRepayAcctNo().equals(other.getStpltRepayAcctNo()))
        	&& (this.getStpltRepayAcctNm() == null ? other.getStpltRepayAcctNm() == null : this.getStpltRepayAcctNm().equals(other.getStpltRepayAcctNm()))
                                	&& (this.getRepayHisInfo() == null ? other.getRepayHisInfo() == null : this.getRepayHisInfo().equals(other.getRepayHisInfo()))
                                                        	&& (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
                        	&& (this.getUrgeRsn() == null ? other.getUrgeRsn() == null : this.getUrgeRsn().equals(other.getUrgeRsn()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getAcctNo() == null) ? 0 : getAcctNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getProdCd() == null) ? 0 : getProdCd().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getBillPeriod() == null) ? 0 : getBillPeriod().hashCode());
        result = prime * result + ((getPostBillInd() == null) ? 0 : getPostBillInd().hashCode());
        result = prime * result + ((getPostBillAddr() == null) ? 0 : getPostBillAddr().hashCode());
        result = prime * result + ((getBillMediumTyep() == null) ? 0 : getBillMediumTyep().hashCode());
        result = prime * result + ((getLockCd() == null) ? 0 : getLockCd().hashCode());
        result = prime * result + ((getBillAge() == null) ? 0 : getBillAge().hashCode());
        result = prime * result + ((getStpltRepayType() == null) ? 0 : getStpltRepayType().hashCode());
        result = prime * result + ((getStpltRepayBankNm() == null) ? 0 : getStpltRepayBankNm().hashCode());
        result = prime * result + ((getStpltRepayOpenbankNo() == null) ? 0 : getStpltRepayOpenbankNo().hashCode());
        result = prime * result + ((getStpltRepayAcctNo() == null) ? 0 : getStpltRepayAcctNo().hashCode());
        result = prime * result + ((getStpltRepayAcctNm() == null) ? 0 : getStpltRepayAcctNm().hashCode());
        result = prime * result + ((getRepayHisInfo() == null) ? 0 : getRepayHisInfo().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
        result = prime * result + ((getUrgeRsn() == null) ? 0 : getUrgeRsn().hashCode());
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
		sb.append(", acctNo=").append(acctNo);
		sb.append(", custId=").append(custId);
		sb.append(", prodCd=").append(prodCd);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", creditLmt=").append(creditLmt);
		sb.append(", tempLmt=").append(tempLmt);
		sb.append(", tempLmtSdate=").append(tempLmtSdate);
		sb.append(", tempLmtEdate=").append(tempLmtEdate);
		sb.append(", withdrawCashLmt=").append(withdrawCashLmt);
		sb.append(", authUpPercent=").append(authUpPercent);
		sb.append(", lmtInstalPercent=").append(lmtInstalPercent);
		sb.append(", bal=").append(bal);
		sb.append(", withdrawCashBal=").append(withdrawCashBal);
		sb.append(", prinBal=").append(prinBal);
		sb.append(", lmtInstalBal=").append(lmtInstalBal);
		sb.append(", allApLmt=").append(allApLmt);
		sb.append(", pointsBal=").append(pointsBal);
		sb.append(", createDate=").append(createDate);
		sb.append(", billPeriod=").append(billPeriod);
		sb.append(", postBillInd=").append(postBillInd);
		sb.append(", postBillAddr=").append(postBillAddr);
		sb.append(", billMediumTyep=").append(billMediumTyep);
		sb.append(", lockCd=").append(lockCd);
		sb.append(", billAge=").append(billAge);
		sb.append(", stpltRepayType=").append(stpltRepayType);
		sb.append(", stpltRepayBankNm=").append(stpltRepayBankNm);
		sb.append(", stpltRepayOpenbankNo=").append(stpltRepayOpenbankNo);
		sb.append(", stpltRepayAcctNo=").append(stpltRepayAcctNo);
		sb.append(", stpltRepayAcctNm=").append(stpltRepayAcctNm);
		sb.append(", lastEndDate=").append(lastEndDate);
		sb.append(", planEndDate=").append(planEndDate);
		sb.append(", minRepayLmt=").append(minRepayLmt);
		sb.append(", repayHisInfo=").append(repayHisInfo);
		sb.append(", lastRepayAmt=").append(lastRepayAmt);
		sb.append(", custLastTransDate=").append(custLastTransDate);
		sb.append(", actualRepayAmt=").append(actualRepayAmt);
		sb.append(", cancelAmt=").append(cancelAmt);
		sb.append(", cancelDate=").append(cancelDate);
		sb.append(", unbillBal=").append(unbillBal);
		sb.append(", rmk=").append(rmk);
		sb.append(", consumeToyear=").append(consumeToyear);
		sb.append(", urgeNum=").append(urgeNum);
		sb.append(", urgeRsn=").append(urgeRsn);
        sb.append("]");
        return sb.toString();
    }
}