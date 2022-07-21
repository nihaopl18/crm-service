package cn.com.yusys.yusp.cm.processparam.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CIMP_CM_NODES_DISPLAY_INPUT")
public class CmFRcNodeInputInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="FORM_IN_ID")
	private String formInId;
	
	public String getFormInId() { return formInId; }
	public void setFormInId(String formInId) { this.formInId=formInId; }
	
	@Column(name="FORM_ID")
	private String formId;
	
	public String getFormId() { return formId; }
	public void setFormId(String formId) { this.formId=formId; }
	
	@Column(name="FORM_IN_TABLE")
	private String formInTable;
	
	public String getFormInTable() { return formInTable; }
	public void setFormInTable(String formInTable) { this.formInTable=formInTable; }
	
	@Column(name="FORM_IN_FILED")
	private String formInFiled;
	
	public String getFormInFiled() { return formInFiled; }
	public void setFormInFiled(String formInFiled) { this.formInFiled=formInFiled; }
	
	@Column(name="FORM_IN_NAME")
	private String formInName;
	
	public String getFormInName() { return formInName; }	
	public void setFormInName(String formInName) { this.formInName=formInName; }
	
	@Column(name="FORM_IN_VAL")
	private String formInVal;
	
	public String getFormInVal() { return formInVal; }
	public void setFormInVal(String formInVal) { this.formInVal=formInVal; }
	
	@Column(name="FORM_IN_TYPE")
	private String formInType;
	
	public String getFormInType() { return formInType; }
	public void setFormInType(String formInType) { this.formInType=formInType; }
	
	@Column(name="UP_FORM_IN_ID")
	private String upFormInId;
	
	public String getUpFormInId() { return upFormInId; }
	public void setUpFormInId(String upFormInId) { this.upFormInId=upFormInId; }
	
	@Column(name="CONDITION")
	private String condition;
	
	public String getCondition() { return condition; }
	public void setCondition(String condition) { this.condition=condition; }
	
	@Column(name="SOURCE_TYPE")
	private String sourceType;
	
	public String getSourceType() { return sourceType; }
	public void setSourceType(String sourceType) { this.sourceType=sourceType; }
	
	@Column(name="MESSAGE")
	private String message;
	
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message=message; }
	
	@Transient
	private String flag;
	
	public String getFlag() { return flag; }
	public void setFlag(String flag) { this.flag=flag; }
	
	@Transient
	private String nodeId;
	
	public String getNodeId() { return nodeId; }
	public void setNodeId(String nodeId) { this.nodeId=nodeId; }
	
}
