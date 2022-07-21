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
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowColumn;
import cn.com.yusys.yscrm.mgr.sys.pdplan.repository.mapper.OcrmFpdProdShowColumnMapper;
/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowColumnService
 * @类描述: 展示方案关联属性服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-24 19:40:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdProdShowColumnService extends CommonService {
    @Autowired
    private OcrmFpdProdShowColumnMapper ocrmFpdProdShowColumnMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFpdProdShowColumnMapper;
    }
    
    @Transactional(readOnly = true)
	public List<Map<String, String>> getList(QueryModel model) {
		// TODO 自动生成的方法存根
    	PageHelper.startPage(model.getPage(), model.getSize());
		String planId = (String) model.getCondition().get("planId");
		if (planId != null) {
			PageHelper.startPage(model.getPage(), model.getSize());
			List<Map<String, String>> list = ocrmFpdProdShowColumnMapper.getList(planId);
			PageHelper.clearPage();
			return list;
		}
		PageHelper.clearPage();
		return null;
	}
    
    @Transactional(readOnly = true)
	public List<Map<String, String>> getListNo(QueryModel model) {
		// TODO 自动生成的方法存根
    	
		String planId = (String) model.getCondition().get("planId");
		if (planId != null) {
			PageHelper.startPage(model.getPage(), model.getSize());
			List<Map<String, String>> list = ocrmFpdProdShowColumnMapper.getListNo(planId);
			PageHelper.clearPage();
			return list;
		}
		return null;
	}
    
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int join(List<OcrmFpdProdShowColumn> lists) {
		// TODO 自动生成的方法存根
		int num = 0;
		for (int i = 0; i < lists.size(); i++) {
			OcrmFpdProdShowColumn ocrmFpdProdShowColumn = lists.get(i);
			
			if (checkjoin(ocrmFpdProdShowColumn.getPlanId(), ocrmFpdProdShowColumn.getColumnId()) != 0) {
				continue;
			}
			ocrmFpdProdShowColumn.setRtableId(UUID.randomUUID().toString().replaceAll("-", ""));
			UtilTools.updateUtl(ocrmFpdProdShowColumn);
			num += insertSelective(getMapper(), ocrmFpdProdShowColumn);
		}
		return num;
	}
	@Transactional(readOnly = true)
	public int checkjoin(String planId,String columnId) {
		return ocrmFpdProdShowColumnMapper.checkjoin(planId,columnId);
	};
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int save(List<OcrmFpdProdShowColumn> lists) {
		// TODO 自动生成的方法存根
		int num = 0;
		for (int i = 0; i < lists.size(); i++) {
			OcrmFpdProdShowColumn ocrmFpdProdShowColumn = lists.get(i);
			deleteByIds(ocrmFpdProdShowColumn.getRcloumnId());
			insertSelective(getMapper(), ocrmFpdProdShowColumn);
		}
		return num;
	}
	@Transactional(readOnly = true)
	public List<Map<String, String>> getprodInfo(QueryModel model) {
		// TODO 自动生成的方法存根
		String catlCode = (String)model.getCondition().get("catlCode");
		List<Map<String, String>> tableCoumn=ocrmFpdProdShowColumnMapper.gettopName(catlCode);
		String showColum="";
		String lookupSql="";
		for(int i=0;i<tableCoumn.size();i++) {
			if(tableCoumn.get(i).get("dicName")!=null) {
					lookupSql=lookupSql + " left join admin_sm_lookup_item item"+i+" on item"+i+".lookup_code='"+tableCoumn.get(i).get("dicName")+
							"' and item"+i+".lookup_item_code="+tableCoumn.get(i).get("tableOthName")+"."+tableCoumn.get(i).get("columnName");
					if(i==tableCoumn.size()-1) {
						showColum=showColum+" item"+i+".lookup_item_name as "+tableCoumn.get(i).get("columnName");
					}else {
						showColum=showColum+" item"+i+".lookup_item_name as "+tableCoumn.get(i).get("columnName")+",";
					}
			}else if(tableCoumn.get(i).get("columnType")!=null&&tableCoumn.get(i).get("columnType").equals("DATE")) {
				if(i==tableCoumn.size()-1) {
					showColum=showColum+"to_char("+tableCoumn.get(i).get("tableOthName")+"."+tableCoumn.get(i).get("columnName")+",'yyyy-MM-dd') as "+tableCoumn.get(i).get("columnName");
				}else {
					showColum=showColum+"to_char("+tableCoumn.get(i).get("tableOthName")+"."+tableCoumn.get(i).get("columnName")+",'yyyy-MM-dd') as "+tableCoumn.get(i).get("columnName")+",";
				}
			}else {
				if(i==tableCoumn.size()-1) {
					showColum=showColum+tableCoumn.get(i).get("tableOthName")+"."+tableCoumn.get(i).get("columnName");
				}else {
					showColum=showColum+tableCoumn.get(i).get("tableOthName")+"."+tableCoumn.get(i).get("columnName")+",";
				}
			}
		}
		String sql = null;
		Map<String, String> showr = ocrmFpdProdShowColumnMapper.getSql(catlCode);
//		if (showr.get("planType").equals("1")) {
//			sql = "select * " + showr.get("rFrom") + " " + showr.get("rWhere") + " AND " + showr.get("custColumn") + " = \'" + model.getCondition().get("custId") + "\'";
//		}else if (showr.get("planType").equals("2")) {
//			sql = "select * " + showr.get("rFrom") + " " + showr.get("rWhere") + " AND PRODUCT_ID " + " = \'" + model.getCondition().get("productId") + "\'";
//		}
		if (showr.get("planType").equals("1")) {
			sql = " select "+ showColum +" "+ showr.get("rFrom") + " " + lookupSql+" "+ showr.get("rWhere") + " AND " + showr.get("custColumn") + " = \'" + model.getCondition().get("custId") + "\'";
		}else if (showr.get("planType").equals("2")) {
			sql = " select  " +showColum+" "+ showr.get("rFrom") + " " +lookupSql+ " "+showr.get("rWhere") + " AND PRODUCT_ID " + " = \'" + model.getCondition().get("productId") + "\'";
		}
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list= ocrmFpdProdShowColumnMapper.getprodInfo(sql);
		PageHelper.clearPage();
		return list;
	}
	@Transactional(readOnly = true)
	public List<Map<String, String>> getProdTree(QueryModel model) {
		// TODO 自动生成的方法存根
		List<Map<String, String>> list = ocrmFpdProdShowColumnMapper.getCustProd(model);
		if (list.size() == 0) {
			return null;
		}
		String sql = "";
		for (int i = 0; i < list.size(); i++) {
			Map<String, String> map = list.get(i);
			if (i==0) {
				sql = " SELECT * FROM ACRM_F_PD_PROD_CATL A START WITH A.CATL_CODE = \'" + map.get("catlCode") + "\'  CONNECT BY PRIOR A.CATL_PARENT = A.CATL_CODE";
			}
			if (i>0) {
				sql += " UNION SELECT * FROM ACRM_F_PD_PROD_CATL A START WITH A.CATL_CODE = \'" + map.get("catlCode") + "\'  CONNECT BY PRIOR A.CATL_PARENT = A.CATL_CODE";
			}
		}
		return ocrmFpdProdShowColumnMapper.getProdTree(sql);
	}
	@Transactional(readOnly = true)
	public List<Map<String, String>> gettopName(String catlCode) {
		// TODO 自动生成的方法存根
		return ocrmFpdProdShowColumnMapper.gettopName(catlCode);
	}

}
