package cn.com.yusys.yscrm.product.web.rest;

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
import cn.com.yusys.yscrm.product.domain.OcrmFpdCustFitProd;
import cn.com.yusys.yscrm.product.service.OcrmFpdCustFitProdService;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdCustFitProdResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 15:25:03
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdcustfitprod")
public class OcrmFpdCustFitProdResource extends CommonResource<OcrmFpdCustFitProd, String> {
	@Autowired
	private OcrmFpdCustFitProdService ocrmFpdCustFitProdService;

	@Override
	protected CommonService getCommonService() {
		return ocrmFpdCustFitProdService;
	}

	/**
	 * @方法名称: targetCustomersQuery
	 * @方法描述: 目标客户查询
	 * @param
	 * @return
	 */
	@GetMapping("/targetcustomersquery")
	public ResultDto<List<Map<String, Object>>> targetCustomersQuery(QueryModel model) {
		List<Map<String, Object>> focusCust = ocrmFpdCustFitProdService.targetCustomersQuery(model);
		if (focusCust.size() > 0) {
			return new ResultDto<List<Map<String, Object>>>(focusCust);
		} else {
			return null;
		}
	}
	
	@GetMapping("/queryProd")
	public  ResultDto<List<Map<String, Object>>> queryProd(QueryModel model) {
		List<Map<String, Object>> list = ocrmFpdCustFitProdService.queryProd(model);
		return new ResultDto<List<Map<String, Object>>>(list);
	}

}
