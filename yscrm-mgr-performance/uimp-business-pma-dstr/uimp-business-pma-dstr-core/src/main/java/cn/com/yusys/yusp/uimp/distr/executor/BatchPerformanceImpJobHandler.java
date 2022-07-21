package cn.com.yusys.yusp.uimp.distr.executor;

import cn.com.yusys.yusp.commons.job.core.biz.model.ReturnT;
import cn.com.yusys.yusp.commons.job.core.handler.IJobHandler;
import cn.com.yusys.yusp.commons.job.core.handler.annotation.JobHandler;
import cn.com.yusys.yusp.uimp.distr.thread.pool.BatchFixedThreadPoolManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: BatchPerformanceImpJobHandler
 * @类描述: # 业绩批量导入-发起批次数据-任务执行器
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-10-25 11:29:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
@JobHandler(value="batchperformanceImp")
public class BatchPerformanceImpJobHandler extends IJobHandler {
	
	private static final Logger log = LoggerFactory.getLogger(BatchPerformanceImpJobHandler.class);

	@Autowired
	private BatchFixedThreadPoolManager batchFixedThreadPoolManager;
	
	@Override
	public ReturnT<String> execute(String arg0) throws Exception {
//		try {
//			log.info("start jobhandler batchperformanceImp");
//			// 1、获取待发起的batchIds，并放入batchIdsMap
//			List<PmaFperformanceTobatchInf> toBatchInfList = batchFixedThreadPoolManager.putBatchIdsToBatchIdsMap();
//			// 2、将batchIds交给batchFixedThreadPoolManager执行
//			if(toBatchInfList.size() > 0) {
//				batchFixedThreadPoolManager.executeByBatchIds(toBatchInfList);
//			}
//			log.info("complete jobhandler batchperformanceImp, execute batchIds.size:" + toBatchInfList.size());
//			if(log.isDebugEnabled()) {
//				if(toBatchInfList.size() > 0) {
//					String batchIds = "";
//					for(PmaFperformanceTobatchInf item: toBatchInfList) {
//						batchIds += item.getBatchId();
//					}
//					log.debug("execute batchIds is: " + batchIds);
//				} else {
//					log.debug("execute batchIds.size is zero");
//				}
//			}
//		} catch(Exception e) {
//			log.error("execute BatchPerformanceImpJobHandler error: ", e);
//		}
		return null;
	}

}
