package cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.app.domain.PmaAppMarketActivityInfo;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-app-core模块
 * @类名称: PmaFMarketActivityInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-07-08 14:20:35
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaAppMarketActivityInfoMapper extends CommonMapper<PmaAppMarketActivityInfo> {
	List<Map<String, Object>> querylist(QueryModel model);
}