package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringUtil;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeIndexRel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeIndexRelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeIndexRelResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-20 10:36:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafschemeindexrel")
public class PmaFSchemeIndexRelResource extends CommonResource<PmaFSchemeIndexRel, String> {
    @Autowired
    private PmaFSchemeIndexRelService pmaFSchemeIndexRelService;

    @Override
    protected CommonService getCommonService() {
        return pmaFSchemeIndexRelService;
    }
	/**
	 * @throws Exception 
	 * @方法名称: queryIndex
	 * @方法描述: 查询指标数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/queryIndex")
	public ResultDto<List<Map<String, Object>>> queryIndex(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeIndexRelService.queryIndex(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	@ApiOperation(value = "评分模型-查询指标信息", notes = "评分模型-查询指标信息")
	@GetMapping("/queryIndexForScore")
	public ResultDto<List<Map<String, Object>>> queryIndexForScore(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeIndexRelService.queryIndexForScore(model);
		return new ResultDto<>(list);
	}







	/**
	 * @throws Exception 
	 * @方法名称: queryIndex
	 * @方法描述: 指标补录的指标放大镜查询逻辑
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "指标补录的指标放大镜", notes = "指标补录的指标放大镜")
	@GetMapping("/querySchemeIndex")
	public ResultDto<List<Map<String, Object>>> querySchemeIndex(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeIndexRelService.querySchemeIndex(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	@ApiOperation(value = "指标补录的指标放大镜", notes = "指标补录的指标放大镜")
	@GetMapping("/querySchemeAndIndex")
	public ResultDto<List<Map<String, Object>>> querySchemeAndIndex(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeIndexRelService.querySchemeAndIndex(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @throws Exception 
	 * @方法名称: delIndex
	 * @方法描述: 删除指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "删除指标", notes = "删除指标")
	@PostMapping("/delIndex")
	public ResultDto<String> delIndex(@RequestBody Map<String,Object> map) throws Exception {
		return pmaFSchemeIndexRelService.delIndex(map);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: queryNames
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询数据名称", notes = "查询数据名称")
	@GetMapping("/querynames")
	public ResultDto<String> queryNames(@RequestParam("objId") String objId) throws Exception {
		ResultDto<String> result = new ResultDto<String>();
    	if(StringUtil.isNotEmpty(objId)) {
    		String resultStr = pmaFSchemeIndexRelService.queryNames(objId);
    		if("-1".equals(resultStr)) {
    			result.setCode(-2);
       		  	result.setMessage("服务器忙，请稍后重试！");
    		} else if(StringUtil.isEmpty(resultStr)) {
    			result.setCode(-3);
       		  	result.setMessage("无相关数据！");
    		} else {
    			result.setCode(0);
       		  	result.setMessage("操作成功！");
       		  	result.setData(resultStr);
    		}
    	} else {
    		result.setCode(-1);
   		  	result.setMessage("请求参数错误！");
    	}
    	return result;
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: queryByMap
	 * @方法描述: 地图上查询下拉选
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据(分页)", notes = "查询列表数据(分页)")
	@GetMapping("/querybymap")
	public ResultDto<List<Map<String, Object>>> queryByMap(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeIndexRelService.queryByMap(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: queryIndex
	 * @方法描述: 首页方案指标放大镜查询逻辑
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "首页方案指标放大镜", notes = "首页方案指标放大镜")
	@GetMapping("/queryIndexByDash")
	public ResultDto<List<Map<String, Object>>> queryIndexByDash(QueryModel model){
		List<Map<String, Object>> list = this.pmaFSchemeIndexRelService.queryIndexByDash(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: querynamesbydash
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询数据名称", notes = "查询数据名称")
	@GetMapping("/querynamesbydash")
	public ResultDto<String> queryNamesByDash(@RequestParam("objId") String objId) throws Exception {
		ResultDto<String> result = new ResultDto<String>();
    	if(StringUtil.isNotEmpty(objId)) {
    		String resultStr = pmaFSchemeIndexRelService.queryNamesByDash(objId);
    		if("-1".equals(resultStr)) {
    			result.setCode(-2);
       		  	result.setMessage("服务器忙，请稍后重试！");
    		} else if(StringUtil.isEmpty(resultStr)) {
    			result.setCode(-3);
       		  	result.setMessage("无相关数据！");
    		} else {
    			result.setCode(0);
       		  	result.setMessage("操作成功！");
       		  	result.setData(resultStr);
    		}
    	} else {
    		result.setCode(-1);
   		  	result.setMessage("请求参数错误！");
    	}
    	return result;
	}
	
	@ApiOperation(value = "指标值调整的考核指标放大镜", notes = "指标值调整的考核指标放大镜")
	@GetMapping("/queryIndexRes")
	public ResultDto<List<Map<String, Object>>> queryIndexRes(QueryModel model){
		List<Map<String, Object>> list = this.pmaFSchemeIndexRelService.queryIndexRes(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
}
