package cn.com.yusys.yscrm.custpub.workflow.biz;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.com.yusys.yscrm.custpub.domain.*;
import cn.com.yusys.yscrm.info.workreport.service.OcrmFwpWorkReportService;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.RemindInfo;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.service.RemindInfoService;
import cn.com.yusys.yusp.echain.client.dto.core.EchainInstanceDTO;
import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciAdmitBelongMapper;
import cn.com.yusys.yscrm.custpub.service.AcrmFciCustAdmitAllService;
import cn.com.yusys.yscrm.custpub.service.AcrmFciCustAllService;
import cn.com.yusys.yscrm.custpub.service.AcrmFciOrgCustInfoService;
import cn.com.yusys.yscrm.custpub.service.AcrmFciPerAdmitInfoService;
import cn.com.yusys.yscrm.custpub.service.AcrmFciPerCustService;
import cn.com.yusys.yscrm.custpub.service.OcrmFciAdmitBelongService;
import cn.com.yusys.yscrm.custpub.service.OcrmFciBelongHisService;
import cn.com.yusys.yscrm.custpub.service.OcrmFciLatentApplyService;
import cn.com.yusys.yscrm.custpub.service.OcrmFciTransApplyService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.echain.client.consts.Consts;
import cn.com.yusys.yusp.echain.client.message.InstanceMessage;
import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

@Component
public class WfiScoreAdjustWorkflowBizAfterProcessor implements InstanceMessageProcessor {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private ObjectMapper objectMapper = new ObjectMapper();
	/*
	 * 准入客户全量服务
	 */
	@Autowired
	private AcrmFciCustAdmitAllService acrmFciCustAdmitAllService;
	/*
	 * 对公客户（准入，非准入）服务
	 */
	@Autowired
	private AcrmFciOrgCustInfoService acrmFciOrgCustInfoService;
	/*
	 * 准入个人服务
	 */
	@Autowired
	private AcrmFciPerAdmitInfoService acrmFciPerAdmitInfoService;
	/*
	 * 个人服务
	 */
	@Autowired
	private AcrmFciPerCustService acrmFciPerCustService;
	/*
	 * 客户全量服务
	 */
	@Autowired
	private AcrmFciCustAllService acrmFciCustAllService;
	/*
	 * 认领客户服务
	 */
	@Autowired
	private OcrmFciLatentApplyService ocrmFciLatentApplyService;
	/*
	 * 移交客户服务
	 */
	@Autowired
	private OcrmFciTransApplyService ocrmFciTransApplyService;
	/*
	 * 准入客户归属
	 */
	@Autowired
	private OcrmFciAdmitBelongService ocrmFciAdmitBelongService;
	@Autowired
	private OcrmFciAdmitBelongMapper ocrmFciAdmitBelongMapper;
    @Autowired
    private OcrmFwpWorkReportService ocrmFwpWorkReportService;
	@Autowired
	private RemindInfoService remindInfoService;
	@Autowired
	private OcrmFciBelongHisService ocrmFciBelongHisService;
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private UaaClient uaaClient;

	private static final String WFMCC = "WFMCC";
	private static final String WFMCD = "WFMCD";
	private static final String WFCFE = "WFCFE";
	private static final String WFCH = "WFCH";
	private static final String WFCLA = "WFCLA";
	private static final String ESDW = "ESDW";
	

