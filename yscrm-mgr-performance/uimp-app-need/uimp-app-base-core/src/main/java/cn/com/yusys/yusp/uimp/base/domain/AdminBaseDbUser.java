package cn.com.yusys.yusp.uimp.base.domain;

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
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseDbUser
 * @类描述: ADMIN_BASE_DB_USER数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-21 11:18:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_BASE_DB_USER")
public class AdminBaseDbUser extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 用户名 **/
	@Column(name = "NAME", unique = false, nullable = true, length = 50)
	private String name;
	
	/** 密码 **/
	@Column(name = "PASSWORD", unique = false, nullable = true, length = 50)
	private String password;
	
	/** 表空间 **/
	@Column(name = "TABLESPACE", unique = false, nullable = true, length = 50)
	private String tablespace;
	
	/** 临时表空间 **/
	@Column(name = "TEMP_TABLESPACE", unique = false, nullable = true, length = 50)
	private String tempTablespace;
	
	/** 所属系统：1-PMA;2-CRM;3-其他 **/
	@Column(name = "SYS_ID", unique = false, nullable = true, length = 2)
	private String sysId;
	
	/** 备注  **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 500)
	private String remark;
	
	/** 创建人 **/
	@Column(name = "CREATE_USER", unique = false, nullable = true, length = 32)
	private String createUser;
	
	/** 创建时间 **/
	@Column(name = "CREATE_DT", unique = false, nullable = true, length = 7)
	private Date createDt;
	
	/** 最后修改人 **/
	@Column(name = "LAST_UPDATE_USER", unique = false, nullable = true, length = 32)
	private String lastUpdateUser;
	
	/** 最后修改时间 **/
	@Column(name = "LAST_UPDATE_DT", unique = false, nullable = true, length = 7)
	private Date lastUpdateDt;
	
	
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}
	
    /**
     * @return Name
     */	
	public String getName() {
		return this.name;
	}
	
	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}
	
    /**
     * @return Password
     */	
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * @param tablespace
	 */
	public void setTablespace(String tablespace) {
		this.tablespace = tablespace == null ? null : tablespace.trim();
	}
	
    /**
     * @return Tablespace
     */	
	public String getTablespace() {
		return this.tablespace;
	}
	
	/**
	 * @param tempTablespace
	 */
	public void setTempTablespace(String tempTablespace) {
		this.tempTablespace = tempTablespace == null ? null : tempTablespace.trim();
	}
	
    /**
     * @return TempTablespace
     */	
	public String getTempTablespace() {
		return this.tempTablespace;
	}
	
	/**
	 * @param sysId
	 */
	public void setSysId(String sysId) {
		this.sysId = sysId == null ? null : sysId.trim();
	}
	
    /**
     * @return SysId
     */	
	public String getSysId() {
		return this.sysId;
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
	 * @param createDt
	 */
	public void setCreateDt(Date createDt) {
		this.createDt = createDt;
	}
	
    /**
     * @return CreateDt
     */	
	public Date getCreateDt() {
		return this.createDt;
	}
	
	/**
	 * @param lastUpdateUser
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
	}
	
    /**
     * @return LastUpdateUser
     */	
	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}
	
	/**
	 * @param lastUpdateDt
	 */
	public void setLastUpdateDt(Date lastUpdateDt) {
		this.lastUpdateDt = lastUpdateDt;
	}
	
    /**
     * @return LastUpdateDt
     */	
	public Date getLastUpdateDt() {
		return this.lastUpdateDt;
	}


}