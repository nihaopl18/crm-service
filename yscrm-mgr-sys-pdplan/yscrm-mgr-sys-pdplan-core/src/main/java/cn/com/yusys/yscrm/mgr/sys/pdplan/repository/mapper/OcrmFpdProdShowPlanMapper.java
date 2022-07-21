package cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowPlan;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowPlanMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-23 19:29:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdProdShowPlanMapper extends CommonMapper<OcrmFpdProdShowPlan> {

	List<Map<String, String>> getListByModel(QueryModel model);


	int checkPlanName(@Param("planName") String planName);


	int checkUpdPlanName(@Param("planId") String planId,@Param("planName") String planName);


	void delById(String planId);


	String getPlanType(String planId);
	
}