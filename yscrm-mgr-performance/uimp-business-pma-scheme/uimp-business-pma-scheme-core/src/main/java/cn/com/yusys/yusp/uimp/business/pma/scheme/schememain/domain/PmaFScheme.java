package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFScheme
 * @类描述: PMA_F_SCHEME数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 15:01:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFScheme", description = "考核方案信息表")
@Entity
@Table(name = "PMA_F_SCHEME")
public class PmaFScheme extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "ID", name = "id", required = false)
	private String id;

	/** 考核方案ID **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "考核方案ID", name = "schemeId", required = false)
	private String schemeId;
	
	/** 考核方案名称 **/
	@Column(name = "SCHEME_NAME", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "考核方案名称", name = "schemeName", required = false)
	private String schemeName;
	
	/** 方案描述 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 300)
	@ApiModelProperty(value = "方案描述", name = "remark", required = false)
	private String remark;
	
	/** 机构等级 **/
	@Column(name = "ORG_LEVEL", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "机构等级", name = "orgLevel", required = false)
	private String orgLevel;
	
	/** 考核方案目录编号 **/
	@Column(name = "MENU_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "考核方案目录编号", name = "menuId", required = false)
	private String menuId;
	
	/** 创建者ID **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "创建者ID", name = "creator", required = false)
	private String creator;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "创建日期", name = "createDate", required = false)
	private String createDate;
	
	/** 最后修改者ID **/
	@Column(name = "UPDATER_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "最后修改者ID", name = "updaterId", required = false)
	private String updaterId;
	
	/** 最后更新日期 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "最后更新日期", name = "updateDate", required = false)
	private String updateDate;
	
	/** 方案所属机构     **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "方案所属机构", name = "orgId", required = false)
	private String orgId;
	
	
	/** 生效日期 **/
	@Column(name = "START_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "生效日期", name = "startDate", required = false)
	private String startDate;
	
	/** 失效日期 **/
	@Column(name = "END_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "失效日期", name = "endDate", required = false)
	private String endDate;
	
	/** 考核场景 **/
	@Column(name = "CHECK_SCENE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "考核场景", name = "checkScene", required = false)
	private String checkScene;
	
	/** 评价对象类型 **/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "评价对象类型", name = "evlObjType", required = false)
	private String evlObjType;
	
	/** 特殊规则类型 **/
	@Column(name = "SPE_RULE_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "特殊规则类型", name = "speRuleType", required = false)
	private String speRuleType;
	
	/** 数据删除标志 **/
	@Column(name = "STAT_FLAG", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "数据删除标志", name = "statFlag", required = false)
	private String statFlag;
	
	@Column(name = "SCHEME_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "考核类型", name = "schemeType", required = false)
	private String schemeType;
	
	@Column(name = "IS_EXCEL", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "是否是Excel", name = "isExcel", required = false)
	private String isExcel;


	@Column(name = "SCHEME_CYCLE_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "考核方案周期类型", name = "schemeCycleType", required = false)
	private String schemeCycleType;
	
	public String getSchemeType() {
		return schemeType;
	}

	public String getIsExcel() {
		return isExcel;
	}

	public void setIsExcel(String isExcel) {
		this.isExcel = isExcel;
	}

	public void setSchemeType(String schemeType) {
		this.schemeType = schemeType;
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
	
	/**
	 * @param orgLevel
	 */
	public void setOrgLevel(String orgLevel) {
		this.orgLevel = orgLevel == null ? null : orgLevel.trim();
	}
	
    /**
     * @return OrgLevel
     */	
	public String getOrgLevel() {
		return this.orgLevel;
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
	 * @param updaterId
	 */
	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId == null ? null : updaterId.trim();
	}
	
    /**
     * @return UpdaterId
     */	
	public String getUpdaterId() {
		return this.updaterId;
	}
	
	/**
	 * @param updateDate
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate == null ? null : updateDate.trim();
	}
	
    /**
     * @return UpdateDate
     */	
	public String getUpdateDate() {
		return this.updateDate;
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
	 * @param checkScene
	 */
	public void setCheckScene(String checkScene) {
		this.checkScene = checkScene == null ? null : checkScene.trim();
	}
	
    /**
     * @return CheckScene
     */	
	public String getCheckScene() {
		return this.checkScene;
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
	 * @param speRuleType
	 */
	public void setSpeRuleType(String speRuleType) {
		this.speRuleType = speRuleType == null ? null : speRuleType.trim();
	}
	
    /**
     * @return SpeRuleType
     */	
	public String getSpeRuleType() {
		return this.speRuleType;
	}
	
	/**
	 * @param statFlag
	 */
	public void setStatFlag(String statFlag) {
		this.statFlag = statFlag == null ? null : statFlag.trim();
	}
	
    /**
     * @return StatFlag
     */	
	public String getStatFlag() {
		return this.statFlag;
	}

	public String getSchemeCycleType() {
		return schemeCycleType;
	}

	public void setSchemeCycleType(String schemeCycleType) {
		this.schemeCycleType = schemeCycleType;
	}
}