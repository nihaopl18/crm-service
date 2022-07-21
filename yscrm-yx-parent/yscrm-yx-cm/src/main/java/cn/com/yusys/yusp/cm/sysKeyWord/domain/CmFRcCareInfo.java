package cn.com.yusys.yusp.cm.sysKeyWord.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "CM_F_RC_CARE_INFO")
public class CmFRcCareInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CARE_ID")
	private String careId;
	
	@Column(name="CARE_NAME")
	private String careName;
	
	@Column(name="CARE_TYPE")
	private String careType;
	
	@Column(name="CARE_LEVEL")
	private String careLevel;
	
	@Column(name="CARE_WAY")
	private String careWay;
	
	@Column(name="CARE_CONTENT")
	private String careContent;
	
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

	
	

	public String getCareId() {
		return careId;
	}

	public void setCareId(String careId) {
		this.careId = careId;
	}
	
	public String getCareName() {
		return careName;
	}

	public void setCareName(String careName) {
		this.careName = careName;
	}
	
	public String getCareType() {
		return careType;
	}

	public void setCareType(String careType) {
		this.careType = careType;
	}
	
	public String getCareLevel() {
		return careLevel;
	}

	public void setCareLevel(String careLevel) {
		this.careLevel = careLevel;
	}
	
	public String getCareWay() {
		return careWay;
	}

	public void setCareWay(String careWay) {
		this.careWay = careWay;
	}
	
	public String getCareContent() {
		return careContent;
	}

	public void setCareContent(String careContent) {
		this.careContent = careContent;
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
