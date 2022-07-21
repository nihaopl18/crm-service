package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.AcrmCustCount;
import cn.com.yusys.yscrm.custpub.domain.AcrmCustCountVO;
import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import io.lettuce.core.dynamic.annotation.Param;
@Mapper
public interface GovernedCustMapper extends CommonMapper<AcrmFciCustAdmitAll>{

	List<Map<Object, String>> getList(QueryModel model);

	List<Map<String, String>> getListPer(QueryModel model);

	List<Map<Object, String>> getListOrg(QueryModel model);

	List<Map<String, String>> getListAll(QueryModel model);

	Map<Object, String> getBusiTypeByUserId(String loginCode);

	List<Map<String, String>> getManageCustPerList(QueryModel model);

	List<Map<String, String>> getManageCustOrgList(QueryModel model);

	List<Map<String, String>> getOrgIdBySql(Map<String, String> map);

	List<Map<String, String>> getOrgIdByUserId(QueryModel model);

	List<Map<Object, String>> getListOrgAll(QueryModel model);

	List<Map<String, String>> getListPerAll(QueryModel model);

    List<AcrmCustCountVO> custQueryList(Map<String, String> map);

//	List<Map<String, String>> getListPerNoAdmitAll(QueryModel model);
//
//	List<Map<String, String>> getListPerNoAdmit(QueryModel model);
//
//	List<Map<Object, String>> getListOrgNoAdmitAll(QueryModel model);
//
//	List<Map<Object, String>> getListOrgNoAdmit(QueryModel model);

}