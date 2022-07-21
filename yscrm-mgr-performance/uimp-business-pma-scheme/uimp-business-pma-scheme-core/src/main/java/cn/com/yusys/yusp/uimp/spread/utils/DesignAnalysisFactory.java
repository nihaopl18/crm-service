package cn.com.yusys.yusp.uimp.spread.utils;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.yuchengtech.report.frame.spreadjs.entity.SpreadSchema;

import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelCellInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelTmpInfo;

public class DesignAnalysisFactory {

	public static SimpleDesignAnalysis createAnalysis(String json, PmaFschemeExcelTmpInfo tmpInfo, List<PmaFschemeExcelCellInfo> cellInfoList,
			List<Map<String, Object>> objCellInfoList, List<Map<String, Object>> indexCellInfoList, 
			List<Map<String, Object>> evlindexCellInfoList, List<Map<String, Object>> formulaCellInfoList, 
			List<Map<String, Object>> orgparamCellInfoList, List<Map<String, Object>> pstparamCellInfoList, 
			List<Map<String, Object>> svwCellInfoList, List<Map<String, Object>> dutyCellInfoList, 
			List<Map<String, Object>> orgCellInfoList, List<Map<String, Object>> objIdCellInfoList) {
		SpreadSchema schema = JSON.parseObject(json, SpreadSchema.class);
		return new SimpleDesignAnalysis(schema, tmpInfo, cellInfoList, objCellInfoList, indexCellInfoList, 
				evlindexCellInfoList, formulaCellInfoList, orgparamCellInfoList, pstparamCellInfoList, svwCellInfoList,
				dutyCellInfoList, orgCellInfoList, objIdCellInfoList);
	}
}
