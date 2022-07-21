package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the CIMP_CM_NODES_DISPLAY_INPUT database table.
 * 
 */
@Entity
@Table(name="CIMP_CM_NODES_DISPLAY_INPUT")
public class CimpCmNodesDisplayInput extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="FORM_IN_ID")
	private String formInId;

	private String condition;

	@Column(name="FORM_ID")
	private String formId;

	@Column(name="FORM_IN_FILED")
	private String formInFiled;

	@Column(name="FORM_IN_NAME")
	private String formInName;

	@Column(name="FORM_IN_TABLE")
	private String formInTable;

	@Column(name="FORM_IN_TYPE")
	private String formInType;

	@Column(name="FORM_IN_VAL")
	private String formInVal;

    @Lob()
	private String message;

	@Column(name="SOURCE_TYPE")
	private String sourceType;

	@Column(name="UP_FORM_IN_ID")
	private String upFormInId;

    public CimpCmNodesDisplayInput() {
    }

	public String getFormInId() {
		return this.formInId;
	}

	public void setFormInId(String formInId) {
		this.formInId = formInId;
	}

	public String getCondition() {
		return this.condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getFormId() {
		return this.formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getFormInFiled() {
		return this.formInFiled;
	}

	public void setFormInFiled(String formInFiled) {
		this.formInFiled = formInFiled;
	}

	public String getFormInName() {
		return this.formInName;
	}

	public void setFormInName(String formInName) {
		this.formInName = formInName;
	}

	public String getFormInTable() {
		return this.formInTable;
	}

	public void setFormInTable(String formInTable) {
		this.formInTable = formInTable;
	}

	public String getFormInType() {
		return this.formInType;
	}

	public void setFormInType(String formInType) {
		this.formInType = formInType;
	}

	public String getFormInVal() {
		return this.formInVal;
	}

	public void setFormInVal(String formInVal) {
		this.formInVal = formInVal;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getSourceType() {
		return this.sourceType;
	}

	public void setSourceType(String sourceType) {
		this.sourceType = sourceType;
	}

	public String getUpFormInId() {
		return this.upFormInId;
	}

	public void setUpFormInId(String upFormInId) {
		this.upFormInId = upFormInId;
	}

}