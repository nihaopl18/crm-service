package cn.com.yusys.yusp.uimp.base.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFuncReg
 * @类描述: ADMIN_BASE_META_FUNC_REG数据实体类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-12-07 17:56:14
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "AdminBaseMetaFunReg", description = "业务功能注册信息")
@Entity
@Table(name = "ADMIN_BASE_META_FUN_REG")
public class AdminBaseMetaFunReg extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "主键", name = "id", required = false)
	private String id;

	/** 业务名称 **/
	@Column(name = "FUN_NAME", unique = false, nullable = false, length = 255)
	@ApiModelProperty(value = "业务名称", name = "funName", required = true)
	private String funName;

	/** 业务标识码 **/
	@Column(name = "FUN_CODE", unique = false, nullable = false, length = 255)
	@ApiModelProperty(value = "业务标识码", name = "funCode", required = true)
	private String funCode;

	/** 业务类型 **/
	@Column(name = "FUN_TYPE", unique = false, nullable = false, length = 255)
	@ApiModelProperty(value = "业务类型", name = "funType", required = true)
	private String funType;

	/** 功能描述 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 255)
	@ApiModelProperty(value = "功能描述", name = "remark", required = true)
	private String remark;
	
	@Transient
	private List<AdminBaseMetaFunColumn> funColumnList;

	@Transient
	private List<AdminBaseMetaFunColumnCfg> funColumnCfgList;

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
	 * @param funName
	 */
	public void setFunName(String funName) {
		this.funName = funName == null ? null : funName.trim();
	}

	/**
	 * @return FunName
	 */
	public String getFunName() {
		return this.funName;
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
	 * @param funType
	 */
	public void setFunType(String funType) {
		this.funType = funType == null ? null : funType.trim();
	}

	/**
	 * @return FunType
	 */
	public String getFunType() {
		return this.funType;
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

	public List<AdminBaseMetaFunColumn> getFunColumnList() {
		return funColumnList;
	}

	@SuppressWarnings("unchecked")
	public void setFunColumnList(String funColumnString) {
		JSONArray funColumnArray = JSONArray.fromObject(funColumnString);
		this.funColumnList = JSONArray.toList(funColumnArray, new AdminBaseMetaFunColumn(),new JsonConfig());
	}

	public List<AdminBaseMetaFunColumnCfg> getFunColumnCfgList() {
		return funColumnCfgList;
	}

	@SuppressWarnings("unchecked")
	public void setFunColumnCfgList(String funColumnCfgString) {
		JSONArray funColumnCfgArray = JSONArray.fromObject(funColumnCfgString);
		this.funColumnCfgList = JSONArray.toList(funColumnCfgArray, new AdminBaseMetaFunColumnCfg(), new JsonConfig());
	}

}