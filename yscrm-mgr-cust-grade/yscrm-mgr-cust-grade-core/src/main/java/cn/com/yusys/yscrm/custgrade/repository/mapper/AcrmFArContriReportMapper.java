package cn.com.yusys.yscrm.custgrade.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custgrade.domain.AcrmFArContriReport;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

@Mapper
public interface AcrmFArContriReportMapper extends CommonMapper<AcrmFArContriReport>{
	List<Map<String, Object>> querylist(QueryModel queryModel);
	
	String queryUserBusiType(@Param("loginCode") String loginCode);

	List<Map<String, Object>> querylistAllBusi(QueryModel model);
	}
