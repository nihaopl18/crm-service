package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.service.CommonPerformanceTransService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonPerformanceTransResource
 * @类描述: # 业绩公共接口 资源类
 * @功能描述: 
 * @创建人: xujiawei
 * @创建时间: 2020-02-17 15:01:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Api(tags = "业绩转移接口")
@RestController
@RequestMapping("/api/commonPerformanceTrans")
public class CommonPerformanceTransResource {

	@Autowired
	private CommonPerformanceTransService commonPerformanceTransService;
	/**
	 * @throws Exception 
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> querylist(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.commonPerformanceTransService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @throws Exception 
	 * @方法名称: queryPerformance
	 * @方法描述: 业绩明细
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "业绩明细", notes = "业绩明细")
	@GetMapping("/queryPerformance")
	public ResultDto<List<Map<String, Object>>> queryPerformance(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.commonPerformanceTransService.queryPerformance(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @throws Exception 
	 * @方法名称: trans
	 * @方法描述: 业绩明细转移
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "业绩明细转移", notes = "业绩明细转移")
	@PostMapping("/trans")
	public ResultDto<String> trans(@RequestBody Map<String,Object> map) throws Exception {
		return this.commonPerformanceTransService.trans(map);
	}
	/**
	 * @throws Exception 
	 * @方法名称: transByManager
	 * @方法描述: 业绩明细转移
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "业绩转移", notes = "业绩转移")
	@PostMapping("/transByManager")
	public ResultDto<String> transByManager(@RequestBody Map<String,Object> map) throws Exception {
		return this.commonPerformanceTransService.transByManager(map);
	}
}
