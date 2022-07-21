package cn.com.yusys.yscrm.sysview.domain.activity;

import java.util.Objects;

/**
 * @author: sxm
 * @time: 2021/10/8 11:14
 */
public class ActivityKey {
    private String upOrgId;
    private String upOrgName;
    private String orgId;
    private String orgName;
    private String creatorName;

    public String getUpOrgId() {
        return upOrgId;
    }

    public void setUpOrgId(String upOrgId) {
        this.upOrgId = upOrgId;
    }

    public String getUpOrgName() {
        return upOrgName;
    }

    public void setUpOrgName(String upOrgName) {
        this.upOrgName = upOrgName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        ActivityKey that = (ActivityKey) o;
        return Objects.equals(upOrgId, that.upOrgId) &&
                Objects.equals(upOrgName, that.upOrgName) &&
                Objects.equals(orgId, that.orgId) &&
                Objects.equals(orgName, that.orgName) &&
                Objects.equals(creatorName, that.creatorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(upOrgId, upOrgName, orgId, orgName, creatorName);
    }
}
