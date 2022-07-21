package cn.com.yusys.yusp.cm.cust.repository.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqRelation;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqRelationMapper
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

@Mapper
public interface CimpFFqRelationMapper extends CommonMapper<CimpFFqRelation>{
	List<Map<String, Object>> getListByModel(QueryModel model);
	List<Map<String, Object>> getDataObj();
	List<Map<String, Object>> getDataObjs(String SQL);
	List<Map<String, Object>> getColDataObj(String SQL);
	List<Map<String, Object>> getColDataObjs(String SQL);
	List<CimpFFqRelation> queryRelations(String SQL);
	long getSeq();
	int deletebyid(String id);
	int addData(CimpFFqRelation record);
	void updateData(CimpFFqRelation record);
}
