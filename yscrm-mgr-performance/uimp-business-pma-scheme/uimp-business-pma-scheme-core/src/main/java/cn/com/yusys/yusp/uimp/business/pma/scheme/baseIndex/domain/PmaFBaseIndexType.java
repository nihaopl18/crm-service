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
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexType
 * @类描述: PMA_F_BASE_INDEX_TYPE数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-02 16:29:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFBaseIndexType", description = "基础指标目录管理")
@Entity
@Table(name = "PMA_F_BASE_INDEX_TYPE")
public class PmaFBaseIndexType extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 类型编号 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "类型编号", name = "id", required = false)
	private String id;

	/** 类型名称 **/
	@Column(name = "TYPE_NAME", unique = false, nullable = true, length = 200)
	@ApiModelProperty(value = "类型名称", name = "typeName", required = true)
	private String typeName;
	
	/** 上级类型编号 **/
	@Column(name = "PARENT_ID", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "上级类型编号", name = "parentId", required = true)
	private String parentId;
	
	/** 叶节点标志("Y-是
N-否") **/
	@Column(name = "LEAF_FLAG", unique = false, nullable = true, length = 1)
	@ApiModelProperty(value = "叶节点标志", name = "leafFlag", required = true)
	private String leafFlag;
	
	/** 层级(oracle数据库，level是关键字，因此改成LEVEL0) **/
	@Column(name = "LEVEL0", unique = false, nullable = true, length = 0)
	@ApiModelProperty(value = "层级", name = "level0", required = true)
	private java.math.BigDecimal level0;
	
	/** 类型标识("0-目录
1-指标分类") **/
	@Column(name = "DIR_TYPE", unique = false, nullable = true, length = 1)
	@ApiModelProperty(value = "类型标识", name = "dirType", required = true)
	private String dirType;
	
	/** 业务条线编号 **/
	@Column(name = "BUSS_SYS_NO", unique = false, nullable = true, length = 30)
	@ApiModelProperty(value = "业务条线编号", name = "bussSysNo", required = true)
	private String bussSysNo;
	
	/** 所属机构 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "所属机构", name = "orgId", required = true)
	private String orgId;
	
	/** 创建者ID **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "创建者ID", name = "creator", required = true)
	private String creator;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "创建日期", name = "createDate", required = true)
	private String createDate;
	
	/** 修改者ID **/
	@Column(name = "UPDATER_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "修改者ID", name = "updaterId", required = true)
	private String updaterId;
	
	/** 修改日期 **/
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "修改日期", name = "updateDate", required = true)
	private String updateDate;

	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 32)
	@ApiModelProperty(value = "创建机构", name = "createOrg", required = true)
	private String createOrg;

	/** 修改机构 **/
	@Column(name = "UPDATE_ORG", unique = false, nullable = true, length = 32)
	@ApiModelProperty(value = "修改机构", name = "updateOrg", required = true)
	private String updateOrg;
	
	
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
	 * @param typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName == null ? null : typeName.trim();
	}
	
    /**
     * @return TypeName
     */	
	public String getTypeName() {
		return this.typeName;
	}
	
	/**
	 * @param parentId
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	
    /**
     * @return ParentId
     */	
	public String getParentId() {
		return this.parentId;
	}
	
	/**
	 * @param leafFlag
	 */
	public void setLeafFlag(String leafFlag) {
		this.leafFlag = leafFlag == null ? null : leafFlag.trim();
	}
	
    /**
     * @return LeafFlag
     */	
	public String getLeafFlag() {
		return this.leafFlag;
	}
	
	/**
	 * @param level0
	 */
	public void setLevel0(java.math.BigDecimal level0) {
		this.level0 = level0;
	}
	
    /**
     * @return Level0
     */	
	public java.math.BigDecimal getLevel0() {
		return this.level0;
	}
	
	/**
	 * @param dirType
	 */
	public void setDirType(String dirType) {
		this.dirType = dirType == null ? null : dirType.trim();
	}
	
    /**
     * @return DirType
     */	
	public String getDirType() {
		return this.dirType;
	}
	
	/**
	 * @param bussSysNo
	 */
	public void setBussSysNo(String bussSysNo) {
		this.bussSysNo = bussSysNo == null ? null : bussSysNo.trim();
	}
	
    /**
     * @return BussSysNo
     */	
	public String getBussSysNo() {
		return this.bussSysNo;
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

	public String getCreateOrg() {
		return createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public String getUpdateOrg() {
		return updateOrg;
	}

	public void setUpdateOrg(String updateOrg) {
		this.updateOrg = updateOrg;
	}
}