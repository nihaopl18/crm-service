package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciOrgCustInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciPerAdmitInfo;
import cn.com.yusys.yscrm.custpub.domain.PotenCustPer;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: PotentialCustMapper
 * @类描述: 潜在客户管理Mapper
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-31 16:45:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PotentialCustMapper extends CommonMapper<AcrmFciCustAdmitAll> {

	List<Map<String, String>> getListByModelPer(QueryModel model);
	
	List<Map<String, String>> getListByModelOrg(QueryModel model);

	int checkIsOrg(AcrmFciOrgCustInfo acrmFciOrgCustInfo);
	
	String getSeq();

	int checkIsPer(AcrmFciPerAdmitInfo acrmFciOrgCustInfo);

	AcrmFciCustAdmitAll getCustAdminAllBycustId(String custId);

	int checkIsOrgUp(AcrmFciOrgCustInfo acrmFciOrgCustInfo);

	int checkIsPerUp(AcrmFciPerAdmitInfo acrmFciOrgCustInfo);

	Map<String, String> isCustMgr(String userId);

	Map<String, String> custExist(Map<String, String> map);

	int checkIsCust(Map<String, String> map);
	
	int insertPotenCustPer(Map<String, String> mapper);

	int cleanPotenCustPer();
	
	int insertPotenCustOrg(Map<String, String> mapper);

	int cleanPotenCustOrg();
	
	int deleteBelong(String [] ids);
	int deleteAddr(String [] ids);
	int deleteIdent(String [] ids);
	int deleteContact(String [] ids);
	int deleteCustAll(String [] ids);
	int deletePerAdmit(String [] ids);
	
	int deleteOrgAdmit(String [] ids);
	int deleteKeyMan(String [] ids);
}