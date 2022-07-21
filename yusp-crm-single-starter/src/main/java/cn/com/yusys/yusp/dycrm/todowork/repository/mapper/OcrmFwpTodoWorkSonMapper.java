package cn.com.yusys.yusp.dycrm.todowork.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWorkSon;

/**
 * @项目名称: dycrm-todowork模块
 * @类名称: OcrmFwpWTodoWorkMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:32:24
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpTodoWorkSonMapper extends CommonMapper<OcrmFwpTodoWorkSon> {

	List<Map<String, Object>> queryByToDoWorkId(QueryModel queryModel);

	List<Map<String, Object>> queryStartDate(@Param("noticeId") String noticeId);

	int updateByTodoWorkId(OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon);

	int deleteByNoticeId(Map<String, Object> map);

	List<OcrmFwpTodoWorkSon> queryState(@Param("noticeIds") List<String> noticeId);

	int updateToDoWorkState(Map<String, Object> map);

	int deleteByTodoWorkId(Map<String, Object> map);

	List<String> queryNoticeId(@Param("todoWorkIds") List<String> todoWorkId);

	int querySon(@Param("noticeId") String noticeId);

	int updateSon(OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon);

	int updateSons(OcrmFwpTodoWorkSon ocrmFwpTodoWorkSon);

	int queryNotice(@Param("noticeId") String noticeId);

	List<OcrmFwpTodoWorkSon> listConTactByTodoWorkIds(Map<String, Object> map);
}