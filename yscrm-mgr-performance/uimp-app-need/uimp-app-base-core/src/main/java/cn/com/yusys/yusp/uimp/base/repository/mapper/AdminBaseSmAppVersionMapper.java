package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseSmAppVersion;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: AdminBaseSmAppVersionMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-01-15 17:30:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AdminBaseSmAppVersionMapper extends CommonMapper<AdminBaseSmAppVersion> {
	List<Map<String, Object>> queryList(QueryModel model);
}