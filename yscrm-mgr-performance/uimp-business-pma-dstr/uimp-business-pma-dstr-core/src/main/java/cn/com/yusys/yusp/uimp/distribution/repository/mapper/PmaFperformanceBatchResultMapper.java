package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFperformanceBatchResult;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFperformanceBatchResultMapper
 * @类描述: #业绩批量导入线程池生成工作流结果表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-15 09:27:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFperformanceBatchResultMapper extends CommonMapper<PmaFperformanceBatchResult> {
	
	/**
	 * @方法名称: querySuccNumByBatchId
	 * @方法描述: 根据批次编号 查询工作流生成成功数量
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer querySuccNumByBatchId(@Param("batchId") String batchId);
	
	/**
	 * @方法名称: queryErrNumByBatchId
	 * @方法描述: 根据批次编号 查询工作流生成失败数量
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer queryErrNumByBatchId(@Param("batchId") String batchId);
	
	/**
	 * @方法名称: deleteByBatchId
	 * @方法描述: 根据批次编号 删除数据
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer deleteByBatchId(@Param("batchId") String batchId);
}