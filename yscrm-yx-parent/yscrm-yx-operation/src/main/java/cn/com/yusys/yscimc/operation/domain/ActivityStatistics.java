package cn.com.yusys.yscimc.operation.domain;



import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Table(name = "ACTIVITY_STATISTICS")
public class ActivityStatistics {

	/**
	 * 编号
	 */
	@ApiModelProperty(value = "编号")
	@Id
	private String id;

	/**
	 * 活动组件ID
	 */
	@ApiModelProperty(value = "活动组件ID")
	private String nodeId;

	/**
	 * 邀请人
	 */
	@ApiModelProperty(value = "邀请人")
	private String invitee;

	/**
	 * 受邀人
	 */
	@ApiModelProperty(value = "受邀人")
	private String receiver;

	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	private String phoneNum;

	/**
	 * 来源渠道
	 */
	@ApiModelProperty(value = "来源渠道")
	private String sourceChannel;

	/**
	 * 创建日期
	 */
	@ApiModelProperty(value = "创建日期")
	private Date createDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getInvitee() {
		return invitee;
	}

	public void setInvitee(String invitee) {
		this.invitee = invitee;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getSourceChannel() {
		return sourceChannel;
	}

	public void setSourceChannel(String sourceChannel) {
		this.sourceChannel = sourceChannel;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
