package cn.com.yusys.yscrm.custmgrgroup.web.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custmgrgroup.domain.OcrmFcmMktTeam;
import cn.com.yusys.yscrm.custmgrgroup.domain.OcrmFcmTeamCustManager;
import cn.com.yusys.yscrm.custmgrgroup.service.OcrmFcmTeamCustManagerService;

/**
 * @项目名称: yscrm-entity-cust-mgr-group-core模块
 * @类名称: OcrmFcmTeamCustManagerResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-14 10:50:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcmteamcustmanager")
public class OcrmFcmTeamCustManagerResource extends CommonResource<OcrmFcmTeamCustManager, String> {
	
	private Logger logger = LoggerFactory.getLogger(OcrmFcmTeamCustManagerResource.class);
	
    @Autowired
    private OcrmFcmTeamCustManagerService ocrmFcmTeamCustManagerService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFcmTeamCustManagerService;
    }
    
    /**
 	 * @方法名称: queryList
 	 * @方法描述: 客户经理团队成员列表查询
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querylist/{mktTeamId}")
	public ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel,@PathVariable String mktTeamId) {
    	logger.debug("客户经理团队成员管理->查询团队列表->查询条件{},团队编号{}",queryModel.getCondition().toString(),mktTeamId);
    	queryModel.getCondition().put("mktTeamId", mktTeamId);
		List<Map<String, Object>> list = ocrmFcmTeamCustManagerService.queryList(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    
    /**
 	 * @方法名称: remove
 	 * @方法描述: 删除客户经理团队成员
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @PostMapping("/remove/{mgrId}")
    public ResultDto<Object> remove(@PathVariable String mgrId) {
    	logger.debug("客户经理团队管理->删除客户经理团队成员->客户经理团队成员ID->{}",mgrId);
    	int result = ocrmFcmTeamCustManagerService.remove(mgrId);
		return new ResultDto<Object>(result);
    }
    
    /**
 	 * @方法名称: save
 	 * @方法描述: 保存客户经理团队成员
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @PostMapping("/save")
    public ResultDto<Object> save(@RequestBody OcrmFcmTeamCustManager ocrmFcmTeamCustManager) {
    	logger.debug("客户经理团队管理->新增客户经理团队成员->成员信息{}",ocrmFcmTeamCustManager.toString());
    	int result = ocrmFcmTeamCustManagerService.save(ocrmFcmTeamCustManager);
		return new ResultDto<Object>(result);
    }
    
    /**
	 * @方法名称: check
	 * @方法描述: 新增成员前校验该客户经理团队是否已经存在该成员
	 * @参数与返回说明: mktTeamId 团队ID , mgrId 成员ID
	 * @算法描述:
	 */
	@GetMapping("/check")
	public ResultDto<List<Map<String, Object>>> check(@RequestParam(required = true) String mktTeamId,@RequestParam(required = true) String mgrId) {
		logger.debug("客户经理团队管理->新增客户经理团队成员前校验->客户经理团队ID{},成员编号{}", mktTeamId, mgrId);
		List<Map<String, Object>> result = ocrmFcmTeamCustManagerService.check(mktTeamId,mgrId);
		return new ResultDto<List<Map<String, Object>>>(result);
	}

}
