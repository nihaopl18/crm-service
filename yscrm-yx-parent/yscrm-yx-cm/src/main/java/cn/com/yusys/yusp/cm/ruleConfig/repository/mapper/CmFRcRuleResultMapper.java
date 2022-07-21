package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleResult;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRuleResultMapper
 * @类描述: 事件结果信息接口
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-23 14:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcRuleResultMapper extends CommonMapper<CmFRcRuleResult>{
	
	/**查询事件结果信息*/
	List<CmFRcRuleResult> getEventResult(QueryModel model);
	List<Map<String, Object>> getResult(QueryModel model);
	List<Map<String, Object>> getMegIn(QueryModel model);
	List<Map<String, Object>> getMegOut(QueryModel model);
}
