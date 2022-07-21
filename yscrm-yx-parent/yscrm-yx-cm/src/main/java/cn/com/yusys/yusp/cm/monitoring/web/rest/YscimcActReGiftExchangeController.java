package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReGiftExchangeVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActReGiftExchangeService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 活动效果礼品兑换表
 *
 * @author houyx3
 * @date 2022-04-15 16:49:33
 */
@Api("活动效果礼品兑换表接口")
@RestController
@RequestMapping("/api/yscimcactregiftexchange")
public class YscimcActReGiftExchangeController {

    @Autowired
    private YscimcActReGiftExchangeService yscimcActReGiftExchangeService;

    @GetMapping("/getLastData")
    public ResultDto<List<YscimcActReGiftExchangeVo>> getLastData(String actId) {

        // 校验入参是否为空
        if (StringUtils.isBlank(actId)) {
            throw new RuntimeException("活动ID不能为空");
        }
        return new ResultDto<>(yscimcActReGiftExchangeService.getLastData(actId));
    }
}
