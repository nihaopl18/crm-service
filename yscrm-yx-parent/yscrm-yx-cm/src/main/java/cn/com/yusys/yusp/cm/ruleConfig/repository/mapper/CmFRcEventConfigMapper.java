package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventInfo;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleParam;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcEventConfigMapper
 * @类描述: 事件规则配置接口
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-29 14:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcEventConfigMapper extends CommonMapper<CmFRcEventInfo>{
	/**
	 * 查询某交易类型的字段
	 * @param model
	 * @return
	 */
	List<Map<String, Object>> queryTransCode(QueryModel model);
	/**查询引用参数字段*/
	List<CmFRcRuleParam> queryRuleParams();

	/**查询引用参数字段*/
	List<CmFRcRuleParam> queryParams();
}
