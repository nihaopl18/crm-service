package cn.com.yusys.climp.view.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.view.repository.mapper.LoyCustViewMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * 
 * @项目名称：yusp-climp-view-core
 * @类名称：LoyCustViewService
 * @类描述：
 * @功能描述:客户视图service
 * @创建人：hujun3@yusys.com.cn
 * @创建时间：2018年12月28日
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 2.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class LoyCustViewService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(LoyCustViewService.class);
	@Autowired
	private LoyCustViewMapper mapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return this.mapper;
	}
	
	/**
	 * 
	* @方法名称: getCustInfo
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> getCustInfo(String custId){
		
		List<Map<String, Object>> result=this.mapper.getCustInfo(custId);
		PageHelper.clearPage();
		logger.info("客户信息分页查询");
		return result;
	}
	/**
	 * 
	* @方法名称: queryScoretByCust
	* @方法描述: 查询客户综合积分信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryScoretByCust(String custId){
		List<Map<String, Object>> result=this.mapper.queryScoretByCust(custId);
		PageHelper.clearPage();
		logger.info("客户综合积分信息分页查询");
		return result;
	}
	/**
	 * 
	* @方法名称: queryCustAccountByPage
	* @方法描述: 查询客户积分账户信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryCustAccountByPage(QueryModel param){
		PageHelper.startPage(param.getPage(), param.getSize());
		List<Map<String, Object>> result=this.mapper.queryCustAccountByPage(param);
		PageHelper.clearPage();
		logger.info("客户账户分页查询");
		return result;
	}
	/**
	 * 
	* @方法名称: queryAccountDetailByPage
	* @方法描述: 查询客户积分账户交易明细信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryAccountDetailByPage(QueryModel param){
		PageHelper.startPage(param.getPage(), param.getSize());
		List<Map<String, Object>> result=this.mapper.queryAccountDetailByPage(param);
		PageHelper.clearPage();
		logger.info("客户账户分页交易明细查询");
		return result;
	}
	/**
	 * 
	* @方法名称: queryAddScoreByPage
	* @方法描述: 查询客户积分加分信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryAddScoreByPage(QueryModel param){
		PageHelper.startPage(param.getPage(), param.getSize());
		param.setSort("t3.TRANS_DATE desc");
		List<Map<String, Object>> result=this.mapper.queryAddScoreByPage(param);
		PageHelper.clearPage();
		logger.info("客户加分信息分页查询");
		return result;
	}
	/**
	 * 
	* @方法名称: querySubScoreByPage
	* @方法描述: 查询客户积分减分信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> querySubScoreByPage(QueryModel param){
		PageHelper.startPage(param.getPage(), param.getSize());
		List<Map<String, Object>> result=this.mapper.querySubScoreByPage(param);
		PageHelper.clearPage();
		logger.info("客户减分信息分页查询");
		return result;
	}
	/**
	 * 
	* @方法名称: queryOrigTransByPage
	* @方法描述: 客户原始交易查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryOrigTransByPage(QueryModel param){
		PageHelper.startPage(param.getPage(), param.getSize());
		List<Map<String, Object>> result=this.mapper.queryOrigTransByPage(param);
		PageHelper.clearPage();
		logger.info("客户原始交易分页查询");
		return result;
	}
	/**
	 * 
	* @方法名称: queryOrigTransDetail
	* @方法描述: 客户交易明细查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryOrigTransDetail(String consumerSeqNo,String sourceTable){
		Map<String,String> param=new HashMap<String,String>();
		param.put("consumerSeqNo", consumerSeqNo);
		param.put("sourceTable", sourceTable);
		List<Map<String, Object>> result=this.mapper.queryOrigTransDetail(param);
		logger.info("客户交易明细查询");
		return result;
	}
	/**
	 * 
	* @方法名称: queryTableAndColumn
	* @方法描述: 查询待积流水表表名和字段信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryTableAndColumn(){
		
		//查询待积流水表表名 
		List<Map<String, Object>> result=this.mapper.queryTableInfo();
		for(int i=0;i<result.size();i++) {
			Map<String, Object> table=result.get(i);
			Map<String,String> param=new HashMap<String,String>();
			param.put("tableId", table.get("tableId").toString());
			List<Map<String, Object>> data=this.mapper.queryColumnByTable(param);
			table.put("columns", data);
		}
		logger.info("查询待积流水表表名和字段信息");
		return result;
	}
}
