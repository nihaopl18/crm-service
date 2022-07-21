package cn.com.yusys.yusp.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ecc.echain.workflow.engine.EVO;
import com.ecc.echain.workflow.engine.WorkFlowClient;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.yusys.yusp.echain.client.dto.core.EchainInstanceDTO;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessorFactory;
import cn.com.yusys.yusp.echain.server.service.EchainCoreMessageService;
import cn.com.yusys.yusp.echain.server.util.EchainVOUtils;

@Component
public class SingleEchainCoreMessageService implements EchainCoreMessageService{
    private final Logger log = LoggerFactory.getLogger(EchainCoreMessageService.class);

    private ObjectMapper mapper = new ObjectMapper();
    
    private WorkFlowClient wfc = WorkFlowClient.getInstance();
    
    @Autowired
    private InstanceMessageProcessorFactory processorFactory;

    public boolean sendMessage(String type, boolean success, EVO requestEVO) {
        EVO paramEVO = new EVO();
        paramEVO.setInstanceID(requestEVO.getInstanceID());
//        paramEVO.setNodeID(requestEVO.getNodeID());
        String message = null;
        try {
            EVO instanceEVO = wfc.getInstanceInfo(paramEVO);
            EchainInstanceDTO instanceInfo = EchainVOUtils.evo2InstanceDTO(instanceEVO);
            InstanceMessage instanceMessage = new InstanceMessage(type, success, instanceInfo);
            message = mapper.writeValueAsString(instanceMessage);
            
            List<InstanceMessageProcessor> processors = processorFactory.getProcessors(message);
            for (InstanceMessageProcessor processor : processors) {
                try {
                    processor.process(message);
                } catch (Exception e) {
                    log.error(e.toString(), e);
                }
            }
            
            return true;
        } catch (Exception e) {
            log.error("Echain服务端消息发送异常: " + e + "\n消息为: " + message);
        }
        return false;
    }
}
