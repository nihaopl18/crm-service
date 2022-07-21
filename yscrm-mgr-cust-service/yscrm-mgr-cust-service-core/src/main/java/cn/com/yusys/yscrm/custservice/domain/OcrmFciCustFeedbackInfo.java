/*
 * 代码生成器自动生成的
 * Since 2008 - 2019
 *
 */
package cn.com.yusys.yscrm.custservice.domain;


import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.sql.Clob;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @项目名称: demo模块
 * @类名称: OcrmFciCustFeedbackInfo
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: 23378
 * @创建时间: 2019-02-11 16:49:43
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Table(name = "OCRM_F_CI_CUST_FEEDBACK_INFO")
public class OcrmFciCustFeedbackInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 反馈ID **/
	@Id
	@Column(name = "FEEDBACK_ID")
	@Generated(GenerationType.UUID)
	private String feedbackId;
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE")
	private String corpOrgCode;

	/** 客户号 **/
	@Column(name = "CUST_ID")
	private String custId;

	/** 客户名称 **/
	@Column(name = "CUST_NAME")
	private String custName;

	/** 反馈类型 **/
	@Column(name = "FEEDBACK_TYPE")
	private String feedbackType;

	/** 反馈渠道 **/
	@Column(name = "FEEDBACK_CHG")
	private String feedbackChg;

	/** 工单来源 **/
	@Column(name = "WORK_ORDER_SOURCE")
	private String workOrderSource;

	/** 反馈内容 **/
	@Column(name = "FEEDBACK_CONTENT")
	private String feedbackContent;

	/** 紧急程度 **/
	@Column(name = "EMERGENCY_LEVEL")
	private String emergencyLevel;

	/** 处理有效期 **/
	@Column(name = "EXPIRY_DATE")
	private Date expiryDate;

	/** 处理人编号 **/
	@Column(name = "CONDUCTOR_ID")
	private String conductorId;

	/** 处理人名称 **/
	@Column(name = "CONDUCTOR_NAME")
	private String conductorName;

	/** 待处理机构编号 **/
	@Column(name = "CONDUCTOR_ORG_ID")
	private String conductorOrgId;

	/** 待处理机构名称 **/
	@Column(name = "CONDUCTOR_ORG_NAME")
	private String conductorOrgName;

	/** 处理所需资源 **/
	@Column(name = "NEED_RESOURCE")
	private String needResource;

	/** 客户卡号/账号 **/
	@Column(name = "ACCT_NO")
	private String acctNo;

	/** 客户联系电话 **/
	@Column(name = "CUST_PHONE_NO")
	private String custPhoneNo;

	/** 客户性别 **/
	@Column(name = "CUST_SEX")
	private String custSex;

	/** 被投诉员工工号 **/
	@Column(name = "COMPLAIN_EMP_ID")
	private String complainEmpId;

	/** 被投诉员工姓名 **/
	@Column(name = "COMPLAIN_EMP_NAME")
	private String complainEmpName;

	/** 投诉内同 **/
	@Column(name = "COMPLAIN_CONTENT")
	private String complainContent;

	/** 支行调查结果 **/
	@Column(name = "CHECK_RESULT")
	private String checkResult;

	/** 处理时间 **/
	@Column(name = "CONDUCT_TM")
	private String conductTm;

	/** 附件 **/
	@Column(name = "ADJUNCT")
	private Timestamp adjunct;

	/** 是否已处理 **/
	@Column(name = "IS_PROCESSED")
	private String isProcessed;

	/** 反馈标题 **/
	@Column(name = "FEEDBACK_TITLE")
	private String feedbackTitle;

	/** 反馈日期 **/
	@Column(name = "FEEDBACK_DATE")
	private Date feedbackDate;

	/** 是否小企业客户 **/
	@Column(name = "IS_PEANUTS")
	private String isPeanuts;

	/** 反馈人 **/
	@Column(name = "FEEDBACK_PER")
	private String feedbackPer;
	
	@Column(name = "FEEDBACK_PER_ID")
	private String feedbackPerId;

	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode;
	}

	/**
	 * @return corpOrgCode
	 */
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}

	/**
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}

	/**
	 * @return custId
	 */
	public String getCustId() {
		return this.custId;
	}

	/**
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return custName
	 */
	public String getCustName() {
		return this.custName;
	}

	/**
	 * @param feedbackType
	 */
	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType;
	}

	/**
	 * @return feedbackType
	 */
	public String getFeedbackType() {
		return this.feedbackType;
	}

	/**
	 * @param feedbackChg
	 */
	public void setFeedbackChg(String feedbackChg) {
		this.feedbackChg = feedbackChg;
	}

	/**
	 * @return feedbackChg
	 */
	public String getFeedbackChg() {
		return this.feedbackChg;
	}

	/**
	 * @param feedbackId
	 */
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}

	/**
	 * @return feedbackId
	 */
	public String getFeedbackId() {
		return this.feedbackId;
	}

	/**
	 * @param workOrderSource
	 */
	public void setWorkOrderSource(String workOrderSource) {
		this.workOrderSource = workOrderSource;
	}

	/**
	 * @return workOrderSource
	 */
	public String getWorkOrderSource() {
		return this.workOrderSource;
	}

	/**
	 * @param feedbackContent
	 */
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent;
	}

	/**
	 * @return feedbackContent
	 */
	public String getFeedbackContent() {
		return this.feedbackContent;
	}

	/**
	 * @param emergencyLevel
	 */
	public void setEmergencyLevel(String emergencyLevel) {
		this.emergencyLevel = emergencyLevel;
	}

	/**
	 * @return emergencyLevel
	 */
	public String getEmergencyLevel() {
		return this.emergencyLevel;
	}

	/**
	 * @param expiryDate
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * @return expiryDate
	 */
	public Date getExpiryDate() {
		return this.expiryDate;
	}

	/**
	 * @param conductorId
	 */
	public void setConductorId(String conductorId) {
		this.conductorId = conductorId;
	}

	/**
	 * @return conductorId
	 */
	public String getConductorId() {
		return this.conductorId;
	}

	/**
	 * @param conductorName
	 */
	public void setConductorName(String conductorName) {
		this.conductorName = conductorName;
	}

	/**
	 * @return conductorName
	 */
	public String getConductorName() {
		return this.conductorName;
	}

	/**
	 * @param conductorOrgId
	 */
	public void setConductorOrgId(String conductorOrgId) {
		this.conductorOrgId = conductorOrgId;
	}

	/**
	 * @return conductorOrgId
	 */
	public String getConductorOrgId() {
		return this.conductorOrgId;
	}

	/**
	 * @param conductorOrgName
	 */
	public void setConductorOrgName(String conductorOrgName) {
		this.conductorOrgName = conductorOrgName;
	}

	/**
	 * @return conductorOrgName
	 */
	public String getConductorOrgName() {
		return this.conductorOrgName;
	}

	/**
	 * @param needResource
	 */
	public void setNeedResource(String needResource) {
		this.needResource = needResource;
	}

	/**
	 * @return needResource
	 */
	public String getNeedResource() {
		return this.needResource;
	}

	/**
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	/**
	 * @return acctNo
	 */
	public String getAcctNo() {
		return this.acctNo;
	}

	/**
	 * @param custPhoneNo
	 */
	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo;
	}

	/**
	 * @return custPhoneNo
	 */
	public String getCustPhoneNo() {
		return this.custPhoneNo;
	}

	/**
	 * @param custSex
	 */
	public void setCustSex(String custSex) {
		this.custSex = custSex;
	}

	/**
	 * @return custSex
	 */
	public String getCustSex() {
		return this.custSex;
	}

	/**
	 * @param complainEmpId
	 */
	public void setComplainEmpId(String complainEmpId) {
		this.complainEmpId = complainEmpId;
	}

	/**
	 * @return complainEmpId
	 */
	public String getComplainEmpId() {
		return this.complainEmpId;
	}

	/**
	 * @param complainEmpName
	 */
	public void setComplainEmpName(String complainEmpName) {
		this.complainEmpName = complainEmpName;
	}

	/**
	 * @return complainEmpName
	 */
	public String getComplainEmpName() {
		return this.complainEmpName;
	}

	/**
	 * @param complainContent
	 */
	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent;
	}

	/**
	 * @return complainContent
	 */
	public String getComplainContent() {
		return this.complainContent;
	}

	/**
	 * @param checkResult
	 */
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	/**
	 * @return checkResult
	 */
	public String getCheckResult() {
		return this.checkResult;
	}

	/**
	 * @param conductTm
	 */
	public void setConductTm(String conductTm) {
		this.conductTm = conductTm;
	}

	/**
	 * @return conductTm
	 */
	public String getConductTm() {
		return this.conductTm;
	}

	/**
	 * @param adjunct
	 */
	public void setAdjunct(Timestamp adjunct) {
		this.adjunct = adjunct;
	}

	/**
	 * @return adjunct
	 */
	public Timestamp getAdjunct() {
		return this.adjunct;
	}

	/**
	 * @param isProcessed
	 */
	public void setIsProcessed(String isProcessed) {
		this.isProcessed = isProcessed;
	}

	/**
	 * @return isProcessed
	 */
	public String getIsProcessed() {
		return this.isProcessed;
	}

	/**
	 * @param feedbackTitle
	 */
	public void setFeedbackTitle(String feedbackTitle) {
		this.feedbackTitle = feedbackTitle;
	}

	/**
	 * @return feedbackTitle
	 */
	public String getFeedbackTitle() {
		return this.feedbackTitle;
	}

	/**
	 * @param feedbackDate
	 */
	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	/**
	 * @return feedbackDate
	 */
	public Date getFeedbackDate() {
		return this.feedbackDate;
	}



	/**
	 * @param isPeanuts
	 */
	public void setIsPeanuts(String isPeanuts) {
		this.isPeanuts = isPeanuts;
	}

	/**
	 * @return isPeanuts
	 */
	public String getIsPeanuts() {
		return this.isPeanuts;
	}

	public void setId(String feedbackPer) {
		this.feedbackPer = feedbackPer;
	}

	public String getFeedbackPer() {
		return feedbackPer;
	}

	public String getFeedbackPerId() {
		return feedbackPerId;
	}

	public void setFeedbackPerId(String feedbackPerId) {
		this.feedbackPerId = feedbackPerId;
	}

	public void setFeedbackPer(String feedbackPer) {
		this.feedbackPer = feedbackPer;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OcrmFciCustFeedbackInfo other = (OcrmFciCustFeedbackInfo) obj;
		if (acctNo == null) {
			if (other.acctNo != null)
				return false;
		} else if (!acctNo.equals(other.acctNo))
			return false;
		if (adjunct == null) {
			if (other.adjunct != null)
				return false;
		} else if (!adjunct.equals(other.adjunct))
			return false;
		if (checkResult == null) {
			if (other.checkResult != null)
				return false;
		} else if (!checkResult.equals(other.checkResult))
			return false;
		if (complainContent == null) {
			if (other.complainContent != null)
				return false;
		} else if (!complainContent.equals(other.complainContent))
			return false;
		if (complainEmpId == null) {
			if (other.complainEmpId != null)
				return false;
		} else if (!complainEmpId.equals(other.complainEmpId))
			return false;
		if (complainEmpName == null) {
			if (other.complainEmpName != null)
				return false;
		} else if (!complainEmpName.equals(other.complainEmpName))
			return false;
		if (conductTm == null) {
			if (other.conductTm != null)
				return false;
		} else if (!conductTm.equals(other.conductTm))
			return false;
		if (conductorId == null) {
			if (other.conductorId != null)
				return false;
		} else if (!conductorId.equals(other.conductorId))
			return false;
		if (conductorName == null) {
			if (other.conductorName != null)
				return false;
		} else if (!conductorName.equals(other.conductorName))
			return false;
		if (conductorOrgId == null) {
			if (other.conductorOrgId != null)
				return false;
		} else if (!conductorOrgId.equals(other.conductorOrgId))
			return false;
		if (conductorOrgName == null) {
			if (other.conductorOrgName != null)
				return false;
		} else if (!conductorOrgName.equals(other.conductorOrgName))
			return false;
		if (corpOrgCode == null) {
			if (other.corpOrgCode != null)
				return false;
		} else if (!corpOrgCode.equals(other.corpOrgCode))
			return false;
		if (custId == null) {
			if (other.custId != null)
				return false;
		} else if (!custId.equals(other.custId))
			return false;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (custPhoneNo == null) {
			if (other.custPhoneNo != null)
				return false;
		} else if (!custPhoneNo.equals(other.custPhoneNo))
			return false;
		if (custSex == null) {
			if (other.custSex != null)
				return false;
		} else if (!custSex.equals(other.custSex))
			return false;
		if (emergencyLevel == null) {
			if (other.emergencyLevel != null)
				return false;
		} else if (!emergencyLevel.equals(other.emergencyLevel))
			return false;
		if (expiryDate == null) {
			if (other.expiryDate != null)
				return false;
		} else if (!expiryDate.equals(other.expiryDate))
			return false;
		if (feedbackChg == null) {
			if (other.feedbackChg != null)
				return false;
		} else if (!feedbackChg.equals(other.feedbackChg))
			return false;
		if (feedbackContent == null) {
			if (other.feedbackContent != null)
				return false;
		} else if (!feedbackContent.equals(other.feedbackContent))
			return false;
		if (feedbackDate == null) {
			if (other.feedbackDate != null)
				return false;
		} else if (!feedbackDate.equals(other.feedbackDate))
			return false;
		if (feedbackId == null) {
			if (other.feedbackId != null)
				return false;
		} else if (!feedbackId.equals(other.feedbackId))
			return false;
		if (feedbackPer == null) {
			if (other.feedbackPer != null)
				return false;
		} else if (!feedbackPer.equals(other.feedbackPer))
			return false;
		if (feedbackPerId == null) {
			if (other.feedbackPerId != null)
				return false;
		} else if (!feedbackPerId.equals(other.feedbackPerId))
			return false;
		if (feedbackTitle == null) {
			if (other.feedbackTitle != null)
				return false;
		} else if (!feedbackTitle.equals(other.feedbackTitle))
			return false;
		if (feedbackType == null) {
			if (other.feedbackType != null)
				return false;
		} else if (!feedbackType.equals(other.feedbackType))
			return false;
		if (isPeanuts == null) {
			if (other.isPeanuts != null)
				return false;
		} else if (!isPeanuts.equals(other.isPeanuts))
			return false;
		if (isProcessed == null) {
			if (other.isProcessed != null)
				return false;
		} else if (!isProcessed.equals(other.isProcessed))
			return false;
		if (needResource == null) {
			if (other.needResource != null)
				return false;
		} else if (!needResource.equals(other.needResource))
			return false;
		if (workOrderSource == null) {
			if (other.workOrderSource != null)
				return false;
		} else if (!workOrderSource.equals(other.workOrderSource))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acctNo == null) ? 0 : acctNo.hashCode());
		result = prime * result + ((adjunct == null) ? 0 : adjunct.hashCode());
		result = prime * result + ((checkResult == null) ? 0 : checkResult.hashCode());
		result = prime * result + ((complainContent == null) ? 0 : complainContent.hashCode());
		result = prime * result + ((complainEmpId == null) ? 0 : complainEmpId.hashCode());
		result = prime * result + ((complainEmpName == null) ? 0 : complainEmpName.hashCode());
		result = prime * result + ((conductTm == null) ? 0 : conductTm.hashCode());
		result = prime * result + ((conductorId == null) ? 0 : conductorId.hashCode());
		result = prime * result + ((conductorName == null) ? 0 : conductorName.hashCode());
		result = prime * result + ((conductorOrgId == null) ? 0 : conductorOrgId.hashCode());
		result = prime * result + ((conductorOrgName == null) ? 0 : conductorOrgName.hashCode());
		result = prime * result + ((corpOrgCode == null) ? 0 : corpOrgCode.hashCode());
		result = prime * result + ((custId == null) ? 0 : custId.hashCode());
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((custPhoneNo == null) ? 0 : custPhoneNo.hashCode());
		result = prime * result + ((custSex == null) ? 0 : custSex.hashCode());
		result = prime * result + ((emergencyLevel == null) ? 0 : emergencyLevel.hashCode());
		result = prime * result + ((expiryDate == null) ? 0 : expiryDate.hashCode());
		result = prime * result + ((feedbackChg == null) ? 0 : feedbackChg.hashCode());
		result = prime * result + ((feedbackContent == null) ? 0 : feedbackContent.hashCode());
		result = prime * result + ((feedbackDate == null) ? 0 : feedbackDate.hashCode());
		result = prime * result + ((feedbackId == null) ? 0 : feedbackId.hashCode());
		result = prime * result + ((feedbackPer == null) ? 0 : feedbackPer.hashCode());
		result = prime * result + ((feedbackPerId == null) ? 0 : feedbackPerId.hashCode());
		result = prime * result + ((feedbackTitle == null) ? 0 : feedbackTitle.hashCode());
		result = prime * result + ((feedbackType == null) ? 0 : feedbackType.hashCode());
		result = prime * result + ((isPeanuts == null) ? 0 : isPeanuts.hashCode());
		result = prime * result + ((isProcessed == null) ? 0 : isProcessed.hashCode());
		result = prime * result + ((needResource == null) ? 0 : needResource.hashCode());
		result = prime * result + ((workOrderSource == null) ? 0 : workOrderSource.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "OcrmFciCustFeedbackInfo [feedbackId=" + feedbackId + ", corpOrgCode=" + corpOrgCode + ", custId="
				+ custId + ", custName=" + custName + ", feedbackType=" + feedbackType + ", feedbackChg=" + feedbackChg
				+ ", workOrderSource=" + workOrderSource + ", feedbackContent=" + feedbackContent + ", emergencyLevel="
				+ emergencyLevel + ", expiryDate=" + expiryDate + ", conductorId=" + conductorId + ", conductorName="
				+ conductorName + ", conductorOrgId=" + conductorOrgId + ", conductorOrgName=" + conductorOrgName
				+ ", needResource=" + needResource + ", acctNo=" + acctNo + ", custPhoneNo=" + custPhoneNo
				+ ", custSex=" + custSex + ", complainEmpId=" + complainEmpId + ", complainEmpName=" + complainEmpName
				+ ", complainContent=" + complainContent + ", checkResult=" + checkResult + ", conductTm=" + conductTm
				+ ", adjunct=" + adjunct + ", isProcessed=" + isProcessed + ", feedbackTitle=" + feedbackTitle
				+ ", feedbackDate=" + feedbackDate + ", isPeanuts=" + isPeanuts + ", feedbackPer=" + feedbackPer
				+ ", feedbackPerId=" + feedbackPerId + "]";
	}
}