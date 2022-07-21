package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;
/**
 * 营销活动策划——营销活动管理
 * @author zhanghan3
 * 20181113
 */
public interface ManagerMonitoringMapper extends CommonMapper<CimpCmMarketplan>{
	
	List<Map<String, Object>> getList(QueryModel model);
	List<Map<String, Object>> getImpList(QueryModel model);
	List<Map<String, Object>> getSuccessList(QueryModel model);
	List<Map<String, Object>> getFailedList(QueryModel model);
}
