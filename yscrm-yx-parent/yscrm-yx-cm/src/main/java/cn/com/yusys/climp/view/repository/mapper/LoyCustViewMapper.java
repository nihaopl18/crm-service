package cn.com.yusys.climp.view.repository.mapper;

import cn.com.yusys.climp.view.domain.LoyCmCustInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

/**
 * 
 * @项目名称：yusp-climp-view-core
 * @类名称：LoyCustViewMapper
 * @类描述：
 * @功能描述:客户视图mapper
 * @创建人：hujun3@yusys.com.cn
 * @创建时间：2018年12月28日
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 2.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface LoyCustViewMapper extends CommonMapper<LoyCmCustInfo> {

	/**
	 * 
	* @方法名称: getCustInfo
	* @方法描述: 获取客户基本信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> getCustInfo(@Param("custId")String custId);
	/**
	 * 
	* @方法名称: queryScoretByCust
	* @方法描述: 获取客户综合积分信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryScoretByCust(@Param("custId")String custId);
	/**
	 * 
	* @方法名称: queryCustAccountByPage
	* @方法描述: 分页查询客户账户信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryCustAccountByPage(QueryModel param);
	/**
	 * 
	* @方法名称: queryAccountDetailByPage
	* @方法描述: 分页查询客户账户交易明细信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryAccountDetailByPage(QueryModel param);
	/**
	 * 
	* @方法名称: queryAddScoreByPage
	* @方法描述: 分页查询客户加分信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryAddScoreByPage(QueryModel param);
	/**
	 * 
	* @方法名称: querySubScoreByPage
	* @方法描述: 分页查询客户减分信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> querySubScoreByPage(QueryModel param);
	/**
	 * 
	* @方法名称: queryOrigTransByPage
	* @方法描述: 客户原始交易分页信息查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryOrigTransByPage(QueryModel param);
	/**
	 * 
	* @方法名称: queryOrigTransDetail
	* @方法描述: 原始交易明细查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryOrigTransDetail(Map<String,String> param);
	/**
	 * 
	* @方法名称: queryTableInfo
	* @方法描述: 查询待积流水表表名 
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryTableInfo();
	
	/**
	 * 
	* @方法名称: queryColumnByTable
	* @方法描述: 原始交易明细查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryColumnByTable(Map<String,String> param);

	

}
