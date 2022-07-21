package cn.com.yusys.yscrm.cust.person.repository.mapper;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciCommAumContriInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;



/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmLevelRateMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 09:58:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PCustHomePageMapper extends CommonMapper<AcrmFciCommAumContriInfo> {
	List<Map<String, Object>> queryPerAumContriList(Map<?, ?> param);
	List<Map<String, Object>> queryPerReportList(Map<?, ?> param);
	List<Map<String, Object>> queryDiscountList(Map<?, ?> param);
	List<Map<String, Object>> queryProductList(Map<?, ?> param);
	List<Map<String, Object>> queryVisitlist(Map<?, ?> param);
	List<Map<String, Object>> queryProductTagList(Map<?, ?> param);
	
	String[] getXaxisMonArray(@Param("custId") String custId);
	String[] getXaxisArray(@Param("custId") String custId);
	List<Map<String,Object>> queryPerBussMonSum(@Param("custId") String custId);
	List<Map<String,Object>> queryPerBussSum(@Param("custId") String custId);
	List<Map<String, Object>> queryDepLoanFin(Map<?, ?> param);
}