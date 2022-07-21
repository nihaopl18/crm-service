package cn.com.yusys.yusp.dycrm.todowork.web.rest;

import cn.com.yusys.yscrm.sysview.web.rest.activity.ActivityMonitoring;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWork;
import cn.com.yusys.yusp.dycrm.todowork.service.OcrmFwpTodoWorkService;
import cn.com.yusys.yusp.dycrm.todowork.service.OcrmFwpTodoWorkSonService;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: dycrm-todowork模块
 * @类名称: OcrmFwpTodoWorkResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:32:24
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/todowork")
public class OcrmFwpTodoWorkResource extends CommonResource<OcrmFwpTodoWork, String> {
	@Autowired
	private OcrmFwpTodoWorkService ocrmFwpTodoWorkService;

	@Autowired
	private OcrmFwpTodoWorkSonService ocrmFwpTodoWorkSonService;

	private final Logger log = LoggerFactory.getLogger(OcrmFwpTodoWorkResource.class);

	@Override
	protected CommonService getCommonService() {
		return ocrmFwpTodoWorkService;
	}

	@GetMapping("/queryMainlist")
	@Timed
	protected ResultDto<List<Map<String, Object>>> queryMainlist(QueryModel queryModel) {
		List<Map<String, Object>> list = ocrmFwpTodoWorkService.queryMainlist(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	@GetMapping("/indexQuery")
	@Timed
	protected ResultDto<List<Map<String, Object>>> indexQuery(QueryModel queryModel) {
		List<Map<String, Object>> list = ocrmFwpTodoWorkService.indexQuery(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	@GetMapping("/queryFinished")
	@Timed
	protected ResultDto<List<Map<String, Object>>> queryFinished(QueryModel queryModel) {
		List<Map<String, Object>> list = ocrmFwpTodoWorkService.queryFinished(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	@GetMapping("/selectDataNum")
	@Timed
	protected ResultDto<Map<String,List<String>>> selectDataNum(QueryModel queryModel) {
		Map<String,List<String>> map = ocrmFwpTodoWorkService.selectDataNum(queryModel);
		return new ResultDto<Map<String,List<String>>>(map);
	}

	@GetMapping("/queryDetail")
	@Timed
	protected ResultDto<List<Map<String, Object>>> queryDetail(QueryModel queryModel) {
		List<Map<String, Object>> list = ocrmFwpTodoWorkService.queryDetail(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	@GetMapping("/querySublist")
	@Timed
	protected ResultDto<List<Map<String, Object>>> querySublist(QueryModel queryModel) {
		List<Map<String, Object>> list = ocrmFwpTodoWorkSonService.queryByToDoWorkId(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	 * @description: 根据用户ID查询用户关联角色
	 * @author hujun3
	 * @date 2021/09/16 21:47:46
	 **/
	@GetMapping("/getuserrole")
	protected ResultDto<List<Map<String, Object>>> getUserRoleInfo(String userId) {
		List<Map<String, Object>> list = ocrmFwpTodoWorkService.getUserRoleInfo(userId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * @函数名称:addOneTodoWork
	 * @函数描述:创建一次性待办事项
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/addOne")
	@Timed
	protected ResultDto<Integer> addOneTodoWork(@RequestBody OcrmFwpTodoWork ocrmFwpTodoWork)
			throws URISyntaxException {
		int result = ocrmFwpTodoWorkService.addOneTodoWork(ocrmFwpTodoWork);
		return new ResultDto<Integer>(result);
	}

	/**
	 * @函数名称:addCyCleTodoWork
	 * @函数描述:创建周期性待办事项
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/addCyCle")
	@Timed
	protected ResultDto<Integer> addCyCleTodoWork(@RequestBody OcrmFwpTodoWork ocrmFwpTodoWork)
			throws URISyntaxException {
		int result = ocrmFwpTodoWorkService.addCyCleTodoWork(ocrmFwpTodoWork);
		return new ResultDto<Integer>(result);
	}

	/**
	 * @函数名称:delete
	 * @函数描述:删除 - 根据 事项编号字段 逻辑删除
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/deleteOne")
	@Timed
	protected ResultDto<String> deleteOne(@RequestParam(value="todoWorkId")String todoWorkId) {
		int result = ocrmFwpTodoWorkService.deleteOne(Arrays.asList(todoWorkId.split(";")));
		return new ResultDto<>("删除" + result + "一次性待办");
	}

	@GetMapping("/deleteCycle")
	@Timed
	protected ResultDto<String> deleteCycle(@RequestParam(value="todoWorkId")String todoWorkId) {
		int result = ocrmFwpTodoWorkService.deleteCycle(Arrays.asList(todoWorkId.split(";")));
		return new ResultDto<>("删除" + result + "子待办");
	}
	
	@GetMapping("/deleteSon")
	@Timed
	protected ResultDto<String> deleteSon(@RequestParam(value="todoWorkId")List<String> todoWorkId) {
		int result = ocrmFwpTodoWorkService.deleteSon(todoWorkId);
		return new ResultDto<>("删除" + result + "子待办");
	}
	/**
	 * @函数名称:updateOne
	 * @函数描述:根据 事项编号 更新
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@PostMapping("/updateOne")
	@Timed
	protected ResultDto<Integer> updateOne(@RequestBody OcrmFwpTodoWork ocrmFwpTodoWork) throws URISyntaxException {
		int result = ocrmFwpTodoWorkService.updateOne(ocrmFwpTodoWork);
		return new ResultDto<Integer>(result);
	}

	@PostMapping("/updateCyCle")
	@Timed
	protected ResultDto<Integer> updateCyCle(@RequestBody OcrmFwpTodoWork ocrmFwpTodoWork) throws URISyntaxException {
		int result = ocrmFwpTodoWorkService.updateCyCle(ocrmFwpTodoWork);
		return new ResultDto<Integer>(result);
	}
	
	@PostMapping("/updateSon")
	@Timed
	protected ResultDto<Integer> updateSon(@RequestBody OcrmFwpTodoWork ocrmFwpTodoWork) throws URISyntaxException {
		int result = ocrmFwpTodoWorkSonService.updateSon(ocrmFwpTodoWork);
		return new ResultDto<Integer>(result);
	}
	
	@PostMapping("/updateSons")
	@Timed
	protected ResultDto<Integer> updateSons(@RequestBody OcrmFwpTodoWork ocrmFwpTodoWork) throws URISyntaxException {
		int result = ocrmFwpTodoWorkSonService.updateSons(ocrmFwpTodoWork);
		return new ResultDto<Integer>(result);
	}

	@GetMapping("/updateToDoWorkState")
	@Timed
	protected ResultDto<Integer> updateToDoWorkState(@RequestParam(value="todoWorkId")List<String> todoWorkId)
			throws URISyntaxException {
		int result = ocrmFwpTodoWorkService.updateToDoWorkState(todoWorkId);
		return new ResultDto<Integer>(result);
	}
	
	@GetMapping("/updateToDoWorkSonState")
	@Timed
	protected ResultDto<Integer> updateToDoWorkSonState(@RequestParam(value="todoWorkId")List<String> todoWorkId)
			throws URISyntaxException {
		int result = ocrmFwpTodoWorkService.updateToDoWorkSonState(todoWorkId);
		return new ResultDto<Integer>(result);
	}

	/**
	 * @方法名称: export
	 * @方法描述: 查询结果导出
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/export")
	public void export(HttpServletResponse response, QueryModel model) throws IOException {
		try {
			ocrmFwpTodoWorkService.export(model, response);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("导出失败");
		}
	}
}
