package cn.com.yusys.yscrm.cust.org.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.org.domain.OcrmFciOrgOthbankInfo;
import cn.com.yusys.yscrm.cust.org.service.OcrmFCiOrgOthbankInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciOrgBondInfoResource
 * @类描述: #资源类
 * @功能描述: 债券信息
 * @创建人: 15104
 * @创建时间: 2019-02-17 00:56:36
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfciorgothbankinfo")
public class OcrmFCiOrgOthbankInfoResource extends CommonResource<OcrmFciOrgOthbankInfo, String> {
	@Autowired
	private OcrmFCiOrgOthbankInfoService ocrmFCiOrgOthbankInfoService;

	@Override
	protected CommonService getCommonService() {
		return ocrmFCiOrgOthbankInfoService;
	}

	// 家庭收支信息查询
	@GetMapping("/getorgotherbank/{custId}")
	public ResultDto<List<Map<Object, String>>> getFamilyincList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(ocrmFCiOrgOthbankInfoService.getOrgOtherBank(custId));
	}

	// 家庭收支信息新增修改方法
	@PostMapping("/updateotherbank/{custId}")
	public ResultDto<Integer> updateOtherBank(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("depmodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(ocrmFCiOrgOthbankInfoService.updateOtherBank(map));
	}

	// 家庭收支信息删除方法
	@PostMapping("/delotherbank")
	public ResultDto<Integer> delOtherBank(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(ocrmFCiOrgOthbankInfoService.delOtherBank(id));
	}

}
