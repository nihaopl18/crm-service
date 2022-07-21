package cn.com.yusys.yusp.cm.cust.service;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.com.yusys.yusp.cm.cust.repository.mapper.CimpFFqScolMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * 灵活查询方案
 * @author zhangxs4
 * 
 */
@Service
public class CimpFFqScolService  extends CommonService{
	
	@Autowired
	private CimpFFqScolMapper cimpFFqScolMapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.cimpFFqScolMapper;
	}
	
	/**
	 * 根据节点信息查询条件字段列
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> getScol(String ssId) {
		List<Map<String, Object>> list = cimpFFqScolMapper.getScol(ssId);
		return list;
	}

}

