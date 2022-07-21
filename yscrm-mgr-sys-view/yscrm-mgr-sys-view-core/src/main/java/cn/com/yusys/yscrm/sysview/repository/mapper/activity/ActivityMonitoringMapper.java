package cn.com.yusys.yscrm.sysview.repository.mapper.activity;

import cn.com.yusys.yscrm.sysview.domain.activity.TodoWorkSRC;
import cn.com.yusys.yscrm.sysview.domain.activity.ActiveIndex;
import cn.com.yusys.yscrm.sysview.domain.activity.*;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface ActivityMonitoringMapper {
    /**
     * 分行管户
     *
     * @return
     */
    List<BelongInfo> branchBelong(Map<String, Object> map);

    /**
     * 支行管户
     *
     * @return
     */
    List<BelongInfo> subBranchBelong(Map<String, Object> map);

    /**
     * 团队长管户
     * @param map
     * @return
     */
    List<BelongInfo> teamBelong(Map<String, Object> map);

    /**
     * 客户经理数
     *
     * @return
     */
    Integer custManagerNum(Map<String, Object> map);

    /**
     *  活动数据接触客户人数
     * @param map
     * @return
     */
    Integer dataTouchCustCount(Map<String, Object> map);

    Integer workReportCount(Map<String, Object> map);


    Integer changeCount(Map<String, Object> map);

    Integer todoWorkCount(Map<String, Object> map);

    List<ChangeRemindInfo> changeRemindInfo(Map<String, Object> map);

    List<TodoWork> todoWork(Map<String, Object> map);

    List<TodoWorkExcel> todoWorkSonExcel(Map<String, Object> queryMap);

    List<TodoWorkInfo> todoWorkInfo(Map<String, Object> map);

    List<TodoWorkInfo> todoWorkDetail(Map<String, Object> map);

    /**
     * 支行跟进率
     *
     * @param map
     * @return
     */
    List<TodoWorkRate> subBranchTodoWorkRate(Map<String, Object> map);

    List<TodoWorkRate> subBranchTodoWorkSonRate(Map<String, Object> queryMap);

    List<WorkReportInfo> workReportInfo(Map<String, Object> map);

    /**
     * 获取团队用户id
     *
     * @param map
     * @return
     */
    Integer getTeamUserId(Map<String, Object> map);

	Integer todoWorkSonCount(Map<String, Object> queryMap);

	ActiveIndex loanAvgCust(Map<String, Object> queryMap);

	ActiveIndex financingAvgCust(Map<String, Object> queryMap);

    ActiveIndex teamAvgCust(Map<String, Object> queryMap);

    ActiveIndex allAvgCust(Map<String, Object> queryMap);

	List<TodoWorkInfo> todoWorkSonDetail(Map<String, Object> queryMap);

    List<TodoWorkSRC> todoWorkTotal(Map<String, Object> queryMap);

    List<TodoWorkSRC> todoWorkSonTotal(Map<String, Object> queryMap);

    List<ChangeRemindSRC> changeRemindTotal(Map<String, Object> queryMap);

    List<WorkReportSRC> workReportTotal(Map<String, Object> queryMap);

    List<TouchSRC> touchTotal(Map<String, Object> queryMap);
}
