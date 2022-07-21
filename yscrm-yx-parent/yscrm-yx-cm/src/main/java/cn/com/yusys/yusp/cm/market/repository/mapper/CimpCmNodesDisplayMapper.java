package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.CimpCmNodesDisplay;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * @项目名称：yscimc-service
 * @类名称：CimpCmNodesDisplayMapper
 * @类描述：节点表单表
 * @功能描述:
 * @创建人：chenlin2 
 * @创建时间：2018-11-17
 */
public interface CimpCmNodesDisplayMapper extends CommonMapper<CimpCmNodesDisplay>{

	CimpCmNodesDisplay getDisplay(@Param("nodeId") String nodeId);
	/**
	 * 
	* @方法名称: getMarketTypeByFlowId
	* @方法描述: 查询流程中的营销方式组件
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getMarketTypeByFlowId(Map<String,String> params);

	/**
	 *
	 * @方法名称: getMarketTypeByFlowId
	 * @方法描述: 查询流程中的营销方式组件(包括组件信息)
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String,Object>> getMarketTypeAllByFlowId(Map<String,String> params);
	
	String checkBe(String nodeId);

}
