package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseDisplayInfo;
import cn.com.yusys.yusp.uimp.base.service.AdminBaseDisplayInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseDisplayInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-06 20:40:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "数据库用户管理")
@RequestMapping("/api/adminbasedisplayinfo")
public class AdminBaseDisplayInfoResource extends CommonResource<AdminBaseDisplayInfo, String> {
    @Autowired
    private AdminBaseDisplayInfoService adminBaseDisplayInfoService;

    @Override
    protected CommonService getCommonService() {
        return adminBaseDisplayInfoService;
    }
    
    /**
	 * @方法名称: querylist
	 * @方法描述: 查询列表数据(分页)
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "查询列表数据", notes = "查询列表数据")
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> querylist() {
		List<Map<String, Object>> list = this.adminBaseDisplayInfoService.querylist();
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	

	/**
	 * @方法名称: star
	 * @方法描述: 关注
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "关注", notes = "关注")
	@RequestMapping("/star/{id}")
	public ResultDto<Object> star(@PathVariable String id) throws Exception {
		return this.adminBaseDisplayInfoService.star(id);
	}
	
	/**
	 * @方法名称: unstar
	 * @方法描述: 取消关注
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	@ApiOperation(value = "取消关注", notes = "取消关注")
	@RequestMapping("/unstar/{id}")
	public ResultDto<Object> unstar(@PathVariable String id) throws Exception {
		return this.adminBaseDisplayInfoService.unstar(id);
	}

}
