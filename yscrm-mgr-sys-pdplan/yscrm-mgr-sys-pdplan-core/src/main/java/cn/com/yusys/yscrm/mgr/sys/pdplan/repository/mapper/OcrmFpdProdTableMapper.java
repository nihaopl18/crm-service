package cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdTable;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdTableMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-23 19:28:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdProdTableMapper extends CommonMapper<OcrmFpdProdTable> {

	List<Map<String, String>> getTableName();

	List<Map<String, String>> getListByModel(QueryModel model);

	List<Map<String, String>> getTableInfo(String tableName);

	List<Map<String, String>> getTableInfoByTable(String tableName);

	int checkTableName(String tableName);

	int checkTableOthName(String tableOthName);

	void delById(String string);

	
}