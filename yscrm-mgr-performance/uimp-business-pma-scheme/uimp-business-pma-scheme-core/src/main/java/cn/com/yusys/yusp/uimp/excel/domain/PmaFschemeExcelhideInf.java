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
 * @类名称: PmaFschemeExcelhideInf
 * @类描述: PMA_F_SCHEME_EXCELHIDE_INF考核方案发布隐藏行列信息表 数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-27 15:17:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_SCHEME_EXCELHIDE_INF")
public class PmaFschemeExcelhideInf extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 考核方案ID **/
	@Column(name = "SCHEME_ID", unique = false, nullable = false, length = 50)
	private String schemeId;
	
	/** 数据日期 **/
	@Column(name = "ETL_DATE", unique = false, nullable = false, length = 8)
	private String etlDate;
	
	/** 隐藏行信息 **/
	@Column(name = "HIDE_ROWS", unique = false, nullable = true, length = 1500)
	private String hideRows;
	
	/** 隐藏列信息 **/
	@Column(name = "HIDE_COLS", unique = false, nullable = true, length = 1500)
	private String hideCols;
	
	/** 隐藏列索引信息 **/
	@Column(name = "HIDE_COLS_INDEX", unique = false, nullable = true, length = 1500)
	private String hideColsIndex;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	 * @param etlDate
	 */
	public void setEtlDate(String etlDate) {
		this.etlDate = etlDate == null ? null : etlDate.trim();
	}
	
    /**
     * @return EtlDate
     */	
	public String getEtlDate() {
		return this.etlDate;
	}
	
	/**
	 * @param hideRows
	 */
	public void setHideRows(String hideRows) {
		this.hideRows = hideRows == null ? null : hideRows.trim();
	}
	
    /**
     * @return HideRows
     */	
	public String getHideRows() {
		return this.hideRows;
	}
	
	/**
	 * @param hideCols
	 */
	public void setHideCols(String hideCols) {
		this.hideCols = hideCols == null ? null : hideCols.trim();
	}
	
    /**
     * @return HideCols
     */	
	public String getHideCols() {
		return this.hideCols;
	}
	
	/**
	 * @param hideColsIndex
	 */
	public void setHideColsIndex(String hideColsIndex) {
		this.hideColsIndex = hideColsIndex == null ? null : hideColsIndex.trim();
	}
	
    /**
     * @return HideColsIndex
     */	
	public String getHideColsIndex() {
		return this.hideColsIndex;
	}


}