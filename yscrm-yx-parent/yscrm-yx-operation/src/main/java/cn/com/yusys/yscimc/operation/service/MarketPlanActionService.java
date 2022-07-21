package cn.com.yusys.yscimc.operation.service;

import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.rai.engine.data.domain.EngMarketingEntryVo;

/**
 * @Author Lenovo
 * @Data 2021/12/7 15:55
 */
public interface MarketPlanActionService {
    /**
     * 使用营销活动 id 开始活动
     */
    String startPlanByTempId(String tempId);

    /**
     * 使用 MQ 中的数据执行事件类活动
     */
    void startPlanForEventAction(EngMarketingEntryVo entryVo);

    CimpCmMarketplan getMarkPlan(String tempId);
}
