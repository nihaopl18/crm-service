package cn.com.yusys.yscrm.info.remind.domain;

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
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: AcrmFwpRemindInfo
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-22 11:14:59
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_WP_REMIND_INFO")
public class AcrmFwpRemindInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 信息提醒编号 **/
	@Id
	@Column(name = "INFO_ID")
	@Generated(GenerationType.UUID)
	private String infoId;

	/** 关联业务编号 **/
	@Column(name = "BUSI_ID", unique = false, nullable = true, length = 50)
	private String busiId;

	/** 提醒大类代码 **/
	@Column(name = "REMIND_CLASS", unique = false, nullable = true, length = 30)
	private String remindClass;

	/** 提醒小类代码 **/
	@Column(name = "REMIND_TYPE", unique = false, nullable = true, length = 30)
	private String remindType;

	/** 信息接受人ID **/
	@Column(name = "RECE_USER_ID", unique = false, nullable = true, length = 50)
	private String receUserId;

	/** 信息接受人名称 **/
	@Column(name = "RECE_USER_NAME", unique = false, nullable = true, length = 50)
	private String receUserName;

	/** 信息内容 **/
	@Column(name = "INFO_TEXT", unique = false, nullable = true, length = 200)
	private String infoText;

	/** 信息状态 **/
	@Column(name = "INFO_STATE", unique = false, nullable = true, length = 10)
	private String infoState;

	/** 提醒生成日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;

	/** 提醒发布日期 **/

	@Column(name = "ISSUE_DATE", unique = false, nullable = true, length = 7)
	private Date issueDate;

	/** 最后更新时间 **/
	@Column(name = "LAST_CHG_DATE", unique = false, nullable = true, length = 7)
	private Date lastChgDate;

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId == null ? null :infoId.trim();
	}

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId == null ? null :busiId.trim();
	}

	public String getRemindClass() {
		return remindClass;
	}

	public void setRemindClass(String remindClass) {
		this.remindClass = remindClass == null ? null :remindClass.trim();
	}

	public String getRemindType() {
		return remindType;
	}

	public void setRemindType(String remindType) {
		this.remindType = remindType == null ? null :remindType.trim();
	}

	public String getReceUserId() {
		return receUserId;
	}

	public void setReceUserId(String receUserId) {
		this.receUserId = receUserId == null ? null :receUserId.trim();
	}

	public String getReceUserName() {
		return receUserName;
	}

	public void setReceUserName(String receUserName) {
		this.receUserName = receUserName == null ? null :receUserName.trim();
	}

	public String getInfoText() {
		return infoText;
	}

	public void setInfoText(String infoText) {
		this.infoText = infoText == null ? null :infoText.trim();
	}

	public String getInfoState() {
		return infoState;
	}

	public void setInfoState(String infoState) {
		this.infoState = infoState == null ? null :infoState.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getLastChgDate() {
		return lastChgDate;
	}

	public void setLastChgDate(Date lastChgDate) {
		this.lastChgDate = lastChgDate;
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
		AcrmFwpRemindInfo other = (AcrmFwpRemindInfo) that;
		return (this.getInfoId() == null ? other.getInfoId() == null : this.getInfoId().equals(other.getInfoId()))
				&& (this.getInfoState() == null ?other.getInfoState() == null : this.getInfoState().equals(other.getInfoState()))
				&& (this.getInfoText() == null ?other.getInfoText() == null : this.getInfoText().equals(other.getInfoText()))
				&& (this.getBusiId() == null ?other.getBusiId() == null : this.getBusiId().equals(other.getBusiId()))
				&& (this.getReceUserId() == null ?other.getReceUserId() == null : this.getReceUserId().equals(other.getReceUserId()))
				&& (this.getReceUserName() == null ?other.getReceUserName() == null : this.getReceUserName().equals(other.getReceUserName()))
				&& (this.getRemindClass() == null ?other.getRemindClass() == null : this.getRemindClass().equals(other.getRemindClass()))
				&& (this.getRemindType() == null ?other.getRemindType() == null : this.getRemindType().equals(other.getRemindType()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getInfoId() == null) ? 0 : getInfoId().hashCode());

		result = prime * result + ((getInfoState() == null) ? 0 : getInfoState().hashCode());
		result = prime * result + ((getInfoText() == null) ? 0 : getInfoText().hashCode());
		result = prime * result + ((getBusiId() == null) ? 0 : getReceUserId().hashCode());
		result = prime * result + ((getReceUserId() == null) ? 0 : getReceUserId().hashCode());
		result = prime * result + ((getReceUserName() == null) ? 0 : getReceUserName().hashCode());
		result = prime * result + ((getRemindClass() == null) ? 0 : getRemindClass().hashCode());
		result = prime * result + ((getRemindType() == null) ? 0 : getRemindType().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("Hash = ").append(hashCode());
		sb.append(", infoId=").append(infoId);
		sb.append(", infoId=").append(infoState);
		sb.append(", infoId=").append(infoText);
		sb.append(", infoId=").append(busiId);
		sb.append(", infoId=").append(receUserId);
		sb.append(", infoId=").append(receUserId);
		sb.append(", infoId=").append(remindClass);
		sb.append(", infoId=").append(remindType);
		sb.append("]");
		return sb.toString();
	}
}