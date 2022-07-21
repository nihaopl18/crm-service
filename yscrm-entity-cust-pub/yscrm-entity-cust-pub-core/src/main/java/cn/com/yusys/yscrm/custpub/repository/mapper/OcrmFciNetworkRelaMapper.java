package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciNetworkRela;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciNetworkRelaMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:23:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciNetworkRelaMapper extends CommonMapper<OcrmFciNetworkRela> {

	List<Map<String, Object>> getListByModel(QueryModel model);
	List<Map<String, Object>> getCustInfoByInfo(Map<String,String> param);

}