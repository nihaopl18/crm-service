package cn.com.yusys.yusp.uimp.distribution.model;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: InvokeDataModel
 * @类描述: 业绩批量导入结果-撤销批次model
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-10-23 22:51:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public class InvokeDataModel {

	private String funCode;
	
	private String batchId;

	public String getFunCode() {
		return funCode;
	}

	public void setFunCode(String funCode) {
		this.funCode = funCode;
	}

	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
}
