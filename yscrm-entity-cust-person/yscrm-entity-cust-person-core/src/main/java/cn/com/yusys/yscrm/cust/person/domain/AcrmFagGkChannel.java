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
 * @类名称: AcrmFagGkChannel
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: 15104
 * @创建时间: 2019-01-28 12:29:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_GK_CHANNEL")
public class AcrmFagGkChannel extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户编号
 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 记录标志
 **/
	/*@Column(name = "ID", unique = false, nullable = true, length = 40)
	private String id;*/
	
	/** ETL日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 客户名称
 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 80)
	private String custName;
	
	/** 客户类型
 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 起始时间
 **/
	@Transient
	@Column(name = "START_DT", unique = false, nullable = true, length = 7)
	private Date startDt;
	
	/** 终止时间
 **/
	@Transient
	@Column(name = "END_DT", unique = false, nullable = true, length = 7)
	private Date endDt;
	
	/** 渠道
 **/
	@Column(name = "CHANNEL", unique = false, nullable = true, length = 30)
	private String channel;
	
	/** 业务种类
 **/
	@Column(name = "BUSI_TYPE", unique = false, nullable = true, length = 20)
	private String busiType;
	
	/** 存款笔数
 **/
	@Column(name = "SAVE_COUNT", unique = false, nullable = true, length = 10)
	private long saveCount;
	
	/** 存款金额
 **/
	@Column(name = "SAVE_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal saveAmt;
	
	/** 取款笔数
 **/
	@Column(name = "DRAW_COUNT", unique = false, nullable = true, length = 10)
	private long drawCount;
	
	/** 取款金额
 **/
	@Column(name = "DRAW_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal drawAmt;
	
	/** 交易金额
 **/
	@Column(name = "TRAN_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal tranAmt;
	
	/** 交易笔数
 **/
	@Column(name = "TRANS_NUM", unique = false, nullable = true, length = 10)
	private long transNum;
	
	/** 手续费收入
 **/
	@Column(name = "INCOME", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal income;
	
	
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
     * @return dataDate
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
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}
	
    /**
     * @return CustName
     */	
	public String getCustName() {
		return this.custName;
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
	 * @param startDt
	 */
	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}
	
    /**
     * @return StartDt
     */	
	public Date getStartDt() {
		return this.startDt;
	}
	
	/**
	 * @param endDt
	 */
	public void setEndDt(Date endDt) {
		this.endDt = endDt;
	}
	
    /**
     * @return EndDt
     */	
	public Date getEndDt() {
		return this.endDt;
	}
	
	/**
	 * @param channel
	 */
	public void setChannel(String channel) {
		this.channel = channel == null ? null : channel.trim();
	}
	
    /**
     * @return Channel
     */	
	public String getChannel() {
		return this.channel;
	}
	
	/**
	 * @param busiType
	 */
	public void setBusiType(String busiType) {
		this.busiType = busiType == null ? null : busiType.trim();
	}
	
    /**
     * @return BusiType
     */	
	public String getBusiType() {
		return this.busiType;
	}
	
	/**
	 * @param saveCount
	 */
	public void setSaveCount(long saveCount) {
		this.saveCount = saveCount;
	}
	
    /**
     * @return SaveCount
     */	
	public long getSaveCount() {
		return this.saveCount;
	}
	
	/**
	 * @param saveAmt
	 */
	public void setSaveAmt(java.math.BigDecimal saveAmt) {
		this.saveAmt = saveAmt;
	}
	
    /**
     * @return SaveAmt
     */	
	public java.math.BigDecimal getSaveAmt() {
		return this.saveAmt;
	}
	
	/**
	 * @param drawCount
	 */
	public void setDrawCount(long drawCount) {
		this.drawCount = drawCount;
	}
	
    /**
     * @return DrawCount
     */	
	public long getDrawCount() {
		return this.drawCount;
	}
	
	/**
	 * @param drawAmt
	 */
	public void setDrawAmt(java.math.BigDecimal drawAmt) {
		this.drawAmt = drawAmt;
	}
	
    /**
     * @return DrawAmt
     */	
	public java.math.BigDecimal getDrawAmt() {
		return this.drawAmt;
	}
	
	/**
	 * @param tranAmt
	 */
	public void setTranAmt(java.math.BigDecimal tranAmt) {
		this.tranAmt = tranAmt;
	}
	
    /**
     * @return TranAmt
     */	
	public java.math.BigDecimal getTranAmt() {
		return this.tranAmt;
	}
	
	/**
	 * @param transNum
	 */
	public void setTransNum(long transNum) {
		this.transNum = transNum;
	}
	
    /**
     * @return TransNum
     */	
	public long getTransNum() {
		return this.transNum;
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
        AcrmFagGkChannel other = (AcrmFagGkChannel) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
                        	&& (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
        	&& (this.getBusiType() == null ? other.getBusiType() == null : this.getBusiType().equals(other.getBusiType()))
                                                                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getBusiType() == null) ? 0 : getBusiType().hashCode());
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
		sb.append(", custName=").append(custName);
		sb.append(", custType=").append(custType);
		sb.append(", startDt=").append(startDt);
		sb.append(", endDt=").append(endDt);
		sb.append(", channel=").append(channel);
		sb.append(", busiType=").append(busiType);
		sb.append(", saveCount=").append(saveCount);
		sb.append(", saveAmt=").append(saveAmt);
		sb.append(", drawCount=").append(drawCount);
		sb.append(", drawAmt=").append(drawAmt);
		sb.append(", tranAmt=").append(tranAmt);
		sb.append(", transNum=").append(transNum);
		sb.append(", income=").append(income);
        sb.append("]");
        return sb.toString();
    }
}