package cn.com.yusys.yusp.uimp.business.pma.coefficient.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.coefficient.domain.PmaFCoefficient;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFCoefficientMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-14 10:20:52
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFCoefficientMapper extends CommonMapper<PmaFCoefficient> {

	List<Map<String, Object>> querylist(QueryModel model);

	void deleteData(PmaFCoefficient pmaFCoefficient);

	String selectCount(QueryModel modelNew);
	
}