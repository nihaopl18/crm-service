package cn.com.yusys.yscrm.cust.org.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgFinItem;

/**
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgFinItemMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 10:55:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFciOrgFinItemMapper extends CommonMapper<AcrmFciOrgFinItem> {
	List<Map<String, Object>> queryList(@Param("reportId") String reportId);
}