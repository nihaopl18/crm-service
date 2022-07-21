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
 * @类名称: OcrmFciTransCustList
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-15 17:36:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_TRANS_CUST_LIST")
public class OcrmFciTransCustList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 申请编号 **/
	@Column(name = "APPLY_NO", unique = false, nullable = true, length = 30)
	private String applyNo;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 原客户经理编号 **/
	@Column(name = "MGR_ID", unique = false, nullable = true, length = 30)
	private String mgrId;
	
	/** 原客户经理名称 **/
	@Column(name = "MGR_NAME", unique = false, nullable = true, length = 200)
	private String mgrName;
	
	/** 原主协办类型 **/
	@Column(name = "MAIN_TYPE", unique = false, nullable = true, length = 30)
	private String mainType;
	
	/** 原所属机构 **/
	@Column(name = "INSTITUTION", unique = false, nullable = true, length = 30)
	private String institution;
	
	/** 原所属机构名称 **/
	@Column(name = "INSTITUTION_NAME", unique = false, nullable = true, length = 200)
	private String institutionName;
	
	/** 移交主协办类型 **/
	@Column(name = "MAIN_TYPE_NEW", unique = false, nullable = true, length = 30)
	private String mainTypeNew;
	
	/** 是否小企业客户 **/
	@Column(name = "IS_SMALL", unique = false, nullable = true, length = 30)
	private String isSmall;
	
	/** 是否集团客户 **/
	@Column(name = "IS_GROUP", unique = false, nullable = true, length = 30)
	private String isGroup;
	
	/** 是否代发工资客户 **/
	@Column(name = "IS_WAGES", unique = false, nullable = true, length = 30)
	private String isWages;
	
	/** 是否网银客户 **/
	@Column(name = "IS_ONLINE_BANK", unique = false, nullable = true, length = 30)
	private String isOnlineBank;
	
	/** 是否贷款客户 **/
	@Column(name = "IS_LOAN", unique = false, nullable = true, length = 30)
	private String isLoan;
	
	
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
	 * @param applyNo
	 */
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo == null ? null : applyNo.trim();
	}
	
    /**
     * @return ApplyNo
     */	
	public String getApplyNo() {
		return this.applyNo;
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
	 * @param mainType
	 */
	public void setMainType(String mainType) {
		this.mainType = mainType == null ? null : mainType.trim();
	}
	
    /**
     * @return MainType
     */	
	public String getMainType() {
		return this.mainType;
	}
	
	/**
	 * @param institution
	 */
	public void setInstitution(String institution) {
		this.institution = institution == null ? null : institution.trim();
	}
	
    /**
     * @return Institution
     */	
	public String getInstitution() {
		return this.institution;
	}
	
	/**
	 * @param institutionName
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName == null ? null : institutionName.trim();
	}
	
    /**
     * @return InstitutionName
     */	
	public String getInstitutionName() {
		return this.institutionName;
	}
	
	/**
	 * @param mainTypeNew
	 */
	public void setMainTypeNew(String mainTypeNew) {
		this.mainTypeNew = mainTypeNew == null ? null : mainTypeNew.trim();
	}
	
    /**
     * @return MainTypeNew
     */	
	public String getMainTypeNew() {
		return this.mainTypeNew;
	}
	
	/**
	 * @param isSmall
	 */
	public void setIsSmall(String isSmall) {
		this.isSmall = isSmall == null ? null : isSmall.trim();
	}
	
    /**
     * @return IsSmall
     */	
	public String getIsSmall() {
		return this.isSmall;
	}
	
	/**
	 * @param isGroup
	 */
	public void setIsGroup(String isGroup) {
		this.isGroup = isGroup == null ? null : isGroup.trim();
	}
	
    /**
     * @return IsGroup
     */	
	public String getIsGroup() {
		return this.isGroup;
	}
	
	/**
	 * @param isWages
	 */
	public void setIsWages(String isWages) {
		this.isWages = isWages == null ? null : isWages.trim();
	}
	
    /**
     * @return IsWages
     */	
	public String getIsWages() {
		return this.isWages;
	}
	
	/**
	 * @param isOnlineBank
	 */
	public void setIsOnlineBank(String isOnlineBank) {
		this.isOnlineBank = isOnlineBank == null ? null : isOnlineBank.trim();
	}
	
    /**
     * @return IsOnlineBank
     */	
	public String getIsOnlineBank() {
		return this.isOnlineBank;
	}
	
	/**
	 * @param isLoan
	 */
	public void setIsLoan(String isLoan) {
		this.isLoan = isLoan == null ? null : isLoan.trim();
	}
	
    /**
     * @return IsLoan
     */	
	public String getIsLoan() {
		return this.isLoan;
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
        OcrmFciTransCustList other = (OcrmFciTransCustList) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getApplyNo() == null ? other.getApplyNo() == null : this.getApplyNo().equals(other.getApplyNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        	&& (this.getMainType() == null ? other.getMainType() == null : this.getMainType().equals(other.getMainType()))
        	&& (this.getInstitution() == null ? other.getInstitution() == null : this.getInstitution().equals(other.getInstitution()))
        	&& (this.getInstitutionName() == null ? other.getInstitutionName() == null : this.getInstitutionName().equals(other.getInstitutionName()))
        	&& (this.getMainTypeNew() == null ? other.getMainTypeNew() == null : this.getMainTypeNew().equals(other.getMainTypeNew()))
        	&& (this.getIsSmall() == null ? other.getIsSmall() == null : this.getIsSmall().equals(other.getIsSmall()))
        	&& (this.getIsGroup() == null ? other.getIsGroup() == null : this.getIsGroup().equals(other.getIsGroup()))
        	&& (this.getIsWages() == null ? other.getIsWages() == null : this.getIsWages().equals(other.getIsWages()))
        	&& (this.getIsOnlineBank() == null ? other.getIsOnlineBank() == null : this.getIsOnlineBank().equals(other.getIsOnlineBank()))
        	&& (this.getIsLoan() == null ? other.getIsLoan() == null : this.getIsLoan().equals(other.getIsLoan()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getApplyNo() == null) ? 0 : getApplyNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getMainType() == null) ? 0 : getMainType().hashCode());
        result = prime * result + ((getInstitution() == null) ? 0 : getInstitution().hashCode());
        result = prime * result + ((getInstitutionName() == null) ? 0 : getInstitutionName().hashCode());
        result = prime * result + ((getMainTypeNew() == null) ? 0 : getMainTypeNew().hashCode());
        result = prime * result + ((getIsSmall() == null) ? 0 : getIsSmall().hashCode());
        result = prime * result + ((getIsGroup() == null) ? 0 : getIsGroup().hashCode());
        result = prime * result + ((getIsWages() == null) ? 0 : getIsWages().hashCode());
        result = prime * result + ((getIsOnlineBank() == null) ? 0 : getIsOnlineBank().hashCode());
        result = prime * result + ((getIsLoan() == null) ? 0 : getIsLoan().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", applyNo=").append(applyNo);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", mgrId=").append(mgrId);
		sb.append(", mgrName=").append(mgrName);
		sb.append(", mainType=").append(mainType);
		sb.append(", institution=").append(institution);
		sb.append(", institutionName=").append(institutionName);
		sb.append(", mainTypeNew=").append(mainTypeNew);
		sb.append(", isSmall=").append(isSmall);
		sb.append(", isGroup=").append(isGroup);
		sb.append(", isWages=").append(isWages);
		sb.append(", isOnlineBank=").append(isOnlineBank);
		sb.append(", isLoan=").append(isLoan);
        sb.append("]");
        return sb.toString();
    }
}