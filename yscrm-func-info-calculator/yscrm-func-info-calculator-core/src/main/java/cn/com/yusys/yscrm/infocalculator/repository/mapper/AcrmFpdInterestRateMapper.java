package cn.com.yusys.yscrm.infocalculator.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.infocalculator.domain.AcrmFpdInterestRate;

/**
 * @项目名称: yscrm-func-info-calculator-core模块
 * @类名称: AcrmFpdInterestRateMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-12 16:07:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFpdInterestRateMapper extends CommonMapper<AcrmFpdInterestRate> {
	List<Map<String, Object>> querylistdep(QueryModel queryModel);
	List<Map<String, Object>> querylistloan(QueryModel queryModel);
}