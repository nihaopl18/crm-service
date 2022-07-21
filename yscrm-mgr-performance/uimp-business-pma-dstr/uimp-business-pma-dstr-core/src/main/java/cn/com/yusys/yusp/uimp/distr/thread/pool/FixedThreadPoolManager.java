package cn.com.yusys.yusp.uimp.distr.thread.pool;

import cn.com.yusys.yusp.commons.util.StringUtil;
import cn.com.yusys.yusp.flow.dto.WFStratDto;
import cn.com.yusys.yusp.flow.service.core.WorkflowEngineInterface;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.distr.thread.PerformanceImpThreadRunnable;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFPerformanceBatchInfo;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.CommonPerformanceImpMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFPerformanceBatchInfoMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFperformanceBatchResultMapper;
import cn.com.yusys.yusp.uimp.distribution.service.CommonDistributionService;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: FixedThreadPoolManager
 * @类描述: # 业绩批量导入线程池管理类，使用java自带的ThreadPoolExecutor，创建固定线程数量的线程池
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-03 14:51:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Component
public class FixedThreadPoolManager {
	
	private static final Logger log = LoggerFactory.getLogger(FixedThreadPoolManager.class);
	
	@Autowired
	private CommonPerformanceImpMapper commonPerformanceImpMapper;
	
	@Autowired
	private PmaFPerformanceBatchInfoMapper pmaFPerformanceBatchInfoMapper;

	@Autowired
	private PmaFperformanceBatchResultMapper pmaFperformanceBatchResultMapper;
	
	@Autowired
	private CommonDistributionService commonDistributionService;
	
	@Autowired
	private MetaFunctionManagerService metaFunctionManagerService;
	
	@Autowired
	private WorkflowEngineInterface workflowEngineService;

	/**
	 * 业绩批量导入-发起审批流-执行线程池大小
	 */
	@Value("${info.pma.performance-imp.thread-pool-size}")
	private int THREAD_POOL_SIZE;
	
	/**
	 * 业绩批量导入-记录正在执行ApplyId的ConcurrentHashMap最大size
	 */
//	@Value("${application.pma.performance-imp.execute-concurrenthashmap-max-size}")
//	private int EXECUTE_CONCURRENTHASHMAP_MAX_SIZE;

	/**
	 * 批量导入-执行发起工作流线程池
	 */
	private ExecutorService executorService;
	
	/**
	 * 业绩批量导入-记录正在执行ApplyId的ConcurrentHashMap
	 */
//	private ConcurrentHashMap<String, String> applyIdsMap;
	
	/**
	 * 业绩批量导入-记录发起工作流线程的执行结果数据
	 */
//	private ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>> batchResultMap;
	private Map<String, Map<String, Integer>> batchResultMap;
	
	/**
	 * 业绩批量导入-记录发起工作流线程的执行结果Map-成功对应的KEY
	 * 针对重新发起工作流做处理
	 */
	public static final String DB_BATCH_RESULT_SUCCESS = "DBSUCCESS";
	
	/**
	 * 业绩批量导入-记录发起工作流线程的执行结果Map-成功对应的KEY
	 */
	public static final String BATCH_RESULT_SUCCESS = "SUCCESS";
	
	/**
	 * 业绩批量导入-记录发起工作流线程的执行结果Map-失败对应的KEY
	 */
	public static final String BATCH_RESULT_ERROR = "ERROR";
	
	/**
	 * 业绩批量导入-记录发起工作流线程的执行结果Map-失败对应的KEY
	 * 针对重新发起工作流做处理
	 */
	public static final String DB_BATCH_RESULT_ERROR = "DBERROR";
	
//	@Autowired
//	private PmaFperformanceToinitwfInfService pmaFperformanceToinitwfInfService;

	@PostConstruct
	public void init() {
		executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
//		applyIdsMap = new ConcurrentHashMap<String, String>();
//		batchResultMap = new ConcurrentHashMap<String, ConcurrentHashMap<String, Integer>>();
		batchResultMap = Collections.synchronizedMap(new HashMap<String, Map<String, Integer>>());
	}
	
