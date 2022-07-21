package cn.com.yusys.climp.acty.repository.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyEngRuleSet;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleSetMapper
 * @类描述: 规则集Dao类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:40:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyEngRuleSetMapper extends CommonMapper<LoyEngRuleSet> {
	/**
	* @方法名称:insertRuleSet
	* @方法描述:启用活动新增规则集信息
	* @参数与返回说明:
	* @算法描述:
	 */
	int insertRuleSet(@Param("id") String id);
	/**
	* @方法名称:deleteRuleSet
	* @方法描述:停用活动删除规则集信息
	* @参数与返回说明:
	* @算法描述:
	 */
	int deleteRuleSet(@Param("id") String id);
}