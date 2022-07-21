package cn.com.yusys.yusp.cm.cust.web.rest;


import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codahale.metrics.annotation.Timed;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqDbcol;
import cn.com.yusys.yusp.cm.cust.service.CimpFFqDbcolService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqDbcolResource
 * @类描述: 
 * @功能描述: 数据集管理
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年11月08日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimpffqdbcol")
public class CimpFFqDbcolResource  extends CommonResource<CimpFFqDbcol,String>{
	 @Autowired
	 private CimpFFqDbcolService cimpFFqDbcolService;
	
	 public CimpFFqDbcolResource(CimpFFqDbcolService service) {
	        super();
	        this.cimpFFqDbcolService=service;
	        // TODO Auto-generated constructor stub
	    }
	 private final Logger log = LoggerFactory.getLogger(CimpFFqDbcolResource.class);
	
	 @Override
	 protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimpFFqDbcolService;
	}
	 
	 /*
	  * 页面初始化查询指标信息
	  * @param 否
	  * @return HashMap
	  * */
	 @GetMapping("/collist")
	 public ResultDto<List<CimpFFqDbcol>> qryCollist(QueryModel model) {
		 List<CimpFFqDbcol> list = this.cimpFFqDbcolService.qryCollist(model);
		 return new ResultDto<List<CimpFFqDbcol>>(list);
	 }
	 
	 /*
	  * 校验该来源表是否已经配置
	  * @param 
	  * @return HashMap
	  * */
	 @GetMapping("/isexist")
	 public ResultDto<List<CimpFFqDbcol>> isExist(QueryModel model) {
		 List<CimpFFqDbcol> list = this.cimpFFqDbcolService.isExist(model);
		 return new ResultDto<List<CimpFFqDbcol>>(list);
	 }
	 
	 /*
	  * 查询数据集字段 
	  * @param 否
	  * @return HashMap
	  * */
	 @GetMapping("/qrysetdata")
	 public ResultDto<List<CimpFFqDbcol>> qrysetdata(QueryModel model) {
		 List<CimpFFqDbcol> list = this.cimpFFqDbcolService.qrysetdata(model);
		 return new ResultDto<List<CimpFFqDbcol>>(list);
	 }
	 
	 /*
	  * 查询全部数据集字段 
	  * @param 是
	  * @return HashMap
	  * */
	 @GetMapping("/qryallsetdata")
	 public ResultDto<List<CimpFFqDbcol>> qryallsetdata(QueryModel model) {
		 List<CimpFFqDbcol> list = this.cimpFFqDbcolService.qryallsetdata(model);
		 return new ResultDto<List<CimpFFqDbcol>>(list);
	 }
	 
	 /**
		* @方法名称: updatesetdata
		* @方法描述: 指标维护保存
		* @参数与返回说明: 
		* @算法描述: 
		*/
		@PostMapping("/updatesetdata")
        public  ResultDto<Object> updatesetdata(@RequestBody ArrayList<CimpFFqDbcol> t) throws URISyntaxException
		{	
			List<CimpFFqDbcol> list = t;
			 this.cimpFFqDbcolService.updatesetdata(list);
	         return new ResultDto<Object>();
			
		}
		
		/**
		* @方法名称: deletedata
		* @方法描述: 指标维护删除
		* @参数与返回说明: 
		* @算法描述: 
		*/
		@PostMapping("/deletedata")
		@Timed
		public ResultDto <Integer> deletedata(@RequestBody CimpFFqDbcol record)  {
			int num = 0;
	        num=this.cimpFFqDbcolService.deletedata(record);
			return new ResultDto<Integer>(num);
		}
		
		/*
		  * 加载数据表来源
		  * @param 否
		  * @return HashMap
		  * */
		 @GetMapping("/loadData")
		 public ResultDto<List<Map<String, Object>>> loadData(@RequestParam String id) {
			 return new ResultDto<List<Map<String, Object>>>(this.cimpFFqDbcolService.loadData(id));
		 }
		 
		 /*
		  * 客户灵活查询查询左侧树
		  * @param 否
		  * @return HashMap
		  * */
		 @GetMapping("/prepare")
		 public ResultDto<List<Map<String, Object>>> prepare() {
			 return new ResultDto<List<Map<String, Object>>>(this.cimpFFqDbcolService.prepare());
		 }
		 
		 /*
		  * 客户灵活查询结果 
		  * @param 
		  * @return HashMap
		  * */
		 @GetMapping("/queryresult")
		 public ResultDto<List<Map<String, Object>>> queryResult(QueryModel model) {
			 ResultDto<List<Map<String, Object>>> resultDto=new ResultDto<List<Map<String, Object>>>();
			 List<Map<String, Object>> list=this.cimpFFqDbcolService.queryResult(model);
			 log.info("list="+list);
			 if(list==null)
			 {
				 resultDto.setMessage("执行查询出错，请检查方案是否合理！");
		    	 resultDto.setCode(-1); 
				 return resultDto;
			 }else{
				 return new ResultDto<List<Map<String, Object>>>(list);
			 }
		 }
		 
		 /*
		  * 客户灵活查询查询字段属性值类型 文本框..
		  * @param 
		  * @return HashMap
		  * */
		 @GetMapping("/showcoltype")
		 public ResultDto<List<Map<String, Object>>> showcoltype(QueryModel model) {
			 List<Map<String, Object>> list=this.cimpFFqDbcolService.showcoltype(model);
			 return new ResultDto<List<Map<String, Object>>>(list);
		 }
		 
		 /*
		  * 查询数据字典
		  * @param 
		  * @return HashMap
		  * */
		 @GetMapping("/qrylookupcode")
		 public ResultDto<List<Map<String, Object>>> qryLookupcode() {
			 List<Map<String, Object>> list = this.cimpFFqDbcolService.qryLookupcode();
			 return new ResultDto<List<Map<String, Object>>>(list);
		 }
		 
		 /*
		  * 根据code查询数据字典选项值
		  * @param 
		  * @return HashMap
		  * */
		 @GetMapping("/getcodeitem")
		 public ResultDto<List<Map<String, Object>>> getcodeitem(String lookupCode) {
			 List<Map<String, Object>> list = this.cimpFFqDbcolService.getcodeitem(lookupCode);
			 return new ResultDto<List<Map<String, Object>>>(list);
		 }
		 
		 /**
			* @方法名称: deleteMult
			* @方法描述: 多个删除
			* @参数与返回说明: 
			* @算法描述: 
			*/
			@PostMapping("/deletes/{ids}")
			@Timed
			public ResultDto<Integer> deleteByid(@PathVariable String ids) {
				String[] id = ids.toString().split(",");
				int i;
				for(i=0;i<id.length;i++) {
					cimpFFqDbcolService.deleteByid(id[i]);
				}
				int result =i;
				return new ResultDto<Integer>(result);
				
			}
			
			/**
			* @方法名称: getListByModel
			* @方法描述: 查询表名
			* @参数与返回说明: 
			* @算法描述: 
			*/
		    @GetMapping("/getDataSetSolution")
			public ResultDto<List<CimpFFqDbcol>> getDataSetSolution() {
				List<CimpFFqDbcol> list = cimpFFqDbcolService.getDataSetSolution();
				return new ResultDto<List<CimpFFqDbcol>>(list);
			} 
			 
		    /*
			  * 根据客户群sql查询数据
			  * @param 否
			  * @return HashMap
			  * */
			 @GetMapping("/qrycustinfo")
			 public ResultDto<List<Map<String, Object>>> qryCustinfo(String sql) {
				 List<Map<String, Object>> list = cimpFFqDbcolService.qryCustinfo(sql);
				 return new ResultDto<List<Map<String, Object>>>(list);
			 }
}

