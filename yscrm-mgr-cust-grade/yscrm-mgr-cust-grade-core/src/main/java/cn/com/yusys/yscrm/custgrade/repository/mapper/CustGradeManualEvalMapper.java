package cn.com.yusys.yscrm.custgrade.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custgrade.domain.OcrmFciPreGradeApplyInfo;

/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: CustGradeManualEvalMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-20 16:12:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CustGradeManualEvalMapper extends CommonMapper<OcrmFciPreGradeApplyInfo> {
	List<Map<String, Object>> querylist(QueryModel queryModel);
	
	List<Map<String, Object>> querylistSingle(QueryModel queryModel);
	Map<String, String> getMgrType(Map<String, String> map);
	
	List<Map<String, Object>> querylistByCustId(QueryModel queryModel);
/**
 * 查询 客户 业务信息 的数据
 */
	List<Map<String, Object>> queryBuss(String custId);
	/**
	 * 查询当前客户是否在审批中
	 */
	 int queryIsApply(String custId);
	 /**
	  * 审批之后逻辑
	  */
	int updateApply(Map<String,String> applyInfo);
	
	/**
	 * 审批通过执行逻辑
	 */
	
	int updateCustServal (Map<String,String> servalueInfo);
	/**
	 *  查询当前客户的 所有归属机构
	 */
	List<Map<String,Object>> queryBelongOrg(String custId);
	
	/**
	 *  查询申请机构信息
	 */
	List<Map<String,Object>> queryApplyOrg(Map<String,String> orgInfo);
	/**
	 * 查询传入机构的上级机构。只查到分行
	 */
	List<Map<String,Object>> queryUpOrg(String org); 
	
	/**
	 * 查询当前机构 是否是总行，分行 
	 */
	int queryCurrOrg(String org); 

	/**
	 * 查询申请数据列表
	 */
	List<Map<String,Object>> queryApplyInfo(String applyId); 
     
	/**
	 * 同步等级
	 */
	
	int updatePerCustser (Map<String,String> servalueInfo);
	int updateOrgCustser (Map<String,String> servalueInfo);
	int updatePerAdmit(Map<String, String> applyMap);
	int updateAdmitAll(Map<String, String> applyMap);

}