package cn.com.yusys.yusp.cm.indexplan.repository.mapper;

import cn.com.yusys.yusp.admin.domain.AdminSmOrg;
import cn.com.yusys.yusp.admin.domain.AdminSmUser;
import cn.com.yusys.yusp.cm.indexplan.domain.CimpCmAssemblyAnalysis;
import cn.com.yusys.yusp.cm.indexplan.domain.ObjectInfo;
import cn.com.yusys.yusp.cm.indexplan.domain.YscimcIndexStatePo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmAsseminfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 营销成效策划指标
 * @author zhanghan3
 * 20181120
 */
public interface CimpCmIndexPlanMapper extends CommonMapper<CimpCmAssemblyAnalysis> {

	String getSeq();

	int deletePlan(String ids);

	List<Map<String, Object>> getProductList(@Param("proId") String proId);

	List<Map<String, Object>> getIndexList(@Param("proId") String proId);

	//	List<Map<String, Object>> targetQuery(@Param("sql") String sql);
	List<CimpCmAssemblyAnalysis> targetQuery(@Param("nodeId") String nodeId);

	int saveAssembly(String ids);

	void deleteAssembly(@Param("nodId") String nodId);

	List<Map<String, Object>> getAssembly(String flowId);

	String proQuery(String flowId);

	List<Map<String, Object>> getProduct(@Param("productId") String productId);

	List<Map<String, Object>> chaQuery(String flowId);

	String proIndexList(String nodeId);

	String getProId(String nodeId);

	List<Map<String, Object>> orgQuery();

	List<Map<String, Object>> customerquery();

	List<Map<String, Object>> customerByLoginCode(String customerLogCode);

	List<Map<String, Object>> customerquery(QueryModel model);

	List<Map<String, Object>> customerMgrQuery(QueryModel model);

	List<String> childOrg(String orgId);

	String selectNodeId(String tempId);

	List<AdminSmUser> selectCustomerId(List<String> orgCodeList);

	List<CimpCmAssemblyAnalysis> selectTotalIndex(@Param("orgId") Set<String> orgId, @Param("nodeId") String nodeId);

	List<CimpCmAssemblyAnalysis> selectChildOrgIndex(@Param("nodeId") String nodeId, @Param("objIdList") List<String> objIdList);

	List<CimpCmAssemblyAnalysis> indexDistributionQuery(@Param("nodeId") String nodeId, @Param("objIdList") List<String> objIdList);

	List<AdminSmOrg> selectOrgId(String orgName);

	List<AdminSmUser> selectObjId(String objName);

	List<CimpCmAsseminfo> selectChannel(ObjectInfo objectInfo);

	void deleteOriginalIndex(@Param("objIdList")List<String> objIdList, @Param("nodeId")String nodeId);

	Set<String> selectObjIdBynodeId(String nodeId);

	String selectCreateOrg(String tempId);

	List<AdminSmOrg> fuzzSelectOrgId(@Param("objName")String objName, @Param("orgCodeList")List<String> orgCodeList);

	List<AdminSmUser> fuzzSelectCustomerMgrId(@Param("objName")String objName,@Param("orgId") String orgId);

	List<AdminSmUser> selectCustomerMgrIdOfOrg(ObjectInfo objectInfo);

	List<CimpCmAssemblyAnalysis> selectOrgIndex(@Param("nodeId")String nodeId,@Param("orgId")String orgId);

	List<Map<String, Object>> customerQueryByOrgId(QueryModel model);

    List<Map<String, Object>> taskDataForOrgUrl(QueryModel model);

	List<Map<String, Object>> taskDataForMgrUrl(QueryModel model);

	String getActivityId(String nodeId);
	
	String getActivityName(String activityId);


	void insertIndexStateList(List<YscimcIndexStatePo> yscimcIndexStatePoList);

	Integer selectOrgIndexState(String orgId);

	void insertIndexState(YscimcIndexStatePo yscimcIndexStatePo);

	void deleteIndexState(String activityId);

	List<YscimcIndexStatePo> selectIndexState(String activityId);

	void updateIndexState(YscimcIndexStatePo yscimcIndexStatePo);

    String selectOrgName(String objId);
}

