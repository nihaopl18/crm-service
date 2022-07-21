package cn.com.yusys.climp.acty.repository.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyEngTransactionRouting;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngTransactionRoutingMapper
 * @类描述: 交易路由Dao类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:41:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyEngTransactionRoutingMapper extends CommonMapper<LoyEngTransactionRouting> {
	/**
	* @方法名称:insertRouting
	* @方法描述:启用活动新增路由信息
	* @参数与返回说明:
	* @算法描述:
	 */
	int insertRouting(@Param("activityId") String activityId);
	/**
	* @方法名称:deleteRouting
	* @方法描述:停用活动删除路由信息
	* @参数与返回说明:
	* @算法描述:
	 */
	int deleteRouting(@Param("ruleSetId") String ruleSetId);
}