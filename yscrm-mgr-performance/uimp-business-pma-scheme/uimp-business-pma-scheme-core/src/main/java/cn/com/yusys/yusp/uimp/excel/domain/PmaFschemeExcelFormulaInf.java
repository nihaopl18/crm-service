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
 * @类名称: PmaFschemeExcelFormulaInf
 * @类描述: PMA_F_SCHEME_EXCELFORMULA_INF考核方案报表公式信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:05:34
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_EXCELFORMULA_INF")
public class PmaFschemeExcelFormulaInf extends BaseDomain implements Serializable{
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
	
	/** EXCEL公式 **/
	@Column(name = "EXCEL_FORMULA", unique = false, nullable = false, length = 200)
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