package cn.com.yusys.climp.acty.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleComparison
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_ENG_RULE_COMPARISON")
public class LoyEngRuleComparison extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键ID **/
	@Id
	@Column(name = "ID", unique = false, nullable = false, length = 38)
	private java.math.BigDecimal id;
	
	/** 规则ID **/
	@Column(name = "RULE_ID", unique = false, nullable = false, length = 38)
	private java.math.BigDecimal ruleId;
	
	/** 变量名 **/
	@Column(name = "VARIABLE_NAME", unique = false, nullable = true, length = 200)
	private String variableName;
	
	/** 运算符 **/
	@Column(name = "OPERATOR", unique = false, nullable = true, length = 20)
	private String operator;
	
	/** 比较值 **/
	@Column(name = "COMPARISION_VALUE", unique = false, nullable = true, length = 4000)
	private String comparisionValue;
	
	/** 处理优先级 **/
	@Column(name = "PROCESS_ORDER", unique = false, nullable = true, length = 4)
	private short processOrder;
	
	/** 变量类型 **/
	@Column(name = "VARIABLE_TYPE", unique = false, nullable = true, length = 10)
	private String variableType;
	
	
	/**
	 * @param id
	 */
	public void setId(java.math.BigDecimal id) {
		this.id = id;
	}
	
    /**
     * @return Id
     */	
	public java.math.BigDecimal getId() {
		return this.id;
	}
	
	/**
	 * @param ruleId
	 */
	public void setRuleId(java.math.BigDecimal ruleId) {
		this.ruleId = ruleId;
	}
	
    /**
     * @return RuleId
     */	
	public java.math.BigDecimal getRuleId() {
		return this.ruleId;
	}
	
	/**
	 * @param variableName
	 */
	public void setVariableName(String variableName) {
		this.variableName = variableName == null ? null : variableName.trim();
	}
	
    /**
     * @return VariableName
     */	
	public String getVariableName() {
		return this.variableName;
	}
	
	/**
	 * @param operator
	 */
	public void setOperator(String operator) {
		this.operator = operator == null ? null : operator.trim();
	}
	
    /**
     * @return Operator
     */	
	public String getOperator() {
		return this.operator;
	}
	
	/**
	 * @param comparisionValue
	 */
	public void setComparisionValue(String comparisionValue) {
		this.comparisionValue = comparisionValue == null ? null : comparisionValue.trim();
	}
	
    /**
     * @return ComparisionValue
     */	
	public String getComparisionValue() {
		return this.comparisionValue;
	}
	
	/**
	 * @param processOrder
	 */
	public void setProcessOrder(short processOrder) {
		this.processOrder = processOrder;
	}
	
    /**
     * @return ProcessOrder
     */	
	public short getProcessOrder() {
		return this.processOrder;
	}
	
	/**
	 * @param variableType
	 */
	public void setVariableType(String variableType) {
		this.variableType = variableType == null ? null : variableType.trim();
	}
	
    /**
     * @return VariableType
     */	
	public String getVariableType() {
		return this.variableType;
	}


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LoyEngRuleComparison other = (LoyEngRuleComparison) that;
                		return (this.getVariableName() == null ? other.getVariableName() == null : this.getVariableName().equals(other.getVariableName()))
        	&& (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
        	&& (this.getComparisionValue() == null ? other.getComparisionValue() == null : this.getComparisionValue().equals(other.getComparisionValue()))
                	&& (this.getVariableType() == null ? other.getVariableType() == null : this.getVariableType().equals(other.getVariableType()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVariableName() == null) ? 0 : getVariableName().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getComparisionValue() == null) ? 0 : getComparisionValue().hashCode());
        result = prime * result + ((getVariableType() == null) ? 0 : getVariableType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", ruleId=").append(ruleId);
		sb.append(", variableName=").append(variableName);
		sb.append(", operator=").append(operator);
		sb.append(", comparisionValue=").append(comparisionValue);
		sb.append(", processOrder=").append(processOrder);
		sb.append(", variableType=").append(variableType);
        sb.append("]");
        return sb.toString();
    }
}