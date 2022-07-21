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
 * @类名称: PmaFDisPlanDetail
 * @类描述: PMA_F_DIS_PLAN_DETAIL数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-03-26 10:16:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFDisPlanDetail", description = "方案分配明细")
@Entity
@Table(name = "PMA_F_DIS_PLAN_DETAIL")
public class PmaFDisPlanDetail extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "主键", name = "id", required = false)
	private String id;

	/** 机构号 **/
	@Column(name = "ORG_NO", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "机构号", name = "orgNo", required = false)
	private String orgNo;
	
	/** 机构名称 **/
	@Column(name = "ORG_NAME", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "机构名", name = "orgName", required = false)
	private String orgName;
	
	/** 分配比例 **/
	@Column(name = "DISTR_RATE", unique = false, nullable = true, length = 10)
	@ApiModelProperty(value = "分配比例", name = "distrRate", required = false)
	private java.math.BigDecimal distrRate;
	
	/** 客户经理类型 **/
	@Column(name = "MANAGER_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "客户经理类型", name = "managerType", required = false)
	private String managerType;
	
	/** 业务种类 **/
	@Column(name = "BUSS_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "业务类型", name = "bussType", required = false)
	private String bussType;
	
	
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
	 * @param distrRate
	 */
	public void setDistrRate(java.math.BigDecimal distrRate) {
		this.distrRate = distrRate;
	}
	
    /**
     * @return DistrRate
     */	
	public java.math.BigDecimal getDistrRate() {
		return this.distrRate;
	}
	
	/**
	 * @param managerType
	 */
	public void setManagerType(String managerType) {
		this.managerType = managerType == null ? null : managerType.trim();
	}
	
    /**
     * @return ManagerType
     */	
	public String getManagerType() {
		return this.managerType;
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


}