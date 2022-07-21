package cn.com.yusys.climp.qypool.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.qypool.domain.LoyAcOrderList;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

public interface LoyAcOrderListMapper extends CommonMapper<LoyAcOrderList>{
	List<Map<String,Object>>orderListQuery(QueryModel model);
	Map<String,String> getOrderDetail(@Param("orderId")String orderId);
	Map<String,String> getCustInfo(@Param("orderId")String orderId);
	Map<String,String> getCommInfo(@Param("orderId")String orderId);
	List<Map<String,Object>>getVirtNo(Map<String,Object> vOrder);
	int updateUsedSts(Map<String,Object> vmap);
	int orderOutList(Map<String,Object> vmap);
	int delOutList(String[] arr);
	int editOutList(LoyAcOrderList record);
	int updatests(LoyAcOrderList record);

	List<String> getOrderId(@Param("orderCode")String orderCode);

	String getTimes(Map<String, String> map);

    String getEcifNo(Map<String, Object> requestBody);

	List<Map<String, Object>> getOrderListByCustEcif(Map<String,String> map);

    Map<String, Object> orderCheck(@Param("orderCode")String order_code);
}
