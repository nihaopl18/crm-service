package com.yusys.streaminghub.app.argtable;

import com.yusys.streaminghub.app.annotation.ArgIndex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(description = "测试参数表。用于严格对应流中心应用的相应参数")
public class TestArgTable {
    @ApiModelProperty(value = "v1值", name = "v1", required = true)
    @ArgIndex(argIndex = 0)
    int v;
    @ApiModelProperty(value = "h值", required = true)
    @ArgIndex(argIndex = 1)
    String h;
    @ApiModelProperty(value = "列表", required = true)
    @ArgIndex(argIndex = 2)
    List<String> b;

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

    public List<String> getB() {
        return b;
    }

    public void setB(List<String> b) {
        this.b = b;
    }
}
