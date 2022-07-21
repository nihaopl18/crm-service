package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;


import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcCareAction;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcProAction;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRiskAction;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleAction;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRuleActionMapper
 * @类描述: 规则配置动作接口
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-11-8 14:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcRuleActionMapper extends CommonMapper<CmFRcRuleAction>{
	
	int delActionByEventId(@Param("eventId") String eventId) ;
	
	List<CmFRcRuleAction> getActionByEventId(@Param("eventId") String eventId);
	
	List<Map<String, Object>> getmodelList(@Param("actionId") String actionId ,@Param("actionType") String actionType);

	List<CmFRcCareAction> getCareAction(@Param("actionId") String actionId);
	List<CmFRcProAction>  getProAction(@Param("actionId") String actionId);
	List<CmFRcRiskAction> getRiskAction(@Param("actionId") String actionId);
}
