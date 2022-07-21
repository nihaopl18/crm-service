package cn.com.yusys.yscimc.operation.service.impl;

import cn.com.yusys.yscimc.operation.domain.ActivityEventResultEntity;
import cn.com.yusys.yscimc.operation.service.ActivityEventResultService;
import cn.com.yusys.yscimc.operation.service.MarketEventService;
import cn.com.yusys.yscimc.operation.service.MarketPlanActionService;
import cn.com.yusys.yusp.rai.engine.data.domain.ActionPo;
import cn.com.yusys.yusp.rai.engine.data.domain.EngMarketingEntryVo;
import cn.com.yusys.yusp.rai.engine.data.domain.RaiCalculationRequMsgVo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author Lenovo
 * @Data 2022/2/23 14:07m
 */
//@Service("marketEventService")
//public class MarketEventServiceImpl implements MarketEventService {
//
//    private static final String BATCH_EVENT_EXCHANGE_NAME = "yscimc-batch-event-Activity";
//    private static final String BATCH_SEND_QUEUE_NAME = "yscimc-batch-event-Activity";
//    private static final String BATCH_ROUTING_KEY = "yscimc.batch.event.Activity";
//
//    private static final String REAL_EVENT_EXCHANGE_NAME = "";
//    private static final String REAL_SEND_QUEUE_NAME = "";
//    private static final String REAL_ROUTING_KEY = "";
//
//    private static final String SEND_QUEUE_NAME_TEXT = "yusp_intf.RAI_MARKETING_TEST";
//    private static final String LISTEN_QUEUE_NAME = "yusp_intf.RAI_MARKETING_ENTRY_TEST_1";
//
//    private final Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
//
//    @Autowired
//    private AmqpAdmin amqpAdmin;
//
////    @Autowired
////    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    private MarketPlanActionService marketPlanActionService;
//
//    @Autowired
//    private ActivityEventResultService activityEventResultService;
//
//    @PostConstruct
//    public void initMQTest() {
//        // true：是否持久化； false：是否自动删除
//        Exchange exchange = new DirectExchange(BATCH_EVENT_EXCHANGE_NAME, true, false);
//        amqpAdmin.declareExchange(exchange);
//        // true：是否持久化； false：是不是排他的队列； false：是否自动删除
//        Queue queue = new Queue(BATCH_SEND_QUEUE_NAME, true, false, false);
//        amqpAdmin.declareQueue(queue);
//        /**
//         * String destination：目的地，可以是 exchange 也可以是 queue
//         * Binding.DestinationType destinationType：目的地类型 exchange | queue
//         * String exchange：交换机
//         * String routingKey：路由键
//         * Map<String, Object> arguments：自定义参数
//         */
//        Binding binding = new Binding(BATCH_SEND_QUEUE_NAME, Binding.DestinationType.QUEUE, BATCH_EVENT_EXCHANGE_NAME, BATCH_ROUTING_KEY, null);
//        amqpAdmin.declareBinding(binding);
//    }
//
//    /**
//     * 实时事件
//     * @param jsonData
//     */
//    @Override
//    public void realTimeEvent(String jsonData) {
//
//        // 1. 解析 json 数据；
//        HashMap<String, Object> reqData = gson.fromJson(jsonData, HashMap.class);
//
//        RaiCalculationRequMsgVo<HashMap<String, Object>> msgVo = new RaiCalculationRequMsgVo<>();
//        msgVo.setContent(reqData);
//
//        // 2. 将数据保存到表中
//        ActivityEventResultEntity resultEntity = new ActivityEventResultEntity();
//        resultEntity.setId(this.getUUID());
//        resultEntity.setOutTradeNo((String) reqData.get("outTradeNo"));
//        resultEntity.setChannelCode((String) reqData.get("channel_Code"));
//        resultEntity.setCorpNo((String) reqData.get("corpNo"));
//        resultEntity.setCustomerId((String) reqData.get("custId"));
//        resultEntity.setReqTime((String) reqData.get("req_Time"));
//        activityEventResultService.saveResultEntity(resultEntity);
//
//        // 3. 使用 RabbitMQ 将消息发送出去;
////        rabbitTemplate.convertAndSend(SEND_QUEUE_NAME_TEXT, msgVo);
//    }
//
//    /**
//     * 批量事件
//     * @param jsonData
//     */
//    @Override
//    public void batchTaskEvent(String jsonData) {
//        // 1. 解析 json 数据；
//        HashMap<String, Object> reqData = gson.fromJson(jsonData, HashMap.class);
//
//        // 2. 使用 RabbitMQ 将消息发送出去;
////        rabbitTemplate.convertAndSend(BATCH_EVENT_EXCHANGE_NAME, BATCH_ROUTING_KEY, reqData);
//    }
//
////    @RabbitListener(queues = {LISTEN_QUEUE_NAME})
//    public void receiveMessage(Message message, EngMarketingEntryVo entryVo, Channel channel) {
//        try {
//            ActivityEventResultEntity resultEntity = activityEventResultService.getByOutTradeNo(entryVo.getOutTradeNo());
//            // 2. resultEntity 不为 null 表示当前活动为 实时类型事件，批量事件不用保存此处的数据
//            if (resultEntity != null) {
//                for (ActionPo actionPo : entryVo.getActionPoList()) {
//                    ActivityEventResultEntity resultEntityInsert = new ActivityEventResultEntity();
//                    resultEntityInsert.setId(this.getUUID());
//                    resultEntityInsert.setOutTradeNo(entryVo.getOutTradeNo());
//                    resultEntityInsert.setChannelCode(resultEntity.getChannelCode());
//                    resultEntityInsert.setCorpNo(entryVo.getCorpNo());
//                    resultEntityInsert.setCustomerId(entryVo.getCustId());
//                    resultEntityInsert.setActivityId(actionPo.getActId());
//                    resultEntityInsert.setReqTime(resultEntity.getReqTime());
//                    // 实时类型事件不用保存 transCode
//                    activityEventResultService.saveResultEntity(resultEntityInsert);
//                }
//                // 将原有的数据删除，保证数据准确性
//                activityEventResultService.delete(resultEntity);
//            }
//            marketPlanActionService.startPlanForEventAction(entryVo);
////            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        } catch (Exception e) {
//            e.printStackTrace();
////            try {
////                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
////            } catch (IOException ioException) {
////                ioException.printStackTrace();
////            }
//        }
//    }
//
//    /**
//     * 自增UUID
//     */
//    private String getUUID() {
//        return UUID.randomUUID().toString().toLowerCase().replace("-", "");
//    }
//}
