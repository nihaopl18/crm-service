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
 * @类名称: AcrmFciRiskWarnInfo
 * @类描述: #数据实体类
 * @功能描述: 风险预警信息
 * @创建人: 15104
 * @创建时间: 2019-02-13 15:31:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_RISK_WARN_INFO")
public class AcrmFciRiskWarnInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户标识
 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 最新更新系统
	 **/
		@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
		private String custId;
	
	/** 数据日期
 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 最新更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间
 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户类型
 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 风险类型
 **/
	@Column(name = "RISK_TYPE", unique = false, nullable = true, length = 20)
	private String riskType;
	
	/** 风险描述
 **/
	@Column(name = "RISK_DESC", unique = false, nullable = true, length = 200)
	private String riskDesc;
	
	/** 风险等级
 **/
	@Column(name = "RISK_LEV", unique = false, nullable = true, length = 20)
	private String riskLev;
	
	/** 风险状态
 **/
	@Column(name = "RISK_STATUS", unique = false, nullable = true, length = 20)
	private String riskStatus;
	
	/** 风险提示日期
 **/
	@Transient
	@Column(name = "RISK_TIP_DATE", unique = false, nullable = true, length = 7)
	private Date riskTipDate;
	
	/** 风险处置日期
 **/
	@Transient
	@Column(name = "RISK_SET_DATE", unique = false, nullable = true, length = 7)
	private Date riskSetDate;
	
	/** 来源系统
 **/
	@Column(name = "SRC_SYS_CD", unique = false, nullable = true, length = 20)
	private String srcSysCd;
	
	
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
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
	}
	/**
     * @return id
     */	
	public String getId() {
		return this.id;
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
	 * @param riskType
	 */
	public void setRiskType(String riskType) {
		this.riskType = riskType == null ? null : riskType.trim();
	}
	
    /**
     * @return RiskType
     */	
	public String getRiskType() {
		return this.riskType;
	}
	
	/**
	 * @param riskDesc
	 */
	public void setRiskDesc(String riskDesc) {
		this.riskDesc = riskDesc == null ? null : riskDesc.trim();
	}
	
    /**
     * @return RiskDesc
     */	
	public String getRiskDesc() {
		return this.riskDesc;
	}
	
	/**
	 * @param riskLev
	 */
	public void setRiskLev(String riskLev) {
		this.riskLev = riskLev == null ? null : riskLev.trim();
	}
	
    /**
     * @return RiskLev
     */	
	public String getRiskLev() {
		return this.riskLev;
	}
	
	/**
	 * @param riskStatus
	 */
	public void setRiskStatus(String riskStatus) {
		this.riskStatus = riskStatus == null ? null : riskStatus.trim();
	}
	
    /**
     * @return RiskStatus
     */	
	public String getRiskStatus() {
		return this.riskStatus;
	}
	
	/**
	 * @param riskTipDate
	 */
	public void setRiskTipDate(Date riskTipDate) {
		this.riskTipDate = riskTipDate;
	}
	
    /**
     * @return RiskTipDate
     */	
	public Date getRiskTipDate() {
		return this.riskTipDate;
	}
	
	/**
	 * @param riskSetDate
	 */
	public void setRiskSetDate(Date riskSetDate) {
		this.riskSetDate = riskSetDate;
	}
	
    /**
     * @return RiskSetDate
     */	
	public Date getRiskSetDate() {
		return this.riskSetDate;
	}
	
	/**
	 * @param srcSysCd
	 */
	public void setSrcSysCd(String srcSysCd) {
		this.srcSysCd = srcSysCd == null ? null : srcSysCd.trim();
	}
	
    /**
     * @return SrcSysCd
     */	
	public String getSrcSysCd() {
		return this.srcSysCd;
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
        AcrmFciRiskWarnInfo other = (AcrmFciRiskWarnInfo) that;
        		return (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getRiskType() == null ? other.getRiskType() == null : this.getRiskType().equals(other.getRiskType()))
        	&& (this.getRiskDesc() == null ? other.getRiskDesc() == null : this.getRiskDesc().equals(other.getRiskDesc()))
        	&& (this.getRiskLev() == null ? other.getRiskLev() == null : this.getRiskLev().equals(other.getRiskLev()))
        	&& (this.getRiskStatus() == null ? other.getRiskStatus() == null : this.getRiskStatus().equals(other.getRiskStatus()))
                        	&& (this.getSrcSysCd() == null ? other.getSrcSysCd() == null : this.getSrcSysCd().equals(other.getSrcSysCd()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getRiskType() == null) ? 0 : getRiskType().hashCode());
        result = prime * result + ((getRiskDesc() == null) ? 0 : getRiskDesc().hashCode());
        result = prime * result + ((getRiskLev() == null) ? 0 : getRiskLev().hashCode());
        result = prime * result + ((getRiskStatus() == null) ? 0 : getRiskStatus().hashCode());
        result = prime * result + ((getSrcSysCd() == null) ? 0 : getSrcSysCd().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", id=").append(id);
		sb.append(", custType=").append(custType);
		sb.append(", riskType=").append(riskType);
		sb.append(", riskDesc=").append(riskDesc);
		sb.append(", riskLev=").append(riskLev);
		sb.append(", riskStatus=").append(riskStatus);
		sb.append(", riskTipDate=").append(riskTipDate);
		sb.append(", riskSetDate=").append(riskSetDate);
		sb.append(", srcSysCd=").append(srcSysCd);
        sb.append("]");
        return sb.toString();
    }
}