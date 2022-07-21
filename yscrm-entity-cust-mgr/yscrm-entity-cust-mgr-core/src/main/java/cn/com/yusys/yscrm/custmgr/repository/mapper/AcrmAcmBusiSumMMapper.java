package cn.com.yusys.yscrm.custmgr.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custmgr.domain.AcrmAcmBusiSumM;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmBusiSumMMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 14:11:40
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmAcmBusiSumMMapper extends CommonMapper<AcrmAcmBusiSumM> {
	String[] getXaxisArray(@Param("mgrId") String mgrId);
	String[] getXaxisArrayPer(@Param("mgrId") String mgrId);
	String[] getXaxisArrayOrg(@Param("mgrId") String mgrId);
	List<Map<String,Object>> getPerCustAum(@Param("mgrId") String mgrId);
	List<Map<String,Object>> getOrgCustAum(@Param("mgrId") String mgrId);
	List<Map<String,Object>> getPerCustLoanBal(@Param("mgrId") String mgrId);
	List<Map<String,Object>> getOrgCustLoanBal(@Param("mgrId") String mgrId);
	List<Map<String,Object>> getCustAumBal(@Param("mgrId") String mgrId);
	List<Map<String,Object>> getCustLoanBal(@Param("mgrId") String mgrId);
}