package cn.com.yusys.yscrm.cust.group.domain;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CrmBasedata implements Serializable {

    /**
     * 是否关注
     */
    private String startDate;
    /**
     * 客户群名称
     */
    private String endDate;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
