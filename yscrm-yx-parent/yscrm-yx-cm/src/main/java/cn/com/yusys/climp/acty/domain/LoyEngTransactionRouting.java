package cn.com.yusys.climp.acty.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngTransactionRouting
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:41:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_ENG_TRANSACTION_ROUTING")
public class LoyEngTransactionRouting extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 交易代码 **/
	@Column(name = "TRANSACTION_CODE", unique = false, nullable = false, length = 50)
	private String transactionCode;
	
	/** 规则集ID **/
	@Column(name = "RULE_SET_ID", unique = false, nullable = false, length = 38)
	private java.math.BigDecimal ruleSetId;
	
	/** 处理优先级 **/
	@Column(name = "PROCESS_PRIORITY", unique = false, nullable = false, length = 4)
	private short processPriority;
	
	/** 处理顺序 **/
	@Column(name = "PROCESS_ORDER", unique = false, nullable = false, length = 20)
	private java.math.BigDecimal processOrder;
	
	
	/**
	 * @param transactionCode
	 */
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode == null ? null : transactionCode.trim();
	}
	
    /**
     * @return TransactionCode
     */	
	public String getTransactionCode() {
		return this.transactionCode;
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
	 * @param processPriority
	 */
	public void setProcessPriority(short processPriority) {
		this.processPriority = processPriority;
	}
	
    /**
     * @return ProcessPriority
     */	
	public short getProcessPriority() {
		return this.processPriority;
	}
	
	/**
	 * @param processOrder
	 */
	public void setProcessOrder(java.math.BigDecimal processOrder) {
		this.processOrder = processOrder;
	}
	
    /**
     * @return ProcessOrder
     */	
	public java.math.BigDecimal getProcessOrder() {
		return this.processOrder;
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
        LoyEngTransactionRouting other = (LoyEngTransactionRouting) that;
		return (this.getTransactionCode() == null ? other.getTransactionCode() == null : this.getTransactionCode().equals(other.getTransactionCode()))
                                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTransactionCode() == null) ? 0 : getTransactionCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", transactionCode=").append(transactionCode);
		sb.append(", ruleSetId=").append(ruleSetId);
		sb.append(", processPriority=").append(processPriority);
		sb.append(", processOrder=").append(processOrder);
        sb.append("]");
        return sb.toString();
    }
}