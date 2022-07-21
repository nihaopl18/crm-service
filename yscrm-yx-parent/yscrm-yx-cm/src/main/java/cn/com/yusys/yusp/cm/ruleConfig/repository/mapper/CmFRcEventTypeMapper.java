package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventType;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;
/**
 * 事件类型接口
 * @author chenlin
 *
 */
public interface CmFRcEventTypeMapper extends CommonMapper<CmFRcEventType>{
	
	/**
	 * 查询事件类别
	 */
	List<CmFRcEventType> getEventType(QueryModel model);
	/**
	 * 逻辑删除事件类型
	 * @param map
	 * @return
	 */
	int updataEventTypeState(Map<String,String> map);
}
