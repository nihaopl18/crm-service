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
 * @类名称: OcrmFsysViewItem
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:47:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_SYS_VIEW_ITEM")
public class OcrmFsysViewItem extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 视图项名称 **/
	@Column(name = "VIEW_ITEM_NAME", unique = false, nullable = false, length = 100)
	private String viewItemName;
	
	/** 视图项描述 **/
	@Column(name = "VIEW_ITEM_DESC", unique = false, nullable = true, length = 32)
	private String viewItemDesc;
	
	/** 所属视图ID **/
	@Column(name = "VIEW_ID", unique = false, nullable = true, length = 40)
	private String viewId;
	
	/** 链接地址 **/
	@Column(name = "VIEW_ADDR", unique = false, nullable = false, length = 150)
	private String viewAddr;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = false, length = 32)
	private String lastChgUsr;
	
	/** 最新更新机构 **/
	@Column(name = "LAST_CHG_ORG", unique = false, nullable = true, length = 100)
	private String lastChgOrg;
	
	/** 最新更新日期 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 顺序 **/
	@Column(name = "ORDERS", unique = false, nullable = true, length = 27)
	private java.math.BigDecimal orders;
	
	/** 备注 **/
	@Column(name = "NOTES", unique = false, nullable = true, length = 100)
	private String notes;
	
	
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
	 * @param viewItemName
	 */
	public void setViewItemName(String viewItemName) {
		this.viewItemName = viewItemName == null ? null : viewItemName.trim();
	}
	
    /**
     * @return ViewItemName
     */	
	public String getViewItemName() {
		return this.viewItemName;
	}
	
	/**
	 * @param viewItemDesc
	 */
	public void setViewItemDesc(String viewItemDesc) {
		this.viewItemDesc = viewItemDesc == null ? null : viewItemDesc.trim();
	}
	
    /**
     * @return ViewItemDesc
     */	
	public String getViewItemDesc() {
		return this.viewItemDesc;
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
	 * @param viewAddr
	 */
	public void setViewAddr(String viewAddr) {
		this.viewAddr = viewAddr == null ? null : viewAddr.trim();
	}
	
    /**
     * @return ViewAddr
     */	
	public String getViewAddr() {
		return this.viewAddr;
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
        OcrmFsysViewItem other = (OcrmFsysViewItem) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getViewItemName() == null ? other.getViewItemName() == null : this.getViewItemName().equals(other.getViewItemName()))
        	&& (this.getViewItemDesc() == null ? other.getViewItemDesc() == null : this.getViewItemDesc().equals(other.getViewItemDesc()))
        	&& (this.getViewId() == null ? other.getViewId() == null : this.getViewId().equals(other.getViewId()))
        	&& (this.getViewAddr() == null ? other.getViewAddr() == null : this.getViewAddr().equals(other.getViewAddr()))
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
        result = prime * result + ((getViewItemName() == null) ? 0 : getViewItemName().hashCode());
        result = prime * result + ((getViewItemDesc() == null) ? 0 : getViewItemDesc().hashCode());
        result = prime * result + ((getViewId() == null) ? 0 : getViewId().hashCode());
        result = prime * result + ((getViewAddr() == null) ? 0 : getViewAddr().hashCode());
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
		sb.append(", viewItemName=").append(viewItemName);
		sb.append(", viewItemDesc=").append(viewItemDesc);
		sb.append(", viewId=").append(viewId);
		sb.append(", viewAddr=").append(viewAddr);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgOrg=").append(lastChgOrg);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", orders=").append(orders);
		sb.append(", notes=").append(notes);
        sb.append("]");
        return sb.toString();
    }
}