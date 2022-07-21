package cn.com.yusys.yscrm.custmgr.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custmgr.domain.AcrmFcmCustMgrInfo;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmFcmCustMgrInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: luhy1@yusys.com.cn
 * @创建时间: 2019-01-28 17:33:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CustMgrQueryMapper extends CommonMapper<AcrmFcmCustMgrInfo> {
	List<Map<String, Object>> queryCustMgrList(QueryModel queryModel);
	List<Map<String, Object>> checkCustMgrApply(@Param("mgrId") String mgrId);
	String queryUserBusiType(@Param("loginCode") String loginCode);
	List<Map<String,String>> queryOrgId(@Param("orgId") String orgId);
}