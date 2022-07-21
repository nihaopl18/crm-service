package cn.com.yusys.climp.pool.domain;

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
 * @项目名称: yusp-climp-sface-core模块
 * @类名称: LoyAcScorePool
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: ZZZ
 * @创建时间: 2019-01-08 15:20:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_AC_SCORE_POOL")
public class LoyAcScorePool extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 积分池ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "POOL_ID", unique = false, nullable = false, length = 32)
	private String poolId;
	
	/** 积分池编号 **/
	@Column(name = "POOL_NO", unique = false, nullable = true, length = 20)
	private String poolNo;
	
	/** 积分池名称 **/
	@Column(name = "POOL_NAME", unique = false, nullable = true, length = 100)
	private String poolName;
	
	/** 积分池初始积分 **/
	@Column(name = "POOL_SCORE_INITIAL", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal poolScoreInitial;
	
	/** 积分池已用积分 **/
	@Column(name = "POOL_SCORE_USED", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal poolScoreUsed;
	
	/** 积分池剩余积分 **/
	@Column(name = "POOL_SCORE_SURPLUS", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal poolScoreSurplus;
	
	/** 每点参考成本 **/
	@Column(name = "REFERENCE_COST", unique = false, nullable = true, length = 16)
	private java.math.BigDecimal referenceCost;
	
	/** 预警阀值(百分比) **/
	@Column(name = "WARN_THRESHOLD", unique = false, nullable = true, length = 10)
	private String warnThreshold;
	
	/** 是否有上限(0无，1有，数据字典定义) **/
	@Column(name = "UPPER_LIMIT", unique = false, nullable = true, length = 20)
	private String upperLimit;
	
	/** 积分池描述 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 1024)
	private String remark;
	
	/** 删除标志(1为删除，在系统全局参数中定义) **/
	@Column(name = "DELETE_SIGN", unique = false, nullable = true, length = 20)
	private String deleteSign;
	
	/** 审批状态[在数据字典定义] **/
	@Column(name = "WF_APPR_STS", unique = false, nullable = true, length = 20)
	private String wfApprSts;
	
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
	
	/** 积分池类型 **/
	@Column(name = "POOL_TYPE", unique = false, nullable = true, length = 10)
	private String poolType;
	
	/** 父积分池ID **/
	@Column(name = "POOL_PARENT_ID", unique = false, nullable = true, length = 32)
	private String poolParentId;
	
	/** 预警短信发送手机号码 **/
	@Column(name = "WARN_PHONE_NO", unique = false, nullable = true, length = 20)
	private String warnPhoneNo;
	
	/**
	 * @return warnPhoneNo
	 */
	public String getWarnPhoneNo() {
		return warnPhoneNo;
	}

	/**
	 * @param warnPhoneNo 要设置的 warnPhoneNo
	 */
	public void setWarnPhoneNo(String warnPhoneNo) {
		this.warnPhoneNo = warnPhoneNo;
	}

	public String getPoolParentId() {
		return poolParentId;
	}
	
	public void setPoolParentId(String poolParentId) {
		this.poolParentId = poolParentId;
	}

	/**
	 * @param poolId
	 */
	public void setPoolId(String poolId) {
		this.poolId = poolId == null ? null : poolId.trim();
	}
	
    /**
     * @return PoolId
     */	
	public String getPoolId() {
		return this.poolId;
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
	 * @param poolName
	 */
	public void setPoolName(String poolName) {
		this.poolName = poolName == null ? null : poolName.trim();
	}
	
    /**
     * @return PoolName
     */	
	public String getPoolName() {
		return this.poolName;
	}
	
	/**
	 * @param poolScoreInitial
	 */
	public void setPoolScoreInitial(java.math.BigDecimal poolScoreInitial) {
		this.poolScoreInitial = poolScoreInitial;
	}
	
    /**
     * @return PoolScoreInitial
     */	
	public java.math.BigDecimal getPoolScoreInitial() {
		return this.poolScoreInitial;
	}
	
	/**
	 * @param poolScoreUsed
	 */
	public void setPoolScoreUsed(java.math.BigDecimal poolScoreUsed) {
		this.poolScoreUsed = poolScoreUsed;
	}
	
    /**
     * @return PoolScoreUsed
     */	
	public java.math.BigDecimal getPoolScoreUsed() {
		return this.poolScoreUsed;
	}
	
	/**
	 * @param poolScoreSurplus
	 */
	public void setPoolScoreSurplus(java.math.BigDecimal poolScoreSurplus) {
		this.poolScoreSurplus = poolScoreSurplus;
	}
	
    /**
     * @return PoolScoreSurplus
     */	
	public java.math.BigDecimal getPoolScoreSurplus() {
		return this.poolScoreSurplus;
	}
	
	/**
	 * @param referenceCost
	 */
	public void setReferenceCost(java.math.BigDecimal referenceCost) {
		this.referenceCost = referenceCost;
	}
	
    /**
     * @return ReferenceCost
     */	
	public java.math.BigDecimal getReferenceCost() {
		return this.referenceCost;
	}
	
	/**
	 * @param warnThreshold
	 */
	public void setWarnThreshold(String warnThreshold) {
		this.warnThreshold = warnThreshold == null ? null : warnThreshold.trim();
	}
	
    /**
     * @return WarnThreshold
     */	
	public String getWarnThreshold() {
		return this.warnThreshold;
	}
	
	/**
	 * @param upperLimit
	 */
	public void setUpperLimit(String upperLimit) {
		this.upperLimit = upperLimit == null ? null : upperLimit.trim();
	}
	
    /**
     * @return UpperLimit
     */	
	public String getUpperLimit() {
		return this.upperLimit;
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
	
	/**
	 * @param poolType
	 */
	public void setPoolType(String poolType) {
		this.poolType = poolType == null ? null : poolType.trim();
	}
	
    /**
     * @return PoolType
     */	
	public String getPoolType() {
		return this.poolType;
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
        LoyAcScorePool other = (LoyAcScorePool) that;
		return (this.getPoolId() == null ? other.getPoolId() == null : this.getPoolId().equals(other.getPoolId()))
        	&& (this.getPoolNo() == null ? other.getPoolNo() == null : this.getPoolNo().equals(other.getPoolNo()))
        	&& (this.getPoolName() == null ? other.getPoolName() == null : this.getPoolName().equals(other.getPoolName()))
                                        	&& (this.getWarnThreshold() == null ? other.getWarnThreshold() == null : this.getWarnThreshold().equals(other.getWarnThreshold()))
        	&& (this.getUpperLimit() == null ? other.getUpperLimit() == null : this.getUpperLimit().equals(other.getUpperLimit()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getDeleteSign() == null ? other.getDeleteSign() == null : this.getDeleteSign().equals(other.getDeleteSign()))
        	&& (this.getWfApprSts() == null ? other.getWfApprSts() == null : this.getWfApprSts().equals(other.getWfApprSts()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        	&& (this.getPoolType() == null ? other.getPoolType() == null : this.getPoolType().equals(other.getPoolType()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPoolId() == null) ? 0 : getPoolId().hashCode());
        result = prime * result + ((getPoolNo() == null) ? 0 : getPoolNo().hashCode());
        result = prime * result + ((getPoolName() == null) ? 0 : getPoolName().hashCode());
        result = prime * result + ((getWarnThreshold() == null) ? 0 : getWarnThreshold().hashCode());
        result = prime * result + ((getUpperLimit() == null) ? 0 : getUpperLimit().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getDeleteSign() == null) ? 0 : getDeleteSign().hashCode());
        result = prime * result + ((getWfApprSts() == null) ? 0 : getWfApprSts().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getPoolType() == null) ? 0 : getPoolType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", poolId=").append(poolId);
		sb.append(", poolNo=").append(poolNo);
		sb.append(", poolName=").append(poolName);
		sb.append(", poolScoreInitial=").append(poolScoreInitial);
		sb.append(", poolScoreUsed=").append(poolScoreUsed);
		sb.append(", poolScoreSurplus=").append(poolScoreSurplus);
		sb.append(", referenceCost=").append(referenceCost);
		sb.append(", warnThreshold=").append(warnThreshold);
		sb.append(", warnPhoneNo=").append(warnPhoneNo);
		sb.append(", upperLimit=").append(upperLimit);
		sb.append(", remark=").append(remark);
		sb.append(", deleteSign=").append(deleteSign);
		sb.append(", wfApprSts=").append(wfApprSts);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
		sb.append(", poolType=").append(poolType);
        sb.append("]");
        return sb.toString();
    }
}