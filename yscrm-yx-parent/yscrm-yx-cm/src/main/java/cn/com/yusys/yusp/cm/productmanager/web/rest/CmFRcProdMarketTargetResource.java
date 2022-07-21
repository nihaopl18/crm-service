package cn.com.yusys.yusp.cm.productmanager.web.rest;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProdMarketTargetInfo;
import cn.com.yusys.yusp.cm.productmanager.service.CmFRcProdMarketTargetService;
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
 * @类名称: CmFRcProdMarketTargetResource
 * @类描述: 营销成效指标维护接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcprodmarkettarget")
public class CmFRcProdMarketTargetResource extends CommonResource<CmFRcProdMarketTargetInfo, Serializable>{

	@Autowired
	private CmFRcProdMarketTargetService service;
	
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}
	/**
	* @方法名称: getList
	* @方法描述: 查询营销成效指标
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/list")
	public ResultDto<List<CmFRcProdMarketTargetInfo>> getList(QueryModel model) {
		return this.service.getList(model);
	}
	@GetMapping("/listAll")
	public ResultDto<List<CmFRcProdMarketTargetInfo>> getListAll(QueryModel model) {
		return this.service.getListAll(model);
	}
	@GetMapping("/listByTargetId")
	public ResultDto<List<CmFRcProdMarketTargetInfo>> getListByTargetId(QueryModel model) {
		return this.service.getListByTargetId(model);
	}
	@GetMapping("/listByTargetName")
	public ResultDto<List<CmFRcProdMarketTargetInfo>> getListByTargetName(QueryModel model) {
		return new ResultDto<List<CmFRcProdMarketTargetInfo>>(service.getListByTargetName(model));
		//return this.service.getListByTargetName(model);
	}
	@GetMapping("/queryByTargetName")
	public ResultDto<List<CmFRcProdMarketTargetInfo>> queryByTargetName(QueryModel model) {
		return this.service.queryByTargetName(model);
		//return this.service.getListByTargetName(model);
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增营销成效指标
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/insertlist")
	public ResultDto<Integer> insertList(@RequestBody CmFRcProdMarketTargetInfo record) throws ParseException {
		return this.service.insertList(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新营销成效指标
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/updatelist")
	public ResultDto<Integer> updateList(@RequestBody CmFRcProdMarketTargetInfo record) throws ParseException {
		return this.service.updateList(record);
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 删除营销成效指标
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/deletelist")
	public ResultDto<Integer> deleteList(@RequestBody CmFRcProdMarketTargetInfo record) {
		return this.service.deleteList(record);
	}
	/**
	* @throws  
	* @方法名称: upList
	* @方法描述: 营销成效指标启用
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/uplist")
	public ResultDto<Integer> upList(@RequestBody CmFRcProdMarketTargetInfo record) {
		return this.service.upList(record);
	}
	/**
	* @throws  
	* @方法名称: downList
	* @方法描述: 营销成效指标停用
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/downlist")
	public ResultDto<Integer> downList(@RequestBody CmFRcProdMarketTargetInfo record) {
		return this.service.downList(record);
	}
}
