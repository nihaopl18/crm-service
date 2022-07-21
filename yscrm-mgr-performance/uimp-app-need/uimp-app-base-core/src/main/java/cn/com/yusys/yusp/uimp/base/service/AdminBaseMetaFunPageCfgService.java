package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunPageCfg;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseMetaFunPageCfgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunPageCfgService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-12-23 15:43:18
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminBaseMetaFunPageCfgService extends CommonService {
	@Autowired
	private AdminBaseMetaFunPageCfgMapper adminBaseMetaFunPageCfgMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return adminBaseMetaFunPageCfgMapper;
	}

	/**
	 * @方法名称: saveorupdate
	 * @方法描述: 新增或保存业务功能配置信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> saveorupdate(@RequestBody List<AdminBaseMetaFunPageCfg> list) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
			// 1、删除指定funCode的配置信息
			if (list != null && list.size() > 0) {
				String funCode = list.get(0).getFunCode();
				this.adminBaseMetaFunPageCfgMapper.delPageCfgByFunCode(funCode);
			}
			// 2、新增配置信息
			for (AdminBaseMetaFunPageCfg adminBaseMetaFuncReg : list) {
				this.adminBaseMetaFunPageCfgMapper.insertSelective(adminBaseMetaFuncReg);
			}
			resultDto.setCode(0);
			resultDto.setMessage("新增或保存业务功能配置信息成功");
		} catch (Exception e) {
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}
	
	/**
	 * @方法名称: queryPageCfg
	 * @方法描述: 查询业务注册信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public Map<String, Object> queryPageCfg(String funCode) {
		List<Map<String, Object>> dataList = adminBaseMetaFunPageCfgMapper.queryPageCfg(funCode);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		for (Map<String, Object> dataMap : dataList) {
			returnMap.put(dataMap.get("configName").toString(), dataMap.get("configValue"));
		}
		return returnMap;
	}

	
//	@Cacheable(value = "AdminBaseMetaFunPageCfg", key = "#funCode")
	public ConcurrentHashMap<String, String> getFunPageCfg(String funCode) {
		ConcurrentHashMap<String, String> pageCfg = new ConcurrentHashMap<String, String>();
		List<Map<String,Object>> list = adminBaseMetaFunPageCfgMapper.queryPageCfg(funCode);
		for(Map<String,Object> map : list) {
			String configName = String.valueOf(map.get("configName"));
			String configValue = String.valueOf(map.get("configValue"));
			pageCfg.put(configName, configValue);
		}
		return pageCfg;
	}
	
//	@CachePut(value = "AdminBaseMetaFunPageCfg", key = "#funCode")
	public ConcurrentHashMap<String, String> refreshFunPageCfg(String funCode) {
		ConcurrentHashMap<String, String> pageCfg = new ConcurrentHashMap<String, String>();
		List<Map<String,Object>> list = adminBaseMetaFunPageCfgMapper.queryPageCfg(funCode);
		for(Map<String,Object> map : list) {
			String configName = String.valueOf(map.get("configName"));
			String configValue = String.valueOf(map.get("configValue"));
			pageCfg.put(configName, configValue);
		}
		return pageCfg;
	}
}
