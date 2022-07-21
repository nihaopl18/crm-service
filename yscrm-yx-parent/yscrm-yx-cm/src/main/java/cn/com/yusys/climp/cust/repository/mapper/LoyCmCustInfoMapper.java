package cn.com.yusys.climp.cust.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.score.domain.LoySrScoreCollect;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.cust.domain.LoyCmCustInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * 
 * @项目名称：yusp-climp-cust-core
 * @类名称：LoyCmCustInfoMapper
 * @类描述：
 * @功能描述:客户信息mapper
 * @创建人：hujun3@yusys.com.cn
 * @创建时间：2018年12月28日
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 2.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface LoyCmCustInfoMapper extends CommonMapper<LoyCmCustInfo> {

	/**
	 * 
	* @方法名称: queryCustByPage
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryCustByPage(QueryModel param);
	/**
	 * 
	* @方法名称: queryCustByTotal
	* @方法描述: 查询客户总数
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryCustByTotal(QueryModel param);
	
	/**
	 * 
	* @方法名称: queryCustByPageO
	* @方法描述: 分页查询-积分调整用到
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> queryCustByPageO(QueryModel param);
	
	/**
	 * 
	 * @方法名称: queryCustByTotalO
	 * @方法描述: 查询客户选择器中客户总数
	 * @参数与返回说明: 
	 * @算法描述:
	 */
	List<Map<String, Object>> queryCustByTotalO(QueryModel param);
	/**
	 * 
	* @方法名称: getCust
	* @方法描述: 分页查询
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> getCust(@Param("custId") String custId);

	/**
	 * 查询客户可用积分
	 * @param custNo
	 * @param sumScore
	 * @return
	 */
	Integer getScoreNum(@Param("custNo") String custNo,@Param("sumScore") String sumScore);

	/**
	 * 查询客户可用账户
	 * @param custId
	 * @return
	 */
	List<Map<String,Object>> getUseableAccount(@Param("custId")String custId);
}
