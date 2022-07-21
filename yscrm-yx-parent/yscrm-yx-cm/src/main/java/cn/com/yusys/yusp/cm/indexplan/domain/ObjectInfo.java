package cn.com.yusys.yusp.cm.indexplan.domain;

public class ObjectInfo {
    private String objName;
    private String objType;
    private String tempId;
    private String orgId;
    private String choiceOrgId;
    private int page;
    private int size;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getChoiceOrgId() {
        return choiceOrgId;
    }

    public void setChoiceOrgId(String choiceOrgId) {
        this.choiceOrgId = choiceOrgId;
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
}
