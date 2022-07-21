package cn.com.yusys.yscrm.cust.person.domain;

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
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciCustFeedbackInfo
 * @类描述: #数据实体类
 * @功能描述: 客户反馈信息
 * @创建人: 15104
 * @创建时间: 2019-02-14 17:57:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_CUST_FEEDBACK_INFO")
public class OcrmFciCustFeedbackInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 反馈ID **/
	@Id
	@Column(name = "FEEDBACK_ID")
	@Generated(GenerationType.UUID)
	private String feedbackId;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 100)
	private String custName;
	
	/** 反馈类型 **/
	@Column(name = "FEEDBACK_TYPE", unique = false, nullable = true, length = 10)
	private String feedbackType;
	
	/** 反馈渠道 **/
	@Column(name = "FEEDBACK_CHG", unique = false, nullable = true, length = 10)
	private String feedbackChg;
	
	/** 工单来源 **/
	@Column(name = "WORK_ORDER_SOURCE", unique = false, nullable = true, length = 20)
	private String workOrderSource;
	
	/** 反馈内容 **/
	@Column(name = "FEEDBACK_CONTENT", unique = false, nullable = true, length = 800)
	private String feedbackContent;
	
	/** 紧急程度 **/
	@Column(name = "EMERGENCY_LEVEL", unique = false, nullable = true, length = 10)
	private String emergencyLevel;
	
	/** 处理有效期 **/
	@Column(name = "EXPIRY_DATE", unique = false, nullable = true, length = 7)
	private Date expiryDate;
	
	/** 处理人编号 **/
	@Column(name = "CONDUCTOR_ID", unique = false, nullable = true, length = 10)
	private String conductorId;
	
	/** 处理人名称 **/
	@Column(name = "CONDUCTOR_NAME", unique = false, nullable = true, length = 20)
	private String conductorName;
	
	/** 待处理机构编号 **/
	@Column(name = "CONDUCTOR_ORG_ID", unique = false, nullable = true, length = 10)
	private String conductorOrgId;
	
	/** 待处理机构名称 **/
	@Column(name = "CONDUCTOR_ORG_NAME", unique = false, nullable = true, length = 40)
	private String conductorOrgName;
	
	/** 处理所需资源 **/
	@Column(name = "NEED_RESOURCE", unique = false, nullable = true, length = 20)
	private String needResource;
	
	/** 客户卡号/账号 **/
	@Column(name = "ACCT_NO", unique = false, nullable = true, length = 30)
	private String acctNo;
	
	/** 客户联系电话 **/
	@Column(name = "CUST_PHONE_NO", unique = false, nullable = true, length = 20)
	private String custPhoneNo;
	
	public String getFeedbackPerId() {
		return feedbackPerId;
	}

	public void setFeedbackPerId(String feedbackPerId) {
		this.feedbackPerId = feedbackPerId;
	}

	/** 客户性别 **/
	@Column(name = "CUST_SEX", unique = false, nullable = true, length = 1)
	private String custSex;
	
	/** 被投诉员工工号 **/
	@Column(name = "COMPLAIN_EMP_ID", unique = false, nullable = true, length = 10)
	private String complainEmpId;
	
	/** 被投诉员工姓名 **/
	@Column(name = "COMPLAIN_EMP_NAME", unique = false, nullable = true, length = 20)
	private String complainEmpName;
	
	/** 投诉内同 **/
	@Column(name = "COMPLAIN_CONTENT", unique = false, nullable = true, length = 800)
	private String complainContent;
	
	/** 支行调查结果 **/
	@Column(name = "CHECK_RESULT", unique = false, nullable = true, length = 800)
	private String checkResult;
	
	/** 处理时间 **/
	@Column(name = "CONDUCT_TM", unique = false, nullable = true, length = 7)
	private Date conductTm;
	
	/** 附件 **/
	@Column(name = "ADJUNCT", unique = false, nullable = true, length = 4000)
	private String adjunct;
	
	/** 是否已处理 **/
	@Column(name = "IS_PROCESSED", unique = false, nullable = true, length = 1)
	private String isProcessed;
	
	/** 反馈标题 **/
	@Column(name = "FEEDBACK_TITLE", unique = false, nullable = true, length = 100)
	private String feedbackTitle;
	
	/** 反馈日期 **/
	@Column(name = "FEEDBACK_DATE", unique = false, nullable = true, length = 7)
	private Date feedbackDate;
	
	/** 客户状态 
	@Column(name = "CUST_STATUS", unique = false, nullable = true, length = 1)
	private String custStatus;**/
	
	/** 客户等级 
	@Column(name = "CUST_GRADE", unique = false, nullable = true, length = 1)
	private String custGrade;**/
	
	/** 是否小企业客户 **/
	@Column(name = "IS_PEANUTS")
	private String isPeanuts;
	
	
	/** 客户类型
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 1)
	private String custType; **/
	
	/** 反馈人 **/
	@Column(name = "FEEDBACK_PER")
	private String feedbackPer;
	
	@Column(name = "FEEDBACK_PER_ID")
	private String feedbackPerId;
	
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
	 * @param feedbackType
	 */
	public void setFeedbackType(String feedbackType) {
		this.feedbackType = feedbackType == null ? null : feedbackType.trim();
	}
	
    /**
     * @return FeedbackType
     */	
	public String getFeedbackType() {
		return this.feedbackType;
	}
	
	/**
	 * @param feedbackChg
	 */
	public void setFeedbackChg(String feedbackChg) {
		this.feedbackChg = feedbackChg == null ? null : feedbackChg.trim();
	}
	
    /**
     * @return FeedbackChg
     */	
	public String getFeedbackChg() {
		return this.feedbackChg;
	}
	
	/**
	 * @param feedbackId
	 */
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId == null ? null : feedbackId.trim();
	}
	
    /**
     * @return FeedbackId
     */	
	public String getFeedbackId() {
		return this.feedbackId;
	}
	
	/**
	 * @param workOrderSource
	 */
	public void setWorkOrderSource(String workOrderSource) {
		this.workOrderSource = workOrderSource == null ? null : workOrderSource.trim();
	}
	
    /**
     * @return WorkOrderSource
     */	
	public String getWorkOrderSource() {
		return this.workOrderSource;
	}
	
	/**
	 * @param feedbackContent
	 */
	public void setFeedbackContent(String feedbackContent) {
		this.feedbackContent = feedbackContent == null ? null : feedbackContent.trim();
	}
	
    /**
     * @return FeedbackContent
     */	
	public String getFeedbackContent() {
		return this.feedbackContent;
	}
	
	/**
	 * @param emergencyLevel
	 */
	public void setEmergencyLevel(String emergencyLevel) {
		this.emergencyLevel = emergencyLevel == null ? null : emergencyLevel.trim();
	}
	
    /**
     * @return EmergencyLevel
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
     * @return ExpiryDate
     */	
	public Date getExpiryDate() {
		return this.expiryDate;
	}
	
	/**
	 * @param conductorId
	 */
	public void setConductorId(String conductorId) {
		this.conductorId = conductorId == null ? null : conductorId.trim();
	}
	
    /**
     * @return ConductorId
     */	
	public String getConductorId() {
		return this.conductorId;
	}
	
	/**
	 * @param conductorName
	 */
	public void setConductorName(String conductorName) {
		this.conductorName = conductorName == null ? null : conductorName.trim();
	}
	
    /**
     * @return ConductorName
     */	
	public String getConductorName() {
		return this.conductorName;
	}
	
	/**
	 * @param conductorOrgId
	 */
	public void setConductorOrgId(String conductorOrgId) {
		this.conductorOrgId = conductorOrgId == null ? null : conductorOrgId.trim();
	}
	
    /**
     * @return ConductorOrgId
     */	
	public String getConductorOrgId() {
		return this.conductorOrgId;
	}
	
	/**
	 * @param conductorOrgName
	 */
	public void setConductorOrgName(String conductorOrgName) {
		this.conductorOrgName = conductorOrgName == null ? null : conductorOrgName.trim();
	}
	
    /**
     * @return ConductorOrgName
     */	
	public String getConductorOrgName() {
		return this.conductorOrgName;
	}
	
	/**
	 * @param needResource
	 */
	public void setNeedResource(String needResource) {
		this.needResource = needResource == null ? null : needResource.trim();
	}
	
    /**
     * @return NeedResource
     */	
	public String getNeedResource() {
		return this.needResource;
	}
	
	/**
	 * @param acctNo
	 */
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo == null ? null : acctNo.trim();
	}
	
    /**
     * @return AcctNo
     */	
	public String getAcctNo() {
		return this.acctNo;
	}
	
	/**
	 * @param custPhoneNo
	 */
	public void setCustPhoneNo(String custPhoneNo) {
		this.custPhoneNo = custPhoneNo == null ? null : custPhoneNo.trim();
	}
	
    /**
     * @return CustPhoneNo
     */	
	public String getCustPhoneNo() {
		return this.custPhoneNo;
	}
	
	/**
	 * @param custSex
	 */
	public void setCustSex(String custSex) {
		this.custSex = custSex == null ? null : custSex.trim();
	}
	
    /**
     * @return CustSex
     */	
	public String getCustSex() {
		return this.custSex;
	}
	
	/**
	 * @param complainEmpId
	 */
	public void setComplainEmpId(String complainEmpId) {
		this.complainEmpId = complainEmpId == null ? null : complainEmpId.trim();
	}
	
    /**
     * @return ComplainEmpId
     */	
	public String getComplainEmpId() {
		return this.complainEmpId;
	}
	
	/**
	 * @param complainEmpName
	 */
	public void setComplainEmpName(String complainEmpName) {
		this.complainEmpName = complainEmpName == null ? null : complainEmpName.trim();
	}
	
    /**
     * @return ComplainEmpName
     */	
	public String getComplainEmpName() {
		return this.complainEmpName;
	}
	
	/**
	 * @param complainContent
	 */
	public void setComplainContent(String complainContent) {
		this.complainContent = complainContent == null ? null : complainContent.trim();
	}
	
    /**
     * @return ComplainContent
     */	
	public String getComplainContent() {
		return this.complainContent;
	}
	
	/**
	 * @param checkResult
	 */
	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult == null ? null : checkResult.trim();
	}
	
    /**
     * @return CheckResult
     */	
	public String getCheckResult() {
		return this.checkResult;
	}
	
	/**
	 * @param conductTm
	 */
	public void setConductTm(Date conductTm) {
		this.conductTm = conductTm;
	}
	
    /**
     * @return ConductTm
     */	
	public Date getConductTm() {
		return this.conductTm;
	}
	
	/**
	 * @param adjunct
	 */
	public void setAdjunct(String adjunct) {
		this.adjunct = adjunct;
	}
	
    /**
     * @return Adjunct
     */	
	public String getAdjunct() {
		return this.adjunct;
	}
	
	/**
	 * @param isProcessed
	 */
	public void setIsProcessed(String isProcessed) {
		this.isProcessed = isProcessed == null ? null : isProcessed.trim();
	}
	
    /**
     * @return IsProcessed
     */	
	public String getIsProcessed() {
		return this.isProcessed;
	}
	
	/**
	 * @param feedbackTitle
	 */
	public void setFeedbackTitle(String feedbackTitle) {
		this.feedbackTitle = feedbackTitle == null ? null : feedbackTitle.trim();
	}
	
    /**
     * @return FeedbackTitle
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
     * @return FeedbackDate
     */	
	public Date getFeedbackDate() {
		return this.feedbackDate;
	}
	
	/**
	 * @param custStatus
	 */
