package cn.com.yusys.climp.acty.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleAction
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:06:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * 			2019-03-26 chenlin 权益引擎改造
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_ENG_RULE_ACTION")
public class LoyEngRuleAction extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;


	
	
	/** 主键ID **/
	@Id
	@Column(name = "ID", unique = false, nullable = false, length = 38)
	private java.math.BigDecimal id;
	
	/** 规则ID **/
	@Column(name = "RULE_ID", unique = false, nullable = false, length = 38)
	private java.math.BigDecimal ruleId;
	
	/** 类名 **/
	@Column(name = "CLASS_NAME", unique = false, nullable = true, length = 200)
	private String className;
	
	/** 函数名 **/
	@Column(name = "FUNCTION_NAME", unique = false, nullable = true, length = 200)
	private String functionName;
	
	/** 账户编号（积分账户、虚拟票券账户、实物礼品账户） **/
	@Column(name = "ACCOUNT_NO", unique = false, nullable = true, length = 20)
	private String accountNo;
	
	/**积分池、虚拟票券号、实物礼品编号（3种动作类型公用）*/
	@Column(name = "POOL_NO", unique = false, nullable = true, length = 32)
	private String poolNo;
	
	/**实物礼品规格（实物礼品动作类型使用，其它类型不填）*/
	@Column(name = "MODEL_ID", unique = false, nullable = true, length = 32)
	private String modelId;
	
	/** 积分有效期 **/
	@Column(name = "VALID_DATE", unique = false, nullable = true, length = 19)
	private java.math.BigDecimal validDate;
	
	/** 计算公式 **/
	@Column(name = "FORMULA_WAY", unique = false, nullable = true, length = 10)
	private String formulaWay;
	
	/** 计算公式 **/
	@Column(name = "ACTION_FORMULA", unique = false, nullable = true, length = 500)
	private String actionFormula;
	
	/** 计算公式解释 **/
	@Column(name = "ACTION_FORMULA_MEAN", unique = false, nullable = true, length = 2000)
	private String actionFormulaMean;
	
	/** 封顶值 **/
	@Column(name = "CEILING", unique = false, nullable = true, length = 19)
	private java.math.BigDecimal ceiling;
	
	/**封顶类型*/
	@Column(name = "CEILING_TYPE", unique = false, nullable = true, length = 20)
	private String ceilingType;
	
	/**归属机构*/
	@Column(name = "COST_ORG", unique = false, nullable = true, length = 20)
	private String costOrg;
	
	/**归属产品*/
	@Column(name = "COST_PRO", unique = false, nullable = true, length = 20)
	private String costPro;
	
	/**动作类型（1：积分，2：票券，3：实物礼品）*/
	@Column(name = "ACTION_TYPE", unique = false, nullable = true, length = 10)
	private String actionType;
	
	/**有效期模式(1:滚动有效、2:滚动月末有效、3:滚动年末有效)*/
	@Column(name = "VALID_DATE_MODE", unique = false, nullable = true, length = 10)
	private String validDateMode;
	
	/**是否有上线（1:是、2:否）*/
	@Column(name = "IS_UPPER_LIMIT", unique = false, nullable = true, length = 10)
	private String isUpperLimit;
	
	/**赠送库存池*/
	@Column(name = "STOCK_POOL", unique = false, nullable = true, length = 20)
	private String stockPool;
	
	@Transient
	private String formulaValue;
	@Transient
	private String formulaField;
	@Transient
	private String scoreType;
	
	public String getScoreType() {
		return scoreType;
	}

	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}

	public String getFormulaValue() {
		return formulaValue;
	}

	public void setFormulaValue(String formulaValue) {
		this.formulaValue = formulaValue;
	}

	public String getFormulaField() {
		return formulaField;
	}

	public void setFormulaField(String formulaField) {
		this.formulaField = formulaField;
	}

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
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className == null ? null : className.trim();
	}
	
    /**
     * @return ClassName
     */	
	public String getClassName() {
		return this.className;
	}
	
	/**
	 * @param functionName
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName == null ? null : functionName.trim();
	}
	
    /**
     * @return FunctionName
     */	
	public String getFunctionName() {
		return this.functionName;
	}
	
	/**
	 * @param accountNo
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo == null ? null : accountNo.trim();
	}
	
    /**
     * @return AccountNo
     */	
	public String getAccountNo() {
		return this.accountNo;
	}
	
	/**
	 * @param validDate
	 */
	public void setValidDate(java.math.BigDecimal validDate) {
		this.validDate = validDate;
	}
	
    /**
     * @return ValidDate
     */	
	public java.math.BigDecimal getValidDate() {
		return this.validDate;
	}
	
	
	public String getFormulaWay() {
		return formulaWay;
	}

	public void setFormulaWay(String formulaWay) {
		this.formulaWay = formulaWay;
	}

	/**
	 * @param actionFormula
	 */
	public void setActionFormula(String actionFormula) {
		this.actionFormula = actionFormula == null ? null : actionFormula.trim();
	}
	
    /**
     * @return ActionFormula
     */	
	public String getActionFormula() {
		return this.actionFormula;
	}
	
	/**
	 * @param actionFormulaMean
	 */
	public void setActionFormulaMean(String actionFormulaMean) {
		this.actionFormulaMean = actionFormulaMean == null ? null : actionFormulaMean.trim();
	}
	
    /**
     * @return ActionFormulaMean
     */	
	public String getActionFormulaMean() {
		return this.actionFormulaMean;
	}


    public String getPoolNo() {
		return poolNo;
	}

	public void setPoolNo(String poolNo) {
		this.poolNo = poolNo;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public java.math.BigDecimal getCeiling() {
		return ceiling;
	}

	public void setCeiling(java.math.BigDecimal ceiling) {
		this.ceiling = ceiling;
	}

	public String getCeilingType() {
		return ceilingType;
	}

	public void setCeilingType(String ceilingType) {
		this.ceilingType = ceilingType;
	}

	public String getCostOrg() {
		return costOrg;
	}

	public void setCostOrg(String costOrg) {
		this.costOrg = costOrg;
	}

	public String getCostPro() {
		return costPro;
	}

	public void setCostPro(String costPro) {
		this.costPro = costPro;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getValidDateMode() {
		return validDateMode;
	}

	public void setValidDateMode(String validDateMode) {
		this.validDateMode = validDateMode;
	}

	public String getIsUpperLimit() {
		return isUpperLimit;
	}

	public void setIsUpperLimit(String isUpperLimit) {
		this.isUpperLimit = isUpperLimit;
	}

	public String getStockPool() {
		return stockPool;
	}

	public void setStockPool(String stockPool) {
		this.stockPool = stockPool;
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
        LoyEngRuleAction other = (LoyEngRuleAction) that;
                		return (this.getClassName() == null ? other.getClassName() == null : this.getClassName().equals(other.getClassName()))
        	&& (this.getFunctionName() == null ? other.getFunctionName() == null : this.getFunctionName().equals(other.getFunctionName()))
        	&& (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
                	&& (this.getActionFormula() == null ? other.getActionFormula() == null : this.getActionFormula().equals(other.getActionFormula()))
        	&& (this.getActionFormulaMean() == null ? other.getActionFormulaMean() == null : this.getActionFormulaMean().equals(other.getActionFormulaMean()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getClassName() == null) ? 0 : getClassName().hashCode());
        result = prime * result + ((getFunctionName() == null) ? 0 : getFunctionName().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getActionFormula() == null) ? 0 : getActionFormula().hashCode());
        result = prime * result + ((getActionFormulaMean() == null) ? 0 : getActionFormulaMean().hashCode());
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
		sb.append(", className=").append(className);
		sb.append(", functionName=").append(functionName);
		sb.append(", accountNo=").append(accountNo);
		sb.append(", validDate=").append(validDate);
		sb.append(", actionFormula=").append(actionFormula);
		sb.append(", actionFormulaMean=").append(actionFormulaMean);
        sb.append("]");
        return sb.toString();
    }
}