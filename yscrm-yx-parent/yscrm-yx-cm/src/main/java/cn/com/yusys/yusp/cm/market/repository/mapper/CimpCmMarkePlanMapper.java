package cn.com.yusys.yusp.cm.market.repository.mapper;

import cn.com.yusys.yusp.cm.indexplan.domain.YscimcIndexStatePo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketPositCt;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplanVo;
import cn.com.yusys.yusp.cm.market.form.ActivityReqForm;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * 营销活动策划——营销活动管理
 * @author zhanghan3
 * 20181113
 */
public interface CimpCmMarkePlanMapper extends CommonMapper<CimpCmMarketplan>{
	
	//营销策划查询方法
	List<CimpCmMarketplanVo> getMarketPlanList(QueryModel model);
	String getSeq();
	Integer deletePlan(@Param("ids") String ids);
	/**
	 * 
	* @方法名称: getFieldsInfo
	* @方法描述: 查询字段表格中的字段信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getFieldsInfo(Map<String,String> params);
	/**
	 * 
	* @方法名称: queryPositCtDate
	* @方法描述: 查询时间区间内是否有相同渠道的营销位内容
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> queryPositCtDate(CimpCmMarketPositCt params);
	/**
	 * 
	* @方法名称: updateFlowStsById
	* @方法描述: 更新流程信息状态
	* @参数与返回说明: 
	* @算法描述:
	 */
	void updateFlowStsById(Map<String,String> params);
	
	
	/**
	 * 
	* @方法名称: getmktPositContent
	* @方法描述: 获取节点营销位内容
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getmktPositContent(@Param("nodeId") String nodeId);

	CimpCmMarketplan gettempById(String tempId);
	/**
	 * 
	* @方法名称: deleteMktPositContent
	* @方法描述: 删除节点下的营销位内容信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	void deleteMktPositContent(@Param("nodeId") String nodeId);
	/**
	* @方法名称:delMktPositByCtNodeId
	* @方法描述:根据节点ct_node_id删除营销位内容信息表
	* @参数与返回说明:ct_node_id
	* @算法描述:
	 */
	void delMktPositByCtNodeId(@Param("nodeId") String nodeId);
	/**
	 * 
	* @方法名称: getNodeIdFormId
	* @方法描述: 获取NodeIdFormId
	* @参数与返回说明: 流程id
	* @算法描述:
	 */
	Map<String,Object> getNodeIdFormId(String tempId);
	
	/**
	 * 
	* @方法名称: delPresentation
	* @方法描述: 删除节点操作表
	* @参数与返回说明: formId
	* @算法描述:
	 */
	int delPresentation(String formId);
	
	/**
	 * 
	* @方法名称: delDisplay
	* @方法描述: 删除节点表现表
	* @参数与返回说明: formId
	* @算法描述:
	 */
	int delDisplay(String formId);
	
	/**
	 * 
	* @方法名称: delInfo
	* @方法描述: 删除节点信息表
	* @参数与返回说明: tempId
	* @算法描述:
	 */
	int delInfo(String tempId);
	
	/**
	 * 
	* @方法名称: delCard
	* @方法描述: 删除卡片信息表
	* @参数与返回说明: actyId
	* @算法描述:
	 */
	int delCard(String actyId);
	
	/**
	* @方法名称: updateWfStatus
	* @方法描述: 更新活动流程状态
	* @参数与返回说明: 活动id，审批状态
	* @算法描述:
	 */
	int updateWfStatus(Map<String,Object> param);

	/**
	 * 通过活动编号获取该活动下手机银行关联的营销方式
	 * @param actId
	 * @return
	 */
    List<String> getMarketTypeIdByActId(String actId);

	List<String> childOrg(String orgId);

	List<CimpCmMarketplan> getMarketPlanListByOrgCode(@Param(value="orgCodeList")ArrayList<String> orgCodeList, @Param("keyWord")String keyWord);

	List<CimpCmMarketplan> getMarketPlanListByFuzzyQuery(String keyWord);

    Map getActBaseInfobyid(String tempId);

	List<Map<String, Object>> getListByCondition(QueryModel model);
	List<YscimcIndexStatePo> selectActivity(@Param("reqForm") ActivityReqForm reqForm,@Param("activityIdList")List<String> activityIdList);
}
