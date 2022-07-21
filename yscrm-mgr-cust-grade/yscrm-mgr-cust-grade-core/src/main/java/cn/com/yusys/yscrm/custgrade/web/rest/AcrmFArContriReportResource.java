package cn.com.yusys.yscrm.custgrade.web.rest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custgrade.domain.AcrmFArContriReport;
import cn.com.yusys.yscrm.custgrade.service.AcrmFArContriReportService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称: crm-service
 * @类名称: AcrmFArContriReportResource
 * @类描述: 
 * @功能描述: 客户贡献度查询
 * @创建人: zhangcl3@yusys.com.cn
 * @创建时间: 2019年02月11日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/AcrmFArContriReport")
public class AcrmFArContriReportResource  extends CommonResource<AcrmFArContriReport,String>{
		 @Autowired
		 private AcrmFArContriReportService AcrmFArContriReportService;
		
		 public AcrmFArContriReportResource(AcrmFArContriReportService service) {
		        super();
		        this.AcrmFArContriReportService=service;
		        // TODO Auto-generated constructor stub
		    }
		 private final Logger log = LoggerFactory.getLogger(AcrmFArContriReportResource.class);
		
		 @Override
		 protected CommonService getCommonService() {
			// TODO Auto-generated method stub
			return this.AcrmFArContriReportService;
		}
		 
	    /**
		* @方法名称: getAll
		* @方法描述: 查询条件
		* @参数与返回说明: 
		* @算法描述: 
		*/
	    @GetMapping("/querylist")
		public ResultDto<List<Map<String, Object>>> getAll(QueryModel queryModel) {
	    	if(queryModel.getCondition().containsKey("dataDate")) {
	    		SimpleDateFormat sdf=new  SimpleDateFormat("YYYYMMdd");
	    		Calendar cal=Calendar.getInstance();
	    		String dataDate=(String) queryModel.getCondition().get("dataDate");
	    		int year=Integer.parseInt(dataDate.substring(0,4));
	    		int month=Integer.parseInt(dataDate.substring(5,7));
	    		cal.set(Calendar.YEAR, year);
	    		cal.set(Calendar.MONTH, month-1);
	    		int lastDay=cal.getActualMaximum(Calendar.DATE);
	    		cal.set(Calendar.DAY_OF_MONTH, lastDay);
	    		dataDate=sdf.format(cal.getTime());
	    		queryModel.getCondition().put("dataDate",dataDate);
	    		System.out.println(dataDate);
	    	}
			List<Map<String, Object>> list = AcrmFArContriReportService.getAll(queryModel);
			return new ResultDto<List<Map<String, Object>>>(list);
		} 
	    
	}


