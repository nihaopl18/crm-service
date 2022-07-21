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
 * @类名称: OcrmFciPreOtherFin
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 21:17:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PRE_OTHER_FIN")
public class OcrmFciPreOtherFin extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键 **/
	@Id
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 客户号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 更新机构 **/
	@Column(name = "LAST_ORG_ID", unique = false, nullable = true, length = 32)
	private String lastOrgId;
	
	/** 更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 32)
	private String lastChgUsr;
	
	/** 更新时间 **/
	
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 账号 **/
	@Column(name = "ACCOUNT", unique = false, nullable = true, length = 50)
	private String account;
	
	/** 理财产品类型(保本\非保本) **/
	@Column(name = "FIN_PRO_TYPE", unique = false, nullable = true, length = 2)
	private String finProType;
	
	/** 购买金额 **/
	@Column(name = "PUR_AMO", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal purAmo;
	
	/** 预期收益率 **/
	@Column(name = "EXP_RATE_OF_RET", unique = false, nullable = true, length = 20)
	private String expRateOfRet;
	
	/** 期限 **/
	@Column(name = "TERM", unique = false, nullable = true, length = 20)
	private String term;
	
	/** 购买日期 **/
	@Column(name = "PUR_DATE", unique = false, nullable = true, length = 7)
	private Date purDate;
	
	/** 到期日期 **/
	@Column(name = "EXP_DATE", unique = false, nullable = true, length = 7)
	private Date expDate;
	
	/** 购买银行 **/
	@Column(name = "BUY_BANK", unique = false, nullable = true, length = 40)
	private String buyBank;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	
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
	 * @param lastOrgId
	 */
	public void setLastOrgId(String lastOrgId) {
		this.lastOrgId = lastOrgId == null ? null : lastOrgId.trim();
	}
	
    /**
     * @return LastOrgId
     */	
	public String getLastOrgId() {
		return this.lastOrgId;
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
	 * @param account
	 */
	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}
	
    /**
     * @return Account
     */	
	public String getAccount() {
		return this.account;
	}
	
	/**
	 * @param finProType
	 */
	public void setFinProType(String finProType) {
		this.finProType = finProType == null ? null : finProType.trim();
	}
	
    /**
     * @return FinProType
     */	
	public String getFinProType() {
		return this.finProType;
	}
	
	/**
	 * @param purAmo
	 */
	public void setPurAmo(java.math.BigDecimal purAmo) {
		this.purAmo = purAmo;
	}
	
    /**
     * @return PurAmo
     */	
	public java.math.BigDecimal getPurAmo() {
		return this.purAmo;
	}
	
	/**
	 * @param expRateOfRet
	 */
	public void setExpRateOfRet(String expRateOfRet) {
		this.expRateOfRet = expRateOfRet == null ? null : expRateOfRet.trim();
	}
	
    /**
     * @return ExpRateOfRet
     */	
	public String getExpRateOfRet() {
		return this.expRateOfRet;
	}
	
	/**
	 * @param term
	 */
	public void setTerm(String term) {
		this.term = term == null ? null : term.trim();
	}
	
    /**
     * @return Term
     */	
	public String getTerm() {
		return this.term;
	}
	
	/**
	 * @param purDate
	 */
	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}
	
    /**
     * @return PurDate
     */	
	public Date getPurDate() {
		return this.purDate;
	}
	
	/**
	 * @param expDate
	 */
	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
	
    /**
     * @return ExpDate
     */	
	public Date getExpDate() {
		return this.expDate;
	}
	
	/**
	 * @param buyBank
	 */
	public void setBuyBank(String buyBank) {
		this.buyBank = buyBank == null ? null : buyBank.trim();
	}
	
    /**
     * @return BuyBank
     */	
	public String getBuyBank() {
		return this.buyBank;
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
        OcrmFciPreOtherFin other = (OcrmFciPreOtherFin) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getLastOrgId() == null ? other.getLastOrgId() == null : this.getLastOrgId().equals(other.getLastOrgId()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
        	&& (this.getFinProType() == null ? other.getFinProType() == null : this.getFinProType().equals(other.getFinProType()))
                	&& (this.getExpRateOfRet() == null ? other.getExpRateOfRet() == null : this.getExpRateOfRet().equals(other.getExpRateOfRet()))
        	&& (this.getTerm() == null ? other.getTerm() == null : this.getTerm().equals(other.getTerm()))
                        	&& (this.getBuyBank() == null ? other.getBuyBank() == null : this.getBuyBank().equals(other.getBuyBank()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getLastOrgId() == null) ? 0 : getLastOrgId().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getFinProType() == null) ? 0 : getFinProType().hashCode());
        result = prime * result + ((getExpRateOfRet() == null) ? 0 : getExpRateOfRet().hashCode());
        result = prime * result + ((getTerm() == null) ? 0 : getTerm().hashCode());
        result = prime * result + ((getBuyBank() == null) ? 0 : getBuyBank().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", custId=").append(custId);
		sb.append(", lastOrgId=").append(lastOrgId);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", account=").append(account);
		sb.append(", finProType=").append(finProType);
		sb.append(", purAmo=").append(purAmo);
		sb.append(", expRateOfRet=").append(expRateOfRet);
		sb.append(", term=").append(term);
		sb.append(", purDate=").append(purDate);
		sb.append(", expDate=").append(expDate);
		sb.append(", buyBank=").append(buyBank);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}