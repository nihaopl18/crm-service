package cn.com.yusys.climp.qypool.domain;

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
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyMerchantInfoTemp
 * @类描述: #数据实体类
 * @功能描述: 商户信息导入临时实体类
 * @创建人: hujun3
 * @创建时间: 2019-02-28 10:27:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_MERCHANT_INFO_TEMP")
public class LoyQyMerchantInfoTemp extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** MERCHANT_ID **/
	@Id
	@Column(name = "MERCHANT_ID")
	@Generated(GenerationType.UUID)
	private String merchantId;
	
	/** 商户名称 **/
	@Column(name = "MERCHANT_NAME", unique = false, nullable = false, length = 200)
	private String merchantName;
	
	/** 商户工商名称 **/
	@Column(name = "MER_IAC_NAME", unique = false, nullable = true, length = 200)
	private String merIacName;
	
	/** 商户门店名称 **/
	@Column(name = "MER_STROE_NAME", unique = false, nullable = true, length = 200)
	private String merStroeName;
	
	/** 法人名称 **/
	@Column(name = "LEGAL_PERSON_NM", unique = false, nullable = true, length = 100)
	private String legalPersonNm;
	
	/** 证件类型 **/
	@Column(name = "CERT_TYPE", unique = false, nullable = false, length = 10)
	private String certType;
	
	/** 证件号 **/
	@Column(name = "CERT_NO", unique = false, nullable = false, length = 100)
	private String certNo;
	
	/** 经营一级类目 **/
	@Column(name = "MANAGE_A_TYPE", unique = false, nullable = true, length = 10)
	private String manageAtype;
	
	/** 经营二级类目 **/
	@Column(name = "MANAGE_B_TYPE", unique = false, nullable = true, length = 10)
	private String manageBtype;
	
	/** 联系信息 **/
	@Column(name = "CONTACT_INFO", unique = false, nullable = true, length = 50)
	private String contactInfo;
	
	/** 详细地址 **/
	@Column(name = "ADDRESS_INFO", unique = false, nullable = true, length = 200)
	private String addressInfo;
	
	/** 商户介绍 **/
	@Column(name = "MER_REMARK", unique = false, nullable = true, length = 800)
	private String merRemark;
	
	/** 经营内容介绍 **/
	@Column(name = "MANAGE_CONTENT", unique = false, nullable = true, length = 1400)
	private String manageContent;
	
	/** 数据状态 **/
	@Column(name = "DATA_STS", unique = false, nullable = false, length = 10)
	private String dataSts;
	
	/** 审批状态 **/
	@Column(name = "WF_APPR_STS", unique = false, nullable = false, length = 20)
	private String wfApprSts;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
	//@Transient
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近修改日期 **/
	//@Transient
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 100)
	private String updateOrg;
	
	/** 批次号   批量导入的时候写入数据 **/
	@Column(name = "BATCH_NO", unique = false, nullable = true, length = 30)
	private String batchNo;
	
	
	/**
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId == null ? null : merchantId.trim();
	}
	
    /**
     * @return MerchantId
     */	
	public String getMerchantId() {
		return this.merchantId;
	}
	
	/**
	 * @param merchantName
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName == null ? null : merchantName.trim();
	}
	
    /**
     * @return MerchantName
     */	
	public String getMerchantName() {
		return this.merchantName;
	}
	
	/**
	 * @param merIacName
	 */
	public void setMerIacName(String merIacName) {
		this.merIacName = merIacName == null ? null : merIacName.trim();
	}
	
    /**
     * @return MerIacName
     */	
	public String getMerIacName() {
		return this.merIacName;
	}
	
	/**
	 * @param merStroeName
	 */
	public void setMerStroeName(String merStroeName) {
		this.merStroeName = merStroeName == null ? null : merStroeName.trim();
	}
	
    /**
     * @return MerStroeName
     */	
	public String getMerStroeName() {
		return this.merStroeName;
	}
	
	/**
	 * @param legalPersonNm
	 */
	public void setLegalPersonNm(String legalPersonNm) {
		this.legalPersonNm = legalPersonNm == null ? null : legalPersonNm.trim();
	}
	
    /**
     * @return LegalPersonNm
     */	
	public String getLegalPersonNm() {
		return this.legalPersonNm;
	}
	
	/**
	 * @param certType
	 */
	public void setCertType(String certType) {
		this.certType = certType == null ? null : certType.trim();
	}
	
    /**
     * @return CertType
     */	
	public String getCertType() {
		return this.certType;
	}
	
	/**
	 * @param certNo
	 */
	public void setCertNo(String certNo) {
		this.certNo = certNo == null ? null : certNo.trim();
	}
	
    /**
     * @return CertNo
     */	
	public String getCertNo() {
		return this.certNo;
	}
	
	/**
	 * @param manageAtype
	 */
	public void setManageAtype(String manageAtype) {
		this.manageAtype = manageAtype == null ? null : manageAtype.trim();
	}
	
    /**
     * @return ManageAtype
     */	
	public String getManageAtype() {
		return this.manageAtype;
	}
	
	/**
	 * @param manageBtype
	 */
	public void setManageBtype(String manageBtype) {
		this.manageBtype = manageBtype == null ? null : manageBtype.trim();
	}
	
    /**
     * @return ManageBtype
     */	
	public String getManageBtype() {
		return this.manageBtype;
	}
	
	/**
	 * @param contactInfo
	 */
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo == null ? null : contactInfo.trim();
	}
	
    /**
     * @return ContactInfo
     */	
	public String getContactInfo() {
		return this.contactInfo;
	}
	
	/**
	 * @param addressInfo
	 */
	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo == null ? null : addressInfo.trim();
	}
	
    /**
     * @return AddressInfo
     */	
	public String getAddressInfo() {
		return this.addressInfo;
	}
	
	/**
	 * @param merRemark
	 */
	public void setMerRemark(String merRemark) {
		this.merRemark = merRemark == null ? null : merRemark.trim();
	}
	
    /**
     * @return MerRemark
     */	
	public String getMerRemark() {
		return this.merRemark;
	}
	
	/**
	 * @param manageContent
	 */
	public void setManageContent(String manageContent) {
		this.manageContent = manageContent == null ? null : manageContent.trim();
	}
	
    /**
     * @return ManageContent
     */	
	public String getManageContent() {
		return this.manageContent;
	}
	
	/**
	 * @param dataSts
	 */
	public void setDataSts(String dataSts) {
		this.dataSts = dataSts == null ? null : dataSts.trim();
	}
	
    /**
     * @return DataSts
     */	
	public String getDataSts() {
		return this.dataSts;
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
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo == null ? null : batchNo.trim();
	}
	
    /**
     * @return BatchNo
     */	
	public String getBatchNo() {
		return this.batchNo;
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
        LoyQyMerchantInfoTemp other = (LoyQyMerchantInfoTemp) that;
		return (this.getMerchantId() == null ? other.getMerchantId() == null : this.getMerchantId().equals(other.getMerchantId()))
        	&& (this.getMerchantName() == null ? other.getMerchantName() == null : this.getMerchantName().equals(other.getMerchantName()))
        	&& (this.getMerIacName() == null ? other.getMerIacName() == null : this.getMerIacName().equals(other.getMerIacName()))
        	&& (this.getMerStroeName() == null ? other.getMerStroeName() == null : this.getMerStroeName().equals(other.getMerStroeName()))
        	&& (this.getLegalPersonNm() == null ? other.getLegalPersonNm() == null : this.getLegalPersonNm().equals(other.getLegalPersonNm()))
        	&& (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
        	&& (this.getCertNo() == null ? other.getCertNo() == null : this.getCertNo().equals(other.getCertNo()))
        	&& (this.getManageAtype() == null ? other.getManageAtype() == null : this.getManageAtype().equals(other.getManageAtype()))
        	&& (this.getManageBtype() == null ? other.getManageBtype() == null : this.getManageBtype().equals(other.getManageBtype()))
        	&& (this.getContactInfo() == null ? other.getContactInfo() == null : this.getContactInfo().equals(other.getContactInfo()))
        	&& (this.getAddressInfo() == null ? other.getAddressInfo() == null : this.getAddressInfo().equals(other.getAddressInfo()))
        	&& (this.getMerRemark() == null ? other.getMerRemark() == null : this.getMerRemark().equals(other.getMerRemark()))
        	&& (this.getManageContent() == null ? other.getManageContent() == null : this.getManageContent().equals(other.getManageContent()))
        	&& (this.getDataSts() == null ? other.getDataSts() == null : this.getDataSts().equals(other.getDataSts()))
        	&& (this.getWfApprSts() == null ? other.getWfApprSts() == null : this.getWfApprSts().equals(other.getWfApprSts()))
        	&& (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
                	&& (this.getCreateOrg() == null ? other.getCreateOrg() == null : this.getCreateOrg().equals(other.getCreateOrg()))
        	&& (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
                	&& (this.getUpdateOrg() == null ? other.getUpdateOrg() == null : this.getUpdateOrg().equals(other.getUpdateOrg()))
        	&& (this.getBatchNo() == null ? other.getBatchNo() == null : this.getBatchNo().equals(other.getBatchNo()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMerchantId() == null) ? 0 : getMerchantId().hashCode());
        result = prime * result + ((getMerchantName() == null) ? 0 : getMerchantName().hashCode());
        result = prime * result + ((getMerIacName() == null) ? 0 : getMerIacName().hashCode());
        result = prime * result + ((getMerStroeName() == null) ? 0 : getMerStroeName().hashCode());
        result = prime * result + ((getLegalPersonNm() == null) ? 0 : getLegalPersonNm().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNo() == null) ? 0 : getCertNo().hashCode());
        result = prime * result + ((getManageAtype() == null) ? 0 : getManageAtype().hashCode());
        result = prime * result + ((getManageBtype() == null) ? 0 : getManageBtype().hashCode());
        result = prime * result + ((getContactInfo() == null) ? 0 : getContactInfo().hashCode());
        result = prime * result + ((getAddressInfo() == null) ? 0 : getAddressInfo().hashCode());
        result = prime * result + ((getMerRemark() == null) ? 0 : getMerRemark().hashCode());
        result = prime * result + ((getManageContent() == null) ? 0 : getManageContent().hashCode());
        result = prime * result + ((getDataSts() == null) ? 0 : getDataSts().hashCode());
        result = prime * result + ((getWfApprSts() == null) ? 0 : getWfApprSts().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateOrg() == null) ? 0 : getCreateOrg().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateOrg() == null) ? 0 : getUpdateOrg().hashCode());
        result = prime * result + ((getBatchNo() == null) ? 0 : getBatchNo().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", merchantId=").append(merchantId);
		sb.append(", merchantName=").append(merchantName);
		sb.append(", merIacName=").append(merIacName);
		sb.append(", merStroeName=").append(merStroeName);
		sb.append(", legalPersonNm=").append(legalPersonNm);
		sb.append(", certType=").append(certType);
		sb.append(", certNo=").append(certNo);
		sb.append(", manageAtype=").append(manageAtype);
		sb.append(", manageBtype=").append(manageBtype);
		sb.append(", contactInfo=").append(contactInfo);
		sb.append(", addressInfo=").append(addressInfo);
		sb.append(", merRemark=").append(merRemark);
		sb.append(", manageContent=").append(manageContent);
		sb.append(", dataSts=").append(dataSts);
		sb.append(", wfApprSts=").append(wfApprSts);
		sb.append(", createUser=").append(createUser);
		sb.append(", createDate=").append(createDate);
		sb.append(", createOrg=").append(createOrg);
		sb.append(", updateUser=").append(updateUser);
		sb.append(", updateDate=").append(updateDate);
		sb.append(", updateOrg=").append(updateOrg);
		sb.append(", batchNo=").append(batchNo);
        sb.append("]");
        return sb.toString();
    }
}