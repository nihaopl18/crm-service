package cn.com.yusys.yusp.uimp.distribution.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDistributionModeDetail
 * @类描述: PMA_F_DISTRIBUTION_MODE_DETAIL数据实体类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-23 10:36:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_DISTRIBUTION_MODE_DETAIL")
public class PmaFDistributionModeDetail extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 机构号 **/
	@Column(name = "BRCH_NO", unique = false, nullable = true, length = 50)
	private String brchNo;
	
	/** 机构名称 **/
	@Column(name = "BRCH_NA", unique = false, nullable = true, length = 100)
	private String brchNa;
	
	/** 分配方式类型 **/
	@Column(name = "ALLOT_TYPE", unique = false, nullable = true, length = 2)
	private String allotType;
	
	/** 优先级 **/
	@Column(name = "PRIORITY", unique = false, nullable = true, length = 2)
	private String priority;
	
	/** 生效日期 **/
	@Column(name = "EFFECT_DATE", unique = false, nullable = true, length = 8)
	private String effectDate;
	
	/** 失效日期 **/
	@Column(name = "EXPIRATE_DATE", unique = false, nullable = true, length = 8)
	private String expirateDate;
	
	/** 业务种类 **/
	@Column(name = "BUSS_TYPE", unique = false, nullable = true, length = 2)
	private String bussType;
	
	/** 规模种类 **/
	@Column(name = "TYPE", unique = false, nullable = true, length = 2)
	private String type;
	
	
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
	 * @param brchNo
	 */
	public void setBrchNo(String brchNo) {
		this.brchNo = brchNo == null ? null : brchNo.trim();
	}
	
    /**
     * @return BrchNo
     */	
	public String getBrchNo() {
		return this.brchNo;
	}
	
	/**
	 * @param brchNa
	 */
	public void setBrchNa(String brchNa) {
		this.brchNa = brchNa == null ? null : brchNa.trim();
	}
	
    /**
     * @return BrchNa
     */	
	public String getBrchNa() {
		return this.brchNa;
	}
	
	/**
	 * @param allotType
	 */
	public void setAllotType(String allotType) {
		this.allotType = allotType == null ? null : allotType.trim();
	}
	
    /**
     * @return AllotType
     */	
	public String getAllotType() {
		return this.allotType;
	}
	
	/**
	 * @param priority
	 */
	public void setPriority(String priority) {
		this.priority = priority == null ? null : priority.trim();
	}
	
    /**
     * @return Priority
     */	
	public String getPriority() {
		return this.priority;
	}
	
	/**
	 * @param effectDate
	 */
	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate == null ? null : effectDate.trim();
	}
	
    /**
     * @return EffectDate
     */	
	public String getEffectDate() {
		return this.effectDate;
	}
	
	/**
	 * @param expirateDate
	 */
	public void setExpirateDate(String expirateDate) {
		this.expirateDate = expirateDate == null ? null : expirateDate.trim();
	}
	
    /**
     * @return ExpirateDate
     */	
	public String getExpirateDate() {
		return this.expirateDate;
	}
	
	/**
	 * @param bussType
	 */
	public void setBussType(String bussType) {
		this.bussType = bussType == null ? null : bussType.trim();
	}
	
    /**
     * @return BussType
     */	
	public String getBussType() {
		return this.bussType;
	}
	
	/**
	 * @param type
	 */
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}
	
    /**
     * @return Type
     */	
	public String getType() {
		return this.type;
	}


}