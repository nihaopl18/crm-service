package cn.com.yusys.yusp.uimp.excel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelTmpInfo
 * @类描述: PMA_F_SCHEME_EXCELTMP_INF考核方案报表模板信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:01:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_EXCELTMP_INF")
public class PmaFschemeExcelTmpInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 模板ID **/
	@Id
	@Column(name = "TEMPLATE_ID")
	@Generated(GenerationType.UUID)
	private String templateId;
	
	/** 考核方案ID **/
	@Column(name = "SCHEME_ID", unique = false, nullable = false, length = 50)
	private String schemeId;
	
	/** 模板内容JSON **/
	@Column(name = "TEMPLATE_CONTENTJSON", unique = false, nullable = false, length = 4000)
	private String templateContentjson;
	
	/** 模板类型 **/
	@Column(name = "TEMPLATE_TYPE", unique = false, nullable = false, length = 10)
	private String templateType;
	
	/** 考核对象类型 **/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = false, length = 2)
	private String evlObjType;
	
	
	/**
	 * @param templateId
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId == null ? null : templateId.trim();
	}
	
    /**
     * @return TemplateId
     */	
	public String getTemplateId() {
		return this.templateId;
	}
	
	/**
	 * @param schemeId
	 */
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId == null ? null : schemeId.trim();
	}
	
    /**
     * @return SchemeId
     */	
	public String getSchemeId() {
		return this.schemeId;
	}
	
	/**
	 * @param templateContentjson
	 */
	public void setTemplateContentjson(String templateContentjson) {
		this.templateContentjson = templateContentjson == null ? null : templateContentjson.trim();
	}
	
    /**
     * @return TemplateContentjson
     */	
	public String getTemplateContentjson() {
		return this.templateContentjson;
	}
	
	/**
	 * @param templateType
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType == null ? null : templateType.trim();
	}
	
    /**
     * @return TemplateType
     */	
	public String getTemplateType() {
		return this.templateType;
	}

	/**
     * @return evlObjType
     */	
	public String getEvlObjType() {
		return evlObjType;
	}

	/**
	 * @param evlObjType
	 */
	public void setEvlObjType(String evlObjType) {
		this.evlObjType = evlObjType;
	}

}