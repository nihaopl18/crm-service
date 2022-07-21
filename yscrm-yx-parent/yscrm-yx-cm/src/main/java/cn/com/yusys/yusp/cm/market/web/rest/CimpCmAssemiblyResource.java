package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.domain.CimpCmAssemClassifyinfo;
import cn.com.yusys.yusp.cm.market.domain.CimpCmAssemInout;
import cn.com.yusys.yusp.cm.market.domain.CimpCmAsseminfo;
import cn.com.yusys.yusp.cm.market.service.CimpCmAssemiblyService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称:yscimc-service
 * @类名称: CimpCmAssemiblyResource
 * @类描述: 
 * @功能描述: 组件管理resource
 * @创建人: hujun3@yusys.com.cn
 * @创建时间: 2017-12-22 11:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("api/asseibly")
public class CimpCmAssemiblyResource extends CommonResource<CimpCmAsseminfo, String> {

	private Logger logger = LoggerFactory.getLogger(CimpCmAssemiblyResource.class);
	
	@Autowired
	private CimpCmAssemiblyService service;

	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	
	/**
	 * 
	* @方法名称: getItemsByClassify
	* @方法描述: 根据分类查询组件数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getitemsbyclassify")
	public ResultDto<List<Map<String, Object>>> getItemsByClassify(String id) {
		List<Map<String, Object>> list = service.getItemsByClassify(id);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * 
	* @方法名称: getfieldsChannelById
	* @方法描述: 根据跟更具渠道类组件的ID查询对应的栏位信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getfieldschannelbyid")
	public ResultDto<List<Map<String, Object>>> getfieldsChannelById(String id) {
		List<Map<String, Object>> list = service.getfieldsChannelById(id);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * 
	* @方法名称: getAllItemsInfo
	* @方法描述: 查询全部组件数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getalliteminfo")
	public ResultDto<List<Map<String, Object>>> getAllItemsInfo() {
		List<Map<String, Object>> list = service.getAllItemsInfo();
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * 
	* @方法名称: getAllItemsInfoByScene
	* @方法描述: 根据活动场景查询全部组件数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getalliteminfoscene")
	public ResultDto<List<Map<String, Object>>> getAllItemsInfoByScene(String flowId) {
		List<Map<String, Object>> list = service.getAllItemsInfoByScene(flowId);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * 
	* @方法名称: updateClassifyInfo
	* @方法描述: 维护分类数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/updateclassify")
	public ResultDto<String> updateClassifyInfo(@RequestBody CimpCmAssemClassifyinfo pool) {
		 	service.updateClassifyInfo(pool);
		 	return new ResultDto<String>("success");
	}
	
	/**
	 * 
	* @方法名称: updateItemInfo
	* @方法描述: 维护组件数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/updateitem")
	public ResultDto<String> updateItemInfo(@RequestBody CimpCmAsseminfo pool) {
		 	service.updateItemInfo(pool);
		 	return new ResultDto<String>("success");
	}
	
	/**
	 * 
	* @方法名称: deleteClassify
	* @方法描述: 删除分类信息
	* @参数与返回说明: id 数据ID主键
	* @算法描述:删除分类信息的同时删除分类下的组件数据
	 */
	@PostMapping("/deleteclassify")
	public ResultDto<String> deleteClassify(@ApiParam(value = "id", required = true) String id) {
		
		if(id !=null&&!"".equals(id.toString())) {
			service.deleteClassifyInfo(id);//删除分类信息
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			
			logger.info("删除分类信息以及对应的组件数据  【主键："+id+"】 "+df.format(new Date()));
			
		}
		return new ResultDto<String>("success");
	}
	/**
	 * 
	* @方法名称: deleteIitem
	* @方法描述: 删除组件信息
	* @参数与返回说明: id 数据ID主键
	* @算法描述:
	 */
	@PostMapping("/deleteitem")
	public ResultDto<String> deleteIitem(@ApiParam(value = "id", required = true) String id) {
		
		if(id !=null&&!"".equals(id.toString())) {
			service.deleteItemInfo(id);//删除组件信息
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			
			logger.info("删除组件数据  【主键："+id+"】 "+df.format(new Date()));
			
		}
		return new ResultDto<String>("success");
	}
	/**
	 * 
	* @方法名称: GetClassifyinfo
	* @方法描述:  获取分类信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getclassifyinfo")
	public ResultDto<Object> getClassifyinfo() {
		logger.info("获取组件分类信息");
		List<Map<String, Object>> list=service.getAllClassifyinfo();
		return new ResultDto<Object>(list);
	}

	/**
	 * 
	* @方法名称: getItemInOutinfo
	* @方法描述:  分页查询组件输入输出信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getiteminoutinfo")
	public ResultDto<List<Map<String, Object>>> getItemInOutinfo(QueryModel queryModel) {
		logger.info("获取组件输入输出信息");
		List<Map<String, Object>> list=service.getInOutInfo(queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * 
	* @方法名称: updateItemInOut
	* @方法描述: 维护组件输入输出数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	@PostMapping("/updateiteminout")
	public ResultDto<String> updateItemInOut(@RequestBody CimpCmAssemInout pool) {
		 	service.updateItemInOutInfo(pool);
		 	return new ResultDto<String>("success");
	}
	/**
	 * 
	* @方法名称: deleteIitemInOut
	* @方法描述: 删除组件输入输出信息
	* @参数与返回说明: id 数据ID主键
	* @算法描述:
	 */
	@PostMapping("/deleteiteminout")
	public ResultDto<String> deleteIitemInOut( String ids) {
		
		if(ids !=null&&!"".equals(ids.toString())) {
			service.deleteItemInOutInfo(ids);//删除组件输入输出信息
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			
			logger.info("删除组件输入输出数据  【主键："+ids+"】 "+df.format(new Date()));
			
		}
		return new ResultDto<String>("success");
	}
	
	/**
	 * 
	* @方法名称: getTablesInfo
	* @方法描述: 根据数据库表格信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/gettablesinfo")
	public ResultDto<List<Map<String, Object>>> getTablesInfo(QueryModel queryModel) {
		List<Map<String, Object>> list = service.getTablesInfo( queryModel);
		return new ResultDto<List<Map<String, Object>>>(list);
	}
	/**
	 * 
	* @方法名称: getColumnByTable
	* @方法描述: 根据数据库表格信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getcolumnbytable")
	public ResultDto<List<Map<String, Object>>> getColumnByTable(QueryModel queryModel,String tables) {
		List<Map<String, Object>> data = service.getColumnByTable(queryModel,tables);
		return new ResultDto<List<Map<String, Object>>>(data);
	}
}
