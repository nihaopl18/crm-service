package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFevtLoanLnsacctlist
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-03-13 17:52:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_EVT_LOAN_LNSACCTLIST")
public class AcrmFevtLoanLnsacctlist extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 数据日期 **/
	@Transient
	@Column(name = "DATA_DT", unique = false, nullable = true, length = 7)
	private Date dataDt;
	
	/** 机构编号 **/
	@Column(name = "ORG_NO", unique = false, nullable = true, length = 20)
	private String orgNo;
	
	/** 交易日期 **/
	@Transient
	@Column(name = "TRANS_DT", unique = false, nullable = true, length = 7)
	private Date transDt;
	
	/** 事件编号 **/
	@Column(name = "EVENT_NO", unique = false, nullable = true, length = 60)
	private String eventNo;
	
	/** 账户编号 **/
	@Column(name = "ACCT_NO", unique = false, nullable = true, length = 65)
	private String acctNo;
	
	/** 账户形态代码 **/
	@Column(name = "ACCT_STAT_CD", unique = false, nullable = true, length = 2)
	private String acctStatCd;
	
	/** 数量 **/
	@Column(name = "ORD_QTY", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal ordQty;
	
	/** 内部账户编号 **/
	@Column(name = "INACCT_NO", unique = false, nullable = true, length = 40)
	private String inacctNo;
	
	/** 科目编号 **/
	@Column(name = "ITEM_NO", unique = false, nullable = true, length = 10)
	private String itemNo;
	
	/** 账别标志 **/
	@Column(name = "ACCTYPE_IND", unique = false, nullable = true, length = 1)
	private String acctypeInd;
	
	/** 币种代码 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 借贷标志 **/
	@Column(name = "CD_IND", unique = false, nullable = true, length = 1)
	private String cdInd;
	
	/** 交易金额 **/
	@Column(name = "TRAN_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal tranAmt;
	
	/** 余额 **/
	@Column(name = "BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal bal;
	
	/** 天数 **/
	@Column(name = "DAYS", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal days;
	
	/** 本金积数 **/
	@Column(name = "ACCUM", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal accum;
	
	/** 凭证类型代码 **/
	@Column(name = "VOU_KIND_CD", unique = false, nullable = true, length = 3)
	private String vouKindCd;
	
	/** 凭证编号 **/
	@Column(name = "VOU_NO", unique = false, nullable = true, length = 20)
	private String vouNo;
	
	/** 摘要代码 **/
	@Column(name = "MEMO_CD", unique = false, nullable = true, length = 4)
	private String memoCd;
	
	/** 交易摘要 **/
	@Column(name = "MEMO", unique = false, nullable = true, length = 20)
	private String memo;
	
	/** 对方账户编号 **/
	@Column(name = "TOACCT_NO", unique = false, nullable = true, length = 40)
	private String toacctNo;
	
	/** 销账编号 **/
	@Column(name = "CLS_NO", unique = false, nullable = true, length = 16)
	private String clsNo;
	
	/** 交易时间 **/
	@Transient
	@Column(name = "TRANS_TM", unique = false, nullable = true, length = 7)
	private Date transTm;
	
	/** 原交易流水号 **/
	@Column(name = "PTXN_SEQ_NO", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal ptxnSeqNo;
	
	/** 子交易流水号 **/
	@Column(name = "SUBSERSEQ_NO", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal subserseqNo;
	
	/** 原交易代码 **/
	@Column(name = "TRAN_CD", unique = false, nullable = true, length = 6)
	private String tranCd;
	
	/** 子交易代码 **/
	@Column(name = "SUBTRAN_CD", unique = false, nullable = true, length = 6)
	private String subtranCd;
	
	/** 交易机构编号 **/
	@Column(name = "TRANS_ORG_NO", unique = false, nullable = true, length = 9)
	private String transOrgNo;
	
	/** 交易柜员编号 **/
	@Column(name = "TELLER_NO", unique = false, nullable = true, length = 10)
	private String tellerNo;
	
	/** 授权柜员编号 **/
	@Column(name = "AUTHTLR_NO", unique = false, nullable = true, length = 10)
	private String authtlrNo;
	
	/** 复核柜员编号 **/
	@Column(name = "CHKTLR_NO", unique = false, nullable = true, length = 10)
	private String chktlrNo;
	
	/** 页次 **/
	@Column(name = "PAGE_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal pageNum;
	
	/** 打印标志 **/
	@Column(name = "PRINT_FLAG", unique = false, nullable = true, length = 1)
	private String printFlag;
	
	/** 贷款分户明细交易来源标志 **/
	@Column(name = "TRAN_SOURCE_IND", unique = false, nullable = true, length = 1)
	private String tranSourceInd;
	
	/** 记录类型代码 **/
	@Column(name = "RECORD_TYPE_CD", unique = false, nullable = true, length = 1)
	private String recordTypeCd;
	
	/** 流水帐标识 **/
	@Column(name = "WASTE_BOOK_FLAG", unique = false, nullable = true, length = 1)
	private String wasteBookFlag;
	
	/** 被冲销标志 **/
	@Column(name = "WASH_FLAG", unique = false, nullable = true, length = 1)
	private String washFlag;
	
	/** 备用标志 **/
	@Column(name = "REMARK_FLAG", unique = false, nullable = true, length = 16)
	private String remarkFlag;
	
	/** 序号1 **/
	@Column(name = "SEQ1", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal seq1;
	
	/** 序号2 **/
	@Column(name = "SEQ2", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal seq2;
	
	/** CORP_ORG_CODE **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	
	/**
	 * @param dataDt
	 */
	public void setDataDt(Date dataDt) {
		this.dataDt = dataDt;
	}
	
    /**
     * @return DataDt
     */	
	public Date getDataDt() {
		return this.dataDt;
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
	 * @param acctStatCd
	 */
	public void setAcctStatCd(String acctStatCd) {
		this.acctStatCd = acctStatCd == null ? null : acctStatCd.trim();
	}
	
    /**
     * @return AcctStatCd
     */	
	public String getAcctStatCd() {
		return this.acctStatCd;
	}
	
	/**
	 * @param ordQty
	 */
	public void setOrdQty(java.math.BigDecimal ordQty) {
		this.ordQty = ordQty;
	}
	
    /**
     * @return OrdQty
     */	
	public java.math.BigDecimal getOrdQty() {
		return this.ordQty;
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
	 * @param itemNo
	 */
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo == null ? null : itemNo.trim();
	}
	
    /**
     * @return ItemNo
     */	
	public String getItemNo() {
		return this.itemNo;
	}
	
	/**
	 * @param acctypeInd
	 */
	public void setAcctypeInd(String acctypeInd) {
		this.acctypeInd = acctypeInd == null ? null : acctypeInd.trim();
	}
	
    /**
     * @return AcctypeInd
     */	
	public String getAcctypeInd() {
		return this.acctypeInd;
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
	 * @param days
	 */
	public void setDays(java.math.BigDecimal days) {
		this.days = days;
	}
	
    /**
     * @return Days
     */	
	public java.math.BigDecimal getDays() {
		return this.days;
	}
	
	/**
	 * @param accum
	 */
	public void setAccum(java.math.BigDecimal accum) {
		this.accum = accum;
	}
	
    /**
     * @return Accum
     */	
	public java.math.BigDecimal getAccum() {
		return this.accum;
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
	 * @param memoCd
	 */
	public void setMemoCd(String memoCd) {
		this.memoCd = memoCd == null ? null : memoCd.trim();
	}
	
    /**
     * @return MemoCd
     */	
	public String getMemoCd() {
		return this.memoCd;
	}
	
	/**
	 * @param memo
	 */
	public void setMemo(String memo) {
		this.memo = memo == null ? null : memo.trim();
	}
	
    /**
     * @return Memo
     */	
	public String getMemo() {
		return this.memo;
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
	 * @param subserseqNo
	 */
	public void setSubserseqNo(java.math.BigDecimal subserseqNo) {
		this.subserseqNo = subserseqNo;
	}
	
    /**
     * @return SubserseqNo
     */	
	public java.math.BigDecimal getSubserseqNo() {
		return this.subserseqNo;
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
	 * @param subtranCd
	 */
	public void setSubtranCd(String subtranCd) {
		this.subtranCd = subtranCd == null ? null : subtranCd.trim();
	}
	
    /**
     * @return SubtranCd
     */	
	public String getSubtranCd() {
		return this.subtranCd;
	}
	
	/**
	 * @param transOrgNo
	 */
	public void setTransOrgNo(String transOrgNo) {
		this.transOrgNo = transOrgNo == null ? null : transOrgNo.trim();
	}
	
    /**
     * @return TransOrgNo
     */	
	public String getTransOrgNo() {
		return this.transOrgNo;
	}
	
	/**
	 * @param tellerNo
	 */
	public void setTellerNo(String tellerNo) {
		this.tellerNo = tellerNo == null ? null : tellerNo.trim();
	}
	
    /**
     * @return TellerNo
     */	
	public String getTellerNo() {
		return this.tellerNo;
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
	 * @param chktlrNo
	 */
	public void setChktlrNo(String chktlrNo) {
		this.chktlrNo = chktlrNo == null ? null : chktlrNo.trim();
	}
	
    /**
     * @return ChktlrNo
     */	
	public String getChktlrNo() {
		return this.chktlrNo;
	}
	
	/**
	 * @param pageNum
	 */
	public void setPageNum(java.math.BigDecimal pageNum) {
		this.pageNum = pageNum;
	}
	
    /**
     * @return PageNum
     */	
	public java.math.BigDecimal getPageNum() {
		return this.pageNum;
	}
	
	/**
	 * @param printFlag
	 */
	public void setPrintFlag(String printFlag) {
		this.printFlag = printFlag == null ? null : printFlag.trim();
	}
	
    /**
     * @return PrintFlag
     */	
	public String getPrintFlag() {
		return this.printFlag;
	}
	
	/**
	 * @param tranSourceInd
	 */
	public void setTranSourceInd(String tranSourceInd) {
		this.tranSourceInd = tranSourceInd == null ? null : tranSourceInd.trim();
	}
	
    /**
     * @return TranSourceInd
     */	
	public String getTranSourceInd() {
		return this.tranSourceInd;
	}
	
	/**
	 * @param recordTypeCd
	 */
	public void setRecordTypeCd(String recordTypeCd) {
		this.recordTypeCd = recordTypeCd == null ? null : recordTypeCd.trim();
	}
	
    /**
     * @return RecordTypeCd
     */	
	public String getRecordTypeCd() {
		return this.recordTypeCd;
	}
	
	/**
	 * @param wasteBookFlag
	 */
	public void setWasteBookFlag(String wasteBookFlag) {
		this.wasteBookFlag = wasteBookFlag == null ? null : wasteBookFlag.trim();
	}
	
    /**
     * @return WasteBookFlag
     */	
	public String getWasteBookFlag() {
		return this.wasteBookFlag;
	}
	
	/**
	 * @param washFlag
	 */
	public void setWashFlag(String washFlag) {
		this.washFlag = washFlag == null ? null : washFlag.trim();
	}
	
    /**
     * @return WashFlag
     */	
	public String getWashFlag() {
		return this.washFlag;
	}
	
	/**
	 * @param remarkFlag
	 */
	public void setRemarkFlag(String remarkFlag) {
		this.remarkFlag = remarkFlag == null ? null : remarkFlag.trim();
	}
	
    /**
     * @return RemarkFlag
     */	
	public String getRemarkFlag() {
		return this.remarkFlag;
	}
	
	/**
	 * @param seq1
	 */
	public void setSeq1(java.math.BigDecimal seq1) {
		this.seq1 = seq1;
	}
	
    /**
     * @return Seq1
     */	
	public java.math.BigDecimal getSeq1() {
		return this.seq1;
	}
	
	/**
	 * @param seq2
	 */
	public void setSeq2(java.math.BigDecimal seq2) {
		this.seq2 = seq2;
	}
	
    /**
     * @return Seq2
     */	
	public java.math.BigDecimal getSeq2() {
		return this.seq2;
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
        AcrmFevtLoanLnsacctlist other = (AcrmFevtLoanLnsacctlist) that;
        		return (this.getOrgNo() == null ? other.getOrgNo() == null : this.getOrgNo().equals(other.getOrgNo()))
                	&& (this.getEventNo() == null ? other.getEventNo() == null : this.getEventNo().equals(other.getEventNo()))
        	&& (this.getAcctNo() == null ? other.getAcctNo() == null : this.getAcctNo().equals(other.getAcctNo()))
        	&& (this.getAcctStatCd() == null ? other.getAcctStatCd() == null : this.getAcctStatCd().equals(other.getAcctStatCd()))
                	&& (this.getInacctNo() == null ? other.getInacctNo() == null : this.getInacctNo().equals(other.getInacctNo()))
        	&& (this.getItemNo() == null ? other.getItemNo() == null : this.getItemNo().equals(other.getItemNo()))
        	&& (this.getAcctypeInd() == null ? other.getAcctypeInd() == null : this.getAcctypeInd().equals(other.getAcctypeInd()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
        	&& (this.getCdInd() == null ? other.getCdInd() == null : this.getCdInd().equals(other.getCdInd()))
                                        	&& (this.getVouKindCd() == null ? other.getVouKindCd() == null : this.getVouKindCd().equals(other.getVouKindCd()))
        	&& (this.getVouNo() == null ? other.getVouNo() == null : this.getVouNo().equals(other.getVouNo()))
        	&& (this.getMemoCd() == null ? other.getMemoCd() == null : this.getMemoCd().equals(other.getMemoCd()))
        	&& (this.getMemo() == null ? other.getMemo() == null : this.getMemo().equals(other.getMemo()))
        	&& (this.getToacctNo() == null ? other.getToacctNo() == null : this.getToacctNo().equals(other.getToacctNo()))
        	&& (this.getClsNo() == null ? other.getClsNo() == null : this.getClsNo().equals(other.getClsNo()))
                                	&& (this.getTranCd() == null ? other.getTranCd() == null : this.getTranCd().equals(other.getTranCd()))
        	&& (this.getSubtranCd() == null ? other.getSubtranCd() == null : this.getSubtranCd().equals(other.getSubtranCd()))
        	&& (this.getTransOrgNo() == null ? other.getTransOrgNo() == null : this.getTransOrgNo().equals(other.getTransOrgNo()))
        	&& (this.getTellerNo() == null ? other.getTellerNo() == null : this.getTellerNo().equals(other.getTellerNo()))
        	&& (this.getAuthtlrNo() == null ? other.getAuthtlrNo() == null : this.getAuthtlrNo().equals(other.getAuthtlrNo()))
        	&& (this.getChktlrNo() == null ? other.getChktlrNo() == null : this.getChktlrNo().equals(other.getChktlrNo()))
                	&& (this.getPrintFlag() == null ? other.getPrintFlag() == null : this.getPrintFlag().equals(other.getPrintFlag()))
        	&& (this.getTranSourceInd() == null ? other.getTranSourceInd() == null : this.getTranSourceInd().equals(other.getTranSourceInd()))
        	&& (this.getRecordTypeCd() == null ? other.getRecordTypeCd() == null : this.getRecordTypeCd().equals(other.getRecordTypeCd()))
        	&& (this.getWasteBookFlag() == null ? other.getWasteBookFlag() == null : this.getWasteBookFlag().equals(other.getWasteBookFlag()))
        	&& (this.getWashFlag() == null ? other.getWashFlag() == null : this.getWashFlag().equals(other.getWashFlag()))
        	&& (this.getRemarkFlag() == null ? other.getRemarkFlag() == null : this.getRemarkFlag().equals(other.getRemarkFlag()))
                        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrgNo() == null) ? 0 : getOrgNo().hashCode());
        result = prime * result + ((getEventNo() == null) ? 0 : getEventNo().hashCode());
        result = prime * result + ((getAcctNo() == null) ? 0 : getAcctNo().hashCode());
        result = prime * result + ((getAcctStatCd() == null) ? 0 : getAcctStatCd().hashCode());
        result = prime * result + ((getInacctNo() == null) ? 0 : getInacctNo().hashCode());
        result = prime * result + ((getItemNo() == null) ? 0 : getItemNo().hashCode());
        result = prime * result + ((getAcctypeInd() == null) ? 0 : getAcctypeInd().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getCdInd() == null) ? 0 : getCdInd().hashCode());
        result = prime * result + ((getVouKindCd() == null) ? 0 : getVouKindCd().hashCode());
        result = prime * result + ((getVouNo() == null) ? 0 : getVouNo().hashCode());
        result = prime * result + ((getMemoCd() == null) ? 0 : getMemoCd().hashCode());
        result = prime * result + ((getMemo() == null) ? 0 : getMemo().hashCode());
        result = prime * result + ((getToacctNo() == null) ? 0 : getToacctNo().hashCode());
        result = prime * result + ((getClsNo() == null) ? 0 : getClsNo().hashCode());
        result = prime * result + ((getTranCd() == null) ? 0 : getTranCd().hashCode());
        result = prime * result + ((getSubtranCd() == null) ? 0 : getSubtranCd().hashCode());
        result = prime * result + ((getTransOrgNo() == null) ? 0 : getTransOrgNo().hashCode());
        result = prime * result + ((getTellerNo() == null) ? 0 : getTellerNo().hashCode());
        result = prime * result + ((getAuthtlrNo() == null) ? 0 : getAuthtlrNo().hashCode());
        result = prime * result + ((getChktlrNo() == null) ? 0 : getChktlrNo().hashCode());
        result = prime * result + ((getPrintFlag() == null) ? 0 : getPrintFlag().hashCode());
        result = prime * result + ((getTranSourceInd() == null) ? 0 : getTranSourceInd().hashCode());
        result = prime * result + ((getRecordTypeCd() == null) ? 0 : getRecordTypeCd().hashCode());
        result = prime * result + ((getWasteBookFlag() == null) ? 0 : getWasteBookFlag().hashCode());
        result = prime * result + ((getWashFlag() == null) ? 0 : getWashFlag().hashCode());
        result = prime * result + ((getRemarkFlag() == null) ? 0 : getRemarkFlag().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDt=").append(dataDt);
		sb.append(", orgNo=").append(orgNo);
		sb.append(", transDt=").append(transDt);
		sb.append(", eventNo=").append(eventNo);
		sb.append(", acctNo=").append(acctNo);
		sb.append(", acctStatCd=").append(acctStatCd);
		sb.append(", ordQty=").append(ordQty);
		sb.append(", inacctNo=").append(inacctNo);
		sb.append(", itemNo=").append(itemNo);
		sb.append(", acctypeInd=").append(acctypeInd);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", cdInd=").append(cdInd);
		sb.append(", tranAmt=").append(tranAmt);
		sb.append(", bal=").append(bal);
		sb.append(", days=").append(days);
		sb.append(", accum=").append(accum);
		sb.append(", vouKindCd=").append(vouKindCd);
		sb.append(", vouNo=").append(vouNo);
		sb.append(", memoCd=").append(memoCd);
		sb.append(", memo=").append(memo);
		sb.append(", toacctNo=").append(toacctNo);
		sb.append(", clsNo=").append(clsNo);
		sb.append(", transTm=").append(transTm);
		sb.append(", ptxnSeqNo=").append(ptxnSeqNo);
		sb.append(", subserseqNo=").append(subserseqNo);
		sb.append(", tranCd=").append(tranCd);
		sb.append(", subtranCd=").append(subtranCd);
		sb.append(", transOrgNo=").append(transOrgNo);
		sb.append(", tellerNo=").append(tellerNo);
		sb.append(", authtlrNo=").append(authtlrNo);
		sb.append(", chktlrNo=").append(chktlrNo);
		sb.append(", pageNum=").append(pageNum);
		sb.append(", printFlag=").append(printFlag);
		sb.append(", tranSourceInd=").append(tranSourceInd);
		sb.append(", recordTypeCd=").append(recordTypeCd);
		sb.append(", wasteBookFlag=").append(wasteBookFlag);
		sb.append(", washFlag=").append(washFlag);
		sb.append(", remarkFlag=").append(remarkFlag);
		sb.append(", seq1=").append(seq1);
		sb.append(", seq2=").append(seq2);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}