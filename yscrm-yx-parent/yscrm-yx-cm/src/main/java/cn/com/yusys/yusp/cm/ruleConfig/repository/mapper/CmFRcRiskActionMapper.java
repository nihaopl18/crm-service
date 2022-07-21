package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;


import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRiskAction;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 风险动作配置
 * @author chenlin
 *
 */
public interface CmFRcRiskActionMapper extends CommonMapper<CmFRcRiskAction>{
	
	List<CmFRcRiskAction> getRiskByEventId(@Param("eventId") String eventId);
}
