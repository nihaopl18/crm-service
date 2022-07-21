package cn.com.yusys.yusp.cm.ruleConfig.service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import cn.com.yusys.yusp.cm.market.repository.mapper.CimpCmNodeMapper;
import cn.com.yusys.yusp.cm.ruleConfig.domain.*;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.*;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.eng.CodeStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcEventConfigService
 * @类描述: 事件规则配置服务类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-23 14:28
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcEventConfigService extends CommonService {

	@SuppressWarnings("unused")
	private Logger logger = LoggerFactory.getLogger(CmFRcEventInfoService.class);
	@Autowired
	private CmFRcEventConfigMapper mapper;

	@Autowired
	private CmFRcRuleComparisonMapper comMapper;

	@Autowired
	private CmFRcEventInfoMapper eventMapper;

	@Autowired
	private CmFRcRuleConComparisonMapper conComMapper;

	@Autowired
	private CmFRcRuleActionMapper actionMapper;

	@Autowired
	private CmFRcRuleActionService actionService;
	@Autowired
	private CmFRcCareActionMapper careMapper;
	@Autowired
	private CmFRcRiskActionMapper riskMapper;
	@Autowired
	private CmFRcProActionMapper proMapper;
	@Autowired
	private CimpCmNodeMapper nodeMapper;
	@Autowired
	private UserInfoService userInfo;

	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}

	/**
	 * 查询某交易类型的字段
	 * 
	 * @param model
	 * @return
	 */
	public List<Map<String, Object>> queryTransCode(QueryModel model) {
		return mapper.queryTransCode(model);
	}

	/**
	 * 查询引用参数字段
	 * 
	 * @return
	 */
	public List<CmFRcRuleParam> queryRuleParams() {
		List<CmFRcRuleParam> list = mapper.queryRuleParams();
		return list;
	}

	public List<CmFRcRuleParam> queryParams() {
		List<CmFRcRuleParam> list = mapper.queryParams();
		return list;
	}

	/**
	 * 保存条件、引用参数的规则比较
	 * 
	 * @param list
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int saveComparison(List<CmFRcRuleComparison> list) {
		int count = 0;
		if (list.size() > 0) {
			// 如果存在先删除再添加
			List<CmFRcRuleComparison> comList = comMapper.getComByEventId(list.get(0).getEventId());
			if (comList.size() > 0) {
				for (int j = 0; j < comList.size(); j++) {
					comMapper.delete(comList.get(j));
				}
			}
			for (int i = 0; i < list.size(); i++) {
				comMapper.insertSelective(list.get(i));
			}
		}
		return count;
	}

	/**
	 * 保存连续动作规则比较
	 * 
	 * @param list
	 * @return
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int saveConCom(List<CmFRcRuleConComparison> list, String eventId) {
		int count = 0;
		// 如果存在先删除再添加
		List<CmFRcRuleConComparison> comList = conComMapper.getConComByEventId(eventId);
		if (comList.size() > 0) {
			for (int j = 0; j < comList.size(); j++) {
				conComMapper.delete(comList.get(j));
			}
		}
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				conComMapper.insertSelective(list.get(i));
			}
		}
		return count;
	}

	/**
	 * 更改事件的条件表达式
	 * 
	 * @param eventId
	 * @param condition
	 * @return
	 */
	public int upeventInfo(String eventId, String condition, String ruleDesc) {
		int count = 0;
		String orgCode = userInfo.getOrgCode();
		String loginCode = SecurityUtils.getCurrentUserLogin();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		CmFRcEventInfo event = eventMapper.selectByPrimaryKey(eventId);
		// 根据事件id查询出节点信息
		CimpCmNodeinfo node = nodeMapper.selectByPrimaryKey(eventId);
		if (node != null) {
			event.setActivityId(node.getTempId());// 设置活动id
		}
		event.setCondition(condition);
		event.setUpdateDate(df.format(new Date()));
		event.setUpdateUser(loginCode);
		event.setUpdateOrg(orgCode);
		event.setRuleDesc(ruleDesc);
		eventMapper.updateByPrimaryKeySelective(event);
		return count;
	}

	/**
	 * 根据事件id查询条件表达的规则比较
	 * 
	 * @param eventId
	 * @return
	 */
	public List<CmFRcRuleComparison> queryCondition(String eventId) {
		List<CmFRcRuleComparison> list = comMapper.getConditionByEventId(eventId);
		return list;
	}

	/**
	 * 根据事件id查询引用参数的规则比较
	 * 
	 * @param eventId
	 * @return
	 */
	public List<CmFRcRuleComparison> queryParam(String eventId) {
		List<CmFRcRuleComparison> list = comMapper.getParamByEventId(eventId);
		return list;
	}

	/**
	 * 根据事件id查询连续动作比较
	 * 
	 * @param eventId
	 * @return
	 */
	public List<CmFRcRuleConComparison> queryConComparison(String eventId) {
		List<CmFRcRuleConComparison> list = conComMapper.getConComByEventId(eventId);
		return list;
	}

	/**
	 * 根据事件id 查询动作主表
	 * 
	 * @param eventId
	 * @return
	 */
	public List<CmFRcRuleAction> queryAction(String eventId) {
		List<CmFRcRuleAction> list = actionMapper.getActionByEventId(eventId);
		return list;
	}

	/**
	 * 根据动作id和动作类型查询模板
	 * 
	 * @param actionId
	 * @param actionType
	 * @return
	 */
	public List<Map<String, Object>> getmodelList(String actionId, String actionType) {
		List<Map<String, Object>> list = actionMapper.getmodelList(actionId, actionType);
		return list;
	}

	/**
	 * 根据事件id删除动作主表信息
	 * 
	 * @param parmas
	 * @return
	 */
	public int deleteAction(String eventId) {
		int count = 0;
		actionMapper.delActionByEventId(eventId);
		return count;
	}

	/**
	 * 保存关注动作
	 * 
	 * @param t
	 * @param eventId
	 * @return
	 */
	// @Transactional(readOnly = false, rollbackFor = {Exception.class,
	// RuntimeException.class})
	public int saveCare(List<CmFRcCareAction> list, String eventId) {
		int count = 0;
		List<CmFRcCareAction> carelist = careMapper.getCareByEventId(eventId);
		if (carelist.size() > 0) {
			for (int j = 0; j < carelist.size(); j++) {
				careMapper.delete(carelist.get(j));
			}
		}
		deleteAction(eventId);
		if (list.size() > 0) {
			CmFRcRuleAction action = new CmFRcRuleAction();
			action.setEventId(eventId);
			action.setActionType("CARE");
			action.setClassName(CodeStringUtils.ENG_RESULT_CLASS_NAME);
			actionMapper.insertSelective(action);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setActionId(action.getId());
				careMapper.insertSelective(list.get(i));
			}
		}
		return count;
	}

	/**
	 * 保存风险动作
	 * 
	 * @param t
	 * @param eventId
	 * @return
	 */
	// @Transactional(readOnly = false, rollbackFor = {Exception.class,
	// RuntimeException.class})
	public int saveRisk(List<CmFRcRiskAction> list, String eventId) {
		int count = 0;
		List<CmFRcRiskAction> risklist = riskMapper.getRiskByEventId(eventId);
		if (risklist.size() > 0) {
			for (int j = 0; j < risklist.size(); j++) {
				riskMapper.delete(risklist.get(j));
			}
		}
		deleteAction(eventId);
		if (list.size() > 0) {
			CmFRcRuleAction action = new CmFRcRuleAction();
			action.setEventId(eventId);
			action.setActionType("RISK");
			action.setClassName(CodeStringUtils.ENG_RESULT_CLASS_NAME);
			actionMapper.insertSelective(action);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setActionId(action.getId());
				riskMapper.insertSelective(list.get(i));
			}
		}
		return count;
	}

	/**
	 * 保存产品动作
	 * 
	 * @param t
	 * @param eventId
	 * @return
	 */
	// @Transactional(readOnly = false, rollbackFor = {Exception.class,
	// RuntimeException.class})
	public int savePro(List<CmFRcProAction> list, String eventId) {
		int count = 0;
		List<CmFRcProAction> prolist = proMapper.getProByEventId(eventId);
		if (prolist.size() > 0) {
			for (int j = 0; j < prolist.size(); j++) {
				proMapper.delete(prolist.get(j));
			}
		}
		deleteAction(eventId);
		if (list.size() > 0) {
			CmFRcRuleAction action = new CmFRcRuleAction();
			action.setEventId(eventId);
			action.setActionType("PRODUCT");
			action.setClassName(CodeStringUtils.ENG_RESULT_CLASS_NAME);
			actionMapper.insertSelective(action);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).setActionId(action.getId());
				proMapper.insertSelective(list.get(i));
			}
		}
		return count;
	}

	public void marketActionOperation(CmFRcMarketAction cmFRcMarketAction, String eventId) {
		if (cmFRcMarketAction!=null){
			List<CmFRcCareAction> carelist = careMapper.getCareByEventId(eventId);
			//删除关怀的数据
			if (carelist.size() > 0) {
				for (int j = 0; j < carelist.size(); j++) {
					careMapper.delete(carelist.get(j));
				}
			}
			List<CmFRcRiskAction> risklist = riskMapper.getRiskByEventId(eventId);
			//删除风险的数据
			if (risklist.size() > 0) {
				for (int j = 0; j < risklist.size(); j++) {
					riskMapper.delete(risklist.get(j));
				}
			}
			List<CmFRcProAction> prolist = proMapper.getProByEventId(eventId);
			//删除产品的数据
			if (prolist.size() > 0) {
				for (int j = 0; j < prolist.size(); j++) {
					proMapper.delete(prolist.get(j));
				}
			}
			//删除规则动作数据
			deleteAction(eventId);
			//插入关怀数据
			List<CmFRcCareAction> careActionList = cmFRcMarketAction.getCareActionList();
			if (careActionList.size() > 0) {
				CmFRcRuleAction action = new CmFRcRuleAction();
				action.setEventId(eventId);
				action.setActionType("CARE");
				action.setClassName(CodeStringUtils.ENG_RESULT_CLASS_NAME);
				actionMapper.insertSelective(action);
				for (int i = 0; i < careActionList.size(); i++) {
					careActionList.get(i).setActionId(action.getId());
					careMapper.insertSelective(careActionList.get(i));
				}
			}
			//插入风险数据
			List<CmFRcRiskAction> riskActionList = cmFRcMarketAction.getRiskActionList();
			if (riskActionList.size() > 0) {
				CmFRcRuleAction action = new CmFRcRuleAction();
				action.setEventId(eventId);
				action.setActionType("RISK");
				action.setClassName(CodeStringUtils.ENG_RESULT_CLASS_NAME);
				actionMapper.insertSelective(action);
				for (int i = 0; i < riskActionList.size(); i++) {
					riskActionList.get(i).setActionId(action.getId());
					riskMapper.insertSelective(riskActionList.get(i));
				}
			}
			//插入产品数据
			List<CmFRcProAction> proActionList = cmFRcMarketAction.getProActionList();
			if (proActionList.size() > 0) {
				CmFRcRuleAction action = new CmFRcRuleAction();
				action.setEventId(eventId);
				action.setActionType("PRODUCT");
				action.setClassName(CodeStringUtils.ENG_RESULT_CLASS_NAME);
				actionMapper.insertSelective(action);
				for (int i = 0; i < proActionList.size(); i++) {
					proActionList.get(i).setActionId(action.getId());
					proMapper.insertSelective(proActionList.get(i));
				}
			}
		}
	}
}
