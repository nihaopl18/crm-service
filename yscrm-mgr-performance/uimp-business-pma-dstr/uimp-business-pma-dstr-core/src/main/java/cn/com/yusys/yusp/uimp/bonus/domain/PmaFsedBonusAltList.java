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
 * @类名称: PmaFsedBonusAltList
 * @类描述: PMA_F_SED_BONUS_ALT_LIST员工奖金二次分配明细表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-08-06 10:25:09
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SED_BONUS_ALT_LIST")
public class PmaFsedBonusAltList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 员工ID **/
	@Column(name = "EVL_OBJ_ID", unique = false, nullable = true, length = 50)
	private String evlObjId;
	
	/** 所属机构ID **/
	@Column(name = "BELONG_ORG_ID", unique = false, nullable = true, length = 50)
	private String belongOrgId;
	
	/** 分配人ID **/
	@Column(name = "OPER_ID", unique = false, nullable = true, length = 50)
	private String operId;
	
	/** 分配时间 **/
	@Column(name = "OPER_TIME", unique = false, nullable = true, length = 20)
	private String operTime;
	
	/** 分配金额 **/
	@Column(name = "OPER_BONUS", unique = false, nullable = true, length = 20)
	private Double operBonus;
	
	/** 分配类型 **/
	@Column(name = "OPER_TYPE", unique = false, nullable = true, length = 2)
	private String operType;
	
	/** 奖金类型 **/
	@Column(name = "BONUS_TYPE", unique = false, nullable = true, length = 2)
	private String bonusType;
	
	/** 数据日期 **/
	@Column(name = "STAT_DATE", unique = false, nullable = true, length = 10)
	private String statDate;
	
	
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
	 * @param evlObjId
	 */
	public void setEvlObjId(String evlObjId) {
		this.evlObjId = evlObjId == null ? null : evlObjId.trim();
	}
	
    /**
     * @return EvlObjId
     */	
	public String getEvlObjId() {
		return this.evlObjId;
	}
	
	/**
	 * @param belongOrgId
	 */
	public void setBelongOrgId(String belongOrgId) {
		this.belongOrgId = belongOrgId == null ? null : belongOrgId.trim();
	}
	
    /**
     * @return BelongOrgId
     */	
	public String getBelongOrgId() {
		return this.belongOrgId;
	}
	
	/**
	 * @param operId
	 */
	public void setOperId(String operId) {
		this.operId = operId == null ? null : operId.trim();
	}
	
    /**
     * @return OperId
     */	
	public String getOperId() {
		return this.operId;
	}
	
	/**
	 * @param operTime
	 */
	public void setOperTime(String operTime) {
		this.operTime = operTime == null ? null : operTime.trim();
	}
	
    /**
     * @return OperTime
     */	
	public String getOperTime() {
		return this.operTime;
	}
	
	/**
	 * @param operBonus
	 */
	public void setOperBonus(Double operBonus) {
		this.operBonus = operBonus;
	}
	
    /**
     * @return OperBonus
     */	
	public Double getOperBonus() {
		return this.operBonus;
	}
	
	/**
	 * @param operType
	 */
	public void setOperType(String operType) {
		this.operType = operType == null ? null : operType.trim();
	}
	
    /**
     * @return OperType
     */	
	public String getOperType() {
		return this.operType;
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


}