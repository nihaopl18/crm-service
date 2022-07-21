package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTrafficSourceVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityTrafficSourceService;
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
 * @date 2022/4/8 - 16:58
 */
@RestController
@RequestMapping("/api/yscimcactivitytrafficsource")
public class YscimcActivityTrafficSourceResource {
    private final YscimcActivityTrafficSourceService service;

    public YscimcActivityTrafficSourceResource(YscimcActivityTrafficSourceService service) {
        this.service = service;
    }
    @GetMapping("/getflowsource")
    public ResultDto<List<YscimcActivityTrafficSourceVo>> getflowsource(String activityId,String dateString){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=format.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("日期数据异常");
        }
        List<YscimcActivityTrafficSourceVo> yscimcActivityTrafficSourceVos = service.getflowsource(activityId,date);
        return new ResultDto<>(yscimcActivityTrafficSourceVos);

    }
}
