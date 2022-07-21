package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;


import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcProAction;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 产品动作配置
 * @author chenlin
 *
 */
public interface CmFRcProActionMapper extends CommonMapper<CmFRcProAction>{
	
	List<CmFRcProAction> getProByEventId(@Param("eventId") String eventId);
}
