package cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowColumn;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowColumnMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-24 19:40:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdProdShowColumnMapper extends CommonMapper<OcrmFpdProdShowColumn> {

	List<Map<String, String>> getList(String planId);

	List<Map<String, String>> getListNo(String planId);
	
	void deleteByPlanId(String planId);
	
	void deleteByRTableId(String rtableId);

	List<Map<String, String>> getprodInfo(@Param("sql") String sql);

	List<Map<String, String>> getProdTree(@Param("sql") String sql);

	List<Map<String, String>> gettopName(String catlCode);

	void delById(String rtableId);

	Map<String, String> getSql(String catlCode);

	int checkjoin(@Param("planId") String planId,@Param("columnId") String columnId);

	List<Map<String, String>> getCustProd(QueryModel model);
}