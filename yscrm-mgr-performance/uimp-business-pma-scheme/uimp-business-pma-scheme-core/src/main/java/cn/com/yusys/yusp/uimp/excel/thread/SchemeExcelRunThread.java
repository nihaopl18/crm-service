package cn.com.yusys.yusp.uimp.excel.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.grapecity.documents.excel.IWorksheet;
import com.grapecity.documents.excel.Workbook;

import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeEvlobjRelMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeEvlobjRelService;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelCellInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelTmpInfo;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelrunInfo;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelCellInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelEvlindexInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelFormulaInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelIndexInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelObjInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelTmpInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExceldutyInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelobjidInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelorgInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelorgparamInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelpstparamInfService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelrunInfoService;
import cn.com.yusys.yusp.uimp.excel.service.PmaFschemeExcelsvwInfService;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PerformanceImpThreadRunnable
 * @类描述: # 业绩批量导入线程类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-02-17 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class SchemeExcelRunThread implements Runnable {
	
	private String schemeId;
	private String templateId;
	private String templateType;
	private String evlObjType;
	private String etlDate;
	private PmaFschemeExcelTmpInfo tmpInfo;
	private PmaFschemeExcelTmpInfoService tmpInfoService;
	private PmaFschemeExcelCellInfoService cellInfoService;
	private PmaFschemeExcelObjInfoService objInfoService;
	private PmaFschemeExcelIndexInfoService indexInfoService;
	private PmaFschemeExcelEvlindexInfoService evlindexInfoService;
	private PmaFschemeExcelFormulaInfService formulaInfService;
	private PmaFschemeExcelorgparamInfService orgparamInfService;
	private PmaFschemeExcelpstparamInfService pstparamInfService;
	private PmaFschemeExcelsvwInfService svwInfService;
	private PmaFschemeExceldutyInfService dutyInfService;
	private PmaFschemeExcelorgInfService orgInfService;
	private PmaFschemeExcelobjidInfService objIdInfService;
	private PmaFschemeExcelrunInfo runInfo;
	private PmaFschemeExcelrunInfoService runInfoService;
	private PmaFSchemeEvlobjRelMapper evlObjRelMapper;
	private PmaFSchemeEvlobjRelService evlObjRelService;

	public SchemeExcelRunThread(String schemeId, String templateId, String templateType, String evlObjType, String etlDate,
			PmaFschemeExcelTmpInfo tmpInfo, PmaFschemeExcelTmpInfoService tmpInfoService,
			PmaFschemeExcelCellInfoService cellInfoService, PmaFschemeExcelObjInfoService objInfoService,
			PmaFschemeExcelIndexInfoService indexInfoService, PmaFschemeExcelEvlindexInfoService evlindexInfoService,
			PmaFschemeExcelFormulaInfService formulaInfService, PmaFschemeExcelorgparamInfService orgparamInfService,
			PmaFschemeExcelpstparamInfService pstparamInfService, PmaFschemeExcelsvwInfService svwInfService, 
			PmaFschemeExceldutyInfService dutyInfService, PmaFschemeExcelorgInfService orgInfService,
			PmaFschemeExcelobjidInfService objIdInfService,
			PmaFschemeExcelrunInfo runInfo, PmaFschemeExcelrunInfoService runInfoService, 
			PmaFSchemeEvlobjRelMapper evlObjRelMapper, PmaFSchemeEvlobjRelService evlObjRelService) {
		this.schemeId = schemeId;
		this.templateId = templateId;
		this.templateType = templateType;
		this.evlObjType = evlObjType;
		this.etlDate = etlDate;
		this.tmpInfo = tmpInfo;
		this.tmpInfoService = tmpInfoService;
		this.cellInfoService = cellInfoService;
		this.objInfoService = objInfoService;
		this.indexInfoService = indexInfoService;
		this.evlindexInfoService = evlindexInfoService;
		this.formulaInfService = formulaInfService;
		this.orgparamInfService = orgparamInfService;
		this.pstparamInfService = pstparamInfService;
		this.svwInfService = svwInfService;
		this.dutyInfService = dutyInfService;
		this.orgInfService = orgInfService;
		this.objIdInfService = objIdInfService;
		this.runInfo = runInfo;
		this.runInfoService = runInfoService;
		this.evlObjRelMapper = evlObjRelMapper;
		this.evlObjRelService = evlObjRelService;
	}

	@Override
	public void run() {
		try {
			// 1、获取一般单元格、考核对象、基础指标(带具体值)、派生指标、公式单元格、机构/岗位参数、得分/计价/权重、岗位、所属机构、考核对象编号信息
			// 一般单元格、考核对象、派生指标、公式的数据与查询设计器数据保持一致
			// 基础指标数据需要查询具体数据日期(考核对象)的实际值
			// 机构/岗位参数数据需要根据参数取数规则，查询对应考核对象的参数值
			List<PmaFschemeExcelCellInfo> commonCellInfoList = cellInfoService.getCellInfoByTemplateId(templateId);
			List<Map<String, Object>> objCellInfoList = new ArrayList<Map<String, Object>>();
			List<Map<String, Object>> evlObjIdList = new ArrayList<Map<String, Object>>(); 
			if(!"02".equals(templateType)) {	// 非 单元格考核方案，需要查询考核对象单元格数据
				objCellInfoList = objInfoService.getCellInfoByTemplateId(templateId);
				this.executeByEvlObjId(commonCellInfoList, objCellInfoList, "");
			} else {	// 单元格考核方案，需要查询所有考核对象数据
				evlObjIdList = evlObjRelMapper.getEvlObjBySchemeId(schemeId);
				if(evlObjIdList != null && evlObjIdList.size() > 0) {
					for(Map<String, Object> item : evlObjIdList) {	// 多个考核对象批量处理
						this.executeByEvlObjId(commonCellInfoList, objCellInfoList, item.get("id") + "");
					}
				} else {	// 单元格考核方案，没有配置考核对象，不允许运行
					// 运行失败，更新-考核方案报表运行信息表数据
					runInfo.setRunEndTime(new Date());
					runInfo.setRunStatus("2");
					runInfo.setErrMsg("单元格考核方案没有配置考核对象");
					runInfoService.updateSelective(runInfo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 运行失败，更新-考核方案报表运行信息表数据
			runInfo.setRunEndTime(new Date());
			runInfo.setRunStatus("2");
			runInfo.setErrMsg("系统异常");
			runInfoService.updateSelective(runInfo);
		}
	}
	
	public void executeByEvlObjId(List<PmaFschemeExcelCellInfo> commonCellInfoList, 
			List<Map<String, Object>> objCellInfoList, String evlObjId) throws Exception {
		List<Map<String, Object>> indexCellInfoList = indexInfoService.getPreviewInfo(templateId, etlDate, evlObjId, templateType);
//		List<Map<String, Object>> evlindexCellInfoList = evlindexInfoService.getCellInfoByTemplateId(templateId);
		List<Map<String, Object>> evlindexCellInfoList = evlindexInfoService.getPreviewInfo(templateId, etlDate, evlObjId, templateType);
		List<Map<String, Object>> formulaCellInfoList = formulaInfService.getCellInfoByTemplateId(templateId);
		List<Map<String, Object>> orgparamCellInfoList = orgparamInfService.getPreviewInfo(templateId, evlObjType, evlObjId);
		List<Map<String, Object>> pstparamCellInfoList = pstparamInfService.getPreviewInfo(templateId, evlObjType, evlObjId);
		List<Map<String, Object>> svwCellInfoList = svwInfService.getCellInfoByTemplateId(templateId);
		List<Map<String, Object>> dutyCellInfoList = dutyInfService.getPreviewInfo(templateId, etlDate, evlObjId, templateType);
		List<Map<String, Object>> orgCellInfoList = orgInfService.getPreviewInfo(templateId, etlDate, evlObjId, templateType, this.tmpInfo.getEvlObjType());
		List<Map<String, Object>> objIdCellInfoList = objIdInfService.getCellInfoByTemplateId(templateId);
		
		// 2、创建Workbook，根据查询的一般单元格(带默认值)、基础指标值、机构/岗位参数值给sheet页中的单元格赋值；根据查询的派生指标、公式、得分/计价/权重，给对应单元格添加公式内容
		Workbook workbook = new Workbook();
		IWorksheet worksheet = workbook.getWorksheets().get(0);
		if(commonCellInfoList != null) {
			for(PmaFschemeExcelCellInfo commonCellInfo : commonCellInfoList) {	// 一般单元格，根据DEFAULT_VALUE赋值
				if(commonCellInfo.getDefaultValue() != null && StringUtil.isNotEmpty(commonCellInfo.getDefaultValue() + "")) {
					worksheet.getRange(commonCellInfo.getCellNo()).setValue(commonCellInfo.getDefaultValue());
				}
			}
		}
		if(indexCellInfoList != null) {
			for(Map<String, Object> item : indexCellInfoList) {	// 基础指标单元格，优先DEFAULT_VALUE赋值，DEFAULT_VALUE没有，根据RESULT_VALUE赋值
				if(item.get("defaultValue") != null && StringUtil.isNotEmpty(item.get("defaultValue") + "")) {
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("defaultValue"));
				} else {
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("resultValue"));
				}
				// 指标值字段赋值
				item.put("indexValue", worksheet.getRange(item.get("cellNo") + "").getValue());
				if("02".equals(templateType)) {	// 单元格类型考核方案，需要给evlObjId考核对象编号字段单独赋值
					item.put("evlObjId", evlObjId);
				}
			}
		}
		if(orgparamCellInfoList != null) {
			for(Map<String, Object> item : orgparamCellInfoList) {	// 机构参数单元格，优先DEFAULT_VALUE赋值，DEFAULT_VALUE没有，根据RESULT_VALUE赋值
				if(item.get("defaultValue") != null && StringUtil.isNotEmpty(item.get("defaultValue") + "")) {
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("defaultValue"));
				} else {
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("resultValue"));
				}
				// 参数值字段赋值
				item.put("paramValue", worksheet.getRange(item.get("cellNo") + "").getValue());
				if("02".equals(templateType)) {	// 单元格类型考核方案，需要给evlObjId考核对象编号字段单独赋值
					item.put("evlObjId", evlObjId);
				}
			}
		}
		if(pstparamCellInfoList != null) {
			for(Map<String, Object> item : pstparamCellInfoList) {	// 岗位单元格，优先DEFAULT_VALUE赋值，DEFAULT_VALUE没有，根据RESULT_VALUE赋值
				if(item.get("defaultValue") != null && StringUtil.isNotEmpty(item.get("defaultValue") + "")) {
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("defaultValue"));
				} else {
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("resultValue"));
				}
				// 参数值字段赋值
				item.put("paramValue", worksheet.getRange(item.get("cellNo") + "").getValue());
				if("02".equals(templateType)) {	// 单元格类型考核方案，需要给evlObjId考核对象编号字段单独赋值
					item.put("evlObjId", evlObjId);
				}
			}
		}
		if(evlindexCellInfoList != null) {
			for(Map<String, Object> item : evlindexCellInfoList) {	// 派生指标单元格，给对应单元格添加公式内容
				if(item.get("defaultValue") != null && StringUtil.isNotEmpty(item.get("defaultValue") + "")) {	// 如果默认值存在，使用默认值，不添加公式内容
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("defaultValue"));
				} else if(item.get("excelFormula") != null && StringUtil.isNotEmpty(item.get("excelFormula") + "")) {	// 公式内容存在，给单元格添加公式内容
					worksheet.getRange(item.get("cellNo") + "").setFormula(item.get("excelFormula") + "");
				} else {	// 使用-派生指标值-给单元格赋值
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("resultValue"));
				}
				if("02".equals(templateType)) {	// 单元格类型考核方案，需要给evlObjId考核对象编号字段单独赋值
					item.put("evlObjId", evlObjId);
				}
			}
		}
		if(formulaCellInfoList != null) {
			for(Map<String, Object> item : formulaCellInfoList) {	// 公式单元格，给对应单元格添加公式内容
				if(item.get("defaultValue") != null && StringUtil.isNotEmpty(item.get("defaultValue") + "")) {	// 如果默认值存在，使用默认值，不添加公式内容
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("defaultValue"));
				} else {
					worksheet.getRange(item.get("cellNo") + "").setFormula(item.get("excelFormula") + "");
				}
				if("02".equals(templateType)) {	// 单元格类型考核方案，需要给evlObjId考核对象编号字段单独赋值
					item.put("evlObjId", evlObjId);
				}
			}
		}
		if(svwCellInfoList != null) {
			for(Map<String, Object> item : svwCellInfoList) {	// 得分/计价/权重单元格，给对应单元格添加公式内容
				if(item.get("defaultValue") != null && StringUtil.isNotEmpty(item.get("defaultValue") + "")) {	// 如果默认值存在，使用默认值，不添加公式内容
					worksheet.getRange(item.get("cellNo") + "").setValue(item.get("defaultValue"));
				} else {
					worksheet.getRange(item.get("cellNo") + "").setFormula(item.get("excelFormula") + "");
				}
				if("02".equals(templateType)) {	// 单元格类型考核方案，需要给evlObjId考核对象编号字段单独赋值
					item.put("evlObjId", evlObjId);
				}
			}
		}
		// 清空单元格缓存数据
		workbook.dirty();
		// 计算并缓存所有单元格计算结果，后续getValue获取时，不需要再次计算直接返回值
		workbook.calculate();
		// 3、从worksheet中获取派生指标、公式、得分/计价/权重类型单元格实际计算后的值
		if(evlindexCellInfoList != null) {
			for(Map<String, Object> item : evlindexCellInfoList) {	// 为派生指标单元格数据添加实际值
				if(item.get("excelFormula") != null && StringUtil.isNotEmpty(item.get("excelFormula") + "")) {	// 公式内容非空的单元格，给excelFormulaValue字段添加单元格值
					item.put("excelFormulaValue", worksheet.getRange(item.get("cellNo") + "").getValue());
				} else {	// 指标值字段赋值
					item.put("indexValue", worksheet.getRange(item.get("cellNo") + "").getValue());
				}
			}
		}
		if(formulaCellInfoList != null) {
			for(Map<String, Object> item : formulaCellInfoList) {	// 为公式单元格数据添加实际值
				item.put("excelFormulaValue", worksheet.getRange(item.get("cellNo") + "").getValue());
			}
		}
		if(svwCellInfoList != null) {
			for(Map<String, Object> item : svwCellInfoList) {	// 为得分/计价/权重单元格数据添加实际值
				item.put("excelFormulaValue", worksheet.getRange(item.get("cellNo") + "").getValue());
			}
		}
		// 4、分别备份模板信息表、单元格信息表、基础指标信息表、派生指标信息表、考核对象信息表、公式信息表、机构参数信息表、岗位参数信息表、得分/计价/权重、岗位、所属机构、考核对象编号信息表数据
		// 其中单元格信息表需要包含一般单元格、基础指标、派生指标、考核对象、公式单元格、机构参数、岗位参数、得分/计价/权重单元格、岗位、所属机构、考核对象编号的数据
		tmpInfoService.updateBackupTableData(tmpInfo, etlDate);
		cellInfoService.updateBackupTableData(etlDate, templateId, commonCellInfoList, objCellInfoList, 
				indexCellInfoList, evlindexCellInfoList, formulaCellInfoList, orgparamCellInfoList, pstparamCellInfoList, svwCellInfoList,
				dutyCellInfoList, orgCellInfoList, objIdCellInfoList);
		if(!"02".equals(templateType)) {	// 非单元格，需要更新考核对象信息表(备份表)数据
			objInfoService.updateBackupTableData(etlDate, templateId, objCellInfoList);
		}
		indexInfoService.updateBackupTableData(etlDate, templateId, templateType, evlObjId, indexCellInfoList);
		evlindexInfoService.updateBackupTableData(etlDate, templateId, templateType, evlObjId, evlindexCellInfoList);
		formulaInfService.updateBackupTableData(etlDate, templateId, templateType, evlObjId, formulaCellInfoList);
		orgparamInfService.updateBackupTableData(etlDate, templateId, templateType, evlObjId, orgparamCellInfoList);
		pstparamInfService.updateBackupTableData(etlDate, templateId, templateType, evlObjId, pstparamCellInfoList);
		svwInfService.updateBackupTableData(etlDate, templateId, templateType, evlObjId, svwCellInfoList);
		dutyInfService.updateBackupTableData(etlDate, templateId, templateType, evlObjId, dutyCellInfoList);
		orgInfService.updateBackupTableData(etlDate, templateId, templateType, evlObjId, orgCellInfoList);
		objIdInfService.updateBackupTableData(etlDate, templateId, templateType, evlObjId, objIdCellInfoList);
		
		// 5、备份考核方案评价对象表数据
		evlObjRelService.updateBackupTableData(schemeId, etlDate);
		// 运行成功，更新-考核方案报表运行信息表数据
		runInfo.setRunEndTime(new Date());
		runInfo.setRunStatus("1");
		runInfoService.updateSelective(runInfo);
	}

}
