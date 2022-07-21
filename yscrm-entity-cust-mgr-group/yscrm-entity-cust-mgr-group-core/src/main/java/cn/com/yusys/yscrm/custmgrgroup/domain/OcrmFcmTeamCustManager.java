package cn.com.yusys.yscrm.custmgrgroup.domain;

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
 * @项目名称: yscrm-entity-cust-mgr-group-core模块
 * @类名称: OcrmFcmTeamCustManager
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-14 11:13:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CM_TEAM_CUST_MANAGER")
public class OcrmFcmTeamCustManager extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 所属营销团队ID **/
	@Column(name = "MKT_TEAM_ID", unique = false, nullable = true, length = 32)
	private String mktTeamId;
	
	/** 成员号 **/
	@Column(name = "USER_ID", unique = false, nullable = true, length = 32)
	private String userId;
	
	/** 客户经理名称 **/
	@Column(name = "CUST_MANAGER_NAME", unique = false, nullable = true, length = 50)
	private String custManagerName;
	
	/** 加入日期 **/
	@Column(name = "JOIN_DATE", unique = false, nullable = true, length = 7)
	private Date joinDate;
	
	/** 客户经理归属机构 **/
	@Column(name = "CUST_MANAGER_ORG", unique = false, nullable = true, length = 20)
	private String custManagerOrg;
	
	/** 客户经理工号 **/
	@Column(name = "CUST_MANAGER_ID", unique = false, nullable = true, length = 32)
	private String custManagerId;
	
	/** 加入人ID **/
	@Column(name = "CREATE_USER_ID", unique = false, nullable = true, length = 32)
	private String createUserId;
	
	/** 加入人名称 **/
	@Column(name = "CREATE_USER_NAME", unique = false, nullable = true, length = 50)
	private String createUserName;
	
	/** 加入人机构 **/
	@Column(name = "CREATE_USER_ORG_ID", unique = false, nullable = true, length = 30)
	private String createUserOrgId;
	
	/** 最近维护日期 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
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
	 * @param mktTeamId
	 */
	public void setMktTeamId(String mktTeamId) {
		this.mktTeamId = mktTeamId == null ? null : mktTeamId.trim();
	}
	
    /**
     * @return MktTeamId
     */	
	public String getMktTeamId() {
		return this.mktTeamId;
	}
	
	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
	
    /**
     * @return UserId
     */	
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * @param custManagerName
	 */
	public void setCustManagerName(String custManagerName) {
		this.custManagerName = custManagerName == null ? null : custManagerName.trim();
	}
	
    /**
     * @return CustManagerName
     */	
	public String getCustManagerName() {
		return this.custManagerName;
	}
	
	/**
	 * @param joinDate
	 */
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
    /**
     * @return JoinDate
     */	
	public Date getJoinDate() {
		return this.joinDate;
	}
	
	/**
	 * @param custManagerOrg
	 */
	public void setCustManagerOrg(String custManagerOrg) {
		this.custManagerOrg = custManagerOrg == null ? null : custManagerOrg.trim();
	}
	
    /**
     * @return CustManagerOrg
     */	
	public String getCustManagerOrg() {
		return this.custManagerOrg;
	}
	
	/**
	 * @param custManagerId
	 */
	public void setCustManagerId(String custManagerId) {
		this.custManagerId = custManagerId == null ? null : custManagerId.trim();
	}
	
    /**
     * @return CustManagerId
     */	
	public String getCustManagerId() {
		return this.custManagerId;
	}
	
	/**
	 * @param createUserId
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId == null ? null : createUserId.trim();
	}
	
    /**
     * @return CreateUserId
     */	
	public String getCreateUserId() {
		return this.createUserId;
	}
	
	/**
	 * @param createUserName
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}
	
    /**
     * @return CreateUserName
     */	
	public String getCreateUserName() {
		return this.createUserName;
	}
	
	/**
	 * @param createUserOrgId
	 */
	public void setCreateUserOrgId(String createUserOrgId) {
		this.createUserOrgId = createUserOrgId == null ? null : createUserOrgId.trim();
	}
	
    /**
     * @return CreateUserOrgId
     */	
	public String getCreateUserOrgId() {
		return this.createUserOrgId;
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
        OcrmFcmTeamCustManager other = (OcrmFcmTeamCustManager) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getMktTeamId() == null ? other.getMktTeamId() == null : this.getMktTeamId().equals(other.getMktTeamId()))
        	&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        	&& (this.getCustManagerName() == null ? other.getCustManagerName() == null : this.getCustManagerName().equals(other.getCustManagerName()))
                	&& (this.getCustManagerOrg() == null ? other.getCustManagerOrg() == null : this.getCustManagerOrg().equals(other.getCustManagerOrg()))
        	&& (this.getCustManagerId() == null ? other.getCustManagerId() == null : this.getCustManagerId().equals(other.getCustManagerId()))
        	&& (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
        	&& (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
        	&& (this.getCreateUserOrgId() == null ? other.getCreateUserOrgId() == null : this.getCreateUserOrgId().equals(other.getCreateUserOrgId()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMktTeamId() == null) ? 0 : getMktTeamId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCustManagerName() == null) ? 0 : getCustManagerName().hashCode());
        result = prime * result + ((getCustManagerOrg() == null) ? 0 : getCustManagerOrg().hashCode());
        result = prime * result + ((getCustManagerId() == null) ? 0 : getCustManagerId().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        result = prime * result + ((getCreateUserOrgId() == null) ? 0 : getCreateUserOrgId().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", mktTeamId=").append(mktTeamId);
		sb.append(", userId=").append(userId);
		sb.append(", custManagerName=").append(custManagerName);
		sb.append(", joinDate=").append(joinDate);
		sb.append(", custManagerOrg=").append(custManagerOrg);
		sb.append(", custManagerId=").append(custManagerId);
		sb.append(", createUserId=").append(createUserId);
		sb.append(", createUserName=").append(createUserName);
		sb.append(", createUserOrgId=").append(createUserOrgId);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}