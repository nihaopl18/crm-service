package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaASchemeIndexRel
 * @类描述: PMA_A_SCHEME_INDEX_REL数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-19 16:20:53
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_A_SCHEME_INDEX_REL")
public class PmaASchemeIndexRel extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 考核方案ID **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 50)
	private String schemeId;
	
	/** 指标编号 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 8)
	private String indexId;
	
	/** 指标类型 **/
	@Column(name = "INDEX_TYPE", unique = false, nullable = true, length = 2)
	private String indexType;
	
	/** 创建者ID **/
	@Column(name = "CREATER_ID", unique = false, nullable = true, length = 50)
	private String createrId;
	
	/** 创建者 **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 100)
	private String creator;
	
	/** 创建时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 20)
	private String createTime;
	
	/** 修改者ID **/
	@Column(name = "MODIFY_USER_ID", unique = false, nullable = true, length = 50)
	private String modifyUserId;
	
	/** 修改者 **/
	@Column(name = "MODIFY_USER_NAME", unique = false, nullable = true, length = 100)
	private String modifyUserName;
	
	/** 修改时间 **/
	@Column(name = "MODIFY_TIME", unique = false, nullable = true, length = 20)
	private String modifyTime;
	
	/** 余额类型 **/
	@Column(name = "BAL_TYPE_ID", unique = false, nullable = true, length = 2)
	private String balTypeId;
	
	/** 评价对象类型 **/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = true, length = 2)
	private String evlObjType;
	
	/** 应用类型 **/
	@Column(name = "APPLY_TYPE_ID", unique = false, nullable = true, length = 2)
	private String applyTypeId;
	
	/** 绩效维度 **/
	@Column(name = "DIMENSION_ID", unique = false, nullable = true, length = 2)
	private String dimensionId;
	
	/** APPRAISE_TYPE_ID **/
	@Column(name = "APPRAISE_TYPE_ID", unique = false, nullable = true, length = 2)
	private String appraiseTypeId;
	
	/** CUR_TYPE_ID **/
	@Column(name = "CUR_TYPE_ID", unique = false, nullable = true, length = 2)
	private String curTypeId;
	
	
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
	 * @param indexType
	 */
	public void setIndexType(String indexType) {
		this.indexType = indexType == null ? null : indexType.trim();
	}
	
    /**
     * @return IndexType
     */	
	public String getIndexType() {
		return this.indexType;
	}
	
	/**
	 * @param createrId
	 */
	public void setCreaterId(String createrId) {
		this.createrId = createrId == null ? null : createrId.trim();
	}
	
    /**
     * @return CreaterId
     */	
	public String getCreaterId() {
		return this.createrId;
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
	 * @param createTime
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime == null ? null : createTime.trim();
	}
	
    /**
     * @return CreateTime
     */	
	public String getCreateTime() {
		return this.createTime;
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
	 * @param modifyUserName
	 */
	public void setModifyUserName(String modifyUserName) {
		this.modifyUserName = modifyUserName == null ? null : modifyUserName.trim();
	}
	
    /**
     * @return ModifyUserName
     */	
	public String getModifyUserName() {
		return this.modifyUserName;
	}
	
	/**
	 * @param modifyTime
	 */
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime == null ? null : modifyTime.trim();
	}
	
    /**
     * @return ModifyTime
     */	
	public String getModifyTime() {
		return this.modifyTime;
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
	 * @param dimensionId
	 */
	public void setDimensionId(String dimensionId) {
		this.dimensionId = dimensionId == null ? null : dimensionId.trim();
	}
	
    /**
     * @return DimensionId
     */	
	public String getDimensionId() {
		return this.dimensionId;
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


}