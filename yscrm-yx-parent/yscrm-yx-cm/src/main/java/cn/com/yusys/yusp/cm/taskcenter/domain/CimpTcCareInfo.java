package cn.com.yusys.yusp.cm.taskcenter.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * The persistent class for the CIMP_TC_CARE_INFO database table.
 * 
 */
@Entity
@Table(name="CIMP_TC_CARE_INFO")
public class CimpTcCareInfo  extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;


	@Column(name="CARE_CONTENT")
	private String careContent;
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name="CARE_ID")
	private String careId;

	@Column(name="CUSTOMER_ID")
	private String customerId;

	@Column(name="EXECUTE_USER")
	private String executeUser;

	private String execution;

	@Column(name="FEEDBACK_CONTENT")
	private String feedbackContent;

	@Column(name="FEEDBACK_TIME")
	private String feedbackTime;

	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATE_DT")
	private Date lastUpdateDt;

	@Column(name="LAST_UPDATE_USER")
	private String lastUpdateUser;

	@Column(name="TASK_ID")
	private String taskId;

	public CimpTcCareInfo() {
	}

	public String getCareContent() {
		return this.careContent;
	}

	public void setCareContent(String careContent) {
		this.careContent = careContent;
	}

	public String getCareId() {
		return this.careId;
	}

	public void setCareId(String careId) {
		this.careId = careId;
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getExecuteUser() {
		return this.executeUser;
	}

	public void setExecuteUser(String executeUser) {
		this.executeUser = executeUser;
	}

	public String getExecution() {
		return this.execution;
	}

	public void setExecution(String execution) {
		this.execution = execution;
	}

	public String getFeedbackContent() {
		return this.feedbackContent;
	}

	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	public String getFeedbackTime() {
		return this.feedbackTime;
	}

	public void setFeedbackTime(String feedbackTime) {
		this.feedbackTime = feedbackTime;
	}

	public Date getLastUpdateDt() {
		return this.lastUpdateDt;
	}

	public void setLastUpdateDt(Date lastUpdateDt) {
		this.lastUpdateDt = lastUpdateDt;
	}

	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getTaskId() {
		return this.taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

}