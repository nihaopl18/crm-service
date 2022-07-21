package cn.com.yusys.yusp.cm.sysKeyWord.web.rest;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcMarketCapInfo;
import cn.com.yusys.yusp.cm.sysKeyWord.service.CmFRcMarketCapService;
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
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcMarketCapResource
 * @类描述: 营销封顶接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-12-17 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcmarketcap")
public class CmFRcMarketCapResource extends CommonResource<CmFRcMarketCapInfo, Serializable>{

	@Autowired
	private CmFRcMarketCapService service;
	
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}
	/**
	* @方法名称: getList
	* @方法描述: 查询营销封顶表
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/list")
	public ResultDto<List<CmFRcMarketCapInfo>> getList(QueryModel model) {
		List<CmFRcMarketCapInfo> list = service.getList(model);
		return new ResultDto<List<CmFRcMarketCapInfo>>(list);
	}
	/**
	* @方法名称: deleteList
	* @方法描述: 删除营销封顶表
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/deletelist")
	public ResultDto<Integer> deleteList(@RequestBody CmFRcMarketCapInfo record) {
		return this.service.deleteList(record);
	}
	/** 
	* @方法名称: insertList
	* @方法描述: 新增营销封顶表
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/insertlist")
	public ResultDto<Integer> insertList(@RequestBody CmFRcMarketCapInfo record) throws ParseException {
		return this.service.insertList(record);
	}
	/** 
	* @方法名称: updateList
	* @方法描述: 修改营销封顶表
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/updatelist")
	public ResultDto<Integer> updateList(@RequestBody CmFRcMarketCapInfo record) throws ParseException {
		return this.service.updateList(record);
	}
}
