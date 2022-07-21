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
 * @类名称: AcrmFagCreditLimitList
 * @类描述: #数据实体类
 * @功能描述: 授信信息
 * @创建人: 15104
 * @创建时间: 2019-02-12 10:49:16
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_CREDIT_LIMIT_LIST")
public class AcrmFagCreditLimitList extends BaseDomain implements Serializable{
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
	
	/** 数据统计日期
 **/
	@Transient
	@Column(name = "STATST_DT", unique = false, nullable = true, length = 7)
	private Date statstDt;
	
	/** 申请机构代码
 **/
	@Column(name = "BRC_NO", unique = false, nullable = true, length = 20)
	private String brcNo;
	
	/** 上层机构代码
 **/
	@Column(name = "UP_BRC_NO", unique = false, nullable = true, length = 20)
	private String upBrcNo;
	
	/** 客户名称
 **/
	@Column(name = "CUST_NM", unique = false, nullable = true, length = 250)
	private String custNm;
	
	/** 客户标识
 **/
	@Column(name = "CUST_IND", unique = false, nullable = true, length = 32)
	private String custInd;
	
	/** 额度信息ID
 **/
	@Column(name = "CREDIT_LMT_IN", unique = false, nullable = true, length = 32)
	private String creditLmtIn;
	
	/** 额度编号
 **/
	@Column(name = "AGT_NO", unique = false, nullable = true, length = 50)
	private String agtNo;
	
	/** 额度状态代码
 **/
	@Column(name = "AGT_STAT_CD", unique = false, nullable = true, length = 20)
	private String agtStatCd;
	
	/** 币种
 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 5)
	private String ccyCd;
	
	/** 额度有效起日
 **/
	@Transient
	@Column(name = "START_DATE", unique = false, nullable = true, length = 7)
	private Date startDate;
	
	/** 额度有效止日
 **/
	@Transient
	@Column(name = "END_DATE", unique = false, nullable = true, length = 7)
	private Date endDate;
	
