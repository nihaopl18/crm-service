package cn.com.yusys.yusp.cm.sysKeyWord.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CM_F_RC_RISK_INFO")
public class CmFRcRiskInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="RISK_ID")
	private String riskId;
	
	@Column(name="RISK_NAME")
	private String riskName;
	
	@Column(name="RISK_DESCRIBE")
	private String riskDescribe;
	
	@Column(name="RISK_TYPE")
	private String riskType;
	
	@Column(name="RISK_LEVEL")
	private String riskLevel;
	
	@Column(name="RISK_WAY")
	private String riskWay;
	
	@Column(name="CREAT_USER")
	private String creatUser;

	@Column(name="CREAT_DATE")
	private String creatDate;

	@Column(name="UPDATA_USER")
	private String updataUser;

	@Column(name="UPDATA_DATE")
	private String updataDate;
	
	@Column(name="CREAT_USER_NAME")
	private String creatUserName;
	
	@Column(name="UPDATA_USER_NAME")
	private String updataUserName;

	
	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	public String getRiskDescribe() {
		return riskDescribe;
	}

	public void setRiskDescribe(String riskDescribe) {
		this.riskDescribe = riskDescribe;
	}

	public String getRiskId() {
		return riskId;
	}

	public void setRiskId(String riskId) {
		this.riskId = riskId;
	}

	public String getRiskType() {
		return riskType;
	}

	public void setRiskType(String riskType) {
		this.riskType = riskType;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getRiskWay() {
		return riskWay;
	}

	public void setRiskWay(String riskWay) {
		this.riskWay = riskWay;
	}
	
	public String getCreatUser() {
		return creatUser;
	}

	public void setCreatUser(String creatUser) {
		this.creatUser = creatUser;
	}
	
	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}
	
	public String getUpdataUser() {
		return updataUser;
	}

	public void setUpdataUser(String updataUser) {
		this.updataUser = updataUser;
	}
	
	public String getUpdataDate() {
		return updataDate;
	}

	public void setUpdataDate(String updataDate) {
		this.updataDate = updataDate;
	}
	
	public String getCreatUserName() {
		return creatUserName;
	}

	public void setCreatUserName(String creatUserName) {
		this.creatUserName = creatUserName;
	}
	
	public String getUpdataUserName() {
		return updataUserName;
	}

	public void setUpdataUserName(String updataUserName) {
		this.updataUserName = updataUserName;
	}

}
