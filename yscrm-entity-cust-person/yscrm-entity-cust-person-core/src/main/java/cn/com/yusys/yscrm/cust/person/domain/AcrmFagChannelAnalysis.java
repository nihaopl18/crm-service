package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagChannelAnalysis
 * @类描述: #数据实体类
 * @功能描述: 交易渠道信息
 * @创建人: 15104
 * @创建时间: 2019-02-12 10:05:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_CHANNEL_ANALYSIS")
public class AcrmFagChannelAnalysis extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户号
 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 统计时间
 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 交易渠道类型
 **/
	@Column(name = "CHANNEL_TYPE", unique = false, nullable = true, length = 20)
	private String channelType;
	
	/** 上月交易次数
 **/
	@Column(name = "LM_TRANS_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal lmTransNum;
	
	/** 上月交易金额
 **/
	@Column(name = "LM_TRANS_BAL", unique = false, nullable = true, length = 18)
	private java.math.BigDecimal lmTransBal;
	
	/** 最近6个月(自然月)交易次数
 **/
	@Column(name = "LAST_6M_TRANS_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal last6mTransNum;
	
	/** 最近6个月(自然月)交易金额
 **/
	@Column(name = "LAST_6M_TRANS_BAL", unique = false, nullable = true, length = 18)
	private java.math.BigDecimal last6mTransBal;
	
	/** 最近12个月(自然月)交易次数
 **/
	@Column(name = "LAST_12M_TRANS_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal last12mTransNum;
	
	/** 最近12个月(自然月)交易金额
 **/
	@Column(name = "LAST_12M_TRANS_BAL", unique = false, nullable = true, length = 18)
	private java.math.BigDecimal last12mTransBal;
	
	/** 累计(系统上线开始)交易次数
 **/
	@Column(name = "TRANS_NUM_SUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal transNumSum;
	
	/** 累计(系统上线开始)交易金额
 **/
	@Column(name = "TRANS_BAL_SUM", unique = false, nullable = true, length = 18)
	private java.math.BigDecimal transBalSum;
	
	
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
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
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
	 * @param channelType
	 */
	public void setChannelType(String channelType) {
		this.channelType = channelType == null ? null : channelType.trim();
	}
	
    /**
     * @return ChannelType
     */	
	public String getChannelType() {
		return this.channelType;
	}
	
	/**
	 * @param lmTransNum
	 */
	public void setLmTransNum(java.math.BigDecimal lmTransNum) {
		this.lmTransNum = lmTransNum;
	}
	
    /**
     * @return LmTransNum
     */	
	public java.math.BigDecimal getLmTransNum() {
		return this.lmTransNum;
	}
	
	/**
	 * @param lmTransBal
	 */
	public void setLmTransBal(java.math.BigDecimal lmTransBal) {
		this.lmTransBal = lmTransBal;
	}
	
    /**
     * @return LmTransBal
     */	
	public java.math.BigDecimal getLmTransBal() {
		return this.lmTransBal;
	}
	
	/**
	 * @param last6mTransNum
	 */
	public void setLast6mTransNum(java.math.BigDecimal last6mTransNum) {
		this.last6mTransNum = last6mTransNum;
	}
	
    /**
     * @return Last6mTransNum
     */	
	public java.math.BigDecimal getLast6mTransNum() {
		return this.last6mTransNum;
	}
	
	/**
	 * @param last6mTransBal
	 */
	public void setLast6mTransBal(java.math.BigDecimal last6mTransBal) {
		this.last6mTransBal = last6mTransBal;
	}
	
    /**
     * @return Last6mTransBal
     */	
	public java.math.BigDecimal getLast6mTransBal() {
		return this.last6mTransBal;
	}
	
	/**
	 * @param last12mTransNum
	 */
	public void setLast12mTransNum(java.math.BigDecimal last12mTransNum) {
		this.last12mTransNum = last12mTransNum;
	}
	
    /**
     * @return Last12mTransNum
     */	
	public java.math.BigDecimal getLast12mTransNum() {
		return this.last12mTransNum;
	}
	
	/**
	 * @param last12mTransBal
	 */
	public void setLast12mTransBal(java.math.BigDecimal last12mTransBal) {
		this.last12mTransBal = last12mTransBal;
	}
	
    /**
     * @return Last12mTransBal
     */	
	public java.math.BigDecimal getLast12mTransBal() {
		return this.last12mTransBal;
	}
	
	/**
	 * @param transNumSum
	 */
	public void setTransNumSum(java.math.BigDecimal transNumSum) {
		this.transNumSum = transNumSum;
	}
	
    /**
     * @return TransNumSum
     */	
	public java.math.BigDecimal getTransNumSum() {
		return this.transNumSum;
	}
	
	/**
	 * @param transBalSum
	 */
	public void setTransBalSum(java.math.BigDecimal transBalSum) {
		this.transBalSum = transBalSum;
	}
	
    /**
     * @return TransBalSum
     */	
	public java.math.BigDecimal getTransBalSum() {
		return this.transBalSum;
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
        AcrmFagChannelAnalysis other = (AcrmFagChannelAnalysis) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getChannelType() == null ? other.getChannelType() == null : this.getChannelType().equals(other.getChannelType()))
                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getChannelType() == null) ? 0 : getChannelType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", custId=").append(custId);
		sb.append(", channelType=").append(channelType);
		sb.append(", lmTransNum=").append(lmTransNum);
		sb.append(", lmTransBal=").append(lmTransBal);
		sb.append(", last6mTransNum=").append(last6mTransNum);
		sb.append(", last6mTransBal=").append(last6mTransBal);
		sb.append(", last12mTransNum=").append(last12mTransNum);
		sb.append(", last12mTransBal=").append(last12mTransBal);
		sb.append(", transNumSum=").append(transNumSum);
		sb.append(", transBalSum=").append(transBalSum);
        sb.append("]");
        return sb.toString();
    }
}