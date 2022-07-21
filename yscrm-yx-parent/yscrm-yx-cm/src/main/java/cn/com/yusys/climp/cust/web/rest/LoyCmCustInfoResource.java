package cn.com.yusys.climp.cust.web.rest;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.cust.domain.LoyCmCustInfo;
import cn.com.yusys.climp.cust.service.LoyCmCustInfoService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * 
 * @项目名称：yusp-climp-cust-core
 * @类名称：LoyCmCustInfoService
 * @类描述：
 * @功能描述:客户信息resource
 * @创建人：hujun3@yusys.com.cn
 * @创建时间：2018年12月28日
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 2.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/custinfo")
public class LoyCmCustInfoResource extends CommonResource<LoyCmCustInfo, String> {

	private Logger logger = LoggerFactory.getLogger(LoyCmCustInfoResource.class);
	
	@Autowired
	private LoyCmCustInfoService service;

	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}

	/**
	 * 
	* @方法名称: getList
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/query")
	public ResultDto<List<Map<String, Object>>> getList(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			Map<String, Object> list = service.findAllByParam(queryModel);
			List<Map<String, Object>> data=(List<Map<String, Object>>) list.get("data");
			if(data.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(data);
				reuslt.setTotal(Long.parseLong(list.get("total").toString()));
			}
			logger.info("客户信息分页查询");
		}catch (Exception e) {
			logger.error("客户信息分页查询", e);
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e.getMessage());
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getListO
	* @方法描述: 分页查询-积分调整用到
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/queryother")
	public ResultDto<List<Map<String, Object>>> getListO(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			Map<String, Object> list = service.findAllByParamO(queryModel);
			List<Map<String, Object>> data=(List<Map<String, Object>>) list.get("data");
			if(data.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(data);
				reuslt.setTotal(Long.parseLong(list.get("total").toString()));
			}
			logger.info("客户信息选择器分页查询");
		}catch (Exception e) {
			logger.error("客户信息分页查询", e);
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e.getMessage());
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getcust
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/getcust")
	public ResultDto<List<Map<String, Object>>> getCust(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			Map<String, Object> list = service.getCust(queryModel);
			List<Map<String, Object>> data=(List<Map<String, Object>>) list.get("data");
			if(data.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(data);
				reuslt.setTotal(Long.parseLong(list.get("total").toString()));
			}
			logger.info("客户信息分页查询");
		}catch (Exception e) {
			logger.error("客户信息分页查询", e);
			reuslt.setCode(100001);
			reuslt.setMessage("fail:"+e.getMessage());
		}
		return reuslt;
	}
}
