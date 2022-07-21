package cn.com.yusys.climp.score.workflow.biz;

import cn.com.yusys.climp.qypool.service.UserInfoService;
import cn.com.yusys.climp.score.domain.ExcelImport;
import cn.com.yusys.climp.score.domain.LoySrScoreCollect;
import cn.com.yusys.climp.score.repository.mapper.ExcelImportMapper;
import cn.com.yusys.climp.score.repository.mapper.LoySrScoreAccuteSumMapper;
import cn.com.yusys.climp.score.repository.mapper.LoySrScoreCollectMapper;
import cn.com.yusys.climp.score.repository.mapper.ScoreGameMapper;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.ognl.Ognl;
import org.apache.ibatis.ognl.OgnlContext;
import org.apache.ibatis.ognl.OgnlException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WfiScoreWorkflowBizAfterProcessor implements InstanceMessageProcessor {
    private final Logger logger = LoggerFactory.getLogger(WfiScoreWorkflowBizAfterProcessor.class);

    @Autowired
    private ExcelImportMapper excelImportMapper;
    @Autowired
    private ScoreGameMapper scoreGameMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private LoySrScoreCollectMapper loySrScoreCollectMapper;
    @Autowired
    private LoySrScoreAccuteSumMapper loySrScoreAccuteSumMapper;

    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public boolean should(String s) {
        InstanceMessage instanceMessage = null;
        try {
            instanceMessage = objectMapper.readValue(s, InstanceMessage.class);
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
        logger.info("process message=====================>>{}", s);
        // 根据流程标识，决定此流程是否走此后业务处理
        if ("EXIM".equals(WfSign)) {
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
    public void process(String s) throws Exception {
        InstanceMessage instanceMessage = objectMapper.readValue(s, InstanceMessage.class);
        String WfSign = instanceMessage.getInstanceInfo().getWfSign();
        if ("EXIM".equals(WfSign)){
            //名单制赠送导入审批
            excelImport(s);
        }
    }

    private void excelImport(String message) throws Exception {
        InstanceMessage instanceMessage = objectMapper.readValue(message, InstanceMessage.class);
        String messageType = instanceMessage.getType();
        String importCode = instanceMessage.getInstanceInfo().getBizSeqNo();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(Consts.MESSAGE_TYPE_INIT.equals(messageType)){
            logger.debug("初始化操作:"+message);
        }else if(Consts.MESSAGE_TYPE_SUBMIT.equals(messageType)){
            logger.debug("提交操作:"+message);
            Map<String,String> map = new HashMap<>();
            ExcelImport excelImport = new ExcelImport();
            excelImport.setAppStatus("2");
            excelImport.setImportCode(importCode);
            excelImportMapper.updateStatus(excelImport);
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
            ExcelImport excelImport = new ExcelImport();
            excelImport.setAppStatus("3");
            excelImport.setAppUser(userInfoService.getLoginCode());
            excelImport.setAppDate(s.parse(s.format(new Date())));
            excelImport.setImportCode(importCode);
            excelImportMapper.updateStatus(excelImport);
            scoreGameMapper.insertTmp(importCode);
            scoreGameMapper.insertAccount();
            List<LoySrScoreCollect> list = loySrScoreCollectMapper.selectData(importCode);
            list.forEach(loySrScoreCollect -> {
                loySrScoreCollect.setId(getUuid());
                loySrScoreCollect.setScdId(getUuid());
                loySrScoreCollectMapper.insert(loySrScoreCollect);
            });
            loySrScoreAccuteSumMapper.insertData(importCode);
            scoreGameMapper.deleteTmp(importCode);
        }else if(Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
            logger.debug("退回操作:"+message);
            Map<String,String> map = new HashMap<>();
            ExcelImport excelImport = new ExcelImport();
            excelImport.setAppStatus("4");
            excelImport.setAppUser(userInfoService.getLoginCode());
            excelImport.setAppDate(s.parse(s.format(new Date())));
            excelImport.setImportCode(importCode);
            excelImportMapper.updateStatus(excelImport);
        }else if(Consts.MESSAGE_TYPE_CALLBACK.equals(messageType)){
            logger.debug("打回操作:"+message);
        }else if(Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)){
            logger.debug("拿回操作:"+message);
            ExcelImport excelImport = new ExcelImport();
            excelImport.setAppStatus("5");
            excelImport.setImportCode(importCode);
            excelImportMapper.updateStatus(excelImport);
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
    public String getUuid() {
        OgnlContext contxet = new OgnlContext();
        try {
            Object ognl = Ognl.parseExpression("@java.util.UUID@randomUUID().toString().replace(\"-\", \"\")");
            return Ognl.getValue(ognl, contxet, contxet.getRoot()).toString();
        } catch (OgnlException var3) {
            var3.printStackTrace();
            return null;
        }
    }
}
