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
 * @类名称: OcrmFciPerFinanceInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 22:56:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_FINANCE_INFO")
public class OcrmFciPerFinanceInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** ID主键
 **/
	@Id
	@Column(name = "ID", unique = false, nullable = true, length = 32)
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
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 退休计划
 **/
	@Column(name = "PETIRE_PLAN", unique = false, nullable = true, length = 200)
	private String petirePlan;
	
	/** 购房计划
 **/
	@Column(name = "HOUSE_PUR_PLAN", unique = false, nullable = true, length = 200)
	private String housePurPlan;
	
	/** 子女教育计划
 **/
	@Column(name = "CHILD_EDU_PLAN", unique = false, nullable = true, length = 200)
	private String childEduPlan;
	
	/** 资产总值(不含房产)
 **/
	@Column(name = "ASSET_TOTAL_VAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal assetTotalVal;
	
	/** 国内金融信息(他行)
 **/
	@Column(name = "INTERN_FIN_INFO", unique = false, nullable = true, length = 200)
	private String internFinInfo;
	
	/** 是否按揭
 **/
	@Column(name = "MORTGAGE_FLG", unique = false, nullable = true, length = 30)
	private String mortgageFlg;
	
	/** 房产信息
 **/
	@Column(name = "HOUSE_INFO", unique = false, nullable = true, length = 200)
	private String houseInfo;
	
	/** 海外资产情况
 **/
	@Column(name = "OVERS_ASSET", unique = false, nullable = true, length = 200)
	private String oversAsset;
	
	
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
	 * @param petirePlan
	 */
	public void setPetirePlan(String petirePlan) {
		this.petirePlan = petirePlan == null ? null : petirePlan.trim();
	}
	
    /**
     * @return PetirePlan
     */	
	public String getPetirePlan() {
		return this.petirePlan;
	}
	
	/**
	 * @param housePurPlan
	 */
	public void setHousePurPlan(String housePurPlan) {
		this.housePurPlan = housePurPlan == null ? null : housePurPlan.trim();
	}
	
    /**
     * @return HousePurPlan
     */	
	public String getHousePurPlan() {
		return this.housePurPlan;
	}
	
	/**
	 * @param childEduPlan
	 */
	public void setChildEduPlan(String childEduPlan) {
		this.childEduPlan = childEduPlan == null ? null : childEduPlan.trim();
	}
	
    /**
     * @return ChildEduPlan
     */	
	public String getChildEduPlan() {
		return this.childEduPlan;
	}
	
	/**
	 * @param assetTotalVal
	 */
	public void setAssetTotalVal(java.math.BigDecimal assetTotalVal) {
		this.assetTotalVal = assetTotalVal;
	}
	
    /**
     * @return AssetTotalVal
     */	
	public java.math.BigDecimal getAssetTotalVal() {
		return this.assetTotalVal;
	}
	
	/**
	 * @param internFinInfo
	 */
	public void setInternFinInfo(String internFinInfo) {
		this.internFinInfo = internFinInfo == null ? null : internFinInfo.trim();
	}
	
    /**
     * @return InternFinInfo
     */	
	public String getInternFinInfo() {
		return this.internFinInfo;
	}
	
	/**
	 * @param mortgageFlg
	 */
	public void setMortgageFlg(String mortgageFlg) {
		this.mortgageFlg = mortgageFlg == null ? null : mortgageFlg.trim();
	}
	
    /**
     * @return MortgageFlg
     */	
	public String getMortgageFlg() {
		return this.mortgageFlg;
	}
	
	/**
	 * @param houseInfo
	 */
	public void setHouseInfo(String houseInfo) {
		this.houseInfo = houseInfo == null ? null : houseInfo.trim();
	}
	
    /**
     * @return HouseInfo
     */	
	public String getHouseInfo() {
		return this.houseInfo;
	}
	
	/**
	 * @param oversAsset
	 */
	public void setOversAsset(String oversAsset) {
		this.oversAsset = oversAsset == null ? null : oversAsset.trim();
	}
	
    /**
     * @return OversAsset
     */	
	public String getOversAsset() {
		return this.oversAsset;
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
        OcrmFciPerFinanceInfo other = (OcrmFciPerFinanceInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getPetirePlan() == null ? other.getPetirePlan() == null : this.getPetirePlan().equals(other.getPetirePlan()))
        	&& (this.getHousePurPlan() == null ? other.getHousePurPlan() == null : this.getHousePurPlan().equals(other.getHousePurPlan()))
        	&& (this.getChildEduPlan() == null ? other.getChildEduPlan() == null : this.getChildEduPlan().equals(other.getChildEduPlan()))
                	&& (this.getInternFinInfo() == null ? other.getInternFinInfo() == null : this.getInternFinInfo().equals(other.getInternFinInfo()))
        	&& (this.getMortgageFlg() == null ? other.getMortgageFlg() == null : this.getMortgageFlg().equals(other.getMortgageFlg()))
        	&& (this.getHouseInfo() == null ? other.getHouseInfo() == null : this.getHouseInfo().equals(other.getHouseInfo()))
        	&& (this.getOversAsset() == null ? other.getOversAsset() == null : this.getOversAsset().equals(other.getOversAsset()))
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
        result = prime * result + ((getPetirePlan() == null) ? 0 : getPetirePlan().hashCode());
        result = prime * result + ((getHousePurPlan() == null) ? 0 : getHousePurPlan().hashCode());
        result = prime * result + ((getChildEduPlan() == null) ? 0 : getChildEduPlan().hashCode());
        result = prime * result + ((getInternFinInfo() == null) ? 0 : getInternFinInfo().hashCode());
        result = prime * result + ((getMortgageFlg() == null) ? 0 : getMortgageFlg().hashCode());
        result = prime * result + ((getHouseInfo() == null) ? 0 : getHouseInfo().hashCode());
        result = prime * result + ((getOversAsset() == null) ? 0 : getOversAsset().hashCode());
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
		sb.append(", petirePlan=").append(petirePlan);
		sb.append(", housePurPlan=").append(housePurPlan);
		sb.append(", childEduPlan=").append(childEduPlan);
		sb.append(", assetTotalVal=").append(assetTotalVal);
		sb.append(", internFinInfo=").append(internFinInfo);
		sb.append(", mortgageFlg=").append(mortgageFlg);
		sb.append(", houseInfo=").append(houseInfo);
		sb.append(", oversAsset=").append(oversAsset);
        sb.append("]");
        return sb.toString();
    }
}