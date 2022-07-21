/*
 * 代码生成器自动生成的
 * Since 2008 - 2020
 *
 */
package cn.com.yusys.yusp.uimp.business.pma.app.domain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;

/**
 * @项目名称: yusp-file-ext-starter模块
 * @类名称: AdminSmAnnexe
 * @类描述: ADMIN_SM_ANNEXE数据实体类
 * @功能描述: 
 * @创建人: niumr
 * @创建时间: 2020-08-07 17:27:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Table(name = "ADMIN_SM_ANNEXE")
public class AdminSmAnnexe extends BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;
	
	/** 附件编号 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ANNEXE_ID")
	private String annexeId;
	
	/** 关联业务模块 **/
	@Column(name = "REL_MOD", unique = false, nullable = true, length = 10)
	private String relMod;
	
	/** 关联业务主表编号 **/
	@Column(name = "REL_ID", unique = false, nullable = true, length = 32)
	private String relId;
	
	/** 附件名称 **/
	@Column(name = "ANNEXE_NAME", unique = false, nullable = true, length = 500)
	private String annexeName;
	
	/** 附件类型 **/
	@Column(name = "ANNEXE_TYPE", unique = false, nullable = true, length = 10)
	private String annexeType;
	
	/** 附件大小（KB） **/
	@Column(name = "ANNEXE_SIZE", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal annexeSize;
	
	/** 下载次数 **/
	@Column(name = "LOAD_COUNT", unique = false, nullable = true, length = 0)
	private int loadCount;
	
	/** 客户端名称 **/
	@Column(name = "CLIENT_NAME", unique = false, nullable = true, length = 500)
	private String clientName;
	
	/** 附件服务器名称 **/
	@Column(name = "ANNEXE_SER_NAME", unique = false, nullable = true, length = 500)
	private String annexeSerName;
	
	/** 物理地址 **/
	@Column(name = "PHYSICAL_ADDRESS", unique = false, nullable = true, length = 500)
	private String physicalAddress;
	
	/** 最后下载时间 **/
	@Column(name = "LAST_LOAD_TIME", unique = false, nullable = true, length = 20)
	private String lastLoadTime;
	
	/** 最后下载人ID **/
	@Column(name = "LAST_LOADER", unique = false, nullable = true, length = 32)
	private String lastLoader;
	
	/** 创建人编号 **/
	@Column(name = "CREATE_USER_ID", unique = false, nullable = true, length = 20)
	private String createUserId;
	
	/** 创建人姓名 **/
	@Column(name = "CREATE_USER_NAME", unique = false, nullable = true, length = 100)
	private String createUserName;
	
	/** 创建时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 20)
	private String createTime;
	
	/** 创建人机构编号 **/
	@Column(name = "CREATE_ORG_ID", unique = false, nullable = true, length = 32)
	private String createOrgId;
	
	/** 创建人机构名称 **/
	@Column(name = "CREATE_ORG_NAME", unique = false, nullable = true, length = 100)
	private String createOrgName;
	
	/** 上传附件个数 **/
	@Column(name = "UPLOAD_COUNT", unique = false, nullable = true, length = 10)
	private String uploadCount;
	
	
	/**
	 * @param annexeId
	 */
	public void setAnnexeId(String annexeId) {
		this.annexeId = annexeId;
	}
	
    /**
     * @return annexeId
     */
	public String getAnnexeId() {
		return this.annexeId;
	}
	
	/**
	 * @param relMod
	 */
	public void setRelMod(String relMod) {
		this.relMod = relMod;
	}
	
    /**
     * @return relMod
     */
	public String getRelMod() {
		return this.relMod;
	}
	
	/**
	 * @param relId
	 */
	public void setRelId(String relId) {
		this.relId = relId;
	}
	
    /**
     * @return relId
     */
	public String getRelId() {
		return this.relId;
	}
	
	/**
	 * @param annexeName
	 */
	public void setAnnexeName(String annexeName) {
		this.annexeName = annexeName;
	}
	
    /**
     * @return annexeName
     */
	public String getAnnexeName() {
		return this.annexeName;
	}
	
	/**
	 * @param annexeType
	 */
	public void setAnnexeType(String annexeType) {
		this.annexeType = annexeType;
	}
	
    /**
     * @return annexeType
     */
	public String getAnnexeType() {
		return this.annexeType;
	}
	
	/**
	 * @param annexeSize
	 */
	public void setAnnexeSize(java.math.BigDecimal annexeSize) {
		this.annexeSize = annexeSize;
	}
	
    /**
     * @return annexeSize
     */
	public java.math.BigDecimal getAnnexeSize() {
		return this.annexeSize;
	}
	
	/**
	 * @param loadCount
	 */
	public void setLoadCount(int loadCount) {
		this.loadCount = loadCount;
	}
	
    /**
     * @return loadCount
     */
	public int getLoadCount() {
		return this.loadCount;
	}
	
	/**
	 * @param clientName
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
    /**
     * @return clientName
     */
	public String getClientName() {
		return this.clientName;
	}
	
	/**
	 * @param annexeSerName
	 */
	public void setAnnexeSerName(String annexeSerName) {
		this.annexeSerName = annexeSerName;
	}
	
    /**
     * @return annexeSerName
     */
	public String getAnnexeSerName() {
		return this.annexeSerName;
	}
	
	/**
	 * @param physicalAddress
	 */
	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}
	
    /**
     * @return physicalAddress
     */
	public String getPhysicalAddress() {
		return this.physicalAddress;
	}
	
	/**
	 * @param lastLoadTime
	 */
	public void setLastLoadTime(String lastLoadTime) {
		this.lastLoadTime = lastLoadTime;
	}
	
    /**
     * @return lastLoadTime
     */
	public String getLastLoadTime() {
		return this.lastLoadTime;
	}
	
	/**
	 * @param lastLoader
	 */
	public void setLastLoader(String lastLoader) {
		this.lastLoader = lastLoader;
	}
	
    /**
     * @return lastLoader
     */
	public String getLastLoader() {
		return this.lastLoader;
	}
	
	/**
	 * @param createUserId
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}
	
    /**
     * @return createUserId
     */
	public String getCreateUserId() {
		return this.createUserId;
	}
	
	/**
	 * @param createUserName
	 */
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	
    /**
     * @return createUserName
     */
	public String getCreateUserName() {
		return this.createUserName;
	}
	
	/**
	 * @param createTime
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
    /**
     * @return createTime
     */
	public String getCreateTime() {
		return this.createTime;
	}
	
	/**
	 * @param createOrgId
	 */
	public void setCreateOrgId(String createOrgId) {
		this.createOrgId = createOrgId;
	}
	
    /**
     * @return createOrgId
     */
	public String getCreateOrgId() {
		return this.createOrgId;
	}
	
	/**
	 * @param createOrgName
	 */
	public void setCreateOrgName(String createOrgName) {
		this.createOrgName = createOrgName;
	}
	
    /**
     * @return createOrgName
     */
	public String getCreateOrgName() {
		return this.createOrgName;
	}
	
	/**
	 * @param uploadCount
	 */
	public void setUploadCount(String uploadCount) {
		this.uploadCount = uploadCount;
	}
	
    /**
     * @return uploadCount
     */
	public String getUploadCount() {
		return this.uploadCount;
	}


}