package cn.com.yusys.yusp.cm.cust.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ACIM_F_CI_CUSTOMER")
public class AcimFCiCustomer extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CUST_ID")//客户编号
    private String custId;
	
	@Column(name = "CUST_TYPE")//客户类型
    private String custType;
	
	@Column(name = "IDENT_TYPE")//证件类型
    private String identType;
	
	@Column(name = "IDENT_NO")//证件号码
    private String identNo;
	
	@Column(name = "CUST_NAME")//客户名称
    private String custName;
	
	@Column(name = "SHORT_NAME")//客户简称
    private String shortName;
	
	@Column(name = "EN_NAME")//英文名称
    private String enName;
	
	@Column(name = "EN_SHORT_NAME")//英文简称
    private String enShortName;
	
	@Column(name = "CUST_STAT")//客户状态
    private String custStat;
	
	@Column(name = "POTENTIAL_FLAG")//潜在客户标识
    private String potentialFlag;
	
	@Column(name = "MERGE_FLAG")//客户合并标志
    private String mergeFlag;
	
	@Column(name = "CUST_LEVEL")//客户级别
    private String custLevel;

	@Column(name = "CORE_NO")//核心客户号
    private String coreNo;

	@Column(name = "SOURCE_CHANNEL")//客户来源渠道
    private String sourceChannel;

	@Column(name = "CREATE_DATE")//客户创建日期
    private String createDate;

	@Column(name = "CREATE_TIME")//客户创建时间
    private String createTime;

	@Column(name = "CREATE_TELLER_NO")//客户创建柜员编号
    private String createTellerNo;

	@Column(name = "LAST_UPDATE_SYS")//最后更新系统
    private String lastUpdateSys;
	
	@Column(name = "LAST_UPDATE_USER")//最后更新人
    private String lastUpdateUser;
	
	@Column(name = "LAST_UPDATE_TM")//最后更新时间
    private String lastUpdateTm;
	
	@Column(name = "ETL_DATE")//etl日期
    private String etlDate;
	
	@Column(name = "COMBINE_FLAG")//客户合并标识
    private String combineFlag;
	
	@Column(name = "CONTACT_NUMBER")//联系方式
    private String contactNumber;
	
	@Column(name = "BELONG_ORG")//归属机构
    private String belongOrg;
	
	@Column(name = "BELONG_MGR")//归属客户经理
    private String belongMgr;
	
	@Column(name = "RISK_LEVEL")//客户风险偏好等级
    private String riskLevel;
	
	@Column(name = "WORTH_LEVEL")//客户价值等级
    private String worthLevel;
	
	@Column(name = "SERVICE_LEVEL")//客户服务等级
    private String serviceLevel;
	

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getWorthLevel() {
		return worthLevel;
	}

	public void setWorthLevel(String worthLevel) {
		this.worthLevel = worthLevel;
	}

	public String getServiceLevel() {
		return serviceLevel;
	}

	public void setServiceLevel(String serviceLevel) {
		this.serviceLevel = serviceLevel;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustType() {
		return custType;
	}

	public void setCustType(String custType) {
		this.custType = custType;
	}

	public String getIdentType() {
		return identType;
	}

	public void setIdentType(String identType) {
		this.identType = identType;
	}

	public String getIdentNo() {
		return identNo;
	}

	public void setIdentNo(String identNo) {
		this.identNo = identNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getEnShortName() {
		return enShortName;
	}

	public void setEnShortName(String enShortName) {
		this.enShortName = enShortName;
	}

	public String getCustStat() {
		return custStat;
	}

	public void setCustStat(String custStat) {
		this.custStat = custStat;
	}

	public String getPotentialFlag() {
		return potentialFlag;
	}

	public void setPotentialFlag(String potentialFlag) {
		this.potentialFlag = potentialFlag;
	}

	public String getMergeFlag() {
		return mergeFlag;
	}

	public void setMergeFlag(String mergeFlag) {
		this.mergeFlag = mergeFlag;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCoreNo() {
		return coreNo;
	}

	public void setCoreNo(String coreNo) {
		this.coreNo = coreNo;
	}

	public String getSourceChannel() {
		return sourceChannel;
	}

	public void setSourceChannel(String sourceChannel) {
		this.sourceChannel = sourceChannel;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTellerNo() {
		return createTellerNo;
	}

	public void setCreateTellerNo(String createTellerNo) {
		this.createTellerNo = createTellerNo;
	}

	public String getLastUpdateSys() {
		return lastUpdateSys;
	}

	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys;
	}

	public String getLastUpdateUser() {
		return lastUpdateUser;
	}

	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser;
	}

	public String getLastUpdateTm() {
		return lastUpdateTm;
	}

	public void setLastUpdateTm(String lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm;
	}

	public String getEtlDate() {
		return etlDate;
	}

	public void setEtlDate(String etlDate) {
		this.etlDate = etlDate;
	}

	public String getCombineFlag() {
		return combineFlag;
	}

	public void setCombineFlag(String combineFlag) {
		this.combineFlag = combineFlag;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getBelongOrg() {
		return belongOrg;
	}

	public void setBelongOrg(String belongOrg) {
		this.belongOrg = belongOrg;
	}

	public String getBelongMgr() {
		return belongMgr;
	}

	public void setBelongMgr(String belongMgr) {
		this.belongMgr = belongMgr;
	}
	
	
}
