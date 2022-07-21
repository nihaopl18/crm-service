package cn.com.yusys.yusp.cm.market.repository.mapper;

import cn.com.yusys.yusp.cm.market.domain.FrTransInfoModel;
import cn.com.yusys.yusp.cm.market.domain.FrTransMapModel;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcTableEcName;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 交易管理mapper
 * @author Administrator
 *
 * @param <T>
 */
@Mapper
public interface TransManagerMapper  extends CommonMapper<FrTransInfoModel> {

	List<Map<String, String>> getTransList(QueryModel model);
	List<Map<String, String>> getTransListWithNoPage(FrTransInfoModel model);
	void transUpdateByPk(FrTransInfoModel model);
	void transInsert(FrTransInfoModel model);
	void deleteTransByPks(Map<String,List<String>>  pks);
	void  deleteTransMapByPks(Map<String,List<String>>  pks);
	FrTransInfoModel getTrans(@Param("transCode") String transCode);
	List<FrTransMapModel>  getCurrentTransParamList(FrTransInfoModel model);
	
	List<Map<String, String>>  getTransParamList(QueryModel model); 
	
	List<Map<String, String>> getRruleDetailConfigDetail(String transcode);
	
	List<FrTransInfoModel> querylist(QueryModel model);
	int dropTable(Map<String, Object> map);
	int createTable(Map<String, Object> map);
	List<Map<String,String>> selectTab(@Param("tabName") String tabName);
	int delTrans(@Param("transCode") String transCode);
	int insertTrans(Map<String, Object> map);
	void updateTransByCode(@Param("transCode") String transCode);
	List<CmFRcTableEcName> getTableByTransCode(@Param("transCode") String transCode);
}
