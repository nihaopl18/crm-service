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
 * @类名称: AcrmFevtPreSaveList
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-03-13 17:52:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_EVT_PER_SAVE_LIST")
public class AcrmFevtPerSaveList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 事件编号
 **/
	@Id
	@Column(name = "EVENT_NO")
	@Generated(GenerationType.UUID)
	private String eventNo;
	
	/** 交易日期
 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 子账户编号
 **/
	@Column(name = "SUBACCT_NO", unique = false, nullable = true, length = 40)
	private String subacctNo;
	
	/** 账户编号
 **/
	@Column(name = "ACCT_NO", unique = false, nullable = true, length = 40)
	private String acctNo;
	
	/** 卡片编号
 **/
	@Column(name = "CARD_NO", unique = false, nullable = true, length = 40)
	private String cardNo;
	
	/** 销账编号
 **/
	@Column(name = "CLS_NO", unique = false, nullable = true, length = 16)
	private String clsNo;
	
	/** 币种代码
 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 交易金额
 **/
	@Column(name = "TRAN_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal tranAmt;
	
	/** 余额
 **/
	@Column(name = "BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal bal;
	
	/** 记账日期
 **/
	@Transient
	@Column(name = "TRANS_DT", unique = false, nullable = true, length = 7)
	private Date transDt;
	
	/** 生效日期
 **/
	@Transient
	@Column(name = "EFT_DT", unique = false, nullable = true, length = 7)
	private Date eftDt;
	
	/** 明细记录类型代码
 **/
	@Column(name = "RCDTYPE_CD", unique = false, nullable = true, length = 1)
	private String rcdtypeCd;
	
	/** 借贷标志
 **/
	@Column(name = "CD_IND", unique = false, nullable = true, length = 1)
	private String cdInd;
	
	/** 现转标志
 **/
	@Column(name = "CT_IND", unique = false, nullable = true, length = 1)
	private String ctInd;
	
	/** 利息金额
 **/
	@Column(name = "INT_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal intAmt;
	
	/** 利率
 **/
	@Column(name = "INT_RATE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal intRate;
	
	/** 凭证种类代码
 **/
	@Column(name = "VOU_KIND_CD", unique = false, nullable = true, length = 3)
	private String vouKindCd;
	
	/** 凭证编号
 **/
	@Column(name = "VOU_NO", unique = false, nullable = true, length = 20)
	private String vouNo;
	
	/** 对方账户编号
 **/
	@Column(name = "TOACCT_NO", unique = false, nullable = true, length = 40)
	private String toacctNo;
	
	/** 对方账户名称
 **/
	@Column(name = "FTF_ACC_NAME", unique = false, nullable = true, length = 70)
	private String ftfAccName;
	
	/** 对方销账编号
 **/
	@Column(name = "OPPCLS_NO", unique = false, nullable = true, length = 40)
	private String oppclsNo;
	
	/** 原交易流水编号
 **/
	@Column(name = "PTXN_SEQ_NO", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal ptxnSeqNo;
	
	/** 子交易流水编号
 **/
	@Column(name = "CTXN_SEQ_NO", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal ctxnSeqNo;
	
	/** 原交易代码
 **/
	@Column(name = "PTXN_CODE_NO", unique = false, nullable = true, length = 6)
	private String ptxnCodeNo;
	
	/** 子交易代码
 **/
	@Column(name = "CTXN_CODE_CD", unique = false, nullable = true, length = 6)
	private String ctxnCodeCd;
	
	/** 交易机构编号
 **/
	@Column(name = "ORG_NO", unique = false, nullable = true, length = 45)
	private String orgNo;
	
	/** 交易柜员编号
 **/
	@Column(name = "TLR_NO", unique = false, nullable = true, length = 20)
	private String tlrNo;
	
	/** 交易复核柜员编号
 **/
	@Column(name = "REVTLR_NO", unique = false, nullable = true, length = 20)
	private String revtlrNo;
	
	/** 交易授权柜员编号
 **/
	@Column(name = "AUTHTLR_NO", unique = false, nullable = true, length = 20)
	private String authtlrNo;
	
	/** 交易渠道
 **/
	@Column(name = "CHANNEL", unique = false, nullable = true, length = 2)
	private String channel;
	
	/** 渠道代码
 **/
	@Column(name = "CHANNEL_CD", unique = false, nullable = true, length = 8)
	private String channelCd;
	
	/** 商户名称
 **/
	@Column(name = "AGENT_NAME", unique = false, nullable = true, length = 70)
	private String agentName;
	
	/** 被冲销标志
 **/
	@Column(name = "REF_IND", unique = false, nullable = true, length = 1)
	private String refInd;
	
	/** 被冲销流水号
 **/
	@Column(name = "REF_SEQ_NO", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal refSeqNo;
	
	/** 摘要码
 **/
	@Column(name = "BRIEFCODE_NO", unique = false, nullable = true, length = 4)
	private String briefcodeNo;
	
	/** 交易摘要
 **/
	@Column(name = "TRAN_BRIEF", unique = false, nullable = true, length = 40)
	private String tranBrief;
	
	/** 计息天数
 **/
	@Column(name = "INT_DAY", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal intDay;
	
	/** 计息积数1
 **/
	@Column(name = "INT_ACCUM1", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal intAccum1;
	
	/** 计息积数2
 **/
	@Column(name = "INT_ACCUM2", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal intAccum2;
	
	/** 页次
 **/
	@Column(name = "PAGE_NO", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal pageNo;
	
	/** 笔次
 **/
	@Column(name = "ORD_SEQ", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal ordSeq;
	
	/** 对账单打印标志
 **/
	@Column(name = "PRT_IND", unique = false, nullable = true, length = 8)
	private String prtInd;
	
	/** 交易时间
 **/
	@Transient
	@Column(name = "TRANS_TM", unique = false, nullable = true, length = 7)
	private Date transTm;
	
	/** CORP_ORG_CODE **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	
	/**
	 * @param eventNo
	 */
	public void setEventNo(String eventNo) {
		this.eventNo = eventNo == null ? null : eventNo.trim();
	}
	
    /**
     * @return EventNo
     */	
	public String getEventNo() {
		return this.eventNo;
	}
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
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
	 * @param clsNo
	 */
	public void setClsNo(String clsNo) {
		this.clsNo = clsNo == null ? null : clsNo.trim();
	}
	
    /**
     * @return ClsNo
     */	
	public String getClsNo() {
		return this.clsNo;
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
	 * @param tranAmt
	 */
	public void setTranAmt(java.math.BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}
	
    /**
     * @return TranAmt
     */	
	public java.math.BigDecimal getTranAmt() {
		return this.tranAmt;
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
	 * @param transDt
	 */
	public void setTransDt(Date transDt) {
		this.transDt = transDt;
	}
	
    /**
     * @return TransDt
     */	
	public Date getTransDt() {
		return this.transDt;
	}
	
	/**
	 * @param eftDt
	 */
	public void setEftDt(Date eftDt) {
		this.eftDt = eftDt;
	}
	
    /**
     * @return EftDt
     */	
	public Date getEftDt() {
		return this.eftDt;
	}
	
	/**
	 * @param rcdtypeCd
	 */
	public void setRcdtypeCd(String rcdtypeCd) {
		this.rcdtypeCd = rcdtypeCd == null ? null : rcdtypeCd.trim();
	}
	
    /**
     * @return RcdtypeCd
     */	
	public String getRcdtypeCd() {
		return this.rcdtypeCd;
	}
	
	/**
	 * @param cdInd
	 */
	public void setCdInd(String cdInd) {
		this.cdInd = cdInd == null ? null : cdInd.trim();
	}
	
    /**
     * @return CdInd
     */	
	public String getCdInd() {
		return this.cdInd;
	}
	
	/**
	 * @param ctInd
	 */
	public void setCtInd(String ctInd) {
		this.ctInd = ctInd == null ? null : ctInd.trim();
	}
	
    /**
     * @return CtInd
     */	
	public String getCtInd() {
		return this.ctInd;
	}
	
	/**
	 * @param intAmt
	 */
	public void setIntAmt(java.math.BigDecimal intAmt) {
		this.intAmt = intAmt;
	}
	
    /**
     * @return IntAmt
     */	
	public java.math.BigDecimal getIntAmt() {
		return this.intAmt;
	}
	
	/**
	 * @param intRate
	 */
	public void setIntRate(java.math.BigDecimal intRate) {
		this.intRate = intRate;
	}
	
    /**
     * @return IntRate
     */	
	public java.math.BigDecimal getIntRate() {
		return this.intRate;
	}
	
	/**
	 * @param vouKindCd
	 */
	public void setVouKindCd(String vouKindCd) {
		this.vouKindCd = vouKindCd == null ? null : vouKindCd.trim();
	}
	
    /**
     * @return VouKindCd
     */	
	public String getVouKindCd() {
		return this.vouKindCd;
	}
	
	/**
	 * @param vouNo
	 */
	public void setVouNo(String vouNo) {
		this.vouNo = vouNo == null ? null : vouNo.trim();
	}
	
    /**
     * @return VouNo
     */	
	public String getVouNo() {
		return this.vouNo;
	}
	
	/**
	 * @param toacctNo
	 */
	public void setToacctNo(String toacctNo) {
		this.toacctNo = toacctNo == null ? null : toacctNo.trim();
	}
	
    /**
     * @return ToacctNo
     */	
	public String getToacctNo() {
		return this.toacctNo;
	}
	
	/**
	 * @param ftfAccName
	 */
	public void setFtfAccName(String ftfAccName) {
		this.ftfAccName = ftfAccName == null ? null : ftfAccName.trim();
	}
	
    /**
     * @return FtfAccName
     */	
	public String getFtfAccName() {
		return this.ftfAccName;
	}
	
	/**
	 * @param oppclsNo
	 */
	public void setOppclsNo(String oppclsNo) {
		this.oppclsNo = oppclsNo == null ? null : oppclsNo.trim();
	}
	
    /**
     * @return OppclsNo
     */	
	public String getOppclsNo() {
		return this.oppclsNo;
	}
	
	/**
	 * @param ptxnSeqNo
	 */
	public void setPtxnSeqNo(java.math.BigDecimal ptxnSeqNo) {
		this.ptxnSeqNo = ptxnSeqNo;
	}
	
    /**
     * @return PtxnSeqNo
     */	
	public java.math.BigDecimal getPtxnSeqNo() {
		return this.ptxnSeqNo;
	}
	
	/**
	 * @param ctxnSeqNo
	 */
	public void setCtxnSeqNo(java.math.BigDecimal ctxnSeqNo) {
		this.ctxnSeqNo = ctxnSeqNo;
	}
	
    /**
     * @return CtxnSeqNo
     */	
	public java.math.BigDecimal getCtxnSeqNo() {
		return this.ctxnSeqNo;
	}
	
	/**
	 * @param ptxnCodeNo
	 */
	public void setPtxnCodeNo(String ptxnCodeNo) {
		this.ptxnCodeNo = ptxnCodeNo == null ? null : ptxnCodeNo.trim();
	}
	
    /**
     * @return PtxnCodeNo
     */	
	public String getPtxnCodeNo() {
		return this.ptxnCodeNo;
	}
	
	/**
	 * @param ctxnCodeCd
	 */
	public void setCtxnCodeCd(String ctxnCodeCd) {
		this.ctxnCodeCd = ctxnCodeCd == null ? null : ctxnCodeCd.trim();
	}
	
    /**
     * @return CtxnCodeCd
     */	
	public String getCtxnCodeCd() {
		return this.ctxnCodeCd;
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
	 * @param tlrNo
	 */
	public void setTlrNo(String tlrNo) {
		this.tlrNo = tlrNo == null ? null : tlrNo.trim();
	}
	
    /**
     * @return TlrNo
     */	
	public String getTlrNo() {
		return this.tlrNo;
	}
	
	/**
	 * @param revtlrNo
	 */
	public void setRevtlrNo(String revtlrNo) {
		this.revtlrNo = revtlrNo == null ? null : revtlrNo.trim();
	}
	
    /**
     * @return RevtlrNo
     */	
	public String getRevtlrNo() {
		return this.revtlrNo;
	}
	
	/**
	 * @param authtlrNo
	 */
	public void setAuthtlrNo(String authtlrNo) {
		this.authtlrNo = authtlrNo == null ? null : authtlrNo.trim();
	}
	
    /**
     * @return AuthtlrNo
     */	
	public String getAuthtlrNo() {
		return this.authtlrNo;
	}
	
	/**
	 * @param channel
	 */
	public void setChannel(String channel) {
		this.channel = channel == null ? null : channel.trim();
	}
	
    /**
     * @return Channel
     */	
	public String getChannel() {
		return this.channel;
	}
	
	/**
	 * @param channelCd
	 */
	public void setChannelCd(String channelCd) {
		this.channelCd = channelCd == null ? null : channelCd.trim();
	}
	
    /**
     * @return ChannelCd
     */	
	public String getChannelCd() {
		return this.channelCd;
	}
	
	/**
	 * @param agentName
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName == null ? null : agentName.trim();
	}
	
    /**
     * @return AgentName
     */	
	public String getAgentName() {
		return this.agentName;
	}
	
	/**
	 * @param refInd
	 */
	public void setRefInd(String refInd) {
		this.refInd = refInd == null ? null : refInd.trim();
	}
	
    /**
     * @return RefInd
     */	
	public String getRefInd() {
		return this.refInd;
	}
	
	/**
	 * @param refSeqNo
	 */
	public void setRefSeqNo(java.math.BigDecimal refSeqNo) {
		this.refSeqNo = refSeqNo;
	}
	
    /**
     * @return RefSeqNo
     */	
	public java.math.BigDecimal getRefSeqNo() {
		return this.refSeqNo;
	}
	
	/**
	 * @param briefcodeNo
	 */
	public void setBriefcodeNo(String briefcodeNo) {
		this.briefcodeNo = briefcodeNo == null ? null : briefcodeNo.trim();
	}
	
    /**
     * @return BriefcodeNo
     */	
	public String getBriefcodeNo() {
		return this.briefcodeNo;
	}
	
	/**
	 * @param tranBrief
	 */
	public void setTranBrief(String tranBrief) {
		this.tranBrief = tranBrief == null ? null : tranBrief.trim();
	}
	
    /**
     * @return TranBrief
     */	
	public String getTranBrief() {
		return this.tranBrief;
	}
	
	/**
	 * @param intDay
	 */
	public void setIntDay(java.math.BigDecimal intDay) {
		this.intDay = intDay;
	}
	
    /**
     * @return IntDay
     */	
	public java.math.BigDecimal getIntDay() {
		return this.intDay;
	}
	
	/**
	 * @param intAccum1
	 */
	public void setIntAccum1(java.math.BigDecimal intAccum1) {
		this.intAccum1 = intAccum1;
	}
	
    /**
     * @return IntAccum1
     */	
	public java.math.BigDecimal getIntAccum1() {
		return this.intAccum1;
	}
	
	/**
	 * @param intAccum2
	 */
	public void setIntAccum2(java.math.BigDecimal intAccum2) {
		this.intAccum2 = intAccum2;
	}
	
    /**
     * @return IntAccum2
     */	
	public java.math.BigDecimal getIntAccum2() {
		return this.intAccum2;
	}
	
	/**
	 * @param pageNo
	 */
	public void setPageNo(java.math.BigDecimal pageNo) {
		this.pageNo = pageNo;
	}
	
    /**
     * @return PageNo
     */	
	public java.math.BigDecimal getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * @param ordSeq
	 */
	public void setOrdSeq(java.math.BigDecimal ordSeq) {
		this.ordSeq = ordSeq;
	}
	
    /**
     * @return OrdSeq
     */	
	public java.math.BigDecimal getOrdSeq() {
		return this.ordSeq;
	}
	
	/**
	 * @param prtInd
	 */
	public void setPrtInd(String prtInd) {
		this.prtInd = prtInd == null ? null : prtInd.trim();
	}
	
    /**
     * @return PrtInd
     */	
	public String getPrtInd() {
		return this.prtInd;
	}
	
	/**
	 * @param transTm
	 */
	public void setTransTm(Date transTm) {
		this.transTm = transTm;
	}
	
    /**
     * @return TransTm
     */	
	public Date getTransTm() {
		return this.transTm;
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
        AcrmFevtPerSaveList other = (AcrmFevtPerSaveList) that;
		return (this.getEventNo() == null ? other.getEventNo() == null : this.getEventNo().equals(other.getEventNo()))
                	&& (this.getSubacctNo() == null ? other.getSubacctNo() == null : this.getSubacctNo().equals(other.getSubacctNo()))
        	&& (this.getAcctNo() == null ? other.getAcctNo() == null : this.getAcctNo().equals(other.getAcctNo()))
        	&& (this.getCardNo() == null ? other.getCardNo() == null : this.getCardNo().equals(other.getCardNo()))
        	&& (this.getClsNo() == null ? other.getClsNo() == null : this.getClsNo().equals(other.getClsNo()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
                                        	&& (this.getRcdtypeCd() == null ? other.getRcdtypeCd() == null : this.getRcdtypeCd().equals(other.getRcdtypeCd()))
        	&& (this.getCdInd() == null ? other.getCdInd() == null : this.getCdInd().equals(other.getCdInd()))
        	&& (this.getCtInd() == null ? other.getCtInd() == null : this.getCtInd().equals(other.getCtInd()))
                        	&& (this.getVouKindCd() == null ? other.getVouKindCd() == null : this.getVouKindCd().equals(other.getVouKindCd()))
        	&& (this.getVouNo() == null ? other.getVouNo() == null : this.getVouNo().equals(other.getVouNo()))
        	&& (this.getToacctNo() == null ? other.getToacctNo() == null : this.getToacctNo().equals(other.getToacctNo()))
        	&& (this.getFtfAccName() == null ? other.getFtfAccName() == null : this.getFtfAccName().equals(other.getFtfAccName()))
        	&& (this.getOppclsNo() == null ? other.getOppclsNo() == null : this.getOppclsNo().equals(other.getOppclsNo()))
                        	&& (this.getPtxnCodeNo() == null ? other.getPtxnCodeNo() == null : this.getPtxnCodeNo().equals(other.getPtxnCodeNo()))
        	&& (this.getCtxnCodeCd() == null ? other.getCtxnCodeCd() == null : this.getCtxnCodeCd().equals(other.getCtxnCodeCd()))
        	&& (this.getOrgNo() == null ? other.getOrgNo() == null : this.getOrgNo().equals(other.getOrgNo()))
        	&& (this.getTlrNo() == null ? other.getTlrNo() == null : this.getTlrNo().equals(other.getTlrNo()))
        	&& (this.getRevtlrNo() == null ? other.getRevtlrNo() == null : this.getRevtlrNo().equals(other.getRevtlrNo()))
        	&& (this.getAuthtlrNo() == null ? other.getAuthtlrNo() == null : this.getAuthtlrNo().equals(other.getAuthtlrNo()))
        	&& (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
        	&& (this.getChannelCd() == null ? other.getChannelCd() == null : this.getChannelCd().equals(other.getChannelCd()))
        	&& (this.getAgentName() == null ? other.getAgentName() == null : this.getAgentName().equals(other.getAgentName()))
        	&& (this.getRefInd() == null ? other.getRefInd() == null : this.getRefInd().equals(other.getRefInd()))
                	&& (this.getBriefcodeNo() == null ? other.getBriefcodeNo() == null : this.getBriefcodeNo().equals(other.getBriefcodeNo()))
        	&& (this.getTranBrief() == null ? other.getTranBrief() == null : this.getTranBrief().equals(other.getTranBrief()))
                                                	&& (this.getPrtInd() == null ? other.getPrtInd() == null : this.getPrtInd().equals(other.getPrtInd()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getEventNo() == null) ? 0 : getEventNo().hashCode());
        result = prime * result + ((getSubacctNo() == null) ? 0 : getSubacctNo().hashCode());
        result = prime * result + ((getAcctNo() == null) ? 0 : getAcctNo().hashCode());
        result = prime * result + ((getCardNo() == null) ? 0 : getCardNo().hashCode());
        result = prime * result + ((getClsNo() == null) ? 0 : getClsNo().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getRcdtypeCd() == null) ? 0 : getRcdtypeCd().hashCode());
        result = prime * result + ((getCdInd() == null) ? 0 : getCdInd().hashCode());
        result = prime * result + ((getCtInd() == null) ? 0 : getCtInd().hashCode());
        result = prime * result + ((getVouKindCd() == null) ? 0 : getVouKindCd().hashCode());
        result = prime * result + ((getVouNo() == null) ? 0 : getVouNo().hashCode());
        result = prime * result + ((getToacctNo() == null) ? 0 : getToacctNo().hashCode());
        result = prime * result + ((getFtfAccName() == null) ? 0 : getFtfAccName().hashCode());
        result = prime * result + ((getOppclsNo() == null) ? 0 : getOppclsNo().hashCode());
        result = prime * result + ((getPtxnCodeNo() == null) ? 0 : getPtxnCodeNo().hashCode());
        result = prime * result + ((getCtxnCodeCd() == null) ? 0 : getCtxnCodeCd().hashCode());
        result = prime * result + ((getOrgNo() == null) ? 0 : getOrgNo().hashCode());
        result = prime * result + ((getTlrNo() == null) ? 0 : getTlrNo().hashCode());
        result = prime * result + ((getRevtlrNo() == null) ? 0 : getRevtlrNo().hashCode());
        result = prime * result + ((getAuthtlrNo() == null) ? 0 : getAuthtlrNo().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getChannelCd() == null) ? 0 : getChannelCd().hashCode());
        result = prime * result + ((getAgentName() == null) ? 0 : getAgentName().hashCode());
        result = prime * result + ((getRefInd() == null) ? 0 : getRefInd().hashCode());
        result = prime * result + ((getBriefcodeNo() == null) ? 0 : getBriefcodeNo().hashCode());
        result = prime * result + ((getTranBrief() == null) ? 0 : getTranBrief().hashCode());
        result = prime * result + ((getPrtInd() == null) ? 0 : getPrtInd().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", eventNo=").append(eventNo);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", subacctNo=").append(subacctNo);
		sb.append(", acctNo=").append(acctNo);
		sb.append(", cardNo=").append(cardNo);
		sb.append(", clsNo=").append(clsNo);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", tranAmt=").append(tranAmt);
		sb.append(", bal=").append(bal);
		sb.append(", transDt=").append(transDt);
		sb.append(", eftDt=").append(eftDt);
		sb.append(", rcdtypeCd=").append(rcdtypeCd);
		sb.append(", cdInd=").append(cdInd);
		sb.append(", ctInd=").append(ctInd);
		sb.append(", intAmt=").append(intAmt);
		sb.append(", intRate=").append(intRate);
		sb.append(", vouKindCd=").append(vouKindCd);
		sb.append(", vouNo=").append(vouNo);
		sb.append(", toacctNo=").append(toacctNo);
		sb.append(", ftfAccName=").append(ftfAccName);
		sb.append(", oppclsNo=").append(oppclsNo);
		sb.append(", ptxnSeqNo=").append(ptxnSeqNo);
		sb.append(", ctxnSeqNo=").append(ctxnSeqNo);
		sb.append(", ptxnCodeNo=").append(ptxnCodeNo);
		sb.append(", ctxnCodeCd=").append(ctxnCodeCd);
		sb.append(", orgNo=").append(orgNo);
		sb.append(", tlrNo=").append(tlrNo);
		sb.append(", revtlrNo=").append(revtlrNo);
		sb.append(", authtlrNo=").append(authtlrNo);
		sb.append(", channel=").append(channel);
		sb.append(", channelCd=").append(channelCd);
		sb.append(", agentName=").append(agentName);
		sb.append(", refInd=").append(refInd);
		sb.append(", refSeqNo=").append(refSeqNo);
		sb.append(", briefcodeNo=").append(briefcodeNo);
		sb.append(", tranBrief=").append(tranBrief);
		sb.append(", intDay=").append(intDay);
		sb.append(", intAccum1=").append(intAccum1);
		sb.append(", intAccum2=").append(intAccum2);
		sb.append(", pageNo=").append(pageNo);
		sb.append(", ordSeq=").append(ordSeq);
		sb.append(", prtInd=").append(prtInd);
		sb.append(", transTm=").append(transTm);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}