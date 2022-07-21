package cn.com.yusys.yscrm.homepage.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscrm-mgr-sys-homepage-core模块
 * @类名称: OcrmFsysUserCfg
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-17 16:58:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_SYS_USER_CFG")
public class OcrmFsysUserCfg extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键 **/
	@Column(name = "ID", unique = false, nullable = false, length = 32)
	private String id;
	
	/** 用户编号 **/
	@Column(name = "USER_ID", unique = false, nullable = false, length = 32)
	private String userId;
	
	/** 模式 **/
	@Column(name = "MENU_MODEL", unique = false, nullable = false, length = 32)
	private String menuModel;
	
	/** 皮肤 **/
	@Column(name = "THEMES", unique = false, nullable = false, length = 20)
	private String themes;
	
	/** 字号 **/
	@Column(name = "FONT_SIZE", unique = false, nullable = false, length = 20)
	private String fontSize;
	
	/** 语言 **/
	@Column(name = "LANGUAGE", unique = false, nullable = true, length = 20)
	private String language;
	
	/** 备注 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 20)
	private String remark;
	
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}
	
	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
	
    /**
     * @return UserId
     */	
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * @param menuModel
	 */
	public void setMenuModel(String menuModel) {
		this.menuModel = menuModel == null ? null : menuModel.trim();
	}
	
    /**
     * @return MenuModel
     */	
	public String getMenuModel() {
		return this.menuModel;
	}
	
	/**
	 * @param themes
	 */
	public void setThemes(String themes) {
		this.themes = themes == null ? null : themes.trim();
	}
	
    /**
     * @return Themes
     */	
	public String getThemes() {
		return this.themes;
	}
	
	/**
	 * @param fontSize
	 */
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize == null ? null : fontSize.trim();
	}
	
    /**
     * @return FontSize
     */	
	public String getFontSize() {
		return this.fontSize;
	}
	
	/**
	 * @param language
	 */
	public void setLanguage(String language) {
		this.language = language == null ? null : language.trim();
	}
	
    /**
     * @return Language
     */	
	public String getLanguage() {
		return this.language;
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


    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OcrmFsysUserCfg other = (OcrmFsysUserCfg) that;
        		return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
        	&& (this.getMenuModel() == null ? other.getMenuModel() == null : this.getMenuModel().equals(other.getMenuModel()))
        	&& (this.getThemes() == null ? other.getThemes() == null : this.getThemes().equals(other.getThemes()))
        	&& (this.getFontSize() == null ? other.getFontSize() == null : this.getFontSize().equals(other.getFontSize()))
        	&& (this.getLanguage() == null ? other.getLanguage() == null : this.getLanguage().equals(other.getLanguage()))
        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getMenuModel() == null) ? 0 : getMenuModel().hashCode());
        result = prime * result + ((getThemes() == null) ? 0 : getThemes().hashCode());
        result = prime * result + ((getFontSize() == null) ? 0 : getFontSize().hashCode());
        result = prime * result + ((getLanguage() == null) ? 0 : getLanguage().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", userId=").append(userId);
		sb.append(", menuModel=").append(menuModel);
		sb.append(", themes=").append(themes);
		sb.append(", fontSize=").append(fontSize);
		sb.append(", language=").append(language);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}