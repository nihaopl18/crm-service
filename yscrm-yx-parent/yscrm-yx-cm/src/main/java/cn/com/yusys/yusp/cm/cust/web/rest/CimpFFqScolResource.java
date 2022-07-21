package cn.com.yusys.yusp.cm.cust.web.rest;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqScol;
import cn.com.yusys.yusp.cm.cust.service.CimpFFqScolService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqScolResource
 * @类描述: 
 * @功能描述: 灵活查询方案条件
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年11月21日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimpffqscol")
public class CimpFFqScolResource  extends CommonResource<CimpFFqScol,String>{
	 @Autowired
	 private CimpFFqScolService cimpFFqScolService;
	
	 public CimpFFqScolResource(CimpFFqScolService service) {
	        super();
	        this.cimpFFqScolService=service;
	        // TODO Auto-generated constructor stub
	    }
	 private final Logger log = LoggerFactory.getLogger(CimpFFqScolResource.class);
	
	 @Override
	 protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimpFFqScolService;
	}
	 
    /**
	* @方法名称: getScol
	* @方法描述: 查询条件
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/getscol")
	public ResultDto<List<Map<String, Object>>> getScol(String ssId) {
		List<Map<String, Object>> list = cimpFFqScolService.getScol(ssId);
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
    
}

