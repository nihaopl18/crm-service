package cn.com.yusys.yusp.cm.cust.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.cm.cust.domain.CimpCgCustPerContSum;
import cn.com.yusys.yusp.cm.cust.service.CimpCgCustPerContSumService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

@RestController
@RequestMapping("/api/cimpcgcustpercontsum")
public class CimpCgCustPerContSumResource extends CommonResource<CimpCgCustPerContSum, String>{
	@Autowired
	private CimpCgCustPerContSumService service;
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.service;
	}
	//显示查询列表信息
	@GetMapping("/list")
	public ResultDto<List<Map<String, Object>>> getListByModel(QueryModel queryModel) {
		List<Map<String, Object>> list = service.getListByModel(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
		 
		 
}
