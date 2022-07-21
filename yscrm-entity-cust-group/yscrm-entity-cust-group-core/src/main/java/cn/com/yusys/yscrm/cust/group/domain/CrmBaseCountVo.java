package cn.com.yusys.yscrm.cust.group.domain;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CrmBaseCountVo implements Serializable {

    /**
     * 客户群编号
     */
    @ApiModelProperty(value = "客户群编号")
    private String custGroupId;
    @ApiModelProperty(value = "条数")
    private int count;

    public String getCustGroupId() {
        return custGroupId;
    }

    public void setCustGroupId(String custGroupId) {
        this.custGroupId = custGroupId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
