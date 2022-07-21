package com.yusys.streaminghub.app.web.rest;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import com.yusys.streaminghub.app.annotation.ArgTable;
import com.yusys.streaminghub.app.annotation.ResponseResult;
import com.yusys.streaminghub.app.annotation.SyncMethod;
import com.yusys.streaminghub.app.domain.QueryModelWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/external/api/custmgrquery")
@Api(value = "客群管理")
public class CustMgrQueryExternal {
    @PostMapping(value = "/querylist")
    @ApiOperation("客户经理列表查询")
    @ResponseResult
    @SyncMethod
    public ResultDto<List<Map<String, Object>>> queryList(
            @RequestParam(required = true) @ApiParam(value = "应用标识") String appId,
            @RequestParam(required = true) @ApiParam(value = "随机码") String nonce,
            @RequestParam(required = true) @ApiParam(value = "签名，必须以超级应用私钥生成该签名。规则：MD5(appid+appsecrect+nonce)") String sign,
            @RequestParam(required = true) @ApiParam(value = "查询模块标识") String module,
            @RequestParam(required = true) @ApiParam(value = "操作者用户账号") String user,
            @RequestParam(required = true) @ApiParam(value = "操作者密码") String password,
            @RequestParam(required = false) @ApiParam(value = "是否使用缓冲取数") String cached,
            @RequestBody(required = true) @ApiParam(value = "客户查询参数") @ArgTable() QueryModelWrapper queryModelWrapper
    ) {

        return null;
    }
}
