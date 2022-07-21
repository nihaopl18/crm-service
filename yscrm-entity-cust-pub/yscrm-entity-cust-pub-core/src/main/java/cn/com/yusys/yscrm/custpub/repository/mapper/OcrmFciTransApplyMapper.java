package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciTransApply;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;



/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciTransApplyMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-15 10:38:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciTransApplyMapper extends CommonMapper<OcrmFciTransApply> {

	List<Map<String, String>> getListByModel(QueryModel model);

	List<Map<String, String>> myCustListByModel(QueryModel model);

	List<Map<String, String>> InnerCustListByModel(QueryModel model);

	Map<String, String> getPerCustByCustId(Map<String, String> perCust);

	Map<String, String> getOrgCustByCustId(Map<String, String> orgCust);

	List<Map<String, String>> transferInfo(QueryModel model);

	Map<String, String> getMyPerCustByCustId(Map<String, String> mapPer);

	Map<String, String> getMyOrgCustByCustId(Map<String, String> mapOrg);

	List<Map<String, String>> getTransInfo(String applyNo);

	List<Map<String, String>> OuterCustListByModel(QueryModel model);

	int updTransferApproval(Map<String, String> map);

	int getLevel(Map<String, String> map);

	List<Map<String, String>> mycustmgrByModel(QueryModel model);

	List<Map<String, String>> getUsersNode(String applyNo);
	
}