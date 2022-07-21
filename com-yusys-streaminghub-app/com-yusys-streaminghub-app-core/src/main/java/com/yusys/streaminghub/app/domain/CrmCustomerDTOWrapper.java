package com.yusys.streaminghub.app.domain;

import cn.com.yusys.yscrm.cust.group.domain.CrmCustomerDTO;
import com.yusys.streaminghub.app.annotation.ArgIndex;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "客户查询参数")
public class CrmCustomerDTOWrapper {
    @ApiModelProperty(value = "客户参数", required = true)
    @ArgIndex(argIndex = 0)
    CrmCustomerDTO crmCustomerDTO;

    public CrmCustomerDTO getCrmCustomerDTO() {
        return crmCustomerDTO;
    }

    public void setCrmCustomerDTO(CrmCustomerDTO crmCustomerDTO) {
        this.crmCustomerDTO = crmCustomerDTO;
    }
}
