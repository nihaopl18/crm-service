package cn.com.yusys.yusp.uimp.excel.model;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: ExcelDataModel
 * @类描述: # 考核方案Excel组件数据更新model类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:40:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class ExcelDataModel {
	
	// 考核方案编号
	private String schemeId;
	
	/**
	 *  {
	 *    commonArray: [], 所有单元格数据集
	 *    idxArray:[], 基础指标数据集
	 *    evlidxArray:[], 派生指标数据集
	 *    formulaArray:[], 公式数据集
	 *    evalobjArray:[],  考核对象数据集
     *    orgParamArray: [],  机构参数数据集
     *    postParamArray: [],  岗位参数数据集
     *    svwArray: [],	得分/计价/权重数据集
     *    dutyArray: [], 岗位数据集
     *    orgArray: [], 所属机构数据集
     *    objIdArray: [] 考核对象编号数据集
	 *  }
	 */
	// 单元格数据集
	private String designData;
	
	// 模板ID
	private String templateId;
	
	// 模板类型
	private String templateType;
	
	// excel模板样式json
	private String templateJson;
	
	// 考核对象类型
	private String evlObjType;

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getDesignData() {
		return designData;
	}

	public void setDesignData(String designData) {
		this.designData = designData;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTemplateType() {
		return templateType;
	}

	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}

	public String getTemplateJson() {
		return templateJson;
	}

	public void setTemplateJson(String templateJson) {
		this.templateJson = templateJson;
	}

	public String getEvlObjType() {
		return evlObjType;
	}

	public void setEvlObjType(String evlObjType) {
		this.evlObjType = evlObjType;
	}
}
