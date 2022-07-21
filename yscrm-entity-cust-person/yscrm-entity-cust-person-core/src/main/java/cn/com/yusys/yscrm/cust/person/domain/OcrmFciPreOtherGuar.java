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
 * @类名称: OcrmFciPreOtherGuar
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 21:17:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PRE_OTHER_GUAR")
public class OcrmFciPreOtherGuar extends BaseDomain implements Serializable{
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
	
	/** 被担保人名称 **/
	@Column(name = "BY_GUA_NAME", unique = false, nullable = true, length = 200)
	private String byGuaName;
	
	/** 担保方式 **/
	@Column(name = "GUA_MET", unique = false, nullable = true, length = 2)
	private String guaMet;
	
	/** 担保业务描述 **/
	@Column(name = "GUA_BUS_DES", unique = false, nullable = true, length = 300)
	private String guaBusDes;
	
	/** 担保金额元 **/
	@Column(name = "GUA_AMO", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal guaAmo;
	
	/** 担保余额元 **/
	@Column(name = "GUA_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal guaBal;
	
	/** 起始日期 **/
	
	@Column(name = "START_DATE", unique = false, nullable = true, length = 7)
	private Date startDate;
	
	/** 到期日期 **/
	
	@Column(name = "EXP_DATE", unique = false, nullable = true, length = 7)
	private Date expDate;
	
	/** 银行详细名称 **/
	@Column(name = "BANK_DET_NAME", unique = false, nullable = true, length = 300)
	private String bankDetName;
	
	/** 有效标志 **/
	@Column(name = "VALID_LOGO", unique = false, nullable = true, length = 2)
	private String validLogo;
	
	/** 备注 **/
	@Column(name = "NOTE", unique = false, nullable = true, length = 500)
	private String note;
	
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
	 * @param byGuaName
	 */
	public void setByGuaName(String byGuaName) {
		this.byGuaName = byGuaName == null ? null : byGuaName.trim();
	}
	
    /**
     * @return ByGuaName
     */	
	public String getByGuaName() {
		return this.byGuaName;
	}
	
	/**
	 * @param guaMet
	 */
	public void setGuaMet(String guaMet) {
		this.guaMet = guaMet == null ? null : guaMet.trim();
	}
	
    /**
     * @return GuaMet
     */	
	public String getGuaMet() {
		return this.guaMet;
	}
	
	/**
	 * @param guaBusDes
	 */
	public void setGuaBusDes(String guaBusDes) {
		this.guaBusDes = guaBusDes == null ? null : guaBusDes.trim();
	}
	
    /**
     * @return GuaBusDes
     */	
	public String getGuaBusDes() {
		return this.guaBusDes;
	}
	
	/**
	 * @param guaAmo
	 */
	public void setGuaAmo(java.math.BigDecimal guaAmo) {
		this.guaAmo = guaAmo;
	}
	
    /**
     * @return GuaAmo
     */	
	public java.math.BigDecimal getGuaAmo() {
		return this.guaAmo;
	}
	
	/**
	 * @param guaBal
	 */
	public void setGuaBal(java.math.BigDecimal guaBal) {
		this.guaBal = guaBal;
	}
	
    /**
     * @return GuaBal
     */	
	public java.math.BigDecimal getGuaBal() {
		return this.guaBal;
	}
	
	/**
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
    /**
     * @return StartDate
     */	
	public Date getStartDate() {
		return this.startDate;
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
	 * @param bankDetName
	 */
	public void setBankDetName(String bankDetName) {
		this.bankDetName = bankDetName == null ? null : bankDetName.trim();
	}
	
    /**
     * @return BankDetName
     */	
	public String getBankDetName() {
		return this.bankDetName;
	}
	
	/**
	 * @param validLogo
	 */
	public void setValidLogo(String validLogo) {
		this.validLogo = validLogo == null ? null : validLogo.trim();
	}
	
    /**
     * @return ValidLogo
     */	
	public String getValidLogo() {
		return this.validLogo;
	}
	
	/**
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}
	
    /**
     * @return Note
     */	
	public String getNote() {
		return this.note;
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
        OcrmFciPreOtherGuar other = (OcrmFciPreOtherGuar) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getLastOrgId() == null ? other.getLastOrgId() == null : this.getLastOrgId().equals(other.getLastOrgId()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getByGuaName() == null ? other.getByGuaName() == null : this.getByGuaName().equals(other.getByGuaName()))
        	&& (this.getGuaMet() == null ? other.getGuaMet() == null : this.getGuaMet().equals(other.getGuaMet()))
        	&& (this.getGuaBusDes() == null ? other.getGuaBusDes() == null : this.getGuaBusDes().equals(other.getGuaBusDes()))
                                        	&& (this.getBankDetName() == null ? other.getBankDetName() == null : this.getBankDetName().equals(other.getBankDetName()))
        	&& (this.getValidLogo() == null ? other.getValidLogo() == null : this.getValidLogo().equals(other.getValidLogo()))
        	&& (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
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
        result = prime * result + ((getByGuaName() == null) ? 0 : getByGuaName().hashCode());
        result = prime * result + ((getGuaMet() == null) ? 0 : getGuaMet().hashCode());
        result = prime * result + ((getGuaBusDes() == null) ? 0 : getGuaBusDes().hashCode());
        result = prime * result + ((getBankDetName() == null) ? 0 : getBankDetName().hashCode());
        result = prime * result + ((getValidLogo() == null) ? 0 : getValidLogo().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
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
		sb.append(", byGuaName=").append(byGuaName);
		sb.append(", guaMet=").append(guaMet);
		sb.append(", guaBusDes=").append(guaBusDes);
		sb.append(", guaAmo=").append(guaAmo);
		sb.append(", guaBal=").append(guaBal);
		sb.append(", startDate=").append(startDate);
		sb.append(", expDate=").append(expDate);
		sb.append(", bankDetName=").append(bankDetName);
		sb.append(", validLogo=").append(validLogo);
		sb.append(", note=").append(note);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}