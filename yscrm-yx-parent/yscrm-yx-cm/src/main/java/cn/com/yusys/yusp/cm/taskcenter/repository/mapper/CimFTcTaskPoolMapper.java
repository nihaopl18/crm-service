package cn.com.yusys.yusp.cm.taskcenter.repository.mapper;

/**
 * 
 * @项目名称: yusp-app-cm-taskcenter
 * @类名称: CimFTcTaskPoolMapper
 * @类描述: 
 * @功能描述: 模型版本信息
 * @创建人: yangye@yusys.com.cn
 * @创建时间: 2018年11月09日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */

import cn.com.yusys.yusp.cm.taskcenter.domain.*;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface CimFTcTaskPoolMapper extends CommonMapper<CimFTcTaskPool>{
	/*
	 * 查询任务池
	 * */
	List<CimFTcTaskPool> getTaskPoolList(QueryModel condition);
	/*
	 * 更新任务状态
	 * */
	int updateTaskState(CimFTcTaskPool tp);
	
	CimFTcTaskPool getTaskById(String taskId);
	/*
	 * 更新分配后任务状态
	 * */
	int allotTask(CimFTcTaskPool tp);
	/*
	 * 审批时列出任务信息
	 * */
	List<CimFTcTaskPool> getApplyList(QueryModel model);
	
	/**
	 * 查询已完成任务数
	 */
	List<Map<String, Object>> conmpletedTask(QueryModel model);
	
	
	int insertTP(CimFTcTP tp);
	
	List<CimFTcTP> getlist(String BizSeqNo);
	
	int deleteList(String bizSeqNo);
	
	List<Map<String, Object>> getAllotRoleCode(QueryModel model);
	
	List<Map<String, Object>> getApplyRoleCode(QueryModel model);
	
	
	List<Map<String, Object>> getUser(Map<String, Object> map);

	int insertAll(List<CimFTcTaskPool> taskPoolList);

	String getOrgId(String admin);

	String getOrgName(String belongOrg);

	String getMgrName(String belongMgr);

	int insertRiskInfo(CimFTcRisk cimFTcRisk);

	int insertCareInfo(CimpTcCareInfo cimpTcCareInfo);

    int insertTask(CimFTcTaskPool taskPool);

	int insertRiskAll(List<CimFTcRisk> cimFTcRiskList);

	int insertCareAll(List<CimpTcCareInfo> cimpTcCareInfoList);

	List<CimFTcTaskPoolDto> queryTaskPoolList(@Param("model")QueryModel condition, @Param("list")List<String> orgCodeList);

	//List<Map<String, Object>> getUser(QueryModel model);

}

