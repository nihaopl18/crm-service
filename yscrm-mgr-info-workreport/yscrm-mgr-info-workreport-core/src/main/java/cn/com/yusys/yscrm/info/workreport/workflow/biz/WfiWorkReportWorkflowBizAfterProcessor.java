package cn.com.yusys.yscrm.info.workreport.workflow.biz;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpTodoWork;
import cn.com.yusys.yscrm.info.workreport.service.CustomerAndTodoWorkService;
import cn.com.yusys.yscrm.info.workreport.service.OcrmFwpCustomerContactService;
import cn.com.yusys.yscrm.info.workreport.service.OcrmFwpWorkReportService;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.RemindInfo;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.service.RemindInfoService;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.dto.core.EchainInstanceDTO;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Component
public class WfiWorkReportWorkflowBizAfterProcessor implements InstanceMessageProcessor {

    @Autowired
    private OcrmFwpWorkReportService ocrmFwpWorkReportService;

    @Autowired
    private OcrmFwpCustomerContactService ocrmFwpCustomerContactService;

    @Autowired
    private CustomerAndTodoWorkService customerAndTodoWorkService;

    @Autowired
    private RemindInfoService remindInfoService;

    private ObjectMapper objectMapper = new ObjectMapper();

    private final Logger logger = LoggerFactory.getLogger(WfiWorkReportWorkflowBizAfterProcessor.class);
    @Override
    public boolean should(String wfSign) {
        InstanceMessage instanceMessage = null;
        try {
            instanceMessage = objectMapper.readValue(wfSign, InstanceMessage.class);
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
        logger.info("process message=====================>>{}", wfSign);
        // 根据流程标识，决定此流程是否走此后业务处理
        if ("WFWR".equals(WfSign)) {
            logger.debug("后业务处理类命中:" + this.getClass());
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
        String workReportId = instanceMessage.getInstanceInfo().getBizSeqNo();
        if(Consts.MESSAGE_TYPE_INIT.equals(messageType)){
            logger.debug("初始化操作:"+message);
            ocrmFwpWorkReportService.saveIntanceId(workReportId,instanceMessage.getInstanceInfo().getInstanceId());
            ocrmFwpWorkReportService.updateStatus(workReportId,"N-0");
            ocrmFwpCustomerContactService.updateStatus(workReportId,"N-0");
        }else if(Consts.MESSAGE_TYPE_SUBMIT.equals(messageType)){
            logger.debug("提交操作:"+message);
            ocrmFwpWorkReportService.updateStatus(workReportId,"N-1");
            ocrmFwpCustomerContactService.updateStatus(workReportId,"N-1");
            addRemind(instanceMessage.getInstanceInfo(),messageType);
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
            ocrmFwpWorkReportService.updateStatus(workReportId,"N");
            ocrmFwpCustomerContactService.updateStatus(workReportId,"N");
            List<Map<String,Object>> list = ocrmFwpCustomerContactService.selectByWorkReportIds(workReportId,"N");
            addTodoWorks(list);
            addRemind(instanceMessage.getInstanceInfo(),messageType);
        }else if(Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
            logger.debug("退回操作:"+message);
            ocrmFwpWorkReportService.updateStatus(workReportId,"N-2");
            ocrmFwpCustomerContactService.updateStatus(workReportId,"N-2");
            addRemind(instanceMessage.getInstanceInfo(),messageType);
        }else if(Consts.MESSAGE_TYPE_CALLBACK.equals(messageType)){
            logger.debug("打回操作:"+message);
        }else if(Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)){
            logger.debug("拿回操作:"+message);
            ocrmFwpWorkReportService.updateStatus(workReportId,"N-3");
            ocrmFwpCustomerContactService.updateStatus(workReportId,"N-3");
            addRemind(instanceMessage.getInstanceInfo(),messageType);
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
    }

    private void addTodoWorks(List<Map<String, Object>> list) {
        List<OcrmFwpTodoWork> todoWorkList = new ArrayList<>();
        for (Map<String,Object> m : list){
            if (m.get("nextContactDate") != null){
                OcrmFwpTodoWork ocrmFwpTodoWork = new OcrmFwpTodoWork();
                SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date startDate = (Date) m.get("nextContactDate");
                try{
                startDate = s.parse(s.format(startDate));}
                catch (ParseException e){
                    logger.error("日期格式化出错" + e);
                }
                ocrmFwpTodoWork.setStartDate(startDate);
                ocrmFwpTodoWork.setRelationCust(m.get("contactCustName") + "/"
                        + m.get("contactCustId"));
                String contactGoal = (String) m.get("contactGoal");
                if("1".equals(contactGoal)) {
                    contactGoal = "产品营销";
                }else if ("2".equals(contactGoal)) {
                    contactGoal = "客户关怀";
                }
                ocrmFwpTodoWork.setTodoWorkTitle(contactGoal);
                ocrmFwpTodoWork.setTodoWorkContent("客户跟进;" + contactGoal + ";" + m.get("product") == null ? "" : (String)m.get("product"));
                todoWorkList.add(ocrmFwpTodoWork);
                ocrmFwpTodoWork.setFinisher(m.get("creatorName") + "-"+ m.get("creatorId"));
                ocrmFwpTodoWork.setCreatorId((String) m.get("creatorId"));
                ocrmFwpTodoWork.setCreatorName((String) m.get("creatorName"));
                ocrmFwpTodoWork.setCreatorOrgId((String) m.get("creatorOrgId"));
                ocrmFwpTodoWork.setCreatorOrgName((String) m.get("creatorOrgName"));
                ocrmFwpTodoWork.setCreateDate((Date) m.get("createDate"));
            }
        }
        customerAndTodoWorkService.addOneTodoWork(todoWorkList);
    }

    private void addRemind(EchainInstanceDTO instanceInfo, String messageType) {
        RemindInfo remindInfo = new RemindInfo();
        remindInfo.setBusiId(instanceInfo.getInstanceId());
        remindInfo.setRemindClass("APP");
        if (Consts.MESSAGE_TYPE_SUBMIT.equals(messageType) || Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType) || Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)){
            String[] userIds = instanceInfo.getCurrentNodeUser().split(";");
            remindInfo.setReceUserId(userIds[0]);
            remindInfo.setReceUserName(ocrmFwpWorkReportService.getCurrentNodeUserName(remindInfo.getReceUserId()));
            if (Consts.MESSAGE_TYPE_SUBMIT.equals(messageType) ){
                remindInfo.setRemindType("APP-02");
                remindInfo.setInfoText("您有一条【" + "工作报告" + "】审批待处理，请关注！");
            }else if (Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
                remindInfo.setRemindType("APP-03");
                remindInfo.setInfoText("【工作报告】审批申请被驳回，请关注！");
            }else if (Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)){
                remindInfo.setRemindType("APP-03");
                remindInfo.setInfoText("【工作报告】审批申请已撤回，请关注！");
            }
        }

        if (Consts.MESSAGE_TYPE_END.equals(messageType)){
            remindInfo.setReceUserId(instanceInfo.getCustId());
            remindInfo.setReceUserName(ocrmFwpWorkReportService.getCurrentNodeUserName(remindInfo.getReceUserId()));
            remindInfo.setRemindType("APP-03");
            remindInfo.setInfoText("【工作报告】审批申请已通过，请关注！");
        }
        remindInfoService.addOne(remindInfo);
    }
}
