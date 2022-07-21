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
 * The persistent class for the CM_F_RC_RULE_ACTION database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_RULE_ACTION")
public class CmFRcRuleAction extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ACTION_TYPE")
	private String actionType;

	@Column(name="CLASS_NAME")
	private String className;

	@Column(name="EVENT_ID")
	private String eventId;
	
	
	@Id
	@Generated(GenerationType.UUID)
	private String id;

    public CmFRcRuleAction() {
    }


	public String getActionType() {
		return this.actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getEventId() {
		return this.eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

}