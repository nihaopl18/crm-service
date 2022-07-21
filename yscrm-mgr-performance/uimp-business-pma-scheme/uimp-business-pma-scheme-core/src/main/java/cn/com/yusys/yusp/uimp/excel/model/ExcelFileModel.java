package cn.com.yusys.yusp.uimp.excel.model;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: ExcelFileModel
 * @类描述: # 考核方案Excel-excel文件model类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-07-01 14:40:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class ExcelFileModel {

	private String title; // excel文件标题
	
	private String schemeId; // 考核方案编号
	
	private String etlDate; // 数据日期
	
	private String jsonStr; // excel内容json

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStr = jsonStr;
	}
}
