package cn.com.yusys.yscrm.custgrade.workflow.biz;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.yusys.yscrm.custgrade.service.CustGradeManualEvalService;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;

@Component
public class WfiScoreAdjustWorkflowBizAfterProcessorForCustGrade implements InstanceMessageProcessor {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	public static final String MESSAGE_TYPE_SUBMIT = "submit"; // 提交
    public static final String MESSAGE_TYPE_RETURNBACK = "returnBack"; // 退回
    private ObjectMapper objectMapper = new ObjectMapper();
 
	/*
	 * 服务等级手工评定
	 */
	@Autowired
	private CustGradeManualEvalService CustGradeManualEvalService;
    @Override
    public boolean should(String wfSign) {
    	InstanceMessage instanceMessage = null;
		try {
			instanceMessage = objectMapper.readValue(wfSign, InstanceMessage.class);
 		} catch (JsonParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        String WfSign=instanceMessage.getInstanceInfo().getWfSign();
		//解析 message获取流程申请类型，判断是否执行 process方法
		log.info("songer进入process message="+wfSign);
		if("FWDJSGPD".equals(WfSign)){// 根据流程标识，决定此流程是否走此后业务处理
            log.debug("后业务处理类命中:"+this.getClass());
            return true;
        }
		return false;
    }

    @Override
    public int order() {
        return 0;
    }

    @Override
    public void process(String message) throws Exception {

    	InstanceMessage instanceMessage = objectMapper.readValue(message, InstanceMessage.class);
        String messageType = instanceMessage.getType();
        if(Consts.MESSAGE_TYPE_INIT.equals(messageType)){
        	log.debug("初始化操作:"+message);
        }else if(Consts.MESSAGE_TYPE_SUBMIT.equals(messageType)){
        	log.debug("提交操作:"+message);
        }else if(Consts.MESSAGE_TYPE_SIGNIN.equals(messageType)){
            log.debug("签收操作:"+message);
        }else if(Consts.MESSAGE_TYPE_SIGNOFF.equals(messageType)){
            log.debug("签收取消操作:"+message);
        }else if(Consts.MESSAGE_TYPE_CHANGE.equals(messageType)){
            log.debug("转办操作:"+message);
        }else if(Consts.MESSAGE_TYPE_JUMP.equals(messageType)){
            log.debug("跳转操作:"+message);
        }else if(Consts.MESSAGE_TYPE_END.equals(messageType)){
        	log.debug("结束操作:"+message);
//        	InstanceMessage instanceMessage = objectMapper.readValue(message, InstanceMessage.class);
//          String messageType = instanceMessage.getType();
          String BizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
          String WfStatus=instanceMessage.getInstanceInfo().getWfStatus();
          String WfSign=instanceMessage.getInstanceInfo().getWfSign();
          CustGradeManualEvalService.apply(BizSeqNo, "2");
        }else if(Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
            log.debug("退回操作:"+message);
        }else if(Consts.MESSAGE_TYPE_CALLBACK.equals(messageType)){
            log.debug("打回操作:"+message);
        }else if(Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)){
        }else if(Consts.MESSAGE_TYPE_CANCEL.equals(messageType)){
            log.debug("撤销操作:"+message);
        }else if(Consts.MESSAGE_TYPE_HANG.equals(messageType)){
            log.debug("挂起操作:"+message);
        }else if(Consts.MESSAGE_TYPE_WAKE.equals(messageType)){
            log.debug("唤醒操作:"+message);
        }else if(Consts.MESSAGE_TYPE_REFUSE.equals(messageType)){
        	log.debug("拒绝操作:"+message);
            String BizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
        	  CustGradeManualEvalService.apply(BizSeqNo, "3");
        }else{
            log.warn("未知操作:"+message);
        }
    }
}
