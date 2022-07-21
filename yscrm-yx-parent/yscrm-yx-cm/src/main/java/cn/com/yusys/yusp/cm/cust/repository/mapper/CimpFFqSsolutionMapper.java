package cn.com.yusys.yusp.cm.cust.repository.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqSsolution;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

@Mapper
public interface CimpFFqSsolutionMapper extends CommonMapper<CimpFFqSsolution>{
	List<Map<String, Object>> getSsresult(String id);
	List<Map<String, Object>> getList();
	List<CimpFFqSsolution> checkSsolution(String ssName);
	List<Map<String, Object>> getListById(QueryModel model);
}
