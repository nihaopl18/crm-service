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
 * @类名称: PmaFschemeExcelorgparamInf
 * @类描述: PMA_F_SCHEME_EXCELORGPARAM_INF考核方案报表机构参数信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-19 12:27:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_EXCELORGPARAM_INF")
public class PmaFschemeExcelorgparamInf extends BaseDomain implements Serializable{
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
	
	/** 机构参数编号 **/
	@Column(name = "ORG_PARAM_ID", unique = false, nullable = false, length = 30)
	private String orgParamId;
	
	/** 参数值 **/
	@Column(name = "PARAM_VALUE", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal paramValue;
	
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
	 * @param orgParamId
	 */
	public void setOrgParamId(String orgParamId) {
		this.orgParamId = orgParamId == null ? null : orgParamId.trim();
	}
	
    /**
     * @return OrgParamId
     */	
	public String getOrgParamId() {
		return this.orgParamId;
	}
	
	/**
	 * @param paramValue
	 */
	public void setParamValue(java.math.BigDecimal paramValue) {
		this.paramValue = paramValue;
	}
	
    /**
     * @return ParamValue
     */	
	public java.math.BigDecimal getParamValue() {
		return this.paramValue;
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