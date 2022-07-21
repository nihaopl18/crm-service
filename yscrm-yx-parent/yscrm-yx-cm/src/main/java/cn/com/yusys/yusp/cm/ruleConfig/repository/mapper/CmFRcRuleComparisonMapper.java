package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;


import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleComparison;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 规则比较
 * @author chenlin
 *
 */
public interface CmFRcRuleComparisonMapper extends CommonMapper<CmFRcRuleComparison>{
	
	List<CmFRcRuleComparison> getComByEventId(@Param("eventId") String eventId);
	List<CmFRcRuleComparison> getConditionByEventId(@Param("eventId") String eventId);
	List<CmFRcRuleComparison> getParamByEventId(@Param("eventId") String eventId);
}
