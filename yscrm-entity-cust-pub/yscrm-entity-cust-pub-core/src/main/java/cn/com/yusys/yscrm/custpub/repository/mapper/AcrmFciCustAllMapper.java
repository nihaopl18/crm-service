package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAll;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciCustAllMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-21 16:52:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFciCustAllMapper extends CommonMapper<AcrmFciCustAll> {

	Map<String, String> getCustTypeByCustId(String custId);

	String getCustByCustId(String custId);
	
}