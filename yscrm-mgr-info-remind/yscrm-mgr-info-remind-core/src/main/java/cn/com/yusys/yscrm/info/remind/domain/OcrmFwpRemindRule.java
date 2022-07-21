package cn.com.yusys.yscrm.info.remind.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: OcrmFwpRemindRule
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Bronze
 * @创建时间: 2019-03-11 14:25:09
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_REMIND_RULE")
public class OcrmFwpRemindRule extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 规则编号 **/
	@Id
	@Column(name = "RULE_ID")
	@Generated(GenerationType.UUID)
	private String ruleId;
	
	/** 规则类别编号 **/
	@Column(name = "TYPE_ID", unique = false, nullable = true, length = 32)
	private String typeId;
	
	/** 规则名称 **/
	@Column(name = "RULE_NAME", unique = false, nullable = true, length = 100)
	private String ruleName;
	
	/** 接收角色编号 **/
	@Column(name = "RECE_ROLE_ID", unique = false, nullable = true, length = 32)
	private String receRoleId;
	
	/** 接收角色名称 **/
	@Column(name = "RECE_ROLE_NAME", unique = false, nullable = true, length = 100)
	private String receRoleName;
	
	/** 适用机构号 **/
	@Column(name = "ADJUST_ORG_ID", unique = false, nullable = true, length = 32)
	private String adjustOrgId;
	
	/** 适用机构名称 **/
	@Column(name = "ADJUST_ORG_NAME", unique = false, nullable = true, length = 100)
	private String adjustOrgName;
	
	/** 对公基线层级 **/
	@Column(name = "ORG_CUST_LEVEL", unique = false, nullable = true, length = 32)
	private String orgCustLevel;
	
	/** 个人基线层级 **/
	@Column(name = "PER_CUST_LEVEL", unique = false, nullable = true, length = 32)
	private String perCustLevel;
	
	/** 客户类型 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 20)
	private String custType;
	
	/** 提醒提前天数 **/
	@Column(name = "BEFORE_DAYS", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal beforeDays;
	
	/** 提醒持续天数 **/
	@Column(name = "LAST_DAYS", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastDays;
	
	/** 对公变动阀值 **/
	@Column(name = "ORG_THRESHHOLD", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal orgThreshhold;
	
	/** 个人变动阀值 **/
	@Column(name = "PER_THRESHHOLD", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal perThreshhold;
	
	/** 信息提醒模板 **/
	@Column(name = "REMIND_MODEL", unique = false, nullable = true, length = 800)
	private String remindModel;
	
	/** 是否批量勾选客户发短信 **/
	@Column(name = "IS_BATCH_MESS", unique = false, nullable = true, length = 20)
	private String isBatchMess;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 32)
	private String createUser;
	
	/** 创建人机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 20)
	private String createOrg;
	
	/** 创建日期 **/
	@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 32)
	private String updateUser;
	
	/** 修改人机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 20)
	private String updateOrg;
	
	/** 修改日期 **/
	@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 是否启用 **/
	@Column(name = "IS_ENABLE", unique = false, nullable = true, length = 20)
	private String isEnable;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 数据日期 **/
	@Transient
	@Column(name = "ETL_DATE", unique = false, nullable = true, length = 7)
	private Date etlDate;
	
	private String isSendMes;
	
	private String messageModel;
	
	public String getIsSendMes() {
		return isSendMes;
	}

	public void setIsSendMes(String isSendMes) {
		this.isSendMes = isSendMes;
	}

	public String getMessageModel() {
		return messageModel;
	}

	public void setMessageModel(String messageModel) {
		this.messageModel = messageModel;
	}
	
	/**
	 * @param ruleId
	 */
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId == null ? null : ruleId.trim();
	}
	
    /**
     * @return RuleId
     */	
	public String getRuleId() {
		return this.ruleId;
	}
	
	/**
	 * @param typeId
	 */
	public void setTypeId(String typeId) {
		this.typeId = typeId == null ? null : typeId.trim();
	}
	
    /**
     * @return TypeId
     */	
	public String getTypeId() {
		return this.typeId;
	}
	
	/**
	 * @param ruleName
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName == null ? null : ruleName.trim();
	}
	
    /**
     * @return RuleName
     */	
	public String getRuleName() {
		return this.ruleName;
	}
	
	/**
	 * @param receRoleId
	 */
	public void setReceRoleId(String receRoleId) {
		this.receRoleId = receRoleId == null ? null : receRoleId.trim();
	}
	
    /**
     * @return ReceRoleId
     */	
	public String getReceRoleId() {
		return this.receRoleId;
	}
	
	/**
	 * @param receRoleName
	 */
	public void setReceRoleName(String receRoleName) {
		this.receRoleName = receRoleName == null ? null : receRoleName.trim();
	}
	
    /**
     * @return ReceRoleName
     */	
	public String getReceRoleName() {
		return this.receRoleName;
	}
	
	/**
	 * @param adjustOrgId
	 */
	public void setAdjustOrgId(String adjustOrgId) {
		this.adjustOrgId = adjustOrgId == null ? null : adjustOrgId.trim();
	}
	
    /**
     * @return AdjustOrgId
     */	
	public String getAdjustOrgId() {
		return this.adjustOrgId;
	}
	
	/**
	 * @param adjustOrgName
	 */
	public void setAdjustOrgName(String adjustOrgName) {
		this.adjustOrgName = adjustOrgName == null ? null : adjustOrgName.trim();
	}
	
    /**
     * @return AdjustOrgName
     */	
	public String getAdjustOrgName() {
		return this.adjustOrgName;
	}
	
	/**
	 * @param orgCustLevel
	 */
	public void setorgCustLevel(String orgCustLevel) {
		this.orgCustLevel = orgCustLevel == null ? null : orgCustLevel.trim();
	}
	
    /**
     * @return OrgCustLevel
     */	
	public String getOrgCustLevel() {
		return this.orgCustLevel;
	}
	
	/**
	 * @param perCustLevel
	 */
	public void setPerCustLevel(String perCustLevel) {
		this.perCustLevel = perCustLevel == null ? null : perCustLevel.trim();
	}
	
    /**
     * @return PerCustLevel
     */	
	public String getPerCustLevel() {
		return this.perCustLevel;
	}
	
	/**
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	
    /**
     * @return CustType
     */	
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * @param beforeDays
	 */
	public void setBeforeDays(java.math.BigDecimal beforeDays) {
		this.beforeDays = beforeDays;
	}
	
    /**
     * @return BeforeDays
     */	
	public java.math.BigDecimal getBeforeDays() {
		return this.beforeDays;
	}
	
	/**
	 * @param lastDays
	 */
	public void setLastDays(java.math.BigDecimal lastDays) {
		this.lastDays = lastDays;
	}
	
    /**
     * @return LastDays
     */	
	public java.math.BigDecimal getLastDays() {
		return this.lastDays;
	}
	
	/**
	 * @param orgThreshhold
	 */
	public void setOrgThreshhold(java.math.BigDecimal orgThreshhold) {
		this.orgThreshhold = orgThreshhold;
	}
	
    /**
     * @return OrgThreshhold
     */	
	public java.math.BigDecimal getOrgThreshhold() {
		return this.orgThreshhold;
	}
	
	/**
	 * @param perThreshhold
	 */
	public void setPerThreshhold(java.math.BigDecimal perThreshhold) {
		this.perThreshhold = perThreshhold;
	}
	
    /**
     * @return PerThreshhold
     */	
	public java.math.BigDecimal getPerThreshhold() {
		return this.perThreshhold;
	}
	
	/**
	 * @param remindModel
	 */
	public void setRemindModel(String remindModel) {
		this.remindModel = remindModel == null ? null : remindModel.trim();
	}
	
    /**
     * @return RemindModel
     */	
	public String getRemindModel() {
		return this.remindModel;
	}
	
	/**
	 * @param isBatchMess
	 */
	public void setIsBatchMess(String isBatchMess) {
		this.isBatchMess = isBatchMess == null ? null : isBatchMess.trim();
	}
	
    /**
     * @return IsBatchMess
     */	
	public String getIsBatchMess() {
		return this.isBatchMess;
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
	 * @param isEnable
	 */
	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable == null ? null : isEnable.trim();
	}
	
    /**
     * @return IsEnable
     */	
	public String getIsEnable() {
		return this.isEnable;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}
	
	/**
	 * @param etlDate
	 */
	public void setEtlDate(Date etlDate) {
		this.etlDate = etlDate;
	}
	
    /**
     * @return EtlDate
     */	
	public Date getEtlDate() {
		return this.etlDate;
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
        OcrmFwpRemindRule other = (OcrmFwpRemindRule) that;
		return (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
        	&& (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
        	&& (this.getRuleName() == null ? other.getRuleName() == null : this.getRuleName().equals(other.getRuleName()))
        	&& (this.getReceRoleId() == null ? other.getReceRoleId() == null : this.getReceRoleId().equals(other.getReceRoleId()))
        	&& (this.getReceRoleName() == null ? other.getReceRoleName() == null : this.getReceRoleName().equals(other.getReceRoleName()))
        	&& (this.getAdjustOrgId() == null ? other.getAdjustOrgId() == null : this.getAdjustOrgId().equals(other.getAdjustOrgId()))
        	&& (this.getAdjustOrgName() == null ? other.getAdjustOrgName() == null : this.getAdjustOrgName().equals(other.getAdjustOrgName()))
        	&& (this.getOrgCustLevel() == null ? other.getOrgCustLevel() == null : this.getOrgCustLevel().equals(other.getOrgCustLevel()))
        	&& (this.getPerCustLevel() == null ? other.getPerCustLevel() == null : this.getPerCustLevel().equals(other.getPerCustLevel()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
                                        	&& (this.getRemindModel() == null ? other.getRemindModel() == null : this.getRemindModel().equals(other.getRemindModel()))
        	&& (this.getIsBatchMess() == null ? other.getIsBatchMess() == null : this.getIsBatchMess().equals(other.getIsBatchMess()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
        	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
                	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
        	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
                	&& (this.getIsEnable() == null ? other.getIsEnable() == null : this.getIsEnable().equals(other.getIsEnable()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
        result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
        result = prime * result + ((getReceRoleId() == null) ? 0 : getReceRoleId().hashCode());
        result = prime * result + ((getReceRoleName() == null) ? 0 : getReceRoleName().hashCode());
        result = prime * result + ((getAdjustOrgId() == null) ? 0 : getAdjustOrgId().hashCode());
        result = prime * result + ((getAdjustOrgName() == null) ? 0 : getAdjustOrgName().hashCode());
        result = prime * result + ((getOrgCustLevel() == null) ? 0 : getOrgCustLevel().hashCode());
        result = prime * result + ((getPerCustLevel() == null) ? 0 : getPerCustLevel().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getRemindModel() == null) ? 0 : getRemindModel().hashCode());
        result = prime * result + ((getIsBatchMess() == null) ? 0 : getIsBatchMess().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getIsEnable() == null) ? 0 : getIsEnable().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", ruleId=").append(ruleId);
		sb.append(", typeId=").append(typeId);
		sb.append(", ruleName=").append(ruleName);
		sb.append(", receRoleId=").append(receRoleId);
		sb.append(", receRoleName=").append(receRoleName);
		sb.append(", adjustOrgId=").append(adjustOrgId);
		sb.append(", adjustOrgName=").append(adjustOrgName);
		sb.append(", orgCustLevel=").append(orgCustLevel);
		sb.append(", perCustLevel=").append(perCustLevel);
		sb.append(", custType=").append(custType);
		sb.append(", beforeDays=").append(beforeDays);
		sb.append(", lastDays=").append(lastDays);
		sb.append(", orgThreshhold=").append(orgThreshhold);
		sb.append(", perThreshhold=").append(perThreshhold);
		sb.append(", remindModel=").append(remindModel);
		sb.append(", isBatchMess=").append(isBatchMess);
		sb.append(", createUser=").append(createUser);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", createDate=").append(createDate);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateOrg=").append(updateOrg);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", isEnable=").append(isEnable);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", etlDate=").append(etlDate);
        sb.append("]");
        return sb.toString();
    }
}