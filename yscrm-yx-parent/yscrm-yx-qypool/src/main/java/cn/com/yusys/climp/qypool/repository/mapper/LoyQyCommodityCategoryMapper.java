package cn.com.yusys.climp.qypool.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.qypool.domain.LoyQyCommodityCategory;

/**
 * @项目名称: yusp-climp-qypool-core模块
 * @类名称: LoyQyCommodityCategoryMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: chenlin
 * @创建时间: 2019-02-26 14:39:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyQyCommodityCategoryMapper extends CommonMapper<LoyQyCommodityCategory> {
	/**
	* @方法名称:getCategory
	* @方法描述:商品类别树查询
	* @参数与返回说明:
	* @算法描述:
	 */
	List<LoyQyCommodityCategory> getCategoryTree();
	/**
	* @方法名称:getCategory
	* @方法描述:商品类别查询
	* @参数与返回说明:
	* @算法描述:
	 */
	List<LoyQyCommodityCategory> getCategory(QueryModel model);
	/**
	* @方法名称:updateCategory
	* @方法描述:根据类目编号修改子类别的信息
	* @参数与返回说明:
	* @算法描述:
	 */
	int updateCategory(Map<String,String> map);
	/**
	* @方法名称:getSequenceNo
	* @方法描述:获取类别编号
	* @参数与返回说明:
	* @算法描述:
	 */
	int getSequenceNo(String sequence);
	/**
	* @方法名称:delCategory
	* @方法描述:根据类目编号删除该类目及类目下所有类目
	* @参数与返回说明:
	* @算法描述:
	 */
	int delCategory(String categoryCode);
	
	List<Map<String,Object>>getInstus();
	
	/**
	* @方法名称:getNodeCommodity
	* @方法描述:根据类目编号查询该类目及类目子节点商品
	* @参数与返回说明:
	* @算法描述:
	 */
	int getNodeCommodity(String categoryCode);
}