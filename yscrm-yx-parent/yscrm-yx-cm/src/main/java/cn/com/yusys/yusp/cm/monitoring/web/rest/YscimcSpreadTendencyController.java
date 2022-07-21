package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.service.YscimcSpreadTendencyService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 传播趋势表
 *
 * @author houyx3
 * @date 2022-04-16 14:15:48
 */
@Api("传播趋势表接口")
@RestController
@RequestMapping("/api/yscimcspreadtendency")
public class YscimcSpreadTendencyController {
    @Autowired
    private YscimcSpreadTendencyService yscimcSpreadTendencyService;

    /**
     * 获取活动最近几月的传播统计
     * @param actId 活动id
     * @param month 最近几月
     * @return
     */
    @GetMapping("/getLastDataForMonth")
    public ResultDto<Map<String, Object>> getLastDataForMonth(String actId, int month) {
        // 如果不指定最近几月，默认为最近6个月
        if (month== 0) {
            month = 6;
        }
        return new ResultDto<>(yscimcSpreadTendencyService.getLastDataForMonth(actId, month));
    }
}
