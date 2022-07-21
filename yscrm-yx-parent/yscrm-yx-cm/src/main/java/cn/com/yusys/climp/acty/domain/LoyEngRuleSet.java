package cn.com.yusys.climp.acty.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleSet
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:40:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_ENG_RULE_SET")
public class LoyEngRuleSet extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键ID **/
	@Id
	@Column(name = "ID", unique = false, nullable = false, length = 38)
	private java.math.BigDecimal id;
	
	/** 活动ID **/
	@Column(name = "ACTIVITY_ID", unique = false, nullable = true, length = 32)
	private String activityId;
	
	/** 规则目录ID **/
	@Column(name = "CATALOG_ID", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal catalogId;
	
	
	/**
	 * @param id
	 */
	public void setId(java.math.BigDecimal id) {
		this.id = id;
	}
	
    /**
     * @return Id
     */	
	public java.math.BigDecimal getId() {
		return this.id;
	}
	
	/**
	 * @param activityId
	 */
	public void setActivityId(String activityId) {
		this.activityId = activityId == null ? null : activityId.trim();
	}
	
    /**
     * @return ActivityId
     */	
	public String getActivityId() {
		return this.activityId;
	}
	
	/**
	 * @param catalogId
	 */
	public void setCatalogId(java.math.BigDecimal catalogId) {
		this.catalogId = catalogId;
	}
	
    /**
     * @return CatalogId
     */	
	public java.math.BigDecimal getCatalogId() {
		return this.catalogId;
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
        LoyEngRuleSet other = (LoyEngRuleSet) that;
        		return (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", activityId=").append(activityId);
		sb.append(", catalogId=").append(catalogId);
        sb.append("]");
        return sb.toString();
    }
}