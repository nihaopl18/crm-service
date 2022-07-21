package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.service.YscimcChannelRtAccessService;
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
 * @date 2022/4/12 - 14:47
 */
@RestController
@RequestMapping("/api/yscimcchannelrtaccess")
public class YscimcChannelRtAccessResource {
    private final YscimcChannelRtAccessService service;

    public YscimcChannelRtAccessResource(YscimcChannelRtAccessService service) {
        this.service = service;
    }
    @GetMapping("/getchannelrtaccess")
    public ResultDto<List<String>> getchannelrtaccess(String activityId, String dateString, String timeArr){
        List<String> list = new LinkedList();
        LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        list.add(0,service.getchannelrtaccess(activityId, date, timeArr));
        list.add(1,service.getchannelrtaccess(activityId, date.plusDays(-1), timeArr));
        return new ResultDto<>(list);
    }
}
