package cn.com.yusys.yusp.eng;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleResult;
import cn.com.yusys.yusp.cm.ruleConfig.service.CmFRcRuleResultService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRuleResultResource
 * @类描述: 时间表单
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-11-19 10:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcruleresult")
public class CmFRcRuleResultEngResource extends CommonResource<CmFRcRuleResult, Serializable>{

	@Autowired
	private CmFRcRuleResultService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	@PostMapping("/backcall")
	public ResultDto<String> backCall(@RequestBody ArrayList<CmFRcRuleResult> resultList){
		service.backCall(resultList);
		return new  ResultDto<String>("~~~~~~~~~~~~~联机测试~~~~~~~~~~~~~~~~~~");
	}
}
