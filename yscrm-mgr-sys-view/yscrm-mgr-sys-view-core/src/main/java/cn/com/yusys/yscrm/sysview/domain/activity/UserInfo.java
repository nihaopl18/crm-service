package cn.com.yusys.yscrm.sysview.domain.activity;

public class UserInfo {
    private String loginCode;

    private String userName;

    private String orgName;

    private String loginSts;

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

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getLoginSts() { return loginSts; }

    public void setLoginSts(String loginSts) { this.loginSts = loginSts; }
}
