package cn.com.yusys.yscrm.cust.group.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.cust.group.domain.OcrmFciCgMember;

/**
 * @项目名称: yscrm-entity-cust-group-core模块
 * @类名称: OcrmFciCgMemberMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-18 10:34:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciCgMemberMapper extends CommonMapper<OcrmFciCgMember> {

	int delMemberByGroupId(String groupid);

	int checkBe(OcrmFciCgMember c);

	int outGroup(OcrmFciCgMember c);

	List<Map<Object, String>> getJoinList(QueryModel model);

	List<Map<Object, String>> getNoMemberList(QueryModel model);

	List<Map<String, String>> getMemberDeposit(String custGroupId);

	List<Map<String, String>> getMemberLoan(String custGroupId);

	List<Map<String, String>> getMemberPro(String custGroupId);

	List<Map<String, String>> getMemberContribution(QueryModel custGroupId);

	List<Map<String, String>> getFitProduct(String custGroupId);

	List<Map<Object, String>> getMemberList(QueryModel model);

	List<Map<String, String>> getAutoMemberList(QueryModel model);

	Map<String, String> getSqlByGroupId(String custGroupId);

	List<Map<Object, String>> getMemberList1(Map<String, String> sqlMap1);

	List<Map<String, String>> getMemberContribution1(QueryModel model);
	
}