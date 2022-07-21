package cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowR;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowRMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-24 19:39:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdProdShowRMapper extends CommonMapper<OcrmFpdProdShowR> {

	OcrmFpdProdShowR getEntityByPlanId(String planId);

	int deleteByPlanId(String planId);

	int trialQuery(@Param("sql") String sql);
	
}