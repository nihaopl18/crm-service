package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPersonpostParamInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.service.PmaFPersonpostParamInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFPersonpostParamInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-10 15:10:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "岗位参数管理")
@RequestMapping("/api/pmafpersonpostparaminfo")
public class PmaFPersonpostParamInfoResource extends CommonResource<PmaFPersonpostParamInfo, String> {
    @Autowired
    private PmaFPersonpostParamInfoService pmaFPersonpostParamInfoService;

    @Override
    protected CommonService getCommonService() {
        return pmaFPersonpostParamInfoService;
    }
    /**
  	 * @方法名称: querylist
  	 * @方法描述: 查询机构参数info信息
  	 * @参数与返回说明: 
  	 * @算法描述: 
  	 */
  	@ApiOperation(value = "查询岗位参数info信息", notes = "查询岗位参数info信息")
  	@GetMapping("/querylist")
  	public ResultDto<List<Map<String, Object>>> querylist(QueryModel model) {
  		List<Map<String, Object>> list = this.pmaFPersonpostParamInfoService.querylist(model);
  		return new ResultDto<List<Map<String, Object>>>(list);
  	}
 	@ApiOperation(value = "新增岗位参数info", notes = "新增岗位参数info")
    @PostMapping("/add")
	public ResultDto<PmaFPersonpostParamInfo> add(@RequestBody PmaFPersonpostParamInfo pmaFPersonpostParamInfo) throws Exception {
    	return pmaFPersonpostParamInfoService.add(pmaFPersonpostParamInfo);
    }
	@ApiOperation(value = "修改岗位参数info", notes = "修改岗位参数info")
    @PostMapping("/modify")
	public ResultDto<PmaFPersonpostParamInfo> modify(@RequestBody PmaFPersonpostParamInfo pmaFPersonpostParamInfo) throws Exception {
    	return pmaFPersonpostParamInfoService.modify(pmaFPersonpostParamInfo);
    }
	/**
	 * @方法名称: del
	 * @方法描述: 删除基础指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "删除岗位参数info", notes = "删除岗位参数info")
    @PostMapping("/delete")
	public ResultDto<Integer> del(@RequestBody String ids) {
    	return pmaFPersonpostParamInfoService.delete(ids);
    }
	/**
  	 * @方法名称: querypostlist
  	 * @方法描述:查询岗位参数树
  	 * @参数与返回说明: 
  	 * @算法描述: 
  	 */
  	@ApiOperation(value = "查询岗位参数树", notes = "查询岗位参数树")
  	@GetMapping("/querypostlist")
  	public ResultDto<List<Map<String, Object>>> querypostlist() {
  		List<Map<String, Object>> list = this.pmaFPersonpostParamInfoService.querypostlist();
  		return new ResultDto<List<Map<String, Object>>>(list);
  	}
  	
  	@ApiOperation(value = "根据参数编号查询参数名称", notes = "根据参数编号查询参数名称")
  	@GetMapping("/querynamebyparamid")
  	public ResultDto<String> queryNameByParamId(@RequestParam("paramId") String paramId) {
  		String paramName = this.pmaFPersonpostParamInfoService.queryNameByParamId(paramId);
  		return new ResultDto<String>(paramName);
  	}
}
