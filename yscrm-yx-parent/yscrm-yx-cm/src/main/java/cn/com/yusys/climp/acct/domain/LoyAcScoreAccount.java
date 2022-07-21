package cn.com.yusys.climp.acct.domain;

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
 * @项目名称: yusp-climp-acct模块
 * @类名称: LoyAcScoreAccount
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: ZZZ
 * @创建时间: 2019-01-03 17:27:51
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_AC_SCORE_ACCOUNT")
public class LoyAcScoreAccount extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 账户ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ACCOUNT_ID", unique = false, nullable = false, length = 32)
	private String accountId;
	
	/** 账户编号 **/
	@Column(name = "ACCOUNT_NO", unique = false, nullable = false, length = 20)
	private String accountNo;
	
	/** 账户名称 **/
	@Column(name = "ACCOUNT_NAME", unique = false, nullable = false, length = 100)
	private String accountName;
	
	/** 账户类别ID **/
	@Column(name = "ACCT_TYPE_ID", unique = false, nullable = false, length = 32)
	private String acctTypeId;
	
	/** 账户优先级[手动录入，任何2个账户优先级不能相同，用于积分扣减时，有效期相同情况下，优先扣减哪个账户积分] **/
	@Column(name = "ACCT_PRIORITY", unique = false, nullable = false, length = 11)
	private long acctPriority;
	
	/** 时效类型[时效账户、永久账户] **/
	@Column(name = "TIME_VALID_TYPE", unique = false, nullable = false, length = 10)
	private String timeValidType;
	
	/** 积分类型[红利积分、尊享积分等，数据字典定义] **/
	@Column(name = "SCORE_TYPE", unique = false, nullable = true, length = 10)
	private String scoreType;
	
	/** 积分池编号[绑定积分池] **/
	@Column(name = "POOL_NO", unique = false, nullable = true, length = 20)
	private String poolNo;
	
	/** 描述 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 1024)
	private String remark;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
//	@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近修改时间 **/
//	@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 100)
	private String updateOrg;
	
	/** 删除标志 **/
	@Column(name = "DELETE_SIGN", unique = false, nullable = true, length = 20)
	private String deleteSign;
	
	/** 是否自动转换 **/
	@Column(name = "AUTO_CHANGE", unique = false, nullable = true, length = 10)
	private String autoChange;
	
	/** 审批状态 **/
	@Column(name = "WF_APPR_STS", unique = false, nullable = true, length = 20)
	private String wfApprSts;

	/** 积分大类(1-业务类；2-权益赠送类) **/
	@Column(name = "ACCT_B_TYPE", unique = false, nullable = true, length = 20)
	private String acctBType;
	
	/** 积分小类(1-余额类；2-卡消费类；3-代销/代理类；4-VIP升级积分类；5-业务办理类；6-注册登录类) **/
	@Column(name = "ACCT_S_TYPE", unique = false, nullable = true, length = 20)
	private String acctSType;
	
	public String getAcctBType() {
		return acctBType;
	}

	public void setAcctBType(String acctBType) {
		this.acctBType = acctBType;
	}

	public String getAcctSType() {
		return acctSType;
	}

	public void setAcctSType(String acctSType) {
		this.acctSType = acctSType;
	}

	/**
	 * @param accountId
	 */
	public void setAccountId(String accountId) {
		this.accountId = accountId == null ? null : accountId.trim();
	}
	
    /**
     * @return AccountId
     */	
	public String getAccountId() {
		return this.accountId;
	}
	
	/**
	 * @param accountNo
	 */
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo == null ? null : accountNo.trim();
	}
	
    /**
     * @return AccountNo
     */	
	public String getAccountNo() {
		return this.accountNo;
	}
	
	/**
	 * @param accountName
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName == null ? null : accountName.trim();
	}
	
    /**
     * @return AccountName
     */	
	public String getAccountName() {
		return this.accountName;
	}
	
	/**
	 * @param acctTypeId
	 */
	public void setAcctTypeId(String acctTypeId) {
		this.acctTypeId = acctTypeId == null ? null : acctTypeId.trim();
	}
	
    /**
     * @return AcctTypeId
     */	
	public String getAcctTypeId() {
		return this.acctTypeId;
	}
	
	/**
	 * @param acctPriority
	 */
	public void setAcctPriority(long acctPriority) {
		this.acctPriority = acctPriority;
	}
	
    /**
     * @return AcctPriority
     */	
	public long getAcctPriority() {
		return this.acctPriority;
	}
	
	/**
	 * @param timeValidType
	 */
	public void setTimeValidType(String timeValidType) {
		this.timeValidType = timeValidType == null ? null : timeValidType.trim();
	}
	
    /**
     * @return TimeValidType
     */	
	public String getTimeValidType() {
		return this.timeValidType;
	}
	
	/**
	 * @param scoreType
	 */
	public void setScoreType(String scoreType) {
		this.scoreType = scoreType == null ? null : scoreType.trim();
	}
	
    /**
     * @return ScoreType
     */	
	public String getScoreType() {
		return this.scoreType;
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
	 * @param autoChange
	 */
	public void setAutoChange(String autoChange) {
		this.autoChange = autoChange == null ? null : autoChange.trim();
	}
	
    /**
     * @return AutoChange
     */	
	public String getAutoChange() {
		return this.autoChange;
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
        LoyAcScoreAccount other = (LoyAcScoreAccount) that;
		return (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
        	&& (this.getAccountNo() == null ? other.getAccountNo() == null : this.getAccountNo().equals(other.getAccountNo()))
        	&& (this.getAccountName() == null ? other.getAccountName() == null : this.getAccountName().equals(other.getAccountName()))
        	&& (this.getAcctTypeId() == null ? other.getAcctTypeId() == null : this.getAcctTypeId().equals(other.getAcctTypeId()))
                	&& (this.getTimeValidType() == null ? other.getTimeValidType() == null : this.getTimeValidType().equals(other.getTimeValidType()))
        	&& (this.getScoreType() == null ? other.getScoreType() == null : this.getScoreType().equals(other.getScoreType()))
        	&& (this.getPoolNo() == null ? other.getPoolNo() == null : this.getPoolNo().equals(other.getPoolNo()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        	&& (this.getDeleteSign() == null ? other.getDeleteSign() == null : this.getDeleteSign().equals(other.getDeleteSign()))
        	&& (this.getAutoChange() == null ? other.getAutoChange() == null : this.getAutoChange().equals(other.getAutoChange()))
        	&& (this.getWfApprSts() == null ? other.getWfApprSts() == null : this.getWfApprSts().equals(other.getWfApprSts()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getAccountNo() == null) ? 0 : getAccountNo().hashCode());
        result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
        result = prime * result + ((getAcctTypeId() == null) ? 0 : getAcctTypeId().hashCode());
        result = prime * result + ((getTimeValidType() == null) ? 0 : getTimeValidType().hashCode());
        result = prime * result + ((getScoreType() == null) ? 0 : getScoreType().hashCode());
        result = prime * result + ((getPoolNo() == null) ? 0 : getPoolNo().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getDeleteSign() == null) ? 0 : getDeleteSign().hashCode());
        result = prime * result + ((getAutoChange() == null) ? 0 : getAutoChange().hashCode());
        result = prime * result + ((getWfApprSts() == null) ? 0 : getWfApprSts().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", accountId=").append(accountId);
		sb.append(", accountNo=").append(accountNo);
		sb.append(", accountName=").append(accountName);
		sb.append(", acctTypeId=").append(acctTypeId);
		sb.append(", acctPriority=").append(acctPriority);
		sb.append(", timeValidType=").append(timeValidType);
		sb.append(", scoreType=").append(scoreType);
		sb.append(", poolNo=").append(poolNo);
		sb.append(", remark=").append(remark);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
		sb.append(", deleteSign=").append(deleteSign);
		sb.append(", autoChange=").append(autoChange);
		sb.append(", wfApprSts=").append(wfApprSts);
        sb.append("]");
        return sb.toString();
    }
}