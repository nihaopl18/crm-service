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
 * @类名称: OcrmFwpScheduleOther
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Bronze
 * @创建时间: 2019-02-16 11:47:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_SCHEDULE_OTHER")
public class OcrmFwpScheduleOther extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "O_ID")
	@Generated(GenerationType.UUID)
	private String oid;
	
	/** 日程编号 **/
	@Column(name = "SCHEDULE_ID", unique = false, nullable = true, length = 32)
	private String scheduleId;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 情况说明 **/
	@Column(name = "OTH_SIT_REMARK", unique = false, nullable = true, length = 2000)
	private String othSitRemark;
	
	/** 完成情况说明 **/
	@Column(name = "OTH_COMP_REMARK", unique = false, nullable = true, length = 2000)
	private String othCompRemark;
	
	/** 日程任务描述 **/
	@Column(name = "SCH_DESC", unique = false, nullable = true, length = 2000)
	private String schDesc;
	
	/** 完成状态 **/
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
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 2000)
	private String remark;
	
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
	 * @param oid
	 */
	public void setOid(String oid) {
		this.oid = oid == null ? null : oid.trim();
	}
	
    /**
     * @return Oid
     */	
	public String getOid() {
		return this.oid;
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
	 * @param othSitRemark
	 */
	public void setOthSitRemark(String othSitRemark) {
		this.othSitRemark = othSitRemark == null ? null : othSitRemark.trim();
	}
	
    /**
     * @return OthSitRemark
     */	
	public String getOthSitRemark() {
		return this.othSitRemark;
	}
	
	/**
	 * @param othCompRemark
	 */
	public void setOthCompRemark(String othCompRemark) {
		this.othCompRemark = othCompRemark == null ? null : othCompRemark.trim();
	}
	
    /**
     * @return OthCompRemark
     */	
	public String getOthCompRemark() {
		return this.othCompRemark;
	}
	
	/**
	 * @param schDesc
	 */
	public void setSchDesc(String schDesc) {
		this.schDesc = schDesc == null ? null : schDesc.trim();
	}
	
    /**
     * @return SchDesc
     */	
	public String getSchDesc() {
		return this.schDesc;
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
        OcrmFwpScheduleOther other = (OcrmFwpScheduleOther) that;
		return (this.getOid() == null ? other.getOid() == null : this.getOid().equals(other.getOid()))
        	&& (this.getScheduleId() == null ? other.getScheduleId() == null : this.getScheduleId().equals(other.getScheduleId()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getOthSitRemark() == null ? other.getOthSitRemark() == null : this.getOthSitRemark().equals(other.getOthSitRemark()))
        	&& (this.getOthCompRemark() == null ? other.getOthCompRemark() == null : this.getOthCompRemark().equals(other.getOthCompRemark()))
        	&& (this.getSchDesc() == null ? other.getSchDesc() == null : this.getSchDesc().equals(other.getSchDesc()))
        	&& (this.getStat() == null ? other.getStat() == null : this.getStat().equals(other.getStat()))
        	&& (this.getArangeId() == null ? other.getArangeId() == null : this.getArangeId().equals(other.getArangeId()))
        	&& (this.getArangeName() == null ? other.getArangeName() == null : this.getArangeName().equals(other.getArangeName()))
        	&& (this.getMgrId() == null ? other.getMgrId() == null : this.getMgrId().equals(other.getMgrId()))
        	&& (this.getMgrName() == null ? other.getMgrName() == null : this.getMgrName().equals(other.getMgrName()))
        	&& (this.getIsRemind() == null ? other.getIsRemind() == null : this.getIsRemind().equals(other.getIsRemind()))
        	&& (this.getRemindDate() == null ? other.getRemindDate() == null : this.getRemindDate().equals(other.getRemindDate()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getOid() == null) ? 0 : getOid().hashCode());
        result = prime * result + ((getScheduleId() == null) ? 0 : getScheduleId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getOthSitRemark() == null) ? 0 : getOthSitRemark().hashCode());
        result = prime * result + ((getOthCompRemark() == null) ? 0 : getOthCompRemark().hashCode());
        result = prime * result + ((getSchDesc() == null) ? 0 : getSchDesc().hashCode());
        result = prime * result + ((getStat() == null) ? 0 : getStat().hashCode());
        result = prime * result + ((getArangeId() == null) ? 0 : getArangeId().hashCode());
        result = prime * result + ((getArangeName() == null) ? 0 : getArangeName().hashCode());
        result = prime * result + ((getMgrId() == null) ? 0 : getMgrId().hashCode());
        result = prime * result + ((getMgrName() == null) ? 0 : getMgrName().hashCode());
        result = prime * result + ((getIsRemind() == null) ? 0 : getIsRemind().hashCode());
        result = prime * result + ((getRemindDate() == null) ? 0 : getRemindDate().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
		sb.append(", oid=").append(oid);
		sb.append(", scheduleId=").append(scheduleId);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", othSitRemark=").append(othSitRemark);
		sb.append(", othCompRemark=").append(othCompRemark);
		sb.append(", schDesc=").append(schDesc);
		sb.append(", stat=").append(stat);
		sb.append(", arangeId=").append(arangeId);
		sb.append(", arangeName=").append(arangeName);
		sb.append(", mgrId=").append(mgrId);
		sb.append(", mgrName=").append(mgrName);
		sb.append(", isRemind=").append(isRemind);
		sb.append(", remindDate=").append(remindDate);
		sb.append(", remark=").append(remark);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", isDelete=").append(isDelete);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
        sb.append("]");
        return sb.toString();
    }
}