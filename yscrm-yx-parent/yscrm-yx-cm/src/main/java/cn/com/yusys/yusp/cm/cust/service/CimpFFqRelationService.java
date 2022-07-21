package cn.com.yusys.yusp.cm.cust.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqRelation;
import cn.com.yusys.yusp.cm.cust.repository.mapper.CimpFFqRelationMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqRelationService
 * @类描述: 
 * @功能描述: 数据集管理
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年11月08日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Service
public class CimpFFqRelationService extends CommonService{
	@Autowired
	private CimpFFqRelationMapper mapper;
	private final Logger logger = LoggerFactory.getLogger(CimpFFqRelationService.class);

	@Override
	protected CommonMapper getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	
	/**
	 * 查询基本信息
	 */
	public List<Map<String, Object>> getListByModel(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = mapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
	}
	
	/**
	 * 查询基本信息
	 */
	public List<Map<String, Object>> getDataObj() {
		List<Map<String, Object>> list = mapper.getDataObj();
		return list;
	}
	
	/**
	 * 查询右表
	 */
	public List<Map<String, Object>> getDataObjs(QueryModel queryModel) {
		String joinLeftTab = String.valueOf(queryModel.getCondition().get("joinLeftTab"));
		StringBuffer builder = new StringBuffer("select c.group_id as value,(c.dbtable_name||g.group_name) as name,c.dbtable_name as tabName  from " +
        		"CIMP_F_FQ_DBCOL c left join CIMP_f_fq_group g on c.group_id= g.id where 1=1 " +
        		"and c.group_id in (select id from CIMP_f_fq_group where obj_id = '"+joinLeftTab+"') "+
        		"group by c.group_id,c.dbtable_name,g.group_name");
       
        String SQL = builder.toString();
		List<Map<String, Object>> list = mapper.getDataObjs(SQL);
		return list;
	}
	
	/**
	 * 左表字段
	 */
	public List<Map<String, Object>> getColDataObj(QueryModel queryModel) {
		String tabname=(String)queryModel.getCondition().get("tabName");
		String joinLeftTab = String.valueOf(queryModel.getCondition().get("joinLeftTab"));
		StringBuffer builder = new StringBuffer("select c.id as value,c.col_name_e as name from cimp_F_FQ_DBCOL c " +
				"where 1=1 and c.obj_id = '"+joinLeftTab+"' and c.dbtable_name = '"+tabname+"'  ");
			
        String SQL = builder.toString();
		List<Map<String, Object>> list = mapper.getColDataObj(SQL);
		return list;
	}
	
	/**
	 * 右表字段
	 */
	public List<Map<String, Object>> getColDataObjs(QueryModel queryModel) {
		
		logger.info("joinRightTab==="+queryModel.getCondition().get("joinRightTab"));
		String tabName=(String)queryModel.getCondition().get("tabName");
		String joinRightTab = String.valueOf(queryModel.getCondition().get("joinRightTab"));
		StringBuffer builder = new StringBuffer("select c.id as value,c.col_name_e as name from CIMP_F_FQ_DBCOL c " +
				"where 1=1 and c.group_id = '"+joinRightTab+"' and c.dbtable_name = '"+tabName+"'  ");
			
        String SQL = builder.toString();
		List<Map<String, Object>> list = mapper.getColDataObjs(SQL);
		return list;
	}
	
	/**
	 * 新增
	 * @param record
	 * @return
	 */
	public int addData(CimpFFqRelation record){
		record.setId(mapper.getSeq());
		int num=mapper.addData(record);
		return num;
	}
	/**
	 * 修改
	 * @param record
	 * @return
	 */
	
	public int updateData(CimpFFqRelation record) {
		int count = 0;
		mapper.updateData(record);
		return count;
	}
	
	public int deletebyid(String id) {
		return mapper.deletebyid(id);
	}
	
}
