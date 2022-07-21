package cn.com.yusys.yscrm.cust.person.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFagLoanPawnInfo;
import cn.com.yusys.yscrm.cust.person.service.AcrmFagLoanPawnInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagLoanPawnInfoResource
 * @类描述: #资源类
 * @功能描述: 担保信息-抵押物信息
 * @创建人: 15104
 * @创建时间: 2019-02-11 14:12:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfagloanpawninfo")
public class AcrmFagLoanPawnInfoResource extends CommonResource<AcrmFagLoanPawnInfo, String> {
    @Autowired
    private AcrmFagLoanPawnInfoService acrmFagLoanPawnInfoService;

    @Override
    protected CommonService getCommonService() {
        return acrmFagLoanPawnInfoService;
    }

    @GetMapping("/querylist/{custId}")
	public ResultDto<Object> querylist(QueryModel model, @PathVariable String custId) {
		List<Map<Object, String>> baseInfo = acrmFagLoanPawnInfoService.querylist(model, custId);

   		return new ResultDto<Object>(baseInfo);
	}
    
}
