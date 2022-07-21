package cn.com.yusys.yusp.uimp.displan.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDisPlanInfo
 * @类描述: PMA_F_DIS_PLAN_INFO数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-03-26 10:05:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFDisPlanInfo", description = "方案分配")
@Entity
@Table(name = "PMA_F_DIS_PLAN_INFO")
public class PmaFDisPlanInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "主键", name = "id", required = false)
	private String id;

	/** 业务种类 **/
	@Column(name = "BUSS_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "业务类型", name = "bussType", required = false)
	private String bussType;
	
	/** 机构号 **/
	@Column(name = "ORG_NO", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "机构号", name = "orgNo", required = false)
	private String orgNo;
	
	/** 机构名称 **/
	@Column(name = "ORG_NAME", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "机构名", name = "orgName", required = false)
	private String orgName;
	
	
	/** 生效日期 **/
	@Column(name = "EFFECT_DATE", unique = false, nullable = true, length = 8)
	@ApiModelProperty(value = "生效日期", name = "effectDate", required = false)
	private String effectDate;
	
	/** 失效日期 **/
	@Column(name = "EXPIRATE_DATE", unique = false, nullable = true, length = 8)
	@ApiModelProperty(value = "失效日期", name = "expirateDate", required = false)
	private String expirateDate;
	
	
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
	 * @param orgNo
	 */
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo == null ? null : orgNo.trim();
	}
	
    /**
     * @return OrgNo
     */	
	public String getOrgNo() {
		return this.orgNo;
	}
	
	/**
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}
	
    /**
     * @return OrgName
     */	
	public String getOrgName() {
		return this.orgName;
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


}