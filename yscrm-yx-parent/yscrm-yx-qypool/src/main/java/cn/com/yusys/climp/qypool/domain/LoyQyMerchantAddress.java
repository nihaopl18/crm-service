package cn.com.yusys.climp.qypool.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyMerchantAddress
 * @类描述: LOY_QY_MERCHANT_ADDRESS数据实体类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-06-03 19:29:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_QY_MERCHANT_ADDRESS")
public class LoyQyMerchantAddress extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "ADDRESS_ID")
	@Generated(GenerationType.UUID)
	private String addressId;
	
	/** 商户编号 **/
	@Column(name = "MERCHANT_ID", unique = false, nullable = false, length = 32)
	private String merchantId;
	
	/** 地址类型 **/
	@Column(name = "ADDRESS_TYPE", unique = false, nullable = true, length = 10)
	private String addressType;
	
	/** 国家 **/
	@Column(name = "COUNTRY", unique = false, nullable = true, length = 10)
	private String country;
	
	/** 是否首选 **/
	@Column(name = "IF_FIRST", unique = false, nullable = true, length = 10)
	private String ifFirst;
	
	/** 省份 **/
	@Column(name = "RPOVINCE", unique = false, nullable = true, length = 10)
	private String rpovince;
	
	/** 城市 **/
	@Column(name = "CITY_NAME", unique = false, nullable = true, length = 10)
	private String cityName;
	
	/** 区县 **/
	@Column(name = "COUNTY_AREA", unique = false, nullable = true, length = 10)
	private String countyArea;
	
	/** 乡镇 **/
	@Column(name = "TOWNSHIP", unique = false, nullable = true, length = 10)
	private String township;
	
	/** 街道 **/
	@Column(name = "STREET", unique = false, nullable = true, length = 10)
	private String street;
	
	/** 详细地址 **/
	@Column(name = "ADDRESS_INFO", unique = false, nullable = false, length = 800)
	private String addressInfo;
	
	/** 邮编 **/
	@Column(name = "POST_NO", unique = false, nullable = false, length = 1400)
	private String postNo;
	
	/** 来源系统 **/
	@Column(name = "SYS_NO", unique = false, nullable = true, length = 10)
	private String sysNo;
	
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
	 * @param addressId
	 */
	public void setAddressId(String addressId) {
		this.addressId = addressId == null ? null : addressId.trim();
	}
	
    /**
     * @return AddressId
     */	
	public String getAddressId() {
		return this.addressId;
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
	 * @param addressType
	 */
	public void setAddressType(String addressType) {
		this.addressType = addressType == null ? null : addressType.trim();
	}
	
    /**
     * @return AddressType
     */	
	public String getAddressType() {
		return this.addressType;
	}
	
	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}
	
    /**
     * @return Country
     */	
	public String getCountry() {
		return this.country;
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
	 * @param rpovince
	 */
	public void setRpovince(String rpovince) {
		this.rpovince = rpovince == null ? null : rpovince.trim();
	}
	
    /**
     * @return Rpovince
     */	
	public String getRpovince() {
		return this.rpovince;
	}
	
	/**
	 * @param cityName
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName == null ? null : cityName.trim();
	}
	
    /**
     * @return CityName
     */	
	public String getCityName() {
		return this.cityName;
	}
	
	/**
	 * @param countyArea
	 */
	public void setCountyArea(String countyArea) {
		this.countyArea = countyArea == null ? null : countyArea.trim();
	}
	
    /**
     * @return CountyArea
     */	
	public String getCountyArea() {
		return this.countyArea;
	}
	
	/**
	 * @param township
	 */
	public void setTownship(String township) {
		this.township = township == null ? null : township.trim();
	}
	
    /**
     * @return Township
     */	
	public String getTownship() {
		return this.township;
	}
	
	/**
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street == null ? null : street.trim();
	}
	
    /**
     * @return Street
     */	
	public String getStreet() {
		return this.street;
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
	 * @param postNo
	 */
	public void setPostNo(String postNo) {
		this.postNo = postNo == null ? null : postNo.trim();
	}
	
    /**
     * @return PostNo
     */	
	public String getPostNo() {
		return this.postNo;
	}
	
	/**
	 * @param sysNo
	 */
	public void setSysNo(String sysNo) {
		this.sysNo = sysNo == null ? null : sysNo.trim();
	}
	
    /**
     * @return SysNo
     */	
	public String getSysNo() {
		return this.sysNo;
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