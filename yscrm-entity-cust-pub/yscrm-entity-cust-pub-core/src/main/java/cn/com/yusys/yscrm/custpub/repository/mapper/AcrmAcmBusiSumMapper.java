package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmAcmBusiSum;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmAcmBusiSumMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-03 19:14:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmAcmBusiSumMapper extends CommonMapper<AcrmAcmBusiSum> {

	List<Map<String, Object>> getRankPer(QueryModel model);
	
	List<Map<String, Object>> getRankPer2(QueryModel model);
	
	List<Map<String, Object>> getRankOrg2(QueryModel model);
	
	List<Map<String, Object>> getRankOrg(QueryModel model);

	List<Map<String, Object>> getListByModel(QueryModel model);

	List<Map<String, Object>> getRankPer3(QueryModel model);

	List<Map<String, Object>> getRankOrg3(QueryModel model);

	List<Map<String, Object>> getListByModel1(QueryModel model);
	
}