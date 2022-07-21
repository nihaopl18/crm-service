package cn.com.yusys.yusp.cm.processparam.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "CIMP_CM_NODES_PRESENTATION")
public class CmFRcNodePresentInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="FORM_OPERATION_ID")
	private String formOperationId;
	
	public String getFormOperationId() { return formOperationId; }
	public void setFormOperationId(String formOperationId) { this.formOperationId=formOperationId; }
	
	@Column(name="FORM_ID")
	private String formId;
	
	public String getFormId() { return formId; }
	public void setFormId(String formId) { this.formId=formId; }
	
	@Column(name="FORM_OPERATION_TABLE")
	private String formOperationTable;
	
	public String getFormOperationTable() { return formOperationTable; }
	public void setFormOperationTable(String formOperationTable) { this.formOperationTable=formOperationTable; }
	
	@Column(name="FORM_OPERATION_FILED")
	private String formOperationFiled;
	
	public String getFormOperationFiled() { return formOperationFiled; }
	public void setFormOperationFiled(String formOperationFiled) { this.formOperationFiled=formOperationFiled; }
	
	@Column(name="FORM_OPERATION_NAME")
	private String formOperationName;
	
	public String getFormOperationName() { return formOperationName; }
	public void setFormOperationName(String formOperationName) { this.formOperationName=formOperationName; }
	
	@Column(name="FORM_OPERATION_VAL")
	private String formOperationVal;
	
	public String getFormOperationVal() { return formOperationVal; }
	public void setFormOperationVal(String formOperationVal) { this.formOperationVal=formOperationVal; }
	
	@Column(name="FORM_OPERATION_TYPE")
	private String formOperationType;
	
	public String getFormOperationType() { return formOperationType; }
	public void setFormOperationType(String formOperationType) { this.formOperationType=formOperationType; }
	
	@Transient
	private String flag;
	
	public String getFlag() { return flag; }
	public void setFlag(String flag) { this.flag=flag; }
	
	@Transient
	private String nodeId;
	
	public String getNodeId() { return nodeId; }
	public void setNodeId(String nodeId) { this.nodeId=nodeId; }
	
}
