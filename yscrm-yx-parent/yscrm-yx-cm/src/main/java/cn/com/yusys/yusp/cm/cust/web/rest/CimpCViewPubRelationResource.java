package cn.com.yusys.yusp.cm.cust.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.cm.cust.domain.CimpCViewPubRelation;
import cn.com.yusys.yusp.cm.cust.service.CimpCViewPubRelationService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

@RestController
@RequestMapping("/api/cimpcviewpubrelation")
public class CimpCViewPubRelationResource extends CommonResource<CimpCViewPubRelation, String>{
	@Autowired
	private CimpCViewPubRelationService service;
	@Override
	protected CommonService getCommonService() {
		// TODO 自动生成的方法存根
		return this.service;
	}
	//显示查询列表信息
	@GetMapping("/list")
	public ResultDto<List<CimpCViewPubRelation>> getListByModel(QueryModel queryModel) {
		List<CimpCViewPubRelation> list = service.getListByModel(queryModel);
		return new ResultDto<List<CimpCViewPubRelation>>(list);
	}
		 
		 
}
