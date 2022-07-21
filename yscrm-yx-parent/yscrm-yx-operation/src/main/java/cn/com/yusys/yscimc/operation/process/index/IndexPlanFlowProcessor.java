package cn.com.yusys.yscimc.operation.process.index;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.process.ComponentFlowProcessor;
import cn.com.yusys.yscimc.operation.process.task.MarketPlanTaskProcessor;
import cn.com.yusys.yscimc.operation.support.MarketPlanServiceExtend;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import cn.com.yusys.yusp.cm.taskcenter.repository.mapper.CimFTcTaskPoolMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 营销成效指标组件的数据处理器
 * @author zhangyt12
 * @date 2021/12/22 18:38
 */
@Component("indexPlanFlowProcessor")
public class IndexPlanFlowProcessor implements ComponentFlowProcessor {

    private static final Logger logger = LoggerFactory.getLogger(IndexPlanFlowProcessor.class);

    private final CimFTcTaskPoolMapper taskPoolMapper;

    public IndexPlanFlowProcessor(CimFTcTaskPoolMapper taskPoolMapper) {
        this.taskPoolMapper = taskPoolMapper;
    }

    @Override
    public void process(MarketPlanTaskExecutor executor, ProcessedDataBo processedDataBo) {
        // TODO 活动营销指标需要保存到对应的表格中
        executor.processAndExecute(this.getNextFlow(executor.getMarketPlanServiceExtend()), processedDataBo);
    }

    @Override
    public ComponentFlowProcessor getNextFlow(MarketPlanServiceExtend serviceExtend) {
        return serviceExtend.getNextFlowProcessor(MarketPlanTaskProcessor.class);
    }

    private String getUUID() {
        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
    }
}
