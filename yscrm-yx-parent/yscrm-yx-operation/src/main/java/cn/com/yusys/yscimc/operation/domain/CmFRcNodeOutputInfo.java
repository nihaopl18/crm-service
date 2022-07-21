package cn.com.yusys.yscimc.operation.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CIMP_CM_NODES_DISPLAY_OUTPUT")
public class CmFRcNodeOutputInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="FORM_OUT_ID")
	private String formOutId;
	
	public String getFormOutId() { return formOutId; }
	public void setFormOutId(String formOutId) { this.formOutId=formOutId; }
	
	@Column(name="FORM_ID")
	private String formId;
	
	public String getFormId() { return formId; }
	public void setFormId(String formId) { this.formId=formId; }
	
	@Column(name="FORM_OUT_TABLE")
	private String formOutTable;
	
	public String getFormOutTable() { return formOutTable; }
	public void setFormOutTable(String formOutTable) { this.formOutTable=formOutTable; }
	
	@Column(name="FORM_OUT_FILED")
	private String formOutFiled;
	
	public String getFormOutFiled() { return formOutFiled; }
	public void setFormOutFiled(String formOutFiled) { this.formOutFiled=formOutFiled; }
	
	@Column(name="FORM_OUT_NAME")
	private String formOutName;
	
	public String getFormOutName() { return formOutName; }
	public void setFormOutName(String formOutName) { this.formOutName=formOutName; }
	
	@Column(name="FORM_OUT_VAL")
	private String formOutVal;
	
	public String getFormOutVal() { return formOutVal; }
	public void setFormOutVal(String formOutVal) { this.formOutVal=formOutVal; }
	
	@Column(name="FORM_OUT_TYPE")
	private String formOutType;
	
	public String getFormOutType() { return formOutType; }
	public void setFormOutType(String formOutType) { this.formOutType=formOutType; }
	
	@Column(name="UP_FORM_OUT_ID")
	private String upFormOutId;
	
	public String getUpFormOutId() { return upFormOutId; }
	public void setUpFormOutId(String upFormOutId) { this.upFormOutId=upFormOutId; }
	
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
