package cn.com.yusys.yscrm.cust.org.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciEventInfo
 * @类描述: #数据实体类
 * @功能描述: 客户大事记
 * @创建人: 15104
 * @创建时间: 2019-02-17 00:53:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_EVENT_INFO")
public class OcrmFciEventInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 事件编号
 **/
	@Id
	@Column(name = "EVENT_ID")
	@Generated(GenerationType.UUID)
	private String eventId;
	
	/** 数据日期
 **/
	
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期
 **/
	
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号
 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人
 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最新更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最近更新人机构ID **/
	@Column(name = "LAST_CHG_ORG_ID", unique = false, nullable = true, length = 20)
	private String lastChgOrgId;
	
	/** 最新更新时间
 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户标识
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;
	
	/** 客户类型
 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 事件名称
 **/
	@Column(name = "EVENT_NAME", unique = false, nullable = true, length = 200)
	private String eventName;
	
	/** 事件类型
 **/
	@Column(name = "EVENT_TYPE", unique = false, nullable = true, length = 30)
	private String eventType;
	
	/** 事件内容
 **/
	@Column(name = "EVENT_DESC", unique = false, nullable = true, length = 800)
	private String eventDesc;
	
	/** 事件状态
 **/
	@Column(name = "EVENT_STAT", unique = false, nullable = true, length = 30)
	private String eventStat;
	
	/** 事件影响程度
 **/
	@Column(name = "EVENT_AFFECT_DEGREE", unique = false, nullable = true, length = 30)
	private String eventAffectDegree;
	
	/** 事件分类
 **/
	@Column(name = "EVENT_SORT", unique = false, nullable = true, length = 30)
	private String eventSort;
	
	/** 发生日期
 **/
	
	@Column(name = "EVENT_DATE", unique = false, nullable = true, length = 7)
	private Date eventDate;
	
	/** 是否提醒
 **/
	@Column(name = "WARN_FLG", unique = false, nullable = true, length = 30)
	private String warnFlg;
	
	/** 提醒规则类型
 **/
	@Column(name = "REMIND_RULE_TYPE", unique = false, nullable = true, length = 30)
	private String remindRuleType;
	
	/** 提醒对象
 **/
	@Column(name = "REMIND_OBJ", unique = false, nullable = true, length = 20)
	private String remindObj;
	
	/** 提醒人员(客户经理本人)
 **/
	@Column(name = "REMIND_MGR_ID", unique = false, nullable = true, length = 20)
	private String remindMgrId;
	
	/** 提醒时间
 **/
	@Column(name = "REMIND_TIME", unique = false, nullable = true, length = 7)
	private Date remindTime;
	
	/** 提醒内容
 **/
	@Column(name = "REMIND_INFO", unique = false, nullable = true, length = 200)
	private String remindInfo;
	
	/** 维护人员
 **/
	@Column(name = "MAINT_MAN", unique = false, nullable = true, length = 20)
	private String maintMan;
	
	/** 维护日期
 **/
	@Column(name = "MAINT_DATE", unique = false, nullable = true, length = 7)
	private Date maintDate;
	
	/** 事件来源
 **/
	@Column(name = "SRC_SYS_CD", unique = false, nullable = true, length = 30)
	private String srcSysCd;
	
	/**
	 * @return
	 */
	public String getLastChgOrgId() {
		return lastChgOrgId;
	}

	/**
	 * @param lastChgOrgId
	 */
	public void setLastChgOrgId(String lastChgOrgId) {
		this.lastChgOrgId = lastChgOrgId;
	}
	
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
	 * @param eventId
	 */
	public void setEventId(String eventId) {
		this.eventId = eventId == null ? null : eventId.trim();
	}
	
    /**
     * @return EventId
     */	
	public String getEventId() {
		return this.eventId;
	}
	
	/**
	 * @param eventName
	 */
	public void setEventName(String eventName) {
		this.eventName = eventName == null ? null : eventName.trim();
	}
	
    /**
     * @return EventName
     */	
	public String getEventName() {
		return this.eventName;
	}
	
	/**
	 * @param eventType
	 */
	public void setEventType(String eventType) {
		this.eventType = eventType == null ? null : eventType.trim();
	}
	
    /**
     * @return EventType
     */	
	public String getEventType() {
		return this.eventType;
	}
	
	/**
	 * @param eventDesc
	 */
	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc == null ? null : eventDesc.trim();
	}
	
    /**
     * @return EventDesc
     */	
	public String getEventDesc() {
		return this.eventDesc;
	}
	
	/**
	 * @param eventStat
	 */
	public void setEventStat(String eventStat) {
		this.eventStat = eventStat == null ? null : eventStat.trim();
	}
	
    /**
     * @return EventStat
     */	
	public String getEventStat() {
		return this.eventStat;
	}
	
	/**
	 * @param eventAffectDegree
	 */
	public void setEventAffectDegree(String eventAffectDegree) {
		this.eventAffectDegree = eventAffectDegree == null ? null : eventAffectDegree.trim();
	}
	
    /**
     * @return EventAffectDegree
     */	
	public String getEventAffectDegree() {
		return this.eventAffectDegree;
	}
	
	/**
	 * @param eventSort
	 */
	public void setEventSort(String eventSort) {
		this.eventSort = eventSort == null ? null : eventSort.trim();
	}
	
    /**
     * @return EventSort
     */	
	public String getEventSort() {
		return this.eventSort;
	}
	
	/**
	 * @param eventDate
	 */
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
    /**
     * @return EventDate
     */	
	public Date getEventDate() {
		return this.eventDate;
	}
	
	/**
	 * @param warnFlg
	 */
	public void setWarnFlg(String warnFlg) {
		this.warnFlg = warnFlg == null ? null : warnFlg.trim();
	}
	
    /**
     * @return WarnFlg
     */	
	public String getWarnFlg() {
		return this.warnFlg;
	}
	
	/**
	 * @param remindRuleType
	 */
	public void setRemindRuleType(String remindRuleType) {
		this.remindRuleType = remindRuleType == null ? null : remindRuleType.trim();
	}
	
    /**
     * @return RemindRuleType
     */	
	public String getRemindRuleType() {
		return this.remindRuleType;
	}
	
	/**
	 * @param remindObj
	 */
	public void setRemindObj(String remindObj) {
		this.remindObj = remindObj == null ? null : remindObj.trim();
	}
	
    /**
     * @return RemindObj
     */	
	public String getRemindObj() {
		return this.remindObj;
	}
	
	/**
	 * @param remindMgrId
	 */
	public void setRemindMgrId(String remindMgrId) {
		this.remindMgrId = remindMgrId == null ? null : remindMgrId.trim();
	}
	
    /**
     * @return RemindMgrId
     */	
	public String getRemindMgrId() {
		return this.remindMgrId;
	}
	
	/**
	 * @param remindTime
	 */
	public void setRemindTime(Date remindTime) {
		this.remindTime = remindTime;
	}
	
    /**
     * @return RemindTime
     */	
	public Date getRemindTime() {
		return this.remindTime;
	}
	
	/**
	 * @param remindInfo
	 */
	public void setremindInfo(String remindInfo) {
		this.remindInfo = remindInfo == null ? null : remindInfo.trim();
	}
	
    /**
     * @return remindInfo
     */	
	public String getremindInfo() {
		return this.remindInfo;
	}
	
	/**
	 * @param maintMan
	 */
	public void setMaintMan(String maintMan) {
		this.maintMan = maintMan == null ? null : maintMan.trim();
	}
	
    /**
     * @return MaintMan
     */	
	public String getMaintMan() {
		return this.maintMan;
	}
	
	/**
	 * @param maintDate
	 */
	public void setMaintDate(Date maintDate) {
		this.maintDate = maintDate;
	}
	
    /**
     * @return MaintDate
     */	
	public Date getMaintDate() {
		return this.maintDate;
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
        OcrmFciEventInfo other = (OcrmFciEventInfo) that;
                		return (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getEventId() == null ? other.getEventId() == null : this.getEventId().equals(other.getEventId()))
        	&& (this.getEventName() == null ? other.getEventName() == null : this.getEventName().equals(other.getEventName()))
        	&& (this.getEventType() == null ? other.getEventType() == null : this.getEventType().equals(other.getEventType()))
        	&& (this.getEventDesc() == null ? other.getEventDesc() == null : this.getEventDesc().equals(other.getEventDesc()))
        	&& (this.getEventStat() == null ? other.getEventStat() == null : this.getEventStat().equals(other.getEventStat()))
        	&& (this.getEventAffectDegree() == null ? other.getEventAffectDegree() == null : this.getEventAffectDegree().equals(other.getEventAffectDegree()))
        	&& (this.getEventSort() == null ? other.getEventSort() == null : this.getEventSort().equals(other.getEventSort()))
                	&& (this.getWarnFlg() == null ? other.getWarnFlg() == null : this.getWarnFlg().equals(other.getWarnFlg()))
        	&& (this.getRemindRuleType() == null ? other.getRemindRuleType() == null : this.getRemindRuleType().equals(other.getRemindRuleType()))
        	&& (this.getRemindObj() == null ? other.getRemindObj() == null : this.getRemindObj().equals(other.getRemindObj()))
        	&& (this.getRemindMgrId() == null ? other.getRemindMgrId() == null : this.getRemindMgrId().equals(other.getRemindMgrId()))
                	&& (this.getremindInfo() == null ? other.getremindInfo() == null : this.getremindInfo().equals(other.getremindInfo()))
        	&& (this.getMaintMan() == null ? other.getMaintMan() == null : this.getMaintMan().equals(other.getMaintMan()))
                	&& (this.getSrcSysCd() == null ? other.getSrcSysCd() == null : this.getSrcSysCd().equals(other.getSrcSysCd()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getEventId() == null) ? 0 : getEventId().hashCode());
        result = prime * result + ((getEventName() == null) ? 0 : getEventName().hashCode());
        result = prime * result + ((getEventType() == null) ? 0 : getEventType().hashCode());
        result = prime * result + ((getEventDesc() == null) ? 0 : getEventDesc().hashCode());
        result = prime * result + ((getEventStat() == null) ? 0 : getEventStat().hashCode());
        result = prime * result + ((getEventAffectDegree() == null) ? 0 : getEventAffectDegree().hashCode());
        result = prime * result + ((getEventSort() == null) ? 0 : getEventSort().hashCode());
        result = prime * result + ((getWarnFlg() == null) ? 0 : getWarnFlg().hashCode());
        result = prime * result + ((getRemindRuleType() == null) ? 0 : getRemindRuleType().hashCode());
        result = prime * result + ((getRemindObj() == null) ? 0 : getRemindObj().hashCode());
        result = prime * result + ((getRemindMgrId() == null) ? 0 : getRemindMgrId().hashCode());
        result = prime * result + ((getremindInfo() == null) ? 0 : getremindInfo().hashCode());
        result = prime * result + ((getMaintMan() == null) ? 0 : getMaintMan().hashCode());
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
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", custType=").append(custType);
		sb.append(", eventId=").append(eventId);
		sb.append(", eventName=").append(eventName);
		sb.append(", eventType=").append(eventType);
		sb.append(", eventDesc=").append(eventDesc);
		sb.append(", eventStat=").append(eventStat);
		sb.append(", eventAffectDegree=").append(eventAffectDegree);
		sb.append(", eventSort=").append(eventSort);
		sb.append(", eventDate=").append(eventDate);
		sb.append(", warnFlg=").append(warnFlg);
		sb.append(", remindRuleType=").append(remindRuleType);
		sb.append(", remindObj=").append(remindObj);
		sb.append(", remindMgrId=").append(remindMgrId);
		sb.append(", remindTime=").append(remindTime);
		sb.append(", remindInfo=").append(remindInfo);
		sb.append(", maintMan=").append(maintMan);
		sb.append(", maintDate=").append(maintDate);
		sb.append(", srcSysCd=").append(srcSysCd);
        sb.append("]");
        return sb.toString();
    }
}