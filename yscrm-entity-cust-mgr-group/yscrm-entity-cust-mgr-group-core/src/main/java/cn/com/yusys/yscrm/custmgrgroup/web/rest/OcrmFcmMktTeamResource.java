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
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custmgrgroup.domain.OcrmFcmMktTeam;
import cn.com.yusys.yscrm.custmgrgroup.service.OcrmFcmMktTeamService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-entity-cust-mgr-group-core模块
 * @类名称: OcrmFcmMktTeamResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-13 09:58:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcmmktteam")
public class OcrmFcmMktTeamResource extends CommonResource<OcrmFcmMktTeam, String> {
	
	private Logger logger = LoggerFactory.getLogger(OcrmFcmMktTeamResource.class);
	
    @Autowired
    private OcrmFcmMktTeamService ocrmFcmMktTeamService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFcmMktTeamService;
    }
    /**
 	 * @方法名称: queryList
 	 * @方法描述: 客户经理团队列表查询
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
		List<Map<String, Object>> list = ocrmFcmMktTeamService.queryList(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
    
    /**
 	 * @方法名称: save
 	 * @方法描述: 保存或更新客户经理团队
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @PostMapping("/saveorupdate")
    public ResultDto<Object> saveOrUpdate(@RequestBody OcrmFcmMktTeam ocrmFcmMktTeam) {
    	int result = ocrmFcmMktTeamService.saveOrUpdate(ocrmFcmMktTeam);
		return new ResultDto<Object>(result);
    }
    
    /**
 	 * @方法名称: remove
 	 * @方法描述: 删除客户经理团队
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @PostMapping("/remove/{mktTeamId}")
    public ResultDto<Object> remove(@PathVariable String mktTeamId) {
    	logger.debug("客户经理团队管理->删除客户经理团队->客户经理团队ID->{}",mktTeamId);
    	int result = ocrmFcmMktTeamService.remove(mktTeamId);
		return new ResultDto<Object>(result);
    }
    
    /**
     * @方法名称: queryInfo
 	 * @方法描述: 根据客户经理团队编号获取客户经理团队表单信息
 	 * @参数与返回说明: mktTeamId 客户经理团队ID
 	 * @算法描述:
 	 */
    @GetMapping("/queryinfo/{mktTeamId}")
	public ResultDto<List<Map<String, Object>>> queryInfo(@PathVariable String mktTeamId) {
    	logger.debug("客户经理团队管理->查询客户经理表单信息->客户经理团队ID->{}",mktTeamId);
    	List<Map<String, Object>> list = ocrmFcmMktTeamService.queryInfo(mktTeamId);
		return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
 	 * @方法名称: queryCustList
 	 * @方法描述: 查询客户经理团队客户信息列表
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/querycustlist/{mktTeamId}")
	public ResultDto<List<Map<String, Object>>> queryCustList(QueryModel queryModel,@PathVariable String mktTeamId) {
    	logger.debug("客户经理团队管理->查询团队客户信息列表->查询条件{},团队编号{}",queryModel.getCondition().toString(),mktTeamId);
    	queryModel.getCondition().put("mktTeamId", mktTeamId);
		List<Map<String, Object>> list = ocrmFcmMktTeamService.queryCustList(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

}
