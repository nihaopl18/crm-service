package cn.com.yusys.yusp.cm.processparam.web.rest;

import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodePresentInfo;
import cn.com.yusys.yusp.cm.processparam.service.CmFRcNodePresentService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcNodePresentMapper
 * @类描述: 组件操作参数接口
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
@RequestMapping("/api/cmfrcnodepresent")
public class CmFRcNodePresentResource extends CommonResource<CmFRcNodePresentInfo, Serializable>{

	@Autowired
	private CmFRcNodePresentService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	/**
	* @方法名称: getList
	* @方法描述: 查询组件操作参数表数据
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/list")
	public ResultDto<List<CmFRcNodePresentInfo>> getList(QueryModel model) {
		return this.service.getList(model);
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增组件操作参数表数据
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/insertlist")
	public ResultDto<Integer> insertList(@RequestBody CmFRcNodePresentInfo record) throws ParseException {
		return this.service.insertList(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新组件操作参数表数据
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/updatelist")
	public ResultDto<Integer> updateList(@RequestBody CmFRcNodePresentInfo record) throws ParseException {
		return this.service.updateList(record);
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 删除组件操作参数表数据
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/deletelist")
	public ResultDto<Integer> deleteList(@RequestBody CmFRcNodePresentInfo record) {
		return this.service.deleteList(record);
	}
}
