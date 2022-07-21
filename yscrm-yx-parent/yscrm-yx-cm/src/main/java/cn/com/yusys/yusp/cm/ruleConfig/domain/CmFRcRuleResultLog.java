package cn.com.yusys.yusp.cm.ruleConfig.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * 事件引擎结果表
 * 
 */
@Entity
@Table(name="CM_F_RC_RULE_RESULT_LOG")
public class CmFRcRuleResultLog extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@Generated(GenerationType.UUID)
	private String id;

	@Column(name="IN_MESSAGE")
	private String inMessage;

	@Column(name="OUT_MESSAGE")
	private String outMessage;

	@Column(name="MESSAGE_DATE")
	private String messageDate;


    public CmFRcRuleResultLog() {
    }


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getInMessage() {
		return inMessage;
	}


	public void setInMessage(String inMessage) {
		this.inMessage = inMessage;
	}


	public String getOutMessage() {
		return outMessage;
	}


	public void setOutMessage(String outMessage) {
		this.outMessage = outMessage;
	}


	public String getMessageDate() {
		return messageDate;
	}


	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	
}