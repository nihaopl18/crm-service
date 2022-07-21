package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityChannelFlowVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityChannelFlowService;
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
 * @date 2022/4/11 - 16:07
 */
@RestController
@RequestMapping("/api/yscimcactivitychannelflow")
public class YscimcActivityChannelFlowResource {
    private final YscimcActivityChannelFlowService service;

    public YscimcActivityChannelFlowResource(YscimcActivityChannelFlowService service) {
        this.service = service;
    }
    @GetMapping("/getchannel")
    public ResultDto<List<YscimcActivityChannelFlowVo>> getchannel(String activityId,String dateString){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=format.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("日期数据异常");
        }
        List<YscimcActivityChannelFlowVo> yscimcActivityChannelFlowVo=service.getchannel(activityId,date);
        return new ResultDto<>(yscimcActivityChannelFlowVo);
    }
}
