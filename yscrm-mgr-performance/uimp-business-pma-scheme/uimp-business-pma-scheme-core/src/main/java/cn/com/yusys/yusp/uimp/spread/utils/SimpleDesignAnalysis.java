package cn.com.yusys.yusp.uimp.spread.utils;

import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelCellInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelTmpInfo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yuchengtech.bione.utils.BeanUtils;
import com.yuchengtech.report.frame.design.web.vo.CellInfo;
import com.yuchengtech.report.frame.spreadjs.entity.*;
import org.apache.commons.lang3.math.NumberUtils;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: SimpleDesignAnalysis
 * @类描述: # 考核方案Excel组件-单元格数据简单加工 服务类
 * @功能描述: 方案预览/运行结果查询/我的方案结果查询/机构员工方案结果查询时，在后台加工单元格数据到json中，给前台直接展示
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:01:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class SimpleDesignAnalysis {
	
	private List<CellInfo> cellInfos = new ArrayList<CellInfo>();

	private SpreadSchema schema = null;
	
	private DataTable newDataTable = new DataTable();

	private Data data = null;

	private SheetsProperty sheetP = new SheetsProperty();

	private DataTable dataTable = null;
	
	protected PmaFschemeExcelTmpInfo tmpInfo;
	
	protected List<PmaFschemeExcelCellInfo> cellInfoList = null;
	protected List<Map<String, Object>> objCellInfoList = null;
	protected List<Map<String, Object>> indexCellInfoList = null;
	protected List<Map<String, Object>> evlindexCellInfoList = null;
	protected List<Map<String, Object>> formulaCellInfoList = null;
	protected List<Map<String, Object>> orgparamCellInfoList = null;
	protected List<Map<String, Object>> pstparamCellInfoList = null;
	protected List<Map<String, Object>> svwCellInfoList = null;
	protected List<Map<String, Object>> dutyCellInfoList = null;
	protected List<Map<String, Object>> orgCellInfoList = null;
	protected List<Map<String, Object>> objIdCellInfoList = null;
	
	protected Map<String, Map<String, Object>> cellMaps = new HashMap<String, Map<String, Object>>();
	
	public SimpleDesignAnalysis(SpreadSchema schema, PmaFschemeExcelTmpInfo tmpInfo, List<PmaFschemeExcelCellInfo> cellInfoList,
			List<Map<String, Object>> objCellInfoList, List<Map<String, Object>> indexCellInfoList, 
			List<Map<String, Object>> evlindexCellInfoList, List<Map<String, Object>> formulaCellInfoList, 
			List<Map<String, Object>> orgparamCellInfoList, List<Map<String, Object>> pstparamCellInfoList, 
			List<Map<String, Object>> svwCellInfoList, List<Map<String, Object>> dutyCellInfoList, 
			List<Map<String, Object>> orgCellInfoList, List<Map<String, Object>> objIdCellInfoList) {
		this.schema = schema;
		this.tmpInfo = tmpInfo;
		this.cellInfoList = cellInfoList;
		this.objCellInfoList = objCellInfoList;
		this.indexCellInfoList = indexCellInfoList;
		this.evlindexCellInfoList = evlindexCellInfoList;
		this.formulaCellInfoList = formulaCellInfoList;
		this.orgparamCellInfoList = orgparamCellInfoList;
		this.pstparamCellInfoList = pstparamCellInfoList;
		this.svwCellInfoList = svwCellInfoList;
		this.dutyCellInfoList = dutyCellInfoList;
		this.orgCellInfoList = orgCellInfoList;
		this.objIdCellInfoList = objIdCellInfoList;
		createCellInfoMap(cellInfoList, objCellInfoList, indexCellInfoList, evlindexCellInfoList, formulaCellInfoList, 
				orgparamCellInfoList, pstparamCellInfoList, svwCellInfoList, dutyCellInfoList, orgCellInfoList,
				objIdCellInfoList);
		createSchema();
	}
	
	private void createCellInfoMap(List<PmaFschemeExcelCellInfo> cellInfoList, 
			List<Map<String, Object>> objCellInfoList, List<Map<String, Object>> indexCellInfoList, 
			List<Map<String, Object>> evlindexCellInfoList, List<Map<String, Object>> formulaCellInfoList, 
			List<Map<String, Object>> orgparamCellInfoList, List<Map<String, Object>> pstparamCellInfoList, 
			List<Map<String, Object>> svwCellInfoList, List<Map<String, Object>> dutyCellInfoList, 
			List<Map<String, Object>> orgCellInfoList, List<Map<String, Object>> objIdCellInfoList) {
		if(cellInfoList != null && cellInfoList.size() > 0) {
			Map<String, Object> tempMap = null;
			for(PmaFschemeExcelCellInfo item: cellInfoList) {
				tempMap = new HashMap<String, Object>();
				tempMap.put("seq", item.getSeq());
				tempMap.put("cellNo", item.getCellNo());
				tempMap.put("rowId", item.getRowId());
				tempMap.put("colId", item.getColId());
				tempMap.put("cellType", item.getCellType());
				tempMap.put("defaultValue", item.getDefaultValue());
				this.cellMaps.put(item.getRowId() + "," + item.getColId(), tempMap);
			}
		}
		if(objCellInfoList != null && objCellInfoList.size() > 0) {
			for(Map<String, Object> item: objCellInfoList) {	
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
		if(indexCellInfoList != null && indexCellInfoList.size() > 0) {
			for(Map<String, Object> item: indexCellInfoList) {	
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
		if(evlindexCellInfoList != null && evlindexCellInfoList.size() > 0) {
			for(Map<String, Object> item: evlindexCellInfoList) {	
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
		if(formulaCellInfoList != null && formulaCellInfoList.size() > 0) {
			for(Map<String, Object> item: formulaCellInfoList) {
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
		if(orgparamCellInfoList != null && orgparamCellInfoList.size() > 0) {
			for(Map<String, Object> item: orgparamCellInfoList) {
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
		if(pstparamCellInfoList != null && pstparamCellInfoList.size() > 0) {
			for(Map<String, Object> item: pstparamCellInfoList) {
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
		if(svwCellInfoList != null && svwCellInfoList.size() > 0) {
			for(Map<String, Object> item: svwCellInfoList) {
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
		if(dutyCellInfoList != null && dutyCellInfoList.size() > 0) {
			for(Map<String, Object> item: dutyCellInfoList) {
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
		if(orgCellInfoList != null && orgCellInfoList.size() > 0) {
			for(Map<String, Object> item: orgCellInfoList) {
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
		if(objIdCellInfoList != null && objIdCellInfoList.size() > 0) {
			for(Map<String, Object> item: objIdCellInfoList) {
				this.cellMaps.put(item.get("rowId") + "," + item.get("colId"), item);
			}
		}
	}
	
	private void createSchema() {
		if (schema != null) {
			Map<String, SheetsProperty> sheetsTable = schema.getSheetsProperties();
			Object[] key = sheetsTable.keySet().toArray();
			data = sheetsTable.get(key[0]).getData();
			this.sheetP = sheetsTable.get(key[0]);
			if (data != null) {
				dataTable = data.getDataTable();
			}
		}
	}
	
	public String analysisSourceInfo() {
		String result = "";
		if (schema != null && dataTable != null) {
			this.sheetP.setRowCount(0);
			analysisInfo();
			this.schema.setShowHorizontalScrollbar(true);
			this.schema.setShowVerticalScrollbar(true);
			this.sheetP.setActiveCol(null);
			this.sheetP.setActiveRow(null);
			this.sheetP.setAllowCellOverflow(true);
			this.sheetP.setSelections(null);
			this.sheetP.setFrozenLineShowFlag(false);
			result = JSON.toJSONString(schema, SerializerFeature.DisableCircularReferenceDetect);
		} else {
//			result.put("error", "所选模板信息配置异常！");
		}
		return result;
	}
	
	private String analysisInfo() {
		String info = "";
		// expendSheetSize();
		setCellMap();
		setProInfo();
		setDataTable(newDataTable);
		return info;
	}
	
	private void setCellMap() {
		Map<String, DataTableProperty> dtps = dataTable.getAdditionalProperties();
		Object obj = null;
		Map<String, Object> cellMap = null;
		Object result = null;
		for (String rowIndex : dtps.keySet()) {
			Map<String, Object> dtpps = dtps.get(rowIndex).getAdditionalProperties();
			for (String colIndex : dtpps.keySet()) {
				cellMap = getCellMap(NumberUtils.toInt(rowIndex), NumberUtils.toInt(colIndex));
				obj = dtpps.get(colIndex);
				if(cellMap == null) {
					DataTablePropertyProperty pro = getProInfo(obj, null, false);
					if(pro.getValue() != null) {	// 处理: 没有关联单元格类型 且 单元格Value非空的单元格数据
						result = pro.getValue();
						dealResult(result, NumberUtils.toInt(rowIndex), NumberUtils.toInt(colIndex), obj);
					}
				} else {
					result = "";
					if(ExcelConstants.CELL_TYPE_COMMON.equals(cellMap.get("cellType"))) {	// 一般单元格
						result = cellMap.get("defaultValue");
					} else if(ExcelConstants.CELL_TYPE_EVALOBJ.equals(cellMap.get("cellType"))) {	// 考核对象单元格
						result = cellMap.get("evlObjName");
					} else if(ExcelConstants.CELL_TYPE_DUTY.equals(cellMap.get("cellType"))) {	// 岗位单元格
						result = cellMap.get("dutyName");
					} else if(ExcelConstants.CELL_TYPE_ORG.equals(cellMap.get("cellType"))) {	// 所属机构单元格
						result = cellMap.get("belongOrgName");
					} else if(ExcelConstants.CELL_TYPE_OBJID.equals(cellMap.get("cellType"))) {	// 考核对象编号单元格
						result = cellMap.get("evlObjId");
					} else {	// 其他单元格
						if(cellMap.get("defaultValue") != null && StringUtil.isNotEmpty(cellMap.get("defaultValue") + "")) {
							result = cellMap.get("defaultValue");
						} else {
							result = cellMap.get("resultValue");
						}
					}
					dealResult(result, NumberUtils.toInt(rowIndex), NumberUtils.toInt(colIndex), obj);
				}
			}
		}
	}
	
	private void setProInfo() {
		for (CellInfo cellInfo : cellInfos) {
			// 此处后续可以根据不同的单元格类型，调整展示值格式，目前统一处理
			bindCellInfo(cellInfo);	// 绑定单元格property属性到sheet
		}
	}
	
	protected void setDataTable(DataTable dataTable) {
		if (schema != null) {
			Map<String, SheetsProperty> sheetsTable = schema.getSheetsProperties();
			Object[] key = sheetsTable.keySet().toArray();
			data = sheetsTable.get(key[0]).getData();
			data.setDataTable(dataTable);
		}
	}
	
	private void dealResult(Object result, int rowId, int colId, Object obj) {
		String rowNum = String.valueOf(rowId);
		String colNum = String.valueOf(colId);
		String extDirection = "";
		CellInfo cellInfo = new CellInfo(NumberUtils.toInt(rowNum), NumberUtils.toInt(colNum));
		DataTablePropertyProperty pro = getProInfo(obj, null, false);
		pro.setValue(result);
		cellInfo.addDataTablePropertyProperty(pro);
		cellInfo.setONm(rowId, colId);
		cellInfo.setInitDirection(extDirection);
		cellInfos.add(cellInfo);
	}
	
	private DataTablePropertyProperty getProInfo(Object obj, String formula, boolean flag) {
		DataTablePropertyProperty pro = new DataTablePropertyProperty();
		if (obj != null && obj instanceof DataTablePropertyProperty) {
			DataTablePropertyProperty source = (DataTablePropertyProperty) obj;
			if (flag)
				BeanUtils.copy(source, pro);
			else
				pro = source;
			if (source.getStyle() instanceof String) {
				String style = String.valueOf(source.getStyle());
				pro.setStyle(style);
			} else
				pro.setStyle(source.getStyle());
			pro.setValue(source.getValue());
			if (formula != null)
				pro.setFormula(formula);

		} else {
			pro.setValue(obj);
			if (formula != null)
				pro.setFormula(formula);
		}
		return pro;
	}
	
	private Map<String, Object> getCellMap(int rowId, int colId) {
		return this.cellMaps.get(rowId + "," + colId);
	}
	
	private void bindCellInfo(CellInfo cellInfo) {
		String rowNum = String.valueOf(cellInfo.getRowStart());
		String cellNum = String.valueOf(cellInfo.getCellStart());
		if(cellInfo.getDataTablePropertyPropertys()!=null && cellInfo.getDataTablePropertyPropertys().size() > 0) {
			for (DataTablePropertyProperty pro : cellInfo.getDataTablePropertyPropertys()) {
				setProperty(rowNum, cellNum, pro);
				this.setColInfo(NumberUtils.toInt(cellNum) + 2);
				this.setRowInfo(NumberUtils.toInt(rowNum) + 2);
				rowNum = String.valueOf(NumberUtils.toInt(rowNum) + 1);
			}
		}else {
			setProperty(rowNum, cellNum, cellInfo.getDataTablePropertyProperty());
			this.setColInfo(NumberUtils.toInt(cellNum) + 2);
			this.setRowInfo(NumberUtils.toInt(rowNum) + 2);
		}
	}

	private void setRowInfo(int rowCount) {
		if (rowCount > (this.sheetP.getRowCount() == null ? 0 : this.sheetP.getRowCount())) {
			this.sheetP.setRowCount(rowCount);
			this.sheetP.getData().setRowCount(rowCount);
		}
	}

	private void setColInfo(int colCount) {
		if (colCount > (this.sheetP.getColumnCount() == null ? 0 : this.sheetP.getColumnCount())) {
			this.sheetP.setColumnCount(colCount);
			this.sheetP.getData().setColCount(colCount);
		}
	}

	public void setProperty(String rowNum, String cellNum, DataTablePropertyProperty pro) {
		if (newDataTable.getAdditionalProperties().get(rowNum) == null) {
			DataTableProperty tpro = new DataTableProperty();
			tpro.setAdditionalProperty(cellNum, pro);
			newDataTable.setAdditionalProperty(rowNum, tpro);
		} else {
			newDataTable.getAdditionalProperties().get(rowNum).setAdditionalProperty(cellNum, pro);
		}
	}
}
