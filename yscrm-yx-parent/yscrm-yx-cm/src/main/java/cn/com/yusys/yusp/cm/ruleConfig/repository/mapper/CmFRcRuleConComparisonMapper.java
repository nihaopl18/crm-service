package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;


import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleConComparison;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 连续规则比较
 * @author chenlin
 *
 */
public interface CmFRcRuleConComparisonMapper extends CommonMapper<CmFRcRuleConComparison>{
	
	List<CmFRcRuleConComparison> getConComByEventId(@Param("eventId") String eventId);
}
