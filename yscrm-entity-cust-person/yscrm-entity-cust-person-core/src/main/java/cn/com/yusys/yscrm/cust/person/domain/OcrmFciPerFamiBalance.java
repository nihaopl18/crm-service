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
 * @类名称: OcrmFciPerFamiBalance
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-03-01 10:20:57
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_FAMI_BALANCE")
public class OcrmFciPerFamiBalance extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** ID主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期
 **/
	@Transient
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号
 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人
 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最近更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最近更新时间
 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 调查年份
 **/
	@Column(name = "SUR_YEAR", unique = false, nullable = true, length = 8)
	private String surYear;
	
	/** 家庭年收入(元)
 **/
	@Column(name = "YEAR_INCOME", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal yearIncome;
	
	/** 家庭年可支配收入
 **/
	@Column(name = "ANN_INCOME", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal annIncome;
	
	/** 家庭人数
 **/
	@Column(name = "POPU_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal popuNum;
	
	/** 其中劳动力人口
 **/
	@Column(name = "LABOR_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal laborNum;
	
	/** 家庭人均年收入
 **/
	@Column(name = "FAM_PER_INCOME", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal famPerIncome;
	
	/** 家庭年支出情况
 **/
	@Column(name = "FAM_EXPEN_DESC", unique = false, nullable = true, length = 200)
	private String famExpenDesc;
	
	/** 家庭年支出金额
 **/
	@Column(name = "FAM_EXPEN_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal famExpenAmt;
	
	/** 资产总额
 **/
	@Column(name = "ASSET_TOTAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal assetTotal;
	
	/** 负债总额
 **/
	@Column(name = "DEBT_TOTAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal debtTotal;
	
	/** 净资产
 **/
	@Column(name = "NET_ASSET", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal netAsset;
	
	/** 备注
 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	
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
	 * @param surYear
	 */
	public void setSurYear(String surYear) {
		this.surYear = surYear == null ? null : surYear.trim();
	}
	
    /**
     * @return SurYear
     */	
	public String getSurYear() {
		return this.surYear;
	}
	
	/**
	 * @param yearIncome
	 */
	public void setYearIncome(java.math.BigDecimal yearIncome) {
		this.yearIncome = yearIncome;
	}
	
    /**
     * @return YearIncome
     */	
	public java.math.BigDecimal getYearIncome() {
		return this.yearIncome;
	}
	
	/**
	 * @param annIncome
	 */
	public void setAnnIncome(java.math.BigDecimal annIncome) {
		this.annIncome = annIncome;
	}
	
    /**
     * @return AnnIncome
     */	
	public java.math.BigDecimal getAnnIncome() {
		return this.annIncome;
	}
	
	/**
	 * @param popuNum
	 */
	public void setPopuNum(java.math.BigDecimal popuNum) {
		this.popuNum = popuNum;
	}
	
    /**
     * @return PopuNum
     */	
	public java.math.BigDecimal getPopuNum() {
		return this.popuNum;
	}
	
	/**
	 * @param laborNum
	 */
	public void setLaborNum(java.math.BigDecimal laborNum) {
		this.laborNum = laborNum;
	}
	
    /**
     * @return LaborNum
     */	
	public java.math.BigDecimal getLaborNum() {
		return this.laborNum;
	}
	
	/**
	 * @param famPerIncome
	 */
	public void setFamPerIncome(java.math.BigDecimal famPerIncome) {
		this.famPerIncome = famPerIncome;
	}
	
    /**
     * @return FamPerIncome
     */	
	public java.math.BigDecimal getFamPerIncome() {
		return this.famPerIncome;
	}
	
	/**
	 * @param famExpenDesc
	 */
	public void setFamExpenDesc(String famExpenDesc) {
		this.famExpenDesc = famExpenDesc == null ? null : famExpenDesc.trim();
	}
	
    /**
     * @return FamExpenDesc
     */	
	public String getFamExpenDesc() {
		return this.famExpenDesc;
	}
	
	/**
	 * @param famExpenAmt
	 */
	public void setFamExpenAmt(java.math.BigDecimal famExpenAmt) {
		this.famExpenAmt = famExpenAmt;
	}
	
    /**
     * @return FamExpenAmt
     */	
	public java.math.BigDecimal getFamExpenAmt() {
		return this.famExpenAmt;
	}
	
	/**
	 * @param assetTotal
	 */
	public void setAssetTotal(java.math.BigDecimal assetTotal) {
		this.assetTotal = assetTotal;
	}
	
    /**
     * @return AssetTotal
     */	
	public java.math.BigDecimal getAssetTotal() {
		return this.assetTotal;
	}
	
	/**
	 * @param debtTotal
	 */
	public void setDebtTotal(java.math.BigDecimal debtTotal) {
		this.debtTotal = debtTotal;
	}
	
    /**
     * @return DebtTotal
     */	
	public java.math.BigDecimal getDebtTotal() {
		return this.debtTotal;
	}
	
	/**
	 * @param netAsset
	 */
	public void setNetAsset(java.math.BigDecimal netAsset) {
		this.netAsset = netAsset;
	}
	
    /**
     * @return NetAsset
     */	
	public java.math.BigDecimal getNetAsset() {
		return this.netAsset;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
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
        OcrmFciPerFamiBalance other = (OcrmFciPerFamiBalance) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getSurYear() == null ? other.getSurYear() == null : this.getSurYear().equals(other.getSurYear()))
                                                	&& (this.getFamExpenDesc() == null ? other.getFamExpenDesc() == null : this.getFamExpenDesc().equals(other.getFamExpenDesc()))
                                        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getSurYear() == null) ? 0 : getSurYear().hashCode());
        result = prime * result + ((getFamExpenDesc() == null) ? 0 : getFamExpenDesc().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", surYear=").append(surYear);
		sb.append(", yearIncome=").append(yearIncome);
		sb.append(", annIncome=").append(annIncome);
		sb.append(", popuNum=").append(popuNum);
		sb.append(", laborNum=").append(laborNum);
		sb.append(", famPerIncome=").append(famPerIncome);
		sb.append(", famExpenDesc=").append(famExpenDesc);
		sb.append(", famExpenAmt=").append(famExpenAmt);
		sb.append(", assetTotal=").append(assetTotal);
		sb.append(", debtTotal=").append(debtTotal);
		sb.append(", netAsset=").append(netAsset);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}