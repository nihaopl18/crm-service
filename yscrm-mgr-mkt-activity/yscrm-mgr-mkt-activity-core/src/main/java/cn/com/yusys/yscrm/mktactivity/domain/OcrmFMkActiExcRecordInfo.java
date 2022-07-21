package cn.com.yusys.yscrm.mktactivity.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.annotation.Transient;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name="OCRM_F_MK_ACTI_EXC_RECORD")
public class OcrmFMkActiExcRecordInfo extends BaseDomain implements Serializable {
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

	@Column(name="MAJOR_MANGER")
	private String majorManger;
	
	public String getMajorManger() { return majorManger; }
	public void setMajorManger(String majorManger) { this.majorManger=majorManger; }

	@Column(name="MAJOR_ORG")
	private String majorOrg;
	
	public String getMajorOrg() { return majorOrg; }
	public void setMajorOrg(String majorOrg) { this.majorOrg=majorOrg; }

	@Column(name="PROGRESS_STAGE")
	private String progressStage;
	
	public String getProgressStage() { return progressStage; }
	public void setProgressStage(String progressStage) { this.progressStage=progressStage; }
	
	@Column(name="RELATION_CUSTOMER")
	private String relationCustomer;
	
	public String getRelationCustomer() { return relationCustomer; }
	public void setRelationCustomer(String relationCustomer) { this.relationCustomer=relationCustomer; }
	
	@Column(name="PRODUCT_ID")
	private String productId;
	
	public String getProductId() { return productId; }
	public void setProductId(String productId) { this.productId=productId; }
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	public String getProductName() { return productName; }
	public void setProductName(String productName) { this.productName=productName; }
	
	@Column(name="EXECUTOR_ID")
	private String executorId;
	
	public String getExecutorId() { return executorId; }
	public void setExecutorId(String executorId) { this.executorId=executorId; }
	
	@Column(name="EXECUTOR_NAME")
	private String executorName;
	
	public String getExecutorName() { return executorName; }
	public void setExecutorName(String executorName) { this.executorName=executorName; }
	
	@Column(name="EXECUTOR_DATE")
	private Date executorDate;
	
	public Date getExecutorDate() { return executorDate; }
	public void setExecutorDate(Date executorDate) { this.executorDate=executorDate; }
	
	@Column(name="EXECUTOR_CANAL")
	private String executorCanal;
	
	public String getExecutorCanal() { return executorCanal; }
	public void setExecutorCanal(String executorCanal) { this.executorCanal=executorCanal; }
	
	@Column(name="EXECUTOR_RESULT")
	private String executorResult;
	
	public String getExecutorResult() { return executorResult; }
	public void setExecutorResult(String executorResult) { this.executorResult=executorResult; }
	
	@Column(name="PREP_EVENT")
	private String prepEvent;
	
	public String getPrepEvent() { return prepEvent; }
	public void setPrepEvent(String prepEvent) { this.prepEvent=prepEvent; }
	
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
	
	@Transient
	private String mktAppState;
	public String getMktAppState() { return mktAppState; }
	public void setMktAppState(String mktAppState) { this.mktAppState=mktAppState; }
}
