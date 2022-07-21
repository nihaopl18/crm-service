package cn.com.yusys.yscrm.user.schedule.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.user.schedule.domain.OcrmFwpSchedule;

/**
 * @项目名称: yscrm-mgr-user-schedule-core模块
 * @类名称: OcrmFwpScheduleMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-12 18:34:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpScheduleMapper extends CommonMapper<OcrmFwpSchedule> {
	
    /**
     * @方法名称: hasSameData
     * @方法描述: 判断OCRM_F_WP_SCHEDULE表中 是否已有对应 客户经理、日程日期的数据
     * @参数与返回说明: 
     * @算法描述: 无
     */
	List<Map<String, Object>> hasSameData(@Param("mgrId") String mgrId, @Param("schDate") String schDate);
	
    /**
     * @方法名称: querySchedule
     * @方法描述: 日程安排 日历组件 简要数据查询，公共API接口
     * @参数与返回说明: 
     * @算法描述: 无
     */
	List<Map<String, Object>> querySchedule1(@Param("reporterId") String reporterId, @Param("startDate") String startDate, 
			@Param("endDate") String endDate);
	List<Map<String, Object>> querySchedule(@Param("scheduleIds") String scheduleIds,@Param("reporterId") String reporterId);
	int updateFun (@Param("mgrId") String mgrId,@Param("scheduleId") String scheduleId);
	Map<String, Object> selectMgr(@Param("scheduleId") String scheduleId);
}