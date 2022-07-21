package cn.com.yusys.yscrm.cust.person.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.cust.person.repository.mapper.InterfaceMapper;


@Service
public class InterfaceService {

@Autowired
 InterfaceMapper mapper;
	
	public List<Map<String, Object>> queryOne(String custId) {
		List<Map<String, Object>> list=mapper.queryOne(custId);
		return list;
	}
	
	public List<Map<String, Object>> queryTwo(String custId) {
		List<Map<String, Object>> list=mapper.queryTwo(custId);
		return list;
	}
	
	public List<Map<String, Object>> queryThree(String custId) {
		List<Map<String, Object>> list=mapper.queryThree(custId);
		return list;
	}
	
	public String queryCustId(Map map) {
		String value=mapper.queryCustId(map);
		return value;
	}
	
	public String queryProp(String value) {
		return mapper.queryProp(value);
	}
}
