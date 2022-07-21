package cn.com.yusys.yusp.cm.taskcenter.repository.mapper;

/**
 * 
 * @项目名称: yusp-app-cm-taskcenter
 * @类名称: CimFTcMyTaskMapper
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

import java.util.List;
import java.util.Map;

@Mapper
public interface CimFTcMyTaskMapper extends CommonMapper<CimFTcMyTask>{
	/**
	 * 查询任务池
	 */
	List<Map<String, Object>> getMyTaskList(QueryModel model);

	int applyMyTaskState(CimFTcMyTask mt);
	
	int updateNickUser(CimFTcNiche mt);
	
	int applyBack(CimFTcMyTask mt);
	
	int applyUpdate(CimFTcMyTask mt);
	
	int insertMyTask(CimFTcMyTask mt);
	
	int applyUser(CimFTcNiche c);
	
	int insertNicheback(CimFTcNicheback mt);
	
	int riskBackUpdate(CimFTcRisk mt);
	
	int riskUpdate(CimFTcNiche mt);
	
	int careBackUpdate(CimpTcCareInfo mt);
	
	int updateAllotNickUser(CimFTcNiche mt);
	
	List<Map<String, Object>> nicheInfolist(QueryModel model);
	
	List<CimFTcMyTask> completedTotal(QueryModel model);
	
	List<CimFTcMyTask> taskTotal(QueryModel model);
	
	List<CimFTcTP> getlist(String BizSeqNo);
	
	List<Map<String, Object>> updateMarket(QueryModel model);
	
	int marketBack(CmFRcMarketBack mt);

	int careBack(CimpTcCareInfo cimpTcCareInfo);

	int riskBack(CimFTcRisk cimFTcRisk);

	int marketFeedback(CmFRcMarketBack mt);
}

