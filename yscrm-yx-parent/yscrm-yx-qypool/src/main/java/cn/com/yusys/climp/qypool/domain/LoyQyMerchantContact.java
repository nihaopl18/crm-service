package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyMerchantContact
 * @类描述: LOY_QY_MERCHANT_CONTACT数据实体类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-06-03 19:29:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_MERCHANT_CONTACT")
public class LoyQyMerchantContact extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "CONTACT_ID")
	@Generated(GenerationType.UUID)
	private String contactId;
	
	/** 商户编号 **/
	@Column(name = "MERCHANT_ID", unique = false, nullable = false, length = 32)
	private String merchantId;
	
	/** 联系方式类型 **/
	@Column(name = "CONTACT_TYPE", unique = false, nullable = false, length = 10)
	private String contactType;
	
	/** 联系信息 **/
	@Column(name = "CONTACT_INFO", unique = false, nullable = false, length = 100)
	private String contactInfo;
	
	/** 是否首选 **/
	@Column(name = "IF_FIRST", unique = false, nullable = false, length = 10)
	private String ifFirst;
	
	/** 联系顺序 **/
	@Column(name = "CONTACT_ORADER", unique = false, nullable = true, length = 10)
	private String contactOrader;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 100)
	private String createUser;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 7)
	private Date createDate;
	
	/** 最近更新人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 100)
	private String updateUser;
	
	/** 最近更新日期 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 7)
	private Date updateDate;
	
	
	/**
	 * @param contactId
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId == null ? null : contactId.trim();
	}
	
    /**
     * @return ContactId
     */	
	public String getContactId() {
		return this.contactId;
	}
	
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
	 * @param contactType
	 */
	public void setContactType(String contactType) {
		this.contactType = contactType == null ? null : contactType.trim();
	}
	
    /**
     * @return ContactType
     */	
	public String getContactType() {
		return this.contactType;
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
	 * @param ifFirst
	 */
	public void setIfFirst(String ifFirst) {
		this.ifFirst = ifFirst == null ? null : ifFirst.trim();
	}
	
    /**
     * @return IfFirst
     */	
	public String getIfFirst() {
		return this.ifFirst;
	}
	
	/**
	 * @param contactOrader
	 */
	public void setContactOrader(String contactOrader) {
		this.contactOrader = contactOrader == null ? null : contactOrader.trim();
	}
	
    /**
     * @return ContactOrader
     */	
	public String getContactOrader() {
		return this.contactOrader;
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


}