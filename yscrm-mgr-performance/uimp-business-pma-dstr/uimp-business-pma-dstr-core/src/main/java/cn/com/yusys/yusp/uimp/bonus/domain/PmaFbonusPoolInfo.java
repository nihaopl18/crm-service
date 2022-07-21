package cn.com.yusys.yusp.uimp.bonus.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFbonusPoolInfo
 * @类描述: PMA_F_BONUS_POOL_INFO二次分配奖金池信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-08-06 10:24:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_BONUS_POOL_INFO")
public class PmaFbonusPoolInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 奖金类型 **/
	@Column(name = "BONUS_TYPE", unique = false, nullable = true, length = 2)
	private String bonusType;
	
	/** 奖金池类型 **/
	@Column(name = "POOL_TYPE", unique = false, nullable = true, length = 2)
	private String poolType;
	
	/** 数据日期 **/
	@Column(name = "STAT_DATE", unique = false, nullable = true, length = 10)
	private String statDate;
	
	/** 所属机构ID **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 50)
	private String orgId;
	
	/** 奖金池金额 **/
	@Column(name = "POOL_BONUS", unique = false, nullable = true, length = 20)
	private Double poolBonus;
	
	/** 生效标识 **/
	@Column(name = "IF_FLAG", unique = false, nullable = true, length = 2)
	private String ifFlag;
	
	/** 剩余奖金池金额 **/
	@Column(name = "SUR_POOL_BONUS", unique = false, nullable = true, length = 20)
	private Double surPoolBonus;
	
	/** 已分配奖金池金额 **/
	@Column(name = "ASSIGN_POOL_BONUS", unique = false, nullable = true, length = 20)
	private Double assignPoolBonus;
	
	
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
	 * @param bonusType
	 */
	public void setBonusType(String bonusType) {
		this.bonusType = bonusType == null ? null : bonusType.trim();
	}
	
    /**
     * @return BonusType
     */	
	public String getBonusType() {
		return this.bonusType;
	}
	
	/**
	 * @param poolType
	 */
	public void setPoolType(String poolType) {
		this.poolType = poolType == null ? null : poolType.trim();
	}
	
    /**
     * @return PoolType
     */	
	public String getPoolType() {
		return this.poolType;
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
	 * @param poolBonus
	 */
	public void setPoolBonus(Double poolBonus) {
		this.poolBonus = poolBonus;
	}
	
    /**
     * @return PoolBonus
     */	
	public Double getPoolBonus() {
		return this.poolBonus;
	}
	
	/**
	 * @param ifFlag
	 */
	public void setIfFlag(String ifFlag) {
		this.ifFlag = ifFlag == null ? null : ifFlag.trim();
	}
	
    /**
     * @return IfFlag
     */	
	public String getIfFlag() {
		return this.ifFlag;
	}
	
	/**
	 * @param surPoolBonus
	 */
	public void setSurPoolBonus(Double surPoolBonus) {
		this.surPoolBonus = surPoolBonus;
	}
	
    /**
     * @return SurPoolBonus
     */	
	public Double getSurPoolBonus() {
		return this.surPoolBonus;
	}
	
	/**
	 * @param assignPoolBonus
	 */
	public void setAssignPoolBonus(Double assignPoolBonus) {
		this.assignPoolBonus = assignPoolBonus;
	}
	
    /**
     * @return AssignPoolBonus
     */	
	public Double getAssignPoolBonus() {
		return this.assignPoolBonus;
	}


}