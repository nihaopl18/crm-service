package cn.com.yusys.yscrm.sysview.domain.activity;

public class TouchSRC {

    /**
     * 次数
     */
    private Integer time;
    /**
     * 接触客户
     */
    private String contactCustId;
    /**
     * 接触方式
     */
    private String contactType;
    /**
     * 创建人Id
     */
    private String creatorId;
    /**
     * 创建人名称
     */
    private String creatorName;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 机构id
     */
    private String orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     * 机构层级
     */
    private String orgLevel;
    /**
     * 上级机构Id
     */
    private String upOrgId;
    /**
     * 上级机构名称
     */
    private String upOrgName;
    /**
     * 上级机构层级
     */
    private String uporgLevel;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getContactCustId() {
        return contactCustId;
    }

    public void setContactCustId(String contactCustId) {
        this.contactCustId = contactCustId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(String orgLevel) {
        this.orgLevel = orgLevel;
    }

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

    public String getUporgLevel() {
        return uporgLevel;
    }

    public void setUporgLevel(String uporgLevel) {
        this.uporgLevel = uporgLevel;
    }
}
