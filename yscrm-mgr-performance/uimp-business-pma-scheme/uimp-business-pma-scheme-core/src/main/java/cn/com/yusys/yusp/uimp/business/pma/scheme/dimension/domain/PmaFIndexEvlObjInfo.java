package cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFIndexEvlObjInfo
 * @类描述: PMA_F_INDEX_EVL_OBJ_INFO数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-02-12 14:49:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFIndexEvlObjInfo", description = "考核对象维度表")
@Entity
@Table(name = "PMA_F_INDEX_EVL_OBJ_INFO")
public class PmaFIndexEvlObjInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "ID", name = "id", required = false)
	private String id;

	/** 指标编号 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "INDEX_ID", name = "indexId", required = false)
	private String indexId;
	
	/** 考核对象类型 **/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "EVL_OBJ_TYPE", name = "evlObjType", required = false)
	private String evlObjType;

	/** 考核对象类型名称**/
	private String evlObjTypeName;

	public String getEvlObjTypeName() {
		return evlObjTypeName;
	}

	public void setEvlObjTypeName(String evlObjTypeName) {
		this.evlObjTypeName = evlObjTypeName;
	}

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
	 * @param indexId
	 */
	public void setIndexId(String indexId) {
		this.indexId = indexId == null ? null : indexId.trim();
	}
	
    /**
     * @return IndexId
     */	
	public String getIndexId() {
		return this.indexId;
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