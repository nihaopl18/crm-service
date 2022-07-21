package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

@Entity
@Table(name = "CIMP_CG_CUST_BELONG")
public class CimpCgCustBelong extends BaseDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
    private String id;
	
	@Column(name = "CUST_ID")
    private String custId;
	
	@Column(name = "MGR_ID")
    private String mgrId;
	
	@Column(name = "MAIN_TYPE")
    private String mainType;
	
	@Column(name = "MAINTAIN_RIGHT")
    private String maintainRight;
	
	@Column(name = "CHECK_RIGHT")
    private String checkRight;
	
	@Column(name = "ASSIGN_USER")
    private String assignUser;

	@Column(name = "ASSIGN_USERNAME")
    private String assignUsername;

	@Column(name = "ASSIGN_DATE")
    private String assignDate;

	@Column(name = "INSTITUTION")
    private String instituion;

	@Column(name = "INSTITUTION_NAME")
    private String instituionName;

	@Column(name = "MGR_NAME")
    private String mgrName;

	@Column(name = "EFFECT_DATE")
    private String effectDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getMgrId() {
		return mgrId;
	}

	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}

	public String getMainType() {
		return mainType;
	}

	public void setMainType(String mainType) {
		this.mainType = mainType;
	}

	public String getMaintainRight() {
		return maintainRight;
	}

	public void setMaintainRight(String maintainRight) {
		this.maintainRight = maintainRight;
	}

	public String getCheckRight() {
		return checkRight;
	}

	public void setCheckRight(String checkRight) {
		this.checkRight = checkRight;
	}

	public String getAssignUser() {
		return assignUser;
	}

	public void setAssignUser(String assignUser) {
		this.assignUser = assignUser;
	}

	public String getAssignUsername() {
		return assignUsername;
	}

	public void setAssignUsername(String assignUsername) {
		this.assignUsername = assignUsername;
	}

	public String getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(String assignDate) {
		this.assignDate = assignDate;
	}

	public String getInstituion() {
		return instituion;
	}

	public void setInstituion(String instituion) {
		this.instituion = instituion;
	}

	public String getInstituionName() {
		return instituionName;
	}

	public void setInstituionName(String instituionName) {
		this.instituionName = instituionName;
	}

	public String getMgrName() {
		return mgrName;
	}

	public void setMgrName(String mgrName) {
		this.mgrName = mgrName;
	}

	public String getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}
	
	
}