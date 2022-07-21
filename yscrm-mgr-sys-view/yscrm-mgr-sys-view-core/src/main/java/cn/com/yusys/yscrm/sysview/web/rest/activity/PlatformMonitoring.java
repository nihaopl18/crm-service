package cn.com.yusys.yscrm.sysview.web.rest.activity;

import cn.com.yusys.yscrm.sysview.domain.TagAnalysisQuery;
import cn.com.yusys.yscrm.sysview.domain.activity.FunModuleStatsVO;
import cn.com.yusys.yscrm.sysview.domain.activity.LineChart;
import cn.com.yusys.yscrm.sysview.domain.activity.OrgMAUProportion;
import cn.com.yusys.yscrm.sysview.domain.activity.SystemUseInfoVO;
import cn.com.yusys.yscrm.sysview.service.activity.PlatformMonitoringService;
import cn.com.yusys.yscrm.sysview.web.rest.AcrmAbrBusiSumInfoResource;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 平台运营监测
 *
 * @author: sxm
 * @time: 2021/9/13 10:44
 */
@RestController
@RequestMapping("/api/plfmonitoring")
public class PlatformMonitoring {
    @Autowired
    private PlatformMonitoringService platformMonitoringService;
    private final Logger log = LoggerFactory.getLogger(PlatformMonitoring.class);
    /**
     * 功能模块统计
     *
     * @return
     */
    @GetMapping("/funmodulestats")
    public ResultDto<List<FunModuleStatsVO>> funModuleStats(TagAnalysisQuery tagAnalysisQuery) {
        return new ResultDto<List<FunModuleStatsVO>>(platformMonitoringService.funModuleStats(tagAnalysisQuery));
    }

    /**
     * 近一月系统使用情况概览
     *
     * @return
     */
    @GetMapping("/systemuseinfo")
    public ResultDto<SystemUseInfoVO> systemUseInfo() {
        return new ResultDto<SystemUseInfoVO>(platformMonitoringService.systemUseInfo());
    }

    /**
     * 近一年全行MAU波动
     *
     * @return
     */
    @GetMapping("/mauflct")
    public ResultDto<List<LineChart>> MAUFluctuation() {
        return new ResultDto<List<LineChart>>(platformMonitoringService.getMAUFlct());
    }

    /**
     * 机构月活用户占比
     *
     * @return
     */
    @GetMapping("/orgmauproportion")
    public ResultDto<Map<String,List<OrgMAUProportion>>> orgMAUProportion() {
        return new ResultDto<Map<String,List<OrgMAUProportion>>>(platformMonitoringService.orgMAUProportion());
    }

    /**
     * 导出
     *
     * @param
     */
    @GetMapping("/export")
    @ResponseBody
    public void daochuStatisticToExcel(HttpServletResponse response,TagAnalysisQuery tagAnalysisQuery) {
        try {
            platformMonitoringService.export(response,tagAnalysisQuery);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }

    /**
     * 导出未登录用户
     *
     * @param
     */
    @GetMapping("/exportNoLoginUser")
    @ResponseBody
    public void exportNoLoginUser(HttpServletResponse response) {
        try {
            platformMonitoringService.exportNoLoginUser(response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }
}
