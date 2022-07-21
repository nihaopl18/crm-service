package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain;

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
 * @类名称: PmaFIndexCdtInfo
 * @类描述: PMA_F_INDEX_CDT_INFO数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-02-12 16:43:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@ApiModel(value = "PmaFIndexCdtInfo", description = "基础指标条件值")
@Entity
@Table(name = "PMA_F_INDEX_CDT_INFO")
public class PmaFIndexCdtInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID
 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	@ApiModelProperty(value = "主键", name = "id", required = false)
	private String id;

	/** 指标编号
 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 20)
	@ApiModelProperty(value = "指标编号", name = "indexId", required = false)
	private String indexId;
	
	/** 条件类型
 **/
	@Column(name = "CDT_TYPE", unique = false, nullable = true, length = 2)
	@ApiModelProperty(value = "条件类型", name = "cdtType", required = false)
	private String cdtType;
	
	/** 条件列

 **/
	@Column(name = "CDT_COLUMN", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "条件列", name = "cdtColumn", required = false)
	private String cdtColumn;
	
	/** 条件值
 **/
	@Column(name = "CDT_VALUE", unique = false, nullable = true, length = 1000)
	@ApiModelProperty(value = "条件值", name = "cdtValue", required = false)
	private String cdtValue;
	
	/** 条件值名
 **/
	@Column(name = "CDT_VALUE_NAME", unique = false, nullable = true, length = 50)
	@ApiModelProperty(value = "条件值名", name = "cdtValueName", required = false)
	private String cdtValueName;
	
	/** 条件方向类型（
0反向过滤正向过滤
1) **/
	@Column(name = "CDT_DIR_TYPE", unique = false, nullable = true, length = 1000)
	@ApiModelProperty(value = "条件方向类型", name = "cdtDirType", required = false)
	private String cdtDirType;
	
	
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
	 * @param cdtType
	 */
	public void setCdtType(String cdtType) {
		this.cdtType = cdtType == null ? null : cdtType.trim();
	}
	
    /**
     * @return CdtType
     */	
	public String getCdtType() {
		return this.cdtType;
	}
	
	/**
	 * @param cdtColumn
	 */
	public void setCdtColumn(String cdtColumn) {
		this.cdtColumn = cdtColumn == null ? null : cdtColumn.trim();
	}
	
    /**
     * @return CdtColumn
     */	
	public String getCdtColumn() {
		return this.cdtColumn;
	}
	
	/**
	 * @param cdtValue
	 */
	public void setCdtValue(String cdtValue) {
		this.cdtValue = cdtValue == null ? null : cdtValue.trim();
	}
	
    /**
     * @return CdtValue
     */	
	public String getCdtValue() {
		return this.cdtValue;
	}
	
	/**
	 * @param cdtValueName
	 */
	public void setCdtValueName(String cdtValueName) {
		this.cdtValueName = cdtValueName == null ? null : cdtValueName.trim();
	}
	
    /**
     * @return CdtValueName
     */	
	public String getCdtValueName() {
		return this.cdtValueName;
	}
	
	/**
	 * @param cdtDirType
	 */
	public void setCdtDirType(String cdtDirType) {
		this.cdtDirType = cdtDirType == null ? null : cdtDirType.trim();
	}
	
    /**
     * @return CdtDirType
     */	
	public String getCdtDirType() {
		return this.cdtDirType;
	}


}