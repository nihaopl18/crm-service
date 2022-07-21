package cn.com.yusys.climp.acty.repository.mapper;

import java.util.List;

import cn.com.yusys.climp.acty.domain.LoyEngRuleParam;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * 
 * @项目名称：yusp-climp-acty-core
 * @类名称：LoyEngRuleParamMapper
 * @类描述：引用参数接口
 * @功能描述:
 * @创建人：chenlin2@yusys.com.cn
 * @创建时间：2018-12-28 10:37
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface LoyEngRuleParamMapper  extends CommonMapper<LoyEngRuleParam>{
	/**
	 * 
	* @方法名称:getParamList
	* @方法描述:引用参数查询
	* @参数与返回说明:查询参数
	* @算法描述:
	 */
	List<LoyEngRuleParam> getParamList(QueryModel model);
	List<LoyEngRuleParam> getRuleParamList(QueryModel model);
}
