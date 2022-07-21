package cn.com.yusys.yusp.uimp.business.pma.menuClick.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminSmMenuStat
 * @类描述: ADMIN_SM_MENU_STAT数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-04-03 13:57:16
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_SM_MENU_STAT")
public class AdminSmMenuStat extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** id **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 菜单id **/
	@Column(name = "MENU_ID", unique = false, nullable = true, length = 32)
	private String menuId;
	
	/** 菜单名称 **/
	@Column(name = "MENU_NAME", unique = false, nullable = true, length = 100)
	private String menuName;
	
	/** 上级菜单id **/
	@Column(name = "PARENT_MENU_ID", unique = false, nullable = true, length = 32)
	private String parentMenuId;
	@Column(name = "PARENT_MENU_NAME", unique = false, nullable = true, length = 100)
	private String parentMenuName;
	@Column(name = "CLICK_NUM", unique = false, nullable = true, length = 20)
	private String clickNum;
	
	
	public String getParentMenuName() {
		return parentMenuName;
	}

	public void setParentMenuName(String parentMenuName) {
		this.parentMenuName = parentMenuName;
	}

	public String getClickNum() {
		return clickNum;
	}

	public void setClickNum(String clickNum) {
		this.clickNum = clickNum;
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


}