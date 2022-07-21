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
 * @类名称: OcrmFsysView
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-16 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_SYS_VIEW")
public class OcrmFsysView extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 视图ID **/
	@Id
	@Column(name = "VIEW_ID")
	@Generated(GenerationType.UUID)
	private String viewId;
	
	/** 视图名称 **/
	@Column(name = "VIEW_NAME", unique = false, nullable = true, length = 30)
	private String viewName;
	
	/** 视图类型 **/
	@Column(name = "VIEW_TYPE", unique = false, nullable = true, length = 2)
	private String viewType;
	
	/** 备注 **/
	@Column(name = "NOTES", unique = false, nullable = true, length = 200)
	private String notes;
	
	
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
	 * @param viewName
	 */
	public void setViewName(String viewName) {
		this.viewName = viewName == null ? null : viewName.trim();
	}
	
    /**
     * @return ViewName
     */	
	public String getViewName() {
		return this.viewName;
	}
	
	/**
	 * @param viewType
	 */
	public void setViewType(String viewType) {
		this.viewType = viewType == null ? null : viewType.trim();
	}
	
    /**
     * @return ViewType
     */	
	public String getViewType() {
		return this.viewType;
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
        OcrmFsysView other = (OcrmFsysView) that;
		return (this.getViewId() == null ? other.getViewId() == null : this.getViewId().equals(other.getViewId()))
        	&& (this.getViewName() == null ? other.getViewName() == null : this.getViewName().equals(other.getViewName()))
        	&& (this.getViewType() == null ? other.getViewType() == null : this.getViewType().equals(other.getViewType()))
        	&& (this.getNotes() == null ? other.getNotes() == null : this.getNotes().equals(other.getNotes()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getViewId() == null) ? 0 : getViewId().hashCode());
        result = prime * result + ((getViewName() == null) ? 0 : getViewName().hashCode());
        result = prime * result + ((getViewType() == null) ? 0 : getViewType().hashCode());
        result = prime * result + ((getNotes() == null) ? 0 : getNotes().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", viewId=").append(viewId);
		sb.append(", viewName=").append(viewName);
		sb.append(", viewType=").append(viewType);
		sb.append(", notes=").append(notes);
        sb.append("]");
        return sb.toString();
    }
}