package cn.com.yusys.yscrm.homepage.domain;

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
 * @项目名称: yscrm-mgr-sys-homepage-core模块
 * @类名称: OcrmFsysUserTile
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-17 11:35:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_SYS_USER_TILE")
public class OcrmFsysUserTile extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键 **/
	@Column(name = "ID", unique = false, nullable = false, length = 32)
	private String id;
	
	/** 用户ID **/
	@Column(name = "USER_ID", unique = false, nullable = false, length = 32)
	private String userId;
	
	/** 图表ID **/
	@Column(name = "CHART_ID", unique = false, nullable = true, length = 32)
	private String chartId;
	
	/** 菜单ID **/
	@Column(name = "RES_ID", unique = false, nullable = true, length = 27)
	private java.math.BigDecimal resId;
	
	/** 模块ID **/
	@Column(name = "MODULE_ID", unique = false, nullable = true, length = 27)
	private java.math.BigDecimal moduleId;
	
	/** 顺序号 **/
	@Column(name = "ORDERS", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal orders;
	
	/** 页面编号 **/
	@Column(name = "PAGE_NO", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal pageNo;
	
	
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
	 * @param chartId
	 */
	public void setChartId(String chartId) {
		this.chartId = chartId == null ? null : chartId.trim();
	}
	
    /**
     * @return ChartId
     */	
	public String getChartId() {
		return this.chartId;
	}
	
	/**
	 * @param resId
	 */
	public void setResId(java.math.BigDecimal resId) {
		this.resId = resId;
	}
	
    /**
     * @return ResId
     */	
	public java.math.BigDecimal getResId() {
		return this.resId;
	}
	
	/**
	 * @param moduleId
	 */
	public void setModuleId(java.math.BigDecimal moduleId) {
		this.moduleId = moduleId;
	}
	
    /**
     * @return ModuleId
     */	
	public java.math.BigDecimal getModuleId() {
		return this.moduleId;
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
	 * @param pageNo
	 */
	public void setPageNo(java.math.BigDecimal pageNo) {
		this.pageNo = pageNo;
	}
	
    /**
     * @return PageNo
     */	
	public java.math.BigDecimal getPageNo() {
		return this.pageNo;
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
        OcrmFsysUserTile other = (OcrmFsysUserTile) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        	&& (this.getChartId() == null ? other.getChartId() == null : this.getChartId().equals(other.getChartId()))
                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getChartId() == null) ? 0 : getChartId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userId=").append(userId);
		sb.append(", chartId=").append(chartId);
		sb.append(", resId=").append(resId);
		sb.append(", moduleId=").append(moduleId);
		sb.append(", orders=").append(orders);
		sb.append(", pageNo=").append(pageNo);
        sb.append("]");
        return sb.toString();
    }
}