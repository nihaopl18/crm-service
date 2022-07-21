package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFDistributionMode;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFDistributionModeMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-23 10:35:54
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFDistributionModeMapper extends CommonMapper<PmaFDistributionMode> {
	List<Map<String,Object>> queryList(QueryModel model);
	int delMode(String brchNo);
}