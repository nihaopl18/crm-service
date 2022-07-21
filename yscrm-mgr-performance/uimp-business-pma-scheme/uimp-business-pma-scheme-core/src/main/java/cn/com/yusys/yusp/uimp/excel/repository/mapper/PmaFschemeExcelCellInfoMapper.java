package cn.com.yusys.yusp.uimp.excel.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelCellInfo;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelCellInfoMapper
 * @类描述: #考核方案报表单元格信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:03:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFschemeExcelCellInfoMapper extends CommonMapper<PmaFschemeExcelCellInfo> {

	/**
     * @方法名称: deleteByTemplateId
     * @方法描述: 根据 模板ID，删除数据
     * @参数与返回说明: 
     * @算法描述:
     */
	Integer deleteByTemplateId(@Param("templateId") String templateId);
	
	/**
     * @方法名称: batchInsert
     * @方法描述: 批量新增数据
     * @参数与返回说明: 
     * @算法描述:
     */
	Integer batchInsert(@Param("dataList") List<PmaFschemeExcelCellInfo> dataList);

	/**
     * @方法名称: getCellInfoByTemplateIdAndCellType
     * @方法描述: 根据模板ID/单元格类型，查询考核方案报表单元格信息表-数据
     * @参数与返回说明: 
     * @算法描述:
     */
	List<PmaFschemeExcelCellInfo> getCellInfoByTemplateIdAndCellType(@Param("templateId") String templateId, @Param("cellType") String cellType);
	
	/**
     * @函数名称:deleteBackupTableDataByTemplateIdAndEtlDate
     * @函数描述:根据模板ID、数据日期，删除单元格信息表(备份表)数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer deleteBackupTableDataByTemplateIdAndEtlDate(@Param("templateId") String templateId, @Param("etlDate") String etlDate);
	
	/**
     * @方法名称: batchInsertBackupTableCommonCellData
     * @方法描述: 批量新增单元格信息表(备份表)一般单元格数据
     * @参数与返回说明: 
     * @算法描述:
     */
	Integer batchInsertBackupTableCommonCellData(@Param("etlDate") String etlDate, @Param("dataList") List<PmaFschemeExcelCellInfo> dataList);
	
	/**
     * @方法名称: batchInsertBackupTableOtherCellData
     * @方法描述: 批量新增单元格信息表(备份表)基础指标、公式、考核对象单元格数据
     * @参数与返回说明: 
     * @算法描述:
     */
	Integer batchInsertBackupTableOtherCellData(@Param("etlDate") String etlDate, @Param("dataList") List<Map<String, Object>> dataList);
	
	/**
     * @方法名称: getCellInfoFromBackupTableByTemplateIdAndEtlDateAndCellType
     * @方法描述: 根据模板ID/数据日期/单元格类型，查询考核方案报表单元格信息表(备份表)-数据
     * @参数与返回说明: 
     * @算法描述:
     */
	List<PmaFschemeExcelCellInfo> getCellInfoFromBackupTableByTemplateIdAndEtlDateAndCellType(@Param("templateId") String backupTableName, 
			@Param("etlDate") String etlDate, @Param("cellType") String cellType);
	
	/**
     * @方法名称: getMySchemeCellInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期，查询我的考核方案报表单元格信息表(备份表)-一般单元格数据
     * @参数与返回说明: 
     * @算法描述:
     * 需要排除隐藏行/列数据
     */
	List<PmaFschemeExcelCellInfo> getMySchemeCellInfoFromBackupTable(@Param("templateId") String backupTableName, 
			@Param("etlDate") String etlDate, @Param("cellType") String cellType, @Param("hideRows") String[] hideRows, 
			@Param("hideCols") String[] hideCols);
	
	/**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案报表单元格信息表
	 * @参数与返回说明:
	 * @param templateId 被复制的模板ID
	 * @param newTemplateId 新的模板ID
	 * @算法描述:
	 */
	Integer copySchemeInf(@Param("templateId") String templateId, @Param("newTemplateId") String newTemplateId);
}