package cn.com.yusys.yusp.uimp.distribution.workflow;

import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepAcctInfo;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepPeriod;
import cn.com.yusys.yusp.uimp.distribution.web.rest.PmaFComDepCommResource;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.util.StringUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class WfiDepositPerDisWorkflowBizAfterProcessor implements InstanceMessageProcessor {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private PmaFComDepCommResource pmaFComDepCommResource;

    @Override
    public boolean should(String wfSign) {
        try {
			InstanceMessage instanceMessage = objectMapper.readValue(wfSign, InstanceMessage.class);
			String applyTyep = instanceMessage.getInstanceInfo().getWfSign();
            /*HashMap paramMap = instanceMessage.getInstanceInfo().getParamMap();
            HashMap<String,Object> getNodeFormData = (HashMap)paramMap.get("getNodeFormData");
            Object periodId = getNodeFormData.get("periodId");
            System.out.println("获取区间id为:"+periodId);*/
            if("CK_YJFPSP".equals(applyTyep)){
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

        String bizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
        /*HashMap<String,Object> getNodeFormData = (HashMap) instanceMessage.getInstanceInfo().getParamMap().get("getNodeFormData");
        String periodId = getNodeFormData.get("periodId").toString();
        String[] split = periodId.split(",");

        System.out.println("获取区间id为:"+periodId);*/

        if(StringUtil.isEmpty(bizSeqNo)){
            log.error("获取需要审批的业务id失败，"+instanceMessage);
            return;
        }
        Map<String,Object> map = new HashMap<>();
        map.put("workType","1");
        if(Consts.MESSAGE_TYPE_INIT.equals(messageType)){
            log.debug("初始化操作:"+message);
            //分配状态:1未分配
            PmaFComDepAcctInfo acctInfo = new PmaFComDepAcctInfo();
            acctInfo.setDstrSts("1");
            acctInfo.setId(bizSeqNo);
            map.put("acctInfo",acctInfo);

        }else if(Consts.MESSAGE_TYPE_SUBMIT.equals(messageType)){
            log.debug("提交操作:"+message);
            // TODO 状态:4待审批 1审批中
            PmaFComDepAcctInfo acctInfo = new PmaFComDepAcctInfo();
            acctInfo.setId(bizSeqNo);
            acctInfo.setDstrSts("4");
            acctInfo.setApplySts("1");
            map.put("acctInfo",acctInfo);

            map.put("applySts","1");
            pmaFComDepCommResource.executeApprove(map);

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
            // TODO 状态:2已分配 2审批通过
            PmaFComDepAcctInfo acctInfo = new PmaFComDepAcctInfo();
            acctInfo.setId(bizSeqNo);
            acctInfo.setDstrSts("2");
            acctInfo.setApplySts("2");
            map.put("acctInfo",acctInfo);

            map.put("applySts","2");

            pmaFComDepCommResource.executeApprove(map);

        }else if(Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
            log.debug("退回操作:"+message);
        }else if(Consts.MESSAGE_TYPE_CALLBACK.equals(messageType)){
            log.debug("打回操作:"+message);
            // TODO 状态:4待审批 2审批驳回
            PmaFComDepAcctInfo acctInfo = new PmaFComDepAcctInfo();
            acctInfo.setId(bizSeqNo);
            acctInfo.setDstrSts("1");
            acctInfo.setApplySts("3");
            map.put("acctInfo",acctInfo);

            map.put("applySts","3");

            pmaFComDepCommResource.executeApprove(map);

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
        }else{
            log.warn("未知操作:"+message);
        }
    }
}
