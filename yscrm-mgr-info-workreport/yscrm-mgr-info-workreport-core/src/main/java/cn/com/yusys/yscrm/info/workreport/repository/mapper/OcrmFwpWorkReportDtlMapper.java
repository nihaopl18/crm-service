package cn.com.yusys.yscrm.info.workreport.repository.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.info.workreport.domain.OcrmFwpWorkReportDtl;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yscrm-mgr-info-workreport-core模块
 * @类名称: OcrmFwpWorkReportDtlMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:33:20
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpWorkReportDtlMapper extends CommonMapper<OcrmFwpWorkReportDtl> {
	int insertReportDtl(@Param("reportId") String reportId,@Param("reportCycle") String reportCycle
			,@Param("coreOrgCode") String coreOrgCode,@Param("id") String id);
    
}