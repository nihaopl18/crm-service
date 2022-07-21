package com.yusys.streaminghub.app.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusys.streaminghub.app.info.ReceiptsState;
import com.yusys.streaminghub.app.service.IReceiptsStateService;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//同时创建或更新redis中收单状态和发送kafka订单状态更新命令
@Service
@PropertySource(value = "classpath:kafka.properties")
public class ReceiptsStateService implements IReceiptsStateService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Value("${kafka.topic.update_states}")
    String topic;


    @Override
    public void updateState(String state, String message, String receiptId, Object data) throws JsonProcessingException {
        //redis
        //kafka
        String jdata = new ObjectMapper().writeValueAsString(data);
        updateStateJsonData(state,message,receiptId,jdata);
    }

    @Override
    public void updateStateJsonData(String state, String message, String receiptId, String jdata) throws JsonProcessingException {
        ReceiptsState receiptsState = new ReceiptsState(state,message,receiptId,jdata);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(receiptsState);
        ProducerRecord<String, String> producerRecord =
                new ProducerRecord<>(topic, receiptId, json);
        kafkaTemplate.send(producerRecord);
    }
}
