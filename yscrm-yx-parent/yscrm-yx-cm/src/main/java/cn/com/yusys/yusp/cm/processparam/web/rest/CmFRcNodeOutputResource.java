package cn.com.yusys.yusp.cm.processparam.web.rest;

import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodeOutputInfo;
import cn.com.yusys.yusp.cm.processparam.service.CmFRcNodeOutputService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcNodeOutputResource
 * @类描述: 组件输出参数接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-15
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcnodeoutput")
public class CmFRcNodeOutputResource extends CommonResource<CmFRcNodeOutputInfo, Serializable>{

	@Autowired
	private CmFRcNodeOutputService service;
	
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}
	/**
	* @方法名称: getList
	* @方法描述: 查询查询组件输出参数表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/list")
	public ResultDto<List<CmFRcNodeOutputInfo>> getList(QueryModel model) {
		return this.service.getList(model);
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 查询查询组件输出参数表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/insertlist")
	public ResultDto<Integer> insertList(@RequestBody CmFRcNodeOutputInfo record) throws ParseException {
		return this.service.insertList(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 查询查询组件输出参数表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/updatelist")
	public ResultDto<Integer> updateList(@RequestBody CmFRcNodeOutputInfo record) throws ParseException {
		return this.service.updateList(record);
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 查询查询组件输出参数表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/deletelist")
	public ResultDto<Integer> deleteList(@RequestBody CmFRcNodeOutputInfo record) {
		return this.service.deleteList(record);
	}
	
	@PostMapping("/saveoutmerge")
	public ResultDto<Integer> saveoutmerge(@RequestBody CmFRcNodeOutputInfo record) throws ParseException {
		int num = service.checkBe(record.getNodeId());
		if (num ==0) {
			return this.service.addmerge(record);
		}
		return new ResultDto<>(service.upd(record));
	}
	// 查询是否存在组件ID
	@PostMapping("/checknodeid")
	public ResultDto<Map<String, Object>> checknodeid(@RequestBody QueryModel model) throws ParseException {
		return new ResultDto<>(service.checknodeid(model));
	}
}
