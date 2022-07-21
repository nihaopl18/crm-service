package cn.com.yusys.yusp.cm.market.repository.mapper;


import cn.com.yusys.yusp.cm.market.domain.CimpCmAssemInout;
import cn.com.yusys.yusp.cm.market.domain.CimpCmAsseminfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称：yscimc-service
 * @类名称：CimpCmAssemblyMapper
 * @类描述：营销组件相关MAPPER
 * @功能描述:
 * @创建人：hujun3 
 * @创建时间：2018-11-15
 */
public interface CimpCmAssemblyMapper extends CommonMapper<CimpCmAsseminfo>{
	
	/**
	 * 
	* @方法名称: getAllClassifyinfo
	* @方法描述: 获取类型信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getAllClassifyinfo();
	
	/**
	 * 
	* @方法名称: getIteminfoByClassify
	* @方法描述: 根据分类查询组件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getIteminfoByClassify(Map<String,String> params);
	/**
	 * 
	* @方法名称: getfieldsChannelById
	* @方法描述: 根据渠道组件的ID查询渠道的栏位信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getfieldsChannelById(Map<String,String> params);
	
	/**
	 * 
	* @方法名称: getIteminfoByClassify
	* @方法描述: 查询全部组件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getAllIteminfo();
	/**
	 * 
	* @方法名称: getAllIteminfoByScene
	* @方法描述: 根据活动场景查询全部组件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getAllIteminfoByScene(Map<String,String> params);
	
	/**
	 * 
	* @方法名称: getItemInOutinfo
	* @方法描述: 获取组件输入输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getItemInOutinfo(QueryModel param);
		/** @方法名称: getItemInOutinfo
		* @方法描述: 获取组件输入输出信息
		* @参数与返回说明: 
		* @算法描述:
		 */
	List<CimpCmAssemInout> getInOutinfo(QueryModel param);

	/**
	 * 
	* @方法名称: removeItemsByClassify
	* @方法描述: 根据分类ID删除组件数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	int removeItemsByClassify (Map<String,String> params);
	/**
	 * 
	* @方法名称: removeInOutByClassify
	* @方法描述: 根据分类ID删除组件输入输出数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	int removeInOutByClassify (Map<String,String> params);
	/**
	 * 
	* @方法名称: removeInOutByItem
	* @方法描述: 根据组件ID删除输入输出数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	int removeInOutByItem (Map<String,String> params);
	
	/**
	 * 
	* @方法名称: getTablesInfo
	* @方法描述: 查询数据库表格信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getTablesInfo(QueryModel queryModel);
	/**
	 * 
	* @方法名称: getcolumnByTable
	* @方法描述: 根据表格查询字段信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getcolumnByTable(Map<String,Object> params);

	void updateCmFRcChannelMgr(@Param("data") CimpCmAsseminfo data);

	List<CimpCmAsseminfo> selectAll();
}
