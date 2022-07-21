package cn.com.yusys.yusp.uimp.excel.model;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: ExcelPublishModel
 * @类描述: # 考核方案Excel发布model类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-27 15:40:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class ExcelPublishModel {
	
	// 考核方案报表运行信息表-主键值
	private String runId;
	
	// 考核方案发布隐藏行列信息表-主键值
	private String hideInfId;
	
	// 考核方案编号
	private String schemeId;
	
	// 数据日期
	private String etlDate;
	
	// 隐藏行信息
	private String hideRows;
	
	// 隐藏列信息
	private String hideCols;
	
	// 隐藏列索引信息
	private String hideColsIndex;

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId;
	}

	public String getHideInfId() {
		return hideInfId;
	}

	public void setHideInfId(String hideInfId) {
		this.hideInfId = hideInfId;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getEtlDate() {
		return etlDate;
	}

	public void setEtlDate(String etlDate) {
		this.etlDate = etlDate;
	}

	public String getHideRows() {
		return hideRows;
	}

	public void setHideRows(String hideRows) {
		this.hideRows = hideRows;
	}

	public String getHideCols() {
		return hideCols;
	}

	public void setHideCols(String hideCols) {
		this.hideCols = hideCols;
	}

	public String getHideColsIndex() {
		return hideColsIndex;
	}

	public void setHideColsIndex(String hideColsIndex) {
		this.hideColsIndex = hideColsIndex;
	}
}
