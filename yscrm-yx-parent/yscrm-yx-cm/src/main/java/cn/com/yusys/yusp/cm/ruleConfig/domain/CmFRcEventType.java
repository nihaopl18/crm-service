package cn.com.yusys.yusp.cm.ruleConfig.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the CM_F_RC_EVENT_TYPE database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_EVENT_TYPE")
public class CmFRcEventType extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CREATE_DATE")
	private String createDate;

	@Column(name="CREATE_ORG")
	private String createOrg;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DELETE_SIGN")
	private String deleteSign;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="EVENT_TYPE_ID")
	private String eventTypeId;

	@Column(name="EVENT_TYPE_NAME")
	private String eventTypeName;

	@Column(name="PARENT_EVENT_TYPE_ID")
	private String parentEventTypeId;

	private String remark;

	@Column(name="SEQ_NO")
	private String seqNo;

	@Column(name="UPDATE_DATE")
	private String updateDate;

	@Column(name="UPDATE_ORG")
	private String updateOrg;

	@Column(name="UPDATE_USER")
	private String updateUser;

	@Column(name="USE_FLAG")
	private String useFlag;

    public CmFRcEventType() {
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

	public String getEventTypeId() {
		return this.eventTypeId;
	}

	public void setEventTypeId(String eventTypeId) {
		this.eventTypeId = eventTypeId;
	}

	public String getEventTypeName() {
		return this.eventTypeName;
	}

	public void setEventTypeName(String eventTypeName) {
		this.eventTypeName = eventTypeName;
	}

	public String getParentEventTypeId() {
		return this.parentEventTypeId;
	}

	public void setParentEventTypeId(String parentEventTypeId) {
		this.parentEventTypeId = parentEventTypeId;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSeqNo() {
		return this.seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
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

}