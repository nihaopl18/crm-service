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
 * @类名称: AcrmFarContriReport
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-15 11:55:53
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AR_CONTRI_REPORT")
public class AcrmFarContriReport extends BaseDomain implements Serializable{
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
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 主办机构编号 **/
	@Column(name = "BELONG_BRCH_NO", unique = false, nullable = true, length = 30)
	private String belongBrchNo;
	
	/** 主办机构名称 **/
	@Column(name = "BELONG_BRCH_NAME", unique = false, nullable = true, length = 200)
	private String belongBrchName;
	
	/** 主办一级支行编号 **/
	@Column(name = "BELONG_FIRG_BRCH_NO", unique = false, nullable = true, length = 30)
	private String belongFirgBrchNo;
	
	/** 主办一级支行名称 **/
	@Column(name = "BELONG_FIRG_BRCH_NAME", unique = false, nullable = true, length = 200)
	private String belongFirgBrchName;
	
	/** 客户类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 1)
	private String custType;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 本月存款贡献度 **/
	@Column(name = "M_DEP_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mdepContribu;
	
	/** 本月贷款贡献度 **/
	@Column(name = "M_LOAN_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mloanContribu;
	
	/** 本月中间业务贡献度 **/
	@Column(name = "M_MID_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mmidContribu;
	
	/** 本月综合贡献度 **/
	@Column(name = "M_SUM_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal msumContribu;
	
	/** 累计12个月存款贡献度 **/
	@Column(name = "DEP_12M_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dep12mContribu;
	
	/** 累计12个月贷款贡献度 **/
	@Column(name = "LOAN_12M_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loan12mContribu;
	
	/** 累计12个月中间业务贡献度 **/
	@Column(name = "MID_12M_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal mid12mContribu;
	
	/** 累计12个月综合贡献度 **/
	@Column(name = "SUM_12M_CONTRIBU", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal sum12mContribu;
	
	
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
	 * @param belongBrchNo
	 */
	public void setBelongBrchNo(String belongBrchNo) {
		this.belongBrchNo = belongBrchNo == null ? null : belongBrchNo.trim();
	}
	
    /**
     * @return BelongBrchNo
     */	
	public String getBelongBrchNo() {
		return this.belongBrchNo;
	}
	
	/**
	 * @param belongBrchName
	 */
	public void setBelongBrchName(String belongBrchName) {
		this.belongBrchName = belongBrchName == null ? null : belongBrchName.trim();
	}
	
    /**
     * @return BelongBrchName
     */	
	public String getBelongBrchName() {
		return this.belongBrchName;
	}
	
	/**
	 * @param belongFirgBrchNo
	 */
	public void setBelongFirgBrchNo(String belongFirgBrchNo) {
		this.belongFirgBrchNo = belongFirgBrchNo == null ? null : belongFirgBrchNo.trim();
	}
	
    /**
     * @return BelongFirgBrchNo
     */	
	public String getBelongFirgBrchNo() {
		return this.belongFirgBrchNo;
	}
	
	/**
	 * @param belongFirgBrchName
	 */
	public void setBelongFirgBrchName(String belongFirgBrchName) {
		this.belongFirgBrchName = belongFirgBrchName == null ? null : belongFirgBrchName.trim();
	}
	
    /**
     * @return BelongFirgBrchName
     */	
	public String getBelongFirgBrchName() {
		return this.belongFirgBrchName;
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
	 * @param mdepContribu
	 */
	public void setMdepContribu(java.math.BigDecimal mdepContribu) {
		this.mdepContribu = mdepContribu;
	}
	
    /**
     * @return MdepContribu
     */	
	public java.math.BigDecimal getMdepContribu() {
		return this.mdepContribu;
	}
	
	/**
	 * @param mloanContribu
	 */
	public void setMloanContribu(java.math.BigDecimal mloanContribu) {
		this.mloanContribu = mloanContribu;
	}
	
    /**
     * @return MloanContribu
     */	
	public java.math.BigDecimal getMloanContribu() {
		return this.mloanContribu;
	}
	
	/**
	 * @param mmidContribu
	 */
	public void setMmidContribu(java.math.BigDecimal mmidContribu) {
		this.mmidContribu = mmidContribu;
	}
	
    /**
     * @return MmidContribu
     */	
	public java.math.BigDecimal getMmidContribu() {
		return this.mmidContribu;
	}
	
	/**
	 * @param msumContribu
	 */
	public void setMsumContribu(java.math.BigDecimal msumContribu) {
		this.msumContribu = msumContribu;
	}
	
    /**
     * @return MsumContribu
     */	
	public java.math.BigDecimal getMsumContribu() {
		return this.msumContribu;
	}
	
	/**
	 * @param dep12mContribu
	 */
	public void setDep12mContribu(java.math.BigDecimal dep12mContribu) {
		this.dep12mContribu = dep12mContribu;
	}
	
    /**
     * @return Dep12mContribu
     */	
	public java.math.BigDecimal getDep12mContribu() {
		return this.dep12mContribu;
	}
	
	/**
	 * @param loan12mContribu
	 */
	public void setLoan12mContribu(java.math.BigDecimal loan12mContribu) {
		this.loan12mContribu = loan12mContribu;
	}
	
    /**
     * @return Loan12mContribu
     */	
	public java.math.BigDecimal getLoan12mContribu() {
		return this.loan12mContribu;
	}
	
	/**
	 * @param mid12mContribu
	 */
	public void setMid12mContribu(java.math.BigDecimal mid12mContribu) {
		this.mid12mContribu = mid12mContribu;
	}
	
    /**
     * @return Mid12mContribu
     */	
	public java.math.BigDecimal getMid12mContribu() {
		return this.mid12mContribu;
	}
	
	/**
	 * @param sum12mContribu
	 */
	public void setSum12mContribu(java.math.BigDecimal sum12mContribu) {
		this.sum12mContribu = sum12mContribu;
	}
	
    /**
     * @return Sum12mContribu
     */	
	public java.math.BigDecimal getSum12mContribu() {
		return this.sum12mContribu;
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
        AcrmFarContriReport other = (AcrmFarContriReport) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getBelongBrchNo() == null ? other.getBelongBrchNo() == null : this.getBelongBrchNo().equals(other.getBelongBrchNo()))
        	&& (this.getBelongBrchName() == null ? other.getBelongBrchName() == null : this.getBelongBrchName().equals(other.getBelongBrchName()))
        	&& (this.getBelongFirgBrchNo() == null ? other.getBelongFirgBrchNo() == null : this.getBelongFirgBrchNo().equals(other.getBelongFirgBrchNo()))
        	&& (this.getBelongFirgBrchName() == null ? other.getBelongFirgBrchName() == null : this.getBelongFirgBrchName().equals(other.getBelongFirgBrchName()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getBelongBrchNo() == null) ? 0 : getBelongBrchNo().hashCode());
        result = prime * result + ((getBelongBrchName() == null) ? 0 : getBelongBrchName().hashCode());
        result = prime * result + ((getBelongFirgBrchNo() == null) ? 0 : getBelongFirgBrchNo().hashCode());
        result = prime * result + ((getBelongFirgBrchName() == null) ? 0 : getBelongFirgBrchName().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
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
		sb.append(", belongBrchNo=").append(belongBrchNo);
		sb.append(", belongBrchName=").append(belongBrchName);
		sb.append(", belongFirgBrchNo=").append(belongFirgBrchNo);
		sb.append(", belongFirgBrchName=").append(belongFirgBrchName);
		sb.append(", custId=").append(custId);
		sb.append(", custType=").append(custType);
		sb.append(", custName=").append(custName);
		sb.append(", mdepContribu=").append(mdepContribu);
		sb.append(", mloanContribu=").append(mloanContribu);
		sb.append(", mmidContribu=").append(mmidContribu);
		sb.append(", msumContribu=").append(msumContribu);
		sb.append(", dep12mContribu=").append(dep12mContribu);
		sb.append(", loan12mContribu=").append(loan12mContribu);
		sb.append(", mid12mContribu=").append(mid12mContribu);
		sb.append(", sum12mContribu=").append(sum12mContribu);
        sb.append("]");
        return sb.toString();
    }
}