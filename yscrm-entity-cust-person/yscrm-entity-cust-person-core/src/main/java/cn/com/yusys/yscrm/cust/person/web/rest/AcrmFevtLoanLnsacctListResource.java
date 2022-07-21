package cn.com.yusys.yscrm.cust.person.web.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFevtLoanLnsacctlist;
import cn.com.yusys.yscrm.cust.person.service.AcrmFevtLoanLnsacctListService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFevtLoanLnsacctListResource
 * @类描述: #资源类
 * @功能描述: 账户信息-贷款账户交易流水
 * @创建人: 15104
 * @创建时间: 2019-01-28 00:41:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfevtloanlnsacctlist")
public class AcrmFevtLoanLnsacctListResource extends CommonResource<AcrmFevtLoanLnsacctlist, String> {
    @Autowired
    private AcrmFevtLoanLnsacctListService acrmFevtLoanLnsacctListService;

    @Override
    protected CommonService getCommonService() {
        return acrmFevtLoanLnsacctListService;
    }

    @GetMapping("/querylist")
	public ResultDto<Object> querylist(QueryModel model) {
		List<Map<Object, String>> baseInfo = acrmFevtLoanLnsacctListService.querylist(model);

   		return new ResultDto<Object>(baseInfo);
	}
	
    @GetMapping("/export")
   	public void export(HttpServletResponse response,QueryModel model) throws IOException {
   		this.acrmFevtLoanLnsacctListService.export(model, response);
   	}
}
