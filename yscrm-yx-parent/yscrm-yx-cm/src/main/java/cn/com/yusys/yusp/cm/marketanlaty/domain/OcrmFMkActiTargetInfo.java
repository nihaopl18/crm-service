package cn.com.yusys.yusp.cm.marketanlaty.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="OCRM_F_MK_ACTI_TARGET")
public class OcrmFMkActiTargetInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TARGET_ID")
	private BigDecimal targetId;
	
	public BigDecimal getTargetId() { return targetId; }
	public void setTargetId(BigDecimal targetId) { this.targetId=targetId; }
	
	@Column(name="ACTI_ID")
	private BigDecimal actiId;
	
	public BigDecimal getActiId() { return actiId; }
	public void setActiId(BigDecimal actiId) { this.actiId=actiId; }

	@Column(name="EXE_OBJ_TYPE")
	private String exeObjType;
	
	public String getExeObjType() { return exeObjType; }
	public void setExeObjType(String exeObjType) { this.exeObjType=exeObjType; }
	
	@Column(name="EXE_OBJ_CODE")
	private String exeObjCode;
	
	public String getExeObjCode() { return exeObjCode; }
	public void setExeObjCode(String exeObjCode) { this.exeObjCode=exeObjCode; }

	@Column(name="EXE_OBJ_NAME")
	private String exeObjName;
	
	public String getExeObjName() { return exeObjName; }
	public void setExeObjName(String exeObjName) { this.exeObjName=exeObjName; }

	@Column(name="TARGET_CODE")
	private String targetCode;
	
	public String getTargetCode() { return targetCode; }
	public void setTargetCode(String targetCode) { this.targetCode=targetCode; }

	@Column(name="TARGET_NAME")
	private String targetName;
	
	public String getTargetName() { return targetName; }
	public void setTargetName(String targetName) { this.targetName=targetName; }
	
	@Column(name="TARGET_VALUE")
	private BigDecimal targetValue;
	
	public BigDecimal getTargetValue() { return targetValue; }
	public void setTargetValue(BigDecimal targetValue) { this.targetValue=targetValue; }
	
	@Column(name="ORIGNAL_VAL")
	private BigDecimal orignalVal;
	
	public BigDecimal getOrignalVal() { return orignalVal; }
	public void setOrignalVal(BigDecimal orignalVal) { this.orignalVal=orignalVal; }
	
	@Column(name="ACHIEVE_VALUE")
	private BigDecimal achieveValue;
	
	public BigDecimal getAchieveValue() { return achieveValue; }
	public void setAchieveValue(BigDecimal achieveValue) { this.achieveValue=achieveValue; }
	
	@Column(name="ACHIEVE_PERCENT")
	private BigDecimal achievePercent;
	
	public BigDecimal getAchievePercent() { return achievePercent; }
	public void setAchievePercent(BigDecimal achievePercent) { this.achievePercent=achievePercent; }	
	
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
