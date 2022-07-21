package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain;


import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-core模块
 * @类名称: PmaFBaseIndexInfo
 * @类描述: PMA_F_BASE_INDEX_INFO数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2019-12-24 16:17:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFBaseIndexInfo", description = "基础指标管理")
@Entity
@Table(name = "PMA_F_BASE_INDEX_INFO")
public class PmaFBaseIndexInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "主键", name = "id", required = false)
	private String id;

	/** 基础指标名称 **/
	@Column(name = "INDEX_NAME", unique = false, nullable = true, length = 200)
	@ApiModelProperty(value = "基础指标名称", name = "indexName", required = true)
	private String indexName;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "创建机构", name = "createOrg", required = true)
	private String createOrg;
	
	
	/** 业务类型 **/
	@Column(name = "INDEX_BUSINESS_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "业务类型", name = "indexBusinessType", required = true)
	private String indexBusinessType;
	
	/** 创建者ID **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "创建者ID", name = "creator", required = true)
	private String creator;
	
	/** 创建时间 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 8)
	@ApiModelProperty(value = "创建时间", name = "createDate", required = true)
	private String createDate;
	
	/** 修改者ID **/
	@Column(name = "UPDATER_ID", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "修改者ID", name = "updaterId", required = true)
	private String updaterId;
	
	/** 修改时间 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length =8)
	@ApiModelProperty(value = "修改时间", name = "updateDate", required = true)
	private String updateDate;
	
	/** 基础指标编号 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 8)
	@ApiModelProperty(value = "基础指标编号", name = "indexId", required = true)
	private String indexId;
	
	/** 指标类型 **/
	@Column(name = "INDEX_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "指标类型", name = "indexType", required = true)
	private String indexType;
	
	/** 修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 32)
	@ApiModelProperty(value = "修改机构", name = "updateOrg", required = true)
	private String updateOrg;
	
	/** 指标状态(0停用 1启用) **/
	@Column(name = "INDEX_STATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "指标状态", name = "indexState", required = true)
	private String indexState;
	
	/** 指标所属目录ID **/
	@Column(name = "INDEX_CATALOG_ID", unique = false, nullable = true, length = 32)
	@ApiModelProperty(value = "指标所属目录ID", name = "indexCatalogId", required = true)
	private String indexCatalogId;
	/**币种**/
	@Column(name = "CURRENCY", unique = false, nullable = true, length = 32)
	@ApiModelProperty(value = "币种", name = "currency", required = true)
	private String currency;
	/**考核对象类型**/
	@Transient
	private String obj ;
	
	/**应用类型**/
	@Transient
	private String applyTypeId ;
	
	/**余额类型**/
	@Transient
	private String yeType ;
	
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
	 * @param indexName
	 */
	public void setIndexName(String indexName) {
		this.indexName = indexName == null ? null : indexName.trim();
	}
	
    /**
     * @return IndexName
     */	
	public String getIndexName() {
		return this.indexName;
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
	
	public String getObj() {
		return this.obj;
	}

	public void setObj(String obj) {
		this.obj = obj == null ? null : obj.trim();
	}

	public String getApplyTypeId() {
		return this.applyTypeId;
	}

	public void setApplyTypeId(String applyTypeId) {
		this.applyTypeId = applyTypeId == null ? null : applyTypeId.trim();
	}

	public String getYeType() {
		return this.yeType;
	}

	public void setYeType(String yeType) {
		this.yeType = yeType == null ? null : yeType.trim();
	}

	public String getCreateOrg() {
		return createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getIndexBusinessType() {
		return indexBusinessType;
	}

	public void setIndexBusinessType(String indexBusinessType) {
		this.indexBusinessType = indexBusinessType;
	}

	public String getIndexState() {
		return this.indexState;
	}

	public void setIndexState(String indexState) {
		this.indexState = indexState == null ? null : indexState.trim();
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
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

	public String getIndexCatalogId() {
		return indexCatalogId;
	}

	public void setIndexCatalogId(String indexCatalogId) {
		this.indexCatalogId = indexCatalogId;
	}
}