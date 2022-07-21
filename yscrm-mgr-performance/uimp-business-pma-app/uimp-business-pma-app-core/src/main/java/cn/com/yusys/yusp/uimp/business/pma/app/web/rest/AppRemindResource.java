package cn.com.yusys.yusp.uimp.business.pma.app.web.rest;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.app.service.AppRemindService;
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
 * @项目名称: uimp-business-pma-app-core模块
 * @类名称: AppRemindResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-06 10:48:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/appremind")
@Api(tags = "移动端首页提醒模块")
public class AppRemindResource {
	
	@Autowired
	private AppRemindService appRemindService;

	@ApiOperation(value = "查询到期提醒信息", notes = "查询到期提醒信息")
	@GetMapping("/queryall")
    public ResultDto<Object> queryAll(){
		List<Map<String, Object>> list = this.appRemindService.queryAll();
		return new ResultDto<Object>(list);
    }
	
	@ApiOperation(value = "查询待办任务列表(根据业务分组)", notes = "查询待办任务列表(根据业务分组)")
	@GetMapping("/querytodogrouplist")
    public ResultDto<Object> queryTodoList(){
		List<Map<String, Object>> list = this.appRemindService.queryTodoGroupList();
		return new ResultDto<Object>(list);
    }
	
	@ApiOperation(value = "查询待办任务的跳转菜单", notes = "查询待办任务的跳转菜单")
	@GetMapping("/querytodomenu/{funCode}")
    public ResultDto<Object> queryTodoMenu(@PathVariable String funCode){
		List<Map<String, Object>> list = this.appRemindService.queryTodoMenu(funCode);
		return new ResultDto<Object>(list);
    }
}
