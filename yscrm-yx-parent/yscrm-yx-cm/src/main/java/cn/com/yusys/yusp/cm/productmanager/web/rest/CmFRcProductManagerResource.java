package cn.com.yusys.yusp.cm.productmanager.web.rest;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProductManagerInfo;
import cn.com.yusys.yusp.cm.productmanager.service.CmFRcProductManagerService;
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
 * @类名称: CmFRcProductManagerResource
 * @类描述: 产品管理接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-08 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcproductmanager")
public class CmFRcProductManagerResource extends CommonResource<CmFRcProductManagerInfo, Serializable>{

	@Autowired
	private CmFRcProductManagerService service;
	
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}
	/**
	* @方法名称: getList
	* @方法描述: 查询关注风险表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/list")
	public ResultDto<List<CmFRcProductManagerInfo>> getList(QueryModel model) {
		return new ResultDto<List<CmFRcProductManagerInfo>>(this.service.getList(model));
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增产品
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/insertlist")
	public ResultDto<Integer> insertList(@RequestBody CmFRcProductManagerInfo record) throws ParseException {
		return this.service.insertList(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新产品
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/updatelist")
	public ResultDto<Integer> updateList(@RequestBody CmFRcProductManagerInfo record) throws ParseException {
		return this.service.updateList(record);
	}
	/**
	* @throws 
	* @方法名称: getProdById
	* @方法描述: 组件返回产品信息
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/getprodbyid")
	public ResultDto<List<CmFRcProductManagerInfo>>getProdById(@RequestBody CmFRcProductManagerInfo record) {
		return new ResultDto<List<CmFRcProductManagerInfo>>(service.getProdById(record));
	}
	/**
	* @throws 
	* @方法名称: getOutputProd
	* @方法描述: 组件返回产品信息输出
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/listoutput")
	public ResultDto<List<Map<String,Object>>> getOutputProd (QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(service.getOutputProd(model));
	}
	/**
	* @throws 
	* @方法名称: getProdCust
	* @方法描述: 产品目标客户
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/getprodcust")
	public ResultDto<List<Map<String,Object>>>getProdCust(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(service.getProdCust(model));
	}
	//通过多个产品编号获取产品信息
	@GetMapping("/getprobyids")
	public ResultDto<List<CmFRcProductManagerInfo>>getProByIds(QueryModel model) {
		return new ResultDto<List<CmFRcProductManagerInfo>>(service.getProByIds(model));
	}
	//获取所有产品信息
		@GetMapping("/getpro")
		public ResultDto<List<CmFRcProductManagerInfo>>getPro() {
			return new ResultDto<List<CmFRcProductManagerInfo>>(service.getPro());
		}
}
