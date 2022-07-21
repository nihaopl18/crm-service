package cn.com.yusys.yscrm.product.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.product.domain.AcrmFpdProdCatl;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdProdCatlMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-01-25 10:59:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFpdProdCatlMapper extends CommonMapper<AcrmFpdProdCatl> {

	/**
	* @方法名称: getTreelist
	* @方法描述:  产品类别树查询
	* @算法描述:
	 */
	List<Map<String, Object>> treeListQuery(QueryModel param);
	
	/**
	* @方法名称: getTreelist
	* @方法描述:  产品类别树点击事件
	* @算法描述:
	 */
	List<Map<String, Object>> productTreeQuery(QueryModel param);
	
	/**
	* @方法名称: deleteProductTree
	* @方法描述:  产品类别树删除
	* @算法描述:
	 */
	int deleteProductTree(QueryModel param);
	
	/**
	* @方法名称: getTreelist
	* @方法描述:  产品类别树查询
	* @算法描述:
	 */
	List<Map<String, Object>> displaySchemeQuery(QueryModel param);
	
	/**
	* @方法名称: getTreelist
	* @方法描述:  产品类别树查询
	* @算法描述:
	 */
	List<Map<String, Object>> yufpDptSelectorQuery(QueryModel param);
	/**
	* @方法名称: custProdTree
	* @方法描述:  个人持有产品树
	* @算法描述:
	 */
	List<Map<String, Object>> custProdTree(QueryModel model);
}