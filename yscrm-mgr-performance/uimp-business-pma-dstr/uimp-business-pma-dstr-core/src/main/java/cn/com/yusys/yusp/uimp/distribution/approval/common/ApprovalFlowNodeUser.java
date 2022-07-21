package cn.com.yusys.yusp.uimp.distribution.approval.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecc.echain.ext.NodeUserListExtIF;
import com.ecc.echain.workflow.engine.EVO;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: ApprovalFlowNodeUser
 * @类描述: # 业绩审批流 获取节点人员列表（同机构）
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-01-07 09:45:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public class ApprovalFlowNodeUser implements NodeUserListExtIF {
	
	private static final Logger log = LoggerFactory.getLogger(ApprovalFlowNodeUser.class);
	
	// TODO 注入 mapper

	@Override
	public List getNodeUserList(EVO evo) throws Exception {
		log.debug("start get nodeUserList, instanceId is " + evo.getInstanceID());
		List<String> list = new ArrayList<String>();
		Map paramMap = evo.paramMap;
		String loginCode = evo.getCurrentNodeUser();
		Vector vecData, vecRow;
		String SQL = "";
		if (paramMap.containsKey("org")) {
			String orgId = paramMap.get("org").toString();
			SQL = " select u.LOGIN_CODE, u.ORG_ID " + 
					" from ADMIN_SM_USER u " + 
					" inner join ADMIN_SM_USER_ROLE_REL url on u.USER_ID = url.USER_ID " + 
					" inner join ADMIN_SM_ROLE r on url.ROLE_ID = r.ROLE_ID " + 
					" where r.ORG_ID = '" + orgId + "' or u.ORG_ID = '" + orgId + "' ";
			if ("custDstr".equals(paramMap.get("funCode"))) {	// 客户分配 单独处理
				if(loginCode.indexOf(";")>0){
					String[] strArr = loginCode.split(";");
					loginCode=strArr[0];
				}
				SQL = " select u.LOGIN_CODE, u.ORG_ID " + 
						" from ADMIN_SM_USER u " + 
						" inner join ADMIN_SM_USER_ROLE_REL url on u.USER_ID = url.USER_ID " + 
						" inner join ADMIN_SM_ROLE r on url.ROLE_ID = r.ROLE_ID " + 
						" where EXISTS ( " + 
						"	select 1 from ADMIN_SM_USER temp_u " + 
						"		where temp_u.LOGIN_CODE = '" + loginCode + "' and " + 
						"		   (temp_u.ORG_ID = r.ORG_ID or temp_u.ORG_ID = u.ORG_ID)" + 
						" )";
			}
			// TODO 执行SQL 获取每个LOGIN_CODE
		} else {
			throw new RuntimeException("配置项中没有将机构配置成为审批条件");
		}
		return list;
	}

}
