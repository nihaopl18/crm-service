package cn.com.yusys.yusp.dycrm.userAcct.domain;

import java.util.List;
import java.util.Map;
/**
 * @author: lufl
 * @time: 2021-10-25 13:53:10
 */
public class TeamUserInfo {
    /**
     * 用户Id
     */
    private String userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 机构编号
     */
    private String orgId;

    /**
     * 办公电话
     */
    private String userOfficetel;

    /**
     * 移动电话
     */
    private String userMobilephone;

    /**
     * 角色列表
     */
    private List<Map<String,Object>> roles;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 用户头像
     */
    private String userAvatar;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getUserOfficetel() {
        return userOfficetel;
    }

    public void setUserOfficetel(String userOfficetel) {
        this.userOfficetel = userOfficetel;
    }

    public String getUserMobilephone() {
        return userMobilephone;
    }

    public void setUserMobilephone(String userMobilephone) {
        this.userMobilephone = userMobilephone;
    }

    public List<Map<String, Object>> getRoles() {
        return roles;
    }

    public void setRoles(List<Map<String, Object>> roles) {
        this.roles = roles;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }
}
