package cn.com.yusys.yusp.uimp.base.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminBaseSmAppVersion
 * @类描述: ADMIN_BASE_SM_APP_VERSION数据实体类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-01-15 17:30:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_BASE_SM_APP_VERSION")
public class AdminBaseSmAppVersion extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 版本号 **/
	@Column(name = "VERSION_ID", unique = false, nullable = true, length = 32)
	private String versionId;
	
	/** 是否必须更新：0-否，1-是 **/
	@Column(name = "IS_MAST", unique = false, nullable = true, length = 32)
	private String isMast;
	
	/** 版本归属：0-安卓，1-IOS **/
	@Column(name = "VERSION_BELONG", unique = false, nullable = true, length = 20)
	private String versionBelong;
	
	/** 下载地址 **/
	@Column(name = "DOWNLOAD_URL", unique = false, nullable = true, length = 255)
	private String downloadUrl;
	
	/** 更新內容 **/
	@Column(name = "CONTENT", unique = false, nullable = true, length = 255)
	private String content;
	
	/** 下载文件名称 **/
	@Column(name = "DOWNLOAD_NAME", unique = false, nullable = true, length = 255)
	private String downloadName;
	
	
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
	 * @param versionId
	 */
	public void setVersionId(String versionId) {
		this.versionId = versionId == null ? null : versionId.trim();
	}
	
    /**
     * @return VersionId
     */	
	public String getVersionId() {
		return this.versionId;
	}
	
	/**
	 * @param isMast
	 */
	public void setIsMast(String isMast) {
		this.isMast = isMast == null ? null : isMast.trim();
	}
	
    /**
     * @return IsMast
     */	
	public String getIsMast() {
		return this.isMast;
	}
	
	/**
	 * @param versionBelong
	 */
	public void setVersionBelong(String versionBelong) {
		this.versionBelong = versionBelong == null ? null : versionBelong.trim();
	}
	
    /**
     * @return VersionBelong
     */	
	public String getVersionBelong() {
		return this.versionBelong;
	}
	
	/**
	 * @param downloadUrl
	 */
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl == null ? null : downloadUrl.trim();
	}
	
    /**
     * @return DownloadUrl
     */	
	public String getDownloadUrl() {
		return this.downloadUrl;
	}
	
	/**
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}
	
    /**
     * @return Content
     */	
	public String getContent() {
		return this.content;
	}
	
	/**
	 * @param downloadName
	 */
	public void setDownloadName(String downloadName) {
		this.downloadName = downloadName == null ? null : downloadName.trim();
	}
	
    /**
     * @return DownloadName
     */	
	public String getDownloadName() {
		return this.downloadName;
	}


}