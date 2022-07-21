package cn.com.yusys.yscrm.mgr.sys.pdplan.domain;

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
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowColumn
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-31 18:14:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_PD_PROD_SHOW_COLUMN")
public class OcrmFpdProdShowColumn extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 属性关联ID **/
	@Id
	@Column(name = "R_CLOUMN_ID")
	@Generated(GenerationType.UUID)
	private String rcloumnId;
	
	/** 产品展示方案ID **/
	@Column(name = "PLAN_ID", unique = false, nullable = true, length = 40)
	private String planId;
	
	/** 表关联ID **/
	@Column(name = "R_TABLE_ID", unique = false, nullable = true, length = 100)
	private String rtableId;
	
	/** 属性定义ID **/
	@Column(name = "COLUMN_ID", unique = false, nullable = true, length = 40)
	private String columnId;
	
	/** 排序 **/
	@Column(name = "CLOUMN_SQUENCE", unique = false, nullable = true, length = 3)
	private short cloumnSquence;
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 20)
	private String updateUser;
	
	/** 最近更新时间 **/
	@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	
	/**
	 * @param rcloumnId
	 */
	public void setRcloumnId(String rcloumnId) {
		this.rcloumnId = rcloumnId == null ? null : rcloumnId.trim();
	}
	
    /**
     * @return RcloumnId
     */	
	public String getRcloumnId() {
		return this.rcloumnId;
	}
	
	/**
	 * @param planId
	 */
	public void setPlanId(String planId) {
		this.planId = planId == null ? null : planId.trim();
	}
	
    /**
     * @return PlanId
     */	
	public String getPlanId() {
		return this.planId;
	}
	
	/**
	 * @param rtableId
	 */
	public void setRtableId(String rtableId) {
		this.rtableId = rtableId == null ? null : rtableId.trim();
	}
	
    /**
     * @return RtableId
     */	
	public String getRtableId() {
		return this.rtableId;
	}
	
	/**
	 * @param columnId
	 */
	public void setColumnId(String columnId) {
		this.columnId = columnId == null ? null : columnId.trim();
	}
	
    /**
     * @return ColumnId
     */	
	public String getColumnId() {
		return this.columnId;
	}
	
	/**
	 * @param cloumnSquence
	 */
	public void setCloumnSquence(short cloumnSquence) {
		this.cloumnSquence = cloumnSquence;
	}
	
    /**
     * @return CloumnSquence
     */	
	public short getCloumnSquence() {
		return this.cloumnSquence;
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
        OcrmFpdProdShowColumn other = (OcrmFpdProdShowColumn) that;
		return (this.getRcloumnId() == null ? other.getRcloumnId() == null : this.getRcloumnId().equals(other.getRcloumnId()))
        	&& (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
        	&& (this.getRtableId() == null ? other.getRtableId() == null : this.getRtableId().equals(other.getRtableId()))
        	&& (this.getColumnId() == null ? other.getColumnId() == null : this.getColumnId().equals(other.getColumnId()))
                	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRcloumnId() == null) ? 0 : getRcloumnId().hashCode());
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getRtableId() == null) ? 0 : getRtableId().hashCode());
        result = prime * result + ((getColumnId() == null) ? 0 : getColumnId().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", rcloumnId=").append(rcloumnId);
		sb.append(", planId=").append(planId);
		sb.append(", rtableId=").append(rtableId);
		sb.append(", columnId=").append(columnId);
		sb.append(", cloumnSquence=").append(cloumnSquence);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
        sb.append("]");
        return sb.toString();
    }
}