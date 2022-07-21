package cn.com.yusys.yscimc.operation.controller;

import cn.com.yusys.yscimc.operation.domain.ActivityCustomerResultEntity;
import cn.com.yusys.yscimc.operation.domain.dto.ActivityResultDto;
import cn.com.yusys.yscimc.operation.domain.form.ActivityResultForm;
import cn.com.yusys.yscimc.operation.service.ActivityCustomerResultService;
import cn.com.yusys.yscimc.operation.service.MarketPlanActionService;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 运营活动执行等动作接口
 * @author zhangyt12
 * @date 2021/12/7 15:52
 */
@RestController
@RequestMapping("/api/marketplanaction")
public class MarketPlanActionResource {
    private final MarketPlanActionService marketPlanActionService;

    private final ActivityCustomerResultService resultService;

    public MarketPlanActionResource(MarketPlanActionService marketPlanActionService, ActivityCustomerResultService resultService) {
        this.marketPlanActionService = marketPlanActionService;
        this.resultService = resultService;
    }

    @PostMapping("/start")
    public ResultDto<?> startPlan(@RequestBody String tempId) {
        String result = marketPlanActionService.startPlanByTempId(tempId);
        return new ResultDto(result);
    }

    @PostMapping("/result")
    public ResultDto<?> getActivityResult(@RequestBody ActivityResultForm resultForm) {
        ActivityResultDto dto = resultService.getActivityResult(resultForm);
        return new ResultDto(dto);
    }

    @PostMapping("/result/customer")
    public ResultDto<?> getCustomerResult(@RequestBody ActivityResultForm resultForm) {
        List<ActivityCustomerResultEntity> resultByTempId = resultService.getResultByTempId(resultForm);
        return new ResultDto(resultByTempId);
    }
}
