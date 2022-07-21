package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the CIMP_CM_ASSEM_INOUT database table.
 * 
 */
@Entity
@Table(name="CIMP_CM_ASSEM_INOUT")
public class CimpCmAssemInout extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="ASSEMBLY_ID")
	private String assemblyId;

	@Column(name="IN_OR_OUT")
	private String inOrOut;

	@Column(name="INOUT_FILE")
	private String inoutFile;

	@Lob
	@Column(name="\"MESSAGE\"")
	private String message;
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name="PARAM_ID")
	private String paramId;

	@Column(name="PARAM_NAME")
	private String paramName;

	@Column(name="PARAM_TYPE")
	private String paramType;

	@Column(name="SOURCE_TARGET_FIELD")
	private String sourceTargetField;

	@Column(name="SOURCE_TARGET_TAB")
	private String sourceTargetTab;

	@Column(name="TASK_CONDITION")
	private String taskCondition;

	public CimpCmAssemInout() {
	}

	public String getAssemblyId() {
		return this.assemblyId;
	}

	public void setAssemblyId(String assemblyId) {
		this.assemblyId = assemblyId;
	}

	public String getInOrOut() {
		return this.inOrOut;
	}

	public void setInOrOut(String inOrOut) {
		this.inOrOut = inOrOut;
	}

	public String getInoutFile() {
		return this.inoutFile;
	}

	public void setInoutFile(String inoutFile) {
		this.inoutFile = inoutFile;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getParamId() {
		return this.paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
	}

	public String getParamName() {
		return this.paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}

	public String getParamType() {
		return this.paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public String getSourceTargetField() {
		return this.sourceTargetField;
	}

	public void setSourceTargetField(String sourceTargetField) {
		this.sourceTargetField = sourceTargetField;
	}

	public String getSourceTargetTab() {
		return this.sourceTargetTab;
	}

	public void setSourceTargetTab(String sourceTargetTab) {
		this.sourceTargetTab = sourceTargetTab;
	}

	public String getTaskCondition() {
		return this.taskCondition;
	}

	public void setTaskCondition(String taskCondition) {
		this.taskCondition = taskCondition;
	}

}