package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFComDepAcctInfo;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFcomDepDistributeInfo;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFcomDepDistributeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author:Mr.raop
 * @create:2022-05-10
 */
@Api(tags = "存款业绩分配_分配明细记录表[分配比例]接口")
@RestController
@RequestMapping("/api/PmaFcomDepDistributeResource")
public class PmaFcomDepDistributeResource {

    @Autowired
    private PmaFcomDepDistributeService pmaFcomDepDistributeService;

    @ApiOperation(value = "查询该时间区间的分配明细记录", notes = "查询该时间区间的分配明细记录")
    @GetMapping("/queryPmaFcomDepDistributeList")
    public ResultDto<List<Map<String, Object>>> queryPmaFcomDepDistributeList(QueryModel model) {
        List<Map<String, Object>> list = this.pmaFcomDepDistributeService.queryList(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    @ApiOperation(value = "保存存款业绩分配比例", notes = "保存存款业绩分配比例")
    @PostMapping("/savePmaDistribute")
    public ResultDto<PmaFcomDepDistributeInfo> savePmaDistribute(@RequestBody PmaFcomDepDistributeInfo distributeInfo) throws Exception{
        return pmaFcomDepDistributeService.savePmaDistribute(distributeInfo);
    }



}
