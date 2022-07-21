package cn.com.yusys.yscrm.info.workreport.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0.0
 * @项目名称: yscrm-mgr-info-workreport-core模块
 * @类名称: OcrmFwpWorkReport
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: Bronze
 * @创建时间: 2019-01-29 17:00:11
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_WORK_REPORT")
public class OcrmFwpWorkReport extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 报告编号
	 **/
	@Id
	@Column(name = "WORK_REPORT_ID")
	@Generated(GenerationType.UUID)
	private String workReportId;

	/**
	 * 报告业务类型
	 **/
	@Column(name = "WORK_REPORT_BUSI_TYPE", unique = false, nullable = true, length = 30)
	private String workReportBusiType;

	/**
	 * 报告周期开始日期
	 **/
	@Column(name = "START_DATE", unique = false, nullable = true, length = 7)
	private Date startDate;

	/**
	 * 工作内容（选择）
	 **/
	@Column(name = "WORK_SUMMARY", unique = false, nullable = true, length = 800)
	private String workSummary;

	/**
	 * 报告内容（输入）
	 **/
	@Column(name = "WORK_CONTENT", unique = false, nullable = true, length = 1500)
	private String workContent;

	/**
	 * 总结及后续工作计划
	 **/
	@Column(name = "LATER_PLAN", unique = false, nullable = true, length = 1500)
	private String laterPlan;

	/**
	 * 是否删除
	 **/
	@Column(name = "IS_DELETE", unique = false, nullable = true, length = 2)
	private String isDelete;

	/**
	 * 是否草稿
	 **/
	@Column(name = "IS_DRAFT", unique = false, nullable = true, length = 2)
	private String isDraft;

	/**
	 * 添加人ID
	 **/
	@Column(name = "CREATOR_ID", unique = false, nullable = true, length = 30)
	private String creatorId;

	/**
	 * 添加人名称
	 **/
	@Column(name = "CREATOR_NAME", unique = false, nullable = true, length = 30)
	private String creatorName;

	/**
	 * 添加人所属机构ID
	 **/
	@Column(name = "CREATOR_ORG", unique = false, nullable = true, length = 30)
	private String creatorOrg;

	/**
	 * 添加人所属机构名称
	 **/
	@Column(name = "CREATOR_ORG_NAME", unique = false, nullable = true, length = 30)
	private String creatorOrgName;

	/**
	 * 添加时间
	 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;

	/**
	 * 最近更新人ID
	 **/
	@Column(name = "LAST_CHG_USR_ID", unique = false, nullable = true, length = 30)
	private String lastChgUsrId;

	/**
	 * 最近更新人名称
	 **/
	@Column(name = "LAST_CHG_USR_NAME", unique = false, nullable = true, length = 30)
	private String lastChgUsrName;

	/**
	 * 最近更新人所属机构ID
	 **/
	@Column(name = "LAST_CHG_USR_ORG_ID", unique = false, nullable = true, length = 30)
	private String lastChgUsrOrgId;

	/**
	 * 最近更新人所属机构名称
	 **/
	@Column(name = "LAST_CHG_USR_ORG_NAME", unique = false, nullable = true, length = 30)
	private String lastChgUsrOrgName;

	/**
	 * 最近更新时间
	 **/
	@Column(name = "LAST_CHG_DATE", unique = false, nullable = true, length = 7)
	private Date lastChgDate;

	/**
	 * 补充
	 **/
	@Column(name = "ANNEX", unique = false, nullable = true, length = 1000)
	private String annex;
	
	/**
	 * 报告周期结束日期
	 **/
	@Column(name = "END_DATE", unique = false, nullable = true, length = 7)
	private Date endDate;

	/**
	 * 流程实例号
	 **/
	@Column(name = "INSTANCE_ID", unique = false, nullable = true, length = 60)
	private String instanceId;

	public String getWorkReportId() {
		return workReportId;
	}

	public void setWorkReportId(String workReportId) {
		this.workReportId = workReportId == null ? null : workReportId.trim();
	}

	public String getWorkReportBusiType() {
		return workReportBusiType;
	}

	public void setWorkReportBusiType(String workReportBusiType) {
		this.workReportBusiType = workReportBusiType == null ? null : workReportBusiType.trim();
	}

	/**
	 * @return startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate 要设置的 startDate
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
	 * @param endDate 要设置的 endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getWorkSummary() {
		return workSummary;
	}

	public void setWorkSummary(String workSummary) {
		this.workSummary = workSummary == null ? null : workSummary.trim();
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent == null ? null : workContent.trim();
	}

	public String getLaterPlan() {
		return laterPlan;
	}

	public void setLaterPlan(String laterPlan) {
		this.laterPlan = laterPlan == null ? null : laterPlan.trim();
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete == null ? null : isDelete.trim();
	}

	public String getIsDraft() {
		return isDraft;
	}

	public void setIsDraft(String isDraft) {
		this.isDraft = isDraft == null ? null : isDraft.trim();
	}

	public String getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId == null ? null : creatorId.trim();
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName == null ? null : creatorName.trim();
	}

	public String getCreatorOrgName() {
		return creatorOrgName;
	}

	public void setCreatorOrgName(String creatorOrgName) {
		this.creatorOrgName = creatorOrgName == null ? null : creatorOrgName.trim();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLastChgUsrId() {
		return lastChgUsrId;
	}

	public void setLastChgUsrId(String lastChgUsrId) {
		this.lastChgUsrId = lastChgUsrId == null ? null : lastChgUsrId.trim();
	}

	public String getLastChgUsrName() {
		return lastChgUsrName;
	}

	public void setLastChgUsrName(String lastChgUsrName) {
		this.lastChgUsrName = lastChgUsrName == null ? null : lastChgUsrName.trim();
	}

	public String getLastChgUsrOrgId() {
		return lastChgUsrOrgId;
	}

	public void setLastChgUsrOrgId(String lastChgUsrOrgId) {
		this.lastChgUsrOrgId = lastChgUsrOrgId == null ? null : lastChgUsrOrgId.trim();
	}

	public String getLastChgUsrOrgName() {
		return lastChgUsrOrgName;
	}

	public void setLastChgUsrOrgName(String lastChgUsrOrgName) {
		this.lastChgUsrOrgName = lastChgUsrOrgName == null ? null : lastChgUsrOrgName.trim();
	}

	public Date getLastChgDate() {
		return lastChgDate;
	}

	public void setLastChgDate(Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}

	/**
	 * @return createOrg
	 */
	public String getCreatorOrg() {
		return creatorOrg;
	}

	/**
	 * @param creatorOrg
	 *            要设置的 createOrg
	 */
	public void setCreatorOrg(String creatorOrg) {
		this.creatorOrg = creatorOrg == null ? null : creatorOrg.trim();
	}

	/**
	 * @return annex
	 */
	public String getAnnex() {
		return annex;
	}

	/**
	 * @param annex
	 *            要设置的 annex
	 */
	public void setAnnex(String annex) {
		this.annex = annex == null ? null : annex.trim();
	}

	public String getInstanceId() { return instanceId; }

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId == null ? null : instanceId;
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
		OcrmFwpWorkReport other = (OcrmFwpWorkReport) that;
		return (this.getWorkReportId() == null ? other.getWorkReportId() == null
				: this.getWorkReportId().equals(other.getWorkReportId()))
				&& (this.getWorkReportBusiType() == null ? other.getWorkReportBusiType() == null
						: this.getWorkReportBusiType().equals(other.getWorkReportBusiType()))
				&& (this.getWorkContent() == null ? other.getWorkContent() == null
						: this.getWorkContent().equals(other.getWorkContent()))
				&& (this.getWorkSummary() == null ? other.getWorkSummary() == null
						: this.getWorkSummary().equals(other.getWorkSummary()))
				&& (this.getCreatorId() == null ? other.getCreatorId() == null
						: this.getCreatorId().equals(other.getCreatorId()))
				&& (this.getCreatorName() == null ? other.getCreatorName() == null
						: this.getCreatorName().equals(other.getCreatorName()))
				&& (this.getCreatorOrgName() == null ? other.getCreatorOrgName() == null
						: this.getCreatorOrgName().equals(other.getCreatorOrgName()))
				&& (this.getLastChgUsrId() == null ? other.getCreatorOrgName() == null
						: this.getCreatorOrgName().equals(other.getCreatorOrgName()))
				&& (this.getLastChgUsrName() == null ? other.getLastChgUsrName() == null
						: this.getLastChgUsrName().equals(other.getLastChgUsrName()))
				&& (this.getLastChgUsrOrgId() == null ? other.getLastChgUsrOrgId() == null
						: this.getLastChgUsrOrgId().equals(other.getLastChgUsrOrgId()))
				&& (this.getLastChgUsrOrgName() == null ? other.getLastChgUsrOrgName() == null
						: this.getLastChgUsrOrgName().equals(other.getLastChgUsrOrgName()))
				&& (this.getLaterPlan() == null ? other.getLaterPlan() == null
						: this.getLaterPlan().equals(other.getLaterPlan()))
				&& (this.getIsDraft() == null ? other.getIsDraft() == null
						: this.getIsDraft().equals(other.getIsDraft()))
				&& (this.getIsDelete() == null ? other.getIsDelete() == null
						: this.getIsDelete().equals(other.getIsDelete()))
				&& (this.getInstanceId() == null ? other.getInstanceId() == null
				: this.getInstanceId().equals(other.getInstanceId()))
				&& (this.getAnnex() == null ? other.getAnnex() == null : this.getAnnex().equals(other.getAnnex()))
				&& (this.getCreatorOrg() == null ? other.getCreatorOrg() == null
						: this.getCreatorOrg().equals(other.getCreatorOrg()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getWorkReportId() == null) ? 0 : getWorkReportId().hashCode());
		result = prime * result + ((getWorkReportBusiType() == null) ? 0 : getWorkReportBusiType().hashCode());
		result = prime * result + ((getWorkContent() == null) ? 0 : getWorkContent().hashCode());
		result = prime * result + ((getWorkSummary() == null) ? 0 : getWorkSummary().hashCode());
		result = prime * result + ((getIsDelete() == null) ? 0 : getIsDelete().hashCode());
		result = prime * result + ((getIsDraft() == null) ? 0 : getIsDraft().hashCode());
		result = prime * result + ((getLaterPlan() == null) ? 0 : getLaterPlan().hashCode());
		result = prime * result + ((getLastChgUsrOrgName() == null) ? 0 : getLastChgUsrOrgName().hashCode());
		result = prime * result + ((getLastChgUsrOrgId() == null) ? 0 : getLastChgUsrOrgId().hashCode());
		result = prime * result + ((getLastChgUsrName() == null) ? 0 : getLastChgUsrName().hashCode());
		result = prime * result + ((getLastChgUsrId() == null) ? 0 : getLastChgUsrId().hashCode());
		result = prime * result + ((getCreatorOrgName() == null) ? 0 : getCreatorOrgName().hashCode());
		result = prime * result + ((getCreatorName() == null) ? 0 : getCreatorName().hashCode());
		result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
		result = prime * result + ((getAnnex() == null) ? 0 : getAnnex().hashCode());
		result = prime * result + ((getInstanceId() == null) ? 0 : getInstanceId().hashCode());
		result = prime * result + ((getCreatorOrg() == null) ? 0 : getCreatorOrg().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("Hash = ").append(hashCode());
		sb.append(", workReportId=").append(workReportId);
		sb.append(", workReportBusiType=").append(workReportBusiType);
		sb.append(", workContent=").append(workContent);
		sb.append(", workSummary=").append(workSummary);
		sb.append(", isDelete=").append(isDelete);
		sb.append(", isDraft=").append(isDraft);
		sb.append(", creatorId=").append(creatorId);
		sb.append(", creatorName=").append(creatorName);
		sb.append(", creatorOrgName=").append(creatorOrgName);
		sb.append(", lastChgUsrId=").append(lastChgUsrId);
		sb.append(", lastChgUsrOrgId=").append(lastChgUsrOrgId);
		sb.append(", lastChgUsrName=").append(lastChgUsrName);
		sb.append(", lastChgUsrOrgName=").append(lastChgUsrOrgName);
		sb.append(", laterPlan=").append(laterPlan);
		sb.append(", creatorOrg=").append(creatorOrg);
		sb.append(", annex=").append(annex);
		sb.append(", instanceId=").append(instanceId);
		sb.append("]");
		return sb.toString();
	}
}