	/**
     * @方法名称: recordSuccErrCountToBatchResultMap
	 * @方法描述: 向batchResultMap记录-单批次数据工作流发起成功/失败数量
	 * @参数与返回说明: 
	 * @param batchId批次号
	 * @param isException工作流发起是否异常
	 * @return 单批次数据工作流发起成功/失败数量, key: SUCCESS成功  ERROR失败 
     * @算法描述:
     */
	public Map<String, Integer> recordSuccErrCountToBatchResultMap(String batchId, boolean isException, boolean isReStartWf, PmaFPerformanceBatchInfo pmaFPerformanceBatchInfo) {
		try {
			if(StringUtil.isNotEmpty(batchId)) {
				Map<String, Integer> batchResult = null;
				Map<String, Integer> tempBatchResult = new HashMap<String, Integer>();
				synchronized(batchResultMap) {
					batchResult = batchResultMap.get(batchId);
					if(isReStartWf && batchResult == null) {
						batchResult = new ConcurrentHashMap<String, Integer>();
						batchResult.put(DB_BATCH_RESULT_SUCCESS, pmaFPerformanceBatchInfo.getWfSuccCount());
						batchResult.put(DB_BATCH_RESULT_ERROR, pmaFPerformanceBatchInfo.getWfErrCount());
						batchResult.put(BATCH_RESULT_SUCCESS, 0);
						batchResult.put(BATCH_RESULT_ERROR, 0);
						batchResultMap.put(batchId, batchResult);
					} else if(batchResult == null) {
						batchResult = new ConcurrentHashMap<String, Integer>();
						batchResult.put(BATCH_RESULT_SUCCESS, 0);
						batchResult.put(BATCH_RESULT_ERROR, 0);
						batchResultMap.put(batchId, batchResult);
					}
					if(isException) {
						batchResult.put(BATCH_RESULT_ERROR, batchResult.get(BATCH_RESULT_ERROR) + 1);
					} else {
						batchResult.put(BATCH_RESULT_SUCCESS, batchResult.get(BATCH_RESULT_SUCCESS) + 1);
					}
					tempBatchResult.put(DB_BATCH_RESULT_SUCCESS, batchResult.get(DB_BATCH_RESULT_SUCCESS));
					tempBatchResult.put(DB_BATCH_RESULT_ERROR, batchResult.get(DB_BATCH_RESULT_ERROR));
					tempBatchResult.put(BATCH_RESULT_SUCCESS, batchResult.get(BATCH_RESULT_SUCCESS));
					tempBatchResult.put(BATCH_RESULT_ERROR, batchResult.get(BATCH_RESULT_ERROR));
				}
				if(log.isDebugEnabled()) {
					log.debug("complete record batchResult, SUCCESS:" + batchResult.get(BATCH_RESULT_SUCCESS) + "; "
							+ "ERROR:" + batchResult.get(BATCH_RESULT_ERROR));
				}
				return tempBatchResult;
			} else {
				log.warn("batchId is null, cannot to record batchResult");
				return null;
			}
		} catch(Exception e) {
			log.error("fail record batchResult", e);
		}
		return null;
	}
	
	/**
     * @方法名称: recordSuccErrCountToBatchResultMap
	 * @方法描述: 向batchResultMap记录-单批次数据工作流发起成功/失败数量
	 * @参数与返回说明: 
	 * @param batchId批次号
	 * @param isException工作流发起是否异常
	 * @return 单批次数据工作流发起成功/失败数量, key: SUCCESS成功  ERROR失败 
     * @算法描述:
     */
//	public Map<String, Integer> recordSuccErrCountToBatchResultMap(String batchId, boolean isException) {
//		try {
//			if(StringUtil.isNotEmpty(batchId)) {
//				ConcurrentHashMap<String, Integer> batchResult = batchResultMap.get(batchId);
//				if(batchResult == null) {
//					batchResult = new ConcurrentHashMap<String, Integer>();
//					batchResult.put(BATCH_RESULT_SUCCESS, 0);
//					batchResult.put(BATCH_RESULT_ERROR, 0);
//					batchResultMap.put(batchId, batchResult);
//				}
//				if(isException) {
//					batchResult.put(BATCH_RESULT_ERROR, batchResult.get(BATCH_RESULT_ERROR) + 1);
//				} else {
//					batchResult.put(BATCH_RESULT_SUCCESS, batchResult.get(BATCH_RESULT_SUCCESS) + 1);
//				}
//				if(log.isDebugEnabled()) {
//					log.debug("complete record batchResult, SUCCESS:" + batchResult.get(BATCH_RESULT_SUCCESS) + "; "
//							+ "ERROR:" + batchResult.get(BATCH_RESULT_ERROR));
//				}
//				return batchResult;
//			} else {
//				log.warn("batchId is null, cannot to record batchResult");
//				return null;
//			}
//		} catch(Exception e) {
//			log.error("fail record batchResult", e);
//		}
//		return null;
//	}
	
