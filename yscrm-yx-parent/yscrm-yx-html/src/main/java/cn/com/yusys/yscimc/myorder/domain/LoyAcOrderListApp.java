package cn.com.yusys.yscimc.myorder.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: LoyAcOrderList
 * @类描述: #移动端用户订单实体类
 * @功能描述: 移动端用户订单编辑
 * @创建人: yangxiao2
 * @创建时间: 2019-07-04 14:38:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
/** 商品订单表实体类 **/
@Table(name = "LOY_AC_ORDER_LIST")
public class LoyAcOrderListApp extends BaseDomain implements Serializable{

	private static final long serialVersionUID = 1L;

	/** 订单号 **/
	@Id
	@Column(name = "ORDER_NUMBER")
	private String orderNumber;
	
	public String getOrderNumber() { return orderNumber; }
	public void setOrderNumber(String orderNumber) { this.orderNumber=orderNumber; }
	
	/** 订单状态 **/
	@Column(name = "ORDER_STATE")
	private String orderState;
	
	public String getOrderState() { return orderState; }
	public void setOrderState(String orderState) { this.orderState=orderState; }
	
	/** 订单客户编号 **/
	@Column(name = "ORDER_CUST_ID")
	private String orderCustId;
	
	public String getOrderCustId() { return orderCustId; }
	public void setOrderCustId(String orderCustId) { this.orderCustId=orderCustId; }
	
	/** 下单日期 **/
	@Column(name = "ORDER_START_DATE")
	private Date orderStartDate;
	
	public Date getOrderStartDate() { return orderStartDate; }
	public void setOrderStartDate(Date orderStartDate) { this.orderStartDate=orderStartDate; }
	
	/** 完成日期 **/
	@Column(name = "ORDER_END_DATE")
	private Date orderEndDate;
	
	public Date getOrderEndDate() { return orderEndDate; }
	public void setOrderEndDate(Date orderEndDate) { this.orderEndDate=orderEndDate; }
	
	/** 收货人 **/
	@Column(name = "CONSIGNEE_NAME")
	private String consigneeName;
	
	public String getConsigneeName() { return consigneeName; }
	public void setConsigneeName(String consigneeName) { this.consigneeName=consigneeName; }
	
	/** 收货人联系方式 **/
	@Column(name = "CONSIGNEE_NUMBER")
	private String consigneeNumber;
	
	public String getConsigneeNumber() { return consigneeNumber; }
	public void setConsigneeNumber(String consigneeNumber) { this.consigneeNumber=consigneeNumber; }
	
	/** 收货人地址 **/
	@Column(name = "CONSIGNEE_ADDRESS")
	private String consigneeAddress;
	
	public String getConsigneeAddress() { return consigneeAddress; }
	public void setConsigneeAddress(String consigneeAddress) { this.consigneeAddress=consigneeAddress; }
	
	/** 运单号 **/
	@Column(name = "TRACKING_NUMBER")
	private String trackingNumber;
	
	public String getTrackingNumber() { return trackingNumber; }
	public void setTrackingNumber(String trackingNumber) { this.trackingNumber=trackingNumber; }
	
	/** 物流商 **/
	@Column(name = "LOGISTICS")
	private String logistics;
	
	public String getLogistics() { return logistics; }
	public void setLogistics(String logistics) { this.logistics=logistics; }
	
	/** 商品编号 **/
	@Column(name = "COMMODITY_CODE")
	private String commodityCode;
	
	public String getCommodityCode() { return commodityCode; }
	public void setCommodityCode(String commodityCode) { this.commodityCode=commodityCode; }
	
	/** 商品名称 **/
	@Column(name = "COMMODITY_NAME")
	private String commodityName;
	
	public String getCommodityName() { return commodityName; }
	public void setCommodityName(String commodityName) { this.commodityName=commodityName; }
	
	/** 商品数量 **/
	@Column(name = "COMMODITY_NUMBER")
	private long commodityNumber;
	
