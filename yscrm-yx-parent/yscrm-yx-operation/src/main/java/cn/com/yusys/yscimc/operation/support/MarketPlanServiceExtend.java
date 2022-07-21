package cn.com.yusys.yscimc.operation.support;

import cn.com.yusys.yscimc.operation.process.ChannelProcessor;
import cn.com.yusys.yscimc.operation.process.ComponentFlowProcessor;
import cn.com.yusys.yscimc.operation.process.ContentDataProcessor;
import cn.com.yusys.yscimc.operation.process.customer.CustomerFlowProcessor;
import cn.com.yusys.yscimc.operation.resolver.ComponentInfoResolver;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lenovo
 * @Data 2021/12/9 15:09
 */
@Component
public class MarketPlanServiceExtend implements ApplicationContextAware, ApplicationEventPublisherAware {

    // 渠道执行器（手机银行，短信，微信组件信息存储）
    private final List<ChannelProcessor> channelProcessorList = new ArrayList<>(16);
    // 活动信息解析器
    private final List<ComponentInfoResolver> componentInfoResolverList = new ArrayList<>(16);
    // 活动数据流程处理器
    private final List<ComponentFlowProcessor> flowProcessorList = new ArrayList<>(16);
    // 活动内容数据处理器
    private final List<ContentDataProcessor> contentDataProcessorList = new ArrayList<>(16);
    // 事件发布器
    public ApplicationEventPublisher eventPublisher;

    /**
     * 获取活动配置的组件的解析器集合
     * @param typeList
     * @return
     */
    public List<ComponentInfoResolver> getResolverListByType(List<String> typeList) {
        List<ComponentInfoResolver> resolverList = new ArrayList<>(16);
        for (ComponentInfoResolver resolver : componentInfoResolverList) {
            if (typeList.contains(resolver.getType())) {
                resolverList.add(resolver);
            }
        }
        return resolverList;
    }

    /**
     * 返回第一个执行的组件数据处理器：客户类型组件数据处理器
     * @return
     */
    public final ComponentFlowProcessor getFirstProcessor() {
        ComponentFlowProcessor processor = null;
        for (ComponentFlowProcessor dataProcessor : flowProcessorList) {
            if (dataProcessor instanceof CustomerFlowProcessor) {
                processor = dataProcessor;
                break;
            }
        }
        return processor;
    }

    public List<ChannelProcessor> getChannelProcessor(List<String> typeList) {
        List<ChannelProcessor> processorList = new ArrayList<>(8);
        for (ChannelProcessor processor : this.channelProcessorList) {
            if (typeList.contains(processor.getType())) {
                processorList.add(processor);
            }
        }
        return processorList;
    }

    public ApplicationEventPublisher getEventPublisher() {
        return eventPublisher;
    }

    public List<ContentDataProcessor> getContentDataProcessorList() {
        return this.contentDataProcessorList;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 注入所有的【组件解析器】
        componentInfoResolverList.addAll(applicationContext.getBeansOfType(ComponentInfoResolver.class).values());
        // 注入所有的【渠道执行器】
        channelProcessorList.addAll(applicationContext.getBeansOfType(ChannelProcessor.class).values());
        // 注入所有的【组件数据流程处理器】
        flowProcessorList.addAll(applicationContext.getBeansOfType(ComponentFlowProcessor.class).values());
        // 注入所有的【活动内容数据处理器】
        contentDataProcessorList.addAll(applicationContext.getBeansOfType(ContentDataProcessor.class).values());
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.eventPublisher = applicationEventPublisher;
    }

    public final ComponentFlowProcessor getNextFlowProcessor(Class<?> clazz) {
        // processor 排序
        ComponentFlowProcessor processor = null;
        for (ComponentFlowProcessor componentFlowProcessor : flowProcessorList) {
            if (componentFlowProcessor.getClass().getSimpleName().equals(clazz.getSimpleName())) {
                processor = componentFlowProcessor;
                break;
            }
        }
        return processor;
    }
}