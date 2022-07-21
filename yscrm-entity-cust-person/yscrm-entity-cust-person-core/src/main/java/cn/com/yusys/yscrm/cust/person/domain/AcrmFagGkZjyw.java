package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagGkZjyw
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-01-28 12:28:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_GK_ZJYW")
public class AcrmFagGkZjyw extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	
	/** 客户编号
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 统计日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 业务种类
 **/
	@Column(name = "TYPE", unique = false, nullable = true, length = 20)
	private String type;
	
	/** 业务笔数
 **/
	@Column(name = "COUNT", unique = false, nullable = true, length = 10)
	private long count;
	
	/** 业务发生额
 **/
	@Column(name = "AMOUNT", unique = false, nullable = true, length = 18)
	private java.math.BigDecimal amount;
	
	/** 手续费收入
 **/
	@Column(name = "INCOME", unique = false, nullable = true, length = 18)
	private java.math.BigDecimal income;
	
	/** 客户类型
 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 币种
 **/
	@Column(name = "CCY_CD", unique = false, nullable = true, length = 3)
	private String ccyCd;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	
	
	/**
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}
	
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return dataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}
	
    /**
     * @return Type
     */	
	public String getType() {
		return this.type;
	}
	
	/**
	 * @param count
	 */
	public void setCount(long count) {
		this.count = count;
	}
	
    /**
     * @return Count
     */	
	public long getCount() {
		return this.count;
	}
	
	/**
	 * @param amount
	 */
	public void setAmount(java.math.BigDecimal amount) {
		this.amount = amount;
	}
	
    /**
     * @return Amount
     */	
	public java.math.BigDecimal getAmount() {
		return this.amount;
	}
	
	/**
	 * @param income
	 */
	public void setIncome(java.math.BigDecimal income) {
		this.income = income;
	}
	
    /**
     * @return Income
     */	
	public java.math.BigDecimal getIncome() {
		return this.income;
	}
	
	/**
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	
    /**
     * @return CustType
     */	
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * @param ccyCd
	 */
	public void setCcyCd(String ccyCd) {
		this.ccyCd = ccyCd == null ? null : ccyCd.trim();
	}
	
    /**
     * @return CcyCd
     */	
	public String getCcyCd() {
		return this.ccyCd;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
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
        AcrmFagGkZjyw other = (AcrmFagGkZjyw) that;
		return (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                	&& (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
                                	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getCcyCd() == null ? other.getCcyCd() == null : this.getCcyCd().equals(other.getCcyCd()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getCcyCd() == null) ? 0 : getCcyCd().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", custId=").append(custId);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", type=").append(type);
		sb.append(", count=").append(count);
		sb.append(", amount=").append(amount);
		sb.append(", income=").append(income);
		sb.append(", custType=").append(custType);
		sb.append(", ccyCd=").append(ccyCd);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}