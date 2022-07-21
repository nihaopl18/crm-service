package cn.com.yusys.yscrm.info.remind.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.info.remind.domain.OcrmFwpRemindRuleType;

/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: OcrmFwpRemindRuleTypeMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-19 09:02:21
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpRemindRuleTypeMapper extends CommonMapper<OcrmFwpRemindRuleType> {
	
	/**
	 * @方法名称: queryTree
	 * @方法描述: 查询提醒规则树，公共API接口
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<Map<String, Object>> queryTree();
}