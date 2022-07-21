package cn.com.yusys.yscimc.operation.support;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;
import cn.com.yusys.yscimc.operation.domain.bo.ComponentDataBo;
import cn.com.yusys.yscimc.operation.domain.bo.EventTypeDataBo;
import cn.com.yusys.yscimc.operation.domain.bo.MarketPlanInitialDataBo;
import cn.com.yusys.yscimc.operation.domain.bo.ProcessedDataBo;
import cn.com.yusys.yscimc.operation.domain.dto.MarketPlanResultDto;
import cn.com.yusys.yscimc.operation.event.MarketPlantFlowDataEvent;
import cn.com.yusys.yscimc.operation.process.ChannelProcessor;
import cn.com.yusys.yscimc.operation.process.ComponentFlowProcessor;
import cn.com.yusys.yscimc.operation.resolver.ComponentInfoResolver;
import cn.com.yusys.yscimc.operation.service.ActivityStatisticsService;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 营销任务执行器
 * @author zhangyt12
 * @date 2021/12/8 16:17
 */
public class MarketPlanTaskExecutor {

    private static final Logger log = LoggerFactory.getLogger(MarketPlanTaskExecutor.class);

    // 活动执行所需的初始信息（活动信息与节点信息）
    private final MarketPlanInitialDataBo initialDataBo;

    // 组件 processor 的整合类（渠道执行器，组件解析器，数据流程处理器，内容数据处理器，事件发布器）
    private final MarketPlanServiceExtend marketPlanServiceExtend;

    // 活动所有节点的类型
    private final List<String> typeList;

    // 组件解析数据承载类
    private final ComponentDataBo componentDataBo = new ComponentDataBo(this);

    private final ActivityStatisticsService activityStatisticsService;

    // 当系统从 MQ 中获取到数据时，会将数据放入该对象中；
    private EventTypeDataBo eventTypeDataBo;

    // 提供给事件类活动使用；
    private ProcessedDataBo processedDataBo;

    public MarketPlanTaskExecutor(MarketPlanInitialDataBo initialDataBo, MarketPlanServiceExtend marketPlanServiceExtend, ActivityStatisticsService activityStatisticsService) {
        this.initialDataBo = initialDataBo;
        this.marketPlanServiceExtend = marketPlanServiceExtend;
        this.activityStatisticsService = activityStatisticsService;
        // 获取组件节点类型列表
        this.typeList = initialDataBo.getNodesList().stream().map(CimpCmNodeinfo::getAssemblyId).collect(Collectors.toList());
    }

    /**
     * 活动执行对外暴露的方法
     * @return
     */
    public final void start() {

        if (CollectionUtils.isEmpty(initialDataBo.getNodesList())) {
            log.warn("活动日志-活动执行失败，没有配置任何组件...");
            throw new RuntimeException("活动日志-活动执行失败，没有配置任何组件...");
        }

        log.info("活动日志-第八步，活动正式开始执行了！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！");

        // TODO 发布事件，当前活动开始执行
        publishFlowMessage("活动开始执行...");

        // 解析组件，获取组件数据，存到 ComponentDataBo 对象中
        getComponentInfo();

        // TODO 进行校验，同时自定义异常并抛出对应异常，并修改活动执行结果；

        for (String type : typeList) {
            if (type.equals(ComponentTypeEnum.BATCH_EVENT_ACTIVITY.getComponentType()) && eventTypeDataBo == null) {
                log.info("活动日志-第十一步，事件类活动已开启--------------：{}", initialDataBo.getPlanInfo().getActivityName());
                return ;
            }
        }

        activityStatisticsService.saveActAddrForActId(initialDataBo.getPlanInfo().getTempId());

        // 发布事件，组件信息解析完毕，即将开始处理组件信息
        publishFlowMessage("组件信息解析完毕，即将开始处理组件信息。");

        // 使用 typeList 获取第一个执行的数据处理器
        ComponentFlowProcessor processor = marketPlanServiceExtend.getFirstProcessor();

        // 处理组件解析出来的数据，并调用渠道执行器执行
        log.info("活动日志-第十二步，准备开始执行 processor ！");
        this.processAndExecute(processor, processedDataBo);

        log.info("活动执行结束--------------------------------------------------------------------------------");
    }

