package cn.com.yusys.yscrm.custmgr.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custmgr.domain.AcrmFcmCustmgrPerf;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;


/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: CustMgrBelonginfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-22 17:25:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CustMgrBelonginfoMapper extends CommonMapper<AcrmFcmCustmgrPerf> {
	
	/**
	 * 列表查询
	 * 
	 * @param queryModel
	 * @return
	 */
	List<Map<String, Object>> querylist(QueryModel queryModel);
	
}