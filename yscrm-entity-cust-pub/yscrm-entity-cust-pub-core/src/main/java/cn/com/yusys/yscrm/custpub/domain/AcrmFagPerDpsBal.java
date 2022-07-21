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
 * @类名称: AcrmFagPerDpsBal
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-15 11:52:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_PER_DPS_BAL")
public class AcrmFagPerDpsBal extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = false, length = 10)
	private String corpOrgCode;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = false, length = 8)
	private String dataDate;
	
	/** 子帐号标识 **/
	@Column(name = "SUBACCT_NO", unique = false, nullable = false, length = 32)
	private String subacctNo;
	
	/** 账号 **/
	@Column(name = "ACCT_NO", unique = false, nullable = false, length = 32)
	private String acctNo;
	
	/** 账户名称 **/
	@Column(name = "ACCT_NAME", unique = false, nullable = false, length = 200)
	private String acctName;
	
	/** 账户类型 **/
	@Column(name = "ACCT_TYPE", unique = false, nullable = false, length = 30)
	private String acctType;
	
	/** 产品编码 **/
	@Column(name = "PROD_CD", unique = false, nullable = false, length = 30)
	private String prodCd;
	
	/** 定活标志 **/
	@Column(name = "TERM_FLG", unique = false, nullable = false, length = 20)
	private String termFlg;
	
	/** 产品名称 **/
	@Column(name = "PROD_NAME", unique = false, nullable = false, length = 200)
	private String prodName;
	
	/** 货币代码 **/
	@Column(name = "CURR_CD", unique = false, nullable = false, length = 30)
	private String currCd;
	
	/** 钞汇标志 **/
	@Column(name = "FCY_CASH_FLG", unique = false, nullable = false, length = 20)
	private String fcyCashFlg;
	
	/** 开户机构 **/
	@Column(name = "OPEN_BRCH_NO", unique = false, nullable = false, length = 30)
	private String openBrchNo;
	
	/** 所属机构 **/
	@Column(name = "OWN_BRCH_NO", unique = false, nullable = false, length = 30)
	private String ownBrchNo;
	
	/** 科目编号 **/
	@Column(name = "SUBJECT_CD", unique = false, nullable = false, length = 20)
	private String subjectCd;
	
	/** 账户状态 **/
	@Column(name = "ACCT_STATUS", unique = false, nullable = false, length = 1)
	private String acctStatus;
	
	/** 帐户余额 **/
	@Column(name = "ACCT_BAL", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal acctBal;
	
	/** 上日余额 **/
	@Column(name = "LAST_D_BAL", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal lastDbal;
	
	/** 上月余额 **/
	@Column(name = "LAST_M_BAL", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal lastMbal;
	
	/** 上季余额 **/
	@Column(name = "LAST_Q_BAL", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal lastQbal;
	
	/** 上年末余额 **/
	@Column(name = "LAST_Y_BAL", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal lastYbal;
	
	/** 月积数 **/
	@Column(name = "M_ACCUM", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal maccum;
	
	/** 季积数 **/
	@Column(name = "Q_ACCUM", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal qaccum;
	
	/** 年积数 **/
	@Column(name = "Y_ACCUM", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal yaccum;
	
	/** 上年末年积数 **/
	@Column(name = "LAST_Y_ACCUM", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal lastYaccum;
	
	/** 月日均 **/
	@Column(name = "M_AVG", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal mavg;
	
	/** 季日均 **/
	@Column(name = "Q_AVG", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal qavg;
	
	/** 年日均 **/
	@Column(name = "Y_AVG", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal yavg;
	
	/** 上年末日均 **/
	@Column(name = "LAST_Y_AVG", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal lastYavg;
	
	/** 近1个月积数 **/
	@Column(name = "LAST_1M_ACCUM", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal last1mAccum;
	
	/** 近3个月积数 **/
	@Column(name = "LAST_3M_ACCUM", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal last3mAccum;
	
	/** 近6个月积数 **/
	@Column(name = "LAST_6M_ACCUM", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal last6mAccum;
	
	/** 近12个月积数 **/
	@Column(name = "LAST_12M_ACCUM", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal last12mAccum;
	
	/** 近1个月日均 **/
	@Column(name = "LAST_1M_AVG", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal last1mAvg;
	
	/** 近3个月日均 **/
	@Column(name = "LAST_3M_AVG", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal last3mAvg;
	
	/** 近6个月日均 **/
	@Column(name = "LAST_6M_AVG", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal last6mAvg;
	
	/** 近12个月日均 **/
	@Column(name = "LAST_12M_AVG", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal last12mAvg;
	
	/** 通知存款标志 **/
	@Column(name = "TERM_TYPE", unique = false, nullable = false, length = 1)
	private String termType;
	
	/** 转存标志 **/
	@Column(name = "ROLL_FLAG", unique = false, nullable = false, length = 1)
	private String rollFlag;
	
	/** 利多宝标志 **/
	@Column(name = "LDB_FLAG", unique = false, nullable = false, length = 1)
	private String ldbFlag;
	
	/** 利享存标志 **/
	@Column(name = "LXC_FLAG", unique = false, nullable = false, length = 1)
	private String lxcFlag;
	
	
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
		this.dataDate = dataDate == null ? null : dataDate.trim();
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param subacctNo
	 */
	public void setSubacctNo(String subacctNo) {
		this.subacctNo = subacctNo == null ? null : subacctNo.trim();
	}
	
    /**
     * @return SubacctNo
     */	
	public String getSubacctNo() {
		return this.subacctNo;
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
	 * @param acctName
	 */
	public void setAcctName(String acctName) {
		this.acctName = acctName == null ? null : acctName.trim();
	}
	
    /**
     * @return AcctName
     */	
	public String getAcctName() {
		return this.acctName;
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
	 * @param termFlg
	 */
	public void setTermFlg(String termFlg) {
		this.termFlg = termFlg == null ? null : termFlg.trim();
	}
	
    /**
     * @return TermFlg
     */	
	public String getTermFlg() {
		return this.termFlg;
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
	 * @param fcyCashFlg
	 */
	public void setFcyCashFlg(String fcyCashFlg) {
		this.fcyCashFlg = fcyCashFlg == null ? null : fcyCashFlg.trim();
	}
	
    /**
     * @return FcyCashFlg
     */	
	public String getFcyCashFlg() {
		return this.fcyCashFlg;
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
	 * @param ownBrchNo
	 */
	public void setOwnBrchNo(String ownBrchNo) {
		this.ownBrchNo = ownBrchNo == null ? null : ownBrchNo.trim();
	}
	
    /**
     * @return OwnBrchNo
     */	
	public String getOwnBrchNo() {
		return this.ownBrchNo;
	}
	
	/**
	 * @param subjectCd
	 */
	public void setSubjectCd(String subjectCd) {
		this.subjectCd = subjectCd == null ? null : subjectCd.trim();
	}
	
    /**
     * @return SubjectCd
     */	
	public String getSubjectCd() {
		return this.subjectCd;
	}
	
	/**
	 * @param acctStatus
	 */
	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus == null ? null : acctStatus.trim();
	}
	
    /**
     * @return AcctStatus
     */	
	public String getAcctStatus() {
		return this.acctStatus;
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
	 * @param lastDbal
	 */
	public void setLastDbal(java.math.BigDecimal lastDbal) {
		this.lastDbal = lastDbal;
	}
	
    /**
     * @return LastDbal
     */	
	public java.math.BigDecimal getLastDbal() {
		return this.lastDbal;
	}
	
	/**
	 * @param lastMbal
	 */
	public void setLastMbal(java.math.BigDecimal lastMbal) {
		this.lastMbal = lastMbal;
	}
	
    /**
     * @return LastMbal
     */	
	public java.math.BigDecimal getLastMbal() {
		return this.lastMbal;
	}
	
	/**
	 * @param lastQbal
	 */
	public void setLastQbal(java.math.BigDecimal lastQbal) {
		this.lastQbal = lastQbal;
	}
	
    /**
     * @return LastQbal
     */	
	public java.math.BigDecimal getLastQbal() {
		return this.lastQbal;
	}
	
	/**
	 * @param lastYbal
	 */
	public void setLastYbal(java.math.BigDecimal lastYbal) {
		this.lastYbal = lastYbal;
	}
	
    /**
     * @return LastYbal
     */	
	public java.math.BigDecimal getLastYbal() {
		return this.lastYbal;
	}
	
	/**
	 * @param maccum
	 */
	public void setMaccum(java.math.BigDecimal maccum) {
		this.maccum = maccum;
	}
	
    /**
     * @return Maccum
     */	
	public java.math.BigDecimal getMaccum() {
		return this.maccum;
	}
	
	/**
	 * @param qaccum
	 */
	public void setQaccum(java.math.BigDecimal qaccum) {
		this.qaccum = qaccum;
	}
	
    /**
     * @return Qaccum
     */	
	public java.math.BigDecimal getQaccum() {
		return this.qaccum;
	}
	
	/**
	 * @param yaccum
	 */
	public void setYaccum(java.math.BigDecimal yaccum) {
		this.yaccum = yaccum;
	}
	
    /**
     * @return Yaccum
     */	
	public java.math.BigDecimal getYaccum() {
		return this.yaccum;
	}
	
	/**
	 * @param lastYaccum
	 */
	public void setLastYaccum(java.math.BigDecimal lastYaccum) {
		this.lastYaccum = lastYaccum;
	}
	
    /**
     * @return LastYaccum
     */	
	public java.math.BigDecimal getLastYaccum() {
		return this.lastYaccum;
	}
	
	/**
	 * @param mavg
	 */
	public void setMavg(java.math.BigDecimal mavg) {
		this.mavg = mavg;
	}
	
    /**
     * @return Mavg
     */	
	public java.math.BigDecimal getMavg() {
		return this.mavg;
	}
	
	/**
	 * @param qavg
	 */
	public void setQavg(java.math.BigDecimal qavg) {
		this.qavg = qavg;
	}
	
    /**
     * @return Qavg
     */	
	public java.math.BigDecimal getQavg() {
		return this.qavg;
	}
	
	/**
	 * @param yavg
	 */
	public void setYavg(java.math.BigDecimal yavg) {
		this.yavg = yavg;
	}
	
    /**
     * @return Yavg
     */	
	public java.math.BigDecimal getYavg() {
		return this.yavg;
	}
	
	/**
	 * @param lastYavg
	 */
	public void setLastYavg(java.math.BigDecimal lastYavg) {
		this.lastYavg = lastYavg;
	}
	
    /**
     * @return LastYavg
     */	
	public java.math.BigDecimal getLastYavg() {
		return this.lastYavg;
	}
	
	/**
	 * @param last1mAccum
	 */
	public void setLast1mAccum(java.math.BigDecimal last1mAccum) {
		this.last1mAccum = last1mAccum;
	}
	
    /**
     * @return Last1mAccum
     */	
	public java.math.BigDecimal getLast1mAccum() {
		return this.last1mAccum;
	}
	
	/**
	 * @param last3mAccum
	 */
	public void setLast3mAccum(java.math.BigDecimal last3mAccum) {
		this.last3mAccum = last3mAccum;
	}
	
    /**
     * @return Last3mAccum
     */	
	public java.math.BigDecimal getLast3mAccum() {
		return this.last3mAccum;
	}
	
	/**
	 * @param last6mAccum
	 */
	public void setLast6mAccum(java.math.BigDecimal last6mAccum) {
		this.last6mAccum = last6mAccum;
	}
	
    /**
     * @return Last6mAccum
     */	
	public java.math.BigDecimal getLast6mAccum() {
		return this.last6mAccum;
	}
	
	/**
	 * @param last12mAccum
	 */
	public void setLast12mAccum(java.math.BigDecimal last12mAccum) {
		this.last12mAccum = last12mAccum;
	}
	
    /**
     * @return Last12mAccum
     */	
	public java.math.BigDecimal getLast12mAccum() {
		return this.last12mAccum;
	}
	
	/**
	 * @param last1mAvg
	 */
	public void setLast1mAvg(java.math.BigDecimal last1mAvg) {
		this.last1mAvg = last1mAvg;
	}
	
    /**
     * @return Last1mAvg
     */	
	public java.math.BigDecimal getLast1mAvg() {
		return this.last1mAvg;
	}
	
	/**
	 * @param last3mAvg
	 */
	public void setLast3mAvg(java.math.BigDecimal last3mAvg) {
		this.last3mAvg = last3mAvg;
	}
	
    /**
     * @return Last3mAvg
     */	
	public java.math.BigDecimal getLast3mAvg() {
		return this.last3mAvg;
	}
	
	/**
	 * @param last6mAvg
	 */
	public void setLast6mAvg(java.math.BigDecimal last6mAvg) {
		this.last6mAvg = last6mAvg;
	}
	
    /**
     * @return Last6mAvg
     */	
	public java.math.BigDecimal getLast6mAvg() {
		return this.last6mAvg;
	}
	
	/**
	 * @param last12mAvg
	 */
	public void setLast12mAvg(java.math.BigDecimal last12mAvg) {
		this.last12mAvg = last12mAvg;
	}
	
    /**
     * @return Last12mAvg
     */	
	public java.math.BigDecimal getLast12mAvg() {
		return this.last12mAvg;
	}
	
	/**
	 * @param termType
	 */
	public void setTermType(String termType) {
		this.termType = termType == null ? null : termType.trim();
	}
	
    /**
     * @return TermType
     */	
	public String getTermType() {
		return this.termType;
	}
	
	/**
	 * @param rollFlag
	 */
	public void setRollFlag(String rollFlag) {
		this.rollFlag = rollFlag == null ? null : rollFlag.trim();
	}
	
    /**
     * @return RollFlag
     */	
	public String getRollFlag() {
		return this.rollFlag;
	}
	
	/**
	 * @param ldbFlag
	 */
	public void setLdbFlag(String ldbFlag) {
		this.ldbFlag = ldbFlag == null ? null : ldbFlag.trim();
	}
	
    /**
     * @return LdbFlag
     */	
	public String getLdbFlag() {
		return this.ldbFlag;
	}
	
	/**
	 * @param lxcFlag
	 */
	public void setLxcFlag(String lxcFlag) {
		this.lxcFlag = lxcFlag == null ? null : lxcFlag.trim();
	}
	
    /**
     * @return LxcFlag
     */	
	public String getLxcFlag() {
		return this.lxcFlag;
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
        AcrmFagPerDpsBal other = (AcrmFagPerDpsBal) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getSubacctNo() == null ? other.getSubacctNo() == null : this.getSubacctNo().equals(other.getSubacctNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getAcctNo() == null ? other.getAcctNo() == null : this.getAcctNo().equals(other.getAcctNo()))
        	&& (this.getAcctName() == null ? other.getAcctName() == null : this.getAcctName().equals(other.getAcctName()))
        	&& (this.getAcctType() == null ? other.getAcctType() == null : this.getAcctType().equals(other.getAcctType()))
        	&& (this.getProdCd() == null ? other.getProdCd() == null : this.getProdCd().equals(other.getProdCd()))
        	&& (this.getTermFlg() == null ? other.getTermFlg() == null : this.getTermFlg().equals(other.getTermFlg()))
        	&& (this.getProdName() == null ? other.getProdName() == null : this.getProdName().equals(other.getProdName()))
        	&& (this.getCurrCd() == null ? other.getCurrCd() == null : this.getCurrCd().equals(other.getCurrCd()))
        	&& (this.getFcyCashFlg() == null ? other.getFcyCashFlg() == null : this.getFcyCashFlg().equals(other.getFcyCashFlg()))
        	&& (this.getOpenBrchNo() == null ? other.getOpenBrchNo() == null : this.getOpenBrchNo().equals(other.getOpenBrchNo()))
        	&& (this.getOwnBrchNo() == null ? other.getOwnBrchNo() == null : this.getOwnBrchNo().equals(other.getOwnBrchNo()))
        	&& (this.getSubjectCd() == null ? other.getSubjectCd() == null : this.getSubjectCd().equals(other.getSubjectCd()))
        	&& (this.getAcctStatus() == null ? other.getAcctStatus() == null : this.getAcctStatus().equals(other.getAcctStatus()))
                                                                                                                                                                                	&& (this.getTermType() == null ? other.getTermType() == null : this.getTermType().equals(other.getTermType()))
        	&& (this.getRollFlag() == null ? other.getRollFlag() == null : this.getRollFlag().equals(other.getRollFlag()))
        	&& (this.getLdbFlag() == null ? other.getLdbFlag() == null : this.getLdbFlag().equals(other.getLdbFlag()))
        	&& (this.getLxcFlag() == null ? other.getLxcFlag() == null : this.getLxcFlag().equals(other.getLxcFlag()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getSubacctNo() == null) ? 0 : getSubacctNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getAcctNo() == null) ? 0 : getAcctNo().hashCode());
        result = prime * result + ((getAcctName() == null) ? 0 : getAcctName().hashCode());
        result = prime * result + ((getAcctType() == null) ? 0 : getAcctType().hashCode());
        result = prime * result + ((getProdCd() == null) ? 0 : getProdCd().hashCode());
        result = prime * result + ((getTermFlg() == null) ? 0 : getTermFlg().hashCode());
        result = prime * result + ((getProdName() == null) ? 0 : getProdName().hashCode());
        result = prime * result + ((getCurrCd() == null) ? 0 : getCurrCd().hashCode());
        result = prime * result + ((getFcyCashFlg() == null) ? 0 : getFcyCashFlg().hashCode());
        result = prime * result + ((getOpenBrchNo() == null) ? 0 : getOpenBrchNo().hashCode());
        result = prime * result + ((getOwnBrchNo() == null) ? 0 : getOwnBrchNo().hashCode());
        result = prime * result + ((getSubjectCd() == null) ? 0 : getSubjectCd().hashCode());
        result = prime * result + ((getAcctStatus() == null) ? 0 : getAcctStatus().hashCode());
        result = prime * result + ((getTermType() == null) ? 0 : getTermType().hashCode());
        result = prime * result + ((getRollFlag() == null) ? 0 : getRollFlag().hashCode());
        result = prime * result + ((getLdbFlag() == null) ? 0 : getLdbFlag().hashCode());
        result = prime * result + ((getLxcFlag() == null) ? 0 : getLxcFlag().hashCode());
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
		sb.append(", subacctNo=").append(subacctNo);
		sb.append(", custId=").append(custId);
		sb.append(", acctNo=").append(acctNo);
		sb.append(", acctName=").append(acctName);
		sb.append(", acctType=").append(acctType);
		sb.append(", prodCd=").append(prodCd);
		sb.append(", termFlg=").append(termFlg);
		sb.append(", prodName=").append(prodName);
		sb.append(", currCd=").append(currCd);
		sb.append(", fcyCashFlg=").append(fcyCashFlg);
		sb.append(", openBrchNo=").append(openBrchNo);
		sb.append(", ownBrchNo=").append(ownBrchNo);
		sb.append(", subjectCd=").append(subjectCd);
		sb.append(", acctStatus=").append(acctStatus);
		sb.append(", acctBal=").append(acctBal);
		sb.append(", lastDbal=").append(lastDbal);
		sb.append(", lastMbal=").append(lastMbal);
		sb.append(", lastQbal=").append(lastQbal);
		sb.append(", lastYbal=").append(lastYbal);
		sb.append(", maccum=").append(maccum);
		sb.append(", qaccum=").append(qaccum);
		sb.append(", yaccum=").append(yaccum);
		sb.append(", lastYaccum=").append(lastYaccum);
		sb.append(", mavg=").append(mavg);
		sb.append(", qavg=").append(qavg);
		sb.append(", yavg=").append(yavg);
		sb.append(", lastYavg=").append(lastYavg);
		sb.append(", last1mAccum=").append(last1mAccum);
		sb.append(", last3mAccum=").append(last3mAccum);
		sb.append(", last6mAccum=").append(last6mAccum);
		sb.append(", last12mAccum=").append(last12mAccum);
		sb.append(", last1mAvg=").append(last1mAvg);
		sb.append(", last3mAvg=").append(last3mAvg);
		sb.append(", last6mAvg=").append(last6mAvg);
		sb.append(", last12mAvg=").append(last12mAvg);
		sb.append(", termType=").append(termType);
		sb.append(", rollFlag=").append(rollFlag);
		sb.append(", ldbFlag=").append(ldbFlag);
		sb.append(", lxcFlag=").append(lxcFlag);
        sb.append("]");
        return sb.toString();
    }
}