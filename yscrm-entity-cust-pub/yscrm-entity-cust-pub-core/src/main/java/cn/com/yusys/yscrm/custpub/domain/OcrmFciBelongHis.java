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
 * @类名称: OcrmFciBelongHis
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-29 15:47:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_BELONG_HIS")
public class OcrmFciBelongHis extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "HIS_ID")
	@Generated(GenerationType.UUID)
	private String hisId;
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
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
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户标识 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 调整前归属机构类型 **/
	@Column(name = "ORG_TYPE_PRE", unique = false, nullable = true, length = 1)
	private String orgTypePre;
	
	/** 调整前归属机构ID **/
	@Column(name = "ORG_ID_PRE", unique = false, nullable = true, length = 32)
	private String orgIdPre;
	
	/** 调整前归属机构名称 **/
	@Column(name = "ORG_NAME_PRE", unique = false, nullable = true, length = 200)
	private String orgNamePre;
	
	/** 调整前归属客户经理类型 **/
	@Column(name = "MGR_TYPE_PRE", unique = false, nullable = true, length = 1)
	private String mgrTypePre;
	
	/** 调整前归属客户经理ID **/
	@Column(name = "MGR_ID_PRE", unique = false, nullable = true, length = 32)
	private String mgrIdPre;
	
	/** 调整前归属客户经理名称 **/
	@Column(name = "MGR_NAME_PRE", unique = false, nullable = true, length = 200)
	private String mgrNamePre;
	
	/** 调整后归属机构类型 **/
	@Column(name = "ORG_TYPE", unique = false, nullable = true, length = 1)
	private String orgType;
	
	/** 调整后归属机构ID **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 32)
	private String orgId;
	
	/** 调整后归属机构名称 **/
	@Column(name = "ORG_NAME", unique = false, nullable = true, length = 200)
	private String orgName;
	
	/** 调整后归属客户经理类型 **/
	@Column(name = "MGR_TYPE", unique = false, nullable = true, length = 1)
	private String mgrType;
	
	/** 调整后归属客户经理ID **/
	@Column(name = "MGR_ID", unique = false, nullable = true, length = 32)
	private String mgrId;
	
	/** 调整后归属客户经理名称 **/
	@Column(name = "MGR_NAME", unique = false, nullable = true, length = 200)
	private String mgrName;
	
	/** 调整人 **/
	@Column(name = "ASSIGN_USER", unique = false, nullable = true, length = 32)
	private String assignUser;
	
	/** 调整日期 **/
	@Column(name = "ASSIGN_DATE", unique = false, nullable = true, length = 11)
	private Date assignDate;
	
	/** 调整原因 **/
	@Column(name = "WORK_TRAN_REASON", unique = false, nullable = true, length = 800)
	private String workTranReason;
	
	/** 调整类别 **/
	@Column(name = "WORK_TRAN_LEVEL", unique = false, nullable = true, length = 13)
	private String workTranLevel;
	
	/** 工作交接日期 **/
	@Column(name = "WORK_TRAN_DATE", unique = false, nullable = true, length = 11)
	private Date workTranDate;
	
	
	/**
	 * @param hisId
	 */
	public void setHisId(String hisId) {
		this.hisId = hisId == null ? null : hisId.trim();
	}
	
    /**
     * @return hisId
     */	
	public String getHisId() {
		return this.hisId;
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
	 * @param orgTypePre
	 */
	public void setOrgTypePre(String orgTypePre) {
		this.orgTypePre = orgTypePre == null ? null : orgTypePre.trim();
	}
	
    /**
     * @return OrgTypePre
     */	
	public String getOrgTypePre() {
		return this.orgTypePre;
	}
	
	/**
	 * @param orgIdPre
	 */
	public void setOrgIdPre(String orgIdPre) {
		this.orgIdPre = orgIdPre == null ? null : orgIdPre.trim();
	}
	
    /**
     * @return OrgIdPre
     */	
	public String getOrgIdPre() {
		return this.orgIdPre;
	}
	
	/**
	 * @param orgNamePre
	 */
	public void setOrgNamePre(String orgNamePre) {
		this.orgNamePre = orgNamePre == null ? null : orgNamePre.trim();
	}
	
    /**
     * @return OrgNamePre
     */	
	public String getOrgNamePre() {
		return this.orgNamePre;
	}
	
	/**
	 * @param mgrTypePre
	 */
	public void setMgrTypePre(String mgrTypePre) {
		this.mgrTypePre = mgrTypePre == null ? null : mgrTypePre.trim();
	}
	
    /**
     * @return MgrTypePre
     */	
	public String getMgrTypePre() {
		return this.mgrTypePre;
	}
	
	/**
	 * @param mgrIdPre
	 */
	public void setMgrIdPre(String mgrIdPre) {
		this.mgrIdPre = mgrIdPre == null ? null : mgrIdPre.trim();
	}
	
    /**
     * @return MgrIdPre
     */	
	public String getMgrIdPre() {
		return this.mgrIdPre;
	}
	
	/**
	 * @param mgrNamePre
	 */
	public void setMgrNamePre(String mgrNamePre) {
		this.mgrNamePre = mgrNamePre == null ? null : mgrNamePre.trim();
	}
	
    /**
     * @return MgrNamePre
     */	
	public String getMgrNamePre() {
		return this.mgrNamePre;
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
	
	/**
	 * @param assignUser
	 */
	public void setAssignUser(String assignUser) {
		this.assignUser = assignUser == null ? null : assignUser.trim();
	}
	
    /**
     * @return AssignUser
     */	
	public String getAssignUser() {
		return this.assignUser;
	}
	
	/**
	 * @param assignDate
	 */
	public void setAssignDate(Date assignDate) {
		this.assignDate = assignDate;
	}
	
    /**
     * @return AssignDate
     */	
	public Date getAssignDate() {
		return this.assignDate;
	}
	
	/**
	 * @param workTranReason
	 */
	public void setWorkTranReason(String workTranReason) {
		this.workTranReason = workTranReason == null ? null : workTranReason.trim();
	}
	
    /**
     * @return WorkTranReason
     */	
	public String getWorkTranReason() {
		return this.workTranReason;
	}
	
	/**
	 * @param workTranLevel
	 */
	public void setWorkTranLevel(String workTranLevel) {
		this.workTranLevel = workTranLevel == null ? null : workTranLevel.trim();
	}
	
    /**
     * @return WorkTranLevel
     */	
	public String getWorkTranLevel() {
		return this.workTranLevel;
	}
	
	/**
	 * @param workTranDate
	 */
	public void setWorkTranDate(Date workTranDate) {
		this.workTranDate = workTranDate;
	}
	
    /**
     * @return WorkTranDate
     */	
	public Date getWorkTranDate() {
		return this.workTranDate;
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
        OcrmFciBelongHis other = (OcrmFciBelongHis) that;
        		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastUpdateSys() == null ? other.getLastUpdateSys() == null : this.getLastUpdateSys().equals(other.getLastUpdateSys()))
        	&& (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
                	&& (this.getLastUpdateOrg() == null ? other.getLastUpdateOrg() == null : this.getLastUpdateOrg().equals(other.getLastUpdateOrg()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getOrgTypePre() == null ? other.getOrgTypePre() == null : this.getOrgTypePre().equals(other.getOrgTypePre()))
        	&& (this.getOrgIdPre() == null ? other.getOrgIdPre() == null : this.getOrgIdPre().equals(other.getOrgIdPre()))
        	&& (this.getOrgNamePre() == null ? other.getOrgNamePre() == null : this.getOrgNamePre().equals(other.getOrgNamePre()))
        	&& (this.getMgrTypePre() == null ? other.getMgrTypePre() == null : this.getMgrTypePre().equals(other.getMgrTypePre()))
        	&& (this.getMgrIdPre() == null ? other.getMgrIdPre() == null : this.getMgrIdPre().equals(other.getMgrIdPre()))
        	&& (this.getMgrNamePre() == null ? other.getMgrNamePre() == null : this.getMgrNamePre().equals(other.getMgrNamePre()))
        	&& (this.getOrgType() == null ? other.getOrgType() == null : this.getOrgType().equals(other.getOrgType()))
        	&& (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
        	&& (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
        	&& (this.getMgrType() == null ? other.getMgrType() == null : this.getMgrType().equals(other.getMgrType()))
        	&& (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        	&& (this.getAssignUser() == null ? other.getAssignUser() == null : this.getAssignUser().equals(other.getAssignUser()))
                	&& (this.getWorkTranReason() == null ? other.getWorkTranReason() == null : this.getWorkTranReason().equals(other.getWorkTranReason()))
        	&& (this.getWorkTranLevel() == null ? other.getWorkTranLevel() == null : this.getWorkTranLevel().equals(other.getWorkTranLevel()))
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
        result = prime * result + ((getOrgTypePre() == null) ? 0 : getOrgTypePre().hashCode());
        result = prime * result + ((getOrgIdPre() == null) ? 0 : getOrgIdPre().hashCode());
        result = prime * result + ((getOrgNamePre() == null) ? 0 : getOrgNamePre().hashCode());
        result = prime * result + ((getMgrTypePre() == null) ? 0 : getMgrTypePre().hashCode());
        result = prime * result + ((getMgrIdPre() == null) ? 0 : getMgrIdPre().hashCode());
        result = prime * result + ((getMgrNamePre() == null) ? 0 : getMgrNamePre().hashCode());
        result = prime * result + ((getOrgType() == null) ? 0 : getOrgType().hashCode());
        result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getMgrType() == null) ? 0 : getMgrType().hashCode());
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getAssignUser() == null) ? 0 : getAssignUser().hashCode());
        result = prime * result + ((getWorkTranReason() == null) ? 0 : getWorkTranReason().hashCode());
        result = prime * result + ((getWorkTranLevel() == null) ? 0 : getWorkTranLevel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", hisId=").append(hisId);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", lastUpdateSys=").append(lastUpdateSys);
		sb.append(", lastUpdateUser=").append(lastUpdateUser);
		sb.append(", lastUpdateTm=").append(lastUpdateTm);
		sb.append(", lastUpdateOrg=").append(lastUpdateOrg);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", orgTypePre=").append(orgTypePre);
		sb.append(", orgIdPre=").append(orgIdPre);
		sb.append(", orgNamePre=").append(orgNamePre);
		sb.append(", mgrTypePre=").append(mgrTypePre);
		sb.append(", mgrIdPre=").append(mgrIdPre);
		sb.append(", mgrNamePre=").append(mgrNamePre);
		sb.append(", orgType=").append(orgType);
		sb.append(", orgId=").append(orgId);
		sb.append(", orgName=").append(orgName);
		sb.append(", mgrType=").append(mgrType);
		sb.append(", mgrId=").append(mgrId);
		sb.append(", mgrName=").append(mgrName);
		sb.append(", assignUser=").append(assignUser);
		sb.append(", assignDate=").append(assignDate);
		sb.append(", workTranReason=").append(workTranReason);
		sb.append(", workTranLevel=").append(workTranLevel);
		sb.append(", workTranDate=").append(workTranDate);
        sb.append("]");
        return sb.toString();
    }
}