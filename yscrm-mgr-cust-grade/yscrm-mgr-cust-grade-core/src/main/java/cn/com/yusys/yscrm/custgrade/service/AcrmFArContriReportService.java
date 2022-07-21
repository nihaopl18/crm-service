package cn.com.yusys.yscrm.custgrade.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custgrade.repository.mapper.AcrmFArContriReportMapper;
import cn.com.yusys.yscrm.custgrade.util.UtilsCommon;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * 
 * @项目名称: crm-service
 * @类名称: AcrmFArContriReportService
 * @类描述:
 * @功能描述: 客户贡献度查询
 * @创建人: zhangcl3@yusys.com.cn
 * @创建时间: 2019年02月11日
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFArContriReportService extends CommonService {
	@Autowired
	private AcrmFArContriReportMapper mapper;
	private final Logger logger = LoggerFactory.getLogger(AcrmFArContriReportService.class);

//	@Autowired
//	private UaaClient uaaClient;

	@Autowired 
	private UtilsCommon util;
	@Override
	protected CommonMapper getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}

//	/**
//	 * @方法名称: queryUserBusiType
//	 * @方法描述: 查询当前登录用户所属条线
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	@Transactional(readOnly = true)
//	public String queryUserBusiType() {
//		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
//		String userCode = dto.getBody().getLoginCode();
//		String busiTypeAuth = "";
//		String busiType = this.mapper.queryUserBusiType(userCode);
//		if (busiType != null) {
//			busiTypeAuth += " AND T.CUST_ID IN ( SELECT ATTR.CUST_ID FROM ACRM_F_CI_CUST_ADMIT_ALL ATTR WHERE ";
//			String arr[] = busiType.split(",");
//			for (String a : arr) {
//				busiTypeAuth = busiTypeAuth + " ATTR.BUSI_TYPE LIKE '%" + a + "%' OR ";
//			}
//			if (busiTypeAuth.contains("OR")) {
//				busiTypeAuth = busiTypeAuth.substring(0, busiTypeAuth.lastIndexOf("OR"));
//			}
//			busiTypeAuth = busiTypeAuth + ") ";
//			logger.debug("当前用户{},业务条线{},业务条线授权{}", userCode, busiType, busiTypeAuth);
//		} else {
//			busiTypeAuth = " and 1=2 ";// 当前登录人无业务条线
//			logger.info("当前用户{},业务条线为空{},业务条线授权{}", userCode, busiType, busiTypeAuth);
//		}
//
//		return busiTypeAuth;
//	}
//
//	/**
//	 * @方法名称: queryUserCust
//	 * @方法描述: 查询当前登录用户所辖客户
//	 * @参数与返回说明:
//	 * @算法描述:
//	 */
//	public String queryUserCust() {
//		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
//		String userCode = dto.getBody().getLoginCode();
//		String userCust = "";
//		/**
//		 * 管户
//		 */
//		userCust += " AND T.CUST_ID IN ( ";
//		userCust += " SELECT L.CUST_ID FROM OCRM_F_CI_ADMIT_BELONG L  WHERE L.MGR_ID ='" + userCode + "'";
//		userCust += " UNION ALL ";
//		/**
//		 * 托管户
//		 */
//		userCust += " SELECT L.CUST_ID  FROM OCRM_F_CI_TRUSTEESHIP_APPLY A               "
//				+ " LEFT JOIN OCRM_F_CI_TRUSTEESHIP_LIST L ON A.APPLY_ID = L.APPLY_NO  "
//				+ " WHERE TRUST_STAT = '1'    AND TRUST_MGR_ID = '" + userCode + "'";
//		userCust += " UNION ALL ";
//		/**
//		 * 授权户
//		 */
//		userCust += " SELECT L.CUST_ID  FROM OCRM_F_CI_GRANT_APPLY A              "
//				+ " LEFT JOIN OCRM_F_CI_GRANT_LIST L ON A.APPLY_ID = L.APPLY_NO "
//				+ " WHERE GRANT_STAT = '1'  AND GRANT_MGR_ID =  '" + userCode + "'";
//		userCust += " ) ";
//		logger.info("当前用户{},数据授权{}", userCode, userCust);
//		return userCust;
//	}
//
//	/**
//	 * 查询当前用户下辖客户
//	 */
//
//	public String queryUserOrg() {
//		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
//		String orgCode = dto.getBody().getOrg().getCode();
//		String orgCust = "";
//		orgCust += " AND T.CUST_ID IN (";
//		orgCust += " SELECT B.CUST_ID FROM OCRM_F_CI_ADMIT_BELONG B "
//		          + "WHERE B.ORG_ID IN (SELECT ORG_CODE FROM SYS_ORG_VIEW WHERE  SYS_ORG_VIEW.ORG_SEQ like '%' || '"+orgCode+"' || ',%')";
//		orgCust += " ) ";
//		logger.info("当前机构{},数据授权{}", orgCode, orgCust);
//		return orgCust;
//	}
//     /**
//      * 混合权限查询
//      */
//	public String  queryALL() {
//		String userAllcust="";
//		userAllcust+=" AND ( ";
//		//获取管理者 下辖 且 条线客户 
//		String UserOrg=queryUserOrg();
//		userAllcust= userAllcust+ " ( " +UserOrg.substring(4,UserOrg.length()) + queryUserBusiType()+" ) ";
//		userAllcust += " OR ";
//		// 获取 客户经理的所辖客户
//		String UserCust=queryUserCust();
//		userAllcust += UserCust.substring(4, UserCust.length());
//		userAllcust += " ) ";
//		logger.info("混合授权{}", userAllcust);
//		return userAllcust;
//	}

	
	/**
	 * 查询分组
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getAll(QueryModel model) {
		model =util.dealRole(model);
		if(!"1".equals(model.getCondition().get("sign"))){
			PageHelper.startPage(model.getPage(), model.getSize());
		}
		String busiType = (String) model.getCondition().get("busiType");
		String custType = (String) model.getCondition().get("custType");
		List<Map<String, Object>> list = null;
		if (custType.equals("")) {
			return list;
		}
		if (busiType.equals("6")) {
			list = this.mapper.querylistAllBusi(model);
		}else {
			list = this.mapper.querylist(model);
		}
		PageHelper.clearPage();
		return list;
	}

	
//	/**
//	 * 权限处理
//	 */
//	public QueryModel dealRole(QueryModel model) {
//		
//		String mgrType=" AND  MGR_TYPE='1' ";
//		if (isRole().equals("KHJL")) {
//			/*
//			 * 客户经理角色处理, 只取 当前人 所管辖客户 包含授权 ，管户， 托管
//			 */	
//			//model.getCondition().put("mgrType",mgrType);
//			model.getCondition().put("dataAuth", queryUserCust());
//
//		} else if (isRole().equals("GLZ")) {
//			/*
//			 * 管理者角色处理 只取 当前人下辖 机构，及所在业务条线
//			 */
//			model.getCondition().put("mgrTypeFlag",mgrType);
//			model.getCondition().put("busiTypeAuth", queryUserBusiType());
//			model.getCondition().put("dataAuth", queryUserOrg());
//		} else {
//			/*
//			 * 混合角色处理 取当前人 所管辖客户 包含授权 ，管户， 托管 和 当当前人下辖机构，及所在业务条线
//			 */
//			model.getCondition().put("mgrTypeFlag",mgrType);
//			model.getCondition().put("busiTypeAuth", queryALL());
//
//		}
//		return model;
//	}
//	
//	
//	/**
//	 * 判断当前登录人 仅是 客户经理 ，仅是管理者 ，或者两者皆是
//	 */
//
//	public String isRole() {
//		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
//		List<ObjBean> roleList = dto.getBody().getRoles();
//		/**
//		 * 当前登录人有且只有 一个角色 为客户经理
//		 */
//		if (roleList.size() == 1 && roleList.get(0).getCode().equals("15")) {
//			logger.debug("当前登录人为单角色,角色为{}{}",roleList.get(0).getCode(),roleList.get(0).getName());
//			return "KHJL";
//		}
//		for (ObjBean obj : roleList) {
//			/**
//			 * 当前角色 有两个以上 其中混入 客户经理角色 则为混合角色。
//			 */
//			if ("15".equals(obj.getCode())) {
//				logger.debug("当前登录人为混合角色,角色为{}",roleList);
//				return "ALL";
//			}
//		}
//		/**
//		 * 当前角色 有两个以上 但没有 客户经理角色 为 管理者角色
//		 */
//		logger.debug("当前登录人为管理角色,角色为{}",roleList);
//		return "GLZ";
//	}
}
