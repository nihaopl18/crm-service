package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciBelongHis;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yscrm-entity-cust-pub模块
 * @类名称: OcrmFciBelongHisMapper
 * @类描述: 客户归属调整历史
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-29 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciBelongHisMapper extends CommonMapper<OcrmFciBelongHis> {
	List<Map<String, Object>> getOrglist(String orgCode);
	
}