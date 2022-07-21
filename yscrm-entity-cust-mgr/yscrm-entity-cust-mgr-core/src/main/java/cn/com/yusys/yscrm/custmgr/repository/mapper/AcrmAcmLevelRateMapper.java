package cn.com.yusys.yscrm.custmgr.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custmgr.domain.AcrmAcmLevelRate;

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
public interface AcrmAcmLevelRateMapper extends CommonMapper<AcrmAcmLevelRate> {
	List<Map<String, Object>> queryPerCustGradeDist(@Param("mgrId") String mgrId);
	List<Map<String, Object>> queryOrgCustGradeDist(@Param("mgrId") String mgrId);
}