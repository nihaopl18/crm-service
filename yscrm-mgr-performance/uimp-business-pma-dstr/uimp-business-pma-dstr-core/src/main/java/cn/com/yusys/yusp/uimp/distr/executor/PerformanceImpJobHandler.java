package cn.com.yusys.yusp.uimp.distr.executor;//package cn.com.yusys.yusp.uimp.distr.executor;
//
//import java.util.List;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import cn.com.yusys.yusp.commons.job.core.biz.model.ReturnT;
//import cn.com.yusys.yusp.commons.job.core.handler.IJobHandler;
//import cn.com.yusys.yusp.commons.job.core.handler.annotation.JobHandler;
//import cn.com.yusys.yusp.uimp.distr.thread.pool.FixedThreadPoolManager;
//
///**
// * @项目名称: uimp-business-pma-dstr-core模块
// * @类名称: PerformanceImpJobHandler
// * @类描述: # 业绩批量导入-发起工作流-任务执行器
// * @功能描述: 
// * @创建人: lixt1
// * @创建时间: 2020-10-22 15:29:02
// * @修改备注: 
// * @修改记录: 修改时间    修改人员    修改原因
// * -------------------------------------------------------------
// * @version 1.0.0
// * @Copyright (c) 2017宇信科技-版权所有
// */
//@Service
//@JobHandler(value="performanceImp")
//public class PerformanceImpJobHandler extends IJobHandler {
//	
//	private static final Logger log = LoggerFactory.getLogger(PerformanceImpJobHandler.class);
//
//	@Autowired
//	private FixedThreadPoolManager fixedThreadPoolManager;
//	
//	/**
//	 * @函数名称:execute
//	 * @函数描述:定时执行，获取待发起工作流的applyId，交给线程池处理
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	@Override
//	public ReturnT<String> execute(String arg0) throws Exception {
//		try {
//			log.info("start jobhandler performanceImp");
//			// 1、获取待发起的applyIds，并放入applyIdsMap
//			List<String> applyIds = fixedThreadPoolManager.putApplyIdsToApplyIdsMap();
//			// 2、将applyIds交给fixedThreadPoolManager执行
//			if(applyIds.size() > 0) {
//				fixedThreadPoolManager.executeByApplyIds(applyIds);
//			}
//			log.info("complete jobhandler performanceImp, execute applyIds.size:" + applyIds.size());
//			if(log.isDebugEnabled()) {
//				log.debug(applyIds.size() == 0 ? "execute applyIds.size is zero" : "execute applyIds is: " + String.join(",", applyIds));
//			}
//		} catch(Exception e) {
//			log.error("execute jobhandler error: ", e);
//		}
//		return null;
//	}
//
//}
