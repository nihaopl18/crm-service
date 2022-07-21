package com.yusys.streaminghub.app.web.rest;

import com.yusys.streaminghub.app.annotation.ArgTable;
import com.yusys.streaminghub.app.annotation.ResponseResult;
import com.yusys.streaminghub.app.annotation.SyncMethod;
import com.yusys.streaminghub.app.argtable.TestArgTable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/external/test")
@Api(value = "外部同步接口")
public class TestResourceExternal {
    @PostMapping(value = "/1")
    @ApiOperation("test方法")
    @ResponseResult
    @SyncMethod
    public Map<String,Object> test(
            @RequestParam(required = true) @ApiParam(value = "应用标识") String appId,
            @RequestParam(required = true) @ApiParam(value = "随机码") String nonce,
            @RequestParam(required = true) @ApiParam(value = "签名，必须以超级应用私钥生成该签名。规则：MD5(appid+appsecrect+nonce)") String sign,
            @RequestParam(required = true) @ApiParam(value = "查询模块标识") String module,
            @RequestParam(required = true) @ApiParam(value = "操作者用户账号") String user,
            @RequestParam(required = true) @ApiParam(value = "密码") String password,
            @RequestParam(required = false) @ApiParam(value = "是否使用缓冲取数") String cached,
            @RequestBody(required = true) @ApiParam(value = "对应流应用实参") @ArgTable TestArgTable argTable
    ) {

        return null;
    }
}
