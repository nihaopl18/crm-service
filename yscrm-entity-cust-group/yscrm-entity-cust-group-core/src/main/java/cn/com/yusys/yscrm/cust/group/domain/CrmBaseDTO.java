package cn.com.yusys.yscrm.cust.group.domain;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Map;

public class CrmBaseDTO implements Serializable {

    private static final long serialVersionUID = 1613148922215118848L;
    private int page;
    private int size = 10;
    private String sort;
    /**
     * 是否关注
     */
    @ApiModelProperty(value = "是否关注")
    private String isFocus;
    /**
     * 客户群名称
     */
    @ApiModelProperty(value = "客户群名称")
    private String custGroupName;
    /*
       机构等级 500总行
     */
    @ApiModelProperty(value = "机构等级")
    private String orgIdAuth;

    /** 权限
     **/
    @ApiModelProperty(value = "权限")
    private String dataAuth;
    /** 登录人编码
     **/
    @ApiModelProperty(value = "登录人编码")
    private String _userCode;

    /** 登录人机构
     **/
    @ApiModelProperty(value = "登录人机构")
    private String _orgCode;

    /** 登录人名称
     **/
    @ApiModelProperty(value = "登录人名称")
    private String createUser;

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

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

    public String getIsFocus() {
        return isFocus;
    }

    public void setIsFocus(String isFocus) {
        this.isFocus = isFocus;
    }

    public String getCustGroupName() {
        return custGroupName;
    }

    public void setCustGroupName(String custGroupName) {
        this.custGroupName = custGroupName;
    }

    public String getOrgIdAuth() {
        return orgIdAuth;
    }

    public void setOrgIdAuth(String orgIdAuth) {
        this.orgIdAuth = orgIdAuth;
    }


    public String getDataAuth() {
        return dataAuth;
    }

    public String get_userCode() {
        return _userCode;
    }

    public void set_userCode(String _userCode) {
        this._userCode = _userCode;
    }

    public String get_orgCode() {
        return _orgCode;
    }

    public void set_orgCode(String _orgCode) {
        this._orgCode = _orgCode;
    }

    public void setDataAuth(String dataAuth) {
        this.dataAuth = dataAuth;
    }
}
