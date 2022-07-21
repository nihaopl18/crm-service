package cn.com.yusys.climp.acty.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * 		2019-03-26 chenlin 权益引擎改造
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_ENG_RULE_INFO")
public class LoyEngRuleInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键ID **/
	@Id
	@Column(name = "ID", unique = false, nullable = false, length = 38)
	private java.math.BigDecimal id;
	
	/** 规则集ID **/
	@Column(name = "RULE_SET_ID", unique = false, nullable = false, length = 38)
	private java.math.BigDecimal ruleSetId;
	
	/** 比较条件 **/
	@Column(name = "CONDITION", unique = false, nullable = false, length = 4000)
	private String condition;
	
	/** 比较条件解释 **/
	@Column(name = "CONDITION_MEAN", unique = false, nullable = true, length = 4000)
	private String conditionMean;
	
	/** 处理顺序 **/
	@Column(name = "PROCESS_ORDER", unique = false, nullable = false, length = 4)
	private short processOrder;
	
	/** 开始日期 **/
	@Column(name = "BEGIN_DATE", unique = false, nullable = true, length = 7)
	private Date beginDate;
	
	/** 结束日期 **/
	@Column(name = "END_DATE", unique = false, nullable = true, length = 7)
	private Date endDate;
	
	/** 规则名称 **/
	@Column(name = "RULE_NAME", unique = false, nullable = false, length = 200)
	private String ruleName;
	
	/** 规则描述 **/
	@Column(name = "RULE_DESC", unique = false, nullable = true, length = 256)
	private String ruleDesc;
	
	/** 删除标识 **/
	@Column(name = "DELETE_SIGN", unique = false, nullable = true, length = 10)
	private String deleteSign;
	
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
	 * @param ruleSetId
	 */
	public void setRuleSetId(java.math.BigDecimal ruleSetId) {
		this.ruleSetId = ruleSetId;
	}
	
    /**
     * @return RuleSetId
     */	
	public java.math.BigDecimal getRuleSetId() {
		return this.ruleSetId;
	}
	
	/**
	 * @param condition
	 */
	public void setCondition(String condition) {
		this.condition = condition == null ? null : condition.trim();
	}
	
    /**
     * @return Condition
     */	
	public String getCondition() {
		return this.condition;
	}
	
	/**
	 * @param conditionMean
	 */
	public void setConditionMean(String conditionMean) {
		this.conditionMean = conditionMean == null ? "" : conditionMean.trim();
	}
	
    /**
     * @return ConditionMean
     */	
	public String getConditionMean() {
		return this.conditionMean;
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
	 * @param beginDate
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
    /**
     * @return BeginDate
     */	
	public Date getBeginDate() {
		return this.beginDate;
	}
	
	/**
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
    /**
     * @return EndDate
     */	
	public Date getEndDate() {
		return this.endDate;
	}
	

	
	/**
	 * @param ruleName
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName == null ? null : ruleName.trim();
	}
	
    /**
     * @return RuleName
     */	
	public String getRuleName() {
		return this.ruleName;
	}
	
	/**
	 * @param ruleDesc
	 */
	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc == null ? null : ruleDesc.trim();
	}
	
    /**
     * @return RuleDesc
     */	
	public String getRuleDesc() {
		return this.ruleDesc;
	}
	
	/**
	 * @param deleteSign
	 */
	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign == null ? null : deleteSign.trim();
	}
	
    /**
     * @return DeleteSign
     */	
	public String getDeleteSign() {
		return this.deleteSign;
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
        LoyEngRuleInfo other = (LoyEngRuleInfo) that;
                		return (this.getCondition() == null ? other.getCondition() == null : this.getCondition().equals(other.getCondition()))
        	&& (this.getConditionMean() == null ? other.getConditionMean() == null : this.getConditionMean().equals(other.getConditionMean()))
        	&& (this.getRuleName() == null ? other.getRuleName() == null : this.getRuleName().equals(other.getRuleName()))
        	&& (this.getRuleDesc() == null ? other.getRuleDesc() == null : this.getRuleDesc().equals(other.getRuleDesc()))
        	&& (this.getDeleteSign() == null ? other.getDeleteSign() == null : this.getDeleteSign().equals(other.getDeleteSign()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCondition() == null) ? 0 : getCondition().hashCode());
        result = prime * result + ((getConditionMean() == null) ? 0 : getConditionMean().hashCode());
        result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        result = prime * result + ((getRuleDesc() == null) ? 0 : getRuleDesc().hashCode());
        result = prime * result + ((getDeleteSign() == null) ? 0 : getDeleteSign().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", ruleSetId=").append(ruleSetId);
		sb.append(", condition=").append(condition);
		sb.append(", conditionMean=").append(conditionMean);
		sb.append(", processOrder=").append(processOrder);
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", ruleName=").append(ruleName);
		sb.append(", ruleDesc=").append(ruleDesc);
		sb.append(", deleteSign=").append(deleteSign);
        sb.append("]");
        return sb.toString();
    }
}