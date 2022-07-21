package cn.com.yusys.yusp.uimp.audit.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFAppointAuditInfo
 * @类描述: PMA_F_APPOINT_AUDIT_INFO数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-02 14:45:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFAppointAuditInfo", description = "业绩预约")
@Entity
@Table(name = "PMA_F_APPOINT_AUDIT_INFO")
public class PmaFAppointAuditInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "主键", name = "id", required = false)
	private String id;

	/** 预约机构编号 **/
	@Column(name = "APPOINT_ORG_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "预约机构编号", name = "appointOrgId", required = false)
	private String appointOrgId;
	
	/** 证件类型 **/
	@Column(name = "CARD_TYPE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "证件类型", name = "cardType", required = false)
	private String cardType;
	
	/** 证件号码 **/
	@Column(name = "CARD_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "证件号码", name = "cardId", required = false)
	private String cardId;
	
	/** 预约开始时间 **/
	@Column(name = "START_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "预约开始时间", name = "startDate", required = false)
	private String startDate;
	
	/** 预约结束时间 **/
	@Column(name = "END_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "预约结束时间", name = "endDate", required = false)
	private String endDate;
	
	/** 金额 **/
	@Column(name = "AMT", unique = false, nullable = true, length = 0)
	@ApiModelProperty(value = "金额", name = "amt", required = false)
	private java.math.BigDecimal amt;
	
	/** 业务种类 **/
	@Column(name = "BUS_TYPE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "业务种类", name = "busType", required = false)
	private String busType;
	
	/** 业务种类 **/
	@Column(name = "BUS_TYPE_DETAIL", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "业务种类细类", name = "busTypeDetail", required = false)
	private String busTypeDetail;
	
	/** 申请时间 **/
	@Column(name = "APPLY_TIME", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "申请时间", name = "applyTime", required = false)
	private String applyTime;
	
	/** 客户经理编号 **/
	@Column(name = "APPLY_USER_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "客户经理编号", name = "applyUserId", required = false)
	private String applyUserId;
	
	/** 客户经理姓名 **/
	@Column(name = "APPLY_USER_NAME", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "客户经理姓名", name = "applyUserName", required = false)
	private String applyUserName;
	
	/** 审批时间 **/
	@Column(name = "AUDIT_TIME", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "审批时间", name = "auditTime", required = false)
	private String auditTime;
	
	/** 预约审批状态 **/
	@Column(name = "AUDIT_STATUS", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "预约审批状态", name = "auditStatus", required = false)
	private String auditStatus;
	
	/** 预约审批意见 **/
	@Column(name = "AUDIT_BAKE", unique = false, nullable = true, length = 200)
	@ApiModelProperty(value = "预约审批意见", name = "auditBake", required = false)
	private String auditBake;
	
	/** 预约审批人ID **/
	@Column(name = "AUDIT_USER_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "预约审批人ID", name = "auditUserId", required = false)
	private String auditUserId;
	
	/** 预约审批人姓名 **/
	@Column(name = "AUDIT_USER_NAME", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "预约审批人姓名", name = "auditUserName", required = false)
	private String auditUserName;
	
	/** 是否命中 **/
	@Column(name = "ETL_RES", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "是否命中", name = "etlRes", required = false)
	private String etlRes;
	
	/** STATE **/
	@Column(name = "STATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "预约状态", name = "state", required = false)
	private String state;
	
	/** CUST_NAME **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "客户名称", name = "custName", required = false)
	private String custName;
	
	/** CUST_TYPE **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "客户类型", name = "custType", required = false)
	private String custType;
	
	/** CUST_NO **/
	@Column(name = "CUST_NO", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "客户号", name = "custNo", required = false)
	private String custNo;

	/** 金额开始区间 **/
	@Column(name = "AMT_START", unique = false, nullable = true, length = 0)
	@ApiModelProperty(value = "金额开始区间", name = "amtStart", required = false)
	private java.math.BigDecimal amtStart;
	
	/** 金额结束区间 **/
	@Column(name = "AMT_END", unique = false, nullable = true, length = 0)
	@ApiModelProperty(value = "金额开始区间", name = "amtEnd", required = false)
	private java.math.BigDecimal amtEnd;
	
	/** 金额浮动金额 **/
	@Column(name = "AMT_FLOAT", unique = false, nullable = true, length = 0)
	@ApiModelProperty(value = "金额浮动金额", name = "amtFloat", required = false)
	private java.math.BigDecimal amtFloat;
	
	/** APPOINT_PHONE **/
	@Column(name = "APPOINT_PHONE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "手机号", name = "appointPhone", required = false)
	private String appointPhone;
	
	public String getAppointPhone() {
		return appointPhone;
	}

	public void setAppointPhone(String appointPhone) {
		this.appointPhone = appointPhone;
	}

	public String getBusTypeDetail() {
		return busTypeDetail;
	}

	public void setBusTypeDetail(String busTypeDetail) {
		this.busTypeDetail = busTypeDetail;
	}

	public java.math.BigDecimal getAmtStart() {
		return amtStart;
	}

	public void setAmtStart(java.math.BigDecimal amtStart) {
		this.amtStart = amtStart;
	}

	public java.math.BigDecimal getAmtEnd() {
		return amtEnd;
	}

	public void setAmtEnd(java.math.BigDecimal amtEnd) {
		this.amtEnd = amtEnd;
	}

	public java.math.BigDecimal getAmtFloat() {
		return amtFloat;
	}

	public void setAmtFloat(java.math.BigDecimal amtFloat) {
		this.amtFloat = amtFloat;
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
	 * @param appointOrgId
	 */
	public void setAppointOrgId(String appointOrgId) {
		this.appointOrgId = appointOrgId == null ? null : appointOrgId.trim();
	}
	
    /**
     * @return AppointOrgId
     */	
	public String getAppointOrgId() {
		return this.appointOrgId;
	}
	
	/**
	 * @param cardType
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType == null ? null : cardType.trim();
	}
	
    /**
     * @return CardType
     */	
	public String getCardType() {
		return this.cardType;
	}
	
	/**
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId == null ? null : cardId.trim();
	}
	
    /**
     * @return CardId
     */	
	public String getCardId() {
		return this.cardId;
	}
	
	/**
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate == null ? null : startDate.trim();
	}
	
    /**
     * @return StartDate
     */	
	public String getStartDate() {
		return this.startDate;
	}
	
	/**
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}
	
    /**
     * @return EndDate
     */	
	public String getEndDate() {
		return this.endDate;
	}
	
	/**
	 * @param amt
	 */
	public void setAmt(java.math.BigDecimal amt) {
		this.amt = amt;
	}
	
    /**
     * @return Amt
     */	
	public java.math.BigDecimal getAmt() {
		return this.amt;
	}
	
	/**
	 * @param busType
	 */
	public void setBusType(String busType) {
		this.busType = busType == null ? null : busType.trim();
	}
	
    /**
     * @return BusType
     */	
	public String getBusType() {
		return this.busType;
	}
	
	/**
	 * @param applyTime
	 */
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime == null ? null : applyTime.trim();
	}
	
    /**
     * @return ApplyTime
     */	
	public String getApplyTime() {
		return this.applyTime;
	}
	
	/**
	 * @param applyUserId
	 */
	public void setApplyUserId(String applyUserId) {
		this.applyUserId = applyUserId == null ? null : applyUserId.trim();
	}
	
    /**
     * @return ApplyUserId
     */	
	public String getApplyUserId() {
		return this.applyUserId;
	}
	
	/**
	 * @param applyUserName
	 */
	public void setApplyUserName(String applyUserName) {
		this.applyUserName = applyUserName == null ? null : applyUserName.trim();
	}
	
    /**
     * @return ApplyUserName
     */	
	public String getApplyUserName() {
		return this.applyUserName;
	}
	
	/**
	 * @param auditTime
	 */
	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime == null ? null : auditTime.trim();
	}
	
    /**
     * @return AuditTime
     */	
	public String getAuditTime() {
		return this.auditTime;
	}
	
	/**
	 * @param auditStatus
	 */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus == null ? null : auditStatus.trim();
	}
	
    /**
     * @return AuditStatus
     */	
	public String getAuditStatus() {
		return this.auditStatus;
	}
	
	/**
	 * @param auditBake
	 */
	public void setAuditBake(String auditBake) {
		this.auditBake = auditBake == null ? null : auditBake.trim();
	}
	
    /**
     * @return AuditBake
     */	
	public String getAuditBake() {
		return this.auditBake;
	}
	
	/**
	 * @param auditUserId
	 */
	public void setAuditUserId(String auditUserId) {
		this.auditUserId = auditUserId == null ? null : auditUserId.trim();
	}
	
    /**
     * @return AuditUserId
     */	
	public String getAuditUserId() {
		return this.auditUserId;
	}
	
	/**
	 * @param auditUserName
	 */
	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName == null ? null : auditUserName.trim();
	}
	
    /**
     * @return AuditUserName
     */	
	public String getAuditUserName() {
		return this.auditUserName;
	}
	
	/**
	 * @param etlRes
	 */
	public void setEtlRes(String etlRes) {
		this.etlRes = etlRes == null ? null : etlRes.trim();
	}
	
    /**
     * @return EtlRes
     */	
	public String getEtlRes() {
		return this.etlRes;
	}
	
	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
	
    /**
     * @return State
     */	
	public String getState() {
		return this.state;
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
	
	/**
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	
    /**
     * @return CustType
     */	
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * @param custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo == null ? null : custNo.trim();
	}
	
    /**
     * @return CustNo
     */	
	public String getCustNo() {
		return this.custNo;
	}



}