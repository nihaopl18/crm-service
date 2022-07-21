package cn.com.yusys.yscrm.custmgr.domain;

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
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmBusiSumD
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 16:47:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_A_CM_BUSI_SUM_D")
public class AcrmAcmBusiSumD extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = false, length = 10)
	private String corpOrgCode;
	
	/** 数据日期 **/
	@Column(name = "DATA_DT", unique = false, nullable = false, length = 7)
	private Date dataDt;
	
	/** 对象编号 **/
	@Column(name = "TARGET_ID", unique = false, nullable = false, length = 10)
	private String targetId;
	
	/** 汇总维度 **/
	@Column(name = "TARGET_TYPE", unique = false, nullable = false, length = 1)
	private String targetType;
	
	/** 归属条线 **/
	@Column(name = "BEL_TYPE", unique = false, nullable = true, length = 30)
	private String belType;
	
	/** 管理企业户数 **/
	@Column(name = "ORG_NUM", unique = false, nullable = true, length = 10)
	private long orgNum;
	
	/** 管理个人户数 **/
	@Column(name = "PER_NUM", unique = false, nullable = true, length = 10)
	private long perNum;
	
	/** 管理有效对公户新增 **/
	@Column(name = "NEW_EFF_ORG_NUM", unique = false, nullable = true, length = 10)
	private long newEffOrgNum;
	
	/** 管理有效对公户新增 **/
	@Column(name = "NEW_EFF_PER_NUM", unique = false, nullable = true, length = 10)
	private long newEffPerNum;
	
	/** 管户企业存款余额 **/
	@Column(name = "DPS_BAL_ORG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dpsBalOrg;
	
	/** 管户企业存款月日均余额 **/
	@Column(name = "DPS_M_AVG_BAL_ORG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dpsMavgBalOrg;
	
	/** 管户个人存款余额 **/
	@Column(name = "DPS_BAL_PER", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dpsBalPer;
	
	/** 管户个人存款月日均余额 **/
	@Column(name = "DPS_M_AVG_BAL_PER", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal dpsMavgBalPer;
	
	/** 管户贷款余额 **/
	@Column(name = "LOAN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanBal;
	
	/** 管户贷款月日均余额 **/
	@Column(name = "LOAN_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanMavgBal;
	
	/** 管户理财产品余额 **/
	@Column(name = "FIN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal finBal;
	
	/** 管户理财产品月日均余额 **/
	@Column(name = "FIN_M_AVG_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal finMavgBal;
	
	/** 管户对公客户资产规模 **/
	@Column(name = "AUM_BAL_ORG", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal aumBalOrg;
	
	/** 管户个人客户资产规模 **/
	@Column(name = "AUM_BAL_PER", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal aumBalPer;
	
	
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
	
	/**
	 * @param targetId
	 */
	public void setTargetId(String targetId) {
		this.targetId = targetId == null ? null : targetId.trim();
	}
	
    /**
     * @return TargetId
     */	
	public String getTargetId() {
		return this.targetId;
	}
	
	/**
	 * @param targetType
	 */
	public void setTargetType(String targetType) {
		this.targetType = targetType == null ? null : targetType.trim();
	}
	
    /**
     * @return TargetType
     */	
	public String getTargetType() {
		return this.targetType;
	}
	
	/**
	 * @param belType
	 */
	public void setBelType(String belType) {
		this.belType = belType == null ? null : belType.trim();
	}
	
    /**
     * @return BelType
     */	
	public String getBelType() {
		return this.belType;
	}
	
	/**
	 * @param orgNum
	 */
	public void setOrgNum(long orgNum) {
		this.orgNum = orgNum;
	}
	
    /**
     * @return OrgNum
     */	
	public long getOrgNum() {
		return this.orgNum;
	}
	
	/**
	 * @param perNum
	 */
	public void setPerNum(long perNum) {
		this.perNum = perNum;
	}
	
    /**
     * @return PerNum
     */	
	public long getPerNum() {
		return this.perNum;
	}
	
	/**
	 * @param newEffOrgNum
	 */
	public void setNewEffOrgNum(long newEffOrgNum) {
		this.newEffOrgNum = newEffOrgNum;
	}
	
    /**
     * @return NewEffOrgNum
     */	
	public long getNewEffOrgNum() {
		return this.newEffOrgNum;
	}
	
	/**
	 * @param newEffPerNum
	 */
	public void setNewEffPerNum(long newEffPerNum) {
		this.newEffPerNum = newEffPerNum;
	}
	
    /**
     * @return NewEffPerNum
     */	
	public long getNewEffPerNum() {
		return this.newEffPerNum;
	}
	
	/**
	 * @param dpsBalOrg
	 */
	public void setDpsBalOrg(java.math.BigDecimal dpsBalOrg) {
		this.dpsBalOrg = dpsBalOrg;
	}
	
    /**
     * @return DpsBalOrg
     */	
	public java.math.BigDecimal getDpsBalOrg() {
		return this.dpsBalOrg;
	}
	
	/**
	 * @param dpsMavgBalOrg
	 */
	public void setDpsMavgBalOrg(java.math.BigDecimal dpsMavgBalOrg) {
		this.dpsMavgBalOrg = dpsMavgBalOrg;
	}
	
    /**
     * @return DpsMavgBalOrg
     */	
	public java.math.BigDecimal getDpsMavgBalOrg() {
		return this.dpsMavgBalOrg;
	}
	
	/**
	 * @param dpsBalPer
	 */
	public void setDpsBalPer(java.math.BigDecimal dpsBalPer) {
		this.dpsBalPer = dpsBalPer;
	}
	
    /**
     * @return DpsBalPer
     */	
	public java.math.BigDecimal getDpsBalPer() {
		return this.dpsBalPer;
	}
	
	/**
	 * @param dpsMavgBalPer
	 */
	public void setDpsMavgBalPer(java.math.BigDecimal dpsMavgBalPer) {
		this.dpsMavgBalPer = dpsMavgBalPer;
	}
	
    /**
     * @return DpsMavgBalPer
     */	
	public java.math.BigDecimal getDpsMavgBalPer() {
		return this.dpsMavgBalPer;
	}
	
	/**
	 * @param loanBal
	 */
	public void setLoanBal(java.math.BigDecimal loanBal) {
		this.loanBal = loanBal;
	}
	
    /**
     * @return LoanBal
     */	
	public java.math.BigDecimal getLoanBal() {
		return this.loanBal;
	}
	
	/**
	 * @param loanMavgBal
	 */
	public void setLoanMavgBal(java.math.BigDecimal loanMavgBal) {
		this.loanMavgBal = loanMavgBal;
	}
	
    /**
     * @return LoanMavgBal
     */	
	public java.math.BigDecimal getLoanMavgBal() {
		return this.loanMavgBal;
	}
	
	/**
	 * @param finBal
	 */
	public void setFinBal(java.math.BigDecimal finBal) {
		this.finBal = finBal;
	}
	
    /**
     * @return FinBal
     */	
	public java.math.BigDecimal getFinBal() {
		return this.finBal;
	}
	
	/**
	 * @param finMavgBal
	 */
	public void setFinMavgBal(java.math.BigDecimal finMavgBal) {
		this.finMavgBal = finMavgBal;
	}
	
    /**
     * @return FinMavgBal
     */	
	public java.math.BigDecimal getFinMavgBal() {
		return this.finMavgBal;
	}
	
	/**
	 * @param aumBalOrg
	 */
	public void setAumBalOrg(java.math.BigDecimal aumBalOrg) {
		this.aumBalOrg = aumBalOrg;
	}
	
    /**
     * @return AumBalOrg
     */	
	public java.math.BigDecimal getAumBalOrg() {
		return this.aumBalOrg;
	}
	
	/**
	 * @param aumBalPer
	 */
	public void setAumBalPer(java.math.BigDecimal aumBalPer) {
		this.aumBalPer = aumBalPer;
	}
	
    /**
     * @return AumBalPer
     */	
	public java.math.BigDecimal getAumBalPer() {
		return this.aumBalPer;
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
        AcrmAcmBusiSumD other = (AcrmAcmBusiSumD) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getTargetId() == null ? other.getTargetId() == null : this.getTargetId().equals(other.getTargetId()))
        	&& (this.getTargetType() == null ? other.getTargetType() == null : this.getTargetType().equals(other.getTargetType()))
        	&& (this.getBelType() == null ? other.getBelType() == null : this.getBelType().equals(other.getBelType()))
                                                                                                                        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getTargetId() == null) ? 0 : getTargetId().hashCode());
        result = prime * result + ((getTargetType() == null) ? 0 : getTargetType().hashCode());
        result = prime * result + ((getBelType() == null) ? 0 : getBelType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", dataDt=").append(dataDt);
		sb.append(", targetId=").append(targetId);
		sb.append(", targetType=").append(targetType);
		sb.append(", belType=").append(belType);
		sb.append(", orgNum=").append(orgNum);
		sb.append(", perNum=").append(perNum);
		sb.append(", newEffOrgNum=").append(newEffOrgNum);
		sb.append(", newEffPerNum=").append(newEffPerNum);
		sb.append(", dpsBalOrg=").append(dpsBalOrg);
		sb.append(", dpsMavgBalOrg=").append(dpsMavgBalOrg);
		sb.append(", dpsBalPer=").append(dpsBalPer);
		sb.append(", dpsMavgBalPer=").append(dpsMavgBalPer);
		sb.append(", loanBal=").append(loanBal);
		sb.append(", loanMavgBal=").append(loanMavgBal);
		sb.append(", finBal=").append(finBal);
		sb.append(", finMavgBal=").append(finMavgBal);
		sb.append(", aumBalOrg=").append(aumBalOrg);
		sb.append(", aumBalPer=").append(aumBalPer);
        sb.append("]");
        return sb.toString();
    }
}