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
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowTable;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdShowColumnMapper;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdShowTableMapper;
/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowTableService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-24 19:39:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdProdShowTableService extends CommonService {
    @Autowired
    private OcrmFpdProdShowTableMapper ocrmFpdProdShowTableMapper;
    /*
     * 展示方案关联属性Mapper
     */
    @Autowired
    private OcrmFpdProdShowColumnMapper ocrmFpdProdShowColumnMapper;
	private static final String PLANID =  "planId";
    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFpdProdShowTableMapper;
    }
    /*
     * 查询相关联的表信息
     */
    @Transactional(readOnly = true)
	public List<Map<String, String>> getListByPlanId(QueryModel model) {
		// TODO 自动生成的方法存根
    	PageHelper.startPage(model.getPage(), model.getSize());
    	List<Map<String, String>> list = ocrmFpdProdShowTableMapper.getListByPlanId((String)model.getCondition().get(PLANID));
		PageHelper.clearPage();
    	
		return list;
	}
    /*
     * 查询未关联的表信息
     */
	@Transactional(readOnly = true)
	public List<Map<String, String>> getListByPlanIdNo(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
    	List<Map<String, String>> list = ocrmFpdProdShowTableMapper.getListByPlanIdNo((String)model.getCondition().get(PLANID));
		PageHelper.clearPage();
		return list;
	}
	/*
	 * 获取传参封装成对象，再调用接口新增，返回成功添加的信息条数
	 */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int save(QueryModel model) {
		// TODO 自动生成的方法存根
		int num = 0;
		String planId = (String) model.getCondition().get(PLANID);
		String planName = (String) model.getCondition().get("planName");
		String[] tableIds = ((String)model.getCondition().get("tableIds")).split(",");
		for (int i = 0; i < tableIds.length; i++) {
			String tableId = tableIds[i];
			if (checkSave(planId, tableId) != 0) {
				continue;
			}
			OcrmFpdProdShowTable ocrmFpdProdShowTable = new OcrmFpdProdShowTable();
			ocrmFpdProdShowTable.setRtableId(UUID.randomUUID().toString().replaceAll("-", ""));
			ocrmFpdProdShowTable.setPlanId(planId);
			ocrmFpdProdShowTable.setTableId(tableId);
			ocrmFpdProdShowTable.setPlanName(planName);
			UtilTools.updateUtl(ocrmFpdProdShowTable);
			num += insertSelective(getMapper(), ocrmFpdProdShowTable);
		}
		return num;
	}
	public int del(String ids) {
		// TODO 自动生成的方法存根
		String[] id = ids.split(",");
		int num = 0;
		for (int i = 0; i < id.length; i++) {
			String rtableId = id[i];
			ocrmFpdProdShowColumnMapper.deleteByRTableId(rtableId);
			num++;
		}
		return num;
	}
	
	public int checkSave(String planId, String tableId) {
	return	ocrmFpdProdShowTableMapper.checkSave(planId,tableId);
	}

}
