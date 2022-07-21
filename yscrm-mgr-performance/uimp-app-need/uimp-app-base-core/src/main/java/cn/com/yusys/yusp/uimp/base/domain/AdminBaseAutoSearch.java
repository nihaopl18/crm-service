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
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseAutoSearch
 * @类描述: ADMIN_BASE_AUTO_SEARCH数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-17 10:54:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_BASE_AUTO_SEARCH")
public class AdminBaseAutoSearch extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 功能名称 **/
	@Column(name = "FUN_NAME", unique = false, nullable = true, length = 50)
	private String funName;
	
	/** 表名 **/
	@Column(name = "TABLE_EN_NAME", unique = false, nullable = true, length = 50)
	private String tableEnName;
	
	/** 表中文名 **/
	@Column(name = "TABLE_CN_NAME", unique = false, nullable = true, length = 50)
	private String tableCnName;
	
	/** 是否配置 **/
	@Column(name = "IF_CONF", unique = false, nullable = true, length = 10)
	private String ifConf;
	
	/** 配置Url **/
	@Column(name = "CONF_URL", unique = false, nullable = true, length = 200)
	private String confUrl;
	
	/** 描述 **/
	@Column(name = "DESCRIBE", unique = false, nullable = true, length = 500)
	private String describe;
	
	@Column(name = "ORG_DATA_AUTH", unique = false, nullable = true, length = 100)
	private String orgDataAuth;
	
	@Column(name = "TABLE_TYPE", unique = false, nullable = true, length = 10)
	private String tableType;
	
	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public String getOrgDataAuth() {
		return orgDataAuth;
	}

	public void setOrgDataAuth(String orgDataAuth) {
		this.orgDataAuth = orgDataAuth;
	}

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
	 * @param funName
	 */
	public void setFunName(String funName) {
		this.funName = funName == null ? null : funName.trim();
	}
	
    /**
     * @return FunName
     */	
	public String getFunName() {
		return this.funName;
	}
	
	/**
	 * @param tableEnName
	 */
	public void setTableEnName(String tableEnName) {
		this.tableEnName = tableEnName == null ? null : tableEnName.trim();
	}
	
    /**
     * @return TableEnName
     */	
	public String getTableEnName() {
		return this.tableEnName;
	}
	
	/**
	 * @param tableCnName
	 */
	public void setTableCnName(String tableCnName) {
		this.tableCnName = tableCnName == null ? null : tableCnName.trim();
	}
	
    /**
     * @return TableCnName
     */	
	public String getTableCnName() {
		return this.tableCnName;
	}
	
	/**
	 * @param ifConf
	 */
	public void setIfConf(String ifConf) {
		this.ifConf = ifConf == null ? null : ifConf.trim();
	}
	
    /**
     * @return IfConf
     */	
	public String getIfConf() {
		return this.ifConf;
	}
	
	/**
	 * @param confUrl
	 */
	public void setConfUrl(String confUrl) {
		this.confUrl = confUrl == null ? null : confUrl.trim();
	}
	
    /**
     * @return ConfUrl
     */	
	public String getConfUrl() {
		return this.confUrl;
	}
	
	/**
	 * @param describe
	 */
	public void setDescribe(String describe) {
		this.describe = describe == null ? null : describe.trim();
	}
	
    /**
     * @return Describe
     */	
	public String getDescribe() {
		return this.describe;
	}


}