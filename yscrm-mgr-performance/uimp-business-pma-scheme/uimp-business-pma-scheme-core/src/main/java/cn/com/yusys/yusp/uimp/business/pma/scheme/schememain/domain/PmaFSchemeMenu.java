package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeMenu
 * @类描述: PMA_F_SCHEME_MENU数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 09:56:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFSchemeMenu", description = "考核方案目录表")
@Entity
@Table(name = "PMA_F_SCHEME_MENU")
public class PmaFSchemeMenu extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 考核方案目录编号 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "MENU_ID")
	@ApiModelProperty(value = "考核方案目录编号", name = "menuId", required = false)
	private String menuId;

	/** 考核方案目录名称 **/
	@Column(name = "MENU_NAME", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "考核方案目录名称", name = "menuName", required = false)
	private String menuName;
	
	/** 机构等级 **/
	@Column(name = "ORG_LEVEL", unique = false, nullable = true, length = 10)
	@ApiModelProperty(value = "机构等级", name = "orgLevel", required = false)
	private String orgLevel;
	
	/** 父方案目录编号 **/
	@Column(name = "PARENT_MENU_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "父方案目录编号", name = "parentMenuId", required = false)
	private String parentMenuId;
	
	/** 描述 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 300)
	@ApiModelProperty(value = "描述", name = "remark", required = false)
	private String remark;
	
	/** 创建者ID **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "创建者ID", name = "creator", required = false)
	private String creator;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "创建日期", name = "createDate", required = false)
	private String createDate;
	
	/** 最后修改者 **/
	@Column(name = "UPDATE_USER", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "最后修改者", name = "updateUser", required = false)
	private String updateUser;
	
	/** 最后更新日期 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "最后更新日期 ", name = "updateDate", required = false)
	private String updateDate;
	
	/** 方案所在机构编号 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "方案所在机构编号", name = "orgId", required = false)
	private String orgId;
	
	
	/**
	 * @param menuId
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId == null ? null : menuId.trim();
	}
	
    /**
     * @return MenuId
     */	
	public String getMenuId() {
		return this.menuId;
	}
	
	/**
	 * @param menuName
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName == null ? null : menuName.trim();
	}
	
    /**
     * @return MenuName
     */	
	public String getMenuName() {
		return this.menuName;
	}
	
	/**
	 * @param orgLevel
	 */
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel == null ? null : orgLevel.trim();
	}
	
    /**
     * @return OrgLevel
     */	
	public String getOrgLevel() {
		return this.orgLevel;
	}
	
	/**
	 * @param parentMenuId
	 */
	public void setParentMenuId(String parentMenuId) {
		this.parentMenuId = parentMenuId == null ? null : parentMenuId.trim();
	}
	
    /**
     * @return ParentMenuId
     */	
	public String getParentMenuId() {
		return this.parentMenuId;
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
	 * @param creator
	 */
	public void setCreator(String creator) {
		this.creator = creator == null ? null : creator.trim();
	}
	
    /**
     * @return Creator
     */	
	public String getCreator() {
		return this.creator;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}
	
    /**
     * @return CreateDate
     */	
	public String getCreateDate() {
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
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate == null ? null : updateDate.trim();
	}
	
    /**
     * @return UpdateDate
     */	
	public String getUpdateDate() {
		return this.updateDate;
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