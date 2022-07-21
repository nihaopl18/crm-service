package cn.com.yusys.yscrm.homepage.repository.mapper;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.homepage.domain.OcrmFsysUserTile;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-sys-homepage-core模块
 * @类名称: OcrmFsysUserTileMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-17 11:35:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFsysUserTileMapper extends CommonMapper<OcrmFsysUserTile> {
	List<Map<Object, String>> getGraphList();

	List<Map<Object, String>> getStyleList();

	int delByUserId(String userid);

	List<Map<Object, String>> getListBySql(@Param(value="sql") String sql);
	
	Map<String, Object> getUserData (String loginCode);
	
	List<Map<String, Object>> getAllUserData (List<String> ids);
	
	Map<String, Object> getUserModel (QueryModel model);

	List<Map<Object, String>> getGraphList(QueryModel model);
}