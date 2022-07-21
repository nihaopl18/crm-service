package cn.com.yusys.yusp.cm.indexplan.domain;

import java.util.List;

public class IndexPlanSaveForm {

    private String nodeId;
    private String orgId;
    private String activityId;
    private String activityName;
    private List<IndexDataFormList> indexDataFormList;

    private List<ObjectDataForm> objectDataFormList;

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }
    public String getNodeId() {
        return nodeId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public void setIndexDataFormList(List<IndexDataFormList> indexDataFormList) {
        this.indexDataFormList = indexDataFormList;
    }
    public List<IndexDataFormList> getIndexDataFormList() {
        return indexDataFormList;
    }

    public List<ObjectDataForm> getObjectDataFormList() {
        return objectDataFormList;
    }

    public void setObjectDataFormList(List<ObjectDataForm> objectDataFormList) {
        this.objectDataFormList = objectDataFormList;
    }
}
