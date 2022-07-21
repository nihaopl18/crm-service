package cn.com.yusys.yscrm.cust.person.web.rest;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFevtPerSaveList;
import cn.com.yusys.yscrm.cust.person.service.AcrmFevtPreSaveListService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFevtPreSaveListResource
 * @类描述: #资源类
 * @功能描述: 账户信息-存款交易流水
 * @创建人: 15104
 * @创建时间: 2019-01-28 00:23:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfevtpresavelist")
public class AcrmFevtPreSaveListResource extends CommonResource<AcrmFevtPerSaveList, String> {
    @Autowired
    private AcrmFevtPreSaveListService acrmFevtPreSaveListService;
    
    @Override
    protected CommonService getCommonService() {
        return acrmFevtPreSaveListService;
    }
    

    @GetMapping("/querylist")
	public ResultDto<Object> querylist(QueryModel model,HttpServletResponse response) throws IOException {
		List<Map<Object, String>> baseInfo = acrmFevtPreSaveListService.querylist(model);
   		return new ResultDto<Object>(baseInfo);
	}
    @GetMapping("/queryballist")
   	public ResultDto<Object> queryballist(QueryModel model) throws NoSuchAlgorithmException {
    	List<Map<Object, String>> balInfo = acrmFevtPreSaveListService.queryballist(model);
      	return new ResultDto<Object>(balInfo);
   	}
	
    
    @GetMapping("/export")
   	public void export(HttpServletResponse response,QueryModel model) throws IOException {
   		this.acrmFevtPreSaveListService.export(model, response);
   	}
}
