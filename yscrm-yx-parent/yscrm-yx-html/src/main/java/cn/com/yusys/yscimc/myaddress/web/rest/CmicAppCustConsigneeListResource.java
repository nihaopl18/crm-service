package cn.com.yusys.yscimc.myaddress.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscimc.myaddress.domain.CmicAppCustConsigneeList;
import cn.com.yusys.yscimc.myaddress.service.CmicAppCustConsigneeListService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardInfoResource
 * @类描述: #移动端用户地址操作接口
 * @功能描述: 移动端用户地址操作接口
 * @创建人: yangxiao2
 * @创建时间: 2019-06-28 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmicappcustconsigneelist")
public class CmicAppCustConsigneeListResource extends CommonResource<CmicAppCustConsigneeList, String> {

	@Autowired
	private CmicAppCustConsigneeListService service;
	
	@Override
	protected CommonService getCommonService() {
		return service;
	}

	/**
	 * @方法名称：getCustConsignee
	 * @方法描述: 查询用户地址
	 * @param: custId
	 * @return: addressList
	 * */
	@GetMapping("/getcustconsignee")
	public ResultDto<List<Map<String,Object>>>getCustConsignee(@RequestParam (required = false) String custId) {
		return new ResultDto<List<Map<String,Object>>>(service.getCustConsignee(custId));
	}
	
	/**
	 * @方法名称：addCustConsignee
	 * @方法描述: 新增用户地址
	 * @param: record
	 * @return: 
	 * */
	@PostMapping("/addcustconsignee")
	public ResultDto<Integer>addCustConsignee(@RequestBody CmicAppCustConsigneeList record) {
		return new ResultDto<Integer>(service.addCustConsignee(record));
	}
	
	/**
	 * @方法名称：editCustConsignee
	 * @方法描述: 修改收货地址
	 * @param: custId
	 * @return: addressList
	 * */
	@PostMapping("/editcustconsignee")
	public ResultDto<Integer>editCustConsignee(@RequestBody CmicAppCustConsigneeList record) {
		return new ResultDto<Integer>(service.editCustConsignee(record));
	}
	
	/**
	 * @方法名称：getDefaultAddress
	 * @方法描述: 查询用户默认地址
	 * @param: custId
	 * @return: address
	 * */
	@GetMapping("/getdefaultaddress")
	public ResultDto<Map<String,Object>>getDefaultAddress(@RequestParam (required = false) String custId) {
		return new ResultDto<Map<String,Object>>(service.getDefaultAddress(custId));
	}
}
