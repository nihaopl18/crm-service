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
 * @类名称: AcrmFagLoanAcctBal
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-15 11:54:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_LOAN_ACCT_BAL")
public class AcrmFagLoanAcctBal extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 账户标识 **/
	@Column(name = "ACCT_ID", unique = false, nullable = true, length = 32)
	private String acctId;
	
	/** 账户类型 **/
	@Column(name = "ACCT_TYPE", unique = false, nullable = true, length = 20)
	private String acctType;
	
	/** 借据号码 **/
	@Column(name = "DUEBILL_NO", unique = false, nullable = true, length = 32)
	private String duebillNo;
	
	/** 客户类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 30)
	private String custType;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 产品编码 **/
	@Column(name = "PROD_CD", unique = false, nullable = true, length = 30)
	private String prodCd;
	
	/** 产品名称 **/
	@Column(name = "PROD_NAME", unique = false, nullable = true, length = 100)
	private String prodName;
	
	/** 还款方式 **/
	@Column(name = "REPAY_WAY", unique = false, nullable = true, length = 30)
	private String repayWay;
	
	/** 业务状态 **/
	@Column(name = "BIZ_STAT_CD", unique = false, nullable = true, length = 20)
	private String bizStatCd;
	
	/** 记录状态 **/
	@Column(name = "RECD_STAT_CD", unique = false, nullable = true, length = 20)
	private String recdStatCd;
	
	/** 货币代码 **/
	@Column(name = "CURR_CD", unique = false, nullable = true, length = 30)
	private String currCd;
	
	/** 借据余额 **/
	@Column(name = "LOAN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanBal;
	
	/** 贷款创利 **/
	@Column(name = "LOAN_PROFIT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanProfit;
	
	/** 上日余额 **/
	@Column(name = "LAST_D_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastDbal;
	
	/** 上月余额 **/
	@Column(name = "LAST_M_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastMbal;
	
	/** 上季余额 **/
	@Column(name = "LAST_Q_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastQbal;
	
	/** 上年末余额 **/
	@Column(name = "LAST_Y_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastYbal;
	
	/** 月积数 **/
	@Column(name = "M_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal maccum;
	
	/** 上月积数 **/
	@Column(name = "LAST_M_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastMaccum;
	
	/** 季积数 **/
	@Column(name = "Q_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal qaccum;
	
	/** 上季积数 **/
	@Column(name = "LAST_Q_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastQaccum;
	
	/** 年积数 **/
	@Column(name = "Y_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal yaccum;
	
	/** 上年末积数 **/
	@Column(name = "LAST_Y_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastYaccum;
	
	/** 月日均 **/
	@Column(name = "M_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mavg;
	
	/** 上月日均 **/
	@Column(name = "LAST_M_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastMavg;
	
	/** 季日均 **/
	@Column(name = "Q_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal qavg;
	
	/** 上季日均 **/
	@Column(name = "LAST_Q_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastQavg;
	
	/** 年日均 **/
	@Column(name = "Y_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal yavg;
	
	/** 上年末日均 **/
	@Column(name = "LAST_Y_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastYavg;
	
	/** 近1个月积数 **/
	@Column(name = "LAST_1M_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal last1mAccum;
	
	/** 近3个月积数 **/
	@Column(name = "LAST_3M_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal last3mAccum;
	
	/** 近6个月积数 **/
	@Column(name = "LAST_6M_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal last6mAccum;
	
	/** 近12个月积数 **/
	@Column(name = "LAST_12M_ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal last12mAccum;
	
	/** 近1个月日均 **/
	@Column(name = "LAST_1M_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal last1mAvg;
	
	/** 近3个月日均 **/
	@Column(name = "LAST_3M_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal last3mAvg;
	
	/** 近6个月日均 **/
	@Column(name = "LAST_6M_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal last6mAvg;
	
	/** 近12个月日均 **/
	@Column(name = "LAST_12M_AVG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal last12mAvg;
	
	
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
	 * @param duebillNo
	 */
	public void setDuebillNo(String duebillNo) {
		this.duebillNo = duebillNo == null ? null : duebillNo.trim();
	}
	
    /**
     * @return DuebillNo
     */	
	public String getDuebillNo() {
		return this.duebillNo;
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
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	
    /**
     * @return CustType
     */	
	public String getCustType() {
		return this.custType;
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
	 * @param repayWay
	 */
	public void setRepayWay(String repayWay) {
		this.repayWay = repayWay == null ? null : repayWay.trim();
	}
	
    /**
     * @return RepayWay
     */	
	public String getRepayWay() {
		return this.repayWay;
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
	 * @param loanProfit
	 */
	public void setLoanProfit(java.math.BigDecimal loanProfit) {
		this.loanProfit = loanProfit;
	}
	
    /**
     * @return LoanProfit
     */	
	public java.math.BigDecimal getLoanProfit() {
		return this.loanProfit;
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
	 * @param lastMaccum
	 */
	public void setLastMaccum(java.math.BigDecimal lastMaccum) {
		this.lastMaccum = lastMaccum;
	}
	
    /**
     * @return LastMaccum
     */	
	public java.math.BigDecimal getLastMaccum() {
		return this.lastMaccum;
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
	 * @param lastQaccum
	 */
	public void setLastQaccum(java.math.BigDecimal lastQaccum) {
		this.lastQaccum = lastQaccum;
	}
	
    /**
     * @return LastQaccum
     */	
	public java.math.BigDecimal getLastQaccum() {
		return this.lastQaccum;
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
	 * @param lastMavg
	 */
	public void setLastMavg(java.math.BigDecimal lastMavg) {
		this.lastMavg = lastMavg;
	}
	
    /**
     * @return LastMavg
     */	
	public java.math.BigDecimal getLastMavg() {
		return this.lastMavg;
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
	 * @param lastQavg
	 */
	public void setLastQavg(java.math.BigDecimal lastQavg) {
		this.lastQavg = lastQavg;
	}
	
    /**
     * @return LastQavg
     */	
	public java.math.BigDecimal getLastQavg() {
		return this.lastQavg;
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
        AcrmFagLoanAcctBal other = (AcrmFagLoanAcctBal) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getAcctId() == null ? other.getAcctId() == null : this.getAcctId().equals(other.getAcctId()))
        	&& (this.getAcctType() == null ? other.getAcctType() == null : this.getAcctType().equals(other.getAcctType()))
        	&& (this.getDuebillNo() == null ? other.getDuebillNo() == null : this.getDuebillNo().equals(other.getDuebillNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getProdCd() == null ? other.getProdCd() == null : this.getProdCd().equals(other.getProdCd()))
        	&& (this.getProdName() == null ? other.getProdName() == null : this.getProdName().equals(other.getProdName()))
        	&& (this.getRepayWay() == null ? other.getRepayWay() == null : this.getRepayWay().equals(other.getRepayWay()))
        	&& (this.getBizStatCd() == null ? other.getBizStatCd() == null : this.getBizStatCd().equals(other.getBizStatCd()))
        	&& (this.getRecdStatCd() == null ? other.getRecdStatCd() == null : this.getRecdStatCd().equals(other.getRecdStatCd()))
        	&& (this.getCurrCd() == null ? other.getCurrCd() == null : this.getCurrCd().equals(other.getCurrCd()))
                                                                                                                                                                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getAcctId() == null) ? 0 : getAcctId().hashCode());
        result = prime * result + ((getAcctType() == null) ? 0 : getAcctType().hashCode());
        result = prime * result + ((getDuebillNo() == null) ? 0 : getDuebillNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getProdCd() == null) ? 0 : getProdCd().hashCode());
        result = prime * result + ((getProdName() == null) ? 0 : getProdName().hashCode());
        result = prime * result + ((getRepayWay() == null) ? 0 : getRepayWay().hashCode());
        result = prime * result + ((getBizStatCd() == null) ? 0 : getBizStatCd().hashCode());
        result = prime * result + ((getRecdStatCd() == null) ? 0 : getRecdStatCd().hashCode());
        result = prime * result + ((getCurrCd() == null) ? 0 : getCurrCd().hashCode());
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
		sb.append(", acctId=").append(acctId);
		sb.append(", acctType=").append(acctType);
		sb.append(", duebillNo=").append(duebillNo);
		sb.append(", custId=").append(custId);
		sb.append(", custType=").append(custType);
		sb.append(", custName=").append(custName);
		sb.append(", prodCd=").append(prodCd);
		sb.append(", prodName=").append(prodName);
		sb.append(", repayWay=").append(repayWay);
		sb.append(", bizStatCd=").append(bizStatCd);
		sb.append(", recdStatCd=").append(recdStatCd);
		sb.append(", currCd=").append(currCd);
		sb.append(", loanBal=").append(loanBal);
		sb.append(", loanProfit=").append(loanProfit);
		sb.append(", lastDbal=").append(lastDbal);
		sb.append(", lastMbal=").append(lastMbal);
		sb.append(", lastQbal=").append(lastQbal);
		sb.append(", lastYbal=").append(lastYbal);
		sb.append(", maccum=").append(maccum);
		sb.append(", lastMaccum=").append(lastMaccum);
		sb.append(", qaccum=").append(qaccum);
		sb.append(", lastQaccum=").append(lastQaccum);
		sb.append(", yaccum=").append(yaccum);
		sb.append(", lastYaccum=").append(lastYaccum);
		sb.append(", mavg=").append(mavg);
		sb.append(", lastMavg=").append(lastMavg);
		sb.append(", qavg=").append(qavg);
		sb.append(", lastQavg=").append(lastQavg);
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
        sb.append("]");
        return sb.toString();
    }
}