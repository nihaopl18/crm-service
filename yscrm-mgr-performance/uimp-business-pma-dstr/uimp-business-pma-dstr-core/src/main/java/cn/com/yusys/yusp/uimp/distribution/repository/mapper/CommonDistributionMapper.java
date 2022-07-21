package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.audit.domain.PmaFAppointAuditInfo;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: CommonDistributionMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-02 14:45:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface CommonDistributionMapper extends CommonMapper<PmaFAppointAuditInfo> {
	
	List<Map<String, Object>> listByModel(String sqlStr);
	List<Map<String, Object>> queryPeriodTable(String SQL);
	List<Map<String, Object>> queryDistributeTable(String SQL);
	List<Map<String, Object>> queryPeriodHisTable(String SQL);
	List<Map<String, Object>> queryDistributeHisTable(String SQL);
	List<Map<String, Object>> queryPeriodHisTableForVet(String SQL);
	String getQueryId(String queryIdSequenceSQL);
	List<Map<String, Object>> selectPeriod(String string);
	void pass(List<String> sqlList);
	void insertConFun(List<String> sqlList);
	Map<String, Object> save(List<String> sqlList);
	void reject(List<String> sqlList);
	Map<String, String> queryUserIdByRoleCode(@Param("roleCode") String roleCode,@Param("orgId")  String orgId);
	Map<String, Object> queryEtlState();
	Map<String, Object> queryTimeState();
	List<Map<String, Object>> selectApproveUser(@Param("orgId") String orgId);
	/**
	 * @方法名称: executeInsertSql
	 * @方法描述: 动态执行新增语句-公共方法
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Integer executeInsertSql(@Param("sqlStr") String sqlStr);
}