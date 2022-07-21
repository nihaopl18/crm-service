package cn.com.yusys.yusp.cm.cust.domain;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.Id;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
@Entity
@Table(name = "CIM_F_MM_TAG_TAGS")
public class CimFMmTagTagsInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "TAG_NO")
	private String tagNo;
	
	@Column(name = "GROUP_NO")
	private String groupNo;
	
	@Column(name = "PARENT_NO")
	private String parentNo;
	
	@Column(name = "TAG_NAME")
	private String tagName;
	
	@Column(name = "TAG_DESC")
	private String tagDesc;
	
	@Column(name = "TIMELINES_TYPE")
	private String timelinesType;
	
	@Column(name = "PROCESS_MODE")
	private String processMode;
	
	@Column(name = "MODEL_CODE")
	private String modelCode;
	
	@Column(name = "UPDATE_FREQUENCY")
	private String updateFrequency;
	
	@Column(name = "TAG_PRI")
	private String tagPri;
	
	@Column(name = "TAG_APPLY")
	private String tagApply;
	
	@Column(name = "TAG_LIFECYCLE")
	private String tagLifecycle;
	
	@Column(name = "IF_AVAILABLE")
	private String ifAvailable;
	
	@Column(name = "AVAILABLE_DATE")
	private Date availableDate;
	
	@Column(name = "DISABLE_DATE")
	private Date disableDate;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "CREATE_USER")
	private String createUser;
	
	@Column(name = "CREATE_ORG")
	private String createOrg;
	
	@Column(name = "CREATE_SYS")
	private String createSys;
	
	@Column(name = "LAST_UPDATE_DT")
	private String lastUpdateDt;
	
	@Column(name = "LAST_UPDATE_USER")
	private String lastUpdateUser;
	
	@Column(name = "TAG_RESTS")
	private String tagRests;
	
	@Transient
	private String groupName;

	@Transient 
	private String tagNos;

	//********************************************************
	
	public String getTagNo() {
		return tagNo;
	}
	
	public void setTagNo(String tagNo) {
		this.tagNo = tagNo;
	}
	
	public String getGroupNo() {
		return groupNo;
	}
	
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}
	
	public String getParentNo() {
		return parentNo;
	}
	
	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}
	
	public String getTagName() {
		return tagName;
	}
	
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	
	public String getTagDesc() {
		return tagDesc;
	}
	
	public void setTagDesc(String tagDesc) {
		this.tagDesc = tagDesc;
	}
	
	public String getTimelinesType() {
		return timelinesType;
	}
	
	public void setTimelinesType(String timelinesType) {
		this.timelinesType = timelinesType;
	}
	
	public String getProcessMode() {
		return processMode;
	}
	
	public void setProcessMode(String processMode) {
		this.processMode = processMode;
	}
	
	public String getModelCode() {
		return modelCode;
	}
	
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	
	public String getUpdateFrequency() {
		return updateFrequency;
	}
	
	public void setUpdateFrequency(String updateFrequency) {
		this.updateFrequency = updateFrequency;
	}
	
	public String getTagPri() {
		return tagPri;
	}
	
	public void setTagPri(String tagPri) {
		this.tagPri = tagPri;
	}
	
	public String getTagApply() {
		return tagApply;
	}
	
	public void setTagApply(String tagApply) {
		this.tagApply = tagApply;
	}
	
	public String getTagLifecycle() {
		return tagLifecycle;
	}
	
	public void setTagLifecycle(String tagLifecycle) {
		this.tagLifecycle = tagLifecycle;
	}
	
	public String getIfAvailable() {
		return ifAvailable;
	}
	
	public void setIfAvailable(String ifAvailable) {
		this.ifAvailable = ifAvailable;
	}
	
	public Date getAvailableDate() {
		return availableDate;
	}
	
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	
	public Date getDisableDate() {
		return disableDate;
	}
	
	public void setDisableDate(Date disableDate) {
		this.disableDate = disableDate;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	public String getCreateOrg() {
		return createOrg;
	}
	
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}
	
	public String getCreateSys() {
		return createSys;
	}
	
	public void setCreateSys(String createSys) {
		this.createSys = createSys;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getTagNos() {
		return tagNos;
	}
	
	public void setTagNos(String tagNos) {
		this.tagNos = tagNos;
	}
	
	public String getLastUpdateDt() {
		return lastUpdateDt;
	}
	
	public void setLastUpdateDt(String lastUpdateDt) {
		this.lastUpdateDt = lastUpdateDt;
	}
	
	public String getLastUpdateUser() {
		return lastUpdateUser;
	}
	
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}
	
	public String getTagRests() {
		return tagRests;
	}
	
	public void setTagRests(String tagRests) {
		this.tagRests = tagRests;
	}
}
