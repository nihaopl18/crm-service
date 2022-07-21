package cn.com.yusys.climp.qypool.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.qypool.domain.LoyQyMerchantAddress;
import cn.com.yusys.climp.qypool.domain.LoyQyMerchantContact;
import cn.com.yusys.climp.qypool.domain.LoyQyMerchantInfo;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyMerchantInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-02-27 14:28:32
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyQyMerchantInfoMapper extends CommonMapper<LoyQyMerchantInfo> {
	/**
	 * @方法名称	queryInfoByPage
	 * @方法描述	查询商户信息信息
	 * @算法描述	根据输入查询条件，返回商户表中的对应的商户信息(关联了用户，机构表查询)
	 * @return	商户信息列表
	 */
	List<Map<String,Object>> queryInfoByPage(QueryModel model);
	/**
	 * @方法名称	getInfoByPage
	 * @方法描述	商户组件查询商户信息信息
	 * @算法描述	根据输入查询条件，返回商户表中的对应的商户信息(关联了用户，机构表查询)
	 * @return	商户信息列表
	 */
	List<Map<String,Object>> getInfoByPage(QueryModel model);
	/**
	 * @方法名称	getInfoByPage
	 * @方法描述	商户组件查询商户信息信息
	 * @算法描述	根据输入查询条件，返回商户表中的对应的商户信息(关联了用户，机构表查询)
	 * @return	商户信息列表
	 */
	List<Map<String,Object>> getInfoById(@Param("merchantId")String merchantId);
	
	/**
	 * @方法名称	getContactByMerId
	 * @方法描述	商户联系信息查询
	 * @算法描述	根据输入查询条件，返回商户表中的对应的商户信息的联系信息
	 * @return	商户信息列表，商户联系信息表
	 */
	List<Map<String,Object>> getContactByMerId(QueryModel param);
	/**
	 * @方法名称	getAddressByMerId
	 * @方法描述	商户地址信息查询
	 * @算法描述	根据输入查询条件，返回商户表中的对应的商户的地址信息
	 * @return	商户信息列表，商户地址信息表
	 */
	List<Map<String,Object>> getAddressByMerId(QueryModel param);
	/**
	 * @方法名称	getInfoByIds
	 * @方法描述	商户组件查询商户信息信息
	 * @算法描述	根据输入查询条件，返回商户表中的对应的商户信息(关联了用户，机构表查询)
	 * @return	商户信息列表
	 */
	List<Map<String,Object>> getInfoByIds(String[] array);
	/**
	 * @方法名称	getNum
	 * @方法描述	统计本批次导入的条数
	 * @算法描述	根据批次号汇总查询
	 * @return	
	 */
	List<Map<String,Object>> getNum(@Param("batchNo")String batchNo);
	/**
	 * @方法名称	insertList
	 * @方法描述	把临时表中的数据插入到正式表中
	 * @算法描述	根据批次号把本批次的数据插入到正式表
	 * @return	
	 */
	void insertList(@Param("batchNo")String batchNo);
	/**
	 * @方法名称	updateStsByBatch
	 * @方法描述	根据批次号更新数据状态
	 * @算法描述	根据批次号更新数据状态
	 * @return	
	 */
	void updateStsByBatch(LoyQyMerchantInfo param);
	/**
	 * @方法名称	updateContactIfFrist
	 * @方法描述	修改联系信息中事首选项的数据变成非首选项
	 * @算法描述	
	 * @return	
	 */
	void updateContactIfFrist(LoyQyMerchantContact param);
	/**
	 * @方法名称	updatAddressIfFirst
	 * @方法描述	把地址中的首选项数据改为不是首选项
	 * @算法描述	
	 * @return	
	 */
	void updatAddressIfFirst(LoyQyMerchantAddress param);
	
	/**
	 * @方法名称	deleteTempInfo
	 * @方法描述	删除临时表中的对应批次的数据
	 * @算法描述	根据批次号删除临时表中的数据
	 * @return	
	 */
	void deleteTempInfo(@Param("batchNo")String batchNo);
	/**
	 * @方法名称	deleteContactInfo
	 * @方法描述	删除商户联系 信息
	 * @算法描述	
	 * @return	
	 */
	void deleteContactInfo(@Param("merchantId")String merchantId);
	/**
	 * @方法名称	deleteAddressInfo
	 * @方法描述	删除商户联系 信息
	 * @算法描述	
	 * @return	
	 */
	void deleteAddressInfo(@Param("merchantId")String merchantId);	
	
}