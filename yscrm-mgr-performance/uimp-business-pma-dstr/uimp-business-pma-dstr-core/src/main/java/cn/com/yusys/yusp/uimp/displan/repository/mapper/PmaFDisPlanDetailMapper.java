package cn.com.yusys.yusp.uimp.displan.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.displan.domain.PmaFDisPlanDetail;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDisPlanDetailMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-03-26 10:16:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFDisPlanDetailMapper extends CommonMapper<PmaFDisPlanDetail> {

	List<Map<String, Object>> listByModel(QueryModel model);

	void deleteSql(@Param("bussType") String bussType, @Param("orgNo") String orgNo);
	
}