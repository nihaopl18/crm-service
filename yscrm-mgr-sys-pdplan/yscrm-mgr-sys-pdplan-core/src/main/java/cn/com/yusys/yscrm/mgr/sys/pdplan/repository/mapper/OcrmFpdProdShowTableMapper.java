package cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowTable;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowTableMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-24 19:39:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdProdShowTableMapper extends CommonMapper<OcrmFpdProdShowTable> {

	List<Map<String, String>> getListByPlanId(String planId);

	List<Map<String, String>> getListByPlanIdNo(String planId);
	
	void deleteByPlanId(String planId);

	int checkSave(@Param("planId") String planId,@Param("tableId") String tableId);
	
}