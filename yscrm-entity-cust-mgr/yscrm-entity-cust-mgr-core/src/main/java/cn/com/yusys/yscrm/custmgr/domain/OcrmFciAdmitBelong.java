package cn.com.yusys.yscrm.custmgr.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFciAdmitBelong
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-22 15:52:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_ADMIT_BELONG")
public class OcrmFciAdmitBelong extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识 **/
	@Id
	@Column(name = "CUST_ID")
	private String custId;
	
	/** 主键ID **/
	@Column(name = "BELONG_ID", unique = false, nullable = false, length = 36)
	private java.math.BigDecimal belongId;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 数据日期 **/
	@Column(name = "IS_ADMIT_ENTER", unique = false, nullable = true, length = 2)
	private String isAdmitEnter;
	
	public String getIsAdmitEnter() {
		return isAdmitEnter;
	}

	public void setIsAdmitEnter(String isAdmitEnter) {
		this.isAdmitEnter = isAdmitEnter;
	}

	/** 最新更新系统 **/
	@Column(name = "LAST_UPDATE_SYS", unique = false, nullable = true, length = 32)
	private String lastUpdateSys;
	
	/** 最新更新人 **/
	@Column(name = "LAST_UPDATE_USER", unique = false, nullable = true, length = 32)
	private String lastUpdateUser;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_UPDATE_TM", unique = false, nullable = true, length = 11)
	private Date lastUpdateTm;
	
	/** 最新更新机构 **/
	@Column(name = "LAST_UPDATE_ORG", unique = false, nullable = true, length = 32)
	private String lastUpdateOrg;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = false, length = 10)
	private String corpOrgCode;
	
	/** 归属机构类型 **/
	@Column(name = "ORG_TYPE", unique = false, nullable = true, length = 1)
	private String orgType;
	
	/** 归属机构ID **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 32)
	private String orgId;
	
	/** 归属机构名称 **/
	@Column(name = "ORG_NAME", unique = false, nullable = true, length = 200)
	private String orgName;
	
	/** 归属客户经理类型 **/
	@Column(name = "MGR_TYPE", unique = false, nullable = true, length = 1)
	private String mgrType;
	
	/** 归属客户经理ID **/
	@Column(name = "MGR_ID", unique = false, nullable = true, length = 32)
	private String mgrId;
	
	/** 归属客户经理名称 **/
	@Column(name = "MGR_NAME", unique = false, nullable = true, length = 200)
	private String mgrName;
	
	
	/**
	 * @param belongId
	 */
	public void setBelongId(java.math.BigDecimal belongId) {
		this.belongId = belongId;
	}
	
    /**
     * @return BelongId
     */	
	public java.math.BigDecimal getBelongId() {
		return this.belongId;
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
	 * @param lastUpdateSys
	 */
	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys == null ? null : lastUpdateSys.trim();
	}
	
    /**
     * @return LastUpdateSys
     */	
	public String getLastUpdateSys() {
		return this.lastUpdateSys;
	}
	
	/**
	 * @param lastUpdateUser
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
	}
	
    /**
     * @return LastUpdateUser
     */	
	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}
	
	/**
	 * @param lastUpdateTm
	 */
	public void setLastUpdateTm(Date lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}
	
    /**
     * @return LastUpdateTm
     */	
	public Date getLastUpdateTm() {
		return this.lastUpdateTm;
	}
	
	/**
	 * @param lastUpdateOrg
	 */
	public void setLastUpdateOrg(String lastUpdateOrg) {
		this.lastUpdateOrg = lastUpdateOrg == null ? null : lastUpdateOrg.trim();
	}
	
    /**
     * @return LastUpdateOrg
     */	
	public String getLastUpdateOrg() {
		return this.lastUpdateOrg;
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
	 * @param orgType
	 */
	public void setOrgType(String orgType) {
		this.orgType = orgType == null ? null : orgType.trim();
	}
	
    /**
     * @return OrgType
     */	
	public String getOrgType() {
		return this.orgType;
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
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}
	
    /**
     * @return OrgName
     */	
	public String getOrgName() {
		return this.orgName;
	}
	
	/**
	 * @param mgrType
	 */
	public void setMgrType(String mgrType) {
		this.mgrType = mgrType == null ? null : mgrType.trim();
	}
	
    /**
     * @return MgrType
     */	
	public String getMgrType() {
		return this.mgrType;
	}
	
	/**
	 * @param mgrId
	 */
	public void setMgrId(String mgrId) {
		this.mgrId = mgrId == null ? null : mgrId.trim();
	}
	
    /**
     * @return MgrId
     */	
	public String getMgrId() {
		return this.mgrId;
	}
	
	/**
	 * @param mgrName
	 */
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName == null ? null : mgrName.trim();
	}
	
    /**
     * @return MgrName
     */	
	public String getMgrName() {
		return this.mgrName;
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
        OcrmFciAdmitBelong other = (OcrmFciAdmitBelong) that;
        		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastUpdateSys() == null ? other.getLastUpdateSys() == null : this.getLastUpdateSys().equals(other.getLastUpdateSys()))
        	&& (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
                	&& (this.getLastUpdateOrg() == null ? other.getLastUpdateOrg() == null : this.getLastUpdateOrg().equals(other.getLastUpdateOrg()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getOrgType() == null ? other.getOrgType() == null : this.getOrgType().equals(other.getOrgType()))
        	&& (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
        	&& (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
        	&& (this.getMgrType() == null ? other.getMgrType() == null : this.getMgrType().equals(other.getMgrType()))
        	&& (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getLastUpdateSys() == null) ? 0 : getLastUpdateSys().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getLastUpdateOrg() == null) ? 0 : getLastUpdateOrg().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getOrgType() == null) ? 0 : getOrgType().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getMgrType() == null) ? 0 : getMgrType().hashCode());
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", belongId=").append(belongId);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", lastUpdateSys=").append(lastUpdateSys);
		sb.append(", lastUpdateUser=").append(lastUpdateUser);
		sb.append(", lastUpdateTm=").append(lastUpdateTm);
		sb.append(", lastUpdateOrg=").append(lastUpdateOrg);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", orgType=").append(orgType);
		sb.append(", orgId=").append(orgId);
		sb.append(", orgName=").append(orgName);
		sb.append(", mgrType=").append(mgrType);
		sb.append(", mgrId=").append(mgrId);
		sb.append(", mgrName=").append(mgrName);
        sb.append("]");
        return sb.toString();
    }
}