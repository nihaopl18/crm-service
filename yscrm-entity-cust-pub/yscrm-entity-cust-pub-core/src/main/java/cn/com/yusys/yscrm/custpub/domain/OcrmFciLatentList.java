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
 * @类名称: OcrmFciLatentList
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-14 19:50:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_LATENT_LIST")
public class OcrmFciLatentList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "LIST_ID")
	@Generated(GenerationType.UUID)
	private String listId;
	
	/** 申请ID **/
	@Column(name = "APPLY_ID", unique = false, nullable = true, length = 30)
	private String applyId;
	
	/** 客户ID **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 客户类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 认领关系类型 **/
	@Column(name = "MAN_TYPE", unique = false, nullable = true, length = 20)
	private String manType;
	
	/** 原归属客户经理ID **/
	@Column(name = "OLD_MGR_ID", unique = false, nullable = true, length = 30)
	private String oldMgrId;
	
	/** 原归属客户经理名称 **/
	@Column(name = "OLD_MGR_NAME", unique = false, nullable = true, length = 200)
	private String oldMgrName;
	
	/** 原归属机构ID **/
	@Column(name = "OLD_ORG_ID", unique = false, nullable = true, length = 30)
	private String oldOrgId;
	
	/** 原归属机构名称 **/
	@Column(name = "OLD_ORG_NAME", unique = false, nullable = true, length = 200)
	private String oldOrgName;
	
	
	/**
	 * @param listId
	 */
	public void setListId(String listId) {
		this.listId = listId == null ? null : listId.trim();
	}
	
    /**
     * @return ListId
     */	
	public String getListId() {
		return this.listId;
	}
	
	/**
	 * @param applyId
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId == null ? null : applyId.trim();
	}
	
    /**
     * @return ApplyId
     */	
	public String getApplyId() {
		return this.applyId;
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
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	
    /**
     * @return CustType
     */	
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * @param manType
	 */
	public void setManType(String manType) {
		this.manType = manType == null ? null : manType.trim();
	}
	
    /**
     * @return ManType
     */	
	public String getManType() {
		return this.manType;
	}
	
	/**
	 * @param oldMgrId
	 */
	public void setOldMgrId(String oldMgrId) {
		this.oldMgrId = oldMgrId == null ? null : oldMgrId.trim();
	}
	
    /**
     * @return OldMgrId
     */	
	public String getOldMgrId() {
		return this.oldMgrId;
	}
	
	/**
	 * @param oldMgrName
	 */
	public void setOldMgrName(String oldMgrName) {
		this.oldMgrName = oldMgrName == null ? null : oldMgrName.trim();
	}
	
    /**
     * @return OldMgrName
     */	
	public String getOldMgrName() {
		return this.oldMgrName;
	}
	
	/**
	 * @param oldOrgId
	 */
	public void setOldOrgId(String oldOrgId) {
		this.oldOrgId = oldOrgId == null ? null : oldOrgId.trim();
	}
	
    /**
     * @return OldOrgId
     */	
	public String getOldOrgId() {
		return this.oldOrgId;
	}
	
	/**
	 * @param oldOrgName
	 */
	public void setOldOrgName(String oldOrgName) {
		this.oldOrgName = oldOrgName == null ? null : oldOrgName.trim();
	}
	
    /**
     * @return OldOrgName
     */	
	public String getOldOrgName() {
		return this.oldOrgName;
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
        OcrmFciLatentList other = (OcrmFciLatentList) that;
		return (this.getListId() == null ? other.getListId() == null : this.getListId().equals(other.getListId()))
        	&& (this.getApplyId() == null ? other.getApplyId() == null : this.getApplyId().equals(other.getApplyId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getManType() == null ? other.getManType() == null : this.getManType().equals(other.getManType()))
        	&& (this.getOldMgrId() == null ? other.getOldMgrId() == null : this.getOldMgrId().equals(other.getOldMgrId()))
        	&& (this.getOldMgrName() == null ? other.getOldMgrName() == null : this.getOldMgrName().equals(other.getOldMgrName()))
        	&& (this.getOldOrgId() == null ? other.getOldOrgId() == null : this.getOldOrgId().equals(other.getOldOrgId()))
        	&& (this.getOldOrgName() == null ? other.getOldOrgName() == null : this.getOldOrgName().equals(other.getOldOrgName()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getListId() == null) ? 0 : getListId().hashCode());
        result = prime * result + ((getApplyId() == null) ? 0 : getApplyId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getManType() == null) ? 0 : getManType().hashCode());
        result = prime * result + ((getOldMgrId() == null) ? 0 : getOldMgrId().hashCode());
        result = prime * result + ((getOldMgrName() == null) ? 0 : getOldMgrName().hashCode());
        result = prime * result + ((getOldOrgId() == null) ? 0 : getOldOrgId().hashCode());
        result = prime * result + ((getOldOrgName() == null) ? 0 : getOldOrgName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", listId=").append(listId);
		sb.append(", applyId=").append(applyId);
		sb.append(", custId=").append(custId);
		sb.append(", custType=").append(custType);
		sb.append(", manType=").append(manType);
		sb.append(", oldMgrId=").append(oldMgrId);
		sb.append(", oldMgrName=").append(oldMgrName);
		sb.append(", oldOrgId=").append(oldOrgId);
		sb.append(", oldOrgName=").append(oldOrgName);
        sb.append("]");
        return sb.toString();
    }
}