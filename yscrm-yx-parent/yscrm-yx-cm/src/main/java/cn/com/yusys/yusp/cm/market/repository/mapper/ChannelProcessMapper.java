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
public interface ChannelProcessMapper extends CommonMapper<CimpCmChannelResultInfo>{
	
	/**
	 * 
	* @方法名称: getItemsByFlowId
	* @方法描述: 获取流程实例节点信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getItemsByFlowId(Map<String,String> params);
	
	/**
	 * 
	* @方法名称: getConfigByName
	* @方法描述: 获取系统公共参数
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getConfigByName(@Param(value="propName") String name);
	
	/**
	 * 
	* @方法名称: getChannelItemOutInfo
	* @方法描述: 获取流程渠道节点的输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getChannelItemOutInfo(Map<String,String> params);
	/**
	 * 
	* @方法名称: deleteInfoByNode
	* @方法描述: 删除节点下的结果信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	int deleteInfoByNode(String nodeId);
	/**
	 * 
	* @方法名称: updateStsByNodeId
	* @方法描述: 更新手机银行组件下设置的营销位内容状态
	* @参数与返回说明: 
	* @算法描述:
	 */
	int updateStsByNodeId(Map<String,String> params);
	
	/**
	 * 
	* @方法名称: getItemOutInfo
	* @方法描述: 获取流程实例节点的输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getItemOutInfo(List<String> list);
	/**
	 * 
	* @方法名称: getModelListByNodeId
	* @方法描述: 获取营销动作选中的模板信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getModelListByNodeId(List<String> list);
	
	
	/**
	 * 
	* @方法名称: getItemCustGroupinfo
	* @方法描述: 获取客户群信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getItemCustGroupinfo(List<String> list);
	/**
	 * 
	* @方法名称: getItemCustinfoBySql
	* @方法描述: 获取客户信息-灵活查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getItemCustinfoBySql(@Param(value="value") String sql);
	/**
	 * 
	* @方法名称: getItemCustinfoBySqlBQ
	* @方法描述: 获取客户信息-标签客户
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getItemCustinfoBySqlBQ(@Param(value="value") String sql);
	/**
	 * 
	* @方法名称: getItemCustinfoByGroupId
	* @方法描述: 获取客户信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getItemCustinfoByGroupId(List<String> list);
	/**
	 * 
	* @方法名称: getCustChPerinfoBySql
	* @方法描述: 客户渠道偏好-根据SQL获取客户信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getCustChPerinfoBySql(@Param(value="value") String sql);
	/**
	 * 
	* @方法名称: getCustChPerinfoBySqlBQ
	* @方法描述: 客户渠道偏好-根据SQL获取客户信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getCustChPerinfoBySqlBQ(@Param(value="value") String sql);
	/**
	 * 
	* @方法名称: getCustChPerinfoByGroupId
	* @方法描述: 客户渠道偏好-根据客户群ID获取客户信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getCustChPerinfoByGroupId(List<String> list);
	/**
	 * 
	* @方法名称: getItemProdInfo
	* @方法描述: 获取产品信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getItemProdInfo(List<String> list);
	/**
	 * 
	* @方法名称: getItemProdAndchannelInfo
	* @方法描述: 查询产品和对应的使用渠道和模板信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getItemProdAndchannelInfo(List<String> list);
	
	/**
	 * 
	* @方法名称: getOperaByItem
	* @方法描述: 获取操作信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getOperaByItem(Map<String,String> params);
	/**
	 * 
	* @方法名称: getModelByProd
	* @方法描述: 获取产品适用模板信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getModelByProd(Map<String,String> params);
	/**
	 * 
	* @方法名称: getModelKey
	* @方法描述: 获取模板关键字信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getModelKey();
	/**
	 * 
	* @方法名称: getInvetByFlowId
	* @方法描述: 获取流程清单整合后的信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getInvetByFlowId(Map<String,String> params);

	/**
	 * 
	* @方法名称: getInvetPerinfoByFlowId
	* @方法描述: 获取流程清单整合后的客户信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getInvetPerinfoByFlowId(Map<String,String> params);
	

}
