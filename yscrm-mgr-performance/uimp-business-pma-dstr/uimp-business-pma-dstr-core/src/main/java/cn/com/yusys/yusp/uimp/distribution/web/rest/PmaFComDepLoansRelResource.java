package cn.com.yusys.yusp.uimp.distribution.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFComDepLoansPeriodService;
import cn.com.yusys.yusp.uimp.distribution.service.PmaFComDepLoansRelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author:Mr.raop
 * @create:2022-05-16
 */

@Api(tags = "查询贷款分配明细表接口")
@RestController
@RequestMapping("/api/PmaFComDepLoansRelResource")
public class PmaFComDepLoansRelResource {

    @Autowired
    private PmaFComDepLoansRelService pmaFComDepLoansRelService;

    @ApiOperation(value = "查询贷款分配明细表", notes = "查询贷款分配明细表")
    @GetMapping("/queryList")
    public ResultDto<List<Map<String, Object>>> queryPmaFComDepLoansRelList(QueryModel model) {
        List<Map<String, Object>> list = this.pmaFComDepLoansRelService.queryList(model);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

}