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
 * The persistent class for the CM_F_RC_RULE_CON_COMPARISON database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_RULE_CON_COMPARISON")
public class CmFRcRuleConComparison extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COMPARISION_VALUE")
	private String comparisionValue;

	private String cycle;

	@Column(name="CYCLE_TYPE")
	private String cycleType;

	@Column(name="EVENT_ID")
	private String eventId;
	
	@Id
	@Generated(GenerationType.UUID)
	private String id;

	// 就是 累计 还是 共计
	@Column(name="STATISTICAL_METHOD")
	private String statisticalMethod;

	// 表字段参数
	@Column(name="VARIABLE_NAME")
	private String variableName;

	private String operator;
	
	@Column(name="VARIABLE_TYPE")
	private String variableType;
	
	
    public CmFRcRuleConComparison() {
    }

	public String getComparisionValue() {
		return this.comparisionValue;
	}

	public void setComparisionValue(String comparisionValue) {
		this.comparisionValue = comparisionValue;
	}

	public String getCycle() {
		return this.cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getCycleType() {
		return this.cycleType;
	}

	public void setCycleType(String cycleType) {
		this.cycleType = cycleType;
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

	public String getStatisticalMethod() {
		return this.statisticalMethod;
	}

	public void setStatisticalMethod(String statisticalMethod) {
		this.statisticalMethod = statisticalMethod;
	}

	public String getVariableName() {
		return this.variableName;
	}

	public void setVariableName(String variableName) {
		this.variableName = variableName;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getVariableType() {
		return variableType;
	}

	public void setVariableType(String variableType) {
		this.variableType = variableType;
	}

}