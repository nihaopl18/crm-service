package cn.com.yusys.yscrm.cust.org.web.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFevtPreSaveList;
import cn.com.yusys.yscrm.cust.org.service.UnitAcrmFevtPreSaveListService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFevtPreSaveListResource
 * @类描述: #资源类
 * @功能描述: 账户信息-对公存款交易流水
 * @创建人: 15104
 * @创建时间: 2019-01-28 00:23:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/unitAcrmFevtPreSaveList")
public class UnitAcrmFevtPreSaveListResource extends CommonResource<AcrmFevtPreSaveList, String> {
    @Autowired
    private UnitAcrmFevtPreSaveListService unitAcrmFevtPreSaveListService;

    @Override
    protected CommonService getCommonService() {
        return unitAcrmFevtPreSaveListService;
    }

    @GetMapping("/querylist")
	public ResultDto<Object> querylist(QueryModel model) {
		List<Map<Object, String>> baseInfo = unitAcrmFevtPreSaveListService.querylist(model);

   		return new ResultDto<Object>(baseInfo);
	}
	
    @GetMapping("/export")
   	public void export(HttpServletResponse response,QueryModel model) throws IOException {
   		this.unitAcrmFevtPreSaveListService.export(model, response);
   	}
}
