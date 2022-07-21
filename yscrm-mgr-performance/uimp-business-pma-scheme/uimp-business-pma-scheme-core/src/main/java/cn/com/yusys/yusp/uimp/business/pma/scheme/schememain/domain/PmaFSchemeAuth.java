package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeAuth
 * @类描述: PMA_F_SCHEME_AUTH数据实体类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-26 15:05:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_AUTH")
public class PmaFSchemeAuth extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/** 方案编号 **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 32)
	private String schemeId;
	
	/** 方案编号 **/
	@Column(name = "SCHEME_NAME", unique = false, nullable = true, length = 32)
	private String schemeName;
	
	/** 授权对象编号 **/
	@Column(name = "GRANT_OBJ_ID", unique = false, nullable = true, length = 32)
	private String grantObjId;
	
	/** 授权对象名称 **/
	@Column(name = "GRANT_OBJ_NAME", unique = false, nullable = true, length = 200)
	private String grantObjName;
	
	/** 授权对象类型 码值SQ_OBJ_TYPE **/
	@Column(name = "SQ_OBJ_TYPE", unique = false, nullable = true, length = 2)
	private String sqObjType;
	
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
	 * @param sqObjType
	 */
	public void setSqObjType(String sqObjType) {
		this.sqObjType = sqObjType == null ? null : sqObjType.trim();
	}
	
    /**
     * @return SqObjType
     */	
	public String getSqObjType() {
		return this.sqObjType;
	}


}