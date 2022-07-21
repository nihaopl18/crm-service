package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeOrgRel
 * @类描述: PMA_F_SCHEME_ORG_REL数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 18:13:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFSchemeOrgRel", description = "考核方案机构关系表")
@Entity
@Table(name = "PMA_F_SCHEME_ORG_REL")
public class PmaFSchemeOrgRel extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "ID", name = "id", required = false)
	private String id;

	/** 考核方案ID **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "考核方案ID", name = "schemeId", required = false)
	private String schemeId;
	
	/** 机构ID **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "机构ID", name = "orgId", required = false)
	private String orgId;
	
	/** 机构名称 **/
	@Column(name = "ORG_NAME", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "机构名称", name = "orgName", required = false)
	private String orgName;
	
	
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
	 * @param schemeId
	 */
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId == null ? null : schemeId.trim();
	}
	
    /**
     * @return SchemeId
     */	
	public String getSchemeId() {
		return this.schemeId;
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


}