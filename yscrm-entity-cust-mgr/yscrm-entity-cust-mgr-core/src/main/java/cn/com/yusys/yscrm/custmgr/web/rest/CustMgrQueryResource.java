package cn.com.yusys.yscrm.custmgr.web.rest;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.RequestPath;
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
import cn.com.yusys.yscrm.custmgr.domain.AcrmFcmCustMgrInfo;
import cn.com.yusys.yscrm.custmgr.service.CustMgrQueryService;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: CustMgrQueryResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: luhy1@yusys.com.cn
 * @创建时间: 2019-01-28 17:33:00
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/custmgrquery")
public class CustMgrQueryResource extends CommonResource<AcrmFcmCustMgrInfo, String> {
	@Autowired
	private CustMgrQueryService custMgrQueryService;

	@Override
	protected CommonService getCommonService() {
		return custMgrQueryService;
	}

	/**
	 * @方法名称: queryList
	 * @方法描述: 客户经理列表查询
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/querylist")
	public ResultDto<List<Map<String, Object>>> queryList(QueryModel queryModel) {
		List<Map<String, Object>> list = custMgrQueryService.queryCustMgrList(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	/**
	 * @方法名称: checkCustMgrApply
	 * @方法描述: 退出申请之前查询该客户经理是否正在办理退出客户经理业务
	 * @参数与返回说明:
	 * @算法描述:
	 */
	@GetMapping("/checkcustmgrapply")
	public ResultDto<List<Map<String, Object>>> checkCustMgrApply(@RequestParam(required = true) String mgrId) {
		List<Map<String, Object>> result = custMgrQueryService.checkCustMgrApply(mgrId);
		return new ResultDto<List<Map<String, Object>>>(result);
	}

	/**
 	 * @方法名称: quitCustMgrApply
 	 * @方法描述: 退出客户经理-申请
 	 * @参数与返回说明:
 	 * mgrId 客户经理编号
 	 * reason 退出理由
 	 * @算法描述:
 	 */
    @PostMapping("/quitcustmgrapply")
	public ResultDto<Object> quitCustMgrApply(@RequestBody Map<String,Object> params) {
    	String mgrId = String.valueOf(params.get("userCode"));
    	String reason = String.valueOf(params.get("reason"));
		String result = custMgrQueryService.quitCustMgrApply(mgrId, reason);
		return new ResultDto<Object>(result);
	}

}
