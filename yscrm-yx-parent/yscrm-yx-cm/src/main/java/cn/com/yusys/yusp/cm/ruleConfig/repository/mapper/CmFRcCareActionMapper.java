package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;


import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcCareAction;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 关怀动作配置
 * @author chenlin
 *
 */
public interface CmFRcCareActionMapper extends CommonMapper<CmFRcCareAction>{
	
	List<CmFRcCareAction> getCareByEventId(@Param("eventId") String eventId);
}
