package cn.com.yusys.yusp.uimp.excel.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelObjInfo;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelObjInfoMapper
 * @类描述: #考核方案报表考核对象信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:03:53
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFschemeExcelObjInfoMapper extends CommonMapper<PmaFschemeExcelObjInfo> {

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
	Integer batchInsert(@Param("dataList") List<PmaFschemeExcelObjInfo> dataList);

	/**
     * @方法名称: getCellInfoByTemplateId
     * @方法描述: 根据模板ID，查询-考核对象单元格数据
     * @参数与返回说明: 
     * @算法描述:
     */
	List<Map<String, Object>> getCellInfoByTemplateId(@Param("templateId") String templateId);
	
	/**
     * @函数名称:deleteBackupTableDataByTemplateIdAndEtlDate
     * @函数描述:根据模板ID、数据日期，删除考核对象信息表(备份表)数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer deleteBackupTableDataByTemplateIdAndEtlDate(@Param("templateId") String templateId, @Param("etlDate") String etlDate);
	
	/**
     * @方法名称: batchInsertBackupTableData
     * @方法描述: 批量新增考核对象信息表(备份表)数据
     * @参数与返回说明: 
     * @算法描述:
     */
	Integer batchInsertBackupTableData(@Param("etlDate") String etlDate, @Param("dataList") List<Map<String, Object>> dataList);

	/**
     * @方法名称: getCellInfoFromBackupTableByTemplateIdAndEtlDate
     * @方法描述: 根据模板ID、数据日期，查询-考核对象单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     */
	List<Map<String, Object>> getCellInfoFromBackupTableByTemplateIdAndEtlDate(@Param("templateId") String templateId, 
			@Param("etlDate") String etlDate);
	
	/**
     * @方法名称: getMySchemeCellInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-我的考核方案考核对象单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     * 1、根据 方案类型/考核对象类型，查询对应权限数据
     * 2、根据hideRows、hideCols，排除对应行/列数据
     */
	List<Map<String, Object>> getMySchemeCellInfoFromBackupTable(@Param("templateId") String templateId, 
			@Param("etlDate") String etlDate, @Param("evlObjId") String evlObjId, 
			@Param("templateType") String templateType, @Param("evlObjType") String evlObjType, 
			@Param("hideRows") String[] hideRows, @Param("hideCols") String[] hideCols);
	
	/**
     * @方法名称: getOrgStaffSchemeCellInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-机构辖内员工对象的考核方案考核对象单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     * 1、根据 方案类型/考核对象类型，查询对应权限数据
     * 2、根据hideRows、hideCols，排除对应行/列数据
     */
	List<Map<String, Object>> getOrgStaffSchemeCellInfoFromBackupTable(@Param("templateId") String templateId, 
			@Param("etlDate") String etlDate, @Param("evlObjId") String evlObjId, @Param("curOrgId") String curOrgId,
			@Param("templateType") String templateType, @Param("evlObjType") String evlObjType, 
			@Param("hideRows") String[] hideRows, @Param("hideCols") String[] hideCols);
	
	/**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案报表考核对象信息表
	 * @参数与返回说明:
	 * @param templateId 被复制的模板ID
	 * @param newTemplateId 新的模板ID
	 * @算法描述:
	 */
	Integer copySchemeInf(@Param("templateId") String templateId, @Param("newTemplateId") String newTemplateId);
}