package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFperformanceToinitwfInf;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFperformanceToinitwfInfMapper
 * @类描述: #业绩批量导入工作流待发起信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-10-21 23:53:53
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFperformanceToinitwfInfMapper extends CommonMapper<PmaFperformanceToinitwfInf> {
	
	/**
	 * @方法名称: batchInsertToinitwfInf
	 * @方法描述: 批量保存  业绩批量导入工作流待发起信息表数据
	 * @参数与返回说明: 
	 * @param dataList 数据集
	 * @param funCode 业绩类型
	 * @param batchId  批次号
	 * @param periodHisTableName  分配区间历史表表名
	 * @param dtlTableName  批量导入明细表表名
	 * @param isReStartWf  是否重新发起审批
	 * @param workFlow  流程标识
	 * @param userId 操作用户编号
	 * @param executeStatus 执行状态: 0待执行 1执行中 执行完成数据直接删除
	 * @算法描述: 
	 */
	Integer batchInsertToinitwfInf(@Param("dataList") List<Map<String, Object>> dataList, 
			@Param("funCode") String funCode, @Param("batchId") String batchId, @Param("periodHisTableName") String periodHisTableName,
			@Param("dtlTableName") String dtlTableName, @Param("isReStartWf") String isReStartWf, @Param("workFlow") String workFlow,
			@Param("userId") String userId, @Param("executeStatus") String executeStatus);
	
	/**
	 * @方法名称: getEarlyApplyIdsByCount
	 * @方法描述: 获取 业绩批量导入工作流待发起信息表-审批编号字段值
	 * @参数与返回说明: 
	 * @param count 获取的审批编号个数
	 * @算法描述: 
	 *   根据CREATE_TIME字段升序排列，获取EXECUTE_STATUS='0'最早的count条数据
	 */
	List<String> getEarlyApplyIdsByCount(@Param("count") Integer count);
	
	/**
	 * @方法名称: deleteByApplyId
	 * @方法描述: 根据审批编号 删除业绩批量导入工作流待发起信息表数据
	 * @参数与返回说明: 
	 * @param applyId 审批编号
	 * @算法描述: 
	 */
	Integer deleteByApplyId(@Param("applyId") String applyId);
	
	/**
	 * @方法名称: getToinitwfInfByApplyIds
	 * @方法描述: 根据applyIds获取 业绩批量导入工作流待发起信息表数据
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	List<PmaFperformanceToinitwfInf> getToinitwfInfByApplyIds(@Param("applyIdsList") List<String> applyIds);
	
	/**
	 * @方法名称: updateExecuteStatusByApplyIds
	 * @方法描述: 根据applyIds 更新业绩批量导入工作流待发起信息表-执行状态字段值为-executeStatus
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer updateExecuteStatusByApplyIds(@Param("executeStatus") String executeStatus, @Param("applyIdsList") List<String> applyIds);
}