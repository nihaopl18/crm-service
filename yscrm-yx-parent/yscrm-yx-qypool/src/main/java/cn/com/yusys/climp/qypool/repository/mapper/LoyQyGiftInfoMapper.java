package cn.com.yusys.climp.qypool.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;

import cn.com.yusys.climp.qypool.domain.LoyQyGiftInfo;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyGiftInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-21 17:29:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyQyGiftInfoMapper extends CommonMapper<LoyQyGiftInfo> {
	/**
	* @方法名称:getGift
	* @方法描述:礼品列表查询
	* @参数与返回说明:
	* @算法描述:
	 */
	List<LoyQyGiftInfo> getGift(QueryModel model);
}