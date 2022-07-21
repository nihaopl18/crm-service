package cn.com.yusys.yscrm.sysview.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewContr;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewContrMapper
 * @类描述: 视图控制点
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:50:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFsysViewContrMapper extends CommonMapper<OcrmFsysViewContr> {
	List<Map<String, Object>> ifCodeRepeat(Map<?, ?> map);
	List<Map<String, Object>> getContrInfo(QueryModel model);
	List<Map<String, Object>> getViewTree(QueryModel model);
}