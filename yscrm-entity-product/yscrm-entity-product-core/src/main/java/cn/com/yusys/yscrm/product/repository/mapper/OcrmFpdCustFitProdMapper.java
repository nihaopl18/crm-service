package cn.com.yusys.yscrm.product.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.product.domain.OcrmFpdCustFitProd;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdCustFitProdMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 15:25:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdCustFitProdMapper extends CommonMapper<OcrmFpdCustFitProd> {
	/**
	* @方法名称: productInfoQuery
	* @方法描述: 目标客户查询
	* @算法描述:
	 */
	List<Map<String, Object>> targetCustomersQuery(QueryModel param);
	List<Map<String,Object>> queryProd(QueryModel model);
}