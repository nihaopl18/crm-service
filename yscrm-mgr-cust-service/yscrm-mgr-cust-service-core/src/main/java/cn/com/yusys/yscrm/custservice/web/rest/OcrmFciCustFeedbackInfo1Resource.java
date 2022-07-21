/*
 * 代码生成器自动生成的
 * Since 2008 - 2019
 *
 */
package cn.com.yusys.yscrm.custservice.web.rest;

import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cn.com.yusys.yusp.commons.config.DefaultProfileUtil;
import cn.com.yusys.yusp.commons.excel.ExcelImportExportUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.micrometer.core.annotation.Timed;
import cn.com.yusys.yscrm.custservice.domain.OcrmFciCustFeedbackInfo;
import cn.com.yusys.yscrm.custservice.service.OcrmFciCustFeedbackInfo1Service;

/**
 * @项目名称: demo模块
 * @类名称: OcrmFciCustFeedbackInfoResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: 23378
 * @创建时间: 2019-02-11 16:49:43
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcicustfeedbackinfo1")
public class OcrmFciCustFeedbackInfo1Resource extends CommonResource<OcrmFciCustFeedbackInfo, String> {
	@Autowired
	private OcrmFciCustFeedbackInfo1Service service;

	@Override
	protected CommonService getCommonService() {
		return service;
	}
	

	/**
	 * @函数名称:index
	 * @函数描述:查询对象列表，公共API接口
	 * @参数与返回说明:
	 * @param QueryModel
	 *            分页查询类
	 * @算法描述:
	 */
	@GetMapping("/queryAll")
	@Timed
	protected ResultDto<List<OcrmFciCustFeedbackInfo>> queryAll(QueryModel queryModel) {
		List<OcrmFciCustFeedbackInfo> list = service.queryAll(queryModel);
		System.out.println(list);
		return new ResultDto<List<OcrmFciCustFeedbackInfo>>(list);
	}

	@GetMapping("/queryView")
	protected ResultDto<List<OcrmFciCustFeedbackInfo>> queryView(QueryModel model) {

		if (model.getCondition().get("feedbackChg") != null && model.getCondition().get("feedbackChg") != "") {
			java.util.ArrayList list = (ArrayList) model.getCondition().get("feedbackChg");
			Object[] feedbackChg = list.toArray();
			if (list.size() != 0 && !model.getCondition().get("feedbackChg").toString().equals("[]")) {
				model.getCondition().remove("feedbackChg");
				model.getCondition().put("feedbackChg", feedbackChg);
			} else {
				model.getCondition().remove("feedbackChg");
				model.getCondition().put("feedbackChg", null);
			}
		}
		if (model.getCondition().get("custLevel") != null && model.getCondition().get("custLevel") != "") {
			java.util.ArrayList list = (ArrayList) model.getCondition().get("custLevel");
			Object[] custLevel = list.toArray();
			if (list.size() != 0 && !model.getCondition().get("custLevel").toString().equals("[]")) {
				model.getCondition().remove("custLevel");
				model.getCondition().put("custLevel", custLevel);
			} else {
				model.getCondition().remove("custLevel");
				model.getCondition().put("custLevel", null);
			}
		}
		List<OcrmFciCustFeedbackInfo> list = service.queryPer(model);
		return new ResultDto<List<OcrmFciCustFeedbackInfo>>(list);
	}

	@PostMapping("/insert")
	protected ResultDto<OcrmFciCustFeedbackInfo> insert(@RequestBody OcrmFciCustFeedbackInfo info) {
		service.insertFeedback(info);
		return new ResultDto<OcrmFciCustFeedbackInfo>(info);
	}

	@PostMapping("/update")
	protected ResultDto<Integer> update(@RequestBody OcrmFciCustFeedbackInfo info) {
		int result = service.updateSelective(info);
		return new ResultDto<Integer>(result);
	}

	@PostMapping("/delete/{ids}")
	protected ResultDto<Integer> delete(@PathVariable String ids) {
		System.out.println(ids);
		String[] id = ids.toString().split(",");
		int i;
		for (i = 0; i < id.length; i++) {
			int result = service.deleteByPrimaryKey(id[i]);
		}
		int result = i;
		return new ResultDto<Integer>(result);
	}

}
