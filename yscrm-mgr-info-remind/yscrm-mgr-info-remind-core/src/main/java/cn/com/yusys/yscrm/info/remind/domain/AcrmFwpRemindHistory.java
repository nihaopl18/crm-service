/*
 * 代码生成器自动生成的
 * Since 2008 - 2019
 *
 */
package cn.com.yusys.yscrm.info.remind.domain;

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
 * @项目名称: demo模块
 * @类名称: AcrmFwpRemindHistory
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: ns
 * @创建时间: 2019-04-15 21:02:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_WP_REMIND_HISTORY")
public class AcrmFwpRemindHistory extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
	
	
	/** 规则类别编号 **/
	@Column(name = "TYPE_ID")
	private String typeId;
	
	/** 规则类别名称 **/
	@Column(name = "TYPE_NAME")
	private String typeName;
	
	/** 短信发送人名称 **/
	@Column(name = "MESSAGE_SEND_NAME")
	private String messageSendName;
	
	/** 短信接收人名称 **/
	@Column(name = "MESSAGE_RECE_NAME")
	private String messageReceName;
	
	/** 短信内容 **/
	@Column(name = "MESSAGE_INFO")
	private String messageInfo;
	
	/** 发送时间 **/
	@Column(name = "SEND_TIME")
	private String sendTime;
	
	/** 发送号码 **/
	@Column(name = "MESSAGE_RECE_NUM")
	private String messageReceNum;
	
	/** 短信发送人ID **/
	@Column(name = "MESSAGE_SEND_ID")
	private String messageSendId;
	
	/** 短信接收人ID **/
	@Column(name = "MESSAGE_RECE_ID")
	private String messageReceId;
	
	//短信文件名
	@Column(name="MESSAGE_NAME")
	private String messageName;
	
	public String getMessageName() {
		return messageName;
	}

	public void setMessageName(String messageName) {
		this.messageName = messageName;
	}

	/**
	 * @param typeId
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	
    /**
     * @return typeId
     */
	public String getTypeId() {
		return this.typeId;
	}
	
	/**
	 * @param typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
    /**
     * @return typeName
     */
	public String getTypeName() {
		return this.typeName;
	}
	
	/**
	 * @param messageSendName
	 */
	public void setMessageSendName(String messageSendName) {
		this.messageSendName = messageSendName;
	}
	
    /**
     * @return messageSendName
     */
	public String getMessageSendName() {
		return this.messageSendName;
	}
	
	/**
	 * @param messageReceName
	 */
	public void setMessageReceName(String messageReceName) {
		this.messageReceName = messageReceName;
	}
	
    /**
     * @return messageReceName
     */
	public String getMessageReceName() {
		return this.messageReceName;
	}
	
	/**
	 * @param messageInfo
	 */
	public void setMessageInfo(String messageInfo) {
		this.messageInfo = messageInfo;
	}
	
    /**
     * @return messageInfo
     */
	public String getMessageInfo() {
		return this.messageInfo;
	}
	
	/**
	 * @param sendTime
	 */
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}
	
    /**
     * @return sendTime
     */
	public String getSendTime() {
		return this.sendTime;
	}
	
	/**
	 * @param messageReceNum
	 */
	public void setMessageReceNum(String messageReceNum) {
		this.messageReceNum = messageReceNum;
	}
	
    /**
     * @return messageReceNum
     */
	public String getMessageReceNum() {
		return this.messageReceNum;
	}
	
	/**
	 * @param messageSendId
	 */
	public void setMessageSendId(String messageSendId) {
		this.messageSendId = messageSendId;
	}
	
    /**
     * @return messageSendId
     */
	public String getMessageSendId() {
		return this.messageSendId;
	}
	
	/**
	 * @param messageReceId
	 */
	public void setMessageReceId(String messageReceId) {
		this.messageReceId = messageReceId;
	}
	
    /**
     * @return messageReceId
     */
	public String getMessageReceId() {
		return this.messageReceId;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AcrmFwpRemindHistory other = (AcrmFwpRemindHistory) obj;
		if (messageInfo == null) {
			if (other.messageInfo != null)
				return false;
		} else if (!messageInfo.equals(other.messageInfo))
			return false;
		if (messageName == null) {
			if (other.messageName != null)
				return false;
		} else if (!messageName.equals(other.messageName))
			return false;
		if (messageReceId == null) {
			if (other.messageReceId != null)
				return false;
		} else if (!messageReceId.equals(other.messageReceId))
			return false;
		if (messageReceName == null) {
			if (other.messageReceName != null)
				return false;
		} else if (!messageReceName.equals(other.messageReceName))
			return false;
		if (messageReceNum == null) {
			if (other.messageReceNum != null)
				return false;
		} else if (!messageReceNum.equals(other.messageReceNum))
			return false;
		if (messageSendId == null) {
			if (other.messageSendId != null)
				return false;
		} else if (!messageSendId.equals(other.messageSendId))
			return false;
		if (messageSendName == null) {
			if (other.messageSendName != null)
				return false;
		} else if (!messageSendName.equals(other.messageSendName))
			return false;
		if (sendTime == null) {
			if (other.sendTime != null)
				return false;
		} else if (!sendTime.equals(other.sendTime))
			return false;
		if (typeId == null) {
			if (other.typeId != null)
				return false;
		} else if (!typeId.equals(other.typeId))
			return false;
		if (typeName == null) {
			if (other.typeName != null)
				return false;
		} else if (!typeName.equals(other.typeName))
			return false;
		return true;
	}
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((messageInfo == null) ? 0 : messageInfo.hashCode());
		result = prime * result + ((messageName == null) ? 0 : messageName.hashCode());
		result = prime * result + ((messageReceId == null) ? 0 : messageReceId.hashCode());
		result = prime * result + ((messageReceName == null) ? 0 : messageReceName.hashCode());
		result = prime * result + ((messageReceNum == null) ? 0 : messageReceNum.hashCode());
		result = prime * result + ((messageSendId == null) ? 0 : messageSendId.hashCode());
		result = prime * result + ((messageSendName == null) ? 0 : messageSendName.hashCode());
		result = prime * result + ((sendTime == null) ? 0 : sendTime.hashCode());
		result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
		result = prime * result + ((typeName == null) ? 0 : typeName.hashCode());
		return result;
	}
	
    @Override
	public String toString() {
		return "AcrmFwpRemindHistory [typeId=" + typeId + ", typeName=" + typeName + ", messageSendName="
				+ messageSendName + ", messageReceName=" + messageReceName + ", messageInfo=" + messageInfo
				+ ", sendTime=" + sendTime + ", messageReceNum=" + messageReceNum + ", messageSendId=" + messageSendId
				+ ", messageReceId=" + messageReceId + ", messageName=" + messageName + "]";
	}
}