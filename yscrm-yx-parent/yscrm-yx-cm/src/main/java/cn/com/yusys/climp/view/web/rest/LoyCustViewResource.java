package cn.com.yusys.climp.view.web.rest;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.view.domain.LoyCmCustInfo;
import cn.com.yusys.climp.view.service.LoyCustViewService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * 
 * @项目名称：yusp-climp-view-core
 * @类名称：LoyCustViewResource
 * @类描述：
 * @功能描述:客户视图resource
 * @创建人：hujun3@yusys.com.cn
 * @创建时间：2018年12月28日
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 2.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/custview")
public class LoyCustViewResource extends CommonResource<LoyCmCustInfo, String> {

	private Logger logger = LoggerFactory.getLogger(LoyCustViewResource.class);
	
	@Autowired
	private LoyCustViewService service;

	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}

	/**
	 * 
	* @方法名称: getCustBaseInfo
	* @方法描述: 查询客户基本信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/custbaseinfo")
	public ResultDto<Map<String, Object>> getCustBaseInfo(String custId) {
		ResultDto<Map<String, Object>> reuslt=new ResultDto<Map<String, Object>>();
		try {
			List<Map<String, Object>> data=service.getCustInfo(custId);
			if(data.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				Map<String, Object> list = data.get(0);
				reuslt.setData(list);
			}
			logger.info("查询客户基本信息");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getCustScoreInfo
	* @方法描述: 查询客户综合积分信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/custinteginfo")
	public ResultDto<List<Map<String, Object>>> getCustScoreInfo(String custId) {
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = service.queryScoretByCust(custId);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(list);
			}
			logger.info("查询客户基本信息");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getCustAccountInfo
	* @方法描述: 客户积分账户信息查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/custaccountinfo")
	public ResultDto<List<Map<String, Object>>> getCustAccountInfo(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = service.queryCustAccountByPage(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(list);
			}
			logger.info("客户信息分页查询");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getCustAccountDetail
	* @方法描述: 客户积分账户交易明细查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/custaccountdetail")
	public ResultDto<List<Map<String, Object>>> getCustAccountDetail(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = service.queryAccountDetailByPage(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(list);
			}
			logger.info("客户信息分页查询");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getCustAddScoreInfo
	* @方法描述:页客户积分加分查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/addintegdetail")
	public ResultDto<List<Map<String, Object>>> getCustAddScoreInfo(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = service.queryAddScoreByPage(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(list);
			}
			logger.info("客户积分加分信息分页查询");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getCustSubScoreInfo
	* @方法描述: 客户积分减分查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/subintegdetail")
	public ResultDto<List<Map<String, Object>>> getCustSubScoreInfo(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = service.querySubScoreByPage(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(list);
			}
			logger.info("客户积分减分信息分页查询");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getOrigTransInfo
	* @方法描述: 客户原始交易查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/originaltransinfo")
	public ResultDto<List<Map<String, Object>>> getOrigTransInfo(QueryModel queryModel) {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = service.queryOrigTransByPage(queryModel);
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt=new ResultDto<List<Map<String, Object>>>(list);
			}
			logger.info("客户原始交易分页查询");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getOrigTransDetail
	* @方法描述: 客户原始交易明细
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/originaltransdetail")
	public ResultDto<Map<String, Object>> getOrigTransDetail(@RequestParam("consumerSeqNo") String consumerSeqNo,@RequestParam("sourceTable") String sourceTable) {
		
		ResultDto<Map<String, Object>> reuslt=new ResultDto<Map<String, Object>>();
		try {
			List<Map<String, Object>> data=service.queryOrigTransDetail(consumerSeqNo,sourceTable);
			if(data.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				Map<String, Object> list = data.get(0);
				reuslt.setData(list);
			}
			logger.info("查询客户原始交易明细信息");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
	/**
	 * 
	* @方法名称: getTableAndColumn
	* @方法描述: 查询表格和字段配置信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/querytableandcolumn")
	public ResultDto<List<Map<String, Object>>> getTableAndColumn() {
		
		ResultDto<List<Map<String, Object>>> reuslt=new ResultDto<List<Map<String, Object>>>();
		try {
			List<Map<String, Object>> list = service.queryTableAndColumn();
			if(list.isEmpty()) {
				reuslt.setCode(200001);
				reuslt.setMessage("noData");
			}else {
				reuslt.setData(list);
			}
			logger.info("查询表格和字段配置信息");
		}catch (Exception e) {
			e.printStackTrace();
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
	}
}
