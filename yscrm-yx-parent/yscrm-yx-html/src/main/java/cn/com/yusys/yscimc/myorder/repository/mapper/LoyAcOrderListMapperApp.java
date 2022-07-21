package cn.com.yusys.yscimc.myorder.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscimc.myorder.domain.LoyAcOrderListApp;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: LoyAcOrderListMapper
 * @类描述: #移动端用户卡包订单Mapper
 * @功能描述: 移动端用户卡包订单编辑
 * @创建人: yangxiao2
 * @创建时间: 2019-07-04 14:38:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyAcOrderListMapperApp extends CommonMapper<LoyAcOrderListApp>{
	/**
	 * @方法名称：getAvailableTicket
	 * @方法描述：获取用户可使用票券
	 * @param: 用户id
	 * @return: 可用票券列表
	 * */
	List<Map<String,Object>>getAvailableTicket(String custId);
	
	/**
	 * @方法名称：getUsedTicket
	 * @方法描述：获取用户已使用票券
	 * @param: 用户id
	 * @return: 已使用票券列表
	 * */
	List<Map<String,Object>>getUsedTicket(String custId);
	
	/**
	 * @方法名称：getExpiredTicket
	 * @方法描述：获取用户过期票券
	 * @param: 用户id
	 * @return: 过期票券列表
	 * */
	List<Map<String,Object>>getExpiredTicket(String custId);
	
	/**
	 * @方法名称：checkUsedTicket
	 * @方法描述：用户核销票券
	 * @param: 票券id
	 * @return: 
	 * */
	int checkUsedTicket(String virtNo);
	
	/**
	 * @方法名称：getParentOrder
	 * @方法描述：查询主订单
	 * @param: 订单信息 orderCustId orderState
	 * @return: 主订单列表
	 * */
	List<Map<String,Object>>getParentOrder(Map<String,Object> orderParam);
	
	/**
	 * @方法名称：getSonOrder
	 * @方法描述：查询子订单
	 * @param: 订单信息 orderCustId majorOrderNumber orderState
	 * @return: 子订单列表
	 * */
	List<Map<String,Object>>getSonOrder(Map<String,Object> orderParam);
	
	/**
	 * @方法名称：orderConfirmReceive
	 * @方法描述：订单确认收货
	 * @param: 主订单号 majorOrderNumber
	 * @return: 
	 * */
	int orderConfirmReceive(Map<String,Object> orderParam);
	
	/**
	 * @方法名称：orderExchangeGood
	 * @方法描述：订单换货
	 * @param: 订单号 orderNumber 换货原因  orderExcReason
 	 * @return: 
	 * */
	int orderExchangeGood(Map<String,Object> orderParam);
}
