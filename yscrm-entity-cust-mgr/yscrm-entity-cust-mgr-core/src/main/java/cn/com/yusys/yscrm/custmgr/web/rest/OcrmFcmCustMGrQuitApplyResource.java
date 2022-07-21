package cn.com.yusys.yscrm.custmgr.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custmgr.domain.AcrmFcmCustMgrInfo;
import cn.com.yusys.yscrm.custmgr.service.OcrmFcmCustMgrQuitApplyService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;


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
@RequestMapping("/api/ocrmfcmcustmgrquitapply")
public class OcrmFcmCustMGrQuitApplyResource extends CommonResource<AcrmFcmCustMgrInfo, String> {
	
	@Autowired
	private OcrmFcmCustMgrQuitApplyService ocrmFcmCustMgrQuitApplyService;
	
	@Override
	protected CommonService getCommonService() {
		return ocrmFcmCustMgrQuitApplyService;
	}

	/**
 	 * @方法名称: queryQuitCustMgrApply
 	 * @方法描述: 查询退出客户经理信息
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */	
    @GetMapping("/queryquitcustmgrapply/{id}")
	public ResultDto<List<Map<String, Object>>> queryQuitCustMgrApply(@PathVariable String id) {
		List<Map<String, Object>> list = ocrmFcmCustMgrQuitApplyService.queryQuitCustMgrApply(id);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

	
}
