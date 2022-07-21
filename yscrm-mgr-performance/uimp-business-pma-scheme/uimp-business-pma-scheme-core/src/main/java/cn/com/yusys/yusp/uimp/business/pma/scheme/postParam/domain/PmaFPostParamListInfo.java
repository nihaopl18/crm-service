package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFPostParamListInfo
 * @类描述: PMA_F_POST_PARAM_LIST_INFO数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-13 09:50:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_POST_PARAM_LIST_INFO")
public class PmaFPostParamListInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 参数编号 **/
	@Column(name = "PARAM_ID", unique = false, nullable = true, length = 50)
	private String paramId;
	
	/** 机构编号 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 50)
	private String orgId;
	
	/** 创建者ID **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 50)
	private String creator;
	
	/** 创建者 **/
	@Column(name = "CREATOR_ID", unique = false, nullable = true, length = 50)
	private String creatorId;
	
	/** 创建时间 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private String createDate;
	
	/** 修改者ID **/
	@Column(name = "MODIFY_USER", unique = false, nullable = true, length = 50)
	private String modifyUser;
	
	/** 修改者 **/
	@Column(name = "MODIFY_USER_ID", unique = false, nullable = true, length = 50)
	private String modifyUserId;
	
	/** 修改时间 **/
	@Column(name = "MODIFY_DATE", unique = false, nullable = true, length = 20)
	private String modifyDate;
	
	/** 参数值 **/
	@Column(name = "PARAM_VALUE", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal paramValue;
	
	/** EFFECT_POST **/
	@Column(name = "EFFECT_POST", unique = false, nullable = true, length = 20)
	private String effectPost;
	
	/** EFFECT_POST_NAME **/
	@Column(name = "EFFECT_POST_NAME", unique = false, nullable = true, length = 20)
	private String effectPostName;
	
	private List<PmaFPostParamPerInfo>  list;
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
	 * @param paramId
	 */
	public void setParamId(String paramId) {
		this.paramId = paramId == null ? null : paramId.trim();
	}
	
    /**
     * @return ParamId
     */	
	public String getParamId() {
		return this.paramId;
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
	 * @param creatorId
	 */
	public void setCreatorId(String creatorId) {
		this.creatorId = creatorId == null ? null : creatorId.trim();
	}
	
    /**
     * @return CreatorId
     */	
	public String getCreatorId() {
		return this.creatorId;
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
	 * @param modifyUser
	 */
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser == null ? null : modifyUser.trim();
	}
	
    /**
     * @return ModifyUser
     */	
	public String getModifyUser() {
		return this.modifyUser;
	}
	
	/**
	 * @param modifyUserId
	 */
	public void setModifyUserId(String modifyUserId) {
		this.modifyUserId = modifyUserId == null ? null : modifyUserId.trim();
	}
	
    /**
     * @return ModifyUserId
     */	
	public String getModifyUserId() {
		return this.modifyUserId;
	}
	
	/**
	 * @param modifyDate
	 */
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate == null ? null : modifyDate.trim();
	}
	
    /**
     * @return ModifyDate
     */	
	public String getModifyDate() {
		return this.modifyDate;
	}
	
	/**
	 * @param paramValue
	 */
	public void setParamValue(java.math.BigDecimal paramValue) {
		this.paramValue = paramValue;
	}
	
    /**
     * @return ParamValue
     */	
	public java.math.BigDecimal getParamValue() {
		return this.paramValue;
	}
	
	/**
	 * @param effectPost
	 */
	public void setEffectPost(String effectPost) {
		this.effectPost = effectPost == null ? null : effectPost.trim();
	}
	
    /**
     * @return EffectPost
     */	
	public String getEffectPost() {
		return this.effectPost;
	}
	
	/**
	 * @param effectPostName
	 */
	public void setEffectPostName(String effectPostName) {
		this.effectPostName = effectPostName == null ? null : effectPostName.trim();
	}
	
    /**
     * @return EffectPostName
     */	
	public String getEffectPostName() {
		return this.effectPostName;
	}

	public List<PmaFPostParamPerInfo> getList() {
		return list;
	}

	public void setList(List<PmaFPostParamPerInfo> list) {
		this.list = list;
	}


}