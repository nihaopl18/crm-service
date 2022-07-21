package cn.com.yusys.yscrm.product.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFpdProdScol
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-19 15:43:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_PD_PROD_SCOL")
public class AcrmFpdProdScol extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 产品ID **/
	@Column(name = "PRO_ID", unique = false, nullable = true, length = 36)
	private String proId;
	
	/** 内分组序列号 **/
	@Column(name = "SS_COL_ORDER", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal ssColOrder;
	
	/** 查询项 **/
	@Column(name = "SS_COL_ITEM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal ssColItem;
	
	/** 操作符 **/
	@Column(name = "SS_COL_OP", unique = false, nullable = true, length = 10)
	private String ssColOp;
	
	/** 查询值 **/
	@Column(name = "SS_COL_VALUE", unique = false, nullable = true, length = 1000)
	private String ssColValue;
	
	/** 内连接符 **/
	@Column(name = "SS_COL_JOIN", unique = false, nullable = true, length = 10)
	private String ssColJoin;
	
	/** 外分组序列号 **/
	@Column(name = "SS_COL_GORDER", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal ssColGorder;
	
	/** 外连接符 **/
	@Column(name = "SS_COL_GJOIN", unique = false, nullable = true, length = 10)
	private String ssColGjoin;
	
	/** 外连接符 **/
	@Column(name = "SS_COL_TYPE", unique = false, nullable = true, length = 10)
	private String ssColType;
	
	
	public String getSsColType() {
		return ssColType;
	}

	public void setSsColType(String ssColType) {
		this.ssColType = ssColType;
	}

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
	 * @param proId
	 */
	public void setProId(String proId) {
		this.proId = proId == null ? null : proId.trim();
	}
	
    /**
     * @return ProId
     */	
	public String getProId() {
		return this.proId;
	}
	
	/**
	 * @param ssColOrder
	 */
	public void setSsColOrder(java.math.BigDecimal ssColOrder) {
		this.ssColOrder = ssColOrder;
	}
	
    /**
     * @return SsColOrder
     */	
	public java.math.BigDecimal getSsColOrder() {
		return this.ssColOrder;
	}
	
	/**
	 * @param ssColItem
	 */
	public void setSsColItem(java.math.BigDecimal ssColItem) {
		this.ssColItem = ssColItem;
	}
	
    /**
     * @return SsColItem
     */	
	public java.math.BigDecimal getSsColItem() {
		return this.ssColItem;
	}
	
	/**
	 * @param ssColOp
	 */
	public void setSsColOp(String ssColOp) {
		this.ssColOp = ssColOp == null ? null : ssColOp.trim();
	}
	
    /**
     * @return SsColOp
     */	
	public String getSsColOp() {
		return this.ssColOp;
	}
	
	/**
	 * @param ssColValue
	 */
	public void setSsColValue(String ssColValue) {
		this.ssColValue = ssColValue == null ? null : ssColValue.trim();
	}
	
    /**
     * @return SsColValue
     */	
	public String getSsColValue() {
		return this.ssColValue;
	}
	
	/**
	 * @param ssColJoin
	 */
	public void setSsColJoin(String ssColJoin) {
		this.ssColJoin = ssColJoin == null ? null : ssColJoin.trim();
	}
	
    /**
     * @return SsColJoin
     */	
	public String getSsColJoin() {
		return this.ssColJoin;
	}
	
	/**
	 * @param ssColGorder
	 */
	public void setSsColGorder(java.math.BigDecimal ssColGorder) {
		this.ssColGorder = ssColGorder;
	}
	
    /**
     * @return SsColGorder
     */	
	public java.math.BigDecimal getSsColGorder() {
		return this.ssColGorder;
	}
	
	/**
	 * @param ssColGjoin
	 */
	public void setSsColGjoin(String ssColGjoin) {
		this.ssColGjoin = ssColGjoin == null ? null : ssColGjoin.trim();
	}
	
    /**
     * @return SsColGjoin
     */	
	public String getSsColGjoin() {
		return this.ssColGjoin;
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
        AcrmFpdProdScol other = (AcrmFpdProdScol) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getProId() == null ? other.getProId() == null : this.getProId().equals(other.getProId()))
                        	&& (this.getSsColOp() == null ? other.getSsColOp() == null : this.getSsColOp().equals(other.getSsColOp()))
        	&& (this.getSsColValue() == null ? other.getSsColValue() == null : this.getSsColValue().equals(other.getSsColValue()))
        	&& (this.getSsColJoin() == null ? other.getSsColJoin() == null : this.getSsColJoin().equals(other.getSsColJoin()))
                	&& (this.getSsColGjoin() == null ? other.getSsColGjoin() == null : this.getSsColGjoin().equals(other.getSsColGjoin()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProId() == null) ? 0 : getProId().hashCode());
        result = prime * result + ((getSsColOp() == null) ? 0 : getSsColOp().hashCode());
        result = prime * result + ((getSsColValue() == null) ? 0 : getSsColValue().hashCode());
        result = prime * result + ((getSsColJoin() == null) ? 0 : getSsColJoin().hashCode());
        result = prime * result + ((getSsColGjoin() == null) ? 0 : getSsColGjoin().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", proId=").append(proId);
		sb.append(", ssColOrder=").append(ssColOrder);
		sb.append(", ssColItem=").append(ssColItem);
		sb.append(", ssColOp=").append(ssColOp);
		sb.append(", ssColValue=").append(ssColValue);
		sb.append(", ssColJoin=").append(ssColJoin);
		sb.append(", ssColGorder=").append(ssColGorder);
		sb.append(", ssColGjoin=").append(ssColGjoin);
        sb.append("]");
        return sb.toString();
    }
}