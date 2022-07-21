package cn.com.yusys.yscrm.custmgr.workflow.biz;

import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.yusys.yscrm.custmgr.service.OcrmFcmCustMgrQuitApplyService;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;


@Component
public class WfiCustMgrAdjustWorkflowBizAfterProcessor implements InstanceMessageProcessor {
	
	@Autowired
	private OcrmFcmCustMgrQuitApplyService ocrmFcmCustMgrQuitApplyService;

	private ObjectMapper objectMapper = new ObjectMapper();

	private final Logger logger = LoggerFactory.getLogger(WfiCustMgrAdjustWorkflowBizAfterProcessor.class);

	@Override
	public int order() {
		return 0;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void process(String message) throws Exception {
		InstanceMessage instanceMessage = objectMapper.readValue(message, InstanceMessage.class);
		String messageType = instanceMessage.getType();
		if (Consts.MESSAGE_TYPE_INIT.equals(messageType)) {
			logger.debug("初始化操作:" + message);
		} else if (Consts.MESSAGE_TYPE_SUBMIT.equals(messageType)) {
			logger.debug("提交操作:" + message);
			String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
			ocrmFcmCustMgrQuitApplyService.submit(bizSeqNo);
		} else if (Consts.MESSAGE_TYPE_SIGNIN.equals(messageType)) {
			logger.debug("签收操作:" + message);
		} else if (Consts.MESSAGE_TYPE_SIGNOFF.equals(messageType)) {
			logger.debug("签收取消操作:" + message);
		} else if (Consts.MESSAGE_TYPE_CHANGE.equals(messageType)) {
			logger.debug("转办操作:" + message);
		} else if (Consts.MESSAGE_TYPE_JUMP.equals(messageType)) {
			logger.debug("跳转操作:" + message);
		} else if (Consts.MESSAGE_TYPE_END.equals(messageType)) {
			logger.debug("结束操作:" + message);
			String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
			Map paramMap =  instanceMessage.getInstanceInfo().getParamMap();
			Map formData = (Map) paramMap.get("getNodeFormData");
			String mgrId = (String) formData.get("mgrId");
			String orgId = (String) formData.get("orgId");
			String orgName = (String) formData.get("orgName");
			ocrmFcmCustMgrQuitApplyService.pass(bizSeqNo,mgrId,orgId,orgName);
			logger.debug("流程{}结束，执行业务处理",bizSeqNo);
		} else if (Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)) {
			logger.debug("退回操作:" + message);
		} else if (Consts.MESSAGE_TYPE_CALLBACK.equals(messageType)) {
			logger.debug("打回操作:" + message);
		} else if (Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)) {

		} else if (Consts.MESSAGE_TYPE_CANCEL.equals(messageType)) {
			logger.debug("撤销操作:" + message);
		} else if (Consts.MESSAGE_TYPE_HANG.equals(messageType)) {
			logger.debug("挂起操作:" + message);
		} else if (Consts.MESSAGE_TYPE_WAKE.equals(messageType)) {
			logger.debug("唤醒操作:" + message);
		} else if (Consts.MESSAGE_TYPE_REFUSE.equals(messageType)) {
			logger.debug("否决操作:" + message);
			String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
			ocrmFcmCustMgrQuitApplyService.refuse(bizSeqNo);
		} else {
			logger.warn("未知操作:" + message);
		}
	}

	@Override
	public boolean should(String wfSign) {
		InstanceMessage instanceMessage = null;
		try {
			instanceMessage = objectMapper.readValue(wfSign, InstanceMessage.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String WfSign = instanceMessage.getInstanceInfo().getWfSign();
		// 解析 message获取流程申请类型，判断是否执行 process方法
		logger.info("process message=====================>>{}", wfSign);
		// 根据流程标识，决定此流程是否走此后业务处理
		if ("TCKHJLSP".equals(WfSign)) {
			logger.debug("后业务处理类命中:" + this.getClass());
			return true;
		}
		return false;
	}

}
