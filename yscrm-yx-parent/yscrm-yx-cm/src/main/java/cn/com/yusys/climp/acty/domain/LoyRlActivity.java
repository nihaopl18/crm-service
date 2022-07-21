package cn.com.yusys.climp.acty.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlActivity
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_RL_ACTIVITY")
public class LoyRlActivity extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 活动ID **/
	@Id
	@Column(name = "ACTIVITY_ID", unique = false, nullable = false, length = 32)
	private String activityId;
	
	/** 项目ID **/
	@Column(name = "PROJECT_ID", unique = false, nullable = true, length = 32)
	private String projectId;
	
	/** 节点id **/
	@Column(name = "TEMP_ID", unique = false, nullable = true, length = 32)
	private String tempId;
	
	/** 策划编号（营销活动主键） **/
	@Column(name = "NODE_ID", unique = false, nullable = true, length = 32)
	private String nodeId;
	
	/** 组件id **/
	@Column(name = "ASSEMBLY_ID", unique = false, nullable = true, length = 32)
	private String assemblyId;
	
	/** 交易类型（1实时，2批量） **/
	@Column(name = "TRANSACTION_TYPE", unique = false, nullable = true, length = 10)
	private String transactionType;
	
	/** 活动名称 **/
	@Column(name = "ACTIVITY_NAME", unique = false, nullable = true, length = 100)
	private String activityName;
	
	/** 开始日期 **/
	@Column(name = "BEGIN_DATE", unique = false, nullable = true, length = 7)
	private Date beginDate;
	
	/** 结束日期 **/
	@Column(name = "END_DATE", unique = false, nullable = true, length = 7)
	private Date endDate;
	
	/** 优先级 **/
	@Column(name = "ACTIVITY_PRIORITY", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal activityPriority;
	
	/** 交易类型[代码] **/
	@Column(name = "TRANSACTION_CODE", unique = false, nullable = true, length = 50)
	private String transactionCode;
	
	/** 关联积分池(活动) **/
	@Column(name = "POOL_NO", unique = false, nullable = true, length = 20)
	private String poolNo;
	
	/** 审批状态 **/
	@Column(name = "WF_APPR_STS", unique = false, nullable = true, length = 10)
	private String wfApprSts;
	
	/** 启停标志[其停用标示，0停用，1使用，数据字典定义] **/
	@Column(name = "USE_FLAG", unique = false, nullable = true, length = 10)
	private String useFlag;
	
	/** 删除标志(1为删除，在系统全局参数中定义) **/
	@Column(name = "DELETE_SIGN", unique = false, nullable = true, length = 20)
	private String deleteSign;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 256)
	private String remark;
	
	/** INSTITUTION_ID **/
	@Column(name = "INSTITUTION_ID", unique = false, nullable = true, length = 50)
	private String institutionId;
	
	/** INSTITUTION_NAME **/
	@Column(name = "INSTITUTION_NAME", unique = false, nullable = true, length = 500)
	private String institutionName;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近修改时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 100)
	private String updateOrg;
	
	
	/**
	 * @param activityId
	 */
	public void setActivityId(String activityId) {
		this.activityId = activityId == null ? null : activityId.trim();
	}
	
    /**
     * @return ActivityId
     */	
	public String getActivityId() {
		return this.activityId;
	}
	
	/**
	 * @param projectId
	 */
	public void setProjectId(String projectId) {
		this.projectId = projectId == null ? null : projectId.trim();
	}
	
    /**
     * @return ProjectId
     */	
	public String getProjectId() {
		return this.projectId;
	}
	
	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId  = tempId == null ? null : tempId.trim();
	}

	/**
	 * @param activityName
	 */
	public void setActivityName(String activityName) {
		this.activityName = activityName == null ? null : activityName.trim();
	}
	
    /**
     * @return ActivityName
     */	
	public String getActivityName() {
		return this.activityName;
	}
	
	/**
	 * @param beginDate
	 */
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
    /**
     * @return BeginDate
     */	
	public Date getBeginDate() {
		return this.beginDate;
	}
	
	/**
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
    /**
     * @return EndDate
     */	
	public Date getEndDate() {
		return this.endDate;
	}
	
	/**
	 * @param activityPriority
	 */
	public void setActivityPriority(java.math.BigDecimal activityPriority) {
		this.activityPriority = activityPriority;
	}
	
    /**
     * @return ActivityPriority
     */	
	public java.math.BigDecimal getActivityPriority() {
		return this.activityPriority;
	}
	
	/**
	 * @param transactionCode
	 */
	public void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode == null ? null : transactionCode.trim();
	}
	
    /**
     * @return TransactionCode
     */	
	public String getTransactionCode() {
		return this.transactionCode;
	}
	
	/**
	 * @param poolNo
	 */
	public void setPoolNo(String poolNo) {
		this.poolNo = poolNo == null ? null : poolNo.trim();
	}
	
    /**
     * @return PoolNo
     */	
	public String getPoolNo() {
		return this.poolNo;
	}
	
	/**
	 * @param wfApprSts
	 */
	public void setWfApprSts(String wfApprSts) {
		this.wfApprSts = wfApprSts == null ? null : wfApprSts.trim();
	}
	
    /**
     * @return WfApprSts
     */	
	public String getWfApprSts() {
		return this.wfApprSts;
	}
	
	/**
	 * @param useFlag
	 */
	public void setUseFlag(String useFlag) {
		this.useFlag = useFlag == null ? null : useFlag.trim();
	}
	
    /**
     * @return UseFlag
     */	
	public String getUseFlag() {
		return this.useFlag;
	}
	
	/**
	 * @param deleteSign
	 */
	public void setDeleteSign(String deleteSign) {
		this.deleteSign = deleteSign == null ? null : deleteSign.trim();
	}
	
    /**
     * @return DeleteSign
     */	
	public String getDeleteSign() {
		return this.deleteSign;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * @param institutionId
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId == null ? null : institutionId.trim();
	}
	
    /**
     * @return InstitutionId
     */	
	public String getInstitutionId() {
		return this.institutionId;
	}
	
	/**
	 * @param institutionName
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName == null ? null : institutionName.trim();
	}
	
    /**
     * @return InstitutionName
     */	
	public String getInstitutionName() {
		return this.institutionName;
	}
	
	/**
	 * @param createUser
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}
	
    /**
     * @return CreateUser
     */	
	public String getCreateUser() {
		return this.createUser;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
    /**
     * @return CreateDate
     */	
	public Date getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
	}
	
	/**
	 * @param updateUser
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}
	
    /**
     * @return UpdateUser
     */	
	public String getUpdateUser() {
		return this.updateUser;
	}
	
	/**
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
    /**
     * @return UpdateDate
     */	
	public Date getUpdateDate() {
		return this.updateDate;
	}
	
	/**
	 * @param updateOrg
	 */
	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg == null ? null : updateOrg.trim();
	}
	
    /**
     * @return UpdateOrg
     */	
	public String getUpdateOrg() {
		return this.updateOrg;
	}


    public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getAssemblyId() {
		return assemblyId;
	}

	public void setAssemblyId(String assemblyId) {
		this.assemblyId = assemblyId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
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
        LoyRlActivity other = (LoyRlActivity) that;
		return (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
        	&& (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
        	&& (this.getActivityName() == null ? other.getActivityName() == null : this.getActivityName().equals(other.getActivityName()))
                                	&& (this.getTransactionCode() == null ? other.getTransactionCode() == null : this.getTransactionCode().equals(other.getTransactionCode()))
        	&& (this.getPoolNo() == null ? other.getPoolNo() == null : this.getPoolNo().equals(other.getPoolNo()))
        	&& (this.getWfApprSts() == null ? other.getWfApprSts() == null : this.getWfApprSts().equals(other.getWfApprSts()))
        	&& (this.getUseFlag() == null ? other.getUseFlag() == null : this.getUseFlag().equals(other.getUseFlag()))
        	&& (this.getDeleteSign() == null ? other.getDeleteSign() == null : this.getDeleteSign().equals(other.getDeleteSign()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getInstitutionId() == null ? other.getInstitutionId() == null : this.getInstitutionId().equals(other.getInstitutionId()))
        	&& (this.getInstitutionName() == null ? other.getInstitutionName() == null : this.getInstitutionName().equals(other.getInstitutionName()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getActivityName() == null) ? 0 : getActivityName().hashCode());
        result = prime * result + ((getTransactionCode() == null) ? 0 : getTransactionCode().hashCode());
        result = prime * result + ((getPoolNo() == null) ? 0 : getPoolNo().hashCode());
        result = prime * result + ((getWfApprSts() == null) ? 0 : getWfApprSts().hashCode());
        result = prime * result + ((getUseFlag() == null) ? 0 : getUseFlag().hashCode());
        result = prime * result + ((getDeleteSign() == null) ? 0 : getDeleteSign().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getInstitutionId() == null) ? 0 : getInstitutionId().hashCode());
        result = prime * result + ((getInstitutionName() == null) ? 0 : getInstitutionName().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", activityId=").append(activityId);
		sb.append(", projectId=").append(projectId);
		sb.append(", activityName=").append(activityName);
		sb.append(", beginDate=").append(beginDate);
		sb.append(", endDate=").append(endDate);
		sb.append(", activityPriority=").append(activityPriority);
		sb.append(", transactionCode=").append(transactionCode);
		sb.append(", poolNo=").append(poolNo);
		sb.append(", wfApprSts=").append(wfApprSts);
		sb.append(", useFlag=").append(useFlag);
		sb.append(", deleteSign=").append(deleteSign);
		sb.append(", remark=").append(remark);
		sb.append(", institutionId=").append(institutionId);
		sb.append(", institutionName=").append(institutionName);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
        sb.append("]");
        return sb.toString();
    }
}