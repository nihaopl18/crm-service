package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagLoanGuarantee
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-03-14 00:28:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_LOAN_GUARANTEE")
public class AcrmFagLoanGuarantee extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 数据来源 **/
	@Id
	@Column(name = "SRC_NO")
	@Generated(GenerationType.UUID)
	private String srcNo;
	/** 担保品编号 **/
	@Id
	@Column(name = "GUAR_NO")
	@Generated(GenerationType.UUID)
	private String guarNo;
	/** 担保合同编号 **/
	@Id
	@Column(name = "GUAR_CONT_NO")
	@Generated(GenerationType.UUID)
	private String guarContNo;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 保证人客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 保证人名称 **/
	@Column(name = "CUST_NM", unique = false, nullable = true, length = 200)
	private String custNm;
	
	/** 保证人类型代码 **/
	@Column(name = "CUST_TYPE_CD", unique = false, nullable = true, length = 20)
	private String custTypeCd;
	
	/** 证件类型代码 **/
	@Column(name = "CERT_TYPE_CD", unique = false, nullable = true, length = 20)
	private String certTypeCd;
	
	/** 证件号码 **/
	@Column(name = "CERT_NO", unique = false, nullable = true, length = 40)
	private String certNo;
	
	/** 币种代码 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 担保金额 **/
	@Column(name = "GUARANTEE_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal guaranteeAmt;
	
	/** 保证人贷款证号 **/
	@Column(name = "COM_LOAN_CARD", unique = false, nullable = true, length = 32)
	private String comLoanCard;
	
	/** 保证担保形式代码 **/
	@Column(name = "GUARANTEE_FORM_CD", unique = false, nullable = true, length = 5)
	private String guaranteeFormCd;
	
	/** 保证方式代码 **/
	@Column(name = "GUARANTEE_TYPE_CD", unique = false, nullable = true, length = 5)
	private String guaranteeTypeCd;
	
	/** 最高担保金额 **/
	@Column(name = "GUARANTEE_MAX_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal guaranteeMaxAmt;
	
	/** 已用保证限额 **/
	@Column(name = "RISKING_LIMIT_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal riskingLimitAmt;
	
	/** 对本行负债金额 **/
	@Column(name = "BCC_DEBT_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal bccDebtAmt;
	
	/** 有效期起始日 **/
	@Column(name = "START_DT", unique = false, nullable = true, length = 30)
	private String startDt;
	
	/** 有效期终止日 **/
	@Column(name = "END_DT", unique = false, nullable = true, length = 30)
	private String endDt;
	
	/** 互保标志代码 **/
	@Column(name = "GUARANTEE_MUTUAL_CD", unique = false, nullable = true, length = 1)
	private String guaranteeMutualCd;
	
	/** 有效标志 **/
	@Column(name = "VALID_IND", unique = false, nullable = true, length = 1)
	private String validInd;
	
	
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
	 * @param srcNo
	 */
	public void setSrcNo(String srcNo) {
		this.srcNo = srcNo == null ? null : srcNo.trim();
	}
	
    /**
     * @return SrcNo
     */	
	public String getSrcNo() {
		return this.srcNo;
	}
	
	/**
	 * @param guarNo
	 */
	public void setGuarNo(String guarNo) {
		this.guarNo = guarNo == null ? null : guarNo.trim();
	}
	
    /**
     * @return GuarNo
     */	
	public String getGuarNo() {
		return this.guarNo;
	}
	
	/**
	 * @param guarContNo
	 */
	public void setGuarContNo(String guarContNo) {
		this.guarContNo = guarContNo == null ? null : guarContNo.trim();
	}
	
    /**
     * @return GuarContNo
     */	
	public String getGuarContNo() {
		return this.guarContNo;
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
	 * @param certTypeCd
	 */
	public void setCertTypeCd(String certTypeCd) {
		this.certTypeCd = certTypeCd == null ? null : certTypeCd.trim();
	}
	
    /**
     * @return CertTypeCd
     */	
	public String getCertTypeCd() {
		return this.certTypeCd;
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
	 * @param guaranteeAmt
	 */
	public void setGuaranteeAmt(java.math.BigDecimal guaranteeAmt) {
		this.guaranteeAmt = guaranteeAmt;
	}
	
    /**
     * @return GuaranteeAmt
     */	
	public java.math.BigDecimal getGuaranteeAmt() {
		return this.guaranteeAmt;
	}
	
	/**
	 * @param comLoanCard
	 */
	public void setComLoanCard(String comLoanCard) {
		this.comLoanCard = comLoanCard == null ? null : comLoanCard.trim();
	}
	
    /**
     * @return ComLoanCard
     */	
	public String getComLoanCard() {
		return this.comLoanCard;
	}
	
	/**
	 * @param guaranteeFormCd
	 */
	public void setGuaranteeFormCd(String guaranteeFormCd) {
		this.guaranteeFormCd = guaranteeFormCd == null ? null : guaranteeFormCd.trim();
	}
	
    /**
     * @return GuaranteeFormCd
     */	
	public String getGuaranteeFormCd() {
		return this.guaranteeFormCd;
	}
	
	/**
	 * @param guaranteeTypeCd
	 */
	public void setGuaranteeTypeCd(String guaranteeTypeCd) {
		this.guaranteeTypeCd = guaranteeTypeCd == null ? null : guaranteeTypeCd.trim();
	}
	
    /**
     * @return GuaranteeTypeCd
     */	
	public String getGuaranteeTypeCd() {
		return this.guaranteeTypeCd;
	}
	
	/**
	 * @param guaranteeMaxAmt
	 */
	public void setGuaranteeMaxAmt(java.math.BigDecimal guaranteeMaxAmt) {
		this.guaranteeMaxAmt = guaranteeMaxAmt;
	}
	
    /**
     * @return GuaranteeMaxAmt
     */	
	public java.math.BigDecimal getGuaranteeMaxAmt() {
		return this.guaranteeMaxAmt;
	}
	
	/**
	 * @param riskingLimitAmt
	 */
	public void setRiskingLimitAmt(java.math.BigDecimal riskingLimitAmt) {
		this.riskingLimitAmt = riskingLimitAmt;
	}
	
    /**
     * @return RiskingLimitAmt
     */	
	public java.math.BigDecimal getRiskingLimitAmt() {
		return this.riskingLimitAmt;
	}
	
	/**
	 * @param bccDebtAmt
	 */
	public void setBccDebtAmt(java.math.BigDecimal bccDebtAmt) {
		this.bccDebtAmt = bccDebtAmt;
	}
	
    /**
     * @return BccDebtAmt
     */	
	public java.math.BigDecimal getBccDebtAmt() {
		return this.bccDebtAmt;
	}
	
	/**
	 * @param startDt
	 */
	public void setStartDt(String startDt) {
		this.startDt = startDt == null ? null : startDt.trim();
	}
	
    /**
     * @return StartDt
     */	
	public String getStartDt() {
		return this.startDt;
	}
	
	/**
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt == null ? null : endDt.trim();
	}
	
    /**
     * @return EndDt
     */	
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * @param guaranteeMutualCd
	 */
	public void setGuaranteeMutualCd(String guaranteeMutualCd) {
		this.guaranteeMutualCd = guaranteeMutualCd == null ? null : guaranteeMutualCd.trim();
	}
	
    /**
     * @return GuaranteeMutualCd
     */	
	public String getGuaranteeMutualCd() {
		return this.guaranteeMutualCd;
	}
	
	/**
	 * @param validInd
	 */
	public void setValidInd(String validInd) {
		this.validInd = validInd == null ? null : validInd.trim();
	}
	
    /**
     * @return ValidInd
     */	
	public String getValidInd() {
		return this.validInd;
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
        AcrmFagLoanGuarantee other = (AcrmFagLoanGuarantee) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getSrcNo() == null ? other.getSrcNo() == null : this.getSrcNo().equals(other.getSrcNo()))
        	&& (this.getGuarNo() == null ? other.getGuarNo() == null : this.getGuarNo().equals(other.getGuarNo()))
        	&& (this.getGuarContNo() == null ? other.getGuarContNo() == null : this.getGuarContNo().equals(other.getGuarContNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustNm() == null ? other.getCustNm() == null : this.getCustNm().equals(other.getCustNm()))
        	&& (this.getCustTypeCd() == null ? other.getCustTypeCd() == null : this.getCustTypeCd().equals(other.getCustTypeCd()))
        	&& (this.getCertTypeCd() == null ? other.getCertTypeCd() == null : this.getCertTypeCd().equals(other.getCertTypeCd()))
        	&& (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
                	&& (this.getComLoanCard() == null ? other.getComLoanCard() == null : this.getComLoanCard().equals(other.getComLoanCard()))
        	&& (this.getGuaranteeFormCd() == null ? other.getGuaranteeFormCd() == null : this.getGuaranteeFormCd().equals(other.getGuaranteeFormCd()))
        	&& (this.getGuaranteeTypeCd() == null ? other.getGuaranteeTypeCd() == null : this.getGuaranteeTypeCd().equals(other.getGuaranteeTypeCd()))
                                	&& (this.getStartDt() == null ? other.getStartDt() == null : this.getStartDt().equals(other.getStartDt()))
        	&& (this.getEndDt() == null ? other.getEndDt() == null : this.getEndDt().equals(other.getEndDt()))
        	&& (this.getGuaranteeMutualCd() == null ? other.getGuaranteeMutualCd() == null : this.getGuaranteeMutualCd().equals(other.getGuaranteeMutualCd()))
        	&& (this.getValidInd() == null ? other.getValidInd() == null : this.getValidInd().equals(other.getValidInd()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getSrcNo() == null) ? 0 : getSrcNo().hashCode());
        result = prime * result + ((getGuarNo() == null) ? 0 : getGuarNo().hashCode());
        result = prime * result + ((getGuarContNo() == null) ? 0 : getGuarContNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustNm() == null) ? 0 : getCustNm().hashCode());
        result = prime * result + ((getCustTypeCd() == null) ? 0 : getCustTypeCd().hashCode());
        result = prime * result + ((getCertTypeCd() == null) ? 0 : getCertTypeCd().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getComLoanCard() == null) ? 0 : getComLoanCard().hashCode());
        result = prime * result + ((getGuaranteeFormCd() == null) ? 0 : getGuaranteeFormCd().hashCode());
        result = prime * result + ((getGuaranteeTypeCd() == null) ? 0 : getGuaranteeTypeCd().hashCode());
        result = prime * result + ((getStartDt() == null) ? 0 : getStartDt().hashCode());
        result = prime * result + ((getEndDt() == null) ? 0 : getEndDt().hashCode());
        result = prime * result + ((getGuaranteeMutualCd() == null) ? 0 : getGuaranteeMutualCd().hashCode());
        result = prime * result + ((getValidInd() == null) ? 0 : getValidInd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append("]");
        return sb.toString();
    }
}