package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReRoiVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActReRoiService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * 活动效果ROI
 * @author houyx3
 * @date 2022-04-8
 * @email houyx3@yusys.com.cn
 * @version 1.0
 * */
@Api("活动效果ROI接口")
@RestController
@RequestMapping("/api/yscimcactreroi")
public class YscimcActReRoiResource {
    @Autowired
    private YscimcActReRoiService yscimcActReRoiService;

    @GetMapping("/getRealTimeData")
    public ResultDto<YscimcActReRoiVo> getRealTimeData(String actId, String date){
        return new ResultDto<>(yscimcActReRoiService.getRealTimeData(actId, date));
    }


}
