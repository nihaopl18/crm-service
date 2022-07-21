package cn.com.yusys.climp.acty.repository.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyEngRuleComparison;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleComparisonMapper
 * @类描述: 规则比较Dao类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyEngRuleComparisonMapper extends CommonMapper<LoyEngRuleComparison> {
	/**
	* @方法名称:queryRuleCondition
	* @方法描述:规则比较服务类
	* @参数与返回说明:
	* @算法描述:
	 */
	List<LoyEngRuleComparison> queryRuleCondition(@Param("ruleId") BigDecimal ruleId);
	/**
	* @方法名称:delComparison
	* @方法描述:根据规则id删除规则比较
	* @参数与返回说明:
	* @算法描述:
	 */
	int delComparison(@Param("ruleId") BigDecimal ruleId);
	/**
	* @方法名称:delOtherCom
	* @方法描述:删除不存在规则信息的规则比较
	* @参数与返回说明:
	* @算法描述:
	 */
	int delOtherCom();
}