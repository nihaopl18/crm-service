package cn.com.yusys.yusp.uimp.excel.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelCellInfo
 * @类描述: PMA_F_SCHEME_EXCELCELL_INF考核方案报表单元格信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:03:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_EXCELCELL_INF")
public class PmaFschemeExcelCellInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 单元格序列号 **/
	@Id
	@Column(name = "SEQ")
	@Generated(GenerationType.UUID)
	private String seq;
	
	/** 单元格标识 **/
	@Column(name = "CELL_NO", unique = false, nullable = false, length = 32)
	private String cellNo;
	
	/** 模板ID **/
	@Column(name = "TEMPLATE_ID", unique = false, nullable = false, length = 32)
	private String templateId;
	
	/** 行号 **/
	@Column(name = "ROW_ID", unique = false, nullable = false, length = 12)
	private Long rowId;
	
	/** 列号 **/
	@Column(name = "COL_ID", unique = false, nullable = false, length = 12)
	private Long colId;
	
	/** 单元格类型 **/
	@Column(name = "CELL_TYPE", unique = false, nullable = false, length = 10)
	private String cellType;
	
	/** 默认值 **/
	@Column(name = "DEFAULT_VALUE", unique = false, nullable = true, length = 200)
	private String defaultValue;
	
	/** 是否扩展单元格 **/
	@Column(name = "IS_EXTEND", unique = false, nullable = true, length = 10)
	private String isExtend;
	
	/** 预览展示数据 **/
	@Column(name = "DISPLAY_DATA", unique = false, nullable = true, length = 100)
	private String displayData;
	
	/** 显示格式 **/
	@Column(name = "DISPLAY_FORMAT", unique = false, nullable = true, length = 10)
	private String displayFormat;
	
	/** 数据单位 **/
	@Column(name = "DATA_UNIT", unique = false, nullable = true, length = 10)
	private String dataUnit;
	
	/** 显示精度 **/
	@Column(name = "DISPLAY_PRECISION", unique = false, nullable = true, length = 12)
	private Long displayPrecision;
	
	/** 是否展示-发布 **/
	@Column(name = "IS_SHOW", unique = false, nullable = true, length = 10)
	private String isShow;
	
	
	/**
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq == null ? null : seq.trim();
	}
	
    /**
     * @return Seq
     */	
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * @param cellNo
	 */
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo == null ? null : cellNo.trim();
	}
	
    /**
     * @return CellNo
     */	
	public String getCellNo() {
		return this.cellNo;
	}
	
	/**
	 * @param templateId
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId == null ? null : templateId.trim();
	}
	
    /**
     * @return TemplateId
     */	
	public String getTemplateId() {
		return this.templateId;
	}
	
	/**
	 * @param rowId
	 */
	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}
	
    /**
     * @return RowId
     */	
	public Long getRowId() {
		return this.rowId;
	}
	
	/**
	 * @param colId
	 */
	public void setColId(Long colId) {
		this.colId = colId;
	}
	
    /**
     * @return ColId
     */	
	public Long getColId() {
		return this.colId;
	}
	
	/**
	 * @param cellType
	 */
	public void setCellType(String cellType) {
		this.cellType = cellType == null ? null : cellType.trim();
	}
	
    /**
     * @return CellType
     */	
	public String getCellType() {
		return this.cellType;
	}
	
	/**
	 * @param defaultValue
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
    /**
     * @return DefaultValue
     */	
	public String getDefaultValue() {
		return this.defaultValue;
	}
	
	public String getIsExtend() {
		return isExtend;
	}

	public void setIsExtend(String isExtend) {
		this.isExtend = isExtend;
	}

	/**
	 * @param displayData
	 */
	public void setDisplayData(String displayData) {
		this.displayData = displayData == null ? null : displayData.trim();
	}
	
    /**
     * @return DisplayData
     */	
	public String getDisplayData() {
		return this.displayData;
	}
	
	/**
	 * @param displayFormat
	 */
	public void setDisplayFormat(String displayFormat) {
		this.displayFormat = displayFormat == null ? null : displayFormat.trim();
	}
	
    /**
     * @return DisplayFormat
     */	
	public String getDisplayFormat() {
		return this.displayFormat;
	}
	
	/**
	 * @param dataUnit
	 */
	public void setDataUnit(String dataUnit) {
		this.dataUnit = dataUnit == null ? null : dataUnit.trim();
	}
	
    /**
     * @return DataUnit
     */	
	public String getDataUnit() {
		return this.dataUnit;
	}
	
	/**
	 * @param displayPrecision
	 */
	public void setDisplayPrecision(Long displayPrecision) {
		this.displayPrecision = displayPrecision;
	}
	
    /**
     * @return DisplayPrecision
     */	
	public Long getDisplayPrecision() {
		return this.displayPrecision;
	}
	
	/**
	 * @param isShow
	 */
	public void setIsShow(String isShow) {
		this.isShow = isShow == null ? null : isShow.trim();
	}
	
    /**
     * @return IsShow
     */	
	public String getIsShow() {
		return this.isShow;
	}


}