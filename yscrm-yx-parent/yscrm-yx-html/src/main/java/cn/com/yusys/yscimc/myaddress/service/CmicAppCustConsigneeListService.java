package cn.com.yusys.yscimc.myaddress.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yscimc.myaddress.domain.CmicAppCustConsigneeList;
import cn.com.yusys.yscimc.myaddress.repository.mapper.CimcAppCustConsigneeListMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardInfoService
 * @类描述: #移动端用户地址维护Service
 * @功能描述: 用户地址维护
 * @创建人: yangxiao2
 * @创建时间: 2019-06-28 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CmicAppCustConsigneeListService extends CommonService {
	
	@Autowired
	private CimcAppCustConsigneeListMapper mapper;
	
    @Autowired
    private  UserInfoService userService;
	
	@Override
	protected CommonMapper<?> getMapper() {
		return mapper;
	}
	
	private static final int SUCCESS_STS = 0;
	// private static final int FAILED_STS = -1;
	private static final String IS_DEFAULT = "1";
	
	/**
	 * @方法名称：getCustConsignee
	 * @方法描述: 查询用户地址
	 * @param: custId
	 * @return: addressList
	 * */
	public List<Map<String,Object>>getCustConsignee(String custId) {
		return mapper.getCustConsignee(custId);
	}
	
	/**
	 * @方法名称：addCustConsignee
	 * @方法描述: 新增收货地址
	 * @param: custId
	 * @return: addressList
	 * */
	public int addCustConsignee(CmicAppCustConsigneeList record) {
		record.setConsigneeId(getUUID());
		if (IS_DEFAULT.equals(record.getConsigneeDefaultMark())) {
			// 新增地址设为默认地址后取消其他默认地址
			mapper.editDefaultMark(record.getConsigneeCustId());
		}
		
		mapper.insertSelective(record);
		return SUCCESS_STS;
	}
	
	/**
	 * @方法名称：editCustConsignee
	 * @方法描述: 修改收货地址
	 * @param: custId
	 * @return: addressList
	 * */
	public int editCustConsignee(CmicAppCustConsigneeList record) {
		if (IS_DEFAULT.equals(record.getConsigneeDefaultMark())) {
			// 新增地址设为默认地址后取消其他默认地址
			mapper.editDefaultMark(record.getConsigneeCustId());
		}
		mapper.editCustConsignee(record);
		return SUCCESS_STS;
	}
	
	/**
    * @方法名称: getUUID
    * @方法描述: UUID生成器
    * @参数与返回说明: 
    * @算法描述: 
    */
	private String getUUID() {
		return UUID.randomUUID().toString().toLowerCase().replace("-", "");
	}
		
		
	/**
	 * @方法名称：getDefaultAddress
	 * @方法描述: 查询用户默认地址
	 * @param: custId
	 * @return: address
	 * */
	public Map<String,Object>getDefaultAddress(String custId) {
		if ("".equals(custId) || custId == null) {
			custId = userService.getUserInfo().getUserId();
		}
		return mapper.getDefaultAddress(custId);
	}
}
