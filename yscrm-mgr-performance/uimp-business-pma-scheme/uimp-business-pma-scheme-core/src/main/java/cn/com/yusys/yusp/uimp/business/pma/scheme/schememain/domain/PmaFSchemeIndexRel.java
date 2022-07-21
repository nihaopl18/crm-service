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
 * @类名称: PmaFSchemeIndexRel
 * @类描述: PMA_F_SCHEME_INDEX_REL数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-20 10:36:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFSchemeIndexRel", description = "考核方案与指标关系表")
@Entity
@Table(name = "PMA_F_SCHEME_INDEX_REL")
public class PmaFSchemeIndexRel extends BaseDomain implements Serializable{
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
	
	/** 指标编号 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 8)
	@ApiModelProperty(value = "指标编号", name = "indexId", required = false)
	private String indexId;
	
	/** 指标类型 **/
	@Column(name = "INDEX_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "指标类型", name = "indexType", required = false)
	private String indexType;

	/** 余额类型 **/
	@Column(name = "BAL_TYPE_ID", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "余额类型", name = "balTypeId", required = false)
	private String balTypeId;
	
	/** 评价对象类型 **/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "评价对象类型", name = "evlObjType", required = false)
	private String evlObjType;
	
	/** 应用类型 **/
	@Column(name = "APPLY_TYPE_ID", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "应用类型", name = "applyTypeId", required = false)
	private String applyTypeId;
	
	/** 绩效维度 **/
	@Column(name = "DIMENSION_ID", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "绩效维度", name = "dimensionId", required = false)
	private String dimensionId;


	/** 创建者ID **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "创建者ID", name = "creator", required = true)
	private String creator;

	/** 创建时间 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 8)
	@ApiModelProperty(value = "创建时间", name = "createDate", required = true)
	private String createDate;

	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "创建机构", name = "createOrg", required = true)
	private String createOrg;

	/** 修改者ID **/
	@Column(name = "UPDATER_ID", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "修改者ID", name = "updaterId", required = true)
	private String updaterId;

	/** 修改时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length =8)
	@ApiModelProperty(value = "修改时间", name = "updateDate", required = true)
	private String updateDate;

	/** 修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 32)
	@ApiModelProperty(value = "修改机构", name = "updateOrg", required = true)
	private String updateOrg;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getIndexId() {
		return indexId;
	}

	public void setIndexId(String indexId) {
		this.indexId = indexId;
	}

	public String getIndexType() {
		return indexType;
	}

	public void setIndexType(String indexType) {
		this.indexType = indexType;
	}

	public String getBalTypeId() {
		return balTypeId;
	}

	public void setBalTypeId(String balTypeId) {
		this.balTypeId = balTypeId;
	}

	public String getEvlObjType() {
		return evlObjType;
	}

	public void setEvlObjType(String evlObjType) {
		this.evlObjType = evlObjType;
	}

	public String getApplyTypeId() {
		return applyTypeId;
	}

	public void setApplyTypeId(String applyTypeId) {
		this.applyTypeId = applyTypeId;
	}

	public String getDimensionId() {
		return dimensionId;
	}

	public void setDimensionId(String dimensionId) {
		this.dimensionId = dimensionId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateOrg() {
		return createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateOrg() {
		return updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}
}