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
 * The persistent class for the CM_F_RC_RULE_COMPARISON database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_RULE_COMPARISON")
public class CmFRcRuleComparison extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COL_GJOIN")
	private String colGjoin;

	@Column(name="COL_GORDER")
	private String colGorder;

	@Column(name="COL_JOIN")
	private String colJoin;

	@Column(name="COL_ORDER")
	private String colOrder;

	@Column(name="COMPARISION_TYPE")
	private String comparisionType;

	@Column(name="COMPARISION_VALUE")
	private String comparisionValue;

	@Column(name="EVENT_ID")
	private String eventId;
	
	@Id
	@Generated(GenerationType.UUID)
	private String id;

	private String operator;

	@Column(name="PROCESS_ORDER")
	private String processOrder;

	@Column(name="VARIABLE_NAME")
	private String variableName;

	@Column(name="VARIABLE_TYPE")
	private String variableType;

    public CmFRcRuleComparison() {
    }

	public String getColGjoin() {
		return this.colGjoin;
	}

	public void setColGjoin(String colGjoin) {
		this.colGjoin = colGjoin;
	}

	public String getColGorder() {
		return this.colGorder;
	}

	public void setColGorder(String colGorder) {
		this.colGorder = colGorder;
	}

	public String getColJoin() {
		return this.colJoin;
	}

	public void setColJoin(String colJoin) {
		this.colJoin = colJoin;
	}

	public String getColOrder() {
		return this.colOrder;
	}

	public void setColOrder(String colOrder) {
		this.colOrder = colOrder;
	}

	public String getComparisionType() {
		return this.comparisionType;
	}

	public void setComparisionType(String comparisionType) {
		this.comparisionType = comparisionType;
	}

	public String getComparisionValue() {
		return this.comparisionValue;
	}

	public void setComparisionValue(String comparisionValue) {
		this.comparisionValue = comparisionValue;
	}

	public String getEventId() {
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getProcessOrder() {
		return this.processOrder;
	}

	public void setProcessOrder(String processOrder) {
		this.processOrder = processOrder;
	}

	public String getVariableName() {
		return this.variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getVariableType() {
		return this.variableType;
	}

	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}

}