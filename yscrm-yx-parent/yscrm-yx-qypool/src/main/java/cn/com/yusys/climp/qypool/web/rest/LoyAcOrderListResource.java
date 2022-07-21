package cn.com.yusys.climp.qypool.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.qypool.domain.LoyQyMerchantInfo;
import cn.com.yusys.climp.qypool.service.LoyAcOrderListService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

@RestController
@RequestMapping("/api/loyacorderlist")
public class LoyAcOrderListResource extends CommonResource<LoyQyMerchantInfo, String>{

	@Autowired
	private LoyAcOrderListService service;
	@Override
	protected CommonService getCommonService() {
		return service;
	}
	/*
	 * 查询订单
	 * */
	@GetMapping("/query")
	public ResultDto<List<Map<String,Object>>>orderListQuery(QueryModel model) {
		return new ResultDto<List<Map<String,Object>>>(service.orderListQuery(model));
	}
	/*
	 * 订单详情
	 * */
	@GetMapping("/detail")
	public ResultDto<Map<String,Object>>orderDetailQuery(String orderId) {
		return new ResultDto<Map<String,Object>>(service.orderDetailQuery(orderId));
	}
	/*
	 * 订单出货
	 * */
	@PostMapping("/orderout")
	public ResultDto<Integer>orderOut(@RequestBody Map<String,Object>map) {
		return service.orderOut(map);
	}
	/*
	 * 订单退货
	 * */
	@PostMapping("/orderback")
	public ResultDto<Integer>orderback(@RequestBody Map<String,Object>map){
		return service.orderback(map);
	}
	/*
	 * 订单关闭
	 * */
	@PostMapping("/orderoff")
	public ResultDto<Integer>orderOff(@RequestBody Map<String,Object>map) {
		return service.orderOff(map);
	}
	/*
	 * 订单删除
	 * */
	@PostMapping("/orderdel")
	public ResultDto<Integer>orderDel(@RequestBody Map<?,?> ids) {
		return service.orderDel(ids.get("ids").toString());
	}
}
