package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.service.YscimcRightDistributionTrendService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/13 - 11:14
 */
@RestController
@RequestMapping("/api/yscimcrightdistributiontrend")
public class YscimcRightDistributionTrendResource {
    private final YscimcRightDistributionTrendService service;

    public YscimcRightDistributionTrendResource(YscimcRightDistributionTrendService service) {
        this.service = service;
    }
    @GetMapping("/getrightdistributiontrend")
    public ResultDto<List<String>> getRightDistributionTrend(String activityId, String dateString, String timeArr){
        List<String> list = new LinkedList();
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        list.add(0,service.getRightDistributionTrend(activityId, date, timeArr));
        list.add(1,service.getRightDistributionTrend(activityId, date.plusDays(-1), timeArr));
        return new ResultDto<>(list);
    }
}
