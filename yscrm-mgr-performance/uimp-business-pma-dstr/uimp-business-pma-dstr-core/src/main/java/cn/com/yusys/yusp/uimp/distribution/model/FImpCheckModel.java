package cn.com.yusys.yusp.uimp.distribution.model;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: FImpCheckModel
 * @类描述: 业绩批量excel导入  业务校验 function
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-16 10:46:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public class FImpCheckModel {
	
	/** 批量导入批次号 **/
	private String vBatchid;
	
	/** 批量导入业务主键字段名 **/
	private String vKeycolumnname;
	
	/** 批量导入明细表表名 **/
	private String vDtltablename;
	
	/** 批量导入校验表表名 **/
	private String vChecktablename;
	
	/** 批量导入info表表名 **/
	private String vInfotablename;
	
	/** 返回值 **/
	private String result;

	public String getvBatchid() {
		return vBatchid;
	}

	public void setvBatchid(String vBatchid) {
		this.vBatchid = vBatchid;
	}

	public String getvKeycolumnname() {
		return vKeycolumnname;
	}

	public void setvKeycolumnname(String vKeycolumnname) {
		this.vKeycolumnname = vKeycolumnname;
	}

	public String getvDtltablename() {
		return vDtltablename;
	}

	public void setvDtltablename(String vDtltablename) {
		this.vDtltablename = vDtltablename;
	}

	public String getvChecktablename() {
		return vChecktablename;
	}

	public void setvChecktablename(String vChecktablename) {
		this.vChecktablename = vChecktablename;
	}

	public String getvInfotablename() {
		return vInfotablename;
	}

	public void setvInfotablename(String vInfotablename) {
		this.vInfotablename = vInfotablename;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}