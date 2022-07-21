package cn.com.yusys.yscrm.salesoppor.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name="OCRM_F_MK_MKT_SALESOPPOR")
public class OcrmFMkMktSalesOpporInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BUSINESS_NO")
	private String businessNo;
	
	public String getBusinessNo() { return businessNo; }
	public void setBusinessNo(String businessNo) { this.businessNo=businessNo; }

	@Column(name="BUSINESS_NAME")
	private String businessName;
	
	public String getBusinessName() { return businessName; }
	public void setBusinessName(String businessName) { this.businessName=businessName; }

	@Column(name="BUSINESS_STATE")
	private String businessState;
	
	public String getBusinessState() { return businessState; }
	public void setBusinessState(String businessState) { this.businessState=businessState; }

	@Column(name="BUSINESS_STAGE")
	private String businessStage;
	
	public String getBusinessStage() { return businessStage; }
	public void setBusinessStage(String businessStage) { this.businessStage=businessStage; }

	@Column(name="BUSINESS_SOURCE")
	private String businessSource;
	
	public String getBusinessSource() { return businessSource; }
	public void setBusinessSource(String businessSource) { this.businessSource=businessSource; }

	@Column(name="BUSINESS_FIT_CUST")
	private String businessFitCust;
	
	public String getBusinessFitCust() { return businessFitCust; }
	public void setBusinessFitCust(String businessFitCust) { this.businessFitCust=businessFitCust; }

	@Column(name="BUSINESS_TYPE")
	private String businessType;
	
	public String getBusinessType() { return businessType; }
	public void setBusinessType(String businessType) { this.businessType=businessType; }
	
	@Column(name="BUSINESS_START_DATE")
	private Date businessStartDate;
	
	public Date getBusinessStartDate() { return businessStartDate; }
	public void setBusinessStartDate(Date businessStartDate) { this.businessStartDate=businessStartDate; }
	
	@Column(name="BUSINESS_END_DATE")
	private Date businessEndDate;
	
	public Date getBusinessEndDate() { return businessEndDate; }
	public void setBusinessEndDate(Date businessEndDate) { this.businessEndDate=businessEndDate; }
	
	@Column(name="BUSINESS_VALID_DATE")
	private Date businessValidDate;
	
	public Date getBusinessValidDate() { return businessValidDate; }
	public void setBusinessValidDate(Date businessValidDate) { this.businessValidDate=businessValidDate; }
	
	@Column(name="MARKET_ACTIVITY_ID")
	private String marketActivityId;
	
	public String getMarketActivityId() { return marketActivityId; }
	public void setMarketActivityId(String marketActivityId) { this.marketActivityId=marketActivityId; }
	
	@Column(name="MARKET_ACTIVITY_NAME")
	private String marketActivityName;
	
	public String getMarketActivityName() { return marketActivityName; }
	public void setMarketActivityName(String marketActivityName) { this.marketActivityName=marketActivityName; }
	
	@Column(name="BUSINESS_CONTENT")
	private String businessContent;
	
	public String getBusinessContent() { return businessContent; }
	public void setBusinessContent(String businessContent) { this.businessContent=businessContent; }
	
	@Column(name="CUST_ID")
	private String custId;
	
	public String getCustId() { return custId; }
	public void setCustId(String custId) { this.custId=custId; }
	
	@Column(name="CUST_NAME")
	private String custName;
	
	public String getCustName() { return custName; }
	public void setCustName(String custName) { this.custName=custName; }
	
	@Column(name="CUST_CONTACT")
	private String custContact;
	
	public String getCustContact() { return custContact; }
	public void setCustContact(String custContact) { this.custContact=custContact; }
	
	@Column(name="CUST_CONCACT_INFO")
	private String custConcactInfo;
	
	public String getCustConcactInfo() { return custConcactInfo; }
	public void setCustConcactInfo(String custConcactInfo) { this.custConcactInfo=custConcactInfo; }
	
	@Column(name="CONTACT_PROD_ID")
	private String contactProdId;
	
	public String getContactProdId() { return contactProdId; }
	public void setContactProdId(String contactProdId) { this.contactProdId=contactProdId; }
	
	@Column(name="CONTACT_PROD_NAME")
	private String contactProdName;
	
	public String getContactProdName() { return contactProdName; }
	public void setContactProdName(String contactProdName) { this.contactProdName=contactProdName; }
	
	@Column(name="CUST_TYPE")
	private String custType;
	
	public String getCustType() { return custType; }
	public void setCustType(String custType) { this.custType=custType; }
	
	@Column(name="CUST_GROUP_ID")
	private String custGroupId;
	
	public String getCustGroupId() { return custGroupId; }
	public void setCustGroupId(String custGroupId) { this.custGroupId=custGroupId; }
	
	@Column(name="CUST_GROUP_NAME")
	private String custGroupName;
	
	public String getCustGroupName() { return custGroupName; }
	public void setCustGroupName(String custGroupName) { this.custGroupName=custGroupName; }
	
	@Column(name="EXPECT_AMOUNT")
	private float expectAmount;
	
	public float getExpectAmount() { return expectAmount; }
	public void setExpectAmount(float expectAmount) { this.expectAmount=expectAmount; }
	
	@Column(name="REACH_AMOUNT")
	private float reachAmount;
	
	public float getReachAmount() { return reachAmount; }
	public void setReachAmount(float reachAmount) { this.reachAmount=reachAmount; }
	
	@Column(name="SUCCESS_CHANCE")
	private String successChance;
	
	public String getSuccessChance() { return successChance; }
	public void setSuccessChance(String successChance) { this.successChance=successChance; }
	
	@Column(name="BUSINESS_BUDGET")
	private float businessBudget;
	
	public float getBusinessBudget() { return businessBudget; }
	public void setBusinessBudget(float businessBudget) { this.businessBudget=businessBudget; }
	
	@Column(name="CREATE_USER")
	private String createUser;
	
	public String getCreateUser() { return createUser; }
	public void setCreateUser(String createUser) { this.createUser=createUser; }
	
	@Column(name="CREATE_ORG")
	private String createOrg;
	
	public String getCreateOrg() { return createOrg; }
	public void setCreateOrg(String createOrg) { this.createOrg=createOrg; }
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	public Date getCreateDate() { return createDate; }
	public void setCreateDate(Date createDate) { this.createDate=createDate; }
	
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
	
	@Column(name="EXECUTE_USER")
	private String executeUser;
	
	public String getExecuteUser() { return executeUser; }
	public void setExecuteUser(String executeUser) { this.executeUser=executeUser; }
	
	@Column(name="EXECUTE_ORG")
	private String executeOrg;
	
	public String getExecuteOrg() { return executeOrg; }
	public void setExecuteOrg(String executeOrg) { this.executeOrg=executeOrg; }
	
	@Column(name="ASSIGN_USER")
	private String assignUser;
	
	public String getAssignUser() { return assignUser; }
	public void setAssignUser(String assignUser) { this.assignUser=assignUser; }
	
	@Column(name="ASSIGN_DATE")
	private Date assignDate;
	
	public Date getAssignDate() { return assignDate; }
	public void setAssignDate(Date assignDate) { this.assignDate=assignDate; }
	
	@Column(name="ASSIGN_ORG")
	private String assignOrg;
	
	public String getAssignOrg() { return assignOrg; }
	public void setAssignOrg(String assignOrg) { this.assignOrg=assignOrg; }
	
	@Column(name="RECEIVE_USER")
	private String receiveUser;
	
	public String getReceiveUser() { return receiveUser; }
	public void setReceiveUser(String receiveUser) { this.receiveUser=receiveUser; }
	
	@Column(name="RECEIVE_ORG")
	private String receiveOrg;
	
	public String getReceiveOrg() { return receiveOrg; }
	public void setReceiveOrg(String receiveOrg) { this.receiveOrg=receiveOrg; }
	
	@Column(name="RECEIVE_REASON")
	private String receiveReason;
	
	public String getReceiveReason() { return receiveReason; }
	public void setReceiveReason(String receiveReason) { this.receiveReason=receiveReason; }
	
	@Column(name="RECEIVE_DATE")
	private Date receiveDate;
	
	public Date getReceiveDate() { return receiveDate; }
	public void setReceiveDate(Date receiveDate) { this.receiveDate=receiveDate; }
	
	@Column(name="BACK_REASON")
	private String backReason;
	
	public String getBackReason() { return backReason; }
	public void setBackReason(String backReason) { this.backReason=backReason; }
	
	@Column(name="OFF_STAT")
	private String offStat;
	
	public String getOffStat() { return offStat; }
	public void setOffStat(String offStat) { this.offStat=offStat; }
	
	@Column(name="OFF_FAIL_REASON")
	private String offFailReason;
	
	public String getOffFailReason() { return offFailReason; }
	public void setOffFailReason(String offFailReason) { this.offFailReason=offFailReason; }
	
	
}

