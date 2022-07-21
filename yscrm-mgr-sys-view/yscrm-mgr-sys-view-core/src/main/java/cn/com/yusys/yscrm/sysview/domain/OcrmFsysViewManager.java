package cn.com.yusys.yscrm.sysview.domain;

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
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewManager
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:50:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_SYS_VIEW_MANAGER")
public class OcrmFsysViewManager extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 逻辑系统ID **/
	@Column(name = "SYS_ID", unique = false, nullable = false, length = 32)
	private String sysId;
	
	/** 视图项ID **/
	@Column(name = "VIEW_ITEM_ID", unique = false, nullable = false, length = 40)
	private String viewItemId;
	
	/** 视图项名称 **/
	@Column(name = "NAME", unique = false, nullable = false, length = 100)
	private String name;
	
	/** 上级节点 **/
	@Column(name = "PARENT_ID", unique = false, nullable = false, length = 100)
	private String parentId;
	
	/** 所属视图ID **/
	@Column(name = "VIEW_ID", unique = false, nullable = false, length = 40)
	private String viewId;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = false, length = 32)
	private String lastChgUsr;
	
	/** 最新更新机构 **/
	@Column(name = "LAST_CHG_ORG", unique = false, nullable = true, length = 100)
	private String lastChgOrg;
	
	/** 最新更新日期 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = false, length = 7)
	private Date lastChgDt;
	
	/** 备注 **/
	@Column(name = "NOTES", unique = false, nullable = true, length = 100)
	private String notes;
	
	/** 顺序 **/
	@Column(name = "ORDERS", unique = false, nullable = true, length = 27)
	private java.math.BigDecimal orders;
	
	
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
	 * @param sysId
	 */
	public void setSysId(String sysId) {
		this.sysId = sysId == null ? null : sysId.trim();
	}
	
    /**
     * @return sysId
     */	
	public String getSysId() {
		return this.sysId;
	}
	
	/**
	 * @param viewItemId
	 */
	public void setViewItemId(String viewItemId) {
		this.viewItemId = viewItemId == null ? null : viewItemId.trim();
	}
	
    /**
     * @return ViewItemId
     */	
	public String getViewItemId() {
		return this.viewItemId;
	}
	
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	
    /**
     * @return ViewItemName
     */	
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId == null ? null : parentId.trim();
	}
	
    /**
     * @return ParentId
     */	
	public String getParentId() {
		return this.parentId;
	}
	
	/**
	 * @param viewId
	 */
	public void setViewId(String viewId) {
		this.viewId = viewId == null ? null : viewId.trim();
	}
	
    /**
     * @return ViewId
     */	
	public String getViewId() {
		return this.viewId;
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
	 * @param lastChgOrg
	 */
	public void setLastChgOrg(String lastChgOrg) {
		this.lastChgOrg = lastChgOrg == null ? null : lastChgOrg.trim();
	}
	
    /**
     * @return LastChgOrg
     */	
	public String getLastChgOrg() {
		return this.lastChgOrg;
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
	 * @param notes
	 */
	public void setNotes(String notes) {
		this.notes = notes == null ? null : notes.trim();
	}
	
    /**
     * @return Notes
     */	
	public String getNotes() {
		return this.notes;
	}
	
	/**
	 * @param orders
	 */
	public void setOrders(java.math.BigDecimal orders) {
		this.orders = orders;
	}
	
    /**
     * @return Orders
     */	
	public java.math.BigDecimal getOrders() {
		return this.orders;
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
        OcrmFsysViewManager other = (OcrmFsysViewManager) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getViewItemId() == null ? other.getViewItemId() == null : this.getViewItemId().equals(other.getViewItemId()))
        	&& (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
        	&& (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
        	&& (this.getViewId() == null ? other.getViewId() == null : this.getViewId().equals(other.getViewId()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
        	&& (this.getLastChgOrg() == null ? other.getLastChgOrg() == null : this.getLastChgOrg().equals(other.getLastChgOrg()))
                	&& (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getViewItemId() == null) ? 0 : getViewItemId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getViewId() == null) ? 0 : getViewId().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getLastChgOrg() == null) ? 0 : getLastChgOrg().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", viewItemId=").append(viewItemId);
		sb.append(", viewItemName=").append(name);
		sb.append(", parentId=").append(parentId);
		sb.append(", viewId=").append(viewId);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgOrg=").append(lastChgOrg);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", notes=").append(notes);
		sb.append(", orders=").append(orders);
        sb.append("]");
        return sb.toString();
    }
}