	/**
     * @方法名称: removeFromBatchResultMap
	 * @方法描述: 从batchResultMap中删除对应batchId数据
	 * @参数与返回说明: 
	 * @param batchId批次号
     * @算法描述:
     */
	public void removeFromBatchResultMap(String batchId) {
		try {
			if(StringUtil.isNotEmpty(batchId)) {
				batchResultMap.remove(batchId);
				if(log.isDebugEnabled()) {
					log.debug("batchId has removed from batchResultMap, batchId:" + batchId + ";");
				}
				log.info("after remove batchResultMap size:" + batchResultMap.size());
			} else {
				log.warn("batchId is null, cannot to remove");
			}
		} catch(Exception e) {
			log.error("fail to remove batchId:" + batchId, e);
		}
	}
	
	/**
     * @方法名称: getFromBatchResultMap
	 * @方法描述: 从batchResultMap中获取对应batchId数据
	 * @参数与返回说明: 
	 * @param batchId批次号
     * @算法描述:
     */
	public Map<String, Integer> getFromBatchResultMap(String batchId) {
		return batchResultMap.get(batchId);
	}
	
	/**
     * @方法名称: putApplyIdsToApplyIdsMap
	 * @方法描述: 向applyIdsMap放入需要执行的applyId值
	 * @参数与返回说明: 
     * @算法描述:
     *   判断applyIdsMap当前大小是否超过最大值: 
     *     不超过则从-业绩批量导入工作流待发起信息表获取APPLY_ID值，填充applyIdsMap；
     *     超过则不执行put操作。
     */
//	public List<String> putApplyIdsToApplyIdsMap() {
//		List<String> toApplyIds = new ArrayList<String>();
//		try {
//			Integer currentSize = applyIdsMap.size();
//			if(currentSize < EXECUTE_CONCURRENTHASHMAP_MAX_SIZE) {
//				Integer freeSize = EXECUTE_CONCURRENTHASHMAP_MAX_SIZE - currentSize;
//				toApplyIds = pmaFperformanceToinitwfInfService.getEarlyApplyIdsByCount(freeSize);
//				for(String applyId: toApplyIds) {
//					applyIdsMap.put(applyId, applyId);
//				}
//				if(toApplyIds.size() == 0) {
//					log.warn("there is no applyId to be init");
//				}
//				if(log.isDebugEnabled()) {
//					log.debug("applyIdsMap currentsize:" + currentSize + "; "
//							+ "maxsize:" + EXECUTE_CONCURRENTHASHMAP_MAX_SIZE + "; "
//							+ "putApplyIdsMap size:" + toApplyIds.size() + ";");
//					if(toApplyIds.size() > 0)
//						log.debug("putApplyIdsMap data: " + String.join(",", toApplyIds));
//				}
//			} else {
//				log.warn("applyIdsMap size is equal max_size, cannot to put applyIds");
//			}
//			return toApplyIds;
//		} catch(Exception e) {
//			log.error("fail to put applyIds", e);
//		}
//		return toApplyIds;
//	}
	
	/**
     * @方法名称: removeApplyIdFromApplyIdsMap
	 * @方法描述: 从applyIdsMap删除对应的applyId值
	 * @参数与返回说明: 
     * @算法描述:
     */
//	public void removeApplyIdFromApplyIdsMap(String applyId) {
//		try {
//			if(StringUtil.isNotEmpty(applyId) && applyIdsMap.contains(applyId)) {
//				// 根据审批编号 删除业绩批量导入工作流待发起信息表数据
//				pmaFperformanceToinitwfInfService.deleteByApplyId(applyId);
//				// 从公共变量applyIdsMap中删除applyId数据
//				applyIdsMap.remove(applyId);
//				if(log.isDebugEnabled()) {
//					log.debug("applyId has removed from applyIdsMap, applyId:" + applyId + "; applyIdsMap currentsize:" + applyIdsMap.size());
//				}
//			} else {
//				if(StringUtil.isEmpty(applyId))	{	// 避免不必要的日志
//					log.warn("applyId is null cannot to remove");
//				}
//			}
//		} catch(Exception e) {
//			log.error("fail to remove applyId:" + applyId, e);
//		}
//	}
	
