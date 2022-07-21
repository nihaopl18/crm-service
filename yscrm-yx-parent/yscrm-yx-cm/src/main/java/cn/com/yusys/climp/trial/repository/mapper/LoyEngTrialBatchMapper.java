package cn.com.yusys.climp.trial.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.trial.domain.LoyEngTrialBatch;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-climp-trial模块
 * @类名称: LoyEngTrialBatchMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hujun
 * @创建时间: 2019-01-03 16:49:16
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyEngTrialBatchMapper extends CommonMapper<LoyEngTrialBatch> {
	/**
	 * 
	* @方法名称: queryTrialBatchByPage
	* @方法描述: 查询试算批次信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryTrialBatchByPage(QueryModel param);
	
	/**
	 * 
	* @方法名称: queryTrialBatchByBno
	* @方法描述: 根据批次号查询试算批次信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	LoyEngTrialBatch queryTrialBatchByBno(Map<String,String> param);
	
	/**
	 * 
	* @方法名称: updateTrialBatchByBno
	* @方法描述: 更新试算状态
	* @参数与返回说明: 
	* @算法描述:
	 */
	int updateTrialBatchByBno(Map<String,String> param);
	/**
	 * 
	* @方法名称: deleteTrialRount
	* @方法描述: 清空试算路由表
	* @参数与返回说明: 
	* @算法描述:
	 */
	int deleteTrialRount();
	/**
	 * 
	* @方法名称: deleteTrialBatch
	* @方法描述: 清空试算路由表
	* @参数与返回说明: 
	* @算法描述:
	 */
	int deleteTrialBatch(Map<String,String> param);
	
	/**
	 * 
	* @方法名称: addTrialRount
	* @方法描述: 新增试算路由信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	int addTrialRount(Map<String,String> param);
	/**
	 * 
	* @方法名称: queryOrgReport
	* @方法描述: 查询机构汇总信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryOrgReport(QueryModel param);
	/**
	 * 
	* @方法名称: queryProdReport
	* @方法描述: 查询产品汇总信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryProdReport(QueryModel param);
	/**
	 * 
	* @方法名称: queryOrgProdReport
	* @方法描述: 查询产品和机构汇总信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryOrgProdReport(QueryModel param);
	/**
	 * 
	* @方法名称: queryTransactionCode
	* @方法描述: 查询交易类型数据
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryTransactionCode();
	/**
	 * 
	* @方法名称: queryPropInfo
	* @方法描述: 查询系统参数信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryPropInfo(Map<String,String> param);
	/**
	 * 
	* @方法名称: queryTrialBatchNow
	* @方法描述: 查询未完成的试算批次信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryTrialBatchNow();
	
	
	
}