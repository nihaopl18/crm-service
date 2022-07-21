package cn.com.yusys.yusp.cm.sysKeyWord.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CM_F_RC_CHANNEL_MGR")
public class CmFRcChannelMgr extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Generated(GenerationType.UUID)
	@Column(name="CHANNEL_ID")
	private String channelId;
	
	@Column(name="CHANNEL_NAME")
	private String channelName;
	
	@Column(name="CONNECT_TYPE")
	private String connectType;
	
	public String getConnectType() { return connectType; }
	public void setConnectType(String connectType) { this.connectType=connectType; }
	
	@Column(name="FILE_SERVER_PATH")
	private String fileServerPath;
	
	public String getFileServerPath() { return fileServerPath; }
	public void setFileServerPath(String fileServerPath) { this.fileServerPath=fileServerPath; }
	
	@Column(name="FILE_SERVER_NAME")
	private String fileServerName;
	
	public String getFileServerName() { return fileServerName; }
	public void setFileServerName(String fileServerName) { this.fileServerName=fileServerName; }
	
	@Column(name="FILE_SERVER_LOGIN")
	private String fileServerLogin;
	
	public String getFileServerLogin() { return fileServerLogin; }
	public void setFileServerLogin(String fileServerLogin) { this.fileServerLogin=fileServerLogin; }
	
	@Column(name="FILE_SERVER_PSWD")
	private String fileServerPswd;
	
	public String getFileServerPswd() { return fileServerPswd; }
	public void setFileServerPswd(String fileServerPswd) { this.fileServerPswd=fileServerPswd; }
	
	@Column(name="MESSAGE_TYPE")
	private String messageType;
	
	public String getMessageType() { return messageType; }
	public void setMessageType(String messageType) { this.messageType=messageType; }
	
	@Column(name="DEAL_PATH")
	private String dealPath;
	
	public String getDealPath() { return dealPath; }
	public void setDealPath(String dealPath) { this.dealPath=dealPath; }
	
	@Column(name="DEAL_MESSGAE")
	private String dealMessgae;
	
	public String getDealMessgae() { return dealMessgae; }
	public void setDealMessgae(String dealMessgae) { this.dealMessgae=dealMessgae; }
	
	@Column(name="RUN_CONNECT_TYPE")
	private String runConnectType;
	
	public String getRunConnectType() { return runConnectType; }
	public void setRunConnectType(String runConnectType) { this.runConnectType=runConnectType; }
	
	@Column(name="CREAT_USER")
	private String creatUser;

	@Column(name="CREAT_DATE")
	private Date creatDate;

	@Column(name="UPDATA_USER")
	private String updataUser;

	@Column(name="UPDATA_DATE")
	private Date updataDate;
	
	@Column(name="CREAT_USER_NAME")
	private String creatUserName;
	
	@Column(name="UPDATA_USER_NAME")
	private String updataUserName;

	
	public String getChannelId() { return channelId; }
	public void setChannelId(String channelId) { this.channelId=channelId; }
	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	
	public String getCreatUser() {
		return creatUser;
	}

	public void setCreatUser(String creatUser) {
		this.creatUser = creatUser;
	}
	
	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	
	public String getUpdataUser() {
		return updataUser;
	}

	public void setUpdataUser(String updataUser) {
		this.updataUser = updataUser;
	}
	
	public Date getUpdataDate() {
		return updataDate;
	}

	public void setUpdataDate(Date updataDate) {
		this.updataDate = updataDate;
	}
	
	public String getCreatUserName() {
		return creatUserName;
	}

	public void setCreatUserName(String creatUserName) {
		this.creatUserName = creatUserName;
	}
	
	public String getUpdataUserName() {
		return updataUserName;
	}

	public void setUpdataUserName(String updataUserName) {
		this.updataUserName = updataUserName;
	}
	
	@Column(name = "IS_SET")
	private String isSet;
	
	public String getIsSet() { return this.isSet; }
	public void setIsSet(String isSet) { this.isSet = isSet; }
	
	
	@Column(name = "CHANNEL_ITEM_ID")
	private String channelItemId;

	public String getChannelItemId() {
		return channelItemId;
	}
	public void setChannelItemId(String channelItemId) {
		this.channelItemId = channelItemId;
	}
	
	
}
