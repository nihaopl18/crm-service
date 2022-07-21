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
 * @类名称: PmaFschemeExcelsvwInf
 * @类描述: PMA_F_SCHEME_EXCELSVW_INF考核方案报表得分/计价/权重信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-07-29 15:25:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_EXCELSVW_INF")
public class PmaFschemeExcelsvwInf extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 单元格序列号 **/
	@Id
	@Column(name = "SEQ")
	@Generated(GenerationType.UUID)
	private String seq;
	/** 模板ID **/
	@Id
	@Column(name = "TEMPLATE_ID")
	@Generated(GenerationType.UUID)
	private String templateId;
	
	/** 单元格标识 **/
	@Column(name = "CELL_NO", unique = false, nullable = false, length = 32)
	private String cellNo;
	
	/** 元素类型(01得分，02权重，03计价) **/
	@Column(name = "RESULT_TYPE", unique = false, nullable = true, length = 2)
	private String resultType;
	
	/** 关联基础指标编号 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 20)
	private String indexId;
	
	/** 关联派生指标编号 **/
	@Column(name = "EVLINDEX_ID", unique = false, nullable = true, length = 20)
	private String evlindexId;
	
	/** 考核对象类型(维度) **/
	@Column(name = "EVL_OBJ_TYPE", unique = false, nullable = true, length = 4)
	private String evlObjType;
	
	/** 余额类型(维度) **/
	@Column(name = "BAL_TYPE", unique = false, nullable = true, length = 4)
	private String balType;
	
	/** 应用类型(维度) **/
	@Column(name = "APPLY_TYPE", unique = false, nullable = true, length = 4)
	private String applyType;
	
	/** EXCEL公式 **/
	@Column(name = "EXCEL_FORMULA", unique = false, nullable = true, length = 2000)
	private String excelFormula;
	
	/** 实际值 **/
	@Column(name = "EXCEL_FORMULA_VALUE", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal excelFormulaValue;
	
	/** 考核对象编号 **/
	@Column(name = "EVL_OBJ_ID", unique = false, nullable = true, length = 50)
	private String evlObjId;
	
	
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
	 * @param resultType
	 */
	public void setResultType(String resultType) {
		this.resultType = resultType == null ? null : resultType.trim();
	}
	
    /**
     * @return ResultType
     */	
	public String getResultType() {
		return this.resultType;
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
	 * @param evlindexId
	 */
	public void setEvlindexId(String evlindexId) {
		this.evlindexId = evlindexId == null ? null : evlindexId.trim();
	}
	
    /**
     * @return EvlindexId
     */	
	public String getEvlindexId() {
		return this.evlindexId;
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
	
	/**
	 * @param balType
	 */
	public void setBalType(String balType) {
		this.balType = balType == null ? null : balType.trim();
	}
	
    /**
     * @return BalType
     */	
	public String getBalType() {
		return this.balType;
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
	
	/**
	 * @param excelFormula
	 */
	public void setExcelFormula(String excelFormula) {
		this.excelFormula = excelFormula == null ? null : excelFormula.trim();
	}
	
    /**
     * @return ExcelFormula
     */	
	public String getExcelFormula() {
		return this.excelFormula;
	}
	
	/**
	 * @param excelFormulaValue
	 */
	public void setExcelFormulaValue(java.math.BigDecimal excelFormulaValue) {
		this.excelFormulaValue = excelFormulaValue;
	}
	
    /**
     * @return ExcelFormulaValue
     */	
	public java.math.BigDecimal getExcelFormulaValue() {
		return this.excelFormulaValue;
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


}