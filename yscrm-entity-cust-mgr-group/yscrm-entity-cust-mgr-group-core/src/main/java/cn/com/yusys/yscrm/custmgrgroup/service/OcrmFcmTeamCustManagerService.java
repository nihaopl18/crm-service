package cn.com.yusys.yscrm.custmgrgroup.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custmgrgroup.domain.OcrmFcmTeamCustManager;
import cn.com.yusys.yscrm.custmgrgroup.repository.mapper.OcrmFcmTeamCustManagerMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-entity-cust-mgr-group-core模块
 * @类名称: OcrmFcmTeamCustManagerService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-14 10:50:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFcmTeamCustManagerService extends CommonService {
	
	@Autowired
   	private UaaClient uaaClient;
	
    @Autowired
    private OcrmFcmTeamCustManagerMapper ocrmFcmTeamCustManagerMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFcmTeamCustManagerMapper;
    }
    
    /**
 	 * @方法名称: queryList
 	 * @方法描述: 客户经理团队成员列表查询
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryList(QueryModel queryModel) {
    	PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = ocrmFcmTeamCustManagerMapper.queryList(queryModel);
		PageHelper.clearPage();
		return list;
    }
    
    /**
     * @方法名称: remove
 	 * @方法描述: 删除客户经理团队成员
 	 * @参数与返回说明: mgrId 客户经理团队成员ID
 	 * @算法描述:
 	 */
    public int remove(String mgrId) {
    	return this.ocrmFcmTeamCustManagerMapper.deleteByPrimaryKey(mgrId);
    }

    
    /**
     * @方法名称: save
 	 * @方法描述: 保存或更新客户经理团队成员
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    public int save(OcrmFcmTeamCustManager ocrmFcmTeamCustManager) {
    	ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	ocrmFcmTeamCustManager.setCreateUserId(dto.getBody().getLoginCode());
    	ocrmFcmTeamCustManager.setCreateUserName(dto.getBody().getUserName());
    	ocrmFcmTeamCustManager.setCreateUserOrgId(dto.getBody().getOrg().getCode());
    	ocrmFcmTeamCustManager.setCustManagerOrg(dto.getBody().getOrg().getName());
    	ocrmFcmTeamCustManager.setCorpOrgCode(dto.getBody().getInstu().getCode());
    	ocrmFcmTeamCustManager.setUserId(dto.getBody().getLoginCode());
    	ocrmFcmTeamCustManager.setJoinDate(new Date());
    	return this.ocrmFcmTeamCustManagerMapper.insertSelective(ocrmFcmTeamCustManager);
    }
    
    /**
	 * @方法名称: check
	 * @方法描述: 新增成员前校验该客户经理团队是否已经存在该成员
	 * @参数与返回说明: mktTeamId 团队ID , mgrId 成员ID
	 * @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String,Object>> check(String mktTeamId,String mgrId){
		return ocrmFcmTeamCustManagerMapper.check(mktTeamId,mgrId);
	}
	
}
