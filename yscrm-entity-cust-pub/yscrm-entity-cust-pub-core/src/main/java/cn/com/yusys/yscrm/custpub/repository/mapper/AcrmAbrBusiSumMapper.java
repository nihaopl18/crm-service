package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmAbrBusiSum;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmAbrBusiSumMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-28 10:30:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmAbrBusiSumMapper extends CommonMapper<AcrmAbrBusiSum> {

	List<Map<String, Object>> getListByModel(QueryModel model);

	List<Map<String, Object>> getRank(QueryModel model);

	List<Map<String, Object>> getProp(QueryModel model);

	List<Map<String, Object>> getProp1(QueryModel model);

    List<Map<String, Object>> getProp2(QueryModel model);
}