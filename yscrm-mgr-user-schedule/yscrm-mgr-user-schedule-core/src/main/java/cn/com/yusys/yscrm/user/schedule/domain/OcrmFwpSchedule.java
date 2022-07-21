package cn.com.yusys.yscrm.user.schedule.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-user-schedule-core模块
 * @类名称: OcrmFwpSchedule
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-12 18:34:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_SCHEDULE")
public class OcrmFwpSchedule extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 日程ID **/
	@Id
	@Column(name = "SCHEDULE_ID")
	@Generated(GenerationType.UUID)
	private String scheduleId;
	
	/** 创建人ID **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 32)
	private String cratUsr;
	
	/** 客户经理编号 **/
	@Column(name = "MGR_ID", unique = false, nullable = true, length = 32)
	private String mgrId;
	
	/** 客户经理姓名 **/
	@Column(name = "MGR_NAME", unique = false, nullable = true, length = 80)
	private String mgrName;
	
	/** 创建机构ID **/
	@Column(name = "CRAT_ORG", unique = false, nullable = true, length = 32)
	private String cratOrg;
	
	/** 创建时间 **/
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 20)
	private String cratDt;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 32)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 20)
	private String lastChgDt;
	
	/** 客户联系拜访日程数 **/
	@Column(name = "VISIT_COUNT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal visitCount;
	
	/** 工作计划日程数 **/
	@Column(name = "WEEK_COUNT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal weekCount;
	
	/** 其他日程数 **/
	@Column(name = "OTHER_COUNT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal otherCount;
	
	/** 日程日期 **/
	@Column(name = "SCH_DATE", unique = false, nullable = true, length = 20)
	private String schDate;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
	/**
	 * @param scheduleId
	 */
	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId == null ? null : scheduleId.trim();
	}
	
    /**
     * @return ScheduleId
     */	
	public String getScheduleId() {
		return this.scheduleId;
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
	 * @param mgrId
	 */
	public void setMgrId(String mgrId) {
		this.mgrId = mgrId == null ? null : mgrId.trim();
	}
	
    /**
     * @return MgrId
     */	
	public String getMgrId() {
		return this.mgrId;
	}
	
	/**
	 * @param mgrName
	 */
	public void setMgrName(String mgrName) {
		this.mgrName = mgrName == null ? null : mgrName.trim();
	}
	
    /**
     * @return MgrName
     */	
	public String getMgrName() {
		return this.mgrName;
	}
	
	/**
	 * @param cratOrg
	 */
	public void setCratOrg(String cratOrg) {
		this.cratOrg = cratOrg == null ? null : cratOrg.trim();
	}
	
    /**
     * @return CratOrg
     */	
	public String getCratOrg() {
		return this.cratOrg;
	}
	
	/**
	 * @param cratDt
	 */
	public void setCratDt(String cratDt) {
		this.cratDt = cratDt == null ? null : cratDt.trim();
	}
	
    /**
     * @return CratDt
     */	
	public String getCratDt() {
		return this.cratDt;
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
	public void setLastChgDt(String lastChgDt) {
		this.lastChgDt = lastChgDt == null ? null : lastChgDt.trim();
	}
	
    /**
     * @return LastChgDt
     */	
	public String getLastChgDt() {
		return this.lastChgDt;
	}
	
	/**
	 * @param visitCount
	 */
	public void setVisitCount(java.math.BigDecimal visitCount) {
		this.visitCount = visitCount;
	}
	
    /**
     * @return VisitCount
     */	
	public java.math.BigDecimal getVisitCount() {
		return this.visitCount;
	}
	
	/**
	 * @param weekCount
	 */
	public void setWeekCount(java.math.BigDecimal weekCount) {
		this.weekCount = weekCount;
	}
	
    /**
     * @return WeekCount
     */	
	public java.math.BigDecimal getWeekCount() {
		return this.weekCount;
	}
	
	/**
	 * @param otherCount
	 */
	public void setOtherCount(java.math.BigDecimal otherCount) {
		this.otherCount = otherCount;
	}
	
    /**
     * @return OtherCount
     */	
	public java.math.BigDecimal getOtherCount() {
		return this.otherCount;
	}
	
	/**
	 * @param schDate
	 */
	public void setSchDate(String schDate) {
		this.schDate = schDate == null ? null : schDate.trim();
	}
	
    /**
     * @return SchDate
     */	
	public String getSchDate() {
		return this.schDate;
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
        OcrmFwpSchedule other = (OcrmFwpSchedule) that;
		return (this.getScheduleId() == null ? other.getScheduleId() == null : this.getScheduleId().equals(other.getScheduleId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        	&& (this.getCratOrg() == null ? other.getCratOrg() == null : this.getCratOrg().equals(other.getCratOrg()))
        	&& (this.getCratDt() == null ? other.getCratDt() == null : this.getCratDt().equals(other.getCratDt()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
        	&& (this.getLastChgDt() == null ? other.getLastChgDt() == null : this.getLastChgDt().equals(other.getLastChgDt()))
                                	&& (this.getSchDate() == null ? other.getSchDate() == null : this.getSchDate().equals(other.getSchDate()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getScheduleId() == null) ? 0 : getScheduleId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getCratOrg() == null) ? 0 : getCratOrg().hashCode());
        result = prime * result + ((getCratDt() == null) ? 0 : getCratDt().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getLastChgDt() == null) ? 0 : getLastChgDt().hashCode());
        result = prime * result + ((getSchDate() == null) ? 0 : getSchDate().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", scheduleId=").append(scheduleId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", mgrId=").append(mgrId);
		sb.append(", mgrName=").append(mgrName);
		sb.append(", cratOrg=").append(cratOrg);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", visitCount=").append(visitCount);
		sb.append(", weekCount=").append(weekCount);
		sb.append(", otherCount=").append(otherCount);
		sb.append(", schDate=").append(schDate);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}