package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciNoadmitBelong;
import cn.com.yusys.yscrm.custpub.service.OcrmFciNoadmitBelongService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciNoadmitBelongResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-28 19:23:47
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcinoadmitbelong")
public class OcrmFciNoadmitBelongResource extends CommonResource<OcrmFciNoadmitBelong, String> {
    @Autowired
    private OcrmFciNoadmitBelongService ocrmFciNoadmitBelongService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciNoadmitBelongService;
    }
    /**
	* @方法名称:qryOrgId
	* @方法描述:查询当前客户的机构、客户经理（主办）
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/qryorgid")
	public ResultDto<List<Map<String, Object>>> qryOrgId(@RequestParam(required = false) String custId) {
	        List<Map<String, Object>> list = ocrmFciNoadmitBelongService.qryOrgId(custId);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	/**
	* @方法名称:qryMgrId
	* @方法描述: 查询当前客户的机构、客户经理（协办）
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/qrymgrid")
	public ResultDto<List<Map<String, Object>>> qryMgrId(@RequestParam(required = false) String custId) {
	        List<Map<String, Object>> list = ocrmFciNoadmitBelongService.qryMgrId(custId);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
}
