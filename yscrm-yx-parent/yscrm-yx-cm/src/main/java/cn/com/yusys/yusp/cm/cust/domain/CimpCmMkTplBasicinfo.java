package cn.com.yusys.yusp.cm.cust.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CIMP_CM_MK_TPL_BASICINFO")
public class CimpCmMkTplBasicinfo extends BaseDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "TEMP_ID")
	private String tempId;
	
	@Column(name = "TEMP_NAME")
	private String tempName;
	
	@Column(name = "TEMP_TYPE")
	private String tempType;
	
	@Column(name = "ACHIEVE_GOAL")
	private String achieveGoal;
	
	@Column(name = "TEMP_STS")
	private String tempSts;
	
	@Column(name = "REMARK")
	private String remark;
	
	@Column(name = "CREATOR_ID")
    private String creatorId;

	@Column(name = "CREATE_DATE")
    private Date createDate;

	@Column(name = "LAST_CHG_USR")
    private String lastChgUsr;

	@Column(name = "LAST_CHG_DT")
    private Date lastChgDt;

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}

	public String getTempType() {
		return tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

	public String getAchieveGoal() {
		return achieveGoal;
	}

	public void setAchieveGoal(String achieveGoal) {
		this.achieveGoal = achieveGoal;
	}

	public String getTempSts() {
		return tempSts;
	}

	public void setTempSts(String tempSts) {
		this.tempSts = tempSts;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastChgUsr() {
		return lastChgUsr;
	}

	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}

	public Date getLastChgDt() {
		return lastChgDt;
	}

	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
	
	
}