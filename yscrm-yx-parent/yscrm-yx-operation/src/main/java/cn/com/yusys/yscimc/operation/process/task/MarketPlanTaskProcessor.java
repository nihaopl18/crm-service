package cn.com.yusys.yscimc.operation.process.task;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.vo.CustomerInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.MarketActionInfoVo;
import cn.com.yusys.yscimc.operation.domain.vo.ProductInfoVo;
import cn.com.yusys.yscimc.operation.process.ComponentFlowProcessor;
import cn.com.yusys.yscimc.operation.process.index.IndexPlanFlowProcessor;
import cn.com.yusys.yscimc.operation.support.MarketPlanServiceExtend;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.taskcenter.domain.CimFTcTaskPool;
import cn.com.yusys.yusp.cm.taskcenter.repository.mapper.CimFTcTaskPoolMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 由于任务和营销指标没有关系，所以重新创建一个任务 processorm
 */
@Component("marketPlanTaskProcessor")
public class MarketPlanTaskProcessor implements ComponentFlowProcessor {


    private static final Logger logger = LoggerFactory.getLogger(IndexPlanFlowProcessor.class);

    private final CimFTcTaskPoolMapper taskPoolMapper;

    public MarketPlanTaskProcessor(CimFTcTaskPoolMapper taskPoolMapper) {
        this.taskPoolMapper = taskPoolMapper;
    }

    @Override
    public void process(MarketPlanTaskExecutor executor, ProcessedDataBo processedDataBo) {

        Set<CustomerInfoVo> customerInfoVoSet = processedDataBo.getCustomerInfoVoSet();

        if (customerInfoVoSet == null) {
            executor.processAndExecute(this.getNextFlow(executor.getMarketPlanServiceExtend()), processedDataBo);
        }
        else {
            List<MarketActionInfoVo> marketActionInfoVoList = processedDataBo.getMarketActionInfoVoList();

            if (marketActionInfoVoList != null){
                CimpCmMarketplan planInfo = executor.getInitialData().getPlanInfo();
                List<CimFTcTaskPool> taskPoolList = new ArrayList<>(marketActionInfoVoList.size());

                for (MarketActionInfoVo marketActionInfoVo : marketActionInfoVoList) {
                    CustomerInfoVo customerInfoVo = marketActionInfoVo.getCustomerInfoVo();
                    ProductInfoVo productInfoVo = marketActionInfoVo.getProductInfoVo();
                    // TODO 此处需要优化，不能查这么多次数据库
                    String orgName = taskPoolMapper.getOrgName(customerInfoVo.getBelongOrg());
                    String mgrName = taskPoolMapper.getMgrName(customerInfoVo.getBelongMgr());
                    CimFTcTaskPool taskPool = new CimFTcTaskPool();
                    taskPool.setActivityName(planInfo.getActivityName());
                    taskPool.setProductName(productInfoVo.getProdName());
                    taskPool.setProductId(productInfoVo.getProdName());
                    taskPool.setTaskId(this.getUUID());
                    taskPool.setTaskName(planInfo.getActivityName() + "-" + customerInfoVo.getCustName());
                    taskPool.setTaskType(marketActionInfoVo.getApplyType().equals("PRODUCT") ? "BO" : marketActionInfoVo.getApplyType());
                    taskPool.setTaskState("IMPLEMENTING");
                    taskPool.setStartTime(planInfo.getStartDate());
                    taskPool.setEndTime(planInfo.getEndDate());
                    taskPool.setTaskContent(marketActionInfoVo.getModelInfo());
                    taskPool.setCreateTime(new Date());
                    taskPool.setActivityId(planInfo.getTempId());
                    taskPool.setDutyUser(mgrName);
                    taskPool.setAllotTime(new Date());
                    taskPool.setBelongMgr(customerInfoVo.getBelongMgr());
                    taskPool.setBelongOrg(customerInfoVo.getBelongOrg());
                    taskPool.setCustId(customerInfoVo.getCustId());
                    taskPool.setCustName(customerInfoVo.getCustName());
                    taskPool.setMgrName(mgrName);
                    taskPool.setOrgName(orgName);
                    taskPoolList.add(taskPool);
                }

                taskPoolMapper.insertAll(taskPoolList);
            }
            executor.processAndExecute(this.getNextFlow(executor.getMarketPlanServiceExtend()), processedDataBo);
        }
    }

    @Override
    public ComponentFlowProcessor getNextFlow(MarketPlanServiceExtend serviceExtend) {
        return null;
    }

    private String getUUID() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }
}
