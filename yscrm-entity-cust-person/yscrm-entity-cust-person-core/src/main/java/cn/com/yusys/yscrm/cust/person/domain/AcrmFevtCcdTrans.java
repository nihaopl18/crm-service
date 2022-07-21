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
 * @类名称: AcrmFevtCcdTrans
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-03-13 17:52:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_EVT_CCD_TRANS")
public class AcrmFevtCcdTrans extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 交易流水号
 **/
	@Id
	@Column(name = "TRAN_NO")
	@Generated(GenerationType.UUID)
	private String tranNo;
	
	/** 数据日期
 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 交易日期
 **/
	@Transient
	@Column(name = "TRAN_DATE", unique = false, nullable = true, length = 8)
	private String tranDate;
	
	/** 交易时间
 **/
	@Transient
	@Column(name = "TRAN_TIME", unique = false, nullable = true, length = 7)
	private Date tranTime;
	
	/** 账户编号
 **/
	@Column(name = "ACCT_NO", unique = false, nullable = true, length = 20)
	private String acctNo;
	
	/** 卡号
 **/
	@Column(name = "CARD_NO", unique = false, nullable = true, length = 20)
	private String cardNo;
	
	/** 交易币种代码
 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 交易金额
 **/
	@Column(name = "AMT", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal amt;
	
	/** 借贷标记
 **/
	@Column(name = "CD_FLAG", unique = false, nullable = true, length = 1)
	private String cdFlag;
	
	/** 交易码
 **/
	@Column(name = "TRAN_CD", unique = false, nullable = true, length = 10)
	private String tranCd;
	
	/** 交易参考号
 **/
	@Column(name = "TRAN_REF_NO", unique = false, nullable = true, length = 40)
	private String tranRefNo;
	
	/** 账单交易描述
 **/
	@Column(name = "BILL_DESC", unique = false, nullable = true, length = 60)
	private String billDesc;
	
	/** 授权码
 **/
	@Column(name = "AUTH_CD", unique = false, nullable = true, length = 10)
	private String authCd;
	
	/** 记账日期
 **/
	@Transient
	@Column(name = "ACCT_DATE", unique = false, nullable = true, length = 7)
	private Date acctDate;
	
	/** 记账币种金额
 **/
	@Column(name = "ACCT_AMT", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal acctAmt;
	
	/** 记账币种代码
 **/
	@Column(name = "ACCT_CCY_CD", unique = false, nullable = true, length = 3)
	private String acctCcyCd;
	
	/** 积分数值
 **/
	@Column(name = "POINTS_VALUE", unique = false, nullable = true, length = 18)
	private long pointsValue;
	
	/** 受理分行代码
 **/
	@Column(name = "ORG_NO", unique = false, nullable = true, length = 20)
	private String orgNo;
	
	/** 受卡方标识码
 **/
	@Column(name = "ASSIGNEE_CD", unique = false, nullable = true, length = 20)
	private String assigneeCd;
	
	/** 受理机构名称地址
 **/
	@Column(name = "ORG_ADDR", unique = false, nullable = true, length = 60)
	private String orgAddr;
	
	/** 商户类别代码
 **/
	@Column(name = "MERCHANT_TYPE", unique = false, nullable = true, length = 10)
	private String merchantType;
	
	/** 交易渠道
 **/
	@Column(name = "CHENL_CD", unique = false, nullable = true, length = 20)
	private String chenlCd;
	
	/** 交易接入组织
 **/
	@Column(name = "ENTER_ORG", unique = false, nullable = true, length = 20)
	private String enterOrg;
	
	/** 终端号
 **/
	@Column(name = "TERMINAL_ID", unique = false, nullable = true, length = 20)
	private String terminalId;
	
	/** 备注
 **/
	@Column(name = "RMK", unique = false, nullable = true, length = 200)
	private String rmk;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	
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
	 * @param tranDate
	 */
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}
	
    /**
     * @return TranDate
     */	
	public String getTranDate() {
		return this.tranDate;
	}
	
	/**
	 * @param tranTime
	 */
	public void setTranTime(Date tranTime) {
		this.tranTime = tranTime;
	}
	
    /**
     * @return TranTime
     */	
	public Date getTranTime() {
		return this.tranTime;
	}
	
	/**
	 * @param tranNo
	 */
	public void setTranNo(String tranNo) {
		this.tranNo = tranNo == null ? null : tranNo.trim();
	}
	
    /**
     * @return TranNo
     */	
	public String getTranNo() {
		return this.tranNo;
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
	 * @param amt
	 */
	public void setAmt(java.math.BigDecimal amt) {
		this.amt = amt;
	}
	
    /**
     * @return Amt
     */	
	public java.math.BigDecimal getAmt() {
		return this.amt;
	}
	
	/**
	 * @param cdFlag
	 */
	public void setCdFlag(String cdFlag) {
		this.cdFlag = cdFlag == null ? null : cdFlag.trim();
	}
	
    /**
     * @return CdFlag
     */	
	public String getCdFlag() {
		return this.cdFlag;
	}
	
	/**
	 * @param tranCd
	 */
	public void setTranCd(String tranCd) {
		this.tranCd = tranCd == null ? null : tranCd.trim();
	}
	
    /**
     * @return TranCd
     */	
	public String getTranCd() {
		return this.tranCd;
	}
	
	/**
	 * @param tranRefNo
	 */
	public void setTranRefNo(String tranRefNo) {
		this.tranRefNo = tranRefNo == null ? null : tranRefNo.trim();
	}
	
    /**
     * @return TranRefNo
     */	
	public String getTranRefNo() {
		return this.tranRefNo;
	}
	
	/**
	 * @param billDesc
	 */
	public void setBillDesc(String billDesc) {
		this.billDesc = billDesc == null ? null : billDesc.trim();
	}
	
    /**
     * @return BillDesc
     */	
	public String getBillDesc() {
		return this.billDesc;
	}
	
	/**
	 * @param authCd
	 */
	public void setAuthCd(String authCd) {
		this.authCd = authCd == null ? null : authCd.trim();
	}
	
    /**
     * @return AuthCd
     */	
	public String getAuthCd() {
		return this.authCd;
	}
	
	/**
	 * @param acctDate
	 */
	public void setAcctDate(Date acctDate) {
		this.acctDate = acctDate;
	}
	
    /**
     * @return AcctDate
     */	
	public Date getAcctDate() {
		return this.acctDate;
	}
	
	/**
	 * @param acctAmt
	 */
	public void setAcctAmt(java.math.BigDecimal acctAmt) {
		this.acctAmt = acctAmt;
	}
	
    /**
     * @return AcctAmt
     */	
	public java.math.BigDecimal getAcctAmt() {
		return this.acctAmt;
	}
	
	/**
	 * @param acctCcyCd
	 */
	public void setAcctCcyCd(String acctCcyCd) {
		this.acctCcyCd = acctCcyCd == null ? null : acctCcyCd.trim();
	}
	
    /**
     * @return AcctCcyCd
     */	
	public String getAcctCcyCd() {
		return this.acctCcyCd;
	}
	
	/**
	 * @param pointsValue
	 */
	public void setPointsValue(long pointsValue) {
		this.pointsValue = pointsValue;
	}
	
    /**
     * @return PointsValue
     */	
	public long getPointsValue() {
		return this.pointsValue;
	}
	
	/**
	 * @param orgNo
	 */
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo == null ? null : orgNo.trim();
	}
	
    /**
     * @return OrgNo
     */	
	public String getOrgNo() {
		return this.orgNo;
	}
	
	/**
	 * @param assigneeCd
	 */
	public void setAssigneeCd(String assigneeCd) {
		this.assigneeCd = assigneeCd == null ? null : assigneeCd.trim();
	}
	
    /**
     * @return AssigneeCd
     */	
	public String getAssigneeCd() {
		return this.assigneeCd;
	}
	
	/**
	 * @param orgAddr
	 */
	public void setOrgAddr(String orgAddr) {
		this.orgAddr = orgAddr == null ? null : orgAddr.trim();
	}
	
    /**
     * @return OrgAddr
     */	
	public String getOrgAddr() {
		return this.orgAddr;
	}
	
	/**
	 * @param merchantType
	 */
	public void setMerchantType(String merchantType) {
		this.merchantType = merchantType == null ? null : merchantType.trim();
	}
	
    /**
     * @return MerchantType
     */	
	public String getMerchantType() {
		return this.merchantType;
	}
	
	/**
	 * @param chenlCd
	 */
	public void setChenlCd(String chenlCd) {
		this.chenlCd = chenlCd == null ? null : chenlCd.trim();
	}
	
    /**
     * @return ChenlCd
     */	
	public String getChenlCd() {
		return this.chenlCd;
	}
	
	/**
	 * @param enterOrg
	 */
	public void setEnterOrg(String enterOrg) {
		this.enterOrg = enterOrg == null ? null : enterOrg.trim();
	}
	
    /**
     * @return EnterOrg
     */	
	public String getEnterOrg() {
		return this.enterOrg;
	}
	
	/**
	 * @param terminalId
	 */
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId == null ? null : terminalId.trim();
	}
	
    /**
     * @return TerminalId
     */	
	public String getTerminalId() {
		return this.terminalId;
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
        AcrmFevtCcdTrans other = (AcrmFevtCcdTrans) that;
                        		return (this.getTranNo() == null ? other.getTranNo() == null : this.getTranNo().equals(other.getTranNo()))
        	&& (this.getAcctNo() == null ? other.getAcctNo() == null : this.getAcctNo().equals(other.getAcctNo()))
        	&& (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
                	&& (this.getCdFlag() == null ? other.getCdFlag() == null : this.getCdFlag().equals(other.getCdFlag()))
        	&& (this.getTranCd() == null ? other.getTranCd() == null : this.getTranCd().equals(other.getTranCd()))
        	&& (this.getTranRefNo() == null ? other.getTranRefNo() == null : this.getTranRefNo().equals(other.getTranRefNo()))
        	&& (this.getBillDesc() == null ? other.getBillDesc() == null : this.getBillDesc().equals(other.getBillDesc()))
        	&& (this.getAuthCd() == null ? other.getAuthCd() == null : this.getAuthCd().equals(other.getAuthCd()))
                        	&& (this.getAcctCcyCd() == null ? other.getAcctCcyCd() == null : this.getAcctCcyCd().equals(other.getAcctCcyCd()))
                	&& (this.getOrgNo() == null ? other.getOrgNo() == null : this.getOrgNo().equals(other.getOrgNo()))
        	&& (this.getAssigneeCd() == null ? other.getAssigneeCd() == null : this.getAssigneeCd().equals(other.getAssigneeCd()))
        	&& (this.getOrgAddr() == null ? other.getOrgAddr() == null : this.getOrgAddr().equals(other.getOrgAddr()))
        	&& (this.getMerchantType() == null ? other.getMerchantType() == null : this.getMerchantType().equals(other.getMerchantType()))
        	&& (this.getChenlCd() == null ? other.getChenlCd() == null : this.getChenlCd().equals(other.getChenlCd()))
        	&& (this.getEnterOrg() == null ? other.getEnterOrg() == null : this.getEnterOrg().equals(other.getEnterOrg()))
        	&& (this.getTerminalId() == null ? other.getTerminalId() == null : this.getTerminalId().equals(other.getTerminalId()))
        	&& (this.getRmk() == null ? other.getRmk() == null : this.getRmk().equals(other.getRmk()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTranNo() == null) ? 0 : getTranNo().hashCode());
        result = prime * result + ((getAcctNo() == null) ? 0 : getAcctNo().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getCdFlag() == null) ? 0 : getCdFlag().hashCode());
        result = prime * result + ((getTranCd() == null) ? 0 : getTranCd().hashCode());
        result = prime * result + ((getTranRefNo() == null) ? 0 : getTranRefNo().hashCode());
        result = prime * result + ((getBillDesc() == null) ? 0 : getBillDesc().hashCode());
        result = prime * result + ((getAuthCd() == null) ? 0 : getAuthCd().hashCode());
        result = prime * result + ((getAcctCcyCd() == null) ? 0 : getAcctCcyCd().hashCode());
        result = prime * result + ((getOrgNo() == null) ? 0 : getOrgNo().hashCode());
        result = prime * result + ((getAssigneeCd() == null) ? 0 : getAssigneeCd().hashCode());
        result = prime * result + ((getOrgAddr() == null) ? 0 : getOrgAddr().hashCode());
        result = prime * result + ((getMerchantType() == null) ? 0 : getMerchantType().hashCode());
        result = prime * result + ((getChenlCd() == null) ? 0 : getChenlCd().hashCode());
        result = prime * result + ((getEnterOrg() == null) ? 0 : getEnterOrg().hashCode());
        result = prime * result + ((getTerminalId() == null) ? 0 : getTerminalId().hashCode());
        result = prime * result + ((getRmk() == null) ? 0 : getRmk().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", tranDate=").append(tranDate);
		sb.append(", tranTime=").append(tranTime);
		sb.append(", tranNo=").append(tranNo);
		sb.append(", acctNo=").append(acctNo);
		sb.append(", cardNo=").append(cardNo);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", amt=").append(amt);
		sb.append(", cdFlag=").append(cdFlag);
		sb.append(", tranCd=").append(tranCd);
		sb.append(", tranRefNo=").append(tranRefNo);
		sb.append(", billDesc=").append(billDesc);
		sb.append(", authCd=").append(authCd);
		sb.append(", acctDate=").append(acctDate);
		sb.append(", acctAmt=").append(acctAmt);
		sb.append(", acctCcyCd=").append(acctCcyCd);
		sb.append(", pointsValue=").append(pointsValue);
		sb.append(", orgNo=").append(orgNo);
		sb.append(", assigneeCd=").append(assigneeCd);
		sb.append(", orgAddr=").append(orgAddr);
		sb.append(", merchantType=").append(merchantType);
		sb.append(", chenlCd=").append(chenlCd);
		sb.append(", enterOrg=").append(enterOrg);
		sb.append(", terminalId=").append(terminalId);
		sb.append(", rmk=").append(rmk);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}