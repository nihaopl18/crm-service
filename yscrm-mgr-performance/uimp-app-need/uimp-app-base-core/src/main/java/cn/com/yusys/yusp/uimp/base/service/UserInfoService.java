package cn.com.yusys.yusp.uimp.base.service;

import cn.com.yusys.yusp.admin.service.AdminSmOrgService;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: UserInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-07 17:56:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service("performanceUserInfoService")
public class UserInfoService {

	@Autowired
	private UaaClient uaaClient;

	@Autowired
	private AdminSmOrgService adminSmOrgService;
	/**
	 * @方法名称: getUserInfo
	 * @方法描述: 获取用户登录信息
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public UserInfoDTO getUserInfo() {
		return uaaClient.getUserSessionInfo(SecurityUtils.getCurrentUserLogin()).getBody();
	}
	
//	/**
//	 * @方法名称: getUserInfo
//	 * @方法描述: 获取用户登录信息
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public User getUserInfo(String loginCode) {
//		return uaaClien.(loginCode, null, SecurityUtils.getCurrentUserToken());
//	}
//
	/**
	 * @方法名称: getOrgLevel
	 * @方法描述: 获取当前登录用户机构层级
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	public String getOrgLevel() {
		UserInfoDTO user = getUserInfo();
		return (String) user.getOrg().getMap().get("orgLevel");
	}
	
	/**
	 * @方法名称: getGrantOrgCode
	 * @方法描述: 获取当前登录用户授权机构代码
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public String getGrantOrgCode() {
		UserInfoDTO user = getUserInfo();
		//return (String) user.getMap().get("grantOrgCode");
		return user.getOrg().getCode();
	}
	
	/**
	 * @方法名称: getOrgCode
	 * @方法描述: 获取当前登录用户机构代码
	 * @参数与返回说明:
	 * @算法描述:
	 */
	public String getOrgCode() {
		return getGrantOrgCode();
	}
	
	/**
	 * @方法名称: isMgr
	 * @方法描述: 获取当前登录用户是否为客户经理
	 * @参数与返回说明:
	 * @算法描述:
	 */
	private String isMgr() {
		UserInfoDTO user = getUserInfo();
		// 这里需要改造，否则无法适配
		return "0";
		//return (String) user.getOrg().getMap().get("isMgr");
	}
	
	/**
	 * @方法名称: processDataOrgAuth
	 * @方法描述: 获取指定机构数据授权
	 * @参数与返回说明:
	 * orgColumnName 机构列名称
	 * dataOrgAuth CUR_ORG 当前机构，SUB_ORG当前机构及辖内，CUR_PAR当前机构及上辖，SUB_ORG_INNER当前机构及直属辖内机构
	 * orgCode 机构号
	 * @算法描述:
	 */
	public String processDataOrgAuth(String orgColumnName,String dataOrgAuth,String orgCode) {
		StringBuffer sql = new StringBuffer("");
		if ("CUR_ORG".equals(dataOrgAuth)) {//当前机构权限
			sql.append(" AND ").append(orgColumnName).append(" = '").append(orgCode).append("' ");
		} else if ("SUB_ORG".equals(dataOrgAuth)) { //辖内机构权限
			sql.append(" and exists (select 1 from SYS_UNITS c where ");
			sql.append(orgColumnName);
			sql.append("=c.unitid and REGEXP_LIKE (c.unitseq,'(^|,)(");
			sql.append(orgCode).append(")($|,)') )");
		} else if("CUR_PAR".equals(dataOrgAuth)) { //当前机构和上级机构
			sql.append(" and ( (");
			sql.append(orgColumnName);
			sql.append(" in ");
			sql.append(" ( WITH ORG_TMP (UP_ORG_ID,ORG_ID,START_ORG_ID) AS ");
			sql.append("        (");
			sql.append("        SELECT  P.UP_ORG_ID ");
			sql.append("               ,P.ORG_ID ");
			sql.append("               ,P.ORG_ID ");
			sql.append("        FROM ADMIN_SM_ORG P ");
			sql.append("        UNION ALL ");
			sql.append("        SELECT  B.UP_ORG_ID,ORG_TMP.UP_ORG_ID,ORG_TMP.START_ORG_ID ");
			sql.append("           FROM ORG_TMP ");
			sql.append("          INNER JOIN  ADMIN_SM_ORG B ");
			sql.append("             ON ORG_TMP.UP_ORG_ID = B.ORG_ID ");
			sql.append("            WHERE ORG_TMP.UP_ORG_ID  IS NOT NULL ");
			sql.append("        ) ");
			sql.append(" SELECT UP_ORG_ID FROM ORG_TMP where START_ORG_ID = '"+orgCode+"' ");
			sql.append(") ");
			sql.append(") ");
			sql.append(" OR ( ");
			sql.append(orgColumnName);
			sql.append(" in (SELECT org_code FROM admin_sm_org a where a.up_org_id ='"+orgCode+"' or a.org_code ='"+orgCode+"' )");
			sql.append(") ");
			sql.append(") ");
		} else if ("SUB_ORG_INNER".equals(dataOrgAuth)) { //当前机构及直属辖内机构
			sql.append(" and  ");
			sql.append(orgColumnName);
			sql.append(" in (SELECT org_code FROM admin_sm_org a where a.up_org_id ='"+orgCode+"' or a.org_code ='"+orgCode+"' )");
		} 
		return sql.toString();
	}
	
