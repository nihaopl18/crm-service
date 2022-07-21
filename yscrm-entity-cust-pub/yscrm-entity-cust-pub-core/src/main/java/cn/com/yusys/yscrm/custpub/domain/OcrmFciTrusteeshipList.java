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
 * @类名称: OcrmFciTrusteeshipList
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-22 17:15:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_TRUSTEESHIP_LIST")
public class OcrmFciTrusteeshipList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 	 **/
	@Id
	@Column(name = "LIST_ID")
	@Generated(GenerationType.UUID)
	private String listId;
	
	/** 申请编号 **/
	@Column(name = "APPLY_NO", unique = false, nullable = false, length = 36)
	private java.math.BigDecimal applyNo;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	
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
	 * @param applyNo
	 */
	public void setApplyNo(java.math.BigDecimal applyNo) {
		this.applyNo = applyNo;
	}
	
    /**
     * @return ApplyNo
     */	
	public java.math.BigDecimal getApplyNo() {
		return this.applyNo;
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
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}
	
    /**
     * @return CustName
     */	
	public String getCustName() {
		return this.custName;
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
        OcrmFciTrusteeshipList other = (OcrmFciTrusteeshipList) that;
		return (this.getListId() == null ? other.getListId() == null : this.getListId().equals(other.getListId()))
        	&& (this.getApplyNo() == null ? other.getApplyNo() == null : this.getApplyNo().equals(other.getApplyNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getListId() == null) ? 0 : getListId().hashCode());
        result = prime * result + ((getApplyNo() == null) ? 0 : getApplyNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", listId=").append(listId);
		sb.append(", applyNo=").append(applyNo);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
        sb.append("]");
        return sb.toString();
    }
}