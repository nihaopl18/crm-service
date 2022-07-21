package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFperformanceTobatchInf;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFperformanceTobatchInfMapper
 * @类描述: #业绩批量导入待执行批次数据信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-10-25 11:51:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFperformanceTobatchInfMapper extends CommonMapper<PmaFperformanceTobatchInf> {
	
	List<Map<String, Object>> queryList(QueryModel model);
	
	List<String> getBatchIdsByStatus(@Param("status") String status);

	List<PmaFperformanceTobatchInf> getEarlyBatchInfByCount(@Param("count") Integer count);

	Integer deleteByBatchId(@Param("batchId") String batchId);

	Integer updateStatusByBatchId(@Param("batchId") String batchId, @Param("status") String status);
	
}