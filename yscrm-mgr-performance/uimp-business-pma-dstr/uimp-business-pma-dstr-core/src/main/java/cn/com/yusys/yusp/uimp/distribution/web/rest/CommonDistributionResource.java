package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import cn.com.yusys.yusp.uimp.distribution.service.CommonDistributionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonDistributionResource
 * @类描述: # 业绩公共接口 资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-07 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Api(tags = "业绩公共接口")
@RestController
@RequestMapping("/api/commondistribution")
public class CommonDistributionResource {

	@Autowired
	private CommonDistributionService commonDistributionService;
	

	/**
	 * @方法名称: getImportFunInfo
	 * @方法描述: 获取业绩批量导入的业务类型列表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "获取业绩批量导入的业务类型列表")
	@GetMapping("/getImportFunInfo")
	public ResultDto<List<AdminBaseMetaFunReg>> getImportFunInfo() {
		ResultDto<List<AdminBaseMetaFunReg>> result = new ResultDto<List<AdminBaseMetaFunReg>>();
		try {
			List<AdminBaseMetaFunReg> list = commonDistributionService.getImportFunInfo();
			if(list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			result.setCode(-2);
			result.setMessage("系统异常");
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * @方法名称: getImportFunInfo
	 * @方法描述: 获取业绩批量导入的业务类型列表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "获取业绩批量导入的业务类型列表")
	@GetMapping("/getClaimFunInfo")
	public ResultDto<List<AdminBaseMetaFunReg>> getClaimFunInfo() {
		ResultDto<List<AdminBaseMetaFunReg>> result = new ResultDto<List<AdminBaseMetaFunReg>>();
		try {
			List<AdminBaseMetaFunReg> list = commonDistributionService.getClaimFunInfo();
			if(list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
			} else {
				result.setCode(-1);
				result.setMessage("未查到数据！");
			}
		} catch (Exception e) {
			result.setCode(-2);
			result.setMessage("系统异常");
			e.printStackTrace();
		}
		return result;
	}
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
		List<Map<String, Object>> list = this.commonDistributionService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: saveData
	 * @方法描述: 审批通过
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "审批通过", notes = "审批通过")
	@PostMapping("/saveData")
	public Map<String, Object> saveData(@RequestBody Map<String,Object> map) throws Exception {
		 return commonDistributionService.saveDataEchain4(map);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: queryPeriodTable
	 * @方法描述: 查询区间表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询区间表", notes = "查询区间表")
	@GetMapping("/queryPeriodTable")
	public ResultDto<List<Map<String, Object>>> queryPeriodTable(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.commonDistributionService.queryPeriodTable(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: queryDistributeTable
	 * @方法描述: 查询分配关系表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询分配关系表", notes = "查询分配关系表")
	@GetMapping("/queryDistributeTable")
	public ResultDto<List<Map<String, Object>>> queryDistributeTable(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.commonDistributionService.queryDistributeTable(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @throws Exception 
	 * @方法名称: queryPeriodHisTable
	 * @方法描述: 查询区间历史表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询区间历史表", notes = "查询区间历史表")
	@GetMapping("/queryPeriodHisTable")
	public ResultDto<List<Map<String, Object>>> queryPeriodHisTable(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.commonDistributionService.queryPeriodHisTable(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @throws Exception 
	 * @方法名称: queryPeriodHisTable
	 * @方法描述: 查询区间历史表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询区间历史表", notes = "查询区间历史表")
	@GetMapping("/queryPeriodHisTableVet")
	public ResultDto<List<Map<String, Object>>> queryPeriodHisTableVet(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.commonDistributionService.queryPeriodHisTableForVet(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: queryDistributeHisTable
	 * @方法描述: 查询分配关系历史表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询分配关系历史表", notes = "查询分配关系历史表")
	@GetMapping("/queryDistributeHisTable")
	public ResultDto<List<Map<String, Object>>> queryDistributeHisTable(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.commonDistributionService.queryDistributeHisTable(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @throws Exception 
	 * @方法名称: queryEtlState
	 * @方法描述: 查询跑批状态表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询跑批状态表", notes = "查询跑批状态表")
	@GetMapping("/queryEtlState")
	public Map<String, Object> queryEtlState() throws Exception {
		return this.commonDistributionService.queryEtlState();
	}
	/**
	 * @throws Exception 
	 * @方法名称: queryTimeState
	 * @方法描述: 查询定版日
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询定版日", notes = "查询定版日")
	@GetMapping("/queryTimeState")
	public Map<String, Object> queryTimeState() throws Exception {
		return this.commonDistributionService.queryTimeState();
	}
	/**
	 * @throws Exception 
	 * @方法名称: approve
	 * @方法描述: 审批接口
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "审批接口", notes = "审批接口")
	@PostMapping("/approve")
	public ResultDto<String> approve(@RequestBody Map<String,Object> map) throws Exception {
		return this.commonDistributionService.approveEchain4(map);
	}
	/**
	 * @throws Exception 
	 * @方法名称: approve
	 * @方法描述: 审批接口
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "审批接口", notes = "审批接口")
	@PostMapping("/refuse")
	public ResultDto<String> refuse(@RequestBody Map<String,Object> map) throws Exception {
		return this.commonDistributionService.reject(map);
	}
}
