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
 * @类名称: OcrmFciPerAssetInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-03-01 10:21:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_ASSET_INFO")
public class OcrmFciPerAssetInfo extends BaseDomain implements Serializable{
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
	
	/** 资产编号
 **/
	@Column(name = "ASS_ID", unique = false, nullable = true, length = 20)
	private String assId;
	
	/** 资产名称
 **/
	@Column(name = "ASSET_NAME", unique = false, nullable = true, length = 200)
	private String assetName;
	
	/** 资产单位
 **/
	@Column(name = "ASSET_UNIT", unique = false, nullable = true, length = 60)
	private String assetUnit;
	
	/** 资产数量
 **/
	@Column(name = "ASSET_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal assetNum;
	
	/** 资产估价
 **/
	@Column(name = "ASSET_EVAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal assetEval;
	
	/** 估价日期(手工维护)
 **/
	@Column(name = "EVAL_DATE", unique = false, nullable = true, length = 40)
	private String evalDate;
	
	/** 资产购置日期(手工维护)
 **/
	@Column(name = "ASSET_PUR_DATE", unique = false, nullable = true, length = 40)
	private String assetPurDate;
	
	/** 资产购置原价(手工维护)
 **/
	@Column(name = "ASSET_PUR_PRICE", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal assetPurPrice;
	
	/** 资产描述
 **/
	@Column(name = "ASSET_DESC", unique = false, nullable = true, length = 200)
	private String assetDesc;
	
	/** 抵押状况
 **/
	@Column(name = "MORTGAGE_STAT", unique = false, nullable = true, length = 30)
	private String mortgageStat;
	
	/** 备注
 **/
	@Column(name = "REMARKS", unique = false, nullable = true, length = 200)
	private String remarks;
	
	
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
	 * @param assId
	 */
	public void setAssId(String assId) {
		this.assId = assId == null ? null : assId.trim();
	}
	
    /**
     * @return AssId
     */	
	public String getAssId() {
		return this.assId;
	}
	
	/**
	 * @param assetName
	 */
	public void setAssetName(String assetName) {
		this.assetName = assetName == null ? null : assetName.trim();
	}
	
    /**
     * @return AssetName
     */	
	public String getAssetName() {
		return this.assetName;
	}
	
	/**
	 * @param assetUnit
	 */
	public void setAssetUnit(String assetUnit) {
		this.assetUnit = assetUnit == null ? null : assetUnit.trim();
	}
	
    /**
     * @return AssetUnit
     */	
	public String getAssetUnit() {
		return this.assetUnit;
	}
	
	/**
	 * @param assetNum
	 */
	public void setAssetNum(java.math.BigDecimal assetNum) {
		this.assetNum = assetNum;
	}
	
    /**
     * @return AssetNum
     */	
	public java.math.BigDecimal getAssetNum() {
		return this.assetNum;
	}
	
	/**
	 * @param assetEval
	 */
	public void setAssetEval(java.math.BigDecimal assetEval) {
		this.assetEval = assetEval;
	}
	
    /**
     * @return AssetEval
     */	
	public java.math.BigDecimal getAssetEval() {
		return this.assetEval;
	}
	
	/**
	 * @param evalDate
	 */
	public void setEvalDate(String evalDate) {
		this.evalDate = evalDate == null ? null : evalDate.trim();
	}
	
    /**
     * @return EvalDate
     */	
	public String getEvalDate() {
		return this.evalDate;
	}
	
	/**
	 * @param assetPurDate
	 */
	public void setAssetPurDate(String assetPurDate) {
		this.assetPurDate = assetPurDate == null ? null : assetPurDate.trim();
	}
	
    /**
     * @return AssetPurDate
     */	
	public String getAssetPurDate() {
		return this.assetPurDate;
	}
	
	/**
	 * @param assetPurPrice
	 */
	public void setAssetPurPrice(java.math.BigDecimal assetPurPrice) {
		this.assetPurPrice = assetPurPrice;
	}
	
    /**
     * @return AssetPurPrice
     */	
	public java.math.BigDecimal getAssetPurPrice() {
		return this.assetPurPrice;
	}
	
	/**
	 * @param assetDesc
	 */
	public void setAssetDesc(String assetDesc) {
		this.assetDesc = assetDesc == null ? null : assetDesc.trim();
	}
	
    /**
     * @return AssetDesc
     */	
	public String getAssetDesc() {
		return this.assetDesc;
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
        OcrmFciPerAssetInfo other = (OcrmFciPerAssetInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getAssId() == null ? other.getAssId() == null : this.getAssId().equals(other.getAssId()))
        	&& (this.getAssetName() == null ? other.getAssetName() == null : this.getAssetName().equals(other.getAssetName()))
        	&& (this.getAssetUnit() == null ? other.getAssetUnit() == null : this.getAssetUnit().equals(other.getAssetUnit()))
                        	&& (this.getEvalDate() == null ? other.getEvalDate() == null : this.getEvalDate().equals(other.getEvalDate()))
        	&& (this.getAssetPurDate() == null ? other.getAssetPurDate() == null : this.getAssetPurDate().equals(other.getAssetPurDate()))
                	&& (this.getAssetDesc() == null ? other.getAssetDesc() == null : this.getAssetDesc().equals(other.getAssetDesc()))
        	&& (this.getMortgageStat() == null ? other.getMortgageStat() == null : this.getMortgageStat().equals(other.getMortgageStat()))
        	&& (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
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
        result = prime * result + ((getAssId() == null) ? 0 : getAssId().hashCode());
        result = prime * result + ((getAssetName() == null) ? 0 : getAssetName().hashCode());
        result = prime * result + ((getAssetUnit() == null) ? 0 : getAssetUnit().hashCode());
        result = prime * result + ((getEvalDate() == null) ? 0 : getEvalDate().hashCode());
        result = prime * result + ((getAssetPurDate() == null) ? 0 : getAssetPurDate().hashCode());
        result = prime * result + ((getAssetDesc() == null) ? 0 : getAssetDesc().hashCode());
        result = prime * result + ((getMortgageStat() == null) ? 0 : getMortgageStat().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
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
		sb.append(", assId=").append(assId);
		sb.append(", assetName=").append(assetName);
		sb.append(", assetUnit=").append(assetUnit);
		sb.append(", assetNum=").append(assetNum);
		sb.append(", assetEval=").append(assetEval);
		sb.append(", evalDate=").append(evalDate);
		sb.append(", assetPurDate=").append(assetPurDate);
		sb.append(", assetPurPrice=").append(assetPurPrice);
		sb.append(", assetDesc=").append(assetDesc);
		sb.append(", mortgageStat=").append(mortgageStat);
		sb.append(", remarks=").append(remarks);
        sb.append("]");
        return sb.toString();
    }
}