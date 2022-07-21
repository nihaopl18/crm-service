package cn.com.yusys.yscrm.custmgr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yscrm.custmgr.domain.OcrmFcmCustMgrQuitApply;
import cn.com.yusys.yscrm.custmgr.repository.mapper.CustMgrQueryMapper;
import cn.com.yusys.yscrm.custmgr.repository.mapper.OcrmFcmCustMgrQuitApplyMapper;
/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: CustMgrQueryService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: luhy1@yusys.com.cn
 * @创建时间: 2019-01-28 17:33:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CustMgrQueryService extends CommonService {
	
	private Logger logger = LoggerFactory.getLogger(CustMgrQueryService.class);
	
	@Autowired
   	private UaaClient uaaClient;
	
    @Autowired
    private CustMgrQueryMapper custMgrQueryMapper;
    
    @Autowired
    private OcrmFcmCustMgrQuitApplyMapper ocrmFcmCustMgrQuitApplyMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return custMgrQueryMapper;
    }
    
    /**
 	 * @方法名称: queryUserBusiType
 	 * @方法描述: 查询当前登录用户所属条线
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @Transactional(readOnly = true)
    public String queryUserBusiType() {
    	ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	String userCode = dto.getBody().getLoginCode();
    	String busiType = this.custMgrQueryMapper.queryUserBusiType(userCode);
    	String busiTypeAuth="";
    	if(busiType!=null) {
    		busiTypeAuth = busiTypeAuth+" AND (";
    		String arr[] = busiType.split(",");
    		for(String a : arr) {
    			busiTypeAuth = busiTypeAuth + " ATTR.BUSI_TYPE LIKE '%"+a+"%' OR ";
    		}
    		if(busiTypeAuth.contains("OR")) {
    			busiTypeAuth = busiTypeAuth.substring(0, busiTypeAuth.lastIndexOf("OR"));
    		}
    		busiTypeAuth = busiTypeAuth+ ") ";
    	}else{
    		busiTypeAuth = busiTypeAuth+"AND (1=1) ";
    	}
    	logger.debug("当前用户{},业务条线{},业务条线授权{}",userCode,busiType,busiTypeAuth);
    	return busiTypeAuth;
    }
    
    /**
 	 * @方法名称: queryCustMgrList
 	 * @方法描述: 客户经理列表查询
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryCustMgrList(QueryModel queryModel) {
    	ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	List<ObjBean> roleList = dto.getBody().getRoles();
    	String loginCode=dto.getBody().getLoginCode();
    	String orgId=dto.getBody().getOrg().getCode();
    	Object viewOrgId=queryModel.getCondition().get("orgId");
    	if(viewOrgId!=null&&viewOrgId!="") {
//    		String orgIds=queryOrgId((String) viewOrgId);
//    		queryModel.getCondition().put("orgId", orgIds);
    		queryModel.getCondition().put("orgIds", " AND USR.ORG_ID IN ("+queryOrgId(viewOrgId+"")+")");
    	}
    	boolean isCustMgr = false;
    	for(ObjBean obj : roleList) {
    		if("15".equals(obj.getCode())&&roleList.size()==1) {
    			isCustMgr = true;
    		}
    	}
    	//如果不是客户经理，加入业务条线过滤条件
    	if(!isCustMgr) {
    		//加入业务条线授权
    		if(!"500".equals(orgId)) {
    			queryModel.getCondition().put("uncertain", " AND USR.ORG_ID IN ("+queryOrgId(orgId)+")");
    		}
    	}else {
    		String str=" AND MGR.CUST_MANAGER_ID="+"'"+loginCode+"'";
    		queryModel.getCondition().put("uncertain", str);
    	}
    	PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
    	PageHelper.orderBy(queryModel.getSort());
		List<Map<String, Object>> list = custMgrQueryMapper.queryCustMgrList(queryModel);
		System.out.println(list);
		PageHelper.clearPage();
		return list;
    }
    
    
    /**
     * 查询当前机构号下的下辖机构号
     */
    @Transactional(readOnly = true)
    public String queryOrgId(String orgId) {
    	List<Map<String,String>> list=custMgrQueryMapper.queryOrgId(orgId);
    	StringBuilder sb=new StringBuilder();
    	for (Map<String,String> map : list) {
    		sb.append("'"+map.get("orgId")+"'"+",");
		}
    	String id=sb.toString();
    	id=id.substring(0,id.lastIndexOf(","));
    	return id;
    }
    /**
	 * @方法名称: checkCustMgrApply
	 * @方法描述: 退出申请之前查询该客户经理是否正在办理退出客户经理业务
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String,Object>> checkCustMgrApply(String mgrId){
		return custMgrQueryMapper.checkCustMgrApply(mgrId);
	}
    
    /**
 	 * @方法名称: quitCustMgrApply
 	 * @方法描述: 退出客户经理-申请
 	 * @参数与返回说明:
 	 * mgrId 客户经理编号
 	 * reason 退出理由
 	 * @算法描述:
 	 */
	public String quitCustMgrApply(String custManagerId,String quitReason) {
		OcrmFcmCustMgrQuitApply apply = new OcrmFcmCustMgrQuitApply();
		apply.setId(java.util.UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		apply.setQuitReason(quitReason);
		apply.setCustManagerId(custManagerId);
		this.ocrmFcmCustMgrQuitApplyMapper.insertCustMgrQuitApply(apply);
		return apply.getId();
	}

}
