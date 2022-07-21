package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFPerformanceBatchInfo;
import cn.com.yusys.yusp.uimp.distribution.model.FImpCheckModel;


/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonPerformanceImpMapper
 * @类描述: # 业绩批量导入接口 Mapper
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-10 10:24:40
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface CommonPerformanceImpMapper extends CommonMapper<PmaFPerformanceBatchInfo> {
	
	/**
	 * @方法名称: queryList
	 * @方法描述: 列表查询
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Page<Map<String, Object>> queryList (@Param("sqlStr") String sqlStr, QueryModel queryModel);

	/**
	 * @方法名称: checkBatch
	 * @方法描述: 查询当前系统是否可以进行业绩分配 转移 导入等业绩操作
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer checkBatch(@Param("sqlStr") String sqlStr);
	
	String getCurrentDstrTime(@Param("sqlStr") String sqlStr);
	
	/**
	 * @方法名称: batchInsert
	 * @方法描述: 批量保存 业绩批量导入业务明细表数据
	 * @参数与返回说明: 
	 * @param tableName 业绩批量导入业务明细表表名
	 * @param columnMap 字段名map
	 * @param dataList 数据集
	 * @算法描述: 
	 */
	Integer batchInsert(@Param("tableName") String tableName, @Param("columnMap") Map<String, Object> columnMap, 
			@Param("dataList") List<Map<String, Object>> dataList);
	
	/**
	 * @方法名称: batchInsertMutex
	 * @方法描述: 批量保存  业务互斥表数据
	 * @参数与返回说明: 
	 * @param mutexTebleName 业务互斥表表名
	 * @param pkList 主键字段名列表
	 * @param dataList 数据集
	 * @param typeCode 类型标识  1批量导入 2业绩分配
	 * @param batchId 批量导入批次号
	 * @param createTime 创建时间
	 * @param createUser 创建人
	 * @算法描述: 
	 */
	Integer batchInsertMutex(@Param("mutexTebleName") String mutexTebleName, @Param("pkList") List<String> pkList, 
			@Param("dataList") List<Map<String, Object>> dataList,
			@Param("typeCode") String typeCode, @Param("batchId") String batchId, 
			@Param("createTime") Date createTime, @Param("createUser") String createUser);
	
	/**
	 * @方法名称: callFImpCheckFunction
	 * @方法描述: 执行 业绩批量导入 excel业务校验function
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer callFImpCheckFunction(FImpCheckModel fImpCheckModel);

	/**
	 * @方法名称: queryResultList
	 * @方法描述: 批量导入结果页面-列表查询
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	List<Map<String,Object>> queryResultList(QueryModel queryModel);
	
	/**
	 * @方法名称: batchDelete
	 * @方法描述: 批量删除 业绩批量导入业务明细表数据
	 * @参数与返回说明: 
	 * @param tableName 业绩批量导入业务明细表表名
	 * @param batchId 批次编号
	 * @param pkList 主键字段名
	 * @param dataList 数据集
	 * @算法描述: 
	 */
	Integer batchDelete(@Param("tableName") String tableName, @Param("batchId") String batchId, @Param("pkList") List<String> pkList, 
			@Param("dataList") List<Map<String, Object>> dataList);
	
	/**
	 * @方法名称: executeQuerySql
	 * @方法描述: 动态执行查询语句-公共方法
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	List<Map<String,Object>> executeQuerySql(@Param("sqlStr") String sqlStr);
	
	/**
	 * @方法名称: executeDeleteSql
	 * @方法描述: 动态执行删除语句-公共方法
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer executeDeleteSql(@Param("sqlStr") String sqlStr);
	
	/**
	 * @方法名称: executeUpdateSql
	 * @方法描述: 动态执行更新语句-公共方法
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer executeUpdateSql(@Param("sqlStr") String sqlStr);
	
	/**
	 * @方法名称: executeInsertSql
	 * @方法描述: 动态执行新增语句-公共方法
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer executeInsertSql(@Param("sqlStr") String sqlStr);
	
	/**
	 * @方法名称: batchInsertDistributeHisTableData
	 * @方法描述: 批量新增-分配关系历史表数据
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer batchInsertDistributeHisTableData(@Param("distributeHisTableName") String distributeHisTableName, @Param("periodId") String periodId,
			@Param("distributeColumnList") List<String> distributeColumnList, @Param("distributeDataList") List<Map<String, Object>> distributeDataList);
	
	/**
	 * @方法名称: batchInsertDistributeTableData
	 * @方法描述: 批量新增-分配关系表数据
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer batchInsertDistributeTableData(@Param("distributeTableName") String distributeTableName, @Param("periodId") String periodId,
			@Param("distributeColumnList") List<String> distributeColumnList, @Param("distributeDataList") List<Map<String, Object>> distributeDataList);
	
	/**
	 * @方法名称: updatePeriodHisApplySts
	 * @方法描述: 更新-分配区间历史表 审批结果APPLY_STS字段值
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer updatePeriodHisApplySts(@Param("periodHisTableName") String periodHisTableName, @Param("applyId") String applyId, 
			@Param("applySts") String applySts);
	
	/**
	 * @方法名称: updatePeriodHisApplyStsByBatchId
	 * @方法描述: 根据批次号关联批量导入明细表，更新-分配区间历史表 审批结果APPLY_STS字段值
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer updatePeriodHisApplyStsByBatchId(@Param("periodHisTableName") String periodHisTableName, @Param("dtlTableName") String dtlTableName,
			@Param("batchId") String batchId, @Param("pkColumnNames") List<String> pkColumnNames, @Param("applySts") String applySts);
	
	/**
	 * @方法名称: queryTotalCountByKeyColumn
	 * @方法描述: 根据批次编号、主键字段，查询总数
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer queryTotalCountByKeyColumn(@Param("batchId") String batchId, @Param("dtlTableName") String dtlTableName, @Param("pkColumnNames") List<String> pkColumnNames);
	
	/**
	 * @方法名称: queryApplyIdAndOrgIdFromPeriodHisWorkFlowErr
	 * @方法描述: 从分配区间历史表中，查询生成工作流失败的APPLY_ID、ORG_ID数据
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	List<Map<String, String>> queryApplyIdAndOrgIdFromPeriodHisWorkFlowErr(@Param("batchId") String batchId, @Param("dtlTableName") String dtlTableName,
			@Param("periodHisTableName") String periodHisTableName, @Param("pkList") List<String> pkList);
	
	/**
	 * @方法名称: deleteMutexTableData
	 * @方法描述: 删除 业绩批量导入互斥表数据
	 * @参数与返回说明: 
	 * @param tableName 业绩批量导入互斥表表名
	 * @param batchId 批次编号
	 * @算法描述: 
	 */
	Integer deleteMutexTableData(@Param("tableName") String tableName, @Param("batchId") String batchId);
	
	// 根据业务主键，删除去重表数据
	Integer deleteMutexTableDataByKeyColumn(@Param("tableName") String tableName, @Param("keyColumnName") String keyColumnName, 
			@Param("dataList") List<Map<String, String>> dataList);
	
	
	Integer batchDeleteDistributeTableData(@Param("funCode") String funCode, 
			@Param("distributeTableName") String distributeTableName, @Param("periodTableName") String periodTableName, 
			@Param("pkColumnName") String pkColumnName, @Param("dataList") List<Map<String, String>> dataList);
	
	Integer batchDeletePeriodTableData(@Param("funCode") String funCode, @Param("periodTableName") String periodTableName, 
			@Param("pkColumnName") String pkColumnName, @Param("dataList") List<Map<String, String>> dataList);
	
	Integer batchUpdateInfoTableDstrSts(@Param("funCode") String funCode, @Param("infoTableName") String infoTableName, 
			@Param("dstrSts") String dstrSts, @Param("pkColumnName") String pkColumnName, @Param("dataList") List<Map<String, String>> dataList);
	
	Integer batchInsertPeriodHisTableData(@Param("periodHisTableName") String periodHisTableName, 
			@Param("insertPeriodColumnStr") String insertPeriodColumnStr, @Param("dataList") List<Map<String, String>> dataList);
	
	Integer batchUpdatePeriodHisTableApplyVersion(@Param("periodHisTableName") String periodHisTableName,
			@Param("applySts") String applySts, @Param("dataList") List<Map<String, String>> dataList);
	
	Integer batchInsertPeriodTableData(@Param("periodTableName") String periodTableName, 
			@Param("insertPeriodColumnStr") String insertPeriodColumnStr, 
			@Param("dataList") List<Map<String, String>> dataList);
}	
