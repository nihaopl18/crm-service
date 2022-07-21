package cn.com.yusys.yscimc.myorder.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yscimc.myorder.domain.LoyAcOrderListApp;
import cn.com.yusys.yscimc.myorder.repository.mapper.LoyAcOrderListMapperApp;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: LoyAcOrderListService
 * @类描述: #移动端用户卡包订单Service
 * @功能描述: 移动端用户卡包订单编辑逻辑
 * @创建人: yangxiao2
 * @创建时间: 2019-07-04 14:38:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyAcOrderListServiceApp extends CommonService {
	
	@Autowired
	private LoyAcOrderListMapperApp mapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		return mapper;
	}
	
	private final static int SUCCESS_STS = 0;
	private final static int FAILED_STS = -1;
//	private final static String ALL_STATE = "0"; 
//	private final static String TO_DELIVER_STATE = "1";
//	private final static String DELIVER_STATE = "2";
//	private final static String RETURN_STATE = "3";
//	private final static String EXCHANGE_STATE = "4";
//	private final static String COMPLETE_STATE = "5";
	
	/**
	 * @方法名称：getAvailableTicket
	 * @方法描述：获取用户可使用票券
	 * @param: 用户id
	 * @return: 可用票券列表
	 * */
	public List<Map<String,Object>> getAvailableTicket(String custId) {
		return mapper.getAvailableTicket(custId);
	}
	
	/**
	 * @方法名称：getUsedTicket
	 * @方法描述：获取用户已使用票券
	 * @param: 用户id
	 * @return: 已使用票券列表
	 * */
	public List<Map<String,Object>>getUsedTicket(String custId) {
		return mapper.getUsedTicket(custId);
	}
	
	/**
	 * @方法名称：getExpiredTicket
	 * @方法描述：获取用户过期票券
	 * @param: 用户id
	 * @return: 过期票券列表
	 * */
	public List<Map<String,Object>>getExpiredTicket(String custId) {
		return mapper.getExpiredTicket(custId);
	}
	
	/**
	 * @方法名称：checkUsedTicket
	 * @方法描述：用户核销票券
	 * @param: 票券id
	 * @return: 
	 * */
	public int checkUsedTicket(String virtNo) {
		if ("".equals(virtNo)) {
			return FAILED_STS;
		} else {
			mapper.checkUsedTicket(virtNo);
			return SUCCESS_STS;
		}
	}
	
	/**
	 * @方法名称：getCustOrder
	 * @方法描述：查询用户订单
	 * @param: 订单信息 orderCustId orderState
	 * @return: 订单列表
	 * */
	public List<Map<String,Object>>getCustOrder(Map<String,Object> orderparam) {
		List<Map<String,Object>> orderList = new ArrayList<Map<String,Object>>();
		if (orderparam.get("orderCustId") != null && orderparam.get("orderState") != null) {
			// 查询主订单表
			List<Map<String,Object>> orderMajorList = mapper.getParentOrder(orderparam);
			Iterator<Map<String,Object>> it = orderMajorList.iterator();
			while(it.hasNext()) {
				Map<String,Object> majorOrder = it.next();
				// 加入主订单id
				if (orderparam.get("majorOrderNumber") == null) {
					orderparam.put("majorOrderNumber", majorOrder.get("majorOrderNumber"));
				} else {
					orderparam.replace("majorOrderNumber", majorOrder.get("majorOrderNumber"));
				}
				// 插入子订单
				List<Map<String,Object>> orderSonList = mapper.getSonOrder(orderparam);
				majorOrder.put("shoppingList", orderSonList);
				orderList.add(majorOrder);
			}
		}
		return orderList;
	}
	
	/**
	 * @方法名称：orderConfirmReceive
	 * @方法描述：订单确认收货
	 * @param: 主订单号 majorOrderNumber
	 * @return: 
	 * */
	public int orderConfirmReceive(Map<String,Object> orderParam) {
		if (orderParam.get("majorOrderNumber") != null) {
			mapper.orderConfirmReceive(orderParam);
			return SUCCESS_STS;
		} else {
			return FAILED_STS;
		}
	}
	
	/**
	 * @方法名称：orderExchangeGood
	 * @方法描述：订单换货
	 * @param: 订单号 orderNumber 换货原因  orderExcReason
 	 * @return: 
	 * */
	public int orderExchangeGood(Map<String,Object> orderParam) {
		if (orderParam.get("orderNumber") == null || orderParam.get("orderExcReason") == null) {
			return FAILED_STS;
		} else {
			mapper.orderExchangeGood(orderParam);
			return SUCCESS_STS;
		}
	}
	
	
	
	
}
