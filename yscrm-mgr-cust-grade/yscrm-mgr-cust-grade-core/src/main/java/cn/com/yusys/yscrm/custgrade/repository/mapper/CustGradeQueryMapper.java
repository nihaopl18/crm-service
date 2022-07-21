package cn.com.yusys.yscrm.custgrade.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yscrm.custgrade.domain.CustGradeQuery;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

@Mapper
public interface CustGradeQueryMapper extends CommonMapper<CustGradeQuery>{
	List<Map<String, Object>> querylist(QueryModel queryModel);
	List<Map<String, Object>> querylistAllBusi(QueryModel queryModel);
	}
