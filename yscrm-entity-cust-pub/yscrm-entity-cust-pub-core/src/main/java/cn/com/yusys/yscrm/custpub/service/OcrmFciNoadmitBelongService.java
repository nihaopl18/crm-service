package cn.com.yusys.yscrm.custpub.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciAdmitBelong;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciNoadmitBelong;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciNoadmitBelongMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciNoadmitBelongService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-28 09:57:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciNoadmitBelongService extends CommonService {
    @Autowired
    private OcrmFciNoadmitBelongMapper ocrmFciNoadmitBelongMapper;
    @Autowired
	private UaaClient uaaClient;
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciNoadmitBelongMapper;
    }

    public int updateHost(String custId, String mgrId, String orgId) {
		Map<String, String> map = new HashMap<>();
		map.put("custId", custId);
		map.put("mgrId", mgrId);
		map.put("orgId", orgId);
		return ocrmFciNoadmitBelongMapper.updateHost(map);
		
	}
    public UserInfoDTO getUser() {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		return dto.getBody();
	}
	public int  delBelongByCustIdMgrIdOrgId(String custId, String mgrId, String orgId) {
		// TODO 自动生成的方法存根
		Map<String, String> map = new HashMap<>();
		map.put("custId", custId);
		map.put("mgrId", mgrId);
		map.put("orgId", orgId);
		return ocrmFciNoadmitBelongMapper.delBelongByCustIdMgrIdOrgId(map);
	}
	public int claimAdd(Map<String, String> belong) {
		OcrmFciNoadmitBelong ocrmFciNoadmitBelong = new OcrmFciNoadmitBelong();
		Date date=new Date();
		UserInfoDTO user = getUser();
		ocrmFciNoadmitBelong.setBelongId(UtilTools.getUUID());
		ocrmFciNoadmitBelong.setCorpOrgCode("001");
		ocrmFciNoadmitBelong.setCustId(belong.get("custId"));
		ocrmFciNoadmitBelong.setLastUpdateOrg(user.getOrg().getId());
		ocrmFciNoadmitBelong.setLastUpdateTm(date);
		ocrmFciNoadmitBelong.setMgrId(belong.get("mgrId"));
		ocrmFciNoadmitBelong.setLastUpdateUser(user.getUserId());
		ocrmFciNoadmitBelong.setMgrName(belong.get("mgrName"));
		ocrmFciNoadmitBelong.setMgrType(belong.get("mgrType"));
		ocrmFciNoadmitBelong.setOrgId(belong.get("orgId"));
		ocrmFciNoadmitBelong.setOrgName(belong.get("orgName"));
		ocrmFciNoadmitBelong.setOrgType(belong.get("orgType"));
		ocrmFciNoadmitBelong.setIsAdmitEnter("0");
		return insertSelective(getMapper(), ocrmFciNoadmitBelong);
		
	}

	public int add(Object noadmitrecord) {
		// TODO 自动生成的方法存根
		return insertSelective(getMapper(), noadmitrecord);
	}

	/**
	* @方法名称:qryOrgId
	* @方法描述:查询当前客户的机构、客户经理（主办）
	* @参数与返回说明:
	* @算法描述:
	*/
	@Transactional(readOnly = true)
	public List<Map<String, Object>> qryOrgId(String custId) {
		List<Map<String, Object>> list =  this.ocrmFciNoadmitBelongMapper.qryOrgId(custId);
		return list;
	}
	
	/**
	* @方法名称:qryMgrId
	* @方法描述: 查询当前客户的机构、客户经理（协办）
	* @参数与返回说明:
	* @算法描述:
	*/
	@Transactional(readOnly = true)
	public List<Map<String, Object>> qryMgrId(String custId) {
		List<Map<String, Object>> list =  this.ocrmFciNoadmitBelongMapper.qryMgrId(custId);
		return list;
	}

}
