package cn.com.yusys.yscrm.custmgrgroup.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custmgrgroup.domain.OcrmFcmMktTeam;
import cn.com.yusys.yscrm.custmgrgroup.repository.mapper.OcrmFcmMktTeamMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * @项目名称: yscrm-entity-cust-mgr-group-core模块
 * @类名称: OcrmFcmMktTeamService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-13 09:58:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFcmMktTeamService extends CommonService {
    @Autowired
    private OcrmFcmMktTeamMapper ocrmFcmMktTeamMapper;
    
    @Autowired
   	private UaaClient uaaClient;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFcmMktTeamMapper;
    }
    
    /**
 	 * @方法名称: queryList
 	 * @方法描述: 客户经理团队列表查询
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryList(QueryModel queryModel) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		queryModel.getCondition().put("_orgCode", user.getOrg().getCode());
		queryModel.getCondition().put("_userCode",user.getLoginCode());
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = ocrmFcmMktTeamMapper.queryList(queryModel);
		PageHelper.clearPage();
		return list;
    }
    
    /**
     * @方法名称: saveOrUpdate
 	 * @方法描述: 保存或更新客户经理团队
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    public int saveOrUpdate(OcrmFcmMktTeam ocrmFcmMktTeam) {
    	ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
    	if(ocrmFcmMktTeam.getMktTeamId()==null || "".equals(ocrmFcmMktTeam.getMktTeamId())) {
    		String mktTeamId=ocrmFcmMktTeamMapper.selectMaxmktTeamId();
    		String mktteam=String.valueOf(Integer.parseInt(mktTeamId.substring(1))+1);
    		String sub="";
    		if(mktteam.length()<5){
    			if(mktteam.length()==1){
					sub="000";
				}else if(mktteam.length()==2){
					sub="00";
				}else if(mktteam.length()==3){
					sub="0";
				}else if(mktteam.length()==4){
					sub="";
				}
			}
			ocrmFcmMktTeam.setMktTeamId(mktTeamId.substring(0,1)+sub+mktteam);
    		ocrmFcmMktTeam.setCreateUserId(dto.getBody().getLoginCode());
        	ocrmFcmMktTeam.setCreateUserName(dto.getBody().getUserName());
        	ocrmFcmMktTeam.setCreateUserOrgId(dto.getBody().getOrg().getCode());
        	ocrmFcmMktTeam.setCorpOrgCode(dto.getBody().getInstu().getCode());
        	ocrmFcmMktTeam.setCreateDate(new Date());
    		return this.ocrmFcmMktTeamMapper.insertSelective(ocrmFcmMktTeam);
    	} else {
    		ocrmFcmMktTeam.setUpdateUserId(dto.getBody().getLoginCode());
    		ocrmFcmMktTeam.setUpdateUserName(dto.getBody().getUserName());
    		ocrmFcmMktTeam.setLastChgDt(new Date());
    		return this.ocrmFcmMktTeamMapper.updateByPrimaryKeySelective(ocrmFcmMktTeam);
    	}
    }
    
    /**
     * @方法名称: remove
 	 * @方法描述: 删除客户经理团队
 	 * @参数与返回说明: teamId 客户经理团队ID
 	 * @算法描述:
 	 */
    public int remove(String teamId) {
    	return this.ocrmFcmMktTeamMapper.deleteByPrimaryKey(teamId);
    }
    
    /**
     * @方法名称: queryInfo
 	 * @方法描述: 根据客户经理团队编号获取客户经理团队表单信息
 	 * @参数与返回说明: mktTeamId 客户经理团队ID
 	 * @算法描述:
 	 */
    public List<Map<String, Object>> queryInfo(String mktTeamId) {
		List<Map<String, Object>> list = ocrmFcmMktTeamMapper.queryInfo(mktTeamId);
		return list;
	}
    
    /**
 	 * @方法名称: queryCustList
 	 * @方法描述: 查询客户经理团队客户信息列表
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryCustList(QueryModel queryModel) {
    	PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = ocrmFcmMktTeamMapper.queryCustList(queryModel);
		PageHelper.clearPage();
		return list;
    }

}
