package cn.com.yusys.yscrm.product.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.product.domain.AcrmApdBusiSum;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmApdBusiSumMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-13 10:59:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmApdBusiSumMapper extends CommonMapper<AcrmApdBusiSum> {
	/**
	* @方法名称: numberOfCustQuery
	* @方法描述: 持有产品客户数量趋势
	* @算法描述:
	 */
	String[] getXaxisArray(@Param("prodId") String prodId);
	List<Map<String,Object>> getPerCustAum(@Param("prodId") String prodId);
}