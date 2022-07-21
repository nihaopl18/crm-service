package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTrafficStatisticsVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityTrafficStatisticsService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/8 - 14:28
 */
@RestController
@RequestMapping("/api/yscimcactivitytrafficstatistics")
public class YscimcActivityTrafficStatisticsResource {
    private final YscimcActivityTrafficStatisticsService service;

    public YscimcActivityTrafficStatisticsResource(YscimcActivityTrafficStatisticsService service) {
        this.service = service;
    }
    @GetMapping("/flowstatistics")
    public ResultDto<List<YscimcActivityTrafficStatisticsVo>> flowStatistics(String activityId, String dateString){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=format.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("日期数据异常");
        }

        List<YscimcActivityTrafficStatisticsVo> yscimcActivityTrafficStatisticsVos = service.flowStatistics(activityId, date);
        return new ResultDto<>(yscimcActivityTrafficStatisticsVos);
    }
}
