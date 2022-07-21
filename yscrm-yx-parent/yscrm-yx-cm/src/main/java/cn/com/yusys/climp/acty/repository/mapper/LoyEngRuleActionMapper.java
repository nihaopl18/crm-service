package cn.com.yusys.climp.acty.repository.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyEngRuleAction;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleActionMapper
 * @类描述: 规则动作Dao类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:06:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyEngRuleActionMapper extends CommonMapper<LoyEngRuleAction> {
    /**
    * @方法名称:delOtherAction
    * @方法描述:删除没有规则信息的规则动作
    * @参数与返回说明:
    * @算法描述:
     */
    int delOtherAction();

	List<Map<String, Object>> getRole(@Param("roleCode") String roleCode);
	
	int delAction(@Param("ruleId") BigDecimal ruleId);
}