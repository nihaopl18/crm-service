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
 * @类名称: OcrmFpdProdShowR
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-31 18:13:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_PD_PROD_SHOW_R")
public class OcrmFpdProdShowR extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 关系ID **/
	@Id
	@Column(name = "R_ID")
	@Generated(GenerationType.UUID)
	private String rid;
	
	/** 产品展示方案ID **/
	@Column(name = "PLAN_ID", unique = false, nullable = false, length = 40)
	private String planId;
	
	/** 产品展示方案名称 **/
	@Column(name = "PLAN_NAME", unique = false, nullable = false, length = 100)
	private String planName;
	
	/** 关联表语句 **/
	@Column(name = "R_FROM", unique = false, nullable = true, length = 300)
	private String rfrom;
	
	/** 表连接语句 **/
	@Column(name = "R_WHERE", unique = false, nullable = true, length = 300)
	private String rwhere;
	
	/** 客户连接字段 **/
	@Column(name = "CUST_COLUMN", unique = false, nullable = true, length = 40)
	private String custColumn;
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 20)
	private String updateUser;
	
	/** 最近更新时间 **/
	@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	
	/**
	 * @param rid
	 */
	public void setRid(String rid) {
		this.rid = rid == null ? null : rid.trim();
	}
	
    /**
     * @return Rid
     */	
	public String getRid() {
		return this.rid;
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
	 * @param planName
	 */
	public void setPlanName(String planName) {
		this.planName = planName == null ? null : planName.trim();
	}
	
    /**
     * @return PlanName
     */	
	public String getPlanName() {
		return this.planName;
	}
	
	/**
	 * @param rfrom
	 */
	public void setRfrom(String rfrom) {
		this.rfrom = rfrom == null ? null : rfrom.trim();
	}
	
    /**
     * @return Rfrom
     */	
	public String getRfrom() {
		return this.rfrom;
	}
	
	/**
	 * @param rwhere
	 */
	public void setRwhere(String rwhere) {
		this.rwhere = rwhere == null ? null : rwhere.trim();
	}
	
    /**
     * @return Rwhere
     */	
	public String getRwhere() {
		return this.rwhere;
	}
	
	/**
	 * @param custColumn
	 */
	public void setCustColumn(String custColumn) {
		this.custColumn = custColumn == null ? null : custColumn.trim();
	}
	
    /**
     * @return CustColumn
     */	
	public String getCustColumn() {
		return this.custColumn;
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
        OcrmFpdProdShowR other = (OcrmFpdProdShowR) that;
		return (this.getRid() == null ? other.getRid() == null : this.getRid().equals(other.getRid()))
        	&& (this.getPlanId() == null ? other.getPlanId() == null : this.getPlanId().equals(other.getPlanId()))
        	&& (this.getPlanName() == null ? other.getPlanName() == null : this.getPlanName().equals(other.getPlanName()))
        	&& (this.getRfrom() == null ? other.getRfrom() == null : this.getRfrom().equals(other.getRfrom()))
        	&& (this.getRwhere() == null ? other.getRwhere() == null : this.getRwhere().equals(other.getRwhere()))
        	&& (this.getCustColumn() == null ? other.getCustColumn() == null : this.getCustColumn().equals(other.getCustColumn()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRid() == null) ? 0 : getRid().hashCode());
        result = prime * result + ((getPlanId() == null) ? 0 : getPlanId().hashCode());
        result = prime * result + ((getPlanName() == null) ? 0 : getPlanName().hashCode());
        result = prime * result + ((getRfrom() == null) ? 0 : getRfrom().hashCode());
        result = prime * result + ((getRwhere() == null) ? 0 : getRwhere().hashCode());
        result = prime * result + ((getCustColumn() == null) ? 0 : getCustColumn().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", rid=").append(rid);
		sb.append(", planId=").append(planId);
		sb.append(", planName=").append(planName);
		sb.append(", rfrom=").append(rfrom);
		sb.append(", rwhere=").append(rwhere);
		sb.append(", custColumn=").append(custColumn);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
        sb.append("]");
        return sb.toString();
    }
}