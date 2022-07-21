package cn.com.yusys.yusp.uimp.excel.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelgrantInf
 * @类描述: PMA_F_SCHEME_EXCELGRANT_INF考核方案授权信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-06-28 14:05:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_EXCELGRANT_INF")
public class PmaFschemeExcelgrantInf extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 考核方案ID **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 50)
	private String schemeId;
	
	/** 考核方案名称 **/
	@Column(name = "SCHEME_NAME", unique = false, nullable = true, length = 100)
	private String schemeName;
	
	/** 授权对象类型 **/
	@Column(name = "GRANT_OBJ_TYPE", unique = false, nullable = true, length = 10)
	private String grantObjType;
	
	/** 授权对象编号 **/
	@Column(name = "GRANT_OBJ_ID", unique = false, nullable = true, length = 32)
	private String grantObjId;
	
	/** 授权对象名称 **/
	@Column(name = "GRANT_OBJ_NAME", unique = false, nullable = true, length = 100)
	private String grantObjName;
	
	/** 授权范围 **/
	@Column(name = "GRANT_OBJ_RANGE", unique = false, nullable = true, length = 10)
	private String grantObjRange;
	
	/** 创建时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 7)
	private Date createTime;
	
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
	 * @param schemeName
	 */
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName == null ? null : schemeName.trim();
	}
	
    /**
     * @return SchemeName
     */	
	public String getSchemeName() {
		return this.schemeName;
	}
	
	/**
	 * @param grantObjType
	 */
	public void setGrantObjType(String grantObjType) {
		this.grantObjType = grantObjType == null ? null : grantObjType.trim();
	}
	
    /**
     * @return GrantObjType
     */	
	public String getGrantObjType() {
		return this.grantObjType;
	}
	
	/**
	 * @param grantObjId
	 */
	public void setGrantObjId(String grantObjId) {
		this.grantObjId = grantObjId == null ? null : grantObjId.trim();
	}
	
    /**
     * @return GrantObjId
     */	
	public String getGrantObjId() {
		return this.grantObjId;
	}
	
	public String getGrantObjName() {
		return grantObjName;
	}

	public void setGrantObjName(String grantObjName) {
		this.grantObjName = grantObjName;
	}

	/**
	 * @param grantObjRange
	 */
	public void setGrantObjRange(String grantObjRange) {
		this.grantObjRange = grantObjRange == null ? null : grantObjRange.trim();
	}
	
    /**
     * @return GrantObjRange
     */	
	public String getGrantObjRange() {
		return this.grantObjRange;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}