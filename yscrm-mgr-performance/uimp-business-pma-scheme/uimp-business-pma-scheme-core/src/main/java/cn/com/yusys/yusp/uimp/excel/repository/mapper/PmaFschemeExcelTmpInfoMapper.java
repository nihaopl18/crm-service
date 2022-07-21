package cn.com.yusys.yusp.uimp.excel.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelTmpInfo;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelTmpInfoMapper
 * @类描述: #考核方案报表模板信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:01:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFschemeExcelTmpInfoMapper extends CommonMapper<PmaFschemeExcelTmpInfo> {
	
	/**
	 * @方法名称: indexSelectorQuerylist
	 * @方法描述: 考核方案-指标放大镜-查询列表数据(分页)
	 * @参数与返回说明: 
	 * @param model: condition-type: 1基础指标  2派生指标  0基础/派生都查询
	 * @算法描述: 
	 *   支持查询基础指标、派生指标数据
	 *   返回数据包含指标维度信息
	 */
	List<Map<String, Object>> indexSelectorQuerylist(QueryModel model);
	
	/**
	 * @方法名称: queryIndexNameByIndexId
	 * @方法描述: 根据指标编号，查询指标名称，包括基础指标/派生指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	List<String> queryIndexNameByIndexId(@Param("indexIds") String[] indexIds);

	/**
     * @函数名称:getTmpInfoBySchemeId
     * @函数描述:根据考核方案ID，查询考核方案报表模板信息表数据
     * @参数与返回说明:
     * @算法描述:
     */
	PmaFschemeExcelTmpInfo getTmpInfoBySchemeId(@Param("schemeId") String schemeId);
	
	/**
     * @函数名称:deleteBackupTableDataBySchemeIdAndEtlDate
     * @函数描述:根据考核方案ID、数据日期，删除模板信息表(备份表)数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer deleteBackupTableDataBySchemeIdAndEtlDate(@Param("schemeId") String schemeId, @Param("etlDate") String etlDate);
	
	/**
     * @函数名称:insertBackupTableData
     * @函数描述:新增模板信息表(备份表)模板数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer insertBackupTableData(@Param("tmpInfo") PmaFschemeExcelTmpInfo tmpInfo, @Param("etlDate") String etlDate);
	
	/**
     * @函数名称:getTmpInfoFromBackupTableBySchemeIdAndEtlDate
     * @函数描述:根据考核方案ID、数据日期，查询考核方案报表模板信息表(备份表)数据
     * @参数与返回说明:
     * @算法描述:
     */
	PmaFschemeExcelTmpInfo getTmpInfoFromBackupTableBySchemeIdAndEtlDate(@Param("schemeId") String schemeId, @Param("etlDate") String etlDate);
	
	/**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案报表模板信息表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @算法描述:
	 */
	Integer copySchemeInf(@Param("templateId") String templateId, @Param("schemeId") String schemeId, @Param("newSchemeId") String newSchemeId);
	
    /**
     * @方法名称: getAppOrgSchemeEvlObjInfo
     * @方法描述: 根据考核方案编号、数据日期、考核对象编号，查询-APP机构考核方案-考核对象信息(备份表)
     * @参数与返回说明: 
     * @算法描述:
     */
	List<Map<String, Object>> getAppOrgSchemeEvlObjInfo(@Param("schemeId") String schemeId, 
			@Param("etlDate") String etlDate, @Param("evlObjId") String evlObjId);

}