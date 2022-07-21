package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaSystemUtilMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-admin1
 * @类名称: SystemUtilService
 * @类描述: 业务控件业务
 * @功能描述: 
 * @创建人: lupan@yusys.com.cn
 * @创建时间: 2018-01-04 10:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class PmaSystemUtilService {
	@Autowired
	private PmaSystemUtilMapper mapper;

	/**
	 * @param needManage-是否需要管理机构
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getOrgByParam(String orgId, String userId, boolean needManage,boolean lazy) {
		Map<String, Object> params = new HashMap<>();
		// 模拟会话中的信息
		params.put("orgId", orgId);
		params.put("userId", userId);
		params.put("needManage", needManage);
		if(lazy) {
			return mapper.getOrgByParamLazy(params);
		}
		
		return mapper.getOrgByParam(params);
	}
	
	/**
	 * 
	* @param needTeam 
	 * @方法名称: getOrgtreeByParam
	* @方法描述: 获取机构树控件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getOrgtreeByParam(String orgCode, String userId, boolean needManage,
			boolean needFin, boolean needDpt, String orgLevel,boolean lazy, boolean needTeam) {
		Map<String, Object> params = new HashMap<>();
		params.put("orgCode", orgCode);
		params.put("userId", userId);
		params.put("needManage", needManage);
		params.put("needFin", needFin);
		params.put("needDpt", needDpt);
		params.put("needTeam", needTeam);
		params.put("orgLevel", orgLevel);
		if(lazy) {
			return mapper.getOrgtreeByParamLazy(params);
		}
		return mapper.getOrgtreeByParam(params);
	}
	public List<Map<String, Object>> getOrgtreeByParamApp(String orgCode,boolean lazy) {
		Map<String, Object> params = new HashMap<>();
		params.put("orgCode", orgCode);
		if(lazy) {
			return mapper.getOrgtreeByParamLazyApp(params);
		}
		return mapper.getOrgtreeByParamApp();
	}
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getDptByParam(Map<String, Object> params) {
		return mapper.getDptByParam(params);
	}

	/**
	 * 
	 * @方法名称: getUserByParam
	 * @方法描述: 获取用户通过参数
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getUserByParam(Map<String, Object> params) {
		return mapper.getUserByParam(params);
	}
	/**
	 * 
	 * @方法名称: getUserByParam
	 * @方法描述: 获取用户通过参数
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getUserTdByParam(Map<String, Object> params) {
		return mapper.getUserTdByParam(params);
	}
	/**
	 * 
	 * @方法名称: getRoleByParam
	 * @方法描述: 获取角色根据参数
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getRoleByParam(Map<String, Object> params) {
		return mapper.getRoleByParam(params);
	}

	/**
	 * 
	 * @方法名称: getDutyByParam
	 * @方法描述: 获取岗位通过参数
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getDutyByParam(Map<String, Object> params) {
		return mapper.getDutyByParam(params);
	}

	/**
	 * 
	 * @方法名称: getRoleByUser
	 * @方法描述: 根据会话用户获取角色
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getRoleByUser(String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return mapper.getRoleByUser(params);
	}

	/**
	 * 
	 * @方法名称: getDutyByUser
	 * @方法描述: 获取部门通过用户
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getDutyByUser(String userId) {
		Map<String, Object> params = new HashMap<>();
		params.put("userId", userId);
		return mapper.getDutyByUser(params);
	}

	public Map<String, Object> getorgById(String orgId) {
		return mapper.getorgById(orgId);
	}

	public List<Map<String, Object>> getorgByIds(String orgIds) {
		return mapper.getorgByIds(orgIds.split(","));
	}


	public List<Map<String, Object>> getTeamOrMktInfo(String orgId,String evlObjType) {

		if("01".equals(evlObjType)){
			//查询客户经理
			return mapper.selectMktInfoByOrgId(orgId);
		}else{
			//查询团队
			return mapper.selectTeamInfoByOrgId(orgId);
		}

	}

	/**
	 * 查询指标维度字典项，在考核方案和派生指标模块使用
	 * @param lookUpCode 数据字典code
	 * @param indexId 指标ID
	 * @return
	 */
	public List<Map<String,Object>> getLookUpItemByIndexId(String lookUpCode, String indexId){

		return mapper.selectLookUpItemByIndexId(lookUpCode,indexId);
	}

}
