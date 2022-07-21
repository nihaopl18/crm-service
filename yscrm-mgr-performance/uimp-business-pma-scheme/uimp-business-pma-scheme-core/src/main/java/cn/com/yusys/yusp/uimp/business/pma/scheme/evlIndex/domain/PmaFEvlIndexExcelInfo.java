package cn.com.yusys.yusp.uimp.business.pma.scheme.evlIndex.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFEvlIndexExcelInfo
 * @类描述: PMA_F_EVL_INDEX_EXCEL_INFO数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-04-21 15:02:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_EVL_INDEX_EXCEL_INFO")
public class PmaFEvlIndexExcelInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 派生指标编号 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 8)
	private String indexId;
	
	/** 派生指标名称 **/
	@Column(name = "INDEX_NAME", unique = false, nullable = true, length = 200)
	private String indexName;
	
	/** 指标归属机构 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 100)
	private String orgId;
	
	/** 描述 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 300)
	private String remark;
	
	/** 评价指标计算公式 **/
	@Column(name = "FORMULA", unique = false, nullable = true, length = 4000)
	private String formula;
	
	/** 评价指标计算公式描述 **/
	@Column(name = "FORMULA_NOTES", unique = false, nullable = true, length = 4000)
	private String formulaNotes;
	
	/** 创建者 **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 50)
	private String creator;
	
	/** 创建日期 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private String createDate;
	
	/** 修改者 **/
	@Column(name = "MODIFY_USER", unique = false, nullable = true, length = 50)
	private String modifyUser;
	
	/** 修改日期 **/
	@Column(name = "MODIFY_DATE", unique = false, nullable = true, length = 20)
	private String modifyDate;
	
	/** 作用域机构 **/
	@Column(name = "SCOPE_ORG_ID", unique = false, nullable = true, length = 1)
	private String scopeOrgId;
	
	/** 数据删除标志 **/
	@Column(name = "STAT_FLAG", unique = false, nullable = true, length = 2)
	private String statFlag;
	
	/** 考核对象类型**/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = true, length = 30)
	private String evlObjType;
	
	
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
	 * @param formula
	 */
	public void setFormula(String formula) {
		this.formula = formula == null ? null : formula.trim();
	}
	
    /**
     * @return Formula
     */	
	public String getFormula() {
		return this.formula;
	}
	
	/**
	 * @param formulaNotes
	 */
	public void setFormulaNotes(String formulaNotes) {
		this.formulaNotes = formulaNotes == null ? null : formulaNotes.trim();
	}
	
    /**
     * @return FormulaNotes
     */	
	public String getFormulaNotes() {
		return this.formulaNotes;
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
	 * @param scopeOrgId
	 */
	public void setScopeOrgId(String scopeOrgId) {
		this.scopeOrgId = scopeOrgId == null ? null : scopeOrgId.trim();
	}
	
    /**
     * @return ScopeOrgId
     */	
	public String getScopeOrgId() {
		return this.scopeOrgId;
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
	
	/**
	 * @param bussSysNo
	 */
	public void setEvlObjType(String evlObjType) {
		this.evlObjType = evlObjType == null ? null : evlObjType.trim();
	}
	
    /**
     * @return BussSysNo
     */	
	public String getEvlObjType() {
		return this.evlObjType;
	}


}