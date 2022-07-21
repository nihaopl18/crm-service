package cn.com.yusys.yscrm.user.schedule.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpSchedulePlan;

/**
 * @项目名称: yscrm-mgr-user-schedule-core模块
 * @类名称: OcrmFwpSchedulePlanMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-12 18:36:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpSchedulePlanMapper extends CommonMapper<OcrmFwpSchedulePlan> {
	
	/**
	 * @方法名称: queryList
	 * @方法描述: 条件列表查询
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<Map<String, Object>> queryList(QueryModel model);
	
    /**
     * @方法名称: deleteByPids
     * @方法描述: 删除  - 根据 工作计划 主键字段 逻辑删除
     * @参数与返回说明: 
     * @算法描述: 无
     */
    int deleteByPids(String[] ids);
    
    /**
     * @方法名称: scheduleRelease
     * @方法描述: 下达  - 根据 工作计划 主键 修改计划执行状态
     * @参数与返回说明: 
     * @算法描述: 无
     */
    int scheduleRelease(String[] ids);
}