package cn.com.yusys.climp.acty.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.acty.domain.LoyRlScoreProject;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlScoreProjectMapper
 * @类描述: 积分活动分类Dao类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:40:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyRlScoreProjectMapper extends CommonMapper<LoyRlScoreProject> {
	/**
	 * 查询积分活动分类
	 */
	List<LoyRlScoreProject> getScoreProject(QueryModel model);
	/**
	 * 逻辑删除积分活动分类
	 * @param map
	 * @return
	 */
	int updataScoreProjectState(Map<String,String> map);
}