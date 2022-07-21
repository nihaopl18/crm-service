package cn.com.yusys.yusp.uimp.base.app.uaa.domain;

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
 * @项目名称: yscrm-app-common-core模块
 * @类名称: PmaFappDeviceInfo
 * @类描述: # APP设备信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-05-13 15:43:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_APP_DEVICE_INFO")
public class PmaFappDeviceInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 用户登录代码 **/
	@Column(name = "LOGIN_CODE", unique = false, nullable = false, length = 100)
	private String loginCode;
	
	/** 用户编号 **/
	@Column(name = "USER_ID", unique = false, nullable = false, length = 32)
	private String userId;
	
	/** 设备key **/
	@Column(name = "UKEY", unique = false, nullable = true, length = 50)
	private String ukey;
	
	/** 设备标识码 **/
	@Column(name = "DEVICE_CODE", unique = false, nullable = false, length = 300)
	private String deviceCode;
	
	/** 设备推送token **/
	@Column(name = "DEVICE_TOKEN", unique = false, nullable = true, length = 300)
	private String deviceToken;
	
	/** 应用版本 **/
	@Column(name = "APP_VERSION", unique = false, nullable = true, length = 300)
	private String appVersion;
	
	/** 系统 **/
	@Column(name = "PLATFORM", unique = false, nullable = true, length = 300)
	private String platform;
	
	/** 设备型号 **/
	@Column(name = "DEVICE_MODEL", unique = false, nullable = true, length = 300)
	private String deviceModel;
	
	/** 系统版本 **/
	@Column(name = "OS_VERSION", unique = false, nullable = true, length = 300)
	private String osVersion;
	
	/** 渠道 **/
	@Column(name = "CHANNEL", unique = false, nullable = true, length = 300)
	private String channel;
	
	/** 设备纬度 **/
	@Column(name = "LATITUDE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal latitude;
	
	/** 设备经度 **/
	@Column(name = "LONGTITUDE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal longtitude;
	
	/** 更新时间 **/
	@Column(name = "UPDATE_TIME", unique = false, nullable = true, length = 7)
	private Date updateTime;
	
	/** 是否启用 **/
	@Column(name = "ENABLE_FLAG", unique = false, nullable = false, length = 10)
	private String enableFlag;
	
	/** 用户安全保密协议 **/
	@Column(name = "AGREEMENT_CONTENT", unique = false, nullable = true, length = 2000)
	private String agreementContent;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 300)
	private String remark;
	
	/** 删除标识 **/
	@Column(name = "IS_DEL", unique = false, nullable = true, length = 10)
	private String isDel;
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}
	
	/**
	 * @param loginCode
	 */
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode == null ? null : loginCode.trim();
	}
	
    /**
     * @return LoginCode
     */	
	public String getLoginCode() {
		return this.loginCode;
	}
	
	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
	
    /**
     * @return UserId
     */	
	public String getUserId() {
		return this.userId;
	}

	/**
	 * @param ukey
	 */
	public void setUkey(String ukey) {
		this.ukey = ukey == null ? null : ukey.trim();
	}
	
    /**
     * @return Ukey
     */	
	public String getUkey() {
		return this.ukey;
	}
	
	/**
	 * @param deviceCode
	 */
	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode == null ? null : deviceCode.trim();
	}
	
    /**
     * @return DeviceCode
     */	
	public String getDeviceCode() {
		return this.deviceCode;
	}
	
	/**
	 * @param deviceToken
	 */
	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken == null ? null : deviceToken.trim();
	}
	
    /**
     * @return DeviceToken
     */	
	public String getDeviceToken() {
		return this.deviceToken;
	}
	
	/**
	 * @param appVersion
	 */
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion == null ? null : appVersion.trim();
	}
	
    /**
     * @return AppVersion
     */	
	public String getAppVersion() {
		return this.appVersion;
	}
	
	/**
	 * @param platform
	 */
	public void setPlatform(String platform) {
		this.platform = platform == null ? null : platform.trim();
	}
	
    /**
     * @return Platform
     */	
	public String getPlatform() {
		return this.platform;
	}
	
	/**
	 * @param deviceModel
	 */
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel == null ? null : deviceModel.trim();
	}
	
    /**
     * @return DeviceModel
     */	
	public String getDeviceModel() {
		return this.deviceModel;
	}
	
	/**
	 * @param osVersion
	 */
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion == null ? null : osVersion.trim();
	}
	
    /**
     * @return OsVersion
     */	
	public String getOsVersion() {
		return this.osVersion;
	}
	
	/**
	 * @param channel
	 */
	public void setChannel(String channel) {
		this.channel = channel == null ? null : channel.trim();
	}
	
    /**
     * @return Channel
     */	
	public String getChannel() {
		return this.channel;
	}
	
	/**
	 * @param latitude
	 */
	public void setLatitude(java.math.BigDecimal latitude) {
		this.latitude = latitude;
	}
	
    /**
     * @return Latitude
     */	
	public java.math.BigDecimal getLatitude() {
		return this.latitude;
	}
	
	/**
	 * @param longtitude
	 */
	public void setLongtitude(java.math.BigDecimal longtitude) {
		this.longtitude = longtitude;
	}
	
    /**
     * @return Longtitude
     */	
	public java.math.BigDecimal getLongtitude() {
		return this.longtitude;
	}
	
	/**
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
    /**
     * @return UpdateTime
     */	
	public Date getUpdateTime() {
		return this.updateTime;
	}
	
	/**
	 * @param enableFlag
	 */
	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag == null ? null : enableFlag.trim();
	}
	
    /**
     * @return EnableFlag
     */	
	public String getEnableFlag() {
		return this.enableFlag;
	}
	
	/**
	 * @param agreementContent
	 */
	public void setAgreementContent(String agreementContent) {
		this.agreementContent = agreementContent == null ? null : agreementContent.trim();
	}
	
    /**
     * @return AgreementContent
     */	
	public String getAgreementContent() {
		return this.agreementContent;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * @return isDel
	 */
    public String getIsDel() {
		return isDel;
	}
    
    /**
     * @param isDel
     */	
	public void setIsDel(String isDel) {
		this.isDel = isDel;
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
        PmaFappDeviceInfo other = (PmaFappDeviceInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getLoginCode() == null ? other.getLoginCode() == null : this.getLoginCode().equals(other.getLoginCode()))
        	&& (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        	&& (this.getUkey() == null ? other.getUkey() == null : this.getUkey().equals(other.getUkey()))
        	&& (this.getDeviceCode() == null ? other.getDeviceCode() == null : this.getDeviceCode().equals(other.getDeviceCode()))
        	&& (this.getDeviceToken() == null ? other.getDeviceToken() == null : this.getDeviceToken().equals(other.getDeviceToken()))
        	&& (this.getAppVersion() == null ? other.getAppVersion() == null : this.getAppVersion().equals(other.getAppVersion()))
        	&& (this.getPlatform() == null ? other.getPlatform() == null : this.getPlatform().equals(other.getPlatform()))
        	&& (this.getDeviceModel() == null ? other.getDeviceModel() == null : this.getDeviceModel().equals(other.getDeviceModel()))
        	&& (this.getOsVersion() == null ? other.getOsVersion() == null : this.getOsVersion().equals(other.getOsVersion()))
        	&& (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
                                	&& (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()))
        	&& (this.getAgreementContent() == null ? other.getAgreementContent() == null : this.getAgreementContent().equals(other.getAgreementContent()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLoginCode() == null) ? 0 : getLoginCode().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUkey() == null) ? 0 : getUkey().hashCode());
        result = prime * result + ((getDeviceCode() == null) ? 0 : getDeviceCode().hashCode());
        result = prime * result + ((getDeviceToken() == null) ? 0 : getDeviceToken().hashCode());
        result = prime * result + ((getAppVersion() == null) ? 0 : getAppVersion().hashCode());
        result = prime * result + ((getPlatform() == null) ? 0 : getPlatform().hashCode());
        result = prime * result + ((getDeviceModel() == null) ? 0 : getDeviceModel().hashCode());
        result = prime * result + ((getOsVersion() == null) ? 0 : getOsVersion().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getEnableFlag() == null) ? 0 : getEnableFlag().hashCode());
        result = prime * result + ((getAgreementContent() == null) ? 0 : getAgreementContent().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", loginCode=").append(loginCode);
		sb.append(", userId=").append(userId);
		sb.append(", ukey=").append(ukey);
		sb.append(", deviceCode=").append(deviceCode);
		sb.append(", deviceToken=").append(deviceToken);
		sb.append(", appVersion=").append(appVersion);
		sb.append(", platform=").append(platform);
		sb.append(", deviceModel=").append(deviceModel);
		sb.append(", osVersion=").append(osVersion);
		sb.append(", channel=").append(channel);
		sb.append(", latitude=").append(latitude);
		sb.append(", longtitude=").append(longtitude);
		sb.append(", updateTime=").append(updateTime);
		sb.append(", enableFlag=").append(enableFlag);
		sb.append(", agreementContent=").append(agreementContent);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}