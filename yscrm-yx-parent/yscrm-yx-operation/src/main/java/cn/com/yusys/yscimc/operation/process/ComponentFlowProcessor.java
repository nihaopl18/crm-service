package cn.com.yusys.yscimc.operation.process;

import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.support.MarketPlanServiceExtend;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;

/**
 * 组件数据解析器
 * @author zhangyt12
 * @date 2021/12/13 16:10
 */
public interface ComponentFlowProcessor {
    /**
     * 处理组件解析出的信息，返回渠道执行器需要的数据
     * @param executor
     * @param processedDataBo
     * @return
     */
    void process(MarketPlanTaskExecutor executor, ProcessedDataBo processedDataBo);

    /**
     * 返回下一个执行的组件数据处理器
     * @return
     */
    ComponentFlowProcessor getNextFlow(MarketPlanServiceExtend serviceExtend);
}