	public long getCommodityNumber() { return commodityNumber; }
	public void setCommodityNumber(long commodityNumber) { this.commodityNumber=commodityNumber; }
	
	/** 商品积分价值 **/
	@Column(name = "COMMODITY_L_VALUE")
	private long commodityLValue;
	
	public long getCommodityLValue() { return commodityLValue; }
	public void setCommodityLValue(long commodityLValue) { this.commodityLValue=commodityLValue; }
	
	/** 商品总价值 **/
	@Column(name = "COMMODITY_T_VALUE")
	private long commodityTValue;
	
	public long getCommodityTValue() { return commodityTValue; }
	public void setCommodityTValue(long commodityTValue) { this.commodityTValue=commodityTValue; }
	
	/** 商品现金价值 **/
	@Column(name = "COMMODITY_M_VALUE")
	private long commodityMValue;
	
	public long getCommodityMValue() { return commodityMValue; }
	public void setCommodityMValue(long commodityMValue) { this.commodityMValue=commodityMValue; }
	
	/** 商品类型R-实物V-虚拟 **/
	@Column(name = "COMMODITY_TYPE")
	private String commodityType;
	
	public String getCommodityType() { return commodityType; }
	public void setCommodityType(String commodityType) { this.commodityType=commodityType; }
	
	/** 原始交易流水号 **/
	@Column(name = "TRANSACTION_FLOW")
	private String transactionFlow;
	
	public String getTransactionFlow() { return transactionFlow; }
	public void setTransactionFlow(String transactionFlow) { this.transactionFlow=transactionFlow; }
	
	/** 待机流水表名 **/
	@Column(name = "STAND_FLOW_TABLE_NAME")
	private String standFlowTableName;
	
	public String getStandFlowTableName() { return standFlowTableName; }
	public void setStandFlowTableName(String standFlowTableName) { this.standFlowTableName=standFlowTableName; }
	
	/** 规则编号 **/
	@Column(name = "RULES_ID")
	private String rulesId;
	
	public String getRulesId() { return rulesId; }
	public void setRulesId(String rulesId) { this.rulesId=rulesId; }
	
	/** 商品规格 **/
	@Column(name = "MODEL_PARAM")
	private String modelParam;
	
	public String getModelParam() { return modelParam; }
	public void setModelParam(String modelParam) { this.modelParam=modelParam; }
	
	/** 主订单编号 **/
	@Column(name = "MAJOR_ORDER_NUMBER")
	private String majorOrderNumber;
	
	public String getMajorOrderNumber() { return majorOrderNumber; }
	public void setMajorOrderNumber(String majorOrderNumber) { this.majorOrderNumber=majorOrderNumber; }

	/** 订单区域 **/
	@Column(name = "ORDER_CITY")
	private String orderCity;
	
	public String getOrderCity() { return orderCity; }
	public void setOrderCity(String orderCity) { this.orderCity=orderCity; }
	
	/** 换货原因 **/
	@Column(name = "ORDER_EXC_REASON")
	private String orderExcReason;
	
	public String getOrderExcReason() { return orderExcReason; }
	public void setOrderExcReason(String orderExcReason) { this.orderExcReason=orderExcReason; }
	
	/** 关闭原因 **/
	@Column(name = "ORDER_OFF_REASON")
	private String orderOffReason;
	
	public String getOrderOffReason() { return orderOffReason; }
	public void setOrderOffReason(String orderOffReason) { this.orderOffReason=orderOffReason; }
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER")
	private String updateUser;
	
	public String getUpdateUser() { return updateUser; }
	public void setUpdateUser(String updateUser) { this.updateUser=updateUser; }
	
	/** 最近更新机构 **/
	@Column(name = "UPDATE_ORG")
	private String updateOrg;
	
	public String getUpdateOrg() { return updateOrg; }
	public void setUpdateOrg(String updateOrg) { this.updateOrg=updateOrg; }
	
	/** 最近更新日期 **/
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	public Date getUpdateDate() { return updateDate; }
	public void setUpdateDate(Date updateDate) { this.updateDate=updateDate; }
}
