package cn.com.yusys.yscrm.entity.cust.org.group.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-org-group-core模块
 * @类名称: OcrmFciGroup
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 19:12:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_GROUP")
public class OcrmFciGroup extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 集团编号 **/
	@Id
	@Column(name = "GROUP_NO")
	@Generated(GenerationType.UUID)
	private String groupNo;
	
	/** 集团母公司ID **/
	@Column(name = "GROUP_ROOT_CUST_ID", unique = false, nullable = true, length = 30)
	private String groupRootCustId;
	
	/** 集团类型 **/
	@Column(name = "GROUP_TYPE", unique = false, nullable = true, length = 2)
	private String groupType;
	
	/** 集团状态 **/
	@Column(name = "GROUP_STATUS", unique = false, nullable = true, length = 20)
	private String groupStatus;
	
	/** 集团融资形式 **/
	@Column(name = "GRP_FINANCE_TYPE", unique = false, nullable = true, length = 20)
	private String grpFinanceType;
	
	/** 集团描述 **/
	@Column(name = "GROUP_MEMO", unique = false, nullable = true, length = 500)
	private String groupMemo;
	
	/** 授信主办行ID **/
	@Column(name = "GROUP_HOST_ORG_NO", unique = false, nullable = true, length = 30)
	private String groupHostOrgNo;
	
	/** 地址 **/
	@Column(name = "GROUP_ROOT_ADDRESS", unique = false, nullable = true, length = 200)
	private String groupRootAddress;
	
	/** 主申请（集团）名称 **/
	@Column(name = "GROUP_NAME_MAIN", unique = false, nullable = true, length = 80)
	private String groupNameMain;
	
	/** 集团客户经理 **/
	@Column(name = "GAO", unique = false, nullable = true, length = 20)
	private String gao;
	
	/** 授信总额 **/
	@Column(name = "CREDIT_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal creditAmt;
	
	/** 授信币种 **/
	@Column(name = "CREDIT_CUR", unique = false, nullable = true, length = 20)
	private String creditCur;
	
	/** 额度到期日 **/
	@Transient
	@Column(name = "DUE_DATE", unique = false, nullable = true, length = 7)
	private Date dueDate;
	
	/** 集团下辖关联公司名单 **/
	@Column(name = "CORP_NAME_SUB", unique = false, nullable = true, length = 300)
	private String corpNameSub;
	
	/** 买受商使用情况 **/
	@Column(name = "USE_SITUATION", unique = false, nullable = true, length = 100)
	private String useSituation;
	
	/** 字符型注册地址 **/
	@Column(name = "ADDR_REGIST", unique = false, nullable = true, length = 200)
	private String addrRegist;
	
	/** 集团成员总数 **/
	@Column(name = "EMPLOYEE_NUM", unique = false, nullable = true, length = 10)
	private long employeeNum;
	
	/** 对外担保客户数 **/
	@Column(name = "GURANT_CUS_NUM", unique = false, nullable = true, length = 10)
	private long gurantCusNum;
	
	/** 正式成员数 **/
	@Column(name = "EMPLOYEE_NUM_FORMAL", unique = false, nullable = true, length = 10)
	private long employeeNumFormal;
	
	/** 待审成员数 **/
	@Column(name = "PENDING_MEMBER_NUM", unique = false, nullable = true, length = 10)
	private long pendingMemberNum;
	
	/** 对外担保成员数 **/
	@Column(name = "EXTERNAL_SECURITY_NUM", unique = false, nullable = true, length = 10)
	private long externalSecurityNum;
	
	/** 集团所属机构 **/
	@Column(name = "GAO_ORG", unique = false, nullable = true, length = 20)
	private String gaoOrg;
	
	/** "关联（集团）形式" **/
	@Column(name = "GROUP_FORM", unique = false, nullable = true, length = 20)
	private String groupForm;
	
	/** "用信总额" **/
	@Column(name = "USED_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal usedAmt;
	
	/** "贷款余额" **/
	@Column(name = "LOAN_BALANCE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal loanBalance;
	
	/** "不良贷款余额" **/
	@Column(name = "BAD_LOAN_BALANCE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal badLoanBalance;
	
	/** "担保方式" **/
	@Column(name = "GUARANTEE_TYPE", unique = false, nullable = true, length = 20)
	private String guaranteeType;
	
	/** 统计日期 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 7)
	private Date dataDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_USER_ORG_ID", unique = false, nullable = true, length = 30)
	private String createUserOrgId;
	
	/** 更新日期 **/
	//@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER_ID", unique = false, nullable = true, length = 30)
	private String updateUserId;
	
	/** 创建日期 **/
	//@Transient
	@Column(name = "CREATA_DATE", unique = false, nullable = true, length = 7)
	private Date creataDate;
	
	/** 创建人ID **/
	@Column(name = "CREATE_USER_ID", unique = false, nullable = true, length = 30)
	private String createUserId;
	
	/** 创建人姓名 **/
	@Column(name = "CREATE_USER_NAME", unique = false, nullable = true, length = 80)
	private String createUserName;
	
	
	/**
	 * @param groupNo
	 */
	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo == null ? null : groupNo.trim();
	}
	
    /**
     * @return GroupNo
     */	
	public String getGroupNo() {
		return this.groupNo;
	}
	
	/**
	 * @param groupRootCustId
	 */
	public void setGroupRootCustId(String groupRootCustId) {
		this.groupRootCustId = groupRootCustId == null ? null : groupRootCustId.trim();
	}
	
    /**
     * @return GroupRootCustId
     */	
	public String getGroupRootCustId() {
		return this.groupRootCustId;
	}
	
	/**
	 * @param groupType
	 */
	public void setGroupType(String groupType) {
		this.groupType = groupType == null ? null : groupType.trim();
	}
	
    /**
     * @return GroupType
     */	
	public String getGroupType() {
		return this.groupType;
	}
	
	/**
	 * @param groupStatus
	 */
	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus == null ? null : groupStatus.trim();
	}
	
    /**
     * @return GroupStatus
     */	
	public String getGroupStatus() {
		return this.groupStatus;
	}
	
	/**
	 * @param grpFinanceType
	 */
	public void setGrpFinanceType(String grpFinanceType) {
		this.grpFinanceType = grpFinanceType == null ? null : grpFinanceType.trim();
	}
	
    /**
     * @return GrpFinanceType
     */	
	public String getGrpFinanceType() {
		return this.grpFinanceType;
	}
	
	/**
	 * @param groupMemo
	 */
	public void setGroupMemo(String groupMemo) {
		this.groupMemo = groupMemo == null ? null : groupMemo.trim();
	}
	
    /**
     * @return GroupMemo
     */	
	public String getGroupMemo() {
		return this.groupMemo;
	}
	
	/**
	 * @param groupHostOrgNo
	 */
	public void setGroupHostOrgNo(String groupHostOrgNo) {
		this.groupHostOrgNo = groupHostOrgNo == null ? null : groupHostOrgNo.trim();
	}
	
    /**
     * @return GroupHostOrgNo
     */	
	public String getGroupHostOrgNo() {
		return this.groupHostOrgNo;
	}
	
	/**
	 * @param groupRootAddress
	 */
	public void setGroupRootAddress(String groupRootAddress) {
		this.groupRootAddress = groupRootAddress == null ? null : groupRootAddress.trim();
	}
	
    /**
     * @return GroupRootAddress
     */	
	public String getGroupRootAddress() {
		return this.groupRootAddress;
	}
	
	/**
	 * @param groupNameMain
	 */
	public void setGroupNameMain(String groupNameMain) {
		this.groupNameMain = groupNameMain == null ? null : groupNameMain.trim();
	}
	
    /**
     * @return GroupNameMain
     */	
	public String getGroupNameMain() {
		return this.groupNameMain;
	}
	
	/**
	 * @param gao
	 */
	public void setGao(String gao) {
		this.gao = gao == null ? null : gao.trim();
	}
	
    /**
     * @return Gao
     */	
	public String getGao() {
		return this.gao;
	}
	
	/**
	 * @param creditAmt
	 */
	public void setCreditAmt(java.math.BigDecimal creditAmt) {
		this.creditAmt = creditAmt;
	}
	
    /**
     * @return CreditAmt
     */	
	public java.math.BigDecimal getCreditAmt() {
		return this.creditAmt;
	}
	
	/**
	 * @param creditCur
	 */
	public void setCreditCur(String creditCur) {
		this.creditCur = creditCur == null ? null : creditCur.trim();
	}
	
    /**
     * @return CreditCur
     */	
	public String getCreditCur() {
		return this.creditCur;
	}
	
	/**
	 * @param dueDate
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
    /**
     * @return DueDate
     */	
	public Date getDueDate() {
		return this.dueDate;
	}
	
	/**
	 * @param corpNameSub
	 */
	public void setCorpNameSub(String corpNameSub) {
		this.corpNameSub = corpNameSub == null ? null : corpNameSub.trim();
	}
	
    /**
     * @return CorpNameSub
     */	
	public String getCorpNameSub() {
		return this.corpNameSub;
	}
	
	/**
	 * @param useSituation
	 */
	public void setUseSituation(String useSituation) {
		this.useSituation = useSituation == null ? null : useSituation.trim();
	}
	
    /**
     * @return UseSituation
     */	
	public String getUseSituation() {
		return this.useSituation;
	}
	
	/**
	 * @param addrRegist
	 */
	public void setAddrRegist(String addrRegist) {
		this.addrRegist = addrRegist == null ? null : addrRegist.trim();
	}
	
    /**
     * @return AddrRegist
     */	
	public String getAddrRegist() {
		return this.addrRegist;
	}
	
	/**
	 * @param employeeNum
	 */
	public void setEmployeeNum(long employeeNum) {
		this.employeeNum = employeeNum;
	}
	
    /**
     * @return EmployeeNum
     */	
	public long getEmployeeNum() {
		return this.employeeNum;
	}
	
	/**
	 * @param gurantCusNum
	 */
	public void setGurantCusNum(long gurantCusNum) {
		this.gurantCusNum = gurantCusNum;
	}
	
    /**
     * @return GurantCusNum
     */	
	public long getGurantCusNum() {
		return this.gurantCusNum;
	}
	
	/**
	 * @param employeeNumFormal
	 */
	public void setEmployeeNumFormal(long employeeNumFormal) {
		this.employeeNumFormal = employeeNumFormal;
	}
	
    /**
     * @return EmployeeNumFormal
     */	
	public long getEmployeeNumFormal() {
		return this.employeeNumFormal;
	}
	
	/**
	 * @param pendingMemberNum
	 */
	public void setPendingMemberNum(long pendingMemberNum) {
		this.pendingMemberNum = pendingMemberNum;
	}
	
    /**
     * @return PendingMemberNum
     */	
	public long getPendingMemberNum() {
		return this.pendingMemberNum;
	}
	
	/**
	 * @param externalSecurityNum
	 */
	public void setExternalSecurityNum(long externalSecurityNum) {
		this.externalSecurityNum = externalSecurityNum;
	}
	
    /**
     * @return ExternalSecurityNum
     */	
	public long getExternalSecurityNum() {
		return this.externalSecurityNum;
	}
	
	/**
	 * @param gaoOrg
	 */
	public void setGaoOrg(String gaoOrg) {
		this.gaoOrg = gaoOrg == null ? null : gaoOrg.trim();
	}
	
    /**
     * @return GaoOrg
     */	
	public String getGaoOrg() {
		return this.gaoOrg;
	}
	
	/**
	 * @param groupForm
	 */
	public void setGroupForm(String groupForm) {
		this.groupForm = groupForm == null ? null : groupForm.trim();
	}
	
    /**
     * @return GroupForm
     */	
	public String getGroupForm() {
		return this.groupForm;
	}
	
	/**
	 * @param usedAmt
	 */
	public void setUsedAmt(java.math.BigDecimal usedAmt) {
		this.usedAmt = usedAmt;
	}
	
    /**
     * @return UsedAmt
     */	
	public java.math.BigDecimal getUsedAmt() {
		return this.usedAmt;
	}
	
	/**
	 * @param loanBalance
	 */
	public void setLoanBalance(java.math.BigDecimal loanBalance) {
		this.loanBalance = loanBalance;
	}
	
    /**
     * @return LoanBalance
     */	
	public java.math.BigDecimal getLoanBalance() {
		return this.loanBalance;
	}
	
	/**
	 * @param badLoanBalance
	 */
	public void setBadLoanBalance(java.math.BigDecimal badLoanBalance) {
		this.badLoanBalance = badLoanBalance;
	}
	
    /**
     * @return BadLoanBalance
     */	
	public java.math.BigDecimal getBadLoanBalance() {
		return this.badLoanBalance;
	}
	
	/**
	 * @param guaranteeType
	 */
	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType == null ? null : guaranteeType.trim();
	}
	
    /**
     * @return GuaranteeType
     */	
	public String getGuaranteeType() {
		return this.guaranteeType;
	}
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(Date dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return dataDate
     */	
	public Date getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param createUserOrgId
	 */
	public void setCreateUserOrgId(String createUserOrgId) {
		this.createUserOrgId = createUserOrgId == null ? null : createUserOrgId.trim();
	}
	
    /**
     * @return CreateUserOrgId
     */	
	public String getCreateUserOrgId() {
		return this.createUserOrgId;
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
	 * @param updateUserId
	 */
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId == null ? null : updateUserId.trim();
	}
	
    /**
     * @return UpdateUserId
     */	
	public String getUpdateUserId() {
		return this.updateUserId;
	}
	
	/**
	 * @param creataDate
	 */
	public void setCreataDate(Date creataDate) {
		this.creataDate = creataDate;
	}
	
    /**
     * @return CreataDate
     */	
	public Date getCreataDate() {
		return this.creataDate;
	}
	
	/**
	 * @param createUserId
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId == null ? null : createUserId.trim();
	}
	
    /**
     * @return CreateUserId
     */	
	public String getCreateUserId() {
		return this.createUserId;
	}
	
	/**
	 * @param createUserName
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName == null ? null : createUserName.trim();
	}
	
    /**
     * @return CreateUserName
     */	
	public String getCreateUserName() {
		return this.createUserName;
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
        OcrmFciGroup other = (OcrmFciGroup) that;
		return (this.getGroupNo() == null ? other.getGroupNo() == null : this.getGroupNo().equals(other.getGroupNo()))
        	&& (this.getGroupRootCustId() == null ? other.getGroupRootCustId() == null : this.getGroupRootCustId().equals(other.getGroupRootCustId()))
        	&& (this.getGroupType() == null ? other.getGroupType() == null : this.getGroupType().equals(other.getGroupType()))
        	&& (this.getGroupStatus() == null ? other.getGroupStatus() == null : this.getGroupStatus().equals(other.getGroupStatus()))
        	&& (this.getGrpFinanceType() == null ? other.getGrpFinanceType() == null : this.getGrpFinanceType().equals(other.getGrpFinanceType()))
        	&& (this.getGroupMemo() == null ? other.getGroupMemo() == null : this.getGroupMemo().equals(other.getGroupMemo()))
        	&& (this.getGroupHostOrgNo() == null ? other.getGroupHostOrgNo() == null : this.getGroupHostOrgNo().equals(other.getGroupHostOrgNo()))
        	&& (this.getGroupRootAddress() == null ? other.getGroupRootAddress() == null : this.getGroupRootAddress().equals(other.getGroupRootAddress()))
        	&& (this.getGroupNameMain() == null ? other.getGroupNameMain() == null : this.getGroupNameMain().equals(other.getGroupNameMain()))
        	&& (this.getGao() == null ? other.getGao() == null : this.getGao().equals(other.getGao()))
                	&& (this.getCreditCur() == null ? other.getCreditCur() == null : this.getCreditCur().equals(other.getCreditCur()))
                	&& (this.getCorpNameSub() == null ? other.getCorpNameSub() == null : this.getCorpNameSub().equals(other.getCorpNameSub()))
        	&& (this.getUseSituation() == null ? other.getUseSituation() == null : this.getUseSituation().equals(other.getUseSituation()))
        	&& (this.getAddrRegist() == null ? other.getAddrRegist() == null : this.getAddrRegist().equals(other.getAddrRegist()))
                                                	&& (this.getGaoOrg() == null ? other.getGaoOrg() == null : this.getGaoOrg().equals(other.getGaoOrg()))
        	&& (this.getGroupForm() == null ? other.getGroupForm() == null : this.getGroupForm().equals(other.getGroupForm()))
                                	&& (this.getGuaranteeType() == null ? other.getGuaranteeType() == null : this.getGuaranteeType().equals(other.getGuaranteeType()))
                	&& (this.getCreateUserOrgId() == null ? other.getCreateUserOrgId() == null : this.getCreateUserOrgId().equals(other.getCreateUserOrgId()))
                	&& (this.getUpdateUserId() == null ? other.getUpdateUserId() == null : this.getUpdateUserId().equals(other.getUpdateUserId()))
                	&& (this.getCreateUserId() == null ? other.getCreateUserId() == null : this.getCreateUserId().equals(other.getCreateUserId()))
        	&& (this.getCreateUserName() == null ? other.getCreateUserName() == null : this.getCreateUserName().equals(other.getCreateUserName()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGroupNo() == null) ? 0 : getGroupNo().hashCode());
        result = prime * result + ((getGroupRootCustId() == null) ? 0 : getGroupRootCustId().hashCode());
        result = prime * result + ((getGroupType() == null) ? 0 : getGroupType().hashCode());
        result = prime * result + ((getGroupStatus() == null) ? 0 : getGroupStatus().hashCode());
        result = prime * result + ((getGrpFinanceType() == null) ? 0 : getGrpFinanceType().hashCode());
        result = prime * result + ((getGroupMemo() == null) ? 0 : getGroupMemo().hashCode());
        result = prime * result + ((getGroupHostOrgNo() == null) ? 0 : getGroupHostOrgNo().hashCode());
        result = prime * result + ((getGroupRootAddress() == null) ? 0 : getGroupRootAddress().hashCode());
        result = prime * result + ((getGroupNameMain() == null) ? 0 : getGroupNameMain().hashCode());
        result = prime * result + ((getGao() == null) ? 0 : getGao().hashCode());
        result = prime * result + ((getCreditCur() == null) ? 0 : getCreditCur().hashCode());
        result = prime * result + ((getCorpNameSub() == null) ? 0 : getCorpNameSub().hashCode());
        result = prime * result + ((getUseSituation() == null) ? 0 : getUseSituation().hashCode());
        result = prime * result + ((getAddrRegist() == null) ? 0 : getAddrRegist().hashCode());
        result = prime * result + ((getGaoOrg() == null) ? 0 : getGaoOrg().hashCode());
        result = prime * result + ((getGroupForm() == null) ? 0 : getGroupForm().hashCode());
        result = prime * result + ((getGuaranteeType() == null) ? 0 : getGuaranteeType().hashCode());
        result = prime * result + ((getCreateUserOrgId() == null) ? 0 : getCreateUserOrgId().hashCode());
        result = prime * result + ((getUpdateUserId() == null) ? 0 : getUpdateUserId().hashCode());
        result = prime * result + ((getCreateUserId() == null) ? 0 : getCreateUserId().hashCode());
        result = prime * result + ((getCreateUserName() == null) ? 0 : getCreateUserName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", groupNo=").append(groupNo);
		sb.append(", groupRootCustId=").append(groupRootCustId);
		sb.append(", groupType=").append(groupType);
		sb.append(", groupStatus=").append(groupStatus);
		sb.append(", grpFinanceType=").append(grpFinanceType);
		sb.append(", groupMemo=").append(groupMemo);
		sb.append(", groupHostOrgNo=").append(groupHostOrgNo);
		sb.append(", groupRootAddress=").append(groupRootAddress);
		sb.append(", groupNameMain=").append(groupNameMain);
		sb.append(", gao=").append(gao);
		sb.append(", creditAmt=").append(creditAmt);
		sb.append(", creditCur=").append(creditCur);
		sb.append(", dueDate=").append(dueDate);
		sb.append(", corpNameSub=").append(corpNameSub);
		sb.append(", useSituation=").append(useSituation);
		sb.append(", addrRegist=").append(addrRegist);
		sb.append(", employeeNum=").append(employeeNum);
		sb.append(", gurantCusNum=").append(gurantCusNum);
		sb.append(", employeeNumFormal=").append(employeeNumFormal);
		sb.append(", pendingMemberNum=").append(pendingMemberNum);
		sb.append(", externalSecurityNum=").append(externalSecurityNum);
		sb.append(", gaoOrg=").append(gaoOrg);
		sb.append(", groupForm=").append(groupForm);
		sb.append(", usedAmt=").append(usedAmt);
		sb.append(", loanBalance=").append(loanBalance);
		sb.append(", badLoanBalance=").append(badLoanBalance);
		sb.append(", guaranteeType=").append(guaranteeType);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", createUserOrgId=").append(createUserOrgId);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateUserId=").append(updateUserId);
		sb.append(", creataDate=").append(creataDate);
		sb.append(", createUserId=").append(createUserId);
		sb.append(", createUserName=").append(createUserName);
        sb.append("]");
        return sb.toString();
    }
}