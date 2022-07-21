package cn.com.yusys.yusp.cm.productmanager.web.rest;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProdCatlInfo;
import cn.com.yusys.yusp.cm.productmanager.service.CmFRcProdCatlService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcProductManagerResource
 * @类描述: 产品管理接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-08 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcprodcatl")
public class CmFRcProdCatlResource extends CommonResource<CmFRcProdCatlInfo, Serializable>{

	@Autowired
	private CmFRcProdCatlService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	/**
	* @方法名称: getList
	* @方法描述: 查询产品类别表
	* @参数与返回说明: 
	* @算法描述:
	**/
	@GetMapping("/list")
	public ResultDto<List<CmFRcProdCatlInfo>> getList() {
		return this.service.getList();
	}
	/**
	* @throws ParseException 
	* @方法名称: insertList
	* @方法描述: 新增产品类别
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/insertlist")
	public ResultDto<Integer> insertList(@RequestBody CmFRcProdCatlInfo record) throws ParseException {
		return this.service.insertList(record);
	}
	/**
	* @throws ParseException 
	* @方法名称: updateList
	* @方法描述: 更新产品类别
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/updatelist")
	public ResultDto<Integer> updateList(@RequestBody CmFRcProdCatlInfo record) throws ParseException {
		return this.service.updateList(record);
	}
	/**
	* @throws  
	* @方法名称: deleteList
	* @方法描述: 删除产品类别
	* @参数与返回说明: 
	* @算法描述:
	**/
	@PostMapping("/deletelist")
	public ResultDto<Integer> deleteList(@RequestBody CmFRcProdCatlInfo record) {
		return this.service.deleteList(record);
	}
}
