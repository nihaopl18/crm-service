package cn.com.yusys.yscrm.knowledge.workflow.biz;

import cn.com.yusys.yscrm.knowledge.domain.OcrmFwpInfo;
import cn.com.yusys.yscrm.knowledge.service.OcrmFwpInfoService;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class WfiKnowledgeBizAfterProcessor  implements InstanceMessageProcessor {
    @Autowired
    private OcrmFwpInfoService ocrmFwpInfoService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private final Logger logger = LoggerFactory.getLogger(WfiKnowledgeBizAfterProcessor.class);
    @Override
    public boolean should(String message) {
        //解析 message获取流程申请类型，判断是否执行 process方法
        InstanceMessage instanceMessage = null;
        try {
            instanceMessage = objectMapper.readValue(message, InstanceMessage.class);
        } catch (JsonParseException e) {
//            e.printStackTrace();
            logger.error("获取流程实例信息失败"+e);
        } catch (JsonMappingException e) {
//            e.printStackTrace();
            logger.error("获取流程实例信息失败"+e);
        } catch (IOException e) {
//            e.printStackTrace();
            logger.error("获取流程实例信息失败"+e);
        }
        String WfSign = instanceMessage.getInstanceInfo().getWfSign();
        // 解析 message获取流程申请类型，判断是否执行 process方法
        logger.info("process message=====================>>{}", message);
        // 根据流程标识，决定此流程是否走此后业务处理
        if ("WFKNPU".equals(WfSign)) {
            logger.debug("后业务处理类命中:" + this.getClass());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public int order() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void process(String message) throws Exception {
        // TODO Auto-generated method stub
        InstanceMessage instanceMessage = objectMapper.readValue(message, InstanceMessage.class);
        String messageType = instanceMessage.getType();
        String infoId = instanceMessage.getInstanceInfo().getBizSeqNo();
        OcrmFwpInfo ocrmFwpInfo = new OcrmFwpInfo();
        if(Consts.MESSAGE_TYPE_INIT.equals(messageType)){
            logger.debug("初始化操作:"+message);
            ocrmFwpInfo.setPublishType("N-0");
            ocrmFwpInfo.setMessageId(infoId);
            ocrmFwpInfo.setInstanceId(instanceMessage.getInstanceInfo().getInstanceId());
        }else if(Consts.MESSAGE_TYPE_SUBMIT.equals(messageType)){
            logger.debug("提交操作:"+message);
            ocrmFwpInfo.setPublishType("N-1");
            ocrmFwpInfo.setMessageId(infoId);
        }else if(Consts.MESSAGE_TYPE_SIGNIN.equals(messageType)){
            logger.debug("签收操作:"+message);
        }else if(Consts.MESSAGE_TYPE_SIGNOFF.equals(messageType)){
            logger.debug("签收取消操作:"+message);
        }else if(Consts.MESSAGE_TYPE_CHANGE.equals(messageType)){
            logger.debug("转办操作:"+message);
        }else if(Consts.MESSAGE_TYPE_JUMP.equals(messageType)){
            logger.debug("跳转操作:"+message);
        }else if(Consts.MESSAGE_TYPE_END.equals(messageType)){
            logger.debug("结束操作:"+message);
            SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
            ocrmFwpInfo.setPublishDate(s.format(new Date()));
            ocrmFwpInfo.setPublishType("N");
            ocrmFwpInfo.setMessageId(infoId);
        }else if(Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
            logger.debug("退回操作:"+message);
            ocrmFwpInfo.setPublishType("N-2");
            ocrmFwpInfo.setMessageId(infoId);
        }else if(Consts.MESSAGE_TYPE_CALLBACK.equals(messageType)){
            logger.debug("打回操作:"+message);
        }else if(Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)){
            logger.debug("拿回操作:"+message);
            ocrmFwpInfo.setPublishType("N-3");
            ocrmFwpInfo.setMessageId(infoId);
        }else if(Consts.MESSAGE_TYPE_CANCEL.equals(messageType)){
            logger.debug("撤销操作:"+message);
        }else if(Consts.MESSAGE_TYPE_HANG.equals(messageType)){
            logger.debug("挂起操作:"+message);
        }else if(Consts.MESSAGE_TYPE_WAKE.equals(messageType)){
            logger.debug("唤醒操作:"+message);
        }else if(Consts.MESSAGE_TYPE_REFUSE.equals(messageType)){
            logger.debug("否决操作:"+message);
        }else{
            logger.warn("未知操作:"+message);
        }
        ocrmFwpInfoService.updatePublishData(ocrmFwpInfo);
    }
}
