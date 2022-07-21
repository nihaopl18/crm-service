package cn.com.yusys.yusp.cm.ruleConfig.web.rest;

import cn.com.yusys.yusp.cm.ruleConfig.domain.*;
import cn.com.yusys.yusp.cm.ruleConfig.service.CmFRcEventConfigService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcEventConfigResource
 * @类描述: 事件规则配置控制类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-29 10:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrceventconfig")
public class CmFRcEventConfigResource extends CommonResource<CmFRcEventInfo, Serializable>{

	@Autowired
	private CmFRcEventConfigService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	/**
	 * 查询某交易类型的字段
	 * @param transactionCode
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/querytranscode")
	public ResultDto<List<Map<String, Object>>> queryTransCode(@RequestParam(required = false) String transactionCode,QueryModel queryModel) {
		if(transactionCode!=null){
			queryModel.getCondition().put("transactionCode", transactionCode);
		}
		List<Map<String, Object>> maps = service.queryTransCode(queryModel);
		return new ResultDto<List<Map<String, Object>>>(maps);
	}
	/**
	 * 查询引用参数字段
	 * @return
	 */
	@GetMapping("/queryruleparams")
	public ResultDto<List<CmFRcRuleParam>> queryRuleParams() {
		List<CmFRcRuleParam> list = service.queryRuleParams();
		return new ResultDto<List<CmFRcRuleParam>>(list);
	}
	/**
	 * 保存条件、引用参数的规则比较
	 * @param t
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping("/savecomparison")
    public  ResultDto<Object> saveComparison(@RequestBody ArrayList<CmFRcRuleComparison> t)
            throws URISyntaxException {
    	 List<CmFRcRuleComparison> list = t;
    	 service.saveComparison(list);
         return new ResultDto<Object>();
    }
	/**
	 * 更改事件的条件表达式
	 * @param parmas
	 * @return
	 */
	@PostMapping("/upeventinfo")
	public ResultDto<Integer> upeventInfo(@RequestBody  Map<?,?> parmas) {
		String eventId=(String) parmas.get("eventId");
        String condition = (String) parmas.get("condition");
        String ruleDesc = (String) parmas.get("ruleDesc");
		return new ResultDto<Integer>(this.service.upeventInfo(eventId,condition,ruleDesc));
	}
	/**
	 * 保存连续动作规则比较
	 * @param t
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping("/saveconcom/{eventId}")
    public  ResultDto<Object> saveConCom(@RequestBody ArrayList<CmFRcRuleConComparison> t,@PathVariable String eventId)
            throws URISyntaxException {
    	 List<CmFRcRuleConComparison> list = t;
    	 service.saveConCom(list,eventId);
         return new ResultDto<Object>();
    }
	/**
	 * 根据事件id查询条件表达的规则比较
	 * @param eventId
	 * @return
	 */
	@GetMapping("/querycondition")
	public ResultDto<List<CmFRcRuleComparison>> queryCondition(@RequestParam(required = false) String eventId) {
    	return new ResultDto<List<CmFRcRuleComparison>>(service.queryCondition(eventId));
	}
	/**
	 * 根据事件id查询引用参数的规则比较
	 * @param eventId
	 * @return
	 */
	@GetMapping("/queryparam")
	public ResultDto<List<CmFRcRuleComparison>> queryParam(@RequestParam(required = false) String eventId) {
    	return new ResultDto<List<CmFRcRuleComparison>>(service.queryParam(eventId));
	}
	/**
	 * 根据事件id查询连续动作比较
	 * @param eventId
	 * @return
	 */
	@GetMapping("/queryconcomparison")
	public ResultDto<List<CmFRcRuleConComparison>> queryConComparison(@RequestParam(required = false) String eventId) {
    	return new ResultDto<List<CmFRcRuleConComparison>>(service.queryConComparison(eventId));
	}
	/**
	 * 根据事件id 查询动作主表
	 * @param eventId
	 * @return
	 */
	@GetMapping("/queryaction")
	public ResultDto<List<CmFRcRuleAction>> queryAction(@RequestParam(required = false) String eventId) {
    	return new ResultDto<List<CmFRcRuleAction>>(service.queryAction(eventId));
	}
	/**
	 * 根据动作id和动作类型查询模板
	 * @param actionId
	 * @param actionType
	 * @return
	 */
	@GetMapping("/querymodel")
	public ResultDto<List<Map<String, Object>>> getmodelList(@RequestParam(required = false) String actionId,String actionType) {
    	return new ResultDto<List<Map<String, Object>>>(service.getmodelList(actionId,actionType));
	}
	/**
	 * 根据事件id删除动作主表信息
	 * @param parmas
	 * @return
	 */
	@PostMapping("/deleteaction")
    public ResultDto<Integer> deleteAction(@RequestBody Map<?,?> parmas) {
        String eventId=parmas.get("eventId").toString();
        return new ResultDto<Integer>(this.service.deleteAction(eventId));
    }
	
	/**
	 * 保存关注动作
	 * @param t
	 * @param eventId
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping("/savecare/{eventId}")
    public  ResultDto<Object> saveCare(@RequestBody ArrayList<CmFRcCareAction> t,@PathVariable String eventId)
            throws URISyntaxException {
    	 List<CmFRcCareAction> list = t;
    	 service.saveCare(list,eventId);
         return new ResultDto<Object>();
    }
	/**
	 * 保存风险动作
	 * @param t
	 * @param eventId
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping("/saverisk/{eventId}")
    public  ResultDto<Object> saveRisk(@RequestBody ArrayList<CmFRcRiskAction> t,@PathVariable String eventId)
            throws URISyntaxException {
    	 List<CmFRcRiskAction> list = t;
    	 service.saveRisk(list,eventId);
         return new ResultDto<Object>();
    }
	/**
	 * 保存产品动作
	 * @param t
	 * @param eventId
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping("/savepro/{eventId}")
    public  ResultDto<Object> savePro(@RequestBody ArrayList<CmFRcProAction> t,@PathVariable String eventId)
            throws URISyntaxException {
    	 List<CmFRcProAction> list = t;
    	 service.savePro(list,eventId);
         return new ResultDto<Object>();
    }

	@PostMapping("/marketactionoperation/{eventId}")
	public ResultDto<Object> saveMarketAction(@RequestBody CmFRcMarketAction cmFRcMarketAction, @PathVariable String eventId)
			throws URISyntaxException {
		service.marketActionOperation(cmFRcMarketAction,eventId);
		return new ResultDto<Object>();
	}
}
