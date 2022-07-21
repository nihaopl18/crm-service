package cn.com.yusys.yscimc.marketmethod.domain;
import java.io.Serializable;
import javax.persistence.*;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * The persistent class for the CIMP_CM_NODES_PRESENTATION database table.
 * 
 */
@Entity
@Table(name="CIMP_CM_NODES_PRESENTATION")
public class CimpCmNodesPresentation extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="FORM_OPERATION_ID")
	private String formOperationId;

	@Column(name="FORM_ID")
	private String formId;

	@Column(name="FORM_OPERATION_FILED")
	private String formOperationFiled;

	@Column(name="FORM_OPERATION_NAME")
	private String formOperationName;

	@Column(name="FORM_OPERATION_TABLE")
	private String formOperationTable;

	@Column(name="FORM_OPERATION_TYPE")
	private String formOperationType;

	@Column(name="FORM_OPERATION_VAL")
	private String formOperationVal;

	@Transient
	private String nodeId;
	
	
    public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public CimpCmNodesPresentation() {
    }

	public String getFormOperationId() {
		return this.formOperationId;
	}

	public void setFormOperationId(String formOperationId) {
		this.formOperationId = formOperationId;
	}

	public String getFormId() {
		return this.formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getFormOperationFiled() {
		return this.formOperationFiled;
	}

	public void setFormOperationFiled(String formOperationFiled) {
		this.formOperationFiled = formOperationFiled;
	}

	public String getFormOperationName() {
		return this.formOperationName;
	}

	public void setFormOperationName(String formOperationName) {
		this.formOperationName = formOperationName;
	}

	public String getFormOperationTable() {
		return this.formOperationTable;
	}

	public void setFormOperationTable(String formOperationTable) {
		this.formOperationTable = formOperationTable;
	}

	public String getFormOperationType() {
		return this.formOperationType;
	}

	public void setFormOperationType(String formOperationType) {
		this.formOperationType = formOperationType;
	}

	public String getFormOperationVal() {
		return this.formOperationVal;
	}

	public void setFormOperationVal(String formOperationVal) {
		this.formOperationVal = formOperationVal;
	}

}