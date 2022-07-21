package cn.com.yusys.climp.acct.workflow.biz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.yusys.climp.acct.service.AccountManagerService;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;

@Component
public class WfiScoreAcctWorkflowBizAfterProcessor implements InstanceMessageProcessor {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private AccountManagerService accountManagerService;

    @Override
    public boolean should(String wfSign) {
        if("SCACCT".equals(wfSign)){
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
            String bizSeqNo = "";
            try {
            	//获取当前节点ID
            	String nodeId = instanceMessage.getInstanceInfo().getNodeId();
            	//获取节点名称
            	String nodeName = instanceMessage.getInstanceInfo().getNodeName();
            	//结束节点的nodeId值目前工作流版本有问题，取不到值，先用节点名称=“结束”进行判断
            	if("结束".equals(nodeName)){//流程结束节点
            		bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
            		log.debug("E==========bizSeqNo:[{}]", bizSeqNo);
            		accountManagerService.updateStsSs(bizSeqNo);
            	}
            }catch(Exception e){
            	log.error("工作流[{}]提交/审批业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
            	log.error("业务主键["+bizSeqNo+"]退回业务逻辑处理出错", e);
            	//TODO 业务逻辑异常处理
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
        }else if(Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
            log.debug("退回操作:"+message);
            String bizSeqNo = "";
            try {
	            //前端页面传递的流程主键
	    		bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
	    		accountManagerService.updateStsBack(bizSeqNo);
            }catch(Exception e){
            	log.error("工作流[{}]退回业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
            	log.error("业务主键["+bizSeqNo+"]退回业务逻辑处理出错", e);
            	//TODO 业务逻辑异常处理
            }
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
        }else{
            log.warn("未知操作:"+message);
        }
    }
}
