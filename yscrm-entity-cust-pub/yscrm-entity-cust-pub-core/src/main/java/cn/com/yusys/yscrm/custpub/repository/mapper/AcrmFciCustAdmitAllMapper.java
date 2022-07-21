package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-entity-cust-pub模块
 * @类名称: AcrmFciCustAdmitAllMapper
 * @类描述: 准入客户主信息信息
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-29 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFciCustAdmitAllMapper extends CommonMapper<AcrmFciCustAdmitAll> {

	int updateBelong(Map<String, String> record);

	List<Map<Object, String>> getListOrgAll(QueryModel model);

	List<Map<Object, String>> getListOrg(QueryModel model);

	List<Map<String, String>> getListPerAll(QueryModel model);

	List<Map<String, String>> getListPer(QueryModel model);

//	List<Map<String, String>> getListPerAllNoAdmit(QueryModel model);
//
//	List<Map<String, String>> getListPerNoAdmit(QueryModel model);
//
//	List<Map<Object, String>> getListOrgAllNoAdmit(QueryModel model);
//
//	List<Map<Object, String>> getListOrgNoAdmit(QueryModel model);

	
}
