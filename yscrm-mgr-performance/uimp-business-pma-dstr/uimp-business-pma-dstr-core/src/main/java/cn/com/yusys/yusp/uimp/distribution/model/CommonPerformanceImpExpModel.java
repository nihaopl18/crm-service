package cn.com.yusys.yusp.uimp.distribution.model;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonPerformanceImpExpModel
 * @类描述: # 业绩批量导入  导出接口请求参数model类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-10 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class CommonPerformanceImpExpModel {

	private String funCode;
	private String funName;
	private String excelHeader;
	private String searchParams;
	private String dataAuth;
	private String dataBussAuth;

	public String getFunCode() {
		return funCode;
	}

	public void setFunCode(String funCode) {
		this.funCode = funCode;
	}

	public String getFunName() {
		return funName;
	}

	public void setFunName(String funName) {
		this.funName = funName;
	}

	public String getExcelHeader() {
		return excelHeader;
	}

	public void setExcelHeader(String excelHeader) {
		this.excelHeader = excelHeader;
	}

	public String getSearchParams() {
		return searchParams;
	}

	public void setSearchParams(String searchParams) {
		this.searchParams = searchParams;
	}

	public String getDataAuth() {
		return dataAuth;
	}

	public void setDataAuth(String dataAuth) {
		this.dataAuth = dataAuth;
	}

	public String getDataBussAuth() {
		return dataBussAuth;
	}

	public void setDataBussAuth(String dataBussAuth) {
		this.dataBussAuth = dataBussAuth;
	}
}
