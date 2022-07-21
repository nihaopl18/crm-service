package cn.com.yusys.climp.acty.workflow.biz;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.service.LoyRlActivityService;
import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 *
 * @项目名称：yusp-climp-acty-core
 * @类名称：WfiScoreActyWorkflowBizAfterProcessor
 * @类描述：积分活动审批后处理类
 * @功能描述:
 * @创建人：chenlin2@yusys.com.cn
 * @创建时间：2019-01-16 15:23
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2019宇信科技-版权所有
 */
@Component
public class WfiScoreActyWorkflowBizAfterProcessor implements InstanceMessageProcessor {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private ObjectMapper objectMapper = new ObjectMapper();
    public static final String MESSAGE_TYPE_SUBMIT = "submit"; // 提交
    public static final String MESSAGE_TYPE_RETURNBACK = "returnBack"; // 退回
    @Autowired
    private LoyRlActivityService actyService;
	@Autowired
	private UserInfoService userInfo;
    @Override
    public boolean should(String wfSign) {
        try {
			InstanceMessage instanceMessage = objectMapper.readValue(wfSign, InstanceMessage.class);
			if("SCORE_ACTY".equals(instanceMessage.getInstanceInfo().getWfSign())){
	            log.debug("后业务处理类命中:"+this.getClass());
	            return true;
	        }
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
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

        String BizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
        String WfStatus=instanceMessage.getInstanceInfo().getWfStatus();
        String WfSign=instanceMessage.getInstanceInfo().getWfSign();
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
            String bizSeqNo = "";
            try {
                LoyRlActivity actyInfo =actyService.selectByPrimaryKey(BizSeqNo);
            	// 获取登录用户的机构号
            	String orgCode = userInfo.getOrgCode();
            	// 获取当前会话信息
            	String loginCode = SecurityUtils.getCurrentUserLogin();
            	actyInfo.setWfApprSts("997");
            	actyInfo.setUpdateDate(new Date());
            	actyInfo.setUpdateUser(loginCode);
            	actyInfo.setUpdateOrg(orgCode);
            	actyService.updateSelective(actyInfo);
            }catch(Exception e){
            	log.error("工作流[{}]提交/审批业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
            	log.error("业务主键["+bizSeqNo+"]退回业务逻辑处理出错", e);
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
            log.debug("退回操作:"+message);
            String bizSeqNo = "";
            try {
            	LoyRlActivity actyInfo =actyService.selectByPrimaryKey(BizSeqNo);
        		// 获取登录用户的机构号
        		String orgCode = userInfo.getOrgCode();
        		// 获取当前会话信息
        		String loginCode = SecurityUtils.getCurrentUserLogin();
        		actyInfo.setWfApprSts("998");
        		actyInfo.setUpdateDate(new Date());
        		actyInfo.setUpdateUser(loginCode);
        		actyInfo.setUpdateOrg(orgCode);
        		actyService.updateSelective(actyInfo);
            }catch(Exception e){
            	log.error("工作流[{}]退回业务逻辑处理出错!", instanceMessage.getInstanceInfo().getAppId());
            	log.error("业务主键["+bizSeqNo+"]退回业务逻辑处理出错", e);
            	//TODO 业务逻辑异常处理
            }
        }else{
            log.warn("未知操作:"+message);
        }
    }
}