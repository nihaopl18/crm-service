package cn.com.yusys.yscimc.operation.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the CIMP_CM_NODES_DISPLAY_OUTPUT database table.
 * 
 */
@Entity
@Table(name="CIMP_CM_NODES_DISPLAY_OUTPUT")
public class CimpCmNodesDisplayOutput extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="FORM_OUT_ID")
	private String formOutId;

	private String condition;

	@Column(name="FORM_ID")
	private String formId;

	@Column(name="FORM_OUT_FILED")
	private String formOutFiled;

	@Column(name="FORM_OUT_NAME")
	private String formOutName;

	@Column(name="FORM_OUT_TABLE")
	private String formOutTable;

	@Column(name="FORM_OUT_TYPE")
	private String formOutType;

	@Column(name="FORM_OUT_VAL")
	private String formOutVal;

    @Lob()
	private String message;

	@Column(name="SOURCE_TYPE")
	private String sourceType;

	@Column(name="UP_FORM_OUT_ID")
	private String upFormOutId;

    public CimpCmNodesDisplayOutput() {
    }

	public String getFormOutId() {
		return this.formOutId;
	}

	public void setFormOutId(String formOutId) {
		this.formOutId = formOutId;
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

	public String getFormOutFiled() {
		return this.formOutFiled;
	}

	public void setFormOutFiled(String formOutFiled) {
		this.formOutFiled = formOutFiled;
	}

	public String getFormOutName() {
		return this.formOutName;
	}

	public void setFormOutName(String formOutName) {
		this.formOutName = formOutName;
	}

	public String getFormOutTable() {
		return this.formOutTable;
	}

	public void setFormOutTable(String formOutTable) {
		this.formOutTable = formOutTable;
	}

	public String getFormOutType() {
		return this.formOutType;
	}

	public void setFormOutType(String formOutType) {
		this.formOutType = formOutType;
	}

	public String getFormOutVal() {
		return this.formOutVal;
	}

	public void setFormOutVal(String formOutVal) {
		this.formOutVal = formOutVal;
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

	public String getUpFormOutId() {
		return this.upFormOutId;
	}

	public void setUpFormOutId(String upFormOutId) {
		this.upFormOutId = upFormOutId;
	}

}