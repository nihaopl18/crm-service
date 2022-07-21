package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityCustomerFlowVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityCustomerFlowService;
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
 * @date 2022/4/11 - 10:42
 */
@RestController
@RequestMapping("/api/yscimcactivitycustomerflow")
public class YscimcActivityCustomerFlowResource {
    private final YscimcActivityCustomerFlowService service;

    public YscimcActivityCustomerFlowResource(YscimcActivityCustomerFlowService service) {
        this.service = service;
    }
    @GetMapping("/getcustomer")
    public ResultDto<List<YscimcActivityCustomerFlowVo>> getcustomer(String activityId,String dateString){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date=null;
        try {
            date=format.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException("日期数据异常");
        }
        List<YscimcActivityCustomerFlowVo> yscimcActivityCustomerFlowVo=service.getcustomer(activityId,date);
        return new ResultDto<>(yscimcActivityCustomerFlowVo);
    }
}
