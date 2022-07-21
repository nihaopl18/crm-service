package cn.com.yusys.yusp.cm.market.repository.mapper;

import cn.com.yusys.yusp.cm.market.domain.YscimcFMkActiShare;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;

/**
 * @项目名称: yscimc-cust-group模块
 * @类名称: YscimcFmkActiFissionMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-06-12 09:35:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface YscimcFmkActiShareMapper extends CommonMapper<YscimcFMkActiShare> {

	YscimcFMkActiShare getListById(String id);
	int delByNodeId(String nodeId);

    List<YscimcFMkActiShare> getInfoByIds(List<String> shareIds);

    String hasId(String nodeId);
}