package cn.com.yusys.yusp.cm.cust.repository.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqScol;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

@Mapper
public interface CimpFFqScolMapper extends CommonMapper<CimpFFqScol>{
	List<Map<String, Object>> getScol(String ssId);
	void deletebyssid(String ssId);
}

