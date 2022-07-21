package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.service.YscimcFieldRtAccessService;
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
 * @date 2022/4/12 - 16:26
 */
@RestController
@RequestMapping("/api/yscimcfieldrtaccess")
public class YscimcFieldRtAccessResource {
    private final YscimcFieldRtAccessService service;

    public YscimcFieldRtAccessResource(YscimcFieldRtAccessService service) {
        this.service = service;
    }
    @GetMapping("/getfieldrtaccess")
    public ResultDto<List<String>> getfieldrtaccess(String activityId, String dateString, String timeArr){
        List<String> list = new LinkedList();
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        list.add(0,service.getfieldrtaccess(activityId, date, timeArr));
        list.add(1,service.getfieldrtaccess(activityId, date.plusDays(-1), timeArr));
        return new ResultDto<>(list);
    }
}
