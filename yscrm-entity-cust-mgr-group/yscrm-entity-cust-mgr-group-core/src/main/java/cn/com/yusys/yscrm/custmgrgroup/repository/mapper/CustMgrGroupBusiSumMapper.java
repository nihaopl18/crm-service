package cn.com.yusys.yscrm.custmgrgroup.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custmgrgroup.domain.OcrmFcmMktTeam;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

public interface CustMgrGroupBusiSumMapper extends CommonMapper<OcrmFcmMktTeam> {
	String[] getXaxisArray(@Param("mgrId") String mgrId);
	List<Map<String,Object>> getCustAumBal(@Param("mgrId") String mgrId);
	List<Map<String,Object>> getCustLoanBal(@Param("mgrId") String mgrId);
	List<Map<String, Object>> queryInfo(@Param("mktTeamId") String mktTeamId);
}
