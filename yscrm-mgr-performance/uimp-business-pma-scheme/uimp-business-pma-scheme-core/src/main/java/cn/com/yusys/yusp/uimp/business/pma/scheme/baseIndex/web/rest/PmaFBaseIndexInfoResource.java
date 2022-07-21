package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.web.rest;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.vo.PmaFBaseIndexInfoVO;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.RequestForm;
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
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexSql;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexType;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service.PmaFBaseIndexInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @项目名称: uimp-business-core模块
 * @类名称: PmaFBaseIndexInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2019-12-24 16:17:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "基础指标管理")
@RequestMapping("/api/pmafbaseindexinfo")
public class PmaFBaseIndexInfoResource extends CommonResource<PmaFBaseIndexInfo, String> {
    @Autowired
    private PmaFBaseIndexInfoService pmaFBaseIndexInfoService;

    @Override
    protected CommonService getCommonService() {
        return pmaFBaseIndexInfoService;
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
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	@ApiOperation(value = "新增基础指标info", notes = "新增基础指标info")
    @PostMapping("/add")
	public ResultDto<PmaFBaseIndexInfo> add(@RequestBody PmaFBaseIndexInfo pmaFBaseIndexInfo) throws Exception {
    	return pmaFBaseIndexInfoService.add(pmaFBaseIndexInfo);
    }
	@ApiOperation(value = "修改基础指标info", notes = "修改基础指标info")
    @PostMapping("/modify")
	public ResultDto<PmaFBaseIndexInfo> modify(@RequestBody PmaFBaseIndexInfo pmaFBaseIndexInfo) throws Exception {
    	return pmaFBaseIndexInfoService.modify(pmaFBaseIndexInfo);
    }
    @PostMapping("/info")
	public ResultDto<PmaFBaseIndexInfoVO> info(@RequestBody PmaFBaseIndexInfo pmaFBaseIndexInfo){
		PmaFBaseIndexInfoVO info = pmaFBaseIndexInfoService.info(pmaFBaseIndexInfo);
		return new ResultDto<>(info);
	}
	/**
	 * @方法名称: del
	 * @方法描述: 删除基础指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "删除基础指标", notes = "删除基础指标")
    @PostMapping("/delete")
	public ResultDto<Integer> del(@RequestBody List<PmaFBaseIndexInfo> list) {
    	return pmaFBaseIndexInfoService.delete(list);
    }
	/**
	 * @方法名称: stopIndex
	 * @方法描述: 停用基础指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "停用基础指标", notes = "停用基础指标")
    @PostMapping("/stopIndex")
	public ResultDto<Integer> stopIndex(@RequestBody String ids) {
    	return pmaFBaseIndexInfoService.stopIndex(ids);
    }
	/**
	 * @方法名称: startIndex
	 * @方法描述: 启用基础指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "启用基础指标", notes = "启用基础指标")
    @PostMapping("/startIndex")
	public ResultDto<Integer> startIndex(@RequestBody String ids) {
    	return pmaFBaseIndexInfoService.startIndex(ids);
    }
	/**
	 * @方法名称: querycolumnlist
	 * @方法描述: 查询所有列字段(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询所有列字段(分页)", notes = "查询所有列字段(分页)")
	@GetMapping("/querycolumnlist")
	public ResultDto<List<Map<String, Object>>> querycolumnlist(@RequestParam String bizFlg) {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoService.querycolumnlist(bizFlg);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	@ApiOperation(value = "保存自定义Sql info信息", notes = "保存自定义Sql info信息")
    @PostMapping("/addsqlinfo")
	public ResultDto<PmaFBaseIndexSql> addsqlinfo(@RequestBody PmaFBaseIndexSql pmaFBaseIndexSql) throws Exception {
    	return pmaFBaseIndexInfoService.addsqlinfo(pmaFBaseIndexSql);
    }
	/**
	 * @方法名称: selConditionVal
	 * @方法描述: 查询条件类型码值
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询条件类型码值", notes = "查询条件类型码值")
	@GetMapping("/selConditionVal")
	public ResultDto<List<Map<String, Object>>> selConditionVal() {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoService.selConditionVal();
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @方法名称: sellookup
	 * @方法描述: 查询数据字典
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询数据字典", notes = "查询数据字典")
	@GetMapping("/sellookup")
	public ResultDto<List<Map<String, Object>>> sellookup() {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoService.sellookup();
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @方法名称: sellookupitem
	 * @方法描述: 查询数据字典项
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询数据字典项", notes = "查询数据字典项")
	@GetMapping("/sellookupitem")
	public ResultDto<List<Map<String, Object>>> sellookupitem(@RequestParam String lookupCode) {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoService.sellookupitem(lookupCode);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @方法名称: querylist
	 * @方法描述: 查询维度
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询维度", notes = "查询维度")
	@GetMapping("/querywdlist")
	public ResultDto<List<Map<String, String>>> querywdlist(@RequestParam String indexId) {
		List<Map<String, String>> list = this.pmaFBaseIndexInfoService.qureywdlist(indexId);
		return new ResultDto<List<Map<String, String>>>(list);
	}
	/**
	 * @方法名称: querysqlinfo
	 * @方法描述: 查询自定义sqlinfo
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询自定义sqlinfo", notes = "查询自定义sqlinfo")
	@GetMapping("/querysqlinfo")
	public ResultDto<List<Map<String, Object>>> querysqlinfo(@RequestParam String indexId) {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoService.querysqlinfo(indexId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @方法名称: checkSqlIsExecute
	 * @方法描述: 检查sql是否可执行
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "检查sql是否可执行", notes = "检查sql是否可执行")
	@PostMapping("/checksqlisexecute")
	public ResultDto<Object> checkSqlIsExecute(@RequestBody String infoStr) {
		ResultDto<Object> result= this.pmaFBaseIndexInfoService.checkSqlIsExecute(infoStr);
		return result;
	}
	/**
	 * @方法名称: selColumnType
	 * @方法描述: 查询字段类型
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询字段类型", notes = "查询字段类型")
	@GetMapping("/selColumnType")
	public ResultDto<List<Map<String, Object>>> selColumnType(@RequestParam String colInfo) {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoService.selColumnType(colInfo);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * @方法名称: iseditIndex
	 * @方法描述: 判断是否可以编辑指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "判断是否可以编辑指标", notes = "判断是否可以编辑指标")
	@GetMapping("/iseditIndex")
	public ResultDto<List<Map<String, Object>>> iseditIndex(@RequestParam String indexId) {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoService.iseditIndex(indexId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @方法名称: isOperIndexInfo
	 * @方法描述: 判断是否可以编辑指标
	 * @参数与返回说明: 指标id
	 * @算法描述: 修改，删除，停用时判断指标是否被方案和派生引用，并且判断是否该指标已经定版
	 */
	@ApiOperation(value = "判断是否可以编辑指标", notes = "判断是否可以编辑指标")
	@GetMapping("/isOperIndexInfo")
	public ResultDto<Map<String, Object>> isOperIndexInfo(@RequestParam String indexIds) {
		Map<String, Object> map= this.pmaFBaseIndexInfoService.isOperIndexInfo(indexIds);
		return new ResultDto<Map<String, Object>>(map);
	}
	@PostMapping("/queryIndexList")
	public ResultDto<List<Map<String, Object>>> queryIndexList(@RequestBody RequestForm resultForm) throws Exception {
		List<Map<String, Object>> list = this.pmaFBaseIndexInfoService.queryIndexList(resultForm);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
}
