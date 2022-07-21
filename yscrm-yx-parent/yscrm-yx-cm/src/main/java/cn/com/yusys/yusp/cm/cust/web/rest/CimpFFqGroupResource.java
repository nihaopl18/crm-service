package cn.com.yusys.yusp.cm.cust.web.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqGroup;
import cn.com.yusys.yusp.cm.cust.service.CimpFFqGroupService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqGroupResource
 * @类描述: 
 * @功能描述: 数据集分组
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年11月26日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimpffqgroup")
public class CimpFFqGroupResource  extends CommonResource<CimpFFqGroup,String>{
	 @Autowired
	 private CimpFFqGroupService cimpFFqGroupService;
	
	 public CimpFFqGroupResource(CimpFFqGroupService service) {
	        super();
	        this.cimpFFqGroupService=service;
	        // TODO Auto-generated constructor stub
	    }
	 private final Logger log = LoggerFactory.getLogger(CimpFFqGroupResource.class);
	
	 @Override
	 protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimpFFqGroupService;
	}
	 
	 /*
	  * 根据点击的对象查询分组
	  * @param 
	  * @return HashMap
	  * */
	 @GetMapping("/getgroup")
	 public ResultDto<List<CimpFFqGroup>> getGroup(String objId) {
		 List<CimpFFqGroup> list = this.cimpFFqGroupService.getGroup(objId);
		 return new ResultDto<List<CimpFFqGroup>>(list);
	 }
	 
}


