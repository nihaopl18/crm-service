package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFImpFillInfo
 * @类描述: PMA_F_IMP_FILL_INFO数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-15 17:34:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_IMP_FILL_INFO")
public class PmaFImpFillInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 指标编号 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 255)
	private String indexId;
	
	/** 评价对象ID **/
	@Column(name = "EVL_OBJ_ID", unique = false, nullable = true, length = 255)
	private String evlObjId;
	
	/** 余额类型 **/
	@Column(name = "BAL_TYPE_ID", unique = false, nullable = true, length = 255)
	private String balTypeId;
	
	/** 指标值 **/
	@Column(name = "INDEX_VALUE", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal indexValue;
	
	/** 评价对象类型 **/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = true, length = 255)
	private String evlObjType;
	
	/** 考核方案ID **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 255)
	private String schemeId;
	
	/** 币种 **/
	@Column(name = "CUR_TYPE_ID", unique = false, nullable = true, length = 255)
	private String curTypeId;
	
	/** 应用类型 **/
	@Column(name = "APPLY_TYPE_ID", unique = false, nullable = true, length = 255)
	private String applyTypeId;
	
	/** 创建者名称 **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 255)
	private String creator;
	
	/** 创建者ID **/
	@Column(name = "CREATOR_ID", unique = false, nullable = true, length = 255)
	private String creatorId;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 255)
	private String createDate;
	
	/** 修改人名称 **/
	@Column(name = "MODIFY_USER", unique = false, nullable = true, length = 255)
	private String modifyUser;
	
	/** 修改人ID **/
	@Column(name = "MODIFY_USER_ID", unique = false, nullable = true, length = 255)
	private String modifyUserId;
	
	/** 修改日期 **/
	@Column(name = "MODIFY_DATE", unique = false, nullable = true, length = 255)
	private String modifyDate;
	
	/** 有效期起始日期 **/
	@Column(name = "START_DATE", unique = false, nullable = true, length = 255)
	private String startDate;
	
	/** 有效期结束日期 **/
	@Column(name = "END_DATE", unique = false, nullable = true, length = 255)
	private String endDate;
	
	/** 日期 **/
	@Column(name = "STAT_DATE", unique = false, nullable = true, length = 255)
	private String statDate;
	
	/** 指标口径 **/
	@Column(name = "APPRAISE_TYPE_ID", unique = false, nullable = true, length = 2)
	private String appraiseTypeId;

	/**指标名称**/
	@Column(name = "INDEX_NAME", unique = false, nullable = true, length = 255)
	private String indexName;
	
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
	 * @param indexId
	 */
	public void setIndexId(String indexId) {
		this.indexId = indexId == null ? null : indexId.trim();
	}
	
    /**
     * @return IndexId
     */	
	public String getIndexId() {
		return this.indexId;
	}
	
	/**
	 * @param evlObjId
	 */
	public void setEvlObjId(String evlObjId) {
		this.evlObjId = evlObjId == null ? null : evlObjId.trim();
	}
	
    /**
     * @return EvlObjId
     */	
	public String getEvlObjId() {
		return this.evlObjId;
	}
	
	/**
	 * @param balTypeId
	 */
	public void setBalTypeId(String balTypeId) {
		this.balTypeId = balTypeId == null ? null : balTypeId.trim();
	}
	
    /**
     * @return BalTypeId
     */	
	public String getBalTypeId() {
		return this.balTypeId;
	}
	
	/**
	 * @param indexValue
	 */
	public void setIndexValue(java.math.BigDecimal indexValue) {
		this.indexValue = indexValue;
	}
	
    /**
     * @return IndexValue
     */	
	public java.math.BigDecimal getIndexValue() {
		return this.indexValue;
	}
	
	/**
	 * @param evlObjType
	 */
	public void setEvlObjType(String evlObjType) {
		this.evlObjType = evlObjType == null ? null : evlObjType.trim();
	}
	
    /**
     * @return EvlObjType
     */	
	public String getEvlObjType() {
		return this.evlObjType;
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
	 * @param curTypeId
	 */
	public void setCurTypeId(String curTypeId) {
		this.curTypeId = curTypeId == null ? null : curTypeId.trim();
	}
	
    /**
     * @return CurTypeId
     */	
	public String getCurTypeId() {
		return this.curTypeId;
	}
	
	/**
	 * @param applyTypeId
	 */
	public void setApplyTypeId(String applyTypeId) {
		this.applyTypeId = applyTypeId == null ? null : applyTypeId.trim();
	}
	
    /**
     * @return ApplyTypeId
     */	
	public String getApplyTypeId() {
		return this.applyTypeId;
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
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate == null ? null : startDate.trim();
	}
	
    /**
     * @return StartDate
     */	
	public String getStartDate() {
		return this.startDate;
	}
	
	/**
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate == null ? null : endDate.trim();
	}
	
    /**
     * @return EndDate
     */	
	public String getEndDate() {
		return this.endDate;
	}
	
	/**
	 * @param statDate
	 */
	public void setStatDate(String statDate) {
		this.statDate = statDate == null ? null : statDate.trim();
	}
	
    /**
     * @return StatDate
     */	
	public String getStatDate() {
		return this.statDate;
	}
	
	/**
	 * @param appraiseTypeId
	 */
	public void setAppraiseTypeId(String appraiseTypeId) {
		this.appraiseTypeId = appraiseTypeId == null ? null : appraiseTypeId.trim();
	}
	
    /**
     * @return AppraiseTypeId
     */	
	public String getAppraiseTypeId() {
		return this.appraiseTypeId;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}
}