	/**
     * @方法名称: executeByApplyIds
	 * @方法描述: 根据applyIds获取-工作流待发起信息，构造WFStratDto，并交给ExecutorService执行批量导入发起工作流线程PerformanceImpThreadRunnable
	 * @参数与返回说明: 
     * @算法描述:
     */
//	public void executeByApplyIds(List<String> applyIds) {
//		try {
//			// 1、根据applyIds获取-工作流待发起信息
//			List<PmaFperformanceToinitwfInf> toinitwfInfList = pmaFperformanceToinitwfInfService.getToinitwfInfByApplyIds(applyIds);
//			// 2、遍历并构造WFStratDto，并交给ExecutorService执行
//			PmaFperformanceToinitwfInf toinitwfInf = null;
//			Map<String, Object> paramMap = null;
//			WFStratDto stratDto = null;
//			for(int i=0, k=toinitwfInfList.size(); i < k; ++i) {
//				toinitwfInf = toinitwfInfList.get(i);
//				if(log.isDebugEnabled()) {
//					log.debug("start async execute PerformanceImpThreadRunnable, "
//							+ "funCode:" + toinitwfInf.getFunCode() + "; batchId:" + toinitwfInf.getBatchId() + "; "
//							+ "applyId:" + toinitwfInf.getApplyId());
//				}
//				paramMap = beanToMap(toinitwfInf);
//				boolean isReStartWf = "true".equals(toinitwfInf.getIsReStartWf()) ? true : false;
//				stratDto = new WFStratDto();
//				stratDto.setBizId(toinitwfInf.getApplyId());
//				stratDto.setBizType(toinitwfInf.getWorkFlow());
//				stratDto.setSystemId("yusp");
//				stratDto.setOrgId(toinitwfInf.getOrgId());
//				stratDto.setUserId(toinitwfInf.getUserId());
//				stratDto.setParam(paramMap);
//				stratDto.setBizParam1(toinitwfInf.getFunCode());
//				// 提交任务就是将任务对象加入任务队列，等待工作线程去处理
//				executorService.execute(new PerformanceImpThreadRunnable(stratDto,
//						toinitwfInf.getBatchId(), toinitwfInf.getApplyId(), paramMap,
//						toinitwfInf.getPeriodHisTableName(), isReStartWf, 
//						commonPerformanceImpMapper, 
//						pmaFPerformanceBatchInfoMapper, pmaFperformanceBatchResultMapper,
//						commonDistributionService, metaFunctionManagerService, workflowEngineService, null, this));
//				if(log.isDebugEnabled()) {
//					log.debug("complete async execute PerformanceImpThreadRunnable, "
//							+ "funCode:" + toinitwfInf.getFunCode() + "; batchId:" + toinitwfInf.getBatchId() + "; "
//							+ "applyId:" + toinitwfInf.getApplyId());
//				}
//			}
////			for(PmaFperformanceToinitwfInf toinitwfInf: toinitwfInfList) {
////				if(log.isDebugEnabled()) {
////					log.debug("start async execute PerformanceImpThreadRunnable, "
////							+ "funCode:" + toinitwfInf.getFunCode() + "; batchId:" + toinitwfInf.getBatchId() + "; "
////							+ "applyId:" + toinitwfInf.getApplyId());
////				}
////				Map<String, Object> paramMap = beanToMap(toinitwfInf);
////				boolean isReStartWf = "true".equals(toinitwfInf.getIsReStartWf()) ? true : false;
////				WFStratDto stratDto = new WFStratDto();
////				stratDto.setBizId(toinitwfInf.getApplyId());
////				stratDto.setBizType(toinitwfInf.getWorkFlow());
////				stratDto.setSystemId("yusp");
////				stratDto.setOrgId(toinitwfInf.getOrgId());
////				stratDto.setUserId(toinitwfInf.getUserId());
////				stratDto.setParam(paramMap);
////				stratDto.setBizParam1(toinitwfInf.getFunCode());
////				// 提交任务就是将任务对象加入任务队列，等待工作线程去处理
////				executorService.execute(new PerformanceImpThreadRunnable(stratDto,
////						toinitwfInf.getBatchId(), toinitwfInf.getApplyId(), paramMap,
////						toinitwfInf.getPeriodHisTableName(), isReStartWf, 
////						commonPerformanceImpMapper, 
////						pmaFPerformanceBatchInfoMapper, pmaFperformanceBatchResultMapper,
////						commonDistributionService, metaFunctionManagerService, workflowEngineService, this));
////				if(log.isDebugEnabled()) {
////					log.debug("complete async execute PerformanceImpThreadRunnable, "
////							+ "funCode:" + toinitwfInf.getFunCode() + "; batchId:" + toinitwfInf.getBatchId() + "; "
////							+ "applyId:" + toinitwfInf.getApplyId());
////				}
////			}
//			// 3、根据applyIds更新-业绩批量导入工作流待发起信息表-执行状态值为1执行中
//			if(applyIds.size() > 0) {
//				pmaFperformanceToinitwfInfService.updateExecuteStatusByApplyIds("1", applyIds);
//			}
//			if(log.isDebugEnabled()) {
//				log.debug("complete executeByApplyIds, totalCount:" + toinitwfInfList.size());
//			}
//		} catch(Exception e) {
//			log.error("executeByApplyIds error, applyIds:" + String.join(",", applyIds), e);
//		}
//	}
	
