package cn.com.yusys.yscimc.assemble.domain;

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
 * @项目名称: yscimc-cust-group模块
 * @类名称: LoyAcOrderList
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenl
 * @创建时间: 2019-06-17 17:29:49
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_AC_ORDER_LIST")
public class LoyAcOrderList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 订单号 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ORDER_NUMBER", unique = false, nullable = false, length = 32)
	private String orderNumber;
	
	/** 订单状态 **/
	@Column(name = "ORDER_STATE", unique = false, nullable = true, length = 20)
	private String orderState;
	
	/** 订单客户编号 **/
	@Column(name = "ORDER_CUST_ID", unique = false, nullable = true, length = 32)
	private String orderCustId;
	
	/** 下单日期 **/
	@Transient
	@Column(name = "ORDER_START_DATE", unique = false, nullable = true, length = 7)
	private Date orderStartDate;
	
	/** 完成日期 **/
	@Transient
	@Column(name = "ORDER_END_DATE", unique = false, nullable = true, length = 7)
	private Date orderEndDate;
	
	/** 收货人 **/
	@Column(name = "CONSIGNEE_NAME", unique = false, nullable = true, length = 150)
	private String consigneeName;
	
	/** 收货人联系方式 **/
	@Column(name = "CONSIGNEE_NUMBER", unique = false, nullable = true, length = 32)
	private String consigneeNumber;
	
	/** 收货人地址 **/
	@Column(name = "CONSIGNEE_ADDRESS", unique = false, nullable = true, length = 500)
	private String consigneeAddress;
	
	/** 运单号 **/
	@Column(name = "TRACKING_NUMBER", unique = false, nullable = true, length = 50)
	private String trackingNumber;
	
	/** 物流商 **/
	@Column(name = "LOGISTICS", unique = false, nullable = true, length = 20)
	private String logistics;
	
	/** 商品编号 **/
	@Column(name = "COMMODITY_CODE", unique = false, nullable = true, length = 100)
	private String commodityCode;
	
	/** 商品名称 **/
	@Column(name = "COMMODITY_NAME", unique = false, nullable = true, length = 200)
	private String commodityName;
	
	/** 商品数量 **/
	@Column(name = "COMMODITY_NUMBER", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal commodityNumber;
	
	/** 商品积分价值 **/
	@Column(name = "COMMODITY_L_VALUE", unique = false, nullable = true, length = 18)
	private java.math.BigDecimal commodityLvalue;
	
	/** 商品总价值 **/
	@Column(name = "COMMODITY_T_VALUE", unique = false, nullable = true, length = 18)
	private java.math.BigDecimal commodityTvalue;
	
	/** 商品现金价值 **/
	@Column(name = "COMMODITY_M_VALUE", unique = false, nullable = true, length = 18)
	private java.math.BigDecimal commodityMvalue;
	
	/** 商品类型R-实物V-虚拟P-金融产品 **/
	@Column(name = "COMMODITY_TYPE", unique = false, nullable = true, length = 20)
	private String commodityType;
	
	/** 原始交易流水号 **/
	@Column(name = "TRANSACTION_FLOW", unique = false, nullable = true, length = 32)
	private String transactionFlow;
	
	/** 待机流水表名 **/
	@Column(name = "STAND_FLOW_TABLE_NAME", unique = false, nullable = true, length = 200)
	private String standFlowTableName;
	
	/** 规则编号 **/
	@Column(name = "RULES_ID", unique = false, nullable = true, length = 32)
	private String rulesId;
	
	/** 商品规格 **/
	@Column(name = "MODEL_PARAM", unique = false, nullable = true, length = 200)
	private String modelParam;
	
	/** 活动名称 **/
	@Column(name = "ACTIVITY_NAME", unique = false, nullable = true, length = 100)
	private String activityName;
	
	/** 活动ID **/
	@Column(name = "ACTIVITY_ID", unique = false, nullable = true, length = 32)
	private String activityId;
	
	/** 主订单号 **/
	@Column(name = "MAJOR_ORDER_NUMBER", unique = false, nullable = true, length = 32)
	private String majorOrderNumber;
	
	/** 订单城市 **/
	@Column(name = "ORDER_CITY", unique = false, nullable = true, length = 20)
	private String orderCity;
	
	/** 换货原因 **/
	@Column(name = "ORDER_EXC_REASON", unique = false, nullable = true, length = 500)
	private String orderExcReason;
	
	/** 关闭原因 **/
	@Column(name = "ORDER_OFF_REASON", unique = false, nullable = true, length = 500)
	private String orderOffReason;
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 50)
	private String updateUser;
	
	/** 最近更新机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 50)
	private String updateOrg;
	
	/** 最近更新日期 **/
	@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 订单类型（渠道、引擎） **/
	@Column(name = "ORDER_TYPE", unique = false, nullable = true, length = 20)
	private String orderType;
	
	
	/**
	 * @param orderNumber
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber == null ? null : orderNumber.trim();
	}
	
    /**
     * @return OrderNumber
     */	
	public String getOrderNumber() {
		return this.orderNumber;
	}
	
	/**
	 * @param orderState
	 */
	public void setOrderState(String orderState) {
		this.orderState = orderState == null ? null : orderState.trim();
	}
	
    /**
     * @return OrderState
     */	
	public String getOrderState() {
		return this.orderState;
	}
	
	/**
	 * @param orderCustId
	 */
	public void setOrderCustId(String orderCustId) {
		this.orderCustId = orderCustId == null ? null : orderCustId.trim();
	}
	
    /**
     * @return OrderCustId
     */	
	public String getOrderCustId() {
		return this.orderCustId;
	}
	
	/**
	 * @param orderStartDate
	 */
	public void setOrderStartDate(Date orderStartDate) {
		this.orderStartDate = orderStartDate;
	}
	
    /**
     * @return OrderStartDate
     */	
	public Date getOrderStartDate() {
		return this.orderStartDate;
	}
	
	/**
	 * @param orderEndDate
	 */
	public void setOrderEndDate(Date orderEndDate) {
		this.orderEndDate = orderEndDate;
	}
	
    /**
     * @return OrderEndDate
     */	
	public Date getOrderEndDate() {
		return this.orderEndDate;
	}
	
	/**
	 * @param consigneeName
	 */
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName == null ? null : consigneeName.trim();
	}
	
    /**
     * @return ConsigneeName
     */	
	public String getConsigneeName() {
		return this.consigneeName;
	}
	
	/**
	 * @param consigneeNumber
	 */
	public void setConsigneeNumber(String consigneeNumber) {
		this.consigneeNumber = consigneeNumber == null ? null : consigneeNumber.trim();
	}
	
    /**
     * @return ConsigneeNumber
     */	
	public String getConsigneeNumber() {
		return this.consigneeNumber;
	}
	
	/**
	 * @param consigneeAddress
	 */
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress == null ? null : consigneeAddress.trim();
	}
	
    /**
     * @return ConsigneeAddress
     */	
	public String getConsigneeAddress() {
		return this.consigneeAddress;
	}
	
	/**
	 * @param trackingNumber
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber == null ? null : trackingNumber.trim();
	}
	
    /**
     * @return TrackingNumber
     */	
	public String getTrackingNumber() {
		return this.trackingNumber;
	}
	
	/**
	 * @param logistics
	 */
	public void setLogistics(String logistics) {
		this.logistics = logistics == null ? null : logistics.trim();
	}
	
    /**
     * @return Logistics
     */	
	public String getLogistics() {
		return this.logistics;
	}
	
	/**
	 * @param commodityCode
	 */
	public void setCommodityCode(String commodityCode) {
		this.commodityCode = commodityCode == null ? null : commodityCode.trim();
	}
	
    /**
     * @return CommodityCode
     */	
	public String getCommodityCode() {
		return this.commodityCode;
	}
	
	/**
	 * @param commodityName
	 */
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName == null ? null : commodityName.trim();
	}
	
    /**
     * @return CommodityName
     */	
	public String getCommodityName() {
		return this.commodityName;
	}
	
	/**
	 * @param commodityNumber
	 */
	public void setCommodityNumber(java.math.BigDecimal commodityNumber) {
		this.commodityNumber = commodityNumber;
	}
	
    /**
     * @return CommodityNumber
     */	
	public java.math.BigDecimal getCommodityNumber() {
		return this.commodityNumber;
	}
	
	/**
	 * @param commodityLvalue
	 */
	public void setCommodityLvalue(java.math.BigDecimal commodityLvalue) {
		this.commodityLvalue = commodityLvalue;
	}
	
    /**
     * @return CommodityLvalue
     */	
	public java.math.BigDecimal getCommodityLvalue() {
		return this.commodityLvalue;
	}
	
	/**
	 * @param commodityTvalue
	 */
	public void setCommodityTvalue(java.math.BigDecimal commodityTvalue) {
		this.commodityTvalue = commodityTvalue;
	}
	
    /**
     * @return CommodityTvalue
     */	
	public java.math.BigDecimal getCommodityTvalue() {
		return this.commodityTvalue;
	}
	
	/**
	 * @param commodityMvalue
	 */
	public void setCommodityMvalue(java.math.BigDecimal commodityMvalue) {
		this.commodityMvalue = commodityMvalue;
	}
	
    /**
     * @return CommodityMvalue
     */	
	public java.math.BigDecimal getCommodityMvalue() {
		return this.commodityMvalue;
	}
	
	/**
	 * @param commodityType
	 */
	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType == null ? null : commodityType.trim();
	}
	
    /**
     * @return CommodityType
     */	
	public String getCommodityType() {
		return this.commodityType;
	}
	
	/**
	 * @param transactionFlow
	 */
	public void setTransactionFlow(String transactionFlow) {
		this.transactionFlow = transactionFlow == null ? null : transactionFlow.trim();
	}
	
    /**
     * @return TransactionFlow
     */	
	public String getTransactionFlow() {
		return this.transactionFlow;
	}
	
	/**
	 * @param standFlowTableName
	 */
	public void setStandFlowTableName(String standFlowTableName) {
		this.standFlowTableName = standFlowTableName == null ? null : standFlowTableName.trim();
	}
	
    /**
     * @return StandFlowTableName
     */	
	public String getStandFlowTableName() {
		return this.standFlowTableName;
	}
	
	/**
	 * @param rulesId
	 */
	public void setRulesId(String rulesId) {
		this.rulesId = rulesId == null ? null : rulesId.trim();
	}
	
    /**
     * @return RulesId
     */	
	public String getRulesId() {
		return this.rulesId;
	}
	
	/**
	 * @param modelParam
	 */
	public void setModelParam(String modelParam) {
		this.modelParam = modelParam == null ? null : modelParam.trim();
	}
	
    /**
     * @return ModelParam
     */	
	public String getModelParam() {
		return this.modelParam;
	}
	
	/**
	 * @param activityName
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName == null ? null : activityName.trim();
	}
	
    /**
     * @return ActivityName
     */	
	public String getActivityName() {
		return this.activityName;
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
	 * @param majorOrderNumber
	 */
	public void setMajorOrderNumber(String majorOrderNumber) {
		this.majorOrderNumber = majorOrderNumber == null ? null : majorOrderNumber.trim();
	}
	
    /**
     * @return MajorOrderNumber
     */	
	public String getMajorOrderNumber() {
		return this.majorOrderNumber;
	}
	
	/**
	 * @param orderCity
	 */
	public void setOrderCity(String orderCity) {
		this.orderCity = orderCity == null ? null : orderCity.trim();
	}
	
    /**
     * @return OrderCity
     */	
	public String getOrderCity() {
		return this.orderCity;
	}
	
	/**
	 * @param orderExcReason
	 */
	public void setOrderExcReason(String orderExcReason) {
		this.orderExcReason = orderExcReason == null ? null : orderExcReason.trim();
	}
	
    /**
     * @return OrderExcReason
     */	
	public String getOrderExcReason() {
		return this.orderExcReason;
	}
	
	/**
	 * @param orderOffReason
	 */
	public void setOrderOffReason(String orderOffReason) {
		this.orderOffReason = orderOffReason == null ? null : orderOffReason.trim();
	}
	
    /**
     * @return OrderOffReason
     */	
	public String getOrderOffReason() {
		return this.orderOffReason;
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
	 * @param updateOrg
	 */
	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg == null ? null : updateOrg.trim();
	}
	
    /**
     * @return UpdateOrg
     */	
	public String getUpdateOrg() {
		return this.updateOrg;
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
	
	/**
	 * @param orderType
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType == null ? null : orderType.trim();
	}
	
    /**
     * @return OrderType
     */	
	public String getOrderType() {
		return this.orderType;
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
        LoyAcOrderList other = (LoyAcOrderList) that;
		return (this.getOrderNumber() == null ? other.getOrderNumber() == null : this.getOrderNumber().equals(other.getOrderNumber()))
        	&& (this.getOrderState() == null ? other.getOrderState() == null : this.getOrderState().equals(other.getOrderState()))
        	&& (this.getOrderCustId() == null ? other.getOrderCustId() == null : this.getOrderCustId().equals(other.getOrderCustId()))
                        	&& (this.getConsigneeName() == null ? other.getConsigneeName() == null : this.getConsigneeName().equals(other.getConsigneeName()))
        	&& (this.getConsigneeNumber() == null ? other.getConsigneeNumber() == null : this.getConsigneeNumber().equals(other.getConsigneeNumber()))
        	&& (this.getConsigneeAddress() == null ? other.getConsigneeAddress() == null : this.getConsigneeAddress().equals(other.getConsigneeAddress()))
        	&& (this.getTrackingNumber() == null ? other.getTrackingNumber() == null : this.getTrackingNumber().equals(other.getTrackingNumber()))
        	&& (this.getLogistics() == null ? other.getLogistics() == null : this.getLogistics().equals(other.getLogistics()))
        	&& (this.getCommodityCode() == null ? other.getCommodityCode() == null : this.getCommodityCode().equals(other.getCommodityCode()))
        	&& (this.getCommodityName() == null ? other.getCommodityName() == null : this.getCommodityName().equals(other.getCommodityName()))
                                        	&& (this.getCommodityType() == null ? other.getCommodityType() == null : this.getCommodityType().equals(other.getCommodityType()))
        	&& (this.getTransactionFlow() == null ? other.getTransactionFlow() == null : this.getTransactionFlow().equals(other.getTransactionFlow()))
        	&& (this.getStandFlowTableName() == null ? other.getStandFlowTableName() == null : this.getStandFlowTableName().equals(other.getStandFlowTableName()))
        	&& (this.getRulesId() == null ? other.getRulesId() == null : this.getRulesId().equals(other.getRulesId()))
        	&& (this.getModelParam() == null ? other.getModelParam() == null : this.getModelParam().equals(other.getModelParam()))
        	&& (this.getActivityName() == null ? other.getActivityName() == null : this.getActivityName().equals(other.getActivityName()))
        	&& (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
        	&& (this.getMajorOrderNumber() == null ? other.getMajorOrderNumber() == null : this.getMajorOrderNumber().equals(other.getMajorOrderNumber()))
        	&& (this.getOrderCity() == null ? other.getOrderCity() == null : this.getOrderCity().equals(other.getOrderCity()))
        	&& (this.getOrderExcReason() == null ? other.getOrderExcReason() == null : this.getOrderExcReason().equals(other.getOrderExcReason()))
        	&& (this.getOrderOffReason() == null ? other.getOrderOffReason() == null : this.getOrderOffReason().equals(other.getOrderOffReason()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
        	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
                	&& (this.getOrderType() == null ? other.getOrderType() == null : this.getOrderType().equals(other.getOrderType()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderNumber() == null) ? 0 : getOrderNumber().hashCode());
        result = prime * result + ((getOrderState() == null) ? 0 : getOrderState().hashCode());
        result = prime * result + ((getOrderCustId() == null) ? 0 : getOrderCustId().hashCode());
        result = prime * result + ((getConsigneeName() == null) ? 0 : getConsigneeName().hashCode());
        result = prime * result + ((getConsigneeNumber() == null) ? 0 : getConsigneeNumber().hashCode());
        result = prime * result + ((getConsigneeAddress() == null) ? 0 : getConsigneeAddress().hashCode());
        result = prime * result + ((getTrackingNumber() == null) ? 0 : getTrackingNumber().hashCode());
        result = prime * result + ((getLogistics() == null) ? 0 : getLogistics().hashCode());
        result = prime * result + ((getCommodityCode() == null) ? 0 : getCommodityCode().hashCode());
        result = prime * result + ((getCommodityName() == null) ? 0 : getCommodityName().hashCode());
        result = prime * result + ((getCommodityType() == null) ? 0 : getCommodityType().hashCode());
        result = prime * result + ((getTransactionFlow() == null) ? 0 : getTransactionFlow().hashCode());
        result = prime * result + ((getStandFlowTableName() == null) ? 0 : getStandFlowTableName().hashCode());
        result = prime * result + ((getRulesId() == null) ? 0 : getRulesId().hashCode());
        result = prime * result + ((getModelParam() == null) ? 0 : getModelParam().hashCode());
        result = prime * result + ((getActivityName() == null) ? 0 : getActivityName().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getMajorOrderNumber() == null) ? 0 : getMajorOrderNumber().hashCode());
        result = prime * result + ((getOrderCity() == null) ? 0 : getOrderCity().hashCode());
        result = prime * result + ((getOrderExcReason() == null) ? 0 : getOrderExcReason().hashCode());
        result = prime * result + ((getOrderOffReason() == null) ? 0 : getOrderOffReason().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getOrderType() == null) ? 0 : getOrderType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", orderNumber=").append(orderNumber);
		sb.append(", orderState=").append(orderState);
		sb.append(", orderCustId=").append(orderCustId);
		sb.append(", orderStartDate=").append(orderStartDate);
		sb.append(", orderEndDate=").append(orderEndDate);
		sb.append(", consigneeName=").append(consigneeName);
		sb.append(", consigneeNumber=").append(consigneeNumber);
		sb.append(", consigneeAddress=").append(consigneeAddress);
		sb.append(", trackingNumber=").append(trackingNumber);
		sb.append(", logistics=").append(logistics);
		sb.append(", commodityCode=").append(commodityCode);
		sb.append(", commodityName=").append(commodityName);
		sb.append(", commodityNumber=").append(commodityNumber);
		sb.append(", commodityLvalue=").append(commodityLvalue);
		sb.append(", commodityTvalue=").append(commodityTvalue);
		sb.append(", commodityMvalue=").append(commodityMvalue);
		sb.append(", commodityType=").append(commodityType);
		sb.append(", transactionFlow=").append(transactionFlow);
		sb.append(", standFlowTableName=").append(standFlowTableName);
		sb.append(", rulesId=").append(rulesId);
		sb.append(", modelParam=").append(modelParam);
		sb.append(", activityName=").append(activityName);
		sb.append(", activityId=").append(activityId);
		sb.append(", majorOrderNumber=").append(majorOrderNumber);
		sb.append(", orderCity=").append(orderCity);
		sb.append(", orderExcReason=").append(orderExcReason);
		sb.append(", orderOffReason=").append(orderOffReason);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateOrg=").append(updateOrg);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", orderType=").append(orderType);
        sb.append("]");
        return sb.toString();
    }
}