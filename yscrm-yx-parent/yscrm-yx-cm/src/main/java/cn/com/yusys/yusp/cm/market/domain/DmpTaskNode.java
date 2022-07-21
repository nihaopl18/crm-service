package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the DMP_TASK_NODE database table.
 * 
 */
@Entity
@Table(name="DMP_TASK_NODE")
public class DmpTaskNode extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;

	@Column(name="NODE_STEP")
	private long nodeStep;

	@Column(name="SERIAL_NUMBER")
	private long serialNumber;
	
	@Column(name="NODE_TYPE")
	private String nodeType;

	@Column(name="SOURCE_COLUMNS")
	private String sourceColumns;

	@Column(name="SOURCE_TABLE")
	private String sourceTable;

	@Column(name="TARGET_COLUMNS")
	private String targetColumns;

	@Column(name="TARGET_EXISTS")
	private String targetExists;

	@Column(name="TARGET_TABLE")
	private String targetTable;

	@Column(name="TARGET_TRUNCATE")
	private String targetTruncate;

	@Column(name="TASK_CONDITION")
	private String taskCondition;

    public DmpTaskNode() {
    }

	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public long getNodeStep() {
		return nodeStep;
	}


	public void setNodeStep(long nodeStep) {
		this.nodeStep = nodeStep;
	}


	public long getSerialNumber() {
		return serialNumber;
	}


	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}


	public String getNodeType() {
		return this.nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public String getSourceColumns() {
		return this.sourceColumns;
	}

	public void setSourceColumns(String sourceColumns) {
		this.sourceColumns = sourceColumns;
	}

	public String getSourceTable() {
		return this.sourceTable;
	}

	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable;
	}

	public String getTargetColumns() {
		return this.targetColumns;
	}

	public void setTargetColumns(String targetColumns) {
		this.targetColumns = targetColumns;
	}

	public String getTargetExists() {
		return this.targetExists;
	}

	public void setTargetExists(String targetExists) {
		this.targetExists = targetExists;
	}

	public String getTargetTable() {
		return this.targetTable;
	}

	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable;
	}

	public String getTargetTruncate() {
		return this.targetTruncate;
	}

	public void setTargetTruncate(String targetTruncate) {
		this.targetTruncate = targetTruncate;
	}

	public String getTaskCondition() {
		return this.taskCondition;
	}

	public void setTaskCondition(String taskCondition) {
		this.taskCondition = taskCondition;
	}

}
