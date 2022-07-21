package cn.com.yusys.climp.acty.web.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import cn.com.yusys.climp.acty.domain.LoyEngRuleAction;
import cn.com.yusys.climp.acty.domain.LoyEngRuleComparison;
import cn.com.yusys.climp.acty.domain.LoyEngRuleInfo;
import cn.com.yusys.climp.acty.service.LoyEngRuleInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleInfoResource
 * @类描述: 积分规则资源类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:29
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ruleinfo")
public class LoyEngRuleInfoResource extends CommonResource<LoyEngRuleInfo, String> {
	
	private Logger logger = LoggerFactory.getLogger(LoyEngRuleInfoResource.class);
	
	@Autowired
	private LoyEngRuleInfoService loyEngRuleInfoService;

	@Override
	protected CommonService getCommonService() {
		return loyEngRuleInfoService;
	}

	/**
	 * @方法名称:queryRule
	 * @方法描述:积分规则查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/list")
	public ResultDto<List<Map<String, String>>> queryRule(QueryModel queryModel) {
		List<Map<String, String>> list = loyEngRuleInfoService.queryRule(queryModel);
		return new ResultDto<List<Map<String, String>>>(list);
	}

	/**
	 * @方法名称:queryScoreAccount
	 * @方法描述:查询积分账户类型
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/queryscoreaccount")
	public ResultDto<List<Map<String, Object>>> queryScoreAccount() {
		return new ResultDto<List<Map<String, Object>>>(loyEngRuleInfoService.queryScoreAccount());
	}

	/**
	 * @方法名称:queryTransCode
	 * @方法描述:交易字段查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/querytranscode")
	public ResultDto<List<Map<String, Object>>> queryTransCode(@RequestParam(required = false) String transactionCode) {
		return new ResultDto<List<Map<String, Object>>>(loyEngRuleInfoService.queryTransCode(transactionCode));
	}

	/**
	 * @方法名称:queryRuleParams
	 * @方法描述:查询引用参数字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/queryruleparams")
	public ResultDto<List<Map<String, Object>>> queryRuleParams() {
		return new ResultDto<List<Map<String, Object>>>(loyEngRuleInfoService.queryRuleParams());
	}

	/**
	 * @方法名称:queryTransCode
	 * @方法描述:查询交易类型的金额字段与引用参数的数据字段
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/querynumtranscode")
	public ResultDto<List<Map<String, Object>>> queryNumTransCode(
			@RequestParam(required = false) String transactionCode) {
		return new ResultDto<List<Map<String, Object>>>(loyEngRuleInfoService.queryNumTransCode(transactionCode));
	}
	
	/**
	 * @方法名称:validDateCode
	 * @方法描述:查询有效期
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/validdatecode")
	public ResultDto<List<Map<String, Object>>> validDateCode() {
		return new ResultDto<List<Map<String, Object>>>(loyEngRuleInfoService.validDateCode());
	}

	/**
	 * @方法名称:verificationActivity
	 * @方法描述:活动校验
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/verificationactivity")
	public ResultDto<List<Map<String, Object>>> verificationActivity(
			@RequestParam(required = false) String activityId) {
		return new ResultDto<List<Map<String, Object>>>(loyEngRuleInfoService.verificationActivity(activityId));
	}

	/**
	 * @方法名称:verificationRule
	 * @方法描述:规则校验
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/verificationrule")
	public ResultDto<List<Map<String, Object>>> verificationRule(QueryModel queryModel) {
		String[] variableNames = queryModel.getCondition().get("variableName").toString().split(",");
		// 将transferredG 转换为&
		for(int i =0; i< variableNames.length; i++) {
			variableNames[i] = variableNames[i].replaceAll("transferredG", "&");
		}
		queryModel.getCondition().put("variableName", variableNames);
		return new ResultDto<List<Map<String, Object>>>(loyEngRuleInfoService.verificationRule(queryModel));
	}
	/**
	* @方法名称:getRuleAction
	* @方法描述:根据规则id查询动作
	* @参数与返回说明:
	* @算法描述:
	 */
	@GetMapping("/getruleaction")
	public ResultDto<List<Map<String, Object>>> getActionByRuleId(@RequestParam(required = false)String ruleId) {
		List<Map<String, Object>> list = loyEngRuleInfoService.getActionByRuleId(ruleId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @方法名称:saveRule
	 * @方法描述:保存积分规则
	 * @参数与返回说明:
	 * @算法描述:
	 * update 2019-03-26 chenlin 权益引擎改造
	 */
	@PostMapping("/saverule")
	public ResultDto<Integer> saveRule(@RequestBody Map<?, ?> parmas) {
		String ruleInfoJson = parmas.get("ruleInfoJson").toString();
		String conditionJson = parmas.get("conditionJson").toString();
		String ruleFormulaJson = parmas.get("ruleFormulaJson").toString();
//		String actionConfigJson = parmas.get("actionConfigJson").toString();
		// 积分规则
		LoyEngRuleInfo ruleInfo = JSON.parseObject(ruleInfoJson, LoyEngRuleInfo.class);
		// 规则比较
		List<LoyEngRuleComparison> comList = JSON.parseArray(conditionJson, LoyEngRuleComparison.class);
		// 计算方式
		List<LoyEngRuleAction> formula = JSON.parseArray(ruleFormulaJson, LoyEngRuleAction.class);
		// 规则动作
//		LoyEngRuleAction action = JSON.parseObject(actionConfigJson, LoyEngRuleAction.class);
		return new ResultDto<Integer>(loyEngRuleInfoService.saveRule(ruleInfo, comList, formula));
	}

	/**
	 * @方法名称:deleteBatch
	 * @方法描述:根据规则id删除规则相关信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/deletebatch")
	public ResultDto<Integer> deleteBatch(@RequestBody Map<?, ?> map) {
		String idStr = map.get("id").toString();
		String activityId = map.get("activityId").toString();
		String nodeId = map.get("nodeId").toString();
		return new ResultDto<Integer>(loyEngRuleInfoService.deleteBatch(idStr, activityId, nodeId));
	}

	/**
	 * 
	* @方法名称: getrole
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getrole")
	public ResultDto<List<Map<String, Object>>> getRole(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			Map<String, Object> list = loyEngRuleInfoService.getRole(queryModel);
			List<Map<String, Object>> data=(List<Map<String, Object>>) list.get("data");
			if(data.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(data);
				reuslt.setTotal(Long.parseLong(list.get("total").toString()));
			}
			logger.info("角色信息查询");
		}catch (Exception e) {
			logger.error("角色信息查询", e);
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e.getMessage());
		}
		return reuslt;
	}
}
