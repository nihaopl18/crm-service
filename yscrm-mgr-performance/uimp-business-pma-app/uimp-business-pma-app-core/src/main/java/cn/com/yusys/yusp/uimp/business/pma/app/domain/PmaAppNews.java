package cn.com.yusys.yusp.uimp.business.pma.app.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-app-core模块
 * @类名称: PmaAppNews
 * @类描述: PMA_APP_NEWS数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-03 11:02:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_APP_NEWS")
public class PmaAppNews extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 新闻事件名称 **/
	@Column(name = "NAME", unique = false, nullable = true, length = 100)
	private String name;
	
	/** 新闻图片路径  **/
	@Column(name = "FILE_PATH", unique = false, nullable = true, length = 500)
	private String filePath;
	
	/** 状态1-有效，0-无效 **/
	@Column(name = "STATE", unique = false, nullable = true, length = 2)
	private String state;
	
	/** 创建人                         **/
	@Column(name = "CRAT_USE", unique = false, nullable = true, length = 32)
	private String cratUse;
	
	/** 创建机构                       **/
	@Column(name = "CRAT_ORG", unique = false, nullable = true, length = 32)
	private String cratOrg;
	
	/** 创建时间                       **/
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 维护时间                       **/
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 维护人                         **/
	@Column(name = "LAST_CHG_USE", unique = false, nullable = true, length = 32)
	private String lastChgUse;
	
	/** 维护机构                       **/
	@Column(name = "LAST_CHG_ORG", unique = false, nullable = true, length = 32)
	private String lastChgOrg;
	
	/** 删除标志0--删除1正常           **/
	@Column(name = "IS_DEL", unique = false, nullable = true, length = 2)
	private String isDel;
	
	/** 新闻事件详情地址 **/
	@Column(name = "URL", unique = false, nullable = true, length = 200)
	private String url;
	
	
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
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath == null ? null : filePath.trim();
	}
	
    /**
     * @return FilePath
     */	
	public String getFilePath() {
		return this.filePath;
	}
	
	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
	
    /**
     * @return State
     */	
	public String getState() {
		return this.state;
	}
	
	/**
	 * @param cratUse
	 */
	public void setCratUse(String cratUse) {
		this.cratUse = cratUse == null ? null : cratUse.trim();
	}
	
    /**
     * @return CratUse
     */	
	public String getCratUse() {
		return this.cratUse;
	}
	
	/**
	 * @param cratOrg
	 */
	public void setCratOrg(String cratOrg) {
		this.cratOrg = cratOrg == null ? null : cratOrg.trim();
	}
	
    /**
     * @return CratOrg
     */	
	public String getCratOrg() {
		return this.cratOrg;
	}
	
	/**
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
	}
	
	/**
	 * @param lastChgUse
	 */
	public void setLastChgUse(String lastChgUse) {
		this.lastChgUse = lastChgUse == null ? null : lastChgUse.trim();
	}
	
    /**
     * @return LastChgUse
     */	
	public String getLastChgUse() {
		return this.lastChgUse;
	}
	
	/**
	 * @param lastChgOrg
	 */
	public void setLastChgOrg(String lastChgOrg) {
		this.lastChgOrg = lastChgOrg == null ? null : lastChgOrg.trim();
	}
	
    /**
     * @return LastChgOrg
     */	
	public String getLastChgOrg() {
		return this.lastChgOrg;
	}
	
	/**
	 * @param isDel
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel == null ? null : isDel.trim();
	}
	
    /**
     * @return IsDel
     */	
	public String getIsDel() {
		return this.isDel;
	}
	
	/**
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}
	
    /**
     * @return Url
     */	
	public String getUrl() {
		return this.url;
	}


}