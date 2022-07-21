package cn.com.yusys.yscrm.custmgr.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custmgr.domain.AcrmFcmCustmgrPerf;
import cn.com.yusys.yscrm.custmgr.service.CustMgrBelonginfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;


/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: CustMgrBelonginfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-22 17:25:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/custmgrbelonginfo")
public class CustMgrBelonginfoResource extends CommonResource<AcrmFcmCustmgrPerf, String> {
    @Autowired
    private CustMgrBelonginfoService custMgrBelonginfoService;

    @Override
    protected CommonService getCommonService() {
        return custMgrBelonginfoService;
    }
    
    /**
	 * 客户经理视图-管户清单列表查询
	 * 
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/querylist/{mgrId}")
	public ResultDto<List<Map<String, Object>>> querylist(QueryModel queryModel,@PathVariable String mgrId) {
		List<Map<String, Object>> list = custMgrBelonginfoService.querylist(queryModel,mgrId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

}