package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.service.YscimcPageRtAccessService;
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
 * @date 2022/4/12 - 10:48
 */
@RestController
@RequestMapping("/api/yscimcpagertaccess")
public class YscimcPageRtAccessResource {
    private final YscimcPageRtAccessService service;

    public YscimcPageRtAccessResource(YscimcPageRtAccessService service) {
        this.service = service;
    }

    @GetMapping("/getpagertaccess")
    public ResultDto<List<String>> getpagertaccess(String activityId,String dateString,String timeArr){
        List<String> list = new LinkedList();
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        list.add(0,service.getpagertaccess(activityId, date, timeArr));
        list.add(1,service.getpagertaccess(activityId, date.plusDays(-1), timeArr));
        return new ResultDto<>(list);
    }
}
