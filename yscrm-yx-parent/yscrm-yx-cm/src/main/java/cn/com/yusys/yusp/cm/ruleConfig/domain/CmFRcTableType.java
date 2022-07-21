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
 * The persistent class for the CM_F_RC_TABLE_TYPE database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_TABLE_TYPE")
public class CmFRcTableType extends BaseDomain  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="CREATE_DATE")
	private String createDate;

	@Column(name="CREATE_ORG")
	private String createOrg;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DELETE_SIGN")
	private String deleteSign;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="TYPE_ID")
	private String typeId;

	@Column(name="TYPE_LEVEL")
	private String typeLevel;

	@Column(name="TYPE_NAME")
	private String typeName;

	@Column(name="TYPE_PARENT_ID")
	private String typeParentId;

	@Column(name="TYPE_SEQ")
	private String typeSeq;

	@Column(name="UPDATE_DATE")
	private String updateDate;

	@Column(name="UPDATE_ORG")
	private String updateOrg;

	@Column(name="UPDATE_USER")
	private String updateUser;

    public CmFRcTableType() {
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

	public String getTypeId() {
		return this.typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeLevel() {
		return this.typeLevel;
	}

	public void setTypeLevel(String typeLevel) {
		this.typeLevel = typeLevel;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeParentId() {
		return this.typeParentId;
	}

	public void setTypeParentId(String typeParentId) {
		this.typeParentId = typeParentId;
	}

	public String getTypeSeq() {
		return this.typeSeq;
	}

	public void setTypeSeq(String typeSeq) {
		this.typeSeq = typeSeq;
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