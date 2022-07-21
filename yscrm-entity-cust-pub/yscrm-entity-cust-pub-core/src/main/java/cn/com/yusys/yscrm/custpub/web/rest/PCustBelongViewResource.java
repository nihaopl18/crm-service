package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciCgMember;
import cn.com.yusys.yscrm.custpub.service.PCustBelongViewService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciCgMemberResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-12 19:54:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pcustbelongview")
public class PCustBelongViewResource extends CommonResource<OcrmFciCgMember, String> {
    @Autowired
    private PCustBelongViewService pCustBelongViewService;

    @Override
    protected CommonService getCommonService() {
        return this.pCustBelongViewService;
    }
    /**
	* @方法名称:querybelonggroup
	* @方法描述:查询当前客户的归属客户群
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/querybelonggroup/{custId}")
	public ResultDto<List<Map<String, Object>>> queryBelongGroup(@PathVariable String custId,QueryModel model) {
	        List<Map<String, Object>> list = pCustBelongViewService.queryBelongGroup(custId,model);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	* @方法名称:querybelongmgr
	* @方法描述:查询当前客户的机构、客户经理
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/querybelongmgr/{custId}")
	public ResultDto<List<Map<String, Object>>> queryBelongMgr(@PathVariable String custId,QueryModel model) {
	        List<Map<String, Object>> list = pCustBelongViewService.queryBelongMgr(custId,model);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	* @方法名称:qryBelongHis
	* @方法描述:查询调整历史
	* @参数与返回说明:
	* @算法描述:
	*/
	@GetMapping("/qrybelonghis/{custId}")
	public ResultDto<List<Map<String, Object>>> qryBelongHis(QueryModel model,@PathVariable String custId) {
	        List<Map<String, Object>> list = pCustBelongViewService.qryBelongHis(model,custId);
	        return new ResultDto<List<Map<String, Object>>>(list);
	}
}
