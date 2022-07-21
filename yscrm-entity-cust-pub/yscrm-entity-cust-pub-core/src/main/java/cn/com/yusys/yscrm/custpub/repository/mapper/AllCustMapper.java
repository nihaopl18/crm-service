package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
@Mapper
public interface AllCustMapper extends CommonMapper<AcrmFciCustAdmitAll>{

	List<Map<String, String>> getList(QueryModel model);

	int getOrgLev(Map<String, String> map);
	
	List<Map<String, String>> getMemberDeposit(QueryModel model);

	List<Map<String, String>> getMemberLoan(QueryModel model);

	List<Map<String, String>> getMemberPro(QueryModel model);

	List<Map<String, String>> getMemberContribution(QueryModel model);

	List<Map<String, String>> getFitProduct(QueryModel model);

	Map<String, String> getOrgLevel(String orgId);

	Map<String, String> getOneOrg(Map<String, String> map);

	List<Map<String, String>> getOrgIdBySql(Map<String, String> map);

	List<Map<String, String>> getOrgIdByUserId(QueryModel model);

	Map<String, String> getBusiTypeByUserId(String loginCode);
	Map<String, String> getUserNameByUserId(String lastUser);

	List<Map<String, String>> getorgtree(QueryModel model);
	
}
