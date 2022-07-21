package cn.com.yusys.yscrm.custgrade.web.rest;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custgrade.domain.CustGradeUpBoundaryCustQuery;
import cn.com.yusys.yscrm.custgrade.service.CustGradeUpBoundaryCustQueryService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称: crm-service
 * @类名称: CustGradeUpBoundaryCustQueryResource
 * @类描述: 
 * @功能描述: 客户等级变动列表查询,客户等级变动明细列表查询
 * @创建人: zhangcl3@yusys.com.cn
 * @创建时间: 2019年02月11日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/custgradeupboundarycustquery")
public class CustGradeUpBoundaryCustQueryResource  extends CommonResource<CustGradeUpBoundaryCustQuery,String>{
		 @Autowired
		 private CustGradeUpBoundaryCustQueryService CustGradeUpBoundaryCustQueryService;
		
		 public CustGradeUpBoundaryCustQueryResource(CustGradeUpBoundaryCustQueryService service) {
		        super();
		        this.CustGradeUpBoundaryCustQueryService=service;
		        // TODO Auto-generated constructor stub
		    }
		 private final Logger log = LoggerFactory.getLogger(CustGradeUpBoundaryCustQueryResource.class);
		
		 @Override
		 protected CommonService getCommonService() {
			// TODO Auto-generated method stub
			return this.CustGradeUpBoundaryCustQueryService;
		}
		 
	    /**
		* @方法名称: getAll
		* @方法描述: 查询条件
		* @参数与返回说明: 
		* @算法描述: 
		*/
	    @GetMapping("/querylist")
		public ResultDto<List<Map<String, Object>>> getAll(QueryModel queryModel) {
			List<Map<String, Object>> list = CustGradeUpBoundaryCustQueryService.getAll(queryModel);
			return new ResultDto<List<Map<String, Object>>>(list);
		} 
	    
		 
	    /**
		* @方法名称: getCurrCust
		* @方法描述: 查询条件
		* @参数与返回说明: 
		* @算法描述: 
		*/
	    @GetMapping("/querydetaillist")
		public ResultDto<List<Map<String, Object>>> getCurrCust(QueryModel queryModel) {
	    	ResultDto<List<Map<Object, String>>> resultDto = null;
  	  		String custId = (String) queryModel.getCondition().get("custId");
  	  		if (custId == null || custId.equals("")) {
  	  			resultDto = new ResultDto<>();
  	  			resultDto.setMessage("查询失败");
  	  			resultDto.setCode(-1);
  	  			return new ResultDto<>(null);
  	  		}
	    	List<Map<String, Object>> list = CustGradeUpBoundaryCustQueryService.getCurrCust(queryModel);
			return new ResultDto<List<Map<String, Object>>>(list);
		} 
	    
	}


