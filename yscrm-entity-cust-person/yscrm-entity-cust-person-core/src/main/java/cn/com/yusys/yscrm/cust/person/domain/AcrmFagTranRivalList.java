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
 * @类名称: AcrmFagTranRivalList
 * @类描述: #数据实体类
 * @功能描述: 交易对手信息-交易明细
 * @创建人: 15104
 * @创建时间: 2019-02-11 20:12:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_TRAN_RIVAL_LIST")
public class AcrmFagTranRivalList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识
 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 交易方向
 **/
	@Column(name = "TRAN_TYPE", unique = false, nullable = true, length = 20)
	private String tranType;
	
	/** 对方帐号/客户号
 **/
	@Column(name = "OTHSIDE_ACCT", unique = false, nullable = true, length = 32)
	private String othsideAcct;
	
	/** 交易对手名称
 **/
	@Column(name = "OTHSIDE_NAME", unique = false, nullable = true, length = 200)
	private String othsideName;
	
	/** 起始日期
 **/
	@Transient
	@Column(name = "BEGIN_TIME", unique = false, nullable = true, length = 7)
	private Date beginTime;
	
	/** 结束日期
 **/
	@Transient
	@Column(name = "END_TIME", unique = false, nullable = true, length = 7)
	private Date endTime;
	
	/** 交易金额（开始）
 **/
	@Column(name = "AMT_BEGIN", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal amtBegin;
	
	/** 交易金额（结束）
 **/
	@Column(name = "AMT_END", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal amtEnd;
	
	
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
		this.dataDate = dataDate == null ? null : dataDate.trim();
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
	 * @param tranType
	 */
	public void setTranType(String tranType) {
		this.tranType = tranType == null ? null : tranType.trim();
	}
	
    /**
     * @return TranType
     */	
	public String getTranType() {
		return this.tranType;
	}
	
	/**
	 * @param othsideAcct
	 */
	public void setOthsideAcct(String othsideAcct) {
		this.othsideAcct = othsideAcct == null ? null : othsideAcct.trim();
	}
	
    /**
     * @return OthsideAcct
     */	
	public String getOthsideAcct() {
		return this.othsideAcct;
	}
	
	/**
	 * @param othsideName
	 */
	public void setOthsideName(String othsideName) {
		this.othsideName = othsideName == null ? null : othsideName.trim();
	}
	
    /**
     * @return OthsideName
     */	
	public String getOthsideName() {
		return this.othsideName;
	}
	
	/**
	 * @param beginTime
	 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
    /**
     * @return BeginTime
     */	
	public Date getBeginTime() {
		return this.beginTime;
	}
	
	/**
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
    /**
     * @return EndTime
     */	
	public Date getEndTime() {
		return this.endTime;
	}
	
	/**
	 * @param amtBegin
	 */
	public void setAmtBegin(java.math.BigDecimal amtBegin) {
		this.amtBegin = amtBegin;
	}
	
    /**
     * @return AmtBegin
     */	
	public java.math.BigDecimal getAmtBegin() {
		return this.amtBegin;
	}
	
	/**
	 * @param amtEnd
	 */
	public void setAmtEnd(java.math.BigDecimal amtEnd) {
		this.amtEnd = amtEnd;
	}
	
    /**
     * @return AmtEnd
     */	
	public java.math.BigDecimal getAmtEnd() {
		return this.amtEnd;
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
        AcrmFagTranRivalList other = (AcrmFagTranRivalList) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getTranType() == null ? other.getTranType() == null : this.getTranType().equals(other.getTranType()))
        	&& (this.getOthsideAcct() == null ? other.getOthsideAcct() == null : this.getOthsideAcct().equals(other.getOthsideAcct()))
        	&& (this.getOthsideName() == null ? other.getOthsideName() == null : this.getOthsideName().equals(other.getOthsideName()))
                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getTranType() == null) ? 0 : getTranType().hashCode());
        result = prime * result + ((getOthsideAcct() == null) ? 0 : getOthsideAcct().hashCode());
        result = prime * result + ((getOthsideName() == null) ? 0 : getOthsideName().hashCode());
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
		sb.append(", tranType=").append(tranType);
		sb.append(", othsideAcct=").append(othsideAcct);
		sb.append(", othsideName=").append(othsideName);
		sb.append(", beginTime=").append(beginTime);
		sb.append(", endTime=").append(endTime);
		sb.append(", amtBegin=").append(amtBegin);
		sb.append(", amtEnd=").append(amtEnd);
        sb.append("]");
        return sb.toString();
    }
}