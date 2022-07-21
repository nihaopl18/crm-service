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
 * The persistent class for the CM_F_RC_PRO_ACTION database table.
 * 
 */
@Entity
@Table(name="CM_F_RC_PRO_ACTION")
public class CmFRcProAction extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ACTION_ID")
	private String actionId;

	private String channel;
	
	@Id
	@Generated(GenerationType.UUID)
	private String id;

	@Column(name="PRO_ID")
	private String proId;

	@Column(name="TEMP_CONTENT")
	private String tempContent;

	@Column(name="TEMP_TYPE")
	private String tempType;

	@Column(name="ACTION_CLASSIFY")
	private String actionClassify;
	
    public CmFRcProAction() {
    }

	public String getActionClassify() {
		return actionClassify;
	}

	public void setActionClassify(String actionClassify) {
		this.actionClassify = actionClassify;
	}

	public String getActionId() {
		return this.actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProId() {
		return this.proId;
	}

	public void setProId(String proId) {
		this.proId = proId;
	}

	public String getTempContent() {
		return this.tempContent;
	}

	public void setTempContent(String tempContent) {
		this.tempContent = tempContent;
	}

	public String getTempType() {
		return this.tempType;
	}

	public void setTempType(String tempType) {
		this.tempType = tempType;
	}

}