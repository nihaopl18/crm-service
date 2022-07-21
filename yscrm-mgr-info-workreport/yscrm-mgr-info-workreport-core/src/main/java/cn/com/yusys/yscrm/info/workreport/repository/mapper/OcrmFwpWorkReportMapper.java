package cn.com.yusys.yscrm.info.workreport.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.info.workreport.domain.WorkReportExcle;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpWorkReport;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-info-workreport-core模块
 * @类名称: OcrmFwpWorkReportMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:32:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpWorkReportMapper extends CommonMapper<OcrmFwpWorkReport> {
	
	/**
	 * @方法名称: listByModel
	 * @方法描述: 条件列表查询
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<Map<String, Object>> listByModel(QueryModel model);
	
    /**
     * @方法名称: selectByWorkReportId
     * @方法描述: 根据主键查询
     * @参数与返回说明: 
     * @算法描述: 无
     */
	List<Map<String, Object>> selectByWorkReportId(String id);
	
    /**
     * @方法名称: chkData
     * @方法描述: 查询 同一报告人、同一报告周期内，是否有重复的工作报告
     * @参数与返回说明: 
     * @算法描述: 无
     */
	List<String> chkData(@Param("creatorId") String creatorId,
			@Param("workReportBusiType") String workReportBusiType, @Param("startDate") String startDate);
	
	/**
     * @方法名称: updateContent
     * @方法描述: 根据 报告编号 更新 ： 工作内容、工作困难、工作小结
     * @参数与返回说明: 
     * @算法描述: 无
     */
    int updateContent(@Param("workReportId") String workReportId, @Param("workContent") String workContent, 
    		@Param("workDifficulty") String workDifficulty, @Param("workSummary") String workSummary);

    /**
     * @方法名称: deleteByWorkReportIds
     * @方法描述: 删除  - 根据 报告编号字段 逻辑删除
     * @参数与返回说明:
     * @算法描述: 无
	 * @param map
     */
    int deleteByWorkReportIds(Map<String, Object> map);
    
    List<Map<String,String>> queryOrgId(@Param("orgId") String orgId);

	int updateWorkReport(OcrmFwpWorkReport ocrmFwpWorkReport);

	List<Map<String, Object>> queryMlist(QueryModel model);

    int updateStatus(@Param("workReportId") String workReportId, @Param("isDraft") String s);

    List<Map<String, Object>> queryDetail(@Param("workReportId") String workReportId);

	List<WorkReportExcle> getDay(QueryModel model);

	List<WorkReportExcle> getWeek(QueryModel model);

	List<WorkReportExcle> getMonth(QueryModel model);

    String getUserName(@Param("userId")String receUserId);

    int saveIntanceId(@Param("workReportId") String workReportId, @Param("instanceId") String instanceId);
}