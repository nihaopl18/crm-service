package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.CimpCmChannelResultInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @项目名称：yscimc-service
 * @类名称：CimpCmAssemblyMapper
 * @类描述：渠道处理相关MAPPER
 * @功能描述:
 * @创建人：hujun3 
 * @创建时间：2018-11-15
 */
public interface EngProcessMapper extends CommonMapper<CimpCmChannelResultInfo>{
	
	/**
	 * 
	* @方法名称: getRuleByNodeId
	* @方法描述: 获取权益规则的配置信息根据节点ID
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getRuleByNodeId(@Param(value="nodeId") String nodeId);
	/**
	 * 
	* @方法名称: getRuleByFlowId
	* @方法描述: 获取权益规则的配置信息根据营销活动ID
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getRuleByFlowId(@Param(value="tempId") String tempId);
	
	
	/**
	 * 
	* @方法名称: getConfigByName
	* @方法描述: 获取系统公共参数
	* @参数与返回说明: 
	* @算法描述:
	 */
	void updateEventSts(Map<String,String> params);
	

}
