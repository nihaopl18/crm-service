package com.yusys.streaminghub.app.kafka;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusys.streaminghub.app.info.ReceiptsInfo;
import com.yusys.streaminghub.app.info.RequestInfo;
import com.yusys.streaminghub.app.service.IAccessTokenManager;
import com.yusys.streaminghub.app.service.IReceiptsCacher;
import com.yusys.streaminghub.app.service.IReceiptsStateService;
import com.yusys.streaminghub.app.service.ISpringMappingRegistry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Service
@PropertySource(value = "classpath:kafka.properties")
public class ReceiptsConsumer {
    static Log logger = LogFactory.getLog(ReceiptsConsumer.class);
    @Autowired
    WebApplicationContext applicationContext;
    @Autowired
    ISpringMappingRegistry springMappingRegistry;
    @Autowired
    IReceiptsStateService receiptsStateService;
    @Autowired
    IReceiptsCacher receiptsCacher;
    @Autowired
    IAccessTokenManager accessTokenManager;
    //单条消费，手动提交enable-auto-commit=false
    //一定要指定clientid前缀，否则会报已存在实现的警告.在消费者声明的注解中必须指定客户端前缀且多个消费者不行相同
    @KafkaListener(groupId = "${kafka.groupid}", clientIdPrefix = "receipts", topics = "${kafka.topic.receipts}")
    public void consumeMessage(ConsumerRecord<String, String> record, Acknowledgment acknowledgment) throws Throwable {
        String json = record.value();
        ObjectMapper mapper = new ObjectMapper();
        ReceiptsInfo info = null;
        try {
            info = mapper.readValue(json, ReceiptsInfo.class);
            accessTokenManager.initAccessToken(info.getRequest());
            receiptsStateService.updateState("202", "准备执行", info.getId(), null);
            //TODO: 如果判断查询的参数值与缓冲结果的参数值相同，则直接返回缓冲结果。此处未来实现
            //TODO: 检查参数值和缓冲结果，如果匹配则直接返回结果，则跳过作业查询
            //TODO: 算法：参数先排序，然后MD5，以此为串去查结果是否缓冲存在
            //执行作业进行一次新查询
            boolean cached = info.getRequest().isCached();
            if (cached && receiptsCacher.hasData(info.getRequest())) {
                String retJData = receiptsCacher.getData(info.getRequest());
                receiptsStateService.updateStateJsonData("203", "执行完毕", info.getId(), retJData);
                logger.info(String.format("kafka消费者成功调用mapping方法！%s, 结果:%s", info.getRequest(), retJData));
            } else {
                Object retObj = execMethod(info);
                if (retObj instanceof ResultDto) {
                    ResultDto dto=(ResultDto) retObj;
                    retObj=dto.getData();
                }
                receiptsStateService.updateState("203", "执行完毕", info.getId(), retObj);
                logger.info(String.format("kafka消费者成功调用mapping方法！%s, 结果:%s", info.getRequest(), retObj));
            }
        } catch (Exception e) {
            Throwable throwable = e;
            if (e instanceof InvocationTargetException) {
                InvocationTargetException invocationTargetException = (InvocationTargetException) e;
                throwable = invocationTargetException.getTargetException();
            }
            logger.error(throwable);
            receiptsStateService.updateState("300", "执行出错", info.getId(), throwable.getMessage());
        } finally {
            acknowledgment.acknowledge();
        }
    }


    private Object execMethod(ReceiptsInfo receiptsInfo) throws Throwable {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        //        mapping.match()
        RequestInfo requestInfo = receiptsInfo.getRequest();
        List<HandlerMethod> handlerMethodList = springMappingRegistry.searchMethodHandler(requestInfo.getUrl(), mapping);
        Object obj = springMappingRegistry.invoke(handlerMethodList, requestInfo);
        return obj;
    }
}
