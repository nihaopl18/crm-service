package cn.com.yusys.yusp.cm.cust.web.rest;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.com.yusys.yusp.cm.cust.domain.CimFTagCustTags;
import cn.com.yusys.yusp.cm.cust.service.CimFTagCustTagsService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
/**
 * 
 * @项目名称: yusp-app-cim
 * @类名称: CimFTagCustTagsResource
 * @类描述: 
 * @功能描述: 模型版本信息
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年10月08日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimftagcusttags")
public class CimFTagCustTagsResource  extends CommonResource<CimFTagCustTags,String>{
	 @Autowired
	 private CimFTagCustTagsService cimFTagCustTagsService;
	
	 public CimFTagCustTagsResource(CimFTagCustTagsService service) {
	        super();
	        this.cimFTagCustTagsService=service;
	        // TODO Auto-generated constructor stub
	    }
	 private final Logger log = LoggerFactory.getLogger(CimFTagCustTagsResource.class);
	
	 @Override
	 protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.cimFTagCustTagsService;
	}
    
    
    /**
	* @方法名称: getListByTags
	* @方法描述: 根据标签进行客户查询
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/getlistbytags")
	public ResultDto<List<CimFTagCustTags>> getListByTags(QueryModel queryModel) {
		List<CimFTagCustTags> list = cimFTagCustTagsService.getListByTags(queryModel);
		return new ResultDto<List<CimFTagCustTags>>(list);
	} 
    
    /**
	* @方法名称: qryTags
	* @方法描述: 查询客户下的标签信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
    
    @GetMapping("/qryTags")
   	public ResultDto<List<Map<String, Object>>> qryTags(@RequestParam String custId) {
    	List<Map<String, Object>> list =cimFTagCustTagsService.qryTags(custId);
    	log.info("list.size()="+list.size());
    	ResultDto<List<Map<String, Object>>> resultDto=new ResultDto<List<Map<String, Object>>>();
    	resultDto.setTotal(list.size());
    	resultDto.setData(list);
       	return resultDto;
   	}
    
    /**
	* @方法名称: addTags
	* @方法描述: 新增标签
	* @参数与返回说明: record:CUST_ID,TAG_NO,TAG_NAME,IF_AVAILABLE,AVAILABLE_DATE,DISABLE_DATE
	* @算法描述: 
	*/
    @PostMapping("/addTags")
	  public ResultDto<List<CimFTagCustTags>> addTags (@RequestBody CimFTagCustTags record)throws URISyntaxException, ParseException{
    	ResultDto<List<CimFTagCustTags>> resultDto=new ResultDto<List<CimFTagCustTags>>();
    	int num =cimFTagCustTagsService.addTags(record);
    	log.info("num="+num);
    	if(num==-1){
    		resultDto.setMessage("该客户下已经有此自定义标签！");
    		resultDto.setCode(-1);
    	}else if(num==0){
    		resultDto.setMessage("新增失败！");
    		resultDto.setCode(-1);
    	}else{
    		resultDto.setMessage("success");
    		resultDto.setCode(0);
    	}
    	return  resultDto ;
	 }
    
    /**
	* @方法名称: updateTags
	* @方法描述: 更新客户下标签
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @PostMapping("/updateTags")
	  public ResultDto<List<CimFTagCustTags>> updateTags(@RequestBody CimFTagCustTags record)throws URISyntaxException, ParseException{
    	ResultDto<List<CimFTagCustTags>> resultDto=new ResultDto<List<CimFTagCustTags>>();
    	int num =cimFTagCustTagsService.updateTags(record);
    	log.info("num="+num);
    	if(num==0){
    		resultDto.setMessage("新增失败！");
    		resultDto.setCode(-1);
    	}else {
    		resultDto.setMessage("success");
    		resultDto.setCode(0);
    	}
    	return resultDto;
	 }
    /**
	* @throws JsonProcessingException 
     * @方法名称: getAuthData
	* @方法描述: 根据授权类型对象和标签编号获取有效的授权数据
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/getAuthData")
	public ResultDto<List<CimFTagCustTags>> getAuthData(QueryModel model) throws JsonProcessingException {
		List<CimFTagCustTags> list = cimFTagCustTagsService.getAuthData(model);
		return new ResultDto<List<CimFTagCustTags>>(list);
	} 
}

