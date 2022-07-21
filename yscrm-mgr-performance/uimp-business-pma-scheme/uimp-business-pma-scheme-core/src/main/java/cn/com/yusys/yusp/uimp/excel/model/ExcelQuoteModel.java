package cn.com.yusys.yusp.uimp.excel.model;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: ExcelQuoteModel
 * @类描述: # 考核方案Excel-引用model类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-06-29 14:40:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class ExcelQuoteModel {
	
	// 考核方案编号
	private String schemeId;
	
	// 考核方案目录编号
	private String menuId;

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	
}
