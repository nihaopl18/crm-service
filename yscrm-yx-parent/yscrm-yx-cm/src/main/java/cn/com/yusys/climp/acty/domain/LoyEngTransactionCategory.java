package cn.com.yusys.climp.acty.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngTransactionCategory
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_ENG_TRANSACTION_CATEGORY")
public class LoyEngTransactionCategory extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 交易代码 **/
	@Column(name = "TRANSACTION_CODE", unique = false, nullable = false, length = 50)
	private String transactionCode;
	
	/** 交易名称 **/
	@Column(name = "TRANSACTION_NAME", unique = false, nullable = false, length = 200)
	private String transactionName;
	
	/** 交易流水表 **/
	@Column(name = "TABLE_E_NAME", unique = false, nullable = false, length = 50)
	private String tableEname;
	
	/** 交易类型 **/
	@Column(name = "TRANSACTION_TYPE", unique = false, nullable = true, length = 10)
	private String transactionType;
	
	
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
	 * @param transactionName
	 */
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName == null ? null : transactionName.trim();
	}
	
    /**
     * @return TransactionName
     */	
	public String getTransactionName() {
		return this.transactionName;
	}
	
	/**
	 * @param tableEname
	 */
	public void setTableEname(String tableEname) {
		this.tableEname = tableEname == null ? null : tableEname.trim();
	}
	
    /**
     * @return TableEname
     */	
	public String getTableEname() {
		return this.tableEname;
	}
	
	/**
	 * @param transactionType
	 */
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType == null ? null : transactionType.trim();
	}
	
    /**
     * @return transactionType
     */	
	public String getTransactionType() {
		return this.transactionType;
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
        LoyEngTransactionCategory other = (LoyEngTransactionCategory) that;
		return (this.getTransactionCode() == null ? other.getTransactionCode() == null : this.getTransactionCode().equals(other.getTransactionCode()))
        	&& (this.getTransactionName() == null ? other.getTransactionName() == null : this.getTransactionName().equals(other.getTransactionName()))
        	&& (this.getTableEname() == null ? other.getTableEname() == null : this.getTableEname().equals(other.getTableEname()))
        	&& (this.getTransactionType() == null ? other.getTransactionType() == null : this.getTransactionType().equals(other.getTransactionType()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getTransactionCode() == null) ? 0 : getTransactionCode().hashCode());
        result = prime * result + ((getTransactionName() == null) ? 0 : getTransactionName().hashCode());
        result = prime * result + ((getTableEname() == null) ? 0 : getTableEname().hashCode());
        result = prime * result + ((getTransactionType() == null) ? 0 : getTransactionType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", transactionCode=").append(transactionCode);
		sb.append(", transactionName=").append(transactionName);
		sb.append(", tableEname=").append(tableEname);
		sb.append(", transactionType=").append(transactionType);
        sb.append("]");
        return sb.toString();
    }
}