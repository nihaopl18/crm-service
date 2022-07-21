package cn.com.yusys.yusp.uimp.distr.thread;

import cn.com.yusys.yusp.flow.dto.WFStratDto;
import cn.com.yusys.yusp.flow.service.core.WorkflowEngineInterface;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import cn.com.yusys.yusp.uimp.distr.thread.pool.BatchFixedThreadPoolManager;
import cn.com.yusys.yusp.uimp.distr.thread.pool.FixedThreadPoolManager;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants;
import cn.com.yusys.yusp.uimp.distribution.constants.DistributionConstants.FUN_SUB_TYPE;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFPerformanceBatchInfo;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.CommonPerformanceImpMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFPerformanceBatchInfoMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFperformanceBatchResultMapper;
import cn.com.yusys.yusp.uimp.distribution.service.CommonDistributionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PerformanceImpThreadRunnable
 * @类描述: # 业绩批量导入发起工作流线程类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-02-17 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class PerformanceImpThreadRunnable implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(PerformanceImpThreadRunnable.class);

	private CommonPerformanceImpMapper commonPerformanceImpMapper;
	
	private PmaFPerformanceBatchInfoMapper pmaFPerformanceBatchInfoMapper;
	
	private PmaFperformanceBatchResultMapper pmaFperformanceBatchResultMapper;
	
	private CommonDistributionService commonDistributionService;
	
	private MetaFunctionManagerService metaFunctionManagerService;
	
	private WorkflowEngineInterface workflowEngineService;
	
	private BatchFixedThreadPoolManager batchFixedThreadPoolManager;
	
	private FixedThreadPoolManager fixedThreadPoolManager;
	
	private WFStratDto stratDto;
	
	private String batchId;
	
	private String applyId;
	
	private Map<String, Object> paramMap;
	
	private String periodHisTableName;
	
	private boolean isReStartWf;
	
	public PerformanceImpThreadRunnable(WFStratDto stratDto, String batchId, String applyId, Map<String, Object> paramMap,
			String periodHisTableName, boolean isReStartWf,
			CommonPerformanceImpMapper commonPerformanceImpMapper,
			PmaFPerformanceBatchInfoMapper pmaFPerformanceBatchInfoMapper,
			PmaFperformanceBatchResultMapper pmaFperformanceBatchResultMapper, CommonDistributionService commonDistributionService,
			MetaFunctionManagerService metaFunctionManagerService, WorkflowEngineInterface workflowEngineService,
			BatchFixedThreadPoolManager batchFixedThreadPoolManager, FixedThreadPoolManager fixedThreadPoolManager) {
		this.stratDto = stratDto;
		this.batchId = batchId;
		this.applyId = applyId;
		this.paramMap = paramMap;
		this.periodHisTableName = periodHisTableName;
		this.isReStartWf = isReStartWf;
		this.commonPerformanceImpMapper = commonPerformanceImpMapper;
		this.pmaFPerformanceBatchInfoMapper = pmaFPerformanceBatchInfoMapper;
		this.pmaFperformanceBatchResultMapper = pmaFperformanceBatchResultMapper;
		this.commonDistributionService = commonDistributionService;
		this.metaFunctionManagerService = metaFunctionManagerService;
		this.workflowEngineService = workflowEngineService;
		this.batchFixedThreadPoolManager = batchFixedThreadPoolManager;
		this.fixedThreadPoolManager = fixedThreadPoolManager;
	}
	
	/**
	 * @函数名称:run
	 * @函数描述:线程执行方法
	 * @参数与返回说明:
	 * @算法描述:
	 * 1、调用新版echain工作流
	 * 7、工作流处理发生异常，更新 批量导入明细表、批量导入主表 相关字段
	 * 8、工作流处理成功，更新 批量导入明细表、批量导入主表 相关字段
	 * *** TODO 事务存在不一致性，即 当7/8发生异常，1不会回滚；考虑到7/8很少会出现问题，所以本次不修改
	 */
	@Override
	public void run() {
		boolean isException = false;
		try {
//			Thread.sleep(300);
			// 1、调用新版echain工作流
			workflowEngineService.start(stratDto);
//			isException = false;
			if(log.isDebugEnabled()) {
				log.debug("batchId:" + batchId + "; applyId:" + applyId + "; start workflow success");
			}
		} catch (Exception e) {
			isException = true;
			log.error("batchId:" + batchId + "; applyId:" + applyId + "; start workflow error: ", e);
		}
		// 7、工作流处理发生异常，更新 批量导入明细表、批量导入主表 相关字段
		// 8、工作流处理成功，更新 批量导入明细表、批量导入主表 相关字段
		process(isException);
	}
	
	/**
	 * @函数名称:process
	 * @函数描述:批量导入业务表处理方法
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public void process(boolean isException) {
		if(isException) {
			exceptionProcess();
		} else {
			successProcess();
		}
	}
	
	/**
	 * @函数名称:removeApplyId
	 * @函数描述:线程处理完成，无论生成工作流成功或失败，都执行删除applyId的操作
	 * @参数与返回说明:
	 * @算法描述:
	 */
