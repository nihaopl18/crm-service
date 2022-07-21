package cn.com.yusys.yscrm.info.workreport.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @项目名称: dycrm-todowork模块
 * @类名称: OcrmFwpTodoWork
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2019-01-29 17:00:11
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_TODO_WORK")
public class OcrmFwpTodoWork extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 事项编号 **/
	@Id
	@Column(name = "TODO_WORK_ID")
	@Generated(GenerationType.UUID)
	private String todoWorkId;

	/** 事项主题 **/
	@Column(name = "TODO_WORK_TITLE", unique = false, nullable = true, length = 40)
	private String todoWorkTitle;
	// TODO_WORK_TITLE
	/** 事项类型 **/
	@Column(name = "TODO_WORK_TYPE", unique = false, nullable = true, length = 30)
	private String todoWorkType;

	/** 事项内容 **/
	@Column(name = "TODO_WORK_CONTENT", unique = false, nullable = true, length = 800)
	private String todoWorkContent;

	/** 添加人ID **/
	@Column(name = "CREATOR_ID", unique = false, nullable = true, length = 30)
	private String creatorId;

	/** 添加人名称 **/
	@Column(name = "CREATOR_NAME", unique = false, nullable = true, length = 30)
	private String creatorName;

	/** 添加人所属机构ID **/
	@Column(name = "CREATOR_ORG_ID", unique = false, nullable = true, length = 30)
	private String creatorOrgId;

	/** 添加人所属机构名称 **/
	@Column(name = "CREATOR_ORG_NAME", unique = false, nullable = true, length = 30)
	private String creatorOrgName;

	/** 添加时间 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 15)
	private Date createDate;

	/** 事项状态 **/
	@Column(name = "TODO_WORK_STATE", unique = false, nullable = true, length = 30)
	private String todoWorkState;

	/** 开始时间/执行时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	@Column(name = "START_DATE", unique = false, nullable = true, length = 15)
	private Date startDate;

	/** 事项执行人 **/
	@Column(name = "FINISHER", unique = false, nullable = true, length = 800)
	private String finisher;

	/** 是否删除 **/
	@Column(name = "IS_DELETE", unique = false, nullable = true, length = 30)
	private String isDelete;

	/** 是否周期性待办事项 **/
	@Column(name = "IS_NOTICE", unique = false, nullable = true, length = 30)
	private String isNotice;

	/** 结束时间 **/
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
	@Column(name = "END_DATE", unique = false, nullable = true, length = 15)
	private Date endDate;

	/** 最近更新人ID **/
	@Column(name = "LAST_CHG_USR_ID", unique = false, nullable = true, length = 30)
	private String lastChgUsrId;

	/** 最近更新人名称 **/
	@Column(name = "LAST_CHG_USR_NAME", unique = false, nullable = true, length = 30)
	private String lastChgUsrName;

	/** 最近更新人所属机构ID **/
	@Column(name = "LAST_CHG_USR_ORG_ID", unique = false, nullable = true, length = 30)
	private String lastChgUsrOrgId;

	/** 最近更新人所属机构名称 **/
	@Column(name = "LAST_CHG_USR_ORG_NAME", unique = false, nullable = true, length = 30)
	private String lastChgUsrOrgName;

	/** 最近更新时间 **/
	@Column(name = "LAST_CHG_DATE", unique = false, nullable = true, length = 15)
	private Date lastChgDate;

	/** 关联客户 **/
	@Column(name = "RELATION_CUST", unique = false, nullable = true, length = 30)
	private String relationCust;
	
	/** 执行周期**/
	@Column(name = "NOTICE_CYCLE", unique = false, nullable = true, length = 4)
	private String noticeCycle;

	public String getTodoWorkId() {
		return this.todoWorkId;
	}

	public void setTodoWorkId(String todoWorkId) {
		this.todoWorkId = todoWorkId == null ? null : todoWorkId.trim();
	}

	public String getTodoWorkTitle() {
		return this.todoWorkTitle;
	}

	public void setTodoWorkTitle(String todoWorkTitle) {
		this.todoWorkTitle = todoWorkTitle == null ? null : todoWorkTitle.trim();
	}

	public String getTodoWorkType() {
		return this.todoWorkType;
	}

	public void setTodoWorkType(String todoWorkType) {
		this.todoWorkType = todoWorkType == null ? null : todoWorkType.trim();
	}

	public String getTodoWorkContent() {
		return this.todoWorkContent;
	}

	public void setTodoWorkContent(String todoWorkContent) {
		this.todoWorkContent = todoWorkContent == null ? null : todoWorkContent.trim();
	}

	public String getCreatorId() {
		return this.creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId == null ? null : creatorId.trim();
	}

	public String getCreatorName() {
		return this.creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName == null ? null : creatorName.trim();
	}

	public String getCreatorOrgId() {
		return this.creatorOrgId;
	}

	public void setCreatorOrgId(String creatorOrgId) {
		this.creatorOrgId = creatorOrgId == null ? null : creatorOrgId.trim();
	}

	public String getCreatorOrgName() {
		return this.creatorOrgName;
	}

	public void setCreatorOrgName(String creatorOrgName) {
		this.creatorOrgName = creatorOrgName == null ? null : creatorOrgName.trim();
	}

	public String getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete == null ? null : isDelete.trim();
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getTodoWorkState() {
		return this.todoWorkState;
	}

	public void setTodoWorkState(String todoWorkState) {
		this.todoWorkState = todoWorkState == null ? null : todoWorkState.trim();
	}

	

	public String getIsNotice() {
		return this.isNotice;
	}

	public void setIsNotice(String isNotice) {
		this.isNotice = isNotice == null ? null : isNotice.trim();
	}

	public String getLastChgUsrId() {
		return this.lastChgUsrId;
	}

	public void setLastChgUsrId(String lastChgUsrId) {
		this.lastChgUsrId = lastChgUsrId == null ? null : lastChgUsrId.trim();
	}

	public String getLastChgUsrName() {
		return this.lastChgUsrName;
	}

	public void setLastChgUsrName(String lastChgUsrName) {
		this.lastChgUsrName = lastChgUsrName == null ? null : lastChgUsrName.trim();
	}

	public String getLastChgUsrOrgId() {
		return this.lastChgUsrOrgId;
	}

	public void setLastChgUsrOrgId(String lastChgUsrOrgId) {
		this.lastChgUsrOrgId = lastChgUsrOrgId == null ? null : lastChgUsrOrgId.trim();
	}

	public String getLastChgUsrOrgName() {
		return this.lastChgUsrOrgName;
	}

	public void setLastChgUsrOrgName(String lastChgUsrOrgName) {
		this.lastChgUsrOrgName = lastChgUsrOrgName == null ? null : lastChgUsrOrgName.trim();
	}

	public Date getLastChgDate() {
		return this.lastChgDate;
	}

	public void setLastChgDate(Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * @return startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            要设置的 startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            要设置的 endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return finisher
	 */
	public String getFinisher() {
		return finisher;
	}

	/**
	 * @param finisher 要设置的 finisher
	 */
	public void setFinisher(String finisher) {
		this.finisher = finisher == null ? null : finisher.trim();
	}

	/**
	 * @return relationCust
	 */
	public String getRelationCust() {
		return relationCust;
	}

	/**
	 * @param relationCust 要设置的 relationCust
	 */
	public void setRelationCust(String relationCust) {
		this.relationCust = relationCust == null ? null : relationCust.trim();
	}

	
	/**
	 * @return noticeCycle
	 */
	public String getNoticeCycle() {
		return noticeCycle;
	}

	/**
	 * @param noticeCycle 要设置的 noticeCycle
	 */
	public void setNoticeCycle(String noticeCycle) {
		this.noticeCycle = noticeCycle == null ? null : noticeCycle.trim();
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
		OcrmFwpTodoWork other = (OcrmFwpTodoWork) that;
		return (this.getTodoWorkType() == null ? other.getTodoWorkType() == null
				: this.getTodoWorkType().equals(other.getTodoWorkType()))
				&& (this.getTodoWorkTitle() == null ? other.getTodoWorkTitle() == null
						: this.getTodoWorkTitle().equals(other.getTodoWorkTitle()))
				&& (this.getTodoWorkState() == null ? other.getTodoWorkState() == null
						: this.getTodoWorkState().equals(other.getTodoWorkState()))
				&& (this.getTodoWorkId() == null ? other.getTodoWorkId() == null
						: this.getTodoWorkId().equals(other.getTodoWorkId()))
				&& (this.getTodoWorkContent() == null ? other.getTodoWorkContent() == null
						: this.getTodoWorkContent().equals(other.getTodoWorkContent()))
				&& (this.getIsDelete() == null ? other.getIsDelete() == null
						: this.getIsDelete().equals(other.getIsDelete()))
				&& (this.getIsNotice() == null ? other.getIsNotice() == null
						: this.getIsNotice().equals(other.getIsNotice()))
				&& (this.getLastChgUsrOrgName() == null ? other.getLastChgUsrOrgName() == null
						: this.getLastChgUsrOrgName().equals(other.getLastChgUsrOrgName()))
				&& (this.getLastChgUsrOrgId() == null ? other.getLastChgUsrOrgId() == null
						: this.getLastChgUsrOrgId().equals(other.getLastChgUsrOrgId()))
				&& (this.getLastChgUsrName() == null ? other.getLastChgUsrName() == null
						: this.getLastChgUsrName().equals(other.getLastChgUsrName()))
				&& (this.getLastChgUsrId() == null ? other.getLastChgUsrId() == null
						: this.getLastChgUsrId().equals(other.getLastChgUsrId()))
				&& (this.getCreatorOrgName() == null ? other.getCreatorOrgName() == null
						: this.getCreatorOrgName().equals(other.getCreatorOrgName()))
				&& (this.getCreatorOrgId() == null ? other.getCreatorOrgId() == null
						: this.getCreatorOrgId().equals(other.getCreatorOrgId()))
				&& (this.getCreatorName() == null ? other.getCreatorName() == null
						: this.getCreatorName().equals(other.getCreatorName()))
				&& (this.getCreatorId() == null ? other.getCreatorId() == null
						: this.getCreatorId().equals(other.getCreatorId()))
				&& (this.getFinisher() == null ? other.getFinisher() == null
				: this.getFinisher().equals(other.getFinisher()))
				&& (this.getRelationCust() == null ? other.getRelationCust() == null
				: this.getRelationCust().equals(other.getRelationCust()))
				&& (this.getNoticeCycle() == null ? other.getNoticeCycle() == null
				: this.getNoticeCycle().equals(other.getNoticeCycle()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
		result = prime * result + ((getCreatorName() == null) ? 0 : getCreatorName().hashCode());
		result = prime * result + ((getCreatorOrgId() == null) ? 0 : getCreatorOrgId().hashCode());
		result = prime * result + ((getCreatorOrgName() == null) ? 0 : getCreatorOrgName().hashCode());
		result = prime * result + ((getIsNotice() == null) ? 0 : getIsNotice().hashCode());
		result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
		result = prime * result + ((getLastChgUsrId() == null) ? 0 : getLastChgUsrId().hashCode());
		result = prime * result + ((getLastChgUsrName() == null) ? 0 : getLastChgUsrName().hashCode());
		result = prime * result + ((getLastChgUsrOrgId() == null) ? 0 : getLastChgUsrOrgId().hashCode());
		result = prime * result + ((getLastChgUsrOrgName() == null) ? 0 : getLastChgUsrOrgName().hashCode());
		result = prime * result + ((getTodoWorkContent() == null) ? 0 : getTodoWorkContent().hashCode());
		result = prime * result + ((getTodoWorkId() == null) ? 0 : getTodoWorkId().hashCode());
		result = prime * result + ((getTodoWorkState() == null) ? 0 : getTodoWorkState().hashCode());
		result = prime * result + ((getTodoWorkTitle() == null) ? 0 : getTodoWorkTitle().hashCode());
		result = prime * result + ((getTodoWorkType() == null) ? 0 : getTodoWorkType().hashCode());
		result = prime * result + ((getTodoWorkState() == null) ? 0 : getTodoWorkState().hashCode());
		result = prime * result + ((getRelationCust() == null) ? 0 : getRelationCust().hashCode());
		result = prime * result + ((getFinisher() == null) ? 0 : getFinisher().hashCode());
		result = prime * result + ((getNoticeCycle() == null) ? 0 : getNoticeCycle().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("Hash = ").append(hashCode());
		sb.append(", todoWorkId=").append(todoWorkId);
		sb.append(", todoWorkTitle=").append(todoWorkTitle);
		sb.append(", todoWorkType=").append(todoWorkType);
		sb.append(", todoWorkContent=").append(todoWorkContent);
		sb.append(", creatorId=").append(creatorId);
		sb.append(", creatorName=").append(creatorName);
		sb.append(", creatorOrgId=").append(creatorOrgId);
		sb.append(", creatorOrgName=").append(creatorOrgName);
		sb.append(", todoWorkState=").append(todoWorkState);
		sb.append(", isDelete=").append(isDelete);
		sb.append(", isNotice=").append(isNotice);
		sb.append(", lastChgUsrId=").append(lastChgUsrId);
		sb.append(", lastChgUsrName=").append(lastChgUsrName);
		sb.append(", lastChgUsrOrgId=").append(lastChgUsrOrgId);
		sb.append(", lastChgUsrOrgName=").append(lastChgUsrOrgName);
		sb.append(", relationCust=").append(relationCust);
		sb.append(", finisher=").append(finisher);
		sb.append(", noticeCycle=").append(noticeCycle);
		sb.append("]");
		return sb.toString();
	}
}