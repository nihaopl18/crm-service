package cn.com.yusys.yscimc.operation.controller;

import cn.com.yusys.yscimc.operation.domain.vo.StatisticsVo;
import cn.com.yusys.yscimc.operation.service.ActivityStatisticsService;
import cn.com.yusys.yscimc.operation.service.InternetMarketingDataService;
import cn.com.yusys.yusp.cm.market.service.CimpCmMarketPlanService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/1/13 16:04
 */
@RestController
@RequestMapping("/api/activitystatistics")
public class ActivityStatisticsResource {

    @Autowired
    private ActivityStatisticsService service;

    @Autowired
    private CimpCmMarketPlanService marketPlanService;

    @Autowired
    private InternetMarketingDataService internetMarketingDataService;

    @PostMapping("/statistics")
    public ResultDto<Void> statistics(@RequestBody @Valid StatisticsVo vo) throws Exception {

        service.statistics(vo);
        return new ResultDto<>();
    }

    /**
     * 获取手机银行栏位地址
     * @param date
     * @return
     * @throws Exception
     */
    @GetMapping("/getHtmlWithMobile")
    public ResultDto<List<Map<String, Object>>> getHtmlWithMobile(String date)  {

        List<Map<String, Object>> list = internetMarketingDataService.getMobileBankingWindows(date);

        return new ResultDto<>(list);
    }

    /**
     * 获取手机银行栏位地址
     * @param actId
     * @return
     * @throws
     */
    @GetMapping("/saveActAddrForActId")
    public ResultDto<Integer> saveActAddrForActId(String actId) {
        return new ResultDto<>(service.saveActAddrForActId(actId));
    }
}
