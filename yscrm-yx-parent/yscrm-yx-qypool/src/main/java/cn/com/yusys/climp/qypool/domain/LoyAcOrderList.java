package cn.com.yusys.climp.qypool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name = "LOY_AC_ORDER_LIST")
public class LoyAcOrderList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ORDER_NUMBER", unique = true, nullable = false, length = 50)
	private String orderNumber;
	
	public String getOrderNumber() { return orderNumber; }
	public void setOrderNumber(String orderNumber) { this.orderNumber=orderNumber; }
	
	@Column(name = "ORDER_STATE")
	private String orderState;
	
	public String getOrderState() { return orderState; }
	public void setOrderState(String orderState) { this.orderState=orderState; }
	
	@Column(name = "ORDER_CUST_ID")
	private String orderCustId;
	
	public String getOrderCustId() { return orderCustId; }
	public void setOrderCustId(String orderCustId) { this.orderCustId=orderCustId; }
	
	@Column(name = "ORDER_START_DATE")
	private Date orderStartDate;
	
	public Date getOrderStartDate() { return orderStartDate; }
	public void setOrderStartDate(Date orderStartDate) { this.orderStartDate=orderStartDate; }
	
	@Column(name = "ORDER_END_DATE")
	private Date orderEndDate;
	
	public Date getOrderEndDate() { return orderEndDate; }
	public void setOrderEndDate(Date orderEndDate) { this.orderEndDate=orderEndDate; }
	
	@Column(name = "CONSIGNEE_NAME")
	private String consigneeName;
	
	public String getConsigneeName() { return consigneeName; }
	public void setConsigneeName(String consigneeName) { this.consigneeName=consigneeName; }
	
	@Column(name = "CONSIGNEE_NUMBER")
	private String consigneeNumber;
	
	public String getConsigneeNumber() { return consigneeNumber; }
	public void setConsigneeNumber(String consigneeNumber) { this.consigneeNumber=consigneeNumber; }
	
	@Column(name = "CONSIGNEE_ADDRESS")
	private String consigneeAddress;
	
	public String getConsigneeAddress() { return consigneeAddress; }
	public void setConsigneeAddress(String consigneeAddress) { this.consigneeAddress=consigneeAddress; }
	
	@Column(name = "TRACKING_NUMBER")
	private String trackingNumber;
	
	public String getTrackingNumber() { return trackingNumber; }
	public void setTrackingNumber(String trackingNumber) { this.trackingNumber=trackingNumber; }
	
	@Column(name = "LOGISTICS")
	private String logistics;
	
	public String getLogistics() { return logistics; }
	public void setLogistics(String logistics) { this.logistics=logistics; }
	
	@Column(name = "COMMODITY_ID", unique = false,nullable = false,length = 50)
	private String commodityID;

	public String getCommodityID() {
		return commodityID;
	}

	public void setCommodityID(String commodityID) {
		this.commodityID = commodityID == null ? null : commodityID.trim();
	}

	@Column(name = "COMMODITY_NAME")
	private String commodityName;
	
	public String getCommodityName() { return commodityName; }
	public void setCommodityName(String commodityName) { this.commodityName=commodityName; }
	
	@Column(name = "COMMODITY_NUMBER",length = 20)
	private long commodityNumber;
	
	public long getCommodityNumber() { return commodityNumber; }
	public void setCommodityNumber(long commodityNumber) { this.commodityNumber=commodityNumber; }
	
	@Column(name = "COMMODITY_L_VALUE")
	private long commodityLValue;
	
	public long getCommodityLValue() { return commodityLValue; }
	public void setCommodityLValue(long commodityLValue) { this.commodityLValue=commodityLValue; }
	
	@Column(name = "COMMODITY_T_VALUE")
	private long commodityTValue;
	
	public long getCommodityTValue() { return commodityTValue; }
	public void setCommodityTValue(long commodityTValue) { this.commodityTValue=commodityTValue; }
	
	@Column(name = "COMMODITY_M_VALUE")
	private long commodityMValue;
	
	public long getCommodityMValue() { return commodityMValue; }
	public void setCommodityMValue(long commodityMValue) { this.commodityMValue=commodityMValue; }
	
	@Column(name = "COMMODITY_TYPE")
	private String commodityType;
	
	public String getCommodityType() { return commodityType; }
	public void setCommodityType(String commodityType) { this.commodityType=commodityType; }
	
	@Column(name = "TRANSACTION_FLOW")
	private String transactionFlow;
	
	public String getTransactionFlow() { return transactionFlow; }
	public void setTransactionFlow(String transactionFlow) { this.transactionFlow=transactionFlow; }

	/**
	 * 订单号
	 */
	@Column(name = "ORDER_No", unique = false, nullable = false, length = 50)
	private String orderNo;

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo == null ? null : orderNo;
	}

	@Column(name = "STAND_FLOW_TABLE_NAME")
	private String standFlowTableName;
	
	public String getStandFlowTableName() { return standFlowTableName; }
	public void setStandFlowTableName(String standFlowTableName) { this.standFlowTableName=standFlowTableName; }
	
	@Column(name = "RULES_ID")
	private String rulesId;
	
	public String getRulesId() { return rulesId; }
	public void setRulesId(String rulesId) { this.rulesId=rulesId; }
	
	@Column(name = "MODEL_ID",unique = false,nullable = false,length = 50)
	private String modelId;

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId == null ? null : modelId;
	}

	@Column(name = "ACTIVITY_NAME")
	private String activityName;
	
	public String getActivityName() { return activityName; }
	public void setActivityName(String activityName) { this.activityName=activityName; }
	
	@Column(name = "ACTIVITY_ID")
	private String activityId;
	
	public String getActivityId() { return activityId; }
	public void setActivityId(String activityId) { this.activityId=activityId; }
	
	@Column(name = "MAJOR_ORDER_NUMBER")
	private String majorOrderNumber;
	
	public String getMajorOrderNumber() { return majorOrderNumber; }
	public void setMajorOrderNumber(String majorOrderNumber) { this.majorOrderNumber=majorOrderNumber; }

	@Column(name = "ORDER_CITY")
	private String orderCity;
	
	public String getOrderCity() { return orderCity; }
	public void setOrderCity(String orderCity) { this.orderCity=orderCity; }
	
	@Column(name = "ORDER_EXC_REASON")
	private String orderExcReason;
	
	public String getOrderExcReason() { return orderExcReason; }
	public void setOrderExcReason(String orderExcReason) { this.orderExcReason=orderExcReason; }
	
	@Column(name = "ORDER_OFF_REASON")
	private String orderOffReason;
	
	public String getOrderOffReason() { return orderOffReason; }
	public void setOrderOffReason(String orderOffReason) { this.orderOffReason=orderOffReason; }
	
	@Column(name = "UPDATE_USER")
	private String updateUser;
	
	public String getUpdateUser() { return updateUser; }
	public void setUpdateUser(String updateUser) { this.updateUser=updateUser; }
	
	@Column(name = "UPDATE_ORG")
	private String updateOrg;
	
	public String getUpdateOrg() { return updateOrg; }
	public void setUpdateOrg(String updateOrg) { this.updateOrg=updateOrg; }
	
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	public Date getUpdateDate() { return updateDate; }
	public void setUpdateDate(Date updateDate) { this.updateDate=updateDate; }
	
	@Column(name = "ORDER_TYPE")
	private String orderType;
	
	public String getOrderType() { return orderType; }
	public void setOrderType(String orderType) { this.orderType=orderType; }

	@Column(name = "ORDER_DESC",unique = false,nullable = true,length = 3000)
	private String orderDesc;

	public String getOrderDesc() {
		return orderDesc;
	}

	public void setOrderDesc(String orderDesc) {
		this.orderDesc = orderDesc == null ? null : orderDesc;
	}
}
