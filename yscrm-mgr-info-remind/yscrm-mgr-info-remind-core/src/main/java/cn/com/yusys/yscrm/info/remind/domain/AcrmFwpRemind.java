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
 * @类名称: AcrmFwpRemind
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-02-20 14:09:15
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_WP_REMIND")
public class AcrmFwpRemind extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 信息提醒编号 **/
	@Id
	@Column(name = "INFO_ID")
	@Generated(GenerationType.UUID)
	private String infoId;

	/** 规则编号 **/
	@Column(name = "RULE_ID", unique = false, nullable = true, length = 32)
	private String ruleId;

	/** 规则大类名称 **/
	@Column(name = "RULE_NAME", unique = false, nullable = true, length = 200)
	private String ruleName;

	/** 规则类别编号 **/
	@Column(name = "TYPE_ID", unique = false, nullable = true, length = 200)
	private String typeId;

	/** 规则类别名称 **/
	@Column(name = "TYPE_NAME", unique = false, nullable = true, length = 200)
	private String typeName;

	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;

	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;

	/** 提醒接收人 **/
	@Column(name = "RECE_USER", unique = false, nullable = true, length = 500)
	private String receUser;

	/** 提醒生成日期 **/
	@Column(name = "REMIND_CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date remindCreateDate;

	/** 提醒到期日期 **/

	@Column(name = "REMIND_EXPIRE_DATE", unique = false, nullable = true, length = 7)
	private Date remindExpireDate;

	/** 其它内容 **/
	@Column(name = "OTHER_CONTENT", unique = false, nullable = true, length = 800)
	private String otherContent;

	/** 最新更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;

	/** 最新更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;

	/** 状态 **/
	@Column(name = "STATE", unique = false, nullable = true, length = 4)
	private String state;

	/** 最新更新时间 **/
	@Column(name = "AMT", unique = false, nullable = true, length = 30)
	private String amt;

	/** 重要日期 **/
	@Column(name = "IMPORT_DATE", unique = false, nullable = true, length = 7)
	private Date importDate;

	/** 客户等级 **/
	@Column(name = "CUST_GRADE", unique = false, nullable = true, length = 10)
	private String custGrade;

	/**机构ID**/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 45)
	private String orgId;

	/**操作**/
	@Column(name = "OPERATION", unique = false, nullable = true, length = 45)
	private String operation;
	
	/**
	 * @param orgId
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}

	/**
	 * @return orgId
	 */
	public String getOrgId() {
		return this.orgId;
	}
	
	/**
	 * @param infoId
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId == null ? null : infoId.trim();
	}

	/**
	 * @return InfoId
	 */
	public String getInfoId() {
		return this.infoId;
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
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}

	/**
	 * @return CustId
	 */
	public String getCustId() {
		return this.custId;
	}

	/**
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}

	/**
	 * @return CustName
	 */
	public String getCustName() {
		return this.custName;
	}

	/**
	 * @param receUser
	 */
	public void setReceUser(String receUser) {
		this.receUser = receUser == null ? null : receUser.trim();
	}

	/**
	 * @return ReceUser
	 */
	public String getReceUser() {
		return this.receUser;
	}

	/**
	 * @param remindCreateDate
	 */
	public void setRemindCreateDate(Date remindCreateDate) {
		this.remindCreateDate = remindCreateDate;
	}

	/**
	 * @return RemindCreateDate
	 */
	public Date getRemindCreateDate() {
		return this.remindCreateDate;
	}

	/**
	 * @param remindExpireDate
	 */
	public void setRemindExpireDate(Date remindExpireDate) {
		this.remindExpireDate = remindExpireDate;
	}

	/**
	 * @return RemindExpireDate
	 */
	public Date getRemindExpireDate() {
		return this.remindExpireDate;
	}

	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}

	/**
	 * @return LastChgUsr
	 */
	public String getLastChgUsr() {
		return this.lastChgUsr;
	}

	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}

	/**
	 * @return LastChgDt
	 */
	public Date getLastChgDt() {
		return this.lastChgDt;
	}

	public String getTypeId() {
		return typeId = typeId == null ? null : typeId.trim();
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName == null ? null : typeName.trim();
	}

	/**
	 * @return otherContent
	 */
	public String getOtherContent() {
		return otherContent;
	}

	/**
	 * @param otherContent
	 *            要设置的 otherContent
	 */
	public void setOtherContent(String otherContent) {
		this.otherContent = otherContent == null ? null : otherContent.trim();
	}

	/**
	 * @return state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            要设置的 state
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	/**
	 * @return amt
	 */
	public String getAmt() {
		return amt;
	}

	/**
	 * @param amt
	 *            要设置的 amt
	 */
	public void setAmt(String amt) {
		this.amt = amt == null ? null : amt.trim();
	}

	/**
	 * @return importDate
	 */
	public Date getImportDate() {
		return importDate;
	}

	/**
	 * @param importDate
	 *            要设置的 importDate
	 */
	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public String getOperation() { return operation; }

	public void setOperation(String operation) { this.operation = operation == null ? null : operation; }

	public String getCustGrade() {
		return custGrade;
	}

	public void setCustGrade(String custGrade) {
		this.custGrade = custGrade == null ? null: custGrade.trim();
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
		AcrmFwpRemind other = (AcrmFwpRemind) that;
		return (this.getInfoId() == null ? other.getInfoId() == null : this.getInfoId().equals(other.getInfoId()))
				&& (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
				&& (this.getRuleName() == null ? other.getRuleName() == null
						: this.getRuleName().equals(other.getRuleName()))
				&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
				&& (this.getCustName() == null ? other.getCustName() == null
						: this.getCustName().equals(other.getCustName()))
				&& (this.getReceUser() == null ? other.getReceUser() == null
						: this.getReceUser().equals(other.getReceUser()))
				&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null
						: this.getLastChgUsr().equals(other.getLastChgUsr()))
				&& (this.getAmt() == null ? other.getAmt() == null : this.getAmt().equals(other.getAmt()))
				&& (this.getOtherContent() == null ? other.getOtherContent() == null
						: this.getOtherContent().equals(other.getOtherContent()))
				&& (this.getTypeName() == null ? other.getTypeName() == null
						: this.getTypeName().equals(other.getTypeName()))
				&& (this.getTypeId() == null ? other.getTypeId() == null : this.getTypeId().equals(other.getTypeId()))
				&& (this.getState() == null ? other.getState() == null : this.getState().equals(other.getState()))
				&& (this.getOrgId() == null ? other.getOrgId() == null : this.getOrgId().equals(other.getOrgId()))
				&& (this.getCustGrade() == null ? other.getCustGrade() == null : this.getCustGrade().equals(other.getCustGrade()))
				&& (this.getOperation() == null ? other.getOperation() == null : this.getOperation().equals(other.getOperation()));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getInfoId() == null) ? 0 : getInfoId().hashCode());
		result = prime * result + ((getOrgId() == null) ? 0 : getOrgId().hashCode());
		result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
		result = prime * result + ((getRuleName() == null) ? 0 : getRuleName().hashCode());
		result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
		result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
		result = prime * result + ((getReceUser() == null) ? 0 : getReceUser().hashCode());
		result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
		result = prime * result + ((getAmt() == null) ? 0 : getAmt().hashCode());
		result = prime * result + ((getOtherContent() == null) ? 0 : getOtherContent().hashCode());
		result = prime * result + ((getState() == null) ? 0 : getState().hashCode());
		result = prime * result + ((getTypeId() == null) ? 0 : getTypeId().hashCode());
		result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
		result = prime * result + ((getCustGrade() == null) ? 0 : getCustGrade().hashCode());
		result = prime * result + ((getOperation() == null) ? 0 : getOperation().hashCode());
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName());
		sb.append("[");
		sb.append("Hash = ").append(hashCode());
		sb.append(", infoId=").append(infoId);
		sb.append(", orgId=").append(orgId);
		sb.append(", ruleId=").append(ruleId);
		sb.append(", ruleName=").append(ruleName);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", receUser=").append(receUser);
		sb.append(", remindCreateDate=").append(remindCreateDate);
		sb.append(", remindExpireDate=").append(remindExpireDate);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", amt=").append(amt);
		sb.append(", otherContent=").append(otherContent);
		sb.append(", state=").append(state);
		sb.append(", typeId=").append(typeId);
		sb.append(", typeName=").append(typeName);
		sb.append(", custGrade=").append(custGrade);
		sb.append(", operation=").append(operation);
		sb.append("]");
		return sb.toString();
	}
}