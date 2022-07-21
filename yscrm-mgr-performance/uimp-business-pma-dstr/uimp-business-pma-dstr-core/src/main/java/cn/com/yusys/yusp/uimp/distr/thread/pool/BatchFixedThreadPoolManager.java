package cn.com.yusys.yusp.uimp.distr.thread.pool;

import cn.com.yusys.yusp.commons.util.StringUtil;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFperformanceTobatchInf;
import cn.com.yusys.yusp.uimp.distribution.service.CommonPerformanceImpService;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFperformanceTobatchInfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class BatchFixedThreadPoolManager {
	
	private static final Logger log = LoggerFactory.getLogger(BatchFixedThreadPoolManager.class);
	
	/**
	 * 业绩批量导入-发起批次数据-执行线程池大小
	 */
	@Value("${info.pma.performance-imp.batch-thread-pool-size}")
	private int BATCH_THREAD_POOL_SIZE;
	
	/**
	 * 业绩批量导入-记录正在执行BatchId的ConcurrentHashMap最大size
	 */
	@Value("${info.pma.performance-imp.syn-execute-batch-max-size}")
	private int SYN_EXECUTE_BATCH_MAX_SIZE;
	
	/**
	 * 业绩批量导入-记录正在执行BatchId的ConcurrentHashMap
	 */
	private ConcurrentHashMap<String, String> batchIdsMap;
	
	/**
	 * 批量导入-执行发起批次数据线程池
	 */
	private ExecutorService batchExecutorService;
	
	@Autowired
	private PmaFperformanceTobatchInfService pmaFperformanceTobatchInfService;
	
	@Autowired
	private CommonPerformanceImpService performanceImpService;
	
	@PostConstruct
	public void init() {
		batchExecutorService = Executors.newFixedThreadPool(BATCH_THREAD_POOL_SIZE);
		batchIdsMap = new ConcurrentHashMap<String, String>();
	}
	
	/**
     * @方法名称: putBatchIdsToBatchIdsMap
	 * @方法描述: 向batchIdsMap放入需要执行的batchId值
	 * @参数与返回说明: 
     * @算法描述:
     *   判断batchIdsMap当前大小是否超过最大值: 
     *     不超过则从-业绩批量导入批次号待发起信息表获取BATCH_ID值，填充batchIdsMap；
     *     超过则不执行put操作。
     */
	public List<PmaFperformanceTobatchInf> putBatchIdsToBatchIdsMap() {
		List<PmaFperformanceTobatchInf> toBatchIds = new ArrayList<PmaFperformanceTobatchInf>();
		try {
			// 获取表 PMA_F_PERFORMANCE_TOBATCH_INF中STATUS=2(已删除，需要手工干预)的数据
			if(batchIdsMap.size() > 0) {	// batchIdsMap容量大于0时，才需要判断是否删除
				List<String> deleteBatchIds = pmaFperformanceTobatchInfService.getBatchIdsByStatus("2");
				if(deleteBatchIds != null && deleteBatchIds.size() > 0) {
					String deletedBatchIds = "";	// 记录已经从batchIdsMap中删除的批次编号batchId
					// 在本JVM中查找是否存在相同的BATCH_ID，存在则从batchIdsMap中删除对应数据，后续线程执行其他待执行的批次数据
					for(String key: batchIdsMap.keySet()) {
						if(deleteBatchIds.contains(key)) {
							deletedBatchIds += key + ",";
							batchIdsMap.remove(key);
						}
					}
					if(deletedBatchIds == "") {
						log.info("do not delete from batchIdsMap");
					} else {
						log.warn("had delete from batchIdsMap, deleteBatchIds:" + deletedBatchIds);
					}
				}
			}
			Integer currentSize = batchIdsMap.size();
			log.info("current batchIdsMap.size:" + currentSize + "; maxSize:" + SYN_EXECUTE_BATCH_MAX_SIZE);
			if(currentSize < SYN_EXECUTE_BATCH_MAX_SIZE) {
				Integer freeSize = SYN_EXECUTE_BATCH_MAX_SIZE - currentSize;
				toBatchIds = pmaFperformanceTobatchInfService.getEarlyBatchInfByCount(freeSize);
				String putBatchIds = "";
				for(PmaFperformanceTobatchInf item: toBatchIds) {
					putBatchIds += item.getBatchId() + ",";
					batchIdsMap.put(item.getBatchId(), item.getBatchId());
				}
				if(toBatchIds.size() == 0) {
					log.warn("there is no batchId to be start");
				}
				if(log.isDebugEnabled()) {
					log.debug("batchIdsMap currentsize:" + currentSize + "; "
							+ "maxsize:" + SYN_EXECUTE_BATCH_MAX_SIZE + "; "
							+ "putBatchIdsMap size:" + batchIdsMap.size() + ";");
					if(toBatchIds.size() > 0) {
						log.debug("putBatchIdsMap data: " + putBatchIds);
					}
				}
			} else {
				String batchIds = "";
				for(String key: batchIdsMap.keySet()) {
					batchIds += key;
				}
				log.warn("batchIdsMap size is equal max_size, cannot to put batchIds, batchIdsMap keys:" + batchIds);
			}
			return toBatchIds;
		} catch(Exception e) {
			log.error("fail to put batchIds", e);
		}
		return toBatchIds;
	}
	
	/**
     * @方法名称: removeBatchIdFromBatchIdsMap
	 * @方法描述: 从batchIdsMap删除对应的batchId值
	 * @参数与返回说明: 
     * @算法描述:
     */
	public void removeBatchIdFromBatchIdsMap(String batchId) {
		try {
			if(StringUtil.isNotEmpty(batchId) && batchIdsMap.contains(batchId)) {
				pmaFperformanceTobatchInfService.deleteByBatchId(batchId);
				// 从公共变量batchIdsMap中删除batchId数据
				batchIdsMap.remove(batchId);
				if(log.isDebugEnabled()) {
					log.debug("batchId has removed from batchIdsMap, batchId:" + batchId + "; batchIdsMap currentsize:" + batchIdsMap.size());
				}
			} else {
				if(StringUtil.isEmpty(batchId))	{	// 避免不必要的日志
					log.warn("batchId is null cannot to remove");
				}
			}
		} catch(Exception e) {
			log.error("fail to remove batchId:" + batchId, e);
		}
	}
	
	/**
     * @方法名称: executeByBatchIds
	 * @方法描述: 根据batchIds获取-批次待发起信息，交给batchExecutorService执行批量导入批次发起线程BatchPerformanceImpThreadRunnable
	 * @参数与返回说明: 
     * @算法描述:
     */
//	public void executeByBatchIds(List<PmaFperformanceTobatchInf> toBatchInfList) {
//		try {
//			// 3、根据batchIds更新-业绩批量导入待执行批次数据信息表-执行状态值为1执行中
//			if(toBatchInfList.size() > 0) {
//				pmaFperformanceTobatchInfService.updateStatusByBatchId("1", toBatchInfList);
//			}
//			PmaFperformanceTobatchInf item = null;
//			for(int i=0, k=toBatchInfList.size(); i < k; ++i) {
//				item = toBatchInfList.get(i);
//				if(log.isDebugEnabled()) {
//					log.debug("start async execute BatchPerformanceImpThreadRunnable, "
//							+ "funCode:" + item.getFunCode() + "; batchId:" + item.getBatchId() + ";");
//				}
//				// 提交任务就是将任务对象加入任务队列，等待工作线程去处理
//				batchExecutorService.execute(new BatchPerformanceImpThreadRunnable(item, performanceImpService, this));
//				if(log.isDebugEnabled()) {
//					log.debug("complete start async execute BatchPerformanceImpThreadRunnable, "
//							+ "funCode:" + item.getFunCode() + "; batchId:" + item.getBatchId() + ";");
//				}
//			}
//			if(log.isDebugEnabled()) {
//				log.debug("complete executeByApplyIds, totalCount:" + toBatchInfList.size());
//			}
//		} catch(Exception e) {
//			String batchIds = "";
//			for(PmaFperformanceTobatchInf item: toBatchInfList) {
//				batchIds += item.getBatchId();
//			}
//			log.error("executeByBatchIds error, batchIds:" + batchIds, e);
//		}
//	}
}
