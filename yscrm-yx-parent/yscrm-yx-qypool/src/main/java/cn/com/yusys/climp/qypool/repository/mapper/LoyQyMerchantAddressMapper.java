package cn.com.yusys.climp.qypool.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.qypool.domain.LoyQyMerchantAddress;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyMerchantAddressMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hujun3
 * @创建时间: 2019-06-03 19:29:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyQyMerchantAddressMapper extends CommonMapper<LoyQyMerchantAddress> {

	List<Map<String, Object>> getAddressProvince();
	List<Map<String, Object>> getAddressCity(QueryModel model);
	List<Map<String, Object>> getAddressArea(QueryModel model);
	
}