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
 * @类名称: PmaFIndexApplyInfo
 * @类描述: PMA_F_INDEX_APPLY_INFO数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-02-12 14:51:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFIndexApplyInfo", description = "应用类型维度表")
@Entity
@Table(name = "PMA_F_INDEX_APPLY_INFO")
public class PmaFIndexApplyInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "ID", name = "id", required = false)
	private String id;

	/** 指标编号
 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "INDEX_ID", name = "indexId", required = false)
	private String indexId;
	
	/** 应用类型
 **/
	@Column(name = "APPLY_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "APPLY_TYPE", name = "applyType", required = false)
	private String applyType;

	/** 应用类型名称**/
	private String applyTypeName;

	public String getApplyTypeName() {
		return applyTypeName;
	}

	public void setApplyTypeName(String applyTypeName) {
		this.applyTypeName = applyTypeName;
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
	 * @param applyType
	 */
	public void setApplyType(String applyType) {
		this.applyType = applyType == null ? null : applyType.trim();
	}
	
    /**
     * @return ApplyType
     */	
	public String getApplyType() {
		return this.applyType;
	}


}