	public UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}

	@Override
	public boolean should(String wfSign) {
		InstanceMessage instanceMessage = null;
		try {
			instanceMessage = objectMapper.readValue(wfSign, InstanceMessage.class);
		} catch (JsonParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		String WfSign = instanceMessage.getInstanceInfo().getWfSign();
		//解析 message获取流程申请类型，判断是否执行 process方法
		log.info("songer进入process message=" + wfSign);
		if (WFMCC.equals(WfSign) || WFMCD.equals(WfSign) || WFCFE.equals(WfSign) || WFCH.equals(WfSign) || WFCLA.equals(WfSign) || ESDW.equals(WfSign)) {// 根据流程标识，决定此流程是否走此后业务处理
			log.debug("后业务处理类命中:" + this.getClass());
			return true;
		}
		return false;
	}

	@Override
	public int order() {
		return 0;
	}

	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	@Override
	public void process(String message) throws Exception {

		InstanceMessage instanceMessage = objectMapper.readValue(message, InstanceMessage.class);
		String messageType = instanceMessage.getType();
		if (Consts.MESSAGE_TYPE_INIT.equals(messageType)) {
			log.debug("初始化操作:" + message);
			String BizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
			String WfSign = instanceMessage.getInstanceInfo().getWfSign();
			if (WFMCC.equals(WfSign)) {
				log.info("进入process" + WfSign);
				CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
				crmFCiBelongHisData.setSeqno(BizSeqNo);
				crmFCiBelongHisData.setAssignType("02");
				crmFCiBelongHisData.setInstanceId(instanceMessage.getInstanceInfo().getInstanceId());
				ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
			} else if (WFMCD.equals(WfSign)) {
				log.info("进入process" + WfSign);
				CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
				crmFCiBelongHisData.setSeqno(BizSeqNo);
				crmFCiBelongHisData.setAssignType("01");
				crmFCiBelongHisData.setInstanceId(instanceMessage.getInstanceInfo().getInstanceId());
				ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
			} else if (WFCLA.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String, Object> map = new HashMap<>();
				map.put("id", BizSeqNo);
				map.put("examUserId", instanceMessage.getInstanceInfo().getUserName());
				map.put("instanceId", instanceMessage.getInstanceInfo().getInstanceId());
				ocrmFciAdmitBelongService.updateaumGradeGrade(map);
			} else if (WFCFE.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String, Object> map = new HashMap<>();
				map.put("seqno", BizSeqNo);
				map.put("instanceId", instanceMessage.getInstanceInfo().getInstanceId());
				ocrmFciAdmitBelongService.updateinformation(map);
			} else if (WFCH.equals(WfSign)) {
				log.info("进入process" + WfSign);
				OcrmFciTrusteeshipApply ocrmFciTrusteeshipApply = new OcrmFciTrusteeshipApply();
				ocrmFciTrusteeshipApply.setInstanceId(instanceMessage.getInstanceInfo().getInstanceId());
				ocrmFciTrusteeshipApply.setApplyId(new BigDecimal(BizSeqNo));
                //ocrmFciTrusteeshipApply.setTrustStat("01");
				ocrmFciAdmitBelongService.updateFci(ocrmFciTrusteeshipApply);
			}else if (ESDW.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String,Object> map=new HashMap<>();
				map.put("instanceId",instanceMessage.getInstanceInfo().getInstanceId());
				map.put("seqno",new BigDecimal(BizSeqNo));
				ocrmFciAdmitBelongService.updateEsExportQuery(map);
			}
		} else if (Consts.MESSAGE_TYPE_SUBMIT.equals(messageType)) {
			log.debug("提交操作:" + message);
            String BizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
            String WfSign = instanceMessage.getInstanceInfo().getWfSign();

            if (WFMCC.equals(WfSign)) {
                log.info("进入process" + WfSign);
                CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
                crmFCiBelongHisData.setSeqno(BizSeqNo);
                crmFCiBelongHisData.setAssignType("02");
                crmFCiBelongHisData.setAssignStatus("02");
				crmFCiBelongHisData.setInstanceId(instanceMessage.getInstanceInfo().getInstanceId());
                ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFMCD.equals(WfSign)) {
                log.info("进入process" + WfSign);
                CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
                crmFCiBelongHisData.setSeqno(BizSeqNo);
                crmFCiBelongHisData.setAssignType("01");
                crmFCiBelongHisData.setAssignStatus("02");
				crmFCiBelongHisData.setInstanceId(instanceMessage.getInstanceInfo().getInstanceId());
                ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFCLA.equals(WfSign)) {
                log.info("进入process" + WfSign);
                Map<String, Object> map = new HashMap<>();
                map.put("id", BizSeqNo);
                map.put("modGraValidFlag", "N");
                map.put("status", "02");
				map.put("instanceId", instanceMessage.getInstanceInfo().getInstanceId());
                map.put("examUserId", instanceMessage.getInstanceInfo().getUserName());
                ocrmFciAdmitBelongService.updateaumGradeGrade(map);
            } else if (WFCFE.equals(WfSign)) {
                log.info("进入process" + WfSign);
                Map<String, Object> map = new HashMap<>();
                map.put("seqno", BizSeqNo);
                map.put("status", "02");
				map.put("instanceId", instanceMessage.getInstanceInfo().getInstanceId());
                ocrmFciAdmitBelongService.updateinformation(map);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFCH.equals(WfSign)) {
                log.info("进入process" + WfSign);
                OcrmFciTrusteeshipApply ocrmFciTrusteeshipApply = new OcrmFciTrusteeshipApply();
                ocrmFciTrusteeshipApply.setTrustStat("02");
                ocrmFciTrusteeshipApply.setApplyId(new BigDecimal(BizSeqNo));
				ocrmFciTrusteeshipApply.setInstanceId(instanceMessage.getInstanceInfo().getInstanceId());
                ocrmFciAdmitBelongService.updateFci(ocrmFciTrusteeshipApply);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            }else if (ESDW.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String,Object> map=new HashMap<>();
				map.put("instanceId",instanceMessage.getInstanceInfo().getInstanceId());
				map.put("seqno",new BigDecimal(BizSeqNo));
				map.put("status","02");
				ocrmFciAdmitBelongService.updateEsExportQuery(map);
			}
        } else if (Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)) {
            log.debug("退回操作:" + message);
            String BizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
            String WfSign = instanceMessage.getInstanceInfo().getWfSign();
            if (WFMCC.equals(WfSign)) {
                log.info("进入process" + WfSign);
                CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
                crmFCiBelongHisData.setSeqno(BizSeqNo);
                crmFCiBelongHisData.setAssignType("02");
                crmFCiBelongHisData.setAssignStatus("03");
                ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFMCD.equals(WfSign)) {
                log.info("进入process" + WfSign);
                CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
                crmFCiBelongHisData.setSeqno(BizSeqNo);
                crmFCiBelongHisData.setAssignType("01");
                crmFCiBelongHisData.setAssignStatus("03");
                ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFCLA.equals(WfSign)) {
                log.info("进入process" + WfSign);
                Map<String, Object> map = new HashMap<>();
                map.put("id", BizSeqNo);
                map.put("status", "03");
                map.put("examUserId", instanceMessage.getInstanceInfo().getUserName());
                map.put("examDt", simpleDateFormat.parse(simpleDateFormat.format(new Date())));
                ocrmFciAdmitBelongService.updateaumGradeGrade(map);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFCFE.equals(WfSign)) {
                log.info("进入process" + WfSign);
                Map<String, Object> map = new HashMap<>();
                map.put("seqno", BizSeqNo);
                map.put("status", "03");
                ocrmFciAdmitBelongService.updateinformation(map);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFCH.equals(WfSign)) {
                log.info("进入process" + WfSign);
                OcrmFciTrusteeshipApply ocrmFciTrusteeshipApply = new OcrmFciTrusteeshipApply();
                ocrmFciTrusteeshipApply.setTrustStat("03");
                ocrmFciTrusteeshipApply.setApplyId(new BigDecimal(BizSeqNo));
                ocrmFciAdmitBelongService.updateFci(ocrmFciTrusteeshipApply);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            }else if (ESDW.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String,Object> map=new HashMap<>();
				map.put("instanceId",instanceMessage.getInstanceInfo().getInstanceId());
				map.put("seqno",new BigDecimal(BizSeqNo));
				map.put("status","03");
				ocrmFciAdmitBelongService.updateEsExportQuery(map);
			}
            addRemind(instanceMessage.getInstanceInfo(),messageType);
		} else if (Consts.MESSAGE_TYPE_SIGNIN.equals(messageType)) {
			log.debug("签收操作:" + message);
		} else if (Consts.MESSAGE_TYPE_SIGNOFF.equals(messageType)) {
			log.debug("签收取消操作:" + message);
		} else if (Consts.MESSAGE_TYPE_CHANGE.equals(messageType)) {
			log.debug("转办操作:" + message);
		} else if (Consts.MESSAGE_TYPE_JUMP.equals(messageType)) {
			log.debug("跳转操作:" + message);
		} else if (Consts.MESSAGE_TYPE_END.equals(messageType)) {
			log.debug("结束操作:" + message);
			String BizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
			String WfSign = instanceMessage.getInstanceInfo().getWfSign();

			if (WFMCC.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String, Object> mapp = getbelong(BizSeqNo);
				ocrmFciAdmitBelongMapper.updatebelonghis(mapp);
				CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
				crmFCiBelongHisData.setSeqno(BizSeqNo);
				crmFCiBelongHisData.setAssignType("02");
				crmFCiBelongHisData.setAssignStatus("04");
				ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
			} else if (WFMCD.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String, Object> mapp = getbelong(BizSeqNo);
				ocrmFciAdmitBelongMapper.updatebelonghis(mapp);
				CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
				crmFCiBelongHisData.setSeqno(BizSeqNo);
				crmFCiBelongHisData.setAssignType("01");
				crmFCiBelongHisData.setAssignStatus("04");
				ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
			} else if (WFCLA.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String, Object> map = new HashMap<>();
				map.put("id", BizSeqNo);
				map.put("modGraValidFlag", "Y");
				map.put("status", "04");
				map.put("examUserId", instanceMessage.getInstanceInfo().getUserName());
				map.put("examDt", simpleDateFormat.parse(simpleDateFormat.format(new Date())));
				ocrmFciAdmitBelongService.updateaumGradeGrade(map);
                AcrmCustVO acrmCustVO=ocrmFciAdmitBelongService.selectgrade(BizSeqNo);
				ocrmFciAdmitBelongService.updateGrade(acrmCustVO);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
			} else if (WFCFE.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String, Object> map = new HashMap<>();
				map.put("seqno", BizSeqNo);
				map.put("status", "04");
				ocrmFciAdmitBelongService.updateinformation(map);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
			} else if (WFCH.equals(WfSign)) {
				log.info("进入process" + WfSign);
				OcrmFciTrusteeshipApply ocrmFciTrusteeshipApply = new OcrmFciTrusteeshipApply();
				ocrmFciTrusteeshipApply.setTrustStat("04");
				ocrmFciTrusteeshipApply.setApplyId(new BigDecimal(BizSeqNo));
				ocrmFciAdmitBelongService.updateFci(ocrmFciTrusteeshipApply);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
			}else if (ESDW.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String,Object> map=new HashMap<>();
				map.put("instanceId",instanceMessage.getInstanceInfo().getInstanceId());
				map.put("seqno",new BigDecimal(BizSeqNo));
				map.put("status","04");
				ocrmFciAdmitBelongService.updateEsExportQuery(map);
			}
		} else if (Consts.MESSAGE_TYPE_CALLBACK.equals(messageType)) {
			log.debug("打回操作:" + message);
		} else if (Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)) {
            log.debug("拿回操作:" + message);
            String BizSeqNo = instanceMessage.getInstanceInfo().getBizSeqNo();
            String WfSign = instanceMessage.getInstanceInfo().getWfSign();
            if (WFMCC.equals(WfSign)) {
                log.info("进入process" + WfSign);
                CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
                crmFCiBelongHisData.setSeqno(BizSeqNo);
                crmFCiBelongHisData.setAssignType("02");
                crmFCiBelongHisData.setAssignStatus("05");
                ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFMCD.equals(WfSign)) {
                log.info("进入process" + WfSign);
                CrmFCiBelongHisData crmFCiBelongHisData = new CrmFCiBelongHisData();
                crmFCiBelongHisData.setSeqno(BizSeqNo);
                crmFCiBelongHisData.setAssignType("01");
                crmFCiBelongHisData.setAssignStatus("05");
                ocrmFciAdmitBelongService.updatebelong(crmFCiBelongHisData);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFCLA.equals(WfSign)) {
                log.info("进入process" + WfSign);
                Map<String, Object> map = new HashMap<>();
                map.put("id", BizSeqNo);
                map.put("modGraValidFlag", "N");
                map.put("status", "05");
                map.put("examUserId", instanceMessage.getInstanceInfo().getUserName());
                ocrmFciAdmitBelongService.updateaumGradeGrade(map);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFCFE.equals(WfSign)) {
                log.info("进入process" + WfSign);
                Map<String, Object> map = new HashMap<>();
                map.put("seqno", BizSeqNo);
                map.put("status", "05");
                ocrmFciAdmitBelongService.updateinformation(map);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            } else if (WFCH.equals(WfSign)) {
                log.info("进入process" + WfSign);
                OcrmFciTrusteeshipApply ocrmFciTrusteeshipApply = new OcrmFciTrusteeshipApply();
                ocrmFciTrusteeshipApply.setTrustStat("05");
                ocrmFciTrusteeshipApply.setApplyId(new BigDecimal(BizSeqNo));
                ocrmFciAdmitBelongService.updateFci(ocrmFciTrusteeshipApply);
                addRemind(instanceMessage.getInstanceInfo(),messageType);
            }else if (ESDW.equals(WfSign)) {
				log.info("进入process" + WfSign);
				Map<String,Object> map=new HashMap<>();
				map.put("instanceId",instanceMessage.getInstanceInfo().getInstanceId());
				map.put("seqno",new BigDecimal(BizSeqNo));
				map.put("status","05");
				ocrmFciAdmitBelongService.updateEsExportQuery(map);
			}
		} else if (Consts.MESSAGE_TYPE_CANCEL.equals(messageType)) {
			log.debug("撤销操作:" + message);
		} else if (Consts.MESSAGE_TYPE_HANG.equals(messageType)) {
			log.debug("挂起操作:" + message);
		} else if (Consts.MESSAGE_TYPE_WAKE.equals(messageType)) {
			log.debug("唤醒操作:" + message);
		} else if (Consts.MESSAGE_TYPE_REFUSE.equals(messageType)) {
			log.debug("否决操作:" + message);
		} else {
			log.warn("未知操作:" + message);
		}
	}

	private Map<String, Object> getbelong(String bizSeqNo) {
		Map<String, Object> mapp = new HashMap<>();
		Map<String, Object> map = ocrmFciAdmitBelongService.detailebelonghis(bizSeqNo);
		   mapp.put("seqno", bizSeqNo);
		    mapp.put("mgrIdPre", map.get("mgrIdPre"));
			mapp.put("mgrNamePre", map.get("mgrNamePre"));
			mapp.put("orgIdPre", map.get("orgIdPre"));
			mapp.put("orgNamePre", map.get("orgNamePre"));
			mapp.put("mgrTypePre", map.get("mgrTypePre"));
			mapp.put("mgrId", map.get("mgrId"));
			mapp.put("mgrName", map.get("mgrName"));
			mapp.put("orgId", map.get("orgId"));
			mapp.put("orgName", map.get("orgName"));
			mapp.put("mgrType", map.get("mgrType"));
			return mapp;
		}


    private void addRemind(EchainInstanceDTO instanceInfo, String messageType) throws Exception {
        RemindInfo remindInfo = new RemindInfo();
        remindInfo.setBusiId(instanceInfo.getInstanceId());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String lastday;
		Calendar cale = null;
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);

		cale.set(Calendar.DAY_OF_MONTH, 0);
        String WfSign =instanceInfo.getWfSign();
        remindInfo.setRemindClass("APP");
        if (Consts.MESSAGE_TYPE_SUBMIT.equals(messageType) || Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType) || Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)){
            if(StringUtils.isNotEmpty(instanceInfo.getCurrentNodeUser())){
                String[] userIds = instanceInfo.getCurrentNodeUser().split(";");
                remindInfo.setReceUserId(userIds[0]);
            }else{
                remindInfo.setReceUserId(instanceInfo.getCustId());
            }
            remindInfo.setReceUserName(ocrmFwpWorkReportService.getCurrentNodeUserName(remindInfo.getReceUserId()));
            if (Consts.MESSAGE_TYPE_SUBMIT.equals(messageType) ){
                remindInfo.setRemindType("APP-02");
                if(WFCFE.equals(WfSign)){
					remindInfo.setInfoText("您有一条【" + "客户信息编辑" + "】审批待处理，请关注！");
				}else if(WFCH.equals(WfSign)){
					String datadate=ocrmFciAdmitBelongService.selectdata(instanceInfo.getBizSeqNo());
					remindInfo.setIssueDate(format.parse(datadate));
					remindInfo.setInfoText("您有一条【" + "客户托管" + "】审批待处理，请关注！");
				}else if(WFMCC.equals(WfSign)){
					remindInfo.setInfoText("您有一条【" + "管户调整" + "】审批待处理，请关注！");
				}else if(WFMCD.equals(WfSign)){
					remindInfo.setInfoText("您有一条【" + "管户分配" + "】审批待处理，请关注！");
				}else if(WFCLA.equals(WfSign)){
					remindInfo.setIssueDate(format.parse(format.format(cale.getTime())));
					remindInfo.setInfoText("您有一条【" + "客户分层" + "】审批待处理，请关注！");
				}else if(ESDW.equals(WfSign)){
					remindInfo.setIssueDate(format.parse(format.format(cale.getTime())));
					remindInfo.setInfoText("您有一条【" + "客户信息导出" + "】审批待处理，请关注！");
				}
            }
            if (Consts.MESSAGE_TYPE_RETURNBACK.equals(messageType)){
                remindInfo.setRemindType("APP-03");
				if(WFCFE.equals(WfSign)){
					remindInfo.setInfoText("【客户信息编辑】审批申请被退回，请关注！");
				}else if(WFCH.equals(WfSign)){
					String datadate=ocrmFciAdmitBelongService.selectdata(instanceInfo.getBizSeqNo());
					remindInfo.setIssueDate(format.parse(datadate));
					remindInfo.setInfoText("【客户托管】审批申请被退回，请关注！");
				}else if(WFMCC.equals(WfSign)){
					remindInfo.setInfoText("【管户调整】审批申请被退回，请关注！");
				}else if(WFMCD.equals(WfSign)){
					remindInfo.setInfoText("【管户分配】审批申请被退回，请关注！");
				}else if(WFCLA.equals(WfSign)){
					remindInfo.setIssueDate(format.parse(format.format(cale.getTime())));
					remindInfo.setInfoText("【客户分层】审批申请被退回，请关注！");
				}else if(ESDW.equals(WfSign)){
					remindInfo.setIssueDate(format.parse(format.format(cale.getTime())));
					remindInfo.setInfoText("【" + "客户信息导出" + "】审批申请被退回，请关注！");
				}
            }
        }

        if (Consts.MESSAGE_TYPE_END.equals(messageType)){
            remindInfo.setReceUserId(instanceInfo.getCustId());
            remindInfo.setReceUserName(ocrmFwpWorkReportService.getCurrentNodeUserName(remindInfo.getReceUserId()));
            remindInfo.setRemindType("APP-03");
			if(WFCFE.equals(WfSign)){
				remindInfo.setInfoText("【客户信息编辑】审批申请已通过，请关注！");
			}else if(WFCH.equals(WfSign)){
				String datadate=ocrmFciAdmitBelongService.selectdata(instanceInfo.getBizSeqNo());
				remindInfo.setIssueDate(format.parse(datadate));
				remindInfo.setInfoText("【客户托管】审批申请已通过，请关注！");
			}else if(WFMCC.equals(WfSign)){
				remindInfo.setInfoText("【管户调整】审批申请已通过，请关注！");
			}else if(WFMCD.equals(WfSign)){
				remindInfo.setInfoText("【管户分配】审批申请已通过，请关注！");
			}else if(WFCLA.equals(WfSign)){
				remindInfo.setIssueDate(format.parse(format.format(cale.getTime())));
				remindInfo.setInfoText("【客户分层】审批申请已通过，请关注！");
			}else if(ESDW.equals(WfSign)){
				remindInfo.setIssueDate(format.parse(format.format(cale.getTime())));
				remindInfo.setInfoText("【" + "客户信息导出" + "】审批申请已通过，请关注！");
			}
        }
		if (Consts.MESSAGE_TYPE_TAKEBACK.equals(messageType)){
			remindInfo.setReceUserId(instanceInfo.getCustId());
			remindInfo.setReceUserName(ocrmFwpWorkReportService.getCurrentNodeUserName(remindInfo.getReceUserId()));
			remindInfo.setRemindType("APP-03");
			if(WFCFE.equals(WfSign)){
				remindInfo.setInfoText("【客户信息编辑】审批申请已撤回，请关注！");
			}else if(WFCH.equals(WfSign)){
				String datadate=ocrmFciAdmitBelongService.selectdata(instanceInfo.getBizSeqNo());
				remindInfo.setIssueDate(format.parse(datadate));
				remindInfo.setInfoText("【客户托管】审批申请已撤回，请关注！");
			}else if(WFMCC.equals(WfSign)){
				remindInfo.setInfoText("【管户调整】审批申请已撤回，请关注！");
			}else if(WFMCD.equals(WfSign)){
				remindInfo.setInfoText("【管户分配】审批申请已撤回，请关注！");
			}else if(WFCLA.equals(WfSign)){
				remindInfo.setIssueDate(format.parse(format.format(cale.getTime())));
				remindInfo.setInfoText("【客户分层】审批申请已撤回，请关注！");
			}else if(ESDW.equals(WfSign)){
				remindInfo.setIssueDate(format.parse(format.format(cale.getTime())));
				remindInfo.setInfoText("【" + "客户信息导出" + "】审批申请已撤回，请关注！");
			}
		}
        remindInfoService.addOne(remindInfo);
    }
	}