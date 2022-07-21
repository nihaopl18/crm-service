package cn.com.yusys.yscrm.mktactivity.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name="OCRM_F_MK_ACTI_CUST")
public class OcrmFMkActiCustInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="RECORD_ID")
	private BigDecimal recordId;
	
	public BigDecimal getRecordId() { return recordId; }
	public void setRecordId(BigDecimal recordId) { this.recordId=recordId; }
	
	@Column(name="ACTI_ID")
	private BigDecimal actiId;
	
	public BigDecimal getActiId() { return actiId; }
	public void setActiId(BigDecimal actiId) { this.actiId=actiId; }

	@Column(name="CUST_ID")
	private String custId;
	
	public String getCustId() { return custId; }
	public void setCustId(String custId) { this.custId=custId; }
	
	@Column(name="CUST_NAME")
	private String custName;
	
	public String getCustName() { return custName; }
	public void setCustName(String custName) { this.custName=custName; }

	@Column(name="AIM_CUST_SOURCE")
	private String aimCustSource;
	
	public String getAimCustSource() { return aimCustSource; }
	public void setAimCustSource(String aimCustSource) { this.aimCustSource=aimCustSource; }

	@Column(name="PROGRESS_STEP")
	private String progressStep;
	
	public String getProgressStep() { return progressStep; }
	public void setProgressStep(String progressStep) { this.progressStep=progressStep; }

	@Column(name="RELATION_USER")
	private String relationUser;
	
	public String getRelationUser() { return relationUser; }
	public void setRelationUser(String relationUser) { this.relationUser=relationUser; }
	
	@Column(name="RELATION_DATE")
	private Date relationDate;
	
	public Date getRelationDate() { return relationDate; }
	public void setRelationDate(Date relationDate) { this.relationDate=relationDate; }
	
	@Column(name="CUST_STATE")
	private String custState;
	
	public String getCustState() { return custState; }
	public void setCustState(String custState) { this.custState=custState; }
	
	@Column(name="CUST_MANAGER")
	private String custManager;
	
	public String getCustManager() { return custManager; }
	public void setCustManager(String custManager) { this.custManager=custManager; }
	
	@Column(name="CUST_MANAGER_ORG")
	private String custManagerOrg;
	
	public String getCustManagerOrg() { return custManagerOrg; }
	public void setCustManagerOrg(String custManagerOrg) { this.custManagerOrg=custManagerOrg; }
	
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
	
	@Column(name="UPDATE_USER")
	private String updateUser;
	
	public String getUpdateUser() { return updateUser; }
	public void setUpdateUser(String updateUser) { this.updateUser=updateUser; }
	
	@Column(name="UPDATE_DATE")
	private Date updateDate;
	
	public Date getUpdateDate() { return updateDate; }
	public void setUpdateDate(Date updateDate) { this.updateDate=updateDate; }
	
	@Column(name="UPDATE_ORG")
	private String updateOrg;
	
	public String getUpdateOrg() { return updateOrg; }
	public void setUpdateOrg(String updateOrg) { this.updateOrg=updateOrg; }
	
}