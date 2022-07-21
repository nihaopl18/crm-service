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
 * @类名称: PmaFSchemePostRel
 * @类描述: PMA_F_SCHEME_POST_REL数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 19:07:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFSchemePostRel", description = "考核方案岗位关系表")
@Entity
@Table(name = "PMA_F_SCHEME_POST_REL")
public class PmaFSchemePostRel extends BaseDomain implements Serializable{
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
	
	/** 岗位ID **/
	@Column(name = "POST_ID", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "岗位ID", name = "postId", required = false)
	private String postId;
	
	/** 岗位名称 **/
	@Column(name = "POST_NAME", unique = false, nullable = true, length = 100)
	@ApiModelProperty(value = "岗位名称", name = "postName", required = false)
	private String postName;
	
	
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
	 * @param postId
	 */
	public void setPostId(String postId) {
		this.postId = postId == null ? null : postId.trim();
	}
	
    /**
     * @return PostId
     */	
	public String getPostId() {
		return this.postId;
	}
	
	/**
	 * @param postName
	 */
	public void setPostName(String postName) {
		this.postName = postName == null ? null : postName.trim();
	}
	
    /**
     * @return PostName
     */	
	public String getPostName() {
		return this.postName;
	}


}