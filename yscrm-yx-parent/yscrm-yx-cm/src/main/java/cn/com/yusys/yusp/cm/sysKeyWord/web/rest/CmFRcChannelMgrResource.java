package cn.com.yusys.yusp.cm.sysKeyWord.web.rest;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcChannelMgr;
import cn.com.yusys.yusp.cm.sysKeyWord.service.CmFRcChannelMgrService;
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
 * @类名称: CmFRcChannelMgrService
 * @类描述: 渠道管理接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-14 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcchannelmgr")
public class CmFRcChannelMgrResource extends CommonResource<CmFRcChannelMgr, Serializable>{

	@Autowired
	private CmFRcChannelMgrService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	/**
	 * 
	* @方法名称: getList
	* @方法描述: 查询渠道管理表
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/list")
	public ResultDto<List<CmFRcChannelMgr>> getList(QueryModel model) {
		List<CmFRcChannelMgr> list = service.getList(model);
		return new ResultDto<List<CmFRcChannelMgr>>(list);
	}
	/**
	 * 
	* @方法名称: deleteList
	* @方法描述: 删除渠道管理表
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/deletelist")
	public ResultDto<Integer> deleteList(@RequestBody CmFRcChannelMgr record) {
		return this.service.deleteList(record);
	}
	/**
	 * 
	* @throws ParseException 
	 * @方法名称: insertList
	* @方法描述: 新增渠道管理表
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/insertlist")
	public ResultDto<Integer> insertList(@RequestBody CmFRcChannelMgr record) throws ParseException {
		return this.service.insertList(record);
	}
	/**
	 * 
	* @throws ParseException 
	 * @方法名称: updateList
	* @方法描述: 修改渠道管理表
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/updatelist")
	public ResultDto<Integer> updateList(@RequestBody CmFRcChannelMgr record) throws ParseException {
		return this.service.updateList(record);
	}
	/**
	    * @方法名称: getChannelName
	    * @方法描述: 获取渠道名称
	    * @参数与返回说明: 
	    * @算法描述: 
	    */
	@GetMapping("/getchannelname")
	public ResultDto<List<Map<String,Object>>>getChannelName() {
		return new ResultDto<List<Map<String,Object>>>(this.service.getChannelName());
	}
}
