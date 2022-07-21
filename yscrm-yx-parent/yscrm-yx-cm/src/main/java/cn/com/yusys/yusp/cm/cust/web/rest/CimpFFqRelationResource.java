package cn.com.yusys.yusp.cm.cust.web.rest;

import java.net.URISyntaxException;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqRelation;
import cn.com.yusys.yusp.cm.cust.service.CimpFFqRelationService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqRelationResource
 * @类描述: 
 * @功能描述: 数据关联设置
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年11月08日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimpffqrelation")
public class CimpFFqRelationResource  extends CommonResource<CimpFFqRelation,String>{
	 @Autowired
	 private CimpFFqRelationService cimpFFqRelationService;
	
	 public CimpFFqRelationResource(CimpFFqRelationService service) {
	        super();
	        this.cimpFFqRelationService=service;
	        // TODO Auto-generated constructor stub
	    }
	 private final Logger log = LoggerFactory.getLogger(CimpFFqRelationResource.class);
	
	 @Override
	 protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimpFFqRelationService;
	}
	 
	/**
	* @方法名称: getListByModel
	* @方法描述: 初始化查询
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/list")
	public ResultDto<List<Map<String, Object>>> getListByModel(QueryModel queryModel) {
		List<Map<String, Object>> list = cimpFFqRelationService.getListByModel(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
    
    /**
	* @方法名称: getDataObj
	* @方法描述: 查询对象表作为左表
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/getDataObj")
	public ResultDto<List<Map<String, Object>>> getDataObj() {
		List<Map<String, Object>> list = cimpFFqRelationService.getDataObj();
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
    
    /**
	* @方法名称: getDataObjs
	* @方法描述: 根据左表id查询右表
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/getDataObjs")
	public ResultDto<List<Map<String, Object>>> getDataObjs(QueryModel queryModel) {
		List<Map<String, Object>> list = cimpFFqRelationService.getDataObjs(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
    
    /**
	* @方法名称: getColDataObj
	* @方法描述: 查询左字段
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/getColDataObj")
	public ResultDto<List<Map<String, Object>>> getColDataObj(QueryModel queryModel) {
		List<Map<String, Object>> list = cimpFFqRelationService.getColDataObj(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
    
    /**
	* @方法名称: getColDataObj
	* @方法描述: 查询右字段
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/getColDataObjs")
	public ResultDto<List<Map<String, Object>>> getColDataObjs(QueryModel queryModel) {
		List<Map<String, Object>> list = cimpFFqRelationService.getColDataObjs(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	} 
    /**
	* @方法名称: addData
	* @方法描述: 新增
	* @参数与返回说明: record
	* @算法描述: 
	*/
    @PostMapping("/addData")
	  public ResultDto<Integer> addData (@RequestBody CimpFFqRelation record)throws URISyntaxException, ParseException{
    	ResultDto<Integer> resultDto = new ResultDto<Integer>();
    	resultDto = new ResultDto<Integer>(this.cimpFFqRelationService.addData(record));
    	return  resultDto;
	 }
    
     /**
	  * 修改
	  * @param record
	  * @return
	  */
	 
	 @PostMapping("/updatedata")
	 @Timed
	 public ResultDto<Integer> updateData(@RequestBody CimpFFqRelation record){
	    	ResultDto<Integer> resultDto = new ResultDto<Integer>();
	    	resultDto = new ResultDto<Integer>(this.cimpFFqRelationService.updateData(record));
	    	return  resultDto;
	 }
   
	 /**
		* @方法名称: deleteMult
		* @方法描述: 多个删除
		* @参数与返回说明: 
		* @算法描述: 
		*/
		@PostMapping("/deletes/{ids}")
		@Timed
		public ResultDto<Integer> deletebyid(@PathVariable String ids) {
			String[] id = ids.toString().split(",");
			int i;
			for(i=0;i<id.length;i++) {
				this.cimpFFqRelationService.deletebyid(id[i]);
			}
			int result =i;
			return new ResultDto<Integer>(result);
			
		}
    
}

