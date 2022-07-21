package cn.com.yusys.yscrm.cust.org.domain;

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
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgAssetDebt
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 10:54:47
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_ORG_ASSET_DEBT")
public class AcrmFciOrgAssetDebt extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 财报ID **/
	@Id
	@Column(name = "FIN_REPORT_ID")
	@Generated(GenerationType.UUID)
	private String finReportId;
	/** 财报项目ID **/
	@Id
	@Column(name = "ITEM_ID")
	@Generated(GenerationType.UUID)
	private String itemId;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;
	
	/** 客户分类 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 财务报表类别代码 **/
	@Column(name = "FIN_STAT_TYPE_CD", unique = false, nullable = true, length = 20)
	private String finStatTypeCd;
	
	/** 财务报表截止日期 **/
	@Transient
	@Column(name = "FIN_STAT_DEADLINE", unique = false, nullable = true, length = 7)
	private Date finStatDeadline;
	
	/** 财务报表状态代码 **/
	@Column(name = "FIN_STAT_STATUS_CD", unique = false, nullable = true, length = 20)
	private String finStatStatusCd;
	
	/** 财务报表类型代码 **/
	@Column(name = "FIN_STAT_CD", unique = false, nullable = true, length = 20)
	private String finStatCd;
	
	/** 是否生效 **/
	@Column(name = "VALID_IND", unique = false, nullable = true, length = 1)
	private String validInd;
	
	/** 币种 **/
	@Column(name = "CURR", unique = false, nullable = true, length = 20)
	private String curr;
	
	/** 项目值 **/
	@Column(name = "AMT", unique = false, nullable = true, length = 17)
	private java.math.BigDecimal amt;
	
	/** 创建人 **/
	@Column(name = "CRTE_PERSON", unique = false, nullable = true, length = 32)
	private String crtePerson;
	
	/** 创建日期 **/
	@Transient
	@Column(name = "CRTE_DT", unique = false, nullable = true, length = 7)
	private Date crteDt;
	
	/** 财报日期 **/
	@Transient
	@Column(name = "DATA_DT", unique = false, nullable = true, length = 7)
	private Date dataDt;
	
	
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
	 * @param finReportId
	 */
	public void setFinReportId(String finReportId) {
		this.finReportId = finReportId == null ? null : finReportId.trim();
	}
	
    /**
     * @return FinReportId
     */	
	public String getFinReportId() {
		return this.finReportId;
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
	 * @param finStatTypeCd
	 */
	public void setFinStatTypeCd(String finStatTypeCd) {
		this.finStatTypeCd = finStatTypeCd == null ? null : finStatTypeCd.trim();
	}
	
    /**
     * @return FinStatTypeCd
     */	
	public String getFinStatTypeCd() {
		return this.finStatTypeCd;
	}
	
	/**
	 * @param finStatDeadline
	 */
	public void setFinStatDeadline(Date finStatDeadline) {
		this.finStatDeadline = finStatDeadline;
	}
	
    /**
     * @return FinStatDeadline
     */	
	public Date getFinStatDeadline() {
		return this.finStatDeadline;
	}
	
	/**
	 * @param finStatStatusCd
	 */
	public void setFinStatStatusCd(String finStatStatusCd) {
		this.finStatStatusCd = finStatStatusCd == null ? null : finStatStatusCd.trim();
	}
	
    /**
     * @return FinStatStatusCd
     */	
	public String getFinStatStatusCd() {
		return this.finStatStatusCd;
	}
	
	/**
	 * @param finStatCd
	 */
	public void setFinStatCd(String finStatCd) {
		this.finStatCd = finStatCd == null ? null : finStatCd.trim();
	}
	
    /**
     * @return FinStatCd
     */	
	public String getFinStatCd() {
		return this.finStatCd;
	}
	
	/**
	 * @param validInd
	 */
	public void setValidInd(String validInd) {
		this.validInd = validInd == null ? null : validInd.trim();
	}
	
    /**
     * @return ValidInd
     */	
	public String getValidInd() {
		return this.validInd;
	}
	
	/**
	 * @param itemId
	 */
	public void setItemId(String itemId) {
		this.itemId = itemId == null ? null : itemId.trim();
	}
	
    /**
     * @return ItemId
     */	
	public String getItemId() {
		return this.itemId;
	}
	
	/**
	 * @param curr
	 */
	public void setCurr(String curr) {
		this.curr = curr == null ? null : curr.trim();
	}
	
    /**
     * @return Curr
     */	
	public String getCurr() {
		return this.curr;
	}
	
	/**
	 * @param amt
	 */
	public void setAmt(java.math.BigDecimal amt) {
		this.amt = amt;
	}
	
    /**
     * @return Amt
     */	
	public java.math.BigDecimal getAmt() {
		return this.amt;
	}
	
	/**
	 * @param crtePerson
	 */
	public void setCrtePerson(String crtePerson) {
		this.crtePerson = crtePerson == null ? null : crtePerson.trim();
	}
	
    /**
     * @return CrtePerson
     */	
	public String getCrtePerson() {
		return this.crtePerson;
	}
	
	/**
	 * @param crteDt
	 */
	public void setCrteDt(Date crteDt) {
		this.crteDt = crteDt;
	}
	
    /**
     * @return CrteDt
     */	
	public Date getCrteDt() {
		return this.crteDt;
	}
	
	/**
	 * @param dataDt
	 */
	public void setDataDt(Date dataDt) {
		this.dataDt = dataDt;
	}
	
    /**
     * @return DataDt
     */	
	public Date getDataDt() {
		return this.dataDt;
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
        AcrmFciOrgAssetDebt other = (AcrmFciOrgAssetDebt) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getFinReportId() == null ? other.getFinReportId() == null : this.getFinReportId().equals(other.getFinReportId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getFinStatTypeCd() == null ? other.getFinStatTypeCd() == null : this.getFinStatTypeCd().equals(other.getFinStatTypeCd()))
                	&& (this.getFinStatStatusCd() == null ? other.getFinStatStatusCd() == null : this.getFinStatStatusCd().equals(other.getFinStatStatusCd()))
        	&& (this.getFinStatCd() == null ? other.getFinStatCd() == null : this.getFinStatCd().equals(other.getFinStatCd()))
        	&& (this.getValidInd() == null ? other.getValidInd() == null : this.getValidInd().equals(other.getValidInd()))
        	&& (this.getItemId() == null ? other.getItemId() == null : this.getItemId().equals(other.getItemId()))
        	&& (this.getCurr() == null ? other.getCurr() == null : this.getCurr().equals(other.getCurr()))
                	&& (this.getCrtePerson() == null ? other.getCrtePerson() == null : this.getCrtePerson().equals(other.getCrtePerson()))
                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getFinReportId() == null) ? 0 : getFinReportId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getFinStatTypeCd() == null) ? 0 : getFinStatTypeCd().hashCode());
        result = prime * result + ((getFinStatStatusCd() == null) ? 0 : getFinStatStatusCd().hashCode());
        result = prime * result + ((getFinStatCd() == null) ? 0 : getFinStatCd().hashCode());
        result = prime * result + ((getValidInd() == null) ? 0 : getValidInd().hashCode());
        result = prime * result + ((getItemId() == null) ? 0 : getItemId().hashCode());
        result = prime * result + ((getCurr() == null) ? 0 : getCurr().hashCode());
        result = prime * result + ((getCrtePerson() == null) ? 0 : getCrtePerson().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append("]");
        return sb.toString();
    }
}