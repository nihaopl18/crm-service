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
 * @类名称: OcrmFwpSchedulePlan
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-16 11:39:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_SCHEDULE_PLAN")
public class OcrmFwpSchedulePlan extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "P_ID")
	@Generated(GenerationType.UUID)
	private String pid;
	
	/** 日程编号 **/
	@Column(name = "SCHEDULE_ID", unique = false, nullable = true, length = 32)
	private String scheduleId;
	
	/** 工作计划类型 **/
	@Column(name = "SCH_TYPE", unique = false, nullable = true, length = 30)
	private String schType;
	
	/** 任务周期(YYYY年MM月) **/
	@Column(name = "MONTH_CYCLE", unique = false, nullable = true, length = 30)
	private String monthCycle;
	
	/** 工作计划任务内容 **/
	@Column(name = "SCH_CONTENT", unique = false, nullable = true, length = 2000)
	private String schContent;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 2000)
	private String remark;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 80)
	private String custName;
	
	/** 计划开始时间 **/
	@Column(name = "SCH_START_TIME", unique = false, nullable = true, length = 20)
	private String schStartTime;
	
	/** 计划结束时间 **/
	@Column(name = "SCH_END_TIME", unique = false, nullable = true, length = 20)
	private String schEndTime;
	
	/** 实际开始时间 **/
	@Column(name = "ACT_START_TIME", unique = false, nullable = true, length = 20)
	private String actStartTime;
	
	/** 实际结束时间 **/
	@Column(name = "ACT_END_TIME", unique = false, nullable = true, length = 20)
	private String actEndTime;
	
	/** 计划完成进度 **/
	@Column(name = "SCHEDULE", unique = false, nullable = true, length = 30)
	private String schedule;
	
	/** 未按时完成说明 **/
	@Column(name = "UNFINISHED_REMARK", unique = false, nullable = true, length = 2000)
	private String unfinishedRemark;
	
	/** 计划执行状态 **/
	@Column(name = "STAT", unique = false, nullable = true, length = 30)
	private String stat;
	
	/** 任务安排人ID **/
	@Column(name = "ARANGE_ID", unique = false, nullable = true, length = 32)
	private String arangeId;
	
	/** 任务安排人 **/
	@Column(name = "ARANGE_NAME", unique = false, nullable = true, length = 80)
	private String arangeName;
	
	/** 客户经理编号 **/
	@Column(name = "MGR_ID", unique = false, nullable = true, length = 32)
	private String mgrId;
	
	/** 客户经理姓名 **/
	@Column(name = "MGR_NAME", unique = false, nullable = true, length = 80)
	private String mgrName;
	
	/** 是否提醒 **/
	@Column(name = "IS_REMIND", unique = false, nullable = true, length = 2)
	private String isRemind;
	
	/** 提醒日期 **/
	@Column(name = "REMIND_DATE", unique = false, nullable = true, length = 20)
	private String remindDate;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 是否删除 **/
	@Column(name = "IS_DELETE", unique = false, nullable = true, length = 2)
	private String isDelete;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 32)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 20)
	private String lastChgDt;
	
	
	/**
	 * @param pid
	 */
	public void setPid(String pid) {
		this.pid = pid == null ? null : pid.trim();
	}
	
    /**
     * @return Pid
     */	
	public String getPid() {
		return this.pid;
	}
	
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
	 * @param schType
	 */
	public void setSchType(String schType) {
		this.schType = schType == null ? null : schType.trim();
	}
	
    /**
     * @return SchType
     */	
	public String getSchType() {
		return this.schType;
	}
	
	/**
	 * @param monthCycle
	 */
	public void setMonthCycle(String monthCycle) {
		this.monthCycle = monthCycle == null ? null : monthCycle.trim();
	}
	
    /**
     * @return MonthCycle
     */	
	public String getMonthCycle() {
		return this.monthCycle;
	}
	
	/**
	 * @param schContent
	 */
	public void setSchContent(String schContent) {
		this.schContent = schContent == null ? null : schContent.trim();
	}
	
    /**
     * @return SchContent
     */	
	public String getSchContent() {
		return this.schContent;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
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
	
	/**
	 * @param schStartTime
	 */
	public void setSchStartTime(String schStartTime) {
		this.schStartTime = schStartTime == null ? null : schStartTime.trim();
	}
	
    /**
     * @return SchStartTime
     */	
	public String getSchStartTime() {
		return this.schStartTime;
	}
	
	/**
	 * @param schEndTime
	 */
	public void setSchEndTime(String schEndTime) {
		this.schEndTime = schEndTime == null ? null : schEndTime.trim();
	}
	
    /**
     * @return SchEndTime
     */	
	public String getSchEndTime() {
		return this.schEndTime;
	}
	
	/**
	 * @param actStartTime
	 */
	public void setActStartTime(String actStartTime) {
		this.actStartTime = actStartTime == null ? null : actStartTime.trim();
	}
	
    /**
     * @return ActStartTime
     */	
	public String getActStartTime() {
		return this.actStartTime;
	}
	
	/**
	 * @param actEndTime
	 */
	public void setActEndTime(String actEndTime) {
		this.actEndTime = actEndTime == null ? null : actEndTime.trim();
	}
	
    /**
     * @return ActEndTime
     */	
	public String getActEndTime() {
		return this.actEndTime;
	}
	
	/**
	 * @param schedule
	 */
	public void setSchedule(String schedule) {
		this.schedule = schedule == null ? null : schedule.trim();
	}
	
    /**
     * @return Schedule
     */	
	public String getSchedule() {
		return this.schedule;
	}
	
	/**
	 * @param unfinishedRemark
	 */
	public void setUnfinishedRemark(String unfinishedRemark) {
		this.unfinishedRemark = unfinishedRemark == null ? null : unfinishedRemark.trim();
	}
	
    /**
     * @return UnfinishedRemark
     */	
	public String getUnfinishedRemark() {
		return this.unfinishedRemark;
	}
	
	/**
	 * @param stat
	 */
	public void setStat(String stat) {
		this.stat = stat == null ? null : stat.trim();
	}
	
    /**
     * @return Stat
     */	
	public String getStat() {
		return this.stat;
	}
	
	/**
	 * @param arangeId
	 */
	public void setArangeId(String arangeId) {
		this.arangeId = arangeId == null ? null : arangeId.trim();
	}
	
    /**
     * @return ArangeId
     */	
	public String getArangeId() {
		return this.arangeId;
	}
	
	/**
	 * @param arangeName
	 */
	public void setArangeName(String arangeName) {
		this.arangeName = arangeName == null ? null : arangeName.trim();
	}
	
    /**
     * @return ArangeName
     */	
	public String getArangeName() {
		return this.arangeName;
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
	 * @param isRemind
	 */
	public void setIsRemind(String isRemind) {
		this.isRemind = isRemind == null ? null : isRemind.trim();
	}
	
    /**
     * @return IsRemind
     */	
	public String getIsRemind() {
		return this.isRemind;
	}
	
	/**
	 * @param remindDate
	 */
	public void setRemindDate(String remindDate) {
		this.remindDate = remindDate == null ? null : remindDate.trim();
	}
	
    /**
     * @return RemindDate
     */	
	public String getRemindDate() {
		return this.remindDate;
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
	 * @param isDelete
	 */
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete == null ? null : isDelete.trim();
	}
	
    /**
     * @return IsDelete
     */	
	public String getIsDelete() {
		return this.isDelete;
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
        OcrmFwpSchedulePlan other = (OcrmFwpSchedulePlan) that;
		return (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
        	&& (this.getScheduleId() == null ? other.getScheduleId() == null : this.getScheduleId().equals(other.getScheduleId()))
        	&& (this.getSchType() == null ? other.getSchType() == null : this.getSchType().equals(other.getSchType()))
        	&& (this.getMonthCycle() == null ? other.getMonthCycle() == null : this.getMonthCycle().equals(other.getMonthCycle()))
        	&& (this.getSchContent() == null ? other.getSchContent() == null : this.getSchContent().equals(other.getSchContent()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getSchStartTime() == null ? other.getSchStartTime() == null : this.getSchStartTime().equals(other.getSchStartTime()))
        	&& (this.getSchEndTime() == null ? other.getSchEndTime() == null : this.getSchEndTime().equals(other.getSchEndTime()))
        	&& (this.getActStartTime() == null ? other.getActStartTime() == null : this.getActStartTime().equals(other.getActStartTime()))
        	&& (this.getActEndTime() == null ? other.getActEndTime() == null : this.getActEndTime().equals(other.getActEndTime()))
        	&& (this.getSchedule() == null ? other.getSchedule() == null : this.getSchedule().equals(other.getSchedule()))
        	&& (this.getUnfinishedRemark() == null ? other.getUnfinishedRemark() == null : this.getUnfinishedRemark().equals(other.getUnfinishedRemark()))
        	&& (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
        	&& (this.getArangeId() == null ? other.getArangeId() == null : this.getArangeId().equals(other.getArangeId()))
        	&& (this.getArangeName() == null ? other.getArangeName() == null : this.getArangeName().equals(other.getArangeName()))
        	&& (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        	&& (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
        	&& (this.getRemindDate() == null ? other.getRemindDate() == null : this.getRemindDate().equals(other.getRemindDate()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getIsDelete() == null ? other.getIsDelete() == null : this.getIsDelete().equals(other.getIsDelete()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
        	&& (this.getLastChgDt() == null ? other.getLastChgDt() == null : this.getLastChgDt().equals(other.getLastChgDt()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getScheduleId() == null) ? 0 : getScheduleId().hashCode());
        result = prime * result + ((getSchType() == null) ? 0 : getSchType().hashCode());
        result = prime * result + ((getMonthCycle() == null) ? 0 : getMonthCycle().hashCode());
        result = prime * result + ((getSchContent() == null) ? 0 : getSchContent().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getSchStartTime() == null) ? 0 : getSchStartTime().hashCode());
        result = prime * result + ((getSchEndTime() == null) ? 0 : getSchEndTime().hashCode());
        result = prime * result + ((getActStartTime() == null) ? 0 : getActStartTime().hashCode());
        result = prime * result + ((getActEndTime() == null) ? 0 : getActEndTime().hashCode());
        result = prime * result + ((getSchedule() == null) ? 0 : getSchedule().hashCode());
        result = prime * result + ((getUnfinishedRemark() == null) ? 0 : getUnfinishedRemark().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        result = prime * result + ((getArangeId() == null) ? 0 : getArangeId().hashCode());
        result = prime * result + ((getArangeName() == null) ? 0 : getArangeName().hashCode());
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        result = prime * result + ((getRemindDate() == null) ? 0 : getRemindDate().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getLastChgDt() == null) ? 0 : getLastChgDt().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", pid=").append(pid);
		sb.append(", scheduleId=").append(scheduleId);
		sb.append(", schType=").append(schType);
		sb.append(", monthCycle=").append(monthCycle);
		sb.append(", schContent=").append(schContent);
		sb.append(", remark=").append(remark);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", schStartTime=").append(schStartTime);
		sb.append(", schEndTime=").append(schEndTime);
		sb.append(", actStartTime=").append(actStartTime);
		sb.append(", actEndTime=").append(actEndTime);
		sb.append(", schedule=").append(schedule);
		sb.append(", unfinishedRemark=").append(unfinishedRemark);
		sb.append(", stat=").append(stat);
		sb.append(", arangeId=").append(arangeId);
		sb.append(", arangeName=").append(arangeName);
		sb.append(", mgrId=").append(mgrId);
		sb.append(", mgrName=").append(mgrName);
		sb.append(", isRemind=").append(isRemind);
		sb.append(", remindDate=").append(remindDate);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", isDelete=").append(isDelete);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
        sb.append("]");
        return sb.toString();
    }
}