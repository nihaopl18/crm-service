package cn.com.yusys.yscrm.custflexEs.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmFCiFqScol
 * @类描述: CRM_F_CI_FQ_SCOL数据集-查询条件 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2021-01-02 14:02:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "CRM_F_CI_FQ_SCOL")
public class CrmFCiFqScol extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 查询方案ID **/
	@Column(name = "SS_ID", unique = false, nullable = true, length = 32)
	private String ssId;
	
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
	
	/** 查询项字段类型 **/
	@Column(name = "SS_COL_TYPE", unique = false, nullable = true, length = 10)
	private String ssColType;
	
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

	public String getSsColType() {
		return ssColType;
	}

	public void setSsColType(String ssColType) {
		this.ssColType = ssColType;
	}
}