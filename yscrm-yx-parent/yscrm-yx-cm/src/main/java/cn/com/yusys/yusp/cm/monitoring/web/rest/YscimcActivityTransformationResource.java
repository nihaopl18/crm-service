package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTransformationVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityTransformationService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/13 - 9:59
 */
@RestController
@RequestMapping("/api/yscimcactivitytransformation")
public class YscimcActivityTransformationResource {
    private final YscimcActivityTransformationService service;

    public YscimcActivityTransformationResource(YscimcActivityTransformationService service) {
        this.service = service;
    }
    @GetMapping("/getTransformation")
    public ResultDto<YscimcActivityTransformationVo> getTransformation(String activityId, String dateString){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        Date date=null;
        try {
            date=format.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("日期数据异常");
        }
        YscimcActivityTransformationVo yscimcActivityTransformationVo=service.getTransformation(activityId,date);
        return new ResultDto<>(yscimcActivityTransformationVo);
    }
}
