package cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdColumn;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdColumnMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-23 19:29:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFpdProdColumnMapper extends CommonMapper<OcrmFpdProdColumn> {

	void delColumnsByTableId(String tableid);

	
}