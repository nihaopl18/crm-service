package cn.com.yusys.yscrm.info.remind.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import cn.com.yusys.yscrm.info.remind.domain.OcrmFciCustAdmitTarget;
import cn.com.yusys.yscrm.info.remind.service.OcrmFciCustAdmitTargetService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

@RestController
@RequestMapping("/api/admttancetarget")
public class OcrmFciCustAdmitTargetResource extends CommonResource<OcrmFciCustAdmitTarget, String> {
	
	@Autowired
	private OcrmFciCustAdmitTargetService service;
	
	@Override
	protected CommonService getCommonService() {
		return service;
	}
	
	@GetMapping("/queryList")
    @Timed
    public ResultDto<List<Map<String, Object>>> queryList() {
		List<Map<String, Object>> list=service.queryList();
		System.out.println(list);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	
	@GetMapping("/save")
    @Timed
	public ResultDto<Integer> save(QueryModel model) {
		Integer rowNum=service.save(model);
		System.out.println(rowNum);
		return new ResultDto<Integer>(rowNum);
	}
}
