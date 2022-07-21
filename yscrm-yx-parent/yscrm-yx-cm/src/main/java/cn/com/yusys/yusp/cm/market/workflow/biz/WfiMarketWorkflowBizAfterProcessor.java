package cn.com.yusys.yusp.cm.market.workflow.biz;

import cn.com.yusys.yusp.cm.market.service.CimpCmMarketPlanService;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
/**
 * @项目名称: yscimc-app-cm模块
 * @类名称: WfiMarketWorkflowBizAfterProcessor
 * @类描述: #活动流程业务处理
 * @功能描述: 活动提交审批业务处理
 * @创建人: yangxiao2
 * @创建时间: 2019-07-18 14:11:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Component
public class WfiMarketWorkflowBizAfterProcessor implements InstanceMessageProcessor {
	
	private final static String ON_WORKFLOW = "111"; // 审批中
	private final static String AGREE_STS = "997"; // 同意
	private final static String DISAGREE_STS = "998"; // 否决
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

    private ObjectMapper objectMapper = new ObjectMapper();
    
    @Autowired
    private CimpCmMarketPlanService service;

    @Override
    public boolean should(String wfSign) {
        try {
			InstanceMessage instanceMessage = objectMapper.readValue(wfSign, InstanceMessage.class);
			if("YXHDSP".equals(instanceMessage.getInstanceInfo().getWfSign())){
	            log.debug("后业务处理类命中:"+this.getClass());
	            return true;
	        }
		} catch (IOException e) {
			e.printStackTrace();
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
            	bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
            	log.debug("E==========bizSeqNo:[{}]", bizSeqNo);
            	String tempId = bizSeqNo.substring(bizSeqNo.length()-4);
            	// 设置状态为审批中
            	service.updateWfStatus(tempId,ON_WORKFLOW);
            }catch(Exception e){
            	log.error("工作流[{}]提交/审批业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
            	log.error("业务主键["+bizSeqNo+"]退回业务逻辑处理出错", e);
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
            String bizSeqNo = "";
            try {
            	bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
            	log.debug("E==========bizSeqNo:[{}]", bizSeqNo);
            	String tempId = bizSeqNo.substring(bizSeqNo.length()-4);
            	// 设置状态为同意
            	service.updateWfStatus(tempId,AGREE_STS);
            }catch(Exception e){
            	log.error("工作流[{}]提交/审批业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
            	log.error("业务主键["+bizSeqNo+"]退回业务逻辑处理出错", e);
            }
        }else if(Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
            log.debug("退回操作:"+message);
            String bizSeqNo = "";
            try {
	            //前端页面传递的流程主键
	    		bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
	    		String tempId = bizSeqNo.substring(bizSeqNo.length()-4);
            	// 设置状态为退回
            	service.updateWfStatus(tempId,DISAGREE_STS);
            }catch(Exception e){
            	log.error("工作流[{}]退回业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
            	log.error("业务主键["+bizSeqNo+"]退回业务逻辑处理出错", e);
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
        }else if(Consts.MESSAGE_TYPE_REFUSE.equals(messageType)){
            log.debug("否决操作:"+message);
            String bizSeqNo = "";
            try {
	            //前端页面传递的流程主键
	    		bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
	    		String tempId = bizSeqNo.substring(bizSeqNo.length()-4);
            	// 设置状态为否决
            	service.updateWfStatus(tempId,DISAGREE_STS);
            }catch(Exception e){
            	log.error("工作流[{}]退回业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
            	log.error("业务主键["+bizSeqNo+"]退回业务逻辑处理出错", e);
            }
        }else{
            log.warn("未知操作:"+message);
        }
    }
}

