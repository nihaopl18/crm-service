package cn.com.yusys.yscrm.cust.group.domain;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CrmIndexStatusDTO implements Serializable {

    private static final long serialVersionUID = 1613148922215118848L;

    /**
     * 客户群编号
     */
    @ApiModelProperty(value = "客户群编号")
    private String custGroupId;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间")
    private String StartDate;
    /**
     * 截止时间
     */
    @ApiModelProperty(value = "截止时间")
    private String endDate;
    /**
     * 类型（01客均 02 客群）
     */
    @ApiModelProperty(value = "类型（01客均 02 客群）")
    private String customerType;

    public String getCustGroupId() {
        return custGroupId;
    }

    public void setCustGroupId(String custGroupId) {
        this.custGroupId = custGroupId;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
}
