package cn.com.yusys.yusp.cm.productmanager.web.rest;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProdCombinInfo;
import cn.com.yusys.yusp.cm.productmanager.service.CmFRcProdCombinService;
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
 * @类名称: CmFRcProdCombinResource
 * @类描述: 组合产品管理接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-12 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcprodcombin")
public class CmFRcProdCombinResource extends CommonResource<CmFRcProdCombinInfo, Serializable>{

	@Autowired
	private CmFRcProdCombinService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	/**
	* @方法名称: getList
	* @方法描述: 查询组合产品管理表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/list")
	public ResultDto<List<CmFRcProdCombinInfo>> getList(QueryModel model) {
		return this.service.getList(model);
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增组合子产品
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/insertlist")
	public ResultDto<Integer> insertList(@RequestBody CmFRcProdCombinInfo record) throws ParseException {
		return this.service.insertList(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新组合产品状态
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/updatelist")
	public ResultDto<Integer> updateList(@RequestBody CmFRcProdCombinInfo record) throws ParseException {
		return this.service.updateList(record);
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 删除组合子产品
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/deletelist")
	public ResultDto<Integer> deleteList(@RequestBody CmFRcProdCombinInfo record) {
		return this.service.deleteList(record);
	}
}
