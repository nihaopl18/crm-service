package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.indexplan.domain.YscimcIndexStatePo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketPositCt;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplanVo;
import cn.com.yusys.yusp.cm.market.domain.MarketActionAndCase;
import cn.com.yusys.yusp.cm.market.form.ActivityReqForm;
import cn.com.yusys.yusp.cm.market.form.MarketPlanReqForm;
import cn.com.yusys.yusp.cm.market.service.ChannelProcessService;
import cn.com.yusys.yusp.cm.market.service.CimpCmMarketPlanService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 营销活动策划——营销活动管理
 * @author zhanghan3
 * 20181113
 */
@RestController
@RequestMapping("/api/marketplan")
public class CimpCmMarketPlanResource extends CommonResource<CimpCmMarketplan, Serializable>{
	
	@Autowired
	private CimpCmMarketPlanService marketPlanService;
	@Autowired
	private ChannelProcessService processService;
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.marketPlanService;
	}

	@PostMapping("/result")
	public ResultDto<List<CimpCmMarketplan>> getResultList(@RequestBody MarketPlanReqForm reqForm) {
		List<CimpCmMarketplan> resultList = marketPlanService.getResultList(reqForm);
		return new ResultDto<List<CimpCmMarketplan>>(resultList);
	}
	//活动指标分配状态查询
	@PostMapping("/indexstate")
	public ResultDto<List<YscimcIndexStatePo>> getIndexState(@RequestBody ActivityReqForm reqForm) {
		return  new ResultDto<>(marketPlanService.getIndexState(reqForm));
	}
	@GetMapping("/list")
	public ResultDto<List<CimpCmMarketplanVo>> getNodeList(
			QueryModel queryModel) {
		List<CimpCmMarketplanVo> list = marketPlanService.getMarketPlanList(queryModel);
		return new ResultDto<>(list);
	}

	/**查询当前机构及子机构的活动
	 *IndexDistribution
	 * @param orgCode
	 * @return
	 */
	@GetMapping("/listbyorg")
	public ResultDto<List<CimpCmMarketplan>> getMarketPlanListByOrgCode(String orgId,String keyWord) {
		List<CimpCmMarketplan> list = marketPlanService.getMarketPlanListByOrgCode(orgId,keyWord);
		return new ResultDto<List<CimpCmMarketplan>>(list);
	}

	/**
	 * 模糊查询
	 * @param keyWord
	 * @return
	 */
	@GetMapping("/fuzzyquery")
	public ResultDto<List<CimpCmMarketplan>> getMarketPlanListByFuzzyQuery(String keyWord) {
		List<CimpCmMarketplan> list = marketPlanService.getMarketPlanListByFuzzyQuery(keyWord);
		return new ResultDto<List<CimpCmMarketplan>>(list);
	}
	@GetMapping("/accuratequery")
	public ResultDto<CimpCmMarketplan> getMarketPlanListByAccurateQuery(String activityId,String activityName) {
		CimpCmMarketplan marketPlanListByAccurateQuery = marketPlanService.getMarketPlanListByAccurateQuery(activityId, activityName);
		return new ResultDto<CimpCmMarketplan>(marketPlanListByAccurateQuery);
	}
	/**
	 * 保存组件中的营销位内容信息
	 * @param 
	 * @return
	 */
	@PostMapping("/savemktpositcontent")
	public ResultDto<Object> saveMktPositContent(@RequestBody List<CimpCmMarketPositCt> data) throws ParseException {
		Map<String,Object> reuslt=new HashMap<String,Object>();
		reuslt=this.marketPlanService.saveMktPositContent(data);
		return new ResultDto<>(reuslt);	
	}
	
	@PostMapping("/delmktpositcont")
	public ResultDto<Object> deleteMktPositContent(String nodeId){
		marketPlanService.deleteMktPositContent(nodeId);
		return new ResultDto<>();
	}
	
	/**
	 * 复制流程信息
	 * @param flowId
	 * @return
	 */
	@PostMapping("/copyflowinfo")
	public ResultDto<Object> CopyFlowInfo(String flowId){
		Map<String,String> reuslt=new HashMap<String,String>();
		try {
			reuslt=marketPlanService.copyFlowInfo(flowId);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultDto<Object>(reuslt);
	}

	@PostMapping("/copytomarketcase")
	public ResultDto<Object> copyToMarketCase(@RequestBody MarketActionAndCase marketActionAndCase){
		String marketActionId = marketActionAndCase.getMarketActionId();
		String marketCaseId = marketActionAndCase.getMarketCaseId();
		Map<String,String> result=new HashMap<String,String>();
		try {
			result=marketPlanService.copyToMarketCase(marketActionId,marketCaseId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return new ResultDto<Object>(result);
	}
	/**
	 * 根据主键 查询信息
	 * @param flowId
	 * @return
	 */
	@GetMapping("/getplanbyid")
	public ResultDto<CimpCmMarketplan> getPlanById(String flowId){
		return new ResultDto<CimpCmMarketplan>(marketPlanService.selectByPrimaryKey(flowId));
	}
	
	@PostMapping("/createplan")
	public ResultDto<CimpCmMarketplan> createPlan(@RequestBody CimpCmMarketplanVo cimpCmMarketplan) throws Exception {
		return new ResultDto<>(this.marketPlanService.add(cimpCmMarketplan));	
	}
	
	@PostMapping("/updateplan")
	public ResultDto<CimpCmMarketplan> updatePlan(@RequestBody CimpCmMarketplanVo cimpCmMarketplan) throws ParseException {
		CimpCmMarketplan update = this.marketPlanService.update(cimpCmMarketplan);
		return new ResultDto<>(update);
	}
	
	@PostMapping("/del/{ids}")
	public ResultDto<Integer> del(@PathVariable String ids) {
		return new ResultDto<Integer>(this.marketPlanService.deletePlan(ids));
	}
	/**
	 * 
	* @方法名称: excFlow
	* @方法描述: 执行客户名单营销类的流程
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/excflow")
	public ResultDto<Object> excFlow( String flowId) {
		Map<String, Object>  result=processService.executeFlow(flowId);
		marketPlanService.updateFlowStsById(flowId,"02");
		return new ResultDto<Object>(result);
	}
	/**
	 * 
	* @方法名称: excFlow
	* @方法描述: 执行客户名单营销类的流程
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/updateplansts")
	public ResultDto<Object> updatePlanSts(@RequestBody CimpCmMarketplan cimpCmMarketplan) {
		try {
			marketPlanService.updateSts(cimpCmMarketplan);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultDto<Object>("success");
	}
	/**
	 * 
	* @方法名称: queryFieldsInfo
	* @方法描述: 查询事件流程中的事件组件的fields信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/querfieldsinfo")
	public ResultDto<List<Map<String, Object>>> queryFieldsInfo( String flowId) {
		List<Map<String, Object>>  result=marketPlanService.getfieldsInfo(flowId);
		return new ResultDto<List<Map<String, Object>>>(result);
	}
	/**
	 * 
	* @方法名称: getmktPositContent
	* @方法描述: 获取节点营销位内容信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getmktpositcontent")
	public ResultDto<List<Map<String, Object>>> getmktPositContent( String nodeId) {
		List<Map<String, Object>> result = marketPlanService.getmktPositContent(nodeId);
		return new ResultDto<List<Map<String, Object>>>(result);
	}


	/**
	 * 根据主键 查询信息
	 * @param tempId
	 * @return
	 */
	@GetMapping("/getActBaseInfobyid")
	public ResultDto<Map<String, Object>> getActBaseInfobyid(String tempId){
		return new ResultDto<>(marketPlanService.getActBaseInfobyid(tempId));
	}

	// 根据条件查询列表信息
	@GetMapping("/getListByCondition")
	public ResultDto<List> getListByCondition(QueryModel model){
		return  new ResultDto<>(marketPlanService.getListByCondition(model));
	}


}
