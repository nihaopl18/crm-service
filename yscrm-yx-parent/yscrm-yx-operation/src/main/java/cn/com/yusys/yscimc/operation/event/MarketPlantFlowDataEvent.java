package cn.com.yusys.yscimc.operation.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * 整个活动执行过程信息存储类
 * @author zhangyt12
 * @date 2021/12/14 18:31
 */
public class MarketPlantFlowDataEvent extends ApplicationEvent {

    /**
     * 该属性传递以下内容：
     *
     * 开始执行的信息         startMessage
     * 正在执行的组件名称      executingComponentName
     * 执行的内容反馈          executingContent
     * 执行结束信息            endMessage
     * 活动停止的原因           errorMessage
     */
    private final List<String> flowMessageList;

    public MarketPlantFlowDataEvent(Object source, String flowMessage) {
        super(source);
        this.flowMessageList = new ArrayList<>(3);
        flowMessageList.add(flowMessage);
    }

    public MarketPlantFlowDataEvent(Object source, List<String> flowMessageList) {
        super(source);
        this.flowMessageList = flowMessageList;
    }

    public List<String> getFlowMessageList() {
        return flowMessageList;
    }
}
