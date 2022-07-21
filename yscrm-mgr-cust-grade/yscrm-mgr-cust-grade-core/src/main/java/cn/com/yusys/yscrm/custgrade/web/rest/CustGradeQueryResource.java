package cn.com.yusys.yscrm.custgrade.web.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custgrade.domain.CustGradeQuery;
import cn.com.yusys.yscrm.custgrade.service.CustGradeQueryService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称: crm-service
 * @类名称: CustGradeQueryResource
 * @类描述: 
 * @功能描述: 客户等级查询
 * @创建人: zhangcl3@yusys.com.cn
 * @创建时间: 2019年02月11日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/custgradequery")
public class CustGradeQueryResource  extends CommonResource<CustGradeQuery,String>{
		 @Autowired
		 private CustGradeQueryService CustGradeQueryService;
		
		 public CustGradeQueryResource(CustGradeQueryService service) {
		        super();
		        this.CustGradeQueryService=service;
		        // TODO Auto-generated constructor stub
		    }
		 private final Logger log = LoggerFactory.getLogger(CustGradeQueryResource.class);
		
		 @Override
		 protected CommonService getCommonService() {
			// TODO Auto-generated method stub
			return this.CustGradeQueryService;
		}
		 
	    /**
		* @方法名称: getAll
		* @方法描述: 查询条件
		* @参数与返回说明: 
		* @算法描述: 
		*/
	    @GetMapping("/querylist")
		public ResultDto<List<Map<String, Object>>> getAll(QueryModel queryModel) {
			List<Map<String, Object>> list = CustGradeQueryService.getAll(queryModel);
			return new ResultDto<List<Map<String, Object>>>(list);
		} 
	    
	}


