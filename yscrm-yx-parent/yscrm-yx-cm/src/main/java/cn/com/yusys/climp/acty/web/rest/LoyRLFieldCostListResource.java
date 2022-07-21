package cn.com.yusys.climp.acty.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyRLFieldCostList;
import cn.com.yusys.climp.acty.service.LoyRLFieldCostListService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: 
 * @类描述: #成本归属类
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2019-04-23 15:37:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/fieldcost")
public class LoyRLFieldCostListResource extends CommonResource<LoyRLFieldCostList, String>{
	@Autowired
	LoyRLFieldCostListService service;

	@Override
	protected CommonService getCommonService() {
		return service;
	}
	
	/**
	 * 查询成本归属信息
	 **/
	@GetMapping("/list")
	public ResultDto<List<Map<String,Object>>>costList(@RequestParam(required = false)String tableId) {
		List<Map<String,Object>>list = this.service.costList(tableId);
		return new ResultDto<List<Map<String,Object>>>(list);
	}
	/**
	 * 新增成本归属信息
	 **/
	@PostMapping("/costinsert")
	public ResultDto<Integer>costInsert(@RequestBody Map<String,Object> map) {
		return this.service.costInsert(map);
	}
	/**
	 * 更新成本归属信息
	 **/
	@PostMapping("/costupdate")
	public ResultDto<Integer>costUpdate(@RequestBody LoyRLFieldCostList record) {
		return this.service.costUpdate(record);
	}
	/**
	 * 删除成本归属信息
	 **/
	@PostMapping("/costdelete")
	public ResultDto<Integer>costDel(@RequestBody Map<String,Object> map) {
		return this.service.costDel(map.get("id").toString());
	}
	/**
	 * 查询成本归属字段
	 **/
	@GetMapping("/costfield")
	public ResultDto<List<Map<String,Object>>>costField(@RequestParam(required = false) String tableId){
		return new ResultDto<List<Map<String,Object>>>(this.service.costField(tableId));
	}
	
	/**
	 * 查询成本归属列表
	 **/
	@GetMapping("/getcostlist")
	public ResultDto<List<Map<String,Object>>> getCostList (@RequestParam(required = true) String tableId) {
		return new ResultDto<List<Map<String,Object>>>(service.getCostList(tableId));
	}
}
