package cn.com.yusys.yscrm.cust.group.domain;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CrmBaseCuDTO implements Serializable {

    private static final long serialVersionUID = 1613148922215118848L;
    /**
     * 客户群编号
     */
    @ApiModelProperty(value = "客户群编号")
    private String custGroupId;
    /**
     * 客户群名称
     */
    @ApiModelProperty(value = "客户群名称")
    private String custGroupName;

    /**
     * 客户号集
     */
    @ApiModelProperty(value = "客户号集")
    private String custId;
    /**
     * 主办机构
     */
    @ApiModelProperty(value = "主办机构")
    private String belongBrch;
    /**
     * 客户经理编号
     */
    @ApiModelProperty(value = "客户经理编号")
    private String samId;
    public String getCustGroupId() {
        return custGroupId;
    }

    public void setCustGroupId(String custGroupId) {
        this.custGroupId = custGroupId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustGroupName() {
        return custGroupName;
    }

    public void setCustGroupName(String custGroupName) {
        this.custGroupName = custGroupName;
    }

    public String getBelongBrch() {
        return belongBrch;
    }

    public void setBelongBrch(String belongBrch) {
        this.belongBrch = belongBrch;
    }

    public String getSamId() {
        return samId;
    }

    public void setSamId(String samId) {
        this.samId = samId;
    }
}
