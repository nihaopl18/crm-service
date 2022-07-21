package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReActiveVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActReActiveService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

/**
 * 营销监控
 *
 * @author zhanghan3 20181116
 */
@RestController
@RequestMapping("/api/yscimcactreactive")
public class YscimcActReActiveResource {

    @Autowired
    private YscimcActReActiveService service;

    @GetMapping("/getUserActive")
    public ResultDto<List<String>> getUserActive(String actId,String toDay,String timeArr) {

        List<String> list = new LinkedList();
        LocalDate date = LocalDate.parse(toDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        list.add(0,service.getUserActive(actId, date, timeArr));

        list.add(1,service.getUserActive(actId, date.plusDays(-1), timeArr));

        return new ResultDto<>(list);
    }

    @GetMapping("/getLastDataByDate")
    public ResultDto<YscimcActReActiveVo> getLastDataByDate(String actId, String currentDate){

       return new ResultDto<>(service.getLastDataByDate(actId,currentDate));
    }

    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.parse("2022-04-11", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        System.out.println(date);
    }

}
