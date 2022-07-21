package cn.com.yusys.climp.acty.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.sequence.service.SequenceTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.acty.domain.LoyEngRuleAction;
import cn.com.yusys.climp.acty.domain.LoyEngRuleComparison;
import cn.com.yusys.climp.acty.domain.LoyEngRuleInfo;
import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleActionMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleComparisonMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleInfoMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleSetMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngTransactionRoutingMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleInfoService
 * @类描述: 积分规则服务类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:29
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyEngRuleInfoService extends CommonService {
	@Autowired
	private LoyEngRuleInfoMapper loyEngRuleInfoMapper;
	@Autowired
	private LoyEngRuleComparisonMapper comMapper;
	@Autowired
	private LoyEngRuleActionMapper actionMapper;
	@Autowired
	private LoyRlActivityService actyService;
	@Autowired
	private LoyEngRuleActionService loyEngRuleActionService;
	@Autowired
	private SequenceTemplateService sequenceConfigService;
	@Autowired
	private LoyEngRuleSetMapper loyEngRuleSetMapper;
	@Autowired
	private LoyEngTransactionRoutingMapper loyEngTransactionRoutingMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return loyEngRuleInfoMapper;
	}

	/**
	 * @方法名称:queryRule
	 * @方法描述:积分规则查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public List<Map<String, String>> queryRule(QueryModel model) {
		// 设置分页查询参数(设置到线程变量中了)
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = loyEngRuleInfoMapper.queryRule(model);
		// 清除线程绑定的分页参数，防止影响同线程的其他查询
		PageHelper.clearPage();
		return list;
	}

	/**
	 * @方法名称:validDateCode
	 * @方法描述:有效期查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> validDateCode() {
		return loyEngRuleInfoMapper.validDateCode();
	}

	/**
	 * @方法名称:queryScoreAccount
	 * @方法描述:查询积分账户类型
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryScoreAccount() {
		return loyEngRuleInfoMapper.queryScoreAccount();
	}

	/**
	 * @方法名称:queryTransCode
	 * @方法描述:交易字段查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryTransCode(String transactionCode) {
		return loyEngRuleInfoMapper.queryTransCode(transactionCode);
	}

	/**
	 * @方法名称:queryScoreAccount
	 * @方法描述:查询引用参数字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryRuleParams() {
		return loyEngRuleInfoMapper.queryRuleParams();
	}

	/**
	 * @方法名称:queryTransCode
	 * @方法描述:查询交易类型的金额字段与引用参数的数据字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryNumTransCode(String transactionCode) {
		return loyEngRuleInfoMapper.queryNumTransCode(transactionCode);
	}

	/**
	 * @方法名称:verificationActivity
	 * @方法描述:活动校验
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> verificationActivity(String activityId) {
		return loyEngRuleInfoMapper.verificationActivity(activityId);
	}

	/**
	 * @方法名称:verificationRule
	 * @方法描述:规则校验
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> verificationRule(QueryModel model) {
		return loyEngRuleInfoMapper.verificationRule(model);
	}
	/**
	* @方法名称:getActionByRuleId
	* @方法描述:根据规则id查询动作
	* @参数与返回说明:
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getActionByRuleId(String ruleId) {
		return loyEngRuleInfoMapper.getActionByRuleId(ruleId);
	}
	/***
	 * 序列号
	 * 
	 * @return
	 */
	public String generateNumber() {
		return sequenceConfigService.getNextSeq("ID_SEQUENCES");
	}

	/**
	 * @方法名称:deleteBatch
	 * @方法描述:批量删除规则信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public int deleteBatch(String idStr, String activityId, String nodeId) {
		int n = 0;
		LoyRlActivity activity = new LoyRlActivity();
		if("".equals(nodeId)) {
			activity = actyService.selectByPrimaryKey(activityId);
		}else {
			activity = actyService.getActiveForm(nodeId);
		}
		
		// 如果状态不是未提交状态，则将状态更改为已修改
		if (!"997".equals(activity.getWfApprSts())) {
			// activity.setWfApprSts("5");
			// 如果状态是启用，则修改后变更为停用
			if ("1".equals(activity.getUseFlag())) {
				activity.setUseFlag("0");
				loyEngRuleSetMapper.deleteRuleSet(activity.getActivityId());
				loyEngTransactionRoutingMapper.deleteRouting(activity.getActivityId());
			}
			actyService.updateSelective(activity);
		}
		n = loyEngRuleInfoMapper.delRule(idStr);// 删除规则信息
		comMapper.delOtherCom();// 删除规则比较
		actionMapper.delOtherAction();// 删除规则动作
		return n;
	}

	/**
	 * @方法名称:saveRule
	 * @方法描述:保存积分规则
	 * @参数与返回说明:
	 * @算法描述: update 2019-03-26 chenlin 权益引擎改造
	 */
	public int saveRule(LoyEngRuleInfo ruleInfo, List<LoyEngRuleComparison> conditionJsonList,
			List<LoyEngRuleAction> actionList/* , LoyEngRuleAction ruleAction */) {
		int count = 0;
		StringBuffer conditionFormula = new StringBuffer();// 条件公式
		// 组装条件公式
		for (LoyEngRuleComparison conditionJson : conditionJsonList) {
			if (!"".equals(conditionFormula.toString())) {
				conditionFormula.append(" && ");
			}
			generateFormula(conditionFormula, conditionJson);
		}
		ruleInfo.setCondition("".equals(conditionFormula.toString()) ? "1=1" : conditionFormula.toString());
		
		// 判断是新增规则还是修改规则
		if (null != ruleInfo.getId()) {
			// 删除原有的规则条件
			comMapper.delComparison(ruleInfo.getId());
			actionMapper.delAction(ruleInfo.getId());
			count = this.updateSelective(ruleInfo);
		} else {
			ruleInfo.setId(BigDecimal.valueOf(Long.parseLong(generateNumber())));
			count = this.insertSelective(ruleInfo);
		}
		// 循环取动作保存
		for (int j = 0; j < actionList.size(); j++) {
			LoyEngRuleAction ruleAction = actionList.get(j);
			String formulaValue = String.valueOf(ruleAction.getFormulaValue());
			String formulaField = ruleAction.getFormulaField();
			// 计算方式
			if ("1".equals(ruleAction.getFormulaWay())) {// 固定分值
				ruleAction.setActionFormula(formulaValue);
				ruleAction.setActionFormulaMean(formulaValue);
			} else if ("2".equals(ruleAction.getFormulaWay())) {// 按金额
				ruleAction.setActionFormula("@" + formulaField + " * " + formulaValue);// formulaValue如： 5/1000,表示每1000元得5分
				ruleAction.setActionFormulaMean(formulaField + "#@#" + formulaValue);
			} else if ("3".equals(ruleAction.getFormulaWay())) {// 按区间
				String scoreType = ruleAction.getScoreType();
				StringBuffer sbFormula = new StringBuffer("IF[");
				StringBuffer sbFormulaMean = new StringBuffer(formulaField + ":" + scoreType + "#@#");
				JSONArray array = JSON.parseArray(formulaValue);
				for (int i = array.size() - 1; i >= 0; i--) {
					JSONObject formula = (JSONObject) array.get(i);
					sbFormula.append("@" + formulaField + ">=");
					sbFormula.append(formula.get("scoreLow") + ":");
					sbFormula.append(formula.get("scoreValue") + ";");

					sbFormulaMean.append(formula.get("scoreLow") + ":");
					sbFormulaMean.append(formula.get("scoreValue") + ";");
				}
				sbFormula.append("0]");
				if ("2".equals(scoreType)) {
					sbFormula.append("*@" + formulaField);// 按实际金额计算
					// sbFormula.append("*@" + formulaField + "/10000");//按万元计算
				}
				ruleAction.setActionFormula(sbFormula.toString());
				ruleAction.setActionFormulaMean(sbFormulaMean.toString());
			} else if ("4".equals(ruleAction.getFormulaWay())) {// 按公式
				String[] valArr = formulaValue.split("#@#");
				ruleAction.setActionFormula(valArr[0]);
				ruleAction.setActionFormulaMean(formulaValue);
			}
//			if (ruleAction.getMaxScore() != null && StringUtils.isNotBlank(ruleAction.getMaxScore())) {
//				ruleAction.setMaxScore(BigDecimal.valueOf(Long.valueOf(ruleAction.getMaxScore())));
//			} else if ("".equals(ruleAction.getMaxScore())) {
//				ruleAction.setMaxScore(BigDecimal.valueOf(0));
//			}
			// 动作配置
			ruleAction.setRuleId(ruleInfo.getId());
			ruleAction.setClassName("com.yuchengtech.us.bns.BnsActionImpl");
//			if (null == ruleAction.getValidDate()) {
//				ruleAction.setValidDate(BigDecimal.valueOf(-1));
//			} else {
//				ruleAction.setValidDate(ruleAction.getValidDate());
//			}
			ruleAction.setId(null);
			// 判断是新增规则还是修改规则?
			if (null != ruleAction.getId()) {
				loyEngRuleActionService.updateSelective(ruleAction);
			} else {
				ruleAction.setId(BigDecimal.valueOf(Long.parseLong(generateNumber())));
				loyEngRuleActionService.insertSelective(ruleAction);
			}
		}
		// 保存条件
		for (int i = 0; i < conditionJsonList.size(); i++) {
			conditionJsonList.get(i).setRuleId(ruleInfo.getId());
			conditionJsonList.get(i).setId(BigDecimal.valueOf(Long.parseLong(generateNumber())));
			comMapper.insertSelective(conditionJsonList.get(i));
		}

		// 判断活动是什么状态，若是已通过
		LoyRlActivity activity = actyService.selectByPrimaryKey(ruleInfo.getRuleSetId().toString()); // (LoyRlActivity)
		// 如果状态不是未提交状态，则将状态更改为已修改
		if (!"000".equals(activity.getWfApprSts())) {
			activity.setWfApprSts("000");
			// 如果状态是启用，则修改后变更为停用
			if ("1".equals(activity.getUseFlag())) {
				activity.setUseFlag("0");
				loyEngRuleSetMapper.deleteRuleSet(activity.getActivityId());
				loyEngTransactionRoutingMapper.deleteRouting(activity.getActivityId());
			}
			actyService.updateSelective(activity);
		}
		return count;
	}

	/**
	 * @param ruleComparison
	 * @return
	 */
	private void generateFormula(StringBuffer sb, LoyEngRuleComparison ruleComparison) {
		sb.append(" ");
		int type = Integer.valueOf(ruleComparison.getVariableType());// 字段类型
		switch (type) {
		case 1: // 文本框
			generateStringField(sb, ruleComparison);
			break;
		case 2: // 数值框
			generateNumField(sb, ruleComparison);
			break;
		case 3: // 日期框
			generateDateField(sb, ruleComparison);
			break;
		case 4: // 下拉框
			generateComboField(sb, ruleComparison);
			break;
		case 5: // 单选框
			generateSingleField(sb, ruleComparison);
			break;
		case 6: // 多选框
			generateMultiField(sb, ruleComparison);
			break;
		case 7: // 放大镜
			generateMagnifierField(sb, ruleComparison);
			break;
		default:
			break;
		}
		sb.append(" ");
	}

	/**
	 * 文本框
	 * 
	 * @param sb
	 * @param ruleComparison
	 */
	private void generateStringField(StringBuffer sb, LoyEngRuleComparison ruleComparison) {
		int opertor = -1; // 比较符
		opertor = Integer.valueOf(ruleComparison.getOperator());
		String val = ruleComparison.getComparisionValue().replaceAll("'", "");
		switch (opertor) {
		case 1:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" = '");
			sb.append(val);
			sb.append("'");
			break;
		case 2:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" != '");
			sb.append(val);
			sb.append("'");
			break;
		case 3:
			sb.append("POS['");
			sb.append(val);
			sb.append("',");
			sb.append("@" + ruleComparison.getVariableName());
			sb.append("]>=0");
			break;
		case 4:
			sb.append("POS['");
			sb.append(val);
			sb.append("',");
			sb.append("@" + ruleComparison.getVariableName());
			sb.append("]<0");
			break;
		default:
			break;
		}
	}

	/**
	 * 数值框
	 * 
	 * @param sb
	 * @param ruleComparison
	 */
	private void generateNumField(StringBuffer sb, LoyEngRuleComparison ruleComparison) {
		int opertor = -1; // 比较符
		String[] valArr = (ruleComparison.getComparisionValue()).split("#@#");
		opertor = Integer.valueOf(ruleComparison.getOperator());
		switch (opertor) {
		case 1:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" = ");
			sb.append(valArr[0]);
			break;
		case 2:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" != ");
			sb.append(valArr[0]);
			break;
		case 3:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" > ");
			sb.append(valArr[0]);
			break;
		case 4:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" >= ");
			sb.append(valArr[0]);
			break;
		case 5:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" < ");
			sb.append(valArr[0]);
			break;
		case 6:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" <= ");
			sb.append(valArr[0]);
			break;
		case 7:
			if (Double.valueOf(valArr[0]) > Double.valueOf(valArr[1])) {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" <= ");
				sb.append(valArr[0]);
				sb.append(" && ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" >= ");
				sb.append(valArr[1] + ")");
			} else {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" >= ");
				sb.append(valArr[0]);
				sb.append(" && ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" <= ");
				sb.append(valArr[1] + ")");
			}
			break;
		case 8:
			if (Double.valueOf(valArr[0]) > Double.valueOf(valArr[1])) {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" < ");
				sb.append(valArr[0]);
				sb.append(" && ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" > ");
				sb.append(valArr[1] + ")");
			} else {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" > ");
				sb.append(valArr[0]);
				sb.append(" && ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" < ");
				sb.append(valArr[1] + ")");
			}
			break;
		case 9:
			if (Double.valueOf(valArr[0]) > Double.valueOf(valArr[1])) {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" >= ");
				sb.append(valArr[0]);
				sb.append(" || ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" <= ");
				sb.append(valArr[1] + ")");
			} else {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" <= ");
				sb.append(valArr[0]);
				sb.append(" || ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" >= ");
				sb.append(valArr[1] + ")");
			}
			break;
		case 10:
			if (Double.valueOf(valArr[0]) > Double.valueOf(valArr[1])) {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" > ");
				sb.append(valArr[0]);
				sb.append(" || ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" < ");
				sb.append(valArr[1] + ")");
			} else {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" < ");
				sb.append(valArr[0]);
				sb.append(" || ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" > ");
				sb.append(valArr[1] + ")");
			}
			break;
		default:
			break;
		}
		if (opertor < 7) {
			ruleComparison.setComparisionValue(valArr[0]);
		}
	}

	/**
	 * 日期框
	 * 
	 * @param sb
	 * @param ruleComparison
	 */
	private void generateDateField(StringBuffer sb, LoyEngRuleComparison ruleComparison) {
		int opertor = Integer.valueOf(ruleComparison.getOperator());
		String[] valArr = (ruleComparison.getComparisionValue()).split("#@#");
		switch (opertor) {
		case 1:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" = ");
			sb.append(valArr[0].replaceAll("-", ""));
			break;
		case 2:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" != ");
			sb.append(valArr[0].replaceAll("-", ""));
			break;
		case 3:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" > ");
			sb.append(valArr[0].replaceAll("-", ""));
			break;
		case 4:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" >= ");
			sb.append(valArr[0].replaceAll("-", ""));
			break;
		case 5:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" < ");
			sb.append(valArr[0].replaceAll("-", ""));
			break;
		case 6:
			sb.append("@" + ruleComparison.getVariableName());
			sb.append(" <= ");
			sb.append(valArr[0].replaceAll("-", ""));
			break;
		case 7:
			if (valArr[0].compareTo(valArr[1]) > 0) {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" <= ");
				sb.append(valArr[0].replaceAll("-", ""));
				sb.append(" && ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" >= ");
				sb.append(valArr[1].replaceAll("-", ""));
				sb.append(")");
			} else {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" >= ");
				sb.append(valArr[0].replaceAll("-", ""));
				sb.append(" && ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" <= ");
				sb.append(valArr[1].replaceAll("-", ""));
				sb.append(")");
			}
			break;
		case 8:
			if (valArr[0].compareTo(valArr[1]) > 0) {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" < ");
				sb.append(valArr[0].replaceAll("-", ""));
				sb.append(" && ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" > ");
				sb.append(valArr[1].replaceAll("-", ""));
				sb.append(")");
			} else {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" > ");
				sb.append(valArr[0].replaceAll("-", ""));
				sb.append(" && ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" < ");
				sb.append(valArr[1].replaceAll("-", ""));
				sb.append(")");
			}
			break;
		case 9:
			if (valArr[0].compareTo(valArr[1]) > 0) {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" >= ");
				sb.append(valArr[0].replaceAll("-", ""));
				sb.append(" || ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" <= ");
				sb.append(valArr[1].replaceAll("-", ""));
				sb.append(")");
			} else {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" <= ");
				sb.append(valArr[0].replaceAll("-", ""));
				sb.append(" || ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" >= ");
				sb.append(valArr[1].replaceAll("-", ""));
				sb.append(")");
			}
			break;
		case 10:
			if (valArr[0].compareTo(valArr[1]) > 0) {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" > ");
				sb.append(valArr[0].replaceAll("-", ""));
				sb.append(" || ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" < ");
				sb.append(valArr[1].replaceAll("-", ""));
				sb.append(")");
			} else {
				sb.append("(@" + ruleComparison.getVariableName());
				sb.append(" < ");
				sb.append(valArr[0].replaceAll("-", ""));
				sb.append(" || ");
				sb.append("@" + ruleComparison.getVariableName());
				sb.append(" > ");
				sb.append(valArr[1].replaceAll("-", ""));
				sb.append(")");
			}
			break;
		default:
			break;
		}
		// 去提分隔符： #@#
		if (opertor < 7) {
			ruleComparison.setComparisionValue(valArr[0]);
		}
	}

	/**
	 * 下拉框
	 * 
	 * @param sb
	 * @param ruleComparison
	 */
	private void generateComboField(StringBuffer sb, LoyEngRuleComparison ruleComparison) {
		sb.append("@" + ruleComparison.getVariableName());
		sb.append(" = '");
		sb.append(ruleComparison.getComparisionValue());
		sb.append("'");
	}

	/**
	 * 单选框
	 * 
	 * @param sb
	 * @param ruleComparison
	 */
	private void generateSingleField(StringBuffer sb, LoyEngRuleComparison ruleComparison) {
		sb.append("@" + ruleComparison.getVariableName());
		sb.append(" = '");
		sb.append(ruleComparison.getComparisionValue().length() > 0 ? (ruleComparison.getComparisionValue()) : "");
		sb.append("'");
	}

	/**
	 * 多选框
	 * 
	 * @param sb
	 * @param ruleComparison
	 */
	private void generateMultiField(StringBuffer sb, LoyEngRuleComparison ruleComparison) {
		int opertor = Integer.valueOf(ruleComparison.getOperator());
		String[] valArr = ruleComparison.getComparisionValue() == null ? null
				: (ruleComparison.getComparisionValue()).split(",");
		switch (opertor) {
		case 1:
			if (valArr != null) {
				String s = "";
				for (int i = 0; i < valArr.length; i++) {
					if (valArr[i] == null || "".equals(valArr[i])) {
						continue;
					}
					valArr[i] = valArr[i].length() > 0 ? (valArr[i]) : "";
					if (i > 0) {
						s += "," + valArr[i];
					} else {
						s += valArr[i];
					}
				}
				if (!"".equals(s)) {
					sb.append("POS[");
					sb.append("@" + ruleComparison.getVariableName());
					sb.append(",'");
					sb.append(s);
					sb.append("']>=0");
				}
			}
			break;
		case 2:
			if (valArr != null) {
				String s = "";
				for (int i = 0; i < valArr.length; i++) {
					if (valArr[i] == null || "".equals(valArr[i])) {
						continue;
					}
					valArr[i] = valArr[i].length() > 0 ? (valArr[i]) : "";
					if (i > 0) {
						s += "," + valArr[i];
					} else {
						s += valArr[i];
					}
				}
				if (!"".equals(s)) {
					sb.append("POS[");
					sb.append("@" + ruleComparison.getVariableName());
					sb.append(",'");
					sb.append(s);
					sb.append("']<0");
				}
			}
			break;
		default:
			break;
		}
	}

	/**
	 * 放大镜
	 * 
	 * @param sb
	 * @param ruleComparison
	 */
	private void generateMagnifierField(StringBuffer sb, LoyEngRuleComparison ruleComparison) {
		int opertor = Integer.valueOf(ruleComparison.getOperator());
		String ids = ruleComparison.getComparisionValue() == null ? null
				: (ruleComparison.getComparisionValue()).split("#@#")[0];
		String[] valArr = ids == null ? null : ids.split(",");
		switch (opertor) {
		case 1:
			if (valArr != null) {
				String s = "";
				for (int i = 0; i < valArr.length; i++) {
					if (valArr[i] == null || "".equals(valArr[i])) {
						continue;
					}
					if (i > 0) {
						s += "," + valArr[i];
					} else {
						s += valArr[i];
					}
				}
				if (!"".equals(s)) {
					sb.append("POS[@");
					sb.append(ruleComparison.getVariableName());
					sb.append(",'" + s);
					sb.append("']>=0");
				}
			}
			break;
		case 2:
			if (valArr != null) {
				String s = "";
				for (int i = 0; i < valArr.length; i++) {
					if (valArr[i] == null || "".equals(valArr[i])) {
						continue;
					}
					if (i > 0) {
						s += "," + valArr[i];
					} else {
						s += valArr[i];
					}
				}
				if (!"".equals(s)) {
					sb.append("POS[@");
					sb.append(ruleComparison.getVariableName());
					sb.append(",'" + s);
					sb.append("']<0");
				}
			}
			break;
		default:
			break;
		}
	}

	public Map<String, Object> getRole(QueryModel param) {
		Map<String, Object> result = new HashMap<String, Object>();
		if (param.getCondition().get("roleCode") != null || !param.getCondition().get("roleCode").equals("")) {
			String roleCode = param.getCondition().get("roleCode").toString();
			roleCode = "'" + roleCode.replaceAll(",", "','") + "'";
			List<Map<String, Object>> data = this.actionMapper.getRole(roleCode);
			result.put("data", data);
		} else {
			result.put("data", "");
		}
		return result;
	}
}
