package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.web.rest;

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
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFScheme;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFSchemeExcelService;
import io.swagger.annotations.ApiOperation;
import tk.mybatis.mapper.util.StringUtil;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 15:01:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafschemeexcel")
public class PmaFSchemeExcelResource extends CommonResource<PmaFScheme, String> {
    @Autowired
    private PmaFSchemeExcelService pmaFSchemeExcelService;

    @Override
    protected CommonService getCommonService() {
        return pmaFSchemeExcelService;
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
		List<Map<String, Object>> list = this.pmaFSchemeExcelService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
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
	public ResultDto<String> queryNames(@RequestParam("schemeId") String schemeId) throws Exception {
		ResultDto<String> result = new ResultDto<String>();
    	if(StringUtil.isNotEmpty(schemeId)) {
    		String resultStr = pmaFSchemeExcelService.queryNames(schemeId);
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
	 * @方法名称: addInfo
	 * @方法描述: 新增方案信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增方案信息", notes = "新增方案信息")
	@PostMapping("/addInfo")
	public ResultDto<PmaFScheme> addInfo(@RequestBody PmaFScheme pmaFScheme) throws Exception {
		return pmaFSchemeExcelService.addInfo(pmaFScheme);
	}
	/**
	 * @throws Exception 
	 * @方法名称: editInfo
	 * @方法描述: 修改方案信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "修改方案信息", notes = "修改方案信息")
	@PostMapping("/editInfo")
	public ResultDto<PmaFScheme> editInfo(@RequestBody PmaFScheme pmaFScheme) throws Exception {
		return pmaFSchemeExcelService.editInfo(pmaFScheme);
	}
	/**
	 * @throws Exception 
	 * @方法名称: delScheme
	 * @方法描述: 删除方案信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "删除方案信息", notes = "删除方案信息")
	@PostMapping("/delScheme")
	public ResultDto<String> delScheme(@RequestBody String schemeId) throws Exception {
		return pmaFSchemeExcelService.delScheme(schemeId);
	}
	/**
	 * @throws Exception 
	 * @方法名称: schemePub
	 * @方法描述: 方案启用停用
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "方案启用停用", notes = "方案启用停用")
	@PostMapping("/schemePub")
	public ResultDto<String> schemePub(@RequestBody Map<String,Object> map) throws Exception {
		return pmaFSchemeExcelService.schemePub(map);
	}
	/**
	 * @throws Exception 
	 * @方法名称: addObj
	 * @方法描述: 新增方案对象
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增方案对象", notes = "新增方案对象")
	@PostMapping("/addObj")
	public ResultDto<String> addObj(@RequestBody Map<String,Object> map) throws Exception {
		return pmaFSchemeExcelService.addObj(map);
	}
	/**
	 * @throws Exception 
	 * @方法名称: addIndex
	 * @方法描述: 新增指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增指标", notes = "新增指标")
	@PostMapping("/addIndex")
	public ResultDto<String> addIndex(@RequestBody Map<String,Object> map) throws Exception {
		return pmaFSchemeExcelService.addIndex(map);
	}
	/**
	 * @throws Exception 
	 * @方法名称: addInfo
	 * @方法描述: 新增方案信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增方案信息", notes = "新增方案信息")
	@PostMapping("/addSplit")
	public ResultDto<String> addSplit(@RequestBody Map<String,Object> map) throws Exception {
		return pmaFSchemeExcelService.addSplit(map);
	}
	/**
	 * @throws Exception 
	 * @方法名称: queryHomePageIndex
	 * @方法描述: 首页查询
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "首页查询", notes = "首页查询")
	@GetMapping("/queryHomePageIndex")
	public ResultDto<List<Map<String, Object>>> queryHomePageIndex(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeExcelService.queryHomePageIndex(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @throws Exception 
	 * @方法名称: queryHomePageIndexNew
	 * @方法描述: 首页查询
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "首页查询", notes = "首页查询")
	@GetMapping("/queryHomePageIndexNew")
	public ResultDto<List<Map<String, Object>>> queryHomePageIndexNew(QueryModel model) throws Exception {
		List<Map<String, Object>> list = this.pmaFSchemeExcelService.queryHomePageIndexNew(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
}
