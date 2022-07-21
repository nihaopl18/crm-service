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
 * @类名称: PmaFschemeExcelorgInf
 * @类描述: PMA_F_SCHEME_EXCELORG_INF考核方案报表考核/归属机构信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2021-01-15 22:11:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_EXCELORG_INF")
public class PmaFschemeExcelorgInf extends BaseDomain implements Serializable{
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
	
	/** 归属机构编号 **/
	@Column(name = "BELONG_ORG_ID", unique = false, nullable = true, length = 50)
	private String belongOrgId;
	
	/** 考核机构/归属机构名称 **/
	@Column(name = "BELONG_ORG_NAME", unique = false, nullable = true, length = 100)
	private String belongOrgName;
	
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
	 * @param belongOrgId
	 */
	public void setBelongOrgId(String belongOrgId) {
		this.belongOrgId = belongOrgId == null ? null : belongOrgId.trim();
	}
	
    /**
     * @return BelongOrgId
     */	
	public String getBelongOrgId() {
		return this.belongOrgId;
	}
	
	/**
	 * @param belongOrgName
	 */
	public void setBelongOrgName(String belongOrgName) {
		this.belongOrgName = belongOrgName == null ? null : belongOrgName.trim();
	}
	
    /**
     * @return BelongOrgName
     */	
	public String getBelongOrgName() {
		return this.belongOrgName;
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