	/**
     * 将对象装换为map
     *
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {
        Map<String, Object> map = Maps.newHashMap();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                map.put(key + "", beanMap.get(key));
            }
        }
        return map;
    }
	
	/**
     * @方法名称: execute
	 * @方法描述: 根据参数构造WFStratDto，并交给ExecutorService执行批量导入发起工作流线程PerformanceImpThreadRunnable
	 * @参数与返回说明: 
     * @算法描述:
     */
	@SuppressWarnings("unchecked")
	public void execute(String batchId, List<Map<String, Object>> instanceList, 
			String periodHisTableName, String dtlTableName, boolean isReStartWf,
			CommonPerformanceImpMapper commonPerformanceImpMapper,
			PmaFPerformanceBatchInfoMapper pmaFPerformanceBatchInfoMapper,
			PmaFperformanceBatchResultMapper pmaFperformanceBatchResultMapper, CommonDistributionService commonDistributionService,
			MetaFunctionManagerService metaFunctionManagerService, UserInfoService userInfoService, WorkflowEngineInterface workflowEngineService, 
			String workFlow, BatchFixedThreadPoolManager batchFixedThreadPoolManager, String userId) {
		try {
			log.info("start async execute PerformanceImpThreadRunnable, batchId:" + batchId + "; totalCount:" + instanceList.size());
			Map<String, Object> instanceMap = null;
			String applyId = null;
			Map<String, Object> paramMap = null;
			WFStratDto stratDto = null;
			for(int i=0, k=instanceList.size(); i < k; ++i) {
				instanceMap = instanceList.get(i);
				applyId = instanceMap.get("applyId") + "";
				paramMap = (Map<String, Object>) instanceMap.get("paramMap");
				stratDto = new WFStratDto();
				stratDto.setBizId(applyId);
				stratDto.setBizType(workFlow);
				stratDto.setSystemId("yusp");
				stratDto.setOrgId(paramMap.get("orgId").toString());
				stratDto.setUserId(userInfoService == null ? userId : userInfoService.getUserInfo().getLoginCode());
				stratDto.setParam(paramMap);
				stratDto.setBizParam1(paramMap.get("funCode").toString());
				// 提交任务就是将任务对象加入任务队列，等待工作线程去处理
				executorService.execute(new PerformanceImpThreadRunnable(stratDto,
						batchId, applyId, paramMap,
						periodHisTableName, isReStartWf, 
						commonPerformanceImpMapper, 
						pmaFPerformanceBatchInfoMapper, pmaFperformanceBatchResultMapper,
						commonDistributionService, metaFunctionManagerService, workflowEngineService, batchFixedThreadPoolManager, this));
			}
			log.info("complete async execute PerformanceImpThreadRunnable, batchId:" + batchId + "; totalCount:" + instanceList.size());
		} catch(Exception e) {
			log.error("execute PerformanceImpThreadRunnable error, batchId:" + batchId + "; totalCount:" + instanceList.size() + ";", e);
		}
	}
}
