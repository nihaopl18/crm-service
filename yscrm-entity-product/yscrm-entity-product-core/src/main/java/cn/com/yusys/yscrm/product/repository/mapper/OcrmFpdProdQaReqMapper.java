package cn.com.yusys.yscrm.product.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.product.domain.OcrmFpdProdQaReq;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdQaReqMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 17:12:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdProdQaReqMapper extends CommonMapper<OcrmFpdProdQaReq> {
	
	/**
	* @方法名称: questionsAnswersQuery
	* @方法描述: Q&A查询
	* @算法描述:
	 */
	List<Map<String, Object>> questionsAnswersQuery(QueryModel param);
	
	/**
	* @方法名称: delerteQuestionsAnswers
	* @方法描述: Q&A删除
	* @算法描述:
	 */
	int delerteQuestionsAnswers(QueryModel param);
}