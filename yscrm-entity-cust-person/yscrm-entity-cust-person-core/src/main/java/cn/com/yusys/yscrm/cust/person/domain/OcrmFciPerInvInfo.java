package cn.com.yusys.yscrm.cust.person.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPerInvInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-03-01 10:19:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_INV_INFO")
public class OcrmFciPerInvInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** ID主键
 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	private String id;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期
 **/
	@Transient
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号
 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人
 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最近更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最近更新时间
 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 被投资单位名称全称
 **/
	@Column(name = "INV_NAME", unique = false, nullable = true, length = 150)
	private String invName;
	
	/** 投资性质
 **/
	@Column(name = "INV_TYPE", unique = false, nullable = true, length = 30)
	private String invType;
	
	/** 被投资单位贷款卡号
 **/
	@Column(name = "INV_LOAN_CARD", unique = false, nullable = true, length = 50)
	private String invLoanCard;
	
	/** 被投资企业法人代表
 **/
	@Column(name = "INV_LEGAL", unique = false, nullable = true, length = 30)
	private String invLegal;
	
	/** 币种
 **/
	@Column(name = "CURR_CD", unique = false, nullable = true, length = 30)
	private String currCd;
	
	/** 投资金额元
 **/
	@Column(name = "INV_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal invAmt;
	
	/** 出资方式
 **/
	@Column(name = "PAY_TYPE", unique = false, nullable = true, length = 30)
	private String payType;
	
	/** 所占比例
 **/
	@Column(name = "INV_PERC", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal invPerc;
	
	/** 占股权比例
 **/
	@Column(name = "STOCK_PERC", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal stockPerc;
	
	/** 出资说明
 **/
	@Column(name = "INV_DESC", unique = false, nullable = true, length = 300)
	private String invDesc;
	
	/** 投资时间
 **/
	@Column(name = "INV_DATE", unique = false, nullable = true, length = 8)
	private String invDate;
	
	/** 投资项目_企业情况说明
 **/
	@Column(name = "INV_PRJ_DESC", unique = false, nullable = true, length = 300)
	private String invPrjDesc;
	
	/** 目前办公地址
 **/
	@Column(name = "WORK_ADDR", unique = false, nullable = true, length = 200)
	private String workAddr;
	
	/** 经营范围
 **/
	@Column(name = "WORK_RANGE", unique = false, nullable = true, length = 300)
	private String workRange;
	
	/** 备注
 **/
	@Column(name = "REMARKS", unique = false, nullable = true, length = 200)
	private String remarks;
	
	/** 被投资单位中征码 **/
	@Column(name = "INV_CODE", unique = false, nullable = true, length = 150)
	private String invCode;
	
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
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
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param cratOrgId
	 */
	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId == null ? null : cratOrgId.trim();
	}
	
    /**
     * @return CratOrgId
     */	
	public String getCratOrgId() {
		return this.cratOrgId;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr == null ? null : cratUsr.trim();
	}
	
    /**
     * @return CratUsr
     */	
	public String getCratUsr() {
		return this.cratUsr;
	}
	
	/**
	 * @param lastChgSys
	 */
	public void setLastChgSys(String lastChgSys) {
		this.lastChgSys = lastChgSys == null ? null : lastChgSys.trim();
	}
	
    /**
     * @return LastChgSys
     */	
	public String getLastChgSys() {
		return this.lastChgSys;
	}
	
	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}
	
    /**
     * @return LastChgUsr
     */	
	public String getLastChgUsr() {
		return this.lastChgUsr;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
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
	 * @param invName
	 */
	public void setInvName(String invName) {
		this.invName = invName == null ? null : invName.trim();
	}
	
    /**
     * @return InvName
     */	
	public String getInvName() {
		return this.invName;
	}
	
	/**
	 * @param invType
	 */
	public void setInvType(String invType) {
		this.invType = invType == null ? null : invType.trim();
	}
	
    /**
     * @return InvType
     */	
	public String getInvType() {
		return this.invType;
	}
	
	/**
	 * @param invLoanCard
	 */
	public void setInvLoanCard(String invLoanCard) {
		this.invLoanCard = invLoanCard == null ? null : invLoanCard.trim();
	}
	
    /**
     * @return InvLoanCard
     */	
	public String getInvLoanCard() {
		return this.invLoanCard;
	}
	
	/**
	 * @param invLegal
	 */
	public void setInvLegal(String invLegal) {
		this.invLegal = invLegal == null ? null : invLegal.trim();
	}
	
    /**
     * @return InvLegal
     */	
	public String getInvLegal() {
		return this.invLegal;
	}
	
	/**
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd == null ? null : currCd.trim();
	}
	
    /**
     * @return CurrCd
     */	
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * @param invAmt
	 */
	public void setInvAmt(java.math.BigDecimal invAmt) {
		this.invAmt = invAmt;
	}
	
    /**
     * @return InvAmt
     */	
	public java.math.BigDecimal getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * @param payType
	 */
	public void setPayType(String payType) {
		this.payType = payType == null ? null : payType.trim();
	}
	
    /**
     * @return PayType
     */	
	public String getPayType() {
		return this.payType;
	}
	
	/**
	 * @param invPerc
	 */
	public void setInvPerc(java.math.BigDecimal invPerc) {
		this.invPerc = invPerc;
	}
	
    /**
     * @return InvPerc
     */	
	public java.math.BigDecimal getInvPerc() {
		return this.invPerc;
	}
	
	/**
	 * @param stockPerc
	 */
	public void setStockPerc(java.math.BigDecimal stockPerc) {
		this.stockPerc = stockPerc;
	}
	
    /**
     * @return StockPerc
     */	
	public java.math.BigDecimal getStockPerc() {
		return this.stockPerc;
	}
	
	/**
	 * @param invDesc
	 */
	public void setInvDesc(String invDesc) {
		this.invDesc = invDesc == null ? null : invDesc.trim();
	}
	
    /**
     * @return InvDesc
     */	
	public String getInvDesc() {
		return this.invDesc;
	}
	
	/**
	 * @param invDate
	 */
	public void setInvDate(String invDate) {
		this.invDate = invDate == null ? null : invDate.trim();
	}
	
    /**
     * @return InvDate
     */	
	public String getInvDate() {
		return this.invDate;
	}
	
	/**
	 * @param invPrjDesc
	 */
	public void setInvPrjDesc(String invPrjDesc) {
		this.invPrjDesc = invPrjDesc == null ? null : invPrjDesc.trim();
	}
	
    /**
     * @return InvPrjDesc
     */	
	public String getInvPrjDesc() {
		return this.invPrjDesc;
	}
	
	/**
	 * @param workAddr
	 */
	public void setWorkAddr(String workAddr) {
		this.workAddr = workAddr == null ? null : workAddr.trim();
	}
	
    /**
     * @return WorkAddr
     */	
	public String getWorkAddr() {
		return this.workAddr;
	}
	
	/**
	 * @param workRange
	 */
	public void setWorkRange(String workRange) {
		this.workRange = workRange == null ? null : workRange.trim();
	}
	
    /**
     * @return WorkRange
     */	
	public String getWorkRange() {
		return this.workRange;
	}
	
	/**
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}
	
    /**
     * @return Remarks
     */	
	public String getRemarks() {
		return this.remarks;
	}
	
	/**
	 * @param invCode
	 */
	public void setInvCode(String invCode) {
		this.invCode = invCode == null ? null : invCode.trim();
	}
	
    /**
     * @return InvCode
     */	
	public String getInvCode() {
		return this.invCode;
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
        OcrmFciPerInvInfo other = (OcrmFciPerInvInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getInvName() == null ? other.getInvName() == null : this.getInvName().equals(other.getInvName()))
        	&& (this.getInvType() == null ? other.getInvType() == null : this.getInvType().equals(other.getInvType()))
        	&& (this.getInvLoanCard() == null ? other.getInvLoanCard() == null : this.getInvLoanCard().equals(other.getInvLoanCard()))
        	&& (this.getInvLegal() == null ? other.getInvLegal() == null : this.getInvLegal().equals(other.getInvLegal()))
        	&& (this.getCurrCd() == null ? other.getCurrCd() == null : this.getCurrCd().equals(other.getCurrCd()))
                	&& (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
                        	&& (this.getInvDesc() == null ? other.getInvDesc() == null : this.getInvDesc().equals(other.getInvDesc()))
        	&& (this.getInvDate() == null ? other.getInvDate() == null : this.getInvDate().equals(other.getInvDate()))
        	&& (this.getInvPrjDesc() == null ? other.getInvPrjDesc() == null : this.getInvPrjDesc().equals(other.getInvPrjDesc()))
        	&& (this.getWorkAddr() == null ? other.getWorkAddr() == null : this.getWorkAddr().equals(other.getWorkAddr()))
        	&& (this.getWorkRange() == null ? other.getWorkRange() == null : this.getWorkRange().equals(other.getWorkRange()))
        	&& (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
        	&& (this.getInvCode() == null ? other.getInvCode() == null : this.getInvCode().equals(other.getInvCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getInvName() == null) ? 0 : getInvName().hashCode());
        result = prime * result + ((getInvType() == null) ? 0 : getInvType().hashCode());
        result = prime * result + ((getInvLoanCard() == null) ? 0 : getInvLoanCard().hashCode());
        result = prime * result + ((getInvLegal() == null) ? 0 : getInvLegal().hashCode());
        result = prime * result + ((getCurrCd() == null) ? 0 : getCurrCd().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getInvDesc() == null) ? 0 : getInvDesc().hashCode());
        result = prime * result + ((getInvDate() == null) ? 0 : getInvDate().hashCode());
        result = prime * result + ((getInvPrjDesc() == null) ? 0 : getInvPrjDesc().hashCode());
        result = prime * result + ((getWorkAddr() == null) ? 0 : getWorkAddr().hashCode());
        result = prime * result + ((getWorkRange() == null) ? 0 : getWorkRange().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getInvCode() == null) ? 0 : getInvCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", invName=").append(invName);
		sb.append(", invType=").append(invType);
		sb.append(", invLoanCard=").append(invLoanCard);
		sb.append(", invLegal=").append(invLegal);
		sb.append(", currCd=").append(currCd);
		sb.append(", invAmt=").append(invAmt);
		sb.append(", payType=").append(payType);
		sb.append(", invPerc=").append(invPerc);
		sb.append(", stockPerc=").append(stockPerc);
		sb.append(", invDesc=").append(invDesc);
		sb.append(", invDate=").append(invDate);
		sb.append(", invPrjDesc=").append(invPrjDesc);
		sb.append(", workAddr=").append(workAddr);
		sb.append(", workRange=").append(workRange);
		sb.append(", remarks=").append(remarks);
		sb.append(", invCode=").append(invCode);
        sb.append("]");
        return sb.toString();
    }
}