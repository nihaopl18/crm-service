package cn.com.yusys.yusp.uimp.base.domain;

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
 * @项目名称: uimp-app-base-core模块
 * @类名称: PmaFremindRule
 * @类描述: PMA_F_REMIND_RULE信息提醒规则表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-07-06 10:02:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_REMIND_RULE")
public class PmaFremindRule extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 规则编号(序列号) **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 规则类别编号 **/
	@Column(name = "RULE_ID", unique = false, nullable = true, length = 32)
	private String ruleId;
	
	/** 规则类别名称 **/
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
	
	/** 提醒提前天数 **/
	@Column(name = "BEFORE_DAYS", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal beforeDays;
	
	/** 提醒持续天数 **/
	@Column(name = "LAST_DAYS", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal lastDays;
	
	/** 创建人编号 **/
	@Column(name = "CRAT_USER", unique = false, nullable = true, length = 32)
	private String cratUser;
	
	/** 创建机构编号 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 32)
	private String cratOrgId;
	
	/** 创建日期 **/
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 最新更新人编号 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 32)
	private String lastChgUsr;
	
	/** 最新更新机构编号 **/
	@Column(name = "LAST_CHG_ORG_ID", unique = false, nullable = true, length = 32)
	private String lastChgOrgId;
	
	/** 最新更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 是否启用 **/
	@Column(name = "IS_ENABLE", unique = false, nullable = true, length = 20)
	private String isEnable;
	
	/** 变动阀值 **/
	@Column(name = "THRESHHOLD", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal threshhold;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getReceRoleId() {
		return receRoleId;
	}

	public void setReceRoleId(String receRoleId) {
		this.receRoleId = receRoleId;
	}

	public String getReceRoleName() {
		return receRoleName;
	}

	public void setReceRoleName(String receRoleName) {
		this.receRoleName = receRoleName;
	}

	public String getAdjustOrgId() {
		return adjustOrgId;
	}

	public void setAdjustOrgId(String adjustOrgId) {
		this.adjustOrgId = adjustOrgId;
	}

	public String getAdjustOrgName() {
		return adjustOrgName;
	}

	public void setAdjustOrgName(String adjustOrgName) {
		this.adjustOrgName = adjustOrgName;
	}

	public java.math.BigDecimal getBeforeDays() {
		return beforeDays;
	}

	public void setBeforeDays(java.math.BigDecimal beforeDays) {
		this.beforeDays = beforeDays;
	}

	public java.math.BigDecimal getLastDays() {
		return lastDays;
	}

	public void setLastDays(java.math.BigDecimal lastDays) {
		this.lastDays = lastDays;
	}

	public String getCratUser() {
		return cratUser;
	}

	public void setCratUser(String cratUser) {
		this.cratUser = cratUser;
	}

	public String getCratOrgId() {
		return cratOrgId;
	}

	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId;
	}

	public Date getCratDt() {
		return cratDt;
	}

	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}

	public String getLastChgUsr() {
		return lastChgUsr;
	}

	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr;
	}

	public String getLastChgOrgId() {
		return lastChgOrgId;
	}

	public void setLastChgOrgId(String lastChgOrgId) {
		this.lastChgOrgId = lastChgOrgId;
	}

	public Date getLastChgDt() {
		return lastChgDt;
	}

	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public java.math.BigDecimal getThreshhold() {
		return threshhold;
	}

	public void setThreshhold(java.math.BigDecimal threshhold) {
		this.threshhold = threshhold;
	}
	
}