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
 * @类名称: OcrmFciPerFarmerProd
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-03-01 10:23:49
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_FARMER_PROD")
public class OcrmFciPerFarmerProd extends BaseDomain implements Serializable{
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
	
	/** 登记流水号 **/
	@Column(name = "REG_SEQ_NO", unique = false, nullable = true, length = 80)
	private String regSeqNo;
	
	/** 调查年份 **/
	@Column(name = "SUR_YEAR", unique = false, nullable = true, length = 8)
	private String surYear;
	
	/** 生产经营类型 **/
	@Column(name = "PROD_BUSI_TYPE", unique = false, nullable = true, length = 30)
	private String prodBusiType;
	
	/** 生产经营项目名称 **/
	@Column(name = "PROD_BUSI_NAME", unique = false, nullable = true, length = 200)
	private String prodBusiName;
	
	/** 单位 **/
	@Column(name = "UNITS", unique = false, nullable = true, length = 300)
	private String units;
	
	/** 数量 **/
	@Column(name = "NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal num;
	
	/** 年收入 **/
	@Column(name = "INCOME_Y", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal incomeY;
	
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
	 * @param regSeqNo
	 */
	public void setRegSeqNo(String regSeqNo) {
		this.regSeqNo = regSeqNo == null ? null : regSeqNo.trim();
	}
	
    /**
     * @return RegSeqNo
     */	
	public String getRegSeqNo() {
		return this.regSeqNo;
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
	 * @param prodBusiType
	 */
	public void setProdBusiType(String prodBusiType) {
		this.prodBusiType = prodBusiType == null ? null : prodBusiType.trim();
	}
	
    /**
     * @return ProdBusiType
     */	
	public String getProdBusiType() {
		return this.prodBusiType;
	}
	
	/**
	 * @param prodBusiName
	 */
	public void setProdBusiName(String prodBusiName) {
		this.prodBusiName = prodBusiName == null ? null : prodBusiName.trim();
	}
	
    /**
     * @return ProdBusiName
     */	
	public String getProdBusiName() {
		return this.prodBusiName;
	}
	
	/**
	 * @param units
	 */
	public void setUnits(String units) {
		this.units = units == null ? null : units.trim();
	}
	
    /**
     * @return Units
     */	
	public String getUnits() {
		return this.units;
	}
	
	/**
	 * @param num
	 */
	public void setNum(java.math.BigDecimal num) {
		this.num = num;
	}
	
    /**
     * @return Num
     */	
	public java.math.BigDecimal getNum() {
		return this.num;
	}
	
	/**
	 * @param incomeY
	 */
	public void setIncomeY(java.math.BigDecimal incomeY) {
		this.incomeY = incomeY;
	}
	
    /**
     * @return IncomeY
     */	
	public java.math.BigDecimal getIncomeY() {
		return this.incomeY;
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
        OcrmFciPerFarmerProd other = (OcrmFciPerFarmerProd) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getRegSeqNo() == null ? other.getRegSeqNo() == null : this.getRegSeqNo().equals(other.getRegSeqNo()))
        	&& (this.getSurYear() == null ? other.getSurYear() == null : this.getSurYear().equals(other.getSurYear()))
        	&& (this.getProdBusiType() == null ? other.getProdBusiType() == null : this.getProdBusiType().equals(other.getProdBusiType()))
        	&& (this.getProdBusiName() == null ? other.getProdBusiName() == null : this.getProdBusiName().equals(other.getProdBusiName()))
        	&& (this.getUnits() == null ? other.getUnits() == null : this.getUnits().equals(other.getUnits()))
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
        result = prime * result + ((getRegSeqNo() == null) ? 0 : getRegSeqNo().hashCode());
        result = prime * result + ((getSurYear() == null) ? 0 : getSurYear().hashCode());
        result = prime * result + ((getProdBusiType() == null) ? 0 : getProdBusiType().hashCode());
        result = prime * result + ((getProdBusiName() == null) ? 0 : getProdBusiName().hashCode());
        result = prime * result + ((getUnits() == null) ? 0 : getUnits().hashCode());
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
		sb.append(", regSeqNo=").append(regSeqNo);
		sb.append(", surYear=").append(surYear);
		sb.append(", prodBusiType=").append(prodBusiType);
		sb.append(", prodBusiName=").append(prodBusiName);
		sb.append(", units=").append(units);
		sb.append(", num=").append(num);
		sb.append(", incomeY=").append(incomeY);
		sb.append(", remarks=").append(remarks);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}