package cn.com.yusys.yscrm.product.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.product.domain.AcrmFpdSaleStatistics;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdSaleStatisticsMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-12 19:11:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFpdSaleStatisticsMapper extends CommonMapper<AcrmFpdSaleStatistics> {
	/**
	* @方法名称: salesSituationQuery
	* @方法描述: 产品销售情况查询
	* @算法描述:
	 */
	List<Map<String, Object>> salesSituationQuery(QueryModel param);
}