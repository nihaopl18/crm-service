package cn.com.yusys.yscrm.product.domain;

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
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: OcrmFsysSsCol
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-03-06 10:00:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_SYS_SS_COL")
public class OcrmFsysSsCol extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 关联ID **/
	@Column(name = "SS_ID", unique = false, nullable = true, length = 32)
	private String ssId;
	
	/** 关联类型 **/
	@Column(name = "SS_TYPE", unique = false, nullable = true, length = 30)
	private String ssType;
	
	/** 内分组序列号 **/
	@Column(name = "SS_COL_ORDER", unique = false, nullable = true, length = 27)
	private java.math.BigDecimal ssColOrder;
	
	/** 查询项 **/
	@Column(name = "SS_COL_ITEM", unique = false, nullable = true, length = 27)
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
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
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
	 * @param ssId
	 */
	public void setSsId(String ssId) {
		this.ssId = ssId == null ? null : ssId.trim();
	}
	
    /**
     * @return SsId
     */	
	public String getSsId() {
		return this.ssId;
	}
	
	/**
	 * @param ssType
	 */
	public void setSsType(String ssType) {
		this.ssType = ssType == null ? null : ssType.trim();
	}
	
    /**
     * @return SsType
     */	
	public String getSsType() {
		return this.ssType;
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
        OcrmFsysSsCol other = (OcrmFsysSsCol) that;
		return (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getSsId() == null ? other.getSsId() == null : this.getSsId().equals(other.getSsId()))
        	&& (this.getSsType() == null ? other.getSsType() == null : this.getSsType().equals(other.getSsType()))
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
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSsId() == null) ? 0 : getSsId().hashCode());
        result = prime * result + ((getSsType() == null) ? 0 : getSsType().hashCode());
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
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", id=").append(id);
		sb.append(", ssId=").append(ssId);
		sb.append(", ssType=").append(ssType);
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