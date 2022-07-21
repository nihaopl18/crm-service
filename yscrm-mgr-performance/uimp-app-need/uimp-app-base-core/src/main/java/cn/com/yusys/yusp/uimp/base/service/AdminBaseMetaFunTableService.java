package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunTable;
import cn.com.yusys.yusp.uimp.base.repository.mapper.AdminBaseMetaFunTableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunTableService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-25 10:54:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class AdminBaseMetaFunTableService extends CommonService {
    @Autowired
    private AdminBaseMetaFunTableMapper adminBaseMetaFunTableMapper;
    
    @Autowired
    private AdminBaseMetaFunColumnService adminBaseMetaFunColumnService;
    
    @Override
    protected CommonMapper<?> getMapper() {
        return adminBaseMetaFunTableMapper;
    }
    
    @Transactional(readOnly = true)
    public List<Map<String, Object>> querylist(String funCode) {
		List<Map<String, Object>> list = this.adminBaseMetaFunTableMapper.querylist(funCode);
		return list;
	}
    
    /**
	 * @方法名称: saveorupdate
	 * @方法描述: 新增或保存业务模型配置信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public ResultDto<Object> saveorupdate(@RequestBody List<AdminBaseMetaFunTable> list) throws Exception {
		ResultDto<Object> resultDto = new ResultDto<>();
		try {
			if (list != null && list.size() > 0) {
				String funCode = list.get(0).getFunCode();
				// 1、删除指定funCode的配置信息
				this.adminBaseMetaFunTableMapper.delMetaFunByFunCode(funCode);
				// 2、新增配置信息
				for (AdminBaseMetaFunTable adminBaseMetaFunTable : list) {
					this.adminBaseMetaFunTableMapper.insertSelective(adminBaseMetaFunTable);
					// 自动生成分配表的字段信息
					adminBaseMetaFunColumnService.initTable(adminBaseMetaFunTable.getTableCode(),adminBaseMetaFunTable.getFunSubType(), funCode);
				}
				resultDto.setCode(0);
				resultDto.setMessage("新增或保存业务模型配置信息成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultDto.setCode(500);
			resultDto.setMessage(e.getMessage());
		}
		return resultDto;
	}
	
//	@Cacheable(value = "AdminBaseMetaFunTable", key = "#funCode")
	public ConcurrentHashMap<String, Object> getFunTable(String funCode) {
		ConcurrentHashMap<String, Object> funTable = new ConcurrentHashMap<String, Object>();
		List<Map<String, Object>> list = this.adminBaseMetaFunTableMapper.querylist(funCode);
		for(Map<String,Object> map : list) {
			ConcurrentHashMap<String, String> tableInfo = new ConcurrentHashMap<String, String>();
			String tableName = String.valueOf(map.get("tableName"));
			String tableCnName = String.valueOf(map.get("tableCnName"));
			String funSubType = String.valueOf(map.get("funSubType"));
			String tableCode = String.valueOf(map.get("tableCode"));
			tableInfo.put("tableName", tableName);
			tableInfo.put("tableCnName", tableCnName);
			tableInfo.put("funSubType", funSubType);
			tableInfo.put("tableCode", tableCode);
			funTable.put(tableCode, tableInfo);
		}
		return funTable;
	}
	
//	@CachePut(value = "AdminBaseMetaFunTable", key = "#funCode")
	public ConcurrentHashMap<String, Object> refreshFunTable(String funCode) {
		ConcurrentHashMap<String, Object> funTable = new ConcurrentHashMap<String, Object>();
		List<Map<String, Object>> list = this.adminBaseMetaFunTableMapper.querylist(funCode);
		for(Map<String,Object> map : list) {
			ConcurrentHashMap<String, String> tableInfo = new ConcurrentHashMap<String, String>();
			String tableName = String.valueOf(map.get("tableName"));
			String tableCnName = String.valueOf(map.get("tableCnName"));
			String funSubType = String.valueOf(map.get("funSubType"));
			String tableCode = String.valueOf(map.get("tableCode"));
			tableInfo.put("tableName", tableName);
			tableInfo.put("tableCnName", tableCnName);
			tableInfo.put("funSubType", funSubType);
			tableInfo.put("tableCode", tableCode);
			funTable.put(tableCode, tableInfo);
		}
		return funTable;
	}
	
	/**
	 * @throws Exception 
	 * @方法名称: queryFunColumnInfo
	 * @方法描述:查询列信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public AdminBaseMetaFunTable queryFunTableInfo(String funCode,String funSubType) {
		return adminBaseMetaFunTableMapper.queryFunTableInfo(funCode,funSubType);
	}

}
