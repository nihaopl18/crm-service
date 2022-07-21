package cn.com.yusys.climp.cust.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.climp.cust.repository.mapper.LoyCmCustInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * 
 * @项目名称：yusp-climp-cust-core
 * @类名称：LoyCmCustInfoService
 * @类描述：
 * @功能描述:客户信息service
 * @创建人：hujun3@yusys.com.cn
 * @创建时间：2018年12月28日
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 2.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class LoyCmCustInfoService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoyCmCustInfoService.class);
	@Autowired
	private LoyCmCustInfoMapper mapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	
	/**
	 * 
	* @方法名称: findAllByParam
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public Map<String, Object> findAllByParam(QueryModel param){
		// 设置分页查询参数(设置到线程变量中了)
		//PageHelper.startPage(param.getPage(), param.getSize());
		//param.setSort("cust_id desc");
		Map<String,Object> result=new HashMap<String,Object>();
		List<Map<String, Object>> data=this.mapper.queryCustByPage(param);
		List<Map<String, Object>> total=this.mapper.queryCustByTotal(param);
		result.put("data", data);
		result.put("total", total.get(0).get("total"));
		//PageHelper.clearPage();
		logger.info("客户信息分页查询");
		return result;
	}
	/**
	 * 
	* @方法名称: findAllByParamO
	* @方法描述: 分页查询-积分调整用到
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public Map<String, Object> findAllByParamO(QueryModel param){
		//框架自带分页查询效率太低，优化
		//PageHelper.startPage(param.getPage(), param.getSize());
		//param.setSort("cust_id desc");
		Map<String,Object> result=new HashMap<String,Object>();
		if(!param.getCondition().get("transType").equals("6")) {//当调整类型为解冻的时候
			param.getCondition().put("transType", "");
		}
		List<Map<String, Object>> data=this.mapper.queryCustByPageO(param);
		List<Map<String, Object>> total=this.mapper.queryCustByTotalO(param);
		result.put("data", data);
		result.put("total", total.get(0).get("total"));
		//PageHelper.clearPage();
		logger.info("客户选择器信息分页查询");
		return result;
	}
	/**
	 * 
	* @方法名称: getCust
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public Map<String, Object> getCust(QueryModel param){
		// 设置分页查询参数(设置到线程变量中了)
		//PageHelper.startPage(param.getPage(), param.getSize());
		//param.setSort("cust_id desc");
		Map<String,Object> result=new HashMap<String,Object>();
		if(param.getCondition().get("custId") != null || !param.getCondition().get("custId").equals("")) {
			String custId = param.getCondition().get("custId").toString();
			custId = "'" + custId.replaceAll(",", "','") + "'";
			List<Map<String, Object>> data=this.mapper.getCust(custId);
			result.put("data", data);
		} else {
			result.put("data", "");
		}
		List<Map<String, Object>> total=this.mapper.queryCustByTotal(param);
		result.put("total", total.get(0).get("total"));
		//PageHelper.clearPage();
		logger.info("客户信息分页查询");
		return result;
	}
}
