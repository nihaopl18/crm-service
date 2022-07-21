package cn.com.yusys.yscrm.cust.person.repository.mapper;

import java.util.List;
import java.util.Map;

public interface InterfaceMapper {
	List<Map<String, Object>> queryOne(String custId);
	List<Map<String, Object>> queryTwo(String custId);
	List<Map<String, Object>> queryThree(String custId);
	String queryCustId(Map map);
	String queryProp(String value);
}
