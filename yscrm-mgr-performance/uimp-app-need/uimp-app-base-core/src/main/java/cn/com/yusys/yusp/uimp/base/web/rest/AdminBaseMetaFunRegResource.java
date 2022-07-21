package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunReg;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseMetaFunRegService;
import cn.com.yusys.yusp.uimp.base.service.MetaFunctionManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFuncRegResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-12-07 17:56:14
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "业务功能注册")
@RequestMapping("/api/adminbasemetafuncreg")
public class AdminBaseMetaFunRegResource extends CommonResource<AdminBaseMetaFunReg, String> {
	
	private Logger logger = LoggerFactory.getLogger(AdminBaseMetaFunRegResource.class);
	
	@Autowired
	private AdminBaseMetaFunRegService adminBaseMetaFuncRegService;
	
	@Autowired
	private MetaFunctionManagerService metaFunctionManagerService;
	
	@Override
	protected CommonService getCommonService() {
		return adminBaseMetaFuncRegService;
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
		List<Map<String, Object>> list = this.adminBaseMetaFuncRegService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @方法名称: saveorupdate
	 * @方法描述: 新增或保存业务注册信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增或保存业务注册信息", notes = "新增或保存业务注册信息,新增时主键字段id设置为null")
	@PostMapping("/saveorupdate")
	public ResultDto<Object> saveorupdate(@RequestBody AdminBaseMetaFunReg adminBaseMetaFuncReg) throws Exception {
        ResultDto<Object> result = this.adminBaseMetaFuncRegService.saveorupdate(adminBaseMetaFuncReg);
        logger.info("开始刷新业务注册信息缓存...");
//        this.adminBaseMetaFuncRegService.refreshFunRegInfo();
        this.metaFunctionManagerService.refreshMetaFunInfo(adminBaseMetaFuncReg.getFunCode());
        logger.info("刷新业务注册信息缓存结束...");
        return result;
	}
	
	/**
	 * @方法名称: remove
	 * @方法描述: 删除业务注册信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "删除业务注册信息", notes = "删除业务注册信息")
	@PostMapping("/remove/{id}")
	public ResultDto<Object> remove(@PathVariable String id) throws Exception {
        return this.adminBaseMetaFuncRegService.remove(id);
	}
	
	/**
	 * @方法名称: savefuncolandcfg
	 * @方法描述: 保存字段信息和相关配置
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "保存字段信息和相关配置", notes = "保存字段信息和相关配置")
	@PostMapping("/savefuncolandcfg")
	public ResultDto<Object> savefuncolandcfg(@RequestBody AdminBaseMetaFunReg adminBaseMetaFuncReg) throws Exception {
        ResultDto<Object> result = this.adminBaseMetaFuncRegService.savefuncolandcfg(adminBaseMetaFuncReg);
        logger.info("开始刷新字段信息和相关配置信息缓存...");
        String funCode = adminBaseMetaFuncReg.getFunCode();
//        adminBaseMetaFuncRegService.refreshfuncolandcfg(funCode);
        this.metaFunctionManagerService.refreshMetaFunInfo(funCode);
        logger.info("刷新字段信息和相关配置信息缓存结束...");
        return result;
	}
	
	
}
