package com.yusys.streaminghub.app.domain;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import com.yusys.streaminghub.app.annotation.ArgIndex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "查询模型")
public class QueryModelWrapper {
    @ApiModelProperty(value = "查询模型", required = true)
    @ArgIndex(argIndex = 0)
    QueryModel queryModel;

    public QueryModel getQueryModel() {
        return queryModel;
    }

    public void setQueryModel(QueryModel queryModel) {
        this.queryModel = queryModel;
    }
}
