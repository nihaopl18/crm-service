package cn.com.yusys.yusp.cm.ruleConfig.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the CM_F_RC_EVENT_INFO database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_EVENT_INFO")
public class CmFRcEventInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	
	@Column(name="BEGIN_DATE")
	private String beginDate;

	private String condition;

	@Column(name="CREATE_DATE")
	private String createDate;

	@Column(name="CREATE_ORG")
	private String createOrg;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DELETE_SIGN")
	private String deleteSign;

	@Column(name="END_DATE")
	private String endDate;
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name="EVENT_ID")
	private String eventId;

	@Column(name="EVENT_NAME")
	private String eventName;

	@Column(name="EVENT_PRIORITY")
	private BigDecimal eventPriority;

	@Column(name="EVENT_TYPE_ID")
	private String eventTypeId;

	private String remark;

	@Column(name="RULE_DESC")
	private String ruleDesc;

	@Column(name="TRANSACTION_CODE")
	private String transactionCode;

	@Column(name="UPDATE_DATE")
	private String updateDate;

	@Column(name="UPDATE_ORG")
	private String updateOrg;

	@Column(name="UPDATE_USER")
	private String updateUser;

	@Column(name="USE_FLAG")
	private String useFlag;

	@Column(name="WF_APPR_STS")
	private String wfApprSts;

	@Column(name="ASSEMBLY_ID")
	private String assemblyId;
	
	@Column(name="TRANSACTION_TYPE")
	private String transactionType;
	
	@Transient
	private String eventTypeName;
	
	@Column(name="ACTIVITY_ID")
	private String activityId;
	
    public CmFRcEventInfo() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getEventTypeName() {
		return eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	public String getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrg() {
		return this.createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDeleteSign() {
		return this.deleteSign;
	}

	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEventId() {
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public BigDecimal getEventPriority() {
		return this.eventPriority;
	}

	public void setEventPriority(BigDecimal eventPriority) {
		this.eventPriority = eventPriority;
	}

	public String getEventTypeId() {
		return this.eventTypeId;
	}

	public void setEventTypeId(String eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRuleDesc() {
		return this.ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public String getTransactionCode() {
		return this.transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrg() {
		return this.updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getUseFlag() {
		return this.useFlag;
	}

	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag;
	}

	public String getWfApprSts() {
		return this.wfApprSts;
	}

	public void setWfApprSts(String wfApprSts) {
		this.wfApprSts = wfApprSts;
	}

	public String getAssemblyId() {
		return assemblyId;
	}

	public void setAssemblyId(String assemblyId) {
		this.assemblyId = assemblyId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}