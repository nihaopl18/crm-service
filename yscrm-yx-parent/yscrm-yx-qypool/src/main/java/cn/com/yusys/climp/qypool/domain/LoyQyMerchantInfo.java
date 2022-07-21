package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: testApp-app-single-starter模块
 * @类名称: LoyQyMerchantInfo
 * @类描述: LOY_QY_MERCHANT_INFO数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-06-04 15:37:54
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_MERCHANT_INFO")
public class LoyQyMerchantInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 商户编号 **/
	@Id
	@Column(name = "MERCHANT_ID",unique = true,nullable = false,length = 50)
	@Generated(GenerationType.UUID)
	private String merchantId;
	
	/** 商户名称 **/
	@Column(name = "MERCHANT_NAME", unique = false, nullable = true, length = 200)
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
	
	/** 门店	LOGO **/
	@Column(name = "MERCHANT_LOGO", unique = false, nullable = true, length = 100)
	private String merchantLogo;
	
	/** 证件类型 **/
	@Column(name = "CERT_TYPE", unique = false, nullable = true, length = 10)
	private String certType;
	
	/** 证件号 **/
	@Column(name = "CERT_NO", unique = false, nullable = true, length = 100)
	private String certNo;
	
	/** 经营一级类目 **/
	@Column(name = "MANAGE_A_TYPE", unique = false, nullable = true, length = 10)
	private String manageAType;
	
	/** 经营二级类目 **/
	@Column(name = "MANAGE_B_TYPE", unique = false, nullable = true, length = 10)
	private String manageBType;
	
	/** 详细地址 **/
	@Column(name = "ADDRESS_INFO", unique = false, nullable = true, length = 200)
	private String addressInfo;
	
	/** 商户介绍 **/
	@Column(name = "MER_REMARK", unique = false, nullable = true, length = 1000)
	private String merRemark;
	
	/** 服务介绍 **/
	@Column(name = "MANAGE_CONTENT", unique = false, nullable = true, length = 1400)
	private String manageContent;
	
	/** 数据状态 **/
	@Column(name = "DATA_STS", unique = false, nullable = false, length = 10)
	private String dataSts;
	
	/** 审批状态 **/
	@Column(name = "WF_APPR_STS", unique = false, nullable = false, length = 20)
	private String wfApprSts;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 50)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private Date createDate;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 50)
	private String createOrg;
	
	/** 最近修改人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 50)
	private String updateUser;
	
	/** 最近修改日期 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
	private Date updateDate;
	
	/** 最近修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 50)
	private String updateOrg;
	
	/** 批次号   批量导入的时候写入数据 **/
	@Column(name = "BATCH_NO", unique = false, nullable = true, length = 30)
	private String batchNo;
	
	/** 营业时间 **/
	@Column(name = "BUSE_HOURS", unique = false, nullable = true, length = 100)
	private String buseHours;
	
	/** 店长名称 **/
	@Column(name = "SHOPOWNER_NM", unique = false, nullable = true, length = 100)
	private String shopownerNm;
	
	/** 所属金融机构 **/
	@Column(name = "INSTU_CDE", unique = false, nullable = true, length = 50)
	private String instuCde;
	
	/** 所属机构 **/
	@Column(name = "BELONG_ORG", unique = false, nullable = true, length = 50)
	private String belongOrg;

	/** 联系电话 **/
	@Column(name = "PHONE_INFO", unique = false, nullable = true, length = 200)
	private String phoneInfo;

	/** 邮件地址 **/
	@Column(name = "EMAIL_INFO", unique = false, nullable = true, length = 200)
	private String emailInfo;

	/** 商户代码 **/
	@Column(name = "MERCHANT_CODE", unique = false, nullable = true, length = 50)
	private String merchantCode;

	/** 联系人 **/
	@Column(name = "LINKMAN", unique = false, nullable = true, length = 100)
	private String linkman;
	
	
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
	 * @param merchantLogo
	 */
	public void setMerchantLogo(String merchantLogo) {
		this.merchantLogo = merchantLogo == null ? null : merchantLogo.trim();
	}
	
    /**
     * @return merchantLogo
     */	
	public String getMerchantLogo() {
		return this.merchantLogo;
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
	 * @param manageAType
	 */
	public void setManageAtype(String manageAType) {
		this.manageAType = manageAType == null ? null : manageAType.trim();
	}
	
    /**
     * @return manageAType
     */	
	public String getManageAType() {
		return this.manageAType;
	}
	
	/**
	 * @param manageBType
	 */
	public void setManageBType(String manageBType) {
		this.manageBType = manageBType == null ? null : manageBType.trim();
	}
	
    /**
     * @return manageBType
     */	
	public String getManageBType() {
		return this.manageBType;
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
	
	/**
	 * @param buseHours
	 */
	public void setBuseHours(String buseHours) {
		this.buseHours = buseHours == null ? null : buseHours.trim();
	}
	
    /**
     * @return BuseHours
     */	
	public String getBuseHours() {
		return this.buseHours;
	}
	
	/**
	 * @param shopownerNm
	 */
	public void setShopownerNm(String shopownerNm) {
		this.shopownerNm = shopownerNm == null ? null : shopownerNm.trim();
	}
	
    /**
     * @return ShopownerNm
     */	
	public String getShopownerNm() {
		return this.shopownerNm;
	}
	
	/**
	 * @param instuCde
	 */
	public void setInstuCde(String instuCde) {
		this.instuCde = instuCde == null ? null : instuCde.trim();
	}
	
    /**
     * @return InstuCde
     */	
	public String getInstuCde() {
		return this.instuCde;
	}
	
	/**
	 * @param belongOrg
	 */
	public void setBelongOrg(String belongOrg) {
		this.belongOrg = belongOrg == null ? null : belongOrg.trim();
	}
	
    /**
     * @return BelongOrg
     */	
	public String getBelongOrg() {
		return this.belongOrg;
	}

	public void setManageAType(String manageAType) {
		this.manageAType = manageAType;
	}

	public String getPhoneInfo() {
		return phoneInfo;
	}

	public void setPhoneInfo(String phoneInfo) {
		this.phoneInfo = phoneInfo;
	}

	public String getEmailInfo() {
		return emailInfo;
	}

	public void setEmailInfo(String emailInfo) {
		this.emailInfo = emailInfo;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}

	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
}