package cn.com.yusys.climp.qypool.workFlow;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.yusys.climp.qypool.repository.mapper.LoyQyCommodityInfoMapper;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;

@Component
public class WfiCommodityInfoWorkflowBizAfterProcessor implements InstanceMessageProcessor {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private LoyQyCommodityInfoMapper mapper;
//    @Autowired
//    private UserInfoService userInfoService;
    
    // 000待发起，111审批中，997通过，998否决
    // private final static String PENDING_STS = "000";
    private final static String APPROVAL_STS = "111";
    private final static String PASS_STS = "997";
    private final static String VETO_STS = "998";
    
    @Override
    public boolean should(String wfSign) {
    	Map<String,Object> info=JSON.parseObject(wfSign,Map.class);
    	Map<String,Object> instence=JSON.parseObject(info.get("instanceInfo").toString(),Map.class);
        if("LPTJSPLC".equals(instence.get("wfSign"))){
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
    public void process(String message) throws Exception { InstanceMessage instanceMessage = objectMapper.readValue(message, InstanceMessage.class);
    String messageType = instanceMessage.getType();
    if(Consts.MESSAGE_TYPE_INIT.equals(messageType)){
        log.debug("初始化操作:"+message);
    }else if(Consts.MESSAGE_TYPE_SUBMIT.equals(messageType)){
        log.debug("提交操作:"+message);
        try {
        	String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
        	Map<String,String>params = new HashMap<String,String>();
        	params.put("id", bizSeqNo);
        	// WF_APPR_STS 审批状态设为审批中
        	params.put("sts", APPROVAL_STS); 
        	mapper.editGiftWorkflow(params);
        }catch(Exception e){
        	e.printStackTrace();
        	log.error("工作流[{}]业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
        }
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
        try {
        	String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
        	Map<String,String>params = new HashMap<String,String>();
        	params.put("id", bizSeqNo);
        	// WF_APPR_STS 审批状态设为同意
        	params.put("sts", PASS_STS); 
        	mapper.editGiftWorkflow(params);
        }catch(Exception e){
        	e.printStackTrace();
        	log.error("工作流[{}]业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
        }
    }else if(Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
        log.debug("退回操作:"+message);
    }else if(Consts.MESSAGE_TYPE_CALLBACK.equals(messageType)){
        log.debug("打回操作:"+message);
    }else if(Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)){
        log.debug("拿回操作:"+message);
    }else if(Consts.MESSAGE_TYPE_CANCEL.equals(messageType)){
        log.debug("撤销操作:"+message);
    }else if(Consts.MESSAGE_TYPE_HANG.equals(messageType)){
        log.debug("挂起操作:"+message);
    }else if(Consts.MESSAGE_TYPE_WAKE.equals(messageType)){
        log.debug("唤醒操作:"+message);
    }else if(Consts.MESSAGE_TYPE_REFUSE.equals(messageType)){
        log.debug("否决操作:"+message);
        try {
        	String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
        	Map<String,String>params = new HashMap<String,String>();
        	params.put("id", bizSeqNo);
        	// WF_APPR_STS 审批状态设为否决
        	params.put("sts", VETO_STS); 
        	mapper.editGiftWorkflow(params);
        }catch(Exception e){
        	log.error("工作流[{}]否决业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
        }
    }else{
        log.warn("未知操作:"+message);
    }
    }
}
