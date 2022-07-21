package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciNoadmitBelong;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciNoadmitBelongMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-28 09:57:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciNoadmitBelongMapper extends CommonMapper<OcrmFciNoadmitBelong> {

	int updateHost(Map<String, String> map);

	int delBelongByCustIdMgrIdOrgId(Map<String, String> map);

	void updateOrgByCustid(OcrmFciNoadmitBelong ocrmFciNoadmitBelong);

	void updateByCustid(OcrmFciNoadmitBelong ocrmFciNoadmitBelong);

	void deleteByCustId(Map<String, Object> params);

	void deletemgrByCustId(Map<String, Object> params);

	List<Map<String, Object>> qryOrgId(String custId);

	List<Map<String, Object>> qryMgrId(String custId);

	String getBelongOrgIdByCustId(String custId);

	void deletemgrByCustId1(Map<String, Object> params);
	
}