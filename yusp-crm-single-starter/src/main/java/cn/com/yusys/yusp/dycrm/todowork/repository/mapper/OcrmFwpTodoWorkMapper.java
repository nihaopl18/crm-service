package cn.com.yusys.yusp.dycrm.todowork.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.dycrm.todowork.domain.OcrmFwpTodoWork;
import cn.com.yusys.yusp.dycrm.todowork.domain.TodoWorkExcle;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: dycrm-todowork模块
 * @类名称: OcrmFwpWTodoWorkMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:32:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpTodoWorkMapper extends CommonMapper<OcrmFwpTodoWork> {

    List<Map<String, Object>> queryMainlist(QueryModel queryModel);

    int updateOne(OcrmFwpTodoWork ocrmFwpTodoWork);

	List<Map<String, Object>> queryDetail(QueryModel queryModel);
	/**
	 * @description: 根据用户ID查询用户关联角色
	 * @param userId
	 * @author hujun3
	 * @date 2021/09/16 21:45:28
	 **/
	List<Map<String, Object>> getUserRoleInfo(@Param("userId") String userId);

	int updateCyCle(OcrmFwpTodoWork ocrmFwpTodoWork);

	int updateToDoWorkState(Map<String, Object> map);

	int deleteOne(Map<String, Object> map);

	List<Map<String, Object>> indexQuery(QueryModel queryModel);

	Integer selectTodoNum(QueryModel queryModel);
	
	Integer selectReportNum(QueryModel queryModel);

	List<Map<String, Object>> queryFinished(QueryModel queryModel);

	List<TodoWorkExcle> queryOneDetail(QueryModel model);

	List<TodoWorkExcle> queryCycleDetail(QueryModel model);

    List<OcrmFwpTodoWork> listConTactByTodoWorkIds(Map<String, Object> map);
}