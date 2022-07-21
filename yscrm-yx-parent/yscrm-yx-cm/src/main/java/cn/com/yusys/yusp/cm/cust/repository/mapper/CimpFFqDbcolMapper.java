package cn.com.yusys.yusp.cm.cust.repository.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqDbcol;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqDbcolMapper
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
public interface CimpFFqDbcolMapper extends CommonMapper<CimpFFqDbcol>{
	String getSeq();
	long getSeqId();
	List<CimpFFqDbcol> qryCollist(QueryModel model);
	List<CimpFFqDbcol> isExist(QueryModel model);
	List<CimpFFqDbcol> qrysetdata(QueryModel model);
	List<CimpFFqDbcol> qryallsetdata(String SQL);
	List<Map<String, Object>> loadData(String id);
	List<Map<String, Object>> prepare(String SQL);
	List<CimpFFqDbcol> getResultList(String SQL);
	List<CimpFFqDbcol> queryColumns(String SQL);
	List<CimpFFqDbcol> queryLeftTab(String SQL);
	List<CimpFFqDbcol> queryJoinColumms(String SQL);
	String getSingleResult(String SQL);
	List<CimpFFqDbcol> getSingleResults(String SQL);
	List<Map<String, Object>> queryResult(String SQL);
	int deleteData(CimpFFqDbcol record);
	void insertDbcol(List list);
	List<Map<String, Object>> showcoltype(QueryModel model);
	List<Map<String, Object>> qryLookupcode();
	List<Map<String, Object>> getcodeitem(String lookupCode);
	List<CimpFFqDbcol> getDataSetSolution();
	void deleteByid(String id);
	List<Map<String, Object>> qryCustinfo(String sql);
}
