package cn.com.yusys.yusp.cm.ruleConfig.web.rest;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventInfo;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleResult;
import cn.com.yusys.yusp.cm.ruleConfig.service.CmFRcRuleResultService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRuleResultResource
 * @类描述: 时间表单
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-11-19 10:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcruleresultresource")
public class CmFRcRuleResultResource extends CommonResource<CmFRcRuleResult, Serializable>{

	@Autowired
	private CmFRcRuleResultService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	/**
	 * 
	* @方法名称: getEventResult
	* @方法描述: 查询事件结果信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/resultlist")
	public ResultDto<List<CmFRcRuleResult>> getEventResult(
			QueryModel queryModel) {
		List<CmFRcRuleResult> list = service.getEventResult(queryModel);
		return new ResultDto<List<CmFRcRuleResult>>(list);
	}
	/**
	 * 根据事件id查询事件信息
	 * @param eventId
	 * @return
	 */
	@GetMapping("/geteventform")
	public ResultDto<CmFRcEventInfo> getEventForm(@RequestParam(required = false) String eventId) {
		CmFRcEventInfo obj = service.getEventForm(eventId);
		return new ResultDto<CmFRcEventInfo>(obj);
	}
	@GetMapping("/getmegin")
	public ResultDto<List<Map<String, Object>>> getMegIn(QueryModel queryModel) {
		List<Map<String, Object>> list = service.getMegIn(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * 查询短信输出参数
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/getmegout")
	public ResultDto<List<Map<String, Object>>> getMegOut(QueryModel queryModel) {
		List<Map<String, Object>> list = service.getMegOut(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
}
