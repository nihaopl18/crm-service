package cn.com.yusys.yusp.uimp.distr.thread;

import cn.com.yusys.yusp.flow.service.core.WorkflowEngineInterface;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.distr.thread.pool.BatchFixedThreadPoolManager;
import cn.com.yusys.yusp.uimp.distr.thread.pool.FixedThreadPoolManager;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.CommonPerformanceImpMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFPerformanceBatchInfoMapper;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFperformanceBatchResultMapper;
import cn.com.yusys.yusp.uimp.distribution.service.CommonDistributionService;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFperformanceToinitwfInfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PerformanceImpThreadManager
 * @类描述: # 业绩批量导入线程入口类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-02-17 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PerformanceImpThreadManager {
	
	private static final Logger log = LoggerFactory.getLogger(PerformanceImpThreadManager.class);
	
//	@Value("${application.pma.performance-imp.execute-mode}")
//	private String executeMode;
	
	@Autowired
	private UserInfoService userInfoService;

	@Autowired
	private FixedThreadPoolManager fixedThreadPoolManager;
	
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
	
	@Autowired
	private PmaFperformanceToinitwfInfService pmaFperformanceToinitwfInfService;
	
	/**
	 * @函数名称:process
	 * @函数描述:批量导入工作流线程处理入口类
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void process(String funCode, String batchId, List<Map<String, Object>> instanceList, 
			List<String> pkList, String periodHisTableName, String dtlTableName, boolean isReStartWf, 
			String workFlow, BatchFixedThreadPoolManager batchFixedThreadPoolManager, String userId) {
		try {
			pmaFPerformanceBatchInfoMapper.updateCheckResultAndStatusByBatchIdAndFunCode(batchId, funCode, "", "11");
			if(batchFixedThreadPoolManager != null) {	// 页面点击-异步执行/发起审批按钮
				// 使用java自带的ThreadPoolExecutor，创建固定线程数量的线程池，解决自定义线程池等待问题
				fixedThreadPoolManager.execute(batchId, instanceList, periodHisTableName, dtlTableName, 
						isReStartWf, commonPerformanceImpMapper, pmaFPerformanceBatchInfoMapper,
						pmaFperformanceBatchResultMapper, commonDistributionService, metaFunctionManagerService, 
						null, workflowEngineService, workFlow, batchFixedThreadPoolManager, userId);
			} else if(batchFixedThreadPoolManager == null) {	// 页面点击-同步执行/发起审批按钮
				// 使用java自带的ThreadPoolExecutor，创建固定线程数量的线程池，解决自定义线程池等待问题
				fixedThreadPoolManager.execute(batchId, instanceList, periodHisTableName, dtlTableName, 
						isReStartWf, commonPerformanceImpMapper, pmaFPerformanceBatchInfoMapper,
						pmaFperformanceBatchResultMapper, commonDistributionService, metaFunctionManagerService, 
						userInfoService, workflowEngineService, workFlow, batchFixedThreadPoolManager, null);
//			if("threadPool".equals(executeMode)) {
//				// 使用java自带的ThreadPoolExecutor，创建固定线程数量的线程池，解决自定义线程池等待问题
//				fixedThreadPoolManager.execute(batchId, instanceList, periodHisTableName, dtlTableName, 
//						isReStartWf, commonPerformanceImpMapper, pmaFPerformanceBatchInfoMapper,
//						pmaFperformanceBatchResultMapper, commonDistributionService, metaFunctionManagerService, 
//						userInfoService, workflowEngineService, workFlow);
//			} else if("jobHandler".equals(executeMode)) {
//				// 新增数据到-业绩批量导入工作流待发起信息表，等待定时任务交给执行线程执行
//				pmaFperformanceToinitwfInfService.batchInsertToinitwfInf(instanceList, 
//						funCode, batchId, periodHisTableName, 
//						dtlTableName, isReStartWf + "", workFlow, 
//						userInfoService.getUserInfo().getLoginCode());
			}
		} catch(Exception e) {
			log.error("funCode:" + funCode + "; batchId:" + batchId + "; PerformanceImpThreadManager process error: ", e);
		}
	}

}
