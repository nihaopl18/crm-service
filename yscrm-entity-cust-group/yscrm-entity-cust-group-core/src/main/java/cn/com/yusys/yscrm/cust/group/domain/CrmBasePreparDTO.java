package cn.com.yusys.yscrm.cust.group.domain;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class CrmBasePreparDTO implements Serializable {

    private static final long serialVersionUID = 1613148922215118848L;
    private int page;
    private int size = 10;
    private String sort;
    /**
     * 客户群编号
     */
    @ApiModelProperty(value = "客户群编号")
    private String custGroupId;
    /**
     * 是否关注
     */
    @ApiModelProperty(value = "是否关注")
    private String isFocus;
    /*
       机构等级 500总行
     */
    @ApiModelProperty(value = "机构等级")
    private String orgIdAuth;
    /**
     * 客户号
     */
    @ApiModelProperty(value = "客户号")
    private String custId;

    /**
     * 查询条件
     */
    @ApiModelProperty(value = "查询条件")
    private String queryCriteria;
    /**
     * 用戶類型
     */
    @ApiModelProperty(value = "用戶類型")
    private String mgrType;
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCustGroupId() {
        return custGroupId;
    }

    public void setCustGroupId(String custGroupId) {
        this.custGroupId = custGroupId;
    }

    public String getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(String isFocus) {
        this.isFocus = isFocus;
    }

    public String getOrgIdAuth() {
        return orgIdAuth;
    }

    public void setOrgIdAuth(String orgIdAuth) {
        this.orgIdAuth = orgIdAuth;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getQueryCriteria() {
        return queryCriteria;
    }

    public void setQueryCriteria(String queryCriteria) {
        this.queryCriteria = queryCriteria;
    }

    public String getMgrType() {
        return mgrType;
    }

    public void setMgrType(String mgrType) {
        this.mgrType = mgrType;
    }
}
