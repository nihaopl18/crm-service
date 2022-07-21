package cn.com.yusys.yscimc.operation.resolver;


import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yscimc.operation.support.MarketPlanTaskExecutor;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.rai.engine.data.domain.ActivityPo;

public abstract class AbstractEventActivityResolver implements ComponentInfoResolver {

    @Override
    public void componentResolver(CimpCmNodeinfo nodeInfo, ComponentDataBo componentDataBo) {
        executeResolver(componentDataBo.getTaskExecutor());
    }

    /**
     * 开始活动，预加载规则，存入 redis
     * @param nodeInfo
     * @return
     */
    public abstract ActivityPo preLoadRuleInformation(CimpCmNodeinfo nodeInfo);



    /**
     * 客户触发了动作，执行活动
     * @return
     */
    public abstract void executeResolver(MarketPlanTaskExecutor taskExecutor);
}
