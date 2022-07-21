package cn.com.yusys.yscimc.marketmethod.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscimc.marketmethod.domain.CmicAppClickInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscimc-cust-group模块
 * @类名称: CmicAppClickInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-06-15 16:19:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CmicAppClickInfoMapper extends CommonMapper<CmicAppClickInfo> {

	int getClickNumByRecommenderId(String recommenderId);

	List<Map<String, Object>> getClickNum(QueryModel model);
	
}