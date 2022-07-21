package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciEventInfo;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciEventInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-15 15:57:54
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciEventInfoMapper extends CommonMapper<OcrmFciEventInfo> {
	List<Map<String, Object>> queryEventList(Map<?, ?> param);
	List<Map<String, Object>> queryRemindDec();
	List<Map<String,Object>> selectNotice(QueryModel model);
	String queryDate();
	
}