package cn.com.yusys.yscrm.sysview.domain;


/**
 * @author: sxm
 * @time: 2021/9/3 11:46
 */
public class TagAnalysisQuery {
    private String tagNos;
    private String groupNos;
    private String startTime;
    private String endTime;
    private String selectRole;
    private String dataAuth;
    private int page=1;
    private int size = 10;

    public String getTagNos() {
        return tagNos;
    }

    public void setTagNos(String tagNos) {
        this.tagNos = tagNos;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getGroupNos() {
        return groupNos;
    }

    public void setGroupNos(String groupNos) {
        this.groupNos = groupNos;
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

    public String getSelectRole() { return selectRole; }

    public void setSelectRole(String selectRole) {
        this.selectRole = selectRole;
    }

    public String getDataAuth() {
        return dataAuth;
    }

    public void setDataAuth(String dataAuth) {
        this.dataAuth = dataAuth;
    }
}
