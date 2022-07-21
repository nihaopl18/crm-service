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
 * @类名称: OcrmFwpScheduleVisit
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-12 18:35:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_SCHEDULE_VISIT")
public class OcrmFwpScheduleVisit extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "V_ID")
	@Generated(GenerationType.UUID)
	private String vid;
	
	/** 日程编号 **/
	@Column(name = "SCHEDULE_ID", unique = false, nullable = true, length = 32)
	private String scheduleId;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;
	
	/** 客户类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 30)
	private String custType;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 任务安排人ID **/
	@Column(name = "ARANGE_ID", unique = false, nullable = true, length = 32)
	private String arangeId;
	
	/** 任务安排人 **/
	@Column(name = "ARANGE_NAME", unique = false, nullable = true, length = 80)
	private String arangeName;
	
	/** 接触状态 **/
	@Column(name = "VISIT_STAT", unique = false, nullable = true, length = 30)
	private String visitStat;
	
	/** 接触方式 **/
	@Column(name = "VISIT_TYPE", unique = false, nullable = true, length = 30)
	private String visitType;
	
	/** 接触人ID **/
	@Column(name = "VISITOR_ID", unique = false, nullable = true, length = 32)
	private String visitorId;
	
	/** 接触人 **/
	@Column(name = "VISITOR_NAME", unique = false, nullable = true, length = 80)
	private String visitorName;
	
	/** 客户联系和接触情况 **/
	@Column(name = "VISIT_NOTE", unique = false, nullable = true, length = 800)
	private String visitNote;
	
	/** 联系电话 **/
	@Column(name = "PHONE", unique = false, nullable = true, length = 30)
	private String phone;
	
	/** 客户经理编号 **/
	@Column(name = "MGR_ID", unique = false, nullable = true, length = 32)
	private String mgrId;
	
	/** 客户经理姓名 **/
	@Column(name = "MGR_NAME", unique = false, nullable = true, length = 80)
	private String mgrName;
	
	/** 本次接触目的 **/
	@Column(name = "VISIT_AIMS", unique = false, nullable = true, length = 800)
	private String visitAims;
	
	/** 本次接触成效 **/
	@Column(name = "VISIT_EFFECT", unique = false, nullable = true, length = 800)
	private String visitEffect;
	
	/** 接触开始时间 **/
	@Column(name = "VISIT_START_DATE", unique = false, nullable = true, length = 20)
	private String visitStartDate;
	
	/** 接触结束时间 **/
	@Column(name = "VISIT_END_DATE", unique = false, nullable = true, length = 20)
	private String visitEndDate;
	
	/** 计划下次接触时间 **/
	@Column(name = "NEXT_VISIT_DATE", unique = false, nullable = true, length = 20)
	private String nextVisitDate;
	
	/** 计划下次接触方式 **/
	@Column(name = "NEXT_VISIT_TYPE", unique = false, nullable = true, length = 30)
	private String nextVisitType;
	
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
	 * @param vid
	 */
	public void setVid(String vid) {
		this.vid = vid == null ? null : vid.trim();
	}
	
    /**
     * @return Vid
     */	
	public String getVid() {
		return this.vid;
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
	 * @param visitStat
	 */
	public void setVisitStat(String visitStat) {
		this.visitStat = visitStat == null ? null : visitStat.trim();
	}
	
    /**
     * @return VisitStat
     */	
	public String getVisitStat() {
		return this.visitStat;
	}
	
	/**
	 * @param visitType
	 */
	public void setVisitType(String visitType) {
		this.visitType = visitType == null ? null : visitType.trim();
	}
	
    /**
     * @return VisitType
     */	
	public String getVisitType() {
		return this.visitType;
	}
	
	/**
	 * @param visitorId
	 */
	public void setVisitorId(String visitorId) {
		this.visitorId = visitorId == null ? null : visitorId.trim();
	}
	
    /**
     * @return VisitorId
     */	
	public String getVisitorId() {
		return this.visitorId;
	}
	
	/**
	 * @param visitorName
	 */
	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName == null ? null : visitorName.trim();
	}
	
    /**
     * @return VisitorName
     */	
	public String getVisitorName() {
		return this.visitorName;
	}
	
	/**
	 * @param visitNote
	 */
	public void setVisitNote(String visitNote) {
		this.visitNote = visitNote == null ? null : visitNote.trim();
	}
	
    /**
     * @return VisitNote
     */	
	public String getVisitNote() {
		return this.visitNote;
	}
	
	/**
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
	
    /**
     * @return Phone
     */	
	public String getPhone() {
		return this.phone;
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
	 * @param visitAims
	 */
	public void setVisitAims(String visitAims) {
		this.visitAims = visitAims == null ? null : visitAims.trim();
	}
	
    /**
     * @return VisitAims
     */	
	public String getVisitAims() {
		return this.visitAims;
	}
	
	/**
	 * @param visitEffect
	 */
	public void setVisitEffect(String visitEffect) {
		this.visitEffect = visitEffect == null ? null : visitEffect.trim();
	}
	
    /**
     * @return VisitEffect
     */	
	public String getVisitEffect() {
		return this.visitEffect;
	}
	
	/**
	 * @param visitStartDate
	 */
	public void setVisitStartDate(String visitStartDate) {
		this.visitStartDate = visitStartDate == null ? null : visitStartDate.trim();
	}
	
    /**
     * @return VisitStartDate
     */	
	public String getVisitStartDate() {
		return this.visitStartDate;
	}
	
	/**
	 * @param visitEndDate
	 */
	public void setVisitEndDate(String visitEndDate) {
		this.visitEndDate = visitEndDate == null ? null : visitEndDate.trim();
	}
	
    /**
     * @return VisitEndDate
     */	
	public String getVisitEndDate() {
		return this.visitEndDate;
	}
	
	/**
	 * @param nextVisitDate
	 */
	public void setNextVisitDate(String nextVisitDate) {
		this.nextVisitDate = nextVisitDate == null ? null : nextVisitDate.trim();
	}
	
    /**
     * @return NextVisitDate
     */	
	public String getNextVisitDate() {
		return this.nextVisitDate;
	}
	
	/**
	 * @param nextVisitType
	 */
	public void setNextVisitType(String nextVisitType) {
		this.nextVisitType = nextVisitType == null ? null : nextVisitType.trim();
	}
	
    /**
     * @return NextVisitType
     */	
	public String getNextVisitType() {
		return this.nextVisitType;
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
        OcrmFwpScheduleVisit other = (OcrmFwpScheduleVisit) that;
		return (this.getVid() == null ? other.getVid() == null : this.getVid().equals(other.getVid()))
        	&& (this.getScheduleId() == null ? other.getScheduleId() == null : this.getScheduleId().equals(other.getScheduleId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getArangeId() == null ? other.getArangeId() == null : this.getArangeId().equals(other.getArangeId()))
        	&& (this.getArangeName() == null ? other.getArangeName() == null : this.getArangeName().equals(other.getArangeName()))
        	&& (this.getVisitStat() == null ? other.getVisitStat() == null : this.getVisitStat().equals(other.getVisitStat()))
        	&& (this.getVisitType() == null ? other.getVisitType() == null : this.getVisitType().equals(other.getVisitType()))
        	&& (this.getVisitorId() == null ? other.getVisitorId() == null : this.getVisitorId().equals(other.getVisitorId()))
        	&& (this.getVisitorName() == null ? other.getVisitorName() == null : this.getVisitorName().equals(other.getVisitorName()))
        	&& (this.getVisitNote() == null ? other.getVisitNote() == null : this.getVisitNote().equals(other.getVisitNote()))
        	&& (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
        	&& (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        	&& (this.getVisitAims() == null ? other.getVisitAims() == null : this.getVisitAims().equals(other.getVisitAims()))
        	&& (this.getVisitEffect() == null ? other.getVisitEffect() == null : this.getVisitEffect().equals(other.getVisitEffect()))
        	&& (this.getVisitStartDate() == null ? other.getVisitStartDate() == null : this.getVisitStartDate().equals(other.getVisitStartDate()))
        	&& (this.getVisitEndDate() == null ? other.getVisitEndDate() == null : this.getVisitEndDate().equals(other.getVisitEndDate()))
        	&& (this.getNextVisitDate() == null ? other.getNextVisitDate() == null : this.getNextVisitDate().equals(other.getNextVisitDate()))
        	&& (this.getNextVisitType() == null ? other.getNextVisitType() == null : this.getNextVisitType().equals(other.getNextVisitType()))
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
        result = prime * result + ((getVid() == null) ? 0 : getVid().hashCode());
        result = prime * result + ((getScheduleId() == null) ? 0 : getScheduleId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getArangeId() == null) ? 0 : getArangeId().hashCode());
        result = prime * result + ((getArangeName() == null) ? 0 : getArangeName().hashCode());
        result = prime * result + ((getVisitStat() == null) ? 0 : getVisitStat().hashCode());
        result = prime * result + ((getVisitType() == null) ? 0 : getVisitType().hashCode());
        result = prime * result + ((getVisitorId() == null) ? 0 : getVisitorId().hashCode());
        result = prime * result + ((getVisitorName() == null) ? 0 : getVisitorName().hashCode());
        result = prime * result + ((getVisitNote() == null) ? 0 : getVisitNote().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getVisitAims() == null) ? 0 : getVisitAims().hashCode());
        result = prime * result + ((getVisitEffect() == null) ? 0 : getVisitEffect().hashCode());
        result = prime * result + ((getVisitStartDate() == null) ? 0 : getVisitStartDate().hashCode());
        result = prime * result + ((getVisitEndDate() == null) ? 0 : getVisitEndDate().hashCode());
        result = prime * result + ((getNextVisitDate() == null) ? 0 : getNextVisitDate().hashCode());
        result = prime * result + ((getNextVisitType() == null) ? 0 : getNextVisitType().hashCode());
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
		sb.append(", vid=").append(vid);
		sb.append(", scheduleId=").append(scheduleId);
		sb.append(", custId=").append(custId);
		sb.append(", custType=").append(custType);
		sb.append(", custName=").append(custName);
		sb.append(", arangeId=").append(arangeId);
		sb.append(", arangeName=").append(arangeName);
		sb.append(", visitStat=").append(visitStat);
		sb.append(", visitType=").append(visitType);
		sb.append(", visitorId=").append(visitorId);
		sb.append(", visitorName=").append(visitorName);
		sb.append(", visitNote=").append(visitNote);
		sb.append(", phone=").append(phone);
		sb.append(", mgrId=").append(mgrId);
		sb.append(", mgrName=").append(mgrName);
		sb.append(", visitAims=").append(visitAims);
		sb.append(", visitEffect=").append(visitEffect);
		sb.append(", visitStartDate=").append(visitStartDate);
		sb.append(", visitEndDate=").append(visitEndDate);
		sb.append(", nextVisitDate=").append(nextVisitDate);
		sb.append(", nextVisitType=").append(nextVisitType);
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