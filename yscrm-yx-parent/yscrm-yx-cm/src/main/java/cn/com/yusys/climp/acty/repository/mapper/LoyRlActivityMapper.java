package cn.com.yusys.climp.acty.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlActivityMapper
 * @类描述: 积分活动Dao类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyRlActivityMapper extends CommonMapper<LoyRlActivity> {
	
	/**
	* @方法名称:getActivityInfo
	* @方法描述:查询积分活动信息
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String,String>> getActivityInfo(QueryModel model);
	/**
	* @方法名称:getActivityByTempId
	* @方法描述:根据营销活动id查询积分权益活动
	* @参数与返回说明:
	* @算法描述:
	 */
	List<LoyRlActivity> getActivityByTempId(@Param("tempId") String tempId);
	/**
	* @方法名称:getActiveForm
	* @方法描述:根据节点id查询活动
	* @参数与返回说明:
	* @算法描述:
	 */
	LoyRlActivity getActiveForm(@Param("nodeId") String nodeId);
	/**
	* @方法名称:priorityList
	* @方法描述:查询积分活动信息
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String,String>> priorityList(QueryModel model);
	/**
	* @方法名称:updataActyState
	* @方法描述:根据分类信息删除活动
	* @参数与返回说明:
	* @算法描述:
	 */
	int updataActyState(Map<?,?> param);
	/**
	* @方法名称:updataActyById
	* @方法描述:根据活动id删除活动信息
	* @参数与返回说明:
	* @算法描述:
	 */
	int updataActyById(Map<?,?> param);
	
	/**
	* @方法名称: updateSts
	* @方法描述: 启用/停用活动
	* @参数与返回说明: 
	* @算法描述:
	 */
	int updateSts(Map<?,?> param);
	
}