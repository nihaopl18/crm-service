package cn.com.yusys.yusp.uimp.business.pma.app.model;

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
 * @项目名称: yscrm-base-core模块
 * @类名称: APPUserModel
 * @类描述: # APP用户信息模型，登录返回数据集
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-05-11 08:54:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_APP_VERSION")
public class APPVersion extends BaseDomain implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 版本号 **/
	@Column(name = "VERSION_ID", unique = false, nullable = true, length = 32)
	private String versionId;
	
	/** 是否必须更新 0-否，1-是   **/
	@Column(name = "IS_MUST", unique = false, nullable = true, length = 32)
	private String isMast;
	
	/** 版本归属  0-安卓，1-IOS **/
	@Column(name = "VERSION_BELONG", unique = false, nullable = true, length = 20)
	private String versionBelong;
	
	/**  下载链接 **/
	@Column(name = "DOWNLOAD_URL", unique = false, nullable = true, length = 255)
	private String downLoadUrl;
	
	/** 更新內容 **/
	@Column(name = "CONTENT", unique = false, nullable = true, length = 255)
	private String content;
	
	/** 更新人 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 255)
	private String updateUser;
	
	/** 更新时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 255)
	private Date updateDate;
	
	/** 更新人机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 255)
	private String updateOrg;
	
	/** 是否生效：A-生效，I-失效，对应码值：DATA_STS **/
	@Column(name = "IS_DEL", unique = false, nullable = true, length = 32)
	private String isDel;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;   
	}
	public String getVersionId() {
		return versionId;
	}
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getisMast() {
		return isMast;
	}
	public void setisMast(String isMast) {
		this.isMast = isMast;
	}
	public String getVersionBelong() {
		return versionBelong;
	}
	public void setVersionBelong(String versionBelong) {
		this.versionBelong = versionBelong;
	}
	public String getDownLoadUrl() {
		return downLoadUrl;
	}
	public void setDownLoadUrl(String downLoadUrl) {
		this.downLoadUrl = downLoadUrl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getUpdateOrg() {
		return updateOrg;
	}
	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}
	public String getIsDel() {
		return isDel;
	}
	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}
	
}
