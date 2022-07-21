package cn.com.yusys.yusp.cm.sysKeyWord.web.rest;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcSysTypeInfo;
import cn.com.yusys.yusp.cm.sysKeyWord.service.CmFRcSysTypeService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcSysTypeResource
 * @类描述: 渠道营销模板接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-10-17 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcsystype")
public class CmFRcSysTypeResource extends CommonResource<CmFRcSysTypeInfo, Serializable>{

	@Autowired
	private CmFRcSysTypeService service;
	
	@Override
	protected CommonService getCommonService() {
		return this.service;
	}
	
	/*
	  * 查询渠道营销模板表
	  * @param model
	  * @return hashmap
	  * */
	 @GetMapping("/list")
	 public ResultDto<List<CmFRcSysTypeInfo>> getList(QueryModel model) {
		 List<CmFRcSysTypeInfo> list = service.getList(model);
		 return new ResultDto<List<CmFRcSysTypeInfo>>(list);
	 }
		/*
	  * 营销动作组件查询模板信息-更具模板ID
	  * @param modelId
	  * @return hashmap
	  * */
	 @GetMapping("/listbynodeid")
	 public ResultDto<List<CmFRcSysTypeInfo>> getListByNodeId(String modelId) {
		 List<CmFRcSysTypeInfo> list = service.getListByNodeId(modelId);
		 return new ResultDto<List<CmFRcSysTypeInfo>>(list);
	 }
	 /*
	  * 产品视图查询渠道模型表
	  * @param record
	  * @return Integer
	  * */
	 @GetMapping("/listprod")
	 public ResultDto<List<CmFRcSysTypeInfo>> getListProd(QueryModel model) {
		 List<CmFRcSysTypeInfo> list = service.getListProd(model);
		 return new ResultDto<List<CmFRcSysTypeInfo>>(list);
	 }
	 /*
	  * 删除渠道营销模板表
	  * @param record
	  * @return Integer
	  * */
	 @PostMapping("/deletelist")
	 public ResultDto<Integer> deleteList(@RequestBody CmFRcSysTypeInfo record) throws URISyntaxException{
		 return this.service.deleteList(record);
	 }
	 /*
	  * 新增渠道营销模板表
	  * @param record
	  * @return Integer
	  * */
	 @PostMapping("/insertlist") 
	 public ResultDto<Integer> insertList(@RequestBody CmFRcSysTypeInfo record) throws URISyntaxException{
		 return this.service.insertList(record);
	 }
	 /*
	  * 修改渠道营销模板表
	  * @param record
	  * @return Integer
	  * */
	 @PostMapping("/updatelist")
	 public ResultDto<Integer> updateList(@RequestBody CmFRcSysTypeInfo record) throws URISyntaxException{
		 return this.service.updateList(record);
	 }
	 /*
	  * 获取关键字/别名
	  * @param record
	  * @return Integer
	  * */
	 @GetMapping("/getnames")
	 public ResultDto<List<Map<String, Object>>>getAliasName(QueryModel model) {
		 return new ResultDto<List<Map<String, Object>>>(this.service.getAliasName(model));
	 }
	 
}
