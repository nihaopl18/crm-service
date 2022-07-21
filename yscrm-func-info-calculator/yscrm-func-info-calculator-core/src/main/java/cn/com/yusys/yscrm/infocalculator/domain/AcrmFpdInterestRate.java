package cn.com.yusys.yscrm.infocalculator.domain;

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
 * @项目名称: yscrm-func-info-calculator-core模块
 * @类名称: AcrmFpdInterestRate
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-12 16:07:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_PD_INTEREST_RATE")
public class AcrmFpdInterestRate extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/**   法人    **/
	@Id
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/**   数据日期    **/
	@Transient
	@Column(name = "DATA_DT", unique = false, nullable = true, length = 7)
	private Date dataDt;
	
	/**   利率指标编号    **/
	@Column(name = "INT_RATE_NO", unique = false, nullable = true, length = 2)
	private String intRateNo;
	
	/**   子系统    **/
	@Column(name = "SUB_SYS_CD", unique = false, nullable = true, length = 3)
	private String subSysCd;
	
	/**   币种代码    **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/**   利率期限类型代码    **/
	@Column(name = "INT_RATE_TERM_TYPE_CD", unique = false, nullable = true, length = 1)
	private String intRateTermTypeCd;
	
	/** 	利率期限	  **/
	@Column(name = "INT_RATE_TERM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal intRateTerm;
	
	/** 	生效日期	  **/
	@Transient
	@Column(name = "EFF_DT", unique = false, nullable = true, length = 7)
	private Date effDt;
	
	/** 	利率值	  **/
	@Column(name = "INT_RATE_VAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal intRateVal;
	
	/** 	利率类型代码	  **/
	@Column(name = "INT_RATE_TYPE_CD", unique = false, nullable = true, length = 20)
	private String intRateTypeCd;
	
	/** 	上浮限额	  **/
	@Column(name = "UP_LMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal upLmt;
	
	/** 	下浮限额	  **/
	@Column(name = "DOWN_LMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal downLmt;
	
	/** 	上浮百分点限额	  **/
	@Column(name = "UP_PER_LMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal upPerLmt;
	
	/** 	下浮百分点限额	  **/
	@Column(name = "DOWN_PER_LMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal downPerLmt;
	
	/** 	利率说明	  **/
	@Column(name = "INT_RATE_DESC", unique = false, nullable = true, length = 80)
	private String intRateDesc;
	
	
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
	 * @param intRateNo
	 */
	public void setIntRateNo(String intRateNo) {
		this.intRateNo = intRateNo == null ? null : intRateNo.trim();
	}
	
    /**
     * @return IntRateNo
     */	
	public String getIntRateNo() {
		return this.intRateNo;
	}
	
	/**
	 * @param subSysCd
	 */
	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd == null ? null : subSysCd.trim();
	}
	
    /**
     * @return SubSysCd
     */	
	public String getSubSysCd() {
		return this.subSysCd;
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
	 * @param intRateTermTypeCd
	 */
	public void setIntRateTermTypeCd(String intRateTermTypeCd) {
		this.intRateTermTypeCd = intRateTermTypeCd == null ? null : intRateTermTypeCd.trim();
	}
	
    /**
     * @return IntRateTermTypeCd
     */	
	public String getIntRateTermTypeCd() {
		return this.intRateTermTypeCd;
	}
	
	/**
	 * @param intRateTerm
	 */
	public void setIntRateTerm(java.math.BigDecimal intRateTerm) {
		this.intRateTerm = intRateTerm;
	}
	
    /**
     * @return IntRateTerm
     */	
	public java.math.BigDecimal getIntRateTerm() {
		return this.intRateTerm;
	}
	
	/**
	 * @param effDt
	 */
	public void setEffDt(Date effDt) {
		this.effDt = effDt;
	}
	
    /**
     * @return EffDt
     */	
	public Date getEffDt() {
		return this.effDt;
	}
	
	/**
	 * @param intRateVal
	 */
	public void setIntRateVal(java.math.BigDecimal intRateVal) {
		this.intRateVal = intRateVal;
	}
	
    /**
     * @return IntRateVal
     */	
	public java.math.BigDecimal getIntRateVal() {
		return this.intRateVal;
	}
	
	/**
	 * @param intRateTypeCd
	 */
	public void setIntRateTypeCd(String intRateTypeCd) {
		this.intRateTypeCd = intRateTypeCd == null ? null : intRateTypeCd.trim();
	}
	
    /**
     * @return IntRateTypeCd
     */	
	public String getIntRateTypeCd() {
		return this.intRateTypeCd;
	}
	
	/**
	 * @param upLmt
	 */
	public void setUpLmt(java.math.BigDecimal upLmt) {
		this.upLmt = upLmt;
	}
	
    /**
     * @return UpLmt
     */	
	public java.math.BigDecimal getUpLmt() {
		return this.upLmt;
	}
	
	/**
	 * @param downLmt
	 */
	public void setDownLmt(java.math.BigDecimal downLmt) {
		this.downLmt = downLmt;
	}
	
    /**
     * @return DownLmt
     */	
	public java.math.BigDecimal getDownLmt() {
		return this.downLmt;
	}
	
	/**
	 * @param upPerLmt
	 */
	public void setUpPerLmt(java.math.BigDecimal upPerLmt) {
		this.upPerLmt = upPerLmt;
	}
	
    /**
     * @return UpPerLmt
     */	
	public java.math.BigDecimal getUpPerLmt() {
		return this.upPerLmt;
	}
	
	/**
	 * @param downPerLmt
	 */
	public void setDownPerLmt(java.math.BigDecimal downPerLmt) {
		this.downPerLmt = downPerLmt;
	}
	
    /**
     * @return DownPerLmt
     */	
	public java.math.BigDecimal getDownPerLmt() {
		return this.downPerLmt;
	}
	
	/**
	 * @param intRateDesc
	 */
	public void setIntRateDesc(String intRateDesc) {
		this.intRateDesc = intRateDesc == null ? null : intRateDesc.trim();
	}
	
    /**
     * @return IntRateDesc
     */	
	public String getIntRateDesc() {
		return this.intRateDesc;
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
        AcrmFpdInterestRate other = (AcrmFpdInterestRate) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getIntRateNo() == null ? other.getIntRateNo() == null : this.getIntRateNo().equals(other.getIntRateNo()))
        	&& (this.getSubSysCd() == null ? other.getSubSysCd() == null : this.getSubSysCd().equals(other.getSubSysCd()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
        	&& (this.getIntRateTermTypeCd() == null ? other.getIntRateTermTypeCd() == null : this.getIntRateTermTypeCd().equals(other.getIntRateTermTypeCd()))
                                	&& (this.getIntRateTypeCd() == null ? other.getIntRateTypeCd() == null : this.getIntRateTypeCd().equals(other.getIntRateTypeCd()))
                                        	&& (this.getIntRateDesc() == null ? other.getIntRateDesc() == null : this.getIntRateDesc().equals(other.getIntRateDesc()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getIntRateNo() == null) ? 0 : getIntRateNo().hashCode());
        result = prime * result + ((getSubSysCd() == null) ? 0 : getSubSysCd().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getIntRateTermTypeCd() == null) ? 0 : getIntRateTermTypeCd().hashCode());
        result = prime * result + ((getIntRateTypeCd() == null) ? 0 : getIntRateTypeCd().hashCode());
        result = prime * result + ((getIntRateDesc() == null) ? 0 : getIntRateDesc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", dataDt=").append(dataDt);
		sb.append(", intRateNo=").append(intRateNo);
		sb.append(", subSysCd=").append(subSysCd);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", intRateTermTypeCd=").append(intRateTermTypeCd);
		sb.append(", intRateTerm=").append(intRateTerm);
		sb.append(", effDt=").append(effDt);
		sb.append(", intRateVal=").append(intRateVal);
		sb.append(", intRateTypeCd=").append(intRateTypeCd);
		sb.append(", upLmt=").append(upLmt);
		sb.append(", downLmt=").append(downLmt);
		sb.append(", upPerLmt=").append(upPerLmt);
		sb.append(", downPerLmt=").append(downPerLmt);
		sb.append(", intRateDesc=").append(intRateDesc);
        sb.append("]");
        return sb.toString();
    }
}