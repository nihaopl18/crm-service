package cn.com.yusys.yusp.uimp.displan.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.displan.domain.PmaFDisPlanInfo;
import cn.com.yusys.yusp.uimp.distribution.planDstr.service.PmaFDisPlanInfoService;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDisPlanInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-03-26 10:05:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafdisplaninfo")
public class PmaFDisPlanInfoResource extends CommonResource<PmaFDisPlanInfo, String> {
    @Autowired
    private PmaFDisPlanInfoService pmaFDisPlanInfoService;

    @Override
    protected CommonService getCommonService() {
        return pmaFDisPlanInfoService;
    }
	/**
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> querylist(QueryModel model) {
		List<Map<String, Object>> list = this.pmaFDisPlanInfoService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    @PostMapping("/add")
	@ApiOperation(value = "新增", notes = "新增")
	public ResultDto<PmaFDisPlanInfo> add(@RequestBody PmaFDisPlanInfo pmaFDisPlanInfo) throws Exception {
    	return pmaFDisPlanInfoService.add(pmaFDisPlanInfo);
    }
    @PostMapping("/edit")
	@ApiOperation(value = "修改", notes = "修改")
	public ResultDto<PmaFDisPlanInfo> modify(@RequestBody PmaFDisPlanInfo pmaFDisPlanInfo) throws Exception {
    	return pmaFDisPlanInfoService.modify(pmaFDisPlanInfo);
    }
	@ApiOperation(value = "删除", notes = "删除")
    @PostMapping("/delete")
	public ResultDto<Integer> del(@RequestBody String ids) {
    	return pmaFDisPlanInfoService.delete(ids);
    }
}
