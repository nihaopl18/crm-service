package cn.com.yusys.yusp.cm.market.form;

/**
 * @author sandMan
 * @date 2022/4/1 - 14:52
 */
public class ActivityReqForm {
    private String orgId;
    private String indexState;
    private int page;
    private int size;
    private String activityId;
    private String activityName;

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getIndexState() {
        return indexState;
    }

    public void setIndexState(String indexState) {
        this.indexState = indexState;
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

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
