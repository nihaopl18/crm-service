package cn.com.yusys.yscrm.cust.group.domain;

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
 * @项目名称: yscrm-entity-cust-group-core模块
 * @类名称: OcrmFciCgBase
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-17 21:31:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_CG_BASE")
public class OcrmFciCgBase extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户群编号 **/
	@Id
	@Column(name = "CUST_GROUP_ID")
	@Generated(GenerationType.UUID)
	private String custGroupId;
	
	/** 客户群名称 **/
	@Column(name = "CUST_GROUP_NAME", unique = false, nullable = false, length = 100)
	private String custGroupName;
	
	/** 客户来源 **/
	@Column(name = "CUST_ORIGIN", unique = false, nullable = false, length = 32)
	private String custOrigin;
	
	/** 共享范围 **/
	@Column(name = "SHARE_SCOPE", unique = false, nullable = false, length = 2)
	private String shareScope;
	
	/** 群成员类型 **/
	@Column(name = "GROUP_MEMBER_TYPE", unique = false, nullable = false, length = 2)
	private String groupMemberType;
	
	/** 客户群类型 **/
	@Column(name = "CUST_GROUP_TYPE", unique = false, nullable = false, length = 32)
	private String custGroupType;
	
	/** 客户群描述 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = false, length = 10)
	private String corpOrgCode;
	
	/** 创建人ID **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 32)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构ID **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 32)
	private String createOrg;
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 32)
	private String updateUser;
	
	/** 最近更新时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近修改机构编号 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 32)
	private String updateOrg;
	
	/** 最近修改系统 **/
	@Column(name = "UPDATE_SYS", unique = false, nullable = true, length = 32)
	private String updateSys;
	
	/** 到期时间 **/
	@Column(name = "EXPIRE_DATE", unique = false, nullable = true, length = 7)
	private Date expireDate;
	
	/** SQL **/
	@Column(name = "SQL", unique = false, nullable = true, length = 2000)
	private String sql;
	
	/** 方案ID **/
	@Column(name = "SSID", unique = false, nullable = true, length = 32)
	private String ssid;
	
	/** 有效期 **/
	@Column(name = "TERM_OF_VALIDTY", unique = false, nullable = true, length = 7)
	private Date termOfValidty;
	
	
	/**
	 * @param custGroupId
	 */
	public void setCustGroupId(String custGroupId) {
		this.custGroupId = custGroupId == null ? null : custGroupId.trim();
	}
	
    /**
     * @return CustGroupId
     */	
	public String getCustGroupId() {
		return this.custGroupId;
	}
	
	/**
	 * @param custGroupName
	 */
	public void setCustGroupName(String custGroupName) {
		this.custGroupName = custGroupName == null ? null : custGroupName.trim();
	}
	
    /**
     * @return CustGroupName
     */	
	public String getCustGroupName() {
		return this.custGroupName;
	}
	
	/**
	 * @param custOrigin
	 */
	public void setCustOrigin(String custOrigin) {
		this.custOrigin = custOrigin == null ? null : custOrigin.trim();
	}
	
    /**
     * @return CustOrigin
     */	
	public String getCustOrigin() {
		return this.custOrigin;
	}
	
	/**
	 * @param shareScope
	 */
	public void setShareScope(String shareScope) {
		this.shareScope = shareScope == null ? null : shareScope.trim();
	}
	
    /**
     * @return ShareScope
     */	
	public String getShareScope() {
		return this.shareScope;
	}
	
	/**
	 * @param groupMemberType
	 */
	public void setGroupMemberType(String groupMemberType) {
		this.groupMemberType = groupMemberType == null ? null : groupMemberType.trim();
	}
	
    /**
     * @return GroupMemberType
     */	
	public String getGroupMemberType() {
		return this.groupMemberType;
	}
	
	/**
	 * @param custGroupType
	 */
	public void setCustGroupType(String custGroupType) {
		this.custGroupType = custGroupType == null ? null : custGroupType.trim();
	}
	
    /**
     * @return CustGroupType
     */	
	public String getCustGroupType() {
		return this.custGroupType;
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
	 * @param createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}
	
    /**
     * @return CreateUser
     */	
	public String getCreateUser() {
		return this.createUser;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
    /**
     * @return CreateDate
     */	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
	}
	
	/**
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}
	
    /**
     * @return UpdateUser
     */	
	public String getUpdateUser() {
		return this.updateUser;
	}
	
	/**
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
    /**
     * @return UpdateDate
     */	
	public Date getUpdateDate() {
		return this.updateDate;
	}
	
	/**
	 * @param updateOrg
	 */
	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg == null ? null : updateOrg.trim();
	}
	
    /**
     * @return UpdateOrg
     */	
	public String getUpdateOrg() {
		return this.updateOrg;
	}
	
	/**
	 * @param updateSys
	 */
	public void setUpdateSys(String updateSys) {
		this.updateSys = updateSys == null ? null : updateSys.trim();
	}
	
    /**
     * @return UpdateSys
     */	
	public String getUpdateSys() {
		return this.updateSys;
	}
	
	/**
	 * @param expireDate
	 */
	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}
	
    /**
     * @return ExpireDate
     */	
	public Date getExpireDate() {
		return this.expireDate;
	}
	
	/**
	 * @param sql
	 */
	public void setSql(String sql) {
		this.sql = sql == null ? null : sql.trim();
	}
	
    /**
     * @return Sql
     */	
	public String getSql() {
		return this.sql;
	}
	
	/**
	 * @param ssid
	 */
	public void setSsid(String ssid) {
		this.ssid = ssid == null ? null : ssid.trim();
	}
	
    /**
     * @return Ssid
     */	
	public String getSsid() {
		return this.ssid;
	}
	
	/**
	 * @param termOfValidty
	 */
	public void setTermOfValidty(Date termOfValidty) {
		this.termOfValidty = termOfValidty;
	}
	
    /**
     * @return TermOfValidty
     */	
	public Date getTermOfValidty() {
		return this.termOfValidty;
	}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustGroupId() == null) ? 0 : getCustGroupId().hashCode());
        result = prime * result + ((getCustGroupName() == null) ? 0 : getCustGroupName().hashCode());
        result = prime * result + ((getCustOrigin() == null) ? 0 : getCustOrigin().hashCode());
        result = prime * result + ((getShareScope() == null) ? 0 : getShareScope().hashCode());
        result = prime * result + ((getGroupMemberType() == null) ? 0 : getGroupMemberType().hashCode());
        result = prime * result + ((getCustGroupType() == null) ? 0 : getCustGroupType().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getUpdateSys() == null) ? 0 : getUpdateSys().hashCode());
        result = prime * result + ((getSql() == null) ? 0 : getSql().hashCode());
        result = prime * result + ((getSsid() == null) ? 0 : getSsid().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custGroupId=").append(custGroupId);
		sb.append(", custGroupName=").append(custGroupName);
		sb.append(", custOrigin=").append(custOrigin);
		sb.append(", shareScope=").append(shareScope);
		sb.append(", groupMemberType=").append(groupMemberType);
		sb.append(", custGroupType=").append(custGroupType);
		sb.append(", remark=").append(remark);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
		sb.append(", updateSys=").append(updateSys);
		sb.append(", expireDate=").append(expireDate);
		sb.append(", sql=").append(sql);
		sb.append(", ssid=").append(ssid);
		sb.append(", termOfValidty=").append(termOfValidty);
        sb.append("]");
        return sb.toString();
    }
}