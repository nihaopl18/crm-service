package cn.com.yusys.yscrm.salesoppor.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name="OCRM_F_MK_MKT_ACTIVITY")
public class OcrmFMkMktActivityInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACTIVITY_NO")
	private String activityNo;
	
	public String getActivityNo() { return activityNo; }
	public void setActivityNo(String activityNo) { this.activityNo=activityNo; }

	@Column(name="ACTIVITY_NAME")
	private String activityName;
	
	public String getActivityName() { return activityName; }
	public void setActivityName(String activityName) { this.activityName=activityName; }

	@Column(name="ACTIVITY_EXECUTE_DATE")
	private Date activityExecuteDate;
	
	public Date getActivityExecuteDate() { return activityExecuteDate; }
	public void setActivityExecuteDate(Date activityExecuteDate) { this.activityExecuteDate=activityExecuteDate; }
	
	@Column(name="ACTIVITY_STAGE")
	private String activityStage;
	
	public String getActivityStage() { return activityStage; }
	public void setActivityStage(String activityStage) { this.activityStage=activityStage; }

	@Column(name="ACTIVITY_EXECUTE_TYPE")
	private String activityExecuteType;
	
	public String getActivityExecuteType() { return activityExecuteType; }
	public void setActivityExecuteType(String activityExecuteType) { this.activityExecuteType=activityExecuteType; }

	@Column(name="ACTIVITY_EXECUTE_USER")
	private String activityExecuteUser;
	
	public String getActivityExecuteUser() { return activityExecuteUser; }
	public void setActivityExecuteUser(String activityExecuteUser) { this.activityExecuteUser=activityExecuteUser; }

	@Column(name="ACTIVITY_EXECUTE_ORG")
	private String activityExecuteOrg;
	
	public String getActivityExecuteOrg() { return activityExecuteOrg; }
	public void setActivityExecuteOrg(String activityExecuteOrg) { this.activityExecuteOrg=activityExecuteOrg; }
	
	@Column(name="NEXT_CONTACT_DATE")
	private Date nextContactDate;
	
	public Date getNextContactDate() { return nextContactDate; }
	public void setNextContactDate(Date nextContactDate) { this.nextContactDate=nextContactDate; }
	
	@Column(name="NEXT_EXECUTE_TYPE")
	private String nextExecuteType;
	
	public String getNextExecuteType() { return nextExecuteType; }
	public void setNextExecuteType(String nextExecuteType) { this.nextExecuteType=nextExecuteType; }
	
	@Column(name="ACTIVITY_CONTENT")
	private String activityContent;
	
	public String getActivityContent() { return activityContent; }
	public void setActivityContent(String activityContent) { this.activityContent=activityContent; }
	
	@Column(name="NEXT_ACTIVITY_CONTENT")
	private String nextActivityContent;
	
	public String getNextActivityContent() { return nextActivityContent; }
	public void setNextActivityContent(String nextActivityContent) { this.nextActivityContent=nextActivityContent; }
	
	@Column(name="REMARK")
	private String remark;
	
	public String getRemark() { return remark; }
	public void setRemark(String remark) { this.remark=remark; }
	
	@Column(name="CREATE_USER")
	private String createUser;
	
	public String getCreateUser() { return createUser; }
	public void setCreateUser(String createUser) { this.createUser=createUser; }
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	public Date getCreateDate() { return createDate; }
	public void setCreateDate(Date createDate) { this.createDate=createDate; }
	
	@Column(name="CREATE_ORG")
	private String createOrg;
	
	public String getCreateOrg() { return createOrg; }
	public void setCreateOrg(String createOrg) { this.createOrg=createOrg; }
	
	@Column(name="UPDATA_USER")
	private String updataUser;
	
	public String getUpdataUser() { return updataUser; }
	public void setUpdataUser(String updataUser) { this.updataUser=updataUser; }
	
	@Column(name="UPDATA_ORG")
	private String updataOrg;
	
	public String getUpdataOrg() { return updataOrg; }
	public void setUpdataOrg(String updataOrg) { this.updataOrg=updataOrg; }
	
	@Column(name="UPDATA_DATE")
	private Date updataDate;
	
	public Date getUpdataDate() { return updataDate; }
	public void setUpdataDate(Date updataDate) { this.updataDate=updataDate; }
	
	@Column(name="BUSINESS_NO")
	private String businessNo;
	
	public String getBusinessNo() { return businessNo; }
	public void setBusinessNo(String businessNo) { this.businessNo=businessNo; }
	
}

