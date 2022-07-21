package cn.com.yusys.yscrm.custmgr.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custmgr.domain.OcrmFcmCustMgrQuitApply;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFcmCustMgrQuitApplyMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-28 14:26:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFcmCustMgrQuitApplyMapper extends CommonMapper<OcrmFcmCustMgrQuitApply> {
	
	public void insertCustMgrQuitApply(OcrmFcmCustMgrQuitApply apply);
	
	List<Map<String, Object>> queryQuitCustMgrApply(@Param("id") String id);
	
	public void custMgrQuitSubmit(@Param("bizSeqNo") String bizSeqNo);
	
	public void custMgrQuitPass(@Param("bizSeqNo") String bizSeqNo);
	
	public void custMgrQuitRefuse(@Param("bizSeqNo") String bizSeqNo);
	
	public void updateCustMgrBelongInfo(@Param("mgrId") String mgrId,@Param("operId") String operId,@Param("operOrgId") String operOrgId,@Param("vMgrId") String vMgrId,@Param("vMgrName") String vMgrName);
	
	public void deleteCustMgrInfo(@Param("mgrId") String mgrId);
}