	/** 额度期限
 **/
	@Column(name = "TERM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal term;
	
	/** 期限单位代码
 **/
	@Column(name = "TERM_UNIT_CD", unique = false, nullable = true, length = 20)
	private String termUnitCd;
	
	/** 审批人编号
 **/
	@Column(name = "APPROVER_NO", unique = false, nullable = true, length = 20)
	private String approverNo;
	
	/** 审批机构编号
 **/
	@Column(name = "APPROVE_BRC_NO", unique = false, nullable = true, length = 20)
	private String approveBrcNo;
	
	/** 额度类型代码
 **/
	@Column(name = "LMT_TYPE_CD", unique = false, nullable = true, length = 20)
	private String lmtTypeCd;
	
	/** 冻结额度
 **/
	@Column(name = "FROZEN_IND", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal frozenInd;
	
	/** 业务性质代码
 **/
	@Column(name = "BIZ_PROP_CD", unique = false, nullable = true, length = 20)
	private String bizPropCd;
	
	/** 客户类型代码
 **/
	@Column(name = "CUST_TYPE_CD", unique = false, nullable = true, length = 3)
	private String custTypeCd;
	
	/** 授信品种
 **/
	@Column(name = "PRODUCT_CD", unique = false, nullable = true, length = 20)
	private String productCd;
	
	/** 对公客户行业类型
 **/
	@Column(name = "INDU_TYPE_CD", unique = false, nullable = true, length = 10)
	private String induTypeCd;
	
	/** 对私客户行业类型
 **/
	@Column(name = "INDUSTRY_CD", unique = false, nullable = true, length = 10)
	private String industryCd;
	
	/** 担保方式代码
 **/
	@Column(name = "GUAR_METH_CD", unique = false, nullable = true, length = 20)
	private String guarMethCd;
	
	/** 批复结论代码
 **/
	@Column(name = "APPROVE_CONCLUSION_CD", unique = false, nullable = true, length = 20)
	private String approveConclusionCd;
	
	/** 授信额度_申请
 **/
	@Column(name = "APPLY_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal applyAmt;
	
	/** 授信额度
 **/
	@Column(name = "APPROVE_CREDIT_LIMIT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal approveCreditLimit;
	
	/** 可用额度
 **/
	@Column(name = "APPROVED_FREE_LIMIT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal approvedFreeLimit;
	
	/** 已用额度
 **/
	@Column(name = "APPROVED_USED_LIMIT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal approvedUsedLimit;
	
	/** 担保品类型代码
 **/
	@Column(name = "GUARANTY_TYPE_CD", unique = false, nullable = true, length = 20)
	private String guarantyTypeCd;
	
	/** 本次担保债权金额
 **/
	@Column(name = "GUARANTY_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal guarantyAmt;
	
	/** 抵质押类型
 **/
	@Column(name = "GUARANTEE_TYPE", unique = false, nullable = true, length = 20)
	private String guaranteeType;
	
	/** 担保后的币种
 **/
	@Column(name = "CURRENCY_CD", unique = false, nullable = true, length = 5)
	private String currencyCd;
	
	/** 抵质押物类型代码
 **/
	@Column(name = "COLLATERAL_TYPE_CD", unique = false, nullable = true, length = 20)
	private String collateralTypeCd;
	
	
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
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param statstDt
	 */
	public void setStatstDt(Date statstDt) {
		this.statstDt = statstDt;
	}
	
    /**
     * @return StatstDt
     */	
	public Date getStatstDt() {
		return this.statstDt;
	}
	
	/**
	 * @param brcNo
	 */
	public void setBrcNo(String brcNo) {
		this.brcNo = brcNo == null ? null : brcNo.trim();
	}
	
    /**
     * @return BrcNo
     */	
	public String getBrcNo() {
		return this.brcNo;
	}
	
	/**
	 * @param upBrcNo
	 */
	public void setUpBrcNo(String upBrcNo) {
		this.upBrcNo = upBrcNo == null ? null : upBrcNo.trim();
	}
	
    /**
     * @return UpBrcNo
     */	
	public String getUpBrcNo() {
		return this.upBrcNo;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm == null ? null : custNm.trim();
	}
	
    /**
     * @return CustNm
     */	
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * @param custInd
	 */
	public void setCustInd(String custInd) {
		this.custInd = custInd == null ? null : custInd.trim();
	}
	
    /**
     * @return CustInd
     */	
	public String getCustInd() {
		return this.custInd;
	}
	
	/**
	 * @param creditLmtIn
	 */
	public void setCreditLmtIn(String creditLmtIn) {
		this.creditLmtIn = creditLmtIn == null ? null : creditLmtIn.trim();
	}
	
    /**
     * @return CreditLmtIn
     */	
	public String getCreditLmtIn() {
		return this.creditLmtIn;
	}
	
	/**
	 * @param agtNo
	 */
	public void setAgtNo(String agtNo) {
		this.agtNo = agtNo == null ? null : agtNo.trim();
	}
	
    /**
     * @return AgtNo
     */	
	public String getAgtNo() {
		return this.agtNo;
	}
	
	/**
	 * @param agtStatCd
	 */
	public void setAgtStatCd(String agtStatCd) {
		this.agtStatCd = agtStatCd == null ? null : agtStatCd.trim();
	}
	
    /**
     * @return AgtStatCd
     */	
	public String getAgtStatCd() {
		return this.agtStatCd;
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
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
    /**
     * @return StartDate
     */	
	public Date getStartDate() {
		return this.startDate;
	}
	
	/**
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
    /**
     * @return EndDate
     */	
	public Date getEndDate() {
		return this.endDate;
	}
	
	/**
	 * @param term
	 */
	public void setTerm(java.math.BigDecimal term) {
		this.term = term;
	}
	
    /**
     * @return Term
     */	
	public java.math.BigDecimal getTerm() {
		return this.term;
	}
	
	/**
	 * @param termUnitCd
	 */
	public void setTermUnitCd(String termUnitCd) {
		this.termUnitCd = termUnitCd == null ? null : termUnitCd.trim();
	}
	
    /**
     * @return TermUnitCd
     */	
	public String getTermUnitCd() {
		return this.termUnitCd;
	}
	
	/**
	 * @param approverNo
	 */
	public void setApproverNo(String approverNo) {
		this.approverNo = approverNo == null ? null : approverNo.trim();
	}
	
    /**
     * @return ApproverNo
     */	
	public String getApproverNo() {
		return this.approverNo;
	}
	
	/**
	 * @param approveBrcNo
	 */
	public void setApproveBrcNo(String approveBrcNo) {
		this.approveBrcNo = approveBrcNo == null ? null : approveBrcNo.trim();
	}
	
    /**
     * @return ApproveBrcNo
     */	
	public String getApproveBrcNo() {
		return this.approveBrcNo;
	}
	
	/**
	 * @param lmtTypeCd
	 */
	public void setLmtTypeCd(String lmtTypeCd) {
		this.lmtTypeCd = lmtTypeCd == null ? null : lmtTypeCd.trim();
	}
	
    /**
     * @return LmtTypeCd
     */	
	public String getLmtTypeCd() {
		return this.lmtTypeCd;
	}
	
	/**
	 * @param frozenInd
	 */
	public void setFrozenInd(java.math.BigDecimal frozenInd) {
		this.frozenInd = frozenInd;
	}
	
    /**
     * @return FrozenInd
     */	
	public java.math.BigDecimal getFrozenInd() {
		return this.frozenInd;
	}
	
	/**
	 * @param bizPropCd
	 */
	public void setBizPropCd(String bizPropCd) {
		this.bizPropCd = bizPropCd == null ? null : bizPropCd.trim();
	}
	
    /**
     * @return BizPropCd
     */	
	public String getBizPropCd() {
		return this.bizPropCd;
	}
	
	/**
	 * @param custTypeCd
	 */
	public void setCustTypeCd(String custTypeCd) {
		this.custTypeCd = custTypeCd == null ? null : custTypeCd.trim();
	}
	
    /**
     * @return CustTypeCd
     */	
	public String getCustTypeCd() {
		return this.custTypeCd;
	}
	
	/**
	 * @param productCd
	 */
	public void setProductCd(String productCd) {
		this.productCd = productCd == null ? null : productCd.trim();
	}
	
    /**
     * @return ProductCd
     */	
	public String getProductCd() {
		return this.productCd;
	}
	
	/**
	 * @param induTypeCd
	 */
	public void setInduTypeCd(String induTypeCd) {
		this.induTypeCd = induTypeCd == null ? null : induTypeCd.trim();
	}
	
    /**
     * @return InduTypeCd
     */	
	public String getInduTypeCd() {
		return this.induTypeCd;
	}
	
	/**
	 * @param industryCd
	 */
	public void setIndustryCd(String industryCd) {
		this.industryCd = industryCd == null ? null : industryCd.trim();
	}
	
    /**
     * @return IndustryCd
     */	
	public String getIndustryCd() {
		return this.industryCd;
	}
	
	/**
	 * @param guarMethCd
	 */
	public void setGuarMethCd(String guarMethCd) {
		this.guarMethCd = guarMethCd == null ? null : guarMethCd.trim();
	}
	
    /**
     * @return GuarMethCd
     */	
	public String getGuarMethCd() {
		return this.guarMethCd;
	}
	
	/**
	 * @param approveConclusionCd
	 */
	public void setApproveConclusionCd(String approveConclusionCd) {
		this.approveConclusionCd = approveConclusionCd == null ? null : approveConclusionCd.trim();
	}
	
    /**
     * @return ApproveConclusionCd
     */	
	public String getApproveConclusionCd() {
		return this.approveConclusionCd;
	}
	
	/**
	 * @param applyAmt
	 */
	public void setApplyAmt(java.math.BigDecimal applyAmt) {
		this.applyAmt = applyAmt;
	}
	
    /**
     * @return ApplyAmt
     */	
	public java.math.BigDecimal getApplyAmt() {
		return this.applyAmt;
	}
	
	/**
	 * @param approveCreditLimit
	 */
	public void setApproveCreditLimit(java.math.BigDecimal approveCreditLimit) {
		this.approveCreditLimit = approveCreditLimit;
	}
	
    /**
     * @return ApproveCreditLimit
     */	
	public java.math.BigDecimal getApproveCreditLimit() {
		return this.approveCreditLimit;
	}
	
	/**
	 * @param approvedFreeLimit
	 */
	public void setApprovedFreeLimit(java.math.BigDecimal approvedFreeLimit) {
		this.approvedFreeLimit = approvedFreeLimit;
	}
	
    /**
     * @return ApprovedFreeLimit
     */	
	public java.math.BigDecimal getApprovedFreeLimit() {
		return this.approvedFreeLimit;
	}
	
	/**
	 * @param approvedUsedLimit
	 */
	public void setApprovedUsedLimit(java.math.BigDecimal approvedUsedLimit) {
		this.approvedUsedLimit = approvedUsedLimit;
	}
	
    /**
     * @return ApprovedUsedLimit
     */	
	public java.math.BigDecimal getApprovedUsedLimit() {
		return this.approvedUsedLimit;
	}
	
	/**
	 * @param guarantyTypeCd
	 */
	public void setGuarantyTypeCd(String guarantyTypeCd) {
		this.guarantyTypeCd = guarantyTypeCd == null ? null : guarantyTypeCd.trim();
	}
	
    /**
     * @return GuarantyTypeCd
     */	
	public String getGuarantyTypeCd() {
		return this.guarantyTypeCd;
	}
	
	/**
	 * @param guarantyAmt
	 */
	public void setGuarantyAmt(java.math.BigDecimal guarantyAmt) {
		this.guarantyAmt = guarantyAmt;
	}
	
    /**
     * @return GuarantyAmt
     */	
	public java.math.BigDecimal getGuarantyAmt() {
		return this.guarantyAmt;
	}
	
	/**
	 * @param guaranteeType
	 */
	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType == null ? null : guaranteeType.trim();
	}
	
    /**
     * @return GuaranteeType
     */	
	public String getGuaranteeType() {
		return this.guaranteeType;
	}
	
	/**
	 * @param currencyCd
	 */
	public void setCurrencyCd(String currencyCd) {
		this.currencyCd = currencyCd == null ? null : currencyCd.trim();
	}
	
    /**
     * @return CurrencyCd
     */	
	public String getCurrencyCd() {
		return this.currencyCd;
	}
	
	/**
	 * @param collateralTypeCd
	 */
	public void setCollateralTypeCd(String collateralTypeCd) {
		this.collateralTypeCd = collateralTypeCd == null ? null : collateralTypeCd.trim();
	}
	
    /**
     * @return CollateralTypeCd
     */	
	public String getCollateralTypeCd() {
		return this.collateralTypeCd;
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
        AcrmFagCreditLimitList other = (AcrmFagCreditLimitList) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                        	&& (this.getBrcNo() == null ? other.getBrcNo() == null : this.getBrcNo().equals(other.getBrcNo()))
        	&& (this.getUpBrcNo() == null ? other.getUpBrcNo() == null : this.getUpBrcNo().equals(other.getUpBrcNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustNm() == null ? other.getCustNm() == null : this.getCustNm().equals(other.getCustNm()))
        	&& (this.getCustInd() == null ? other.getCustInd() == null : this.getCustInd().equals(other.getCustInd()))
        	&& (this.getCreditLmtIn() == null ? other.getCreditLmtIn() == null : this.getCreditLmtIn().equals(other.getCreditLmtIn()))
        	&& (this.getAgtNo() == null ? other.getAgtNo() == null : this.getAgtNo().equals(other.getAgtNo()))
        	&& (this.getAgtStatCd() == null ? other.getAgtStatCd() == null : this.getAgtStatCd().equals(other.getAgtStatCd()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
                                	&& (this.getTermUnitCd() == null ? other.getTermUnitCd() == null : this.getTermUnitCd().equals(other.getTermUnitCd()))
        	&& (this.getApproverNo() == null ? other.getApproverNo() == null : this.getApproverNo().equals(other.getApproverNo()))
        	&& (this.getApproveBrcNo() == null ? other.getApproveBrcNo() == null : this.getApproveBrcNo().equals(other.getApproveBrcNo()))
        	&& (this.getLmtTypeCd() == null ? other.getLmtTypeCd() == null : this.getLmtTypeCd().equals(other.getLmtTypeCd()))
        	&& (this.getFrozenInd() == null ? other.getFrozenInd() == null : this.getFrozenInd().equals(other.getFrozenInd()))
        	&& (this.getBizPropCd() == null ? other.getBizPropCd() == null : this.getBizPropCd().equals(other.getBizPropCd()))
        	&& (this.getCustTypeCd() == null ? other.getCustTypeCd() == null : this.getCustTypeCd().equals(other.getCustTypeCd()))
        	&& (this.getProductCd() == null ? other.getProductCd() == null : this.getProductCd().equals(other.getProductCd()))
        	&& (this.getInduTypeCd() == null ? other.getInduTypeCd() == null : this.getInduTypeCd().equals(other.getInduTypeCd()))
        	&& (this.getIndustryCd() == null ? other.getIndustryCd() == null : this.getIndustryCd().equals(other.getIndustryCd()))
        	&& (this.getGuarMethCd() == null ? other.getGuarMethCd() == null : this.getGuarMethCd().equals(other.getGuarMethCd()))
        	&& (this.getApproveConclusionCd() == null ? other.getApproveConclusionCd() == null : this.getApproveConclusionCd().equals(other.getApproveConclusionCd()))
                                        	&& (this.getGuarantyTypeCd() == null ? other.getGuarantyTypeCd() == null : this.getGuarantyTypeCd().equals(other.getGuarantyTypeCd()))
                	&& (this.getGuaranteeType() == null ? other.getGuaranteeType() == null : this.getGuaranteeType().equals(other.getGuaranteeType()))
        	&& (this.getCurrencyCd() == null ? other.getCurrencyCd() == null : this.getCurrencyCd().equals(other.getCurrencyCd()))
        	&& (this.getCollateralTypeCd() == null ? other.getCollateralTypeCd() == null : this.getCollateralTypeCd().equals(other.getCollateralTypeCd()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getBrcNo() == null) ? 0 : getBrcNo().hashCode());
        result = prime * result + ((getUpBrcNo() == null) ? 0 : getUpBrcNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustNm() == null) ? 0 : getCustNm().hashCode());
        result = prime * result + ((getCustInd() == null) ? 0 : getCustInd().hashCode());
        result = prime * result + ((getCreditLmtIn() == null) ? 0 : getCreditLmtIn().hashCode());
        result = prime * result + ((getAgtNo() == null) ? 0 : getAgtNo().hashCode());
        result = prime * result + ((getAgtStatCd() == null) ? 0 : getAgtStatCd().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getTermUnitCd() == null) ? 0 : getTermUnitCd().hashCode());
        result = prime * result + ((getApproverNo() == null) ? 0 : getApproverNo().hashCode());
        result = prime * result + ((getApproveBrcNo() == null) ? 0 : getApproveBrcNo().hashCode());
        result = prime * result + ((getLmtTypeCd() == null) ? 0 : getLmtTypeCd().hashCode());
        result = prime * result + ((getFrozenInd() == null) ? 0 : getFrozenInd().hashCode());
        result = prime * result + ((getBizPropCd() == null) ? 0 : getBizPropCd().hashCode());
        result = prime * result + ((getCustTypeCd() == null) ? 0 : getCustTypeCd().hashCode());
        result = prime * result + ((getProductCd() == null) ? 0 : getProductCd().hashCode());
        result = prime * result + ((getInduTypeCd() == null) ? 0 : getInduTypeCd().hashCode());
        result = prime * result + ((getIndustryCd() == null) ? 0 : getIndustryCd().hashCode());
        result = prime * result + ((getGuarMethCd() == null) ? 0 : getGuarMethCd().hashCode());
        result = prime * result + ((getApproveConclusionCd() == null) ? 0 : getApproveConclusionCd().hashCode());
        result = prime * result + ((getGuarantyTypeCd() == null) ? 0 : getGuarantyTypeCd().hashCode());
        result = prime * result + ((getGuaranteeType() == null) ? 0 : getGuaranteeType().hashCode());
        result = prime * result + ((getCurrencyCd() == null) ? 0 : getCurrencyCd().hashCode());
        result = prime * result + ((getCollateralTypeCd() == null) ? 0 : getCollateralTypeCd().hashCode());
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
		sb.append(", statstDt=").append(statstDt);
		sb.append(", brcNo=").append(brcNo);
		sb.append(", upBrcNo=").append(upBrcNo);
		sb.append(", CustId=").append(custId);
		sb.append(", custNm=").append(custNm);
		sb.append(", custInd=").append(custInd);
		sb.append(", creditLmtIn=").append(creditLmtIn);
		sb.append(", agtNo=").append(agtNo);
		sb.append(", agtStatCd=").append(agtStatCd);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", startDate=").append(startDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", term=").append(term);
		sb.append(", termUnitCd=").append(termUnitCd);
		sb.append(", approverNo=").append(approverNo);
		sb.append(", approveBrcNo=").append(approveBrcNo);
		sb.append(", lmtTypeCd=").append(lmtTypeCd);
		sb.append(", frozenInd=").append(frozenInd);
		sb.append(", bizPropCd=").append(bizPropCd);
		sb.append(", custTypeCd=").append(custTypeCd);
		sb.append(", productCd=").append(productCd);
		sb.append(", induTypeCd=").append(induTypeCd);
		sb.append(", industryCd=").append(industryCd);
		sb.append(", guarMethCd=").append(guarMethCd);
		sb.append(", approveConclusionCd=").append(approveConclusionCd);
		sb.append(", applyAmt=").append(applyAmt);
		sb.append(", approveCreditLimit=").append(approveCreditLimit);
		sb.append(", approvedFreeLimit=").append(approvedFreeLimit);
		sb.append(", approvedUsedLimit=").append(approvedUsedLimit);
		sb.append(", guarantyTypeCd=").append(guarantyTypeCd);
		sb.append(", guarantyAmt=").append(guarantyAmt);
		sb.append(", guaranteeType=").append(guaranteeType);
		sb.append(", currencyCd=").append(currencyCd);
		sb.append(", collateralTypeCd=").append(collateralTypeCd);
        sb.append("]");
        return sb.toString();
    }
}