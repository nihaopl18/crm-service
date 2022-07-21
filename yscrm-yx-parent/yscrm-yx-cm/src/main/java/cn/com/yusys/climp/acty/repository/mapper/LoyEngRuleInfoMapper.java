package cn.com.yusys.climp.acty.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyEngRuleInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleInfoMapper
 * @类描述: 积分规则Dao类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyEngRuleInfoMapper extends CommonMapper<LoyEngRuleInfo> {
	/**
	* @方法名称:queryRule
	* @方法描述:积分规则查询
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String,String>> queryRule(QueryModel model);
	/**
	* @方法名称:validDateCode
	* @方法描述:有效期查询
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String, Object>> validDateCode();
	/**
	* @方法名称:queryScoreAccount
	* @方法描述:查询积分账户类型
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String, Object>> queryScoreAccount();
	/**
	* @方法名称:queryTransCode
	* @方法描述:交易字段查询
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String, Object>> queryTransCode(@Param("transactionCode") String transactionCode);
	/**
	* @方法名称:queryScoreAccount
	* @方法描述:查询引用参数字段
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String, Object>> queryRuleParams();
	/**
	* @方法名称:queryTransCode
	* @方法描述:查询交易类型的金额字段与引用参数的数据字段
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String, Object>> queryNumTransCode(@Param("transactionCode") String transactionCode);
	/**
	* @方法名称:queryNumTransCode
	* @方法描述:活动校验
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String, Object>> verificationActivity(@Param("activityId") String activityId);
	/**
	 * @方法名称:verificationRule
	 * @方法描述:规则校验
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String, Object>> verificationRule(QueryModel model);
	
	/**
	* @方法名称:getActionByRuleId
	* @方法描述:根据规则id查询动作
	* @参数与返回说明:
	* @算法描述:
	 */
	List<Map<String, Object>> getActionByRuleId(@Param("ruleId") String ruleId);
	/**
	* @方法名称:delRule
	* @方法描述:跟新规则表
	* @参数与返回说明:
	* @算法描述:
	 */
	int updatePoolNo(LoyEngRuleInfo info);
	/**
	* @方法名称:delRule
	* @方法描述:删除规则信息
	* @参数与返回说明:
	* @算法描述:
	 */
	int delRule(@Param("id") String id);
	/**
	* @方法名称:updataRuleInfo
	* @方法描述:修改规则信息删除标识
	* @参数与返回说明:
	* @算法描述:
	 */
	int updataRuleInfo(Map<?,?> param);
}