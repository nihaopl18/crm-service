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
 * @类名称: AdminBaseDisplayInfo
 * @类描述: ADMIN_BASE_DISPLAY_INFO数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-06 20:40:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_BASE_DISPLAY_INFO")
public class AdminBaseDisplayInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 标题 **/
	@Column(name = "TITLE", unique = false, nullable = true, length = 50)
	private String title;
	
	/** 地址 **/
	@Column(name = "ADDR", unique = false, nullable = true, length = 200)
	private String addr;
	
	/** 图标 **/
	@Column(name = "IMG", unique = false, nullable = true, length = 200)
	private String img;
	
	/** TAG **/
	@Column(name = "TAGS", unique = false, nullable = true, length = 200)
	private String tags;
	
	/** 是否关注，1-是，0-否 **/
	@Column(name = "STAR", unique = false, nullable = true, length = 2)
	private String star;
	
	
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}
	
    /**
     * @return Title
     */	
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * @param addr
	 */
	public void setAddr(String addr) {
		this.addr = addr == null ? null : addr.trim();
	}
	
    /**
     * @return Addr
     */	
	public String getAddr() {
		return this.addr;
	}
	
	/**
	 * @param img
	 */
	public void setImg(String img) {
		this.img = img == null ? null : img.trim();
	}
	
    /**
     * @return Img
     */	
	public String getImg() {
		return this.img;
	}
	
	/**
	 * @param tags
	 */
	public void setTags(String tags) {
		this.tags = tags == null ? null : tags.trim();
	}
	
    /**
     * @return Tags
     */	
	public String getTags() {
		return this.tags;
	}
	
	/**
	 * @param star
	 */
	public void setStar(String star) {
		this.star = star == null ? null : star.trim();
	}
	
    /**
     * @return Star
     */	
	public String getStar() {
		return this.star;
	}


}