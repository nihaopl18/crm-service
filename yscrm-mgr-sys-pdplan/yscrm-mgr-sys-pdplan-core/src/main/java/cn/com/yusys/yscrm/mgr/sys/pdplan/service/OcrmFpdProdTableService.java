package cn.com.yusys.yscrm.mgr.sys.pdplan.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdTable;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdColumnMapper;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdTableMapper;
/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdTableService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-23 19:28:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdProdTableService extends CommonService {
    @Autowired
    private OcrmFpdProdTableMapper ocrmFpdProdTableMapper;
    
    @Autowired
    private OcrmFpdProdColumnMapper ocrmFpdProdColumnMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFpdProdTableMapper;
    }
    
    @Transactional(readOnly = true)
	public List<Map<String, String>> getTableName() {
		// TODO 自动生成的方法存根
		return ocrmFpdProdTableMapper.getTableName();
	}
    
    @Transactional(readOnly = true)
	public List<Map<String, String>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = ocrmFpdProdTableMapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
		
	}
    
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public OcrmFpdProdTable add(OcrmFpdProdTable ocrmFpdProdTable) {
		// TODO 自动生成的方法存根
		ocrmFpdProdTable.setTableId(UUID.randomUUID().toString().replaceAll("-", ""));
		UtilTools.createUtl(ocrmFpdProdTable);
		UtilTools.updateUtl(ocrmFpdProdTable);
		if (insertSelective(getMapper(), ocrmFpdProdTable) == 1) {
			return ocrmFpdProdTable;
		}
		return null;
	}
	
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int updateFun(OcrmFpdProdTable ocrmFpdProdTable) {
		// TODO 自动生成的方法存根
		UtilTools.updateUtl(ocrmFpdProdTable);
		return updateSelective(getMapper(),ocrmFpdProdTable);
	}
	
	/**
   	* @方法名称: getTableInfo
   	* @方法描述:获取表信息
   	* @参数与返回说明: 判断传入的表名是否存在数据库中，如果存在则返回表信息，如果不存在将执行另外方法获取信息
   	* @算法描述: 
   	*/
	@Transactional(readOnly = true)
	public List<Map<String, String>> getTableInfo(QueryModel model) {
		// TODO 自动生成的方法存根
		List<Map<String, String>> list = null;
		PageHelper.startPage(model.getPage(), model.getSize());
		String tableName = (String) model.getCondition().get("tableName");
		list = ocrmFpdProdTableMapper.getTableInfoByTable(tableName);
		if (list.size() < 1) {
			list = ocrmFpdProdTableMapper.getTableInfo(tableName);
		}
		PageHelper.clearPage();
		return list;
	}
	/*
	 * 检查表名是否存在
	 */
	@Transactional(readOnly = true)
	public int checkTableName(String tableName) {
		// TODO 自动生成的方法存根
		return ocrmFpdProdTableMapper.checkTableName(tableName);
	}
	/*
	 * 检查表别名是否存在
	 */
	@Transactional(readOnly = true)
	public int checkTableOthName(String tableOthName) {
		// TODO 自动生成的方法存根
		return ocrmFpdProdTableMapper.checkTableOthName(tableOthName);
	}

	public int del(String ids) {
		// TODO 自动生成的方法存根
		String[] id = ids.split(",");
		int num = 0;
		for (int i = 0; i < id.length; i++) {
			ocrmFpdProdTableMapper.delById(id[i]);
			ocrmFpdProdColumnMapper.delColumnsByTableId(id[i]);
			num++;
		}
		return num;
	}

}
