package cn.com.yusys.yusp.cm.marketanlaty.web.rest;

import cn.com.yusys.yusp.cm.marketanlaty.domain.OcrmFMkActivityInfo;
import cn.com.yusys.yusp.cm.marketanlaty.service.OcrmFMkActiAnlatyService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFMkActivityResource
 * @类描述：营销活动管理
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-03-23
 */
@RestController
@RequestMapping("/api/mkt")
public class OcrmFMkActiAnlatyResource extends CommonResource<OcrmFMkActivityInfo, Serializable>{
	@Autowired
	private OcrmFMkActiAnlatyService service;
	@Override
	protected CommonService getCommonService() {
		return service;
	}
	/**
	* @方法名称: actiTree
	* @方法描述: 营销活动分析树
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actitree")
	public ResultDto<List<Map<String,Object>>>actiTree(QueryModel model) {
		return new ResultDto<>(this.service.actiTree(model));
	}
	/**
	* @方法名称: actiAnlatyTarget
	* @方法描述: 营销成效分析指标查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actianlatytarget")
	public ResultDto<List<Map<String,Object>>> actiAnlatyTarget(QueryModel model) {
		return new ResultDto<>(this.service.actiAnlatyTarget(model));
	}
	/**
	* @方法名称: getTargetPie
	* @方法描述: 营销成效指标目标机构占比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/gettargetpie")
	public ResultDto<List<Map<String,Object>>> getTargetPie(QueryModel model) {
		return new ResultDto<>(this.service.getTargetPie(model));
	}
	/**
	* @方法名称: getTargetBar
	* @方法描述: 营销成效指标目标机构完成情况对比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/gettargetbar")
	public ResultDto<List<Map<String,Object>>> getTargetBar(QueryModel model) {
		return new ResultDto<>(this.service.getTargetBar(model));
	}
	/**
	* @方法名称: getCmBar
	* @方法描述: 营销成效指标目标客户经理进展图
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getcmbar")
	public ResultDto<List<Map<String,Object>>> getCmBar(QueryModel model){
		return new ResultDto<>(this.service.getCmBar(model));
	}
	/**
	* @方法名称: getCmPie
	* @方法描述: 营销成效指标目标客户经理占比图
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getcmpie")
	public ResultDto<List<Map<String,Object>>> getCmPie(QueryModel model){
		return new ResultDto<>(this.service.getCmPie(model));
	}
	/**
	* @throws ParseException 
	* @方法名称: getActUser
	* @方法描述: 营销活动反馈查询
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/actifedbacklist")
	public ResultDto<List<Map<String,Object>>> actiFedBackList (QueryModel model){
		return new ResultDto<>(this.service.actiFedBackList(model));
	}
}
