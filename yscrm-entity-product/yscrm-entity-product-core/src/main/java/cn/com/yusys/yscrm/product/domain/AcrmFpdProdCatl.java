package cn.com.yusys.yscrm.product.domain;

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
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: AcrmFpdProdCatl
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-26 10:25:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_PD_PROD_CATL")
public class AcrmFpdProdCatl extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE")
	private String corpOrgCode;
	/** 产品类别编号 **/
	@Id
	@Column(name = "CATL_CODE")
	@Generated(GenerationType.UUID)
	private String catlCode;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 最新更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Transient
	@Column(name = "LAST_CHG_TM", unique = false, nullable = true, length = 7)
	private Date lastChgTm;
	
	/** 产品类别名称 **/
	@Column(name = "CATL_NAME", unique = false, nullable = true, length = 100)
	private String catlName;
	
	/** 上级类别编号 **/
	@Column(name = "CATL_PARENT", unique = false, nullable = true, length = 32)
	private String catlParent;
	
	/** 上级类别名称 **/
	@Column(name = "CATL_PARENT_NM", unique = false, nullable = true, length = 100)
	private String catlParentNm;
	
	/** 节点级别 **/
	@Column(name = "CATL_LEVEL", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal catlLevel;
	
	/** 节点顺序 **/
	@Column(name = "CATL_ORDER", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal catlOrder;
	
	/** 归属机构ID **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 32)
	private String orgId;
	
	/** 产品展示方案 **/
	@Column(name = "DISPLAY_SCHEME", unique = false, nullable = true, length = 32)
	private String displayScheme;
	
	
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
	 * @param lastChgTm
	 */
	public void setLastChgTm(Date lastChgTm) {
		this.lastChgTm = lastChgTm;
	}
	
    /**
     * @return LastChgTm
     */	
	public Date getLastChgTm() {
		return this.lastChgTm;
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
	 * @param catlCode
	 */
	public void setCatlCode(String catlCode) {
		this.catlCode = catlCode == null ? null : catlCode.trim();
	}
	
    /**
     * @return CatlCode
     */	
	public String getCatlCode() {
		return this.catlCode;
	}
	
	/**
	 * @param catlName
	 */
	public void setCatlName(String catlName) {
		this.catlName = catlName == null ? null : catlName.trim();
	}
	
    /**
     * @return CatlName
     */	
	public String getCatlName() {
		return this.catlName;
	}
	
	/**
	 * @param catlParent
	 */
	public void setCatlParent(String catlParent) {
		this.catlParent = catlParent == null ? null : catlParent.trim();
	}
	
    /**
     * @return CatlParent
     */	
	public String getCatlParent() {
		return this.catlParent;
	}
	
	/**
	 * @param catlParentNm
	 */
	public void setCatlParentNm(String catlParentNm) {
		this.catlParentNm = catlParentNm == null ? null : catlParentNm.trim();
	}
	
    /**
     * @return CatlParentNm
     */	
	public String getCatlParentNm() {
		return this.catlParentNm;
	}
	
	/**
	 * @param catlLevel
	 */
	public void setCatlLevel(java.math.BigDecimal catlLevel) {
		this.catlLevel = catlLevel;
	}
	
    /**
     * @return CatlLevel
     */	
	public java.math.BigDecimal getCatlLevel() {
		return this.catlLevel;
	}
	
	/**
	 * @param catlOrder
	 */
	public void setCatlOrder(java.math.BigDecimal catlOrder) {
		this.catlOrder = catlOrder;
	}
	
    /**
     * @return CatlOrder
     */	
	public java.math.BigDecimal getCatlOrder() {
		return this.catlOrder;
	}
	
	/**
	 * @param orgId
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}
	
    /**
     * @return OrgId
     */	
	public String getOrgId() {
		return this.orgId;
	}
	
	/**
	 * @param displayScheme
	 */
	public void setDisplayScheme(String displayScheme) {
		this.displayScheme = displayScheme == null ? null : displayScheme.trim();
	}
	
    /**
     * @return DisplayScheme
     */	
	public String getDisplayScheme() {
		return this.displayScheme;
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
        AcrmFpdProdCatl other = (AcrmFpdProdCatl) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCatlCode() == null ? other.getCatlCode() == null : this.getCatlCode().equals(other.getCatlCode()))
        	&& (this.getCatlName() == null ? other.getCatlName() == null : this.getCatlName().equals(other.getCatlName()))
        	&& (this.getCatlParent() == null ? other.getCatlParent() == null : this.getCatlParent().equals(other.getCatlParent()))
        	&& (this.getCatlParentNm() == null ? other.getCatlParentNm() == null : this.getCatlParentNm().equals(other.getCatlParentNm()))
                        	&& (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
        	&& (this.getDisplayScheme() == null ? other.getDisplayScheme() == null : this.getDisplayScheme().equals(other.getDisplayScheme()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCatlCode() == null) ? 0 : getCatlCode().hashCode());
        result = prime * result + ((getCatlName() == null) ? 0 : getCatlName().hashCode());
        result = prime * result + ((getCatlParent() == null) ? 0 : getCatlParent().hashCode());
        result = prime * result + ((getCatlParentNm() == null) ? 0 : getCatlParentNm().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getDisplayScheme() == null) ? 0 : getDisplayScheme().hashCode());
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