package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseDbUser;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseDbUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseDbUserResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-21 11:12:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "数据库用户管理")
@RequestMapping("/api/adminbasedbuser")
public class AdminBaseDbUserResource extends CommonResource<AdminBaseDbUser, String> {
    @Autowired
    private AdminBaseDbUserService adminBaseDbUserService;

    @Override
    protected CommonService getCommonService() {
        return adminBaseDbUserService;
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
		List<Map<String, Object>> list = this.adminBaseDbUserService.querylist(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @方法名称: saveorupdate
	 * @方法描述: 新增或保存数据库用户信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "新增或保存数据库用户信息", notes = "新增或保存数据库用户信息")
	@PostMapping("/saveorupdate")
	public ResultDto<Object> saveorupdate(@RequestBody AdminBaseDbUser adminBaseDbUser) throws Exception {
		return this.adminBaseDbUserService.saveorupdate(adminBaseDbUser);
	}
	
	/**
	 * @方法名称: remove
	 * @方法描述: 删除数据库用户信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "删除数据库用户信息", notes = "删除数据库用户信息")
	@PostMapping("/remove/{id}")
	public ResultDto<Object> remove(@PathVariable String id) throws Exception {
        return this.adminBaseDbUserService.remove(id);
	}

}