//	public void removeApplyId() {
//		if(this.fixedThreadPoolManager != null) {
//			this.fixedThreadPoolManager.removeApplyIdFromApplyIdsMap(applyId);
//		}
//	}
	
	/**
	 * @函数名称:removeFromBatchResultMap
	 * @函数描述:当batchResultMap中成功数+失败数=工作流生成总数时，从batchResultMap删除对应批次数据
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public void removeFromBatchResultMap() {
		if(this.fixedThreadPoolManager != null) {
			this.fixedThreadPoolManager.removeFromBatchResultMap(batchId);
		}
	}
	
	/**
	 * @函数名称:exceptionProcess
	 * @函数描述:工作流处理发生异常，更新 批量导入业务主表、 批量导入分配区间历史表 相关字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void exceptionProcess() {
		try {
			PmaFPerformanceBatchInfo pmaFPerformanceBatchInfo = pmaFPerformanceBatchInfoMapper.selectByPrimaryKey(batchId);
			commonPerformanceImpMapper.updatePeriodHisApplySts(periodHisTableName, applyId, DistributionConstants.APPLY_EXCEPTION);
			Map<String, Integer> batchResult = fixedThreadPoolManager.recordSuccErrCountToBatchResultMap(batchId, true, isReStartWf, pmaFPerformanceBatchInfo);
			Integer dbSuccCount = batchResult.get(FixedThreadPoolManager.DB_BATCH_RESULT_SUCCESS);
			Integer dbErrCount = batchResult.get(FixedThreadPoolManager.DB_BATCH_RESULT_ERROR);
			Integer succCount = batchResult.get(FixedThreadPoolManager.BATCH_RESULT_SUCCESS);
			Integer errCount = batchResult.get(FixedThreadPoolManager.BATCH_RESULT_ERROR);
			if(!isReStartWf) {
				if(pmaFPerformanceBatchInfo.getWfTotalCount().equals(errCount + succCount)) {	// 成功+失败数=工作流总数，更新批量导入主表数据
					pmaFPerformanceBatchInfo.setStatus("19");
					pmaFPerformanceBatchInfo.setWfSuccCount(succCount);
					pmaFPerformanceBatchInfo.setWfErrCount(errCount);
					pmaFPerformanceBatchInfoMapper.updateByPrimaryKey(pmaFPerformanceBatchInfo);
					removeFromBatchResultMap();
					if(batchFixedThreadPoolManager != null) {
						batchFixedThreadPoolManager.removeBatchIdFromBatchIdsMap(batchId);
					}
				}
			} else {	// 重新发起审批
				if(dbErrCount == succCount + errCount) {
					pmaFPerformanceBatchInfo.setStatus("19");
					pmaFPerformanceBatchInfo.setWfSuccCount(dbSuccCount + succCount);
					pmaFPerformanceBatchInfo.setWfErrCount(errCount);
					pmaFPerformanceBatchInfoMapper.updateByPrimaryKey(pmaFPerformanceBatchInfo);
					removeFromBatchResultMap();
					if(batchFixedThreadPoolManager != null) {
						batchFixedThreadPoolManager.removeBatchIdFromBatchIdsMap(batchId);
					}
				}
			}
//			removeApplyId();
			if(log.isDebugEnabled()) {
				log.debug("exceptionProcess has processed batchId:" + batchId + "; applyId:" + applyId + ";");
			}
		} catch(Exception e) {
			log.error("batchId:" + batchId + "; applyId:" + applyId + "; exceptionProcess error: ", e);
		}
	}
	
	/**
	 * @函数名称:successProcess
	 * @函数描述:工作流处理成功，更新 批量导入明细表、批量导入主表 相关字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void successProcess() {
		try {
			PmaFPerformanceBatchInfo pmaFPerformanceBatchInfo = pmaFPerformanceBatchInfoMapper.selectByPrimaryKey(batchId);
			Map<String, Integer> batchResult = fixedThreadPoolManager.recordSuccErrCountToBatchResultMap(batchId, false, isReStartWf, pmaFPerformanceBatchInfo);
			Integer dbSuccCount = batchResult.get(FixedThreadPoolManager.DB_BATCH_RESULT_SUCCESS);
			Integer dbErrCount = batchResult.get(FixedThreadPoolManager.DB_BATCH_RESULT_ERROR);
			Integer succCount = batchResult.get(FixedThreadPoolManager.BATCH_RESULT_SUCCESS);
			Integer errCount = batchResult.get(FixedThreadPoolManager.BATCH_RESULT_ERROR);
			if(!isReStartWf) {
				if(pmaFPerformanceBatchInfo.getWfTotalCount().equals(succCount)) {	// 成功数=工作流总数
					pmaFPerformanceBatchInfo.setWfSuccCount(succCount);
					pmaFPerformanceBatchInfo.setWfErrCount(0);
					pmaFPerformanceBatchInfo.setStatus("12");
					pmaFPerformanceBatchInfo.setCheckResult("");
					pmaFPerformanceBatchInfoMapper.updateByPrimaryKey(pmaFPerformanceBatchInfo);
					removeFromBatchResultMap();
					if(batchFixedThreadPoolManager != null) {
						batchFixedThreadPoolManager.removeBatchIdFromBatchIdsMap(batchId);
					}
				} else if(errCount > 0 && pmaFPerformanceBatchInfo.getWfTotalCount().equals(succCount + errCount)) {	// 成功+失败数=工作流总数，更新业绩批量导入业务主表数据	
					pmaFPerformanceBatchInfo.setWfSuccCount(succCount);
					pmaFPerformanceBatchInfo.setWfErrCount(errCount);
					pmaFPerformanceBatchInfo.setStatus("19");
					pmaFPerformanceBatchInfo.setCheckResult("");
					pmaFPerformanceBatchInfoMapper.updateByPrimaryKey(pmaFPerformanceBatchInfo);
					removeFromBatchResultMap();
					if(batchFixedThreadPoolManager != null) {
						batchFixedThreadPoolManager.removeBatchIdFromBatchIdsMap(batchId);
					}
				}
			} else {	// 重新发起审批
				if(dbErrCount == succCount) {	// 生成工作流成功
					pmaFPerformanceBatchInfo.setWfSuccCount(dbSuccCount + succCount);
					pmaFPerformanceBatchInfo.setWfErrCount(0);
					pmaFPerformanceBatchInfo.setStatus("12");
					pmaFPerformanceBatchInfo.setCheckResult("");
					pmaFPerformanceBatchInfoMapper.updateByPrimaryKey(pmaFPerformanceBatchInfo);
					removeFromBatchResultMap();
					if(batchFixedThreadPoolManager != null) {
						batchFixedThreadPoolManager.removeBatchIdFromBatchIdsMap(batchId);
					}
				} else if (dbErrCount == succCount + errCount) {	// 生成工作流异常
					pmaFPerformanceBatchInfo.setWfSuccCount(dbSuccCount + succCount);
					pmaFPerformanceBatchInfo.setWfErrCount(errCount);
					pmaFPerformanceBatchInfo.setStatus("19");
					pmaFPerformanceBatchInfo.setCheckResult("");
					pmaFPerformanceBatchInfoMapper.updateByPrimaryKey(pmaFPerformanceBatchInfo);
					removeFromBatchResultMap();
					if(batchFixedThreadPoolManager != null) {
						batchFixedThreadPoolManager.removeBatchIdFromBatchIdsMap(batchId);
					}
				}
			}
			// 发起审批成功， 更新 业务信息info表 DSTR_STS字段值为 03待审批
			String funCode = this.paramMap.get("funCode") + "";
			// 获取功能信息缓存
	        Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
	        // 获取分配主键list
	        List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
	        Map<String, String> infoTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
			String infoTableName = infoTableInfo.get("tableName");	// 信息表表名
	        Map<String, String> periodHisTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
			String periodHisTableName = periodHisTableInfo.get("tableName");	// 分配区间历史表表名
			String updateSql = "";
			updateSql += " update " + infoTableName + " info set info.DSTR_STS = '" + DistributionConstants.TO_APPROVE + "' ";
			updateSql += " where 1=1 ";
			for(String pk : pkList) {
				updateSql += " and info." + pk + " in (select DISTINCT phis." + pk + " from " + periodHisTableName + " phis where phis.APPLY_ID = '" + this.applyId + "')";
			}
			// 分区表-ETL_DATE处理
			if(!"ComCustDstr".equals(funCode) && !"PerCustDstr".equals(funCode)) {
				updateSql += " and info.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA') ";
			}
			commonPerformanceImpMapper.executeUpdateSql(updateSql.toString());
			
			if(isReStartWf) {	// 如果是重新发起的审批流，更新 分配区间历史表的审批状态APPLY_STS为11正在审批
				commonPerformanceImpMapper.updatePeriodHisApplySts(periodHisTableName, applyId, DistributionConstants.UNDER_APPROVAL);
			}
//			removeApplyId();
			if(log.isDebugEnabled()) {
				log.debug("successProcess has processed batchId:" + batchId + "; applyId:" + applyId + "; isReStartWf:" + isReStartWf);
			}
		} catch (Exception e) {
			log.error("batchId:" + batchId + "; applyId:" + applyId + "; successProcess error: ", e);
		}
	}
	
	/**
	 * @函数名称:exceptionProcess
	 * @函数描述:工作流处理发生异常，更新 批量导入业务主表、 批量导入分配区间历史表 相关字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
//	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//	public void exceptionProcess() {
//		try {
//			if(!isReStartWf) {	// 如果是重新发起的审批流，再次异常不需要更新数据
//				Integer errCount = pmaFperformanceBatchResultMapper.queryErrNumByBatchId(batchId);
//				Integer succCount = pmaFperformanceBatchResultMapper.querySuccNumByBatchId(batchId);
//				PmaFPerformanceBatchInfo pmaFPerformanceBatchInfo = pmaFPerformanceBatchInfoMapper.selectByPrimaryKey(batchId);
//				if(pmaFPerformanceBatchInfo.getWfTotalCount().equals(errCount + succCount + 1)) {	// 成功+失败数+1(当前失败)=工作流总数，更新批量导入主表数据
//					pmaFPerformanceBatchInfo.setStatus("19");
//					pmaFPerformanceBatchInfo.setWfSuccCount(succCount);
//					pmaFPerformanceBatchInfo.setWfErrCount(errCount + 1);
//					pmaFPerformanceBatchInfoMapper.updateByPrimaryKey(pmaFPerformanceBatchInfo);
//				}
//				// 保存当前工作流失败的记录
//				PmaFperformanceBatchResult pmaFperformanceBatchResult = new PmaFperformanceBatchResult();
//				pmaFperformanceBatchResult.setBatchId(batchId);
//				pmaFperformanceBatchResult.setWfErrNum(1);
//				pmaFperformanceBatchResultMapper.insertSelective(pmaFperformanceBatchResult);
//				commonPerformanceImpMapper.updatePeriodHisApplySts(periodHisTableName, applyId, DistributionConstants.APPLY_EXCEPTION);
//			}
//			removeApplyId();
//			if(log.isDebugEnabled()) {
//				if(!isReStartWf) {
//					log.debug("exceptionProcess has processed batchId:" + batchId + "; applyId:" + applyId + "; isReStartWf:" + isReStartWf);
//				} else {
//					log.debug("exceptionProcess do not process batchId:" + batchId + "; applyId:" + applyId + "; isReStartWf:" + isReStartWf);
//				}
//			}
//		} catch(Exception e) {
//			log.error("batchId:" + batchId + "; applyId:" + applyId + "; exceptionProcess error: ", e);
//		}
//	}
	
	/**
	 * @函数名称:successProcess
	 * @函数描述:工作流处理成功，更新 批量导入明细表、批量导入主表 相关字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
//	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//	public void successProcess() {
//		try {
//			Integer succCount = pmaFperformanceBatchResultMapper.querySuccNumByBatchId(batchId);
//			Integer errCount = pmaFperformanceBatchResultMapper.queryErrNumByBatchId(batchId);
//			PmaFPerformanceBatchInfo pmaFPerformanceBatchInfo = pmaFPerformanceBatchInfoMapper.selectByPrimaryKey(batchId);
//			if(pmaFPerformanceBatchInfo.getWfTotalCount().equals(succCount + 1)) {	// 成功+1(当前成功)=工作流总数
//				pmaFPerformanceBatchInfo.setWfSuccCount(succCount + 1);
//				pmaFPerformanceBatchInfo.setWfErrCount(0);
//				pmaFPerformanceBatchInfo.setStatus("12");
//				pmaFPerformanceBatchInfo.setCheckResult("");
//				pmaFPerformanceBatchInfoMapper.updateByPrimaryKey(pmaFPerformanceBatchInfo);
//				pmaFperformanceBatchResultMapper.deleteByBatchId(batchId);	// 都成功后，删除 业绩批量导入线程池生成工作流结果表冗余数据
//			} else if(errCount > 0 && pmaFPerformanceBatchInfo.getWfTotalCount().equals(succCount + errCount + 1)) {	// 成功+失败数+1(当前成功)=工作流总数，更新业绩批量导入业务主表数据	
//				pmaFPerformanceBatchInfo.setWfSuccCount(succCount + 1);
//				pmaFPerformanceBatchInfo.setWfErrCount(errCount);
//				pmaFPerformanceBatchInfo.setStatus("19");
//				pmaFPerformanceBatchInfo.setCheckResult("");
//				pmaFPerformanceBatchInfoMapper.updateByPrimaryKey(pmaFPerformanceBatchInfo);
//				// 保存当前工作流成功的记录
//				PmaFperformanceBatchResult pmaFperformanceBatchResult = new PmaFperformanceBatchResult();
//				pmaFperformanceBatchResult.setBatchId(batchId);
//				pmaFperformanceBatchResult.setWfSuccNum(1);
//				pmaFperformanceBatchResultMapper.insertSelective(pmaFperformanceBatchResult);
//			} else {
//				PmaFperformanceBatchResult pmaFperformanceBatchResult = new PmaFperformanceBatchResult();
//				pmaFperformanceBatchResult.setBatchId(batchId);
//				pmaFperformanceBatchResult.setWfSuccNum(1);
//				pmaFperformanceBatchResultMapper.insertSelective(pmaFperformanceBatchResult);
//			}
//			// 发起审批成功， 更新 业务信息info表 DSTR_STS字段值为 03待审批
//			String funCode = this.paramMap.get("funCode") + "";
//			// 获取功能信息缓存
//	        Map<String, Object> funInfoMap = metaFunctionManagerService.getMetaFunInfo(funCode);
//	        // 获取分配主键list
//	        List<String> pkList = commonDistributionService.getDstrPrimaryKey(funInfoMap);
//	        Map<String, String> infoTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.INFO);
//			String infoTableName = infoTableInfo.get("tableName");	// 信息表表名
//	        Map<String, String> periodHisTableInfo = commonDistributionService.getTableMap(funInfoMap, FUN_SUB_TYPE.PERIOD_HIS);
//			String periodHisTableName = periodHisTableInfo.get("tableName");	// 分配区间历史表表名
//			String updateSql = "";
//			updateSql += " update " + infoTableName + " info set info.DSTR_STS = '" + DistributionConstants.TO_APPROVE + "' ";
//			updateSql += " where 1=1 ";
//			for(String pk : pkList) {
//				updateSql += " and info." + pk + " in (select DISTINCT phis." + pk + " from " + periodHisTableName + " phis where phis.APPLY_ID = '" + this.applyId + "')";
//			}
//			// 分区表-ETL_DATE处理
//			if(!"ComCustDstr".equals(funCode) && !"PerCustDstr".equals(funCode)) {
//				updateSql += " and info.etl_date = (SELECT TO_CHAR(TO_DATE(ETL_DATE,'YYYYMMDD')-1,'YYYYMMDD') FROM PMA_F_ETL_DATE WHERE ETL_TYPE = 'PMA') ";
//			}
//			commonPerformanceImpMapper.executeUpdateSql(updateSql.toString());
//			
//			if(isReStartWf) {	// 如果是重新发起的审批流，更新 分配区间历史表的审批状态APPLY_STS为11正在审批
//				commonPerformanceImpMapper.updatePeriodHisApplySts(periodHisTableName, applyId, DistributionConstants.UNDER_APPROVAL);
//			}
//			removeApplyId();
//			if(log.isDebugEnabled()) {
//				log.debug("successProcess has processed batchId:" + batchId + "; applyId:" + applyId + "; isReStartWf:" + isReStartWf);
//			}
//		} catch (Exception e) {
//			log.error("batchId:" + batchId + "; applyId:" + applyId + "; successProcess error: ", e);
//		}
//	}
	
}
