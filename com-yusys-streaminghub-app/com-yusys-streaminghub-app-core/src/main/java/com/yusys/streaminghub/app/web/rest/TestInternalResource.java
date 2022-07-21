package com.yusys.streaminghub.app.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Api(value = "测试接口组")
public class TestInternalResource {


    @PostMapping("/1")
    @ApiOperation("test方法")
    public Map<String,Object> test(
            @ApiParam(name = "v1", value = "值", required = true, example = "v1=10")
            @RequestParam(name = "v1", required = true
            ) int v,
            @RequestHeader(required = true)String h,
            @RequestBody List<String> b
    ) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        map.put("v", v + "");
        map.put("h",h);
        map.put("b",b);
//        return String.format("这是内部api的返回值：v=%s h=%s b=%s",v,h,new ObjectMapper().writeValueAsString(b));
        return map;
    }
    @PostMapping("/2")
    @ApiOperation("test方法")
    public String test(
            @ApiParam(name = "v1", value = "值", required = true, example = "v1=10")
            @RequestParam(name = "v1", required = true
            ) long v,
            @RequestHeader(required = true)String h,
            @RequestBody List<String> b
    ) {
        return ""+b+"--- ";
    }
}
