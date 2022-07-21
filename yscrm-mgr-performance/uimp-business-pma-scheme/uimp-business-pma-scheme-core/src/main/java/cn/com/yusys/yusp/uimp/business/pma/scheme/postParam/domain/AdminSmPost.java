package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminSmPost
 * @类描述: ADMIN_SM_POST数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-13 17:39:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_SM_POST")
public class AdminSmPost extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 法人机构号 **/
	@Column(name = "LAW_ORG_NB", unique = false, nullable = true, length = 200)
	private String lawOrgNb;
	
	/** 岗位编号 **/
	@Column(name = "SYS_POST_CODE", unique = false, nullable = true, length = 50)
	private String sysPostCode;
	
	/** 岗位名称 **/
	@Column(name = "SYS_POST_NAME", unique = false, nullable = true, length = 500)
	private String sysPostName;
	
	/** 岗位等级 **/
	@Column(name = "SYS_LV", unique = false, nullable = true, length = 20)
	private String sysLv;
	
	
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
	 * @param lawOrgNb
	 */
	public void setLawOrgNb(String lawOrgNb) {
		this.lawOrgNb = lawOrgNb == null ? null : lawOrgNb.trim();
	}
	
    /**
     * @return LawOrgNb
     */	
	public String getLawOrgNb() {
		return this.lawOrgNb;
	}
	
	/**
	 * @param sysPostCode
	 */
	public void setSysPostCode(String sysPostCode) {
		this.sysPostCode = sysPostCode == null ? null : sysPostCode.trim();
	}
	
    /**
     * @return SysPostCode
     */	
	public String getSysPostCode() {
		return this.sysPostCode;
	}
	
	/**
	 * @param sysPostName
	 */
	public void setSysPostName(String sysPostName) {
		this.sysPostName = sysPostName == null ? null : sysPostName.trim();
	}
	
    /**
     * @return SysPostName
     */	
	public String getSysPostName() {
		return this.sysPostName;
	}
	
	/**
	 * @param sysLv
	 */
	public void setSysLv(String sysLv) {
		this.sysLv = sysLv == null ? null : sysLv.trim();
	}
	
    /**
     * @return SysLv
     */	
	public String getSysLv() {
		return this.sysLv;
	}


}