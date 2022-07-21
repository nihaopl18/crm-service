package cn.com.yusys.yscimc.operation.listener;

import cn.com.yusys.yscimc.operation.event.MarketPlantFlowDataEvent;
import org.springframework.context.ApplicationListener;

import java.util.List;

/**
 * @Author Lenovo
 * @Data 2021/12/14 19:13
 */
public class MarketPlanFlowListener implements ApplicationListener<MarketPlantFlowDataEvent> {

    @Override
    public void onApplicationEvent(MarketPlantFlowDataEvent flowDataEvent) {
        //逻辑处理
        List<String> flowMessageList = flowDataEvent.getFlowMessageList();
    }
}
