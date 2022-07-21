package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseMetaFunColumnCfgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunColumnCfgService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-31 15:14:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminBaseMetaFunColumnCfgService extends CommonService {
    @Autowired
    private AdminBaseMetaFunColumnCfgMapper adminBaseMetaFunColumnCfgMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return adminBaseMetaFunColumnCfgMapper;
    }
    
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(String columnCode) {
		List<Map<String, Object>> list = this.adminBaseMetaFunColumnCfgMapper.querylist(columnCode);
		return list;
	}
    
//    @Cacheable(value = "AdminBaseMetaFunColumnCfg", key = "#columnCode")
	public ConcurrentHashMap<String, Object> getFunColumnCfg(String columnCode) {
		List<Map<String, Object>> list = this.adminBaseMetaFunColumnCfgMapper.querylist(columnCode);
		ConcurrentHashMap<String, Object> columnCfgInfo = new ConcurrentHashMap<String, Object>();
		for(Map<String,Object> map : list) {
			String configName = String.valueOf(map.get("configName"));
			String configValue = String.valueOf(map.get("configValue"));
			columnCfgInfo.put(configName, configValue);
		}
		return columnCfgInfo;
	}
    
//    @CachePut(value = "AdminBaseMetaFunColumnCfg", key = "#columnCode")
	public ConcurrentHashMap<String, Object> refreshFunColumnCfg(String columnCode) {
		List<Map<String, Object>> list = this.adminBaseMetaFunColumnCfgMapper.querylist(columnCode);
		ConcurrentHashMap<String, Object> columnCfgInfo = new ConcurrentHashMap<String, Object>();
		for(Map<String,Object> map : list) {
			String configName = String.valueOf(map.get("configName"));
			String configValue = String.valueOf(map.get("configValue"));
			columnCfgInfo.put(configName, configValue);
		}
		return columnCfgInfo;
	}
    
	@CacheEvict(value = "AdminBaseMetaFunColumnCfg", allEntries = true)
	public void clearFunColumnCfg() {
    	System.out.println("delete");
	}
    
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
    public Map<String, Object> queryFunColumnCfg(String tableCode) {
    	Map<String, Object> returnMap = new HashMap<String, Object>();
		List<Map<String, Object>> list = this.adminBaseMetaFunColumnCfgMapper.queryFunColumnCfg(tableCode);
		for (Map<String, Object> dataMap : list) {
			if (!returnMap.containsKey(dataMap.get("columnCode"))) {
				returnMap.put(dataMap.get("columnCode").toString(), new HashMap<String, Object>());
			}
			((Map<String, Object>) returnMap.get(dataMap.get("columnCode"))).put(dataMap.get("configName").toString(), dataMap.get("configValue"));
		}
		return returnMap;
	}
    

}
