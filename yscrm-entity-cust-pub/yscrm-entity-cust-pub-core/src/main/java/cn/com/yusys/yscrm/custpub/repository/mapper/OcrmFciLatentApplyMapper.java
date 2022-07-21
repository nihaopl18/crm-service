package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciLatentApply;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciLatentApplyMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-14 19:50:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciLatentApplyMapper extends CommonMapper<OcrmFciLatentApply> {
	List<Map<String, String>> getListByModel(QueryModel model);

	List<Map<String, String>> potentialListByModel(QueryModel model);

	List<Map<String, String>> allCustListByModel(QueryModel model);

	List<Map<String, String>> potNoForList(QueryModel model);

	List<Map<String, String>> noPotNoForList(QueryModel model);

	List<Map<String, String>> potForList(QueryModel model);

	List<Map<String, String>> noPotForList(QueryModel model);

	List<Map<String, String>> getClaimInfo(String applyId);

	List<Map<String, String>> getCustByApplyId(String bizSeqNo);

	int updClaimApproval(Map<String, String> map);

	Map<String, String> getOrgLevel(String orgId);

	Map<String, String> belongOrgId(String string);

	Map<String, String> getbelongOrgId(Map<String, String> map);

}