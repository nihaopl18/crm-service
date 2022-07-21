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
 * @类名称: PmaFSchemeSperuleRel
 * @类描述: PMA_F_SCHEME_SPERULE_REL数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 19:18:19
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFSchemeSperuleRel", description = "考核方案特殊规则表")
@Entity
@Table(name = "PMA_F_SCHEME_SPERULE_REL")
public class PmaFSchemeSperuleRel extends BaseDomain implements Serializable{
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
	
	/** 评价对象类型（01-员工 02-机构） **/
	@Column(name = "EVL_OBJ_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "评价对象ID（存放单个员工号或机构号）", name = "evlObjId", required = false)
	private String evlObjId;
	
	/** 评价对象ID（存放单个员工号或机构号） **/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "评价对象类型（01-员工 02-机构）", name = "evlObjType", required = false)
	private String evlObjType;
	
	
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
	 * @param evlObjType
	 */
	public void setEvlObjType(String evlObjType) {
		this.evlObjType = evlObjType == null ? null : evlObjType.trim();
	}
	
    /**
     * @return EvlObjType
     */	
	public String getEvlObjType() {
		return this.evlObjType;
	}


}