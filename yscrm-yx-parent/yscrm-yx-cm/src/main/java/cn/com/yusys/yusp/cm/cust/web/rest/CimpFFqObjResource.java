package cn.com.yusys.yusp.cm.cust.web.rest;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yusp.cm.cust.domain.CimpFFqObj;
import cn.com.yusys.yusp.cm.cust.service.CimpFFqObjService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqObjResource
 * @类描述: 
 * @功能描述: 数据集对象
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年11月26日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimpffqobj")
public class CimpFFqObjResource  extends CommonResource<CimpFFqObj,String>{
	 @Autowired
	 private CimpFFqObjService cimpFFqObjService;
	
	 public CimpFFqObjResource(CimpFFqObjService service) {
	        super();
	        this.cimpFFqObjService=service;
	        // TODO Auto-generated constructor stub
	    }
	 private final Logger log = LoggerFactory.getLogger(CimpFFqObjResource.class);
	
	 @Override
	 protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimpFFqObjService;
	}
	 
	 /*
	  * 页面初始化查询对象
	  * @param 否
	  * @return HashMap
	  * */
	 @GetMapping("/getobj")
	 public ResultDto<List<CimpFFqObj>> getObj(QueryModel model) {
		 List<CimpFFqObj> list = this.cimpFFqObjService.getObj(model);
		 return new ResultDto<List<CimpFFqObj>>(list);
	 }
	 
}

