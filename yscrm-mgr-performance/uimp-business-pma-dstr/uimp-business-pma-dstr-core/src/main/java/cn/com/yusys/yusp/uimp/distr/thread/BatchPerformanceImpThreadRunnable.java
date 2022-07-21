package cn.com.yusys.yusp.uimp.distr.thread;

import cn.com.yusys.yusp.uimp.distr.thread.pool.BatchFixedThreadPoolManager;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFperformanceTobatchInf;
import cn.com.yusys.yusp.uimp.distribution.service.CommonPerformanceImpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BatchPerformanceImpThreadRunnable implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(BatchPerformanceImpThreadRunnable.class);
	
	private PmaFperformanceTobatchInf batchInf;
	
	private CommonPerformanceImpService performanceImpService;
	
	private BatchFixedThreadPoolManager batchFixedThreadPoolManager;
	
	public BatchPerformanceImpThreadRunnable(PmaFperformanceTobatchInf batchInf, CommonPerformanceImpService performanceImpService,
			BatchFixedThreadPoolManager batchFixedThreadPoolManager) {
		this.batchInf = batchInf;
		this.performanceImpService = performanceImpService;
		this.batchFixedThreadPoolManager = batchFixedThreadPoolManager;
	}
	
	@Override
	public void run() {
		try {
			if(log.isDebugEnabled()) {
				log.debug("start asynProcessWorkFlow batchId:" + batchInf.getBatchId());
			}
			performanceImpService.asynProcessWorkFlow(batchInf, batchFixedThreadPoolManager);
			if(log.isDebugEnabled()) {
				log.debug("complete asynProcessWorkFlow batchId:" + batchInf.getBatchId());
			}
		} catch(Exception e) {
			log.error("asynProcessWorkFlow error, batchId:" + batchInf.getBatchId(), e);
		}
	}

}
