package cn.com.yusys.yusp.cm.productmanager.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CM_F_RC_MARKET_TARGET")
public class CmFRcProdMarketTargetInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ID")
	private String id;
	
	public String getId() { return id; }
	public void setId(String id) { this.id=id; }
	
	@Column(name="TARGET_ID")
	private String targetId;
	
	public String getTargetId() { return targetId; }
	public void setTargetId(String targetId) { this.targetId=targetId; }
	
	@Column(name="TARGET_NAME")
	private String targetName;
	
	public String getTargetName() { return targetName; }
	public void setTargetName(String targetName) { this.targetName=targetName; }
	
	@Column(name="TARGET_DESC")
	private String targetDesc;
	
	public String getTargetDesc() { return targetDesc; }
	public void setTargetDesc(String targetDesc) { this.targetDesc=targetDesc; }
	
	@Column(name="CHECK_FREQ")
	private String checkFreq;
	
	public String getCheckFreq() { return checkFreq; }
	public void setCheckFreq(String checkFreq) { this.checkFreq=checkFreq; }
	
	@Column(name="START_DATE")
	private Date startDate;
	
	public Date getStartDate() { return startDate; }
	public void setStartDate(Date startDate) { this.startDate=startDate; }
	
	@Column(name="END_DATE")
	private Date endDate;
	
	public Date getEndDate() { return endDate; }
	public void setEndDate(Date endDate) { this.endDate=endDate; }
	
	@Column(name="TARGET_STATE")
	private String targetState;
	
	public String getTargetState() { return targetState; }
	public void setTargetState(String targetState) { this.targetState=targetState; }
	
	@Column(name="CREATE_USER")
	private String createUser;
	
	public String getCreateUser() { return createUser; }
	public void setCreateUser(String createUser) { this.createUser=createUser; }
	
	@Column(name="CREATE_DATE")
	private Date createDate;
	
	public Date getCreateDate() { return createDate; }
	public void setCreateDate(Date createDate) { this.createDate=createDate; }	
	
	@Column(name="CREATE_USER_NAME")
	private String createUserName;
	
	public String getCreateUserName() { return createUserName; }
	public void setCreateUserName(String createUserName) { this.createUserName=createUserName; }
	
	@Column(name="LAST_UPDATA_USER")
	private String lastUpdataUser;
	
	public String getLastUpdataUser() { return lastUpdataUser; }
	public void setLastUpdataUser(String lastUpdataUser) { this.lastUpdataUser=lastUpdataUser; }
	
	@Column(name="LAST_UPDATA_DATE")
	private Date lastUpdataDate;
	
	public Date getLastUpdataDate() { return lastUpdataDate; }
	public void setLastUpdataDate(Date lastUpdataDate) { this.lastUpdataDate=lastUpdataDate; }
	
	@Column(name="LAST_UPDATE_USER_NAME")
	private String lastUpdateUserName;
	
	public String getLastUpdateUserName() { return lastUpdateUserName; }
	public void setLastUpdateUserName(String lastUpdateUserName) { this.lastUpdateUserName=lastUpdateUserName; }
	
	@Column(name="LAST_UPDATA_ORG")
	private String lastUpdataOrg;
	
	public String getLastUpdataOrg() { return lastUpdataOrg; }
	public void setLastUpdataOrg(String lastUpdataOrg) { this.lastUpdataOrg=lastUpdataOrg; }
	
	@Transient
	private String productId;
	
	public String getProductId() { return productId; }
	public void setProductId(String productId) { this.productId=productId; }
	
}