    /**
     * 组件数据处理器递归处理解析出来的数据，然后，调用渠道执行器执行
     * @param processor 数据流程处理器
     * @param processedDataBo 承载处理好的数据
     * @return
     */
    public List<MarketPlanResultDto> processAndExecute(ComponentFlowProcessor processor, ProcessedDataBo processedDataBo) {
        List<MarketPlanResultDto> marketPlanResultDtoList = new ArrayList<>();
        // 如果执行器不为 null，继续执行下一个执行器
        if (processor != null) {
            log.info("活动日志-第十二步，当前执行的 processr：{}， 当前 ProcessedDataBo 中的数据：{}", processor, processedDataBo);
            processor.process(this, processedDataBo);
        } else {
            // 如果 processor 为 null，表示所有的处理器都执行完毕了，开始执行渠道执行器，并返回 MarketPlanResultDto 活动执行结果；
            log.info("活动日志-第十三步，即将开始执行 ChannelProcessor");
            processedDataBo.setComponentDataBo(componentDataBo);
            List<ChannelProcessor> channelProcessorList = getMarketPlanServiceExtend().getChannelProcessor(this.typeList);
            for (ChannelProcessor channelProcessor : channelProcessorList) {
                log.info("活动日志-第十四步，当前执行的 ChannelProcessor：{}", channelProcessor);
                marketPlanResultDtoList.add(channelProcessor.execute(processedDataBo));
            }
        }
        return marketPlanResultDtoList;
    }

    /**
     * for 循环解析出所有组件的信息，存放到 componentDataBo 类中
     */
    private void getComponentInfo() {
        log.info("活动日志-第九步，开始执行 resolver 组件数据解析器...");
        List<ComponentInfoResolver> infoResolverList = marketPlanServiceExtend.getResolverListByType(this.typeList);
        for (ComponentInfoResolver resolver : infoResolverList) {
            CimpCmNodeinfo nodeInfo = initialDataBo.composeData(resolver.getType());
            resolver.componentResolver(nodeInfo, componentDataBo);
        }
        log.info("活动日志-第十步，resolver 组件解析完毕，查看 resolver 解析出的数据：{}", componentDataBo);
    }

    /**
     * 发布单条活动消息
     * @param message
     */
    private void publishFlowMessage(String message) {
        this.marketPlanServiceExtend.getEventPublisher().publishEvent(new MarketPlantFlowDataEvent(initialDataBo.getPlanInfo(), message));
    }

    /**
     * 发布单条活动消息
     * @param messageList
     */
    private void publishFlowMessage(List<String> messageList) {
        this.marketPlanServiceExtend.getEventPublisher().publishEvent(new MarketPlantFlowDataEvent(initialDataBo.getPlanInfo(), messageList));
    }


    public MarketPlanServiceExtend getMarketPlanServiceExtend() {
        return marketPlanServiceExtend;
    }

    public MarketPlanInitialDataBo getInitialData() {
        return initialDataBo;
    }

    public ComponentDataBo getComponentDataBo() {
        return componentDataBo;
    }

    public EventTypeDataBo getEventTypeDataBo() {
        return eventTypeDataBo;
    }

    public void setEventTypeDataBo(EventTypeDataBo eventTypeDataBo) {
        this.eventTypeDataBo = eventTypeDataBo;
    }

    public ProcessedDataBo getProcessedDataBo() {
        return processedDataBo;
    }

    public void setProcessedDataBo(ProcessedDataBo processedDataBo) {
        this.processedDataBo = processedDataBo;
    }
}
