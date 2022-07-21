package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-admin
 * @类名称: SystemUtilMapper
 * @类描述: 系统控件dao
 * @功能描述:
 * @创建人: lupan@yusys.com.cn
 * @创建时间: 2017-12-27 18:52
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaSystemUtilMapper {
	/**
	 * 
	 * @方法名称: getUserByParam
	 * @方法描述: 获取用户信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String, Object>> getUserByParam(Map<String, Object> map);

	/**
	 *
	 * @方法名称: getOrgByParam
	 * @方法描述: 获取机构信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String, Object>> getOrgByParam(Map<String, Object> map);
	
	/**
	 * 
	 * @方法名称: getOrgByParamLazy
	 * @方法描述: 获取机构信息(懒加载)
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String, Object>> getOrgByParamLazy(Map<String, Object> map);
	/**
	 * 
	* @方法名称: getOrgtreeByParam
	* @方法描述: 获取机构树信息-只对控件使用
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> getOrgtreeByParam(Map<String, Object> map);
	/**
	 * 
	* @方法名称: getOrgtreeByParamApp
	* @方法描述: app中业绩预约用
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> getOrgtreeByParamApp();
	/**
	 * 
	* @方法名称: getOrgtreeByParam
	* @方法描述: 获取机构树信息-只对控件使用
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> getOrgtreeByParamLazy(Map<String, Object> map);
	/**
	 * 
	 * @方法名称: getDptByParam
	 * @方法描述: 根据参数获取岗位信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String, Object>> getDptByParam(Map<String, Object> map);

	/**
	 * 
	 * @方法名称: getRoleByParam
	 * @方法描述: 根据参数获取角色信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String, Object>> getRoleByParam(Map<String, Object> map);

	/**
	 * 
	 * @方法名称: getDutyByParam
	 * @方法描述: 根据参数获取岗位信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String, Object>> getDutyByParam(Map<String, Object> map);

	/**
	 * 
	 * @方法名称: getRoleByUser
	 * @方法描述: 根据会话用户获取绑定角色信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String, Object>> getRoleByUser(Map<String, Object> map);

	/**
	 * 
	 * @方法名称: getDutyByUser
	 * @方法描述: 根据会话用户获取岗位信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String, Object>> getDutyByUser(Map<String, Object> map);

	Map<String, Object> getorgById(String orgId);
	
	List<Map<String, Object>> getorgByIds(String[] orgIds);

	List<Map<String, Object>> getUserTdByParam(Map<String, Object> params);

	List<Map<String, Object>> getOrgtreeByParamLazyApp(Map<String, Object> params);

	/**
	 * 查询客户经理根据机构ID
	 * @param orgId
	 * @return
	 */
	List<Map<String, Object>> selectMktInfoByOrgId(String orgId);

	/**
	 * 查询团队根据机构ID
	 * @param orgId
	 * @return
	 */
	List<Map<String, Object>> selectTeamInfoByOrgId(String orgId);

	/**
	 * 查询指标维度的数据字典信息
	 * @param lookUpCode 字典项code
	 * @param indexId 指标ID
	 * @return
	 */
	List<Map<String,Object>> selectLookUpItemByIndexId(@Param("lookUpCode") String lookUpCode, @Param("indexId") String indexId);
}
