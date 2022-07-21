package cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFParamInfo
 * @类描述: PMA_F_PARAM_INFO数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-09 15:32:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Api(tags = "机构参数info信息")
@Entity
@Table(name = "PMA_F_PARAM_INFO")
public class PmaFParamInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "主键", name = "id", required = false)
	private String id;

	/** 参数名称 **/
	@ApiModelProperty(value = "参数名称", name = "paramName", required = false)
	@Column(name = "PARAM_NAME", unique = false, nullable = true, length = 100)
	private String paramName;
	
	/** 描述 **/
	@ApiModelProperty(value = "描述 ", name = "remark", required = false)
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	/** 参数所属机构编号 **/
	@ApiModelProperty(value = "所属机构编号", name = "orgId", required = false)
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 50)
	private String orgId;
	
	/** 数据删除标志 **/
	@ApiModelProperty(value = "数据删除标志", name = "statFlag", required = false)
	@Column(name = "STAT_FLAG", unique = false, nullable = true, length = 2)
	private String statFlag;
	
	/** 创建者 **/
	@ApiModelProperty(value = "创建者", name = "creator", required = false)
	@Column(name = "CREATOR", unique = false, nullable = true, length = 50)
	private String creator;
	
	/** 修改者 **/
	@ApiModelProperty(value = "修改者", name = "modifyUser", required = false)
	@Column(name = "MODIFY_USER", unique = false, nullable = true, length = 50)
	private String modifyUser;
	
	/** 参数类型编号 **/
	@ApiModelProperty(value = "参数类型编号", name = "dirId", required = false)
	@Column(name = "DIR_ID", unique = false, nullable = true, length = 50)
	private String dirId;
	
	/** 创建时间 **/
	@ApiModelProperty(value = "创建时间", name = "createDate", required = false)
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private String createDate;
	
	/** 修改时间 **/
	@ApiModelProperty(value = "修改时间", name = "modifyDate", required = false)
	@Column(name = "MODIFY_DATE", unique = false, nullable = true, length = 20)
	private String modifyDate;
	
	/** 参数值 **/
	@ApiModelProperty(value = "参数值", name = "paramValue", required = false)
	@Column(name = "PARAM_VALUE", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal paramValue;
	
	/** 参数编号 **/
	@ApiModelProperty(value = "参数编号 ", name = "paramId", required = false)
	@Column(name = "PARAM_ID", unique = false, nullable = true, length = 30)
	private String paramId;
	
	/** 参数值下限 **/
	@ApiModelProperty(value = "参数值下限", name = "minLimit", required = false)
	@Column(name = "MIN_LIMIT", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal minLimit;
	
	/** 参数值上限 **/
	@ApiModelProperty(value = "参数值上限", name = "maxLimit", required = false)
	@Column(name = "MAX_LIMIT", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal maxLimit;
	
	/** 生效范围(0-本机构
1-辖内机构) **/
	@ApiModelProperty(value = "生效范围", name = "area", required = false)
	@Column(name = "AREA", unique = false, nullable = true, length = 10)
	private String area;
	
	/** 业务条线 **/
	@ApiModelProperty(value = "业务条线", name = "bussSysNo", required = false)
	@Column(name = "BUSS_SYS_NO", unique = false, nullable = true, length = 50)
	private String bussSysNo;
	
	
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
	 * @param paramName
	 */
	public void setParamName(String paramName) {
		this.paramName = paramName == null ? null : paramName.trim();
	}
	
    /**
     * @return ParamName
     */	
	public String getParamName() {
		return this.paramName;
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
	 * @param dirId
	 */
	public void setDirId(String dirId) {
		this.dirId = dirId;
	}
	
    /**
     * @return DirId
     */	
	public String getDirId() {
		return this.dirId;
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
	 * @param paramValue
	 */
	public void setParamValue(java.math.BigDecimal paramValue) {
		this.paramValue = paramValue;
	}
	
    /**
     * @return ParamValue
     */	
	public java.math.BigDecimal getParamValue() {
		return this.paramValue;
	}
	
	/**
	 * @param paramId
	 */
	public void setParamId(String paramId) {
		this.paramId = paramId == null ? null : paramId.trim();
	}
	
    /**
     * @return ParamId
     */	
	public String getParamId() {
		return this.paramId;
	}
	
	/**
	 * @param minLimit
	 */
	public void setMinLimit(java.math.BigDecimal minLimit) {
		this.minLimit = minLimit;
	}
	
    /**
     * @return MinLimit
     */	
	public java.math.BigDecimal getMinLimit() {
		return this.minLimit;
	}
	
	/**
	 * @param maxLimit
	 */
	public void setMaxLimit(java.math.BigDecimal maxLimit) {
		this.maxLimit = maxLimit;
	}
	
    /**
     * @return MaxLimit
     */	
	public java.math.BigDecimal getMaxLimit() {
		return this.maxLimit;
	}
	
	/**
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area == null ? null : area.trim();
	}
	
    /**
     * @return Area
     */	
	public String getArea() {
		return this.area;
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


}