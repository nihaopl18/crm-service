package cn.com.yusys.yusp.cm.monitoring.web.rest;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReExtensionVo;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActReExtensionService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 活动效果推广信息表
 *
 * @author houyx3
 * @date 2022-04-15 16:49:33
 */
@Api("活动效果推广信息表接口")
@RestController
@RequestMapping("/api/yscimcactreextension")
public class YscimcActReExtensionController {

    @Autowired
    private YscimcActReExtensionService yscimcActReExtensionService;

    /**
     * 查询活动效果推广信息表
     *
     * @param actId
     * @return
     */
    @GetMapping("/getLastData")
    public ResultDto<List<YscimcActReExtensionVo>> getLastData(String actId) {

        // 校验入参是否为空
        if (StringUtils.isBlank(actId)) {
            throw new RuntimeException("活动ID不能为空");
        }
        return new ResultDto<>(yscimcActReExtensionService.getLastData(actId));
    }
}