	/**
	 * @方法名称: getDataOrgAuth
	 * @方法描述: 获取当前登录用户机构数据授权
	 * @参数与返回说明:
	 * orgColumnName 机构列名称
	 * isCurPar 是否上辖
	 * @算法描述:
	 */
	public String getDataOrgAuth(String orgColumnName,boolean isCurPar) {
		String orgCode = getOrgCode(); //获取当前授权机构
		if("1".equals(isMgr())) {
			return processDataOrgAuth(orgColumnName,"CUR_ORG",orgCode);
		} else {
			if(isCurPar) {
				return processDataOrgAuth(orgColumnName,"CUR_PAR",orgCode);
			} else {
				return processDataOrgAuth(orgColumnName,"SUB_ORG",orgCode);
			}
		}
	}
	
	/**
	 * @方法名称: getOrgBranchGroup
	 * @方法描述: 获取机构(按分行层级)关系
	 * @参数与返回说明:
	 * @算法描述:
	 */
//	public List getOrgBranchGroup() {
//		Map<String, List<String>> relMap = new HashMap<String, List<String>>();
//		List allOrgList = adminSmOrgService.getAllOrgs();
//		for (Object object : allOrgList) {
//			Map<String, String> orgMap = (Map<String, String>) object;
//			String unitSeq = orgMap.get("unitseq");
//			String unitId = orgMap.get("unitid");
//			while (unitSeq.split(",").length > 2) {
//				unitSeq = unitSeq.substring(0, unitSeq.lastIndexOf(","));
//			}
//			List<String> unitList = relMap.get(unitSeq);
//			if (unitList == null) {
//				unitList = new ArrayList<String>();
//			}
//			unitList.add("'"+unitId+"'");
//			relMap.put(unitSeq, unitList);
//		}
//		List list = new ArrayList();
//		for (Object object : relMap.values()) {
//			list.add(object);
//		}
//		return list;
//	}

	/**
	 * @方法名称: getOrgBranchGroup
	 * @方法描述: 获取机构(按分行层级)关系
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getOrgBranchGroup() {
		Map<String, List<String>> relMap = new HashMap<String, List<String>>();
		List allOrgList = null; //adminSmOrgService.getAllOrgs();
		for (Object object : allOrgList) {
			Map<String, String> orgMap = (Map<String, String>) object;
			String unitSeq = orgMap.get("unitseq");
			String unitId = orgMap.get("unitid");
			while (unitSeq.split(",").length > 2) {
				unitSeq = unitSeq.substring(0, unitSeq.lastIndexOf(","));
			}
			List<String> unitList = relMap.get(unitSeq);
			if (unitList == null) {
				unitList = new ArrayList<String>();
			}
			unitList.add("'"+unitId+"'");
			relMap.put(unitSeq, unitList);
		}
		List list = new ArrayList();
		for (Object object : relMap.values()) {
			list.add(object);
		}
		return list;
	}
}
