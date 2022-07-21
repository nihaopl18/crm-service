package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunTable;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunTableResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-25 10:54:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "业务功能管理器")
@RequestMapping("/api/metafunctionmanager")
public class MetaFunctionManagerResource extends CommonResource<AdminBaseMetaFunTable, String> {
    @Autowired
    private MetaFunctionManagerService metaFunctionManagerService;

    @Override
    protected CommonService getCommonService() {
        return metaFunctionManagerService;
    }
    
	/**
	 * @方法名称: getfuninfobycfg
	 * @方法描述: 根据指定配置项返回指定结果的业务功能注册信息列表
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "根据指定配置项返回指定结果的业务功能注册信息列表", notes = "根据指定配置项返回指定结果的业务功能注册信息列表")
	@GetMapping("/getfuninfobycfg")
	public ResultDto<List<AdminBaseMetaFunReg>> getfuninfobycfg(@RequestParam String cfgName, @RequestParam String cfgValue) throws Exception {
		List<AdminBaseMetaFunReg> result = this.metaFunctionManagerService.getFunInfoByCfg(cfgName, cfgValue);
        return new ResultDto<List<AdminBaseMetaFunReg>> (result);
	}
	
	/**
	 * @方法名称: getmetafuninfo
	 * @方法描述: 获取业务功能缓存信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "获取业务功能缓存信息", notes = "获取业务功能缓存信息")
	@GetMapping("/getmetafuninfo")
	public ResultDto<Map<String, Object>> getmetafuninfo(@RequestParam String funCode) throws Exception {
		Map<String, Object> result = this.metaFunctionManagerService.getMetaFunInfo(funCode);
        return new ResultDto<Map<String, Object>> (result);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: getcreatetablesql
	 * @方法描述:生成分配表的建表语句
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "生成分配表的建表语句", notes = "生成分配表的建表语句")
	@GetMapping("/getcreatetablesql")
	public ResultDto<Map<String, Object>> getcreatetablesql(@RequestParam String funCode) throws Exception {
		Map<String, Object> returnMap = this.metaFunctionManagerService.getCreateTableSQL(funCode);
		return new ResultDto<Map<String, Object>>(returnMap);
	}
	
	/**
	 * @方法名称: createbusifunc
	 * @方法描述: 生成功能点
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "生成功能点", notes = "生成功能点")
	@PostMapping("/createbusifunc/{funCode}")
	public ResultDto<Object> createbusifunc(@PathVariable String funCode) throws Exception {
		this.metaFunctionManagerService.getMetaFunInfo(funCode);
        return this.metaFunctionManagerService.createbusifunc(funCode);
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: queryfuncolumninfo
	 * @方法描述:查询列信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询表信息", notes = "根据funCode、funSubType查询表信息")
	@GetMapping("/queryfuntableinfo")
	public ResultDto<AdminBaseMetaFunTable> queryfuntableinfo(@RequestParam String funCode,@RequestParam String funSubType) throws Exception{
		return new ResultDto<AdminBaseMetaFunTable>(this.metaFunctionManagerService.queryFunTableInfo(funCode,funSubType));
	}

}
