package cn.com.yusys.yscrm.product.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.product.domain.OcrmFpdProdLikeness;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdLikenessMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 10:26:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdProdLikenessMapper extends CommonMapper<OcrmFpdProdLikeness> {
	
	/**
	* @方法名称: similarProductsQuery
	* @方法描述: 类似产品查询
	* @算法描述:
	 */
	List<Map<String, Object>> similarProductsQuery(QueryModel param);
	
	/**
	* @方法名称: deleteSimilarProducts
	* @方法描述: 类似产品删除
	* @算法描述:
	 */
	int deleteSimilarProducts(QueryModel param);
}