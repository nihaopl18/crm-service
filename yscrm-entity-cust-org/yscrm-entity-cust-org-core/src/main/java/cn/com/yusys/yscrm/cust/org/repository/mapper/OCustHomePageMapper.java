package cn.com.yusys.yscrm.cust.org.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgHoldPro;

/**
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgHoldProMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-22 14:59:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OCustHomePageMapper extends CommonMapper<AcrmFciOrgHoldPro> {
	List<Map<String, Object>> queryOProductTagList(Map<?, ?> param);
	String[] getBussXaxisArray(@Param("custId") String custId);
	List<Map<String,Object>> getOrgBussSumList(@Param("custId") String custId);
	
	String[] getBussMonXaxisArray(@Param("custId") String custId);
	List<Map<String,Object>> getOrgBussMonSumList(@Param("custId") String custId);
	
	List<Map<String, Object>> queryOrgReportList(Map<?, ?> param);
}