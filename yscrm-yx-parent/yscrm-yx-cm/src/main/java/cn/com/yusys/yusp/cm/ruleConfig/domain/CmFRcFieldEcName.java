package cn.com.yusys.yusp.cm.ruleConfig.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;


/**
 * The persistent class for the CM_F_RC_FIELD_EC_NAME database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_FIELD_EC_NAME")
public class CmFRcFieldEcName extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CREATE_DATE")
	private String createDate;

	@Column(name="CREATE_ORG")
	private String createOrg;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DELETE_SIGN")
	private String deleteSign;

//	@Column(name="F_NAME")
	private String fname;

	@Column(name="FIELD_C_NAME")
	private String fieldCName;

	@Column(name="FIELD_E_NAME")
	private String fieldEName;
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name="FIELD_ID")
	private String fieldId;

	@Column(name="FIELD_LENGTH")
	private BigDecimal fieldLength;

	@Column(name="FIELD_TYPE")
	private String fieldType;

	@Column(name="IS_DISPLAY")
	private String isDisplay;

	private String remark;

	@Column(name="TABLE_ID")
	private String tableId;

	@Column(name="UPDATE_DATE")
	private String updateDate;

	@Column(name="UPDATE_ORG")
	private String updateOrg;

	@Column(name="UPDATE_USER")
	private String updateUser;

	private String magnifier;
	
    public CmFRcFieldEcName() {
    }

	public String getMagnifier() {
		return magnifier;
	}

	public void setMagnifier(String magnifier) {
		this.magnifier = magnifier;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrg() {
		return this.createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDeleteSign() {
		return this.deleteSign;
	}

	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getFieldCName() {
		return this.fieldCName;
	}

	public void setFieldCName(String fieldCName) {
		this.fieldCName = fieldCName;
	}

	public String getFieldEName() {
		return this.fieldEName;
	}

	public void setFieldEName(String fieldEName) {
		this.fieldEName = fieldEName;
	}

	public String getFieldId() {
		return this.fieldId;
	}

	public void setFieldId(String fieldId) {
		this.fieldId = fieldId;
	}

	public BigDecimal getFieldLength() {
		return this.fieldLength;
	}

	public void setFieldLength(BigDecimal fieldLength) {
		this.fieldLength = fieldLength;
	}

	public String getFieldType() {
		return this.fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getIsDisplay() {
		return this.isDisplay;
	}

	public void setIsDisplay(String isDisplay) {
		this.isDisplay = isDisplay;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrg() {
		return this.updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

}