package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesPresentation;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;
/**
 * @项目名称：yscimc-service
 * @类名称：CustValGradeMapper
 * @类描述：营销组件-渠道智能分发-客户价值等级MAPPER
 * @功能描述:
 * @创建人：hujun3 
 * @创建时间：2018-11-28
 */
public interface CustValGradeMapper extends CommonMapper<CimpCmNodesPresentation>{
	
	/**
	 * 
	* @方法名称: getChannelInfo
	* @方法描述: 获取渠道信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getChannelInfo();
	
	/**
	 * 
	* @方法名称: getChannelByGrade
	* @方法描述: 根据星级查询对应的渠道信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getChannelByGrade(Map<String,String> params);

}
