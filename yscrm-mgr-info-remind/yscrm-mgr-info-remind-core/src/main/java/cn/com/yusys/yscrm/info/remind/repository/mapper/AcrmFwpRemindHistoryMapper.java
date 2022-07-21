package cn.com.yusys.yscrm.info.remind.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.info.remind.domain.AcrmFwpRemindHistory;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

public interface AcrmFwpRemindHistoryMapper extends CommonMapper<AcrmFwpRemindHistory>{
	List<Map<String,Object>> queryHistory(QueryModel model);
}
