package cn.com.yusys.yscimc.myaddress.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscimc.myaddress.domain.CmicAppCustConsigneeList;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardInfoMapper
 * @类描述: #移动端用户地址维护Mapper
 * @功能描述: Mapper
 * @创建人: yangxiao2
 * @创建时间: 2019-06-11 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CimcAppCustConsigneeListMapper extends CommonMapper<CmicAppCustConsigneeList>{
	/**
	 * @方法名称：getCustConsignee
	 * @方法描述: 查询用户地址
	 * @param: custId
	 * @return: addressList
	 * */
	List<Map<String,Object>> getCustConsignee(String custId);
	/**
	 * @方法名称：editDefaultMark
	 * @方法描述: 取消用户默认地址
	 * @param: custId
	 * @return: 
	 * */
	int editDefaultMark(String custId);
	/**
	 * @方法名称：editDefaultMark
	 * @方法描述: 取消用户默认地址
	 * @param: custId
	 * @return: 
	 * */
	int editCustConsignee(CmicAppCustConsigneeList record);
	
	/**
	 * @方法名称：getDefaultAddress
	 * @方法描述: 查询用户默认地址
	 * @param: custId
	 * @return: address
	 * */
	Map<String,Object>getDefaultAddress(String custId);
}
