package cn.com.yusys.yusp.cm.ruleConfig.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the CM_F_RC_TABLE_EC_NAME database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_TABLE_EC_NAME")
public class CmFRcTableEcName extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CREATE_DATE")
	private String createDate;

	@Column(name="CREATE_ORG")
	private String createOrg;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DELETE_SIGN")
	private String deleteSign;

	@Column(name="OBJECT_TYPE")
	private String objectType;

	private String remark;

	@Column(name="TABLE_C_NAME")
	private String tableCName;

	@Column(name="TABLE_E_NAME")
	private String tableEName;
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name="TABLE_ID")
	private String tableId;

	@Column(name="TRANSACTION_CODE")
	private String transactionCode;

	@Column(name="TYPE_ID")
	private String typeId;

	@Column(name="UPDATE_DATE")
	private String updateDate;

	@Column(name="UPDATE_ORG")
	private String updateOrg;

	@Column(name="UPDATE_USER")
	private String updateUser;

    public CmFRcTableEcName() {
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

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTableCName() {
		return this.tableCName;
	}

	public void setTableCName(String tableCName) {
		this.tableCName = tableCName;
	}

	public String getTableEName() {
		return this.tableEName;
	}

	public void setTableEName(String tableEName) {
		this.tableEName = tableEName;
	}

	public String getTableId() {
		return this.tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getTransactionCode() {
		return this.transactionCode;
	}

	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
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