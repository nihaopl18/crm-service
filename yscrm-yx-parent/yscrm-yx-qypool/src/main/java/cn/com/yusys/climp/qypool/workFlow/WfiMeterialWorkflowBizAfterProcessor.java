package cn.com.yusys.climp.qypool.workFlow;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.yusys.climp.qypool.repository.mapper.LoyQyMaterialListMapper;
import cn.com.yusys.climp.qypool.service.UserInfoService;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;

@Component
public class WfiMeterialWorkflowBizAfterProcessor implements InstanceMessageProcessor {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    private ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private LoyQyMaterialListMapper meterialmapper;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    public boolean should(String wfSign) {
    	Map<String,Object> info=JSON.parseObject(wfSign,Map.class);
    	Map<String,Object> instence=JSON.parseObject(info.get("instanceInfo").toString(),Map.class);
        if("SCGLSPLC".equals(instence.get("wfSign"))){
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
        Map<String, Object> map = new HashMap<String,Object>();
        String loginCode = SecurityUtils.getCurrentUserLogin();
        try {
        	//获取当前节点ID
        	String nodeId = instanceMessage.getInstanceInfo().getNodeId();
        	String appId = instanceMessage.getInstanceInfo().getAppId();
        	String nodeName = instanceMessage.getInstanceInfo().getNodeName();
        	String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
        	//提交领导审核
        	if("55_a4".equals(nodeId)){
            	//前端页面传递的流程主键
        		if(appId.equals("SCGLSPLC")) {
        			map.put("id", bizSeqNo);
        			map.put("materialSts", "2");
        			map.put("updateUser", loginCode);
        			map.put("updateOrg", userInfoService.getLoginCode());
        			map.put("updateDate", new Date());
        			meterialmapper.setMaterialSts(map);
        		}
        	}
        	//结束节点的nodeId值目前工作流版本有问题，取不到值，先用节点名称=“结束”进行判断
        	if("结束".equals(nodeName)){//流程结束节点
	        	if(appId.equals("SHGL")) {
	        		
	    		}else if(appId.equals("SHGLBATCH")) {//批量提交审批
	    			
	    		}
        	}
        }catch(Exception e){
        	e.printStackTrace();
        	log.error("工作流[{}]业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
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
        Map<String, Object> map = new HashMap<String,Object>();
        String loginCode = SecurityUtils.getCurrentUserLogin();
        try {
        	String nodeName = instanceMessage.getInstanceInfo().getNodeName();
        	String appId = instanceMessage.getInstanceInfo().getAppId();
        	String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
        	
        	//结束节点的nodeId值目前工作流版本有问题，取不到值，先用节点名称=“结束”进行判断
        	if("结束".equals(nodeName)){//流程结束节点
        		if(appId.equals("SCGLSPLC")) {
        			map.put("id", bizSeqNo);
        			map.put("materialSts", "3");
        			map.put("updateUser", loginCode);
        			map.put("updateOrg", userInfoService.getLoginCode());
        			map.put("updateDate", new Date());
        			meterialmapper.setMaterialSts(map);
        		}
        	}
        }catch(Exception e){
        	e.printStackTrace();
        	log.error("工作流[{}]业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
        	//TODO 业务逻辑异常处理
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
        Map<String, Object> map = new HashMap<String,Object>();
        String loginCode = SecurityUtils.getCurrentUserLogin();
        try {
        	//获取当前节点ID
        	String appId = instanceMessage.getInstanceInfo().getAppId();
        	String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
        	//前端页面传递的流程主键
        	if(appId.equals("SCGLSPLC")) {
    			map.put("id", bizSeqNo);
    			map.put("materialSts", "4");
    			map.put("updateUser", loginCode);
    			map.put("updateOrg", userInfoService.getLoginCode());
    			map.put("updateDate", new Date());
    			meterialmapper.setMaterialSts(map);
    		}
        }catch(Exception e){
        	log.error("工作流[{}]否决业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
        	//TODO 业务逻辑异常处理
        }
    }else{
        log.warn("未知操作:"+message);
    }
    }
}

