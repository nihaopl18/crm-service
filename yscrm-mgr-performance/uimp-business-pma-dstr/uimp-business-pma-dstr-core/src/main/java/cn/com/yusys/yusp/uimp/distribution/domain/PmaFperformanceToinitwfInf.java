package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFperformanceToinitwfInf
 * @类描述: PMA_F_PERFORMANCE_TOINITWF_INF业绩批量导入工作流待发起信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-10-21 23:53:53
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_PERFORMANCE_TOINITWF_INF")
public class PmaFperformanceToinitwfInf extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 审批编号 **/
	@Id
	@Column(name = "APPLY_ID")
	@Generated(GenerationType.UUID)
	private String applyId;
	
	/** 业绩类型 **/
	@Column(name = "FUN_CODE", unique = false, nullable = true, length = 255)
	private String funCode;
	
	/** 批次编号 **/
	@Column(name = "BATCH_ID", unique = false, nullable = true, length = 100)
	private String batchId;
	
	/** 分配区间历史表表名 **/
	@Column(name = "PERIOD_HIS_TABLE_NAME", unique = false, nullable = true, length = 255)
	private String periodHisTableName;
	
	/** 批量导入明细表表名 **/
	@Column(name = "DTL_TABLE_NAME", unique = false, nullable = true, length = 255)
	private String dtlTableName;
	
	/** 是否重新发起审批 **/
	@Column(name = "IS_RE_START_WF", unique = false, nullable = true, length = 10)
	private String isReStartWf;
	
	/** 流程标识 **/
	@Column(name = "WORK_FLOW", unique = false, nullable = true, length = 32)
	private String workFlow;
	
	/** 操作用户编号 **/
	@Column(name = "USER_ID", unique = false, nullable = true, length = 32)
	private String userId;
	
	/** 操作用户归属机构层级 **/
	@Column(name = "UNIT_LEVEL", unique = false, nullable = true, length = 10)
	private String unitLevel;
	
	/** 操作用户归属机构号 **/
	@Column(name = "UNIT_ID", unique = false, nullable = true, length = 100)
	private String unitId;
	
	/** 是否跨条线 **/
	@Column(name = "INTER_BUSS", unique = false, nullable = true, length = 10)
	private String interBuss;
	
	/** 是否跨机构 **/
	@Column(name = "INTER_ORG", unique = false, nullable = true, length = 10)
	private String interOrg;
	
	/** 是否跨分行 **/
	@Column(name = "INTER_BRANCH", unique = false, nullable = true, length = 10)
	private String interBranch;
	
	/** 是否虚拟行员分配 **/
	@Column(name = "VIRTUAL_DSTR", unique = false, nullable = true, length = 10)
	private String virtualDstr;
	
	/** 操作用户角色编号 **/
	@Column(name = "ROLE", unique = false, nullable = true, length = 100)
	private String role;
	
	/** 操作用户归属条线 **/
	@Column(name = "BUSS", unique = false, nullable = true, length = 100)
	private String buss;
	
	/** 业绩归属机构号 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 100)
	private String orgId;
	
	/** 业绩主键字段名 **/
	@Column(name = "PK_COLUMN_NAMES", unique = false, nullable = true, length = 255)
	private String pkColumnNames;
	
	/** 业绩主键字段值 **/
	@Column(name = "PK_COLUMN_VALUES", unique = false, nullable = true, length = 255)
	private String pkColumnValues;
	
	/** 执行状态: 0待执行 1执行中 执行完成数据直接删除 **/
	@Column(name = "EXECUTE_STATUS", unique = false, nullable = true, length = 10)
	private String executeStatus;
	
	/** 数据创建时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 7)
	private Date createTime;
	
	
	/**
	 * @param applyId
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId == null ? null : applyId.trim();
	}
	
    /**
     * @return ApplyId
     */	
	public String getApplyId() {
		return this.applyId;
	}
	
	/**
	 * @param funCode
	 */
	public void setFunCode(String funCode) {
		this.funCode = funCode == null ? null : funCode.trim();
	}
	
    /**
     * @return FunCode
     */	
	public String getFunCode() {
		return this.funCode;
	}
	
	/**
	 * @param batchId
	 */
	public void setBatchId(String batchId) {
		this.batchId = batchId == null ? null : batchId.trim();
	}
	
    /**
     * @return BatchId
     */	
	public String getBatchId() {
		return this.batchId;
	}
	
	/**
	 * @param periodHisTableName
	 */
	public void setPeriodHisTableName(String periodHisTableName) {
		this.periodHisTableName = periodHisTableName == null ? null : periodHisTableName.trim();
	}
	
    /**
     * @return PeriodHisTableName
     */	
	public String getPeriodHisTableName() {
		return this.periodHisTableName;
	}
	
	/**
	 * @param dtlTableName
	 */
	public void setDtlTableName(String dtlTableName) {
		this.dtlTableName = dtlTableName == null ? null : dtlTableName.trim();
	}
	
    /**
     * @return DtlTableName
     */	
	public String getDtlTableName() {
		return this.dtlTableName;
	}
	
	/**
	 * @param isReStartWf
	 */
	public void setIsReStartWf(String isReStartWf) {
		this.isReStartWf = isReStartWf == null ? null : isReStartWf.trim();
	}
	
    /**
     * @return IsReStartWf
     */	
	public String getIsReStartWf() {
		return this.isReStartWf;
	}
	
	/**
	 * @param workFlow
	 */
	public void setWorkFlow(String workFlow) {
		this.workFlow = workFlow == null ? null : workFlow.trim();
	}
	
    /**
     * @return WorkFlow
     */	
	public String getWorkFlow() {
		return this.workFlow;
	}
	
	/**
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
	
    /**
     * @return userId
     */	
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * @param unitLevel
	 */
	public void setUnitLevel(String unitLevel) {
		this.unitLevel = unitLevel == null ? null : unitLevel.trim();
	}
	
    /**
     * @return UnitLevel
     */	
	public String getUnitLevel() {
		return this.unitLevel;
	}
	
	/**
	 * @param unitId
	 */
	public void setUnitId(String unitId) {
		this.unitId = unitId == null ? null : unitId.trim();
	}
	
    /**
     * @return UnitId
     */	
	public String getUnitId() {
		return this.unitId;
	}
	
	/**
	 * @param interBuss
	 */
	public void setInterBuss(String interBuss) {
		this.interBuss = interBuss == null ? null : interBuss.trim();
	}
	
    /**
     * @return InterBuss
     */	
	public String getInterBuss() {
		return this.interBuss;
	}
	
	/**
	 * @param interOrg
	 */
	public void setInterOrg(String interOrg) {
		this.interOrg = interOrg == null ? null : interOrg.trim();
	}
	
    /**
     * @return InterOrg
     */	
	public String getInterOrg() {
		return this.interOrg;
	}
	
	/**
	 * @param interBranch
	 */
	public void setInterBranch(String interBranch) {
		this.interBranch = interBranch == null ? null : interBranch.trim();
	}
	
    /**
     * @return InterBranch
     */	
	public String getInterBranch() {
		return this.interBranch;
	}
	
	/**
	 * @param virtualDstr
	 */
	public void setVirtualDstr(String virtualDstr) {
		this.virtualDstr = virtualDstr == null ? null : virtualDstr.trim();
	}
	
    /**
     * @return VirtualDstr
     */	
	public String getVirtualDstr() {
		return this.virtualDstr;
	}
	
	/**
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role == null ? null : role.trim();
	}
	
    /**
     * @return Role
     */	
	public String getRole() {
		return this.role;
	}
	
	/**
	 * @param buss
	 */
	public void setBuss(String buss) {
		this.buss = buss == null ? null : buss.trim();
	}
	
    /**
     * @return Buss
     */	
	public String getBuss() {
		return this.buss;
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
	 * @param pkColumnNames
	 */
	public void setPkColumnNames(String pkColumnNames) {
		this.pkColumnNames = pkColumnNames == null ? null : pkColumnNames.trim();
	}
	
    /**
     * @return PkColumnNames
     */	
	public String getPkColumnNames() {
		return this.pkColumnNames;
	}
	
	/**
	 * @param pkColumnValues
	 */
	public void setPkColumnValues(String pkColumnValues) {
		this.pkColumnValues = pkColumnValues == null ? null : pkColumnValues.trim();
	}
	
    /**
     * @return PkColumnValues
     */	
	public String getPkColumnValues() {
		return this.pkColumnValues;
	}
	
	/**
	 * @param executeStatus
	 */
	public void setExecuteStatus(String executeStatus) {
		this.executeStatus = executeStatus == null ? null : executeStatus.trim();
	}
	
    /**
     * @return ExecuteStatus
     */	
	public String getExecuteStatus() {
		return this.executeStatus;
	}
	
	/**
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
    /**
     * @return CreateTime
     */	
	public Date getCreateTime() {
		return this.createTime;
	}


}