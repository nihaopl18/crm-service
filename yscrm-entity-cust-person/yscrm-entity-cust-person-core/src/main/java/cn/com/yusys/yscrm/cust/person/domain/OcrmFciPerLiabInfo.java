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
 * @类名称: OcrmFciPerLiabInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-03-01 10:21:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_LIAB_INFO")
public class OcrmFciPerLiabInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期 **/
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最近更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最近更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户标识 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 负债编号 **/
	@Column(name = "INDIV_DEBT_ID", unique = false, nullable = true, length = 30)
	private String indivDebtId;
	
	/** 负债类型 **/
	@Column(name = "LIAB_TYPE", unique = false, nullable = true, length = 20)
	private String liabType;
	
	/** 负债描述 **/
	@Column(name = "LIAB_DESC", unique = false, nullable = true, length = 200)
	private String liabDesc;
	
	/** 债权人 **/
	@Column(name = "CREDITOR", unique = false, nullable = true, length = 80)
	private String creditor;
	
	/** 负债币种 **/
	@Column(name = "LIAB_CURR_CD", unique = false, nullable = true, length = 30)
	private String liabCurrCd;
	
	/** 负债金额 **/
	@Column(name = "LIAB_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal liabAmt;
	
	/** 债务开始时间 **/
	@Column(name = "LIAB_START_DATE", unique = false, nullable = true, length = 20)
	private String liabStartDate;
	
	/** 债务结束时间 **/
	@Column(name = "LIAB_END_DATE", unique = false, nullable = true, length = 20)
	private String liabEndDate;
	
	/** 月收入担保信用卡张数 **/
	@Column(name = "CRED_CRD_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal credCrdNum;
	
	/** 为他人担保贷款余额 **/
	@Column(name = "LOAN_GUAR_BAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal loanGuarBal;
	
	/** 备注 **/
	@Column(name = "REMARKS", unique = false, nullable = true, length = 200)
	private String remarks;
	

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
	 * @param indivDebtId
	 */
	public void setIndivDebtId(String indivDebtId) {
		this.indivDebtId = indivDebtId == null ? null : indivDebtId.trim();
	}
	
    /**
     * @return IndivDebtId
     */	
	public String getIndivDebtId() {
		return this.indivDebtId;
	}
	
	/**
	 * @param liabType
	 */
	public void setLiabType(String liabType) {
		this.liabType = liabType == null ? null : liabType.trim();
	}
	
    /**
     * @return LiabType
     */	
	public String getLiabType() {
		return this.liabType;
	}
	
	/**
	 * @param liabDesc
	 */
	public void setLiabDesc(String liabDesc) {
		this.liabDesc = liabDesc == null ? null : liabDesc.trim();
	}
	
    /**
     * @return LiabDesc
     */	
	public String getLiabDesc() {
		return this.liabDesc;
	}
	
	/**
	 * @param creditor
	 */
	public void setCreditor(String creditor) {
		this.creditor = creditor == null ? null : creditor.trim();
	}
	
    /**
     * @return Creditor
     */	
	public String getCreditor() {
		return this.creditor;
	}
	
	/**
	 * @param liabCurrCd
	 */
	public void setLiabCurrCd(String liabCurrCd) {
		this.liabCurrCd = liabCurrCd == null ? null : liabCurrCd.trim();
	}
	
    /**
     * @return LiabCurrCd
     */	
	public String getLiabCurrCd() {
		return this.liabCurrCd;
	}
	
	/**
	 * @param liabAmt
	 */
	public void setLiabAmt(java.math.BigDecimal liabAmt) {
		this.liabAmt = liabAmt;
	}
	
    /**
     * @return LiabAmt
     */	
	public java.math.BigDecimal getLiabAmt() {
		return this.liabAmt;
	}
	
	/**
	 * @param liabStartDate
	 */
	public void setLiabStartDate(String liabStartDate) {
		this.liabStartDate = liabStartDate == null ? null : liabStartDate.trim();
	}
	
    /**
     * @return LiabStartDate
     */	
	public String getLiabStartDate() {
		return this.liabStartDate;
	}
	
	/**
	 * @param liabEndDate
	 */
	public void setLiabEndDate(String liabEndDate) {
		this.liabEndDate = liabEndDate == null ? null : liabEndDate.trim();
	}
	
    /**
     * @return LiabEndDate
     */	
	public String getLiabEndDate() {
		return this.liabEndDate;
	}
	
	/**
	 * @param credCrdNum
	 */
	public void setCredCrdNum(java.math.BigDecimal credCrdNum) {
		this.credCrdNum = credCrdNum;
	}
	
    /**
     * @return CredCrdNum
     */	
	public java.math.BigDecimal getCredCrdNum() {
		return this.credCrdNum;
	}
	
	/**
	 * @param loanGuarBal
	 */
	public void setLoanGuarBal(java.math.BigDecimal loanGuarBal) {
		this.loanGuarBal = loanGuarBal;
	}
	
    /**
     * @return LoanGuarBal
     */	
	public java.math.BigDecimal getLoanGuarBal() {
		return this.loanGuarBal;
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
        OcrmFciPerLiabInfo other = (OcrmFciPerLiabInfo) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getIndivDebtId() == null ? other.getIndivDebtId() == null : this.getIndivDebtId().equals(other.getIndivDebtId()))
        	&& (this.getLiabType() == null ? other.getLiabType() == null : this.getLiabType().equals(other.getLiabType()))
        	&& (this.getLiabDesc() == null ? other.getLiabDesc() == null : this.getLiabDesc().equals(other.getLiabDesc()))
        	&& (this.getCreditor() == null ? other.getCreditor() == null : this.getCreditor().equals(other.getCreditor()))
        	&& (this.getLiabCurrCd() == null ? other.getLiabCurrCd() == null : this.getLiabCurrCd().equals(other.getLiabCurrCd()))
                	&& (this.getLiabStartDate() == null ? other.getLiabStartDate() == null : this.getLiabStartDate().equals(other.getLiabStartDate()))
        	&& (this.getLiabEndDate() == null ? other.getLiabEndDate() == null : this.getLiabEndDate().equals(other.getLiabEndDate()))
                        	&& (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getIndivDebtId() == null) ? 0 : getIndivDebtId().hashCode());
        result = prime * result + ((getLiabType() == null) ? 0 : getLiabType().hashCode());
        result = prime * result + ((getLiabDesc() == null) ? 0 : getLiabDesc().hashCode());
        result = prime * result + ((getCreditor() == null) ? 0 : getCreditor().hashCode());
        result = prime * result + ((getLiabCurrCd() == null) ? 0 : getLiabCurrCd().hashCode());
        result = prime * result + ((getLiabStartDate() == null) ? 0 : getLiabStartDate().hashCode());
        result = prime * result + ((getLiabEndDate() == null) ? 0 : getLiabEndDate().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", indivDebtId=").append(indivDebtId);
		sb.append(", liabType=").append(liabType);
		sb.append(", liabDesc=").append(liabDesc);
		sb.append(", creditor=").append(creditor);
		sb.append(", liabCurrCd=").append(liabCurrCd);
		sb.append(", liabAmt=").append(liabAmt);
		sb.append(", liabStartDate=").append(liabStartDate);
		sb.append(", liabEndDate=").append(liabEndDate);
		sb.append(", credCrdNum=").append(credCrdNum);
		sb.append(", loanGuarBal=").append(loanGuarBal);
		sb.append(", remarks=").append(remarks);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}