package cn.com.yusys.yscrm.sysview.repository.mapper;

import java.util.List;
import java.util.Map;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysView;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewMapper
 * @类描述: 视图
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-16 19:38:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFsysViewMapper extends CommonMapper<OcrmFsysView> {
	List<Map<String, Object>> getViewlist(QueryModel model);
	List<Map<String,Object>> checkName(Map<?, ?> map);
	int getItemByViewId(String viewId);
}