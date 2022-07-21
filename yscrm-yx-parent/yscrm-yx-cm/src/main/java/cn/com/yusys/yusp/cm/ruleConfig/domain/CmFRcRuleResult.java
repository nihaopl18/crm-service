package cn.com.yusys.yusp.cm.ruleConfig.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * 事件引擎结果表
 * 
 */
@Entity
@Table(name="CM_F_RC_RULE_RESULT")
public class CmFRcRuleResult extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ACTION_OBJ_ID")
	private String actionObjId;

	@Column(name="ACTION_OBJ_NAME")
	private String actionObjName;

	@Column(name="ACTION_TYPE")
	private String actionType;

	@Column(name="ACTIVITY_ID")
	private String activityId;

	@Column(name="ASSEMBLY_ID")
	private String assemblyId;

	private String channel;

	@Column(name="CREATE_DATE")
	private String createDate;

	@Column(name="CUST_ID")
	private String custId;

	@Column(name="CUST_NAME")
	private String custName;

	@Column(name="EVENT_ID")
	private String eventId;

	@Column(name="EVENT_NAME")
	private String eventName;
	
	@Id
	@Generated(GenerationType.UUID)
	private String id;

	@Column(name="PARENT_ACTION_ID")
	private String parentActionId;

	@Column(name="SEQUENCE_ID")
	private String sequenceId;

	@Column(name="TEMP_CONTENT")
	private String tempContent;

	@Column(name="TRANSACTION_CODE")
	private String transactionCode;

	@Column(name="TRANSACTION_TYPE")
	private String transactionType;
	
	@Transient
	private String rcvmsg;

    public CmFRcRuleResult() {
    }

	public String getRcvmsg() {
		return rcvmsg;
	}

	public void setRcvmsg(String rcvmsg) {
		this.rcvmsg = rcvmsg;
	}

	public String getActionObjId() {
		return this.actionObjId;
	}

	public void setActionObjId(String actionObjId) {
		this.actionObjId = actionObjId;
	}

	public String getActionObjName() {
		return this.actionObjName;
	}

	public void setActionObjName(String actionObjName) {
		this.actionObjName = actionObjName;
	}

	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActivityId() {
		return this.activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getAssemblyId() {
		return this.assemblyId;
	}

	public void setAssemblyId(String assemblyId) {
		this.assemblyId = assemblyId;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
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

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentActionId() {
		return this.parentActionId;
	}

	public void setParentActionId(String parentActionId) {
		this.parentActionId = parentActionId;
	}

	public String getSequenceId() {
		return this.sequenceId;
	}

	public void setSequenceId(String sequenceId) {
		this.sequenceId = sequenceId;
	}

	public String getTempContent() {
		return this.tempContent;
	}

	public void setTempContent(String tempContent) {
		this.tempContent = tempContent;
	}

	public String getTransactionCode() {
		return this.transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}