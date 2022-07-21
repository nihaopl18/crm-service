package cn.com.yusys.yscrm.cust.person.domain;

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
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPerInsurInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-03-01 10:22:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_INSUR_INFO")
public class OcrmFciPerInsurInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期 **/
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最近更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最近更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户标识 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 保险编号 **/
	@Column(name = "INSUR_NO", unique = false, nullable = true, length = 40)
	private String insurNo;
	
	/** 保险名称(险种) **/
	@Column(name = "INSUR_NAME", unique = false, nullable = true, length = 200)
	private String insurName;
	
	/** 保险公司 **/
	@Column(name = "INSUR_COM", unique = false, nullable = true, length = 200)
	private String insurCom;
	
	/** 保险种类 **/
	@Column(name = "INSUR_TYPE", unique = false, nullable = true, length = 60)
	private String insurType;
	
	/** 投保人 **/
	@Column(name = "INSURED", unique = false, nullable = true, length = 200)
	private String insured;
	
	/** 受益人 **/
	@Column(name = "BFCY_MAN", unique = false, nullable = true, length = 200)
	private String bfcyMan;
	
	/** 保险标的 **/
	@Column(name = "INSUR_TAR", unique = false, nullable = true, length = 200)
	private String insurTar;
	
	/** 保单现有价值元 **/
	@Column(name = "INSUR_VAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal insurVal;
	
	/** 已缴保费元 **/
	@Column(name = "INSUR_FEE", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal insurFee;
	
	/** 应缴保费总额元 **/
	@Column(name = "INSUR_TOT_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal insurTotAmt;
	
	/** 投保日期 **/
	@Column(name = "INSUR_START_DATE", unique = false, nullable = true, length = 8)
	private String insurStartDate;
	
	/** 到期日期 **/
	@Column(name = "INSUR_END_DATE", unique = false, nullable = true, length = 8)
	private String insurEndDate;
	
	/** 保险金额 **/
	@Column(name = "INSUR_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal insurAmt;
	
	/** 抵押状况 **/
	@Column(name = "MORTGAGE_STAT", unique = false, nullable = true, length = 30)
	private String mortgageStat;
	
	/** 备注 **/
	@Column(name = "REMARKS", unique = false, nullable = true, length = 400)
	private String remarks;
	
	
	
	
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
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param cratOrgId
	 */
	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId == null ? null : cratOrgId.trim();
	}
	
    /**
     * @return CratOrgId
     */	
	public String getCratOrgId() {
		return this.cratOrgId;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr == null ? null : cratUsr.trim();
	}
	
    /**
     * @return CratUsr
     */	
	public String getCratUsr() {
		return this.cratUsr;
	}
	
	/**
	 * @param lastChgSys
	 */
	public void setLastChgSys(String lastChgSys) {
		this.lastChgSys = lastChgSys == null ? null : lastChgSys.trim();
	}
	
    /**
     * @return LastChgSys
     */	
	public String getLastChgSys() {
		return this.lastChgSys;
	}
	
	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}
	
    /**
     * @return LastChgUsr
     */	
	public String getLastChgUsr() {
		return this.lastChgUsr;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
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
	 * @param insurNo
	 */
	public void setInsurNo(String insurNo) {
		this.insurNo = insurNo == null ? null : insurNo.trim();
	}
	
    /**
     * @return InsurNo
     */	
	public String getInsurNo() {
		return this.insurNo;
	}
	
	/**
	 * @param insurName
	 */
	public void setInsurName(String insurName) {
		this.insurName = insurName == null ? null : insurName.trim();
	}
	
    /**
     * @return InsurName
     */	
	public String getInsurName() {
		return this.insurName;
	}
	
	/**
	 * @param insurCom
	 */
	public void setInsurCom(String insurCom) {
		this.insurCom = insurCom == null ? null : insurCom.trim();
	}
	
    /**
     * @return InsurCom
     */	
	public String getInsurCom() {
		return this.insurCom;
	}
	
	/**
	 * @param insurType
	 */
	public void setInsurType(String insurType) {
		this.insurType = insurType == null ? null : insurType.trim();
	}
	
    /**
     * @return InsurType
     */	
	public String getInsurType() {
		return this.insurType;
	}
	
	/**
	 * @param insured
	 */
	public void setInsured(String insured) {
		this.insured = insured == null ? null : insured.trim();
	}
	
    /**
     * @return Insured
     */	
	public String getInsured() {
		return this.insured;
	}
	
	/**
	 * @param bfcyMan
	 */
	public void setBfcyMan(String bfcyMan) {
		this.bfcyMan = bfcyMan == null ? null : bfcyMan.trim();
	}
	
    /**
     * @return BfcyMan
     */	
	public String getBfcyMan() {
		return this.bfcyMan;
	}
	
	/**
	 * @param insurTar
	 */
	public void setInsurTar(String insurTar) {
		this.insurTar = insurTar == null ? null : insurTar.trim();
	}
	
    /**
     * @return InsurTar
     */	
	public String getInsurTar() {
		return this.insurTar;
	}
	
	/**
	 * @param insurVal
	 */
	public void setInsurVal(java.math.BigDecimal insurVal) {
		this.insurVal = insurVal;
	}
	
    /**
     * @return InsurVal
     */	
	public java.math.BigDecimal getInsurVal() {
		return this.insurVal;
	}
	
	/**
	 * @param insurFee
	 */
	public void setInsurFee(java.math.BigDecimal insurFee) {
		this.insurFee = insurFee;
	}
	
    /**
     * @return InsurFee
     */	
	public java.math.BigDecimal getInsurFee() {
		return this.insurFee;
	}
	
	/**
	 * @param insurTotAmt
	 */
	public void setInsurTotAmt(java.math.BigDecimal insurTotAmt) {
		this.insurTotAmt = insurTotAmt;
	}
	
    /**
     * @return InsurTotAmt
     */	
	public java.math.BigDecimal getInsurTotAmt() {
		return this.insurTotAmt;
	}
	
	/**
	 * @param insurStartDate
	 */
	public void setInsurStartDate(String insurStartDate) {
		this.insurStartDate = insurStartDate == null ? null : insurStartDate.trim();
	}
	
    /**
     * @return InsurStartDate
     */	
	public String getInsurStartDate() {
		return this.insurStartDate;
	}
	
	/**
	 * @param insurEndDate
	 */
	public void setInsurEndDate(String insurEndDate) {
		this.insurEndDate = insurEndDate == null ? null : insurEndDate.trim();
	}
	
    /**
     * @return InsurEndDate
     */	
	public String getInsurEndDate() {
		return this.insurEndDate;
	}
	
	/**
	 * @param insurAmt
	 */
	public void setInsurAmt(java.math.BigDecimal insurAmt) {
		this.insurAmt = insurAmt;
	}
	
    /**
     * @return InsurAmt
     */	
	public java.math.BigDecimal getInsurAmt() {
		return this.insurAmt;
	}
	
	/**
	 * @param mortgageStat
	 */
	public void setMortgageStat(String mortgageStat) {
		this.mortgageStat = mortgageStat == null ? null : mortgageStat.trim();
	}
	
    /**
     * @return MortgageStat
     */	
	public String getMortgageStat() {
		return this.mortgageStat;
	}
	
	/**
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}
	
    /**
     * @return Remarks
     */	
	public String getRemarks() {
		return this.remarks;
	}
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
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
        OcrmFciPerInsurInfo other = (OcrmFciPerInsurInfo) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getInsurNo() == null ? other.getInsurNo() == null : this.getInsurNo().equals(other.getInsurNo()))
        	&& (this.getInsurName() == null ? other.getInsurName() == null : this.getInsurName().equals(other.getInsurName()))
        	&& (this.getInsurCom() == null ? other.getInsurCom() == null : this.getInsurCom().equals(other.getInsurCom()))
        	&& (this.getInsurType() == null ? other.getInsurType() == null : this.getInsurType().equals(other.getInsurType()))
        	&& (this.getInsured() == null ? other.getInsured() == null : this.getInsured().equals(other.getInsured()))
        	&& (this.getBfcyMan() == null ? other.getBfcyMan() == null : this.getBfcyMan().equals(other.getBfcyMan()))
        	&& (this.getInsurTar() == null ? other.getInsurTar() == null : this.getInsurTar().equals(other.getInsurTar()))
                                	&& (this.getInsurStartDate() == null ? other.getInsurStartDate() == null : this.getInsurStartDate().equals(other.getInsurStartDate()))
        	&& (this.getInsurEndDate() == null ? other.getInsurEndDate() == null : this.getInsurEndDate().equals(other.getInsurEndDate()))
                	&& (this.getMortgageStat() == null ? other.getMortgageStat() == null : this.getMortgageStat().equals(other.getMortgageStat()))
        	&& (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getInsurNo() == null) ? 0 : getInsurNo().hashCode());
        result = prime * result + ((getInsurName() == null) ? 0 : getInsurName().hashCode());
        result = prime * result + ((getInsurCom() == null) ? 0 : getInsurCom().hashCode());
        result = prime * result + ((getInsurType() == null) ? 0 : getInsurType().hashCode());
        result = prime * result + ((getInsured() == null) ? 0 : getInsured().hashCode());
        result = prime * result + ((getBfcyMan() == null) ? 0 : getBfcyMan().hashCode());
        result = prime * result + ((getInsurTar() == null) ? 0 : getInsurTar().hashCode());
        result = prime * result + ((getInsurStartDate() == null) ? 0 : getInsurStartDate().hashCode());
        result = prime * result + ((getInsurEndDate() == null) ? 0 : getInsurEndDate().hashCode());
        result = prime * result + ((getMortgageStat() == null) ? 0 : getMortgageStat().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", insurNo=").append(insurNo);
		sb.append(", insurName=").append(insurName);
		sb.append(", insurCom=").append(insurCom);
		sb.append(", insurType=").append(insurType);
		sb.append(", insured=").append(insured);
		sb.append(", bfcyMan=").append(bfcyMan);
		sb.append(", insurTar=").append(insurTar);
		sb.append(", insurVal=").append(insurVal);
		sb.append(", insurFee=").append(insurFee);
		sb.append(", insurTotAmt=").append(insurTotAmt);
		sb.append(", insurStartDate=").append(insurStartDate);
		sb.append(", insurEndDate=").append(insurEndDate);
		sb.append(", insurAmt=").append(insurAmt);
		sb.append(", mortgageStat=").append(mortgageStat);
		sb.append(", remarks=").append(remarks);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}