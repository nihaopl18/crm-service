package cn.com.yusys.yscrm.custgrade.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: OcrmFciPreGradeApplyInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-20 16:12:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PRE_GRADE_APPLY_INFO")
public class OcrmFciPreGradeApplyInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键 **/
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	private String id;
	
	/** 客户号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 申请时间 **/
	@Temporal(TemporalType.DATE)
	@Column(name = "APP_HOURS")
	private Date appHours;
	
	/** 申请人 **/
	@Column(name = "APPLICANT", unique = false, nullable = true, length = 32)
	private String applicant;
	
	/** 申请人机构 **/
	@Column(name = "APPL_INS", unique = false, nullable = true, length = 32)
	private String applIns;
	
	/** 当期服务等级 **/
	@Column(name = "CUR_SER_LEVEL")
	private String curSerLevel;
	
	/** 申请服务等级 **/
	@Column(name = "APP_SER_LEVEL")
	private String appSerLevel;
	
	/** 申请理由 **/
	@Column(name = "APP_REA", unique = false, nullable = true, length = 300)
	private String appRea;
	
	/** 评级有效期 **/
	@Column(name = "RAT_VAL", unique = false, nullable = true, length = 10)
	private String ratVal;
	
	/** 近三个月日均总资产 **/
	@Column(name = "LAST_THREE_MON_DAY_TOTAL_ASS", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal lastThreeMonDayTotalAss;
	
	/** 近三个月日均总负债 **/
	@Column(name = "LAST_THREE_MON_DAY_TOTAL_LIA", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal lastThreeMonDayTotalLia;
	
	/** 近1年中间业务贡献值 **/
	@Column(name = "LATE_YEAR_MID_BUS_DEGREE", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal lateYearMidBusDegree;
	
	/** 近1年结算量 **/
	@Column(name = "LATE_YEAR_SET_VOL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal lateYearSetVol;
	
	/** 近1年刷卡消费金额 **/
	@Column(name = "LATE_YEAR_CRE_CARD_CON_AMO", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal lateYearCreCardConAmo;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 审批状态 **/
	@Column(name = "APPROVE_STAT", unique = false, nullable = true, length = 30)
	private String approveStat;
	
	/** 客户姓名 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 100)
	private String custName;
	
	
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
	 * @param appHours
	 */
	public void setAppHours(Date appHours) {
		this.appHours = appHours;
	}
	
    /**
     * @return AppHours
     */	
	public Date getAppHours() {
		return this.appHours;
	}
	
	/**
	 * @param applicant
	 */
	public void setApplicant(String applicant) {
		this.applicant = applicant == null ? null : applicant.trim();
	}
	
    /**
     * @return Applicant
     */	
	public String getApplicant() {
		return this.applicant;
	}
	
	/**
	 * @param applIns
	 */
	public void setApplIns(String applIns) {
		this.applIns = applIns == null ? null : applIns.trim();
	}
	
    /**
     * @return ApplIns
     */	
	public String getApplIns() {
		return this.applIns;
	}
	
	/**
	 * @param curSerLevel
	 */
	public void setCurSerLevel(String curSerLevel) {
		this.curSerLevel = curSerLevel == null ? null : curSerLevel.trim();
	}
	
    /**
     * @return CurSerLevel
     */	
	public String getCurSerLevel() {
		return this.curSerLevel;
	}
	
	/**
	 * @param appSerLevel
	 */
	public void setAppSerLevel(String appSerLevel) {
		this.appSerLevel = appSerLevel == null ? null : appSerLevel.trim();
	}
	
    /**
     * @return AppSerLevel
     */	
	public String getAppSerLevel() {
		return this.appSerLevel;
	}
	
	/**
	 * @param appRea
	 */
	public void setAppRea(String appRea) {
		this.appRea = appRea == null ? null : appRea.trim();
	}
	
    /**
     * @return AppRea
     */	
	public String getAppRea() {
		return this.appRea;
	}
	
	/**
	 * @param ratVal
	 */
	public void setRatVal(String ratVal) {
		this.ratVal = ratVal == null ? null : ratVal.trim();
	}
	
    /**
     * @return RatVal
     */	
	public String getRatVal() {
		return this.ratVal;
	}
	
	/**
	 * @param lastThreeMonDayTotalAss
	 */
	public void setLastThreeMonDayTotalAss(java.math.BigDecimal lastThreeMonDayTotalAss) {
		this.lastThreeMonDayTotalAss = lastThreeMonDayTotalAss;
	}
	
    /**
     * @return LastThreeMonDayTotalAss
     */	
	public java.math.BigDecimal getLastThreeMonDayTotalAss() {
		return this.lastThreeMonDayTotalAss;
	}
	
	/**
	 * @param lastThreeMonDayTotalLia
	 */
	public void setLastThreeMonDayTotalLia(java.math.BigDecimal lastThreeMonDayTotalLia) {
		this.lastThreeMonDayTotalLia = lastThreeMonDayTotalLia;
	}
	
    /**
     * @return LastThreeMonDayTotalLia
     */	
	public java.math.BigDecimal getLastThreeMonDayTotalLia() {
		return this.lastThreeMonDayTotalLia;
	}
	
	/**
	 * @param lateYearMidBusDegree
	 */
	public void setLateYearMidBusDegree(java.math.BigDecimal lateYearMidBusDegree) {
		this.lateYearMidBusDegree = lateYearMidBusDegree;
	}
	
    /**
     * @return LateYearMidBusDegree
     */	
	public java.math.BigDecimal getLateYearMidBusDegree() {
		return this.lateYearMidBusDegree;
	}
	
	/**
	 * @param lateYearSetVol
	 */
	public void setLateYearSetVol(java.math.BigDecimal lateYearSetVol) {
		this.lateYearSetVol = lateYearSetVol;
	}
	
    /**
     * @return LateYearSetVol
     */	
	public java.math.BigDecimal getLateYearSetVol() {
		return this.lateYearSetVol;
	}
	
	/**
	 * @param lateYearCreCardConAmo
	 */
	public void setLateYearCreCardConAmo(java.math.BigDecimal lateYearCreCardConAmo) {
		this.lateYearCreCardConAmo = lateYearCreCardConAmo;
	}
	
    /**
     * @return LateYearCreCardConAmo
     */	
	public java.math.BigDecimal getLateYearCreCardConAmo() {
		return this.lateYearCreCardConAmo;
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
	 * @param approveStat
	 */
	public void setApproveStat(String approveStat) {
		this.approveStat = approveStat == null ? null : approveStat.trim();
	}
	
    /**
     * @return ApproveStat
     */	
	public String getApproveStat() {
		return this.approveStat;
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
        OcrmFciPreGradeApplyInfo other = (OcrmFciPreGradeApplyInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
                	&& (this.getApplicant() == null ? other.getApplicant() == null : this.getApplicant().equals(other.getApplicant()))
        	&& (this.getApplIns() == null ? other.getApplIns() == null : this.getApplIns().equals(other.getApplIns()))
        	&& (this.getCurSerLevel() == null ? other.getCurSerLevel() == null : this.getCurSerLevel().equals(other.getCurSerLevel()))
        	&& (this.getAppSerLevel() == null ? other.getAppSerLevel() == null : this.getAppSerLevel().equals(other.getAppSerLevel()))
        	&& (this.getAppRea() == null ? other.getAppRea() == null : this.getAppRea().equals(other.getAppRea()))
        	&& (this.getRatVal() == null ? other.getRatVal() == null : this.getRatVal().equals(other.getRatVal()))
                                                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getApproveStat() == null ? other.getApproveStat() == null : this.getApproveStat().equals(other.getApproveStat()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getApplicant() == null) ? 0 : getApplicant().hashCode());
        result = prime * result + ((getApplIns() == null) ? 0 : getApplIns().hashCode());
        result = prime * result + ((getCurSerLevel() == null) ? 0 : getCurSerLevel().hashCode());
        result = prime * result + ((getAppSerLevel() == null) ? 0 : getAppSerLevel().hashCode());
        result = prime * result + ((getAppRea() == null) ? 0 : getAppRea().hashCode());
        result = prime * result + ((getRatVal() == null) ? 0 : getRatVal().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getApproveStat() == null) ? 0 : getApproveStat().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
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
		sb.append(", appHours=").append(appHours);
		sb.append(", applicant=").append(applicant);
		sb.append(", applIns=").append(applIns);
		sb.append(", curSerLevel=").append(curSerLevel);
		sb.append(", appSerLevel=").append(appSerLevel);
		sb.append(", appRea=").append(appRea);
		sb.append(", ratVal=").append(ratVal);
		sb.append(", lastThreeMonDayTotalAss=").append(lastThreeMonDayTotalAss);
		sb.append(", lastThreeMonDayTotalLia=").append(lastThreeMonDayTotalLia);
		sb.append(", lateYearMidBusDegree=").append(lateYearMidBusDegree);
		sb.append(", lateYearSetVol=").append(lateYearSetVol);
		sb.append(", lateYearCreCardConAmo=").append(lateYearCreCardConAmo);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", approveStat=").append(approveStat);
		sb.append(", custName=").append(custName);
        sb.append("]");
        return sb.toString();
    }
}