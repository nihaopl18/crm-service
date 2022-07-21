package cn.com.yusys.climp.qypool.service;

import java.text.SimpleDateFormat;
import java.util.*;

import cn.com.yusys.climp.qypool.domain.LoyAcOrderExAttr;
import cn.com.yusys.climp.qypool.domain.LoySrExchSerial;
import cn.com.yusys.climp.qypool.repository.mapper.LoyAcOrderExAttrMapper;
import cn.com.yusys.climp.qypool.repository.mapper.LoySrExchSerialMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.qypool.domain.LoyAcOrderList;
import cn.com.yusys.climp.qypool.repository.mapper.LoyAcOrderListMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

@Service
public class LoyAcOrderListService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoyAcOrderListService.class);
	SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Autowired
	private LoyAcOrderListMapper mapper;
	@Autowired
    private UserInfoService userInfoService;
	@Autowired
	private LoyAcOrderExAttrMapper loyAcOrderExAttrMapper;
	@Autowired
	private LoySrExchSerialMapper loySrExchSerialMapper;
	@Override
	protected CommonMapper<?> getMapper() {
		return mapper;
	}
	/*
	 * 更新订单
	 * */
	public int updatests(String orderNumber,String orderState,String reason) {
		LoyAcOrderList record = mapper.selectByPrimaryKey(orderNumber);
		record.setOrderState(orderState);
		record.setUpdateDate(new Date());
		record.setUpdateOrg(userInfoService.getOrgCode());
		record.setUpdateUser(SecurityUtils.getCurrentUserLogin());
		if(orderState.equals("4")) {
			record.setOrderExcReason(reason);
		} else {
			record.setOrderOffReason(reason);
		}
		return mapper.updatests(record);
	}
	/*
	 * 查询订单
	 * */
	public List<Map<String,Object>>orderListQuery(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String,Object>> list = mapper.orderListQuery(model);
		PageHelper.clearPage();
		return list;
	}

	/*
	 * 订单详情
	 * */
	public Map<String,Object> orderDetailQuery(String orderId) {
		Map<String,Object> map = new HashMap<>();
		Map<String,String> order = mapper.getOrderDetail(orderId);
		map.put("ooderDetail",order);
		map.put("cust",mapper.getCustInfo(orderId));
		map.put("comm",mapper.getCommInfo(orderId));
		List<Map<String,Object>> attr = new ArrayList<>();
		attr.addAll(loyAcOrderExAttrMapper.getAttrByOrderNo(order.get("orderNo")));
		map.put("attr", attr );
		return map;
	}
	/*
	 * 订单出货
	 * */
	public ResultDto<Integer>orderOut(Map<String,Object>map) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		if(map.get("orderNumber") == null ||
			map.get("commodityCode") == null ||	
			map.get("commodityType") == null ||
			map.get("commodityNumber") == null) {
			dto.setCode(-1);
			dto.setMessage("订单格式错误！");
		} else if ("".equals(map.get("orderNumber").toString())) {
			dto.setCode(-1);
			dto.setMessage("订单格式错误！");
		} else {
			if("V".equals(map.get("commodityType").toString())) {
				LoyAcOrderList record = mapper.selectByPrimaryKey(map.get("orderNumber").toString());
				List<Map<String,Object>> vlist = mapper.getVirtNo(map);
				if(vlist.size() < Integer.parseInt(map.get("commodityNumber").toString())) {
					dto.setCode(-1);
					dto.setMessage("商品数量不够");
				} else {
					Iterator<Map<String,Object>> it = vlist.iterator();
					Map<String,Object> vmap = new HashMap<String,Object>();
					String [] varray = new String[Integer.parseInt(map.get("commodityNumber").toString())];
					for(int i=0;it.hasNext();i++) {
						varray[i] = it.next().get("virtNo").toString();
					}
					vmap.put("orderNumber", map.get("orderNumber"));
					vmap.put("ticketNo", record.getCommodityID());
					vmap.put("virtNo", varray);
					vmap.put("createDate", new Date());
					mapper.updateUsedSts(vmap);
					mapper.orderOutList(vmap);
					record.setConsigneeName(map.get("consigneeName").toString());
					record.setConsigneeNumber(map.get("consigneeNumber").toString());
					record.setConsigneeAddress(map.get("consigneeAddress").toString());
					record.setOrderState("2");
					mapper.editOutList(record);
					dto.setCode(0);
					dto.setMessage("出货成功");
				}
			} else {
				LoyAcOrderList record = mapper.selectByPrimaryKey(map.get("orderNumber").toString());
				record.setConsigneeName(map.get("consigneeName").toString());
				record.setConsigneeNumber(map.get("consigneeNumber").toString());
				record.setConsigneeAddress(map.get("consigneeAddress").toString());
				record.setLogistics(map.get("logistics").toString());
				record.setTrackingNumber(map.get("trackingNumber").toString());
				record.setOrderState("2");
				mapper.editOutList(record);
			}
		}
		return dto;
	}
	/*
	 * 订单换货
	 * */
	public ResultDto<Integer>orderback(Map<String,Object> map){
		ResultDto<Integer> dto = new ResultDto<Integer>();
		updatests(map.get("orderNumber").toString(),map.get("orderState").toString(),map.get("reason").toString());
		dto.setCode(0);
		dto.setMessage("换货成功");
		return dto;
	}
	/*
	 * 订单关闭
	 * */
	public ResultDto<Integer>orderOff(Map<String,Object> map){
		ResultDto<Integer> dto = new ResultDto<Integer>();
		updatests(map.get("orderNumber").toString(),map.get("orderState").toString(),map.get("reason").toString());
		dto.setCode(0);
		dto.setMessage("关闭成功");
		return dto;
	}
	/*
	 * 订单删除
	 * */
	public ResultDto<Integer>orderDel(String ids) {
		ResultDto<Integer> dto = new ResultDto<Integer>();
		String[] arr = ids.split(",");
		for(int i=0;i<arr.length;i++) {
			mapper.deleteByIds(arr[i]);
		}
		mapper.delOutList(arr);
		dto.setCode(0);
		dto.setMessage("操作成功");
		return dto;
	}

	/**
	 * 保存订单属性
	 * @param extendArr
	 * @return
	 */
	public void addOrderAttr(List<LoyAcOrderExAttr> extendArr) {
		for (LoyAcOrderExAttr loyAcOrderExAttr : extendArr) {
			this.insertSelective(loyAcOrderExAttrMapper,loyAcOrderExAttr);
		}
		return ;
	}

	/**
	 * 保存订单信息
	 * @param loySrExchSerial
	 * @return
	 */
	public void addOrder(LoySrExchSerial loySrExchSerial) {
		loySrExchSerial.setOrderStatus("10");
		Date date = loySrExchSerial.getOrderDt();
		try {
			date = s.parse(s.format(date));
			loySrExchSerial.setOrderDt(date);
		}catch (Exception e){
			logger.error(e.getMessage());
		}
		loySrExchSerial.setAppDt(loySrExchSerial.getOrderDt());
		this.insertSelective(loySrExchSerialMapper,loySrExchSerial);
	}

	public void addOrderInfo(LoyAcOrderList loyAcOrderList) {
		this.insertSelective(loyAcOrderList);
	}

	/**
	 * 订单查询联机接口
	 * @param requestBody
	 * @return
	 */
	public ResultDto<List<Map<String, Object>>> getOrderListByCustNds(Map<String, Object> requestBody,boolean appHead,int queryNum,int pageNum) throws Exception{
		String ecif_cust_no = mapper.getEcifNo(requestBody);
		if (ecif_cust_no != null && !"".equals(ecif_cust_no)){
			Map<String,String> map = new HashMap<>();
			map.put("custId",ecif_cust_no);
			map.put("startDate",(String) requestBody.get("BEGIN_DT"));
			map.put("endDate",(String) requestBody.get("END_DT"));
			List<Map<String,Object>> list = null;
			if (appHead){
				PageHelper.startPage(pageNum, queryNum);
				list = mapper.getOrderListByCustEcif(map);
				PageHelper.clearPage();
			}else {
				list = mapper.getOrderListByCustEcif(map);
			}
			if (list != null && list.size()>0){
				list.forEach(map1 -> {
					List<Map<String,Object>> list1 = loyAcOrderExAttrMapper.getAttrByOrderNo((String)map1.get("orderNo"));
					if (list1 != null && list1.size() > 0){
						map1.put("attr",list1);
					}
				});
				ResultDto<List<Map<String,Object>>> rs = new ResultDto<>(list);
				rs.setMessage(ecif_cust_no);
				return rs;
			}else {
				ResultDto<List<Map<String,Object>>> rs = new ResultDto<>();
				rs.setCode(1007);
				rs.setMessage("未查询到该客户订单兑换信息");
				return rs;
			}
		}else {
			ResultDto<List<Map<String,Object>>> rs = new ResultDto<>();
			rs.setCode(1007);
			rs.setMessage("该NDS客户号未查询ECIF客户号");
			return rs;
		}
	}

	/**
	 * 订单查证联机接口
	 * @param order_code
	 * @return
	 */
	public ResultDto<Map<String, Object>> orderCheck(String order_code) {
		ResultDto<Map<String, Object>> rs = new ResultDto<>();
		Map<String,Object> list = mapper.orderCheck(order_code);
		if (list == null){
			rs.setCode(1008);
			rs.setMessage("未查询到该订单信息");
			return rs;
		}
		rs.setData(list);
		return rs;
	}
}
