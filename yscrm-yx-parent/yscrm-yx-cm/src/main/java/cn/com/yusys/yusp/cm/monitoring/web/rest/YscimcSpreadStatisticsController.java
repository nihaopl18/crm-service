package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcSpreadStatisticsVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcSpreadStatisticsService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 传播统计表
 *
 * @author houyx3
 * @date 2022-04-16 14:15:48
 */
@Api("传播统计表接口")
@RestController
@RequestMapping("/api/yscimcspreadstatistics")
public class YscimcSpreadStatisticsController {
    @Autowired
    private YscimcSpreadStatisticsService yscimcSpreadStatisticsService;

    @GetMapping("/getListTopten")
    public ResultDto<List<YscimcSpreadStatisticsVo>> getListTopten(String activityId) {
        List<YscimcSpreadStatisticsVo> list = yscimcSpreadStatisticsService.getListTopten(activityId);
        return new ResultDto<>(list);
    }


}
