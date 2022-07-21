package cn.com.yusys.yscrm.custflexEs.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmFCiFqSsolution
 * @类描述: CRM_F_CI_FQ_SSOLUTION数据集-查询方案 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2021-01-02 13:04:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "CRM_F_CI_FQ_SSOLUTION")
public class CrmFCiFqSsolution extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 创建日期 **/
	@Column(name = "SS_DATE", unique = false, nullable = true, length = 7)
	private Date ssDate;
	
	/** 方案名 **/
	@Column(name = "SS_NAME", unique = false, nullable = true, length = 100)
	private String ssName;
	
	/** 查询sql **/
	@Column(name = "SS_SQL", unique = false, nullable = true, length = 2000)
	private String ssSql;
	
	/** 结果集ID **/
	@Column(name = "SS_RESULT", unique = false, nullable = true, length = 1000)
	private String ssResult;
	
	/** 排序标识 **/
	@Column(name = "SS_SORT", unique = false, nullable = true, length = 100)
	private String ssSort;
	
	/** 方案类型 **/
	@Column(name = "SS_TYPE", unique = false, nullable = true, length = 20)
	private String ssType;
	
	/** 创建人 **/
	@Column(name = "SS_USER", unique = false, nullable = true, length = 32)
	private String ssUser;
	
	/** 筛选数目 **/
	@Column(name = "TOP_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal topNum;
	
	/** 创建机构 **/
	@Column(name = "CREATE_ORG", unique = false, nullable = true, length = 32)
	private String createOrg;
	
	/** 报表发布状态 **/
	@Column(name = "SS_REL_REPORT", unique = false, nullable = true, length = 2)
	private String ssRelReport;
	
	/** SS_VALID_DATE **/
	@Column(name = "SS_VALID_DATE", unique = false, nullable = true, length = 7)
	private Date ssValidDate;
	
	/** CORP_ORG_CODE **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 100)
	private String corpOrgCode;
	
	
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
	 * @param ssDate
	 */
	public void setSsDate(Date ssDate) {
		this.ssDate = ssDate;
	}
	
    /**
     * @return SsDate
     */	
	public Date getSsDate() {
		return this.ssDate;
	}
	
	/**
	 * @param ssName
	 */
	public void setSsName(String ssName) {
		this.ssName = ssName == null ? null : ssName.trim();
	}
	
    /**
     * @return SsName
     */	
	public String getSsName() {
		return this.ssName;
	}
	
	/**
	 * @param ssSql
	 */
	public void setSsSql(String ssSql) {
		this.ssSql = ssSql == null ? null : ssSql.trim();
	}
	
    /**
     * @return SsSql
     */	
	public String getSsSql() {
		return this.ssSql;
	}
	
	/**
	 * @param ssResult
	 */
	public void setSsResult(String ssResult) {
		this.ssResult = ssResult == null ? null : ssResult.trim();
	}
	
    /**
     * @return SsResult
     */	
	public String getSsResult() {
		return this.ssResult;
	}
	
	/**
	 * @param ssSort
	 */
	public void setSsSort(String ssSort) {
		this.ssSort = ssSort == null ? null : ssSort.trim();
	}
	
    /**
     * @return SsSort
     */	
	public String getSsSort() {
		return this.ssSort;
	}
	
	/**
	 * @param ssType
	 */
	public void setSsType(String ssType) {
		this.ssType = ssType == null ? null : ssType.trim();
	}
	
    /**
     * @return SsType
     */	
	public String getSsType() {
		return this.ssType;
	}
	
	/**
	 * @param ssUser
	 */
	public void setSsUser(String ssUser) {
		this.ssUser = ssUser == null ? null : ssUser.trim();
	}
	
    /**
     * @return SsUser
     */	
	public String getSsUser() {
		return this.ssUser;
	}
	
	/**
	 * @param topNum
	 */
	public void setTopNum(java.math.BigDecimal topNum) {
		this.topNum = topNum;
	}
	
    /**
     * @return TopNum
     */	
	public java.math.BigDecimal getTopNum() {
		return this.topNum;
	}
	
	/**
	 * @param createOrg
	 */
	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg == null ? null : createOrg.trim();
	}
	
    /**
     * @return CreateOrg
     */	
	public String getCreateOrg() {
		return this.createOrg;
	}
	
	/**
	 * @param ssRelReport
	 */
	public void setSsRelReport(String ssRelReport) {
		this.ssRelReport = ssRelReport == null ? null : ssRelReport.trim();
	}
	
    /**
     * @return SsRelReport
     */	
	public String getSsRelReport() {
		return this.ssRelReport;
	}
	
	/**
	 * @param ssValidDate
	 */
	public void setSsValidDate(Date ssValidDate) {
		this.ssValidDate = ssValidDate;
	}
	
    /**
     * @return SsValidDate
     */	
	public Date getSsValidDate() {
		return this.ssValidDate;
	}
	
	/**
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
	}


}