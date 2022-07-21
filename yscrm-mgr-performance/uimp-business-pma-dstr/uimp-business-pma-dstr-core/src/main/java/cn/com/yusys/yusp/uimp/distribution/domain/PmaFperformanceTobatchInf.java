package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFperformanceTobatchInf
 * @类描述: PMA_F_PERFORMANCE_TOBATCH_INF数据实体类
 * @功能描述: 
 * @创建人: Bronze
 * @创建时间: 2020-10-25 14:48:49
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_PERFORMANCE_TOBATCH_INF")
public class PmaFperformanceTobatchInf extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 审批编号 **/
	@Id
	@Column(name = "BATCH_ID")
	@Generated(GenerationType.UUID)
	private String batchId;
	
	/** 业绩类型 **/
	@Column(name = "FUN_CODE", unique = false, nullable = true, length = 255)
	private String funCode;
	
	/** 操作人编号 **/
	@Column(name = "USER_ID", unique = false, nullable = true, length = 100)
	private String userId;
	
	/** 操作人角色 **/
	@Column(name = "ROLE", unique = false, nullable = true, length = 100)
	private String role;
	
	/** 操作人机构层级 **/
	@Column(name = "UNIT_LEVEL", unique = false, nullable = true, length = 10)
	private String unitLevel;
	
	/** 操作人机构号 **/
	@Column(name = "UNIT_ID", unique = false, nullable = true, length = 100)
	private String unitId;
	
	/** 操作人所属授权机构号 **/
	@Column(name = "GRANT_ORG_CODE", unique = false, nullable = true, length = 32)
	private String grantOrgCode;
	
	/** 操作人所属条线 **/
	@Column(name = "BUSS", unique = false, nullable = true, length = 100)
	private String buss;
	
	/** 创建时间 **/
	@Column(name = "CREATE_TIME", unique = false, nullable = true, length = 7)
	private Date createTime;
	
	/** 执行状态 0待执行 1执行中 **/
	@Column(name = "STATUS", unique = false, nullable = true, length = 10)
	private String status;
	
	
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
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId == null ? null : userId.trim();
	}
	
    /**
     * @return UserId
     */	
	public String getUserId() {
		return this.userId;
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
	 * @param grantOrgCode
	 */
	public void setGrantOrgCode(String grantOrgCode) {
		this.grantOrgCode = grantOrgCode == null ? null : grantOrgCode.trim();
	}
	
    /**
     * @return GrantOrgCode
     */	
	public String getGrantOrgCode() {
		return this.grantOrgCode;
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
	
	/**
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}
	
    /**
     * @return Status
     */	
	public String getStatus() {
		return this.status;
	}


}