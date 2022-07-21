package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFPerformanceBatchInfo;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFPerformanceBatchInfoMapper
 * @类描述: # 业绩批量导入业务主表 Mapper
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-15 14:06:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFPerformanceBatchInfoMapper extends CommonMapper<PmaFPerformanceBatchInfo> {
	
	/**
	 * @方法名称: updateStatusByBatchIdAndFunCode
	 * @方法描述: 根据批次编号/业绩类型 更新执行状态
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	void updateStatusByBatchIdAndFunCode(@Param("batchId") String batchId, @Param("funCode") String funCode, 
			@Param("status") String status);
	
	/**
	 * @方法名称: updateCheckResultAndStatusByBatchIdAndFunCode
	 * @方法描述: 根据批次编号/业绩类型 更新校验结果、执行状态字段
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	void updateCheckResultAndStatusByBatchIdAndFunCode(@Param("batchId") String batchId, @Param("funCode") String funCode, 
			@Param("checkResult") String checkResult, @Param("status") String status);
	
	/**
	 * @方法名称: updateWfTotalCountByBatchIdAndFunCode
	 * @方法描述: 根据批次编号/业绩类型 更新工作流总数字段值
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	void updateWfTotalCountByBatchIdAndFunCode(@Param("batchId") String batchId, @Param("funCode") String funCode, 
			@Param("wfTotalCount") String wfTotalCount);
	
	/**
	 * @方法名称: getExecuteBatchCount
	 * @方法描述: 正在生成工作流批次数据个数
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer getExecuteBatchCount();
}