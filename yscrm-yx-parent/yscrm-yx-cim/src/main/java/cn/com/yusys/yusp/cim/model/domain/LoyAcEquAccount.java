package cn.com.yusys.yusp.cim.model.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: LoyAcEquAccount
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-06-04 15:05:21
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_AC_SCORE_ACCOUNT")
public class LoyAcEquAccount extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 账户ID
     **/
    @Id
    @Column(name = "ACCOUNT_NO")
    @Generated(GenerationType.UUID)
    private String accountId;

    /**
     * 所属分类
     **/
    @Column(name = "SUB_TYPE", unique = false, nullable = true, length = 32)
    private String subType;

    /**
     * 账户名称
     **/
    @Column(name = "ACCOUNT_NAME", unique = false, nullable = true, length = 128)
    private String accountName;

    /**
     * 账户类别
     **/
    @Column(name = "ACCT_TYPE_ID", unique = false, nullable = true, length = 32)
    private String acctType;

    /**
     * 汇率
     **/
    @Column(name = "EXCH_RATE", unique = false, nullable = true, length = 32)
    private String exchRate;

    /**
     * 账户状态
     **/
    @Column(name = "ACCT_STAT", unique = false, nullable = true, length = 32)
    private String acctStat;

    /**
     * 审批状态
     **/
    @Column(name = "APPR_STAT", unique = false, nullable = true, length = 32)
    private String apprStat;

    /**
     * 所属金融机构
     **/
    @Column(name = "FINANCE_ORG_CODE", unique = false, nullable = true, length = 32)
    private String financeOrgCode;

    /**
     * 所属机构
     **/
    @Column(name = "ORG_CODE", unique = false, nullable = true, length = 32)
    private String orgCode;

    /**
     * 描述
     **/
    @Column(name = "REMARK", unique = false, nullable = true, length = 1024)
    private String remark;

    /**
     * 创建人
     **/
    @Column(name = "CREATE_USER", unique = false, nullable = true, length = 32)
    private String createUser;

    /**
     * 创建日期
     **/
    @Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
    private Date createDate;

    /**
     * 创建机构
     **/
    @Column(name = "CREATE_ORG", unique = false, nullable = true, length = 32)
    private String createOrg;

    /**
     * 最近修改人
     **/
    @Column(name = "UPDATE_USER", unique = false, nullable = true, length = 32)
    private String updateUser;

    /**
     * 最近修改时间
     **/
    @Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
    private Date updateDate;

    /**
     * 最近修改机构
     **/
    @Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 32)
    private String updateOrg;

    /**
     * 是否删除（0-删除；1-使用）
     **/
    @Column(name = "IS_DEL", unique = false, nullable = true, length = 2)
    private String isDel;


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
     * @param subType
     */
    public void setSubType(String subType) {
        this.subType = subType == null ? null : subType.trim();
    }

    /**
     * @return SubType
     */
    public String getSubType() {
        return this.subType;
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
     * @param acctType
     */
    public void setAcctType(String acctType) {
        this.acctType = acctType == null ? null : acctType.trim();
    }

    /**
     * @return AcctType
     */
    public String getAcctType() {
        return this.acctType;
    }

    /**
     * @param exchRate
     */
    public void setExchRate(String exchRate) {
        this.exchRate = exchRate == null ? null : exchRate.trim();
    }

    /**
     * @return ExchRate
     */
    public String getExchRate() {
        return this.exchRate;
    }

    /**
     * @param acctStat
     */
    public void setAcctStat(String acctStat) {
        this.acctStat = acctStat == null ? null : acctStat.trim();
    }

    /**
     * @return AcctStat
     */
    public String getAcctStat() {
        return this.acctStat;
    }

    /**
     * @param apprStat
     */
    public void setApprStat(String apprStat) {
        this.apprStat = apprStat == null ? null : apprStat.trim();
    }

    /**
     * @return ApprStat
     */
    public String getApprStat() {
        return this.apprStat;
    }

    /**
     * @param financeOrgCode
     */
    public void setFinanceOrgCode(String financeOrgCode) {
        this.financeOrgCode = financeOrgCode == null ? null : financeOrgCode.trim();
    }

    /**
     * @return FinanceOrgCode
     */
    public String getFinanceOrgCode() {
        return this.financeOrgCode;
    }

    /**
     * @param orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * @return OrgCode
     */
    public String getOrgCode() {
        return this.orgCode;
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
     * @param isDel
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }

    /**
     * @return IsDel
     */
    public String getIsDel() {
        return this.isDel;
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
        LoyAcEquAccount other = (LoyAcEquAccount) that;
        return (this.getAccountId() == null ? other.getAccountId() == null : this.getAccountId().equals(other.getAccountId()))
                && (this.getSubType() == null ? other.getSubType() == null : this.getSubType().equals(other.getSubType()))
                && (this.getAccountName() == null ? other.getAccountName() == null : this.getAccountName().equals(other.getAccountName()))
                && (this.getAcctType() == null ? other.getAcctType() == null : this.getAcctType().equals(other.getAcctType()))
                && (this.getExchRate() == null ? other.getExchRate() == null : this.getExchRate().equals(other.getExchRate()))
                && (this.getAcctStat() == null ? other.getAcctStat() == null : this.getAcctStat().equals(other.getAcctStat()))
                && (this.getApprStat() == null ? other.getApprStat() == null : this.getApprStat().equals(other.getApprStat()))
                && (this.getFinanceOrgCode() == null ? other.getFinanceOrgCode() == null : this.getFinanceOrgCode().equals(other.getFinanceOrgCode()))
                && (this.getOrgCode() == null ? other.getOrgCode() == null : this.getOrgCode().equals(other.getOrgCode()))
                && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
                && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                && (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
                && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                && (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
                && (this.getIsDel() == null ? other.getIsDel() == null : this.getIsDel().equals(other.getIsDel()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAccountId() == null) ? 0 : getAccountId().hashCode());
        result = prime * result + ((getSubType() == null) ? 0 : getSubType().hashCode());
        result = prime * result + ((getAccountName() == null) ? 0 : getAccountName().hashCode());
        result = prime * result + ((getAcctType() == null) ? 0 : getAcctType().hashCode());
        result = prime * result + ((getExchRate() == null) ? 0 : getExchRate().hashCode());
        result = prime * result + ((getAcctStat() == null) ? 0 : getAcctStat().hashCode());
        result = prime * result + ((getApprStat() == null) ? 0 : getApprStat().hashCode());
        result = prime * result + ((getFinanceOrgCode() == null) ? 0 : getFinanceOrgCode().hashCode());
        result = prime * result + ((getOrgCode() == null) ? 0 : getOrgCode().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getIsDel() == null) ? 0 : getIsDel().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append(", accountId=").append(accountId);
        sb.append(", subType=").append(subType);
        sb.append(", accountName=").append(accountName);
        sb.append(", acctType=").append(acctType);
        sb.append(", exchRate=").append(exchRate);
        sb.append(", acctStat=").append(acctStat);
        sb.append(", apprStat=").append(apprStat);
        sb.append(", financeOrgCode=").append(financeOrgCode);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", remark=").append(remark);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", createOrg=").append(createOrg);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", updateOrg=").append(updateOrg);
        sb.append(", isDel=").append(isDel);
        sb.append("]");
        return sb.toString();
    }
}