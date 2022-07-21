package cn.com.yusys.yusp.cm.market.vo;

import javax.persistence.Column;

public class AdminSmUserVo {
    private static final long serialVersionUID = 1L;

    @Column(name="USER_ID")
    private String userId;

    @Column(name="LOGIN_CODE")
    private String loginCode;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="ORG_ID")
    private String orgId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
