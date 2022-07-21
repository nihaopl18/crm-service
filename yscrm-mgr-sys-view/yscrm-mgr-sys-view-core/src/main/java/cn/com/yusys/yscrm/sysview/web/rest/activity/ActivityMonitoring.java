package cn.com.yusys.yscrm.sysview.web.rest.activity;

import cn.com.yusys.yscrm.sysview.domain.TagAnalysisQuery;
import cn.com.yusys.yscrm.sysview.domain.activity.*;
import cn.com.yusys.yscrm.sysview.service.activity.ActivityMonitoringService;
import cn.com.yusys.yscrm.sysview.utils.DateUtils;
import cn.com.yusys.yscrm.sysview.utils.PagesUtils;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 活动量监测
 *
 * @author: sxm
 * @time: 2021/9/16 10:10
 */
@RestController
@RequestMapping("/api/activitymonitoring")
public class ActivityMonitoring {
    @Autowired
    private ActivityMonitoringService activityMonitoringService;

    private final Logger log = LoggerFactory.getLogger(ActivityMonitoring.class);

    /**
     * 活动数据概览
     *
     * @param
     * @return
     */
    @GetMapping("/getTimeBucket")
    public ResultDto<Map<String, Object>> getTimeBucket() {
        Map<String, Object> map = new HashMap<>();
        map.put("startTime", DateUtils.getLastMonthStartTime());
        map.put("endTime", DateUtils.getCurrentDate());
        return new ResultDto<>(map);
    }
    /**
     * 活动数据概览
     *
     * @param
     * @return
     */
    @GetMapping("/dataoverview")
    public ResultDto<Map<String, Object>> dataOverview() {
        return new ResultDto<Map<String, Object>>(activityMonitoringService.dataOverview());
    }

    /**
     * 管户概览
     *
     * @return
     */
    @GetMapping("/belongoverview")
    public ResultDto<List<BelongInfo>> belongOverview(@RequestParam(value = "line", required = false)String line) {
        return new ResultDto<List<BelongInfo>>(activityMonitoringService.belongOverview(line));
    }

    /**
     * 客户经理概览
     *
     */
    @GetMapping("/custmanageroverview")
    public ResultDto<Map<String, Integer>> custManagerOverview(QueryModel queryModel) {
        return new ResultDto(activityMonitoringService.custManagerOverview());
    }

    /**
     * 客户接触情况
     *
     */
    @GetMapping("/touchcustinfo")
    public ResultDto<Map<String, Object>> touchCustInfo(QueryModel queryModel) {
        return new ResultDto<Map<String, Object>>(activityMonitoringService.touchCustInfo(queryModel));
    }

    /**
     * 客户接触情况汇总详情
     */
    @GetMapping("/touchExcel")
    public ResultDto<List<TouchCustInfoExcel>> touchExcel(TagAnalysisQuery tagAnalysisQuery) {
        List<TouchCustInfoExcel> list = activityMonitoringService.touchCustInfoExcel(tagAnalysisQuery);
        List<TouchCustInfoExcel> list1 = PagesUtils.pages(list,tagAnalysisQuery.getPage(),tagAnalysisQuery.getSize());
        return new ResultDto<>(list.size(),list1);
    }

    /**
     * 异动提醒情况汇总
     */
    @GetMapping("/changeremind")
    public ResultDto<Map<String, Object>> changeRemind(QueryModel queryModel) {
        return new ResultDto<Map<String, Object>>(activityMonitoringService.changeRemind(queryModel));
    }

    /**
     * 异动提醒详细信息
     *
     * @param
     * @return
     */
    @GetMapping("/changeremindinfo")
    public ResultDto<List<ChangeRemindInfo>> changeRemindInfo(String typeId) {
        return new ResultDto(activityMonitoringService.changeRemindInfo(typeId));
    }

    /**
     * 异动提醒情况汇总详情
     */
    @GetMapping("/remindExcel")
    public ResultDto<List<ChangeRemindExcel>> remindExcel(TagAnalysisQuery tagAnalysisQuery) {
        List<ChangeRemindExcel> list = activityMonitoringService.changeRemindExcel(tagAnalysisQuery);
        List<ChangeRemindExcel> list1 = PagesUtils.pages(list,tagAnalysisQuery.getPage(),tagAnalysisQuery.getSize());
        return new ResultDto<>(list.size(),list1);
    }

    /**
     * 待办提醒汇总
     */
    @GetMapping("/todowork")
    public ResultDto<Map<String, Object>> todoWork(QueryModel queryModel) {
        return new ResultDto<Map<String, Object>>(activityMonitoringService.todoWork(queryModel));
    }

    /**
     * 待办提醒详细信息
     */
    @GetMapping("/todoworkinfo")
    public ResultDto<List<TodoWorkInfo>> todoWorkInfo(String type) {
        return new ResultDto(activityMonitoringService.todoWorkInfo(type));
    }

    /**
     * 根据机构id、经理id查看待办详情
     *
     * @param
     * @return
     */
    @GetMapping("/todoworkdetail")
    public ResultDto<List> todoWorkDetail(QueryModel queryModel) {
        List list = activityMonitoringService.todoWorkDetail(queryModel);
        List list1 = PagesUtils.pages(list, queryModel.getPage(), queryModel.getSize());
        return new ResultDto(list.size(),list1);
    }

    /**
     * 待办提醒汇总详情
     */
    @GetMapping("/todoWorkExcel")
    public ResultDto<List<TodoWorkExcel>> todoWorkExcel(TagAnalysisQuery tagAnalysisQuery) {
        List<TodoWorkExcel> list = activityMonitoringService.todoWorkExcel(tagAnalysisQuery);
        List<TodoWorkExcel> list1 = PagesUtils.pages(list,tagAnalysisQuery.getPage(),tagAnalysisQuery.getSize());
        return new ResultDto<>(list.size(),list1);
    }

    /**
     * 工作报告情况
     *
     * @param
     * @return
     */
    @GetMapping("/workreport")
    public ResultDto<Map<String, Object>> workReport(QueryModel queryModel) {
        return new ResultDto<Map<String, Object>>(activityMonitoringService.workReport(queryModel));
    }

    /**
     * 工作报告详情
     *
     * @param
     * @return
     */
    @GetMapping("/workreportinfo")
    public ResultDto<List<WorkReportInfo>> workReportInfo(String type) {
        return new ResultDto(activityMonitoringService.workReportInfo(type));
    }

    /**
     * 工作报告情况汇总详情
     */
    @GetMapping("/workReportExcel")
    public ResultDto<List<WorkReportExcel>> workReportExcel(TagAnalysisQuery tagAnalysisQuery) {
        List<WorkReportExcel> list = activityMonitoringService.workReportExcel(tagAnalysisQuery);
        List<WorkReportExcel> list1 = PagesUtils.pages(list, tagAnalysisQuery.getPage(), tagAnalysisQuery.getSize());
        return new ResultDto<>(list.size(),list1);
    }

    /**
     * 导出
     *
     * @param
     */
    @GetMapping("/export")
    @ResponseBody
    public void daochuStatisticToExcel(HttpServletResponse response, TagAnalysisQuery tagAnalysisQuery) {
        try {
            activityMonitoringService.export(response,tagAnalysisQuery);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }
}
