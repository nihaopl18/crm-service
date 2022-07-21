package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepPeriod;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFcomDepDistributeInfo;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFComDepPeriodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:Mr.raop
 * @create:2022-05-11
 */

@Api(tags = "存款业绩分配_存款账户[分配区间]表接口")
@RestController
@RequestMapping("/api/PmaFComDepPeriodResource")
public class PmaFComDepPeriodResource {

    @Autowired
    private PmaFComDepPeriodService pmaFComDepPeriodService;

    @ApiOperation(value = "查询存款分配区间表", notes = "查询存款分配区间表")
    @GetMapping("/queryPmaFComDepPeriodList")
    public ResultDto<List<Map<String, Object>>> queryPmaFComDepPeriodList(QueryModel model) {
        List<Map<String, Object>> list = this.pmaFComDepPeriodService.queryList(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    @ApiOperation(value = "保存存款业绩区间", notes = "保存存款业绩区间")
    @PostMapping("/savePmaPeriod")
    public ResultDto<PmaFComDepPeriod> savePmaPeriod(@RequestBody PmaFComDepPeriod pmaperiod) throws Exception{
        return pmaFComDepPeriodService.savePmaPeriod(pmaperiod);
    }

}
