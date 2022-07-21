package cn.com.yusys.yscrm.sysview.domain.activity;

public class WorkReportSRC {

    /**
     * 数量
     */
    private Integer count;
    /**
     * 报告类型
     */
    private String workReportBusiType;
    /**
     * 报告所属人Id
     */
    private String creatorId;
    /**
     * 报告所属人名称
     */
    private String creatorName;
    /**
     * 报告所属人
     */
    private String creator;
    /**
     * 工作日报-工作内容
     */
    private String workSummary;
    /**
     * 机构Id
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
    private String upOrgLevel;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getWorkReportBusiType() {
        return workReportBusiType;
    }

    public void setWorkReportBusiType(String workReportBusiType) {
        this.workReportBusiType = workReportBusiType;
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

    public void setCreaorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getWorkSummary() {
        return workSummary;
    }

    public void setWorkSummary(String workSummary) {
        this.workSummary = workSummary;
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

    public String getUpOrgLevel() {
        return upOrgLevel;
    }

    public void setUpOrgLevel(String upOrgLevel) {
        this.upOrgLevel = upOrgLevel;
    }
}
