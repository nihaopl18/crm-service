package cn.com.yusys.yusp.uimp.business.pma.menuClick.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminSmMenuClickO
 * @类描述: ADMIN_SM_MENU_CLICK_O数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-04-03 09:24:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_SM_MENU_CLICK_O")
public class AdminSmMenuClickO extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 业绩分配模块点击次数 **/
	@Column(name = "DSTR_CLICK_NUM", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal dstrClickNum;
	
	/** 业绩查询点击次数 **/
	@Column(name = "SEL_CLICK_NUM", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal selClickNum;
	
	/** 考核方案点击次数 **/
	@Column(name = "SCHEME_CLICK_NUM", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal schemeClickNum;
	
	/** 系统管理点击次数 **/
	@Column(name = "SM_CLICK_NUM", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal smClickNum;
	
	/** 机构号 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 50)
	private String orgId;
	
	
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
	 * @param dstrClickNum
	 */
	public void setDstrClickNum(java.math.BigDecimal dstrClickNum) {
		this.dstrClickNum = dstrClickNum;
	}
	
    /**
     * @return DstrClickNum
     */	
	public java.math.BigDecimal getDstrClickNum() {
		return this.dstrClickNum;
	}
	
	/**
	 * @param selClickNum
	 */
	public void setSelClickNum(java.math.BigDecimal selClickNum) {
		this.selClickNum = selClickNum;
	}
	
    /**
     * @return SelClickNum
     */	
	public java.math.BigDecimal getSelClickNum() {
		return this.selClickNum;
	}
	
	/**
	 * @param schemeClickNum
	 */
	public void setSchemeClickNum(java.math.BigDecimal schemeClickNum) {
		this.schemeClickNum = schemeClickNum;
	}
	
    /**
     * @return SchemeClickNum
     */	
	public java.math.BigDecimal getSchemeClickNum() {
		return this.schemeClickNum;
	}
	
	/**
	 * @param smClickNum
	 */
	public void setSmClickNum(java.math.BigDecimal smClickNum) {
		this.smClickNum = smClickNum;
	}
	
    /**
     * @return SmClickNum
     */	
	public java.math.BigDecimal getSmClickNum() {
		return this.smClickNum;
	}
	
	/**
	 * @param orgId
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}
	
    /**
     * @return OrgId
     */	
	public String getOrgId() {
		return this.orgId;
	}


}