//	public void setCustStatus(String custStatus) {
//		this.custStatus = custStatus == null ? null : custStatus.trim();
//	}
//	
//    /**
//     * @return CustStatus
//     */	
//	public String getCustStatus() {
//		return this.custStatus;
//	}
	
//	/**
//	 * @param custGrade
//	 */
//	public void setCustGrade(String custGrade) {
//		this.custGrade = custGrade == null ? null : custGrade.trim();
//	}
//	
//    /**
//     * @return CustGrade
//     */	
//	public String getCustGrade() {
//		return this.custGrade;
//	}
	
	/**
	 * @param isPeanuts
	 */
	public void setIsPeanuts(String isPeanuts) {
		this.isPeanuts = isPeanuts == null ? null : isPeanuts.trim();
	}
	
    /**
     * @return IsPeanuts
     */	
	public String getIsPeanuts() {
		return this.isPeanuts;
	}
	
	
	
	/**
	 * @param custType
	 
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	*/
    /**
     * @return CustType
     
	public String getCustType() {
		return this.custType;
	}
	*/	
	/**
	 * @param feedbackPer
	 */
	public void setFeedbackPer(String feedbackPer) {
		this.feedbackPer = feedbackPer == null ? null : feedbackPer.trim();
	}
	
    /**
     * @return FeedbackPer
     */	
	public String getFeedbackPer() {
		return this.feedbackPer;
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