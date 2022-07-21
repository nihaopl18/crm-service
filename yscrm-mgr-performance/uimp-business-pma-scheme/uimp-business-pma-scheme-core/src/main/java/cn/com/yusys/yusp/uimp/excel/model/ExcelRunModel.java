package cn.com.yusys.yusp.uimp.excel.model;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: ExcelRunModel
 * @类描述: # 考核方案Excel-运行model类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-07 14:40:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class ExcelRunModel {

	// 考核方案编号
	private String schemeId;
	
	// 数据日期
	private String etlDate;
	
	// etl定时标志： 1后台跑批执行
	private String etlFlag;
	
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

	public String getEtlFlag() {
		return etlFlag;
	}

	public void setEtlFlag(String etlFlag) {
		this.etlFlag = etlFlag;
	}

}
