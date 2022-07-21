package cn.com.yusys.yusp.uimp.base.model;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: EtlDateModel
 * @类描述: #数据日期表 model类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-09-21 16:49:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class EtlDateModel {
	
	private String etlType;
	
	private String etlDate;
	
	private String etlState;

	public String getEtlType() {
		return etlType;
	}

	public void setEtlType(String etlType) {
		this.etlType = etlType;
	}

	public String getEtlDate() {
		return etlDate;
	}

	public void setEtlDate(String etlDate) {
		this.etlDate = etlDate;
	}

	public String getEtlState() {
		return etlState;
	}

	public void setEtlState(String etlState) {
		this.etlState = etlState;
	}
}
