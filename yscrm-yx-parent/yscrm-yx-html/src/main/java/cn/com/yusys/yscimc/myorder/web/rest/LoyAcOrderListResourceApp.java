package cn.com.yusys.yscimc.myorder.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscimc.myorder.domain.LoyAcOrderListApp;
import cn.com.yusys.yscimc.myorder.service.LoyAcOrderListServiceApp;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: LoyAcOrderListService
 * @类描述: #移动端用户卡包订单Resource
 * @功能描述: 移动端用户卡包订单编辑接口
 * @创建人: yangxiao2
 * @创建时间: 2019-07-04 14:38:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyacorderlistapp")
public class LoyAcOrderListResourceApp extends CommonResource<LoyAcOrderListApp, String>{

	@Autowired
	private LoyAcOrderListServiceApp service;
	
	@Override
	protected CommonService getCommonService() {
		return service;
	}
	
	/**
	 * @方法名称：getAvailableTicket
	 * @方法描述：获取用户可使用票券
	 * @param: 用户id
	 * @return: 可用票券列表
	 * */
	@GetMapping("/getavailableticket")
	public ResultDto<List<Map<String,Object>>> getAvailableTicket(@RequestParam(required = false) String custId) {
		return new ResultDto<List<Map<String,Object>>>(service.getAvailableTicket(custId));
	}
	
	/**
	 * @方法名称：getUsedTicket
	 * @方法描述：获取用户已使用票券
	 * @param: 用户id
	 * @return: 已使用票券列表
	 * */
	@GetMapping("/getusedticket")
	public ResultDto<List<Map<String,Object>>>getUsedTicket(@RequestParam(required = false) String custId) {
		return new ResultDto<List<Map<String,Object>>>(service.getUsedTicket(custId));
	}
	
	/**
	 * @方法名称：getExpiredTicket
	 * @方法描述：获取用户过期票券
	 * @param: 用户id
	 * @return: 过期票券列表
	 * */
	@GetMapping("/getexpiredticket")
	public ResultDto<List<Map<String,Object>>>getExpiredTicket(@RequestParam(required = false) String custId) {
		return new ResultDto<List<Map<String,Object>>>(service.getExpiredTicket(custId));
	}
	
	/**
	 * @方法名称：checkUsedTicket
	 * @方法描述：用户核销票券
	 * @param: 票券id
	 * @return: 
	 * */
	@PostMapping("/checkusedticket")
	public ResultDto<Integer> checkUsedTicket(@RequestBody String virtNo) {
		return new ResultDto<Integer>(service.checkUsedTicket(virtNo));
	}
	
	/**
	 * @方法名称：getCustOrder
	 * @方法描述：查询用户订单
	 * @param: 订单信息 orderCustId orderState
	 * @return: 订单列表
	 * */
	@GetMapping("/getCustOrder")
	public ResultDto<List<Map<String,Object>>>getCustOrder(@RequestParam (required = false) Map<String,Object> orderparam) {
		return new ResultDto<List<Map<String,Object>>>(service.getCustOrder(orderparam));
	}
	
	/**
	 * @方法名称：orderConfirmReceive
	 * @方法描述：订单确认收货
	 * @param: 主订单号 majorOrderNumber
	 * @return: 
	 * */
	@PostMapping("/orderconfirmreceive")
	public ResultDto<Integer> orderConfirmReceive(@RequestBody Map<String,Object> orderParam) {
		return new ResultDto<Integer>(service.orderConfirmReceive(orderParam));
	}
	
	/**
	 * @方法名称：orderExchangeGood
	 * @方法描述：订单换货
	 * @param: 订单号 orderNumber 换货原因  orderExcReason
 	 * @return: 
	 * */
	@PostMapping("/orderexchangegood")
	public ResultDto<Integer> orderExchangeGood(@RequestBody Map<String,Object> orderParam) {
		return new ResultDto<Integer>(service.orderExchangeGood(orderParam));
	}
}
