package cn.com.yusys.yusp.cm.ruleConfig.service;


import cn.com.yusys.yusp.cm.cust.domain.AcimFCiCustomer;
import cn.com.yusys.yusp.cm.cust.service.AcimFCiCustomerService;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodeMapper;
import cn.com.yusys.yusp.cm.market.service.CimpCmMarketPlanService;
import cn.com.yusys.yusp.cm.market.service.CimpCmNodeService;
import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProductManagerInfo;
import cn.com.yusys.yusp.cm.productmanager.repository.mapper.CmFRcProductManagerMapper;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventInfo;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleResult;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleResultLog;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRuleResultLogMapper;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRuleResultMapper;
import cn.com.yusys.yusp.cm.taskcenter.domain.*;
import cn.com.yusys.yusp.cm.taskcenter.repository.mapper.*;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRuleResultService
 * @类描述: 事件表单结果服务类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-11-19 14:28
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcRuleResultService extends CommonService {

	@Autowired
	private CmFRcRuleResultMapper mapper;
	@Autowired
	private CmFRcEventInfoService eventService;
	@Autowired
	private CimpCmNodeService nodeService;
	@Autowired
	private CimpCmMarketPlanService planService;
	@Autowired
	private AcimFCiCustomerService custService;
	@Autowired
	private CimFTcTaskPoolMapper taskMapper;
	@Autowired
	private CimFTcMyTaskMapper mytaskMapper;
	@Autowired
	private CimFTcNicheMapper nicheMapper;
	@Autowired
	private CimFTcRiskMapper riskMapper;
	@Autowired
	private CimFTcCareMapper careMapper;
	@Autowired
	private CmFRcRuleResultLogMapper logMapper;
	@Autowired
	private CimpCmNodeMapper nodeMapper;
	@Autowired
	private CmFRcMarketBackMapper backMapper;
	@Autowired
	private CmFRcProductManagerMapper prodMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}

	/**
	 * 
	 * @方法名称: getEventInfo
	 * @方法描述: 查询事件结果信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<CmFRcRuleResult> getEventResult(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<CmFRcRuleResult> list = mapper.getEventResult(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, Object>> getMegIn(QueryModel model) {
		//PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = mapper.getMegIn(model);
		//PageHelper.clearPage();
		return list;
	}

	public List<Map<String, Object>> getMegOut(QueryModel model) {
		//PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = mapper.getMegOut(model);
		//PageHelper.clearPage();
		return list;
	}

	public CmFRcEventInfo getEventForm(String eventId) {
		return eventService.selectByPrimaryKey(eventId);
	}

	/**
	 * 事件引擎结果处理
	 * 
	 * @param resultList
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public String backCall(List<CmFRcRuleResult> resultList) {
		String message = resultList.get(0).getRcvmsg();
		//当整个流程中不包含渠道节点的时候，直接生成对应的任务，还有，商机，风险，关怀
		if (!getflow(message, resultList.get(0).getEventId(), resultList)) {
			for (int i = 0; i < resultList.size(); i++) {
				CmFRcRuleResult result = resultList.get(i);
				bulidTaskInfo(result);
			}
		}
		return "";
	}
	/**
	 * 
	* @方法名称: bulidTaskInfo
	* @方法描述: 构建任务相关数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	public void bulidTaskInfo(CmFRcRuleResult result) {
		/** 保存任务池 */
		CimFTcTaskPool task = new CimFTcTaskPool();// 任务池
		CimpCmNodeinfo node = nodeService.selectByPrimaryKey(result.getEventId());// 根据组件id查询组件信息
		CimpCmMarketplan plan = planService.selectByPrimaryKey(node.getTempId());// 根据活动id查询活动信息
		//prodMapper.selectByPrimaryKey(result.get)
		task.setTaskName(plan.getActivityName() + "_" + result.getCustName());// 任务名称（活动名称+客户名称）
		if (result.getActionType().equals("PRODUCT")) {// 产品
			task.setTaskType("BO");// 任务类型(bo:商机；risk:风险；care:关怀)
		} else if (result.getActionType().equals("RISK")) {// 风险
			task.setTaskType("RISK");// 任务类型(bo:商机；risk:风险；care:关怀)
		} else if (result.getActionType().equals("CARE")) {// 关注
			task.setTaskType("CARE");// 任务类型(bo:商机；risk:风险；care:关怀)
		}
		AcimFCiCustomer cust = custService.selectByPrimaryKey(result.getCustId());// 根据客户号查询客户信息
		if(cust.getBelongMgr() != null) {
			task.setTaskState("IMPLEMENTING");// 任务状态(UNASSIGNED:未分配；APPLYING：申领中；IMPLEMENTING：执行中；SUCCESSEND：成功结束；FAILEND：失败结束)
		}else {
			task.setTaskState("UNASSIGNED");//任务状态(UNASSIGNED:未分配；APPLYING：申领中；IMPLEMENTING：执行中；SUCCESSEND：成功结束；FAILEND：失败结束)
		}
		task.setStartTime(plan.getStartDate());
		task.setEndTime(plan.getEndDate());
		task.setLastUpdateDt(new Date());
		task.setActivityId(result.getActivityId());
		task.setLastUpdateUser("admin");
		task.setCreateTime(new Date());
		taskMapper.insertSelective(task);
		/**人物反馈信息表**/
		CmFRcMarketBack back=new CmFRcMarketBack();
		if(result.getActionType().equals("PRODUCT")) {
			CmFRcProductManagerInfo   prod=prodMapper.selectByPrimaryKey(result.getActionObjId());
			back.setCatlCode(prod.getCatlCode());
			back.setProductId(prod.getProductId());
		}
		back.setChannelId(result.getChannel());
		back.setCustId(result.getCustId());
		//back.setMarketAmount(marketAmount);
		back.setMarketDate(new Date());
		// back.setProductId(map.get("productId").toString());
		back.setPushDate(new Date());
		back.setTaskId(task.getTaskId());
		backMapper.insertSelective(back);
		if (cust.getBelongMgr() != null) {
			/** 保存我的任务 */
			CimFTcMyTask mytask = new CimFTcMyTask();
			mytask.setTaskId(task.getTaskId());
			mytask.setAllotUser("admin");
			mytask.setDutyUser(cust.getBelongMgr());
			mytask.setAllotTime(new Date());
			mytask.setLastUpdateDt(new Date());
			mytask.setLastUpdateUser("admin");
			mytaskMapper.insertSelective(mytask);
		}
		if (result.getActionType().equals("PRODUCT")) {// 产品
			/** 保存商机 */
			CimFTcNiche niche = new CimFTcNiche();
			niche.setTaskId(task.getTaskId());
			niche.setNicheName(plan.getActivityName());
			niche.setNicheState("0");
			niche.setNicheStage("1");
			niche.setNicheType("0");
			niche.setNicheStartDt(plan.getStartDate());
			niche.setNicheEndDt(plan.getEndDate());
			niche.setCustomerName(result.getCustName());
			niche.setNicheRiseDt(new Date());
			niche.setLastUpdateDt(new Date());
			niche.setLastUpdateUser("admin");
			niche.setExecuteUser(cust.getBelongMgr());
			niche.setExecuteAgency(cust.getBelongOrg());
			niche.setNicheContent(result.getTempContent());
			nicheMapper.insertSelective(niche);
		} else if (result.getActionType().equals("RISK")) {// 风险
			/** 保存商机 */
			CimFTcRisk risk = new CimFTcRisk();
			risk.setTaskId(task.getTaskId());
			risk.setExecuteUser(cust.getBelongMgr());
			risk.setCustomerId(cust.getCustId());
			//risk.setActivityId(result.getActivityId());
			risk.setRiskContent(result.getTempContent());
			risk.setLastUpdateDt(new Date());
			risk.setLastUpdateUser("admin");
			risk.setExecuteUser(cust.getBelongMgr());
			riskMapper.insertSelective(risk);
		} else if (result.getActionType().equals("CARE")) {// 关注
			CimpTcCareInfo care=new CimpTcCareInfo();
			care.setTaskId(task.getTaskId());
			care.setExecuteUser(cust.getBelongMgr());
			care.setCustomerId(cust.getCustId());
			//care.setActivityId(result.getActivityId());
			care.setCareContent(result.getTempContent());
			care.setLastUpdateDt(new Date());
			care.setLastUpdateUser("admin");
			care.setExecuteUser(cust.getBelongMgr());
			careMapper.insertSelective(care);
		}
		
	}
	/**查询流程中是否存在短信渠道节点**/
	public boolean getflow(String message, String nodeId,List<CmFRcRuleResult> list) {
		boolean flag = false;
		CimpCmNodeinfo node = nodeService.selectByPrimaryKey(nodeId);
		List<Map<String,String>> nodeList = nodeMapper.getNodeInfo(node.getTempId());
		for (int i = 0; i < nodeList.size(); i++) {
			if (nodeList.get(i).get("assemblyId").equals("46")) {//判断节点是否是营销平台
				QueryModel queryModel = new QueryModel();
				queryModel.getCondition().put("eventId", nodeId);
				//List<Map<String, Object>> list = mapper.getResult(queryModel);
				for (int j = 0; j < list.size(); j++) {
					//Map<String, Object> map =list.get(j);
					CmFRcRuleResult info=list.get(j);
//					info.setId(map.get("id").toString());
//					info.setActionObjId(map.get("actionObjId").toString());
//					info.setActionObjName(map.get("actionObjName").toString());
//					info.setActionType(map.get("actionType").toString());
//					info.setActivityId(map.get("activityId").toString());
//					info.setAssemblyId(map.get("assemblyId").toString());
//					info.setChannel(map.get("channel").toString());
//					info.setCreateDate(map.get("createDate").toString());
//					info.setCustId(map.get("custId").toString());
//					info.setCustName(map.get("custName").toString());
//					info.setEventId(map.get("eventId").toString());
//					info.setEventName(map.get("eventName").toString());
//					info.setParentActionId(map.get("parentActionId").toString());
//					info.setSequenceId(map.get("sequenceId").toString());
//					info.setTempContent(map.get("tempContent").toString());
//					info.setTransactionCode(map.get("transactionCode").toString());
//					info.setTransactionType(map.get("transactionType").toString());
					bulidTaskInfo(info);
				}
				flag = true;
			}else if(nodeList.get(i).get("classId").equals("4")) {//判断节点是否是渠道类节点
				QueryModel queryModel = new QueryModel();
				queryModel.getCondition().put("eventId", nodeId);
				List<Map<String, Object>> list1 = mapper.getResult(queryModel);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
				List<Object> logList = new ArrayList<Object>();
				for (int j = 0; j < list.size(); j++) {
					Map<String, Object> map = new HashMap<>();
					map.put("CUST_ID", list1.get(j).get("custId"));
					map.put("CONTACT_NUMBER", list1.get(j).get("contactNumber"));
					map.put("TEMP_CONTENT", list1.get(j).get("tempContent"));
					logList.add(map);
				}
				// jsonCareStr = String.Join.writeValueAsString(logList);

				ObjectMapper mapper = new ObjectMapper();

				String outMsg = null;
				try {
					outMsg = mapper.writeValueAsString(logList);
				} catch (JsonProcessingException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				CmFRcRuleResultLog log = new CmFRcRuleResultLog();
				log.setInMessage(message);
				log.setOutMessage(outMsg);
				log.setMessageDate(df.format(new Date()));
				logMapper.insertSelective(log);
				flag = true;
			} else {
				flag = false;
			}
		}
		return flag;
	}
}