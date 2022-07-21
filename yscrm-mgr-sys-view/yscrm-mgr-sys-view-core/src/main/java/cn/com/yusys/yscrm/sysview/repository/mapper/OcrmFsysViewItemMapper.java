package cn.com.yusys.yscrm.sysview.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewItem;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFsysViewItemMapper
 * @类描述: 视图项
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:47:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFsysViewItemMapper extends CommonMapper<OcrmFsysViewItem> {
	List<Map<String, Object>> getViewItemlist(QueryModel model);
	 List<Map<String,Object>> checkName(Map<?, ?> map);
	 int getContrById(String ids);
	 int getMenuById(String ids);
}