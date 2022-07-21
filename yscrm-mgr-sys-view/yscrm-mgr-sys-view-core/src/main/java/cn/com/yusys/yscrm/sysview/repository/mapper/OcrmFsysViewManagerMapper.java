package cn.com.yusys.yscrm.sysview.repository.mapper;

import java.util.List;
import java.util.Map;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewManager;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewManagerMapper
 * @类描述: 树图树
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:50:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFsysViewManagerMapper extends CommonMapper<OcrmFsysViewManager> {
	 List<Map<String, Object>> getSysViewTree(String sysId);
	 List<Map<String, Object>> getListInfo(QueryModel model);
	 Map<String, Object> getViewInfo(String id); 
	 List<String> getDeleteMenuId(String id);
}