package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFwpRemindInfo
 * @类描述: #数据实体类
 * @功能描述: 信息提醒
 * @创建人: 15104
 * @创建时间: 2019-02-14 17:31:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_REMIND_INFO")
public class OcrmFwpRemindInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 7)
	private Date dataDate;
	
	/** 最新更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 信息提醒编号 **/
	@Column(name = "INFO_ID", unique = false, nullable = true, length = 30)
	private String infoId;
	
	/** 规则编号 **/
	@Column(name = "RULE_ID", unique = false, nullable = true, length = 30)
	private String ruleId;
	
	/** 规则大类名称 **/
	@Column(name = "RULE_NAME", unique = false, nullable = true, length = 200)
	private String ruleName;
	
	/** 提醒规则名称 **/
	@Column(name = "REMIND_TYPE", unique = false, nullable = true, length = 200)
	private String remindType;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/** 客户类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 提醒接收人 **/
	@Column(name = "RECE_USER", unique = false, nullable = true, length = 500)
	private String receUser;
	
	/** 提醒生成日期 **/
	@Column(name = "REMIND_CRAT_DT", unique = false, nullable = true, length = 7)
	private Date remindCratDt;
	
	/** 提醒到期日期 **/
	@Column(name = "REMIND_EXPIRE_DATE", unique = false, nullable = true, length = 7)
	private Date remindExpireDate;
	
	/** 提醒剩余天数 **/
	@Column(name = "REMAIN_DAYS", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal remainDays;
	
	/** 提醒内容 **/
	@Column(name = "REMIND_INFO", unique = false, nullable = true, length = 800)
	private String remindInfo;
	
	/** 短信内容 **/
	@Column(name = "MESSAGE_INFO", unique = false, nullable = true, length = 500)
	private String messageInfo;
	
	/** 短信发送时间 **/
	@Column(name = "SEND_TIME", unique = false, nullable = true, length = 7)
	private Date sendTime;
	
	/** 接收号码 **/
	@Column(name = "RECE_NUM", unique = false, nullable = true, length = 20)
	private String receNum;
	
	/** 是否已发送短信 **/
	@Column(name = "HAVE_SEND", unique = false, nullable = true, length = 20)
	private String haveSend;
	
	/** 是否可发送短信 **/
	@Column(name = "IS_SEND", unique = false, nullable = true, length = 20)
	private String isSend;
	
	/** 是否待办已阅 **/
	@Column(name = "IS_READ", unique = false, nullable = true, length = 20)
	private String isRead;
	
	/** 客户价值等级 **/
	@Column(name = "CUST_VALUE_LEVEL", unique = false, nullable = true, length = 50)
	private String custValueLevel;
	
	/** 客户服务等级 **/
	@Column(name = "CUST_SERVICE_LEVEL", unique = false, nullable = true, length = 50)
	private String custServiceLevel;
	
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return DataDate
     */	
	public Date getDataDate() {
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
	 * @param infoId
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId == null ? null : infoId.trim();
	}
	
    /**
     * @return InfoId
     */	
	public String getInfoId() {
		return this.infoId;
	}
	
	/**
	 * @param ruleId
	 */
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId == null ? null : ruleId.trim();
	}
	
    /**
     * @return RuleId
     */	
	public String getRuleId() {
		return this.ruleId;
	}
	
	/**
	 * @param ruleName
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName == null ? null : ruleName.trim();
	}
	
    /**
     * @return RuleName
     */	
	public String getRuleName() {
		return this.ruleName;
	}
	
	/**
	 * @param remindType
	 */
	public void setRemindType(String remindType) {
		this.remindType = remindType == null ? null : remindType.trim();
	}
	
    /**
     * @return RemindType
     */	
	public String getRemindType() {
		return this.remindType;
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
	 * @param receUser
	 */
	public void setReceUser(String receUser) {
		this.receUser = receUser == null ? null : receUser.trim();
	}
	
    /**
     * @return ReceUser
     */	
	public String getReceUser() {
		return this.receUser;
	}
	
	/**
	 * @param remindCratDt
	 */
	public void setRemindCratDt(Date remindCratDt) {
		this.remindCratDt = remindCratDt;
	}
	
    /**
     * @return RemindCratDt
     */	
	public Date getRemindCratDt() {
		return this.remindCratDt;
	}
	
	/**
	 * @param remindExpireDate
	 */
	public void setRemindExpireDate(Date remindExpireDate) {
		this.remindExpireDate = remindExpireDate;
	}
	
    /**
     * @return RemindExpireDate
     */	
	public Date getRemindExpireDate() {
		return this.remindExpireDate;
	}
	
	/**
	 * @param remainDays
	 */
	public void setRemainDays(java.math.BigDecimal remainDays) {
		this.remainDays = remainDays;
	}
	
    /**
     * @return RemainDays
     */	
	public java.math.BigDecimal getRemainDays() {
		return this.remainDays;
	}
	
	/**
	 * @param remindInfo
	 */
	public void setRemindInfo(String remindInfo) {
		this.remindInfo = remindInfo == null ? null : remindInfo.trim();
	}
	
    /**
     * @return RemindInfo
     */	
	public String getRemindInfo() {
		return this.remindInfo;
	}
	
	/**
	 * @param messageInfo
	 */
	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo == null ? null : messageInfo.trim();
	}
	
    /**
     * @return MessageInfo
     */	
	public String getMessageInfo() {
		return this.messageInfo;
	}
	
	/**
	 * @param sendTime
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	
    /**
     * @return SendTime
     */	
	public Date getSendTime() {
		return this.sendTime;
	}
	
	/**
	 * @param receNum
	 */
	public void setReceNum(String receNum) {
		this.receNum = receNum == null ? null : receNum.trim();
	}
	
    /**
     * @return ReceNum
     */	
	public String getReceNum() {
		return this.receNum;
	}
	
	/**
	 * @param haveSend
	 */
	public void setHaveSend(String haveSend) {
		this.haveSend = haveSend == null ? null : haveSend.trim();
	}
	
    /**
     * @return HaveSend
     */	
	public String getHaveSend() {
		return this.haveSend;
	}
	
	/**
	 * @param isSend
	 */
	public void setIsSend(String isSend) {
		this.isSend = isSend == null ? null : isSend.trim();
	}
	
    /**
     * @return IsSend
     */	
	public String getIsSend() {
		return this.isSend;
	}
	
	/**
	 * @param isRead
	 */
	public void setIsRead(String isRead) {
		this.isRead = isRead == null ? null : isRead.trim();
	}
	
    /**
     * @return IsRead
     */	
	public String getIsRead() {
		return this.isRead;
	}
	
	/**
	 * @param custValueLevel
	 */
	public void setCustValueLevel(String custValueLevel) {
		this.custValueLevel = custValueLevel == null ? null : custValueLevel.trim();
	}
	
    /**
     * @return CustValueLevel
     */	
	public String getCustValueLevel() {
		return this.custValueLevel;
	}
	
	/**
	 * @param custServiceLevel
	 */
	public void setCustServiceLevel(String custServiceLevel) {
		this.custServiceLevel = custServiceLevel == null ? null : custServiceLevel.trim();
	}
	
    /**
     * @return CustServiceLevel
     */	
	public String getCustServiceLevel() {
		return this.custServiceLevel;
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
        OcrmFwpRemindInfo other = (OcrmFwpRemindInfo) that;
        		return (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getInfoId() == null ? other.getInfoId() == null : this.getInfoId().equals(other.getInfoId()))
        	&& (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
        	&& (this.getRuleName() == null ? other.getRuleName() == null : this.getRuleName().equals(other.getRuleName()))
        	&& (this.getRemindType() == null ? other.getRemindType() == null : this.getRemindType().equals(other.getRemindType()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getReceUser() == null ? other.getReceUser() == null : this.getReceUser().equals(other.getReceUser()))
                                	&& (this.getRemindInfo() == null ? other.getRemindInfo() == null : this.getRemindInfo().equals(other.getRemindInfo()))
        	&& (this.getMessageInfo() == null ? other.getMessageInfo() == null : this.getMessageInfo().equals(other.getMessageInfo()))
                	&& (this.getReceNum() == null ? other.getReceNum() == null : this.getReceNum().equals(other.getReceNum()))
        	&& (this.getHaveSend() == null ? other.getHaveSend() == null : this.getHaveSend().equals(other.getHaveSend()))
        	&& (this.getIsSend() == null ? other.getIsSend() == null : this.getIsSend().equals(other.getIsSend()))
        	&& (this.getIsRead() == null ? other.getIsRead() == null : this.getIsRead().equals(other.getIsRead()))
        	&& (this.getCustValueLevel() == null ? other.getCustValueLevel() == null : this.getCustValueLevel().equals(other.getCustValueLevel()))
        	&& (this.getCustServiceLevel() == null ? other.getCustServiceLevel() == null : this.getCustServiceLevel().equals(other.getCustServiceLevel()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getInfoId() == null) ? 0 : getInfoId().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        result = prime * result + ((getRemindType() == null) ? 0 : getRemindType().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getReceUser() == null) ? 0 : getReceUser().hashCode());
        result = prime * result + ((getRemindInfo() == null) ? 0 : getRemindInfo().hashCode());
        result = prime * result + ((getMessageInfo() == null) ? 0 : getMessageInfo().hashCode());
        result = prime * result + ((getReceNum() == null) ? 0 : getReceNum().hashCode());
        result = prime * result + ((getHaveSend() == null) ? 0 : getHaveSend().hashCode());
        result = prime * result + ((getIsSend() == null) ? 0 : getIsSend().hashCode());
        result = prime * result + ((getIsRead() == null) ? 0 : getIsRead().hashCode());
        result = prime * result + ((getCustValueLevel() == null) ? 0 : getCustValueLevel().hashCode());
        result = prime * result + ((getCustServiceLevel() == null) ? 0 : getCustServiceLevel().hashCode());
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
		sb.append(", infoId=").append(infoId);
		sb.append(", ruleId=").append(ruleId);
		sb.append(", ruleName=").append(ruleName);
		sb.append(", remindType=").append(remindType);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", custType=").append(custType);
		sb.append(", receUser=").append(receUser);
		sb.append(", remindCratDt=").append(remindCratDt);
		sb.append(", remindExpireDate=").append(remindExpireDate);
		sb.append(", remainDays=").append(remainDays);
		sb.append(", remindInfo=").append(remindInfo);
		sb.append(", messageInfo=").append(messageInfo);
		sb.append(", sendTime=").append(sendTime);
		sb.append(", receNum=").append(receNum);
		sb.append(", haveSend=").append(haveSend);
		sb.append(", isSend=").append(isSend);
		sb.append(", isRead=").append(isRead);
		sb.append(", custValueLevel=").append(custValueLevel);
		sb.append(", custServiceLevel=").append(custServiceLevel);
        sb.append("]");
        return sb.toString();
    }
}