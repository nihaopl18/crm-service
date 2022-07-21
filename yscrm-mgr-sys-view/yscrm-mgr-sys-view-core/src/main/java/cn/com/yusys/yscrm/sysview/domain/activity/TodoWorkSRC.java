package cn.com.yusys.yscrm.sysview.domain.activity;

public class TodoWorkSRC {

    /**
     * 数量
     */
    private Integer count;
    /**
     * 类型
     */
    private String todoWorkType;
    /**
     * 执行人id
     */
    private String creatorId;
    /**
     * 执行人名称
     */
    private String creatorName;
    /**
     * 执行人
     */
    private String finisher;
    /**
     * 状态
     */
    private String todoWorkState;
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
     * 上级机构id
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

    public String getTodoWorkType() {
        return todoWorkType;
    }

    public void setTodoWorkType(String todoWorkType) {
        this.todoWorkType = todoWorkType;
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

    public String getFinisher() {
        return finisher;
    }

    public void setFinisher(String finisher) {
        this.finisher = finisher;
    }

    public String getTodoWorkState() {
        return todoWorkState;
    }

    public void setTodoWorkState(String todoWorkState) {
        this.todoWorkState = todoWorkState;
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
