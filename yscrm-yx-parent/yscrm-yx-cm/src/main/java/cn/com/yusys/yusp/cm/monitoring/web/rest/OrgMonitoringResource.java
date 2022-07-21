package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.monitoring.service.OrgMonitoringService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 营销监控
 * 
 * @author zhanghan3 20181116
 */
@RestController
@RequestMapping("/api/orgmonitoring")
public class OrgMonitoringResource extends CommonResource<CimpCmMarketplan, Serializable> {

	@Autowired
	private OrgMonitoringService orgMonitoringService;

	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.orgMonitoringService;
	}

	// 机构监控主查询
	@GetMapping("/list")
	public ResultDto<List<Map<String, Object>>> getList(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(orgMonitoringService.getList(model));
	}

	// 查询执行中任务下钻数据
	@GetMapping("/getIiplist")
	public ResultDto<List<Map<String, Object>>> getImpList(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(orgMonitoringService.getImpList(model));
	}

	// 查询执行成功任务下钻数据
	@GetMapping("/getsuccesslist")
	public ResultDto<List<Map<String, Object>>> getSuccessList(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(orgMonitoringService.getSuccessList(model));
	}

	// 查询执行失败任务下钻数据
	@GetMapping("/getfailedlist")
	public ResultDto<List<Map<String, Object>>> getFailedList(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(orgMonitoringService.getFailedList(model));
	}
}
